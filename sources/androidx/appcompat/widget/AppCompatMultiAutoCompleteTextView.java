package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.p006a.p007a.C0383a;
import androidx.core.p020f.C0838s;

public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements C0838s {

    /* renamed from: c */
    private static final int[] f1063c = {16843126};

    /* renamed from: a */
    private final C0592e f1064a;

    /* renamed from: b */
    private final C0613m f1065b;

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    /* renamed from: b */
    public void mo2925b(ColorStateList colorStateList) {
        C0592e eVar = this.f1064a;
        if (eVar != null) {
            eVar.mo3411b(colorStateList);
        }
    }

    /* renamed from: d */
    public ColorStateList mo2927d() {
        C0592e eVar = this.f1064a;
        if (eVar != null) {
            return eVar.mo3410b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0592e eVar = this.f1064a;
        if (eVar != null) {
            eVar.mo3404a();
        }
        C0613m mVar = this.f1065b;
        if (mVar != null) {
            mVar.mo3511a();
        }
    }

    /* renamed from: f */
    public PorterDuff.Mode mo2929f() {
        C0592e eVar = this.f1064a;
        if (eVar != null) {
            return eVar.mo3412c();
        }
        return null;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        C0599h.m1629a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0592e eVar = this.f1064a;
        if (eVar != null) {
            eVar.mo3408a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0592e eVar = this.f1064a;
        if (eVar != null) {
            eVar.mo3405a(i);
        }
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(C0383a.m323c(getContext(), i));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C0613m mVar = this.f1065b;
        if (mVar != null) {
            mVar.mo3515a(context, i);
        }
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(C0591d0.m1568b(context), attributeSet, i);
        C0598g0 a = C0598g0.m1610a(getContext(), attributeSet, f1063c, i, 0);
        if (a.mo3447g(0)) {
            setDropDownBackgroundDrawable(a.mo3437b(0));
        }
        a.mo3434a();
        C0592e eVar = new C0592e(this);
        this.f1064a = eVar;
        eVar.mo3409a(attributeSet, i);
        C0613m mVar = new C0613m(this);
        this.f1065b = mVar;
        mVar.mo3519a(attributeSet, i);
        this.f1065b.mo3511a();
    }

    /* renamed from: b */
    public void mo2926b(PorterDuff.Mode mode) {
        C0592e eVar = this.f1064a;
        if (eVar != null) {
            eVar.mo3407a(mode);
        }
    }
}
