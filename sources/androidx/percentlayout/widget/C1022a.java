package androidx.percentlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p020f.C0825f;
import androidx.core.p020f.C0839t;
import androidx.percentlayout.R$styleable;

@Deprecated
/* renamed from: androidx.percentlayout.widget.a */
/* compiled from: PercentLayoutHelper */
public class C1022a {

    /* renamed from: a */
    private final ViewGroup f2594a;

    @Deprecated
    /* renamed from: androidx.percentlayout.widget.a$b */
    /* compiled from: PercentLayoutHelper */
    public interface C1024b {
        /* renamed from: a */
        C1023a mo5136a();
    }

    /* renamed from: androidx.percentlayout.widget.a$c */
    /* compiled from: PercentLayoutHelper */
    static class C1025c extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        boolean f2605a;

        /* renamed from: b */
        boolean f2606b;

        public C1025c(int i, int i2) {
            super(i, i2);
        }
    }

    public C1022a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            this.f2594a = viewGroup;
            return;
        }
        throw new IllegalArgumentException("host must be non-null");
    }

    /* renamed from: a */
    public static void m3577a(ViewGroup.LayoutParams layoutParams, TypedArray typedArray, int i, int i2) {
        layoutParams.width = typedArray.getLayoutDimension(i, 0);
        layoutParams.height = typedArray.getLayoutDimension(i2, 0);
    }

    /* renamed from: b */
    public void mo5145b() {
        C1023a a;
        int childCount = this.f2594a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewGroup.LayoutParams layoutParams = this.f2594a.getChildAt(i).getLayoutParams();
            if ((layoutParams instanceof C1024b) && (a = ((C1024b) layoutParams).mo5136a()) != null) {
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    a.mo5149a((ViewGroup.MarginLayoutParams) layoutParams);
                } else {
                    a.mo5147a(layoutParams);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo5143a(int i, int i2) {
        C1023a a;
        int size = (View.MeasureSpec.getSize(i) - this.f2594a.getPaddingLeft()) - this.f2594a.getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i2) - this.f2594a.getPaddingTop()) - this.f2594a.getPaddingBottom();
        int childCount = this.f2594a.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f2594a.getChildAt(i3);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof C1024b) && (a = ((C1024b) layoutParams).mo5136a()) != null) {
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    a.mo5146a(childAt, (ViewGroup.MarginLayoutParams) layoutParams, size, size2);
                } else {
                    a.mo5148a(layoutParams, size, size2);
                }
            }
        }
    }

    /* renamed from: b */
    private static boolean m3579b(View view, C1023a aVar) {
        return (view.getMeasuredWidthAndState() & -16777216) == 16777216 && aVar.f2595a >= 0.0f && aVar.f2604j.width == -2;
    }

    @Deprecated
    /* renamed from: androidx.percentlayout.widget.a$a */
    /* compiled from: PercentLayoutHelper */
    public static class C1023a {

        /* renamed from: a */
        public float f2595a = -1.0f;

        /* renamed from: b */
        public float f2596b = -1.0f;

        /* renamed from: c */
        public float f2597c = -1.0f;

        /* renamed from: d */
        public float f2598d = -1.0f;

        /* renamed from: e */
        public float f2599e = -1.0f;

        /* renamed from: f */
        public float f2600f = -1.0f;

        /* renamed from: g */
        public float f2601g = -1.0f;

        /* renamed from: h */
        public float f2602h = -1.0f;

        /* renamed from: i */
        public float f2603i;

        /* renamed from: j */
        final C1025c f2604j = new C1025c(0, 0);

        /* renamed from: a */
        public void mo5148a(ViewGroup.LayoutParams layoutParams, int i, int i2) {
            C1025c cVar = this.f2604j;
            int i3 = layoutParams.width;
            cVar.width = i3;
            cVar.height = layoutParams.height;
            boolean z = false;
            boolean z2 = (cVar.f2606b || i3 == 0) && this.f2595a < 0.0f;
            C1025c cVar2 = this.f2604j;
            if ((cVar2.f2605a || cVar2.height == 0) && this.f2596b < 0.0f) {
                z = true;
            }
            float f = this.f2595a;
            if (f >= 0.0f) {
                layoutParams.width = Math.round(((float) i) * f);
            }
            float f2 = this.f2596b;
            if (f2 >= 0.0f) {
                layoutParams.height = Math.round(((float) i2) * f2);
            }
            float f3 = this.f2603i;
            if (f3 >= 0.0f) {
                if (z2) {
                    layoutParams.width = Math.round(((float) layoutParams.height) * f3);
                    this.f2604j.f2606b = true;
                }
                if (z) {
                    layoutParams.height = Math.round(((float) layoutParams.width) / this.f2603i);
                    this.f2604j.f2605a = true;
                }
            }
        }

        public String toString() {
            return String.format("PercentLayoutInformation width: %f height %f, margins (%f, %f,  %f, %f, %f, %f)", new Object[]{Float.valueOf(this.f2595a), Float.valueOf(this.f2596b), Float.valueOf(this.f2597c), Float.valueOf(this.f2598d), Float.valueOf(this.f2599e), Float.valueOf(this.f2600f), Float.valueOf(this.f2601g), Float.valueOf(this.f2602h)});
        }

        /* renamed from: a */
        public void mo5146a(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
            mo5148a(marginLayoutParams, i, i2);
            C1025c cVar = this.f2604j;
            cVar.leftMargin = marginLayoutParams.leftMargin;
            cVar.topMargin = marginLayoutParams.topMargin;
            cVar.rightMargin = marginLayoutParams.rightMargin;
            cVar.bottomMargin = marginLayoutParams.bottomMargin;
            C0825f.m2638c(cVar, C0825f.m2636b(marginLayoutParams));
            C0825f.m2637b(this.f2604j, C0825f.m2634a(marginLayoutParams));
            float f = this.f2597c;
            if (f >= 0.0f) {
                marginLayoutParams.leftMargin = Math.round(((float) i) * f);
            }
            float f2 = this.f2598d;
            if (f2 >= 0.0f) {
                marginLayoutParams.topMargin = Math.round(((float) i2) * f2);
            }
            float f3 = this.f2599e;
            if (f3 >= 0.0f) {
                marginLayoutParams.rightMargin = Math.round(((float) i) * f3);
            }
            float f4 = this.f2600f;
            if (f4 >= 0.0f) {
                marginLayoutParams.bottomMargin = Math.round(((float) i2) * f4);
            }
            boolean z = false;
            float f5 = this.f2601g;
            boolean z2 = true;
            if (f5 >= 0.0f) {
                C0825f.m2638c(marginLayoutParams, Math.round(((float) i) * f5));
                z = true;
            }
            float f6 = this.f2602h;
            if (f6 >= 0.0f) {
                C0825f.m2637b(marginLayoutParams, Math.round(((float) i) * f6));
            } else {
                z2 = z;
            }
            if (z2 && view != null) {
                C0825f.m2635a(marginLayoutParams, C0839t.m2725n(view));
            }
        }

        /* renamed from: a */
        public void mo5149a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            mo5147a((ViewGroup.LayoutParams) marginLayoutParams);
            C1025c cVar = this.f2604j;
            marginLayoutParams.leftMargin = cVar.leftMargin;
            marginLayoutParams.topMargin = cVar.topMargin;
            marginLayoutParams.rightMargin = cVar.rightMargin;
            marginLayoutParams.bottomMargin = cVar.bottomMargin;
            C0825f.m2638c(marginLayoutParams, C0825f.m2636b(cVar));
            C0825f.m2637b(marginLayoutParams, C0825f.m2634a(this.f2604j));
        }

        /* renamed from: a */
        public void mo5147a(ViewGroup.LayoutParams layoutParams) {
            C1025c cVar = this.f2604j;
            if (!cVar.f2606b) {
                layoutParams.width = cVar.width;
            }
            C1025c cVar2 = this.f2604j;
            if (!cVar2.f2605a) {
                layoutParams.height = cVar2.height;
            }
            C1025c cVar3 = this.f2604j;
            cVar3.f2606b = false;
            cVar3.f2605a = false;
        }
    }

    /* renamed from: a */
    public static C1023a m3576a(Context context, AttributeSet attributeSet) {
        C1023a aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PercentLayout_Layout);
        float fraction = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_widthPercent, 1, 1, -1.0f);
        if (fraction != -1.0f) {
            aVar = new C1023a();
            aVar.f2595a = fraction;
        } else {
            aVar = null;
        }
        float fraction2 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_heightPercent, 1, 1, -1.0f);
        if (fraction2 != -1.0f) {
            if (aVar == null) {
                aVar = new C1023a();
            }
            aVar.f2596b = fraction2;
        }
        float fraction3 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_marginPercent, 1, 1, -1.0f);
        if (fraction3 != -1.0f) {
            if (aVar == null) {
                aVar = new C1023a();
            }
            aVar.f2597c = fraction3;
            aVar.f2598d = fraction3;
            aVar.f2599e = fraction3;
            aVar.f2600f = fraction3;
        }
        float fraction4 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_marginLeftPercent, 1, 1, -1.0f);
        if (fraction4 != -1.0f) {
            if (aVar == null) {
                aVar = new C1023a();
            }
            aVar.f2597c = fraction4;
        }
        float fraction5 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_marginTopPercent, 1, 1, -1.0f);
        if (fraction5 != -1.0f) {
            if (aVar == null) {
                aVar = new C1023a();
            }
            aVar.f2598d = fraction5;
        }
        float fraction6 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_marginRightPercent, 1, 1, -1.0f);
        if (fraction6 != -1.0f) {
            if (aVar == null) {
                aVar = new C1023a();
            }
            aVar.f2599e = fraction6;
        }
        float fraction7 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_marginBottomPercent, 1, 1, -1.0f);
        if (fraction7 != -1.0f) {
            if (aVar == null) {
                aVar = new C1023a();
            }
            aVar.f2600f = fraction7;
        }
        float fraction8 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_marginStartPercent, 1, 1, -1.0f);
        if (fraction8 != -1.0f) {
            if (aVar == null) {
                aVar = new C1023a();
            }
            aVar.f2601g = fraction8;
        }
        float fraction9 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_marginEndPercent, 1, 1, -1.0f);
        if (fraction9 != -1.0f) {
            if (aVar == null) {
                aVar = new C1023a();
            }
            aVar.f2602h = fraction9;
        }
        float fraction10 = obtainStyledAttributes.getFraction(R$styleable.PercentLayout_Layout_layout_aspectRatio, 1, 1, -1.0f);
        if (fraction10 != -1.0f) {
            if (aVar == null) {
                aVar = new C1023a();
            }
            aVar.f2603i = fraction10;
        }
        obtainStyledAttributes.recycle();
        return aVar;
    }

    /* renamed from: a */
    public boolean mo5144a() {
        C1023a a;
        int childCount = this.f2594a.getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f2594a.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof C1024b) && (a = ((C1024b) layoutParams).mo5136a()) != null) {
                if (m3579b(childAt, a)) {
                    layoutParams.width = -2;
                    z = true;
                }
                if (m3578a(childAt, a)) {
                    layoutParams.height = -2;
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m3578a(View view, C1023a aVar) {
        return (view.getMeasuredHeightAndState() & -16777216) == 16777216 && aVar.f2596b >= 0.0f && aVar.f2604j.height == -2;
    }
}
