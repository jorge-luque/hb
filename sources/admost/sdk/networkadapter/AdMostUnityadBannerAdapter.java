package admost.sdk.networkadapter;

import admost.sdk.base.AdMost;
import admost.sdk.interfaces.AdMostBannerInterface;
import admost.sdk.model.AdMostBannerResponseItem;
import android.app.Activity;
import android.view.View;
import com.unity3d.services.banners.IUnityBannerListener;
import com.unity3d.services.banners.UnityBanners;
import java.lang.ref.WeakReference;

public class AdMostUnityadBannerAdapter extends AdMostBannerInterface {
    /* access modifiers changed from: protected */
    public void destroyBanner() {
        UnityBanners.setBannerListener((IUnityBannerListener) null);
        UnityBanners.destroy();
    }

    /* access modifiers changed from: protected */
    public View getBannerAdView(WeakReference<Activity> weakReference) {
        return (View) this.mAd;
    }

    public boolean isActivityRequiredForLoad(Activity activity) {
        return false;
    }

    public boolean isSafeForCache() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean loadBanner(WeakReference<Activity> weakReference) {
        UnityBanners.setBannerListener(new IUnityBannerListener() {
            public void onUnityBannerClick(String str) {
                AdMostUnityadBannerAdapter.this.onAmrClick();
            }

            public void onUnityBannerError(String str) {
                AdMostUnityadBannerAdapter adMostUnityadBannerAdapter = AdMostUnityadBannerAdapter.this;
                AdMostBannerResponseItem adMostBannerResponseItem = adMostUnityadBannerAdapter.mBannerResponseItem;
                adMostUnityadBannerAdapter.onAmrFail(adMostBannerResponseItem, "onUnityBannerError: " + str);
            }

            public void onUnityBannerHide(String str) {
            }

            public void onUnityBannerLoaded(String str, View view) {
                AdMostUnityadBannerAdapter.this.onAmrReady();
                AdMostUnityadBannerAdapter.this.mAd = view;
            }

            public void onUnityBannerShow(String str) {
            }

            public void onUnityBannerUnloaded(String str) {
                AdMostUnityadBannerAdapter adMostUnityadBannerAdapter = AdMostUnityadBannerAdapter.this;
                AdMostBannerResponseItem adMostBannerResponseItem = adMostUnityadBannerAdapter.mBannerResponseItem;
                adMostUnityadBannerAdapter.onAmrFail(adMostBannerResponseItem, "onUnityBannerUnloaded: " + str);
            }
        });
        UnityBanners.loadBanner(AdMost.getInstance().getActivity(), this.mBannerResponseItem.AdSpaceId);
        return true;
    }
}
