package admost.sdk.interfaces;

import admost.sdk.AdMostViewBinder;
import admost.sdk.base.AdMostAdType;
import admost.sdk.base.AdMostImpressionManager;
import admost.sdk.base.AdMostLog;
import admost.sdk.listener.AdMostBannerInterfaceClickListener;
import admost.sdk.listener.AdMostBannerInterfaceListener;
import admost.sdk.model.AdMostBannerResponseItem;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public abstract class AdMostBannerInterface implements AdMostAdInterface {
    public long expiresAt;
    public boolean hasAdIcon = false;
    public boolean hasAdImage = false;
    public boolean hasResponse = false;
    public boolean isAdClicked = false;
    public Object mAd;
    public Object mAd1;
    public AdMostBannerResponseItem mBannerResponseItem;
    public AdMostViewBinder mBinder;
    public AdMostBannerInterfaceClickListener mClickListener;
    public AdMostBannerInterfaceListener mInterfaceListener;

    private void clearForGC() {
        this.mAd = null;
        this.mAd1 = null;
        this.mBannerResponseItem = null;
        this.mInterfaceListener = null;
        this.mBinder = null;
    }

    public void addAdChoivesView(View view, AdMostViewBinder adMostViewBinder) {
    }

    public void clearParentView() {
        Object obj = this.mAd;
        if (obj != null && (obj instanceof View)) {
            try {
                ViewGroup viewGroup = (ViewGroup) ((View) obj).getParent();
                if (viewGroup != null) {
                    viewGroup.removeView((View) this.mAd);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void destroy() {
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        if (adMostBannerResponseItem == null) {
            clearForGC();
            return;
        }
        try {
            if (adMostBannerResponseItem.Type.equals("banner")) {
                destroyBanner();
            } else if (this.mBannerResponseItem.Type.equals("native")) {
                destroyNative();
            } else if (this.mBannerResponseItem.Type.equals(AdMostAdType.NATIVE_INSTALL)) {
                destroyNativeInstall();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        clearForGC();
    }

    /* access modifiers changed from: protected */
    public void destroyBanner() {
    }

    /* access modifiers changed from: protected */
    public void destroyNative() {
    }

    /* access modifiers changed from: protected */
    public void destroyNativeInstall() {
    }

    public final View getAdView(LayoutInflater layoutInflater, AdMostViewBinder adMostViewBinder, WeakReference<Activity> weakReference, ViewGroup viewGroup) {
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        if (adMostBannerResponseItem == null) {
            return null;
        }
        try {
            if (adMostBannerResponseItem.Type.equals("banner")) {
                return getBannerAdView(weakReference);
            }
            if (this.mBannerResponseItem.Type.equals("native")) {
                return getNativeAdView(layoutInflater, adMostViewBinder, weakReference, viewGroup);
            }
            if (this.mBannerResponseItem.Type.equals(AdMostAdType.NATIVE_INSTALL)) {
                return getNativeInstallAdView(layoutInflater, adMostViewBinder, weakReference, viewGroup);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public View getBannerAdView(WeakReference<Activity> weakReference) {
        return null;
    }

    public AdMostBannerResponseItem getBannerResponseItem() {
        return this.mBannerResponseItem;
    }

    /* access modifiers changed from: protected */
    public View getNativeAdView(LayoutInflater layoutInflater, AdMostViewBinder adMostViewBinder, WeakReference<Activity> weakReference, ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: protected */
    public View getNativeInstallAdView(LayoutInflater layoutInflater, AdMostViewBinder adMostViewBinder, WeakReference<Activity> weakReference, ViewGroup viewGroup) {
        return null;
    }

    public boolean isActivityRequiredForLoad(Activity activity) {
        return true;
    }

    public boolean isSafeForCache() {
        return true;
    }

    public final void load(AdMostBannerResponseItem adMostBannerResponseItem, WeakReference<Activity> weakReference, AdMostBannerInterfaceListener adMostBannerInterfaceListener) {
        boolean z;
        this.mInterfaceListener = adMostBannerInterfaceListener;
        this.mBannerResponseItem = adMostBannerResponseItem;
        if (adMostBannerResponseItem.Type.equals("banner")) {
            z = loadBanner(weakReference);
        } else if (this.mBannerResponseItem.Type.equals("native")) {
            z = loadNative(weakReference);
        } else {
            z = this.mBannerResponseItem.Type.equals(AdMostAdType.NATIVE_INSTALL) ? loadNativeInstall(weakReference) : false;
        }
        if (z) {
            AdMostImpressionManager.getInstance().setPlacementImpressionData(1, adMostBannerResponseItem);
        }
    }

    /* access modifiers changed from: protected */
    public boolean loadBanner(WeakReference<Activity> weakReference) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean loadNative(WeakReference<Activity> weakReference) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean loadNativeInstall(WeakReference<Activity> weakReference) {
        return false;
    }

    public final void onAmrClick() {
        this.isAdClicked = true;
        AdMostBannerInterfaceClickListener adMostBannerInterfaceClickListener = this.mClickListener;
        if (adMostBannerInterfaceClickListener != null) {
            AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
            adMostBannerInterfaceClickListener.onClick(adMostBannerResponseItem != null ? adMostBannerResponseItem.Network : "");
        }
        if (this.mBannerResponseItem != null) {
            AdMostLog.m299i("AdMostView is clicked: " + this.mBannerResponseItem.toString());
            AdMostImpressionManager.getInstance().setPlacementImpressionData(4, this.mBannerResponseItem);
        }
    }

    public final void onAmrFail(AdMostBannerResponseItem adMostBannerResponseItem, String str) {
        onAmrFail(adMostBannerResponseItem, -1, str);
    }

    public final void onAmrFailToShow(AdMostBannerResponseItem adMostBannerResponseItem, String str) {
        onAmrFailToShow(adMostBannerResponseItem, -1, str);
    }

    public final void onAmrReady() {
        this.hasResponse = true;
        AdMostBannerInterfaceListener adMostBannerInterfaceListener = this.mInterfaceListener;
        if (adMostBannerInterfaceListener != null) {
            adMostBannerInterfaceListener.onReady(this);
        } else {
            clearForGC();
        }
    }

    public final void pause() {
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        if (adMostBannerResponseItem == null || !adMostBannerResponseItem.Type.equals("banner")) {
            AdMostBannerResponseItem adMostBannerResponseItem2 = this.mBannerResponseItem;
            if (adMostBannerResponseItem2 != null && adMostBannerResponseItem2.Type.equals("native")) {
                pauseNative();
                return;
            }
            return;
        }
        pauseBanner();
    }

    /* access modifiers changed from: protected */
    public void pauseBanner() {
    }

    /* access modifiers changed from: protected */
    public void pauseNative() {
    }

    public void removeAdChoicesView(View view, AdMostViewBinder adMostViewBinder) {
    }

    public final void resume() {
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        if (adMostBannerResponseItem == null || !adMostBannerResponseItem.Type.equals("banner")) {
            AdMostBannerResponseItem adMostBannerResponseItem2 = this.mBannerResponseItem;
            if (adMostBannerResponseItem2 != null && adMostBannerResponseItem2.Type.equals("native")) {
                resumeNative();
                return;
            }
            return;
        }
        resumeBanner();
    }

    /* access modifiers changed from: protected */
    public void resumeBanner() {
    }

    /* access modifiers changed from: protected */
    public void resumeNative() {
    }

    public AdMostBannerInterface setBannerResponseItem(AdMostBannerResponseItem adMostBannerResponseItem) {
        this.mBannerResponseItem = adMostBannerResponseItem;
        return this;
    }

    public void setNativeBinder(AdMostViewBinder adMostViewBinder) {
        this.mBinder = adMostViewBinder;
    }

    public void setOnClickListener(AdMostBannerInterfaceClickListener adMostBannerInterfaceClickListener) {
        this.mClickListener = adMostBannerInterfaceClickListener;
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
        this.hasResponse = true;
        AdMostBannerInterfaceListener adMostBannerInterfaceListener = this.mInterfaceListener;
        if (adMostBannerInterfaceListener != null) {
            adMostBannerInterfaceListener.onFail();
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
        AdMostLog.m299i(String.format("FAIL_TO_SHOW : Placement Info: %s %s || Error Message: %s ", objArr));
        this.hasResponse = true;
        AdMostBannerInterfaceListener adMostBannerInterfaceListener = this.mInterfaceListener;
        if (adMostBannerInterfaceListener != null) {
            adMostBannerInterfaceListener.onFail();
        }
        clearForGC();
    }
}
