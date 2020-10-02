package com.iab.omid.library.oguryco.walking;

import com.iab.omid.library.oguryco.walking.p154a.C4235b;
import com.iab.omid.library.oguryco.walking.p154a.C4238c;
import com.iab.omid.library.oguryco.walking.p154a.C4239d;
import com.iab.omid.library.oguryco.walking.p154a.C4240e;
import com.iab.omid.library.oguryco.walking.p154a.C4241f;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.oguryco.walking.b */
public class C4242b implements C4235b.C4237b {

    /* renamed from: a */
    private JSONObject f11375a;

    /* renamed from: b */
    private final C4238c f11376b;

    public C4242b(C4238c cVar) {
        this.f11376b = cVar;
    }

    /* renamed from: a */
    public void mo28828a() {
        this.f11376b.mo28821b(new C4239d(this));
    }

    /* renamed from: a */
    public void mo28819a(JSONObject jSONObject) {
        this.f11375a = jSONObject;
    }

    /* renamed from: a */
    public void mo28829a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f11376b.mo28821b(new C4241f(this, hashSet, jSONObject, j));
    }

    /* renamed from: b */
    public JSONObject mo28820b() {
        return this.f11375a;
    }

    /* renamed from: b */
    public void mo28830b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f11376b.mo28821b(new C4240e(this, hashSet, jSONObject, j));
    }
}
