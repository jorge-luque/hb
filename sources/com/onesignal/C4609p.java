package com.onesignal;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.p020f.C0839t;
import androidx.customview.p023a.C0884a;

/* renamed from: com.onesignal.p */
/* compiled from: DraggableRelativeLayout */
class C4609p extends RelativeLayout {

    /* renamed from: e */
    private static final int f12572e = C4543l1.m15662a(28);

    /* renamed from: f */
    private static final int f12573f = C4543l1.m15662a(64);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C4611b f12574a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0884a f12575b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f12576c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C4612c f12577d;

    /* renamed from: com.onesignal.p$a */
    /* compiled from: DraggableRelativeLayout */
    class C4610a extends C0884a.C0887c {

        /* renamed from: a */
        private int f12578a;

        C4610a() {
        }

        /* renamed from: a */
        public int mo4395a(View view, int i, int i2) {
            return C4609p.this.f12577d.f12583d;
        }

        /* renamed from: b */
        public int mo4401b(View view, int i, int i2) {
            this.f12578a = i;
            if (C4609p.this.f12577d.f12585f == 1) {
                if (i >= C4609p.this.f12577d.f12582c && C4609p.this.f12574a != null) {
                    C4609p.this.f12574a.mo29900a();
                }
                if (i < C4609p.this.f12577d.f12581b) {
                    return C4609p.this.f12577d.f12581b;
                }
            } else {
                if (i <= C4609p.this.f12577d.f12582c && C4609p.this.f12574a != null) {
                    C4609p.this.f12574a.mo29900a();
                }
                if (i > C4609p.this.f12577d.f12581b) {
                    return C4609p.this.f12577d.f12581b;
                }
            }
            return i;
        }

        /* renamed from: b */
        public boolean mo4404b(View view, int i) {
            return true;
        }

        /* renamed from: a */
        public void mo4397a(View view, float f, float f2) {
            int i = C4609p.this.f12577d.f12581b;
            if (!C4609p.this.f12576c) {
                if (C4609p.this.f12577d.f12585f == 1) {
                    if (this.f12578a > C4609p.this.f12577d.f12588i || f2 > ((float) C4609p.this.f12577d.f12586g)) {
                        i = C4609p.this.f12577d.f12587h;
                        boolean unused = C4609p.this.f12576c = true;
                        if (C4609p.this.f12574a != null) {
                            C4609p.this.f12574a.onDismiss();
                        }
                    }
                } else if (this.f12578a < C4609p.this.f12577d.f12588i || f2 < ((float) C4609p.this.f12577d.f12586g)) {
                    i = C4609p.this.f12577d.f12587h;
                    boolean unused2 = C4609p.this.f12576c = true;
                    if (C4609p.this.f12574a != null) {
                        C4609p.this.f12574a.onDismiss();
                    }
                }
            }
            if (C4609p.this.f12575b.mo4388d(C4609p.this.f12577d.f12583d, i)) {
                C0839t.m2682A(C4609p.this);
            }
        }
    }

    /* renamed from: com.onesignal.p$b */
    /* compiled from: DraggableRelativeLayout */
    interface C4611b {
        /* renamed from: a */
        void mo29900a();

        /* renamed from: b */
        void mo29901b();

        void onDismiss();
    }

    /* renamed from: com.onesignal.p$c */
    /* compiled from: DraggableRelativeLayout */
    static class C4612c {

        /* renamed from: a */
        int f12580a;

        /* renamed from: b */
        int f12581b;

        /* renamed from: c */
        int f12582c;

        /* renamed from: d */
        int f12583d;

        /* renamed from: e */
        int f12584e;

        /* renamed from: f */
        int f12585f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public int f12586g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public int f12587h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public int f12588i;

        C4612c() {
        }
    }

    public C4609p(Context context) {
        super(context);
        setClipChildren(false);
        m15936b();
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.f12575b.mo4376a(true)) {
            C0839t.m2682A(this);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        C4611b bVar;
        if (this.f12576c) {
            return true;
        }
        int action = motionEvent.getAction();
        if ((action == 0 || action == 5) && (bVar = this.f12574a) != null) {
            bVar.mo29901b();
        }
        this.f12575b.mo4371a(motionEvent);
        return false;
    }

    /* renamed from: b */
    private void m15936b() {
        this.f12575b = C0884a.m2963a((ViewGroup) this, 1.0f, (C0884a.C0887c) new C4610a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29896a(C4611b bVar) {
        this.f12574a = bVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29897a(C4612c cVar) {
        this.f12577d = cVar;
        int unused = cVar.f12587h = cVar.f12584e + cVar.f12580a + ((Resources.getSystem().getDisplayMetrics().heightPixels - cVar.f12584e) - cVar.f12580a) + f12573f;
        int unused2 = cVar.f12586g = C4543l1.m15662a(3000);
        if (cVar.f12585f == 0) {
            int unused3 = cVar.f12587h = (-cVar.f12584e) - f12572e;
            int unused4 = cVar.f12586g = -cVar.f12586g;
            int unused5 = cVar.f12588i = cVar.f12587h / 3;
            return;
        }
        int unused6 = cVar.f12588i = (cVar.f12584e / 3) + (cVar.f12581b * 2);
    }

    /* renamed from: a */
    public void mo29895a() {
        this.f12576c = true;
        this.f12575b.mo4382b((View) this, getLeft(), this.f12577d.f12587h);
        C0839t.m2682A(this);
    }
}
