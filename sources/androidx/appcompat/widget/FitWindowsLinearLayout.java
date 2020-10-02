package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.C0625s;

public class FitWindowsLinearLayout extends LinearLayout implements C0625s {

    /* renamed from: a */
    private C0625s.C0626a f1119a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void mo3126a(C0625s.C0626a aVar) {
        this.f1119a = aVar;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        C0625s.C0626a aVar = this.f1119a;
        if (aVar != null) {
            aVar.mo2082a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
