package admost.sdk.interfaces;

import admost.sdk.AdMostViewBinder;
import admost.sdk.C0164R;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.base.AdMostAdType;
import admost.sdk.base.AdMostImpressionManager;
import admost.sdk.base.AdMostLog;
import admost.sdk.housead.NativeInterstitialAd;
import admost.sdk.listener.AdMostAdListenerForNetworkAdapter;
import admost.sdk.listener.AdMostBannerInterfaceListener;
import admost.sdk.listener.AdMostFullScreenInterfaceListener;
import admost.sdk.model.AdMostBannerResponseItem;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.drive.DriveFile;
import java.lang.ref.WeakReference;

public abstract class AdMostFullScreenInterface implements AdMostAdInterface {
    public boolean isShowSuccessful;
    public boolean isSingleton;
    public boolean isSingletonForIntAndRewardedBoth;
    public boolean isSingletonForPlacement;
    public WeakReference<Activity> mActivity;
    public Object mAd1;
    public Object mAd2;
    public AdMostBannerResponseItem mBannerResponseItem;
    public AdMostFullScreenInterfaceListener mManagerListener;
    public AdMostBannerInterface mNativeAdapter;

    private void clearForGC() {
        this.mManagerListener = null;
        this.mActivity = null;
        this.mAd1 = null;
        this.mAd2 = null;
    }

