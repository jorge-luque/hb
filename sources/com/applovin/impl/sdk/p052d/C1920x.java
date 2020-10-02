package com.applovin.impl.sdk.p052d;

import com.applovin.impl.p033a.C1476a;
import com.applovin.impl.p033a.C1481b;
import com.applovin.impl.p033a.C1482c;
import com.applovin.impl.p033a.C1483d;
import com.applovin.impl.p033a.C1486f;
import com.applovin.impl.p033a.C1487g;
import com.applovin.impl.p033a.C1489i;
import com.applovin.impl.p033a.C1490j;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C2032t;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.d.x */
class C1920x extends C1864a {

    /* renamed from: a */
    private C1482c f6348a;

    /* renamed from: c */
    private final AppLovinAdLoadListener f6349c;

    C1920x(C1482c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1941j jVar) {
        super("TaskRenderVastAd", jVar);
        this.f6349c = appLovinAdLoadListener;
        this.f6348a = cVar;
    }

    public void run() {
        mo8405a("Rendering VAST ad...");
        int size = this.f6348a.mo7191b().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        String str = "";
        C1486f fVar = null;
        C1490j jVar = null;
        C1481b bVar = null;
        String str2 = str;
        for (C2032t next : this.f6348a.mo7191b()) {
            C2032t c = next.mo8827c(C1489i.m5790a(next) ? "Wrapper" : "InLine");
            if (c != null) {
                C2032t c2 = c.mo8827c("AdSystem");
                if (c2 != null) {
                    fVar = C1486f.m5770a(c2, fVar, this.f6217b);
                }
                str = C1489i.m5781a(c, "AdTitle", str);
                str2 = C1489i.m5781a(c, "Description", str2);
                C1489i.m5786a(c.mo8824a("Impression"), (Set<C1487g>) hashSet, this.f6348a, this.f6217b);
                C2032t b = c.mo8825b("ViewableImpression");
                if (b != null) {
                    C1489i.m5786a(b.mo8824a("Viewable"), (Set<C1487g>) hashSet, this.f6348a, this.f6217b);
                }
                C1489i.m5786a(c.mo8824a("Error"), (Set<C1487g>) hashSet2, this.f6348a, this.f6217b);
                C2032t b2 = c.mo8825b("Creatives");
                if (b2 != null) {
                    for (C2032t next2 : b2.mo8829d()) {
                        C2032t b3 = next2.mo8825b("Linear");
                        if (b3 != null) {
                            jVar = C1490j.m5796a(b3, jVar, this.f6348a, this.f6217b);
                        } else {
                            C2032t c3 = next2.mo8827c("CompanionAds");
                            if (c3 != null) {
                                C2032t c4 = c3.mo8827c("Companion");
                                if (c4 != null) {
                                    bVar = C1481b.m5748a(c4, bVar, this.f6348a, this.f6217b);
                                }
                            } else {
                                mo8410d("Received and will skip rendering for an unidentified creative: " + next2);
                            }
                        }
                    }
                }
            } else {
                mo8410d("Did not find wrapper or inline response for node: " + next);
            }
        }
        C1476a a = C1476a.m5695aV().mo7175a(this.f6217b).mo7178a(this.f6348a.mo7192c()).mo7182b(this.f6348a.mo7193d()).mo7174a(this.f6348a.mo7194e()).mo7170a(this.f6348a.mo7195f()).mo7176a(str).mo7180b(str2).mo7172a(fVar).mo7173a(jVar).mo7171a(bVar).mo7177a((Set<C1487g>) hashSet).mo7181b((Set<C1487g>) hashSet2).mo7179a();
        C1483d a2 = C1489i.m5777a(a);
        if (a2 == null) {
            C1886h hVar = new C1886h(a, this.f6217b, this.f6349c);
            C1907s.C1909a aVar = C1907s.C1909a.CACHING_OTHER;
            if (((Boolean) this.f6217b.mo8549a(C1841c.f5889bj)).booleanValue()) {
                if (a.getType() == AppLovinAdType.REGULAR) {
                    aVar = C1907s.C1909a.CACHING_INTERSTITIAL;
                } else if (a.getType() == AppLovinAdType.INCENTIVIZED) {
                    aVar = C1907s.C1909a.CACHING_INCENTIVIZED;
                }
            }
            this.f6217b.mo8533L().mo8475a((C1864a) hVar, aVar);
            return;
        }
        C1489i.m5784a(this.f6348a, this.f6349c, a2, -6, this.f6217b);
    }
}
