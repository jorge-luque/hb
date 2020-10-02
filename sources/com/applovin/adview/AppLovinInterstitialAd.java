package com.applovin.adview;

import android.content.Context;
import com.applovin.impl.adview.InterstitialAdDialogCreatorImpl;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;

public class AppLovinInterstitialAd {
    public static AppLovinInterstitialAdDialog create(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context != null) {
            return new InterstitialAdDialogCreatorImpl().createInterstitialAdDialog(appLovinSdk, context);
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    @Deprecated
    public static boolean isAdReadyToDisplay(Context context) {
        return AppLovinSdk.getInstance(context).getAdService().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    public static void show(final Context context) {
        if (context != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    new InterstitialAdDialogCreatorImpl().createInterstitialAdDialog(AppLovinSdk.getInstance(context), context).show();
                }
            });
            return;
        }
        throw new IllegalArgumentException("No context specified");
    }

    public String toString() {
        return "AppLovinInterstitialAd{}";
    }
}
