package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.core.p020f.C0838s;
import androidx.core.widget.C0872b;
import androidx.core.widget.C0879i;

public class AppCompatButton extends Button implements C0838s, C0872b {

    /* renamed from: a */
    private final C0592e f1049a;

    /* renamed from: b */
    private final C0613m f1050b;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.buttonStyle);
    }

    /* renamed from: b */
    public void mo2925b(ColorStateList colorStateList) {
        C0592e eVar = this.f1049a;
        if (eVar != null) {
            eVar.mo3411b(colorStateList);
        }
    }

    /* renamed from: d */
    public ColorStateList mo2927d() {
        C0592e eVar = this.f1049a;
        if (eVar != null) {
            return eVar.mo3410b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0592e eVar = this.f1049a;
        if (eVar != null) {
            eVar.mo3404a();
        }
        C0613m mVar = this.f1050b;
        if (mVar != null) {
            mVar.mo3511a();
        }
    }

    /* renamed from: f */
    public PorterDuff.Mode mo2929f() {
        C0592e eVar = this.f1049a;
        if (eVar != null) {
            return eVar.mo3412c();
        }
        return null;
    }

    public int getAutoSizeMaxTextSize() {
        if (C0872b.f2160T) {
            return super.getAutoSizeMaxTextSize();
        }
        C0613m mVar = this.f1050b;
        if (mVar != null) {
            return mVar.mo3525c();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (C0872b.f2160T) {
            return super.getAutoSizeMinTextSize();
        }
        C0613m mVar = this.f1050b;
        if (mVar != null) {
            return mVar.mo3526d();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (C0872b.f2160T) {
            return super.getAutoSizeStepGranularity();
        }
        C0613m mVar = this.f1050b;
        if (mVar != null) {
            return mVar.mo3527e();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (C0872b.f2160T) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C0613m mVar = this.f1050b;
        return mVar != null ? mVar.mo3528f() : new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (!C0872b.f2160T) {
            C0613m mVar = this.f1050b;
            if (mVar != null) {
                return mVar.mo3529g();
            }
            return 0;
        } else if (super.getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        C0613m mVar = this.f1050b;
        if (mVar != null) {
            mVar.mo3522a(z, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        C0613m mVar = this.f1050b;
        if (mVar != null && !C0872b.f2160T && mVar.mo3530h()) {
            this.f1050b.mo3524b();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (C0872b.f2160T) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        C0613m mVar = this.f1050b;
        if (mVar != null) {
            mVar.mo3514a(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException {
        if (C0872b.f2160T) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        C0613m mVar = this.f1050b;
        if (mVar != null) {
            mVar.mo3523a(iArr, i);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (C0872b.f2160T) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        C0613m mVar = this.f1050b;
        if (mVar != null) {
            mVar.mo3512a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0592e eVar = this.f1049a;
        if (eVar != null) {
            eVar.mo3408a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0592e eVar = this.f1049a;
        if (eVar != null) {
            eVar.mo3405a(i);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0879i.m2936a((TextView) this, callback));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C0613m mVar = this.f1050b;
        if (mVar != null) {
            mVar.mo3515a(context, i);
        }
    }

    public void setTextSize(int i, float f) {
        if (C0872b.f2160T) {
            super.setTextSize(i, f);
            return;
        }
        C0613m mVar = this.f1050b;
        if (mVar != null) {
            mVar.mo3513a(i, f);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(C0591d0.m1568b(context), attributeSet, i);
        C0592e eVar = new C0592e(this);
        this.f1049a = eVar;
        eVar.mo3409a(attributeSet, i);
        C0613m mVar = new C0613m(this);
        this.f1050b = mVar;
        mVar.mo3519a(attributeSet, i);
        this.f1050b.mo3511a();
    }

    /* renamed from: b */
    public void mo2926b(PorterDuff.Mode mode) {
        C0592e eVar = this.f1049a;
        if (eVar != null) {
            eVar.mo3407a(mode);
        }
    }
}
