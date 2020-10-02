package com.applovin.impl.mediation;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.p045b.C1697a;
import com.applovin.impl.mediation.p045b.C1698b;
import com.applovin.impl.mediation.p045b.C1699c;
import com.applovin.impl.mediation.p045b.C1701e;
import com.applovin.impl.mediation.p045b.C1702f;
import com.applovin.impl.mediation.p045b.C1704g;
import com.applovin.impl.mediation.p046c.C1717d;
import com.applovin.impl.mediation.p046c.C1724g;
import com.applovin.impl.mediation.p046c.C1725h;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C1994j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxErrorCodes;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MediationServiceImpl {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1941j f5109a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1977q f5110b;

    /* renamed from: com.applovin.impl.mediation.MediationServiceImpl$a */
    private class C1641a implements C1726d {

        /* renamed from: b */
        private final C1697a f5120b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public MaxAdListener f5121c;

        private C1641a(C1697a aVar, MaxAdListener maxAdListener) {
            this.f5120b = aVar;
            this.f5121c = maxAdListener;
        }

        /* renamed from: a */
        public void mo7609a(MaxAd maxAd, C1732e eVar) {
            MediationServiceImpl.this.m6259b(this.f5120b, eVar, this.f5121c);
            if (maxAd.getFormat() == MaxAdFormat.REWARDED && (maxAd instanceof C1699c)) {
                ((C1699c) maxAd).mo7805v();
            }
        }

        /* renamed from: a */
        public void mo7610a(MaxAdListener maxAdListener) {
            this.f5121c = maxAdListener;
        }

        /* renamed from: a */
        public void mo7611a(String str, C1732e eVar) {
            this.f5120b.mo7776i();
            MediationServiceImpl.this.m6249a(this.f5120b, eVar, this.f5121c);
        }

        public void onAdClicked(MaxAd maxAd) {
            MediationServiceImpl.this.f5109a.mo8567ac().mo8505a((C1697a) maxAd, "DID_CLICKED");
            MediationServiceImpl.this.m6260c(this.f5120b);
            C1994j.m7930d(this.f5121c, maxAd);
        }

        public void onAdCollapsed(MaxAd maxAd) {
            C1994j.m7934h(this.f5121c, maxAd);
        }

        public void onAdDisplayFailed(MaxAd maxAd, int i) {
            MediationServiceImpl.this.m6259b(this.f5120b, new C1732e(i), this.f5121c);
        }

        public void onAdDisplayed(MaxAd maxAd) {
            MediationServiceImpl.this.f5110b.mo8742b("MediationService", "Scheduling impression for ad via callback...");
            MediationServiceImpl.this.maybeScheduleCallbackAdImpressionPostback(this.f5120b);
            if (maxAd.getFormat() == MaxAdFormat.INTERSTITIAL || maxAd.getFormat() == MaxAdFormat.REWARDED) {
                MediationServiceImpl.this.f5109a.mo8547Z().mo8731a((Object) maxAd);
            }
            C1994j.m7924b(this.f5121c, maxAd);
        }

        public void onAdExpanded(MaxAd maxAd) {
            C1994j.m7933g(this.f5121c, maxAd);
        }

        public void onAdHidden(final MaxAd maxAd) {
            MediationServiceImpl.this.f5109a.mo8567ac().mo8505a((C1697a) maxAd, "DID_HIDE");
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    if (maxAd.getFormat() == MaxAdFormat.INTERSTITIAL || maxAd.getFormat() == MaxAdFormat.REWARDED) {
                        MediationServiceImpl.this.f5109a.mo8547Z().mo8734b((Object) maxAd);
                    }
                    C1994j.m7928c(C1641a.this.f5121c, maxAd);
                }
            }, maxAd instanceof C1699c ? ((C1699c) maxAd).mo7801r() : 0);
        }

        public void onAdLoadFailed(String str, int i) {
            this.f5120b.mo7776i();
            MediationServiceImpl.this.m6249a(this.f5120b, new C1732e(i), this.f5121c);
        }

        public void onAdLoaded(MaxAd maxAd) {
            this.f5120b.mo7776i();
            MediationServiceImpl.this.m6258b(this.f5120b);
            C1994j.m7909a(this.f5121c, maxAd);
        }

        public void onRewardedVideoCompleted(MaxAd maxAd) {
            C1994j.m7932f(this.f5121c, maxAd);
        }

        public void onRewardedVideoStarted(MaxAd maxAd) {
            C1994j.m7931e(this.f5121c, maxAd);
        }

        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            C1994j.m7911a(this.f5121c, maxAd, maxReward);
            MediationServiceImpl.this.f5109a.mo8533L().mo8475a((C1864a) new C1724g((C1699c) maxAd, MediationServiceImpl.this.f5109a), C1907s.C1909a.MEDIATION_REWARD);
        }
    }

    public MediationServiceImpl(C1941j jVar) {
        this.f5109a = jVar;
        this.f5110b = jVar.mo8602v();
    }

    /* renamed from: a */
    private void m6248a(C1697a aVar) {
        C1977q qVar = this.f5110b;
        qVar.mo8742b("MediationService", "Firing ad preload postback for " + aVar.mo7813E());
        m6251a("mpreload", (C1701e) aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6249a(C1697a aVar, C1732e eVar, MaxAdListener maxAdListener) {
        m6250a(eVar, aVar);
        destroyAd(aVar);
        C1994j.m7912a(maxAdListener, aVar.getAdUnitId(), eVar.getErrorCode());
    }

    /* renamed from: a */
    private void m6250a(C1732e eVar, C1697a aVar) {
        long f = aVar.mo7770f();
        C1977q qVar = this.f5110b;
        qVar.mo8742b("MediationService", "Firing ad load failure postback with load time: " + f);
        HashMap hashMap = new HashMap(1);
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(f));
        m6254a("mlerr", (Map<String, String>) hashMap, eVar, (C1701e) aVar);
    }

    /* renamed from: a */
    private void m6251a(String str, C1701e eVar) {
        m6254a(str, (Map<String, String>) Collections.EMPTY_MAP, (C1732e) null, eVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6252a(String str, C1704g gVar) {
        m6254a("serr", (Map<String, String>) Collections.EMPTY_MAP, new C1732e(str), (C1701e) gVar);
    }

    /* renamed from: a */
    private void m6253a(String str, Map<String, String> map, C1701e eVar) {
        m6254a(str, map, (C1732e) null, eVar);
    }

    /* renamed from: a */
    private void m6254a(String str, Map<String, String> map, C1732e eVar, C1701e eVar2) {
        HashMap hashMap = new HashMap(map);
        hashMap.put("{PLACEMENT}", eVar2.mo7820L() != null ? eVar2.mo7820L() : "");
        this.f5109a.mo8533L().mo8475a((C1864a) new C1717d(str, hashMap, eVar, eVar2, this.f5109a), C1907s.C1909a.MEDIATION_POSTBACKS);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6258b(C1697a aVar) {
        long f = aVar.mo7770f();
        C1977q qVar = this.f5110b;
        qVar.mo8742b("MediationService", "Firing ad load success postback with load time: " + f);
        HashMap hashMap = new HashMap(1);
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(f));
        m6253a("load", (Map<String, String>) hashMap, (C1701e) aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6259b(C1697a aVar, C1732e eVar, MaxAdListener maxAdListener) {
        this.f5109a.mo8567ac().mo8505a(aVar, "DID_FAIL_DISPLAY");
        maybeScheduleAdDisplayErrorPostback(eVar, aVar);
        if (aVar.mo7777j().compareAndSet(false, true)) {
            C1994j.m7910a(maxAdListener, (MaxAd) aVar, eVar.getErrorCode());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6260c(C1697a aVar) {
        m6251a("mclick", (C1701e) aVar);
    }

    public void collectSignal(MaxAdFormat maxAdFormat, final C1704g gVar, Activity activity, final C1702f.C1703a aVar) {
        String str;
        C1977q qVar;
        String str2;
        StringBuilder sb;
        if (gVar == null) {
            throw new IllegalArgumentException("No spec specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (aVar != null) {
            final C1743j a = this.f5109a.mo8603w().mo7893a((C1701e) gVar);
            if (a != null) {
                MaxAdapterParametersImpl a2 = MaxAdapterParametersImpl.m6243a(gVar, maxAdFormat, activity.getApplicationContext());
                a.mo7898a((MaxAdapterInitializationParameters) a2, activity);
                C16402 r1 = new MaxSignalCollectionListener() {
                    public void onSignalCollected(String str) {
                        aVar.mo7848a(C1702f.m6519a(gVar, a, str));
                    }

                    public void onSignalCollectionFailed(String str) {
                        MediationServiceImpl.this.m6252a(str, gVar);
                        aVar.mo7848a(C1702f.m6521b(gVar, a, str));
                    }
                };
                if (!gVar.mo7849b()) {
                    qVar = this.f5110b;
                    sb = new StringBuilder();
                    str2 = "Collecting signal for adapter: ";
                } else if (this.f5109a.mo8604x().mo7890a((C1701e) gVar)) {
                    qVar = this.f5110b;
                    sb = new StringBuilder();
                    str2 = "Collecting signal for now-initialized adapter: ";
                } else {
                    C1977q qVar2 = this.f5110b;
                    qVar2.mo8746e("MediationService", "Skip collecting signal for not-initialized adapter: " + a.mo7902b());
                    str = "Adapter not initialized yet";
                }
                sb.append(str2);
                sb.append(a.mo7902b());
                qVar.mo8742b("MediationService", sb.toString());
                a.mo7899a(a2, gVar, activity, r1);
                return;
            }
            str = "Could not load adapter";
            aVar.mo7848a(C1702f.m6520a(gVar, str));
        } else {
            throw new IllegalArgumentException("No callback specified");
        }
    }

    public void destroyAd(MaxAd maxAd) {
        if (maxAd instanceof C1697a) {
            C1977q qVar = this.f5110b;
            qVar.mo8744c("MediationService", "Destroying " + maxAd);
            C1697a aVar = (C1697a) maxAd;
            C1743j c = aVar.mo7767c();
            if (c != null) {
                c.mo7908h();
                aVar.mo7778k();
            }
        }
    }

    public void loadAd(String str, MaxAdFormat maxAdFormat, C1733f fVar, Activity activity, MaxAdListener maxAdListener) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (maxAdListener != null) {
            if (!this.f5109a.mo8583d()) {
                C1977q.m7750h("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
            }
            this.f5109a.mo8552a();
            this.f5109a.mo8525C().mo7884a(str, maxAdFormat, fVar, activity, maxAdListener);
        } else {
            throw new IllegalArgumentException("No listener specified");
        }
    }

    public void loadThirdPartyMediatedAd(String str, C1697a aVar, Activity activity, MaxAdListener maxAdListener) {
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (activity != null) {
            C1977q qVar = this.f5110b;
            qVar.mo8742b("MediationService", "Loading " + aVar + "...");
            this.f5109a.mo8567ac().mo8505a(aVar, "WILL_LOAD");
            m6248a(aVar);
            C1743j a = this.f5109a.mo8603w().mo7893a((C1701e) aVar);
            if (a != null) {
                MaxAdapterParametersImpl a2 = MaxAdapterParametersImpl.m6241a(aVar, activity.getApplicationContext());
                a.mo7898a((MaxAdapterInitializationParameters) a2, activity);
                C1697a a3 = aVar.mo7764a(a);
                a.mo7900a(str, a3);
                a3.mo7771g();
                a.mo7901a(str, a2, a3, activity, new C1641a(a3, maxAdListener));
                return;
            }
            C1977q qVar2 = this.f5110b;
            qVar2.mo8745d("MediationService", "Failed to load " + aVar + ": adapter not loaded");
            m6249a(aVar, new C1732e((int) MaxErrorCodes.MEDIATION_ADAPTER_LOAD_FAILED), maxAdListener);
        } else {
            throw new IllegalArgumentException("A valid Activity is required");
        }
    }

    public void maybeScheduleAdDisplayErrorPostback(C1732e eVar, C1697a aVar) {
        m6254a("mierr", (Map<String, String>) Collections.EMPTY_MAP, eVar, (C1701e) aVar);
    }

    public void maybeScheduleAdapterInitializationPostback(C1701e eVar, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("{INIT_STATUS}", String.valueOf(initializationStatus.getCode()));
        hashMap.put("{INIT_TIME_MS}", String.valueOf(j));
        m6254a("minit", (Map<String, String>) hashMap, new C1732e(str), eVar);
    }

    public void maybeScheduleCallbackAdImpressionPostback(C1697a aVar) {
        m6251a("mcimp", (C1701e) aVar);
    }

    public void maybeScheduleRawAdImpressionPostback(C1697a aVar) {
        this.f5109a.mo8567ac().mo8505a(aVar, "WILL_DISPLAY");
        HashMap hashMap = new HashMap(1);
        if (aVar instanceof C1699c) {
            hashMap.put("{TIME_TO_SHOW_MS}", String.valueOf(((C1699c) aVar).mo7799p()));
        }
        m6253a("mimp", (Map<String, String>) hashMap, (C1701e) aVar);
    }

    public void maybeScheduleViewabilityAdImpressionPostback(C1698b bVar, long j) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("{VIEWABILITY_FLAGS}", String.valueOf(j));
        hashMap.put("{USED_VIEWABILITY_TIMER}", String.valueOf(bVar.mo7788t()));
        m6253a("mvimp", (Map<String, String>) hashMap, (C1701e) bVar);
    }

    public void showFullscreenAd(MaxAd maxAd, String str, final Activity activity) {
        if (maxAd == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (maxAd instanceof C1699c) {
            this.f5109a.mo8547Z().mo8732a(true);
            final C1699c cVar = (C1699c) maxAd;
            final C1743j c = cVar.mo7767c();
            if (c != null) {
                cVar.mo7837c(str);
                long q = cVar.mo7800q();
                C1977q qVar = this.f5110b;
                qVar.mo8744c("MediationService", "Showing ad " + maxAd.getAdUnitId() + " with delay of " + q + "ms...");
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                    public void run() {
                        if (cVar.getFormat() == MaxAdFormat.REWARDED) {
                            MediationServiceImpl.this.f5109a.mo8533L().mo8475a((C1864a) new C1725h(cVar, MediationServiceImpl.this.f5109a), C1907s.C1909a.MEDIATION_REWARD);
                        }
                        c.mo7897a((C1697a) cVar, activity);
                        MediationServiceImpl.this.f5109a.mo8547Z().mo8732a(false);
                        MediationServiceImpl.this.f5110b.mo8742b("MediationService", "Scheduling impression for ad manually...");
                        MediationServiceImpl.this.maybeScheduleRawAdImpressionPostback(cVar);
                    }
                }, q);
                return;
            }
            this.f5109a.mo8547Z().mo8732a(false);
            C1977q qVar2 = this.f5110b;
            qVar2.mo8745d("MediationService", "Failed to show " + maxAd + ": adapter not found");
            C1977q.m7751i("MediationService", "There may be an integration problem with the adapter for ad unit id '" + cVar.getAdUnitId() + "'. Please check if you have a supported version of that SDK integrated into your project.");
            throw new IllegalStateException("Could not find adapter for provided ad");
        } else {
            C1977q.m7751i("MediationService", "Unable to show ad for '" + maxAd.getAdUnitId() + "': only REWARDED or INTERSTITIAL ads are eligible for showFullscreenAd(). " + maxAd.getFormat() + " ad was provided.");
            throw new IllegalArgumentException("Provided ad is not a MediatedFullscreenAd");
        }
    }
}
