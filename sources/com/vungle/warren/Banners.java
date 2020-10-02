package com.vungle.warren;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.vungle.warren.AdConfig;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import com.vungle.warren.persistence.FutureResult;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.Executors;
import com.vungle.warren.utility.TimeoutProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class Banners {
    /* access modifiers changed from: private */
    public static final String TAG = "Banners";

    public static boolean canPlayAd(final String str, final AdConfig.AdSize adSize) {
        if (!AdConfig.AdSize.isBannerAdSize(adSize)) {
            Log.e(TAG, "Invalid Ad Size. Cannot check loaded status of non banner size placements.");
            return false;
        }
        final Context appContext = Vungle.appContext();
        if (appContext == null) {
            Log.e(TAG, "Context is null");
            return false;
        }
        ServiceLocator instance = ServiceLocator.getInstance(appContext);
        return Boolean.TRUE.equals(new FutureResult(((Executors) instance.getService(Executors.class)).getApiExecutor().submit(new Callable<Boolean>() {
            public Boolean call() {
                if (!Vungle.isInitialized()) {
                    Log.e(Banners.TAG, "Vungle is not initialized");
                    return false;
                }
                Repository repository = (Repository) ServiceLocator.getInstance(appContext).getService(Repository.class);
                Advertisement advertisement = repository.findValidAdvertisementForPlacement(str).get();
                Placement placement = repository.load(str, Placement.class).get();
                if (placement != null && adSize == placement.getAdSize() && advertisement != null && advertisement.getAdConfig().getAdSize().equals(adSize)) {
                    return Boolean.valueOf(Vungle.canPlayAd(advertisement));
                }
                return false;
            }
        })).get(((TimeoutProvider) instance.getService(TimeoutProvider.class)).getTimeout(), TimeUnit.MILLISECONDS));
    }

    public static VungleBanner getBanner(String str, AdConfig.AdSize adSize, PlayAdCallback playAdCallback) {
        Context appContext = Vungle.appContext();
        if (appContext == null || !Vungle.isInitialized()) {
            Log.e(TAG, "Vungle is not initialized, returned VungleNativeAd = null");
            onPlaybackError(str, playAdCallback, 9);
            return null;
        }
        Repository repository = (Repository) ServiceLocator.getInstance(appContext).getService(Repository.class);
        VungleSettings vungleSettings = ((RuntimeValues) ServiceLocator.getInstance(appContext).getService(RuntimeValues.class)).settings.get();
        if (TextUtils.isEmpty(str)) {
            onPlaybackError(str, playAdCallback, 13);
            return null;
        }
        Placement placement = repository.load(str, Placement.class).get();
        if (placement == null) {
            onPlaybackError(str, playAdCallback, 13);
            return null;
        } else if (!AdConfig.AdSize.isBannerAdSize(adSize)) {
            onPlaybackError(str, playAdCallback, 30);
            return null;
        } else if (!canPlayAd(str, adSize)) {
            onPlaybackError(str, playAdCallback, 10);
            return null;
        } else if (vungleSettings != null && vungleSettings.getBannerRefreshDisabled()) {
            return new VungleBanner(appContext, str, 0, adSize, playAdCallback);
        } else {
            return new VungleBanner(appContext, str, placement.getAdRefreshDuration(), adSize, playAdCallback);
        }
    }

    public static void loadBanner(String str, AdConfig.AdSize adSize, LoadAdCallback loadAdCallback) {
        if (Vungle.appContext() == null || !Vungle.isInitialized()) {
            onLoadError(str, loadAdCallback, 9);
        } else if (adSize == null) {
            onLoadError(str, loadAdCallback, 28);
        } else {
            AdConfig adConfig = new AdConfig();
            adConfig.setAdSize(adSize);
            if (!AdConfig.AdSize.isBannerAdSize(adConfig.getAdSize())) {
                onLoadError(str, loadAdCallback, 30);
            }
            Vungle.loadAdInternal(str, adConfig, loadAdCallback);
        }
    }

    private static void onLoadError(String str, LoadAdCallback loadAdCallback, @VungleException.ExceptionCode int i) {
        if (loadAdCallback != null) {
            loadAdCallback.onError(str, new VungleException(i));
        }
    }

    private static void onPlaybackError(String str, PlayAdCallback playAdCallback, @VungleException.ExceptionCode int i) {
        if (playAdCallback != null) {
            playAdCallback.onError(str, new VungleException(i));
        }
    }
}
