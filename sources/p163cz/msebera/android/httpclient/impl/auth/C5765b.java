package p163cz.msebera.android.httpclient.impl.auth;

import com.moat.analytics.mobile.ogury.BuildConfig;
import java.nio.charset.Charset;
import p163cz.msebera.android.httpclient.C5563b;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.auth.AuthenticationException;
import p163cz.msebera.android.httpclient.auth.C5559l;
import p163cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p163cz.msebera.android.httpclient.p177d0.C5692a;
import p163cz.msebera.android.httpclient.p182g0.C5747q;
import p163cz.msebera.android.httpclient.p186j0.C5871a;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;
import p163cz.msebera.android.httpclient.p187k0.C5891f;

/* renamed from: cz.msebera.android.httpclient.impl.auth.b */
/* compiled from: BasicScheme */
public class C5765b extends C5779l {
    private static final long serialVersionUID = -1931571557597830536L;

    /* renamed from: d */
    private boolean f14863d;

    public C5765b(Charset charset) {
        super(charset);
        this.f14863d = false;
    }

    /* renamed from: a */
    public void mo32839a(C5691d dVar) throws MalformedChallengeException {
        super.mo32839a(dVar);
        this.f14863d = true;
    }

    /* renamed from: b */
    public boolean mo32840b() {
        return false;
    }

    /* renamed from: c */
    public boolean mo32841c() {
        return this.f14863d;
    }

    /* renamed from: d */
    public String mo32842d() {
        return BuildConfig.FLAVOR;
    }

    public String toString() {
        return "BASIC [complete=" + this.f14863d + "]";
    }

    public C5765b() {
        this(C5563b.f14521b);
    }

    @Deprecated
    /* renamed from: a */
    public C5691d mo32837a(C5559l lVar, C5899o oVar) throws AuthenticationException {
        return mo32867a(lVar, oVar, new C5871a());
    }

    /* renamed from: a */
    public C5691d mo32867a(C5559l lVar, C5899o oVar, C5875e eVar) throws AuthenticationException {
        C5886a.m18894a(lVar, "Credentials");
        C5886a.m18894a(oVar, "HTTP request");
        StringBuilder sb = new StringBuilder();
        sb.append(lVar.mo32868a().getName());
        sb.append(":");
        sb.append(lVar.mo32869b() == null ? "null" : lVar.mo32869b());
        byte[] a = C5692a.m18124a(C5891f.m18934a(sb.toString(), mo33443a(oVar)), 2);
        C5889d dVar = new C5889d(32);
        if (mo33435e()) {
            dVar.mo33670a("Proxy-Authorization");
        } else {
            dVar.mo33670a("Authorization");
        }
        dVar.mo33670a(": Basic ");
        dVar.mo33671a(a, 0, a.length);
        return new C5747q(dVar);
    }
}
