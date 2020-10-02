package p163cz.msebera.android.httpclient.p182g0;

import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5730g;
import p163cz.msebera.android.httpclient.C5898n;
import p163cz.msebera.android.httpclient.p183h0.C5756b;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.g0.a */
/* compiled from: AbstractHttpMessage */
public abstract class C5731a implements C5898n {

    /* renamed from: a */
    protected C5748r f14795a;
    @Deprecated

    /* renamed from: b */
    protected C5759e f14796b;

    @Deprecated
    protected C5731a(C5759e eVar) {
        this.f14795a = new C5748r();
        this.f14796b = eVar;
    }

    /* renamed from: a */
    public void mo33293a(C5691d dVar) {
        this.f14795a.mo33392a(dVar);
    }

    public void addHeader(String str, String str2) {
        C5886a.m18894a(str, "Header name");
        this.f14795a.mo33392a((C5691d) new C5732b(str, str2));
    }

    /* renamed from: b */
    public void mo33297b(C5691d dVar) {
        this.f14795a.mo33396b(dVar);
    }

    public boolean containsHeader(String str) {
        return this.f14795a.mo33394a(str);
    }

    public C5691d[] getAllHeaders() {
        return this.f14795a.mo33397b();
    }

    public C5691d getFirstHeader(String str) {
        return this.f14795a.mo33395b(str);
    }

    public C5691d[] getHeaders(String str) {
        return this.f14795a.mo33400c(str);
    }

    @Deprecated
    public C5759e getParams() {
        if (this.f14796b == null) {
            this.f14796b = new C5756b();
        }
        return this.f14796b;
    }

    public C5730g headerIterator() {
        return this.f14795a.mo33398c();
    }

    public void removeHeaders(String str) {
        if (str != null) {
            C5730g c = this.f14795a.mo33398c();
            while (c.hasNext()) {
                if (str.equalsIgnoreCase(c.nextHeader().getName())) {
                    c.remove();
                }
            }
        }
    }

    public void setHeader(String str, String str2) {
        C5886a.m18894a(str, "Header name");
        this.f14795a.mo33399c((C5691d) new C5732b(str, str2));
    }

    /* renamed from: a */
    public void mo33295a(C5691d[] dVarArr) {
        this.f14795a.mo33393a(dVarArr);
    }

    public C5730g headerIterator(String str) {
        return this.f14795a.mo33402d(str);
    }

    @Deprecated
    /* renamed from: a */
    public void mo33294a(C5759e eVar) {
        C5886a.m18894a(eVar, "HTTP parameters");
        this.f14796b = eVar;
    }

    protected C5731a() {
        this((C5759e) null);
    }
}
