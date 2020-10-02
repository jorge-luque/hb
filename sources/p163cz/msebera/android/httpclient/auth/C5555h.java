package p163cz.msebera.android.httpclient.auth;

import java.util.Queue;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.auth.h */
/* compiled from: AuthState */
public class C5555h {

    /* renamed from: a */
    private C5548b f14508a = C5548b.UNCHALLENGED;

    /* renamed from: b */
    private C5549c f14509b;

    /* renamed from: c */
    private C5559l f14510c;

    /* renamed from: d */
    private Queue<C5547a> f14511d;

    /* renamed from: a */
    public void mo32853a(C5548b bVar) {
        if (bVar == null) {
            bVar = C5548b.UNCHALLENGED;
        }
        this.f14508a = bVar;
    }

    /* renamed from: b */
    public C5549c mo32858b() {
        return this.f14509b;
    }

    /* renamed from: c */
    public C5559l mo32859c() {
        return this.f14510c;
    }

    /* renamed from: d */
    public C5548b mo32860d() {
        return this.f14508a;
    }

    /* renamed from: e */
    public void mo32861e() {
        this.f14508a = C5548b.UNCHALLENGED;
        this.f14511d = null;
        this.f14509b = null;
        this.f14510c = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("state:");
        sb.append(this.f14508a);
        sb.append(";");
        if (this.f14509b != null) {
            sb.append("auth scheme:");
            sb.append(this.f14509b.mo32842d());
            sb.append(";");
        }
        if (this.f14510c != null) {
            sb.append("credentials present");
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void mo32855a(C5549c cVar, C5559l lVar) {
        C5886a.m18894a(cVar, "Auth scheme");
        C5886a.m18894a(lVar, "Credentials");
        this.f14509b = cVar;
        this.f14510c = lVar;
        this.f14511d = null;
    }

    /* renamed from: a */
    public Queue<C5547a> mo32852a() {
        return this.f14511d;
    }

    /* renamed from: a */
    public void mo32857a(Queue<C5547a> queue) {
        C5886a.m18895a(queue, "Queue of auth options");
        this.f14511d = queue;
        this.f14509b = null;
        this.f14510c = null;
    }

    @Deprecated
    /* renamed from: a */
    public void mo32854a(C5549c cVar) {
        if (cVar == null) {
            mo32861e();
        } else {
            this.f14509b = cVar;
        }
    }

    @Deprecated
    /* renamed from: a */
    public void mo32856a(C5559l lVar) {
        this.f14510c = lVar;
    }
}