    public final void destroy() {
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        if (adMostBannerResponseItem == null) {
            clearForGC();
            return;
        }
        try {
            if (adMostBannerResponseItem.Type.equals("video")) {
                destroyVideo();
            } else if (adMostBannerResponseItem.Type.equals("banner")) {
                destroyInterstitial();
            } else {
                if (!adMostBannerResponseItem.Type.equals("native")) {
                    if (!adMostBannerResponseItem.Type.equals(AdMostAdType.NATIVE_INSTALL)) {
                        if (adMostBannerResponseItem.Type.equals(AdMostAdType.OFFERWALL)) {
                            destroyOfferwall();
                        }
                    }
                }
                destroyNativeInterstitial();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mBannerResponseItem = null;
        clearForGC();
    }

    /* access modifiers changed from: protected */
    public void destroyInterstitial() {
    }

    /* access modifiers changed from: protected */
    public final void destroyNativeInterstitial() {
        AdMostBannerInterface adMostBannerInterface = this.mNativeAdapter;
        if (adMostBannerInterface != null) {
            adMostBannerInterface.destroy();
            this.mNativeAdapter = null;
        }
    }

    /* access modifiers changed from: protected */
    public void destroyOfferwall() {
    }

    /* access modifiers changed from: protected */
    public void destroyVideo() {
    }

    public AdMostBannerResponseItem getBannerResponseItem() {
        return this.mBannerResponseItem;
    }

    public boolean isSafeForCache() {
        return true;
    }

    public final void load(AdMostBannerResponseItem adMostBannerResponseItem, WeakReference<Activity> weakReference, AdMostFullScreenInterfaceListener adMostFullScreenInterfaceListener) {
        this.mManagerListener = adMostFullScreenInterfaceListener;
        this.mBannerResponseItem = adMostBannerResponseItem;
        AdMostImpressionManager.getInstance().setPlacementImpressionData(1, this.mBannerResponseItem);
        if (this.mBannerResponseItem.Type.equals("video")) {
            loadVideo();
        } else if (this.mBannerResponseItem.Type.equals("banner")) {
            loadInterstitial();
        } else if (this.mBannerResponseItem.Type.equals("native") || this.mBannerResponseItem.Type.equals(AdMostAdType.NATIVE_INSTALL)) {
            loadNativeInterstitial();
        } else if (this.mBannerResponseItem.Type.equals(AdMostAdType.OFFERWALL)) {
            loadOfferwall();
        }
    }

    /* access modifiers changed from: protected */
    public void loadInterstitial() {
    }

    /* access modifiers changed from: protected */
    public final void loadNativeInterstitial() {
        if (this.mNativeAdapter == null) {
            this.mManagerListener.onFail(this);
            return;
        }
        this.mNativeAdapter.setNativeBinder(new AdMostViewBinder.Builder(C0164R.layout.admost_native_full).iconImageId(C0164R.C0166id.ad_app_icon).titleId(C0164R.C0166id.ad_headline).callToActionId(C0164R.C0166id.ad_call_to_action).textId(C0164R.C0166id.ad_body).attributionId(C0164R.C0166id.ad_attribution).mainImageId(C0164R.C0166id.ad_image).backImageId(C0164R.C0166id.ad_back).isRoundedMode(true).privacyIconId(C0164R.C0166id.ad_mopub).build());
        this.mNativeAdapter.load(this.mBannerResponseItem, new WeakReference(AdMost.getInstance().getActivity()), new AdMostBannerInterfaceListener() {
            public void onFail() {
                AdMostFullScreenInterface adMostFullScreenInterface = AdMostFullScreenInterface.this;
                adMostFullScreenInterface.mManagerListener.onFail(adMostFullScreenInterface);
            }

            public void onReady(AdMostBannerInterface adMostBannerInterface) {
                AdMostFullScreenInterface adMostFullScreenInterface = AdMostFullScreenInterface.this;
                adMostFullScreenInterface.mAd1 = adMostBannerInterface;
                adMostFullScreenInterface.mManagerListener.onReady(adMostFullScreenInterface);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void loadOfferwall() {
    }

    /* access modifiers changed from: protected */
    public void loadVideo() {
    }

    public final void onAmrClick() {
        AdMostFullScreenInterfaceListener adMostFullScreenInterfaceListener = this.mManagerListener;
        if (adMostFullScreenInterfaceListener != null) {
            adMostFullScreenInterfaceListener.onClick(this);
        }
    }

    public final void onAmrComplete() {
        AdMostFullScreenInterfaceListener adMostFullScreenInterfaceListener = this.mManagerListener;
        if (adMostFullScreenInterfaceListener != null) {
            adMostFullScreenInterfaceListener.onComplete(this);
        }
    }

    public final void onAmrDismiss() {
        try {
            AdMostAdNetworkManager.getInstance().getInitAdapter(this.mBannerResponseItem.Network).removeListenerForPlacement(this.mBannerResponseItem.AdSpaceId);
        } catch (Exception unused) {
        }
        AdMostFullScreenInterfaceListener adMostFullScreenInterfaceListener = this.mManagerListener;
        if (adMostFullScreenInterfaceListener != null) {
            adMostFullScreenInterfaceListener.onDismiss(this);
        }
    }

    public final void onAmrFail(AdMostBannerResponseItem adMostBannerResponseItem, String str) {
        onAmrFail(adMostBannerResponseItem, -1, str);
    }

    public final void onAmrFailToShow(AdMostBannerResponseItem adMostBannerResponseItem, String str) {
        onAmrFailToShow(adMostBannerResponseItem, -1, str);
    }

    public final void onAmrReady() {
        AdMostFullScreenInterfaceListener adMostFullScreenInterfaceListener = this.mManagerListener;
        if (adMostFullScreenInterfaceListener != null) {
            adMostFullScreenInterfaceListener.onReady(this);
        }
    }

    public AdMostFullScreenInterface setBannerResponseItem(AdMostBannerResponseItem adMostBannerResponseItem) {
        this.mBannerResponseItem = adMostBannerResponseItem;
        return this;
    }

    public AdMostFullScreenInterface setNativeAdapter(AdMostBannerInterface adMostBannerInterface) {
        this.mNativeAdapter = adMostBannerInterface;
        return this;
    }

    public final void show() {
        if (this.mBannerResponseItem.Type.equals("video")) {
            this.isShowSuccessful = true;
            showVideo();
        } else if (this.mBannerResponseItem.Type.equals("banner")) {
            this.isShowSuccessful = true;
            showInterstitial();
        } else if (this.mBannerResponseItem.Type.equals("native") || this.mBannerResponseItem.Type.equals(AdMostAdType.NATIVE_INSTALL)) {
            this.isShowSuccessful = true;
            showNativeInterstitial();
        } else if (this.mBannerResponseItem.Type.equals(AdMostAdType.OFFERWALL)) {
            this.isShowSuccessful = true;
            showOfferwall();
        }
    }

    /* access modifiers changed from: protected */
    public void showInterstitial() {
    }

    public final void showNativeInterstitial() {
        View adView = ((AdMostBannerInterface) this.mAd1).getAdView(LayoutInflater.from(AdMost.getInstance().getActivity()), ((AdMostBannerInterface) this.mAd1).mBinder, new WeakReference(AdMost.getInstance().getActivity()), (ViewGroup) null);
        this.mNativeAdapter.addAdChoivesView(adView, ((AdMostBannerInterface) this.mAd1).mBinder);
        NativeInterstitialAd.setView(adView, new AdMostAdListenerForNetworkAdapter() {
            public void onClicked(String str) {
            }

            public void onComplete(String str) {
            }

            public void onDismiss(String str) {
                AdMostFullScreenInterface adMostFullScreenInterface = AdMostFullScreenInterface.this;
                AdMostFullScreenInterfaceListener adMostFullScreenInterfaceListener = adMostFullScreenInterface.mManagerListener;
                if (adMostFullScreenInterfaceListener != null) {
                    adMostFullScreenInterfaceListener.onDismiss(adMostFullScreenInterface);
                }
            }

            public void onFail(int i) {
            }

            public void onFailToShow(int i) {
            }

            public void onReady(String str, int i) {
            }

            public void onShown(String str) {
            }
        });
        Intent intent = new Intent(AdMost.getInstance().getContext(), NativeInterstitialAd.class);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        AdMost.getInstance().getContext().startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void showOfferwall() {
    }

    /* access modifiers changed from: protected */
    public void showVideo() {
    }

    public void onAmrFail(AdMostBannerResponseItem adMostBannerResponseItem, int i, String str) {
        String str2;
        Object[] objArr = new Object[3];
        objArr[0] = adMostBannerResponseItem != null ? adMostBannerResponseItem.toString() : "bannerResponseItem null";
        if (i == -1) {
            str2 = "";
        } else {
            str2 = "|| Error Code (Ad Network): " + i;
        }
        objArr[1] = str2;
        objArr[2] = str;
        AdMostLog.m299i(String.format("NOT_FILLED : Placement Info: %s %s || Error Message: %s ", objArr));
        try {
            AdMostAdNetworkManager.getInstance().getInitAdapter(adMostBannerResponseItem).removeListenerForPlacement(adMostBannerResponseItem.AdSpaceId);
        } catch (Exception unused) {
        }
        AdMostFullScreenInterfaceListener adMostFullScreenInterfaceListener = this.mManagerListener;
        if (adMostFullScreenInterfaceListener != null) {
            adMostFullScreenInterfaceListener.onFail(this);
        }
        clearForGC();
    }

    public void onAmrFailToShow(AdMostBannerResponseItem adMostBannerResponseItem, int i, String str) {
        String str2;
        Object[] objArr = new Object[3];
        objArr[0] = adMostBannerResponseItem != null ? adMostBannerResponseItem.toString() : "bannerResponseItem null";
        if (i == -1) {
            str2 = "";
        } else {
            str2 = "|| Error Code (Ad Network): " + i;
        }
        objArr[1] = str2;
        objArr[2] = str;
        String format = String.format("FAIL_TO_SHOW : Placement Info: %s %s || Error Message: %s ", objArr);
        this.isShowSuccessful = false;
        AdMostLog.m299i(format);
        try {
            AdMostAdNetworkManager.getInstance().getInitAdapter(adMostBannerResponseItem).removeListenerForPlacement(adMostBannerResponseItem.AdSpaceId);
        } catch (Exception unused) {
        }
        AdMostFullScreenInterfaceListener adMostFullScreenInterfaceListener = this.mManagerListener;
        if (adMostFullScreenInterfaceListener != null) {
            adMostFullScreenInterfaceListener.onFailToShow(this);
        } else {
            AdMostLog.m296e("mManagerListener removed before callback onAmrFailToShow");
        }
        clearForGC();
    }
}
