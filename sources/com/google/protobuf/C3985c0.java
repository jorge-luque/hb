package com.google.protobuf;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.protobuf.c0 */
/* compiled from: UnknownFieldSetLite */
public final class C3985c0 {

    /* renamed from: f */
    private static final C3985c0 f10745f = new C3985c0(0, new int[0], new Object[0], false);

    /* renamed from: a */
    private int f10746a;

    /* renamed from: b */
    private int[] f10747b;

    /* renamed from: c */
    private Object[] f10748c;

    /* renamed from: d */
    private int f10749d;

    /* renamed from: e */
    private boolean f10750e;

    private C3985c0() {
        this(0, new int[8], new Object[8], true);
    }

    /* renamed from: a */
    static C3985c0 m13258a(C3985c0 c0Var, C3985c0 c0Var2) {
        int i = c0Var.f10746a + c0Var2.f10746a;
        int[] copyOf = Arrays.copyOf(c0Var.f10747b, i);
        System.arraycopy(c0Var2.f10747b, 0, copyOf, c0Var.f10746a, c0Var2.f10746a);
        Object[] copyOf2 = Arrays.copyOf(c0Var.f10748c, i);
        System.arraycopy(c0Var2.f10748c, 0, copyOf2, c0Var.f10746a, c0Var2.f10746a);
        return new C3985c0(i, copyOf, copyOf2, true);
    }

    /* renamed from: d */
    private void m13261d() {
        int i = this.f10746a;
        if (i == this.f10747b.length) {
            int i2 = this.f10746a + (i < 4 ? 8 : i >> 1);
            this.f10747b = Arrays.copyOf(this.f10747b, i2);
            this.f10748c = Arrays.copyOf(this.f10748c, i2);
        }
    }

    /* renamed from: e */
    public static C3985c0 m13262e() {
        return f10745f;
    }

    /* renamed from: f */
    static C3985c0 m13263f() {
        return new C3985c0();
    }

    /* renamed from: b */
    public int mo28087b() {
        int i;
        int i2 = this.f10749d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f10746a; i4++) {
            int i5 = this.f10747b[i4];
            int a = C4005f0.m13357a(i5);
            int b = C4005f0.m13359b(i5);
            if (b == 0) {
                i = CodedOutputStream.m13139f(a, ((Long) this.f10748c[i4]).longValue());
            } else if (b == 1) {
                i = CodedOutputStream.m13131d(a, ((Long) this.f10748c[i4]).longValue());
            } else if (b == 2) {
                i = CodedOutputStream.m13122b(a, (C3995f) this.f10748c[i4]);
            } else if (b == 3) {
                i = (CodedOutputStream.m13143i(a) * 2) + ((C3985c0) this.f10748c[i4]).mo28087b();
            } else if (b == 5) {
                i = CodedOutputStream.m13138f(a, ((Integer) this.f10748c[i4]).intValue());
            } else {
                throw new IllegalStateException(InvalidProtocolBufferException.m13213d());
            }
            i3 += i;
        }
        this.f10749d = i3;
        return i3;
    }

    /* renamed from: c */
    public void mo28088c() {
        this.f10750e = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C3985c0)) {
            return false;
        }
        C3985c0 c0Var = (C3985c0) obj;
        return this.f10746a == c0Var.f10746a && Arrays.equals(this.f10747b, c0Var.f10747b) && Arrays.deepEquals(this.f10748c, c0Var.f10748c);
    }

    public int hashCode() {
        return ((((527 + this.f10746a) * 31) + Arrays.hashCode(this.f10747b)) * 31) + Arrays.deepHashCode(this.f10748c);
    }

    private C3985c0(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f10749d = -1;
        this.f10746a = i;
        this.f10747b = iArr;
        this.f10748c = objArr;
        this.f10750e = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo28083a() {
        if (!this.f10750e) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: a */
    public void mo28084a(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.f10746a; i++) {
            int i2 = this.f10747b[i];
            int a = C4005f0.m13357a(i2);
            int b = C4005f0.m13359b(i2);
            if (b == 0) {
                codedOutputStream.mo27978c(a, ((Long) this.f10748c[i]).longValue());
            } else if (b == 1) {
                codedOutputStream.mo27966a(a, ((Long) this.f10748c[i]).longValue());
            } else if (b == 2) {
                codedOutputStream.mo27967a(a, (C3995f) this.f10748c[i]);
            } else if (b == 3) {
                codedOutputStream.mo27979d(a, 3);
                ((C3985c0) this.f10748c[i]).mo28084a(codedOutputStream);
                codedOutputStream.mo27979d(a, 4);
            } else if (b == 5) {
                codedOutputStream.mo27974b(a, ((Integer) this.f10748c[i]).intValue());
            } else {
                throw InvalidProtocolBufferException.m13213d();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo28085a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f10746a; i2++) {
            C4057w.m13527a(sb, i, String.valueOf(C4005f0.m13357a(this.f10747b[i2])), this.f10748c[i2]);
        }
    }

    /* renamed from: a */
    private void m13260a(int i, Object obj) {
        m13261d();
        int[] iArr = this.f10747b;
        int i2 = this.f10746a;
        iArr[i2] = i;
        this.f10748c[i2] = obj;
        this.f10746a = i2 + 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo28086a(int i, C4013g gVar) throws IOException {
        mo28083a();
        int a = C4005f0.m13357a(i);
        int b = C4005f0.m13359b(i);
        if (b == 0) {
            m13260a(i, (Object) Long.valueOf(gVar.mo28146h()));
            return true;
        } else if (b == 1) {
            m13260a(i, (Object) Long.valueOf(gVar.mo28144f()));
            return true;
        } else if (b == 2) {
            m13260a(i, (Object) gVar.mo28139c());
            return true;
        } else if (b == 3) {
            C3985c0 c0Var = new C3985c0();
            c0Var.m13259a(gVar);
            gVar.mo28134a(C4005f0.m13358a(a, 4));
            m13260a(i, (Object) c0Var);
            return true;
        } else if (b == 4) {
            return false;
        } else {
            if (b == 5) {
                m13260a(i, (Object) Integer.valueOf(gVar.mo28142e()));
                return true;
            }
            throw InvalidProtocolBufferException.m13213d();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3985c0 mo28081a(int i, int i2) {
        mo28083a();
        if (i != 0) {
            m13260a(C4005f0.m13358a(i, 0), (Object) Long.valueOf((long) i2));
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3985c0 mo28082a(int i, C3995f fVar) {
        mo28083a();
        if (i != 0) {
            m13260a(C4005f0.m13358a(i, 2), (Object) fVar);
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* renamed from: a */
    private com.google.protobuf.C3985c0 m13259a(com.google.protobuf.C4013g r2) throws java.io.IOException {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r2.mo28155q()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.mo28086a((int) r0, (com.google.protobuf.C4013g) r2)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C3985c0.m13259a(com.google.protobuf.g):com.google.protobuf.c0");
    }
}
