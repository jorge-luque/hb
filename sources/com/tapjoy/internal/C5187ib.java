package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.ib */
public final class C5187ib {

    /* renamed from: a */
    public float f14213a;

    /* renamed from: b */
    public int f14214b;

    /* renamed from: a */
    public static C5187ib m17427a(String str) {
        if (C3166jq.m10436c(str)) {
            return null;
        }
        try {
            C5187ib ibVar = new C5187ib();
            int length = str.length() - 1;
            char charAt = str.charAt(length);
            if (charAt == 'w') {
                ibVar.f14213a = Float.valueOf(str.substring(0, length)).floatValue();
                ibVar.f14214b = 1;
            } else if (charAt == 'h') {
                ibVar.f14213a = Float.valueOf(str.substring(0, length)).floatValue();
                ibVar.f14214b = 2;
            } else {
                ibVar.f14213a = Float.valueOf(str).floatValue();
                ibVar.f14214b = 0;
            }
            return ibVar;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public final float mo31351a(float f, float f2) {
        int i = this.f14214b;
        if (i == 1) {
            return (this.f14213a * f) / 100.0f;
        }
        if (i == 2) {
            return (this.f14213a * f2) / 100.0f;
        }
        return this.f14213a;
    }
}
