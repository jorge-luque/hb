package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.C0497m;
import androidx.appcompat.widget.C0631v;
import androidx.core.p020f.C0839t;

/* renamed from: androidx.appcompat.view.menu.q */
/* compiled from: StandardMenuPopup */
final class C0503q extends C0494k implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, C0497m, View.OnKeyListener {

    /* renamed from: v */
    private static final int f916v = R$layout.abc_popup_menu_item_layout;

    /* renamed from: b */
    private final Context f917b;

    /* renamed from: c */
    private final C0482g f918c;

    /* renamed from: d */
    private final C0481f f919d;

    /* renamed from: e */
    private final boolean f920e;

    /* renamed from: f */
    private final int f921f;

    /* renamed from: g */
    private final int f922g;

    /* renamed from: h */
    private final int f923h;

    /* renamed from: i */
    final C0631v f924i;

    /* renamed from: j */
    final ViewTreeObserver.OnGlobalLayoutListener f925j = new C0504a();

    /* renamed from: k */
    private final View.OnAttachStateChangeListener f926k = new C0505b();

    /* renamed from: l */
    private PopupWindow.OnDismissListener f927l;

    /* renamed from: m */
    private View f928m;

    /* renamed from: n */
    View f929n;

    /* renamed from: o */
    private C0497m.C0498a f930o;

    /* renamed from: p */
    ViewTreeObserver f931p;

    /* renamed from: q */
    private boolean f932q;

    /* renamed from: r */
    private boolean f933r;

    /* renamed from: s */
    private int f934s;

    /* renamed from: t */
    private int f935t = 0;

    /* renamed from: u */
    private boolean f936u;

    /* renamed from: androidx.appcompat.view.menu.q$a */
    /* compiled from: StandardMenuPopup */
    class C0504a implements ViewTreeObserver.OnGlobalLayoutListener {
        C0504a() {
        }

        public void onGlobalLayout() {
            if (C0503q.this.mo2476a() && !C0503q.this.f924i.mo3181k()) {
                View view = C0503q.this.f929n;
                if (view == null || !view.isShown()) {
                    C0503q.this.dismiss();
                } else {
                    C0503q.this.f924i.show();
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.q$b */
    /* compiled from: StandardMenuPopup */
    class C0505b implements View.OnAttachStateChangeListener {
        C0505b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = C0503q.this.f931p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    C0503q.this.f931p = view.getViewTreeObserver();
                }
                C0503q qVar = C0503q.this;
                qVar.f931p.removeGlobalOnLayoutListener(qVar.f925j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public C0503q(Context context, C0482g gVar, View view, int i, int i2, boolean z) {
        this.f917b = context;
        this.f918c = gVar;
        this.f920e = z;
        this.f919d = new C0481f(gVar, LayoutInflater.from(context), this.f920e, f916v);
        this.f922g = i;
        this.f923h = i2;
        Resources resources = context.getResources();
        this.f921f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f928m = view;
        this.f924i = new C0631v(this.f917b, (AttributeSet) null, this.f922g, this.f923h);
        gVar.mo2524a((C0497m) this, context);
    }

    /* renamed from: f */
    private boolean m1041f() {
        View view;
        if (mo2476a()) {
            return true;
        }
        if (this.f932q || (view = this.f928m) == null) {
            return false;
        }
        this.f929n = view;
        this.f924i.mo3163a((PopupWindow.OnDismissListener) this);
        this.f924i.mo3162a((AdapterView.OnItemClickListener) this);
        this.f924i.mo3164a(true);
        View view2 = this.f929n;
        boolean z = this.f931p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f931p = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f925j);
        }
        view2.addOnAttachStateChangeListener(this.f926k);
        this.f924i.mo3161a(view2);
        this.f924i.mo3172f(this.f935t);
        if (!this.f933r) {
            this.f934s = C0494k.m994a(this.f919d, (ViewGroup) null, this.f917b, this.f921f);
            this.f933r = true;
        }
        this.f924i.mo3170e(this.f934s);
        this.f924i.mo3174g(2);
        this.f924i.mo3159a(mo2715d());
        this.f924i.show();
        ListView e = this.f924i.mo2484e();
        e.setOnKeyListener(this);
        if (this.f936u && this.f918c.mo2562h() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f917b).inflate(R$layout.abc_popup_menu_header_item_layout, e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f918c.mo2562h());
            }
            frameLayout.setEnabled(false);
            e.addHeaderView(frameLayout, (Object) null, false);
        }
        this.f924i.mo3048a((ListAdapter) this.f919d);
        this.f924i.show();
        return true;
    }

