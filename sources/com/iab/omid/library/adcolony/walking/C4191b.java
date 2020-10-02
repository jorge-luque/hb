package com.iab.omid.library.adcolony.walking;

import com.iab.omid.library.adcolony.walking.p148a.C4184b;
import com.iab.omid.library.adcolony.walking.p148a.C4187c;
import com.iab.omid.library.adcolony.walking.p148a.C4188d;
import com.iab.omid.library.adcolony.walking.p148a.C4189e;
import com.iab.omid.library.adcolony.walking.p148a.C4190f;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.walking.b */
public class C4191b implements C4184b.C4186b {

    /* renamed from: a */
    private JSONObject f11254a;

    /* renamed from: b */
    private final C4187c f11255b;

    public C4191b(C4187c cVar) {
        this.f11255b = cVar;
    }

    /* renamed from: a */
    public void mo28614a() {
        this.f11255b.mo28607b(new C4188d(this));
    }

    /* renamed from: a */
    public void mo28605a(JSONObject jSONObject) {
        this.f11254a = jSONObject;
    }

    /* renamed from: a */
    public void mo28615a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f11255b.mo28607b(new C4190f(this, hashSet, jSONObject, j));
    }

    /* renamed from: b */
    public JSONObject mo28606b() {
        return this.f11254a;
    }

    /* renamed from: b */
    public void mo28616b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f11255b.mo28607b(new C4189e(this, hashSet, jSONObject, j));
    }
}
