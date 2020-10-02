package androidx.percentlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.percentlayout.widget.C1022a;

@Deprecated
public class PercentRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    private final C1022a f2592a = new C1022a(this);

    public PercentRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f2592a.mo5145b();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f2592a.mo5143a(i, i2);
        super.onMeasure(i, i2);
        if (this.f2592a.mo5144a()) {
            super.onMeasure(i, i2);
        }
    }

    @Deprecated
    /* renamed from: androidx.percentlayout.widget.PercentRelativeLayout$a */
    public static class C1021a extends RelativeLayout.LayoutParams implements C1022a.C1024b {

        /* renamed from: a */
        private C1022a.C1023a f2593a;

        public C1021a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2593a = C1022a.m3576a(context, attributeSet);
        }

        /* renamed from: a */
        public C1022a.C1023a mo5136a() {
            if (this.f2593a == null) {
                this.f2593a = new C1022a.C1023a();
            }
            return this.f2593a;
        }

        /* access modifiers changed from: protected */
        public void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            C1022a.m3577a(this, typedArray, i, i2);
        }

        public C1021a(int i, int i2) {
            super(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public C1021a generateDefaultLayoutParams() {
        return new C1021a(-1, -1);
    }

    public C1021a generateLayoutParams(AttributeSet attributeSet) {
        return new C1021a(getContext(), attributeSet);
    }
}
