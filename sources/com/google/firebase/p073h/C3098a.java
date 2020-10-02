package com.google.firebase.p073h;

import javax.annotation.Nonnull;

/* renamed from: com.google.firebase.h.a */
/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
final class C3098a extends C3099f {

    /* renamed from: a */
    private final String f8639a;

    /* renamed from: b */
    private final String f8640b;

    C3098a(String str, String str2) {
        if (str != null) {
            this.f8639a = str;
            if (str2 != null) {
                this.f8640b = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    @Nonnull
    /* renamed from: a */
    public String mo18328a() {
        return this.f8639a;
    }

    @Nonnull
    /* renamed from: b */
    public String mo18329b() {
        return this.f8640b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3099f)) {
            return false;
        }
        C3099f fVar = (C3099f) obj;
        if (!this.f8639a.equals(fVar.mo18328a()) || !this.f8640b.equals(fVar.mo18329b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f8639a.hashCode() ^ 1000003) * 1000003) ^ this.f8640b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f8639a + ", version=" + this.f8640b + "}";
    }
}
