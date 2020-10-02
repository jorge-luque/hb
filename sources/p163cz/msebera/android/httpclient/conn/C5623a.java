package p163cz.msebera.android.httpclient.conn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.p166c0.C5573f;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5892g;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.a */
/* compiled from: BasicManagedEntity */
public class C5623a extends C5573f implements C5629g, C5632j {

    /* renamed from: b */
    protected C5635m f14625b;

    /* renamed from: c */
    protected final boolean f14626c;

    public C5623a(C5870j jVar, C5635m mVar, boolean z) {
        super(jVar);
        C5886a.m18894a(mVar, "Connection");
        this.f14625b = mVar;
        this.f14626c = z;
    }

    /* renamed from: j */
    private void m17910j() throws IOException {
        C5635m mVar = this.f14625b;
        if (mVar != null) {
            try {
                if (this.f14626c) {
                    C5892g.m18935a(this.f14540a);
                    this.f14625b.mo33034S();
                } else {
                    mVar.mo33033L();
                }
            } finally {
                mo33007i();
            }
        }
    }

    /* renamed from: a */
    public void mo32899a(OutputStream outputStream) throws IOException {
        super.mo32899a(outputStream);
        m17910j();
    }

    /* renamed from: b */
    public boolean mo32900b() {
        return false;
    }

    /* renamed from: b */
    public boolean mo33004b(InputStream inputStream) throws IOException {
        boolean isOpen;
        try {
            if (this.f14625b != null) {
                if (this.f14626c) {
                    isOpen = this.f14625b.isOpen();
                    inputStream.close();
                    this.f14625b.mo33034S();
                } else {
                    this.f14625b.mo33033L();
                }
            }
        } catch (SocketException e) {
            if (isOpen) {
                throw e;
            }
        } catch (Throwable th) {
            mo33007i();
            throw th;
        }
        mo33007i();
        return false;
    }

    /* renamed from: c */
    public boolean mo33005c(InputStream inputStream) throws IOException {
        C5635m mVar = this.f14625b;
        if (mVar == null) {
            return false;
        }
        mVar.mo33008t();
        return false;
    }

    /* renamed from: d */
    public void mo33006d() throws IOException {
        m17910j();
    }

    @Deprecated
    /* renamed from: g */
    public void mo28847g() throws IOException {
        m17910j();
    }

    public InputStream getContent() throws IOException {
        return new C5631i(this.f14540a.getContent(), this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo33007i() throws IOException {
        C5635m mVar = this.f14625b;
        if (mVar != null) {
            try {
                mVar.mo33006d();
            } finally {
                this.f14625b = null;
            }
        }
    }

    /* renamed from: t */
    public void mo33008t() throws IOException {
        C5635m mVar = this.f14625b;
        if (mVar != null) {
            try {
                mVar.mo33008t();
            } finally {
                this.f14625b = null;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public boolean mo33003a(InputStream inputStream) throws IOException {
        try {
            if (this.f14625b != null) {
                if (this.f14626c) {
                    inputStream.close();
                    this.f14625b.mo33034S();
                } else {
                    this.f14625b.mo33033L();
                }
            }
            mo33007i();
            return false;
        } catch (Throwable th) {
            mo33007i();
            throw th;
        }
    }
}
