package com.google.android.exoplayer2.p072ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.facebook.internal.Utility;
import com.google.android.exoplayer2.p072ui.C3066c;
import com.google.android.exoplayer2.util.C3069a;
import com.google.android.exoplayer2.util.C3071c;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.google.android.exoplayer2.ui.DefaultTimeBar */
public class DefaultTimeBar extends View implements C3066c {

    /* renamed from: A */
    private long f8469A;

    /* renamed from: B */
    private int f8470B;

    /* renamed from: C */
    private boolean f8471C;

    /* renamed from: D */
    private long f8472D;

    /* renamed from: E */
    private long f8473E;

    /* renamed from: F */
    private long f8474F;

    /* renamed from: G */
    private long f8475G;

    /* renamed from: H */
    private int f8476H;

    /* renamed from: I */
    private long[] f8477I;

    /* renamed from: J */
    private boolean[] f8478J;

    /* renamed from: a */
    private final Rect f8479a = new Rect();

    /* renamed from: b */
    private final Rect f8480b = new Rect();

    /* renamed from: c */
    private final Rect f8481c = new Rect();

    /* renamed from: d */
    private final Rect f8482d = new Rect();

    /* renamed from: e */
    private final Paint f8483e = new Paint();

    /* renamed from: f */
    private final Paint f8484f = new Paint();

    /* renamed from: g */
    private final Paint f8485g = new Paint();

    /* renamed from: h */
    private final Paint f8486h = new Paint();

    /* renamed from: i */
    private final Paint f8487i = new Paint();

    /* renamed from: j */
    private final Paint f8488j;

    /* renamed from: k */
    private final Drawable f8489k;

    /* renamed from: l */
    private final int f8490l;

    /* renamed from: m */
    private final int f8491m;

    /* renamed from: n */
    private final int f8492n;

    /* renamed from: o */
    private final int f8493o;

    /* renamed from: p */
    private final int f8494p;

    /* renamed from: q */
    private final int f8495q;

    /* renamed from: r */
    private final int f8496r;

    /* renamed from: s */
    private final int f8497s;

    /* renamed from: t */
    private final StringBuilder f8498t;

    /* renamed from: u */
    private final Formatter f8499u;

    /* renamed from: v */
    private final Runnable f8500v;

    /* renamed from: w */
    private final CopyOnWriteArraySet<C3066c.C3067a> f8501w;

    /* renamed from: x */
    private final int[] f8502x;

    /* renamed from: y */
    private final Point f8503y;

    /* renamed from: z */
    private int f8504z;

    /* renamed from: com.google.android.exoplayer2.ui.DefaultTimeBar$a */
    class C3053a implements Runnable {
        C3053a() {
        }

