package p093e.p097b.p098a.p099a;

import android.os.Bundle;

/* renamed from: e.b.a.a.d */
/* compiled from: ReferrerDetails */
public class C3375d {

    /* renamed from: a */
    private final Bundle f9437a;

    public C3375d(Bundle bundle) {
        this.f9437a = bundle;
    }

    /* renamed from: a */
    public long mo19136a() {
        return this.f9437a.getLong("install_begin_timestamp_seconds");
    }

    /* renamed from: b */
    public String mo19137b() {
        return this.f9437a.getString("install_referrer");
    }

    /* renamed from: c */
    public long mo19138c() {
        return this.f9437a.getLong("referrer_click_timestamp_seconds");
    }
}
