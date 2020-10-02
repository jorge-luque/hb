package com.criteo.publisher.model.p055z;

import java.net.URI;

/* renamed from: com.criteo.publisher.model.z.a */
abstract class C2468a extends C2487m {

    /* renamed from: a */
    private final String f7940a;

    /* renamed from: b */
    private final String f7941b;

    /* renamed from: c */
    private final URI f7942c;

    /* renamed from: d */
    private final C2490o f7943d;

    C2468a(String str, String str2, URI uri, C2490o oVar) {
        if (str != null) {
            this.f7940a = str;
            if (str2 != null) {
                this.f7941b = str2;
                if (uri != null) {
                    this.f7942c = uri;
                    if (oVar != null) {
                        this.f7943d = oVar;
                        return;
                    }
                    throw new NullPointerException("Null logo");
                }
                throw new NullPointerException("Null logoClickUrl");
            }
            throw new NullPointerException("Null description");
        }
        throw new NullPointerException("Null domain");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo10427a() {
        return this.f7941b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo10428b() {
        return this.f7940a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C2490o mo10429c() {
        return this.f7943d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public URI mo10430d() {
        return this.f7942c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2487m)) {
            return false;
        }
        C2487m mVar = (C2487m) obj;
        if (!this.f7940a.equals(mVar.mo10428b()) || !this.f7941b.equals(mVar.mo10427a()) || !this.f7942c.equals(mVar.mo10430d()) || !this.f7943d.equals(mVar.mo10429c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((this.f7940a.hashCode() ^ 1000003) * 1000003) ^ this.f7941b.hashCode()) * 1000003) ^ this.f7942c.hashCode()) * 1000003) ^ this.f7943d.hashCode();
    }

    public String toString() {
        return "NativeAdvertiser{domain=" + this.f7940a + ", description=" + this.f7941b + ", logoClickUrl=" + this.f7942c + ", logo=" + this.f7943d + "}";
    }
}
