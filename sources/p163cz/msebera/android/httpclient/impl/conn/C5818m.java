package p163cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import p163cz.msebera.android.httpclient.C5563b;
import p163cz.msebera.android.httpclient.p181f0.C5727e;
import p163cz.msebera.android.httpclient.p181f0.C5729g;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.m */
/* compiled from: LoggingSessionOutputBuffer */
public class C5818m implements C5729g {

    /* renamed from: a */
    private final C5729g f15017a;

    /* renamed from: b */
    private final C5822q f15018b;

    /* renamed from: c */
    private final String f15019c;

    public C5818m(C5729g gVar, C5822q qVar, String str) {
        this.f15017a = gVar;
        this.f15018b = qVar;
        this.f15019c = str == null ? C5563b.f14521b.name() : str;
    }

    /* renamed from: a */
    public void mo33233a(int i) throws IOException {
        this.f15017a.mo33233a(i);
        if (this.f15018b.mo33567a()) {
            this.f15018b.mo33568b(i);
        }
    }

    public void flush() throws IOException {
        this.f15017a.flush();
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f15017a.write(bArr, i, i2);
        if (this.f15018b.mo33567a()) {
            this.f15018b.mo33570b(bArr, i, i2);
        }
    }

    /* renamed from: a */
    public void mo33234a(C5889d dVar) throws IOException {
        this.f15017a.mo33234a(dVar);
        if (this.f15018b.mo33567a()) {
            String str = new String(dVar.mo33673a(), 0, dVar.length());
            this.f15018b.mo33569b((str + "\r\n").getBytes(this.f15019c));
        }
    }

    /* renamed from: a */
    public void mo33236a(String str) throws IOException {
        this.f15017a.mo33236a(str);
        if (this.f15018b.mo33567a()) {
            this.f15018b.mo33569b((str + "\r\n").getBytes(this.f15019c));
        }
    }

    /* renamed from: a */
    public C5727e mo33232a() {
        return this.f15017a.mo33232a();
    }
}
