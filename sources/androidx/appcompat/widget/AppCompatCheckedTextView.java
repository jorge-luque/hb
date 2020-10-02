package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.appcompat.p006a.p007a.C0383a;
import androidx.core.widget.C0879i;

public class AppCompatCheckedTextView extends CheckedTextView {

    /* renamed from: b */
    private static final int[] f1054b = {16843016};

    /* renamed from: a */
    private final C0613m f1055a;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0613m mVar = this.f1055a;
        if (mVar != null) {
            mVar.mo3511a();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        C0599h.m1629a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(C0383a.m323c(getContext(), i));
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0879i.m2936a((TextView) this, callback));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C0613m mVar = this.f1055a;
        if (mVar != null) {
            mVar.mo3515a(context, i);
        }
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(C0591d0.m1568b(context), attributeSet, i);
        C0613m mVar = new C0613m(this);
        this.f1055a = mVar;
        mVar.mo3519a(attributeSet, i);
        this.f1055a.mo3511a();
        C0598g0 a = C0598g0.m1610a(getContext(), attributeSet, f1054b, i, 0);
        setCheckMarkDrawable(a.mo3437b(0));
        a.mo3434a();
    }
}
