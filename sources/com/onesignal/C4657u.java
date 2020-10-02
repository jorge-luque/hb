package com.onesignal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.core.widget.C0878h;
import com.onesignal.C4564n1;
import com.onesignal.C4609p;
import com.onesignal.C4701w2;

/* renamed from: com.onesignal.u */
/* compiled from: InAppMessageView */
class C4657u {

    /* renamed from: p */
    private static final int f12663p = Color.parseColor("#00000000");

    /* renamed from: q */
    private static final int f12664q = Color.parseColor("#BB000000");

    /* renamed from: r */
    private static final int f12665r = C4543l1.m15662a(24);

    /* renamed from: s */
    private static final int f12666s = C4543l1.m15662a(4);

    /* renamed from: a */
    private PopupWindow f12667a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Activity f12668b;

    /* renamed from: c */
    private final Handler f12669c = new Handler();

    /* renamed from: d */
    private int f12670d;

    /* renamed from: e */
    private int f12671e;

    /* renamed from: f */
    private double f12672f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f12673g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f12674h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f12675i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C4701w2.C4713k f12676j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public WebView f12677k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public RelativeLayout f12678l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C4609p f12679m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C4666i f12680n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Runnable f12681o;

    /* renamed from: com.onesignal.u$a */
    /* compiled from: InAppMessageView */
    class C4658a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f12682a;

        C4658a(int i) {
            this.f12682a = i;
        }

