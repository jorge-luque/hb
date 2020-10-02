package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.R$attr;
import androidx.core.p020f.C0838s;
import androidx.core.widget.C0883l;

public class AppCompatImageButton extends ImageButton implements C0838s, C0883l {

    /* renamed from: a */
    private final C0592e f1059a;

    /* renamed from: b */
    private final C0603i f1060b;

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.imageButtonStyle);
    }

    /* renamed from: a */
    public void mo2977a(ColorStateList colorStateList) {
        C0603i iVar = this.f1060b;
        if (iVar != null) {
            iVar.mo3484a(colorStateList);
        }
    }

    /* renamed from: b */
    public void mo2925b(ColorStateList colorStateList) {
        C0592e eVar = this.f1059a;
        if (eVar != null) {
            eVar.mo3411b(colorStateList);
        }
    }

    /* renamed from: c */
    public PorterDuff.Mode mo2979c() {
        C0603i iVar = this.f1060b;
        if (iVar != null) {
            return iVar.mo3488c();
        }
        return null;
    }

    /* renamed from: d */
    public ColorStateList mo2927d() {
        C0592e eVar = this.f1059a;
        if (eVar != null) {
            return eVar.mo3410b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0592e eVar = this.f1059a;
        if (eVar != null) {
            eVar.mo3404a();
        }
        C0603i iVar = this.f1060b;
        if (iVar != null) {
            iVar.mo3482a();
        }
    }

    /* renamed from: f */
    public PorterDuff.Mode mo2929f() {
        C0592e eVar = this.f1059a;
        if (eVar != null) {
            return eVar.mo3412c();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.f1060b.mo3489d() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0592e eVar = this.f1059a;
        if (eVar != null) {
            eVar.mo3408a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0592e eVar = this.f1059a;
        if (eVar != null) {
            eVar.mo3405a(i);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0603i iVar = this.f1060b;
        if (iVar != null) {
            iVar.mo3482a();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        C0603i iVar = this.f1060b;
        if (iVar != null) {
            iVar.mo3482a();
        }
    }

    public void setImageResource(int i) {
        this.f1060b.mo3483a(i);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0603i iVar = this.f1060b;
        if (iVar != null) {
            iVar.mo3482a();
        }
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(C0591d0.m1568b(context), attributeSet, i);
        C0592e eVar = new C0592e(this);
        this.f1059a = eVar;
        eVar.mo3409a(attributeSet, i);
        C0603i iVar = new C0603i(this);
        this.f1060b = iVar;
        iVar.mo3486a(attributeSet, i);
    }

    /* renamed from: a */
    public ColorStateList mo2976a() {
        C0603i iVar = this.f1060b;
        if (iVar != null) {
            return iVar.mo3487b();
        }
        return null;
    }

    /* renamed from: b */
    public void mo2926b(PorterDuff.Mode mode) {
        C0592e eVar = this.f1059a;
        if (eVar != null) {
            eVar.mo3407a(mode);
        }
    }

    /* renamed from: a */
    public void mo2978a(PorterDuff.Mode mode) {
        C0603i iVar = this.f1060b;
        if (iVar != null) {
            iVar.mo3485a(mode);
        }
    }
}
