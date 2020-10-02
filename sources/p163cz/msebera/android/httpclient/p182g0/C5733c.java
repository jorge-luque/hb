package p163cz.msebera.android.httpclient.p182g0;

import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.C5906u;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5893h;

/* renamed from: cz.msebera.android.httpclient.g0.c */
/* compiled from: BasicHeaderElement */
public class C5733c implements C5696e, Cloneable {

    /* renamed from: a */
    private final String f14799a;

    /* renamed from: b */
    private final String f14800b;

    /* renamed from: c */
    private final C5906u[] f14801c;

    public C5733c(String str, String str2, C5906u[] uVarArr) {
        C5886a.m18894a(str, "Name");
        this.f14799a = str;
        this.f14800b = str2;
        if (uVarArr != null) {
            this.f14801c = uVarArr;
        } else {
            this.f14801c = new C5906u[0];
        }
    }

    /* renamed from: a */
    public int mo33176a() {
        return this.f14801c.length;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5696e)) {
            return false;
        }
        C5733c cVar = (C5733c) obj;
        if (!this.f14799a.equals(cVar.f14799a) || !C5893h.m18940a((Object) this.f14800b, (Object) cVar.f14800b) || !C5893h.m18941a((Object[]) this.f14801c, (Object[]) cVar.f14801c)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return this.f14799a;
    }

    public C5906u[] getParameters() {
        return (C5906u[]) this.f14801c.clone();
    }

    public String getValue() {
        return this.f14800b;
    }

    public int hashCode() {
        int a = C5893h.m18938a(C5893h.m18938a(17, (Object) this.f14799a), (Object) this.f14800b);
        for (C5906u a2 : this.f14801c) {
            a = C5893h.m18938a(a, (Object) a2);
        }
        return a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14799a);
        if (this.f14800b != null) {
            sb.append("=");
            sb.append(this.f14800b);
        }
        for (C5906u append : this.f14801c) {
            sb.append("; ");
            sb.append(append);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public C5906u mo33177a(int i) {
        return this.f14801c[i];
    }

    /* renamed from: a */
    public C5906u mo33178a(String str) {
        C5886a.m18894a(str, "Name");
        for (C5906u uVar : this.f14801c) {
            if (uVar.getName().equalsIgnoreCase(str)) {
                return uVar;
            }
        }
        return null;
    }

    public C5733c(String str, String str2) {
        this(str, str2, (C5906u[]) null);
    }
}
