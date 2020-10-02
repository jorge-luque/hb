package p163cz.msebera.android.httpclient.impl.auth;

import java.util.Locale;
import p163cz.msebera.android.httpclient.C5567c;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.auth.AuthenticationException;
import p163cz.msebera.android.httpclient.auth.C5557j;
import p163cz.msebera.android.httpclient.auth.C5558k;
import p163cz.msebera.android.httpclient.auth.C5559l;
import p163cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p163cz.msebera.android.httpclient.p186j0.C5874d;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.impl.auth.a */
/* compiled from: AuthSchemeBase */
public abstract class C5764a implements C5558k {

    /* renamed from: a */
    private C5557j f14862a;

    /* renamed from: a */
    public void mo32839a(C5691d dVar) throws MalformedChallengeException {
        int i;
        C5889d dVar2;
        C5886a.m18894a(dVar, "Header");
        String name = dVar.getName();
        if (name.equalsIgnoreCase("WWW-Authenticate")) {
            this.f14862a = C5557j.TARGET;
        } else if (name.equalsIgnoreCase("Proxy-Authenticate")) {
            this.f14862a = C5557j.PROXY;
        } else {
            throw new MalformedChallengeException("Unexpected header name: " + name);
        }
        if (dVar instanceof C5567c) {
            C5567c cVar = (C5567c) dVar;
            dVar2 = cVar.mo32887a();
            i = cVar.mo32888c();
        } else {
            String value = dVar.getValue();
            if (value != null) {
                dVar2 = new C5889d(value.length());
                dVar2.mo33670a(value);
                i = 0;
            } else {
                throw new MalformedChallengeException("Header value is null");
            }
        }
        while (i < dVar2.length() && C5874d.m18865a(dVar2.charAt(i))) {
            i++;
        }
        int i2 = i;
        while (i2 < dVar2.length() && !C5874d.m18865a(dVar2.charAt(i2))) {
            i2++;
        }
        String a = dVar2.mo33665a(i, i2);
        if (a.equalsIgnoreCase(mo32842d())) {
            mo33434a(dVar2, i2, dVar2.length());
            return;
        }
        throw new MalformedChallengeException("Invalid scheme identifier: " + a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo33434a(C5889d dVar, int i, int i2) throws MalformedChallengeException;

    /* renamed from: e */
    public boolean mo33435e() {
        C5557j jVar = this.f14862a;
        return jVar != null && jVar == C5557j.PROXY;
    }

    public String toString() {
        String d = mo32842d();
        if (d != null) {
            return d.toUpperCase(Locale.ROOT);
        }
        return super.toString();
    }

    /* renamed from: a */
    public C5691d mo32867a(C5559l lVar, C5899o oVar, C5875e eVar) throws AuthenticationException {
        return mo32837a(lVar, oVar);
    }
}
