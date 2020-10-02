package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* renamed from: androidx.core.graphics.drawable.f */
/* compiled from: WrappedDrawableState */
final class C0862f extends Drawable.ConstantState {

    /* renamed from: a */
    int f2097a;

    /* renamed from: b */
    Drawable.ConstantState f2098b;

    /* renamed from: c */
    ColorStateList f2099c = null;

    /* renamed from: d */
    PorterDuff.Mode f2100d = C0860d.f2089g;

    C0862f(C0862f fVar) {
        if (fVar != null) {
            this.f2097a = fVar.f2097a;
            this.f2098b = fVar.f2098b;
            this.f2099c = fVar.f2099c;
            this.f2100d = fVar.f2100d;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4267a() {
        return this.f2098b != null;
    }

    public int getChangingConfigurations() {
        int i = this.f2097a;
        Drawable.ConstantState constantState = this.f2098b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    public Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    public Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new C0861e(this, resources);
        }
        return new C0860d(this, resources);
    }
}
