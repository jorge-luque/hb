package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.C0497m;
import androidx.appcompat.widget.C0630u;
import androidx.appcompat.widget.C0631v;
import androidx.core.p020f.C0804c;
import androidx.core.p020f.C0839t;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.appcompat.view.menu.d */
/* compiled from: CascadingMenuPopup */
final class C0473d extends C0494k implements C0497m, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: B */
    private static final int f774B = R$layout.abc_cascading_menu_item_layout;

    /* renamed from: A */
    boolean f775A;

    /* renamed from: b */
    private final Context f776b;

    /* renamed from: c */
    private final int f777c;

    /* renamed from: d */
    private final int f778d;

    /* renamed from: e */
    private final int f779e;

    /* renamed from: f */
    private final boolean f780f;

    /* renamed from: g */
    final Handler f781g;

    /* renamed from: h */
    private final List<C0482g> f782h = new ArrayList();

    /* renamed from: i */
    final List<C0478d> f783i = new ArrayList();

    /* renamed from: j */
    final ViewTreeObserver.OnGlobalLayoutListener f784j = new C0474a();

    /* renamed from: k */
    private final View.OnAttachStateChangeListener f785k = new C0475b();

    /* renamed from: l */
    private final C0630u f786l = new C0476c();

    /* renamed from: m */
    private int f787m = 0;

    /* renamed from: n */
    private int f788n = 0;

    /* renamed from: o */
    private View f789o;

    /* renamed from: p */
    View f790p;

    /* renamed from: q */
    private int f791q;

    /* renamed from: r */
    private boolean f792r;

    /* renamed from: s */
    private boolean f793s;

    /* renamed from: t */
    private int f794t;

    /* renamed from: u */
    private int f795u;

    /* renamed from: v */
    private boolean f796v;

    /* renamed from: w */
    private boolean f797w;

    /* renamed from: x */
    private C0497m.C0498a f798x;

    /* renamed from: y */
    ViewTreeObserver f799y;

    /* renamed from: z */
    private PopupWindow.OnDismissListener f800z;

    /* renamed from: androidx.appcompat.view.menu.d$a */
    /* compiled from: CascadingMenuPopup */
    class C0474a implements ViewTreeObserver.OnGlobalLayoutListener {
        C0474a() {
        }

        public void onGlobalLayout() {
            if (C0473d.this.mo2476a() && C0473d.this.f783i.size() > 0 && !C0473d.this.f783i.get(0).f808a.mo3181k()) {
                View view = C0473d.this.f790p;
                if (view == null || !view.isShown()) {
                    C0473d.this.dismiss();
                    return;
                }
                for (C0478d dVar : C0473d.this.f783i) {
                    dVar.f808a.show();
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.d$b */
    /* compiled from: CascadingMenuPopup */
    class C0475b implements View.OnAttachStateChangeListener {
        C0475b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = C0473d.this.f799y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    C0473d.this.f799y = view.getViewTreeObserver();
                }
                C0473d dVar = C0473d.this;
                dVar.f799y.removeGlobalOnLayoutListener(dVar.f784j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.d$c */
    /* compiled from: CascadingMenuPopup */
    class C0476c implements C0630u {

        /* renamed from: androidx.appcompat.view.menu.d$c$a */
        /* compiled from: CascadingMenuPopup */
        class C0477a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C0478d f804a;

            /* renamed from: b */
            final /* synthetic */ MenuItem f805b;

            /* renamed from: c */
            final /* synthetic */ C0482g f806c;

            C0477a(C0478d dVar, MenuItem menuItem, C0482g gVar) {
                this.f804a = dVar;
                this.f805b = menuItem;
                this.f806c = gVar;
            }

            public void run() {
                C0478d dVar = this.f804a;
                if (dVar != null) {
                    C0473d.this.f775A = true;
                    dVar.f809b.mo2526a(false);
                    C0473d.this.f775A = false;
                }
                if (this.f805b.isEnabled() && this.f805b.hasSubMenu()) {
                    this.f806c.mo2527a(this.f805b, 4);
                }
            }
        }

        C0476c() {
        }

        /* renamed from: a */
        public void mo2491a(C0482g gVar, MenuItem menuItem) {
            C0478d dVar = null;
            C0473d.this.f781g.removeCallbacksAndMessages((Object) null);
            int size = C0473d.this.f783i.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (gVar == C0473d.this.f783i.get(i).f809b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                int i2 = i + 1;
                if (i2 < C0473d.this.f783i.size()) {
                    dVar = C0473d.this.f783i.get(i2);
                }
                C0473d.this.f781g.postAtTime(new C0477a(dVar, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
            }
        }

        /* renamed from: b */
        public void mo2492b(C0482g gVar, MenuItem menuItem) {
            C0473d.this.f781g.removeCallbacksAndMessages(gVar);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.d$d */
    /* compiled from: CascadingMenuPopup */
    private static class C0478d {

        /* renamed from: a */
        public final C0631v f808a;

        /* renamed from: b */
        public final C0482g f809b;

        /* renamed from: c */
        public final int f810c;

        public C0478d(C0631v vVar, C0482g gVar, int i) {
            this.f808a = vVar;
            this.f809b = gVar;
            this.f810c = i;
        }

        /* renamed from: a */
        public ListView mo2494a() {
            return this.f808a.mo2484e();
        }
    }

    public C0473d(Context context, View view, int i, int i2, boolean z) {
        this.f776b = context;
        this.f789o = view;
        this.f778d = i;
        this.f779e = i2;
        this.f780f = z;
        this.f796v = false;
        this.f791q = m861g();
        Resources resources = context.getResources();
        this.f777c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f781g = new Handler();
    }

    /* renamed from: c */
    private int m857c(C0482g gVar) {
        int size = this.f783i.size();
        for (int i = 0; i < size; i++) {
            if (gVar == this.f783i.get(i).f809b) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: d */
    private int m858d(int i) {
        List<C0478d> list = this.f783i;
        ListView a = list.get(list.size() - 1).mo2494a();
        int[] iArr = new int[2];
        a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f790p.getWindowVisibleDisplayFrame(rect);
        if (this.f791q == 1) {
            if (iArr[0] + a.getWidth() + i > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /* renamed from: f */
    private C0631v m860f() {
        C0631v vVar = new C0631v(this.f776b, (AttributeSet) null, this.f778d, this.f779e);
        vVar.mo3573a(this.f786l);
        vVar.mo3162a((AdapterView.OnItemClickListener) this);
        vVar.mo3163a((PopupWindow.OnDismissListener) this);
        vVar.mo3161a(this.f789o);
        vVar.mo3172f(this.f788n);
        vVar.mo3164a(true);
        vVar.mo3174g(2);
        return vVar;
    }

    /* renamed from: g */
    private int m861g() {
        return C0839t.m2725n(this.f789o) == 1 ? 0 : 1;
    }

    /* renamed from: a */
    public void mo2475a(C0482g gVar) {
        gVar.mo2524a((C0497m) this, this.f776b);
        if (mo2476a()) {
            m859d(gVar);
        } else {
            this.f782h.add(gVar);
        }
    }

    /* renamed from: b */
    public void mo2478b(boolean z) {
        this.f796v = z;
    }

    /* renamed from: b */
    public boolean mo2479b() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo2482c() {
        return false;
    }

    public void dismiss() {
        int size = this.f783i.size();
        if (size > 0) {
            C0478d[] dVarArr = (C0478d[]) this.f783i.toArray(new C0478d[size]);
            for (int i = size - 1; i >= 0; i--) {
                C0478d dVar = dVarArr[i];
                if (dVar.f808a.mo2476a()) {
                    dVar.f808a.dismiss();
                }
            }
        }
    }

    /* renamed from: e */
    public ListView mo2484e() {
        if (this.f783i.isEmpty()) {
            return null;
        }
        List<C0478d> list = this.f783i;
        return list.get(list.size() - 1).mo2494a();
    }

    public void onDismiss() {
        C0478d dVar;
        int size = this.f783i.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                dVar = null;
                break;
            }
            dVar = this.f783i.get(i);
            if (!dVar.f808a.mo2476a()) {
                break;
            }
            i++;
        }
        if (dVar != null) {
            dVar.f809b.mo2526a(false);
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
        if (!mo2476a()) {
            for (C0482g d : this.f782h) {
                m859d(d);
            }
            this.f782h.clear();
            View view = this.f789o;
            this.f790p = view;
            if (view != null) {
                boolean z = this.f799y == null;
                ViewTreeObserver viewTreeObserver = this.f790p.getViewTreeObserver();
                this.f799y = viewTreeObserver;
                if (z) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f784j);
                }
                this.f790p.addOnAttachStateChangeListener(this.f785k);
            }
        }
    }

    /* renamed from: b */
    public void mo2477b(int i) {
        this.f792r = true;
        this.f794t = i;
    }

    /* renamed from: c */
    public void mo2480c(int i) {
        this.f793s = true;
        this.f795u = i;
    }

    /* renamed from: a */
    private MenuItem m855a(C0482g gVar, C0482g gVar2) {
        int size = gVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = gVar.getItem(i);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    /* renamed from: c */
    public void mo2481c(boolean z) {
        this.f797w = z;
    }

    /* renamed from: a */
    private View m856a(C0478d dVar, C0482g gVar) {
        int i;
        C0481f fVar;
        int firstVisiblePosition;
        MenuItem a = m855a(dVar.f809b, gVar);
        if (a == null) {
            return null;
        }
        ListView a2 = dVar.mo2494a();
        ListAdapter adapter = a2.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            fVar = (C0481f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (C0481f) adapter;
            i = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            } else if (a == fVar.getItem(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + i) - a2.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a2.getChildCount()) {
            return a2.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    /* renamed from: d */
    private void m859d(C0482g gVar) {
        View view;
        C0478d dVar;
        int i;
        int i2;
        int i3;
        LayoutInflater from = LayoutInflater.from(this.f776b);
        C0481f fVar = new C0481f(gVar, from, this.f780f, f774B);
        if (!mo2476a() && this.f796v) {
            fVar.mo2505a(true);
        } else if (mo2476a()) {
            fVar.mo2505a(C0494k.m996b(gVar));
        }
        int a = C0494k.m994a(fVar, (ViewGroup) null, this.f776b, this.f777c);
        C0631v f = m860f();
        f.mo3048a((ListAdapter) fVar);
        f.mo3170e(a);
        f.mo3172f(this.f788n);
        if (this.f783i.size() > 0) {
            List<C0478d> list = this.f783i;
            dVar = list.get(list.size() - 1);
            view = m856a(dVar, gVar);
        } else {
            dVar = null;
            view = null;
        }
        if (view != null) {
            f.mo3576c(false);
            f.mo3574a((Object) null);
            int d = m858d(a);
            boolean z = d == 1;
            this.f791q = d;
            if (Build.VERSION.SDK_INT >= 26) {
                f.mo3161a(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.f789o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f788n & 7) == 5) {
                    iArr[0] = iArr[0] + this.f789o.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.f788n & 5) != 5) {
                if (z) {
                    a = view.getWidth();
                }
                i3 = i - a;
                f.mo3158a(i3);
                f.mo3167b(true);
                f.mo3166b(i2);
            } else if (!z) {
                a = view.getWidth();
                i3 = i - a;
                f.mo3158a(i3);
                f.mo3167b(true);
                f.mo3166b(i2);
            }
            i3 = i + a;
            f.mo3158a(i3);
            f.mo3167b(true);
            f.mo3166b(i2);
        } else {
            if (this.f792r) {
                f.mo3158a(this.f794t);
            }
            if (this.f793s) {
                f.mo3166b(this.f795u);
            }
            f.mo3159a(mo2715d());
        }
        this.f783i.add(new C0478d(f, gVar, this.f791q));
        f.show();
        ListView e = f.mo2484e();
        e.setOnKeyListener(this);
        if (dVar == null && this.f797w && gVar.mo2562h() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R$layout.abc_popup_menu_header_item_layout, e, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(gVar.mo2562h());
            e.addHeaderView(frameLayout, (Object) null, false);
            f.show();
        }
    }

    /* renamed from: a */
    public boolean mo2476a() {
        return this.f783i.size() > 0 && this.f783i.get(0).f808a.mo2476a();
    }

    /* renamed from: a */
    public void mo2460a(boolean z) {
        for (C0478d a : this.f783i) {
            C0494k.m995a(a.mo2494a().getAdapter()).notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void mo2459a(C0497m.C0498a aVar) {
        this.f798x = aVar;
    }

    /* renamed from: a */
    public boolean mo2464a(C0506r rVar) {
        for (C0478d next : this.f783i) {
            if (rVar == next.f809b) {
                next.mo2494a().requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        mo2475a((C0482g) rVar);
        C0497m.C0498a aVar = this.f798x;
        if (aVar != null) {
            aVar.mo2089a(rVar);
        }
        return true;
    }

    /* renamed from: a */
    public void mo2457a(C0482g gVar, boolean z) {
        int c = m857c(gVar);
        if (c >= 0) {
            int i = c + 1;
            if (i < this.f783i.size()) {
                this.f783i.get(i).f809b.mo2526a(false);
            }
            C0478d remove = this.f783i.remove(c);
            remove.f809b.mo2543b((C0497m) this);
            if (this.f775A) {
                remove.f808a.mo3575b((Object) null);
                remove.f808a.mo3169d(0);
            }
            remove.f808a.dismiss();
            int size = this.f783i.size();
            if (size > 0) {
                this.f791q = this.f783i.get(size - 1).f810c;
            } else {
                this.f791q = m861g();
            }
            if (size == 0) {
                dismiss();
                C0497m.C0498a aVar = this.f798x;
                if (aVar != null) {
                    aVar.mo2088a(gVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.f799y;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.f799y.removeGlobalOnLayoutListener(this.f784j);
                    }
                    this.f799y = null;
                }
                this.f790p.removeOnAttachStateChangeListener(this.f785k);
                this.f800z.onDismiss();
            } else if (z) {
                this.f783i.get(0).f809b.mo2526a(false);
            }
        }
    }

    /* renamed from: a */
    public void mo2472a(int i) {
        if (this.f787m != i) {
            this.f787m = i;
            this.f788n = C0804c.m2545a(i, C0839t.m2725n(this.f789o));
        }
    }

    /* renamed from: a */
    public void mo2473a(View view) {
        if (this.f789o != view) {
            this.f789o = view;
            this.f788n = C0804c.m2545a(this.f787m, C0839t.m2725n(view));
        }
    }

    /* renamed from: a */
    public void mo2474a(PopupWindow.OnDismissListener onDismissListener) {
        this.f800z = onDismissListener;
    }
}
