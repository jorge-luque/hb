package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import com.applovin.impl.mediation.p045b.C1697a;
import com.applovin.impl.mediation.p045b.C1701e;
import com.applovin.impl.mediation.p045b.C1704g;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.mediation.j */
public class C1743j {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Handler f5410a = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1941j f5411b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1977q f5412c;

    /* renamed from: d */
    private final String f5413d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C1701e f5414e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final String f5415f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MaxAdapter f5416g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f5417h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C1697a f5418i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f5419j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final C1759a f5420k = new C1759a();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public MaxAdapterResponseParameters f5421l;

    /* renamed from: m */
    private final AtomicBoolean f5422m = new AtomicBoolean(true);
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final AtomicBoolean f5423n = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final AtomicBoolean f5424o = new AtomicBoolean(false);

    /* renamed from: com.applovin.impl.mediation.j$a */
    private class C1759a implements MaxAdViewAdapterListener, MaxInterstitialAdapterListener, MaxRewardedAdapterListener {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public C1726d f5466b;

        private C1759a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m6701a(C1726d dVar) {
            if (dVar != null) {
                this.f5466b = dVar;
                return;
            }
            throw new IllegalArgumentException("No listener specified");
        }

        /* renamed from: a */
        private void m6704a(String str) {
            C1743j.this.f5424o.set(true);
            m6706a(str, (MaxAdListener) this.f5466b, (Runnable) new Runnable() {
                public void run() {
                    if (C1743j.this.f5423n.compareAndSet(false, true)) {
                        C1759a.this.f5466b.onAdLoaded(C1743j.this.f5418i);
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m6705a(String str, int i) {
            m6707a(str, new MaxAdapterError(i));
        }

        /* renamed from: a */
        private void m6706a(final String str, final MaxAdListener maxAdListener, final Runnable runnable) {
            C1743j.this.f5410a.post(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        MaxAdListener maxAdListener = maxAdListener;
                        String name = maxAdListener != null ? maxAdListener.getClass().getName() : null;
                        C1977q e2 = C1743j.this.f5412c;
                        e2.mo8743b("MediationAdapterWrapper", "Failed to forward call (" + str + ") to " + name, e);
                    }
                }
            });
        }

        /* renamed from: a */
        private void m6707a(String str, final MaxAdapterError maxAdapterError) {
            m6706a(str, (MaxAdListener) this.f5466b, (Runnable) new Runnable() {
                public void run() {
                    if (C1743j.this.f5423n.compareAndSet(false, true)) {
                        C1759a.this.f5466b.mo7611a(C1743j.this.f5417h, (C1732e) maxAdapterError);
                    }
                }
            });
        }

        /* renamed from: b */
        private void m6709b(String str) {
            if (C1743j.this.f5418i.mo7777j().compareAndSet(false, true)) {
                m6706a(str, (MaxAdListener) this.f5466b, (Runnable) new Runnable() {
                    public void run() {
                        C1759a.this.f5466b.onAdDisplayed(C1743j.this.f5418i);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m6710b(String str, int i) {
            m6711b(str, new MaxAdapterError(i));
        }

        /* renamed from: b */
        private void m6711b(String str, final MaxAdapterError maxAdapterError) {
            m6706a(str, (MaxAdListener) this.f5466b, (Runnable) new Runnable() {
                public void run() {
                    C1759a.this.f5466b.mo7609a((MaxAd) C1743j.this.f5418i, (C1732e) maxAdapterError);
                }
            });
        }

        public void onAdViewAdClicked() {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": adview ad clicked");
            m6706a("onAdViewAdClicked", (MaxAdListener) this.f5466b, (Runnable) new Runnable() {
                public void run() {
                    C1759a.this.f5466b.onAdClicked(C1743j.this.f5418i);
                }
            });
        }

        public void onAdViewAdCollapsed() {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": adview ad collapsed");
            m6706a("onAdViewAdCollapsed", (MaxAdListener) this.f5466b, (Runnable) new Runnable() {
                public void run() {
                    C1759a.this.f5466b.onAdCollapsed(C1743j.this.f5418i);
                }
            });
        }

        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1977q e = C1743j.this.f5412c;
            e.mo8745d("MediationAdapterWrapper", C1743j.this.f5415f + ": adview ad failed to display with code: " + maxAdapterError);
            m6711b("onAdViewAdDisplayFailed", maxAdapterError);
        }

        public void onAdViewAdDisplayed() {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": adview ad displayed");
            m6709b("onAdViewAdDisplayed");
        }

        public void onAdViewAdExpanded() {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": adview ad expanded");
            m6706a("onAdViewAdExpanded", (MaxAdListener) this.f5466b, (Runnable) new Runnable() {
                public void run() {
                    C1759a.this.f5466b.onAdExpanded(C1743j.this.f5418i);
                }
            });
        }

        public void onAdViewAdHidden() {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": adview ad hidden");
            m6706a("onAdViewAdHidden", (MaxAdListener) this.f5466b, (Runnable) new Runnable() {
                public void run() {
                    C1759a.this.f5466b.onAdHidden(C1743j.this.f5418i);
                }
            });
        }

        public void onAdViewAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1977q e = C1743j.this.f5412c;
            e.mo8745d("MediationAdapterWrapper", C1743j.this.f5415f + ": adview ad ad failed to load with code: " + maxAdapterError);
            m6707a("onAdViewAdLoadFailed", maxAdapterError);
        }

