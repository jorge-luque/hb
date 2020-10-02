package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.p020f.C0839t;
import androidx.core.p020f.C0848u;

/* renamed from: androidx.appcompat.widget.j0 */
/* compiled from: TooltipCompatHandler */
class C0606j0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: j */
    private static C0606j0 f1475j;

    /* renamed from: k */
    private static C0606j0 f1476k;

    /* renamed from: a */
    private final View f1477a;

    /* renamed from: b */
    private final CharSequence f1478b;

    /* renamed from: c */
    private final int f1479c;

    /* renamed from: d */
    private final Runnable f1480d = new C0607a();

    /* renamed from: e */
    private final Runnable f1481e = new C0608b();

    /* renamed from: f */
    private int f1482f;

    /* renamed from: g */
    private int f1483g;

    /* renamed from: h */
    private C0610k0 f1484h;

    /* renamed from: i */
    private boolean f1485i;

    /* renamed from: androidx.appcompat.widget.j0$a */
    /* compiled from: TooltipCompatHandler */
    class C0607a implements Runnable {
        C0607a() {
        }

        public void run() {
            C0606j0.this.mo3493a(false);
        }
    }

    /* renamed from: androidx.appcompat.widget.j0$b */
    /* compiled from: TooltipCompatHandler */
    class C0608b implements Runnable {
        C0608b() {
        }

        public void run() {
            C0606j0.this.mo3492a();
        }
    }

    private C0606j0(View view, CharSequence charSequence) {
        this.f1477a = view;
        this.f1478b = charSequence;
        this.f1479c = C0848u.m2759a(ViewConfiguration.get(view.getContext()));
        m1689c();
        this.f1477a.setOnLongClickListener(this);
        this.f1477a.setOnHoverListener(this);
    }

    /* renamed from: a */
    public static void m1685a(View view, CharSequence charSequence) {
        C0606j0 j0Var = f1475j;
        if (j0Var != null && j0Var.f1477a == view) {
            m1686a((C0606j0) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            C0606j0 j0Var2 = f1476k;
            if (j0Var2 != null && j0Var2.f1477a == view) {
                j0Var2.mo3492a();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new C0606j0(view, charSequence);
    }

    /* renamed from: b */
    private void m1688b() {
        this.f1477a.removeCallbacks(this.f1480d);
    }

    /* renamed from: c */
    private void m1689c() {
        this.f1482f = Integer.MAX_VALUE;
        this.f1483g = Integer.MAX_VALUE;
    }

    /* renamed from: d */
    private void m1690d() {
        this.f1477a.postDelayed(this.f1480d, (long) ViewConfiguration.getLongPressTimeout());
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1484h != null && this.f1485i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1477a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                m1689c();
                mo3492a();
            }
        } else if (this.f1477a.isEnabled() && this.f1484h == null && m1687a(motionEvent)) {
            m1686a(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f1482f = view.getWidth() / 2;
        this.f1483g = view.getHeight() / 2;
        mo3493a(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        mo3492a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3493a(boolean z) {
        long j;
        int i;
        long j2;
        if (C0839t.m2735x(this.f1477a)) {
            m1686a((C0606j0) null);
            C0606j0 j0Var = f1476k;
            if (j0Var != null) {
                j0Var.mo3492a();
            }
            f1476k = this;
            this.f1485i = z;
            C0610k0 k0Var = new C0610k0(this.f1477a.getContext());
            this.f1484h = k0Var;
            k0Var.mo3505a(this.f1477a, this.f1482f, this.f1483g, this.f1485i, this.f1478b);
            this.f1477a.addOnAttachStateChangeListener(this);
            if (this.f1485i) {
                j = 2500;
            } else {
                if ((C0839t.m2730s(this.f1477a) & 1) == 1) {
                    j2 = 3000;
                    i = ViewConfiguration.getLongPressTimeout();
                } else {
                    j2 = 15000;
                    i = ViewConfiguration.getLongPressTimeout();
                }
                j = j2 - ((long) i);
            }
            this.f1477a.removeCallbacks(this.f1481e);
            this.f1477a.postDelayed(this.f1481e, j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3492a() {
        if (f1476k == this) {
            f1476k = null;
            C0610k0 k0Var = this.f1484h;
            if (k0Var != null) {
                k0Var.mo3504a();
                this.f1484h = null;
                m1689c();
                this.f1477a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1475j == this) {
            m1686a((C0606j0) null);
        }
        this.f1477a.removeCallbacks(this.f1481e);
    }

    /* renamed from: a */
    private static void m1686a(C0606j0 j0Var) {
        C0606j0 j0Var2 = f1475j;
        if (j0Var2 != null) {
            j0Var2.m1688b();
        }
        f1475j = j0Var;
        if (j0Var != null) {
            j0Var.m1690d();
        }
    }

    /* renamed from: a */
    private boolean m1687a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f1482f) <= this.f1479c && Math.abs(y - this.f1483g) <= this.f1479c) {
            return false;
        }
        this.f1482f = x;
        this.f1483g = y;
        return true;
    }
}
