package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.p020f.C0839t;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.d */
/* compiled from: FastScroller */
class C1094d extends RecyclerView.C1053n implements RecyclerView.C1062s {

    /* renamed from: D */
    private static final int[] f2952D = {16842919};

    /* renamed from: E */
    private static final int[] f2953E = new int[0];

    /* renamed from: A */
    int f2954A = 0;

    /* renamed from: B */
    private final Runnable f2955B = new C1095a();

    /* renamed from: C */
    private final RecyclerView.C1063t f2956C = new C1096b();

    /* renamed from: a */
    private final int f2957a;

    /* renamed from: b */
    private final int f2958b;

    /* renamed from: c */
    final StateListDrawable f2959c;

    /* renamed from: d */
    final Drawable f2960d;

    /* renamed from: e */
    private final int f2961e;

    /* renamed from: f */
    private final int f2962f;

    /* renamed from: g */
    private final StateListDrawable f2963g;

    /* renamed from: h */
    private final Drawable f2964h;

    /* renamed from: i */
    private final int f2965i;

    /* renamed from: j */
    private final int f2966j;

    /* renamed from: k */
    int f2967k;

    /* renamed from: l */
    int f2968l;

    /* renamed from: m */
    float f2969m;

    /* renamed from: n */
    int f2970n;

    /* renamed from: o */
    int f2971o;

    /* renamed from: p */
    float f2972p;

    /* renamed from: q */
    private int f2973q = 0;

    /* renamed from: r */
    private int f2974r = 0;

    /* renamed from: s */
    private RecyclerView f2975s;

    /* renamed from: t */
    private boolean f2976t = false;

    /* renamed from: u */
    private boolean f2977u = false;

    /* renamed from: v */
    private int f2978v = 0;

    /* renamed from: w */
    private int f2979w = 0;

    /* renamed from: x */
    private final int[] f2980x = new int[2];

    /* renamed from: y */
    private final int[] f2981y = new int[2];

