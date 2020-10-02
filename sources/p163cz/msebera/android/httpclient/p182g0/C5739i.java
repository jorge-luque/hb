package p163cz.msebera.android.httpclient.p182g0;

import java.util.Locale;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.C5905t;
import p163cz.msebera.android.httpclient.C5907v;
import p163cz.msebera.android.httpclient.C5908w;
import p163cz.msebera.android.httpclient.C5910y;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.g0.i */
/* compiled from: BasicHttpResponse */
public class C5739i extends C5731a implements C5901q {

    /* renamed from: c */
    private C5910y f14818c;

    /* renamed from: d */
    private C5907v f14819d;

    /* renamed from: e */
    private int f14820e;

    /* renamed from: f */
    private String f14821f;

    /* renamed from: g */
    private C5870j f14822g;

    /* renamed from: h */
    private final C5908w f14823h;

    /* renamed from: i */
    private Locale f14824i;

    public C5739i(C5910y yVar, C5908w wVar, Locale locale) {
        C5886a.m18894a(yVar, "Status line");
        this.f14818c = yVar;
        this.f14819d = yVar.getProtocolVersion();
        this.f14820e = yVar.mo33371a();
        this.f14821f = yVar.mo33372b();
        this.f14823h = wVar;
        this.f14824i = locale;
    }

    /* renamed from: a */
    public C5910y mo33335a() {
        if (this.f14818c == null) {
            C5907v vVar = this.f14819d;
            if (vVar == null) {
                vVar = C5905t.f15130f;
            }
            int i = this.f14820e;
            String str = this.f14821f;
            if (str == null) {
                str = mo33336a(i);
            }
            this.f14818c = new C5745o(vVar, i, str);
        }
        return this.f14818c;
    }

    public C5870j getEntity() {
        return this.f14822g;
    }

    public C5907v getProtocolVersion() {
        return this.f14819d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo33335a());
        sb.append(' ');
        sb.append(this.f14795a);
        if (this.f14822g != null) {
            sb.append(' ');
            sb.append(this.f14822g);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void mo33337a(C5870j jVar) {
        this.f14822g = jVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo33336a(int i) {
        C5908w wVar = this.f14823h;
        if (wVar == null) {
            return null;
        }
        Locale locale = this.f14824i;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return wVar.mo33201a(i, locale);
    }
}
