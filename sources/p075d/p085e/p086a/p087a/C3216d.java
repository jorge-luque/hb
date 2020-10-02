package p075d.p085e.p086a.p087a;

import android.view.animation.Interpolator;

/* renamed from: d.e.a.a.d */
/* compiled from: LookupTableInterpolator */
abstract class C3216d implements Interpolator {

    /* renamed from: a */
    private final float[] f8980a;

    /* renamed from: b */
    private final float f8981b;

    protected C3216d(float[] fArr) {
        this.f8980a = fArr;
        this.f8981b = 1.0f / ((float) (fArr.length - 1));
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f8980a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f), fArr.length - 2);
        float f2 = this.f8981b;
        float f3 = (f - (((float) min) * f2)) / f2;
        float[] fArr2 = this.f8980a;
        return fArr2[min] + (f3 * (fArr2[min + 1] - fArr2[min]));
    }
}
