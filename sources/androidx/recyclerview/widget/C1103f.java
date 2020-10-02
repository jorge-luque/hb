package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.f */
/* compiled from: LayoutState */
class C1103f {

    /* renamed from: a */
    boolean f3003a = true;

    /* renamed from: b */
    int f3004b;

    /* renamed from: c */
    int f3005c;

    /* renamed from: d */
    int f3006d;

    /* renamed from: e */
    int f3007e;

    /* renamed from: f */
    int f3008f = 0;

    /* renamed from: g */
    int f3009g = 0;

    /* renamed from: h */
    boolean f3010h;

    /* renamed from: i */
    boolean f3011i;

    C1103f() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5874a(RecyclerView.C1070z zVar) {
        int i = this.f3005c;
        return i >= 0 && i < zVar.mo5697a();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f3004b + ", mCurrentPosition=" + this.f3005c + ", mItemDirection=" + this.f3006d + ", mLayoutDirection=" + this.f3007e + ", mStartLine=" + this.f3008f + ", mEndLine=" + this.f3009g + '}';
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo5873a(RecyclerView.C1066v vVar) {
        View d = vVar.mo5678d(this.f3005c);
        this.f3005c += this.f3006d;
        return d;
    }
}
