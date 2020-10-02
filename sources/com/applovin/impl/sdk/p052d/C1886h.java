package com.applovin.impl.sdk.p052d;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.p033a.C1476a;
import com.applovin.impl.p033a.C1481b;
import com.applovin.impl.p033a.C1484e;
import com.applovin.impl.p033a.C1493k;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p051c.C1854d;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Collections;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.d.h */
class C1886h extends C1877c {

    /* renamed from: c */
    private final C1476a f6251c;

    public C1886h(C1476a aVar, C1941j jVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheVastAd", aVar, jVar, appLovinAdLoadListener);
        this.f6251c = aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m7282j() {
        if (this.f6251c.mo7154d()) {
            mo8405a("Begin caching for VAST streaming ad #" + this.f6232a.getAdIdNumber() + "...");
            mo8434c();
            if (this.f6251c.mo7158g()) {
                mo8438i();
            }
            if (this.f6251c.mo7155e() == C1476a.C1479b.COMPANION_AD) {
                m7283k();
                m7285m();
            } else {
                m7284l();
            }
            if (!this.f6251c.mo7158g()) {
                mo8438i();
            }
            if (this.f6251c.mo7155e() == C1476a.C1479b.COMPANION_AD) {
                m7284l();
            } else {
                m7283k();
                m7285m();
            }
        } else {
            mo8405a("Begin caching for VAST ad #" + this.f6232a.getAdIdNumber() + "...");
            mo8434c();
            m7283k();
            m7284l();
            m7285m();
            mo8438i();
        }
        mo8405a("Finished caching VAST ad #" + this.f6251c.getAdIdNumber());
        long currentTimeMillis = System.currentTimeMillis() - this.f6251c.getCreatedAtMillis();
        C1854d.m7123a(this.f6251c, this.f6217b);
        C1854d.m7122a(currentTimeMillis, (AppLovinAdBase) this.f6251c, this.f6217b);
        mo8431a((AppLovinAdBase) this.f6251c);
        this.f6251c.mo7152b();
        mo8430a();
    }

    /* renamed from: k */
    private void m7283k() {
        String str;
        String str2;
        String str3;
        if (!mo8433b()) {
            if (this.f6251c.mo7149aT()) {
                C1481b m = this.f6251c.mo7167m();
                if (m != null) {
                    C1484e b = m.mo7184b();
                    if (b != null) {
                        Uri b2 = b.mo7203b();
                        String uri = b2 != null ? b2.toString() : "";
                        String c = b.mo7204c();
                        if (URLUtil.isValidUrl(uri) || C2025o.m7963b(c)) {
                            if (b.mo7200a() == C1484e.C1485a.STATIC) {
                                mo8405a("Caching static companion ad at " + uri + "...");
                                Uri b3 = mo8432b(uri, Collections.emptyList(), false);
                                if (b3 != null) {
                                    b.mo7201a(b3);
                                } else {
                                    str2 = "Failed to cache static companion ad";
                                }
                            } else if (b.mo7200a() == C1484e.C1485a.HTML) {
                                if (C2025o.m7963b(uri)) {
                                    mo8405a("Begin caching HTML companion ad. Fetching from " + uri + "...");
                                    c = mo8436f(uri);
                                    if (C2025o.m7963b(c)) {
                                        str3 = "HTML fetched. Caching HTML now...";
                                    } else {
                                        str2 = "Unable to load companion ad resources from " + uri;
                                    }
                                } else {
                                    str3 = "Caching provided HTML for companion ad. No fetch required. HTML: " + c;
                                }
                                mo8405a(str3);
                                b.mo7202a(mo8429a(c, (List<String>) Collections.emptyList(), (C1827g) this.f6251c));
                            } else if (b.mo7200a() == C1484e.C1485a.IFRAME) {
                                str = "Skip caching of iFrame resource...";
                            } else {
                                return;
                            }
                            this.f6251c.mo8230a(true);
                            return;
                        }
                        mo8408c("Companion ad does not have any resources attached. Skipping...");
                        return;
                    }
                    str2 = "Failed to retrieve non-video resources from companion ad. Skipping...";
                    mo8410d(str2);
                    return;
                }
                str = "No companion ad provided. Skipping...";
            } else {
                str = "Companion ad caching disabled. Skipping...";
            }
            mo8405a(str);
        }
    }

    /* renamed from: l */
    private void m7284l() {
        C1493k l;
        Uri b;
        if (!mo8433b()) {
            if (!this.f6251c.mo7150aU()) {
                mo8405a("Video caching disabled. Skipping...");
            } else if (this.f6251c.mo7165k() != null && (l = this.f6251c.mo7166l()) != null && (b = l.mo7230b()) != null) {
                Uri a = mo8427a(b.toString(), (List<String>) Collections.emptyList(), false);
                if (a != null) {
                    mo8405a("Video file successfully cached into: " + a);
                    l.mo7229a(a);
                    return;
                }
                mo8410d("Failed to cache video file: " + l);
            }
        }
    }

    /* renamed from: m */
    private void m7285m() {
        String str;
        String str2;
        if (!mo8433b()) {
            if (this.f6251c.mo7148aS() != null) {
                mo8405a("Begin caching HTML template. Fetching from " + this.f6251c.mo7148aS() + "...");
                str = mo8428a(this.f6251c.mo7148aS().toString(), this.f6251c.mo8211K());
            } else {
                str = this.f6251c.mo7147aR();
            }
            if (C2025o.m7963b(str)) {
                C1476a aVar = this.f6251c;
                aVar.mo7145a(mo8429a(str, aVar.mo8211K(), (C1827g) this.f6251c));
                str2 = "Finish caching HTML template " + this.f6251c.mo7147aR() + " for ad #" + this.f6251c.getAdIdNumber();
            } else {
                str2 = "Unable to load HTML template";
            }
            mo8405a(str2);
        }
    }

    public void run() {
        super.run();
        C18871 r0 = new Runnable() {
            public void run() {
                C1886h.this.m7282j();
            }
        };
        if (this.f6232a.mo8214N()) {
            this.f6217b.mo8533L().mo8480c().execute(r0);
        } else {
            r0.run();
        }
    }
}
