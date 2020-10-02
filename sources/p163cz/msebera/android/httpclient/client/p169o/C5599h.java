package p163cz.msebera.android.httpclient.client.p169o;

import java.net.URI;
import p163cz.msebera.android.httpclient.C5907v;
import p163cz.msebera.android.httpclient.C5909x;
import p163cz.msebera.android.httpclient.client.p167m.C5587a;
import p163cz.msebera.android.httpclient.p182g0.C5744n;
import p163cz.msebera.android.httpclient.p183h0.C5760f;

/* renamed from: cz.msebera.android.httpclient.client.o.h */
/* compiled from: HttpRequestBase */
public abstract class C5599h extends C5591b implements C5600i, C5595d {

    /* renamed from: e */
    private C5907v f14579e;

    /* renamed from: f */
    private URI f14580f;

    /* renamed from: g */
    private C5587a f14581g;

    /* renamed from: a */
    public void mo32964a(C5907v vVar) {
        this.f14579e = vVar;
    }

    public C5587a getConfig() {
        return this.f14581g;
    }

    public abstract String getMethod();

    public C5907v getProtocolVersion() {
        C5907v vVar = this.f14579e;
        return vVar != null ? vVar : C5760f.m18361b(getParams());
    }

    public C5909x getRequestLine() {
        String method = getMethod();
        C5907v protocolVersion = getProtocolVersion();
        URI uri = getURI();
        String aSCIIString = uri != null ? uri.toASCIIString() : null;
        if (aSCIIString == null || aSCIIString.isEmpty()) {
            aSCIIString = "/";
        }
        return new C5744n(method, aSCIIString, protocolVersion);
    }

    public URI getURI() {
        return this.f14580f;
    }

    public String toString() {
        return getMethod() + " " + getURI() + " " + getProtocolVersion();
    }

    /* renamed from: a */
    public void mo32963a(C5587a aVar) {
        this.f14581g = aVar;
    }

    /* renamed from: a */
    public void mo32965a(URI uri) {
        this.f14580f = uri;
    }
}
