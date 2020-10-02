package androidx.customview.p023a;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.p020f.C0839t;
import java.util.Arrays;

/* renamed from: androidx.customview.a.a */
/* compiled from: ViewDragHelper */
public class C0884a {

    /* renamed from: w */
    private static final Interpolator f2174w = new C0885a();

    /* renamed from: a */
    private int f2175a;

    /* renamed from: b */
    private int f2176b;

    /* renamed from: c */
    private int f2177c = -1;

    /* renamed from: d */
    private float[] f2178d;

    /* renamed from: e */
    private float[] f2179e;

    /* renamed from: f */
    private float[] f2180f;

    /* renamed from: g */
    private float[] f2181g;

    /* renamed from: h */
    private int[] f2182h;

    /* renamed from: i */
    private int[] f2183i;

    /* renamed from: j */
    private int[] f2184j;

    /* renamed from: k */
    private int f2185k;

    /* renamed from: l */
    private VelocityTracker f2186l;

    /* renamed from: m */
    private float f2187m;

    /* renamed from: n */
    private float f2188n;

    /* renamed from: o */
    private int f2189o;

    /* renamed from: p */
    private int f2190p;

    /* renamed from: q */
    private OverScroller f2191q;

    /* renamed from: r */
    private final C0887c f2192r;

    /* renamed from: s */
    private View f2193s;

    /* renamed from: t */
    private boolean f2194t;

    /* renamed from: u */
    private final ViewGroup f2195u;

    /* renamed from: v */
    private final Runnable f2196v = new C0886b();

    /* renamed from: androidx.customview.a.a$a */
    /* compiled from: ViewDragHelper */
    static class C0885a implements Interpolator {
        C0885a() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* renamed from: androidx.customview.a.a$b */
    /* compiled from: ViewDragHelper */
    class C0886b implements Runnable {
        C0886b() {
        }

        public void run() {
            C0884a.this.mo4384c(0);
        }
    }

    /* renamed from: androidx.customview.a.a$c */
    /* compiled from: ViewDragHelper */
    public static abstract class C0887c {
        /* renamed from: a */
        public int mo4393a(int i) {
            return i;
        }

        /* renamed from: a */
        public int mo4394a(View view) {
            return 0;
        }

        /* renamed from: a */
        public abstract int mo4395a(View view, int i, int i2);

        /* renamed from: a */
        public void mo4396a(int i, int i2) {
        }

        /* renamed from: a */
        public abstract void mo4397a(View view, float f, float f2);

        /* renamed from: a */
        public void mo4398a(View view, int i) {
        }

        /* renamed from: a */
        public void mo4399a(View view, int i, int i2, int i3, int i4) {
        }

        /* renamed from: b */
        public int mo4400b(View view) {
            return 0;
        }

        /* renamed from: b */
        public abstract int mo4401b(View view, int i, int i2);

        /* renamed from: b */
        public void mo4402b(int i, int i2) {
        }

        /* renamed from: b */
        public boolean mo4403b(int i) {
            return false;
        }

        /* renamed from: b */
        public abstract boolean mo4404b(View view, int i);

        /* renamed from: c */
        public void mo4405c(int i) {
        }
    }

    private C0884a(Context context, ViewGroup viewGroup, C0887c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (cVar != null) {
            this.f2195u = viewGroup;
            this.f2192r = cVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f2189o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f2176b = viewConfiguration.getScaledTouchSlop();
            this.f2187m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f2188n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f2191q = new OverScroller(context, f2174w);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    /* renamed from: a */
    public static C0884a m2964a(ViewGroup viewGroup, C0887c cVar) {
        return new C0884a(viewGroup.getContext(), viewGroup, cVar);
    }

    /* renamed from: g */
    private void m2978g() {
        float[] fArr = this.f2178d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f2179e, 0.0f);
            Arrays.fill(this.f2180f, 0.0f);
            Arrays.fill(this.f2181g, 0.0f);
            Arrays.fill(this.f2182h, 0);
            Arrays.fill(this.f2183i, 0);
            Arrays.fill(this.f2184j, 0);
            this.f2185k = 0;
        }
    }

    /* renamed from: h */
    private void m2980h() {
        this.f2186l.computeCurrentVelocity(1000, this.f2187m);
        m2965a(m2960a(this.f2186l.getXVelocity(this.f2177c), this.f2188n, this.f2187m), m2960a(this.f2186l.getYVelocity(this.f2177c), this.f2188n, this.f2187m));
    }

    /* renamed from: b */
    public void mo4378b() {
        this.f2177c = -1;
        m2978g();
        VelocityTracker velocityTracker = this.f2186l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2186l = null;
        }
    }

