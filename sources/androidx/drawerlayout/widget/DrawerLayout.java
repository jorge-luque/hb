package androidx.drawerlayout.widget;

import admost.sdk.base.AdMost;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.graphics.drawable.C0857a;
import androidx.core.p020f.C0797a;
import androidx.core.p020f.C0804c;
import androidx.core.p020f.C0839t;
import androidx.core.p020f.p021c0.C0807c;
import androidx.customview.p023a.C0884a;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup {

    /* renamed from: J */
    private static final int[] f2200J = {16843828};

    /* renamed from: K */
    static final int[] f2201K = {16842931};

    /* renamed from: L */
    static final boolean f2202L = (Build.VERSION.SDK_INT >= 19);

    /* renamed from: M */
    private static final boolean f2203M;

    /* renamed from: A */
    private Object f2204A;

    /* renamed from: B */
    private boolean f2205B;

    /* renamed from: C */
    private Drawable f2206C = null;

    /* renamed from: D */
    private Drawable f2207D = null;

    /* renamed from: E */
    private Drawable f2208E = null;

    /* renamed from: F */
    private Drawable f2209F = null;

    /* renamed from: G */
    private final ArrayList<View> f2210G;

    /* renamed from: H */
    private Rect f2211H;

    /* renamed from: I */
    private Matrix f2212I;

    /* renamed from: a */
    private final C0893c f2213a = new C0893c();

    /* renamed from: b */
    private float f2214b;

    /* renamed from: c */
    private int f2215c;

    /* renamed from: d */
    private int f2216d = -1728053248;

    /* renamed from: e */
    private float f2217e;

    /* renamed from: f */
    private Paint f2218f = new Paint();

    /* renamed from: g */
    private final C0884a f2219g;

    /* renamed from: h */
    private final C0884a f2220h;

    /* renamed from: i */
    private final C0896f f2221i;

    /* renamed from: j */
    private final C0896f f2222j;

    /* renamed from: k */
    private int f2223k;

    /* renamed from: l */
    private boolean f2224l;

    /* renamed from: m */
    private boolean f2225m = true;

    /* renamed from: n */
    private int f2226n = 3;

    /* renamed from: o */
    private int f2227o = 3;

    /* renamed from: p */
    private int f2228p = 3;

    /* renamed from: q */
    private int f2229q = 3;

    /* renamed from: r */
    private boolean f2230r;

    /* renamed from: s */
    private List<C0894d> f2231s;

    /* renamed from: t */
    private float f2232t;

    /* renamed from: u */
    private float f2233u;

    /* renamed from: v */
    private Drawable f2234v;

    /* renamed from: w */
    private Drawable f2235w;

    /* renamed from: x */
    private Drawable f2236x;

    /* renamed from: y */
    private CharSequence f2237y;

    /* renamed from: z */
    private CharSequence f2238z;

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$a */
    class C0891a implements View.OnApplyWindowInsetsListener {
        C0891a() {
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).mo4418a((Object) windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$c */
    static final class C0893c extends C0797a {
        C0893c() {
        }

        /* renamed from: a */
        public void mo4080a(View view, C0807c cVar) {
            super.mo4080a(view, cVar);
            if (!DrawerLayout.m3029m(view)) {
                cVar.mo4122b((View) null);
            }
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$d */
    public interface C0894d {
        /* renamed from: a */
        void mo4466a(int i);

        /* renamed from: a */
        void mo4467a(View view);

        /* renamed from: a */
        void mo4468a(View view, float f);

        /* renamed from: b */
        void mo4469b(View view);
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$f */
    private class C0896f extends C0884a.C0887c {

        /* renamed from: a */
        private final int f2251a;

        /* renamed from: b */
        private C0884a f2252b;

        /* renamed from: c */
        private final Runnable f2253c = new C0897a();

        /* renamed from: androidx.drawerlayout.widget.DrawerLayout$f$a */
        class C0897a implements Runnable {
            C0897a() {
            }

            public void run() {
                C0896f.this.mo4470a();
            }
        }

        C0896f(int i) {
            this.f2251a = i;
        }

        /* renamed from: a */
        public void mo4471a(C0884a aVar) {
            this.f2252b = aVar;
        }

        /* renamed from: b */
        public void mo4472b() {
            DrawerLayout.this.removeCallbacks(this.f2253c);
        }

        /* renamed from: b */
        public boolean mo4403b(int i) {
            return false;
        }

        /* renamed from: c */
        public void mo4405c(int i) {
            DrawerLayout.this.mo4414a(this.f2251a, i, this.f2252b.mo4383c());
        }

        /* renamed from: c */
        private void m3069c() {
            int i = 3;
            if (this.f2251a == 3) {
                i = 5;
            }
            View a = DrawerLayout.this.mo4411a(i);
            if (a != null) {
                DrawerLayout.this.mo4415a(a);
            }
        }

        /* renamed from: a */
        public void mo4399a(View view, int i, int i2, int i3, int i4) {
            float f;
            int width = view.getWidth();
            if (DrawerLayout.this.mo4420a(view, 3)) {
                f = (float) (i + width);
            } else {
                f = (float) (DrawerLayout.this.getWidth() - i);
            }
            float f2 = f / ((float) width);
            DrawerLayout.this.mo4431c(view, f2);
            view.setVisibility(f2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        /* renamed from: b */
        public boolean mo4404b(View view, int i) {
            return DrawerLayout.this.mo4445i(view) && DrawerLayout.this.mo4420a(view, this.f2251a) && DrawerLayout.this.mo4434d(view) == 0;
        }

        /* renamed from: b */
        public void mo4402b(int i, int i2) {
            DrawerLayout.this.postDelayed(this.f2253c, 160);
        }

        /* renamed from: b */
        public int mo4401b(View view, int i, int i2) {
            return view.getTop();
        }

        /* renamed from: a */
        public void mo4398a(View view, int i) {
            ((C0895e) view.getLayoutParams()).f2249c = false;
            m3069c();
        }

        /* renamed from: a */
        public void mo4397a(View view, float f, float f2) {
            int i;
            float f3 = DrawerLayout.this.mo4439f(view);
            int width = view.getWidth();
            if (DrawerLayout.this.mo4420a(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && f3 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && f3 > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.f2252b.mo4388d(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4470a() {
            View view;
            int i;
            int d = this.f2252b.mo4386d();
            int i2 = 0;
            boolean z = this.f2251a == 3;
            if (z) {
                view = DrawerLayout.this.mo4411a(3);
                if (view != null) {
                    i2 = -view.getWidth();
                }
                i = i2 + d;
            } else {
                view = DrawerLayout.this.mo4411a(5);
                i = DrawerLayout.this.getWidth() - d;
            }
            if (view == null) {
                return;
            }
            if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && DrawerLayout.this.mo4434d(view) == 0) {
                this.f2252b.mo4382b(view, i, view.getTop());
                ((C0895e) view.getLayoutParams()).f2249c = true;
                DrawerLayout.this.invalidate();
                m3069c();
                DrawerLayout.this.mo4412a();
            }
        }

        /* renamed from: a */
        public void mo4396a(int i, int i2) {
            View view;
            if ((i & 1) == 1) {
                view = DrawerLayout.this.mo4411a(3);
            } else {
                view = DrawerLayout.this.mo4411a(5);
            }
            if (view != null && DrawerLayout.this.mo4434d(view) == 0) {
                this.f2252b.mo4372a(view, i2);
            }
        }

        /* renamed from: a */
        public int mo4394a(View view) {
            if (DrawerLayout.this.mo4445i(view)) {
                return view.getWidth();
            }
            return 0;
        }

        /* renamed from: a */
        public int mo4395a(View view, int i, int i2) {
            if (DrawerLayout.this.mo4420a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }
    }

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 21) {
            z = false;
        }
        f2203M = z;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f2215c = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.f2221i = new C0896f(3);
        this.f2222j = new C0896f(5);
        C0884a a = C0884a.m2963a((ViewGroup) this, 1.0f, (C0884a.C0887c) this.f2221i);
        this.f2219g = a;
        a.mo4387d(1);
        this.f2219g.mo4370a(f2);
        this.f2221i.mo4471a(this.f2219g);
        C0884a a2 = C0884a.m2963a((ViewGroup) this, 1.0f, (C0884a.C0887c) this.f2222j);
        this.f2220h = a2;
        a2.mo4387d(2);
        this.f2220h.mo4370a(f2);
        this.f2222j.mo4471a(this.f2220h);
        setFocusableInTouchMode(true);
        C0839t.m2716f(this, 1);
        C0839t.m2697a((View) this, (C0797a) new C0892b());
        setMotionEventSplittingEnabled(false);
        if (C0839t.m2722k(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new C0891a());
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f2200J);
                try {
                    this.f2234v = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.f2234v = null;
            }
        }
        this.f2214b = f * 10.0f;
        this.f2210G = new ArrayList<>();
    }

    /* renamed from: g */
    private Drawable m3025g() {
        int n = C0839t.m2725n(this);
        if (n == 0) {
            Drawable drawable = this.f2206C;
            if (drawable != null) {
                m3018a(drawable, n);
                return this.f2206C;
            }
        } else {
            Drawable drawable2 = this.f2207D;
            if (drawable2 != null) {
                m3018a(drawable2, n);
                return this.f2207D;
            }
        }
        return this.f2208E;
    }

    /* renamed from: h */
    private Drawable m3026h() {
        int n = C0839t.m2725n(this);
        if (n == 0) {
            Drawable drawable = this.f2207D;
            if (drawable != null) {
                m3018a(drawable, n);
                return this.f2207D;
            }
        } else {
            Drawable drawable2 = this.f2206C;
            if (drawable2 != null) {
                m3018a(drawable2, n);
                return this.f2206C;
            }
        }
        return this.f2209F;
    }

    /* renamed from: i */
    private void m3027i() {
        if (!f2203M) {
            this.f2235w = m3025g();
            this.f2236x = m3026h();
        }
    }

    /* renamed from: l */
    private static boolean m3028l(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    /* renamed from: m */
    static boolean m3029m(View view) {
        return (C0839t.m2723l(view) == 4 || C0839t.m2723l(view) == 2) ? false : true;
    }

    /* renamed from: a */
    public void mo4418a(Object obj, boolean z) {
        this.f2204A = obj;
        this.f2205B = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (!mo4445i(childAt)) {
                    this.f2210G.add(childAt);
                } else if (mo4444h(childAt)) {
                    childAt.addFocusables(arrayList, i, i2);
                    z = true;
                }
            }
            if (!z) {
                int size = this.f2210G.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = this.f2210G.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.f2210G.clear();
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (mo4428c() != null || mo4445i(view)) {
            C0839t.m2716f(view, 4);
        } else {
            C0839t.m2716f(view, 1);
        }
        if (!f2202L) {
            C0839t.m2697a(view, (C0797a) this.f2213a);
        }
    }

    /* renamed from: b */
    public int mo4423b(int i) {
        int n = C0839t.m2725n(this);
        if (i == 3) {
            int i2 = this.f2226n;
            if (i2 != 3) {
                return i2;
            }
            int i3 = n == 0 ? this.f2228p : this.f2229q;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        } else if (i == 5) {
            int i4 = this.f2227o;
            if (i4 != 3) {
                return i4;
            }
            int i5 = n == 0 ? this.f2229q : this.f2228p;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        } else if (i == 8388611) {
            int i6 = this.f2228p;
            if (i6 != 3) {
                return i6;
            }
            int i7 = n == 0 ? this.f2226n : this.f2227o;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        } else if (i != 8388613) {
            return 0;
        } else {
            int i8 = this.f2229q;
            if (i8 != 3) {
                return i8;
            }
            int i9 = n == 0 ? this.f2227o : this.f2226n;
            if (i9 != 3) {
                return i9;
            }
            return 0;
        }
    }

    /* renamed from: c */
    public CharSequence mo4429c(int i) {
        int a = C0804c.m2545a(i, C0839t.m2725n(this));
        if (a == 3) {
            return this.f2237y;
        }
        if (a == 5) {
            return this.f2238z;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0895e) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((C0895e) getChildAt(i).getLayoutParams()).f2248b);
        }
        this.f2217e = f;
        boolean a = this.f2219g.mo4376a(true);
        boolean a2 = this.f2220h.mo4376a(true);
        if (a || a2) {
            C0839t.m2682A(this);
        }
    }

    /* renamed from: d */
    public int mo4434d(View view) {
        if (mo4445i(view)) {
            return mo4423b(((C0895e) view.getLayoutParams()).f2247a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f2217e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (m3017a(x, y, childAt) && !mo4440g(childAt) && m3019a(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean g = mo4440g(view2);
        int width = getWidth();
        int save = canvas.save();
        int i = 0;
        if (g) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view2 && childAt.getVisibility() == 0 && m3028l(childAt) && mo4445i(childAt) && childAt.getHeight() >= height) {
                    if (mo4420a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i = i2;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        float f = this.f2217e;
        if (f > 0.0f && g) {
            int i4 = this.f2216d;
            this.f2218f.setColor((i4 & 16777215) | (((int) (((float) ((-16777216 & i4) >>> 24)) * f)) << 24));
            canvas.drawRect((float) i, 0.0f, (float) width, (float) getHeight(), this.f2218f);
        } else if (this.f2235w != null && mo4420a(view2, 3)) {
            int intrinsicWidth = this.f2235w.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.f2219g.mo4386d()), 1.0f));
            this.f2235w.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f2235w.setAlpha((int) (max * 255.0f));
            this.f2235w.draw(canvas);
        } else if (this.f2236x != null && mo4420a(view2, 5)) {
            int intrinsicWidth2 = this.f2236x.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.f2220h.mo4386d()), 1.0f));
            this.f2236x.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f2236x.setAlpha((int) (max2 * 255.0f));
            this.f2236x.draw(canvas);
        }
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo4438e(View view) {
        return C0804c.m2545a(((C0895e) view.getLayoutParams()).f2247a, C0839t.m2725n(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public float mo4439f(View view) {
        return ((C0895e) view.getLayoutParams()).f2248b;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0895e(-1, -1);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C0895e) {
            return new C0895e((C0895e) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0895e((ViewGroup.MarginLayoutParams) layoutParams) : new C0895e(layoutParams);
    }

    /* renamed from: j */
    public boolean mo4446j(View view) {
        if (mo4445i(view)) {
            return ((C0895e) view.getLayoutParams()).f2248b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* renamed from: k */
    public void mo4447k(View view) {
        mo4427b(view, true);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2225m = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2225m = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r4.f2204A;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r5) {
        /*
            r4 = this;
            super.onDraw(r5)
            boolean r0 = r4.f2205B
            if (r0 == 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r4.f2234v
            if (r0 == 0) goto L_0x002e
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            r2 = 0
            if (r0 < r1) goto L_0x001d
            java.lang.Object r0 = r4.f2204A
            if (r0 == 0) goto L_0x001d
            android.view.WindowInsets r0 = (android.view.WindowInsets) r0
            int r0 = r0.getSystemWindowInsetTop()
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r1 = r4.f2234v
            int r3 = r4.getWidth()
            r1.setBounds(r2, r2, r3, r0)
            android.graphics.drawable.Drawable r0 = r4.f2234v
            r0.draw(r5)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onDraw(android.graphics.Canvas):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004b, code lost:
        r7 = r6.f2219g.mo4377b((int) r0, (int) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 != 3) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.a.a r1 = r6.f2219g
            boolean r1 = r1.mo4380b((android.view.MotionEvent) r7)
            androidx.customview.a.a r2 = r6.f2220h
            boolean r2 = r2.mo4380b((android.view.MotionEvent) r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0038
            if (r0 == r2) goto L_0x0031
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L_0x001e
            if (r0 == r4) goto L_0x0031
            goto L_0x0036
        L_0x001e:
            androidx.customview.a.a r7 = r6.f2219g
            boolean r7 = r7.mo4373a((int) r4)
            if (r7 == 0) goto L_0x0036
            androidx.drawerlayout.widget.DrawerLayout$f r7 = r6.f2221i
            r7.mo4472b()
            androidx.drawerlayout.widget.DrawerLayout$f r7 = r6.f2222j
            r7.mo4472b()
            goto L_0x0036
        L_0x0031:
            r6.mo4419a((boolean) r2)
            r6.f2230r = r3
        L_0x0036:
            r7 = 0
            goto L_0x0060
        L_0x0038:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f2232t = r0
            r6.f2233u = r7
            float r4 = r6.f2217e
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x005d
            androidx.customview.a.a r4 = r6.f2219g
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.mo4377b((int) r0, (int) r7)
            if (r7 == 0) goto L_0x005d
            boolean r7 = r6.mo4440g(r7)
            if (r7 == 0) goto L_0x005d
            r7 = 1
            goto L_0x005e
        L_0x005d:
            r7 = 0
        L_0x005e:
            r6.f2230r = r3
        L_0x0060:
            if (r1 != 0) goto L_0x0070
            if (r7 != 0) goto L_0x0070
            boolean r7 = r6.m3023e()
            if (r7 != 0) goto L_0x0070
            boolean r7 = r6.f2230r
            if (r7 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = 0
        L_0x0070:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m3024f()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View d = mo4435d();
        if (d != null && mo4434d(d) == 0) {
            mo4424b();
        }
        return d != null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        this.f2224l = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                C0895e eVar = (C0895e) childAt.getLayoutParams();
                if (mo4440g(childAt)) {
                    int i8 = eVar.leftMargin;
                    childAt.layout(i8, eVar.topMargin, childAt.getMeasuredWidth() + i8, eVar.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (mo4420a(childAt, 3)) {
                        float f2 = (float) measuredWidth;
                        i5 = (-measuredWidth) + ((int) (eVar.f2248b * f2));
                        f = ((float) (measuredWidth + i5)) / f2;
                    } else {
                        float f3 = (float) measuredWidth;
                        int i9 = i6 - ((int) (eVar.f2248b * f3));
                        f = ((float) (i6 - i9)) / f3;
                        i5 = i9;
                    }
                    boolean z2 = f != eVar.f2248b;
                    int i10 = eVar.f2247a & 112;
                    if (i10 == 16) {
                        int i11 = i4 - i2;
                        int i12 = (i11 - measuredHeight) / 2;
                        int i13 = eVar.topMargin;
                        if (i12 < i13) {
                            i12 = i13;
                        } else {
                            int i14 = i12 + measuredHeight;
                            int i15 = eVar.bottomMargin;
                            if (i14 > i11 - i15) {
                                i12 = (i11 - i15) - measuredHeight;
                            }
                        }
                        childAt.layout(i5, i12, measuredWidth + i5, measuredHeight + i12);
                    } else if (i10 != 80) {
                        int i16 = eVar.topMargin;
                        childAt.layout(i5, i16, measuredWidth + i5, measuredHeight + i16);
                    } else {
                        int i17 = i4 - i2;
                        childAt.layout(i5, (i17 - eVar.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i17 - eVar.bottomMargin);
                    }
                    if (z2) {
                        mo4431c(childAt, f);
                    }
                    int i18 = eVar.f2248b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i18) {
                        childAt.setVisibility(i18);
                    }
                }
            }
        }
        this.f2224l = false;
        this.f2225m = false;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = AdMost.AD_ERROR_FREQ_CAP;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    size2 = AdMost.AD_ERROR_FREQ_CAP;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        int i3 = 0;
        boolean z = this.f2204A != null && C0839t.m2722k(this);
        int n = C0839t.m2725n(this);
        int childCount = getChildCount();
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                C0895e eVar = (C0895e) childAt.getLayoutParams();
                if (z) {
                    int a = C0804c.m2545a(eVar.f2247a, n);
                    if (C0839t.m2722k(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.f2204A;
                            if (a == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i3, windowInsets.getSystemWindowInsetBottom());
                            } else if (a == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i3, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.f2204A;
                        if (a == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i3, windowInsets2.getSystemWindowInsetBottom());
                        } else if (a == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i3, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        eVar.leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        eVar.topMargin = windowInsets2.getSystemWindowInsetTop();
                        eVar.rightMargin = windowInsets2.getSystemWindowInsetRight();
                        eVar.bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (mo4440g(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - eVar.leftMargin) - eVar.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - eVar.topMargin) - eVar.bottomMargin, 1073741824));
                } else if (mo4445i(childAt)) {
                    if (f2203M) {
                        float j = C0839t.m2721j(childAt);
                        float f = this.f2214b;
                        if (j != f) {
                            C0839t.m2689a(childAt, f);
                        }
                    }
                    int e = mo4438e(childAt) & 7;
                    boolean z4 = e == 3;
                    if ((!z4 || !z2) && (z4 || !z3)) {
                        if (z4) {
                            z2 = true;
                        } else {
                            z3 = true;
                        }
                        childAt.measure(ViewGroup.getChildMeasureSpec(i, this.f2215c + eVar.leftMargin + eVar.rightMargin, eVar.width), ViewGroup.getChildMeasureSpec(i2, eVar.topMargin + eVar.bottomMargin, eVar.height));
                        i4++;
                        i3 = 0;
                    } else {
                        throw new IllegalStateException("Child drawer has absolute gravity " + m3022d(e) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
                    }
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i4 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            int i5 = i;
            int i6 = i2;
            i4++;
            i3 = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        View a;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mo4406a());
        int i = savedState.f2239c;
        if (!(i == 0 || (a = mo4411a(i)) == null)) {
            mo4447k(a);
        }
        int i2 = savedState.f2240d;
        if (i2 != 3) {
            mo4413a(i2, 3);
        }
        int i3 = savedState.f2241e;
        if (i3 != 3) {
            mo4413a(i3, 5);
        }
        int i4 = savedState.f2242f;
        if (i4 != 3) {
            mo4413a(i4, 8388611);
        }
        int i5 = savedState.f2243g;
        if (i5 != 3) {
            mo4413a(i5, 8388613);
        }
    }

    public void onRtlPropertiesChanged(int i) {
        m3027i();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            C0895e eVar = (C0895e) getChildAt(i).getLayoutParams();
            boolean z = true;
            boolean z2 = eVar.f2250d == 1;
            if (eVar.f2250d != 2) {
                z = false;
            }
            if (z2 || z) {
                savedState.f2239c = eVar.f2247a;
            } else {
                i++;
            }
        }
        savedState.f2240d = this.f2226n;
        savedState.f2241e = this.f2227o;
        savedState.f2242f = this.f2228p;
        savedState.f2243g = this.f2229q;
        return savedState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
        if (mo4434d(r7) != 2) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.a.a r0 = r6.f2219g
            r0.mo4371a((android.view.MotionEvent) r7)
            androidx.customview.a.a r0 = r6.f2220h
            r0.mo4371a((android.view.MotionEvent) r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0062
            if (r0 == r2) goto L_0x0020
            r7 = 3
            if (r0 == r7) goto L_0x001a
            goto L_0x0070
        L_0x001a:
            r6.mo4419a((boolean) r2)
            r6.f2230r = r1
            goto L_0x0070
        L_0x0020:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.a.a r3 = r6.f2219g
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.mo4377b((int) r4, (int) r5)
            if (r3 == 0) goto L_0x005d
            boolean r3 = r6.mo4440g(r3)
            if (r3 == 0) goto L_0x005d
            float r3 = r6.f2232t
            float r0 = r0 - r3
            float r3 = r6.f2233u
            float r7 = r7 - r3
            androidx.customview.a.a r3 = r6.f2219g
            int r3 = r3.mo4389e()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x005d
            android.view.View r7 = r6.mo4428c()
            if (r7 == 0) goto L_0x005d
            int r7 = r6.mo4434d((android.view.View) r7)
            r0 = 2
            if (r7 != r0) goto L_0x005e
        L_0x005d:
            r1 = 1
        L_0x005e:
            r6.mo4419a((boolean) r1)
            goto L_0x0070
        L_0x0062:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f2232t = r0
            r6.f2233u = r7
            r6.f2230r = r1
        L_0x0070:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            mo4419a(true);
        }
    }

    public void requestLayout() {
        if (!this.f2224l) {
            super.requestLayout();
        }
    }

    /* renamed from: f */
    private boolean m3024f() {
        return mo4435d() != null;
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0895e(getContext(), attributeSet);
    }

    /* renamed from: e */
    private boolean m3023e() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((C0895e) getChildAt(i).getLayoutParams()).f2249c) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo4445i(View view) {
        int a = C0804c.m2545a(((C0895e) view.getLayoutParams()).f2247a, C0839t.m2725n(view));
        return ((a & 3) == 0 && (a & 5) == 0) ? false : true;
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$e */
    public static class C0895e extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f2247a = 0;

        /* renamed from: b */
        float f2248b;

        /* renamed from: c */
        boolean f2249c;

        /* renamed from: d */
        int f2250d;

        public C0895e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f2201K);
            this.f2247a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public C0895e(int i, int i2) {
            super(i, i2);
        }

        public C0895e(C0895e eVar) {
            super(eVar);
            this.f2247a = eVar.f2247a;
        }

        public C0895e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0895e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* renamed from: d */
    static String m3022d(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        return (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    /* renamed from: a */
    public void mo4413a(int i, int i2) {
        View a;
        int a2 = C0804c.m2545a(i2, C0839t.m2725n(this));
        if (i2 == 3) {
            this.f2226n = i;
        } else if (i2 == 5) {
            this.f2227o = i;
        } else if (i2 == 8388611) {
            this.f2228p = i;
        } else if (i2 == 8388613) {
            this.f2229q = i;
        }
        if (i != 0) {
            (a2 == 3 ? this.f2219g : this.f2220h).mo4378b();
        }
        if (i == 1) {
            View a3 = mo4411a(a2);
            if (a3 != null) {
                mo4415a(a3);
            }
        } else if (i == 2 && (a = mo4411a(a2)) != null) {
            mo4447k(a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4430c(View view) {
        C0895e eVar = (C0895e) view.getLayoutParams();
        if ((eVar.f2250d & 1) == 0) {
            eVar.f2250d = 1;
            List<C0894d> list = this.f2231s;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2231s.get(size).mo4467a(view);
                }
            }
            m3021c(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public View mo4435d() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (mo4445i(childAt) && mo4446j(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0890a();

        /* renamed from: c */
        int f2239c = 0;

        /* renamed from: d */
        int f2240d;

        /* renamed from: e */
        int f2241e;

        /* renamed from: f */
        int f2242f;

        /* renamed from: g */
        int f2243g;

        /* renamed from: androidx.drawerlayout.widget.DrawerLayout$SavedState$a */
        static class C0890a implements Parcelable.ClassLoaderCreator<SavedState> {
            C0890a() {
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
            this.f2239c = parcel.readInt();
            this.f2240d = parcel.readInt();
            this.f2241e = parcel.readInt();
            this.f2242f = parcel.readInt();
            this.f2243g = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2239c);
            parcel.writeInt(this.f2240d);
            parcel.writeInt(this.f2241e);
            parcel.writeInt(this.f2242f);
            parcel.writeInt(this.f2243g);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo4440g(View view) {
        return ((C0895e) view.getLayoutParams()).f2247a == 0;
    }

    /* renamed from: h */
    public boolean mo4444h(View view) {
        if (mo4445i(view)) {
            return (((C0895e) view.getLayoutParams()).f2250d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* renamed from: b */
    private MotionEvent m3020b(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation((float) (getScrollX() - view.getLeft()), (float) (getScrollY() - view.getTop()));
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.f2212I == null) {
                this.f2212I = new Matrix();
            }
            matrix.invert(this.f2212I);
            obtain.transform(this.f2212I);
        }
        return obtain;
    }

    /* renamed from: c */
    private void m3021c(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || mo4445i(childAt)) && (!z || childAt != view)) {
                C0839t.m2716f(childAt, 4);
            } else {
                C0839t.m2716f(childAt, 1);
            }
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$b */
    class C0892b extends C0797a {

        /* renamed from: d */
        private final Rect f2245d = new Rect();

        C0892b() {
        }

        /* renamed from: a */
        public void mo4080a(View view, C0807c cVar) {
            if (DrawerLayout.f2202L) {
                super.mo4080a(view, cVar);
            } else {
                C0807c a = C0807c.m2551a(cVar);
                super.mo4080a(view, a);
                cVar.mo4129c(view);
                ViewParent q = C0839t.m2728q(view);
                if (q instanceof View) {
                    cVar.mo4122b((View) q);
                }
                m3059a(cVar, a);
                a.mo4164v();
                m3058a(cVar, (ViewGroup) view);
            }
            cVar.mo4114a((CharSequence) DrawerLayout.class.getName());
            cVar.mo4137e(false);
            cVar.mo4140f(false);
            cVar.mo4126b(C0807c.C0808a.f2017d);
            cVar.mo4126b(C0807c.C0808a.f2018e);
        }

        /* renamed from: b */
        public void mo4084b(View view, AccessibilityEvent accessibilityEvent) {
            super.mo4084b(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        /* renamed from: a */
        public boolean mo4082a(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence c;
            if (accessibilityEvent.getEventType() != 32) {
                return super.mo4082a(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View d = DrawerLayout.this.mo4435d();
            if (d == null || (c = DrawerLayout.this.mo4429c(DrawerLayout.this.mo4438e(d))) == null) {
                return true;
            }
            text.add(c);
            return true;
        }

        /* renamed from: a */
        public boolean mo4083a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f2202L || DrawerLayout.m3029m(view)) {
                return super.mo4083a(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        /* renamed from: a */
        private void m3058a(C0807c cVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.m3029m(childAt)) {
                    cVar.mo4112a(childAt);
                }
            }
        }

        /* renamed from: a */
        private void m3059a(C0807c cVar, C0807c cVar2) {
            Rect rect = this.f2245d;
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
        }
    }

    /* renamed from: a */
    private boolean m3017a(float f, float f2, View view) {
        if (this.f2211H == null) {
            this.f2211H = new Rect();
        }
        view.getHitRect(this.f2211H);
        return this.f2211H.contains((int) f, (int) f2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4431c(View view, float f) {
        C0895e eVar = (C0895e) view.getLayoutParams();
        if (f != eVar.f2248b) {
            eVar.f2248b = f;
            mo4416a(view, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4425b(View view) {
        View rootView;
        C0895e eVar = (C0895e) view.getLayoutParams();
        if ((eVar.f2250d & 1) == 1) {
            eVar.f2250d = 0;
            List<C0894d> list = this.f2231s;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2231s.get(size).mo4469b(view);
                }
            }
            m3021c(view, false);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    /* renamed from: a */
    private boolean m3019a(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent b = m3020b(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(b);
            b.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = (float) (getScrollX() - view.getLeft());
        float scrollY = (float) (getScrollY() - view.getTop());
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public View mo4428c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((C0895e) childAt.getLayoutParams()).f2250d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4426b(View view, float f) {
        float f2 = mo4439f(view);
        float width = (float) view.getWidth();
        int i = ((int) (width * f)) - ((int) (f2 * width));
        if (!mo4420a(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        mo4431c(view, f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4414a(int i, int i2, View view) {
        int f = this.f2219g.mo4390f();
        int f2 = this.f2220h.mo4390f();
        int i3 = 2;
        if (f == 1 || f2 == 1) {
            i3 = 1;
        } else if (!(f == 2 || f2 == 2)) {
            i3 = 0;
        }
        if (view != null && i2 == 0) {
            float f3 = ((C0895e) view.getLayoutParams()).f2248b;
            if (f3 == 0.0f) {
                mo4425b(view);
            } else if (f3 == 1.0f) {
                mo4430c(view);
            }
        }
        if (i3 != this.f2223k) {
            this.f2223k = i3;
            List<C0894d> list = this.f2231s;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2231s.get(size).mo4466a(i3);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo4424b() {
        mo4419a(false);
    }

    /* renamed from: b */
    public void mo4427b(View view, boolean z) {
        if (mo4445i(view)) {
            C0895e eVar = (C0895e) view.getLayoutParams();
            if (this.f2225m) {
                eVar.f2248b = 1.0f;
                eVar.f2250d = 1;
                m3021c(view, true);
            } else if (z) {
                eVar.f2250d |= 2;
                if (mo4420a(view, 3)) {
                    this.f2219g.mo4382b(view, 0, view.getTop());
                } else {
                    this.f2220h.mo4382b(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                mo4426b(view, 1.0f);
                mo4414a(eVar.f2247a, 0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4416a(View view, float f) {
        List<C0894d> list = this.f2231s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f2231s.get(size).mo4468a(view, f);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4420a(View view, int i) {
        return (mo4438e(view) & i) == i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo4411a(int i) {
        int a = C0804c.m2545a(i, C0839t.m2725n(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((mo4438e(childAt) & 7) == a) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m3018a(Drawable drawable, int i) {
        if (drawable == null || !C0857a.m2815e(drawable)) {
            return false;
        }
        C0857a.m2810a(drawable, i);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4419a(boolean z) {
        boolean z2;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0895e eVar = (C0895e) childAt.getLayoutParams();
            if (mo4445i(childAt) && (!z || eVar.f2249c)) {
                int width = childAt.getWidth();
                if (mo4420a(childAt, 3)) {
                    z2 = this.f2219g.mo4382b(childAt, -width, childAt.getTop());
                } else {
                    z2 = this.f2220h.mo4382b(childAt, getWidth(), childAt.getTop());
                }
                z3 |= z2;
                eVar.f2249c = false;
            }
        }
        this.f2221i.mo4472b();
        this.f2222j.mo4472b();
        if (z3) {
            invalidate();
        }
    }

    /* renamed from: a */
    public void mo4415a(View view) {
        mo4417a(view, true);
    }

    /* renamed from: a */
    public void mo4417a(View view, boolean z) {
        if (mo4445i(view)) {
            C0895e eVar = (C0895e) view.getLayoutParams();
            if (this.f2225m) {
                eVar.f2248b = 0.0f;
                eVar.f2250d = 0;
            } else if (z) {
                eVar.f2250d |= 4;
                if (mo4420a(view, 3)) {
                    this.f2219g.mo4382b(view, -view.getWidth(), view.getTop());
                } else {
                    this.f2220h.mo4382b(view, getWidth(), view.getTop());
                }
            } else {
                mo4426b(view, 0.0f);
                mo4414a(eVar.f2247a, 0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4412a() {
        if (!this.f2230r) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.f2230r = true;
        }
    }
}