        public void onAdViewAdLoaded(View view) {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": adview ad loaded");
            View unused = C1743j.this.f5419j = view;
            m6704a("onAdViewAdLoaded");
        }

        public void onInterstitialAdClicked() {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": interstitial ad clicked");
            m6706a("onInterstitialAdClicked", (MaxAdListener) this.f5466b, (Runnable) new Runnable() {
                public void run() {
                    C1759a.this.f5466b.onAdClicked(C1743j.this.f5418i);
                }
            });
        }

        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1977q e = C1743j.this.f5412c;
            e.mo8745d("MediationAdapterWrapper", C1743j.this.f5415f + ": interstitial ad failed to display with code " + maxAdapterError);
            m6711b("onInterstitialAdDisplayFailed", maxAdapterError);
        }

        public void onInterstitialAdDisplayed() {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": interstitial ad displayed");
            m6709b("onInterstitialAdDisplayed");
        }

        public void onInterstitialAdHidden() {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": interstitial ad hidden");
            m6706a("onInterstitialAdHidden", (MaxAdListener) this.f5466b, (Runnable) new Runnable() {
                public void run() {
                    C1759a.this.f5466b.onAdHidden(C1743j.this.f5418i);
                }
            });
        }

        public void onInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1977q e = C1743j.this.f5412c;
            e.mo8745d("MediationAdapterWrapper", C1743j.this.f5415f + ": interstitial ad failed to load with error " + maxAdapterError);
            m6707a("onInterstitialAdLoadFailed", maxAdapterError);
        }

        public void onInterstitialAdLoaded() {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": interstitial ad loaded");
            m6704a("onInterstitialAdLoaded");
        }

        public void onRewardedAdClicked() {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": rewarded ad clicked");
            m6706a("onRewardedAdClicked", (MaxAdListener) this.f5466b, (Runnable) new Runnable() {
                public void run() {
                    C1759a.this.f5466b.onAdClicked(C1743j.this.f5418i);
                }
            });
        }

        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError) {
            C1977q e = C1743j.this.f5412c;
            e.mo8745d("MediationAdapterWrapper", C1743j.this.f5415f + ": rewarded ad display failed with error: " + maxAdapterError);
            m6711b("onRewardedAdDisplayFailed", maxAdapterError);
        }

        public void onRewardedAdDisplayed() {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": rewarded ad displayed");
            m6709b("onRewardedAdDisplayed");
        }

        public void onRewardedAdHidden() {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": rewarded ad hidden");
            m6706a("onRewardedAdHidden", (MaxAdListener) this.f5466b, (Runnable) new Runnable() {
                public void run() {
                    C1759a.this.f5466b.onAdHidden(C1743j.this.f5418i);
                }
            });
        }

        public void onRewardedAdLoadFailed(MaxAdapterError maxAdapterError) {
            C1977q e = C1743j.this.f5412c;
            e.mo8745d("MediationAdapterWrapper", C1743j.this.f5415f + ": rewarded ad failed to load with code: " + maxAdapterError);
            m6707a("onRewardedAdLoadFailed", maxAdapterError);
        }

        public void onRewardedAdLoaded() {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": rewarded ad loaded");
            m6704a("onRewardedAdLoaded");
        }

        public void onRewardedAdVideoCompleted() {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": rewarded video completed");
            m6706a("onRewardedAdVideoCompleted", (MaxAdListener) this.f5466b, (Runnable) new Runnable() {
                public void run() {
                    C1759a.this.f5466b.onRewardedVideoCompleted(C1743j.this.f5418i);
                }
            });
        }

        public void onRewardedAdVideoStarted() {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": rewarded video started");
            m6706a("onRewardedAdVideoStarted", (MaxAdListener) this.f5466b, (Runnable) new Runnable() {
                public void run() {
                    C1759a.this.f5466b.onRewardedVideoStarted(C1743j.this.f5418i);
                }
            });
        }

        public void onUserRewarded(final MaxReward maxReward) {
            C1977q e = C1743j.this.f5412c;
            e.mo8744c("MediationAdapterWrapper", C1743j.this.f5415f + ": user was rewarded: " + maxReward);
            m6706a("onUserRewarded", (MaxAdListener) this.f5466b, (Runnable) new Runnable() {
                public void run() {
                    C1759a.this.f5466b.onUserRewarded(C1743j.this.f5418i, maxReward);
                }
            });
        }
    }

    /* renamed from: com.applovin.impl.mediation.j$b */
    private static class C1776b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final C1704g f5489a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final MaxSignalCollectionListener f5490b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final AtomicBoolean f5491c = new AtomicBoolean();

        C1776b(C1704g gVar, MaxSignalCollectionListener maxSignalCollectionListener) {
            this.f5489a = gVar;
            this.f5490b = maxSignalCollectionListener;
        }
    }

    /* renamed from: com.applovin.impl.mediation.j$c */
    private class C1777c extends C1864a {
        private C1777c() {
            super("TaskTimeoutMediatedAd", C1743j.this.f5411b);
        }

        public void run() {
            if (!C1743j.this.f5423n.get()) {
                mo8410d(C1743j.this.f5415f + " is timing out " + C1743j.this.f5418i + "...");
                this.f6217b.mo8524B().mo7966a(C1743j.this.f5418i);
                C1743j.this.f5420k.m6705a(mo8411e(), -5101);
            }
        }
    }

    /* renamed from: com.applovin.impl.mediation.j$d */
    private class C1778d extends C1864a {

        /* renamed from: c */
        private final C1776b f5494c;

        private C1778d(C1776b bVar) {
            super("TaskTimeoutSignalCollection", C1743j.this.f5411b);
            this.f5494c = bVar;
        }

        public void run() {
            if (!this.f5494c.f5491c.get()) {
                mo8410d(C1743j.this.f5415f + " is timing out " + this.f5494c.f5489a + "...");
                C1743j jVar = C1743j.this;
                jVar.m6676b("The adapter (" + C1743j.this.f5415f + ") timed out", this.f5494c);
            }
        }
    }

    C1743j(C1701e eVar, MaxAdapter maxAdapter, C1941j jVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("No adapter name specified");
        } else if (maxAdapter == null) {
            throw new IllegalArgumentException("No adapter specified");
        } else if (jVar != null) {
            this.f5413d = eVar.mo7813E();
            this.f5416g = maxAdapter;
            this.f5411b = jVar;
            this.f5412c = jVar.mo8602v();
            this.f5414e = eVar;
            this.f5415f = maxAdapter.getClass().getSimpleName();
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6671a(String str) {
        C1977q qVar = this.f5412c;
        qVar.mo8744c("MediationAdapterWrapper", "Marking " + this.f5415f + " as disabled due to: " + str);
        this.f5422m.set(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6672a(String str, C1776b bVar) {
        if (bVar.f5491c.compareAndSet(false, true) && bVar.f5490b != null) {
            bVar.f5490b.onSignalCollected(str);
        }
    }

    /* renamed from: a */
    private void m6673a(final String str, final Runnable runnable) {
        C17523 r0 = new Runnable() {
            public void run() {
                try {
                    C1977q e = C1743j.this.f5412c;
                    e.mo8742b("MediationAdapterWrapper", C1743j.this.f5415f + ": running " + str + "...");
                    runnable.run();
                    C1977q e2 = C1743j.this.f5412c;
                    e2.mo8742b("MediationAdapterWrapper", C1743j.this.f5415f + ": finished " + str + "");
                } catch (Throwable th) {
                    C1977q e3 = C1743j.this.f5412c;
                    e3.mo8743b("MediationAdapterWrapper", "Unable to run adapter operation " + str + ", marking " + C1743j.this.f5415f + " as disabled", th);
                    C1743j jVar = C1743j.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("fail_");
                    sb.append(str);
                    jVar.m6671a(sb.toString());
                }
            }
        };
        if (this.f5414e.mo7816H()) {
            this.f5410a.post(r0);
        } else {
            r0.run();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6676b(String str, C1776b bVar) {
        if (bVar.f5491c.compareAndSet(false, true) && bVar.f5490b != null) {
            bVar.f5490b.onSignalCollectionFailed(str);
        }
    }

    /* renamed from: a */
    public View mo7896a() {
        return this.f5419j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7897a(final C1697a aVar, final Activity activity) {
        final Runnable runnable;
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (aVar.mo7767c() == null) {
            this.f5420k.m6710b("ad_show", -5201);
        } else if (aVar.mo7767c() != this) {
            throw new IllegalArgumentException("Mediated ad belongs to a different adapter");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (!this.f5422m.get()) {
            C1977q.m7751i("MediationAdapterWrapper", "Mediation adapter '" + this.f5415f + "' is disabled. Showing ads with this adapter is disabled.");
            this.f5420k.m6710b("ad_show", -5103);
        } else if (mo7905e()) {
            if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                if (this.f5416g instanceof MaxInterstitialAdapter) {
                    runnable = new Runnable() {
                        public void run() {
                            ((MaxInterstitialAdapter) C1743j.this.f5416g).showInterstitialAd(C1743j.this.f5421l, activity, C1743j.this.f5420k);
                        }
                    };
                } else {
                    C1977q.m7751i("MediationAdapterWrapper", "Mediation adapter '" + this.f5415f + "' is not an interstitial adapter.");
                    this.f5420k.m6710b("showFullscreenAd", -5104);
                    return;
                }
            } else if (aVar.getFormat() != MaxAdFormat.REWARDED) {
                throw new IllegalStateException("Failed to show " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            } else if (this.f5416g instanceof MaxRewardedAdapter) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxRewardedAdapter) C1743j.this.f5416g).showRewardedAd(C1743j.this.f5421l, activity, C1743j.this.f5420k);
                    }
                };
            } else {
                C1977q.m7751i("MediationAdapterWrapper", "Mediation adapter '" + this.f5415f + "' is not an incentivized adapter.");
                this.f5420k.m6710b("showFullscreenAd", -5104);
                return;
            }
            m6673a("ad_render", (Runnable) new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        C1977q e = C1743j.this.f5412c;
                        e.mo8743b("MediationAdapterWrapper", "Failed to start displaying ad" + aVar, th);
                        C1743j.this.f5420k.m6710b("ad_render", (int) MaxAdapterError.ERROR_CODE_UNSPECIFIED);
                    }
                }
            });
        } else {
            throw new IllegalStateException("Mediation adapter '" + this.f5415f + "' does not have an ad loaded. Please load an ad first");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7898a(final MaxAdapterInitializationParameters maxAdapterInitializationParameters, final Activity activity) {
        m6673a("initialize", (Runnable) new Runnable() {
            public void run() {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                C1743j.this.f5416g.initialize(maxAdapterInitializationParameters, activity, new MaxAdapter.OnCompletionListener() {
                    public void onCompletion() {
                        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                            public void run() {
                                long elapsedRealtime = SystemClock.elapsedRealtime();
                                C17451 r2 = C17451.this;
                                C1743j.this.f5411b.mo8604x().mo7887a(C1743j.this.f5414e, elapsedRealtime - elapsedRealtime, MaxAdapter.InitializationStatus.ADAPTER_NOT_SUPPORTED, (String) null);
                            }
                        }, C1743j.this.f5414e.mo7819K());
                    }

                    public void onCompletion(final MaxAdapter.InitializationStatus initializationStatus, final String str) {
                        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                            public void run() {
                                long elapsedRealtime = SystemClock.elapsedRealtime();
                                C17451 r2 = C17451.this;
                                C1743j.this.f5411b.mo8604x().mo7887a(C1743j.this.f5414e, elapsedRealtime - elapsedRealtime, initializationStatus, str);
                            }
                        }, C1743j.this.f5414e.mo7819K());
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7899a(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, C1704g gVar, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        if (maxSignalCollectionListener == null) {
            throw new IllegalArgumentException("No callback specified");
        } else if (!this.f5422m.get()) {
            C1977q.m7751i("MediationAdapterWrapper", "Mediation adapter '" + this.f5415f + "' is disabled. Signal collection ads with this adapter is disabled.");
            maxSignalCollectionListener.onSignalCollectionFailed("The adapter (" + this.f5415f + ") is disabled");
        } else {
            final C1776b bVar = new C1776b(gVar, maxSignalCollectionListener);
            MaxAdapter maxAdapter = this.f5416g;
            if (maxAdapter instanceof MaxSignalProvider) {
                final MaxSignalProvider maxSignalProvider = (MaxSignalProvider) maxAdapter;
                final MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters2 = maxAdapterSignalCollectionParameters;
                final Activity activity2 = activity;
                final C1704g gVar2 = gVar;
                m6673a("collect_signal", (Runnable) new Runnable() {
                    public void run() {
                        StringBuilder sb;
                        maxSignalProvider.collectSignal(maxAdapterSignalCollectionParameters2, activity2, new MaxSignalCollectionListener() {
                            public void onSignalCollected(String str) {
                                C174911 r0 = C174911.this;
                                C1743j.this.m6672a(str, bVar);
                            }

                            public void onSignalCollectionFailed(String str) {
                                C174911 r0 = C174911.this;
                                C1743j.this.m6676b(str, bVar);
                            }
                        });
                        if (bVar.f5491c.get()) {
                            return;
                        }
                        if (gVar2.mo7818J() == 0) {
                            C1977q e = C1743j.this.f5412c;
                            e.mo8742b("MediationAdapterWrapper", "Failing signal collection " + gVar2 + " since it has 0 timeout");
                            C1743j jVar = C1743j.this;
                            jVar.m6676b("The adapter (" + C1743j.this.f5415f + ") has 0 timeout", bVar);
                            return;
                        }
                        int i = (gVar2.mo7818J() > 0 ? 1 : (gVar2.mo7818J() == 0 ? 0 : -1));
                        C1977q e2 = C1743j.this.f5412c;
                        if (i > 0) {
                            sb.append("Setting timeout ");
                            sb.append(gVar2.mo7818J());
                            sb.append("ms. for ");
                            sb.append(gVar2);
                            e2.mo8742b("MediationAdapterWrapper", sb.toString());
                            C1743j.this.f5411b.mo8533L().mo8476a(new C1778d(bVar), C1907s.C1909a.MEDIATION_TIMEOUT, gVar2.mo7818J());
                            return;
                        }
                        sb = new StringBuilder();
                        sb.append("Negative timeout set for ");
                        sb.append(gVar2);
                        sb.append(", not scheduling a timeout");
                        e2.mo8742b("MediationAdapterWrapper", sb.toString());
                    }
                });
                return;
            }
            m6676b("The adapter (" + this.f5415f + ") does not support signal collection", bVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7900a(String str, C1697a aVar) {
        this.f5417h = str;
        this.f5418i = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7901a(String str, final MaxAdapterResponseParameters maxAdapterResponseParameters, final C1697a aVar, final Activity activity, C1726d dVar) {
        final Runnable runnable;
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (!this.f5422m.get()) {
            C1977q.m7751i("MediationAdapterWrapper", "Mediation adapter '" + this.f5415f + "' was disabled due to earlier failures. Loading ads with this adapter is disabled.");
            dVar.onAdLoadFailed(str, -5103);
        } else {
            this.f5421l = maxAdapterResponseParameters;
            this.f5420k.m6701a(dVar);
            if (aVar.getFormat() == MaxAdFormat.INTERSTITIAL) {
                if (this.f5416g instanceof MaxInterstitialAdapter) {
                    runnable = new Runnable() {
                        public void run() {
                            ((MaxInterstitialAdapter) C1743j.this.f5416g).loadInterstitialAd(maxAdapterResponseParameters, activity, C1743j.this.f5420k);
                        }
                    };
                } else {
                    C1977q.m7751i("MediationAdapterWrapper", "Mediation adapter '" + this.f5415f + "' is not an interstitial adapter.");
                    this.f5420k.m6705a("loadAd", -5104);
                    return;
                }
            } else if (aVar.getFormat() == MaxAdFormat.REWARDED) {
                if (this.f5416g instanceof MaxRewardedAdapter) {
                    runnable = new Runnable() {
                        public void run() {
                            ((MaxRewardedAdapter) C1743j.this.f5416g).loadRewardedAd(maxAdapterResponseParameters, activity, C1743j.this.f5420k);
                        }
                    };
                } else {
                    C1977q.m7751i("MediationAdapterWrapper", "Mediation adapter '" + this.f5415f + "' is not an incentivized adapter.");
                    this.f5420k.m6705a("loadAd", -5104);
                    return;
                }
            } else if (aVar.getFormat() != MaxAdFormat.BANNER && aVar.getFormat() != MaxAdFormat.LEADER && aVar.getFormat() != MaxAdFormat.MREC) {
                throw new IllegalStateException("Failed to load " + aVar + ": " + aVar.getFormat() + " is not a supported ad format");
            } else if (this.f5416g instanceof MaxAdViewAdapter) {
                runnable = new Runnable() {
                    public void run() {
                        ((MaxAdViewAdapter) C1743j.this.f5416g).loadAdViewAd(maxAdapterResponseParameters, aVar.getFormat(), activity, C1743j.this.f5420k);
                    }
                };
            } else {
                C1977q.m7751i("MediationAdapterWrapper", "Mediation adapter '" + this.f5415f + "' is not an adview-based adapter.");
                this.f5420k.m6705a("loadAd", -5104);
                return;
            }
            m6673a("ad_load", (Runnable) new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        C1977q e = C1743j.this.f5412c;
                        e.mo8743b("MediationAdapterWrapper", "Failed start loading " + aVar, th);
                        C1743j.this.f5420k.m6705a("loadAd", -1);
                    }
                    if (!C1743j.this.f5423n.get()) {
                        long J = C1743j.this.f5414e.mo7818J();
                        if (J > 0) {
                            C1977q e2 = C1743j.this.f5412c;
                            e2.mo8742b("MediationAdapterWrapper", "Setting timeout " + J + "ms. for " + aVar);
                            C1743j.this.f5411b.mo8533L().mo8476a(new C1777c(), C1907s.C1909a.MEDIATION_TIMEOUT, J);
                            return;
                        }
                        C1977q e3 = C1743j.this.f5412c;
                        e3.mo8742b("MediationAdapterWrapper", "Negative timeout set for " + aVar + ", not scheduling a timeout");
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public String mo7902b() {
        return this.f5413d;
    }

    /* renamed from: c */
    public C1726d mo7903c() {
        return this.f5420k.f5466b;
    }

    /* renamed from: d */
    public boolean mo7904d() {
        return this.f5422m.get();
    }

    /* renamed from: e */
    public boolean mo7905e() {
        return this.f5423n.get() && this.f5424o.get();
    }

    /* renamed from: f */
    public String mo7906f() {
        MaxAdapter maxAdapter = this.f5416g;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getSdkVersion();
        } catch (Throwable th) {
            C1977q qVar = this.f5412c;
            qVar.mo8743b("MediationAdapterWrapper", "Unable to get adapter's SDK version, marking " + this + " as disabled", th);
            m6671a("fail_version");
            return null;
        }
    }

    /* renamed from: g */
    public String mo7907g() {
        MaxAdapter maxAdapter = this.f5416g;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getAdapterVersion();
        } catch (Throwable th) {
            C1977q qVar = this.f5412c;
            qVar.mo8743b("MediationAdapterWrapper", "Unable to get adapter version, marking " + this + " as disabled", th);
            m6671a("fail_version");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo7908h() {
        m6673a("destroy", (Runnable) new Runnable() {
            public void run() {
                C1743j.this.m6671a("destroy");
                C1743j.this.f5416g.onDestroy();
                MaxAdapter unused = C1743j.this.f5416g = null;
            }
        });
    }

    public String toString() {
        return "MediationAdapterWrapper{adapterTag='" + this.f5415f + "'" + '}';
    }
}
