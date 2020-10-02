package androidx.media;

import android.text.TextUtils;
import androidx.core.p019e.C0790c;

/* renamed from: androidx.media.h */
/* compiled from: MediaSessionManagerImplBase */
class C1016h implements C1014f {

    /* renamed from: a */
    private String f2587a;

    /* renamed from: b */
    private int f2588b;

    /* renamed from: c */
    private int f2589c;

    C1016h(String str, int i, int i2) {
        this.f2587a = str;
        this.f2588b = i;
        this.f2589c = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1016h)) {
            return false;
        }
        C1016h hVar = (C1016h) obj;
        if (TextUtils.equals(this.f2587a, hVar.f2587a) && this.f2588b == hVar.f2588b && this.f2589c == hVar.f2589c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return C0790c.m2493a(this.f2587a, Integer.valueOf(this.f2588b), Integer.valueOf(this.f2589c));
    }
}
