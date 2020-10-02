package p163cz.msebera.android.httpclient.p178e0;

import java.util.Locale;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.C5902r;
import p163cz.msebera.android.httpclient.C5908w;
import p163cz.msebera.android.httpclient.C5910y;
import p163cz.msebera.android.httpclient.p182g0.C5739i;
import p163cz.msebera.android.httpclient.p186j0.C5875e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.e0.c */
/* compiled from: DefaultHttpResponseFactory */
public class C5699c implements C5902r {

    /* renamed from: b */
    public static final C5699c f14720b = new C5699c();

    /* renamed from: a */
    protected final C5908w f14721a;

    public C5699c(C5908w wVar) {
        C5886a.m18894a(wVar, "Reason phrase catalog");
        this.f14721a = wVar;
    }

    /* renamed from: a */
    public C5901q mo33199a(C5910y yVar, C5875e eVar) {
        C5886a.m18894a(yVar, "Status line");
        return new C5739i(yVar, this.f14721a, mo33200a(eVar));
    }

    public C5699c() {
        this(C5700d.f14722a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Locale mo33200a(C5875e eVar) {
        return Locale.getDefault();
    }
}
