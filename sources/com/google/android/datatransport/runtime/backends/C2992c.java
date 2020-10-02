package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import p093e.p101c.p102a.p103a.p104i.p109w.C3469a;

/* renamed from: com.google.android.datatransport.runtime.backends.c */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class C2992c extends C2999h {

    /* renamed from: a */
    private final Context f8346a;

    /* renamed from: b */
    private final C3469a f8347b;

    /* renamed from: c */
    private final C3469a f8348c;

    /* renamed from: d */
    private final String f8349d;

    C2992c(Context context, C3469a aVar, C3469a aVar2, String str) {
        if (context != null) {
            this.f8346a = context;
            if (aVar != null) {
                this.f8347b = aVar;
                if (aVar2 != null) {
                    this.f8348c = aVar2;
                    if (str != null) {
                        this.f8349d = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    /* renamed from: a */
    public Context mo12960a() {
        return this.f8346a;
    }

    /* renamed from: b */
    public String mo12961b() {
        return this.f8349d;
    }

    /* renamed from: c */
    public C3469a mo12962c() {
        return this.f8348c;
    }

    /* renamed from: d */
    public C3469a mo12963d() {
        return this.f8347b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2999h)) {
            return false;
        }
        C2999h hVar = (C2999h) obj;
        if (!this.f8346a.equals(hVar.mo12960a()) || !this.f8347b.equals(hVar.mo12963d()) || !this.f8348c.equals(hVar.mo12962c()) || !this.f8349d.equals(hVar.mo12961b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((this.f8346a.hashCode() ^ 1000003) * 1000003) ^ this.f8347b.hashCode()) * 1000003) ^ this.f8348c.hashCode()) * 1000003) ^ this.f8349d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f8346a + ", wallClock=" + this.f8347b + ", monotonicClock=" + this.f8348c + ", backendName=" + this.f8349d + "}";
    }
}
