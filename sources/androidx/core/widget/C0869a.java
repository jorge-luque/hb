package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.p020f.C0839t;

/* renamed from: androidx.core.widget.a */
/* compiled from: AutoScrollHelper */
public abstract class C0869a implements View.OnTouchListener {

    /* renamed from: r */
    private static final int f2130r = ViewConfiguration.getTapTimeout();

    /* renamed from: a */
    final C0870a f2131a = new C0870a();

    /* renamed from: b */
    private final Interpolator f2132b = new AccelerateInterpolator();

    /* renamed from: c */
    final View f2133c;

    /* renamed from: d */
    private Runnable f2134d;

    /* renamed from: e */
    private float[] f2135e = {0.0f, 0.0f};

    /* renamed from: f */
    private float[] f2136f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: g */
    private int f2137g;

    /* renamed from: h */
    private int f2138h;

    /* renamed from: i */
    private float[] f2139i = {0.0f, 0.0f};

    /* renamed from: j */
    private float[] f2140j = {0.0f, 0.0f};

    /* renamed from: k */
    private float[] f2141k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: l */
    private boolean f2142l;

    /* renamed from: m */
    boolean f2143m;

    /* renamed from: n */
    boolean f2144n;

    /* renamed from: o */
    boolean f2145o;

    /* renamed from: p */
    private boolean f2146p;

    /* renamed from: q */
    private boolean f2147q;

    /* renamed from: androidx.core.widget.a$a */
    /* compiled from: AutoScrollHelper */
    private static class C0870a {

        /* renamed from: a */
        private int f2148a;

        /* renamed from: b */
        private int f2149b;

        /* renamed from: c */
        private float f2150c;

        /* renamed from: d */
        private float f2151d;

        /* renamed from: e */
        private long f2152e = Long.MIN_VALUE;

        /* renamed from: f */
        private long f2153f = 0;

        /* renamed from: g */
        private int f2154g = 0;

        /* renamed from: h */
        private int f2155h = 0;

        /* renamed from: i */
        private long f2156i = -1;

        /* renamed from: j */
        private float f2157j;

        /* renamed from: k */
        private int f2158k;

        C0870a() {
        }

        /* renamed from: a */
        private float m2907a(float f) {
            return (-4.0f * f * f) + (f * 4.0f);
        }

        /* renamed from: a */
        public void mo4355a(int i) {
            this.f2149b = i;
        }

        /* renamed from: b */
        public void mo4357b(int i) {
            this.f2148a = i;
        }

        /* renamed from: c */
        public int mo4358c() {
            return this.f2155h;
        }

        /* renamed from: d */
        public int mo4359d() {
            float f = this.f2150c;
            return (int) (f / Math.abs(f));
        }

        /* renamed from: e */
        public int mo4360e() {
            float f = this.f2151d;
            return (int) (f / Math.abs(f));
        }

        /* renamed from: f */
        public boolean mo4361f() {
            return this.f2156i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f2156i + ((long) this.f2158k);
        }

        /* renamed from: g */
        public void mo4362g() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2158k = C0869a.m2888a((int) (currentAnimationTimeMillis - this.f2152e), 0, this.f2149b);
            this.f2157j = m2908a(currentAnimationTimeMillis);
            this.f2156i = currentAnimationTimeMillis;
        }

