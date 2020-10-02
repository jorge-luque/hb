package com.tapjoy.internal;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: com.tapjoy.internal.af */
public final class C4883af extends Animation {

    /* renamed from: a */
    private final boolean f13325a;

    /* renamed from: b */
    private final float f13326b;

    /* renamed from: c */
    private final float f13327c;

    /* renamed from: d */
    private final int f13328d;

    /* renamed from: e */
    private final float f13329e;

    /* renamed from: f */
    private final int f13330f;

    /* renamed from: g */
    private final float f13331g;

    /* renamed from: h */
    private float f13332h;

    /* renamed from: i */
    private float f13333i;

    /* renamed from: j */
    private Camera f13334j;

    public C4883af(boolean z, float f, float f2, int i, float f3, int i2, float f4) {
        this.f13325a = z;
        this.f13326b = f;
        this.f13327c = f2;
        this.f13328d = i;
        this.f13329e = f3;
        this.f13330f = i2;
        this.f13331g = f4;
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f, Transformation transformation) {
        float f2 = this.f13326b;
        float f3 = f2 + ((this.f13327c - f2) * f);
        Matrix matrix = transformation.getMatrix();
        Camera camera = this.f13334j;
        camera.save();
        if (this.f13325a) {
            camera.rotateX(f3);
        } else {
            camera.rotateY(f3);
        }
        camera.getMatrix(matrix);
        camera.restore();
        float f4 = this.f13332h;
        float f5 = this.f13333i;
        matrix.preTranslate(-f4, -f5);
        matrix.postTranslate(f4, f5);
    }

    public final void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.f13332h = resolveSize(this.f13328d, this.f13329e, i, i3);
        this.f13333i = resolveSize(this.f13330f, this.f13331g, i2, i4);
        this.f13334j = new Camera();
    }
}
