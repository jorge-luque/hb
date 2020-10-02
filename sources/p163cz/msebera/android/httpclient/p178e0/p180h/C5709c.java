package p163cz.msebera.android.httpclient.p178e0.p180h;

import com.ogury.p159cm.OguryChoiceManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import p163cz.msebera.android.httpclient.C5563b;
import p163cz.msebera.android.httpclient.p181f0.C5723a;
import p163cz.msebera.android.httpclient.p181f0.C5727e;
import p163cz.msebera.android.httpclient.p181f0.C5728f;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5888c;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.e0.h.c */
/* compiled from: AbstractSessionInputBuffer */
public abstract class C5709c implements C5728f, C5723a {

    /* renamed from: a */
    private InputStream f14741a;

    /* renamed from: b */
    private byte[] f14742b;

    /* renamed from: c */
    private C5888c f14743c;

    /* renamed from: d */
    private Charset f14744d;

    /* renamed from: e */
    private boolean f14745e;

    /* renamed from: f */
    private int f14746f;

    /* renamed from: g */
    private int f14747g;

    /* renamed from: h */
    private C5717k f14748h;

    /* renamed from: i */
    private CodingErrorAction f14749i;

    /* renamed from: j */
    private CodingErrorAction f14750j;

    /* renamed from: k */
    private int f14751k;

    /* renamed from: l */
    private int f14752l;

    /* renamed from: m */
    private CharsetDecoder f14753m;

    /* renamed from: n */
    private CharBuffer f14754n;

    /* renamed from: b */
    private int m18187b(C5889d dVar) throws IOException {
        int f = this.f14743c.mo33662f();
        if (f > 0) {
            if (this.f14743c.mo33658b(f - 1) == 10) {
                f--;
            }
            if (f > 0 && this.f14743c.mo33658b(f - 1) == 13) {
                f--;
            }
        }
        if (this.f14745e) {
            dVar.mo33668a(this.f14743c, 0, f);
        } else {
            f = m18185a(dVar, ByteBuffer.wrap(this.f14743c.mo33656a(), 0, f));
        }
        this.f14743c.mo33659c();
        return f;
    }

