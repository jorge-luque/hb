package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.jf */
public final class C5227jf {

    /* renamed from: a */
    public static C5227jf f14343a = new C5227jf((String) null);

    /* renamed from: b */
    public String f14344b;

    /* renamed from: c */
    public Throwable f14345c;

    /* renamed from: d */
    private Object[] f14346d;

    public C5227jf(String str) {
        this(str, (Object[]) null, (Throwable) null);
    }

    public C5227jf(String str, Object[] objArr, Throwable th) {
        this.f14344b = str;
        this.f14345c = th;
        if (th == null) {
            this.f14346d = objArr;
        } else if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        } else {
            int length = objArr.length - 1;
            Object[] objArr2 = new Object[length];
            System.arraycopy(objArr, 0, objArr2, 0, length);
            this.f14346d = objArr2;
        }
    }
}
