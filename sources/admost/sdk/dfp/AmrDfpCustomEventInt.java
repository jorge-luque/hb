package admost.sdk.dfp;

import admost.sdk.AdMostInterstitial;
import admost.sdk.listener.AdMostAdListener;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial;
import com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener;

public class AmrDfpCustomEventInt implements CustomEventInterstitial {
    private AdMostInterstitial adMostInterstitial;

    public void onDestroy() {
        AdMostInterstitial adMostInterstitial2 = this.adMostInterstitial;
        if (adMostInterstitial2 != null) {
            adMostInterstitial2.destroy();
        }
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void requestInterstitialAd(Context context, CustomEventInterstitialListener customEventInterstitialListener, String str, MediationAdRequest mediationAdRequest, Bundle bundle) {
        AdMostInterstitial adMostInterstitial2 = new AdMostInterstitial((Activity) context, str, (AdMostAdListener) null);
        this.adMostInterstitial = adMostInterstitial2;
        adMostInterstitial2.setListener(new AmrDfpCustomIntEventForwarder(customEventInterstitialListener));
        this.adMostInterstitial.refreshAd(false);
    }

    public void showInterstitial() {
        this.adMostInterstitial.show();
    }
}
