package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.C0502p;

/* renamed from: androidx.appcompat.widget.t */
/* compiled from: ForwardingListener */
public abstract class C0627t implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    private final float f1557a;

    /* renamed from: b */
    private final int f1558b;

    /* renamed from: c */
    private final int f1559c;

    /* renamed from: d */
    final View f1560d;

    /* renamed from: e */
    private Runnable f1561e;

    /* renamed from: f */
    private Runnable f1562f;

    /* renamed from: g */
    private boolean f1563g;

    /* renamed from: h */
    private int f1564h;

    /* renamed from: i */
    private final int[] f1565i = new int[2];

    /* renamed from: androidx.appcompat.widget.t$a */
    /* compiled from: ForwardingListener */
    private class C0628a implements Runnable {
        C0628a() {
        }

        public void run() {
            ViewParent parent = C0627t.this.f1560d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.t$b */
    /* compiled from: ForwardingListener */
    private class C0629b implements Runnable {
        C0629b() {
        }

        public void run() {
            C0627t.this.mo3567d();
        }
    }

    public C0627t(View view) {
        this.f1560d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1557a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1558b = tapTimeout;
        this.f1559c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    /* renamed from: a */
    private boolean m1829a(MotionEvent motionEvent) {
        C0622r rVar;
        View view = this.f1560d;
        C0502p a = mo2379a();
        if (a == null || !a.mo2476a() || (rVar = (C0622r) a.mo2484e()) == null || !rVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m1831a(view, obtainNoHistory);
        m1833b(rVar, obtainNoHistory);
        boolean a2 = rVar.mo3552a(obtainNoHistory, this.f1564h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        boolean z = (actionMasked == 1 || actionMasked == 3) ? false : true;
        if (!a2 || !z) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L_0x006d;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m1832b(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f1560d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L_0x0041
            r3 = 1
            if (r1 == r3) goto L_0x003d
            r4 = 2
            if (r1 == r4) goto L_0x001a
            r6 = 3
            if (r1 == r6) goto L_0x003d
            goto L_0x006d
        L_0x001a:
            int r1 = r5.f1564h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L_0x006d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f1557a
            boolean r6 = m1830a(r0, r4, r6, r1)
            if (r6 != 0) goto L_0x006d
            r5.m1834e()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L_0x003d:
            r5.m1834e()
            goto L_0x006d
        L_0x0041:
            int r6 = r6.getPointerId(r2)
            r5.f1564h = r6
            java.lang.Runnable r6 = r5.f1561e
            if (r6 != 0) goto L_0x0052
            androidx.appcompat.widget.t$a r6 = new androidx.appcompat.widget.t$a
            r6.<init>()
            r5.f1561e = r6
        L_0x0052:
            java.lang.Runnable r6 = r5.f1561e
            int r1 = r5.f1558b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f1562f
            if (r6 != 0) goto L_0x0065
            androidx.appcompat.widget.t$b r6 = new androidx.appcompat.widget.t$b
            r6.<init>()
            r5.f1562f = r6
        L_0x0065:
            java.lang.Runnable r6 = r5.f1562f
            int r1 = r5.f1559c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0627t.m1832b(android.view.MotionEvent):boolean");
    }

    /* renamed from: e */
    private void m1834e() {
        Runnable runnable = this.f1562f;
        if (runnable != null) {
            this.f1560d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1561e;
        if (runnable2 != null) {
            this.f1560d.removeCallbacks(runnable2);
        }
    }

    /* renamed from: a */
    public abstract C0502p mo2379a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract boolean mo2380b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo2904c() {
        C0502p a = mo2379a();
        if (a == null || !a.mo2476a()) {
            return true;
        }
        a.dismiss();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo3567d() {
        m1834e();
        View view = this.f1560d;
        if (view.isEnabled() && !view.isLongClickable() && mo2380b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1563g = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f1563g;
        if (z2) {
            z = m1829a(motionEvent) || !mo2904c();
        } else {
            z = m1832b(motionEvent) && mo2380b();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1560d.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f1563g = z;
        if (z || z2) {
            return true;
        }
        return false;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.f1563g = false;
        this.f1564h = -1;
        Runnable runnable = this.f1561e;
        if (runnable != null) {
            this.f1560d.removeCallbacks(runnable);
        }
    }

    /* renamed from: a */
    private static boolean m1830a(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    /* renamed from: a */
    private boolean m1831a(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1565i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    /* renamed from: b */
    private boolean m1833b(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1565i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }
}
