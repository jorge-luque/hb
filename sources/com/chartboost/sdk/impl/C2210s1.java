package com.chartboost.sdk.impl;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: com.chartboost.sdk.impl.s1 */
public final class C2210s1 extends Animation {

    /* renamed from: a */
    private final float f7453a;

    /* renamed from: b */
    private final float f7454b;

    /* renamed from: c */
    private final float f7455c;

    /* renamed from: d */
    private final float f7456d;

    /* renamed from: e */
    private boolean f7457e = true;

    /* renamed from: f */
    private Camera f7458f;

    public C2210s1(float f, float f2, float f3, float f4, boolean z) {
        this.f7453a = f;
        this.f7454b = f2;
        this.f7455c = f3;
        this.f7456d = f4;
        this.f7457e = z;
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f, Transformation transformation) {
        float f2 = this.f7453a;
        float f3 = f2 + ((this.f7454b - f2) * f);
        Camera camera = this.f7458f;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.f7457e) {
            camera.rotateY(f3);
        } else {
            camera.rotateX(f3);
        }
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-this.f7455c, -this.f7456d);
        matrix.postTranslate(this.f7455c, this.f7456d);
    }

    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.f7458f = new Camera();
    }
}
