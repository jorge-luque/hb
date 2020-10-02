package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.p020f.C0797a;
import androidx.core.p020f.C0829j;
import androidx.core.p020f.C0831l;
import androidx.core.p020f.C0833n;
import androidx.core.p020f.C0835p;
import androidx.core.p020f.C0839t;
import androidx.core.p020f.p021c0.C0807c;
import androidx.core.p020f.p021c0.C0812e;
import com.google.android.gms.drive.MetadataChangeSet;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements C0833n, C0829j {

    /* renamed from: A */
    private static final C0867a f2101A = new C0867a();

    /* renamed from: B */
    private static final int[] f2102B = {16843130};

    /* renamed from: a */
    private long f2103a;

    /* renamed from: b */
    private final Rect f2104b;

    /* renamed from: c */
    private OverScroller f2105c;

    /* renamed from: d */
    private EdgeEffect f2106d;

    /* renamed from: e */
    private EdgeEffect f2107e;

    /* renamed from: f */
    private int f2108f;

    /* renamed from: g */
    private boolean f2109g;

    /* renamed from: h */
    private boolean f2110h;

    /* renamed from: i */
    private View f2111i;

    /* renamed from: j */
    private boolean f2112j;

    /* renamed from: k */
    private VelocityTracker f2113k;

    /* renamed from: l */
    private boolean f2114l;

    /* renamed from: m */
    private boolean f2115m;

    /* renamed from: n */
    private int f2116n;

    /* renamed from: o */
    private int f2117o;

    /* renamed from: p */
    private int f2118p;

    /* renamed from: q */
    private int f2119q;

    /* renamed from: r */
    private final int[] f2120r;

    /* renamed from: s */
    private final int[] f2121s;

    /* renamed from: t */
    private int f2122t;

    /* renamed from: u */
    private int f2123u;

    /* renamed from: v */
    private SavedState f2124v;

    /* renamed from: w */
    private final C0835p f2125w;

    /* renamed from: x */
    private final C0831l f2126x;

    /* renamed from: y */
    private float f2127y;

    /* renamed from: z */
    private C0868b f2128z;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0866a();

        /* renamed from: a */
        public int f2129a;

        /* renamed from: androidx.core.widget.NestedScrollView$SavedState$a */
        static class C0866a implements Parcelable.Creator<SavedState> {
            C0866a() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f2129a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2129a);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f2129a = parcel.readInt();
        }
    }

    /* renamed from: androidx.core.widget.NestedScrollView$b */
    public interface C0868b {
        /* renamed from: a */
        void mo1923a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    public NestedScrollView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: a */
    private static int m2834a(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    /* renamed from: c */
    private boolean m2847c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i2 < childAt.getTop() - scrollY || i2 >= childAt.getBottom() - scrollY || i < childAt.getLeft() || i >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    /* renamed from: g */
    private float m2851g() {
        if (this.f2127y == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f2127y = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f2127y;
    }

    /* renamed from: h */
    private void m2853h() {
        VelocityTracker velocityTracker = this.f2113k;
        if (velocityTracker == null) {
            this.f2113k = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    /* renamed from: i */
    private void m2854i() {
        this.f2105c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f2116n = viewConfiguration.getScaledTouchSlop();
        this.f2117o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2118p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    /* renamed from: j */
    private void m2855j() {
        if (this.f2113k == null) {
            this.f2113k = VelocityTracker.obtain();
        }
    }

    /* renamed from: k */
    private void m2856k() {
        VelocityTracker velocityTracker = this.f2113k;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2113k = null;
        }
    }

    /* renamed from: a */
    public void mo4274a(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        this.f2126x.mo4175a(i, i2, i3, i4, iArr, i5, iArr2);
    }

    /* renamed from: a */
    public boolean mo2823a(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    /* renamed from: b */
    public boolean mo4288b(int i, int i2) {
        return this.f2126x.mo4181a(i, i2);
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (!this.f2105c.isFinished()) {
            this.f2105c.computeScrollOffset();
            int currY = this.f2105c.getCurrY();
            int i = currY - this.f2123u;
            this.f2123u = currY;
            int[] iArr = this.f2121s;
            boolean z = false;
            iArr[1] = 0;
            mo4280a(0, i, iArr, (int[]) null, 1);
            int i2 = i - this.f2121s[1];
            int b = mo4286b();
            if (i2 != 0) {
                int scrollY = getScrollY();
                mo4279a(0, i2, getScrollX(), scrollY, 0, b, 0, 0, false);
                int scrollY2 = getScrollY() - scrollY;
                int i3 = i2 - scrollY2;
                int[] iArr2 = this.f2121s;
                iArr2[1] = 0;
                mo4274a(0, scrollY2, 0, i3, this.f2120r, 1, iArr2);
                i2 = i3 - this.f2121s[1];
            }
            if (i2 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && b > 0)) {
                    z = true;
                }
                if (z) {
                    m2850f();
                    if (i2 < 0) {
                        if (this.f2106d.isFinished()) {
                            this.f2106d.onAbsorb((int) this.f2105c.getCurrVelocity());
                        }
                    } else if (this.f2107e.isFinished()) {
                        this.f2107e.onAbsorb((int) this.f2105c.getCurrVelocity());
                    }
                }
                m2846c();
            }
            if (!this.f2105c.isFinished()) {
                C0839t.m2682A(this);
            } else {
                mo4305f(1);
            }
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    /* renamed from: d */
    public boolean mo4297d(int i) {
        return this.f2126x.mo4180a(i);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || mo4281a(keyEvent);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f2126x.mo4179a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f2126x.mo4178a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return mo4280a(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f2126x.mo4182a(i, i2, i3, i4, iArr);
    }

    public void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        if (this.f2106d != null) {
            int scrollY = getScrollY();
            int i2 = 0;
            if (!this.f2106d.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i = getPaddingLeft() + 0;
                } else {
                    i = 0;
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate((float) i, (float) min);
                this.f2106d.setSize(width, height);
                if (this.f2106d.draw(canvas)) {
                    C0839t.m2682A(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f2107e.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int max = Math.max(mo4286b(), scrollY) + height2;
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    i2 = 0 + getPaddingLeft();
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    max -= getPaddingBottom();
                }
                canvas.translate((float) (i2 - width2), (float) max);
                canvas.rotate(180.0f, (float) width2, 0.0f);
                this.f2107e.setSize(width2, height2);
                if (this.f2107e.draw(canvas)) {
                    C0839t.m2682A(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    /* renamed from: e */
    public boolean mo4304e(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.f2104b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f2104b;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f2104b.top = getScrollY() - height;
            Rect rect2 = this.f2104b;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f2104b;
        int i2 = rect3.top;
        int i3 = height + i2;
        rect3.bottom = i3;
        return m2845b(i, i2, i3);
    }

    /* renamed from: f */
    public void mo4305f(int i) {
        this.f2126x.mo4188c(i);
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getNestedScrollAxes() {
        return this.f2125w.mo4189a();
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return mo4297d(0);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f2126x.mo4185b();
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i, int i2) {
        view.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2110h = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f2112j) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int b = mo4286b();
                int scrollY = getScrollY();
                int g = scrollY - ((int) (axisValue * m2851g()));
                if (g < 0) {
                    b = 0;
                } else if (g <= b) {
                    b = g;
                }
                if (b != scrollY) {
                    super.scrollTo(getScrollX(), b);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f2112j) {
            return true;
        }
        int i = action & 255;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    int i2 = this.f2119q;
                    if (i2 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i2);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                        } else {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y - this.f2108f) > this.f2116n && (2 & getNestedScrollAxes()) == 0) {
                                this.f2112j = true;
                                this.f2108f = y;
                                m2855j();
                                this.f2113k.addMovement(motionEvent);
                                this.f2122t = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i != 3) {
                    if (i == 6) {
                        m2837a(motionEvent);
                    }
                }
            }
            this.f2112j = false;
            this.f2119q = -1;
            m2856k();
            if (this.f2105c.springBack(getScrollX(), getScrollY(), 0, 0, 0, mo4286b())) {
                C0839t.m2682A(this);
            }
            mo4305f(0);
        } else {
            int y2 = (int) motionEvent.getY();
            if (!m2847c((int) motionEvent.getX(), y2)) {
                this.f2112j = false;
                m2856k();
            } else {
                this.f2108f = y2;
                this.f2119q = motionEvent.getPointerId(0);
                m2853h();
                this.f2113k.addMovement(motionEvent);
                this.f2105c.computeScrollOffset();
                this.f2112j = !this.f2105c.isFinished();
                mo4288b(2, 0);
            }
        }
        return this.f2112j;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        this.f2109g = false;
        View view = this.f2111i;
        if (view != null && m2841a(view, (View) this)) {
            m2843b(this.f2111i);
        }
        this.f2111i = null;
        if (!this.f2110h) {
            if (this.f2124v != null) {
                scrollTo(getScrollX(), this.f2124v.f2129a);
                this.f2124v = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i5 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int a = m2834a(scrollY, paddingTop, i5);
            if (a != scrollY) {
                scrollTo(getScrollX(), a);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f2110h = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2114l && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        mo4287b((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        mo2817a(view, i, i2, iArr, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        m2836a(i4, 0, (int[]) null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        mo2826b(view, view2, i, 0);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        View view;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus(this, (View) null, i);
        } else {
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (view != null && !m2839a(view)) {
            return view.requestFocus(i, rect);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2124v = savedState;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2129a = getScrollY();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        C0868b bVar = this.f2128z;
        if (bVar != null) {
            bVar.mo1923a(this, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m2840a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f2104b);
            offsetDescendantRectToMyCoords(findFocus, this.f2104b);
            m2852g(mo4272a(this.f2104b));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return mo2823a(view, view2, i, 0);
    }

    public void onStopNestedScroll(View view) {
        mo2814a(view, 0);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        MotionEvent motionEvent2 = motionEvent;
        m2855j();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2122t = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, (float) this.f2122t);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f2113k;
                velocityTracker.computeCurrentVelocity(1000, (float) this.f2118p);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f2119q);
                if (Math.abs(yVelocity) >= this.f2117o) {
                    int i = -yVelocity;
                    float f = (float) i;
                    if (!dispatchNestedPreFling(0.0f, f)) {
                        dispatchNestedFling(0.0f, f, true);
                        mo4287b(i);
                    }
                } else if (this.f2105c.springBack(getScrollX(), getScrollY(), 0, 0, 0, mo4286b())) {
                    C0839t.m2682A(this);
                }
                this.f2119q = -1;
                m2849e();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent2.findPointerIndex(this.f2119q);
                if (findPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f2119q + " in onTouchEvent");
                } else {
                    int y = (int) motionEvent2.getY(findPointerIndex);
                    int i2 = this.f2108f - y;
                    if (!this.f2112j && Math.abs(i2) > this.f2116n) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f2112j = true;
                        i2 = i2 > 0 ? i2 - this.f2116n : i2 + this.f2116n;
                    }
                    int i3 = i2;
                    if (this.f2112j) {
                        if (mo4280a(0, i3, this.f2121s, this.f2120r, 0)) {
                            i3 -= this.f2121s[1];
                            this.f2122t += this.f2120r[1];
                        }
                        int i4 = i3;
                        this.f2108f = y - this.f2120r[1];
                        int scrollY = getScrollY();
                        int b = mo4286b();
                        int overScrollMode = getOverScrollMode();
                        boolean z = overScrollMode == 0 || (overScrollMode == 1 && b > 0);
                        int i5 = b;
                        if (mo4279a(0, i4, 0, getScrollY(), 0, b, 0, 0, true) && !mo4297d(0)) {
                            this.f2113k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.f2121s;
                        iArr[1] = 0;
                        mo4274a(0, scrollY2, 0, i4 - scrollY2, this.f2120r, 0, iArr);
                        int i6 = this.f2108f;
                        int[] iArr2 = this.f2120r;
                        this.f2108f = i6 - iArr2[1];
                        this.f2122t += iArr2[1];
                        if (z) {
                            int i7 = i4 - this.f2121s[1];
                            m2850f();
                            int i8 = scrollY + i7;
                            if (i8 < 0) {
                                C0874d.m2923a(this.f2106d, ((float) i7) / ((float) getHeight()), motionEvent2.getX(findPointerIndex) / ((float) getWidth()));
                                if (!this.f2107e.isFinished()) {
                                    this.f2107e.onRelease();
                                }
                            } else if (i8 > i5) {
                                C0874d.m2923a(this.f2107e, ((float) i7) / ((float) getHeight()), 1.0f - (motionEvent2.getX(findPointerIndex) / ((float) getWidth())));
                                if (!this.f2106d.isFinished()) {
                                    this.f2106d.onRelease();
                                }
                            }
                            EdgeEffect edgeEffect = this.f2106d;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.f2107e.isFinished())) {
                                C0839t.m2682A(this);
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f2112j && getChildCount() > 0 && this.f2105c.springBack(getScrollX(), getScrollY(), 0, 0, 0, mo4286b())) {
                    C0839t.m2682A(this);
                }
                this.f2119q = -1;
                m2849e();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f2108f = (int) motionEvent2.getY(actionIndex);
                this.f2119q = motionEvent2.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                m2837a(motionEvent);
                this.f2108f = (int) motionEvent2.getY(motionEvent2.findPointerIndex(this.f2119q));
            }
        } else if (getChildCount() == 0) {
            return false;
        } else {
            boolean z2 = !this.f2105c.isFinished();
            this.f2112j = z2;
            if (z2 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f2105c.isFinished()) {
                m2846c();
            }
            this.f2108f = (int) motionEvent.getY();
            this.f2119q = motionEvent2.getPointerId(0);
            mo4288b(2, 0);
        }
        VelocityTracker velocityTracker2 = this.f2113k;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f2109g) {
            m2843b(view2);
        } else {
            this.f2111i = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m2838a(rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m2856k();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        this.f2109g = true;
        super.requestLayout();
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int a = m2834a(i, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int a2 = m2834a(i2, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (a != getScrollX() || a2 != getScrollY()) {
                super.scrollTo(a, a2);
            }
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f2126x.mo4176a(z);
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i) {
        return mo4288b(i, 0);
    }

    public void stopNestedScroll() {
        mo4305f(0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: d */
    private boolean m2848d() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private void m2850f() {
        if (getOverScrollMode() == 2) {
            this.f2106d = null;
            this.f2107e = null;
        } else if (this.f2106d == null) {
            Context context = getContext();
            this.f2106d = new EdgeEffect(context);
            this.f2107e = new EdgeEffect(context);
        }
    }

    /* renamed from: a */
    public boolean mo4280a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.f2126x.mo4184a(i, i2, iArr, iArr2, i3);
    }

    /* renamed from: b */
    public void mo2826b(View view, View view2, int i, int i2) {
        this.f2125w.mo4192a(view, view2, i, i2);
        mo4288b(2, i2);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2104b = new Rect();
        this.f2109g = true;
        this.f2110h = false;
        this.f2111i = null;
        this.f2112j = false;
        this.f2115m = true;
        this.f2119q = -1;
        this.f2120r = new int[2];
        this.f2121s = new int[2];
        m2854i();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2102B, i, 0);
        mo4277a(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f2125w = new C0835p(this);
        this.f2126x = new C0831l(this);
        setNestedScrollingEnabled(true);
        C0839t.m2697a((View) this, (C0797a) f2101A);
    }

    /* renamed from: a */
    public void mo2816a(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        m2836a(i4, i5, iArr);
    }

    /* renamed from: a */
    private void m2836a(int i, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f2126x.mo4175a(0, scrollY2, 0, i - scrollY2, (int[]) null, i2, iArr);
    }

    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo4286b() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    /* renamed from: c */
    public boolean mo4289c(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.f2104b;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f2104b.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f2104b;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f2104b;
        return m2845b(i, rect3.top, rect3.bottom);
    }

    /* renamed from: g */
    private void m2852g(int i) {
        if (i == 0) {
            return;
        }
        if (this.f2115m) {
            mo4273a(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    /* renamed from: a */
    public void mo2814a(View view, int i) {
        this.f2125w.mo4190a(view, i);
        mo4305f(i);
    }

    /* renamed from: b */
    private boolean m2845b(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z = false;
        boolean z2 = i == 33;
        View a = m2835a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m2852g(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    /* renamed from: a */
    public void mo2815a(View view, int i, int i2, int i3, int i4, int i5) {
        m2836a(i4, i5, (int[]) null);
    }

    /* renamed from: a */
    public void mo2817a(View view, int i, int i2, int[] iArr, int i3) {
        mo4280a(i, i2, iArr, (int[]) null, i3);
    }

    /* renamed from: a */
    public int mo4271a() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    /* renamed from: e */
    private void m2849e() {
        this.f2112j = false;
        m2856k();
        mo4305f(0);
        EdgeEffect edgeEffect = this.f2106d;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f2107e.onRelease();
        }
    }

    /* renamed from: a */
    public void mo4276a(C0868b bVar) {
        this.f2128z = bVar;
    }

    /* renamed from: androidx.core.widget.NestedScrollView$a */
    static class C0867a extends C0797a {
        C0867a() {
        }

        /* renamed from: a */
        public boolean mo4081a(View view, int i, Bundle bundle) {
            if (super.mo4081a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i != 4096) {
                if (i == 8192 || i == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.mo4275a(0, max, true);
                    return true;
                } else if (i != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.mo4286b());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.mo4275a(0, min, true);
            return true;
        }

        /* renamed from: b */
        public void mo4084b(View view, AccessibilityEvent accessibilityEvent) {
            super.mo4084b(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.mo4286b() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            C0812e.m2622a(accessibilityEvent, nestedScrollView.getScrollX());
            C0812e.m2623b(accessibilityEvent, nestedScrollView.mo4286b());
        }

        /* renamed from: a */
        public void mo4080a(View view, C0807c cVar) {
            int b;
            super.mo4080a(view, cVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            cVar.mo4114a((CharSequence) ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (b = nestedScrollView.mo4286b()) > 0) {
                cVar.mo4148j(true);
                if (nestedScrollView.getScrollY() > 0) {
                    cVar.mo4113a(C0807c.C0808a.f2020g);
                    cVar.mo4113a(C0807c.C0808a.f2021h);
                }
                if (nestedScrollView.getScrollY() < b) {
                    cVar.mo4113a(C0807c.C0808a.f2019f);
                    cVar.mo4113a(C0807c.C0808a.f2022i);
                }
            }
        }
    }

    /* renamed from: b */
    private void m2842b(int i, int i2, boolean z) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f2103a > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int scrollY = getScrollY();
                OverScroller overScroller = this.f2105c;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY);
                m2844b(z);
            } else {
                if (!this.f2105c.isFinished()) {
                    m2846c();
                }
                scrollBy(i, i2);
            }
            this.f2103a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    /* renamed from: a */
    public void mo4277a(boolean z) {
        if (z != this.f2114l) {
            this.f2114l = z;
            requestLayout();
        }
    }

    /* renamed from: c */
    private void m2846c() {
        this.f2105c.abortAnimation();
        mo4305f(1);
    }

    /* renamed from: a */
    public boolean mo4281a(KeyEvent keyEvent) {
        this.f2104b.setEmpty();
        int i = 130;
        if (!m2848d()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) {
                return false;
            }
            return true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 19) {
                if (keyCode != 20) {
                    if (keyCode != 62) {
                        return false;
                    }
                    if (keyEvent.isShiftPressed()) {
                        i = 33;
                    }
                    mo4304e(i);
                    return false;
                } else if (!keyEvent.isAltPressed()) {
                    return mo4278a(130);
                } else {
                    return mo4289c(130);
                }
            } else if (!keyEvent.isAltPressed()) {
                return mo4278a(33);
            } else {
                return mo4289c(33);
            }
        }
    }

    /* renamed from: b */
    private void m2844b(boolean z) {
        if (z) {
            mo4288b(2, 1);
        } else {
            mo4305f(1);
        }
        this.f2123u = getScrollY();
        C0839t.m2682A(this);
    }

    /* renamed from: a */
    private void m2837a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2119q) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f2108f = (int) motionEvent.getY(i);
            this.f2119q = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f2113k;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* renamed from: b */
    private void m2843b(View view) {
        view.getDrawingRect(this.f2104b);
        offsetDescendantRectToMyCoords(view, this.f2104b);
        int a = mo4272a(this.f2104b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    /* renamed from: b */
    public void mo4287b(int i) {
        if (getChildCount() > 0) {
            this.f2105c.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            m2844b(true);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083 A[ADDED_TO_REGION] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo4279a(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            if (r1 == 0) goto L_0x002a
            if (r1 != r5) goto L_0x0028
            if (r2 == 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r2 = 0
            goto L_0x002b
        L_0x002a:
            r2 = 1
        L_0x002b:
            if (r1 == 0) goto L_0x0034
            if (r1 != r5) goto L_0x0032
            if (r3 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r1 = 0
            goto L_0x0035
        L_0x0034:
            r1 = 1
        L_0x0035:
            int r3 = r15 + r13
            if (r2 != 0) goto L_0x003b
            r2 = 0
            goto L_0x003d
        L_0x003b:
            r2 = r19
        L_0x003d:
            int r6 = r16 + r14
            if (r1 != 0) goto L_0x0043
            r1 = 0
            goto L_0x0045
        L_0x0043:
            r1 = r20
        L_0x0045:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L_0x0050
            r3 = r2
        L_0x004e:
            r2 = 1
            goto L_0x0055
        L_0x0050:
            if (r3 >= r7) goto L_0x0054
            r3 = r7
            goto L_0x004e
        L_0x0054:
            r2 = 0
        L_0x0055:
            if (r6 <= r1) goto L_0x005a
            r6 = r1
        L_0x0058:
            r1 = 1
            goto L_0x005f
        L_0x005a:
            if (r6 >= r8) goto L_0x005e
            r6 = r8
            goto L_0x0058
        L_0x005e:
            r1 = 0
        L_0x005f:
            if (r1 == 0) goto L_0x007e
            boolean r7 = r12.mo4297d(r5)
            if (r7 != 0) goto L_0x007e
            android.widget.OverScroller r7 = r0.f2105c
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.mo4286b()
            r13 = r7
            r14 = r3
            r15 = r6
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L_0x007e:
            r12.onOverScrolled(r3, r6, r2, r1)
            if (r2 != 0) goto L_0x0085
            if (r1 == 0) goto L_0x0086
        L_0x0085:
            r4 = 1
        L_0x0086:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.mo4279a(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    /* renamed from: a */
    private View m2835a(boolean z, int i, int i2) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                boolean z3 = i < top && bottom < i2;
                if (view == null) {
                    view = view2;
                    z2 = z3;
                } else {
                    boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z2) {
                        if (z3) {
                            if (!z4) {
                            }
                        }
                    } else if (z3) {
                        view = view2;
                        z2 = true;
                    } else if (!z4) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    /* renamed from: a */
    public boolean mo4278a(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int a = mo4271a();
        if (findNextFocus == null || !m2840a(findNextFocus, a, getHeight())) {
            if (i == 33 && getScrollY() < a) {
                a = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                a = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), a);
            }
            if (a == 0) {
                return false;
            }
            if (i != 130) {
                a = -a;
            }
            m2852g(a);
        } else {
            findNextFocus.getDrawingRect(this.f2104b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f2104b);
            m2852g(mo4272a(this.f2104b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus == null || !findFocus.isFocused() || !m2839a(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    /* renamed from: a */
    private boolean m2839a(View view) {
        return !m2840a(view, 0, getHeight());
    }

    /* renamed from: a */
    private boolean m2840a(View view, int i, int i2) {
        view.getDrawingRect(this.f2104b);
        offsetDescendantRectToMyCoords(view, this.f2104b);
        return this.f2104b.bottom + i >= getScrollY() && this.f2104b.top - i <= getScrollY() + i2;
    }

    /* renamed from: a */
    public final void mo4273a(int i, int i2) {
        m2842b(i, i2, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4275a(int i, int i2, boolean z) {
        m2842b(i - getScrollX(), i2 - getScrollY(), z);
    }

    /* renamed from: a */
    private boolean m2838a(Rect rect, boolean z) {
        int a = mo4272a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                mo4273a(0, a);
            }
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo4272a(Rect rect) {
        int i;
        int i2;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i3 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i4 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i3 - verticalFadingEdgeLength : i3;
        if (rect.bottom > i4 && rect.top > scrollY) {
            if (rect.height() > height) {
                i2 = rect.top - scrollY;
            } else {
                i2 = rect.bottom - i4;
            }
            return Math.min(i2 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i3);
        } else if (rect.top >= scrollY || rect.bottom >= i4) {
            return 0;
        } else {
            if (rect.height() > height) {
                i = 0 - (i4 - rect.bottom);
            } else {
                i = 0 - (scrollY - rect.top);
            }
            return Math.max(i, -getScrollY());
        }
    }

    /* renamed from: a */
    private static boolean m2841a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !m2841a((View) parent, view2)) {
            return false;
        }
        return true;
    }
}
