package androidx.percentlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.percentlayout.widget.C1022a;

@Deprecated
public class PercentFrameLayout extends FrameLayout {

    /* renamed from: a */
    private final C1022a f2590a = new C1022a(this);

    public PercentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f2590a.mo5145b();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f2590a.mo5143a(i, i2);
        super.onMeasure(i, i2);
        if (this.f2590a.mo5144a()) {
            super.onMeasure(i, i2);
        }
    }

    @Deprecated
    /* renamed from: androidx.percentlayout.widget.PercentFrameLayout$a */
    public static class C1020a extends FrameLayout.LayoutParams implements C1022a.C1024b {

        /* renamed from: a */
        private C1022a.C1023a f2591a;

        public C1020a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2591a = C1022a.m3576a(context, attributeSet);
        }

        /* renamed from: a */
        public C1022a.C1023a mo5136a() {
            if (this.f2591a == null) {
                this.f2591a = new C1022a.C1023a();
            }
            return this.f2591a;
        }

        /* access modifiers changed from: protected */
        public void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            C1022a.m3577a(this, typedArray, i, i2);
        }

        public C1020a(int i, int i2) {
            super(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public C1020a generateDefaultLayoutParams() {
        return new C1020a(-1, -1);
    }

    public C1020a generateLayoutParams(AttributeSet attributeSet) {
        return new C1020a(getContext(), attributeSet);
    }
}
