package p163cz.msebera.android.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: cz.msebera.android.httpclient.j */
/* compiled from: HttpEntity */
public interface C5870j {
    /* renamed from: a */
    C5691d mo32889a();

    /* renamed from: a */
    void mo32899a(OutputStream outputStream) throws IOException;

    /* renamed from: b */
    boolean mo32900b();

    /* renamed from: c */
    C5691d mo32894c();

    /* renamed from: e */
    boolean mo32895e();

    /* renamed from: f */
    boolean mo32901f();

    @Deprecated
    /* renamed from: g */
    void mo28847g() throws IOException;

    InputStream getContent() throws IOException, UnsupportedOperationException;

    /* renamed from: h */
    long mo28849h();
}
