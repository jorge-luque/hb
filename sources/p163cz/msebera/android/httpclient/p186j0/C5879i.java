package p163cz.msebera.android.httpclient.p186j0;

import java.io.IOException;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5900p;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.C5903s;
import p163cz.msebera.android.httpclient.HttpException;

/* renamed from: cz.msebera.android.httpclient.j0.i */
/* compiled from: ImmutableHttpProcessor */
public final class C5879i implements C5877g {

    /* renamed from: a */
    private final C5900p[] f15109a;

    /* renamed from: b */
    private final C5903s[] f15110b;

    public C5879i(C5900p[] pVarArr, C5903s[] sVarArr) {
        if (pVarArr != null) {
            int length = pVarArr.length;
            C5900p[] pVarArr2 = new C5900p[length];
            this.f15109a = pVarArr2;
            System.arraycopy(pVarArr, 0, pVarArr2, 0, length);
        } else {
            this.f15109a = new C5900p[0];
        }
        if (sVarArr != null) {
            int length2 = sVarArr.length;
            C5903s[] sVarArr2 = new C5903s[length2];
            this.f15110b = sVarArr2;
            System.arraycopy(sVarArr, 0, sVarArr2, 0, length2);
            return;
        }
        this.f15110b = new C5903s[0];
    }

    /* renamed from: a */
    public void mo28845a(C5899o oVar, C5875e eVar) throws IOException, HttpException {
        for (C5900p a : this.f15109a) {
            a.mo28845a(oVar, eVar);
        }
    }

    /* renamed from: a */
    public void mo28846a(C5901q qVar, C5875e eVar) throws IOException, HttpException {
        for (C5903s a : this.f15110b) {
            a.mo28846a(qVar, eVar);
        }
    }
}