    /* renamed from: f */
    private int m18188f() {
        for (int i = this.f14751k; i < this.f14752l; i++) {
            if (this.f14742b[i] == 10) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33225a(InputStream inputStream, int i, C5759e eVar) {
        C5886a.m18894a(inputStream, "Input stream");
        C5886a.m18891a(i, "Buffer size");
        C5886a.m18894a(eVar, "HTTP parameters");
        this.f14741a = inputStream;
        this.f14742b = new byte[i];
        this.f14751k = 0;
        this.f14752l = 0;
        this.f14743c = new C5888c(i);
        String str = (String) eVar.mo33425b("http.protocol.element-charset");
        Charset forName = str != null ? Charset.forName(str) : C5563b.f14521b;
        this.f14744d = forName;
        this.f14745e = forName.equals(C5563b.f14521b);
        this.f14753m = null;
        this.f14746f = eVar.mo33419b("http.connection.max-line-length", -1);
        this.f14747g = eVar.mo33419b("http.connection.min-chunk-limit", 512);
        this.f14748h = mo33226c();
        CodingErrorAction codingErrorAction = (CodingErrorAction) eVar.mo33425b("http.malformed.input.action");
        if (codingErrorAction == null) {
            codingErrorAction = CodingErrorAction.REPORT;
        }
        this.f14749i = codingErrorAction;
        CodingErrorAction codingErrorAction2 = (CodingErrorAction) eVar.mo33425b("http.unmappable.input.action");
        if (codingErrorAction2 == null) {
            codingErrorAction2 = CodingErrorAction.REPORT;
        }
        this.f14750j = codingErrorAction2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C5717k mo33226c() {
        return new C5717k();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public int mo33227d() throws IOException {
        int i = this.f14751k;
        if (i > 0) {
            int i2 = this.f14752l - i;
            if (i2 > 0) {
                byte[] bArr = this.f14742b;
                System.arraycopy(bArr, i, bArr, 0, i2);
            }
            this.f14751k = 0;
            this.f14752l = i2;
        }
        int i3 = this.f14752l;
        byte[] bArr2 = this.f14742b;
        int read = this.f14741a.read(bArr2, i3, bArr2.length - i3);
        if (read == -1) {
            return -1;
        }
        this.f14752l = i3 + read;
        this.f14748h.mo33277a((long) read);
        return read;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo33228e() {
        return this.f14751k < this.f14752l;
    }

    public int length() {
        return this.f14752l - this.f14751k;
    }

    public int read() throws IOException {
        while (!mo33228e()) {
            if (mo33227d() == -1) {
                return -1;
            }
        }
        byte[] bArr = this.f14742b;
        int i = this.f14751k;
        this.f14751k = i + 1;
        return bArr[i] & 255;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            return 0;
        }
        if (mo33228e()) {
            int min = Math.min(i2, this.f14752l - this.f14751k);
            System.arraycopy(this.f14742b, this.f14751k, bArr, i, min);
            this.f14751k += min;
            return min;
        } else if (i2 > this.f14747g) {
            int read = this.f14741a.read(bArr, i, i2);
            if (read > 0) {
                this.f14748h.mo33277a((long) read);
            }
            return read;
        } else {
            while (!mo33228e()) {
                if (mo33227d() == -1) {
                    return -1;
                }
            }
            int min2 = Math.min(i2, this.f14752l - this.f14751k);
            System.arraycopy(this.f14742b, this.f14751k, bArr, i, min2);
            this.f14751k += min2;
            return min2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (r2 == -1) goto L_0x002d;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo33223a(p163cz.msebera.android.httpclient.p187k0.C5889d r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "Char array buffer"
            p163cz.msebera.android.httpclient.p187k0.C5886a.m18894a(r8, (java.lang.String) r0)
            r0 = 1
            r1 = 0
            r2 = 0
        L_0x0008:
            r3 = -1
            if (r0 == 0) goto L_0x0063
            int r4 = r7.m18188f()
            if (r4 == r3) goto L_0x002f
            cz.msebera.android.httpclient.k0.c r0 = r7.f14743c
            boolean r0 = r0.mo33660d()
            if (r0 == 0) goto L_0x001e
            int r8 = r7.m18184a((p163cz.msebera.android.httpclient.p187k0.C5889d) r8, (int) r4)
            return r8
        L_0x001e:
            int r4 = r4 + 1
            int r0 = r7.f14751k
            int r3 = r4 - r0
            cz.msebera.android.httpclient.k0.c r5 = r7.f14743c
            byte[] r6 = r7.f14742b
            r5.mo33654a((byte[]) r6, (int) r0, (int) r3)
            r7.f14751k = r4
        L_0x002d:
            r0 = 0
            goto L_0x004c
        L_0x002f:
            boolean r2 = r7.mo33228e()
            if (r2 == 0) goto L_0x0045
            int r2 = r7.f14752l
            int r4 = r7.f14751k
            int r2 = r2 - r4
            cz.msebera.android.httpclient.k0.c r5 = r7.f14743c
            byte[] r6 = r7.f14742b
            r5.mo33654a((byte[]) r6, (int) r4, (int) r2)
            int r2 = r7.f14752l
            r7.f14751k = r2
        L_0x0045:
            int r2 = r7.mo33227d()
            if (r2 != r3) goto L_0x004c
            goto L_0x002d
        L_0x004c:
            int r3 = r7.f14746f
            if (r3 <= 0) goto L_0x0008
            cz.msebera.android.httpclient.k0.c r3 = r7.f14743c
            int r3 = r3.mo33662f()
            int r4 = r7.f14746f
            if (r3 >= r4) goto L_0x005b
            goto L_0x0008
        L_0x005b:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r0 = "Maximum line length limit exceeded"
            r8.<init>(r0)
            throw r8
        L_0x0063:
            if (r2 != r3) goto L_0x006e
            cz.msebera.android.httpclient.k0.c r0 = r7.f14743c
            boolean r0 = r0.mo33660d()
            if (r0 == 0) goto L_0x006e
            return r3
        L_0x006e:
            int r8 = r7.m18187b(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.p178e0.p180h.C5709c.mo33223a(cz.msebera.android.httpclient.k0.d):int");
    }

    /* renamed from: a */
    private int m18184a(C5889d dVar, int i) throws IOException {
        int i2 = this.f14751k;
        this.f14751k = i + 1;
        if (i > i2 && this.f14742b[i - 1] == 13) {
            i--;
        }
        int i3 = i - i2;
        if (!this.f14745e) {
            return m18185a(dVar, ByteBuffer.wrap(this.f14742b, i2, i3));
        }
        dVar.mo33671a(this.f14742b, i2, i3);
        return i3;
    }

    /* renamed from: a */
    private int m18185a(C5889d dVar, ByteBuffer byteBuffer) throws IOException {
        int i = 0;
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.f14753m == null) {
            CharsetDecoder newDecoder = this.f14744d.newDecoder();
            this.f14753m = newDecoder;
            newDecoder.onMalformedInput(this.f14749i);
            this.f14753m.onUnmappableCharacter(this.f14750j);
        }
        if (this.f14754n == null) {
            this.f14754n = CharBuffer.allocate(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
        }
        this.f14753m.reset();
        while (byteBuffer.hasRemaining()) {
            i += m18186a(this.f14753m.decode(byteBuffer, this.f14754n, true), dVar, byteBuffer);
        }
        int a = i + m18186a(this.f14753m.flush(this.f14754n), dVar, byteBuffer);
        this.f14754n.clear();
        return a;
    }

    /* renamed from: a */
    private int m18186a(CoderResult coderResult, C5889d dVar, ByteBuffer byteBuffer) throws IOException {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.f14754n.flip();
        int remaining = this.f14754n.remaining();
        while (this.f14754n.hasRemaining()) {
            dVar.mo33666a(this.f14754n.get());
        }
        this.f14754n.compact();
        return remaining;
    }

    /* renamed from: a */
    public C5727e mo33224a() {
        return this.f14748h;
    }
}
