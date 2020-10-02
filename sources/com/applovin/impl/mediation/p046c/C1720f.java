package com.applovin.impl.mediation.p046c;

import android.app.Activity;
import com.applovin.impl.mediation.p045b.C1697a;
import com.applovin.impl.mediation.p047d.C1727a;
import com.applovin.impl.mediation.p047d.C1729c;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p051c.C1859g;
import com.applovin.impl.sdk.p051c.C1860h;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.utils.C1987d;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C1994j;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxErrorCodes;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.f */
public class C1720f extends C1864a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f5353a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final MaxAdFormat f5354c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final JSONObject f5355d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final MaxAdListener f5356e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final WeakReference<Activity> f5357f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f5358g = false;

    /* renamed from: com.applovin.impl.mediation.c.f$a */
    private class C1722a extends C1864a {

        /* renamed from: c */
        private final JSONArray f5361c;

        /* renamed from: d */
        private final int f5362d;

        C1722a(int i, JSONArray jSONArray) {
            super("TaskProcessNextWaterfallAd", C1720f.this.f6217b);
            if (i < 0 || i >= jSONArray.length()) {
                throw new IllegalArgumentException("Invalid ad index specified: " + i);
            }
            this.f5361c = jSONArray;
            this.f5362d = i;
        }

        /* renamed from: a */
        private String m6594a(int i) {
            return (i < 0 || i >= this.f5361c.length()) ? "undefined" : C1993i.m7896b(C1993i.m7883a(this.f5361c, i, new JSONObject(), this.f6217b), "type", "undefined", this.f6217b);
        }

        /* renamed from: a */
        private void m6595a() {
            JSONObject a = C1993i.m7883a(this.f5361c, this.f5362d, (JSONObject) null, this.f6217b);
            m6594a(this.f5362d);
            mo8405a("Starting task for adapter ad...");
            m6599e("started to load ad");
            this.f6217b.mo8533L().mo8474a((C1864a) new C1719e(C1720f.this.f5353a, a, C1720f.this.f5355d, this.f6217b, (Activity) C1720f.this.f5357f.get(), new C1727a(C1720f.this.f5356e, this.f6217b) {
                public void onAdLoadFailed(String str, int i) {
                    if (i != 204) {
                        boolean unused = C1720f.this.f5358g = true;
                    }
                    C1722a aVar = C1722a.this;
                    aVar.m6599e("failed to load ad: " + i);
                    C1722a.this.m6598b();
                }

                public void onAdLoaded(MaxAd maxAd) {
                    C1722a.this.m6599e("loaded ad");
                    C1720f.this.m6586a(maxAd);
                }
            }));
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m6598b() {
            int i;
            C1720f fVar;
            if (this.f5362d < this.f5361c.length() - 1) {
                mo8407b("Attempting to load next ad (" + this.f5362d + ") after failure...");
                this.f6217b.mo8533L().mo8475a((C1864a) new C1722a(this.f5362d + 1, this.f5361c), C1729c.m6621a(C1720f.this.f5354c));
                return;
            }
            if (C1720f.this.f5358g) {
                fVar = C1720f.this;
                i = MaxErrorCodes.MEDIATION_ADAPTER_LOAD_FAILED;
            } else {
                fVar = C1720f.this;
                i = 204;
            }
            fVar.m6583a(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public void m6599e(String str) {
        }

        public void run() {
            if (((Boolean) this.f6217b.mo8549a(C1841c.f6029eT)).booleanValue()) {
                try {
                    m6595a();
                } catch (Throwable th) {
                    mo8406a("Encountered error while processing ad number " + this.f5362d, th);
                    C1720f.this.m6583a((int) AppLovinErrorCodes.INVALID_RESPONSE);
                }
            } else {
                m6595a();
            }
        }
    }

    C1720f(String str, MaxAdFormat maxAdFormat, JSONObject jSONObject, Activity activity, C1941j jVar, MaxAdListener maxAdListener) {
        super("TaskProcessMediationWaterfall " + str, jVar);
        this.f5353a = str;
        this.f5354c = maxAdFormat;
        this.f5355d = jSONObject;
        this.f5356e = maxAdListener;
        this.f5357f = new WeakReference<>(activity);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6583a(int i) {
        C1860h M;
        C1859g gVar;
        if (i == 204) {
            M = this.f6217b.mo8534M();
            gVar = C1859g.f6202q;
        } else if (i == -5001) {
            M = this.f6217b.mo8534M();
            gVar = C1859g.f6203r;
        } else {
            M = this.f6217b.mo8534M();
            gVar = C1859g.f6204s;
        }
        M.mo8387a(gVar);
        mo8407b("Notifying parent of ad load failure for ad unit " + this.f5353a + ": " + i);
        C1994j.m7912a(this.f5356e, this.f5353a, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6586a(MaxAd maxAd) {
        this.f6217b.mo8606z().mo8748a((C1697a) maxAd);
        mo8407b("Notifying parent of ad load success for ad unit " + this.f5353a);
        C1994j.m7909a(this.f5356e, maxAd);
    }

    public void run() {
        JSONArray optJSONArray = this.f5355d.optJSONArray("ads");
        int length = optJSONArray != null ? optJSONArray.length() : 0;
        if (length > 0) {
            mo8405a("Loading the first out of " + length + " ads...");
            this.f6217b.mo8533L().mo8474a((C1864a) new C1722a(0, optJSONArray));
            return;
        }
        mo8408c("No ads were returned from the server");
        C2029r.m8010a(this.f5353a, this.f5354c, this.f5355d, this.f6217b);
        JSONObject b = C1993i.m7901b(this.f5355d, "settings", new JSONObject(), this.f6217b);
        long a = C1993i.m7869a(b, "alfdcs", 0, this.f6217b);
        if (a > 0) {
            long millis = TimeUnit.SECONDS.toMillis(a);
            C17211 r4 = new Runnable() {
                public void run() {
                    C1720f.this.m6583a(204);
                }
            };
            if (C1993i.m7871a(b, "alfdcs_iba", (Boolean) false, this.f6217b).booleanValue()) {
                C1987d.m7825a(millis, this.f6217b, r4);
            } else {
                AppLovinSdkUtils.runOnUiThreadDelayed(r4, millis);
            }
        } else {
            m6583a(204);
        }
    }
}
