package p163cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import p163cz.msebera.android.httpclient.C5563b;
import p163cz.msebera.android.httpclient.p181f0.C5724b;
import p163cz.msebera.android.httpclient.p181f0.C5727e;
import p163cz.msebera.android.httpclient.p181f0.C5728f;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.l */
/* compiled from: LoggingSessionInputBuffer */
public class C5817l implements C5728f, C5724b {

    /* renamed from: a */
    private final C5728f f15013a;

    /* renamed from: b */
    private final C5724b f15014b;

    /* renamed from: c */
    private final C5822q f15015c;

    /* renamed from: d */
    private final String f15016d;

    public C5817l(C5728f fVar, C5822q qVar, String str) {
        this.f15013a = fVar;
        this.f15014b = fVar instanceof C5724b ? (C5724b) fVar : null;
        this.f15015c = qVar;
        this.f15016d = str == null ? C5563b.f14521b.name() : str;
    }

    /* renamed from: a */
    public boolean mo33287a(int i) throws IOException {
        return this.f15013a.mo33287a(i);
    }

    /* renamed from: b */
    public boolean mo33288b() {
        C5724b bVar = this.f15014b;
        if (bVar != null) {
            return bVar.mo33288b();
        }
        return false;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f15013a.read(bArr, i, i2);
        if (this.f15015c.mo33567a() && read > 0) {
            this.f15015c.mo33566a(bArr, i, read);
        }
        return read;
    }

    /* renamed from: a */
    public int mo33223a(C5889d dVar) throws IOException {
        int a = this.f15013a.mo33223a(dVar);
        if (this.f15015c.mo33567a() && a >= 0) {
            String str = new String(dVar.mo33673a(), dVar.length() - a, a);
            this.f15015c.mo33565a((str + "\r\n").getBytes(this.f15016d));
        }
        return a;
    }

    public int read() throws IOException {
        int read = this.f15013a.read();
        if (this.f15015c.mo33567a() && read != -1) {
            this.f15015c.mo33564a(read);
        }
        return read;
    }

    /* renamed from: a */
    public C5727e mo33224a() {
        return this.f15013a.mo33224a();
    }
}
