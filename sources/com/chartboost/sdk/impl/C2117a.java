package com.chartboost.sdk.impl;

import admost.sdk.AdMostInterstitial;
import com.chartboost.sdk.C2099a;
import com.chartboost.sdk.C2242k;
import com.chartboost.sdk.Events.C2070b;
import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Events.ChartboostShowError;
import com.chartboost.sdk.Model.CBError;
import com.facebook.internal.AnalyticsEvents;

/* renamed from: com.chartboost.sdk.impl.a */
public class C2117a {

    /* renamed from: a */
    public final int f7101a;

    /* renamed from: b */
    public final String f7102b;

    /* renamed from: c */
    public final String f7103c;

    /* renamed from: d */
    public final String f7104d;

    /* renamed from: e */
    public final String f7105e;

    /* renamed from: f */
    public final String f7106f;

    /* renamed from: g */
    public final boolean f7107g;

    /* renamed from: h */
    public final boolean f7108h;

    /* renamed from: com.chartboost.sdk.impl.a$a */
    public class C2118a implements Runnable {

        /* renamed from: a */
        private final int f7109a;

        /* renamed from: b */
        private final String f7110b;

        /* renamed from: c */
        private final CBError.CBImpressionError f7111c;

        /* renamed from: d */
        private final C2070b f7112d;

        public C2118a(int i, String str, CBError.CBImpressionError cBImpressionError, C2070b bVar) {
            this.f7109a = i;
            this.f7110b = str;
            this.f7111c = cBImpressionError;
            this.f7112d = bVar;
        }

        public void run() {
            switch (this.f7109a) {
                case 0:
                    C2117a.this.mo9268a(this.f7110b);
                    return;
                case 1:
                    C2117a.this.mo9272b(this.f7110b);
                    return;
                case 2:
                    C2117a.this.mo9273c(this.f7110b);
                    return;
                case 3:
                    C2117a.this.mo9274d(this.f7110b);
                    return;
                case 4:
                    C2117a.this.mo9271a(this.f7110b, this.f7111c);
                    return;
                case 5:
                    C2117a.this.mo9275e(this.f7110b);
                    return;
                case 6:
                    C2117a.this.mo9269a(this.f7110b, (ChartboostCacheError) this.f7112d);
                    return;
                case 7:
                    C2117a.this.mo9270a(this.f7110b, (ChartboostShowError) this.f7112d);
                    return;
                default:
                    return;
            }
        }
    }

    protected C2117a(int i, String str, String str2, String str3, String str4, String str5, boolean z, boolean z2) {
        this.f7101a = i;
        this.f7102b = str;
        this.f7103c = str2;
        this.f7104d = str3;
        this.f7105e = str4;
        this.f7106f = str5;
        this.f7107g = z;
        this.f7108h = z2;
    }

    /* renamed from: a */
    public static C2117a m8409a() {
        return new C2117a(2, "inplay", (String) null, "/inplay/get", "no webview endpoint", "/inplay/show", false, true);
    }

    /* renamed from: b */
    public static C2117a m8410b() {
        return new C2117a(0, AdMostInterstitial.ZONE_TYPE_INTERSTITIAL, AdMostInterstitial.ZONE_TYPE_INTERSTITIAL, "/interstitial/get", "webview/%s/interstitial/get", "/interstitial/show", false, false);
    }

    /* renamed from: c */
    public static C2117a m8411c() {
        return new C2117a(1, AdMostInterstitial.ZONE_TYPE_REWARDED, "rewarded-video", "/reward/get", "webview/%s/reward/get", "/reward/show", true, false);
    }

    /* renamed from: a */
    public void mo9269a(String str, ChartboostCacheError chartboostCacheError) {
    }

    /* renamed from: a */
    public void mo9270a(String str, ChartboostShowError chartboostShowError) {
    }

    /* renamed from: d */
    public void mo9274d(String str) {
        C2099a aVar = C2242k.f7604d;
        if (aVar != null) {
            int i = this.f7101a;
            if (i == 0) {
                aVar.didDismissInterstitial(str);
            } else if (i == 1) {
                aVar.didDismissRewardedVideo(str);
            }
        }
    }

    /* renamed from: e */
    public void mo9275e(String str) {
        C2099a aVar = C2242k.f7604d;
        if (aVar != null) {
            int i = this.f7101a;
            if (i == 0) {
                aVar.didDisplayInterstitial(str);
            } else if (i == 1) {
                aVar.didDisplayRewardedVideo(str);
            }
        }
    }

    /* renamed from: f */
    public boolean mo9276f(String str) {
        C2099a aVar = C2242k.f7604d;
        if (aVar == null) {
            return true;
        }
        int i = this.f7101a;
        if (i == 0) {
            return aVar.shouldDisplayInterstitial(str);
        }
        if (i != 1) {
            return true;
        }
        return aVar.shouldDisplayRewardedVideo(str);
    }

    /* renamed from: g */
    public boolean mo9277g(String str) {
        C2099a aVar = C2242k.f7604d;
        if (aVar == null || this.f7101a != 0) {
            return true;
        }
        return aVar.shouldRequestInterstitial(str);
    }

    /* renamed from: a */
    public String mo9267a(int i) {
        Object[] objArr = new Object[2];
        objArr[0] = this.f7103c;
        objArr[1] = i == 1 ? AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB : "native";
        return String.format("%s-%s", objArr);
    }

    /* renamed from: b */
    public void mo9272b(String str) {
        C2099a aVar = C2242k.f7604d;
        if (aVar != null) {
            int i = this.f7101a;
            if (i == 0) {
                aVar.didClickInterstitial(str);
            } else if (i == 1) {
                aVar.didClickRewardedVideo(str);
            }
        }
    }

    /* renamed from: c */
    public void mo9273c(String str) {
        C2099a aVar = C2242k.f7604d;
        if (aVar != null) {
            int i = this.f7101a;
            if (i == 0) {
                aVar.didCloseInterstitial(str);
            } else if (i == 1) {
                aVar.didCloseRewardedVideo(str);
            }
        }
    }

    /* renamed from: a */
    public void mo9268a(String str) {
        C2099a aVar = C2242k.f7604d;
        if (aVar != null) {
            int i = this.f7101a;
            if (i == 0) {
                aVar.didCacheInterstitial(str);
            } else if (i == 1) {
                aVar.didCacheRewardedVideo(str);
            } else if (i == 2) {
                aVar.didCacheInPlay(str);
            }
        }
    }

    /* renamed from: a */
    public void mo9271a(String str, CBError.CBImpressionError cBImpressionError) {
        C2099a aVar = C2242k.f7604d;
        if (aVar != null) {
            int i = this.f7101a;
            if (i == 0) {
                aVar.didFailToLoadInterstitial(str, cBImpressionError);
            } else if (i == 1) {
                aVar.didFailToLoadRewardedVideo(str, cBImpressionError);
            } else if (i == 2) {
                aVar.didFailToLoadInPlay(str, cBImpressionError);
            }
        }
    }
}
