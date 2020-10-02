package p163cz.msebera.android.httpclient.p178e0.p180h;

import com.facebook.appevents.AppEventsConstants;
import java.io.IOException;
import java.io.OutputStream;
import p163cz.msebera.android.httpclient.p181f0.C5729g;

/* renamed from: cz.msebera.android.httpclient.e0.h.f */
/* compiled from: ChunkedOutputStream */
public class C5712f extends OutputStream {

    /* renamed from: a */
    private final C5729g f14774a;

    /* renamed from: b */
    private final byte[] f14775b;

    /* renamed from: c */
    private int f14776c;

    /* renamed from: d */
    private boolean f14777d;

    /* renamed from: e */
    private boolean f14778e;

    @Deprecated
    public C5712f(C5729g gVar) throws IOException {
        this(2048, gVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33247a(byte[] bArr, int i, int i2) throws IOException {
        this.f14774a.mo33236a(Integer.toHexString(this.f14776c + i2));
        this.f14774a.write(this.f14775b, 0, this.f14776c);
        this.f14774a.write(bArr, i, i2);
        this.f14774a.mo33236a("");
        this.f14776c = 0;
    }

    public void close() throws IOException {
        if (!this.f14778e) {
            this.f14778e = true;
            mo33249d();
            this.f14774a.flush();
        }
    }

    /* renamed from: d */
    public void mo33249d() throws IOException {
        if (!this.f14777d) {
            mo33251t();
            mo33252u();
            this.f14777d = true;
        }
    }

    public void flush() throws IOException {
        mo33251t();
        this.f14774a.flush();
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void mo33251t() throws IOException {
        int i = this.f14776c;
        if (i > 0) {
            this.f14774a.mo33236a(Integer.toHexString(i));
            this.f14774a.write(this.f14775b, 0, this.f14776c);
            this.f14774a.mo33236a("");
            this.f14776c = 0;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public void mo33252u() throws IOException {
        this.f14774a.mo33236a(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.f14774a.mo33236a("");
    }

    public void write(int i) throws IOException {
        if (!this.f14778e) {
            byte[] bArr = this.f14775b;
            int i2 = this.f14776c;
            bArr[i2] = (byte) i;
            int i3 = i2 + 1;
            this.f14776c = i3;
            if (i3 == bArr.length) {
                mo33251t();
                return;
            }
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }

    public C5712f(int i, C5729g gVar) {
        this.f14776c = 0;
        this.f14777d = false;
        this.f14778e = false;
        this.f14775b = new byte[i];
        this.f14774a = gVar;
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f14778e) {
            byte[] bArr2 = this.f14775b;
            int length = bArr2.length;
            int i3 = this.f14776c;
            if (i2 >= length - i3) {
                mo33247a(bArr, i, i2);
                return;
            }
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.f14776c += i2;
            return;
        }
        throw new IOException("Attempted write to closed stream.");
    }
}
