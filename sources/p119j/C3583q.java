package p119j;

import com.facebook.internal.Utility;
import javax.annotation.Nullable;

/* renamed from: j.q */
/* compiled from: Segment */
final class C3583q {

    /* renamed from: a */
    final byte[] f10040a;

    /* renamed from: b */
    int f10041b;

    /* renamed from: c */
    int f10042c;

    /* renamed from: d */
    boolean f10043d;

    /* renamed from: e */
    boolean f10044e;

    /* renamed from: f */
    C3583q f10045f;

    /* renamed from: g */
    C3583q f10046g;

    C3583q() {
        this.f10040a = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        this.f10044e = true;
        this.f10043d = false;
    }

    /* renamed from: a */
    public final C3583q mo19766a(C3583q qVar) {
        qVar.f10046g = this;
        qVar.f10045f = this.f10045f;
        this.f10045f.f10046g = qVar;
        this.f10045f = qVar;
        return qVar;
    }

    @Nullable
    /* renamed from: b */
    public final C3583q mo19769b() {
        C3583q qVar = this.f10045f;
        if (qVar == this) {
            qVar = null;
        }
        C3583q qVar2 = this.f10046g;
        qVar2.f10045f = this.f10045f;
        this.f10045f.f10046g = qVar2;
        this.f10045f = null;
        this.f10046g = null;
        return qVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final C3583q mo19770c() {
        this.f10043d = true;
        return new C3583q(this.f10040a, this.f10041b, this.f10042c, true, false);
    }

    C3583q(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f10040a = bArr;
        this.f10041b = i;
        this.f10042c = i2;
        this.f10043d = z;
        this.f10044e = z2;
    }

    /* renamed from: a */
    public final C3583q mo19765a(int i) {
        C3583q qVar;
        if (i <= 0 || i > this.f10042c - this.f10041b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            qVar = mo19770c();
        } else {
            qVar = C3584r.m12202a();
            System.arraycopy(this.f10040a, this.f10041b, qVar.f10040a, 0, i);
        }
        qVar.f10042c = qVar.f10041b + i;
        this.f10041b += i;
        this.f10046g.mo19766a(qVar);
        return qVar;
    }

    /* renamed from: a */
    public final void mo19767a() {
        C3583q qVar = this.f10046g;
        if (qVar == this) {
            throw new IllegalStateException();
        } else if (qVar.f10044e) {
            int i = this.f10042c - this.f10041b;
            if (i <= (8192 - qVar.f10042c) + (qVar.f10043d ? 0 : qVar.f10041b)) {
                mo19768a(this.f10046g, i);
                mo19769b();
                C3584r.m12203a(this);
            }
        }
    }

    /* renamed from: a */
    public final void mo19768a(C3583q qVar, int i) {
        if (qVar.f10044e) {
            int i2 = qVar.f10042c;
            if (i2 + i > 8192) {
                if (!qVar.f10043d) {
                    int i3 = qVar.f10041b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = qVar.f10040a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        qVar.f10042c -= qVar.f10041b;
                        qVar.f10041b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f10040a, this.f10041b, qVar.f10040a, qVar.f10042c, i);
            qVar.f10042c += i;
            this.f10041b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
