package com.criteo.publisher.model.p055z;

import com.criteo.publisher.model.p055z.C2469b;
import com.criteo.publisher.model.p055z.C2477h;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.criteo.publisher.model.z.n */
public abstract class C2488n {

    /* renamed from: com.criteo.publisher.model.z.n$a */
    static abstract class C2489a {
        C2489a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C2489a mo10441a(C2487m mVar);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C2489a mo10442a(C2492q qVar);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C2489a mo10443a(List<C2493r> list);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C2488n mo10444a();

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract C2489a mo10445b(List<C2491p> list);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C2488n mo10492b() {
            if (mo10446c().isEmpty()) {
                throw new JsonParseException("Expect that native payload has, at least, one product.");
            } else if (!mo10447d().isEmpty()) {
                return mo10444a();
            } else {
                throw new JsonParseException("Expect that native payload has, at least, one impression pixel.");
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract List<C2493r> mo10446c();

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public abstract List<C2491p> mo10447d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r2 = move-exception;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.criteo.publisher.model.p055z.C2488n m9386a(org.json.JSONObject r2) throws java.io.IOException {
        /*
            com.criteo.publisher.i r0 = com.criteo.publisher.C2387i.m9085U()
            com.criteo.publisher.a0.n r0 = r0.mo10292y()
            java.lang.String r2 = r2.toString()
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            byte[] r2 = r2.getBytes()
            r1.<init>(r2)
            java.lang.Class<com.criteo.publisher.model.z.n> r2 = com.criteo.publisher.model.p055z.C2488n.class
            java.lang.Object r2 = r0.mo10162a(r2, (java.io.InputStream) r1)     // Catch:{ all -> 0x0021 }
            com.criteo.publisher.model.z.n r2 = (com.criteo.publisher.model.p055z.C2488n) r2     // Catch:{ all -> 0x0021 }
            r1.close()
            return r2
        L_0x0021:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r2 = move-exception
            r1.close()     // Catch:{ all -> 0x0027 }
        L_0x0027:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.criteo.publisher.model.p055z.C2488n.m9386a(org.json.JSONObject):com.criteo.publisher.model.z.n");
    }

    /* renamed from: n */
    public static C2489a m9388n() {
        return new C2469b.C2470a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract C2487m mo10434a();

    /* renamed from: b */
    public String mo10483b() {
        return mo10434a().mo10427a();
    }

    /* renamed from: c */
    public String mo10484c() {
        return mo10434a().mo10428b();
    }

    /* renamed from: d */
    public URI mo10485d() {
        return mo10434a().mo10430d();
    }

    /* renamed from: e */
    public URL mo10486e() {
        return mo10434a().mo10429c().mo10448a();
    }

    /* renamed from: f */
    public List<URL> mo10487f() {
        ArrayList arrayList = new ArrayList();
        for (C2491p a : mo10437h()) {
            arrayList.add(a.mo10452a());
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @SerializedName("products")
    /* renamed from: g */
    public abstract List<C2493r> mo10436g();

    /* access modifiers changed from: package-private */
    @SerializedName("impressionPixels")
    /* renamed from: h */
    public abstract List<C2491p> mo10437h();

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public abstract C2492q mo10439i();

    /* renamed from: j */
    public String mo10488j() {
        return mo10439i().mo10458c();
    }

    /* renamed from: k */
    public URI mo10489k() {
        return mo10439i().mo10456a();
    }

    /* renamed from: l */
    public URL mo10490l() {
        return mo10439i().mo10457b();
    }

    /* renamed from: m */
    public C2493r mo10491m() {
        return mo10436g().iterator().next();
    }

    /* renamed from: a */
    public static TypeAdapter<C2488n> m9387a(Gson gson) {
        return new C2477h.C2478a(gson);
    }
}
