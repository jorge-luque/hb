package p163cz.msebera.android.httpclient.client.p168n;

import java.nio.charset.Charset;
import p163cz.msebera.android.httpclient.C5906u;
import p163cz.msebera.android.httpclient.client.p172r.C5622e;
import p163cz.msebera.android.httpclient.p166c0.C5572e;
import p163cz.msebera.android.httpclient.p166c0.C5574g;
import p163cz.msebera.android.httpclient.p186j0.C5874d;

/* renamed from: cz.msebera.android.httpclient.client.n.a */
/* compiled from: UrlEncodedFormEntity */
public class C5589a extends C5574g {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C5589a(Iterable<? extends C5906u> iterable, Charset charset) {
        super(C5622e.m17899a(iterable, charset != null ? charset : C5874d.f15105a), C5572e.m17757a("application/x-www-form-urlencoded", charset));
    }
}
