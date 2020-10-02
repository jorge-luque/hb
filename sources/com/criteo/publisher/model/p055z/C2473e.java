package com.criteo.publisher.model.p055z;

import com.google.gson.annotations.SerializedName;
import java.net.URI;
import java.net.URL;

/* renamed from: com.criteo.publisher.model.z.e */
abstract class C2473e extends C2492q {

    /* renamed from: a */
    private final URI f7954a;

    /* renamed from: b */
    private final URL f7955b;

    /* renamed from: c */
    private final String f7956c;

    C2473e(URI uri, URL url, String str) {
        if (uri != null) {
            this.f7954a = uri;
            if (url != null) {
                this.f7955b = url;
                if (str != null) {
                    this.f7956c = str;
                    return;
                }
                throw new NullPointerException("Null legalText");
            }
            throw new NullPointerException("Null imageUrl");
        }
        throw new NullPointerException("Null clickUrl");
    }

    /* access modifiers changed from: package-private */
    @SerializedName("optoutClickUrl")
    /* renamed from: a */
    public URI mo10456a() {
        return this.f7954a;
    }

    /* access modifiers changed from: package-private */
    @SerializedName("optoutImageUrl")
    /* renamed from: b */
    public URL mo10457b() {
        return this.f7955b;
    }

    /* access modifiers changed from: package-private */
    @SerializedName("longLegalText")
    /* renamed from: c */
    public String mo10458c() {
        return this.f7956c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2492q)) {
            return false;
        }
        C2492q qVar = (C2492q) obj;
        if (!this.f7954a.equals(qVar.mo10456a()) || !this.f7955b.equals(qVar.mo10457b()) || !this.f7956c.equals(qVar.mo10458c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.f7954a.hashCode() ^ 1000003) * 1000003) ^ this.f7955b.hashCode()) * 1000003) ^ this.f7956c.hashCode();
    }

    public String toString() {
        return "NativePrivacy{clickUrl=" + this.f7954a + ", imageUrl=" + this.f7955b + ", legalText=" + this.f7956c + "}";
    }
}