    /* renamed from: z */
    final ValueAnimator f2982z = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});

    /* renamed from: androidx.recyclerview.widget.d$a */
    /* compiled from: FastScroller */
    class C1095a implements Runnable {
        C1095a() {
        }

        public void run() {
            C1094d.this.mo5850a(500);
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$b */
    /* compiled from: FastScroller */
    class C1096b extends RecyclerView.C1063t {
        C1096b() {
        }

        /* renamed from: a */
        public void mo5644a(RecyclerView recyclerView, int i, int i2) {
            C1094d.this.mo5851a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$c */
    /* compiled from: FastScroller */
    private class C1097c extends AnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f2985a = false;

        C1097c() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f2985a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f2985a) {
                this.f2985a = false;
            } else if (((Float) C1094d.this.f2982z.getAnimatedValue()).floatValue() == 0.0f) {
                C1094d dVar = C1094d.this;
                dVar.f2954A = 0;
                dVar.mo5855b(0);
            } else {
                C1094d dVar2 = C1094d.this;
                dVar2.f2954A = 2;
                dVar2.mo5849a();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$d */
    /* compiled from: FastScroller */
    private class C1098d implements ValueAnimator.AnimatorUpdateListener {
        C1098d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            C1094d.this.f2959c.setAlpha(floatValue);
            C1094d.this.f2960d.setAlpha(floatValue);
            C1094d.this.mo5849a();
        }
    }

    C1094d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.f2959c = stateListDrawable;
        this.f2960d = drawable;
        this.f2963g = stateListDrawable2;
        this.f2964h = drawable2;
        this.f2961e = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f2962f = Math.max(i, drawable.getIntrinsicWidth());
        this.f2965i = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f2966j = Math.max(i, drawable2.getIntrinsicWidth());
        this.f2957a = i2;
        this.f2958b = i3;
        this.f2959c.setAlpha(255);
        this.f2960d.setAlpha(255);
        this.f2982z.addListener(new C1097c());
        this.f2982z.addUpdateListener(new C1098d());
        mo5852a(recyclerView);
    }

    /* renamed from: c */
    private void m4408c() {
        this.f2975s.removeCallbacks(this.f2955B);
    }

    /* renamed from: d */
    private void m4410d() {
        this.f2975s.mo5280b((RecyclerView.C1053n) this);
        this.f2975s.mo5281b((RecyclerView.C1062s) this);
        this.f2975s.mo5282b(this.f2956C);
        m4408c();
    }

    /* renamed from: e */
    private int[] m4411e() {
        int[] iArr = this.f2981y;
        int i = this.f2958b;
        iArr[0] = i;
        iArr[1] = this.f2973q - i;
        return iArr;
    }

    /* renamed from: f */
    private int[] m4412f() {
        int[] iArr = this.f2980x;
        int i = this.f2958b;
        iArr[0] = i;
        iArr[1] = this.f2974r - i;
        return iArr;
    }

    /* renamed from: g */
    private boolean m4413g() {
        return C0839t.m2725n(this.f2975s) == 1;
    }

    /* renamed from: h */
    private void m4414h() {
        this.f2975s.mo5259a((RecyclerView.C1053n) this);
        this.f2975s.mo5262a((RecyclerView.C1062s) this);
        this.f2975s.mo5263a(this.f2956C);
    }

    /* renamed from: a */
    public void mo5852a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2975s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                m4410d();
            }
            this.f2975s = recyclerView;
            if (recyclerView != null) {
                m4414h();
            }
        }
    }

    /* renamed from: a */
    public void mo5641a(boolean z) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5855b(int i) {
        if (i == 2 && this.f2978v != 2) {
            this.f2959c.setState(f2952D);
            m4408c();
        }
        if (i == 0) {
            mo5849a();
        } else {
            mo5854b();
        }
        if (this.f2978v == 2 && i != 2) {
            this.f2959c.setState(f2953E);
            m4409c(1200);
        } else if (i == 1) {
            m4409c(1500);
        }
        this.f2978v = i;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.C1070z zVar) {
        if (this.f2973q != this.f2975s.getWidth() || this.f2974r != this.f2975s.getHeight()) {
            this.f2973q = this.f2975s.getWidth();
            this.f2974r = this.f2975s.getHeight();
            mo5855b(0);
        } else if (this.f2954A != 0) {
            if (this.f2976t) {
                m4407b(canvas);
            }
            if (this.f2977u) {
                m4405a(canvas);
            }
        }
    }

    /* renamed from: c */
    private void m4409c(int i) {
        m4408c();
        this.f2975s.postDelayed(this.f2955B, (long) i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5849a() {
        this.f2975s.invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5850a(int i) {
        int i2 = this.f2954A;
        if (i2 == 1) {
            this.f2982z.cancel();
        } else if (i2 != 2) {
            return;
        }
        this.f2954A = 3;
        ValueAnimator valueAnimator = this.f2982z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
        this.f2982z.setDuration((long) i);
        this.f2982z.start();
    }

    /* renamed from: b */
    public void mo5854b() {
        int i = this.f2954A;
        if (i != 0) {
            if (i == 3) {
                this.f2982z.cancel();
            } else {
                return;
            }
        }
        this.f2954A = 1;
        ValueAnimator valueAnimator = this.f2982z;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.f2982z.setDuration(500);
        this.f2982z.setStartDelay(0);
        this.f2982z.start();
    }

    /* renamed from: a */
    private void m4405a(Canvas canvas) {
        int i = this.f2974r;
        int i2 = this.f2965i;
        int i3 = i - i2;
        int i4 = this.f2971o;
        int i5 = this.f2970n;
        int i6 = i4 - (i5 / 2);
        this.f2963g.setBounds(0, 0, i5, i2);
        this.f2964h.setBounds(0, 0, this.f2973q, this.f2966j);
        canvas.translate(0.0f, (float) i3);
        this.f2964h.draw(canvas);
        canvas.translate((float) i6, 0.0f);
        this.f2963g.draw(canvas);
        canvas.translate((float) (-i6), (float) (-i3));
    }

    /* renamed from: b */
    private void m4407b(Canvas canvas) {
        int i = this.f2973q;
        int i2 = this.f2961e;
        int i3 = i - i2;
        int i4 = this.f2968l;
        int i5 = this.f2967k;
        int i6 = i4 - (i5 / 2);
        this.f2959c.setBounds(0, 0, i2, i5);
        this.f2960d.setBounds(0, 0, this.f2962f, this.f2974r);
        if (m4413g()) {
            this.f2960d.draw(canvas);
            canvas.translate((float) this.f2961e, (float) i6);
            canvas.scale(-1.0f, 1.0f);
            this.f2959c.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate((float) (-this.f2961e), (float) (-i6));
            return;
        }
        canvas.translate((float) i3, 0.0f);
        this.f2960d.draw(canvas);
        canvas.translate(0.0f, (float) i6);
        this.f2959c.draw(canvas);
        canvas.translate((float) (-i3), (float) (-i6));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5851a(int i, int i2) {
        int computeVerticalScrollRange = this.f2975s.computeVerticalScrollRange();
        int i3 = this.f2974r;
        this.f2976t = computeVerticalScrollRange - i3 > 0 && i3 >= this.f2957a;
        int computeHorizontalScrollRange = this.f2975s.computeHorizontalScrollRange();
        int i4 = this.f2973q;
        boolean z = computeHorizontalScrollRange - i4 > 0 && i4 >= this.f2957a;
        this.f2977u = z;
        if (this.f2976t || z) {
            if (this.f2976t) {
                float f = (float) i3;
                this.f2968l = (int) ((f * (((float) i2) + (f / 2.0f))) / ((float) computeVerticalScrollRange));
                this.f2967k = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
            }
            if (this.f2977u) {
                float f2 = (float) i4;
                this.f2971o = (int) ((f2 * (((float) i) + (f2 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.f2970n = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
            }
            int i5 = this.f2978v;
            if (i5 == 0 || i5 == 1) {
                mo5855b(1);
            }
        } else if (this.f2978v != 0) {
            mo5855b(0);
        }
    }

    /* renamed from: b */
    public boolean mo5642b(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.f2978v;
        if (i == 1) {
            boolean b = mo5856b(motionEvent.getX(), motionEvent.getY());
            boolean a = mo5853a(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!b && !a) {
                return false;
            }
            if (a) {
                this.f2979w = 1;
                this.f2972p = (float) ((int) motionEvent.getX());
            } else if (b) {
                this.f2979w = 2;
                this.f2969m = (float) ((int) motionEvent.getY());
            }
            mo5855b(2);
        } else if (i == 2) {
            return true;
        } else {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void mo5640a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f2978v != 0) {
            if (motionEvent.getAction() == 0) {
                boolean b = mo5856b(motionEvent.getX(), motionEvent.getY());
                boolean a = mo5853a(motionEvent.getX(), motionEvent.getY());
                if (b || a) {
                    if (a) {
                        this.f2979w = 1;
                        this.f2972p = (float) ((int) motionEvent.getX());
                    } else if (b) {
                        this.f2979w = 2;
                        this.f2969m = (float) ((int) motionEvent.getY());
                    }
                    mo5855b(2);
                }
            } else if (motionEvent.getAction() == 1 && this.f2978v == 2) {
                this.f2969m = 0.0f;
                this.f2972p = 0.0f;
                mo5855b(1);
                this.f2979w = 0;
            } else if (motionEvent.getAction() == 2 && this.f2978v == 2) {
                mo5854b();
                if (this.f2979w == 1) {
                    m4404a(motionEvent.getX());
                }
                if (this.f2979w == 2) {
                    m4406b(motionEvent.getY());
                }
            }
        }
    }

    /* renamed from: b */
    private void m4406b(float f) {
        int[] f2 = m4412f();
        float max = Math.max((float) f2[0], Math.min((float) f2[1], f));
        if (Math.abs(((float) this.f2968l) - max) >= 2.0f) {
            int a = m4403a(this.f2969m, max, f2, this.f2975s.computeVerticalScrollRange(), this.f2975s.computeVerticalScrollOffset(), this.f2974r);
            if (a != 0) {
                this.f2975s.scrollBy(0, a);
            }
            this.f2969m = max;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5856b(float f, float f2) {
        if (!m4413g() ? f >= ((float) (this.f2973q - this.f2961e)) : f <= ((float) (this.f2961e / 2))) {
            int i = this.f2968l;
            int i2 = this.f2967k;
            return f2 >= ((float) (i - (i2 / 2))) && f2 <= ((float) (i + (i2 / 2)));
        }
    }

    /* renamed from: a */
    private void m4404a(float f) {
        int[] e = m4411e();
        float max = Math.max((float) e[0], Math.min((float) e[1], f));
        if (Math.abs(((float) this.f2971o) - max) >= 2.0f) {
            int a = m4403a(this.f2972p, max, e, this.f2975s.computeHorizontalScrollRange(), this.f2975s.computeHorizontalScrollOffset(), this.f2973q);
            if (a != 0) {
                this.f2975s.scrollBy(a, 0);
            }
            this.f2972p = max;
        }
    }

    /* renamed from: a */
    private int m4403a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / ((float) i4)) * ((float) i5));
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5853a(float f, float f2) {
        if (f2 >= ((float) (this.f2974r - this.f2965i))) {
            int i = this.f2971o;
            int i2 = this.f2970n;
            return f >= ((float) (i - (i2 / 2))) && f <= ((float) (i + (i2 / 2)));
        }
    }
}
