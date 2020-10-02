package admost.sdk.dfp;

import admost.sdk.AdMostView;
import admost.sdk.listener.AdMostViewListener;
import android.view.View;
import com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener;

public class AmrDfpCustomBannerEventForwarder implements AdMostViewListener {
    private AdMostView mAdView;
    private CustomEventBannerListener mBannerListener;

    public AmrDfpCustomBannerEventForwarder(CustomEventBannerListener customEventBannerListener, AdMostView adMostView) {
        this.mBannerListener = customEventBannerListener;
        this.mAdView = adMostView;
    }

    public void onClick(String str) {
    }

    public void onFail(int i) {
        this.mBannerListener.onAdFailedToLoad(3);
    }

    public void onReady(String str, int i, View view) {
        this.mBannerListener.onAdLoaded(view);
    }
}
