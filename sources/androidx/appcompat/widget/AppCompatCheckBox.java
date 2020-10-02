package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.appcompat.R$attr;
import androidx.appcompat.p006a.p007a.C0383a;
import androidx.core.p020f.C0838s;
import androidx.core.widget.C0881j;

public class AppCompatCheckBox extends CheckBox implements C0881j, C0838s {

    /* renamed from: a */
    private final C0594f f1051a;

    /* renamed from: b */
    private final C0592e f1052b;

    /* renamed from: c */
    private final C0613m f1053c;

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkboxStyle);
    }

    /* renamed from: a */
    public void mo2954a(ColorStateList colorStateList) {
        C0594f fVar = this.f1051a;
        if (fVar != null) {
            fVar.mo3416a(colorStateList);
        }
    }

    /* renamed from: b */
    public void mo2925b(ColorStateList colorStateList) {
        C0592e eVar = this.f1052b;
        if (eVar != null) {
            eVar.mo3411b(colorStateList);
        }
    }

    /* renamed from: d */
    public ColorStateList mo2927d() {
        C0592e eVar = this.f1052b;
        if (eVar != null) {
            return eVar.mo3410b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0592e eVar = this.f1052b;
        if (eVar != null) {
            eVar.mo3404a();
        }
        C0613m mVar = this.f1053c;
        if (mVar != null) {
            mVar.mo3511a();
        }
    }

    /* renamed from: f */
    public PorterDuff.Mode mo2929f() {
        C0592e eVar = this.f1052b;
        if (eVar != null) {
            return eVar.mo3412c();
        }
        return null;
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0594f fVar = this.f1051a;
        return fVar != null ? fVar.mo3414a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0592e eVar = this.f1052b;
        if (eVar != null) {
            eVar.mo3408a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0592e eVar = this.f1052b;
        if (eVar != null) {
            eVar.mo3405a(i);
        }
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0594f fVar = this.f1051a;
        if (fVar != null) {
            fVar.mo3419b();
        }
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(C0591d0.m1568b(context), attributeSet, i);
        C0594f fVar = new C0594f(this);
        this.f1051a = fVar;
        fVar.mo3418a(attributeSet, i);
        C0592e eVar = new C0592e(this);
        this.f1052b = eVar;
        eVar.mo3409a(attributeSet, i);
        C0613m mVar = new C0613m(this);
        this.f1053c = mVar;
        mVar.mo3519a(attributeSet, i);
    }

    /* renamed from: a */
    public void mo2955a(PorterDuff.Mode mode) {
        C0594f fVar = this.f1051a;
        if (fVar != null) {
            fVar.mo3417a(mode);
        }
    }

    /* renamed from: b */
    public void mo2926b(PorterDuff.Mode mode) {
        C0592e eVar = this.f1052b;
        if (eVar != null) {
            eVar.mo3407a(mode);
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(C0383a.m323c(getContext(), i));
    }
}
