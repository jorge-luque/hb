package admost.sdk.networkadapter;

import admost.sdk.base.AdMost;
import admost.sdk.base.AdMostAdNetwork;
import admost.sdk.base.AdMostAdNetworkManager;
import admost.sdk.base.AdMostCloseOverviewActivity;
import admost.sdk.interfaces.AdMostFullScreenInterface;
import admost.sdk.listener.AdMostInitializationListener;
import admost.sdk.model.AdMostBannerResponseItem;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.google.android.gms.drive.DriveFile;
import java.util.Map;

public class AdMostApplovinFullScreenAdapter extends AdMostFullScreenInterface {
    public void destroyInterstitial() {
        Object obj = this.mAd1;
        if (obj != null) {
            ((AppLovinInterstitialAdDialog) obj).setAdClickListener((AppLovinAdClickListener) null);
            ((AppLovinInterstitialAdDialog) this.mAd1).setAdDisplayListener((AppLovinAdDisplayListener) null);
            ((AppLovinInterstitialAdDialog) this.mAd1).setAdLoadListener((AppLovinAdLoadListener) null);
            ((AppLovinInterstitialAdDialog) this.mAd1).setAdVideoPlaybackListener((AppLovinAdVideoPlaybackListener) null);
        }
    }

    public void loadInterstitial() {
        if (!AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.APPLOVIN).isInitAdNetworkCompletedSuccessfully) {
            AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.APPLOVIN).setInitListener(new AdMostInitializationListener() {
                public void onError(String str) {
                    AdMostApplovinFullScreenAdapter adMostApplovinFullScreenAdapter = AdMostApplovinFullScreenAdapter.this;
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostApplovinFullScreenAdapter.mBannerResponseItem;
                    adMostApplovinFullScreenAdapter.onAmrFail(adMostBannerResponseItem, "onError: " + str);
                }

                public void onInitialized() {
                    AdMostApplovinFullScreenAdapter.this.loadInterstitial();
                }
            });
            return;
        }
        final AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(AppLovinSdk.getInstance(AdMost.getInstance().getContext()), AdMost.getInstance().getContext());
        create.setAdDisplayListener(new AppLovinAdDisplayListener() {
            public void adDisplayed(AppLovinAd appLovinAd) {
            }

            public void adHidden(AppLovinAd appLovinAd) {
                AdMostApplovinFullScreenAdapter.this.onAmrDismiss();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        try {
                            if (AdMost.getInstance().getContext() != null) {
                                Intent intent = new Intent(AdMost.getInstance().getContext(), AdMostCloseOverviewActivity.class);
                                intent.setFlags(DriveFile.MODE_READ_ONLY);
                                AdMost.getInstance().getContext().startActivity(intent);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }, 300);
            }
        });
        create.setAdClickListener(new AppLovinAdClickListener() {
            public void adClicked(AppLovinAd appLovinAd) {
                AdMostApplovinFullScreenAdapter.this.onAmrClick();
            }
        });
        if (this.mBannerResponseItem.AdSpaceId.equals("empty")) {
            AppLovinSdk.getInstance(AdMost.getInstance().getContext()).getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, new AppLovinAdLoadListener() {
                public void adReceived(AppLovinAd appLovinAd) {
                    AdMostApplovinFullScreenAdapter adMostApplovinFullScreenAdapter = AdMostApplovinFullScreenAdapter.this;
                    adMostApplovinFullScreenAdapter.mAd1 = create;
                    adMostApplovinFullScreenAdapter.mAd2 = appLovinAd;
                    adMostApplovinFullScreenAdapter.onAmrReady();
                }

                public void failedToReceiveAd(int i) {
                    AdMostApplovinFullScreenAdapter adMostApplovinFullScreenAdapter = AdMostApplovinFullScreenAdapter.this;
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostApplovinFullScreenAdapter.mBannerResponseItem;
                    adMostApplovinFullScreenAdapter.onAmrFail(adMostBannerResponseItem, "failedToReceiveAd " + i);
                }
            });
        } else {
            AppLovinSdk.getInstance(AdMost.getInstance().getContext()).getAdService().loadNextAdForZoneId(this.mBannerResponseItem.AdSpaceId, new AppLovinAdLoadListener() {
                public void adReceived(AppLovinAd appLovinAd) {
                    AdMostApplovinFullScreenAdapter adMostApplovinFullScreenAdapter = AdMostApplovinFullScreenAdapter.this;
                    adMostApplovinFullScreenAdapter.mAd1 = create;
                    adMostApplovinFullScreenAdapter.mAd2 = appLovinAd;
                    adMostApplovinFullScreenAdapter.onAmrReady();
                }

                public void failedToReceiveAd(int i) {
                    AdMostApplovinFullScreenAdapter adMostApplovinFullScreenAdapter = AdMostApplovinFullScreenAdapter.this;
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostApplovinFullScreenAdapter.mBannerResponseItem;
                    adMostApplovinFullScreenAdapter.onAmrFail(adMostBannerResponseItem, "failedToReceiveAd: " + i);
                }
            });
        }
    }

    public void loadVideo() {
        if (!AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.APPLOVIN).isInitAdNetworkCompletedSuccessfully) {
            AdMostAdNetworkManager.getInstance().getInitAdapter(AdMostAdNetwork.APPLOVIN).setInitListener(new AdMostInitializationListener() {
                public void onError(String str) {
                    AdMostApplovinFullScreenAdapter adMostApplovinFullScreenAdapter = AdMostApplovinFullScreenAdapter.this;
                    AdMostBannerResponseItem adMostBannerResponseItem = adMostApplovinFullScreenAdapter.mBannerResponseItem;
                    adMostApplovinFullScreenAdapter.onAmrFail(adMostBannerResponseItem, "onError: " + str);
                }

                public void onInitialized() {
                    AdMostApplovinFullScreenAdapter.this.loadVideo();
                }
            });
            return;
        }
        final AppLovinIncentivizedInterstitial create = AppLovinIncentivizedInterstitial.create(this.mBannerResponseItem.AdSpaceId.equals("empty") ? null : this.mBannerResponseItem.AdSpaceId, AppLovinSdk.getInstance(AdMost.getInstance().getContext()));
        create.preload(new AppLovinAdLoadListener() {
            public void adReceived(AppLovinAd appLovinAd) {
                if (create.isAdReadyToDisplay()) {
                    AdMostApplovinFullScreenAdapter adMostApplovinFullScreenAdapter = AdMostApplovinFullScreenAdapter.this;
                    adMostApplovinFullScreenAdapter.mAd1 = create;
                    adMostApplovinFullScreenAdapter.onAmrReady();
                    return;
                }
                AdMostApplovinFullScreenAdapter adMostApplovinFullScreenAdapter2 = AdMostApplovinFullScreenAdapter.this;
                adMostApplovinFullScreenAdapter2.onAmrFail(adMostApplovinFullScreenAdapter2.mBannerResponseItem, "isAdReadyToDisplay false");
            }

            public void failedToReceiveAd(int i) {
                AdMostApplovinFullScreenAdapter adMostApplovinFullScreenAdapter = AdMostApplovinFullScreenAdapter.this;
                AdMostBannerResponseItem adMostBannerResponseItem = adMostApplovinFullScreenAdapter.mBannerResponseItem;
                adMostApplovinFullScreenAdapter.onAmrFail(adMostBannerResponseItem, "failedToReceiveAd: " + i);
            }
        });
    }

    public void showInterstitial() {
        ((AppLovinInterstitialAdDialog) this.mAd1).showAndRender((AppLovinAd) this.mAd2);
    }

    public void showVideo() {
        C02888 r2 = new AppLovinAdRewardListener() {
            public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
                AdMostApplovinFullScreenAdapter.this.onAmrDismiss();
            }

            public void userOverQuota(AppLovinAd appLovinAd, Map map) {
                AdMostApplovinFullScreenAdapter.this.onAmrDismiss();
            }

            public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
            }

            public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
            }

            public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
                AdMostApplovinFullScreenAdapter.this.onAmrDismiss();
            }
        };
        C02899 r4 = new AppLovinAdDisplayListener() {
            public void adDisplayed(AppLovinAd appLovinAd) {
            }

            public void adHidden(AppLovinAd appLovinAd) {
                AdMostApplovinFullScreenAdapter.this.onAmrDismiss();
            }
        };
        C027910 r5 = new AppLovinAdClickListener() {
            public void adClicked(AppLovinAd appLovinAd) {
                AdMostApplovinFullScreenAdapter.this.onAmrClick();
            }
        };
        C028011 r3 = new AppLovinAdVideoPlaybackListener() {
            public void videoPlaybackBegan(AppLovinAd appLovinAd) {
                AdMostApplovinInitAdapter.setUserIdNeedsToBeResent(false);
            }

            public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
                if (z) {
                    AdMostApplovinFullScreenAdapter.this.onAmrComplete();
                }
            }
        };
        String userId = AdMostApplovinInitAdapter.getUserId();
        AppLovinIncentivizedInterstitial appLovinIncentivizedInterstitial = (AppLovinIncentivizedInterstitial) this.mAd1;
        if (userId != null && !userId.equals("") && AdMostApplovinInitAdapter.isUserIdNeedsToBeResent()) {
            appLovinIncentivizedInterstitial.setUserIdentifier(userId);
        }
        appLovinIncentivizedInterstitial.show(AdMost.getInstance().getContext(), r2, r3, r4, r5);
    }
}
