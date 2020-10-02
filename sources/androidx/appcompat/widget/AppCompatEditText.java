package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.core.p020f.C0838s;
import androidx.core.widget.C0879i;

public class AppCompatEditText extends EditText implements C0838s {

    /* renamed from: a */
    private final C0592e f1056a;

    /* renamed from: b */
    private final C0613m f1057b;

    /* renamed from: c */
    private final C0611l f1058c;

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.editTextStyle);
    }

    /* renamed from: b */
    public void mo2925b(ColorStateList colorStateList) {
        C0592e eVar = this.f1056a;
        if (eVar != null) {
            eVar.mo3411b(colorStateList);
        }
    }

    /* renamed from: d */
    public ColorStateList mo2927d() {
        C0592e eVar = this.f1056a;
        if (eVar != null) {
            return eVar.mo3410b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0592e eVar = this.f1056a;
        if (eVar != null) {
            eVar.mo3404a();
        }
        C0613m mVar = this.f1057b;
        if (mVar != null) {
            mVar.mo3511a();
        }
    }

    /* renamed from: f */
    public PorterDuff.Mode mo2929f() {
        C0592e eVar = this.f1056a;
        if (eVar != null) {
            return eVar.mo3412c();
        }
        return null;
    }

    public TextClassifier getTextClassifier() {
        C0611l lVar;
        if (Build.VERSION.SDK_INT >= 28 || (lVar = this.f1058c) == null) {
            return super.getTextClassifier();
        }
        return lVar.mo3507a();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        C0599h.m1629a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0592e eVar = this.f1056a;
        if (eVar != null) {
            eVar.mo3408a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0592e eVar = this.f1056a;
        if (eVar != null) {
            eVar.mo3405a(i);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0879i.m2936a((TextView) this, callback));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C0613m mVar = this.f1057b;
        if (mVar != null) {
            mVar.mo3515a(context, i);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        C0611l lVar;
        if (Build.VERSION.SDK_INT >= 28 || (lVar = this.f1058c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            lVar.mo3508a(textClassifier);
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(C0591d0.m1568b(context), attributeSet, i);
        C0592e eVar = new C0592e(this);
        this.f1056a = eVar;
        eVar.mo3409a(attributeSet, i);
        C0613m mVar = new C0613m(this);
        this.f1057b = mVar;
        mVar.mo3519a(attributeSet, i);
        this.f1057b.mo3511a();
        this.f1058c = new C0611l(this);
    }

    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }

    /* renamed from: b */
    public void mo2926b(PorterDuff.Mode mode) {
        C0592e eVar = this.f1056a;
        if (eVar != null) {
            eVar.mo3407a(mode);
        }
    }
}
