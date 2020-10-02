package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.C0859c;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: androidx.appcompat.widget.j */
/* compiled from: AppCompatProgressBarHelper */
class C0605j {

    /* renamed from: c */
    private static final int[] f1472c = {16843067, 16843068};

    /* renamed from: a */
    private final ProgressBar f1473a;

    /* renamed from: b */
    private Bitmap f1474b;

    C0605j(ProgressBar progressBar) {
        this.f1473a = progressBar;
    }

    /* renamed from: b */
    private Shape mo3502b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, (RectF) null, (float[]) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3491a(AttributeSet attributeSet, int i) {
        C0598g0 a = C0598g0.m1610a(this.f1473a.getContext(), attributeSet, f1472c, i, 0);
        Drawable c = a.mo3439c(0);
        if (c != null) {
            this.f1473a.setIndeterminateDrawable(mo3501a(c));
        }
        Drawable c2 = a.mo3439c(1);
        if (c2 != null) {
            this.f1473a.setProgressDrawable(m1681a(c2, false));
        }
        a.mo3434a();
    }

    /* renamed from: a */
    private Drawable m1681a(Drawable drawable, boolean z) {
        if (drawable instanceof C0859c) {
            C0859c cVar = (C0859c) drawable;
            Drawable a = cVar.mo4230a();
            if (a != null) {
                cVar.mo4231a(m1681a(a, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                int id = layerDrawable.getId(i);
                drawableArr[i] = m1681a(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable2.setId(i2, layerDrawable.getId(i2));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f1474b == null) {
                this.f1474b = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(mo3502b());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    /* renamed from: a */
    private Drawable mo3501a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable a = m1681a(animationDrawable.getFrame(i), true);
            a.setLevel(C6078a.DEFAULT_TIMEOUT);
            animationDrawable2.addFrame(a, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(C6078a.DEFAULT_TIMEOUT);
        return animationDrawable2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bitmap mo3490a() {
        return this.f1474b;
    }
}
