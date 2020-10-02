package p163cz.msebera.android.httpclient.p178e0.p179g;

import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.C5898n;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.ParseException;
import p163cz.msebera.android.httpclient.ProtocolException;
import p163cz.msebera.android.httpclient.p166c0.C5571d;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.e0.g.c */
/* compiled from: LaxContentLengthStrategy */
public class C5705c implements C5571d {

    /* renamed from: a */
    private final int f14730a;

    static {
        new C5705c();
    }

    public C5705c(int i) {
        this.f14730a = i;
    }

    /* renamed from: a */
    public long mo32902a(C5898n nVar) throws HttpException {
        long j;
        C5886a.m18894a(nVar, "HTTP message");
        C5691d firstHeader = nVar.getFirstHeader("Transfer-Encoding");
        if (firstHeader != null) {
            try {
                C5696e[] b = firstHeader.mo33162b();
                int length = b.length;
                if (!"identity".equalsIgnoreCase(firstHeader.getValue()) && length > 0 && "chunked".equalsIgnoreCase(b[length - 1].getName())) {
                    return -2;
                }
                return -1;
            } catch (ParseException e) {
                throw new ProtocolException("Invalid Transfer-Encoding header value: " + firstHeader, e);
            }
        } else if (nVar.getFirstHeader("Content-Length") == null) {
            return (long) this.f14730a;
        } else {
            C5691d[] headers = nVar.getHeaders("Content-Length");
            int length2 = headers.length - 1;
            while (true) {
                if (length2 < 0) {
                    j = -1;
                    break;
                }
                try {
                    j = Long.parseLong(headers[length2].getValue());
                    break;
                } catch (NumberFormatException unused) {
                    length2--;
                }
            }
            if (j >= 0) {
                return j;
            }
            return -1;
        }
    }

    public C5705c() {
        this(-1);
    }
}