        public void run() {
            DefaultTimeBar.this.m10001a(false);
        }
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f8488j = paint;
        paint.setAntiAlias(true);
        this.f8501w = new CopyOnWriteArraySet<>();
        this.f8502x = new int[2];
        this.f8503y = new Point();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f8497s = m9995a(displayMetrics, -50);
        int a = m9995a(displayMetrics, 4);
        int a2 = m9995a(displayMetrics, 26);
        int a3 = m9995a(displayMetrics, 4);
        int a4 = m9995a(displayMetrics, 12);
        int a5 = m9995a(displayMetrics, 0);
        int a6 = m9995a(displayMetrics, 16);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.DefaultTimeBar, 0, 0);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.DefaultTimeBar_scrubber_drawable);
                this.f8489k = drawable;
                if (drawable != null) {
                    m10003a(drawable);
                    a2 = Math.max(this.f8489k.getMinimumHeight(), a2);
                }
                this.f8490l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_bar_height, a);
                this.f8491m = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_touch_target_height, a2);
                this.f8492n = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_ad_marker_width, a3);
                this.f8493o = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_enabled_size, a4);
                this.f8494p = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_disabled_size, a5);
                this.f8495q = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_dragged_size, a6);
                int i = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_played_color, -1);
                int i2 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_scrubber_color, m10008c(i));
                int i3 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_buffered_color, m9994a(i));
                int i4 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_unplayed_color, m10010d(i));
                int i5 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_ad_marker_color, -1291845888);
                int i6 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_played_ad_marker_color, m10005b(i5));
                this.f8483e.setColor(i);
                this.f8488j.setColor(i2);
                this.f8484f.setColor(i3);
                this.f8485g.setColor(i4);
                this.f8486h.setColor(i5);
                this.f8487i.setColor(i6);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.f8490l = a;
            this.f8491m = a2;
            this.f8492n = a3;
            this.f8493o = a4;
            this.f8494p = a5;
            this.f8495q = a6;
            this.f8483e.setColor(-1);
            this.f8488j.setColor(m10008c(-1));
            this.f8484f.setColor(m9994a(-1));
            this.f8485g.setColor(m10010d(-1));
            this.f8486h.setColor(-1291845888);
            this.f8489k = null;
        }
        this.f8498t = new StringBuilder();
        this.f8499u = new Formatter(this.f8498t, Locale.getDefault());
        this.f8500v = new C3053a();
        Drawable drawable2 = this.f8489k;
        if (drawable2 != null) {
            this.f8496r = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.f8496r = (Math.max(this.f8494p, Math.max(this.f8493o, this.f8495q)) + 1) / 2;
        }
        this.f8473E = -9223372036854775807L;
        this.f8469A = -9223372036854775807L;
        this.f8504z = 20;
        setFocusable(true);
        if (C3071c.f8625a >= 16) {
            m10011d();
        }
    }

    /* renamed from: a */
    public static int m9994a(int i) {
        return (i & 16777215) | -872415232;
    }

    /* renamed from: b */
    public static int m10005b(int i) {
        return (i & 16777215) | 855638016;
    }

    /* renamed from: c */
    public static int m10008c(int i) {
        return i | -16777216;
    }

    /* renamed from: d */
    public static int m10010d(int i) {
        return (i & 16777215) | 855638016;
    }

    @TargetApi(16)
    /* renamed from: d */
    private void m10011d() {
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    /* renamed from: e */
    private void m10013e() {
        this.f8471C = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<C3066c.C3067a> it = this.f8501w.iterator();
        while (it.hasNext()) {
            it.next().mo13080b(this, m10009c());
        }
    }

    /* renamed from: f */
    private void m10014f() {
        this.f8481c.set(this.f8480b);
        this.f8482d.set(this.f8480b);
        long j = this.f8471C ? this.f8472D : this.f8474F;
        if (this.f8473E > 0) {
            int width = (int) ((((long) this.f8480b.width()) * this.f8475G) / this.f8473E);
            Rect rect = this.f8481c;
            Rect rect2 = this.f8480b;
            rect.right = Math.min(rect2.left + width, rect2.right);
            int width2 = (int) ((((long) this.f8480b.width()) * j) / this.f8473E);
            Rect rect3 = this.f8482d;
            Rect rect4 = this.f8480b;
            rect3.right = Math.min(rect4.left + width2, rect4.right);
        } else {
            Rect rect5 = this.f8481c;
            int i = this.f8480b.left;
            rect5.right = i;
            this.f8482d.right = i;
        }
        invalidate(this.f8479a);
    }

    /* renamed from: g */
    private void m10015g() {
        Drawable drawable = this.f8489k;
        if (drawable != null && drawable.isStateful() && this.f8489k.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* renamed from: b */
    public void mo13052b(long j) {
        this.f8473E = j;
        if (this.f8471C && j == -9223372036854775807L) {
            m10001a(true);
        }
        m10014f();
    }

    /* renamed from: c */
    public void mo13053c(long j) {
        this.f8475G = j;
        m10014f();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        m10015g();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f8489k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        m10007b(canvas);
        m9999a(canvas);
        canvas.restore();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(m10006b());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @TargetApi(21)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(m10006b());
        if (this.f8473E > 0) {
            int i = C3071c.f8625a;
            if (i >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
            } else if (i >= 16) {
                accessibilityNodeInfo.addAction(CodedOutputStream.DEFAULT_BUFFER_SIZE);
                accessibilityNodeInfo.addAction(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (m10012d(r0) == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        removeCallbacks(r4.f8500v);
        postDelayed(r4.f8500v, 1000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L_0x0036
            long r0 = r4.m9996a()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L_0x0027
            switch(r5) {
                case 21: goto L_0x0013;
                case 22: goto L_0x0014;
                case 23: goto L_0x0027;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0036
        L_0x0013:
            long r0 = -r0
        L_0x0014:
            boolean r0 = r4.m10012d((long) r0)
            if (r0 == 0) goto L_0x0036
            java.lang.Runnable r5 = r4.f8500v
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.f8500v
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L_0x0027:
            boolean r0 = r4.f8471C
            if (r0 == 0) goto L_0x0036
            java.lang.Runnable r5 = r4.f8500v
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.f8500v
            r5.run()
            return r3
        L_0x0036:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p072ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = ((i4 - i2) - this.f8491m) / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int i6 = this.f8491m;
        int i7 = ((i6 - this.f8490l) / 2) + i5;
        this.f8479a.set(paddingLeft, i5, paddingRight, i6 + i5);
        Rect rect = this.f8480b;
        Rect rect2 = this.f8479a;
        int i8 = rect2.left;
        int i9 = this.f8496r;
        rect.set(i8 + i9, i7, rect2.right - i9, this.f8490l + i7);
        m10014f();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.f8491m;
        } else if (mode != 1073741824) {
            size = Math.min(this.f8491m, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        m10015g();
    }

    public void onRtlPropertiesChanged(int i) {
        Drawable drawable = this.f8489k;
        if (drawable != null && m10004a(drawable, i)) {
            invalidate();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r3 != 3) goto L_0x0090;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x0090
            long r2 = r7.f8473E
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0011
            goto L_0x0090
        L_0x0011:
            android.graphics.Point r0 = r7.m9997a((android.view.MotionEvent) r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L_0x0075
            r5 = 3
            if (r3 == r4) goto L_0x0066
            r6 = 2
            if (r3 == r6) goto L_0x0029
            if (r3 == r5) goto L_0x0066
            goto L_0x0090
        L_0x0029:
            boolean r8 = r7.f8471C
            if (r8 == 0) goto L_0x0090
            int r8 = r7.f8497s
            if (r0 >= r8) goto L_0x003b
            int r8 = r7.f8470B
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
            r7.m9998a((float) r8)
            goto L_0x0041
        L_0x003b:
            r7.f8470B = r2
            float r8 = (float) r2
            r7.m9998a((float) r8)
        L_0x0041:
            long r0 = r7.m10009c()
            r7.f8472D = r0
            java.util.concurrent.CopyOnWriteArraySet<com.google.android.exoplayer2.ui.c$a> r8 = r7.f8501w
            java.util.Iterator r8 = r8.iterator()
        L_0x004d:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x005f
            java.lang.Object r0 = r8.next()
            com.google.android.exoplayer2.ui.c$a r0 = (com.google.android.exoplayer2.p072ui.C3066c.C3067a) r0
            long r1 = r7.f8472D
            r0.mo13078a(r7, r1)
            goto L_0x004d
        L_0x005f:
            r7.m10014f()
            r7.invalidate()
            return r4
        L_0x0066:
            boolean r0 = r7.f8471C
            if (r0 == 0) goto L_0x0090
            int r8 = r8.getAction()
            if (r8 != r5) goto L_0x0071
            r1 = 1
        L_0x0071:
            r7.m10001a((boolean) r1)
            return r4
        L_0x0075:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.m10002a((float) r8, (float) r0)
            if (r0 == 0) goto L_0x0090
            r7.m9998a((float) r8)
            r7.m10013e()
            long r0 = r7.m10009c()
            r7.f8472D = r0
            r7.m10014f()
            r7.invalidate()
            return r4
        L_0x0090:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p072ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @TargetApi(16)
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (this.f8473E <= 0) {
            return false;
        }
        if (i == 8192) {
            if (m10012d(-m9996a())) {
                m10001a(false);
            }
        } else if (i != 4096) {
            return false;
        } else {
            if (m10012d(m9996a())) {
                m10001a(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.f8471C && !z) {
            m10001a(true);
        }
    }

    /* renamed from: a */
    public void mo13050a(C3066c.C3067a aVar) {
        this.f8501w.add(aVar);
    }

    /* renamed from: c */
    private long m10009c() {
        if (this.f8480b.width() <= 0 || this.f8473E == -9223372036854775807L) {
            return 0;
        }
        return (((long) this.f8482d.width()) * this.f8473E) / ((long) this.f8480b.width());
    }

    /* renamed from: d */
    private boolean m10012d(long j) {
        if (this.f8473E <= 0) {
            return false;
        }
        long c = m10009c();
        long a = C3071c.m10125a(c + j, 0, this.f8473E);
        this.f8472D = a;
        if (a == c) {
            return false;
        }
        if (!this.f8471C) {
            m10013e();
        }
        Iterator<C3066c.C3067a> it = this.f8501w.iterator();
        while (it.hasNext()) {
            it.next().mo13078a(this, this.f8472D);
        }
        m10014f();
        return true;
    }

    /* renamed from: a */
    public void mo13049a(long j) {
        this.f8474F = j;
        setContentDescription(m10006b());
        m10014f();
    }

    /* renamed from: b */
    private void m10007b(Canvas canvas) {
        int height = this.f8480b.height();
        int centerY = this.f8480b.centerY() - (height / 2);
        int i = height + centerY;
        if (this.f8473E <= 0) {
            Rect rect = this.f8480b;
            canvas.drawRect((float) rect.left, (float) centerY, (float) rect.right, (float) i, this.f8485g);
            return;
        }
        Rect rect2 = this.f8481c;
        int i2 = rect2.left;
        int i3 = rect2.right;
        int max = Math.max(Math.max(this.f8480b.left, i3), this.f8482d.right);
        int i4 = this.f8480b.right;
        if (max < i4) {
            canvas.drawRect((float) max, (float) centerY, (float) i4, (float) i, this.f8485g);
        }
        int max2 = Math.max(i2, this.f8482d.right);
        if (i3 > max2) {
            canvas.drawRect((float) max2, (float) centerY, (float) i3, (float) i, this.f8484f);
        }
        if (this.f8482d.width() > 0) {
            Rect rect3 = this.f8482d;
            canvas.drawRect((float) rect3.left, (float) centerY, (float) rect3.right, (float) i, this.f8483e);
        }
        if (this.f8476H != 0) {
            long[] jArr = this.f8477I;
            C3069a.m10120a(jArr);
            long[] jArr2 = jArr;
            boolean[] zArr = this.f8478J;
            C3069a.m10120a(zArr);
            boolean[] zArr2 = zArr;
            int i5 = this.f8492n / 2;
            for (int i6 = 0; i6 < this.f8476H; i6++) {
                long a = C3071c.m10125a(jArr2[i6], 0, this.f8473E);
                Rect rect4 = this.f8480b;
                int min = rect4.left + Math.min(rect4.width() - this.f8492n, Math.max(0, ((int) ((((long) this.f8480b.width()) * a) / this.f8473E)) - i5));
                canvas.drawRect((float) min, (float) centerY, (float) (min + this.f8492n), (float) i, zArr2[i6] ? this.f8487i : this.f8486h);
            }
        }
    }

    /* renamed from: a */
    public void mo13051a(long[] jArr, boolean[] zArr, int i) {
        C3069a.m10121a(i == 0 || !(jArr == null || zArr == null));
        this.f8476H = i;
        this.f8477I = jArr;
        this.f8478J = zArr;
        m10014f();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10001a(boolean z) {
        this.f8471C = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<C3066c.C3067a> it = this.f8501w.iterator();
        while (it.hasNext()) {
            it.next().mo13079a(this, m10009c(), z);
        }
    }

    /* renamed from: a */
    private void m9998a(float f) {
        Rect rect = this.f8482d;
        Rect rect2 = this.f8480b;
        rect.right = C3071c.m10124a((int) f, rect2.left, rect2.right);
    }

    /* renamed from: a */
    private Point m9997a(MotionEvent motionEvent) {
        getLocationOnScreen(this.f8502x);
        this.f8503y.set(((int) motionEvent.getRawX()) - this.f8502x[0], ((int) motionEvent.getRawY()) - this.f8502x[1]);
        return this.f8503y;
    }

    /* renamed from: a */
    private boolean m10002a(float f, float f2) {
        return this.f8479a.contains((int) f, (int) f2);
    }

    /* renamed from: a */
    private void m9999a(Canvas canvas) {
        int i;
        if (this.f8473E > 0) {
            Rect rect = this.f8482d;
            int a = C3071c.m10124a(rect.right, rect.left, this.f8480b.right);
            int centerY = this.f8482d.centerY();
            Drawable drawable = this.f8489k;
            if (drawable == null) {
                if (this.f8471C || isFocused()) {
                    i = this.f8495q;
                } else {
                    i = isEnabled() ? this.f8493o : this.f8494p;
                }
                canvas.drawCircle((float) a, (float) centerY, (float) (i / 2), this.f8488j);
                return;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
            int intrinsicHeight = this.f8489k.getIntrinsicHeight() / 2;
            this.f8489k.setBounds(a - intrinsicWidth, centerY - intrinsicHeight, a + intrinsicWidth, centerY + intrinsicHeight);
            this.f8489k.draw(canvas);
        }
    }

    /* renamed from: b */
    private String m10006b() {
        return C3071c.m10126a(this.f8498t, this.f8499u, this.f8474F);
    }

    /* renamed from: a */
    private long m9996a() {
        long j = this.f8469A;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = this.f8473E;
        if (j2 == -9223372036854775807L) {
            return 0;
        }
        return j2 / ((long) this.f8504z);
    }

    /* renamed from: a */
    private boolean m10003a(Drawable drawable) {
        return C3071c.f8625a >= 23 && m10004a(drawable, getLayoutDirection());
    }

    /* renamed from: a */
    private static boolean m10004a(Drawable drawable, int i) {
        return C3071c.f8625a >= 23 && drawable.setLayoutDirection(i);
    }

    /* renamed from: a */
    private static int m9995a(DisplayMetrics displayMetrics, int i) {
        return (int) ((((float) i) * displayMetrics.density) + 0.5f);
    }
}
