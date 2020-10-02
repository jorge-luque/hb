package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.core.p019e.C0790c;
import androidx.core.p019e.C0792e;
import androidx.core.p019e.C0794g;
import androidx.core.p020f.C0803b0;
import androidx.core.p020f.C0804c;
import androidx.core.p020f.C0832m;
import androidx.core.p020f.C0835p;
import androidx.core.p020f.C0836q;
import androidx.core.p020f.C0839t;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements C0832m {

    /* renamed from: s */
    static final String f1677s;

    /* renamed from: t */
    static final Class<?>[] f1678t = {Context.class, AttributeSet.class};

    /* renamed from: u */
    static final ThreadLocal<Map<String, Constructor<C0672c>>> f1679u = new ThreadLocal<>();

    /* renamed from: v */
    static final Comparator<View> f1680v;

    /* renamed from: w */
    private static final C0792e<Rect> f1681w = new C0794g(12);

    /* renamed from: a */
    private final List<View> f1682a = new ArrayList();

    /* renamed from: b */
    private final C0678a<View> f1683b = new C0678a<>();

    /* renamed from: c */
    private final List<View> f1684c = new ArrayList();

    /* renamed from: d */
    private final int[] f1685d;

    /* renamed from: e */
    private Paint f1686e;

    /* renamed from: f */
    private boolean f1687f;

    /* renamed from: g */
    private boolean f1688g;

    /* renamed from: h */
    private int[] f1689h;

    /* renamed from: i */
    private View f1690i;

    /* renamed from: j */
    private View f1691j;

    /* renamed from: k */
    private C0676g f1692k;

    /* renamed from: l */
    private boolean f1693l;

    /* renamed from: m */
    private C0803b0 f1694m;

    /* renamed from: n */
    private boolean f1695n;

    /* renamed from: o */
    private Drawable f1696o;

    /* renamed from: p */
    ViewGroup.OnHierarchyChangeListener f1697p;

    /* renamed from: q */
    private C0836q f1698q;

    /* renamed from: r */
    private final C0835p f1699r;

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$a */
    class C0670a implements C0836q {
        C0670a() {
        }

        /* renamed from: a */
        public C0803b0 mo2081a(View view, C0803b0 b0Var) {
            return CoordinatorLayout.this.mo3724a(b0Var);
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$b */
    public interface C0671b {
        /* renamed from: a */
        C0672c mo3764a();
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$c */
    public static abstract class C0672c<V extends View> {
        /* renamed from: a */
        public C0803b0 mo3765a(CoordinatorLayout coordinatorLayout, V v, C0803b0 b0Var) {
            return b0Var;
        }

        /* renamed from: a */
        public void mo3766a() {
        }

        /* renamed from: a */
        public void mo3767a(C0675f fVar) {
        }

        /* renamed from: a */
        public void mo3768a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        /* renamed from: a */
        public void mo3770a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        /* renamed from: a */
        public void mo3772a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        @Deprecated
        /* renamed from: a */
        public void mo3774a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        /* renamed from: a */
        public boolean mo3776a(CoordinatorLayout coordinatorLayout, V v) {
            return mo3790c(coordinatorLayout, v) > 0.0f;
        }

        /* renamed from: a */
        public boolean mo3777a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        /* renamed from: a */
        public boolean mo3778a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        /* renamed from: a */
        public boolean mo3779a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        /* renamed from: a */
        public boolean mo3780a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        /* renamed from: a */
        public boolean mo3781a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        /* renamed from: a */
        public boolean mo3782a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        /* renamed from: a */
        public boolean mo3783a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        /* renamed from: a */
        public boolean mo3784a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        /* renamed from: b */
        public int mo3785b(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        /* renamed from: b */
        public boolean mo3786b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        /* renamed from: b */
        public boolean mo3787b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        @Deprecated
        /* renamed from: b */
        public boolean mo3788b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        /* renamed from: b */
        public boolean mo3789b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return mo3788b(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        /* renamed from: c */
        public float mo3790c(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        /* renamed from: c */
        public void mo3791c(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        /* renamed from: d */
        public Parcelable mo3792d(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        /* renamed from: d */
        public void mo3793d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        /* renamed from: a */
        public void mo3775a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                mo3774a(coordinatorLayout, v, view, view2, i);
            }
        }

        /* renamed from: a */
        public void mo3769a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                mo3793d(coordinatorLayout, v, view);
            }
        }

        /* renamed from: a */
        public void mo3771a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                mo3770a(coordinatorLayout, v, view, i, i2, i3, i4);
            }
        }

        /* renamed from: a */
        public void mo3773a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                mo3772a(coordinatorLayout, v, view, i, i2, iArr);
            }
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$d */
    public @interface C0673d {
        Class<? extends C0672c> value();
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$e */
    private class C0674e implements ViewGroup.OnHierarchyChangeListener {
        C0674e() {
        }

        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f1697p;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.mo3726a(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f1697p;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$g */
    class C0676g implements ViewTreeObserver.OnPreDrawListener {
        C0676g() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.mo3726a(0);
            return true;
        }
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$h */
    static class C0677h implements Comparator<View> {
        C0677h() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            float t = C0839t.m2731t(view);
            float t2 = C0839t.m2731t(view2);
            if (t > t2) {
                return -1;
            }
            return t < t2 ? 1 : 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.coordinatorlayout.widget.CoordinatorLayout> r0 = androidx.coordinatorlayout.widget.CoordinatorLayout.class
            java.lang.Package r0 = r0.getPackage()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            java.lang.String r0 = r0.getName()
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            f1677s = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r0 < r2) goto L_0x001f
            androidx.coordinatorlayout.widget.CoordinatorLayout$h r0 = new androidx.coordinatorlayout.widget.CoordinatorLayout$h
            r0.<init>()
            f1680v = r0
            goto L_0x0021
        L_0x001f:
            f1680v = r1
        L_0x0021:
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r0[r1] = r2
            f1678t = r0
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            f1679u = r0
            androidx.core.e.g r0 = new androidx.core.e.g
            r1 = 12
            r0.<init>(r1)
            f1681w = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.<clinit>():void");
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArray;
        new ArrayList();
        this.f1685d = new int[2];
        this.f1699r = new C0835p(this);
        if (i == 0) {
            typedArray = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, 0, R$style.Widget_Support_CoordinatorLayout);
        } else {
            typedArray = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, i, 0);
        }
        int resourceId = typedArray.getResourceId(R$styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f1689h = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.f1689h.length;
            for (int i2 = 0; i2 < length; i2++) {
                int[] iArr = this.f1689h;
                iArr[i2] = (int) (((float) iArr[i2]) * f);
            }
        }
        this.f1696o = typedArray.getDrawable(R$styleable.CoordinatorLayout_statusBarBackground);
        typedArray.recycle();
        m2013f();
        super.setOnHierarchyChangeListener(new C0674e());
    }

    /* renamed from: a */
    private static int m1992a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    /* renamed from: a */
    private static void m1994a(Rect rect) {
        rect.setEmpty();
        f1681w.mo4076a(rect);
    }

    /* renamed from: b */
    private int m2003b(int i) {
        int[] iArr = this.f1689h;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < iArr.length) {
            return iArr[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    /* renamed from: c */
    private static int m2006c(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    /* renamed from: d */
    private static int m2007d(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    /* renamed from: d */
    private static Rect m2008d() {
        Rect a = f1681w.mo4075a();
        return a == null ? new Rect() : a;
    }

    /* renamed from: e */
    private static int m2010e(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    /* renamed from: e */
    private void m2011e() {
        this.f1682a.clear();
        this.f1683b.mo3816a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0675f a = mo3723a(childAt);
            a.mo3797a(this, childAt);
            this.f1683b.mo3817a(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (a.mo3804a(this, childAt, childAt2)) {
                        if (!this.f1683b.mo3820b(childAt2)) {
                            this.f1683b.mo3817a(childAt2);
                        }
                        this.f1683b.mo3818a(childAt2, childAt);
                    }
                }
            }
        }
        this.f1682a.addAll(this.f1683b.mo3819b());
        Collections.reverse(this.f1682a);
    }

    /* renamed from: f */
    private void m2014f(View view, int i) {
        C0675f fVar = (C0675f) view.getLayoutParams();
        int i2 = fVar.f1712j;
        if (i2 != i) {
            C0839t.m2714e(view, i - i2);
            fVar.f1712j = i;
        }
    }

    /* renamed from: c */
    public void mo3735c(View view, int i) {
        C0675f fVar = (C0675f) view.getLayoutParams();
        if (!fVar.mo3802a()) {
            View view2 = fVar.f1713k;
            if (view2 != null) {
                m1998a(view, view2, i);
                return;
            }
            int i2 = fVar.f1707e;
            if (i2 >= 0) {
                m1995a(view, i2, i);
            } else {
                m2009d(view, i);
            }
        } else {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0675f) && super.checkLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        C0675f fVar = (C0675f) view.getLayoutParams();
        C0672c cVar = fVar.f1703a;
        if (cVar != null) {
            float c = cVar.mo3790c(this, view);
            if (c > 0.0f) {
                if (this.f1686e == null) {
                    this.f1686e = new Paint();
                }
                this.f1686e.setColor(fVar.f1703a.mo3785b(this, view));
                this.f1686e.setAlpha(m1992a(Math.round(c * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f1686e);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1696o;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public int getNestedScrollAxes() {
        return this.f1699r.mo4189a();
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m2001a(false);
        if (this.f1693l) {
            if (this.f1692k == null) {
                this.f1692k = new C0676g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1692k);
        }
        if (this.f1694m == null && C0839t.m2722k(this)) {
            C0839t.m2683B(this);
        }
        this.f1688g = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2001a(false);
        if (this.f1693l && this.f1692k != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1692k);
        }
        View view = this.f1691j;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f1688g = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1695n && this.f1696o != null) {
            C0803b0 b0Var = this.f1694m;
            int d = b0Var != null ? b0Var.mo4103d() : 0;
            if (d > 0) {
                this.f1696o.setBounds(0, 0, getWidth(), d);
                this.f1696o.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m2001a(true);
        }
        boolean a = m2002a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            m2001a(true);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0672c c;
        int n = C0839t.m2725n(this);
        int size = this.f1682a.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.f1682a.get(i5);
            if (view.getVisibility() != 8 && ((c = ((C0675f) view.getLayoutParams()).mo3808c()) == null || !c.mo3777a(this, view, n))) {
                mo3735c(view, n);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011a, code lost:
        if (r0.mo3778a(r30, r20, r11, r21, r23, 0) == false) goto L_0x012a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r31, int r32) {
        /*
            r30 = this;
            r7 = r30
            r30.m2011e()
            r30.mo3731b()
            int r8 = r30.getPaddingLeft()
            int r0 = r30.getPaddingTop()
            int r9 = r30.getPaddingRight()
            int r1 = r30.getPaddingBottom()
            int r10 = androidx.core.p020f.C0839t.m2725n(r30)
            r2 = 1
            if (r10 != r2) goto L_0x0021
            r12 = 1
            goto L_0x0022
        L_0x0021:
            r12 = 0
        L_0x0022:
            int r13 = android.view.View.MeasureSpec.getMode(r31)
            int r14 = android.view.View.MeasureSpec.getSize(r31)
            int r15 = android.view.View.MeasureSpec.getMode(r32)
            int r16 = android.view.View.MeasureSpec.getSize(r32)
            int r17 = r8 + r9
            int r18 = r0 + r1
            int r0 = r30.getSuggestedMinimumWidth()
            int r1 = r30.getSuggestedMinimumHeight()
            androidx.core.f.b0 r3 = r7.f1694m
            if (r3 == 0) goto L_0x004b
            boolean r3 = androidx.core.p020f.C0839t.m2722k(r30)
            if (r3 == 0) goto L_0x004b
            r19 = 1
            goto L_0x004d
        L_0x004b:
            r19 = 0
        L_0x004d:
            java.util.List<android.view.View> r2 = r7.f1682a
            int r6 = r2.size()
            r5 = r0
            r4 = r1
            r2 = 0
            r3 = 0
        L_0x0057:
            if (r3 >= r6) goto L_0x016f
            java.util.List<android.view.View> r0 = r7.f1682a
            java.lang.Object r0 = r0.get(r3)
            r20 = r0
            android.view.View r20 = (android.view.View) r20
            int r0 = r20.getVisibility()
            r1 = 8
            if (r0 != r1) goto L_0x0073
            r22 = r3
            r29 = r6
            r28 = r8
            goto L_0x0167
        L_0x0073:
            android.view.ViewGroup$LayoutParams r0 = r20.getLayoutParams()
            r1 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.C0675f) r1
            int r0 = r1.f1707e
            if (r0 < 0) goto L_0x00ba
            if (r13 == 0) goto L_0x00ba
            int r0 = r7.m2003b((int) r0)
            int r11 = r1.f1705c
            int r11 = m2010e(r11)
            int r11 = androidx.core.p020f.C0804c.m2545a(r11, r10)
            r11 = r11 & 7
            r22 = r2
            r2 = 3
            if (r11 != r2) goto L_0x0097
            if (r12 == 0) goto L_0x009c
        L_0x0097:
            r2 = 5
            if (r11 != r2) goto L_0x00a8
            if (r12 == 0) goto L_0x00a8
        L_0x009c:
            int r2 = r14 - r9
            int r2 = r2 - r0
            r0 = 0
            int r2 = java.lang.Math.max(r0, r2)
            r21 = r2
            r11 = 0
            goto L_0x00bf
        L_0x00a8:
            if (r11 != r2) goto L_0x00ac
            if (r12 == 0) goto L_0x00b1
        L_0x00ac:
            r2 = 3
            if (r11 != r2) goto L_0x00bc
            if (r12 == 0) goto L_0x00bc
        L_0x00b1:
            int r0 = r0 - r8
            r11 = 0
            int r0 = java.lang.Math.max(r11, r0)
            r21 = r0
            goto L_0x00bf
        L_0x00ba:
            r22 = r2
        L_0x00bc:
            r11 = 0
            r21 = 0
        L_0x00bf:
            if (r19 == 0) goto L_0x00f1
            boolean r0 = androidx.core.p020f.C0839t.m2722k(r20)
            if (r0 != 0) goto L_0x00f1
            androidx.core.f.b0 r0 = r7.f1694m
            int r0 = r0.mo4101b()
            androidx.core.f.b0 r2 = r7.f1694m
            int r2 = r2.mo4102c()
            int r0 = r0 + r2
            androidx.core.f.b0 r2 = r7.f1694m
            int r2 = r2.mo4103d()
            androidx.core.f.b0 r11 = r7.f1694m
            int r11 = r11.mo4099a()
            int r2 = r2 + r11
            int r0 = r14 - r0
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r13)
            int r2 = r16 - r2
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r15)
            r11 = r0
            r23 = r2
            goto L_0x00f5
        L_0x00f1:
            r11 = r31
            r23 = r32
        L_0x00f5:
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r0 = r1.mo3808c()
            if (r0 == 0) goto L_0x011d
            r24 = 0
            r2 = r1
            r1 = r30
            r26 = r2
            r25 = r22
            r2 = r20
            r22 = r3
            r3 = r11
            r27 = r4
            r4 = r21
            r28 = r8
            r8 = r5
            r5 = r23
            r29 = r6
            r6 = r24
            boolean r0 = r0.mo3778a((androidx.coordinatorlayout.widget.CoordinatorLayout) r1, r2, (int) r3, (int) r4, (int) r5, (int) r6)
            if (r0 != 0) goto L_0x0137
            goto L_0x012a
        L_0x011d:
            r26 = r1
            r27 = r4
            r29 = r6
            r28 = r8
            r25 = r22
            r22 = r3
            r8 = r5
        L_0x012a:
            r5 = 0
            r0 = r30
            r1 = r20
            r2 = r11
            r3 = r21
            r4 = r23
            r0.mo3727a((android.view.View) r1, (int) r2, (int) r3, (int) r4, (int) r5)
        L_0x0137:
            int r0 = r20.getMeasuredWidth()
            int r0 = r17 + r0
            r1 = r26
            int r2 = r1.leftMargin
            int r0 = r0 + r2
            int r2 = r1.rightMargin
            int r0 = r0 + r2
            int r0 = java.lang.Math.max(r8, r0)
            int r2 = r20.getMeasuredHeight()
            int r2 = r18 + r2
            int r3 = r1.topMargin
            int r2 = r2 + r3
            int r1 = r1.bottomMargin
            int r2 = r2 + r1
            r1 = r27
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r20.getMeasuredState()
            r11 = r25
            int r2 = android.view.View.combineMeasuredStates(r11, r2)
            r5 = r0
            r4 = r1
        L_0x0167:
            int r3 = r22 + 1
            r8 = r28
            r6 = r29
            goto L_0x0057
        L_0x016f:
            r11 = r2
            r1 = r4
            r8 = r5
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r11
            r2 = r31
            int r0 = android.view.View.resolveSizeAndState(r8, r2, r0)
            int r2 = r11 << 16
            r3 = r32
            int r1 = android.view.View.resolveSizeAndState(r1, r3, r2)
            r7.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        C0672c c;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0675f fVar = (C0675f) childAt.getLayoutParams();
                if (fVar.mo3803a(0) && (c = fVar.mo3808c()) != null) {
                    z2 |= c.mo3784a(this, childAt, view, f, f2, z);
                }
            }
        }
        if (z2) {
            mo3726a(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        C0672c c;
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0675f fVar = (C0675f) childAt.getLayoutParams();
                if (fVar.mo3803a(0) && (c = fVar.mo3808c()) != null) {
                    z |= c.mo3783a(this, childAt, view, f, f2);
                }
            }
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        mo2817a(view, i, i2, iArr, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        mo2815a(view, i, i2, i3, i4, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        mo2826b(view, view2, i, 0);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mo4406a());
        SparseArray<Parcelable> sparseArray = savedState.f1700c;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0672c c = mo3723a(childAt).mo3808c();
            if (!(id == -1 || c == null || (parcelable2 = sparseArray.get(id)) == null)) {
                c.mo3768a(this, childAt, parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable d;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            C0672c c = ((C0675f) childAt.getLayoutParams()).mo3808c();
            if (!(id == -1 || c == null || (d = c.mo3792d(this, childAt)) == null)) {
                sparseArray.append(id, d);
            }
        }
        savedState.f1700c = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return mo2823a(view, view2, i, 0);
    }

    public void onStopNestedScroll(View view) {
        mo2814a(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f1690i
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0015
            boolean r3 = r0.m2002a((android.view.MotionEvent) r1, (int) r4)
            if (r3 == 0) goto L_0x002b
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            android.view.View r6 = r0.f1690i
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.C0675f) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r6 = r6.mo3808c()
            if (r6 == 0) goto L_0x002b
            android.view.View r7 = r0.f1690i
            boolean r6 = r6.mo3786b((androidx.coordinatorlayout.widget.CoordinatorLayout) r0, r7, (android.view.MotionEvent) r1)
            goto L_0x002c
        L_0x002b:
            r6 = 0
        L_0x002c:
            android.view.View r7 = r0.f1690i
            r8 = 0
            if (r7 != 0) goto L_0x0037
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x004a
        L_0x0037:
            if (r3 == 0) goto L_0x004a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x004a:
            if (r8 == 0) goto L_0x004f
            r8.recycle()
        L_0x004f:
            if (r2 == r4) goto L_0x0054
            r1 = 3
            if (r2 != r1) goto L_0x0057
        L_0x0054:
            r0.m2001a((boolean) r5)
        L_0x0057:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        C0672c c = ((C0675f) view.getLayoutParams()).mo3808c();
        if (c == null || !c.mo3780a(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.f1687f) {
            m2001a(false);
            this.f1687f = true;
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        m2013f();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f1697p = onHierarchyChangeListener;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f1696o;
        if (drawable != null && drawable.isVisible() != z) {
            this.f1696o.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1696o;
    }

    /* access modifiers changed from: protected */
    public C0675f generateDefaultLayoutParams() {
        return new C0675f(-2, -2);
    }

    /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$f */
    public static class C0675f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        C0672c f1703a;

        /* renamed from: b */
        boolean f1704b = false;

        /* renamed from: c */
        public int f1705c = 0;

        /* renamed from: d */
        public int f1706d = 0;

        /* renamed from: e */
        public int f1707e = -1;

        /* renamed from: f */
        int f1708f = -1;

        /* renamed from: g */
        public int f1709g = 0;

        /* renamed from: h */
        public int f1710h = 0;

        /* renamed from: i */
        int f1711i;

        /* renamed from: j */
        int f1712j;

        /* renamed from: k */
        View f1713k;

        /* renamed from: l */
        View f1714l;

        /* renamed from: m */
        private boolean f1715m;

        /* renamed from: n */
        private boolean f1716n;

        /* renamed from: o */
        private boolean f1717o;

        /* renamed from: p */
        private boolean f1718p;

        /* renamed from: q */
        final Rect f1719q = new Rect();

        public C0675f(int i, int i2) {
            super(i, i2);
        }

        /* renamed from: a */
        public void mo3800a(C0672c cVar) {
            C0672c cVar2 = this.f1703a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.mo3766a();
                }
                this.f1703a = cVar;
                this.f1704b = true;
                if (cVar != null) {
                    cVar.mo3767a(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo3806b() {
            if (this.f1703a == null) {
                this.f1715m = false;
            }
            return this.f1715m;
        }

        /* renamed from: c */
        public C0672c mo3808c() {
            return this.f1703a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo3809d() {
            return this.f1718p;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public Rect mo3810e() {
            return this.f1719q;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo3811f() {
            this.f1718p = false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo3812g() {
            this.f1715m = false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo3807b(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.f1715m;
            if (z) {
                return true;
            }
            C0672c cVar = this.f1703a;
            boolean a = (cVar != null ? cVar.mo3776a(coordinatorLayout, view) : false) | z;
            this.f1715m = a;
            return a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3799a(Rect rect) {
            this.f1719q.set(rect);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo3802a() {
            return this.f1713k == null && this.f1708f != -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo3805b(int i) {
            mo3798a(i, false);
        }

        /* renamed from: b */
        private boolean m2067b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f1713k.getId() != this.f1708f) {
                return false;
            }
            View view2 = this.f1713k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f1714l = null;
                    this.f1713k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.f1714l = view2;
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3798a(int i, boolean z) {
            if (i == 0) {
                this.f1716n = z;
            } else if (i == 1) {
                this.f1717o = z;
            }
        }

        C0675f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
            this.f1705c = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f1708f = obtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f1706d = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f1707e = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f1709g = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f1710h = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.CoordinatorLayout_Layout_layout_behavior);
            this.f1704b = hasValue;
            if (hasValue) {
                this.f1703a = CoordinatorLayout.m1993a(context, attributeSet, obtainStyledAttributes.getString(R$styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            C0672c cVar = this.f1703a;
            if (cVar != null) {
                cVar.mo3767a(this);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo3803a(int i) {
            if (i == 0) {
                return this.f1716n;
            }
            if (i != 1) {
                return false;
            }
            return this.f1717o;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3801a(boolean z) {
            this.f1718p = z;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
            r0 = r1.f1703a;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo3804a(androidx.coordinatorlayout.widget.CoordinatorLayout r2, android.view.View r3, android.view.View r4) {
            /*
                r1 = this;
                android.view.View r0 = r1.f1714l
                if (r4 == r0) goto L_0x001b
                int r0 = androidx.core.p020f.C0839t.m2725n(r2)
                boolean r0 = r1.m2066a((android.view.View) r4, (int) r0)
                if (r0 != 0) goto L_0x001b
                androidx.coordinatorlayout.widget.CoordinatorLayout$c r0 = r1.f1703a
                if (r0 == 0) goto L_0x0019
                boolean r2 = r0.mo3782a((androidx.coordinatorlayout.widget.CoordinatorLayout) r2, r3, (android.view.View) r4)
                if (r2 == 0) goto L_0x0019
                goto L_0x001b
            L_0x0019:
                r2 = 0
                goto L_0x001c
            L_0x001b:
                r2 = 1
            L_0x001c:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.C0675f.mo3804a(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View):boolean");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public View mo3797a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f1708f == -1) {
                this.f1714l = null;
                this.f1713k = null;
                return null;
            }
            if (this.f1713k == null || !m2067b(view, coordinatorLayout)) {
                m2065a(view, coordinatorLayout);
            }
            return this.f1713k;
        }

        /* renamed from: a */
        private void m2065a(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f1708f);
            this.f1713k = findViewById;
            if (findViewById != null) {
                if (findViewById != coordinatorLayout) {
                    ViewParent parent = findViewById.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                findViewById = (View) parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.f1714l = null;
                            this.f1713k = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f1714l = findViewById;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.f1714l = null;
                    this.f1713k = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.f1714l = null;
                this.f1713k = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f1708f) + " to anchor view " + view);
            }
        }

        public C0675f(C0675f fVar) {
            super(fVar);
        }

        /* renamed from: a */
        private boolean m2066a(View view, int i) {
            int a = C0804c.m2545a(((C0675f) view.getLayoutParams()).f1709g, i);
            return a != 0 && (C0804c.m2545a(this.f1710h, i) & a) == a;
        }

        public C0675f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0675f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: d */
    private void m2009d(View view, int i) {
        C0675f fVar = (C0675f) view.getLayoutParams();
        Rect d = m2008d();
        d.set(getPaddingLeft() + fVar.leftMargin, getPaddingTop() + fVar.topMargin, (getWidth() - getPaddingRight()) - fVar.rightMargin, (getHeight() - getPaddingBottom()) - fVar.bottomMargin);
        if (this.f1694m != null && C0839t.m2722k(this) && !C0839t.m2722k(view)) {
            d.left += this.f1694m.mo4101b();
            d.top += this.f1694m.mo4103d();
            d.right -= this.f1694m.mo4102c();
            d.bottom -= this.f1694m.mo4099a();
        }
        Rect d2 = m2008d();
        C0804c.m2546a(m2007d(fVar.f1705c), view.getMeasuredWidth(), view.getMeasuredHeight(), d, d2, i);
        view.layout(d2.left, d2.top, d2.right, d2.bottom);
        m1994a(d);
        m1994a(d2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C0803b0 mo3724a(C0803b0 b0Var) {
        if (C0790c.m2494a(this.f1694m, b0Var)) {
            return b0Var;
        }
        this.f1694m = b0Var;
        boolean z = true;
        boolean z2 = b0Var != null && b0Var.mo4103d() > 0;
        this.f1695n = z2;
        if (z2 || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        C0803b0 b = m2004b(b0Var);
        requestLayout();
        return b;
    }

    public C0675f generateLayoutParams(AttributeSet attributeSet) {
        return new C0675f(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0675f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C0675f) {
            return new C0675f((C0675f) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0675f((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0675f(layoutParams);
    }

    /* renamed from: f */
    private void m2013f() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (C0839t.m2722k(this)) {
                if (this.f1698q == null) {
                    this.f1698q = new C0670a();
                }
                C0839t.m2698a((View) this, this.f1698q);
                setSystemUiVisibility(1280);
                return;
            }
            C0839t.m2698a((View) this, (C0836q) null);
        }
    }

    /* renamed from: b */
    private C0803b0 m2004b(C0803b0 b0Var) {
        C0672c c;
        if (b0Var.mo4104e()) {
            return b0Var;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (C0839t.m2722k(childAt) && (c = ((C0675f) childAt.getLayoutParams()).mo3808c()) != null) {
                b0Var = c.mo3765a(this, childAt, b0Var);
                if (b0Var.mo4104e()) {
                    break;
                }
            }
        }
        return b0Var;
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0669a();

        /* renamed from: c */
        SparseArray<Parcelable> f1700c;

        /* renamed from: androidx.coordinatorlayout.widget.CoordinatorLayout$SavedState$a */
        static class C0669a implements Parcelable.ClassLoaderCreator<SavedState> {
            C0669a() {
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f1700c = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f1700c.append(iArr[i], readParcelableArray[i]);
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.f1700c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f1700c.keyAt(i2);
                parcelableArr[i2] = this.f1700c.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* renamed from: a */
    private void m2001a(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0672c c = ((C0675f) childAt.getLayoutParams()).mo3808c();
            if (c != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    c.mo3781a(this, childAt, obtain);
                } else {
                    c.mo3786b(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((C0675f) getChildAt(i2).getLayoutParams()).mo3812g();
        }
        this.f1690i = null;
        this.f1687f = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo3736c(View view, Rect rect) {
        ((C0675f) view.getLayoutParams()).mo3799a(rect);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo3734c() {
        if (this.f1688g && this.f1692k != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1692k);
        }
        this.f1693l = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3733b(View view, Rect rect) {
        rect.set(((C0675f) view.getLayoutParams()).mo3810e());
    }

    /* renamed from: e */
    private void m2012e(View view, int i) {
        C0675f fVar = (C0675f) view.getLayoutParams();
        int i2 = fVar.f1711i;
        if (i2 != i) {
            C0839t.m2712d(view, i - i2);
            fVar.f1711i = i;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3731b() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (m2005b(getChildAt(i))) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z == this.f1693l) {
            return;
        }
        if (z) {
            mo3725a();
        } else {
            mo3734c();
        }
    }

    /* renamed from: b */
    private boolean m2005b(View view) {
        return this.f1683b.mo3821c(view);
    }

    /* renamed from: a */
    private void m2000a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        Comparator<View> comparator = f1680v;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3732b(View view, int i) {
        C0672c c;
        View view2 = view;
        C0675f fVar = (C0675f) view.getLayoutParams();
        if (fVar.f1713k != null) {
            Rect d = m2008d();
            Rect d2 = m2008d();
            Rect d3 = m2008d();
            mo3729a(fVar.f1713k, d);
            boolean z = false;
            mo3730a(view2, false, d2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i2 = measuredHeight;
            m1996a(view, i, d, d3, fVar, measuredWidth, measuredHeight);
            if (!(d3.left == d2.left && d3.top == d2.top)) {
                z = true;
            }
            m1999a(fVar, d3, measuredWidth, i2);
            int i3 = d3.left - d2.left;
            int i4 = d3.top - d2.top;
            if (i3 != 0) {
                C0839t.m2712d(view2, i3);
            }
            if (i4 != 0) {
                C0839t.m2714e(view2, i4);
            }
            if (z && (c = fVar.mo3808c()) != null) {
                c.mo3787b(this, view2, fVar.f1713k);
            }
            m1994a(d);
            m1994a(d2);
            m1994a(d3);
        }
    }

    /* renamed from: a */
    private boolean m2002a(MotionEvent motionEvent, int i) {
        MotionEvent motionEvent2 = motionEvent;
        int i2 = i;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f1684c;
        m2000a(list);
        int size = list.size();
        MotionEvent motionEvent3 = null;
        boolean z = false;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = list.get(i3);
            C0675f fVar = (C0675f) view.getLayoutParams();
            C0672c c = fVar.mo3808c();
            if ((!z && !z2) || actionMasked == 0) {
                if (!z && c != null) {
                    if (i2 == 0) {
                        z = c.mo3781a(this, view, motionEvent2);
                    } else if (i2 == 1) {
                        z = c.mo3786b(this, view, motionEvent2);
                    }
                    if (z) {
                        this.f1690i = view;
                    }
                }
                boolean b = fVar.mo3806b();
                boolean b2 = fVar.mo3807b(this, view);
                z2 = b2 && !b;
                if (b2 && !z2) {
                    break;
                }
            } else if (c != null) {
                if (motionEvent3 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i2 == 0) {
                    c.mo3781a(this, view, motionEvent3);
                } else if (i2 == 1) {
                    c.mo3786b(this, view, motionEvent3);
                }
            }
        }
        list.clear();
        return z;
    }

    /* renamed from: b */
    public void mo2826b(View view, View view2, int i, int i2) {
        C0672c c;
        this.f1699r.mo4192a(view, view2, i, i2);
        this.f1691j = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            C0675f fVar = (C0675f) childAt.getLayoutParams();
            if (fVar.mo3803a(i2) && (c = fVar.mo3808c()) != null) {
                c.mo3775a(this, childAt, view, view2, i, i2);
            }
        }
    }

    /* renamed from: a */
    static C0672c m1993a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f1677s)) {
            str = f1677s + '.' + str;
        }
        try {
            Map map = f1679u.get();
            if (map == null) {
                map = new HashMap();
                f1679u.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(f1678t);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (C0672c) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0675f mo3723a(View view) {
        C0675f fVar = (C0675f) view.getLayoutParams();
        if (!fVar.f1704b) {
            if (view instanceof C0671b) {
                C0672c a = ((C0671b) view).mo3764a();
                if (a == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.mo3800a(a);
                fVar.f1704b = true;
            } else {
                C0673d dVar = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    dVar = (C0673d) cls.getAnnotation(C0673d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.mo3800a((C0672c) dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e) {
                        Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget" + " a default constructor?", e);
                    }
                }
                fVar.f1704b = true;
            }
        }
        return fVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3729a(View view, Rect rect) {
        C0679b.m2094a((ViewGroup) this, view, rect);
    }

    /* renamed from: a */
    public void mo3727a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3730a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            mo3729a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    /* renamed from: a */
    private void m1996a(View view, int i, Rect rect, Rect rect2, C0675f fVar, int i2, int i3) {
        int i4;
        int i5;
        int a = C0804c.m2545a(m2006c(fVar.f1705c), i);
        int a2 = C0804c.m2545a(m2007d(fVar.f1706d), i);
        int i6 = a & 7;
        int i7 = a & 112;
        int i8 = a2 & 7;
        int i9 = a2 & 112;
        if (i8 == 1) {
            i4 = rect.left + (rect.width() / 2);
        } else if (i8 != 5) {
            i4 = rect.left;
        } else {
            i4 = rect.right;
        }
        if (i9 == 16) {
            i5 = rect.top + (rect.height() / 2);
        } else if (i9 != 80) {
            i5 = rect.top;
        } else {
            i5 = rect.bottom;
        }
        if (i6 == 1) {
            i4 -= i2 / 2;
        } else if (i6 != 5) {
            i4 -= i2;
        }
        if (i7 == 16) {
            i5 -= i3 / 2;
        } else if (i7 != 80) {
            i5 -= i3;
        }
        rect2.set(i4, i5, i2 + i4, i3 + i5);
    }

    /* renamed from: a */
    private void m1999a(C0675f fVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + fVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - fVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + fVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - fVar.bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3728a(View view, int i, Rect rect, Rect rect2) {
        C0675f fVar = (C0675f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        m1996a(view, i, rect, rect2, fVar, measuredWidth, measuredHeight);
        m1999a(fVar, rect2, measuredWidth, measuredHeight);
    }

    /* renamed from: a */
    private void m1998a(View view, View view2, int i) {
        Rect d = m2008d();
        Rect d2 = m2008d();
        try {
            mo3729a(view2, d);
            mo3728a(view, i, d, d2);
            view.layout(d2.left, d2.top, d2.right, d2.bottom);
        } finally {
            m1994a(d);
            m1994a(d2);
        }
    }

    /* renamed from: a */
    private void m1995a(View view, int i, int i2) {
        C0675f fVar = (C0675f) view.getLayoutParams();
        int a = C0804c.m2545a(m2010e(fVar.f1705c), i2);
        int i3 = a & 7;
        int i4 = a & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int b = m2003b(i) - measuredWidth;
        int i5 = 0;
        if (i3 == 1) {
            b += measuredWidth / 2;
        } else if (i3 == 5) {
            b += measuredWidth;
        }
        if (i4 == 16) {
            i5 = 0 + (measuredHeight / 2);
        } else if (i4 == 80) {
            i5 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + fVar.leftMargin, Math.min(b, ((width - getPaddingRight()) - measuredWidth) - fVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + fVar.topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - fVar.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3726a(int i) {
        boolean z;
        int i2 = i;
        int n = C0839t.m2725n(this);
        int size = this.f1682a.size();
        Rect d = m2008d();
        Rect d2 = m2008d();
        Rect d3 = m2008d();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.f1682a.get(i3);
            C0675f fVar = (C0675f) view.getLayoutParams();
            if (i2 != 0 || view.getVisibility() != 8) {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (fVar.f1714l == this.f1682a.get(i4)) {
                        mo3732b(view, n);
                    }
                }
                mo3730a(view, true, d2);
                if (fVar.f1709g != 0 && !d2.isEmpty()) {
                    int a = C0804c.m2545a(fVar.f1709g, n);
                    int i5 = a & 112;
                    if (i5 == 48) {
                        d.top = Math.max(d.top, d2.bottom);
                    } else if (i5 == 80) {
                        d.bottom = Math.max(d.bottom, getHeight() - d2.top);
                    }
                    int i6 = a & 7;
                    if (i6 == 3) {
                        d.left = Math.max(d.left, d2.right);
                    } else if (i6 == 5) {
                        d.right = Math.max(d.right, getWidth() - d2.left);
                    }
                }
                if (fVar.f1710h != 0 && view.getVisibility() == 0) {
                    m1997a(view, d, n);
                }
                if (i2 != 2) {
                    mo3733b(view, d3);
                    if (!d3.equals(d2)) {
                        mo3736c(view, d2);
                    }
                }
                for (int i7 = i3 + 1; i7 < size; i7++) {
                    View view2 = this.f1682a.get(i7);
                    C0675f fVar2 = (C0675f) view2.getLayoutParams();
                    C0672c c = fVar2.mo3808c();
                    if (c != null && c.mo3782a(this, view2, view)) {
                        if (i2 != 0 || !fVar2.mo3809d()) {
                            if (i2 != 2) {
                                z = c.mo3787b(this, view2, view);
                            } else {
                                c.mo3791c(this, view2, view);
                                z = true;
                            }
                            if (i2 == 1) {
                                fVar2.mo3801a(z);
                            }
                        } else {
                            fVar2.mo3811f();
                        }
                    }
                }
            }
        }
        m1994a(d);
        m1994a(d2);
        m1994a(d3);
    }

    /* renamed from: a */
    private void m1997a(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int i3;
        int i4;
        int height;
        int i5;
        int i6;
        int i7;
        if (C0839t.m2736y(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            C0675f fVar = (C0675f) view.getLayoutParams();
            C0672c c = fVar.mo3808c();
            Rect d = m2008d();
            Rect d2 = m2008d();
            d2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (c == null || !c.mo3779a(this, view, d)) {
                d.set(d2);
            } else if (!d2.contains(d)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + d.toShortString() + " | Bounds:" + d2.toShortString());
            }
            m1994a(d2);
            if (d.isEmpty()) {
                m1994a(d);
                return;
            }
            int a = C0804c.m2545a(fVar.f1710h, i);
            boolean z3 = true;
            if ((a & 48) != 48 || (i6 = (d.top - fVar.topMargin) - fVar.f1712j) >= (i7 = rect.top)) {
                z = false;
            } else {
                m2014f(view, i7 - i6);
                z = true;
            }
            if ((a & 80) == 80 && (height = ((getHeight() - d.bottom) - fVar.bottomMargin) + fVar.f1712j) < (i5 = rect.bottom)) {
                m2014f(view, height - i5);
                z = true;
            }
            if (!z) {
                m2014f(view, 0);
            }
            if ((a & 3) != 3 || (i3 = (d.left - fVar.leftMargin) - fVar.f1711i) >= (i4 = rect.left)) {
                z2 = false;
            } else {
                m2012e(view, i4 - i3);
                z2 = true;
            }
            if ((a & 5) != 5 || (width = ((getWidth() - d.right) - fVar.rightMargin) + fVar.f1711i) >= (i2 = rect.right)) {
                z3 = z2;
            } else {
                m2012e(view, width - i2);
            }
            if (!z3) {
                m2012e(view, 0);
            }
            m1994a(d);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3725a() {
        if (this.f1688g) {
            if (this.f1692k == null) {
                this.f1692k = new C0676g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1692k);
        }
        this.f1693l = true;
    }

    /* renamed from: a */
    public boolean mo2823a(View view, View view2, int i, int i2) {
        int i3 = i2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                C0675f fVar = (C0675f) childAt.getLayoutParams();
                C0672c c = fVar.mo3808c();
                if (c != null) {
                    boolean b = c.mo3789b(this, childAt, view, view2, i, i2);
                    z |= b;
                    fVar.mo3798a(i3, b);
                } else {
                    fVar.mo3798a(i3, false);
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public void mo2814a(View view, int i) {
        this.f1699r.mo4190a(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0675f fVar = (C0675f) childAt.getLayoutParams();
            if (fVar.mo3803a(i)) {
                C0672c c = fVar.mo3808c();
                if (c != null) {
                    c.mo3769a(this, childAt, view, i);
                }
                fVar.mo3805b(i);
                fVar.mo3811f();
            }
        }
        this.f1691j = null;
    }

    /* renamed from: a */
    public void mo2815a(View view, int i, int i2, int i3, int i4, int i5) {
        C0672c c;
        int childCount = getChildCount();
        boolean z = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                int i7 = i5;
            } else {
                C0675f fVar = (C0675f) childAt.getLayoutParams();
                if (fVar.mo3803a(i5) && (c = fVar.mo3808c()) != null) {
                    c.mo3771a(this, childAt, view, i, i2, i3, i4, i5);
                    z = true;
                }
            }
        }
        if (z) {
            mo3726a(1);
        }
    }

    /* renamed from: a */
    public void mo2817a(View view, int i, int i2, int[] iArr, int i3) {
        C0672c c;
        int i4;
        int i5;
        int childCount = getChildCount();
        boolean z = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() == 8) {
                int i9 = i3;
            } else {
                C0675f fVar = (C0675f) childAt.getLayoutParams();
                if (fVar.mo3803a(i3) && (c = fVar.mo3808c()) != null) {
                    int[] iArr2 = this.f1685d;
                    iArr2[1] = 0;
                    iArr2[0] = 0;
                    c.mo3773a(this, childAt, view, i, i2, iArr2, i3);
                    int[] iArr3 = this.f1685d;
                    if (i > 0) {
                        i4 = Math.max(i6, iArr3[0]);
                    } else {
                        i4 = Math.min(i6, iArr3[0]);
                    }
                    i6 = i4;
                    int[] iArr4 = this.f1685d;
                    if (i2 > 0) {
                        i5 = Math.max(i7, iArr4[1]);
                    } else {
                        i5 = Math.min(i7, iArr4[1]);
                    }
                    i7 = i5;
                    z = true;
                }
            }
        }
        iArr[0] = i6;
        iArr[1] = i7;
        if (z) {
            mo3726a(1);
        }
    }
}
