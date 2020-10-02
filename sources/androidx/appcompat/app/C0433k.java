package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.C0399a;
import androidx.appcompat.p011d.C0454a;
import androidx.appcompat.p011d.C0455b;
import androidx.appcompat.p011d.C0462g;
import androidx.appcompat.p011d.C0465h;
import androidx.appcompat.view.menu.C0482g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.C0620p;
import androidx.appcompat.widget.C0642z;
import androidx.appcompat.widget.Toolbar;
import androidx.core.p020f.C0799a0;
import androidx.core.p020f.C0839t;
import androidx.core.p020f.C0851x;
import androidx.core.p020f.C0855y;
import androidx.core.p020f.C0856z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.app.k */
/* compiled from: WindowDecorActionBar */
public class C0433k extends C0399a implements ActionBarOverlayLayout.C0512d {

    /* renamed from: D */
    private static final Interpolator f535D = new AccelerateInterpolator();

    /* renamed from: E */
    private static final Interpolator f536E = new DecelerateInterpolator();

    /* renamed from: A */
    final C0855y f537A = new C0434a();

    /* renamed from: B */
    final C0855y f538B = new C0435b();

    /* renamed from: C */
    final C0799a0 f539C = new C0436c();

    /* renamed from: a */
    Context f540a;

    /* renamed from: b */
    private Context f541b;

    /* renamed from: c */
    private Activity f542c;

    /* renamed from: d */
    private Dialog f543d;

    /* renamed from: e */
    ActionBarOverlayLayout f544e;

    /* renamed from: f */
    ActionBarContainer f545f;

    /* renamed from: g */
    C0620p f546g;

    /* renamed from: h */
    ActionBarContextView f547h;

    /* renamed from: i */
    View f548i;

    /* renamed from: j */
    C0642z f549j;

    /* renamed from: k */
    private boolean f550k;

    /* renamed from: l */
    C0437d f551l;

    /* renamed from: m */
    C0455b f552m;

    /* renamed from: n */
    C0455b.C0456a f553n;

    /* renamed from: o */
    private boolean f554o;

    /* renamed from: p */
    private ArrayList<C0399a.C0401b> f555p = new ArrayList<>();

    /* renamed from: q */
    private boolean f556q;

    /* renamed from: r */
    private int f557r = 0;

    /* renamed from: s */
    boolean f558s = true;

    /* renamed from: t */
    boolean f559t;

    /* renamed from: u */
    boolean f560u;

    /* renamed from: v */
    private boolean f561v;

    /* renamed from: w */
    private boolean f562w = true;

    /* renamed from: x */
    C0465h f563x;

    /* renamed from: y */
    private boolean f564y;

    /* renamed from: z */
    boolean f565z;

    /* renamed from: androidx.appcompat.app.k$a */
    /* compiled from: WindowDecorActionBar */
    class C0434a extends C0856z {
        C0434a() {
        }

