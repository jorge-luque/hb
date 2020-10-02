package com.tapjoy.internal;

import com.facebook.internal.Utility;

/* renamed from: com.tapjoy.internal.iy */
final class C5218iy {

    /* renamed from: a */
    final byte[] f14328a;

    /* renamed from: b */
    int f14329b;

    /* renamed from: c */
    int f14330c;

    /* renamed from: d */
    boolean f14331d;

    /* renamed from: e */
    boolean f14332e;

    /* renamed from: f */
    C5218iy f14333f;

    /* renamed from: g */
    C5218iy f14334g;

    C5218iy() {
        this.f14328a = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        this.f14332e = true;
        this.f14331d = false;
    }

    /* renamed from: a */
    public final C5218iy mo31435a() {
        C5218iy iyVar = this.f14333f;
        if (iyVar == this) {
            iyVar = null;
        }
        C5218iy iyVar2 = this.f14334g;
        iyVar2.f14333f = this.f14333f;
        this.f14333f.f14334g = iyVar2;
        this.f14333f = null;
        this.f14334g = null;
        return iyVar;
    }

    C5218iy(C5218iy iyVar) {
        this(iyVar.f14328a, iyVar.f14329b, iyVar.f14330c);
        iyVar.f14331d = true;
    }

    /* renamed from: a */
    public final C5218iy mo31436a(C5218iy iyVar) {
        iyVar.f14334g = this;
        iyVar.f14333f = this.f14333f;
        this.f14333f.f14334g = iyVar;
        this.f14333f = iyVar;
        return iyVar;
    }

    C5218iy(byte[] bArr, int i, int i2) {
        this.f14328a = bArr;
        this.f14329b = i;
        this.f14330c = i2;
        this.f14332e = false;
        this.f14331d = true;
    }

    /* renamed from: a */
    public final void mo31437a(C5218iy iyVar, int i) {
        if (iyVar.f14332e) {
            int i2 = iyVar.f14330c;
            if (i2 + i > 8192) {
                if (!iyVar.f14331d) {
                    int i3 = iyVar.f14329b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = iyVar.f14328a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        iyVar.f14330c -= iyVar.f14329b;
                        iyVar.f14329b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f14328a, this.f14329b, iyVar.f14328a, iyVar.f14330c, i);
            iyVar.f14330c += i;
            this.f14329b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
