package p163cz.msebera.android.httpclient.p166c0;

import java.io.IOException;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.p182g0.C5732b;

/* renamed from: cz.msebera.android.httpclient.c0.a */
/* compiled from: AbstractHttpEntity */
public abstract class C5568a implements C5870j {

    /* renamed from: a */
    protected C5691d f14528a;

    /* renamed from: b */
    protected C5691d f14529b;

    /* renamed from: c */
    protected boolean f14530c;

    protected C5568a() {
    }

    /* renamed from: a */
    public C5691d mo32889a() {
        return this.f14528a;
    }

    /* renamed from: b */
    public void mo32893b(C5691d dVar) {
        this.f14528a = dVar;
    }

    /* renamed from: c */
    public C5691d mo32894c() {
        return this.f14529b;
    }

    /* renamed from: e */
    public boolean mo32895e() {
        return this.f14530c;
    }

    @Deprecated
    /* renamed from: g */
    public void mo28847g() throws IOException {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (this.f14528a != null) {
            sb.append("Content-Type: ");
            sb.append(this.f14528a.getValue());
            sb.append(',');
        }
        if (this.f14529b != null) {
            sb.append("Content-Encoding: ");
            sb.append(this.f14529b.getValue());
            sb.append(',');
        }
        long h = mo28849h();
        if (h >= 0) {
            sb.append("Content-Length: ");
            sb.append(h);
            sb.append(',');
        }
        sb.append("Chunked: ");
        sb.append(this.f14530c);
        sb.append(']');
        return sb.toString();
    }

    /* renamed from: a */
    public void mo32891a(String str) {
        mo32893b(str != null ? new C5732b("Content-Type", str) : null);
    }

    /* renamed from: a */
    public void mo32890a(C5691d dVar) {
        this.f14529b = dVar;
    }

    /* renamed from: a */
    public void mo32892a(boolean z) {
        this.f14530c = z;
    }
}
