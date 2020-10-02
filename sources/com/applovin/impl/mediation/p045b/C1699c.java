package com.applovin.impl.mediation.p045b;

import android.os.SystemClock;
import com.applovin.impl.mediation.C1743j;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p048a.C1814c;
import com.applovin.impl.sdk.p050b.C1840b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.c */
public class C1699c extends C1697a {

    /* renamed from: c */
    private final AtomicReference<C1814c> f5299c;

    /* renamed from: d */
    private final AtomicBoolean f5300d;

    private C1699c(C1699c cVar, C1743j jVar) {
        super(cVar.mo7811C(), cVar.mo7810B(), jVar, cVar.f5302b);
        this.f5299c = cVar.f5299c;
        this.f5300d = cVar.f5300d;
    }

    public C1699c(JSONObject jSONObject, JSONObject jSONObject2, C1941j jVar) {
        super(jSONObject, jSONObject2, (C1743j) null, jVar);
        this.f5299c = new AtomicReference<>();
        this.f5300d = new AtomicBoolean();
    }

    /* renamed from: A */
    public String mo7794A() {
        return mo7833b("nia_button_title", mo7824a("nia_button_title", ""));
    }

    /* renamed from: a */
    public C1697a mo7764a(C1743j jVar) {
        return new C1699c(this, jVar);
    }

    /* renamed from: a */
    public void mo7795a(C1814c cVar) {
        this.f5299c.set(cVar);
    }

    /* renamed from: l */
    public long mo7780l() {
        long b = mo7831b("ad_expiration_ms", -1);
        return b >= 0 ? b : mo7823a("ad_expiration_ms", ((Long) this.f5302b.mo8549a(C1840b.f5752E)).longValue());
    }

    /* renamed from: m */
    public long mo7796m() {
        long b = mo7831b("ad_hidden_timeout_ms", -1);
        return b >= 0 ? b : mo7823a("ad_hidden_timeout_ms", ((Long) this.f5302b.mo8549a(C1840b.f5754G)).longValue());
    }

    /* renamed from: n */
    public boolean mo7797n() {
        if (mo7836b("schedule_ad_hidden_on_ad_dismiss", (Boolean) false)) {
            return true;
        }
        return mo7829a("schedule_ad_hidden_on_ad_dismiss", (Boolean) this.f5302b.mo8549a(C1840b.f5755H));
    }

    /* renamed from: o */
    public long mo7798o() {
        long b = mo7831b("ad_hidden_on_ad_dismiss_callback_delay_ms", -1);
        return b >= 0 ? b : mo7823a("ad_hidden_on_ad_dismiss_callback_delay_ms", ((Long) this.f5302b.mo8549a(C1840b.f5756I)).longValue());
    }

    /* renamed from: p */
    public long mo7799p() {
        if (mo7775h() > 0) {
            return SystemClock.elapsedRealtime() - mo7775h();
        }
        return -1;
    }

    /* renamed from: q */
    public long mo7800q() {
        long b = mo7831b("fullscreen_display_delay_ms", -1);
        return b >= 0 ? b : ((Long) this.f5302b.mo8549a(C1840b.f5786x)).longValue();
    }

    /* renamed from: r */
    public long mo7801r() {
        return mo7831b("ahdm", ((Long) this.f5302b.mo8549a(C1840b.f5787y)).longValue());
    }

    /* renamed from: s */
    public String mo7802s() {
        return mo7833b("bcode", "");
    }

    /* renamed from: t */
    public String mo7803t() {
        return mo7824a("mcode", "");
    }

    /* renamed from: u */
    public boolean mo7804u() {
        return this.f5300d.get();
    }

    /* renamed from: v */
    public void mo7805v() {
        this.f5300d.set(true);
    }

    /* renamed from: w */
    public C1814c mo7806w() {
        return this.f5299c.getAndSet((Object) null);
    }

    /* renamed from: x */
    public boolean mo7807x() {
        return mo7836b("show_nia", Boolean.valueOf(mo7829a("show_nia", (Boolean) false)));
    }

    /* renamed from: y */
    public String mo7808y() {
        return mo7833b("nia_title", mo7824a("nia_title", ""));
    }

    /* renamed from: z */
    public String mo7809z() {
        return mo7833b("nia_message", mo7824a("nia_message", ""));
    }
}
