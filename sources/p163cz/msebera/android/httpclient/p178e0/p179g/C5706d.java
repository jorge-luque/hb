package p163cz.msebera.android.httpclient.p178e0.p179g;

import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5898n;
import p163cz.msebera.android.httpclient.C5905t;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.ProtocolException;
import p163cz.msebera.android.httpclient.p166c0.C5571d;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.e0.g.d */
/* compiled from: StrictContentLengthStrategy */
public class C5706d implements C5571d {

    /* renamed from: a */
    private final int f14731a;

    static {
        new C5706d();
    }

    public C5706d(int i) {
        this.f14731a = i;
    }

    /* renamed from: a */
    public long mo32902a(C5898n nVar) throws HttpException {
        C5886a.m18894a(nVar, "HTTP message");
        C5691d firstHeader = nVar.getFirstHeader("Transfer-Encoding");
        if (firstHeader != null) {
            String value = firstHeader.getValue();
            if ("chunked".equalsIgnoreCase(value)) {
                if (!nVar.getProtocolVersion().mo33701c(C5905t.f15129e)) {
                    return -2;
                }
                throw new ProtocolException("Chunked transfer encoding not allowed for " + nVar.getProtocolVersion());
            } else if ("identity".equalsIgnoreCase(value)) {
                return -1;
            } else {
                throw new ProtocolException("Unsupported transfer encoding: " + value);
            }
        } else {
            C5691d firstHeader2 = nVar.getFirstHeader("Content-Length");
            if (firstHeader2 == null) {
                return (long) this.f14731a;
            }
            String value2 = firstHeader2.getValue();
            try {
                long parseLong = Long.parseLong(value2);
                if (parseLong >= 0) {
                    return parseLong;
                }
                throw new ProtocolException("Negative content length: " + value2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Invalid content length: " + value2);
            }
        }
    }

    public C5706d() {
        this(-1);
    }
}
