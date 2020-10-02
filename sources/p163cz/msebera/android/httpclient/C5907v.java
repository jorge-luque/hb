package p163cz.msebera.android.httpclient;

import java.io.Serializable;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.v */
/* compiled from: ProtocolVersion */
public class C5907v implements Serializable, Cloneable {
    private static final long serialVersionUID = 8950662842175091068L;

    /* renamed from: a */
    protected final String f15131a;

    /* renamed from: b */
    protected final int f15132b;

    /* renamed from: c */
    protected final int f15133c;

    public C5907v(String str, int i, int i2) {
        C5886a.m18894a(str, "Protocol name");
        this.f15131a = str;
        C5886a.m18891a(i, "Protocol minor version");
        this.f15132b = i;
        C5886a.m18891a(i2, "Protocol minor version");
        this.f15133c = i2;
    }

    /* renamed from: a */
    public final int mo33696a() {
        return this.f15132b;
    }

    /* renamed from: b */
    public final int mo33698b() {
        return this.f15133c;
    }

    /* renamed from: c */
    public final String mo33700c() {
        return this.f15131a;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5907v)) {
            return false;
        }
        C5907v vVar = (C5907v) obj;
        if (this.f15131a.equals(vVar.f15131a) && this.f15132b == vVar.f15132b && this.f15133c == vVar.f15133c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f15131a.hashCode() ^ (this.f15132b * 100000)) ^ this.f15133c;
    }

    public String toString() {
        return this.f15131a + '/' + Integer.toString(this.f15132b) + '.' + Integer.toString(this.f15133c);
    }

    /* renamed from: a */
    public C5907v mo33695a(int i, int i2) {
        if (i == this.f15132b && i2 == this.f15133c) {
            return this;
        }
        return new C5907v(this.f15131a, i, i2);
    }

    /* renamed from: b */
    public boolean mo33699b(C5907v vVar) {
        return vVar != null && this.f15131a.equals(vVar.f15131a);
    }

    /* renamed from: c */
    public final boolean mo33701c(C5907v vVar) {
        return mo33699b(vVar) && mo33697a(vVar) <= 0;
    }

    /* renamed from: a */
    public int mo33697a(C5907v vVar) {
        C5886a.m18894a(vVar, "Protocol version");
        C5886a.m18897a(this.f15131a.equals(vVar.f15131a), "Versions for different protocols cannot be compared: %s %s", this, vVar);
        int a = mo33696a() - vVar.mo33696a();
        return a == 0 ? mo33698b() - vVar.mo33698b() : a;
    }
}
