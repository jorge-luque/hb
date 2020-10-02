package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.C0470a;
import androidx.appcompat.view.menu.C0482g;
import androidx.appcompat.view.menu.C0497m;
import androidx.appcompat.widget.Toolbar;
import androidx.core.p020f.C0839t;
import androidx.core.p020f.C0851x;
import androidx.core.p020f.C0855y;
import androidx.core.p020f.C0856z;

/* renamed from: androidx.appcompat.widget.h0 */
/* compiled from: ToolbarWidgetWrapper */
public class C0600h0 implements C0620p {

    /* renamed from: a */
    Toolbar f1446a;

    /* renamed from: b */
    private int f1447b;

    /* renamed from: c */
    private View f1448c;

    /* renamed from: d */
    private View f1449d;

    /* renamed from: e */
    private Drawable f1450e;

    /* renamed from: f */
    private Drawable f1451f;

    /* renamed from: g */
    private Drawable f1452g;

    /* renamed from: h */
    private boolean f1453h;

    /* renamed from: i */
    CharSequence f1454i;

    /* renamed from: j */
    private CharSequence f1455j;

    /* renamed from: k */
    private CharSequence f1456k;

    /* renamed from: l */
    Window.Callback f1457l;

    /* renamed from: m */
    boolean f1458m;

    /* renamed from: n */
    private C0576c f1459n;

    /* renamed from: o */
    private int f1460o;

    /* renamed from: p */
    private int f1461p;

    /* renamed from: q */
    private Drawable f1462q;

    /* renamed from: androidx.appcompat.widget.h0$a */
    /* compiled from: ToolbarWidgetWrapper */
    class C0601a implements View.OnClickListener {

        /* renamed from: a */
        final C0470a f1463a = new C0470a(C0600h0.this.f1446a.getContext(), 0, 16908332, 0, 0, C0600h0.this.f1454i);

        C0601a() {
        }

