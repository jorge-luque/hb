package com.vungle.warren.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.content.C0769b;
import com.vungle.warren.NetworkProviderReceiver;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class NetworkProvider {
    private static NetworkProvider INSTANCE = null;
    static final long NETWORK_CHECK_DELAY = 30000;
    private static final String TAG = "NetworkProvider";
    public static final int TYPE_NONE = -1;

    /* renamed from: cm */
    private final ConnectivityManager f14486cm;
    private final Context ctx;
    private AtomicInteger currentNetwork = new AtomicInteger();
    private boolean enabled;
    /* access modifiers changed from: private */
    public Handler handler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public Set<NetworkListener> listeners = new CopyOnWriteArraySet();
    private ConnectivityManager.NetworkCallback networkCallback;
    /* access modifiers changed from: private */
    public Runnable typeRunnable = new Runnable() {
        public void run() {
            if (!NetworkProvider.this.listeners.isEmpty()) {
                NetworkProvider.this.onNetworkChanged();
                NetworkProvider.this.handler.postDelayed(NetworkProvider.this.typeRunnable, NetworkProvider.NETWORK_CHECK_DELAY);
            }
        }
    };

    public interface NetworkListener {
        void onChanged(int i);
    }

    private NetworkProvider(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.ctx = applicationContext;
        this.f14486cm = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        this.currentNetwork.set(getCurrentNetworkType());
        if (Build.VERSION.SDK_INT < 21) {
            this.enabled = NetworkProviderReceiver.isEnabledBroadcastReceiver(context);
        } else {
            NetworkProviderReceiver.enableBroadcastReceiver(context, false);
        }
    }

    public static synchronized NetworkProvider getInstance(Context context) {
        NetworkProvider networkProvider;
        synchronized (NetworkProvider.class) {
            if (INSTANCE == null) {
                INSTANCE = new NetworkProvider(context);
            }
            networkProvider = INSTANCE;
        }
        return networkProvider;
    }

    private ConnectivityManager.NetworkCallback getNetworkCallback() {
        ConnectivityManager.NetworkCallback networkCallback2 = this.networkCallback;
        if (networkCallback2 != null) {
            return networkCallback2;
        }
        C55411 r0 = new ConnectivityManager.NetworkCallback() {
            public void onAvailable(Network network) {
                super.onAvailable(network);
                NetworkProvider.this.onNetworkChanged();
            }

            public void onLost(Network network) {
                super.onLost(network);
                NetworkProvider.this.onNetworkChanged();
            }
        };
        this.networkCallback = r0;
        return r0;
    }

    private void postToListeners(final int i) {
        this.handler.post(new Runnable() {
            public void run() {
                for (NetworkListener onChanged : NetworkProvider.this.listeners) {
                    onChanged.onChanged(i);
                }
            }
        });
    }

    private synchronized void setEnableNetworkListener(boolean z) {
        if (this.enabled != z) {
            this.enabled = z;
            if (Build.VERSION.SDK_INT < 21) {
                if (NetworkProviderReceiver.hasReceiver(this.ctx)) {
                    NetworkProviderReceiver.enableBroadcastReceiver(this.ctx, z);
                } else if (z) {
                    this.handler.postDelayed(this.typeRunnable, NETWORK_CHECK_DELAY);
                } else {
                    this.handler.removeCallbacks(this.typeRunnable);
                }
            } else if (this.f14486cm != null) {
                if (z) {
                    try {
                        NetworkRequest.Builder builder = new NetworkRequest.Builder();
                        builder.addCapability(12);
                        this.f14486cm.registerNetworkCallback(builder.build(), getNetworkCallback());
                    } catch (Exception e) {
                        Log.e(TAG, e.getMessage());
                    }
                } else {
                    this.f14486cm.unregisterNetworkCallback(getNetworkCallback());
                }
            }
        } else {
            return;
        }
        return;
    }

    public void addListener(NetworkListener networkListener) {
        this.listeners.add(networkListener);
        setEnableNetworkListener(true);
    }

    public int getCurrentNetworkType() {
        int i = -1;
        if (this.f14486cm == null || C0769b.m2414a(this.ctx, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            this.currentNetwork.set(-1);
            return -1;
        }
        NetworkInfo activeNetworkInfo = this.f14486cm.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
            i = activeNetworkInfo.getType();
        }
        int andSet = this.currentNetwork.getAndSet(i);
        if (i != andSet) {
            "on network changed: " + andSet + "->" + i;
            postToListeners(i);
        }
        setEnableNetworkListener(!this.listeners.isEmpty());
        return i;
    }

    public void onNetworkChanged() {
        getCurrentNetworkType();
    }

    public void removeListener(NetworkListener networkListener) {
        this.listeners.remove(networkListener);
        setEnableNetworkListener(!this.listeners.isEmpty());
    }
}
