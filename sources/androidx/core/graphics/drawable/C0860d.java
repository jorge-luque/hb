package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* renamed from: androidx.core.graphics.drawable.d */
/* compiled from: WrappedDrawableApi14 */
class C0860d extends Drawable implements Drawable.Callback, C0859c, C0858b {

    /* renamed from: g */
    static final PorterDuff.Mode f2089g = PorterDuff.Mode.SRC_IN;

    /* renamed from: a */
    private int f2090a;

    /* renamed from: b */
    private PorterDuff.Mode f2091b;

    /* renamed from: c */
    private boolean f2092c;

    /* renamed from: d */
    C0862f f2093d;

    /* renamed from: e */
    private boolean f2094e;

    /* renamed from: f */
    Drawable f2095f;

    C0860d(C0862f fVar, Resources resources) {
        this.f2093d = fVar;
        m2821a(resources);
    }

    /* renamed from: a */
    private void m2821a(Resources resources) {
        Drawable.ConstantState constantState;
        C0862f fVar = this.f2093d;
        if (fVar != null && (constantState = fVar.f2098b) != null) {
            mo4231a(constantState.newDrawable(resources));
        }
    }

    /* renamed from: c */
    private C0862f m2823c() {
        return new C0862f(this.f2093d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo4232b() {
        return true;
    }

    public void draw(Canvas canvas) {
        this.f2095f.draw(canvas);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        C0862f fVar = this.f2093d;
        return changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0) | this.f2095f.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        C0862f fVar = this.f2093d;
        if (fVar == null || !fVar.mo4267a()) {
            return null;
        }
        this.f2093d.f2097a = getChangingConfigurations();
        return this.f2093d;
    }

    public Drawable getCurrent() {
        return this.f2095f.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f2095f.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f2095f.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f2095f.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f2095f.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f2095f.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f2095f.getPadding(rect);
    }

    public int[] getState() {
        return this.f2095f.getState();
    }

    public Region getTransparentRegion() {
        return this.f2095f.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return this.f2095f.isAutoMirrored();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f2093d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = r1.mo4232b()
            if (r0 == 0) goto L_0x000d
            androidx.core.graphics.drawable.f r0 = r1.f2093d
            if (r0 == 0) goto L_0x000d
            android.content.res.ColorStateList r0 = r0.f2099c
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001e
        L_0x0016:
            android.graphics.drawable.Drawable r0 = r1.f2095f
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0020
        L_0x001e:
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.C0860d.isStateful():boolean");
    }

    public void jumpToCurrentState() {
        this.f2095f.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (!this.f2094e && super.mutate() == this) {
            this.f2093d = m2823c();
            Drawable drawable = this.f2095f;
            if (drawable != null) {
                drawable.mutate();
            }
            C0862f fVar = this.f2093d;
            if (fVar != null) {
                Drawable drawable2 = this.f2095f;
                fVar.f2098b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f2094e = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2095f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f2095f.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f2095f.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        this.f2095f.setAutoMirrored(z);
    }

    public void setChangingConfigurations(int i) {
        this.f2095f.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2095f.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f2095f.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f2095f.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return m2822a(iArr) || this.f2095f.setState(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f2093d.f2099c = colorStateList;
        m2822a(getState());
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f2093d.f2100d = mode;
        m2822a(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f2095f.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* renamed from: a */
    private boolean m2822a(int[] iArr) {
        if (!mo4232b()) {
            return false;
        }
        C0862f fVar = this.f2093d;
        ColorStateList colorStateList = fVar.f2099c;
        PorterDuff.Mode mode = fVar.f2100d;
        if (colorStateList == null || mode == null) {
            this.f2092c = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f2092c && colorForState == this.f2090a && mode == this.f2091b)) {
                setColorFilter(colorForState, mode);
                this.f2090a = colorForState;
                this.f2091b = mode;
                this.f2092c = true;
                return true;
            }
        }
        return false;
    }

    C0860d(Drawable drawable) {
        this.f2093d = m2823c();
        mo4231a(drawable);
    }

    /* renamed from: a */
    public final Drawable mo4230a() {
        return this.f2095f;
    }

    /* renamed from: a */
    public final void mo4231a(Drawable drawable) {
        Drawable drawable2 = this.f2095f;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f2095f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            C0862f fVar = this.f2093d;
            if (fVar != null) {
                fVar.f2098b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
