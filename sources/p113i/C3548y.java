package p113i;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import p113i.C3537r;
import p113i.p114e0.C3500c;
import p113i.p114e0.p116f.C5941f;

/* renamed from: i.y */
/* compiled from: Request */
public final class C3548y {

    /* renamed from: a */
    final C3539s f9947a;

    /* renamed from: b */
    final String f9948b;

    /* renamed from: c */
    final C3537r f9949c;
    @Nullable

    /* renamed from: d */
    final C3550z f9950d;

    /* renamed from: e */
    final Map<Class<?>, Object> f9951e;
    @Nullable

    /* renamed from: f */
    private volatile C3495d f9952f;

    C3548y(C3549a aVar) {
        this.f9947a = aVar.f9953a;
        this.f9948b = aVar.f9954b;
        this.f9949c = aVar.f9955c.mo19511a();
        this.f9950d = aVar.f9956d;
        this.f9951e = C3500c.m11645a(aVar.f9957e);
    }

    @Nullable
    /* renamed from: a */
    public String mo19600a(String str) {
        return this.f9949c.mo19502a(str);
    }

    /* renamed from: b */
    public List<String> mo19602b(String str) {
        return this.f9949c.mo19505b(str);
    }

    /* renamed from: c */
    public C3537r mo19603c() {
        return this.f9949c;
    }

    /* renamed from: d */
    public boolean mo19604d() {
        return this.f9947a.mo19526h();
    }

    /* renamed from: e */
    public String mo19605e() {
        return this.f9948b;
    }

    /* renamed from: f */
    public C3549a mo19606f() {
        return new C3549a(this);
    }

    /* renamed from: g */
    public C3539s mo19607g() {
        return this.f9947a;
    }

    public String toString() {
        return "Request{method=" + this.f9948b + ", url=" + this.f9947a + ", tags=" + this.f9951e + '}';
    }

    /* renamed from: i.y$a */
    /* compiled from: Request */
    public static class C3549a {
        @Nullable

        /* renamed from: a */
        C3539s f9953a;

        /* renamed from: b */
        String f9954b;

        /* renamed from: c */
        C3537r.C3538a f9955c;
        @Nullable

        /* renamed from: d */
        C3550z f9956d;

        /* renamed from: e */
        Map<Class<?>, Object> f9957e;

        public C3549a() {
            this.f9957e = Collections.emptyMap();
            this.f9954b = "GET";
            this.f9955c = new C3537r.C3538a();
        }

        /* renamed from: a */
        public C3549a mo19611a(C3539s sVar) {
            if (sVar != null) {
                this.f9953a = sVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: b */
        public C3549a mo19618b(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                mo19611a(C3539s.m11858d(str));
                return this;
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: a */
        public C3549a mo19615a(String str, String str2) {
            this.f9955c.mo19510a(str, str2);
            return this;
        }

        /* renamed from: a */
        public C3549a mo19613a(String str) {
            this.f9955c.mo19514c(str);
            return this;
        }

        C3549a(C3548y yVar) {
            Map<Class<?>, Object> map;
            this.f9957e = Collections.emptyMap();
            this.f9953a = yVar.f9947a;
            this.f9954b = yVar.f9948b;
            this.f9956d = yVar.f9950d;
            if (yVar.f9951e.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = new LinkedHashMap<>(yVar.f9951e);
            }
            this.f9957e = map;
            this.f9955c = yVar.f9949c.mo19500a();
        }

        /* renamed from: a */
        public C3549a mo19610a(C3537r rVar) {
            this.f9955c = rVar.mo19500a();
            return this;
        }

        /* renamed from: a */
        public C3549a mo19609a(C3495d dVar) {
            String dVar2 = dVar.toString();
            if (dVar2.isEmpty()) {
                mo19613a("Cache-Control");
                return this;
            }
            mo19619b("Cache-Control", dVar2);
            return this;
        }

        /* renamed from: b */
        public C3549a mo19619b(String str, String str2) {
            this.f9955c.mo19515c(str, str2);
            return this;
        }

        /* renamed from: b */
        public C3549a mo19617b() {
            mo19614a("GET", (C3550z) null);
            return this;
        }

        /* renamed from: a */
        public C3549a mo19612a(C3550z zVar) {
            mo19614a("POST", zVar);
            return this;
        }

        /* renamed from: a */
        public C3549a mo19614a(String str, @Nullable C3550z zVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (zVar != null && !C5941f.m19042b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (zVar != null || !C5941f.m19045e(str)) {
                this.f9954b = str;
                this.f9956d = zVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        /* renamed from: a */
        public C3548y mo19616a() {
            if (this.f9953a != null) {
                return new C3548y(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    @Nullable
    /* renamed from: a */
    public C3550z mo19599a() {
        return this.f9950d;
    }

    /* renamed from: b */
    public C3495d mo19601b() {
        C3495d dVar = this.f9952f;
        if (dVar != null) {
            return dVar;
        }
        C3495d a = C3495d.m11602a(this.f9949c);
        this.f9952f = a;
        return a;
    }
}
