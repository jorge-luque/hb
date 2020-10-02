package admost.sdk.interfaces;

import admost.sdk.listener.AdMostAdListenerForNetworkAdapter;
import admost.sdk.listener.AdMostInitializationListener;
import android.app.Activity;
import com.applovin.sdk.AppLovinMediationProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AdMostAdNetworkInitInterface {
    public boolean hasBiddingInitializationError;
    public boolean hasInitializationError;
    public ArrayList<AdMostInitializationListener> initListeners = new ArrayList<>();
    public int initParameterCount;
    public boolean initRequired;
    public long initStartedAt;
    public boolean isInitAdNetworkCompletedSuccessfully;
    public boolean isInitFailed;
    public boolean isInitLightWeight = false;
    public boolean isInitialized;
    public int minSdkVersion;
    public final ConcurrentHashMap<String, AdMostAdListenerForNetworkAdapter> placementListeners = new ConcurrentHashMap<>();
    public Set<String> supportedAdTypes = new HashSet();

    public AdMostAdNetworkInitInterface(boolean z, int i, int i2) {
        this.initRequired = z;
        this.initParameterCount = i;
        this.minSdkVersion = i2;
    }

    public String getAdapterVersion() {
        return "";
    }

    public String getMinSdkVersion() {
        return "";
    }

    public String getVersion() {
        return "not implemented";
    }

    public final boolean ignoreInLifeCycle(Activity activity) {
        String lowerCase = activity.getClass().getName().toLowerCase();
        return lowerCase.contains("chartboost") || lowerCase.contains(AppLovinMediationProvider.MOPUB) || lowerCase.contains("android.gms.ads") || lowerCase.contains("com.google.ads") || lowerCase.contains("vungle") || lowerCase.contains("tapjoy") || lowerCase.contains(AppLovinMediationProvider.IRONSOURCE) || lowerCase.contains("admostdebugactivity");
    }

    public void initialize(Activity activity, String[] strArr) {
    }

    public boolean onBackPressed(Activity activity) {
        return true;
    }

    public void onDestroy(Activity activity) {
    }

    public void onPause(Activity activity) {
    }

    public void onResume(Activity activity) {
    }

    public void onStart(Activity activity) {
    }

    public void onStop(Activity activity) {
    }

    public void removeListenerForPlacement(String str) {
        synchronized (this.placementListeners) {
            this.placementListeners.remove(str);
        }
    }

    public void sendFailToInitListeners() {
        this.hasInitializationError = true;
        ArrayList<AdMostInitializationListener> arrayList = this.initListeners;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<AdMostInitializationListener> it = this.initListeners.iterator();
            while (it.hasNext()) {
                it.next().onError("");
            }
            this.initListeners.clear();
        }
    }

    public void sendSuccessToInitListeners() {
        this.hasInitializationError = false;
        ArrayList<AdMostInitializationListener> arrayList = this.initListeners;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<AdMostInitializationListener> it = this.initListeners.iterator();
            while (it.hasNext()) {
                it.next().onInitialized();
            }
            this.initListeners.clear();
        }
    }

    public final void setAsInitialized() {
        this.initStartedAt = System.currentTimeMillis();
        this.isInitialized = true;
    }

    public void setInitListener(AdMostInitializationListener adMostInitializationListener) {
        this.initListeners.add(adMostInitializationListener);
    }

    public void setListenerForPlacement(String str, AdMostAdListenerForNetworkAdapter adMostAdListenerForNetworkAdapter) {
        synchronized (this.placementListeners) {
            this.placementListeners.put(str, adMostAdListenerForNetworkAdapter);
        }
    }

    public void setUserId(String str) {
    }

    public AdMostAdNetworkInitInterface(boolean z, int i, int i2, boolean z2, String... strArr) {
        this.initRequired = z;
        this.initParameterCount = i;
        this.minSdkVersion = i2;
        this.isInitLightWeight = z2;
        this.supportedAdTypes.addAll(Arrays.asList(strArr));
    }
}