        public void onClick(View view) {
            C0600h0 h0Var = C0600h0.this;
            Window.Callback callback = h0Var.f1457l;
            if (callback != null && h0Var.f1458m) {
                callback.onMenuItemSelected(0, this.f1463a);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.h0$b */
    /* compiled from: ToolbarWidgetWrapper */
    class C0602b extends C0856z {

        /* renamed from: a */
        private boolean f1465a = false;

        /* renamed from: b */
        final /* synthetic */ int f1466b;

        C0602b(int i) {
            this.f1466b = i;
        }

        /* renamed from: a */
        public void mo3360a(View view) {
            this.f1465a = true;
        }

        /* renamed from: b */
        public void mo2086b(View view) {
            if (!this.f1465a) {
                C0600h0.this.f1446a.setVisibility(this.f1466b);
            }
        }

        /* renamed from: c */
        public void mo2087c(View view) {
            C0600h0.this.f1446a.setVisibility(0);
        }
    }

    public C0600h0(Toolbar toolbar, boolean z) {
        this(toolbar, z, R$string.abc_action_bar_up_description, R$drawable.abc_ic_ab_back_material);
    }

    /* renamed from: e */
    private void m1630e(CharSequence charSequence) {
        this.f1454i = charSequence;
        if ((this.f1447b & 8) != 0) {
            this.f1446a.mo3307d(charSequence);
        }
    }

    /* renamed from: n */
    private int m1631n() {
        if (this.f1446a.mo3320n() == null) {
            return 11;
        }
        this.f1462q = this.f1446a.mo3320n();
        return 15;
    }

    /* renamed from: o */
    private void m1632o() {
        if ((this.f1447b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f1456k)) {
            this.f1446a.mo3296b(this.f1461p);
        } else {
            this.f1446a.mo3300b(this.f1456k);
        }
    }

    /* renamed from: p */
    private void m1633p() {
        if ((this.f1447b & 4) != 0) {
            Toolbar toolbar = this.f1446a;
            Drawable drawable = this.f1452g;
            if (drawable == null) {
                drawable = this.f1462q;
            }
            toolbar.mo3299b(drawable);
            return;
        }
        this.f1446a.mo3299b((Drawable) null);
    }

    /* renamed from: q */
    private void m1634q() {
        Drawable drawable;
        int i = this.f1447b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.f1451f;
            if (drawable == null) {
                drawable = this.f1450e;
            }
        } else {
            drawable = this.f1450e;
        }
        this.f1446a.mo3291a(drawable);
    }

    /* renamed from: a */
    public void mo3453a(Window.Callback callback) {
        this.f1457l = callback;
    }

    /* renamed from: a */
    public void mo3456a(boolean z) {
    }

    /* renamed from: b */
    public void mo3460b(Drawable drawable) {
        this.f1451f = drawable;
        m1634q();
    }

    /* renamed from: c */
    public void mo3463c(int i) {
        if (i != this.f1461p) {
            this.f1461p = i;
            if (TextUtils.isEmpty(this.f1446a.mo3319m())) {
                mo3468d(this.f1461p);
            }
        }
    }

    public void collapseActionView() {
        this.f1446a.mo3302c();
    }

    /* renamed from: d */
    public void mo3469d(CharSequence charSequence) {
        this.f1453h = true;
        m1630e(charSequence);
    }

    /* renamed from: f */
    public boolean mo3472f() {
        return this.f1446a.mo3337w();
    }

    /* renamed from: g */
    public void mo3473g() {
        this.f1446a.mo3306d();
    }

    public Context getContext() {
        return this.f1446a.getContext();
    }

    /* renamed from: h */
    public boolean mo3475h() {
        return this.f1446a.mo3332r();
    }

    /* renamed from: i */
    public int mo3476i() {
        return this.f1460o;
    }

    /* renamed from: j */
    public ViewGroup mo3477j() {
        return this.f1446a;
    }

    /* renamed from: k */
    public int mo3478k() {
        return this.f1447b;
    }

    /* renamed from: l */
    public void mo3479l() {
    }

    /* renamed from: m */
    public void mo3480m() {
    }

    public C0600h0(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.f1460o = 0;
        this.f1461p = 0;
        this.f1446a = toolbar;
        this.f1454i = toolbar.mo3330p();
        this.f1455j = toolbar.mo3321o();
        this.f1453h = this.f1454i != null;
        this.f1452g = toolbar.mo3320n();
        C0598g0 a = C0598g0.m1610a(toolbar.getContext(), (AttributeSet) null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.f1462q = a.mo3437b(R$styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence e = a.mo3443e(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(e)) {
                mo3469d(e);
            }
            CharSequence e2 = a.mo3443e(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(e2)) {
                mo3465c(e2);
            }
            Drawable b = a.mo3437b(R$styleable.ActionBar_logo);
            if (b != null) {
                mo3460b(b);
            }
            Drawable b2 = a.mo3437b(R$styleable.ActionBar_icon);
            if (b2 != null) {
                mo3450a(b2);
            }
            if (this.f1452g == null && (drawable = this.f1462q) != null) {
                mo3464c(drawable);
            }
            mo3449a(a.mo3440d(R$styleable.ActionBar_displayOptions, 0));
            int g = a.mo3446g(R$styleable.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                mo3452a(LayoutInflater.from(this.f1446a.getContext()).inflate(g, this.f1446a, false));
                mo3449a(this.f1447b | 16);
            }
            int f = a.mo3444f(R$styleable.ActionBar_height, 0);
            if (f > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1446a.getLayoutParams();
                layoutParams.height = f;
                this.f1446a.setLayoutParams(layoutParams);
            }
            int b3 = a.mo3436b(R$styleable.ActionBar_contentInsetStart, -1);
            int b4 = a.mo3436b(R$styleable.ActionBar_contentInsetEnd, -1);
            if (b3 >= 0 || b4 >= 0) {
                this.f1446a.mo3288a(Math.max(b3, 0), Math.max(b4, 0));
            }
            int g2 = a.mo3446g(R$styleable.ActionBar_titleTextStyle, 0);
            if (g2 != 0) {
                Toolbar toolbar2 = this.f1446a;
                toolbar2.mo3297b(toolbar2.getContext(), g2);
            }
            int g3 = a.mo3446g(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (g3 != 0) {
                Toolbar toolbar3 = this.f1446a;
                toolbar3.mo3289a(toolbar3.getContext(), g3);
            }
            int g4 = a.mo3446g(R$styleable.ActionBar_popupTheme, 0);
            if (g4 != 0) {
                this.f1446a.mo3303c(g4);
            }
        } else {
            this.f1447b = m1631n();
        }
        a.mo3434a();
        mo3463c(i);
        this.f1456k = this.f1446a.mo3319m();
        this.f1446a.mo3292a((View.OnClickListener) new C0601a());
    }

    /* renamed from: a */
    public void mo3455a(CharSequence charSequence) {
        if (!this.f1453h) {
            m1630e(charSequence);
        }
    }

    /* renamed from: b */
    public void mo3458b() {
        this.f1458m = true;
    }

    /* renamed from: d */
    public boolean mo3470d() {
        return this.f1446a.mo3334t();
    }

    /* renamed from: a */
    public void mo3450a(Drawable drawable) {
        this.f1450e = drawable;
        m1634q();
    }

    /* renamed from: b */
    public void mo3462b(boolean z) {
        this.f1446a.mo3295a(z);
    }

    /* renamed from: d */
    public void mo3468d(int i) {
        mo3461b((CharSequence) i == 0 ? null : getContext().getString(i));
    }

    /* renamed from: e */
    public boolean mo3471e() {
        return this.f1446a.mo3333s();
    }

    /* renamed from: b */
    public void mo3461b(CharSequence charSequence) {
        this.f1456k = charSequence;
        m1632o();
    }

    /* renamed from: c */
    public void mo3465c(CharSequence charSequence) {
        this.f1455j = charSequence;
        if ((this.f1447b & 8) != 0) {
            this.f1446a.mo3304c(charSequence);
        }
    }

    /* renamed from: a */
    public boolean mo3457a() {
        return this.f1446a.mo3335u();
    }

    /* renamed from: a */
    public void mo3451a(Menu menu, C0497m.C0498a aVar) {
        if (this.f1459n == null) {
            C0576c cVar = new C0576c(this.f1446a.getContext());
            this.f1459n = cVar;
            cVar.mo2454a(R$id.action_menu_presenter);
        }
        this.f1459n.mo2459a(aVar);
        this.f1446a.mo3293a((C0482g) menu, this.f1459n);
    }

    /* renamed from: b */
    public void mo3459b(int i) {
        this.f1446a.setVisibility(i);
    }

    /* renamed from: c */
    public boolean mo3466c() {
        return this.f1446a.mo3301b();
    }

    /* renamed from: c */
    public void mo3464c(Drawable drawable) {
        this.f1452g = drawable;
        m1633p();
    }

    /* renamed from: a */
    public void mo3449a(int i) {
        View view;
        int i2 = this.f1447b ^ i;
        this.f1447b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m1632o();
                }
                m1633p();
            }
            if ((i2 & 3) != 0) {
                m1634q();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f1446a.mo3307d(this.f1454i);
                    this.f1446a.mo3304c(this.f1455j);
                } else {
                    this.f1446a.mo3307d((CharSequence) null);
                    this.f1446a.mo3304c((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0 && (view = this.f1449d) != null) {
                if ((i & 16) != 0) {
                    this.f1446a.addView(view);
                } else {
                    this.f1446a.removeView(view);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3454a(C0642z zVar) {
        Toolbar toolbar;
        View view = this.f1448c;
        if (view != null && view.getParent() == (toolbar = this.f1446a)) {
            toolbar.removeView(this.f1448c);
        }
        this.f1448c = zVar;
        if (zVar != null && this.f1460o == 2) {
            this.f1446a.addView(zVar, 0);
            Toolbar.C0568e eVar = (Toolbar.C0568e) this.f1448c.getLayoutParams();
            eVar.width = -2;
            eVar.height = -2;
            eVar.f406a = 8388691;
            zVar.mo3638a(true);
            throw null;
        }
    }

    /* renamed from: a */
    public void mo3452a(View view) {
        View view2 = this.f1449d;
        if (!(view2 == null || (this.f1447b & 16) == 0)) {
            this.f1446a.removeView(view2);
        }
        this.f1449d = view;
        if (view != null && (this.f1447b & 16) != 0) {
            this.f1446a.addView(view);
        }
    }

    /* renamed from: a */
    public C0851x mo3448a(int i, long j) {
        C0851x a = C0839t.m2688a(this.f1446a);
        a.mo4206a(i == 0 ? 1.0f : 0.0f);
        a.mo4207a(j);
        a.mo4210a((C0855y) new C0602b(i));
        return a;
    }
}
