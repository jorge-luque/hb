package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.C0625s;

public class FitWindowsFrameLayout extends FrameLayout implements C0625s {

    /* renamed from: a */
    private C0625s.C0626a f1118a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void mo3126a(C0625s.C0626a aVar) {
        this.f1118a = aVar;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        C0625s.C0626a aVar = this.f1118a;
        if (aVar != null) {
            aVar.mo2082a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
