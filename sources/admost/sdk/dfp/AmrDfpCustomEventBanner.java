package admost.sdk.dfp;

import admost.sdk.AdMostView;
import admost.sdk.AdMostViewBinder;
import admost.sdk.listener.AdMostViewListener;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.customevent.CustomEventBanner;
import com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener;

public class AmrDfpCustomEventBanner implements CustomEventBanner {
    private AdMostView adMostView;

    public void onDestroy() {
        AdMostView adMostView2 = this.adMostView;
        if (adMostView2 != null) {
            adMostView2.destroy();
        }
    }

    public void onPause() {
        AdMostView adMostView2 = this.adMostView;
        if (adMostView2 != null) {
            adMostView2.pause();
        }
    }

    public void onResume() {
        AdMostView adMostView2 = this.adMostView;
        if (adMostView2 != null) {
            adMostView2.resume();
        }
    }

    public void requestBannerAd(Context context, CustomEventBannerListener customEventBannerListener, String str, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle) {
        AdMostViewBinder adMostViewBinder;
        if (bundle != null) {
            bundle.setClassLoader(AdMostViewBinder.class.getClassLoader());
            adMostViewBinder = (AdMostViewBinder) bundle.getParcelable("amr_binder");
        } else {
            adMostViewBinder = null;
        }
        AdMostView adMostView2 = new AdMostView((Activity) context, str, 0, (AdMostViewListener) null, adMostViewBinder);
        this.adMostView = adMostView2;
        adMostView2.setListener(new AmrDfpCustomBannerEventForwarder(customEventBannerListener, adMostView2));
        this.adMostView.load();
    }
}
