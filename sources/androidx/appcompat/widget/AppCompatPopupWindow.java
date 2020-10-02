package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
import androidx.core.widget.C0878h;

class AppCompatPopupWindow extends PopupWindow {

    /* renamed from: b */
    private static final boolean f1066b = (Build.VERSION.SDK_INT < 21);

    /* renamed from: a */
    private boolean f1067a;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1212a(context, attributeSet, i, 0);
    }

    /* renamed from: a */
    private void m1212a(Context context, AttributeSet attributeSet, int i, int i2) {
        C0598g0 a = C0598g0.m1610a(context, attributeSet, R$styleable.PopupWindow, i, i2);
        if (a.mo3447g(R$styleable.PopupWindow_overlapAnchor)) {
            m1213a(a.mo3435a(R$styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.mo3437b(R$styleable.PopupWindow_android_popupBackground));
        a.mo3434a();
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f1066b && this.f1067a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        if (f1066b && this.f1067a) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m1212a(context, attributeSet, i, i2);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f1066b && this.f1067a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    /* renamed from: a */
    private void m1213a(boolean z) {
        if (f1066b) {
            this.f1067a = z;
        } else {
            C0878h.m2934a((PopupWindow) this, z);
        }
    }
}
