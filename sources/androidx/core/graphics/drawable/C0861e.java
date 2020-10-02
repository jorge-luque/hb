package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: androidx.core.graphics.drawable.e */
/* compiled from: WrappedDrawableApi21 */
class C0861e extends C0860d {

    /* renamed from: h */
    private static Method f2096h;

    C0861e(Drawable drawable) {
        super(drawable);
        m2827c();
    }

    /* renamed from: c */
    private void m2827c() {
        if (f2096h == null) {
            try {
                f2096h = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo4232b() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f2095f;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    public Rect getDirtyBounds() {
        return this.f2095f.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.f2095f.getOutline(outline);
    }

    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f2095f;
        if (!(drawable == null || (method = f2096h) == null)) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e);
            }
        }
        return false;
    }

    public void setHotspot(float f, float f2) {
        this.f2095f.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f2095f.setHotspotBounds(i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public void setTint(int i) {
        if (mo4232b()) {
            super.setTint(i);
        } else {
            this.f2095f.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (mo4232b()) {
            super.setTintList(colorStateList);
        } else {
            this.f2095f.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (mo4232b()) {
            super.setTintMode(mode);
        } else {
            this.f2095f.setTintMode(mode);
        }
    }

    C0861e(C0862f fVar, Resources resources) {
        super(fVar, resources);
        m2827c();
    }
}