    /* renamed from: a */
    public void mo2472a(int i) {
        this.f935t = i;
    }

    /* renamed from: a */
    public void mo2475a(C0482g gVar) {
    }

    /* renamed from: b */
    public void mo2478b(boolean z) {
        this.f919d.mo2505a(z);
    }

    /* renamed from: b */
    public boolean mo2479b() {
        return false;
    }

    /* renamed from: c */
    public void mo2480c(int i) {
        this.f924i.mo3166b(i);
    }

    public void dismiss() {
        if (mo2476a()) {
            this.f924i.dismiss();
        }
    }

    /* renamed from: e */
    public ListView mo2484e() {
        return this.f924i.mo2484e();
    }

    public void onDismiss() {
        this.f932q = true;
        this.f918c.close();
        ViewTreeObserver viewTreeObserver = this.f931p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f931p = this.f929n.getViewTreeObserver();
            }
            this.f931p.removeGlobalOnLayoutListener(this.f925j);
            this.f931p = null;
        }
        this.f929n.removeOnAttachStateChangeListener(this.f926k);
        PopupWindow.OnDismissListener onDismissListener = this.f927l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void show() {
        if (!m1041f()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    /* renamed from: a */
    public boolean mo2476a() {
        return !this.f932q && this.f924i.mo2476a();
    }

    /* renamed from: b */
    public void mo2477b(int i) {
        this.f924i.mo3158a(i);
    }

    /* renamed from: c */
    public void mo2481c(boolean z) {
        this.f936u = z;
    }

    /* renamed from: a */
    public void mo2460a(boolean z) {
        this.f933r = false;
        C0481f fVar = this.f919d;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void mo2459a(C0497m.C0498a aVar) {
        this.f930o = aVar;
    }

    /* renamed from: a */
    public boolean mo2464a(C0506r rVar) {
        if (rVar.hasVisibleItems()) {
            C0495l lVar = new C0495l(this.f917b, rVar, this.f929n, this.f920e, this.f922g, this.f923h);
            lVar.mo2721a(this.f930o);
            lVar.mo2722a(C0494k.m996b((C0482g) rVar));
            lVar.mo2720a(this.f927l);
            this.f927l = null;
            this.f918c.mo2526a(false);
            int b = this.f924i.mo3165b();
            int f = this.f924i.mo3171f();
            if ((Gravity.getAbsoluteGravity(this.f935t, C0839t.m2725n(this.f928m)) & 7) == 5) {
                b += this.f928m.getWidth();
            }
            if (lVar.mo2723a(b, f)) {
                C0497m.C0498a aVar = this.f930o;
                if (aVar == null) {
                    return true;
                }
                aVar.mo2089a(rVar);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo2457a(C0482g gVar, boolean z) {
        if (gVar == this.f918c) {
            dismiss();
            C0497m.C0498a aVar = this.f930o;
            if (aVar != null) {
                aVar.mo2088a(gVar, z);
            }
        }
    }

    /* renamed from: a */
    public void mo2473a(View view) {
        this.f928m = view;
    }

    /* renamed from: a */
    public void mo2474a(PopupWindow.OnDismissListener onDismissListener) {
        this.f927l = onDismissListener;
    }
}
