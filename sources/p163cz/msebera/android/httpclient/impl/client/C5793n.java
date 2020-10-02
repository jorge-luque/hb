package p163cz.msebera.android.httpclient.impl.client;

import admost.sdk.base.AdMost;
import com.facebook.places.model.PlaceFields;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5896l;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.ProtocolException;
import p163cz.msebera.android.httpclient.client.C5584j;
import p163cz.msebera.android.httpclient.client.CircularRedirectException;
import p163cz.msebera.android.httpclient.client.p167m.C5587a;
import p163cz.msebera.android.httpclient.client.p169o.C5597f;
import p163cz.msebera.android.httpclient.client.p169o.C5598g;
import p163cz.msebera.android.httpclient.client.p169o.C5600i;
import p163cz.msebera.android.httpclient.client.p169o.C5601j;
import p163cz.msebera.android.httpclient.client.p171q.C5606a;
import p163cz.msebera.android.httpclient.client.p172r.C5620c;
import p163cz.msebera.android.httpclient.client.p172r.C5621d;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5887b;
import p163cz.msebera.android.httpclient.p187k0.C5894i;

/* renamed from: cz.msebera.android.httpclient.impl.client.n */
/* compiled from: DefaultRedirectStrategy */
public class C5793n implements C5584j {

    /* renamed from: b */
    private static final String[] f14939b = {"GET", "HEAD"};

    /* renamed from: a */
    public C5695b f14940a = new C5695b(C5793n.class);

    static {
        new C5793n();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public URI mo33503a(String str) throws ProtocolException {
        try {
            C5620c cVar = new C5620c(new URI(str).normalize());
            String c = cVar.mo32996c();
            if (c != null) {
                cVar.mo32994b(c.toLowerCase(Locale.ROOT));
            }
            if (C5894i.m18944c(cVar.mo32998d())) {
                cVar.mo32995c("/");
            }
            return cVar.mo32992a();
        } catch (URISyntaxException e) {
            throw new ProtocolException("Invalid redirect URI: " + str, e);
        }
    }

    /* renamed from: b */
    public boolean mo32927b(C5899o oVar, C5901q qVar, C5875e eVar) throws ProtocolException {
        C5886a.m18894a(oVar, "HTTP request");
        C5886a.m18894a(qVar, "HTTP response");
        int a = qVar.mo33335a().mo33371a();
        String method = oVar.getRequestLine().getMethod();
        C5691d firstHeader = qVar.getFirstHeader(PlaceFields.LOCATION);
        if (a != 307) {
            switch (a) {
                case AdMost.AD_ERROR_FREQ_CAP_ON_SHOWN:
                    break;
                case AdMost.AD_ERROR_TAG_PASSIVE:
                    if (!mo33504b(method) || firstHeader == null) {
                        return false;
                    }
                    return true;
                case AdMost.AD_ERROR_ZONE_PASSIVE:
                    return true;
                default:
                    return false;
            }
        }
        return mo33504b(method);
    }

    /* renamed from: c */
    public URI mo33505c(C5899o oVar, C5901q qVar, C5875e eVar) throws ProtocolException {
        C5886a.m18894a(oVar, "HTTP request");
        C5886a.m18894a(qVar, "HTTP response");
        C5886a.m18894a(eVar, "HTTP context");
        C5606a a = C5606a.m17839a(eVar);
        C5691d firstHeader = qVar.getFirstHeader(PlaceFields.LOCATION);
        if (firstHeader != null) {
            String value = firstHeader.getValue();
            if (this.f14940a.mo33168a()) {
                C5695b bVar = this.f14940a;
                bVar.mo33166a("Redirect requested to location '" + value + "'");
            }
            C5587a n = a.mo32984n();
            URI a2 = mo33503a(value);
            try {
                if (!a2.isAbsolute()) {
                    if (n.mo32935e()) {
                        C5896l c = a.mo33644c();
                        C5887b.m18901a((Object) c, "Target host");
                        a2 = C5621d.m17894a(C5621d.m17893a(new URI(oVar.getRequestLine().getUri()), c, false), a2);
                    } else {
                        throw new ProtocolException("Relative redirect location '" + a2 + "' not allowed");
                    }
                }
                C5801u uVar = (C5801u) a.mo33533a("http.protocol.redirect-locations");
                if (uVar == null) {
                    uVar = new C5801u();
                    eVar.mo33535a("http.protocol.redirect-locations", uVar);
                }
                if (n.mo32934d() || !uVar.mo33520b(a2)) {
                    uVar.mo33518a(a2);
                    return a2;
                }
                throw new CircularRedirectException("Circular redirect to '" + a2 + "'");
            } catch (URISyntaxException e) {
                throw new ProtocolException(e.getMessage(), e);
            }
        } else {
            throw new ProtocolException("Received redirect response " + qVar.mo33335a() + " but no location header");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo33504b(String str) {
        for (String equalsIgnoreCase : f14939b) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public C5600i mo32926a(C5899o oVar, C5901q qVar, C5875e eVar) throws ProtocolException {
        URI c = mo33505c(oVar, qVar, eVar);
        String method = oVar.getRequestLine().getMethod();
        if (method.equalsIgnoreCase("HEAD")) {
            return new C5598g(c);
        }
        if (method.equalsIgnoreCase("GET")) {
            return new C5597f(c);
        }
        if (qVar.mo33335a().mo33371a() != 307) {
            return new C5597f(c);
        }
        C5601j a = C5601j.m17831a(oVar);
        a.mo32973a(c);
        return a.mo32972a();
    }
}