        public void run() {
            if (C4657u.this.f12677k == null) {
                C4564n1.m15815b(C4564n1.C4566a0.WARN, "WebView height update skipped, new height will be used once it is displayed.");
                return;
            }
            ViewGroup.LayoutParams layoutParams = C4657u.this.f12677k.getLayoutParams();
            layoutParams.height = this.f12682a;
            C4657u.this.f12677k.setLayoutParams(layoutParams);
            if (C4657u.this.f12679m != null) {
                C4609p b = C4657u.this.f12679m;
                C4657u uVar = C4657u.this;
                b.mo29897a(uVar.m16178a(this.f12682a, uVar.f12676j));
            }
        }
    }

    /* renamed from: com.onesignal.u$b */
    /* compiled from: InAppMessageView */
    class C4659b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RelativeLayout.LayoutParams f12684a;

        /* renamed from: b */
        final /* synthetic */ LinearLayout.LayoutParams f12685b;

        /* renamed from: c */
        final /* synthetic */ C4609p.C4612c f12686c;

        /* renamed from: d */
        final /* synthetic */ C4701w2.C4713k f12687d;

        C4659b(RelativeLayout.LayoutParams layoutParams, LinearLayout.LayoutParams layoutParams2, C4609p.C4612c cVar, C4701w2.C4713k kVar) {
            this.f12684a = layoutParams;
            this.f12685b = layoutParams2;
            this.f12686c = cVar;
            this.f12687d = kVar;
        }

        public void run() {
            if (C4657u.this.f12677k != null) {
                C4657u.this.f12677k.setLayoutParams(this.f12684a);
                Context applicationContext = C4657u.this.f12668b.getApplicationContext();
                C4657u.this.m16181a(applicationContext, this.f12685b, this.f12686c);
                C4657u.this.m16197b(applicationContext);
                C4657u uVar = C4657u.this;
                uVar.m16185a(uVar.f12678l);
                if (C4657u.this.f12680n != null) {
                    C4657u uVar2 = C4657u.this;
                    uVar2.m16193a(this.f12687d, (View) uVar2.f12679m, (View) C4657u.this.f12678l);
                    C4657u.this.f12680n.mo29985b();
                }
                C4657u.this.m16213i();
            }
        }
    }

    /* renamed from: com.onesignal.u$c */
    /* compiled from: InAppMessageView */
    class C4660c implements C4609p.C4611b {
        C4660c() {
        }

        /* renamed from: a */
        public void mo29900a() {
            boolean unused = C4657u.this.f12675i = true;
        }

        /* renamed from: b */
        public void mo29901b() {
            boolean unused = C4657u.this.f12675i = false;
        }

        public void onDismiss() {
            C4657u.this.m16199b((C4701w2.C4712j) null);
        }
    }

    /* renamed from: com.onesignal.u$d */
    /* compiled from: InAppMessageView */
    class C4661d implements Runnable {
        C4661d() {
        }

        public void run() {
            if (C4657u.this.f12668b != null) {
                C4657u.this.mo29973a((C4701w2.C4712j) null);
                Runnable unused = C4657u.this.f12681o = null;
                return;
            }
            boolean unused2 = C4657u.this.f12674h = true;
        }
    }

    /* renamed from: com.onesignal.u$e */
    /* compiled from: InAppMessageView */
    class C4662e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Activity f12691a;

        C4662e(Activity activity) {
            this.f12691a = activity;
        }

        public void run() {
            C4657u.this.m16201c(this.f12691a);
        }
    }

    /* renamed from: com.onesignal.u$f */
    /* compiled from: InAppMessageView */
    class C4663f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C4701w2.C4712j f12693a;

        C4663f(C4701w2.C4712j jVar) {
            this.f12693a = jVar;
        }

        public void run() {
            if (!C4657u.this.f12673g || C4657u.this.f12678l == null) {
                C4657u.this.m16204e();
                C4701w2.C4712j jVar = this.f12693a;
                if (jVar != null) {
                    jVar.onComplete();
                    return;
                }
                return;
            }
            C4657u uVar = C4657u.this;
            uVar.m16184a((View) uVar.f12678l, this.f12693a);
        }
    }

    /* renamed from: com.onesignal.u$g */
    /* compiled from: InAppMessageView */
    class C4664g extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ C4701w2.C4712j f12695a;

        C4664g(C4701w2.C4712j jVar) {
            this.f12695a = jVar;
        }

        public void onAnimationEnd(Animator animator) {
            C4657u.this.m16204e();
            C4701w2.C4712j jVar = this.f12695a;
            if (jVar != null) {
                jVar.onComplete();
            }
        }
    }

    /* renamed from: com.onesignal.u$h */
    /* compiled from: InAppMessageView */
    static /* synthetic */ class C4665h {

        /* renamed from: a */
        static final /* synthetic */ int[] f12697a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.onesignal.w2$k[] r0 = com.onesignal.C4701w2.C4713k.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12697a = r0
                com.onesignal.w2$k r1 = com.onesignal.C4701w2.C4713k.TOP_BANNER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12697a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.onesignal.w2$k r1 = com.onesignal.C4701w2.C4713k.BOTTOM_BANNER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12697a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.onesignal.w2$k r1 = com.onesignal.C4701w2.C4713k.CENTER_MODAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12697a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.onesignal.w2$k r1 = com.onesignal.C4701w2.C4713k.FULL_SCREEN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4657u.C4665h.<clinit>():void");
        }
    }

    /* renamed from: com.onesignal.u$i */
    /* compiled from: InAppMessageView */
    interface C4666i {
        /* renamed from: a */
        void mo29984a();

        /* renamed from: b */
        void mo29985b();
    }

    C4657u(WebView webView, C4701w2.C4713k kVar, int i, double d) {
        this.f12677k = webView;
        this.f12676j = kVar;
        this.f12671e = i;
        this.f12670d = -1;
        this.f12672f = Double.isNaN(d) ? 0.0d : d;
        this.f12673g = !kVar.mo30025a();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m16204e() {
        C4564n1.m15815b(C4564n1.C4566a0.DEBUG, "InAppMessageView cleanupViewsAfterDismiss");
        mo29977d();
        C4666i iVar = this.f12680n;
        if (iVar != null) {
            iVar.mo29984a();
        }
    }

    /* renamed from: f */
    private LinearLayout.LayoutParams m16206f() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f12670d, -1);
        int i = C4665h.f12697a[this.f12676j.ordinal()];
        if (i == 1) {
            layoutParams.gravity = 49;
        } else if (i == 2) {
            layoutParams.gravity = 81;
        } else if (i == 3 || i == 4) {
            layoutParams.gravity = 17;
        }
        return layoutParams;
    }

    /* renamed from: g */
    private void m16209g() {
        this.f12678l = null;
        this.f12679m = null;
        this.f12677k = null;
    }

    /* renamed from: h */
    private int m16210h() {
        return C4543l1.m15666b(this.f12668b);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m16213i() {
        if (this.f12672f > 0.0d && this.f12681o == null) {
            C4661d dVar = new C4661d();
            this.f12681o = dVar;
            this.f12669c.postDelayed(dVar, ((long) this.f12672f) * 1000);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo29976c() {
        return this.f12675i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo29977d() {
        Runnable runnable = this.f12681o;
        if (runnable != null) {
            this.f12669c.removeCallbacks(runnable);
            this.f12681o = null;
        }
        C4609p pVar = this.f12679m;
        if (pVar != null) {
            pVar.removeAllViews();
        }
        PopupWindow popupWindow = this.f12667a;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        m16209g();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16201c(Activity activity) {
        if (!C4543l1.m15671g(activity) || this.f12678l != null) {
            new Handler().postDelayed(new C4662e(activity), 200);
        } else {
            mo29970a(activity);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C4701w2.C4713k mo29974b() {
        return this.f12676j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29975b(Activity activity) {
        m16201c(activity);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16197b(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f12678l = relativeLayout;
        relativeLayout.setBackgroundDrawable(new ColorDrawable(0));
        this.f12678l.setClipChildren(false);
        this.f12678l.setClipToPadding(false);
        this.f12678l.addView(this.f12679m);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16199b(C4701w2.C4712j jVar) {
        C4536k1.m15623a((Runnable) new C4663f(jVar), 600);
    }

    /* renamed from: b */
    private void m16198b(View view, int i) {
        C4606o1.m15923a(view, (float) ((-i) - f12665r), 0.0f, 1000, new C4614p1(0.1d, 8.0d), (Animation.AnimationListener) null).start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29971a(WebView webView) {
        this.f12677k = webView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29972a(C4666i iVar) {
        this.f12680n = iVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29968a() {
        if (this.f12674h) {
            this.f12674h = false;
            m16199b((C4701w2.C4712j) null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29969a(int i) {
        this.f12671e = i;
        C4536k1.m15622a((Runnable) new C4658a(i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29970a(Activity activity) {
        this.f12668b = activity;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f12671e);
        layoutParams.addRule(13);
        LinearLayout.LayoutParams f = this.f12673g ? m16206f() : null;
        C4701w2.C4713k kVar = this.f12676j;
        m16194a(kVar, layoutParams, f, m16178a(this.f12671e, kVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C4609p.C4612c m16178a(int i, C4701w2.C4713k kVar) {
        C4609p.C4612c cVar = new C4609p.C4612c();
        int i2 = f12665r;
        cVar.f12583d = i2;
        cVar.f12581b = i2;
        cVar.f12584e = i;
        m16210h();
        int i3 = C4665h.f12697a[kVar.ordinal()];
        int i4 = 1;
        if (i3 == 1) {
            cVar.f12582c = f12665r - f12666s;
        } else if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 4) {
                    i = m16210h() - (f12665r * 2);
                    cVar.f12584e = i;
                }
            }
            int h = (m16210h() / 2) - (i / 2);
            cVar.f12582c = f12666s + h;
            cVar.f12581b = h;
            cVar.f12580a = h;
        } else {
            cVar.f12580a = m16210h() - i;
            cVar.f12582c = f12665r + f12666s;
        }
        if (kVar == C4701w2.C4713k.TOP_BANNER) {
            i4 = 0;
        }
        cVar.f12585f = i4;
        return cVar;
    }

    /* renamed from: a */
    private void m16194a(C4701w2.C4713k kVar, RelativeLayout.LayoutParams layoutParams, LinearLayout.LayoutParams layoutParams2, C4609p.C4612c cVar) {
        C4536k1.m15622a((Runnable) new C4659b(layoutParams, layoutParams2, cVar, kVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16185a(RelativeLayout relativeLayout) {
        int i;
        int i2 = -1;
        int i3 = this.f12673g ? -1 : this.f12670d;
        if (!this.f12673g) {
            i2 = -2;
        }
        PopupWindow popupWindow = new PopupWindow(relativeLayout, i3, i2);
        this.f12667a = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.f12667a.setTouchable(true);
        if (!this.f12673g) {
            int i4 = C4665h.f12697a[this.f12676j.ordinal()];
            if (i4 == 1) {
                i = 49;
            } else if (i4 == 2) {
                i = 81;
            }
            C0878h.m2932a(this.f12667a, 1003);
            this.f12667a.showAtLocation(this.f12668b.getWindow().getDecorView().getRootView(), i, 0, 0);
        }
        i = 0;
        C0878h.m2932a(this.f12667a, 1003);
        this.f12667a.showAtLocation(this.f12668b.getWindow().getDecorView().getRootView(), i, 0, 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16181a(Context context, LinearLayout.LayoutParams layoutParams, C4609p.C4612c cVar) {
        C4609p pVar = new C4609p(context);
        this.f12679m = pVar;
        if (layoutParams != null) {
            pVar.setLayoutParams(layoutParams);
        }
        this.f12679m.mo29897a(cVar);
        this.f12679m.mo29896a((C4609p.C4611b) new C4660c());
        if (this.f12677k.getParent() != null) {
            ((ViewGroup) this.f12677k.getParent()).removeAllViews();
        }
        CardView a = m16177a(context);
        a.addView(this.f12677k);
        C4609p pVar2 = this.f12679m;
        int i = f12665r;
        pVar2.setPadding(i, i, i, i);
        this.f12679m.setClipChildren(false);
        this.f12679m.setClipToPadding(false);
        this.f12679m.addView(a);
    }

    /* renamed from: a */
    private CardView m16177a(Context context) {
        CardView cardView = new CardView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f12676j == C4701w2.C4713k.FULL_SCREEN ? -1 : -2);
        layoutParams.addRule(13);
        cardView.setLayoutParams(layoutParams);
        cardView.mo3668b((float) C4543l1.m15662a(8));
        cardView.mo3665a((float) C4543l1.m15662a(5));
        cardView.setClipChildren(false);
        cardView.setClipToPadding(false);
        cardView.mo3666a(false);
        return cardView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29973a(C4701w2.C4712j jVar) {
        C4609p pVar = this.f12679m;
        if (pVar == null) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "No host presenter to trigger dismiss animation, counting as dismissed already", new Throwable());
            m16209g();
            if (jVar != null) {
                jVar.onComplete();
                return;
            }
            return;
        }
        pVar.mo29895a();
        m16199b(jVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16193a(C4701w2.C4713k kVar, View view, View view2) {
        int i = C4665h.f12697a[kVar.ordinal()];
        if (i == 1) {
            m16198b(((ViewGroup) view).getChildAt(0), this.f12677k.getHeight());
        } else if (i == 2) {
            m16182a(((ViewGroup) view).getChildAt(0), this.f12677k.getHeight());
        } else if (i == 3 || i == 4) {
            m16183a(view, view2);
        }
    }

    /* renamed from: a */
    private void m16182a(View view, int i) {
        C4606o1.m15923a(view, (float) (i + f12665r), 0.0f, 1000, new C4614p1(0.1d, 8.0d), (Animation.AnimationListener) null).start();
    }

    /* renamed from: a */
    private void m16183a(View view, View view2) {
        Animation a = C4606o1.m15924a(view, 1000, new C4614p1(0.1d, 8.0d), (Animation.AnimationListener) null);
        ValueAnimator a2 = m16175a(view2, 400, f12663p, f12664q, (Animator.AnimatorListener) null);
        a.start();
        a2.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16184a(View view, C4701w2.C4712j jVar) {
        View view2 = view;
        m16175a(view2, 400, f12664q, f12663p, new C4664g(jVar)).start();
    }

    /* renamed from: a */
    private ValueAnimator m16175a(View view, int i, int i2, int i3, Animator.AnimatorListener animatorListener) {
        return C4606o1.m15922a(view, i, i2, i3, animatorListener);
    }
}