    /* renamed from: c */
    public View mo4383c() {
        return this.f2193s;
    }

    /* renamed from: d */
    public void mo4387d(int i) {
        this.f2190p = i;
    }

    /* renamed from: e */
    public int mo4389e() {
        return this.f2176b;
    }

    /* renamed from: f */
    public int mo4390f() {
        return this.f2175a;
    }

    /* renamed from: a */
    public static C0884a m2963a(ViewGroup viewGroup, float f, C0887c cVar) {
        C0884a a = m2964a(viewGroup, cVar);
        a.f2176b = (int) (((float) a.f2176b) * (1.0f / f));
        return a;
    }

    /* renamed from: c */
    private void m2974c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (m2979g(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f2180f[pointerId] = x;
                this.f2181g[pointerId] = y;
            }
        }
    }

    /* renamed from: e */
    private void m2976e(int i) {
        if (this.f2178d != null && mo4379b(i)) {
            this.f2178d[i] = 0.0f;
            this.f2179e[i] = 0.0f;
            this.f2180f[i] = 0.0f;
            this.f2181g[i] = 0.0f;
            this.f2182h[i] = 0;
            this.f2183i[i] = 0;
            this.f2184j[i] = 0;
            this.f2185k = ((1 << i) ^ -1) & this.f2185k;
        }
    }

    /* renamed from: f */
    private void m2977f(int i) {
        float[] fArr = this.f2178d;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            float[] fArr6 = this.f2178d;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.f2179e;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.f2180f;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.f2181g;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.f2182h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f2183i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f2184j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f2178d = fArr2;
            this.f2179e = fArr3;
            this.f2180f = fArr4;
            this.f2181g = fArr5;
            this.f2182h = iArr;
            this.f2183i = iArr2;
            this.f2184j = iArr3;
        }
    }

    /* renamed from: d */
    public int mo4386d() {
        return this.f2189o;
    }

    /* renamed from: d */
    public boolean mo4388d(int i, int i2) {
        if (this.f2194t) {
            return m2973b(i, i2, (int) this.f2186l.getXVelocity(this.f2177c), (int) this.f2186l.getYVelocity(this.f2177c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* renamed from: a */
    public void mo4370a(float f) {
        this.f2188n = f;
    }

    /* renamed from: a */
    public void mo4372a(View view, int i) {
        if (view.getParent() == this.f2195u) {
            this.f2193s = view;
            this.f2177c = i;
            this.f2192r.mo4398a(view, i);
            mo4384c(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f2195u + ")");
    }

    /* renamed from: b */
    public boolean mo4382b(View view, int i, int i2) {
        this.f2193s = view;
        this.f2177c = -1;
        boolean b = m2973b(i, i2, 0, 0);
        if (!b && this.f2175a == 0 && this.f2193s != null) {
            this.f2193s = null;
        }
        return b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4384c(int i) {
        this.f2195u.removeCallbacks(this.f2196v);
        if (this.f2175a != i) {
            this.f2175a = i;
            this.f2192r.mo4405c(i);
            if (this.f2175a == 0) {
                this.f2193s = null;
            }
        }
    }

    /* renamed from: g */
    private boolean m2979g(int i) {
        if (mo4379b(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    /* renamed from: b */
    private boolean m2973b(int i, int i2, int i3, int i4) {
        int left = this.f2193s.getLeft();
        int top = this.f2193s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f2191q.abortAnimation();
            mo4384c(0);
            return false;
        }
        this.f2191q.startScroll(left, top, i5, i6, m2962a(this.f2193s, i5, i6, i3, i4));
        mo4384c(2);
        return true;
    }

    /* renamed from: e */
    private int m2975e(int i, int i2) {
        int i3 = i < this.f2195u.getLeft() + this.f2189o ? 1 : 0;
        if (i2 < this.f2195u.getTop() + this.f2189o) {
            i3 |= 4;
        }
        if (i > this.f2195u.getRight() - this.f2189o) {
            i3 |= 2;
        }
        return i2 > this.f2195u.getBottom() - this.f2189o ? i3 | 8 : i3;
    }

    /* renamed from: a */
    public void mo4369a() {
        mo4378b();
        if (this.f2175a == 2) {
            int currX = this.f2191q.getCurrX();
            int currY = this.f2191q.getCurrY();
            this.f2191q.abortAnimation();
            int currX2 = this.f2191q.getCurrX();
            int currY2 = this.f2191q.getCurrY();
            this.f2192r.mo4399a(this.f2193s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        mo4384c(0);
    }

    /* renamed from: c */
    public boolean mo4385c(int i, int i2) {
        return mo4375a(this.f2193s, i, i2);
    }

    /* renamed from: b */
    private int m2971b(int i, int i2, int i3) {
        int i4;
        if (i == 0) {
            return 0;
        }
        int width = this.f2195u.getWidth();
        float f = (float) (width / 2);
        float b = f + (m2970b(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * f);
        int abs = Math.abs(i2);
        if (abs > 0) {
            i4 = Math.round(Math.abs(b / ((float) abs)) * 1000.0f) * 4;
        } else {
            i4 = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(i4, 600);
    }

    /* renamed from: a */
    private int m2962a(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int a = m2961a(i3, (int) this.f2188n, (int) this.f2187m);
        int a2 = m2961a(i4, (int) this.f2188n, (int) this.f2187m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(a);
        int abs4 = Math.abs(a2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (a != 0) {
            f2 = (float) abs3;
            f = (float) i5;
        } else {
            f2 = (float) abs;
            f = (float) i6;
        }
        float f5 = f2 / f;
        if (a2 != 0) {
            f4 = (float) abs4;
            f3 = (float) i5;
        } else {
            f4 = (float) abs2;
            f3 = (float) i6;
        }
        float f6 = f4 / f3;
        return (int) ((((float) m2971b(i, a, this.f2192r.mo4394a(view))) * f5) + (((float) m2971b(i2, a2, this.f2192r.mo4400b(view))) * f6));
    }

    /* renamed from: b */
    private float m2970b(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    /* renamed from: b */
    private void m2972b(float f, float f2, int i) {
        m2977f(i);
        float[] fArr = this.f2178d;
        this.f2180f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f2179e;
        this.f2181g[i] = f2;
        fArr2[i] = f2;
        this.f2182h[i] = m2975e((int) f, (int) f2);
        this.f2185k |= 1 << i;
    }

    /* renamed from: a */
    private int m2961a(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs > i3) {
            return i > 0 ? i3 : -i3;
        }
        return i;
    }

    /* renamed from: a */
    private float m2960a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs > f3) {
            return f > 0.0f ? f3 : -f3;
        }
        return f;
    }

    /* renamed from: a */
    public boolean mo4376a(boolean z) {
        if (this.f2175a == 2) {
            boolean computeScrollOffset = this.f2191q.computeScrollOffset();
            int currX = this.f2191q.getCurrX();
            int currY = this.f2191q.getCurrY();
            int left = currX - this.f2193s.getLeft();
            int top = currY - this.f2193s.getTop();
            if (left != 0) {
                C0839t.m2712d(this.f2193s, left);
            }
            if (top != 0) {
                C0839t.m2714e(this.f2193s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f2192r.mo4399a(this.f2193s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f2191q.getFinalX() && currY == this.f2191q.getFinalY()) {
                this.f2191q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.f2195u.post(this.f2196v);
                } else {
                    mo4384c(0);
                }
            }
        }
        if (this.f2175a == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo4379b(int i) {
        return ((1 << i) & this.f2185k) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo4381b(View view, int i) {
        if (view == this.f2193s && this.f2177c == i) {
            return true;
        }
        if (view == null || !this.f2192r.mo4404b(view, i)) {
            return false;
        }
        this.f2177c = i;
        mo4372a(view, i);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r12 != r11) goto L_0x00e6;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo4380b(android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r17.getActionMasked()
            int r3 = r17.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r16.mo4378b()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.f2186l
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f2186l = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.f2186l
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0104
            if (r2 == r6) goto L_0x00ff
            if (r2 == r4) goto L_0x0070
            r7 = 3
            if (r2 == r7) goto L_0x00ff
            r7 = 5
            if (r2 == r7) goto L_0x003c
            r4 = 6
            if (r2 == r4) goto L_0x0034
        L_0x0031:
            r5 = 0
            goto L_0x0135
        L_0x0034:
            int r1 = r1.getPointerId(r3)
            r0.m2976e(r1)
            goto L_0x0031
        L_0x003c:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.m2972b((float) r7, (float) r1, (int) r2)
            int r3 = r0.f2175a
            if (r3 != 0) goto L_0x0060
            int[] r1 = r0.f2182h
            r1 = r1[r2]
            int r3 = r0.f2190p
            r4 = r1 & r3
            if (r4 == 0) goto L_0x0031
            androidx.customview.a.a$c r4 = r0.f2192r
            r1 = r1 & r3
            r4.mo4402b((int) r1, (int) r2)
            goto L_0x0031
        L_0x0060:
            if (r3 != r4) goto L_0x0031
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.mo4377b((int) r3, (int) r1)
            android.view.View r3 = r0.f2193s
            if (r1 != r3) goto L_0x0031
            r0.mo4381b((android.view.View) r1, (int) r2)
            goto L_0x0031
        L_0x0070:
            float[] r2 = r0.f2178d
            if (r2 == 0) goto L_0x0031
            float[] r2 = r0.f2179e
            if (r2 != 0) goto L_0x0079
            goto L_0x0031
        L_0x0079:
            int r2 = r17.getPointerCount()
            r3 = 0
        L_0x007e:
            if (r3 >= r2) goto L_0x00fa
            int r4 = r1.getPointerId(r3)
            boolean r7 = r0.m2979g(r4)
            if (r7 != 0) goto L_0x008c
            goto L_0x00f7
        L_0x008c:
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.f2178d
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.f2179e
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.mo4377b((int) r7, (int) r8)
            if (r7 == 0) goto L_0x00b0
            boolean r8 = r0.m2969a((android.view.View) r7, (float) r9, (float) r10)
            if (r8 == 0) goto L_0x00b0
            r8 = 1
            goto L_0x00b1
        L_0x00b0:
            r8 = 0
        L_0x00b1:
            if (r8 == 0) goto L_0x00e6
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r13 = r11 + r12
            androidx.customview.a.a$c r14 = r0.f2192r
            int r12 = r14.mo4395a((android.view.View) r7, (int) r13, (int) r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r15 = r13 + r14
            androidx.customview.a.a$c r5 = r0.f2192r
            int r5 = r5.mo4401b(r7, r15, r14)
            androidx.customview.a.a$c r14 = r0.f2192r
            int r14 = r14.mo4394a((android.view.View) r7)
            androidx.customview.a.a$c r15 = r0.f2192r
            int r15 = r15.mo4400b((android.view.View) r7)
            if (r14 == 0) goto L_0x00df
            if (r14 <= 0) goto L_0x00e6
            if (r12 != r11) goto L_0x00e6
        L_0x00df:
            if (r15 == 0) goto L_0x00fa
            if (r15 <= 0) goto L_0x00e6
            if (r5 != r13) goto L_0x00e6
            goto L_0x00fa
        L_0x00e6:
            r0.m2966a((float) r9, (float) r10, (int) r4)
            int r5 = r0.f2175a
            if (r5 != r6) goto L_0x00ee
            goto L_0x00fa
        L_0x00ee:
            if (r8 == 0) goto L_0x00f7
            boolean r4 = r0.mo4381b((android.view.View) r7, (int) r4)
            if (r4 == 0) goto L_0x00f7
            goto L_0x00fa
        L_0x00f7:
            int r3 = r3 + 1
            goto L_0x007e
        L_0x00fa:
            r16.m2974c((android.view.MotionEvent) r17)
            goto L_0x0031
        L_0x00ff:
            r16.mo4378b()
            goto L_0x0031
        L_0x0104:
            float r2 = r17.getX()
            float r3 = r17.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.m2972b((float) r2, (float) r3, (int) r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.mo4377b((int) r2, (int) r3)
            android.view.View r3 = r0.f2193s
            if (r2 != r3) goto L_0x0125
            int r3 = r0.f2175a
            if (r3 != r4) goto L_0x0125
            r0.mo4381b((android.view.View) r2, (int) r1)
        L_0x0125:
            int[] r2 = r0.f2182h
            r2 = r2[r1]
            int r3 = r0.f2190p
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0135
            androidx.customview.a.a$c r4 = r0.f2192r
            r2 = r2 & r3
            r4.mo4402b((int) r2, (int) r1)
        L_0x0135:
            int r1 = r0.f2175a
            if (r1 != r6) goto L_0x013a
            r5 = 1
        L_0x013a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.p023a.C0884a.mo4380b(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    private void m2965a(float f, float f2) {
        this.f2194t = true;
        this.f2192r.mo4397a(this.f2193s, f, f2);
        this.f2194t = false;
        if (this.f2175a == 1) {
            mo4384c(0);
        }
    }

    /* renamed from: a */
    public void mo4371a(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            mo4378b();
        }
        if (this.f2186l == null) {
            this.f2186l = VelocityTracker.obtain();
        }
        this.f2186l.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View b = mo4377b((int) x, (int) y);
            m2972b(x, y, pointerId);
            mo4381b(b, pointerId);
            int i3 = this.f2182h[pointerId];
            int i4 = this.f2190p;
            if ((i3 & i4) != 0) {
                this.f2192r.mo4402b(i3 & i4, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f2175a == 1) {
                m2980h();
            }
            mo4378b();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f2175a == 1) {
                    m2965a(0.0f, 0.0f);
                }
                mo4378b();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x2 = motionEvent.getX(actionIndex);
                float y2 = motionEvent.getY(actionIndex);
                m2972b(x2, y2, pointerId2);
                if (this.f2175a == 0) {
                    mo4381b(mo4377b((int) x2, (int) y2), pointerId2);
                    int i5 = this.f2182h[pointerId2];
                    int i6 = this.f2190p;
                    if ((i5 & i6) != 0) {
                        this.f2192r.mo4402b(i5 & i6, pointerId2);
                    }
                } else if (mo4385c((int) x2, (int) y2)) {
                    mo4381b(this.f2193s, pointerId2);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.f2175a == 1 && pointerId3 == this.f2177c) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i2 >= pointerCount) {
                            i = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i2);
                        if (pointerId4 != this.f2177c) {
                            View b2 = mo4377b((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                            View view = this.f2193s;
                            if (b2 == view && mo4381b(view, pointerId4)) {
                                i = this.f2177c;
                                break;
                            }
                        }
                        i2++;
                    }
                    if (i == -1) {
                        m2980h();
                    }
                }
                m2976e(pointerId3);
            }
        } else if (this.f2175a != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i2 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i2);
                if (m2979g(pointerId5)) {
                    float x3 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float f = x3 - this.f2178d[pointerId5];
                    float f2 = y3 - this.f2179e[pointerId5];
                    m2966a(f, f2, pointerId5);
                    if (this.f2175a != 1) {
                        View b3 = mo4377b((int) x3, (int) y3);
                        if (m2969a(b3, f, f2) && mo4381b(b3, pointerId5)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i2++;
            }
            m2974c(motionEvent);
        } else if (m2979g(this.f2177c)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f2177c);
            float x4 = motionEvent.getX(findPointerIndex);
            float y4 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.f2180f;
            int i7 = this.f2177c;
            int i8 = (int) (x4 - fArr[i7]);
            int i9 = (int) (y4 - this.f2181g[i7]);
            m2967a(this.f2193s.getLeft() + i8, this.f2193s.getTop() + i9, i8, i9);
            m2974c(motionEvent);
        }
    }

    /* renamed from: b */
    public View mo4377b(int i, int i2) {
        for (int childCount = this.f2195u.getChildCount() - 1; childCount >= 0; childCount--) {
            ViewGroup viewGroup = this.f2195u;
            this.f2192r.mo4393a(childCount);
            View childAt = viewGroup.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m2966a(float f, float f2, int i) {
        int i2 = 1;
        if (!m2968a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m2968a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m2968a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m2968a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f2183i;
            iArr[i] = iArr[i] | i2;
            this.f2192r.mo4396a(i2, i);
        }
    }

    /* renamed from: a */
    private boolean m2968a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f2182h[i] & i2) != i2 || (this.f2190p & i2) == 0 || (this.f2184j[i] & i2) == i2 || (this.f2183i[i] & i2) == i2) {
            return false;
        }
        int i3 = this.f2176b;
        if (abs <= ((float) i3) && abs2 <= ((float) i3)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f2192r.mo4403b(i2)) {
            int[] iArr = this.f2184j;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f2183i[i] & i2) != 0 || abs <= ((float) this.f2176b)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    private boolean m2969a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f2192r.mo4394a(view) > 0;
        boolean z2 = this.f2192r.mo4400b(view) > 0;
        if (z && z2) {
            int i = this.f2176b;
            if ((f * f) + (f2 * f2) > ((float) (i * i))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.f2176b)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.f2176b)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    public boolean mo4373a(int i) {
        int length = this.f2178d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (mo4374a(i, i2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo4374a(int i, int i2) {
        if (!mo4379b(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f2180f[i2] - this.f2178d[i2];
        float f2 = this.f2181g[i2] - this.f2179e[i2];
        if (z && z2) {
            int i3 = this.f2176b;
            if ((f * f) + (f2 * f2) > ((float) (i3 * i3))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.f2176b)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.f2176b)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    private void m2967a(int i, int i2, int i3, int i4) {
        int left = this.f2193s.getLeft();
        int top = this.f2193s.getTop();
        if (i3 != 0) {
            i = this.f2192r.mo4395a(this.f2193s, i, i3);
            C0839t.m2712d(this.f2193s, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.f2192r.mo4401b(this.f2193s, i2, i4);
            C0839t.m2714e(this.f2193s, i2 - top);
        }
        int i6 = i2;
        if (i3 != 0 || i4 != 0) {
            this.f2192r.mo4399a(this.f2193s, i5, i6, i5 - left, i6 - top);
        }
    }

    /* renamed from: a */
    public boolean mo4375a(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }
}
