package androidx.appcompat.p008b.p009a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.C0857a;

/* renamed from: androidx.appcompat.b.a.c */
/* compiled from: DrawableWrapper */
public class C0450c extends Drawable implements Drawable.Callback {

    /* renamed from: a */
    private Drawable f637a;

    public C0450c(Drawable drawable) {
        mo2255a(drawable);
    }

    /* renamed from: a */
    public Drawable mo2254a() {
        return this.f637a;
    }

    public void draw(Canvas canvas) {
        this.f637a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f637a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f637a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f637a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f637a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f637a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f637a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f637a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f637a.getPadding(rect);
    }

    public int[] getState() {
        return this.f637a.getState();
    }

    public Region getTransparentRegion() {
        return this.f637a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return C0857a.m2815e(this.f637a);
    }

    public boolean isStateful() {
        return this.f637a.isStateful();
    }

    public void jumpToCurrentState() {
        C0857a.m2816f(this.f637a);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f637a.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f637a.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f637a.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        C0857a.m2808a(this.f637a, z);
    }

    public void setChangingConfigurations(int i) {
        this.f637a.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f637a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f637a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f637a.setFilterBitmap(z);
    }

    public void setHotspot(float f, float f2) {
        C0857a.m2802a(this.f637a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        C0857a.m2803a(this.f637a, i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        return this.f637a.setState(iArr);
    }

    public void setTint(int i) {
        C0857a.m2812b(this.f637a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        C0857a.m2804a(this.f637a, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        C0857a.m2807a(this.f637a, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f637a.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* renamed from: a */
    public void mo2255a(Drawable drawable) {
        Drawable drawable2 = this.f637a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f637a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
