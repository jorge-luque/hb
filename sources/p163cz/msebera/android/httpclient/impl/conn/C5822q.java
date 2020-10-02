package p163cz.msebera.android.httpclient.impl.conn;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import p163cz.msebera.android.httpclient.p177d0.C5695b;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.conn.q */
/* compiled from: Wire */
public class C5822q {

    /* renamed from: a */
    public C5695b f15025a;

    /* renamed from: b */
    private final String f15026b;

    public C5822q(C5695b bVar, String str) {
        this.f15025a = bVar;
        this.f15026b = str;
    }

    /* renamed from: a */
    private void m18647a(String str, InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                break;
            } else if (read == 13) {
                sb.append("[\\r]");
            } else if (read == 10) {
                sb.append("[\\n]\"");
                sb.insert(0, "\"");
                sb.insert(0, str);
                C5695b bVar = this.f15025a;
                bVar.mo33166a(this.f15026b + " " + sb.toString());
                sb.setLength(0);
            } else if (read < 32 || read > 127) {
                sb.append("[0x");
                sb.append(Integer.toHexString(read));
                sb.append("]");
            } else {
                sb.append((char) read);
            }
        }
        if (sb.length() > 0) {
            sb.append('\"');
            sb.insert(0, '\"');
            sb.insert(0, str);
            C5695b bVar2 = this.f15025a;
            bVar2.mo33166a(this.f15026b + " " + sb.toString());
        }
    }

    /* renamed from: b */
    public void mo33570b(byte[] bArr, int i, int i2) throws IOException {
        C5886a.m18894a(bArr, "Output");
        m18647a(">> ", new ByteArrayInputStream(bArr, i, i2));
    }

    /* renamed from: b */
    public void mo33569b(byte[] bArr) throws IOException {
        C5886a.m18894a(bArr, "Output");
        m18647a(">> ", new ByteArrayInputStream(bArr));
    }

    public C5822q(C5695b bVar) {
        this(bVar, "");
    }

    /* renamed from: b */
    public void mo33568b(int i) throws IOException {
        mo33569b(new byte[]{(byte) i});
    }

    /* renamed from: a */
    public boolean mo33567a() {
        return this.f15025a.mo33168a();
    }

    /* renamed from: a */
    public void mo33566a(byte[] bArr, int i, int i2) throws IOException {
        C5886a.m18894a(bArr, "Input");
        m18647a("<< ", new ByteArrayInputStream(bArr, i, i2));
    }

    /* renamed from: a */
    public void mo33565a(byte[] bArr) throws IOException {
        C5886a.m18894a(bArr, "Input");
        m18647a("<< ", new ByteArrayInputStream(bArr));
    }

    /* renamed from: a */
    public void mo33564a(int i) throws IOException {
        mo33565a(new byte[]{(byte) i});
    }
}
