package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.utils.C1993i;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.v */
public class C2036v {

    /* renamed from: a */
    private final C1941j f6754a;

    /* renamed from: b */
    private final JSONObject f6755b;

    /* renamed from: c */
    private final Object f6756c = new Object();

    public C2036v(C1941j jVar) {
        this.f6754a = jVar;
        this.f6755b = C1993i.m7881a((String) jVar.mo8574b(C1843e.f6105s, "{}"), new JSONObject(), jVar);
    }

    /* renamed from: a */
    public Integer mo8845a(String str) {
        Integer valueOf;
        synchronized (this.f6756c) {
            if (this.f6755b.has(str)) {
                C1993i.m7884a(this.f6755b, str, C1993i.m7894b(this.f6755b, str, 0, this.f6754a) + 1, this.f6754a);
            } else {
                C1993i.m7884a(this.f6755b, str, 1, this.f6754a);
            }
            this.f6754a.mo8556a(C1843e.f6105s, this.f6755b.toString());
            valueOf = Integer.valueOf(C1993i.m7894b(this.f6755b, str, 0, this.f6754a));
        }
        return valueOf;
    }
}
