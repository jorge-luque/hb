package com.criteo.publisher.model.p055z;

import com.criteo.publisher.model.p055z.C2485l;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.net.URI;
import java.net.URL;

/* renamed from: com.criteo.publisher.model.z.r */
public abstract class C2493r {
    /* renamed from: a */
    public static TypeAdapter<C2493r> m9418a(Gson gson) {
        return new C2485l.C2486a(gson);
    }

    /* renamed from: a */
    public abstract String mo10462a();

    /* renamed from: b */
    public abstract URI mo10463b();

    /* renamed from: c */
    public abstract String mo10464c();

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract C2490o mo10465d();

    /* renamed from: e */
    public URL mo10493e() {
        return mo10465d().mo10448a();
    }

    /* renamed from: f */
    public abstract String mo10467f();

    /* renamed from: g */
    public abstract String mo10468g();
}
