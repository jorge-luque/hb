package admost.sdk.networkadapter;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostLocation;
import admost.sdk.base.AdMostLog;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import android.app.Activity;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.GregorianCalendar;

public class AdMostAdmob1720FullScreenAdapter extends AdMostFullScreenInterface {
    /* access modifiers changed from: private */
    public boolean onCompleteCallbackReturned;

    public AdMostAdmob1720FullScreenAdapter() {
        this.isSingleton = false;
        this.isSingletonForIntAndRewardedBoth = false;
        this.isSingletonForPlacement = false;
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
        if (AdMost.getInstance().isUserChild()) {
            builder.tagForChildDirectedTreatment(true);
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
    }

    public void loadInterstitial() {
        String str = this.mBannerResponseItem.AdSpaceId;
        final InterstitialAd interstitialAd = new InterstitialAd(AdMost.getInstance().getContext());
        interstitialAd.setAdUnitId(str);
        interstitialAd.setAdListener(new AdListener() {
            public void onAdClosed() {
                AdMostAdmob1720FullScreenAdapter.this.onAmrDismiss();
            }

            public void onAdFailedToLoad(int i) {
                AdMostAdmob1720FullScreenAdapter adMostAdmob1720FullScreenAdapter = AdMostAdmob1720FullScreenAdapter.this;
                adMostAdmob1720FullScreenAdapter.onAmrFail(adMostAdmob1720FullScreenAdapter.mBannerResponseItem, i, "onAdFailedToLoad");
            }

            public void onAdLeftApplication() {
                super.onAdLeftApplication();
                AdMostAdmob1720FullScreenAdapter.this.onAmrClick();
            }

            public void onAdLoaded() {
                if (interstitialAd.isLoaded()) {
                    AdMostAdmob1720FullScreenAdapter adMostAdmob1720FullScreenAdapter = AdMostAdmob1720FullScreenAdapter.this;
                    adMostAdmob1720FullScreenAdapter.mAd1 = interstitialAd;
                    adMostAdmob1720FullScreenAdapter.onAmrReady();
                }
            }
        });
        interstitialAd.loadAd(getAdRequestBuilder(AdMost.getInstance().getActivity()).build());
    }

    public void loadVideo() {
        final RewardedAd rewardedAd = new RewardedAd(AdMost.getInstance().getActivity(), this.mBannerResponseItem.AdSpaceId);
        rewardedAd.loadAd(getAdRequestBuilder(AdMost.getInstance().getActivity()).build(), (RewardedAdLoadCallback) new RewardedAdLoadCallback() {
            public void onRewardedAdFailedToLoad(int i) {
                AdMostAdmob1720FullScreenAdapter adMostAdmob1720FullScreenAdapter = AdMostAdmob1720FullScreenAdapter.this;
                adMostAdmob1720FullScreenAdapter.onAmrFail(adMostAdmob1720FullScreenAdapter.mBannerResponseItem, i, "onRewardedAdFailedToLoad");
            }

            public void onRewardedAdLoaded() {
                if (rewardedAd.isLoaded()) {
                    AdMostAdmob1720FullScreenAdapter adMostAdmob1720FullScreenAdapter = AdMostAdmob1720FullScreenAdapter.this;
                    adMostAdmob1720FullScreenAdapter.mAd1 = rewardedAd;
                    adMostAdmob1720FullScreenAdapter.onAmrReady();
                    return;
                }
                AdMostAdmob1720FullScreenAdapter adMostAdmob1720FullScreenAdapter2 = AdMostAdmob1720FullScreenAdapter.this;
                adMostAdmob1720FullScreenAdapter2.onAmrFail(adMostAdmob1720FullScreenAdapter2.mBannerResponseItem, "Ad is not loaded");
            }
        });
    }

    public void showInterstitial() {
        ((InterstitialAd) this.mAd1).show();
    }

    public void showVideo() {
        Object obj = this.mAd1;
        if (obj == null) {
            onAmrFailToShow(this.mBannerResponseItem, "ad is null");
        } else {
            ((RewardedAd) obj).show(AdMost.getInstance().getActivity(), new RewardedAdCallback() {
                public void onRewardedAdClosed() {
                    AdMostAdmob1720FullScreenAdapter.this.onAmrDismiss();
                }

                public void onRewardedAdFailedToShow(int i) {
                    AdMostAdmob1720FullScreenAdapter adMostAdmob1720FullScreenAdapter = AdMostAdmob1720FullScreenAdapter.this;
                    adMostAdmob1720FullScreenAdapter.onAmrFailToShow(adMostAdmob1720FullScreenAdapter.mBannerResponseItem, i, "onRewardedAdFailedToShow");
                }

                public void onRewardedAdOpened() {
                }

                public void onUserEarnedReward(RewardItem rewardItem) {
                    if (!AdMostAdmob1720FullScreenAdapter.this.onCompleteCallbackReturned) {
                        boolean unused = AdMostAdmob1720FullScreenAdapter.this.onCompleteCallbackReturned = true;
                        AdMostAdmob1720FullScreenAdapter.this.onAmrComplete();
                    }
                }
            });
        }
    }
}
