package p163cz.msebera.android.httpclient.p186j0;

import java.io.IOException;
import p163cz.msebera.android.httpclient.C5754h;
import p163cz.msebera.android.httpclient.C5885k;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.C5905t;
import p163cz.msebera.android.httpclient.C5907v;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.ProtocolException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.j0.h */
/* compiled from: HttpRequestExecutor */
public class C5878h {

    /* renamed from: a */
    private final int f15108a;

    public C5878h(int i) {
        C5886a.m18898b(i, "Wait for continue time");
        this.f15108a = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo33649a(C5899o oVar, C5901q qVar) {
        int a;
        if ("HEAD".equalsIgnoreCase(oVar.getRequestLine().getMethod()) || (a = qVar.mo33335a().mo33371a()) < 200 || a == 204 || a == 304 || a == 205) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C5901q mo33650b(C5899o oVar, C5754h hVar, C5875e eVar) throws IOException, HttpException {
        C5886a.m18894a(oVar, "HTTP request");
        C5886a.m18894a(hVar, "Client connection");
        C5886a.m18894a(eVar, "HTTP context");
        eVar.mo33535a("http.connection", hVar);
        eVar.mo33535a("http.request_sent", Boolean.FALSE);
        hVar.mo33189a(oVar);
        C5901q qVar = null;
        if (oVar instanceof C5885k) {
            boolean z = true;
            C5907v protocolVersion = oVar.getRequestLine().getProtocolVersion();
            C5885k kVar = (C5885k) oVar;
            if (kVar.expectContinue() && !protocolVersion.mo33701c(C5905t.f15129e)) {
                hVar.flush();
                if (hVar.mo33193h(this.f15108a)) {
                    C5901q R = hVar.mo33182R();
                    if (mo33649a(oVar, R)) {
                        hVar.mo33190a(R);
                    }
                    int a = R.mo33335a().mo33371a();
                    if (a >= 200) {
                        z = false;
                        qVar = R;
                    } else if (a != 100) {
                        throw new ProtocolException("Unexpected response: " + R.mo33335a());
                    }
                }
            }
            if (z) {
                hVar.mo33188a(kVar);
            }
        }
        hVar.flush();
        eVar.mo33535a("http.request_sent", Boolean.TRUE);
        return qVar;
    }

    /* renamed from: c */
    public C5901q mo33651c(C5899o oVar, C5754h hVar, C5875e eVar) throws IOException, HttpException {
        C5886a.m18894a(oVar, "HTTP request");
        C5886a.m18894a(hVar, "Client connection");
        C5886a.m18894a(eVar, "HTTP context");
        try {
            C5901q b = mo33650b(oVar, hVar, eVar);
            return b == null ? mo33646a(oVar, hVar, eVar) : b;
        } catch (IOException e) {
            m18876a(hVar);
            throw e;
        } catch (HttpException e2) {
            m18876a(hVar);
            throw e2;
        } catch (RuntimeException e3) {
            m18876a(hVar);
            throw e3;
        }
    }

    public C5878h() {
        this(3000);
    }

    /* renamed from: a */
    private static void m18876a(C5754h hVar) {
        try {
            hVar.close();
        } catch (IOException unused) {
        }
    }

    /* renamed from: a */
    public void mo33647a(C5899o oVar, C5877g gVar, C5875e eVar) throws HttpException, IOException {
        C5886a.m18894a(oVar, "HTTP request");
        C5886a.m18894a(gVar, "HTTP processor");
        C5886a.m18894a(eVar, "HTTP context");
        eVar.mo33535a("http.request", oVar);
        gVar.mo28845a(oVar, eVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5901q mo33646a(C5899o oVar, C5754h hVar, C5875e eVar) throws HttpException, IOException {
        C5886a.m18894a(oVar, "HTTP request");
        C5886a.m18894a(hVar, "Client connection");
        C5886a.m18894a(eVar, "HTTP context");
        C5901q qVar = null;
        int i = 0;
        while (true) {
            if (qVar != null && i >= 200) {
                return qVar;
            }
            qVar = hVar.mo33182R();
            if (mo33649a(oVar, qVar)) {
                hVar.mo33190a(qVar);
            }
            i = qVar.mo33335a().mo33371a();
        }
    }

    /* renamed from: a */
    public void mo33648a(C5901q qVar, C5877g gVar, C5875e eVar) throws HttpException, IOException {
        C5886a.m18894a(qVar, "HTTP response");
        C5886a.m18894a(gVar, "HTTP processor");
        C5886a.m18894a(eVar, "HTTP context");
        eVar.mo33535a("http.response", qVar);
        gVar.mo28846a(qVar, eVar);
    }
}
