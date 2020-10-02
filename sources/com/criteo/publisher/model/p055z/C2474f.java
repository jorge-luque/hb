package com.criteo.publisher.model.p055z;

import java.net.URI;

/* renamed from: com.criteo.publisher.model.z.f */
abstract class C2474f extends C2493r {

    /* renamed from: a */
    private final String f7957a;

    /* renamed from: b */
    private final String f7958b;

    /* renamed from: c */
    private final String f7959c;

    /* renamed from: d */
    private final URI f7960d;

    /* renamed from: e */
    private final String f7961e;

    /* renamed from: f */
    private final C2490o f7962f;

    C2474f(String str, String str2, String str3, URI uri, String str4, C2490o oVar) {
        if (str != null) {
            this.f7957a = str;
            if (str2 != null) {
                this.f7958b = str2;
                if (str3 != null) {
                    this.f7959c = str3;
                    if (uri != null) {
                        this.f7960d = uri;
                        if (str4 != null) {
                            this.f7961e = str4;
                            if (oVar != null) {
                                this.f7962f = oVar;
                                return;
                            }
                            throw new NullPointerException("Null image");
                        }
                        throw new NullPointerException("Null callToAction");
                    }
                    throw new NullPointerException("Null clickUrl");
                }
                throw new NullPointerException("Null price");
            }
            throw new NullPointerException("Null description");
        }
        throw new NullPointerException("Null title");
    }

    /* renamed from: a */
    public String mo10462a() {
        return this.f7961e;
    }

    /* renamed from: b */
    public URI mo10463b() {
        return this.f7960d;
    }

    /* renamed from: c */
    public String mo10464c() {
        return this.f7958b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C2490o mo10465d() {
        return this.f7962f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2493r)) {
            return false;
        }
        C2493r rVar = (C2493r) obj;
        if (!this.f7957a.equals(rVar.mo10468g()) || !this.f7958b.equals(rVar.mo10464c()) || !this.f7959c.equals(rVar.mo10467f()) || !this.f7960d.equals(rVar.mo10463b()) || !this.f7961e.equals(rVar.mo10462a()) || !this.f7962f.equals(rVar.mo10465d())) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public String mo10467f() {
        return this.f7959c;
    }

    /* renamed from: g */
    public String mo10468g() {
        return this.f7957a;
    }

    public int hashCode() {
        return ((((((((((this.f7957a.hashCode() ^ 1000003) * 1000003) ^ this.f7958b.hashCode()) * 1000003) ^ this.f7959c.hashCode()) * 1000003) ^ this.f7960d.hashCode()) * 1000003) ^ this.f7961e.hashCode()) * 1000003) ^ this.f7962f.hashCode();
    }

    public String toString() {
        return "NativeProduct{title=" + this.f7957a + ", description=" + this.f7958b + ", price=" + this.f7959c + ", clickUrl=" + this.f7960d + ", callToAction=" + this.f7961e + ", image=" + this.f7962f + "}";
    }
}
