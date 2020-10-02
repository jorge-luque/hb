package com.google.zxing.p132f.p133b;

import com.google.zxing.p134g.C4079a;
import java.util.LinkedList;

/* renamed from: com.google.zxing.f.b.f */
/* compiled from: State */
final class C4077f {

    /* renamed from: e */
    static final C4077f f10929e = new C4077f(C4078g.f10934b, 0, 0, 0);

    /* renamed from: a */
    private final int f10930a;

    /* renamed from: b */
    private final C4078g f10931b;

    /* renamed from: c */
    private final int f10932c;

    /* renamed from: d */
    private final int f10933d;

    private C4077f(C4078g gVar, int i, int i2, int i3) {
        this.f10931b = gVar;
        this.f10930a = i;
        this.f10932c = i2;
        this.f10933d = i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo28302a() {
        return this.f10932c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo28307b() {
        return this.f10933d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo28310c() {
        return this.f10930a;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{C4074d.f10922b[this.f10930a], Integer.valueOf(this.f10933d), Integer.valueOf(this.f10932c)});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C4077f mo28304a(int i, int i2) {
        int i3 = this.f10933d;
        C4078g gVar = this.f10931b;
        int i4 = this.f10930a;
        if (i != i4) {
            int i5 = C4074d.f10923c[i4][i];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            gVar = gVar.mo28313a(i6, i7);
            i3 += i7;
        }
        int i8 = i == 2 ? 4 : 5;
        return new C4077f(gVar.mo28313a(i2, i8), i, 0, i3 + i8);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C4077f mo28309b(int i, int i2) {
        C4078g gVar = this.f10931b;
        int i3 = this.f10930a == 2 ? 4 : 5;
        return new C4077f(gVar.mo28313a(C4074d.f10925e[this.f10930a][i], i3).mo28313a(i2, 5), this.f10930a, 0, this.f10933d + i3 + 5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C4077f mo28308b(int i) {
        int i2 = this.f10932c;
        if (i2 == 0) {
            return this;
        }
        return new C4077f(this.f10931b.mo28314b(i - i2, i2), this.f10930a, 0, this.f10933d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C4077f mo28303a(int i) {
        C4078g gVar = this.f10931b;
        int i2 = this.f10930a;
        int i3 = this.f10933d;
        if (i2 == 4 || i2 == 2) {
            int i4 = C4074d.f10923c[i2][0];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            gVar = gVar.mo28313a(i5, i6);
            i3 += i6;
            i2 = 0;
        }
        int i7 = this.f10932c;
        C4077f fVar = new C4077f(gVar, i2, this.f10932c + 1, i3 + ((i7 == 0 || i7 == 31) ? 18 : i7 == 62 ? 9 : 8));
        return fVar.f10932c == 2078 ? fVar.mo28308b(i + 1) : fVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo28306a(C4077f fVar) {
        int i;
        int i2 = this.f10933d + (C4074d.f10923c[this.f10930a][fVar.f10930a] >> 16);
        int i3 = fVar.f10932c;
        if (i3 > 0 && ((i = this.f10932c) == 0 || i > i3)) {
            i2 += 10;
        }
        return i2 <= fVar.f10933d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C4079a mo28305a(byte[] bArr) {
        LinkedList<C4078g> linkedList = new LinkedList<>();
        for (C4078g gVar = mo28308b(bArr.length).f10931b; gVar != null; gVar = gVar.mo28312a()) {
            linkedList.addFirst(gVar);
        }
        C4079a aVar = new C4079a();
        for (C4078g a : linkedList) {
            a.mo28296a(aVar, bArr);
        }
        return aVar;
    }
}
