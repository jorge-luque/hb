package com.applovin.impl.mediation.p045b;

import android.view.View;
import com.applovin.impl.mediation.C1743j;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p050b.C1840b;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.b */
public class C1698b extends C1697a {
    private C1698b(C1698b bVar, C1743j jVar) {
        super(bVar.mo7811C(), bVar.mo7810B(), jVar, bVar.f5302b);
    }

    public C1698b(JSONObject jSONObject, JSONObject jSONObject2, C1941j jVar) {
        super(jSONObject, jSONObject2, (C1743j) null, jVar);
    }

    /* renamed from: a */
    public C1697a mo7764a(C1743j jVar) {
        return new C1698b(this, jVar);
    }

    /* renamed from: l */
    public int mo7780l() {
        int b = mo7830b("ad_view_width", -2);
        if (b != -2) {
            return b;
        }
        MaxAdFormat format = getFormat();
        if (format == MaxAdFormat.BANNER) {
            return 320;
        }
        if (format == MaxAdFormat.LEADER) {
            return 728;
        }
        if (format == MaxAdFormat.MREC) {
            return AppLovinAdSize.MREC.getWidth();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    /* renamed from: m */
    public int mo7781m() {
        AppLovinAdSize appLovinAdSize;
        int b = mo7830b("ad_view_height", -2);
        if (b != -2) {
            return b;
        }
        MaxAdFormat format = getFormat();
        if (format == MaxAdFormat.BANNER) {
            appLovinAdSize = AppLovinAdSize.BANNER;
        } else if (format == MaxAdFormat.LEADER) {
            appLovinAdSize = AppLovinAdSize.LEADER;
        } else if (format == MaxAdFormat.MREC) {
            appLovinAdSize = AppLovinAdSize.MREC;
        } else {
            throw new IllegalStateException("Invalid ad format");
        }
        return appLovinAdSize.getHeight();
    }

    /* renamed from: n */
    public View mo7782n() {
        C1743j jVar;
        if (!mo7765a() || (jVar = this.f5297a) == null) {
            return null;
        }
        View a = jVar.mo7896a();
        if (a != null) {
            return a;
        }
        throw new IllegalStateException("Ad-view based ad is missing an ad view");
    }

    /* renamed from: o */
    public long mo7783o() {
        return mo7831b("viewability_imp_delay_ms", ((Long) this.f5302b.mo8549a(C1841c.f5878bY)).longValue());
    }

    /* renamed from: p */
    public int mo7784p() {
        return mo7830b("viewability_min_width", ((Integer) this.f5302b.mo8549a(getFormat() == MaxAdFormat.BANNER ? C1841c.f5879bZ : getFormat() == MaxAdFormat.MREC ? C1841c.f5933cb : C1841c.f5935cd)).intValue());
    }

    /* renamed from: q */
    public int mo7785q() {
        return mo7830b("viewability_min_height", ((Integer) this.f5302b.mo8549a(getFormat() == MaxAdFormat.BANNER ? C1841c.f5932ca : getFormat() == MaxAdFormat.MREC ? C1841c.f5934cc : C1841c.f5936ce)).intValue());
    }

    /* renamed from: r */
    public float mo7786r() {
        return mo7821a("viewability_min_alpha", ((Float) this.f5302b.mo8549a(C1841c.f5937cf)).floatValue() / 100.0f);
    }

    /* renamed from: s */
    public int mo7787s() {
        return mo7830b("viewability_min_pixels", -1);
    }

    /* renamed from: t */
    public boolean mo7788t() {
        return mo7787s() >= 0;
    }

    /* renamed from: u */
    public long mo7789u() {
        return mo7831b("viewability_timer_min_visible_ms", ((Long) this.f5302b.mo8549a(C1841c.f5938cg)).longValue());
    }

    /* renamed from: v */
    public boolean mo7790v() {
        return mo7791w() >= 0;
    }

    /* renamed from: w */
    public long mo7791w() {
        long b = mo7831b("ad_refresh_ms", -1);
        return b >= 0 ? b : mo7823a("ad_refresh_ms", ((Long) this.f5302b.mo8549a(C1840b.f5777o)).longValue());
    }

    /* renamed from: x */
    public boolean mo7792x() {
        return mo7836b("proe", (Boolean) this.f5302b.mo8549a(C1840b.f5757J));
    }

    /* renamed from: y */
    public long mo7793y() {
        return C2029r.m8039f(mo7833b("bg_color", (String) null));
    }
}