        /* renamed from: b */
        public void mo2086b(View view) {
            View view2;
            C0433k kVar = C0433k.this;
            if (kVar.f558s && (view2 = kVar.f548i) != null) {
                view2.setTranslationY(0.0f);
                C0433k.this.f545f.setTranslationY(0.0f);
            }
            C0433k.this.f545f.setVisibility(8);
            C0433k.this.f545f.mo2779a(false);
            C0433k kVar2 = C0433k.this;
            kVar2.f563x = null;
            kVar2.mo2146l();
            ActionBarOverlayLayout actionBarOverlayLayout = C0433k.this.f544e;
            if (actionBarOverlayLayout != null) {
                C0839t.m2683B(actionBarOverlayLayout);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.k$b */
    /* compiled from: WindowDecorActionBar */
    class C0435b extends C0856z {
        C0435b() {
        }

        /* renamed from: b */
        public void mo2086b(View view) {
            C0433k kVar = C0433k.this;
            kVar.f563x = null;
            kVar.f545f.requestLayout();
        }
    }

    /* renamed from: androidx.appcompat.app.k$c */
    /* compiled from: WindowDecorActionBar */
    class C0436c implements C0799a0 {
        C0436c() {
        }

        /* renamed from: a */
        public void mo2149a(View view) {
            ((View) C0433k.this.f545f.getParent()).invalidate();
        }
    }

    /* renamed from: androidx.appcompat.app.k$d */
    /* compiled from: WindowDecorActionBar */
    public class C0437d extends C0455b implements C0482g.C0483a {

        /* renamed from: c */
        private final Context f569c;

        /* renamed from: d */
        private final C0482g f570d;

        /* renamed from: e */
        private C0455b.C0456a f571e;

        /* renamed from: f */
        private WeakReference<View> f572f;

        public C0437d(Context context, C0455b.C0456a aVar) {
            this.f569c = context;
            this.f571e = aVar;
            C0482g gVar = new C0482g(context);
            gVar.mo2546c(1);
            this.f570d = gVar;
            gVar.mo2522a((C0482g.C0483a) this);
        }

        /* renamed from: a */
        public void mo2150a() {
            C0433k kVar = C0433k.this;
            if (kVar.f551l == this) {
                if (!C0433k.m586a(kVar.f559t, kVar.f560u, false)) {
                    C0433k kVar2 = C0433k.this;
                    kVar2.f552m = this;
                    kVar2.f553n = this.f571e;
                } else {
                    this.f571e.mo2090a(this);
                }
                this.f571e = null;
                C0433k.this.mo2140e(false);
                C0433k.this.f547h.mo2792a();
                C0433k.this.f546g.mo3477j().sendAccessibilityEvent(32);
                C0433k kVar3 = C0433k.this;
                kVar3.f544e.mo2827b(kVar3.f565z);
                C0433k.this.f551l = null;
            }
        }

        /* renamed from: b */
        public void mo2157b(CharSequence charSequence) {
            C0433k.this.f547h.mo2799b(charSequence);
        }

        /* renamed from: c */
        public Menu mo2158c() {
            return this.f570d;
        }

        /* renamed from: d */
        public MenuInflater mo2159d() {
            return new C0462g(this.f569c);
        }

        /* renamed from: e */
        public CharSequence mo2160e() {
            return C0433k.this.f547h.mo2798b();
        }

        /* renamed from: g */
        public CharSequence mo2161g() {
            return C0433k.this.f547h.mo2800c();
        }

        /* renamed from: i */
        public void mo2162i() {
            if (C0433k.this.f551l == this) {
                this.f570d.mo2579s();
                try {
                    this.f571e.mo2093b(this, this.f570d);
                } finally {
                    this.f570d.mo2576r();
                }
            }
        }

        /* renamed from: j */
        public boolean mo2163j() {
            return C0433k.this.f547h.mo2801d();
        }

        /* renamed from: k */
        public boolean mo2164k() {
            this.f570d.mo2579s();
            try {
                return this.f571e.mo2091a((C0455b) this, (Menu) this.f570d);
            } finally {
                this.f570d.mo2576r();
            }
        }

        /* renamed from: b */
        public void mo2156b(int i) {
            mo2157b((CharSequence) C0433k.this.f540a.getResources().getString(i));
        }

        /* renamed from: b */
        public View mo2155b() {
            WeakReference<View> weakReference = this.f572f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        /* renamed from: a */
        public void mo2152a(View view) {
            C0433k.this.f547h.mo2794a(view);
            this.f572f = new WeakReference<>(view);
        }

        /* renamed from: a */
        public void mo2153a(CharSequence charSequence) {
            C0433k.this.f547h.mo2796a(charSequence);
        }

        /* renamed from: a */
        public void mo2151a(int i) {
            mo2153a((CharSequence) C0433k.this.f540a.getResources().getString(i));
        }

        /* renamed from: a */
        public void mo2154a(boolean z) {
            super.mo2154a(z);
            C0433k.this.f547h.mo2797a(z);
        }

        /* renamed from: a */
        public boolean mo2055a(C0482g gVar, MenuItem menuItem) {
            C0455b.C0456a aVar = this.f571e;
            if (aVar != null) {
                return aVar.mo2092a((C0455b) this, menuItem);
            }
            return false;
        }

        /* renamed from: a */
        public void mo2052a(C0482g gVar) {
            if (this.f571e != null) {
                mo2162i();
                C0433k.this.f547h.mo2803f();
            }
        }
    }

    public C0433k(Activity activity, boolean z) {
        new ArrayList();
        this.f542c = activity;
        View decorView = activity.getWindow().getDecorView();
        m587b(decorView);
        if (!z) {
            this.f548i = decorView.findViewById(16908290);
        }
    }

    /* renamed from: a */
    private C0620p m585a(View view) {
        if (view instanceof C0620p) {
            return (C0620p) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).mo3331q();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    static boolean m586a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return !z && !z2;
    }

    /* renamed from: b */
    private void m587b(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.f544e = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.mo2819a((ActionBarOverlayLayout.C0512d) this);
        }
        this.f546g = m585a(view.findViewById(R$id.action_bar));
        this.f547h = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.f545f = actionBarContainer;
        C0620p pVar = this.f546g;
        if (pVar == null || this.f547h == null || actionBarContainer == null) {
            throw new IllegalStateException(C0433k.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f540a = pVar.getContext();
        boolean z = (this.f546g.mo3478k() & 4) != 0;
        if (z) {
            this.f550k = true;
        }
        C0454a a = C0454a.m719a(this.f540a);
        mo2145j(a.mo2293a() || z);
        m588k(a.mo2296d());
        TypedArray obtainStyledAttributes = this.f540a.obtainStyledAttributes((AttributeSet) null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            mo2144i(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            mo2134a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: k */
    private void m588k(boolean z) {
        this.f556q = z;
        if (!z) {
            this.f546g.mo3454a((C0642z) null);
            this.f545f.mo2778a(this.f549j);
        } else {
            this.f545f.mo2778a((C0642z) null);
            this.f546g.mo3454a(this.f549j);
        }
        boolean z2 = true;
        boolean z3 = mo2147m() == 2;
        C0642z zVar = this.f549j;
        if (zVar != null) {
            if (z3) {
                zVar.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f544e;
                if (actionBarOverlayLayout != null) {
                    C0839t.m2683B(actionBarOverlayLayout);
                }
            } else {
                zVar.setVisibility(8);
            }
        }
        this.f546g.mo3462b(!this.f556q && z3);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f544e;
        if (this.f556q || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout2.mo2821a(z2);
    }

    /* renamed from: n */
    private void m590n() {
        if (this.f561v) {
            this.f561v = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f544e;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.mo2831d(false);
            }
            m589l(false);
        }
    }

    /* renamed from: o */
    private boolean m591o() {
        return C0839t.m2736y(this.f545f);
    }

    /* renamed from: p */
    private void m592p() {
        if (!this.f561v) {
            this.f561v = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f544e;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.mo2831d(true);
            }
            m589l(false);
        }
    }

    /* renamed from: b */
    public void mo2137b() {
    }

    /* renamed from: c */
    public void mo2138c() {
        if (!this.f560u) {
            this.f560u = true;
            m589l(true);
        }
    }

    /* renamed from: d */
    public void mo1962d(boolean z) {
        C0465h hVar;
        this.f564y = z;
        if (!z && (hVar = this.f563x) != null) {
            hVar.mo2343a();
        }
    }

    /* renamed from: e */
    public void mo2140e(boolean z) {
        C0851x xVar;
        C0851x xVar2;
        if (z) {
            m592p();
        } else {
            m590n();
        }
        if (m591o()) {
            if (z) {
                xVar = this.f546g.mo3448a(4, 100);
                xVar2 = this.f547h.mo3354a(0, 200);
            } else {
                xVar2 = this.f546g.mo3448a(0, 200);
                xVar = this.f547h.mo3354a(8, 100);
            }
            C0465h hVar = new C0465h();
            hVar.mo2341a(xVar, xVar2);
            hVar.mo2345c();
        } else if (z) {
            this.f546g.mo3459b(4);
            this.f547h.setVisibility(0);
        } else {
            this.f546g.mo3459b(0);
            this.f547h.setVisibility(8);
        }
    }

    /* renamed from: f */
    public void mo2141f(boolean z) {
        View view;
        C0465h hVar = this.f563x;
        if (hVar != null) {
            hVar.mo2343a();
        }
        if (this.f557r != 0 || (!this.f564y && !z)) {
            this.f537A.mo2086b((View) null);
            return;
        }
        this.f545f.setAlpha(1.0f);
        this.f545f.mo2779a(true);
        C0465h hVar2 = new C0465h();
        float f = (float) (-this.f545f.getHeight());
        if (z) {
            int[] iArr = {0, 0};
            this.f545f.getLocationInWindow(iArr);
            f -= (float) iArr[1];
        }
        C0851x a = C0839t.m2688a(this.f545f);
        a.mo4213b(f);
        a.mo4209a(this.f539C);
        hVar2.mo2340a(a);
        if (this.f558s && (view = this.f548i) != null) {
            C0851x a2 = C0839t.m2688a(view);
            a2.mo4213b(f);
            hVar2.mo2340a(a2);
        }
        hVar2.mo2339a(f535D);
        hVar2.mo2338a(250);
        hVar2.mo2342a(this.f537A);
        this.f563x = hVar2;
        hVar2.mo2345c();
    }

    /* renamed from: g */
    public int mo1965g() {
        return this.f546g.mo3478k();
    }

    /* renamed from: h */
    public void mo2143h(boolean z) {
        mo2135a(z ? 4 : 0, 4);
    }

    /* renamed from: i */
    public void mo2144i(boolean z) {
        if (!z || this.f544e.mo2844j()) {
            this.f565z = z;
            this.f544e.mo2827b(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    /* renamed from: j */
    public void mo2145j(boolean z) {
        this.f546g.mo3456a(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo2146l() {
        C0455b.C0456a aVar = this.f553n;
        if (aVar != null) {
            aVar.mo2090a(this.f552m);
            this.f552m = null;
            this.f553n = null;
        }
    }

    /* renamed from: m */
    public int mo2147m() {
        return this.f546g.mo3476i();
    }

    public void onWindowVisibilityChanged(int i) {
        this.f557r = i;
    }

    /* renamed from: g */
    public void mo2142g(boolean z) {
        View view;
        View view2;
        C0465h hVar = this.f563x;
        if (hVar != null) {
            hVar.mo2343a();
        }
        this.f545f.setVisibility(0);
        if (this.f557r != 0 || (!this.f564y && !z)) {
            this.f545f.setAlpha(1.0f);
            this.f545f.setTranslationY(0.0f);
            if (this.f558s && (view = this.f548i) != null) {
                view.setTranslationY(0.0f);
            }
            this.f538B.mo2086b((View) null);
        } else {
            this.f545f.setTranslationY(0.0f);
            float f = (float) (-this.f545f.getHeight());
            if (z) {
                int[] iArr = {0, 0};
                this.f545f.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            this.f545f.setTranslationY(f);
            C0465h hVar2 = new C0465h();
            C0851x a = C0839t.m2688a(this.f545f);
            a.mo4213b(0.0f);
            a.mo4209a(this.f539C);
            hVar2.mo2340a(a);
            if (this.f558s && (view2 = this.f548i) != null) {
                view2.setTranslationY(f);
                C0851x a2 = C0839t.m2688a(this.f548i);
                a2.mo4213b(0.0f);
                hVar2.mo2340a(a2);
            }
            hVar2.mo2339a(f536E);
            hVar2.mo2338a(250);
            hVar2.mo2342a(this.f538B);
            this.f563x = hVar2;
            hVar2.mo2345c();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f544e;
        if (actionBarOverlayLayout != null) {
            C0839t.m2683B(actionBarOverlayLayout);
        }
    }

    /* renamed from: h */
    public Context mo1966h() {
        if (this.f541b == null) {
            TypedValue typedValue = new TypedValue();
            this.f540a.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f541b = new ContextThemeWrapper(this.f540a, i);
            } else {
                this.f541b = this.f540a;
            }
        }
        return this.f541b;
    }

    /* renamed from: c */
    public void mo1961c(boolean z) {
        if (!this.f550k) {
            mo2143h(z);
        }
    }

    /* renamed from: d */
    public void mo2139d() {
        C0465h hVar = this.f563x;
        if (hVar != null) {
            hVar.mo2343a();
            this.f563x = null;
        }
    }

    /* renamed from: l */
    private void m589l(boolean z) {
        if (m586a(this.f559t, this.f560u, this.f561v)) {
            if (!this.f562w) {
                this.f562w = true;
                mo2142g(z);
            }
        } else if (this.f562w) {
            this.f562w = false;
            mo2141f(z);
        }
    }

    /* renamed from: a */
    public void mo2134a(float f) {
        C0839t.m2689a((View) this.f545f, f);
    }

    /* renamed from: a */
    public void mo1956a(Configuration configuration) {
        m588k(C0454a.m719a(this.f540a).mo2296d());
    }

    /* renamed from: a */
    public void mo1957a(CharSequence charSequence) {
        this.f546g.mo3455a(charSequence);
    }

    /* renamed from: a */
    public void mo2135a(int i, int i2) {
        int k = this.f546g.mo3478k();
        if ((i2 & 4) != 0) {
            this.f550k = true;
        }
        this.f546g.mo3449a((i & i2) | ((i2 ^ -1) & k));
    }

    /* renamed from: a */
    public C0455b mo1955a(C0455b.C0456a aVar) {
        C0437d dVar = this.f551l;
        if (dVar != null) {
            dVar.mo2150a();
        }
        this.f544e.mo2827b(false);
        this.f547h.mo2802e();
        C0437d dVar2 = new C0437d(this.f547h.getContext(), aVar);
        if (!dVar2.mo2164k()) {
            return null;
        }
        this.f551l = dVar2;
        dVar2.mo2162i();
        this.f547h.mo2795a((C0455b) dVar2);
        mo2140e(true);
        this.f547h.sendAccessibilityEvent(32);
        return dVar2;
    }

    public C0433k(Dialog dialog) {
        new ArrayList();
        this.f543d = dialog;
        m587b(dialog.getWindow().getDecorView());
    }

    /* renamed from: b */
    public void mo1960b(boolean z) {
        if (z != this.f554o) {
            this.f554o = z;
            int size = this.f555p.size();
            for (int i = 0; i < size; i++) {
                this.f555p.get(i).mo1970a(z);
            }
        }
    }

    /* renamed from: f */
    public boolean mo1964f() {
        C0620p pVar = this.f546g;
        if (pVar == null || !pVar.mo3475h()) {
            return false;
        }
        this.f546g.collapseActionView();
        return true;
    }

    /* renamed from: a */
    public void mo2136a(boolean z) {
        this.f558s = z;
    }

    /* renamed from: a */
    public void mo2133a() {
        if (this.f560u) {
            this.f560u = false;
            m589l(true);
        }
    }

    /* renamed from: a */
    public boolean mo1958a(int i, KeyEvent keyEvent) {
        Menu c;
        C0437d dVar = this.f551l;
        if (dVar == null || (c = dVar.mo2158c()) == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        c.setQwertyMode(z);
        return c.performShortcut(i, keyEvent, 0);
    }
}
