package androidx.slidingpanelayout.widget;

import admost.sdk.base.AdMost;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.p020f.C0797a;
import androidx.core.p020f.C0839t;
import androidx.core.p020f.p021c0.C0807c;
import androidx.customview.p023a.C0884a;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: a */
    private int f3042a = -858993460;

    /* renamed from: b */
    private int f3043b;

    /* renamed from: c */
    private Drawable f3044c;

    /* renamed from: d */
    private Drawable f3045d;

    /* renamed from: e */
    private final int f3046e;

    /* renamed from: f */
    private boolean f3047f;

    /* renamed from: g */
    View f3048g;

    /* renamed from: h */
    float f3049h;

    /* renamed from: i */
    private float f3050i;

    /* renamed from: j */
    int f3051j;

    /* renamed from: k */
    boolean f3052k;

    /* renamed from: l */
    private int f3053l;

    /* renamed from: m */
    private float f3054m;

    /* renamed from: n */
    private float f3055n;

    /* renamed from: o */
    private C1129e f3056o;

    /* renamed from: p */
    final C0884a f3057p;

    /* renamed from: q */
    boolean f3058q;

    /* renamed from: r */
    private boolean f3059r = true;

    /* renamed from: s */
    private final Rect f3060s = new Rect();

    /* renamed from: t */
    final ArrayList<C1126b> f3061t = new ArrayList<>();

    /* renamed from: u */
    private Method f3062u;

    /* renamed from: v */
    private Field f3063v;

    /* renamed from: w */
    private boolean f3064w;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1124a();

        /* renamed from: c */
        boolean f3065c;

        /* renamed from: androidx.slidingpanelayout.widget.SlidingPaneLayout$SavedState$a */
        static class C1124a implements Parcelable.ClassLoaderCreator<SavedState> {
            C1124a() {
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3065c ? 1 : 0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3065c = parcel.readInt() != 0;
        }
    }

    /* renamed from: androidx.slidingpanelayout.widget.SlidingPaneLayout$b */
    private class C1126b implements Runnable {

        /* renamed from: a */
        final View f3068a;

        C1126b(View view) {
            this.f3068a = view;
        }

        public void run() {
            if (this.f3068a.getParent() == SlidingPaneLayout.this) {
                this.f3068a.setLayerType(0, (Paint) null);
                SlidingPaneLayout.this.mo5956d(this.f3068a);
            }
            SlidingPaneLayout.this.f3061t.remove(this);
        }
    }

    /* renamed from: androidx.slidingpanelayout.widget.SlidingPaneLayout$c */
    private class C1127c extends C0884a.C0887c {
        C1127c() {
        }

        /* renamed from: a */
        public void mo4398a(View view, int i) {
            SlidingPaneLayout.this.mo5962f();
        }

        /* renamed from: b */
        public boolean mo4404b(View view, int i) {
            if (SlidingPaneLayout.this.f3052k) {
                return false;
            }
            return ((C1128d) view.getLayoutParams()).f3073b;
        }

        /* renamed from: c */
        public void mo4405c(int i) {
            if (SlidingPaneLayout.this.f3057p.mo4390f() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.f3049h == 0.0f) {
                    slidingPaneLayout.mo5963f(slidingPaneLayout.f3048g);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.mo5947a(slidingPaneLayout2.f3048g);
                    SlidingPaneLayout.this.f3058q = false;
                    return;
                }
                slidingPaneLayout.mo5950b(slidingPaneLayout.f3048g);
                SlidingPaneLayout.this.f3058q = true;
            }
        }

        /* renamed from: a */
        public void mo4399a(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.mo5946a(i);
            SlidingPaneLayout.this.invalidate();
        }

        /* renamed from: b */
        public int mo4401b(View view, int i, int i2) {
            return view.getTop();
        }

        /* renamed from: a */
        public void mo4397a(View view, float f, float f2) {
            int i;
            C1128d dVar = (C1128d) view.getLayoutParams();
            if (SlidingPaneLayout.this.mo5951b()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + dVar.rightMargin;
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.f3049h > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f3051j;
                }
                i = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f3048g.getWidth();
            } else {
                i = dVar.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && SlidingPaneLayout.this.f3049h > 0.5f)) {
                    i += SlidingPaneLayout.this.f3051j;
                }
            }
            SlidingPaneLayout.this.f3057p.mo4388d(i, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        /* renamed from: a */
        public int mo4394a(View view) {
            return SlidingPaneLayout.this.f3051j;
        }

        /* renamed from: a */
        public int mo4395a(View view, int i, int i2) {
            C1128d dVar = (C1128d) SlidingPaneLayout.this.f3048g.getLayoutParams();
            if (SlidingPaneLayout.this.mo5951b()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + dVar.rightMargin) + SlidingPaneLayout.this.f3048g.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.f3051j);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + dVar.leftMargin;
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.f3051j + paddingLeft);
        }

        /* renamed from: a */
        public void mo4396a(int i, int i2) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.f3057p.mo4372a(slidingPaneLayout.f3048g, i2);
        }
    }

    /* renamed from: androidx.slidingpanelayout.widget.SlidingPaneLayout$e */
    public interface C1129e {
        /* renamed from: a */
        void mo5982a(View view);

        /* renamed from: a */
        void mo5983a(View view, float f);

        /* renamed from: b */
        void mo5984b(View view);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        float f = context.getResources().getDisplayMetrics().density;
        this.f3046e = (int) ((32.0f * f) + 0.5f);
        setWillNotDraw(false);
        C0839t.m2697a((View) this, (C0797a) new C1125a());
        C0839t.m2716f(this, 1);
        C0884a a = C0884a.m2963a((ViewGroup) this, 0.5f, (C0884a.C0887c) new C1127c());
        this.f3057p = a;
        a.mo4370a(f * 400.0f);
    }

    /* renamed from: g */
    private static boolean m4597g(View view) {
        Drawable background;
        if (view.isOpaque()) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5947a(View view) {
        C1129e eVar = this.f3056o;
        if (eVar != null) {
            eVar.mo5984b(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5950b(View view) {
        C1129e eVar = this.f3056o;
        if (eVar != null) {
            eVar.mo5982a(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5952c(View view) {
        C1129e eVar = this.f3056o;
        if (eVar != null) {
            eVar.mo5983a(view, this.f3049h);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C1128d) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (!this.f3057p.mo4376a(true)) {
            return;
        }
        if (!this.f3047f) {
            this.f3057p.mo4369a();
        } else {
            C0839t.m2682A(this);
        }
    }

    /* renamed from: d */
    public boolean mo5957d() {
        return this.f3047f;
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        int i;
        int i2;
        super.draw(canvas);
        if (mo5951b()) {
            drawable = this.f3045d;
        } else {
            drawable = this.f3044c;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (mo5951b()) {
                i2 = childAt.getRight();
                i = intrinsicWidth + i2;
            } else {
                int left = childAt.getLeft();
                int i3 = left - intrinsicWidth;
                i = left;
                i2 = i3;
            }
            drawable.setBounds(i2, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        C1128d dVar = (C1128d) view.getLayoutParams();
        int save = canvas.save();
        if (this.f3047f && !dVar.f3073b && this.f3048g != null) {
            canvas.getClipBounds(this.f3060s);
            if (mo5951b()) {
                Rect rect = this.f3060s;
                rect.left = Math.max(rect.left, this.f3048g.getRight());
            } else {
                Rect rect2 = this.f3060s;
                rect2.right = Math.min(rect2.right, this.f3048g.getLeft());
            }
            canvas.clipRect(this.f3060s);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* renamed from: e */
    public boolean mo5960e() {
        return m4596b(this.f3048g, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo5963f(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        View childAt;
        boolean z;
        View view2 = view;
        boolean b = mo5951b();
        int width = b ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = b ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !m4597g(view)) {
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        } else {
            i4 = view.getLeft();
            i3 = view.getRight();
            i2 = view.getTop();
            i = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 < childCount && (childAt = getChildAt(i5)) != view2) {
                if (childAt.getVisibility() == 8) {
                    z = b;
                } else {
                    z = b;
                    childAt.setVisibility((Math.max(b ? paddingLeft : width, childAt.getLeft()) < i4 || Math.max(paddingTop, childAt.getTop()) < i2 || Math.min(b ? width : paddingLeft, childAt.getRight()) > i3 || Math.min(height, childAt.getBottom()) > i) ? 0 : 4);
                }
                i5++;
                view2 = view;
                b = z;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C1128d();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new C1128d((ViewGroup.MarginLayoutParams) layoutParams) : new C1128d(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3059r = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3059r = true;
        int size = this.f3061t.size();
        for (int i = 0; i < size; i++) {
            this.f3061t.get(i).run();
        }
        this.f3061t.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f3047f && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f3058q = !this.f3057p.mo4375a(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f3047f || (this.f3052k && actionMasked != 0)) {
            this.f3057p.mo4378b();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.f3057p.mo4378b();
            return false;
        } else {
            if (actionMasked == 0) {
                this.f3052k = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f3054m = x;
                this.f3055n = y;
                if (this.f3057p.mo4375a(this.f3048g, (int) x, (int) y) && mo5961e(this.f3048g)) {
                    z = true;
                    if (this.f3057p.mo4380b(motionEvent) && !z) {
                        return false;
                    }
                }
            } else if (actionMasked == 2) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float abs = Math.abs(x2 - this.f3054m);
                float abs2 = Math.abs(y2 - this.f3055n);
                if (abs > ((float) this.f3057p.mo4389e()) && abs2 > abs) {
                    this.f3057p.mo4378b();
                    this.f3052k = true;
                    return false;
                }
            }
            z = false;
            return this.f3057p.mo4380b(motionEvent) ? true : true;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean b = mo5951b();
        if (b) {
            this.f3057p.mo4387d(2);
        } else {
            this.f3057p.mo4387d(1);
        }
        int i9 = i3 - i;
        int paddingRight = b ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = b ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f3059r) {
            this.f3049h = (!this.f3047f || !this.f3058q) ? 0.0f : 1.0f;
        }
        int i10 = paddingRight;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                C1128d dVar = (C1128d) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (dVar.f3073b) {
                    int i12 = i9 - paddingLeft;
                    int min = (Math.min(paddingRight, i12 - this.f3046e) - i10) - (dVar.leftMargin + dVar.rightMargin);
                    this.f3051j = min;
                    int i13 = b ? dVar.rightMargin : dVar.leftMargin;
                    dVar.f3074c = ((i10 + i13) + min) + (measuredWidth / 2) > i12;
                    int i14 = (int) (((float) min) * this.f3049h);
                    i10 += i13 + i14;
                    this.f3049h = ((float) i14) / ((float) this.f3051j);
                    i5 = 0;
                } else if (!this.f3047f || (i8 = this.f3053l) == 0) {
                    i10 = paddingRight;
                    i5 = 0;
                } else {
                    i5 = (int) ((1.0f - this.f3049h) * ((float) i8));
                    i10 = paddingRight;
                }
                if (b) {
                    i6 = (i9 - i10) + i5;
                    i7 = i6 - measuredWidth;
                } else {
                    i7 = i10 - i5;
                    i6 = i7 + measuredWidth;
                }
                childAt.layout(i7, paddingTop, i6, childAt.getMeasuredHeight() + paddingTop);
                paddingRight += childAt.getWidth();
            }
        }
        if (this.f3059r) {
            if (this.f3047f) {
                if (this.f3053l != 0) {
                    m4593a(this.f3049h);
                }
                if (((C1128d) this.f3048g.getLayoutParams()).f3074c) {
                    m4594a(this.f3048g, this.f3049h, this.f3042a);
                }
            } else {
                for (int i15 = 0; i15 < childCount; i15++) {
                    m4594a(getChildAt(i15), 0.0f, this.f3042a);
                }
            }
            mo5963f(this.f3048g);
        }
        this.f3059r = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f;
        int i11;
        int i12;
        int i13;
        int i14;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            } else if (mode != Integer.MIN_VALUE && mode == 0) {
                size = AdMost.AD_ERROR_FREQ_CAP;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            } else if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = AdMost.AD_ERROR_FREQ_CAP;
            }
        }
        boolean z = false;
        if (mode2 == Integer.MIN_VALUE) {
            i3 = (size2 - getPaddingTop()) - getPaddingBottom();
            i4 = 0;
        } else if (mode2 != 1073741824) {
            i4 = 0;
            i3 = 0;
        } else {
            i4 = (size2 - getPaddingTop()) - getPaddingBottom();
            i3 = i4;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f3048g = null;
        int i15 = paddingLeft;
        int i16 = 0;
        boolean z2 = false;
        float f2 = 0.0f;
        while (true) {
            i5 = 8;
            if (i16 >= childCount) {
                break;
            }
            View childAt = getChildAt(i16);
            C1128d dVar = (C1128d) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                dVar.f3074c = z;
            } else {
                float f3 = dVar.f3072a;
                if (f3 > 0.0f) {
                    f2 += f3;
                    if (dVar.width == 0) {
                    }
                }
                int i17 = dVar.leftMargin + dVar.rightMargin;
                int i18 = dVar.width;
                if (i18 == -2) {
                    i11 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i17, Integer.MIN_VALUE);
                    f = f2;
                    i12 = Integer.MIN_VALUE;
                } else {
                    f = f2;
                    i12 = Integer.MIN_VALUE;
                    if (i18 == -1) {
                        i11 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i17, 1073741824);
                    } else {
                        i11 = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
                    }
                }
                int i19 = dVar.height;
                if (i19 == -2) {
                    i13 = View.MeasureSpec.makeMeasureSpec(i3, i12);
                } else {
                    if (i19 == -1) {
                        i14 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                    } else {
                        i14 = View.MeasureSpec.makeMeasureSpec(i19, 1073741824);
                    }
                    i13 = i14;
                }
                childAt.measure(i11, i13);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == i12 && measuredHeight > i4) {
                    i4 = Math.min(measuredHeight, i3);
                }
                i15 -= measuredWidth;
                boolean z3 = i15 < 0;
                dVar.f3073b = z3;
                z2 |= z3;
                if (z3) {
                    this.f3048g = childAt;
                }
                f2 = f;
            }
            i16++;
            z = false;
        }
        if (z2 || f2 > 0.0f) {
            int i20 = paddingLeft - this.f3046e;
            int i21 = 0;
            while (i21 < childCount) {
                View childAt2 = getChildAt(i21);
                if (childAt2.getVisibility() != i5) {
                    C1128d dVar2 = (C1128d) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i5) {
                        boolean z4 = dVar2.width == 0 && dVar2.f3072a > 0.0f;
                        if (z4) {
                            i7 = 0;
                        } else {
                            i7 = childAt2.getMeasuredWidth();
                        }
                        if (!z2 || childAt2 == this.f3048g) {
                            if (dVar2.f3072a > 0.0f) {
                                if (dVar2.width == 0) {
                                    int i22 = dVar2.height;
                                    if (i22 == -2) {
                                        i8 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                                    } else if (i22 == -1) {
                                        i8 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                                    } else {
                                        i8 = View.MeasureSpec.makeMeasureSpec(i22, 1073741824);
                                    }
                                } else {
                                    i8 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                if (z2) {
                                    int i23 = paddingLeft - (dVar2.leftMargin + dVar2.rightMargin);
                                    i6 = i20;
                                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i23, 1073741824);
                                    if (i7 != i23) {
                                        childAt2.measure(makeMeasureSpec, i8);
                                    }
                                    i21++;
                                    i20 = i6;
                                    i5 = 8;
                                } else {
                                    i6 = i20;
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(i7 + ((int) ((dVar2.f3072a * ((float) Math.max(0, i15))) / f2)), 1073741824), i8);
                                    i21++;
                                    i20 = i6;
                                    i5 = 8;
                                }
                            }
                        } else if (dVar2.width < 0 && (i7 > i20 || dVar2.f3072a > 0.0f)) {
                            if (z4) {
                                int i24 = dVar2.height;
                                if (i24 == -2) {
                                    i10 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                                    i9 = 1073741824;
                                } else if (i24 == -1) {
                                    i9 = 1073741824;
                                    i10 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                                } else {
                                    i9 = 1073741824;
                                    i10 = View.MeasureSpec.makeMeasureSpec(i24, 1073741824);
                                }
                            } else {
                                i9 = 1073741824;
                                i10 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i20, i9), i10);
                        }
                    }
                }
                i6 = i20;
                i21++;
                i20 = i6;
                i5 = 8;
            }
        }
        setMeasuredDimension(size, i4 + getPaddingTop() + getPaddingBottom());
        this.f3047f = z2;
        if (this.f3057p.mo4390f() != 0 && !z2) {
            this.f3057p.mo4369a();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mo4406a());
        if (savedState.f3065c) {
            mo5960e();
        } else {
            mo5948a();
        }
        this.f3058q = savedState.f3065c;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3065c = mo5957d() ? mo5953c() : this.f3058q;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f3059r = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f3047f) {
            return super.onTouchEvent(motionEvent);
        }
        this.f3057p.mo4371a(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.f3054m = x;
            this.f3055n = y;
        } else if (actionMasked == 1 && mo5961e(this.f3048g)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f = x2 - this.f3054m;
            float f2 = y2 - this.f3055n;
            int e = this.f3057p.mo4389e();
            if ((f * f) + (f2 * f2) < ((float) (e * e)) && this.f3057p.mo4375a(this.f3048g, (int) x2, (int) y2)) {
                m4595a(this.f3048g, 0);
            }
        }
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f3047f) {
            this.f3058q = view == this.f3048g;
        }
    }

    /* renamed from: androidx.slidingpanelayout.widget.SlidingPaneLayout$d */
    public static class C1128d extends ViewGroup.MarginLayoutParams {

        /* renamed from: e */
        private static final int[] f3071e = {16843137};

        /* renamed from: a */
        public float f3072a = 0.0f;

        /* renamed from: b */
        boolean f3073b;

        /* renamed from: c */
        boolean f3074c;

        /* renamed from: d */
        Paint f3075d;

        public C1128d() {
            super(-1, -1);
        }

        public C1128d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C1128d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C1128d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3071e);
            this.f3072a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5956d(View view) {
        Field field;
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            C0839t.m2694a(view, ((C1128d) view.getLayoutParams()).f3075d);
            return;
        }
        if (i >= 16) {
            if (!this.f3064w) {
                try {
                    this.f3062u = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
                } catch (NoSuchMethodException e) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
                }
                try {
                    Field declaredField = View.class.getDeclaredField("mRecreateDisplayList");
                    this.f3063v = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
                }
                this.f3064w = true;
            }
            if (this.f3062u == null || (field = this.f3063v) == null) {
                view.invalidate();
                return;
            }
            try {
                field.setBoolean(view, true);
                this.f3062u.invoke(view, (Object[]) null);
            } catch (Exception e3) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e3);
            }
        }
        C0839t.m2692a(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo5961e(View view) {
        if (view == null) {
            return false;
        }
        C1128d dVar = (C1128d) view.getLayoutParams();
        if (!this.f3047f || !dVar.f3074c || this.f3049h <= 0.0f) {
            return false;
        }
        return true;
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C1128d(getContext(), attributeSet);
    }

    /* renamed from: c */
    public boolean mo5953c() {
        return !this.f3047f || this.f3049h == 1.0f;
    }

    /* renamed from: a */
    private boolean m4595a(View view, int i) {
        if (!this.f3059r && !mo5949a(0.0f, i)) {
            return false;
        }
        this.f3058q = false;
        return true;
    }

    /* renamed from: b */
    private boolean m4596b(View view, int i) {
        if (!this.f3059r && !mo5949a(1.0f, i)) {
            return false;
        }
        this.f3058q = true;
        return true;
    }

    /* renamed from: a */
    public boolean mo5948a() {
        return m4595a(this.f3048g, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5951b() {
        return C0839t.m2725n(this) == 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5946a(int i) {
        if (this.f3048g == null) {
            this.f3049h = 0.0f;
            return;
        }
        boolean b = mo5951b();
        C1128d dVar = (C1128d) this.f3048g.getLayoutParams();
        int width = this.f3048g.getWidth();
        if (b) {
            i = (getWidth() - i) - width;
        }
        float paddingRight = ((float) (i - ((b ? getPaddingRight() : getPaddingLeft()) + (b ? dVar.rightMargin : dVar.leftMargin)))) / ((float) this.f3051j);
        this.f3049h = paddingRight;
        if (this.f3053l != 0) {
            m4593a(paddingRight);
        }
        if (dVar.f3074c) {
            m4594a(this.f3048g, this.f3049h, this.f3042a);
        }
        mo5952c(this.f3048g);
    }

    /* renamed from: androidx.slidingpanelayout.widget.SlidingPaneLayout$a */
    class C1125a extends C0797a {

        /* renamed from: d */
        private final Rect f3066d = new Rect();

        C1125a() {
        }

        /* renamed from: a */
        public void mo4080a(View view, C0807c cVar) {
            C0807c a = C0807c.m2551a(cVar);
            super.mo4080a(view, a);
            m4612a(cVar, a);
            a.mo4164v();
            cVar.mo4114a((CharSequence) SlidingPaneLayout.class.getName());
            cVar.mo4129c(view);
            ViewParent q = C0839t.m2728q(view);
            if (q instanceof View) {
                cVar.mo4122b((View) q);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!mo5980c(childAt) && childAt.getVisibility() == 0) {
                    C0839t.m2716f(childAt, 1);
                    cVar.mo4112a(childAt);
                }
            }
        }

        /* renamed from: b */
        public void mo4084b(View view, AccessibilityEvent accessibilityEvent) {
            super.mo4084b(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        /* renamed from: c */
        public boolean mo5980c(View view) {
            return SlidingPaneLayout.this.mo5961e(view);
        }

        /* renamed from: a */
        public boolean mo4083a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!mo5980c(view)) {
                return super.mo4083a(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        /* renamed from: a */
        private void m4612a(C0807c cVar, C0807c cVar2) {
            Rect rect = this.f3066d;
            cVar2.mo4111a(rect);
            cVar.mo4128c(rect);
            cVar2.mo4121b(rect);
            cVar.mo4133d(rect);
            cVar.mo4152l(cVar2.mo4163u());
            cVar.mo4130c(cVar2.mo4141g());
            cVar.mo4114a(cVar2.mo4127c());
            cVar.mo4123b(cVar2.mo4132d());
            cVar.mo4135d(cVar2.mo4155n());
            cVar.mo4131c(cVar2.mo4154m());
            cVar.mo4137e(cVar2.mo4156o());
            cVar.mo4140f(cVar2.mo4157p());
            cVar.mo4117a(cVar2.mo4149j());
            cVar.mo4150k(cVar2.mo4161t());
            cVar.mo4144h(cVar2.mo4158q());
            cVar.mo4110a(cVar2.mo4119b());
            cVar.mo4120b(cVar2.mo4139f());
        }
    }

    /* renamed from: a */
    private void m4594a(View view, float f, int i) {
        C1128d dVar = (C1128d) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24) | (i & 16777215);
            if (dVar.f3075d == null) {
                dVar.f3075d = new Paint();
            }
            dVar.f3075d.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, dVar.f3075d);
            }
            mo5956d(view);
        } else if (view.getLayerType() != 0) {
            Paint paint = dVar.f3075d;
            if (paint != null) {
                paint.setColorFilter((ColorFilter) null);
            }
            C1126b bVar = new C1126b(view);
            this.f3061t.add(bVar);
            C0839t.m2699a((View) this, (Runnable) bVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo5962f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5949a(float f, int i) {
        int i2;
        if (!this.f3047f) {
            return false;
        }
        boolean b = mo5951b();
        C1128d dVar = (C1128d) this.f3048g.getLayoutParams();
        if (b) {
            i2 = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + dVar.rightMargin)) + (f * ((float) this.f3051j))) + ((float) this.f3048g.getWidth())));
        } else {
            i2 = (int) (((float) (getPaddingLeft() + dVar.leftMargin)) + (f * ((float) this.f3051j)));
        }
        C0884a aVar = this.f3057p;
        View view = this.f3048g;
        if (!aVar.mo4382b(view, i2, view.getTop())) {
            return false;
        }
        mo5962f();
        C0839t.m2682A(this);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4593a(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.mo5951b()
            android.view.View r1 = r9.f3048g
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$d r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.C1128d) r1
            boolean r2 = r1.f3074c
            r3 = 0
            if (r2 == 0) goto L_0x001c
            if (r0 == 0) goto L_0x0016
            int r1 = r1.rightMargin
            goto L_0x0018
        L_0x0016:
            int r1 = r1.leftMargin
        L_0x0018:
            if (r1 > 0) goto L_0x001c
            r1 = 1
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            int r2 = r9.getChildCount()
        L_0x0021:
            if (r3 >= r2) goto L_0x0059
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.f3048g
            if (r4 != r5) goto L_0x002c
            goto L_0x0056
        L_0x002c:
            float r5 = r9.f3050i
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.f3053l
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.f3050i = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L_0x0044
            int r5 = -r5
        L_0x0044:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L_0x0056
            float r5 = r9.f3050i
            if (r0 == 0) goto L_0x004f
            float r5 = r5 - r6
            goto L_0x0051
        L_0x004f:
            float r5 = r6 - r5
        L_0x0051:
            int r6 = r9.f3043b
            r9.m4594a(r4, r5, r6)
        L_0x0056:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.m4593a(float):void");
    }
}
