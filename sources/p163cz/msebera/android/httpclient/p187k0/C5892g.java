package p163cz.msebera.android.httpclient.p187k0;

import java.io.IOException;
import java.io.InputStream;
import p163cz.msebera.android.httpclient.C5870j;

/* renamed from: cz.msebera.android.httpclient.k0.g */
/* compiled from: EntityUtils */
public final class C5892g {
    /* renamed from: a */
    public static void m18935a(C5870j jVar) throws IOException {
        InputStream content;
        if (jVar != null && jVar.mo32901f() && (content = jVar.getContent()) != null) {
            content.close();
        }
    }

    /* renamed from: b */
    public static byte[] m18936b(C5870j jVar) throws IOException {
        C5886a.m18894a(jVar, "Entity");
        InputStream content = jVar.getContent();
        if (content == null) {
            return null;
        }
        try {
            C5886a.m18896a(jVar.mo28849h() <= 2147483647L, "HTTP entity too large to be buffered in memory");
            int h = (int) jVar.mo28849h();
            if (h < 0) {
                h = CodedOutputStream.DEFAULT_BUFFER_SIZE;
            }
            C5888c cVar = new C5888c(h);
            byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    return cVar.mo33663g();
                }
                cVar.mo33654a(bArr, 0, read);
            }
        } finally {
            content.close();
        }
    }
}
