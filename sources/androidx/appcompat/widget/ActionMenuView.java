package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.C0482g;
import androidx.appcompat.view.menu.C0486i;
import androidx.appcompat.view.menu.C0497m;
import androidx.appcompat.view.menu.C0499n;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ActionMenuView extends LinearLayoutCompat implements C0482g.C0484b, C0499n {

    /* renamed from: A */
    C0518e f996A;

    /* renamed from: p */
    private C0482g f997p;

    /* renamed from: q */
    private Context f998q;

    /* renamed from: r */
    private int f999r;

    /* renamed from: s */
    private boolean f1000s;

    /* renamed from: t */
    private C0576c f1001t;

    /* renamed from: u */
    private C0497m.C0498a f1002u;

    /* renamed from: v */
    C0482g.C0483a f1003v;

    /* renamed from: w */
    private boolean f1004w;

    /* renamed from: x */
    private int f1005x;

    /* renamed from: y */
    private int f1006y;

    /* renamed from: z */
    private int f1007z;

    /* renamed from: androidx.appcompat.widget.ActionMenuView$a */
    public interface C0514a {
        /* renamed from: b */
        boolean mo2369b();

        /* renamed from: e */
        boolean mo2371e();
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$b */
    private static class C0515b implements C0497m.C0498a {
        C0515b() {
        }

        /* renamed from: a */
        public void mo2088a(C0482g gVar, boolean z) {
        }

        /* renamed from: a */
        public boolean mo2089a(C0482g gVar) {
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$c */
    public static class C0516c extends LinearLayoutCompat.C0537a {
        @ViewDebug.ExportedProperty

        /* renamed from: c */
        public boolean f1008c;
        @ViewDebug.ExportedProperty

        /* renamed from: d */
        public int f1009d;
        @ViewDebug.ExportedProperty

        /* renamed from: e */
        public int f1010e;
        @ViewDebug.ExportedProperty

        /* renamed from: f */
        public boolean f1011f;
        @ViewDebug.ExportedProperty

        /* renamed from: g */
        public boolean f1012g;

        /* renamed from: h */
        boolean f1013h;

        public C0516c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0516c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0516c(C0516c cVar) {
            super(cVar);
            this.f1008c = cVar.f1008c;
        }

        public C0516c(int i, int i2) {
            super(i, i2);
            this.f1008c = false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$e */
    public interface C0518e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: c */
    private void m1126c(int i, int i2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        int i6;
        boolean z4;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
        int i7 = size - paddingLeft;
        int i8 = this.f1006y;
        int i9 = i7 / i8;
        int i10 = i7 % i8;
        if (i9 == 0) {
            setMeasuredDimension(i7, 0);
            return;
        }
        int i11 = i8 + (i10 / i9);
        int childCount = getChildCount();
        int i12 = 0;
        int i13 = 0;
        boolean z5 = false;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        long j = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            int i17 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z6 = childAt instanceof ActionMenuItemView;
                int i18 = i14 + 1;
                if (z6) {
                    int i19 = this.f1007z;
                    i6 = i18;
                    z4 = false;
                    childAt.setPadding(i19, 0, i19, 0);
                } else {
                    i6 = i18;
                    z4 = false;
                }
                C0516c cVar = (C0516c) childAt.getLayoutParams();
                cVar.f1013h = z4;
                cVar.f1010e = z4 ? 1 : 0;
                cVar.f1009d = z4;
                cVar.f1011f = z4;
                cVar.leftMargin = z4;
                cVar.rightMargin = z4;
                cVar.f1012g = z6 && ((ActionMenuItemView) childAt).mo2372g();
                int a = m1125a(childAt, i11, cVar.f1008c ? 1 : i9, childMeasureSpec, paddingTop);
                i15 = Math.max(i15, a);
                if (cVar.f1011f) {
                    i16++;
                }
                if (cVar.f1008c) {
                    z5 = true;
                }
                i9 -= a;
                i12 = Math.max(i12, childAt.getMeasuredHeight());
                if (a == 1) {
                    j |= (long) (1 << i13);
                    i12 = i12;
                } else {
                    int i20 = i12;
                }
                i14 = i6;
            }
            i13++;
            size2 = i17;
        }
        int i21 = size2;
        boolean z7 = z5 && i14 == 2;
        boolean z8 = false;
        while (true) {
            if (i16 <= 0 || i9 <= 0) {
                i5 = mode;
                i3 = i7;
                z = z8;
                i4 = i12;
            } else {
                int i22 = 0;
                int i23 = 0;
                int i24 = Integer.MAX_VALUE;
                long j2 = 0;
                while (i23 < childCount) {
                    boolean z9 = z8;
                    C0516c cVar2 = (C0516c) getChildAt(i23).getLayoutParams();
                    int i25 = i12;
                    if (cVar2.f1011f) {
                        int i26 = cVar2.f1009d;
                        if (i26 < i24) {
                            j2 = 1 << i23;
                            i24 = i26;
                            i22 = 1;
                        } else if (i26 == i24) {
                            i22++;
                            j2 |= 1 << i23;
                        }
                    }
                    i23++;
                    i12 = i25;
                    z8 = z9;
                }
                z = z8;
                i4 = i12;
                j |= j2;
                if (i22 > i9) {
                    i5 = mode;
                    i3 = i7;
                    break;
                }
                int i27 = i24 + 1;
                int i28 = 0;
                while (i28 < childCount) {
                    View childAt2 = getChildAt(i28);
                    C0516c cVar3 = (C0516c) childAt2.getLayoutParams();
                    int i29 = i7;
                    int i30 = mode;
                    long j3 = (long) (1 << i28);
                    if ((j2 & j3) == 0) {
                        if (cVar3.f1009d == i27) {
                            j |= j3;
                        }
                        z3 = z7;
                    } else {
                        if (!z7 || !cVar3.f1012g || i9 != 1) {
                            z3 = z7;
                        } else {
                            int i31 = this.f1007z;
                            z3 = z7;
                            childAt2.setPadding(i31 + i11, 0, i31, 0);
                        }
                        cVar3.f1009d++;
                        cVar3.f1013h = true;
                        i9--;
                    }
                    i28++;
                    mode = i30;
                    i7 = i29;
                    z7 = z3;
                }
                i12 = i4;
                z8 = true;
            }
        }
        boolean z10 = !z5 && i14 == 1;
        if (i9 <= 0 || j == 0 || (i9 >= i14 - 1 && !z10 && i15 <= 1)) {
            z2 = z;
        } else {
            float bitCount = (float) Long.bitCount(j);
            if (!z10) {
                if ((j & 1) != 0 && !((C0516c) getChildAt(0).getLayoutParams()).f1012g) {
                    bitCount -= 0.5f;
                }
                int i32 = childCount - 1;
                if ((j & ((long) (1 << i32))) != 0 && !((C0516c) getChildAt(i32).getLayoutParams()).f1012g) {
                    bitCount -= 0.5f;
                }
            }
            int i33 = bitCount > 0.0f ? (int) (((float) (i9 * i11)) / bitCount) : 0;
            z2 = z;
            for (int i34 = 0; i34 < childCount; i34++) {
                if ((j & ((long) (1 << i34))) != 0) {
                    View childAt3 = getChildAt(i34);
                    C0516c cVar4 = (C0516c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f1010e = i33;
                        cVar4.f1013h = true;
                        if (i34 == 0 && !cVar4.f1012g) {
                            cVar4.leftMargin = (-i33) / 2;
                        }
                    } else if (cVar4.f1008c) {
                        cVar4.f1010e = i33;
                        cVar4.f1013h = true;
                        cVar4.rightMargin = (-i33) / 2;
                    } else {
                        if (i34 != 0) {
                            cVar4.leftMargin = i33 / 2;
                        }
                        if (i34 != childCount - 1) {
                            cVar4.rightMargin = i33 / 2;
                        }
                    }
                    z2 = true;
                }
            }
        }
        if (z2) {
            for (int i35 = 0; i35 < childCount; i35++) {
                View childAt4 = getChildAt(i35);
                C0516c cVar5 = (C0516c) childAt4.getLayoutParams();
                if (cVar5.f1013h) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f1009d * i11) + cVar5.f1010e, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i3, i5 != 1073741824 ? i4 : i21);
    }

    /* renamed from: a */
    public void mo2866a(C0576c cVar) {
        this.f1001t = cVar;
        cVar.mo3367a(this);
    }

    /* renamed from: b */
    public void mo2867b(boolean z) {
        this.f1001t.mo3369c(z);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0516c;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo2871f(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C0514a)) {
            z = false | ((C0514a) childAt).mo2369b();
        }
        return (i <= 0 || !(childAt2 instanceof C0514a)) ? z : z | ((C0514a) childAt2).mo2371e();
    }

    /* renamed from: g */
    public void mo2873g(int i) {
        if (this.f999r != i) {
            this.f999r = i;
            if (i == 0) {
                this.f998q = getContext();
            } else {
                this.f998q = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    /* renamed from: h */
    public C0516c mo2877h() {
        C0516c generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.f1008c = true;
        return generateDefaultLayoutParams;
    }

    /* renamed from: i */
    public Menu mo2878i() {
        if (this.f997p == null) {
            Context context = getContext();
            C0482g gVar = new C0482g(context);
            this.f997p = gVar;
            gVar.mo2522a((C0482g.C0483a) new C0517d());
            C0576c cVar = new C0576c(context);
            this.f1001t = cVar;
            cVar.mo3371d(true);
            C0576c cVar2 = this.f1001t;
            C0497m.C0498a aVar = this.f1002u;
            if (aVar == null) {
                aVar = new C0515b();
            }
            cVar2.mo2459a(aVar);
            this.f997p.mo2524a((C0497m) this.f1001t, this.f998q);
            this.f1001t.mo3367a(this);
        }
        return this.f997p;
    }

    /* renamed from: j */
    public boolean mo2879j() {
        C0576c cVar = this.f1001t;
        return cVar != null && cVar.mo3372d();
    }

    /* renamed from: k */
    public boolean mo2880k() {
        C0576c cVar = this.f1001t;
        return cVar != null && cVar.mo3374f();
    }

    /* renamed from: l */
    public boolean mo2881l() {
        C0576c cVar = this.f1001t;
        return cVar != null && cVar.mo3375g();
    }

    /* renamed from: m */
    public boolean mo2882m() {
        return this.f1000s;
    }

    /* renamed from: n */
    public C0482g mo2883n() {
        return this.f997p;
    }

    /* renamed from: o */
    public boolean mo2884o() {
        C0576c cVar = this.f1001t;
        return cVar != null && cVar.mo3376h();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0576c cVar = this.f1001t;
        if (cVar != null) {
            cVar.mo2460a(false);
            if (this.f1001t.mo3375g()) {
                this.f1001t.mo3372d();
                this.f1001t.mo3376h();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo2872g();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (!this.f1004w) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i4 - i2) / 2;
        int d = mo3147d();
        int i8 = i3 - i;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean a = C0616m0.m1739a(this);
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                C0516c cVar = (C0516c) childAt.getLayoutParams();
                if (cVar.f1008c) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (mo2871f(i11)) {
                        measuredWidth += d;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a) {
                        i5 = getPaddingLeft() + cVar.leftMargin;
                        i6 = i5 + measuredWidth;
                    } else {
                        i6 = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        i5 = i6 - measuredWidth;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(i5, i12, i6, measuredHeight + i12);
                    paddingRight -= measuredWidth;
                    i9 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                    boolean f = mo2871f(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth2 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        int max = Math.max(0, i15 > 0 ? paddingRight / i15 : 0);
        if (a) {
            int width = getWidth() - getPaddingRight();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt3 = getChildAt(i16);
                C0516c cVar2 = (C0516c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f1008c) {
                    int i17 = width - cVar2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i18 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i17 - measuredWidth3, i18, i17, measuredHeight3 + i18);
                    width = i17 - ((measuredWidth3 + cVar2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt4 = getChildAt(i19);
            C0516c cVar3 = (C0516c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f1008c) {
                int i20 = paddingLeft + cVar3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft = i20 + measuredWidth4 + cVar3.rightMargin + max;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        C0482g gVar;
        boolean z = this.f1004w;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.f1004w = z2;
        if (z != z2) {
            this.f1005x = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (!(!this.f1004w || (gVar = this.f997p) == null || size == this.f1005x)) {
            this.f1005x = size;
            gVar.mo2544b(true);
        }
        int childCount = getChildCount();
        if (!this.f1004w || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                C0516c cVar = (C0516c) getChildAt(i3).getLayoutParams();
                cVar.rightMargin = 0;
                cVar.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m1126c(i, i2);
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$d */
    private class C0517d implements C0482g.C0483a {
        C0517d() {
        }

        /* renamed from: a */
        public boolean mo2055a(C0482g gVar, MenuItem menuItem) {
            C0518e eVar = ActionMenuView.this.f996A;
            return eVar != null && eVar.onMenuItemClick(menuItem);
        }

        /* renamed from: a */
        public void mo2052a(C0482g gVar) {
            C0482g.C0483a aVar = ActionMenuView.this.f1003v;
            if (aVar != null) {
                aVar.mo2052a(gVar);
            }
        }
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo3138a(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1006y = (int) (56.0f * f);
        this.f1007z = (int) (f * 4.0f);
        this.f998q = context;
        this.f999r = 0;
    }

    /* renamed from: a */
    public void mo2865a(C0518e eVar) {
        this.f996A = eVar;
    }

    /* access modifiers changed from: protected */
    public C0516c generateDefaultLayoutParams() {
        C0516c cVar = new C0516c(-2, -2);
        cVar.f1136b = 16;
        return cVar;
    }

    /* renamed from: a */
    static int m1125a(View view, int i, int i2, int i3, int i4) {
        C0516c cVar = (C0516c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = true;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.mo2372g();
        int i5 = 2;
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z2 || i6 >= 2) {
                i5 = i6;
            }
        }
        if (cVar.f1008c || !z2) {
            z = false;
        }
        cVar.f1011f = z;
        cVar.f1009d = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    /* renamed from: g */
    public void mo2872g() {
        C0576c cVar = this.f1001t;
        if (cVar != null) {
            cVar.mo3370c();
        }
    }

    public C0516c generateLayoutParams(AttributeSet attributeSet) {
        return new C0516c(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0516c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        C0516c cVar = layoutParams instanceof C0516c ? new C0516c((C0516c) layoutParams) : new C0516c(layoutParams);
        if (cVar.f1136b <= 0) {
            cVar.f1136b = 16;
        }
        return cVar;
    }

    /* renamed from: a */
    public boolean mo2383a(C0486i iVar) {
        return this.f997p.mo2527a((MenuItem) iVar, 0);
    }

    /* renamed from: a */
    public void mo2382a(C0482g gVar) {
        this.f997p = gVar;
    }

    /* renamed from: a */
    public void mo2864a(C0497m.C0498a aVar, C0482g.C0483a aVar2) {
        this.f1002u = aVar;
        this.f1003v = aVar2;
    }

    /* renamed from: c */
    public void mo2868c(boolean z) {
        this.f1000s = z;
    }
}
