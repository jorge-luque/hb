package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.appcompat.p006a.p007a.C0383a;
import androidx.core.p013a.C0684c;
import androidx.core.p018d.C0785a;
import androidx.core.p020f.C0838s;
import androidx.core.widget.C0872b;
import androidx.core.widget.C0879i;
import androidx.core.widget.C0882k;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView extends TextView implements C0838s, C0882k, C0872b {

    /* renamed from: a */
    private final C0592e f1102a;

    /* renamed from: b */
    private final C0613m f1103b;

    /* renamed from: c */
    private final C0611l f1104c;

    /* renamed from: d */
    private Future<C0785a> f1105d;

    public AppCompatTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: g */
    private void mo2372g() {
        Future<C0785a> future = this.f1105d;
        if (future != null) {
            try {
                this.f1105d = null;
                C0879i.m2940a((TextView) this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    /* renamed from: a */
    public void mo3078a(ColorStateList colorStateList) {
        this.f1103b.mo3516a(colorStateList);
        this.f1103b.mo3511a();
    }

    /* renamed from: b */
    public void mo2925b(ColorStateList colorStateList) {
        C0592e eVar = this.f1102a;
        if (eVar != null) {
            eVar.mo3411b(colorStateList);
        }
    }

    /* renamed from: d */
    public ColorStateList mo2927d() {
        C0592e eVar = this.f1102a;
        if (eVar != null) {
            return eVar.mo3410b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0592e eVar = this.f1102a;
        if (eVar != null) {
            eVar.mo3404a();
        }
        C0613m mVar = this.f1103b;
        if (mVar != null) {
            mVar.mo3511a();
        }
    }

    /* renamed from: f */
    public PorterDuff.Mode mo2929f() {
        C0592e eVar = this.f1102a;
        if (eVar != null) {
            return eVar.mo3412c();
        }
        return null;
    }

    public int getAutoSizeMaxTextSize() {
        if (C0872b.f2160T) {
            return super.getAutoSizeMaxTextSize();
        }
        C0613m mVar = this.f1103b;
        if (mVar != null) {
            return mVar.mo3525c();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (C0872b.f2160T) {
            return super.getAutoSizeMinTextSize();
        }
        C0613m mVar = this.f1103b;
        if (mVar != null) {
            return mVar.mo3526d();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (C0872b.f2160T) {
            return super.getAutoSizeStepGranularity();
        }
        C0613m mVar = this.f1103b;
        if (mVar != null) {
            return mVar.mo3527e();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (C0872b.f2160T) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C0613m mVar = this.f1103b;
        return mVar != null ? mVar.mo3528f() : new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (!C0872b.f2160T) {
            C0613m mVar = this.f1103b;
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

    public int getFirstBaselineToTopHeight() {
        return C0879i.m2935a(this);
    }

    public int getLastBaselineToBottomHeight() {
        return C0879i.m2941b(this);
    }

    public CharSequence getText() {
        mo2372g();
        return super.getText();
    }

    public TextClassifier getTextClassifier() {
        C0611l lVar;
        if (Build.VERSION.SDK_INT >= 28 || (lVar = this.f1104c) == null) {
            return super.getTextClassifier();
        }
        return lVar.mo3507a();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        C0599h.m1629a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        C0613m mVar = this.f1103b;
        if (mVar != null) {
            mVar.mo3522a(z, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        mo2372g();
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        C0613m mVar = this.f1103b;
        if (mVar != null && !C0872b.f2160T && mVar.mo3530h()) {
            this.f1103b.mo3524b();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (C0872b.f2160T) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        C0613m mVar = this.f1103b;
        if (mVar != null) {
            mVar.mo3514a(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException {
        if (C0872b.f2160T) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        C0613m mVar = this.f1103b;
        if (mVar != null) {
            mVar.mo3523a(iArr, i);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (C0872b.f2160T) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        C0613m mVar = this.f1103b;
        if (mVar != null) {
            mVar.mo3512a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0592e eVar = this.f1102a;
        if (eVar != null) {
            eVar.mo3408a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0592e eVar = this.f1102a;
        if (eVar != null) {
            eVar.mo3405a(i);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0613m mVar = this.f1103b;
        if (mVar != null) {
            mVar.mo3531i();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0613m mVar = this.f1103b;
        if (mVar != null) {
            mVar.mo3531i();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0613m mVar = this.f1103b;
        if (mVar != null) {
            mVar.mo3531i();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0613m mVar = this.f1103b;
        if (mVar != null) {
            mVar.mo3531i();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0879i.m2936a((TextView) this, callback));
    }

    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            C0879i.m2937a((TextView) this, i);
        }
    }

    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            C0879i.m2942b(this, i);
        }
    }

    public void setLineHeight(int i) {
        C0879i.m2944c(this, i);
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C0613m mVar = this.f1103b;
        if (mVar != null) {
            mVar.mo3515a(context, i);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        C0611l lVar;
        if (Build.VERSION.SDK_INT >= 28 || (lVar = this.f1104c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            lVar.mo3508a(textClassifier);
        }
    }

    public void setTextSize(int i, float f) {
        if (C0872b.f2160T) {
            super.setTextSize(i, f);
            return;
        }
        C0613m mVar = this.f1103b;
        if (mVar != null) {
            mVar.mo3513a(i, f);
        }
    }

    public void setTypeface(Typeface typeface, int i) {
        Typeface a = (typeface == null || i <= 0) ? null : C0684c.m2117a(getContext(), typeface, i);
        if (a != null) {
            typeface = a;
        }
        super.setTypeface(typeface, i);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(C0591d0.m1568b(context), attributeSet, i);
        C0592e eVar = new C0592e(this);
        this.f1102a = eVar;
        eVar.mo3409a(attributeSet, i);
        C0613m mVar = new C0613m(this);
        this.f1103b = mVar;
        mVar.mo3519a(attributeSet, i);
        this.f1103b.mo3511a();
        this.f1104c = new C0611l(this);
    }

    /* renamed from: a */
    public void mo3079a(PorterDuff.Mode mode) {
        this.f1103b.mo3517a(mode);
        this.f1103b.mo3511a();
    }

    /* renamed from: b */
    public void mo2926b(PorterDuff.Mode mode) {
        C0592e eVar = this.f1102a;
        if (eVar != null) {
            eVar.mo3407a(mode);
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable c = i != 0 ? C0383a.m323c(context, i) : null;
        Drawable c2 = i2 != 0 ? C0383a.m323c(context, i2) : null;
        Drawable c3 = i3 != 0 ? C0383a.m323c(context, i3) : null;
        if (i4 != 0) {
            drawable = C0383a.m323c(context, i4);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(c, c2, c3, drawable);
        C0613m mVar = this.f1103b;
        if (mVar != null) {
            mVar.mo3531i();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable c = i != 0 ? C0383a.m323c(context, i) : null;
        Drawable c2 = i2 != 0 ? C0383a.m323c(context, i2) : null;
        Drawable c3 = i3 != 0 ? C0383a.m323c(context, i3) : null;
        if (i4 != 0) {
            drawable = C0383a.m323c(context, i4);
        }
        setCompoundDrawablesWithIntrinsicBounds(c, c2, c3, drawable);
        C0613m mVar = this.f1103b;
        if (mVar != null) {
            mVar.mo3531i();
        }
    }
}