        /* renamed from: h */
        public void mo4363h() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2152e = currentAnimationTimeMillis;
            this.f2156i = -1;
            this.f2153f = currentAnimationTimeMillis;
            this.f2157j = 0.5f;
            this.f2154g = 0;
            this.f2155h = 0;
        }

        /* renamed from: a */
        private float m2908a(long j) {
            if (j < this.f2152e) {
                return 0.0f;
            }
            long j2 = this.f2156i;
            if (j2 < 0 || j < j2) {
                return C0869a.m2885a(((float) (j - this.f2152e)) / ((float) this.f2148a), 0.0f, 1.0f) * 0.5f;
            }
            long j3 = j - j2;
            float f = this.f2157j;
            return (1.0f - f) + (f * C0869a.m2885a(((float) j3) / ((float) this.f2158k), 0.0f, 1.0f));
        }

        /* renamed from: b */
        public int mo4356b() {
            return this.f2154g;
        }

        /* renamed from: a */
        public void mo4353a() {
            if (this.f2153f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float a = m2907a(m2908a(currentAnimationTimeMillis));
                this.f2153f = currentAnimationTimeMillis;
                float f = ((float) (currentAnimationTimeMillis - this.f2153f)) * a;
                this.f2154g = (int) (this.f2150c * f);
                this.f2155h = (int) (f * this.f2151d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        /* renamed from: a */
        public void mo4354a(float f, float f2) {
            this.f2150c = f;
            this.f2151d = f2;
        }
    }

    /* renamed from: androidx.core.widget.a$b */
    /* compiled from: AutoScrollHelper */
    private class C0871b implements Runnable {
        C0871b() {
        }

        public void run() {
            C0869a aVar = C0869a.this;
            if (aVar.f2145o) {
                if (aVar.f2143m) {
                    aVar.f2143m = false;
                    aVar.f2131a.mo4363h();
                }
                C0870a aVar2 = C0869a.this.f2131a;
                if (aVar2.mo4361f() || !C0869a.this.mo4343b()) {
                    C0869a.this.f2145o = false;
                    return;
                }
                C0869a aVar3 = C0869a.this;
                if (aVar3.f2144n) {
                    aVar3.f2144n = false;
                    aVar3.mo4339a();
                }
                aVar2.mo4353a();
                C0869a.this.mo4340a(aVar2.mo4356b(), aVar2.mo4358c());
                C0839t.m2699a(C0869a.this.f2133c, (Runnable) this);
            }
        }
    }

    public C0869a(View view) {
        this.f2133c = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = (float) ((int) ((1575.0f * f) + 0.5f));
        mo4342b(f2, f2);
        float f3 = (float) ((int) ((f * 315.0f) + 0.5f));
        mo4345c(f3, f3);
        mo4348d(1);
        mo4337a(Float.MAX_VALUE, Float.MAX_VALUE);
        mo4347d(0.2f, 0.2f);
        mo4349e(1.0f, 1.0f);
        mo4346c(f2130r);
        mo4351f(500);
        mo4350e(500);
    }

    /* renamed from: a */
    static float m2885a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* renamed from: a */
    static int m2888a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    /* renamed from: a */
    public C0869a mo4338a(boolean z) {
        if (this.f2146p && !z) {
            m2889c();
        }
        this.f2146p = z;
        return this;
    }

    /* renamed from: a */
    public abstract void mo4340a(int i, int i2);

    /* renamed from: a */
    public abstract boolean mo4341a(int i);

    /* renamed from: b */
    public C0869a mo4342b(float f, float f2) {
        float[] fArr = this.f2141k;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: b */
    public abstract boolean mo4344b(int i);

    /* renamed from: c */
    public C0869a mo4345c(float f, float f2) {
        float[] fArr = this.f2140j;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: d */
    public C0869a mo4348d(int i) {
        this.f2137g = i;
        return this;
    }

    /* renamed from: e */
    public C0869a mo4349e(float f, float f2) {
        float[] fArr = this.f2139i;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: f */
    public C0869a mo4351f(int i) {
        this.f2131a.mo4357b(i);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f2146p
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            r5.m2889c()
            goto L_0x0058
        L_0x001a:
            r5.f2144n = r2
            r5.f2142l = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f2133c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.m2887a((int) r1, (float) r0, (float) r3, (float) r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f2133c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.m2887a((int) r2, (float) r7, (float) r6, (float) r3)
            androidx.core.widget.a$a r7 = r5.f2131a
            r7.mo4354a(r0, r6)
            boolean r6 = r5.f2145o
            if (r6 != 0) goto L_0x0058
            boolean r6 = r5.mo4343b()
            if (r6 == 0) goto L_0x0058
            r5.m2890d()
        L_0x0058:
            boolean r6 = r5.f2147q
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5.f2145o
            if (r6 == 0) goto L_0x0061
            r1 = 1
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.C0869a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* renamed from: f */
    private float m2891f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.f2137g;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                return (!this.f2145o || this.f2137g != 1) ? 0.0f : 1.0f;
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
    }

    /* renamed from: d */
    public C0869a mo4347d(float f, float f2) {
        float[] fArr = this.f2135e;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo4343b() {
        C0870a aVar = this.f2131a;
        int e = aVar.mo4360e();
        int d = aVar.mo4359d();
        return (e != 0 && mo4344b(e)) || (d != 0 && mo4341a(d));
    }

    /* renamed from: c */
    public C0869a mo4346c(int i) {
        this.f2138h = i;
        return this;
    }

    /* renamed from: e */
    public C0869a mo4350e(int i) {
        this.f2131a.mo4355a(i);
        return this;
    }

    /* renamed from: c */
    private void m2889c() {
        if (this.f2143m) {
            this.f2145o = false;
        } else {
            this.f2131a.mo4362g();
        }
    }

    /* renamed from: d */
    private void m2890d() {
        int i;
        if (this.f2134d == null) {
            this.f2134d = new C0871b();
        }
        this.f2145o = true;
        this.f2143m = true;
        if (this.f2142l || (i = this.f2138h) <= 0) {
            this.f2134d.run();
        } else {
            C0839t.m2700a(this.f2133c, this.f2134d, (long) i);
        }
        this.f2142l = true;
    }

    /* renamed from: a */
    public C0869a mo4337a(float f, float f2) {
        float[] fArr = this.f2136f;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    /* renamed from: a */
    private float m2887a(int i, float f, float f2, float f3) {
        float a = m2886a(this.f2135e[i], f2, this.f2136f[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f2139i[i];
        float f5 = this.f2140j[i];
        float f6 = this.f2141k[i];
        float f7 = f4 * f3;
        if (a > 0.0f) {
            return m2885a(a * f7, f5, f6);
        }
        return -m2885a((-a) * f7, f5, f6);
    }

    /* renamed from: a */
    private float m2886a(float f, float f2, float f3, float f4) {
        float f5;
        float a = m2885a(f * f2, 0.0f, f3);
        float f6 = m2891f(f2 - f4, a) - m2891f(f4, a);
        if (f6 < 0.0f) {
            f5 = -this.f2132b.getInterpolation(-f6);
        } else if (f6 <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f2132b.getInterpolation(f6);
        }
        return m2885a(f5, -1.0f, 1.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4339a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f2133c.onTouchEvent(obtain);
        obtain.recycle();
    }
}
