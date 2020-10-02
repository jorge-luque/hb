package p163cz.msebera.android.httpclient.p178e0.p180h;

import com.ogury.p159cm.OguryChoiceManager;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import p163cz.msebera.android.httpclient.C5563b;
import p163cz.msebera.android.httpclient.p181f0.C5723a;
import p163cz.msebera.android.httpclient.p181f0.C5727e;
import p163cz.msebera.android.httpclient.p181f0.C5729g;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5888c;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.e0.h.d */
/* compiled from: AbstractSessionOutputBuffer */
public abstract class C5710d implements C5729g, C5723a {

    /* renamed from: k */
    private static final byte[] f14755k = {13, 10};

    /* renamed from: a */
    private OutputStream f14756a;

    /* renamed from: b */
    private C5888c f14757b;

    /* renamed from: c */
    private Charset f14758c;

    /* renamed from: d */
    private boolean f14759d;

    /* renamed from: e */
    private int f14760e;

    /* renamed from: f */
    private C5717k f14761f;

    /* renamed from: g */
    private CodingErrorAction f14762g;

    /* renamed from: h */
    private CodingErrorAction f14763h;

    /* renamed from: i */
    private CharsetEncoder f14764i;

    /* renamed from: j */
    private ByteBuffer f14765j;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33235a(OutputStream outputStream, int i, C5759e eVar) {
        C5886a.m18894a(outputStream, "Input stream");
        C5886a.m18891a(i, "Buffer size");
        C5886a.m18894a(eVar, "HTTP parameters");
        this.f14756a = outputStream;
        this.f14757b = new C5888c(i);
        String str = (String) eVar.mo33425b("http.protocol.element-charset");
        Charset forName = str != null ? Charset.forName(str) : C5563b.f14521b;
        this.f14758c = forName;
        this.f14759d = forName.equals(C5563b.f14521b);
        this.f14764i = null;
        this.f14760e = eVar.mo33419b("http.connection.min-chunk-limit", 512);
        this.f14761f = mo33238b();
        CodingErrorAction codingErrorAction = (CodingErrorAction) eVar.mo33425b("http.malformed.input.action");
        if (codingErrorAction == null) {
            codingErrorAction = CodingErrorAction.REPORT;
        }
        this.f14762g = codingErrorAction;
        CodingErrorAction codingErrorAction2 = (CodingErrorAction) eVar.mo33425b("http.unmappable.input.action");
        if (codingErrorAction2 == null) {
            codingErrorAction2 = CodingErrorAction.REPORT;
        }
        this.f14763h = codingErrorAction2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C5717k mo33238b() {
        return new C5717k();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo33239c() throws IOException {
        int f = this.f14757b.mo33662f();
        if (f > 0) {
            this.f14756a.write(this.f14757b.mo33656a(), 0, f);
            this.f14757b.mo33659c();
            this.f14761f.mo33277a((long) f);
        }
    }

    public void flush() throws IOException {
        mo33239c();
        this.f14756a.flush();
    }

    public int length() {
        return this.f14757b.mo33662f();
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (bArr != null) {
            if (i2 > this.f14760e || i2 > this.f14757b.mo33657b()) {
                mo33239c();
                this.f14756a.write(bArr, i, i2);
                this.f14761f.mo33277a((long) i2);
                return;
            }
            if (i2 > this.f14757b.mo33657b() - this.f14757b.mo33662f()) {
                mo33239c();
            }
            this.f14757b.mo33654a(bArr, i, i2);
        }
    }

    /* renamed from: a */
    public void mo33237a(byte[] bArr) throws IOException {
        if (bArr != null) {
            write(bArr, 0, bArr.length);
        }
    }

    /* renamed from: a */
    public void mo33233a(int i) throws IOException {
        if (this.f14757b.mo33661e()) {
            mo33239c();
        }
        this.f14757b.mo33652a(i);
    }

    /* renamed from: a */
    public void mo33236a(String str) throws IOException {
        if (str != null) {
            if (str.length() > 0) {
                if (this.f14759d) {
                    for (int i = 0; i < str.length(); i++) {
                        mo33233a((int) str.charAt(i));
                    }
                } else {
                    m18195a(CharBuffer.wrap(str));
                }
            }
            mo33237a(f14755k);
        }
    }

    /* renamed from: a */
    public void mo33234a(C5889d dVar) throws IOException {
        if (dVar != null) {
            int i = 0;
            if (this.f14759d) {
                int length = dVar.length();
                while (length > 0) {
                    int min = Math.min(this.f14757b.mo33657b() - this.f14757b.mo33662f(), length);
                    if (min > 0) {
                        this.f14757b.mo33653a(dVar, i, min);
                    }
                    if (this.f14757b.mo33661e()) {
                        mo33239c();
                    }
                    i += min;
                    length -= min;
                }
            } else {
                m18195a(CharBuffer.wrap(dVar.mo33673a(), 0, dVar.length()));
            }
            mo33237a(f14755k);
        }
    }

    /* renamed from: a */
    private void m18195a(CharBuffer charBuffer) throws IOException {
        if (charBuffer.hasRemaining()) {
            if (this.f14764i == null) {
                CharsetEncoder newEncoder = this.f14758c.newEncoder();
                this.f14764i = newEncoder;
                newEncoder.onMalformedInput(this.f14762g);
                this.f14764i.onUnmappableCharacter(this.f14763h);
            }
            if (this.f14765j == null) {
                this.f14765j = ByteBuffer.allocate(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
            }
            this.f14764i.reset();
            while (charBuffer.hasRemaining()) {
                m18196a(this.f14764i.encode(charBuffer, this.f14765j, true));
            }
            m18196a(this.f14764i.flush(this.f14765j));
            this.f14765j.clear();
        }
    }

    /* renamed from: a */
    private void m18196a(CoderResult coderResult) throws IOException {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.f14765j.flip();
        while (this.f14765j.hasRemaining()) {
            mo33233a((int) this.f14765j.get());
        }
        this.f14765j.compact();
    }

    /* renamed from: a */
    public C5727e mo33232a() {
        return this.f14761f;
    }
}
