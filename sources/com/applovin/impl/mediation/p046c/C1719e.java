package com.applovin.impl.mediation.p046c;

import android.app.Activity;
import com.applovin.impl.mediation.p045b.C1697a;
import com.applovin.impl.mediation.p045b.C1698b;
import com.applovin.impl.mediation.p045b.C1699c;
import com.applovin.impl.mediation.p045b.C1700d;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C1994j;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxErrorCodes;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.e */
public class C1719e extends C1864a {

    /* renamed from: a */
    private final String f5348a;

    /* renamed from: c */
    private final JSONObject f5349c;

    /* renamed from: d */
    private final JSONObject f5350d;

    /* renamed from: e */
    private final MaxAdListener f5351e;

    /* renamed from: f */
    private final WeakReference<Activity> f5352f;

    C1719e(String str, JSONObject jSONObject, JSONObject jSONObject2, C1941j jVar, Activity activity, MaxAdListener maxAdListener) {
        super("TaskLoadAdapterAd " + str, jVar);
        this.f5348a = str;
        this.f5349c = jSONObject;
        this.f5350d = jSONObject2;
        this.f5352f = new WeakReference<>(activity);
        this.f5351e = maxAdListener;
    }

    /* renamed from: a */
    private void m6579a() {
        this.f6217b.mo8605y().loadThirdPartyMediatedAd(this.f5348a, m6581c(), m6580b(), this.f5351e);
    }

    /* renamed from: b */
    private Activity m6580b() {
        Activity activity = (Activity) this.f5352f.get();
        return activity != null ? activity : this.f6217b.mo8572ah();
    }

    /* renamed from: c */
    private C1697a m6581c() {
        String b = C1993i.m7896b(this.f5350d, "ad_format", (String) null, this.f6217b);
        MaxAdFormat c = C2029r.m8031c(b);
        if (c == MaxAdFormat.BANNER || c == MaxAdFormat.MREC || c == MaxAdFormat.LEADER) {
            return new C1698b(this.f5349c, this.f5350d, this.f6217b);
        }
        if (c == MaxAdFormat.NATIVE) {
            return new C1700d(this.f5349c, this.f5350d, this.f6217b);
        }
        if (c == MaxAdFormat.INTERSTITIAL || c == MaxAdFormat.REWARDED) {
            return new C1699c(this.f5349c, this.f5350d, this.f6217b);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + b);
    }

    public void run() {
        if (((Boolean) this.f6217b.mo8549a(C1841c.f6030eU)).booleanValue()) {
            try {
                m6579a();
            } catch (Throwable th) {
                mo8406a("Unable to process adapter ad", th);
                C1994j.m7912a(this.f5351e, this.f5348a, (int) MaxErrorCodes.MEDIATION_ADAPTER_LOAD_FAILED);
            }
        } else {
            m6579a();
        }
    }
}
