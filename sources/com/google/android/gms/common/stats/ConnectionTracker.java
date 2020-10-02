package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.List;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
public class ConnectionTracker {
    private static final Object zzfn = new Object();
    private static volatile ConnectionTracker zzfo = null;
    @VisibleForTesting
    private static boolean zzfp = false;
    private final List<String> zzfq = Collections.emptyList();
    private final List<String> zzfr = Collections.emptyList();
    private final List<String> zzfs = Collections.emptyList();
    private final List<String> zzft = Collections.emptyList();

    private ConnectionTracker() {
    }

    @KeepForSdk
    public static ConnectionTracker getInstance() {
        if (zzfo == null) {
            synchronized (zzfn) {
                if (zzfo == null) {
                    zzfo = new ConnectionTracker();
                }
            }
        }
        return zzfo;
    }

    @KeepForSdk
    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    @KeepForSdk
    public void unbindService(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }

    @SuppressLint({"UntrackedBindService"})
    @KeepForSdk
    public void unbindServiceSafe(Context context, ServiceConnection serviceConnection) {
        try {
            unbindService(context, serviceConnection);
        } catch (IllegalArgumentException e) {
            Log.w("ConnectionTracker", "Exception thrown while unbinding", e);
        }
    }

    public final boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        boolean z;
        ComponentName component = intent.getComponent();
        if (component == null) {
            z = false;
        } else {
            z = ClientLibraryUtils.zzc(context, component.getPackageName());
        }
        if (!z) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }
}
