package admost.sdk.networkadapter;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.base.AdMostLocation;
import admost.sdk.base.AdMostLog;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.model.AdMostBannerResponseItem;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.GregorianCalendar;

public class AdMostAdmobFullScreenAdapter extends AdMostFullScreenInterface {
    /* access modifiers changed from: private */
    public boolean adStarted;
    /* access modifiers changed from: private */
    public boolean onCompleteCallbackReturned;

    public AdMostAdmobFullScreenAdapter() {
        this.isSingleton = true;
        this.isSingletonForIntAndRewardedBoth = false;
        this.isSingletonForPlacement = true;
    }

    private AdRequest.Builder getAdRequestBuilder(Activity activity) {
        Class<AdMobAdapter> cls = AdMobAdapter.class;
        AdRequest.Builder builder = new AdRequest.Builder();
        if (!AdMost.getInstance().getConfiguration().showPersonalizedAdForGDPR()) {
            Bundle bundle = new Bundle();
            bundle.putString("npa", "1");
            builder.addNetworkExtrasBundle(cls, bundle);
        }
        if (!AdMost.getInstance().getConfiguration().showPersonalizedAdForCCPA()) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("rdp", 1);
            builder.addNetworkExtrasBundle(cls, bundle2);
        }
        if (AdMostLocation.isStarted() && AdMostLocation.getInstance().isFound()) {
            builder.setLocation(AdMostLocation.getInstance().location());
        }
        int gender = AdMost.getInstance().getGender();
        if (gender == 0) {
            builder.setGender(1);
        } else if (gender == 1) {
            builder.setGender(2);
        }
        if (AdMost.getInstance().getAge() > 0) {
            builder.setBirthday(new GregorianCalendar(Calendar.getInstance().get(1) - AdMost.getInstance().getAge(), 1, 1).getTime());
        }
        try {
            ArrayList<String> testDeviceIds = AdMost.getInstance().getConfiguration().getTestDeviceIds(AdMostAdNetwork.ADMOB);
            if (testDeviceIds != null && testDeviceIds.size() > 0) {
                Enumeration<T> enumeration = Collections.enumeration(testDeviceIds);
                while (enumeration.hasMoreElements()) {
                    builder.addTestDevice((String) enumeration.nextElement());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setContentUrl(activity, builder);
        return builder;
    }

    private void setContentUrl(Activity activity, Object obj) {
        if (activity != null) {
            try {
                String stringExtra = activity.getIntent().getStringExtra(AdMost.CONTENT_URL);
                if (stringExtra != null) {
                    if (!stringExtra.startsWith("http")) {
                        if (!stringExtra.startsWith("site")) {
                            AdMostLog.m296e("Content URL must be start with 'http' or 'site' (https://support.google.com/admob/answer/6270563)");
                            return;
                        }
                    }
                    if (obj instanceof PublisherAdRequest.Builder) {
                        ((PublisherAdRequest.Builder) obj).setContentUrl(stringExtra);
                    } else if (obj instanceof AdRequest.Builder) {
                        ((AdRequest.Builder) obj).setContentUrl(stringExtra);
                    }
                    AdMostLog.m299i("ADMOST_CONTENT_URL " + stringExtra);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void destroyInterstitial() {
    }

    /* access modifiers changed from: protected */
    public void destroyVideo() {
        AdMostAdmobInitAdapter adMostAdmobInitAdapter = (AdMostAdmobInitAdapter) AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.ADMOB);
        if (adMostAdmobInitAdapter != null) {
            adMostAdmobInitAdapter.setRewardedVideoAd((RewardedVideoAd) null);
        }
        ((RewardedVideoAd) this.mAd1).destroy(AdMost.getInstance().getActivity());
    }

    public void loadInterstitial() {
        String str = this.mBannerResponseItem.AdSpaceId;
        final InterstitialAd interstitialAd = new InterstitialAd(AdMost.getInstance().getContext());
        interstitialAd.setAdUnitId(str);
        interstitialAd.setAdListener(new AdListener() {
            public void onAdClosed() {
                AdMostAdmobFullScreenAdapter.this.onAmrDismiss();
            }

            public void onAdFailedToLoad(int i) {
                AdMostAdmobFullScreenAdapter adMostAdmobFullScreenAdapter = AdMostAdmobFullScreenAdapter.this;
                AdMostBannerResponseItem adMostBannerResponseItem = adMostAdmobFullScreenAdapter.mBannerResponseItem;
                adMostAdmobFullScreenAdapter.onAmrFail(adMostBannerResponseItem, "onAdFailedToLoad: " + i);
            }

            public void onAdLeftApplication() {
                super.onAdLeftApplication();
                AdMostAdmobFullScreenAdapter.this.onAmrClick();
            }

            public void onAdLoaded() {
                if (interstitialAd.isLoaded()) {
                    AdMostAdmobFullScreenAdapter adMostAdmobFullScreenAdapter = AdMostAdmobFullScreenAdapter.this;
                    adMostAdmobFullScreenAdapter.mAd1 = interstitialAd;
                    adMostAdmobFullScreenAdapter.onAmrReady();
                }
            }
        });
        interstitialAd.loadAd(getAdRequestBuilder(AdMost.getInstance().getActivity()).build());
    }

    public void loadVideo() {
        String str = this.mBannerResponseItem.AdSpaceId;
        final RewardedVideoAd rewardedVideoAdInstance = MobileAds.getRewardedVideoAdInstance(AdMost.getInstance().getContext());
        String userId = AdMostAdmobInitAdapter.getUserId();
        if (userId != null && !userId.equals("")) {
            rewardedVideoAdInstance.setUserId(userId);
        }
        rewardedVideoAdInstance.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            public void onRewarded(RewardItem rewardItem) {
                if (!AdMostAdmobFullScreenAdapter.this.onCompleteCallbackReturned) {
                    boolean unused = AdMostAdmobFullScreenAdapter.this.onCompleteCallbackReturned = true;
                    AdMostAdmobFullScreenAdapter.this.onAmrComplete();
                }
            }

            public void onRewardedVideoAdClosed() {
                boolean unused = AdMostAdmobFullScreenAdapter.this.adStarted = true;
                AdMostAdmobFullScreenAdapter.this.onAmrDismiss();
            }

            public void onRewardedVideoAdFailedToLoad(int i) {
                AdMostAdmobFullScreenAdapter adMostAdmobFullScreenAdapter = AdMostAdmobFullScreenAdapter.this;
                AdMostBannerResponseItem adMostBannerResponseItem = adMostAdmobFullScreenAdapter.mBannerResponseItem;
                adMostAdmobFullScreenAdapter.onAmrFail(adMostBannerResponseItem, "onRewardedVideoAdFailedToLoad: " + i);
            }

            public void onRewardedVideoAdLeftApplication() {
                AdMostAdmobFullScreenAdapter.this.onAmrClick();
            }

            public void onRewardedVideoAdLoaded() {
                if (rewardedVideoAdInstance.isLoaded()) {
                    AdMostAdmobFullScreenAdapter.this.mAd1 = rewardedVideoAdInstance;
                    AdMostAdmobInitAdapter adMostAdmobInitAdapter = (AdMostAdmobInitAdapter) AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.ADMOB);
                    if (adMostAdmobInitAdapter != null) {
                        adMostAdmobInitAdapter.setRewardedVideoAd((RewardedVideoAd) AdMostAdmobFullScreenAdapter.this.mAd1);
                    }
                    AdMostAdmobFullScreenAdapter.this.onAmrReady();
                }
            }

            public void onRewardedVideoAdOpened() {
            }

            public void onRewardedVideoCompleted() {
                boolean unused = AdMostAdmobFullScreenAdapter.this.adStarted = true;
                if (!AdMostAdmobFullScreenAdapter.this.onCompleteCallbackReturned) {
                    boolean unused2 = AdMostAdmobFullScreenAdapter.this.onCompleteCallbackReturned = true;
                    AdMostAdmobFullScreenAdapter.this.onAmrComplete();
                }
            }

            public void onRewardedVideoStarted() {
                boolean unused = AdMostAdmobFullScreenAdapter.this.adStarted = true;
            }
        });
        rewardedVideoAdInstance.loadAd(str, getAdRequestBuilder(AdMost.getInstance().getActivity()).build());
    }

    public void showInterstitial() {
        ((InterstitialAd) this.mAd1).show();
    }

    public void showVideo() {
        if (this.mAd1 == null) {
            onAmrFailToShow(this.mBannerResponseItem, "ad is null");
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                if (!AdMostAdmobFullScreenAdapter.this.adStarted) {
                    AdMostAdmobFullScreenAdapter adMostAdmobFullScreenAdapter = AdMostAdmobFullScreenAdapter.this;
                    adMostAdmobFullScreenAdapter.onAmrFail(adMostAdmobFullScreenAdapter.mBannerResponseItem, "45000 millis time-out");
                }
            }
        }, 45000);
        ((RewardedVideoAd) this.mAd1).show();
    }
}
