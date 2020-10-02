package com.adcolony.sdk;

import com.adcolony.sdk.C1441v;
import java.util.Date;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.o */
class C1408o extends C1441v {

    /* renamed from: i */
    static final C1436r f4444i = new C1436r("adcolony_fatal_reports", "4.2.0", "Production");

    /* renamed from: j */
    static final String f4445j = "sourceFile";

    /* renamed from: k */
    static final String f4446k = "lineNumber";

    /* renamed from: l */
    static final String f4447l = "methodName";

    /* renamed from: m */
    static final String f4448m = "stackTrace";

    /* renamed from: n */
    static final String f4449n = "isAdActive";

    /* renamed from: o */
    static final String f4450o = "activeAdId";

    /* renamed from: p */
    static final String f4451p = "active_creative_ad_id";

    /* renamed from: q */
    static final String f4452q = "listOfCachedAds";

    /* renamed from: r */
    static final String f4453r = "listOfCreativeAdIds";

    /* renamed from: s */
    static final String f4454s = "adCacheSize";
    /* access modifiers changed from: private */

    /* renamed from: h */
    public JSONObject f4455h;

    /* renamed from: com.adcolony.sdk.o$a */
    private class C1409a extends C1441v.C1442a {
        C1409a() {
            this.f4528a = new C1408o();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1409a mo6775a(JSONObject jSONObject) {
            JSONObject unused = ((C1408o) this.f4528a).f4455h = jSONObject;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1441v.C1442a mo6776a(Date date) {
            C1437s.m5592a(((C1408o) this.f4528a).f4455h, "timestamp", C1441v.f4521e.format(date));
            return super.mo6776a(date);
        }
    }

    C1408o() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public JSONObject mo6774f() {
        return this.f4455h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1408o mo6773a(JSONObject jSONObject) {
        C1409a aVar = new C1409a();
        aVar.mo6775a(jSONObject);
        aVar.mo6814a(C1437s.m5613h(jSONObject, "message"));
        try {
            aVar.mo6776a(new Date(Long.parseLong(C1437s.m5613h(jSONObject, "timestamp"))));
        } catch (NumberFormatException unused) {
        }
        aVar.mo6813a(f4444i);
        aVar.mo6812a(-1);
        return (C1408o) aVar.mo6815a();
    }
}
