package com.applovin.impl.sdk.utils;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1834i;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.utils.j */
public class C1994j {
    /* renamed from: a */
    public static void m7908a(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdViewEventListener.adOpenedFullscreen(C1994j.m7922b(appLovinAd), appLovinAdView);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen opened event", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m7909a(final MaxAdListener maxAdListener, final MaxAd maxAd) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdLoaded(maxAd);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being loaded", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m7910a(final MaxAdListener maxAdListener, final MaxAd maxAd, final int i) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdDisplayFailed(maxAd, i);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad failing to display", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m7911a(final MaxAdListener maxAdListener, final MaxAd maxAd, final MaxReward maxReward) {
        if (maxAd != null && (maxAdListener instanceof MaxRewardedAdListener)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        ((MaxRewardedAdListener) maxAdListener).onUserRewarded(maxAd, maxReward);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about user being rewarded", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m7912a(final MaxAdListener maxAdListener, final String str, final int i) {
        if (str != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdLoadFailed(str, i);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad failing to load", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m7913a(final AppLovinAdClickListener appLovinAdClickListener, final AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdClickListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdClickListener.adClicked(C1994j.m7922b(appLovinAd));
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m7914a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdDisplayListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdDisplayListener.adDisplayed(C1994j.m7922b(appLovinAd));
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m7915a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final String str) {
        if (appLovinAdDisplayListener instanceof C1834i) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    ((C1834i) appLovinAdDisplayListener).onAdDisplayFailed(str);
                }
            });
        }
    }

    /* renamed from: a */
    public static void m7916a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final int i) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdRewardListener.validationRequestFailed(C1994j.m7922b(appLovinAd), i);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request failing", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m7917a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdRewardListener.userRewardVerified(C1994j.m7922b(appLovinAd), map);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad reward listener about successful reward validation request", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m7918a(final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, final AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdVideoPlaybackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdVideoPlaybackListener.videoPlaybackBegan(C1994j.m7922b(appLovinAd));
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback began", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m7919a(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd, double d, boolean z) {
        if (appLovinAd != null && appLovinAdVideoPlaybackListener != null) {
            final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener2 = appLovinAdVideoPlaybackListener;
            final AppLovinAd appLovinAd2 = appLovinAd;
            final double d2 = d;
            final boolean z2 = z;
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdVideoPlaybackListener2.videoPlaybackEnded(C1994j.m7922b(appLovinAd2), d2, z2);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback ended", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m7920a(final AppLovinPostbackListener appLovinPostbackListener, final String str) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinPostbackListener.onPostbackSuccess(str);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify AppLovinPostbackListener about postback URL (" + str + ") executed", th);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static void m7921a(final AppLovinPostbackListener appLovinPostbackListener, final String str, final int i) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinPostbackListener.onPostbackFailure(str, i);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify AppLovinPostbackListener about postback URL (" + str + ") failing to execute with error code (" + i + "):", th);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static AppLovinAd m7922b(AppLovinAd appLovinAd) {
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) appLovinAd;
        return appLovinAdBase.getDummyAd() != null ? appLovinAdBase.getDummyAd() : appLovinAd;
    }

    /* renamed from: b */
    public static void m7923b(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdViewEventListener.adClosedFullscreen(C1994j.m7922b(appLovinAd), appLovinAdView);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen closed event", th);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public static void m7924b(final MaxAdListener maxAdListener, final MaxAd maxAd) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdDisplayed(maxAd);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", th);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public static void m7925b(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdDisplayListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdDisplayListener.adHidden(C1994j.m7922b(appLovinAd));
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", th);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public static void m7926b(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdRewardListener.userOverQuota(C1994j.m7922b(appLovinAd), map);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad reward listener about exceeding quota", th);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    public static void m7927c(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdViewEventListener.adLeftApplication(C1994j.m7922b(appLovinAd), appLovinAdView);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about application leave event", th);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    public static void m7928c(final MaxAdListener maxAdListener, final MaxAd maxAd) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdHidden(maxAd);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", th);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    public static void m7929c(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map<String, String> map) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        appLovinAdRewardListener.userRewardRejected(C1994j.m7922b(appLovinAd), map);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request being rejected", th);
                    }
                }
            });
        }
    }

    /* renamed from: d */
    public static void m7930d(final MaxAdListener maxAdListener, final MaxAd maxAd) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        maxAdListener.onAdClicked(maxAd);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", th);
                    }
                }
            });
        }
    }

    /* renamed from: e */
    public static void m7931e(final MaxAdListener maxAdListener, final MaxAd maxAd) {
        if (maxAd != null && (maxAdListener instanceof MaxRewardedAdListener)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        ((MaxRewardedAdListener) maxAdListener).onRewardedVideoStarted(maxAd);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about rewarded video starting", th);
                    }
                }
            });
        }
    }

    /* renamed from: f */
    public static void m7932f(final MaxAdListener maxAdListener, final MaxAd maxAd) {
        if (maxAd != null && (maxAdListener instanceof MaxRewardedAdListener)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        ((MaxRewardedAdListener) maxAdListener).onRewardedVideoCompleted(maxAd);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about rewarded video completing", th);
                    }
                }
            });
        }
    }

    /* renamed from: g */
    public static void m7933g(final MaxAdListener maxAdListener, final MaxAd maxAd) {
        if (maxAd != null && (maxAdListener instanceof MaxAdViewAdListener)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        ((MaxAdViewAdListener) maxAdListener).onAdExpanded(maxAd);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being expanded", th);
                    }
                }
            });
        }
    }

    /* renamed from: h */
    public static void m7934h(final MaxAdListener maxAdListener, final MaxAd maxAd) {
        if (maxAd != null && (maxAdListener instanceof MaxAdViewAdListener)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        ((MaxAdViewAdListener) maxAdListener).onAdCollapsed(maxAd);
                    } catch (Throwable th) {
                        C1977q.m7747c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being collapsed", th);
                    }
                }
            });
        }
    }
}
