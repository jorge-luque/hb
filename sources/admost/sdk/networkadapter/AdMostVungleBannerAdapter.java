package admost.sdk.networkadapter;

import admost.sdk.AdMostManager;
import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.base.AdMostUtil;
import admost.sdk.interfaces.AdMostBannerInterface;
import admost.sdk.listener.AdMostInitializationListener;
import admost.sdk.model.AdMostBannerResponseItem;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.vungle.warren.AdConfig;
import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.PlayAdCallback;
import com.vungle.warren.Vungle;
import com.vungle.warren.VungleNativeAd;
import com.vungle.warren.error.VungleException;
import java.lang.ref.WeakReference;

public class AdMostVungleBannerAdapter extends AdMostBannerInterface {
    /* access modifiers changed from: protected */
    public void destroyBanner() {
        Object obj = this.mAd;
        if (obj != null) {
            ((RelativeLayout) obj).removeAllViews();
        }
    }

    /* access modifiers changed from: protected */
    public View getBannerAdView(WeakReference<Activity> weakReference) {
        Object obj = this.mAd1;
        if (obj == null) {
            onAmrFail(this.mBannerResponseItem, "mAd1 null");
            return null;
        }
        ((RelativeLayout) this.mAd).addView(((VungleNativeAd) obj).renderNativeView());
        return (View) this.mAd;
    }

    public boolean isSafeForCache() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean loadBanner(final WeakReference<Activity> weakReference) {
        AdMostBannerResponseItem adMostBannerResponseItem = this.mBannerResponseItem;
        if (adMostBannerResponseItem.ZoneSize != 250) {
            onAmrFail(adMostBannerResponseItem, "loadBanner: ZoneSize os not 250");
            return false;
        } else if (!Vungle.isInitialized()) {
            AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.VUNGLE).setInitListener(new AdMostInitializationListener() {
                public void onError(String str) {
                    AdMostVungleBannerAdapter adMostVungleBannerAdapter = AdMostVungleBannerAdapter.this;
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostVungleBannerAdapter.mBannerResponseItem;
                    adMostVungleBannerAdapter.onAmrFail(adMostBannerResponseItem, "init error: " + str);
                }

                public void onInitialized() {
                    if (Vungle.isInitialized()) {
                        AdMostVungleBannerAdapter adMostVungleBannerAdapter = AdMostVungleBannerAdapter.this;
                        adMostVungleBannerAdapter.load(adMostVungleBannerAdapter.mBannerResponseItem, weakReference, adMostVungleBannerAdapter.mInterfaceListener);
                        return;
                    }
                    AdMostVungleBannerAdapter adMostVungleBannerAdapter2 = AdMostVungleBannerAdapter.this;
                    adMostVungleBannerAdapter2.onAmrFail(adMostVungleBannerAdapter2.mBannerResponseItem, "onInitialized: Vungle.isInitialized false");
                }
            });
            return false;
        } else {
            final RelativeLayout relativeLayout = new RelativeLayout((Context) weakReference.get());
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(AdMostUtil.getDip(AdMost.AD_ERROR_FREQ_CAP), AdMostUtil.getDip(AdMostManager.AD_MEDIUM_RECTANGLE)));
            final String str = this.mBannerResponseItem.AdSpaceId;
            Vungle.loadAd(str, new LoadAdCallback() {
                public void onAdLoad(String str) {
                    if (str.equals(str)) {
                        if (Vungle.canPlayAd(str)) {
                            AdConfig adConfig = new AdConfig();
                            adConfig.setAdSize(AdConfig.AdSize.VUNGLE_MREC);
                            AdMostVungleBannerAdapter.this.mAd1 = Vungle.getNativeAd(str, adConfig, new PlayAdCallback() {
                                public void onAdClick(String str) {
                                    AdMostVungleBannerAdapter.this.onAmrClick();
                                }

                                public void onAdEnd(String str) {
                                }

                                public void onAdEnd(String str, boolean z, boolean z2) {
                                }

                                public void onAdLeftApplication(String str) {
                                }

                                public void onAdRewarded(String str) {
                                }

                                public void onAdStart(String str) {
                                    AdMostVungleBannerAdapter.this.onAmrReady();
                                }

                                public void onError(String str, VungleException vungleException) {
                                    if (str.equals(str)) {
                                        AdMostVungleBannerAdapter adMostVungleBannerAdapter = AdMostVungleBannerAdapter.this;
                                        AdMostBannerResponseItem adMostBannerResponseItem = adMostVungleBannerAdapter.mBannerResponseItem;
                                        adMostVungleBannerAdapter.onAmrFail(adMostBannerResponseItem, "onError: " + str);
                                    }
                                }
                            });
                            AdMostVungleBannerAdapter.this.mAd = relativeLayout;
                            return;
                        }
                        AdMostVungleBannerAdapter adMostVungleBannerAdapter = AdMostVungleBannerAdapter.this;
                        adMostVungleBannerAdapter.onAmrFail(adMostVungleBannerAdapter.mBannerResponseItem, "loadAd can play ad false");
                    }
                }

                public void onError(String str, VungleException vungleException) {
                    if (str.equals(str)) {
                        AdMostVungleBannerAdapter adMostVungleBannerAdapter = AdMostVungleBannerAdapter.this;
                        AdMostBannerResponseItem adMostBannerResponseItem = adMostVungleBannerAdapter.mBannerResponseItem;
                        StringBuilder sb = new StringBuilder();
                        sb.append("loadAd exception: ");
                        sb.append(vungleException == null ? "" : vungleException.getMessage());
                        adMostVungleBannerAdapter.onAmrFail(adMostBannerResponseItem, sb.toString());
                    }
                }
            });
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void pauseBanner() {
        Object obj = this.mAd1;
        if (obj != null) {
            ((VungleNativeAd) obj).setAdVisibility(false);
        }
    }

    /* access modifiers changed from: protected */
    public void resumeBanner() {
        Object obj = this.mAd1;
        if (obj != null) {
            ((VungleNativeAd) obj).setAdVisibility(true);
        }
    }
}
