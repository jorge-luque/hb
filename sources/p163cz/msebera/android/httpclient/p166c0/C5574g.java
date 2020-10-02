package p163cz.msebera.android.httpclient.p166c0;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import p163cz.msebera.android.httpclient.p186j0.C5874d;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.c0.g */
/* compiled from: StringEntity */
public class C5574g extends C5568a implements Cloneable {

    /* renamed from: d */
    protected final byte[] f14541d;

    public C5574g(String str, C5572e eVar) throws UnsupportedCharsetException {
        C5886a.m18894a(str, "Source string");
        Charset a = eVar != null ? eVar.mo32903a() : null;
        this.f14541d = str.getBytes(a == null ? C5874d.f15105a : a);
        if (eVar != null) {
            mo32891a(eVar.toString());
        }
    }

    /* renamed from: a */
    public void mo32899a(OutputStream outputStream) throws IOException {
        C5886a.m18894a(outputStream, "Output stream");
        outputStream.write(this.f14541d);
        outputStream.flush();
    }

    /* renamed from: b */
    public boolean mo32900b() {
        return true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /* renamed from: f */
    public boolean mo32901f() {
        return false;
    }

    public InputStream getContent() throws IOException {
        return new ByteArrayInputStream(this.f14541d);
    }

    /* renamed from: h */
    public long mo28849h() {
        return (long) this.f14541d.length;
    }
}
