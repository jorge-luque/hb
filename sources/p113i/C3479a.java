package p113i;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import p113i.C3539s;
import p113i.p114e0.C3500c;

/* renamed from: i.a */
/* compiled from: Address */
public final class C3479a {

    /* renamed from: a */
    final C3539s f9597a;

    /* renamed from: b */
    final C5968o f9598b;

    /* renamed from: c */
    final SocketFactory f9599c;

    /* renamed from: d */
    final C3482b f9600d;

    /* renamed from: e */
    final List<C5972w> f9601e;

    /* renamed from: f */
    final List<C3528k> f9602f;

    /* renamed from: g */
    final ProxySelector f9603g;
    @Nullable

    /* renamed from: h */
    final Proxy f9604h;
    @Nullable

    /* renamed from: i */
    final SSLSocketFactory f9605i;
    @Nullable

    /* renamed from: j */
    final HostnameVerifier f9606j;
    @Nullable

    /* renamed from: k */
    final C3522g f9607k;

    public C3479a(String str, int i, C5968o oVar, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable C3522g gVar, C3482b bVar, @Nullable Proxy proxy, List<C5972w> list, List<C3528k> list2, ProxySelector proxySelector) {
        C3539s.C3540a aVar = new C3539s.C3540a();
        aVar.mo19545d(sSLSocketFactory != null ? "https" : "http");
        aVar.mo19542b(str);
        aVar.mo19536a(i);
        this.f9597a = aVar.mo19540a();
        if (oVar != null) {
            this.f9598b = oVar;
            if (socketFactory != null) {
                this.f9599c = socketFactory;
                if (bVar != null) {
                    this.f9600d = bVar;
                    if (list != null) {
                        this.f9601e = C3500c.m11643a(list);
                        if (list2 != null) {
                            this.f9602f = C3500c.m11643a(list2);
                            if (proxySelector != null) {
                                this.f9603g = proxySelector;
                                this.f9604h = proxy;
                                this.f9605i = sSLSocketFactory;
                                this.f9606j = hostnameVerifier;
                                this.f9607k = gVar;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    @Nullable
    /* renamed from: a */
    public C3522g mo19259a() {
        return this.f9607k;
    }

    /* renamed from: b */
    public List<C3528k> mo19261b() {
        return this.f9602f;
    }

    /* renamed from: c */
    public C5968o mo19262c() {
        return this.f9598b;
    }

    @Nullable
    /* renamed from: d */
    public HostnameVerifier mo19263d() {
        return this.f9606j;
    }

    /* renamed from: e */
    public List<C5972w> mo19264e() {
        return this.f9601e;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C3479a) {
            C3479a aVar = (C3479a) obj;
            return this.f9597a.equals(aVar.f9597a) && mo19260a(aVar);
        }
    }

    @Nullable
    /* renamed from: f */
    public Proxy mo19266f() {
        return this.f9604h;
    }

    /* renamed from: g */
    public C3482b mo19267g() {
        return this.f9600d;
    }

    /* renamed from: h */
    public ProxySelector mo19268h() {
        return this.f9603g;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f9597a.hashCode()) * 31) + this.f9598b.hashCode()) * 31) + this.f9600d.hashCode()) * 31) + this.f9601e.hashCode()) * 31) + this.f9602f.hashCode()) * 31) + this.f9603g.hashCode()) * 31;
        Proxy proxy = this.f9604h;
        int i = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f9605i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f9606j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        C3522g gVar = this.f9607k;
        if (gVar != null) {
            i = gVar.hashCode();
        }
        return hashCode4 + i;
    }

    /* renamed from: i */
    public SocketFactory mo19270i() {
        return this.f9599c;
    }

    @Nullable
    /* renamed from: j */
    public SSLSocketFactory mo19271j() {
        return this.f9605i;
    }

    /* renamed from: k */
    public C3539s mo19272k() {
        return this.f9597a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f9597a.mo19525g());
        sb.append(":");
        sb.append(this.f9597a.mo19530k());
        if (this.f9604h != null) {
            sb.append(", proxy=");
            sb.append(this.f9604h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f9603g);
        }
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo19260a(C3479a aVar) {
        return this.f9598b.equals(aVar.f9598b) && this.f9600d.equals(aVar.f9600d) && this.f9601e.equals(aVar.f9601e) && this.f9602f.equals(aVar.f9602f) && this.f9603g.equals(aVar.f9603g) && C3500c.m11654a((Object) this.f9604h, (Object) aVar.f9604h) && C3500c.m11654a((Object) this.f9605i, (Object) aVar.f9605i) && C3500c.m11654a((Object) this.f9606j, (Object) aVar.f9606j) && C3500c.m11654a((Object) this.f9607k, (Object) aVar.f9607k) && mo19272k().mo19530k() == aVar.mo19272k().mo19530k();
    }
}
