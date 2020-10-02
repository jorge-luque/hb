package com.onesignal;

import android.view.animation.Interpolator;

/* renamed from: com.onesignal.p1 */
/* compiled from: OneSignalBounceInterpolator */
class C4614p1 implements Interpolator {

    /* renamed from: a */
    private double f12589a = 1.0d;

    /* renamed from: b */
    private double f12590b = 10.0d;

    C4614p1(double d, double d2) {
        this.f12589a = d;
        this.f12590b = d2;
    }

    public float getInterpolation(float f) {
        double d = (double) (-f);
        double d2 = this.f12589a;
        Double.isNaN(d);
        double d3 = this.f12590b;
        double d4 = (double) f;
        Double.isNaN(d4);
        return (float) ((Math.pow(2.718281828459045d, d / d2) * -1.0d * Math.cos(d3 * d4)) + 1.0d);
    }
}
