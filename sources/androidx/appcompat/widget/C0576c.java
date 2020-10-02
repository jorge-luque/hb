package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.p011d.C0454a;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.C0471b;
import androidx.appcompat.view.menu.C0482g;
import androidx.appcompat.view.menu.C0486i;
import androidx.appcompat.view.menu.C0495l;
import androidx.appcompat.view.menu.C0497m;
import androidx.appcompat.view.menu.C0499n;
import androidx.appcompat.view.menu.C0502p;
import androidx.appcompat.view.menu.C0506r;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.C0857a;
import androidx.core.p020f.C0800b;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.widget.c */
/* compiled from: ActionMenuPresenter */
class C0576c extends C0471b implements C0800b.C0801a {

    /* renamed from: A */
    final C0583f f1365A = new C0583f();

    /* renamed from: B */
    int f1366B;

    /* renamed from: i */
    C0580d f1367i;

    /* renamed from: j */
    private Drawable f1368j;

    /* renamed from: k */
    private boolean f1369k;

    /* renamed from: l */
    private boolean f1370l;

    /* renamed from: m */
    private boolean f1371m;

    /* renamed from: n */
    private int f1372n;

    /* renamed from: o */
    private int f1373o;

    /* renamed from: p */
    private int f1374p;

    /* renamed from: q */
    private boolean f1375q;

    /* renamed from: r */
    private boolean f1376r;

    /* renamed from: s */
    private boolean f1377s;

    /* renamed from: t */
    private boolean f1378t;

    /* renamed from: u */
    private int f1379u;

    /* renamed from: v */
    private final SparseBooleanArray f1380v = new SparseBooleanArray();

    /* renamed from: w */
    C0582e f1381w;

    /* renamed from: x */
    C0577a f1382x;

    /* renamed from: y */
    C0579c f1383y;

    /* renamed from: z */
    private C0578b f1384z;

    /* renamed from: androidx.appcompat.widget.c$a */
    /* compiled from: ActionMenuPresenter */
    private class C0577a extends C0495l {
        public C0577a(Context context, C0506r rVar, View view) {
            super(context, rVar, view, false, R$attr.actionOverflowMenuStyle);
            if (!((C0486i) rVar.getItem()).mo2604g()) {
                View view2 = C0576c.this.f1367i;
                mo2719a(view2 == null ? (View) C0576c.this.f770h : view2);
            }
            mo2721a((C0497m.C0498a) C0576c.this.f1365A);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo2726d() {
            C0576c cVar = C0576c.this;
            cVar.f1382x = null;
            cVar.f1366B = 0;
            super.mo2726d();
        }
    }

    /* renamed from: androidx.appcompat.widget.c$b */
    /* compiled from: ActionMenuPresenter */
    private class C0578b extends ActionMenuItemView.C0469b {
        C0578b() {
        }

        /* renamed from: a */
        public C0502p mo2381a() {
            C0577a aVar = C0576c.this.f1382x;
            if (aVar != null) {
                return aVar.mo2724b();
            }
            return null;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$c */
    /* compiled from: ActionMenuPresenter */
    private class C0579c implements Runnable {

        /* renamed from: a */
        private C0582e f1387a;

        public C0579c(C0582e eVar) {
            this.f1387a = eVar;
        }

        public void run() {
            if (C0576c.this.f765c != null) {
                C0576c.this.f765c.mo2519a();
            }
            View view = (View) C0576c.this.f770h;
            if (!(view == null || view.getWindowToken() == null || !this.f1387a.mo2728f())) {
                C0576c.this.f1381w = this.f1387a;
            }
            C0576c.this.f1383y = null;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$d */
    /* compiled from: ActionMenuPresenter */
    private class C0580d extends AppCompatImageView implements ActionMenuView.C0514a {

        /* renamed from: androidx.appcompat.widget.c$d$a */
        /* compiled from: ActionMenuPresenter */
        class C0581a extends C0627t {
            C0581a(View view, C0576c cVar) {
                super(view);
            }

            /* renamed from: a */
            public C0502p mo2379a() {
                C0582e eVar = C0576c.this.f1381w;
                if (eVar == null) {
                    return null;
                }
                return eVar.mo2724b();
            }

            /* renamed from: b */
            public boolean mo2380b() {
                C0576c.this.mo3376h();
                return true;
            }

            /* renamed from: c */
            public boolean mo2904c() {
                C0576c cVar = C0576c.this;
                if (cVar.f1383y != null) {
                    return false;
                }
                cVar.mo3372d();
                return true;
            }
        }

        public C0580d(Context context) {
            super(context, (AttributeSet) null, R$attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            C0604i0.m1679a(this, getContentDescription());
            setOnTouchListener(new C0581a(this, C0576c.this));
        }

        /* renamed from: b */
        public boolean mo2369b() {
            return false;
        }

        /* renamed from: e */
        public boolean mo2371e() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            C0576c.this.mo3376h();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C0857a.m2803a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$e */
    /* compiled from: ActionMenuPresenter */
    private class C0582e extends C0495l {
        public C0582e(Context context, C0482g gVar, View view, boolean z) {
            super(context, gVar, view, z, R$attr.actionOverflowMenuStyle);
            mo2718a(8388613);
            mo2721a((C0497m.C0498a) C0576c.this.f1365A);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void mo2726d() {
            if (C0576c.this.f765c != null) {
                C0576c.this.f765c.close();
            }
            C0576c.this.f1381w = null;
            super.mo2726d();
        }
    }

    public C0576c(Context context) {
        super(context, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
    }

    /* renamed from: g */
    public boolean mo3375g() {
        C0582e eVar = this.f1381w;
        return eVar != null && eVar.mo2725c();
    }

    /* renamed from: h */
    public boolean mo3376h() {
        C0482g gVar;
        if (!this.f1370l || mo3375g() || (gVar = this.f765c) == null || this.f770h == null || this.f1383y != null || gVar.mo2566j().isEmpty()) {
            return false;
        }
        C0579c cVar = new C0579c(new C0582e(this.f764b, this.f765c, this.f1367i, true));
        this.f1383y = cVar;
        ((View) this.f770h).post(cVar);
        super.mo2464a((C0506r) null);
        return true;
    }

    /* renamed from: a */
    public void mo2455a(Context context, C0482g gVar) {
        super.mo2455a(context, gVar);
        Resources resources = context.getResources();
        C0454a a = C0454a.m719a(context);
        if (!this.f1371m) {
            this.f1370l = a.mo2297e();
        }
        if (!this.f1377s) {
            this.f1372n = a.mo2294b();
        }
        if (!this.f1375q) {
            this.f1374p = a.mo2295c();
        }
        int i = this.f1372n;
        if (this.f1370l) {
            if (this.f1367i == null) {
                C0580d dVar = new C0580d(this.f763a);
                this.f1367i = dVar;
                if (this.f1369k) {
                    dVar.setImageDrawable(this.f1368j);
                    this.f1368j = null;
                    this.f1369k = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1367i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f1367i.getMeasuredWidth();
        } else {
            this.f1367i = null;
        }
        this.f1373o = i;
        this.f1379u = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    /* renamed from: b */
    public C0499n mo2465b(ViewGroup viewGroup) {
        C0499n nVar = this.f770h;
        C0499n b = super.mo2465b(viewGroup);
        if (nVar != b) {
            ((ActionMenuView) b).mo2866a(this);
        }
        return b;
    }

    /* renamed from: c */
    public void mo3369c(boolean z) {
        this.f1378t = z;
    }

    /* renamed from: d */
    public void mo3371d(boolean z) {
        this.f1370l = z;
        this.f1371m = true;
    }

    /* renamed from: e */
    public boolean mo3373e() {
        C0577a aVar = this.f1382x;
        if (aVar == null) {
            return false;
        }
        aVar.mo2717a();
        return true;
    }

    /* renamed from: f */
    public boolean mo3374f() {
        return this.f1383y != null || mo3375g();
    }

    /* renamed from: androidx.appcompat.widget.c$f */
    /* compiled from: ActionMenuPresenter */
    private class C0583f implements C0497m.C0498a {
        C0583f() {
        }

        /* renamed from: a */
        public boolean mo2089a(C0482g gVar) {
            if (gVar == null) {
                return false;
            }
            C0576c.this.f1366B = ((C0506r) gVar).getItem().getItemId();
            C0497m.C0498a a = C0576c.this.mo2452a();
            if (a != null) {
                return a.mo2089a(gVar);
            }
            return false;
        }

        /* renamed from: a */
        public void mo2088a(C0482g gVar, boolean z) {
            if (gVar instanceof C0506r) {
                gVar.mo2569m().mo2526a(false);
            }
            C0497m.C0498a a = C0576c.this.mo2452a();
            if (a != null) {
                a.mo2088a(gVar, z);
            }
        }
    }

    /* renamed from: c */
    public boolean mo3370c() {
        return mo3372d() | mo3373e();
    }

    /* renamed from: d */
    public boolean mo3372d() {
        C0499n nVar;
        C0579c cVar = this.f1383y;
        if (cVar == null || (nVar = this.f770h) == null) {
            C0582e eVar = this.f1381w;
            if (eVar == null) {
                return false;
            }
            eVar.mo2717a();
            return true;
        }
        ((View) nVar).removeCallbacks(cVar);
        this.f1383y = null;
        return true;
    }

    /* renamed from: b */
    public boolean mo2479b() {
        int i;
        ArrayList<C0486i> arrayList;
        int i2;
        int i3;
        int i4;
        C0576c cVar = this;
        C0482g gVar = cVar.f765c;
        View view = null;
        int i5 = 0;
        if (gVar != null) {
            arrayList = gVar.mo2570n();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = cVar.f1374p;
        int i7 = cVar.f1373o;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f770h;
        boolean z = false;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            C0486i iVar = arrayList.get(i10);
            if (iVar.mo2624j()) {
                i8++;
            } else if (iVar.mo2619i()) {
                i9++;
            } else {
                z = true;
            }
            if (cVar.f1378t && iVar.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (cVar.f1370l && (z || i9 + i8 > i6)) {
            i6--;
        }
        int i11 = i6 - i8;
        SparseBooleanArray sparseBooleanArray = cVar.f1380v;
        sparseBooleanArray.clear();
        if (cVar.f1376r) {
            int i12 = cVar.f1379u;
            i2 = i7 / i12;
            i3 = i12 + ((i7 % i12) / i2);
        } else {
            i3 = 0;
            i2 = 0;
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < i) {
            C0486i iVar2 = arrayList.get(i13);
            if (iVar2.mo2624j()) {
                View a = cVar.mo2451a(iVar2, view, viewGroup);
                if (cVar.f1376r) {
                    i2 -= ActionMenuView.m1125a(a, i3, i2, makeMeasureSpec, i5);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a.getMeasuredWidth();
                i7 -= measuredWidth;
                if (i14 == 0) {
                    i14 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.mo2600d(true);
                i4 = i;
            } else if (iVar2.mo2619i()) {
                int groupId2 = iVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i11 > 0 || z2) && i7 > 0 && (!cVar.f1376r || i2 > 0);
                boolean z4 = z3;
                i4 = i;
                if (z3) {
                    View a2 = cVar.mo2451a(iVar2, (View) null, viewGroup);
                    if (cVar.f1376r) {
                        int a3 = ActionMenuView.m1125a(a2, i3, i2, makeMeasureSpec, 0);
                        i2 -= a3;
                        if (a3 == 0) {
                            z4 = false;
                        }
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z5 = z4;
                    int measuredWidth2 = a2.getMeasuredWidth();
                    i7 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    z3 = z5 & (!cVar.f1376r ? i7 + i14 > 0 : i7 >= 0);
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    int i15 = 0;
                    while (i15 < i13) {
                        C0486i iVar3 = arrayList.get(i15);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.mo2604g()) {
                                i11++;
                            }
                            iVar3.mo2600d(false);
                        }
                        i15++;
                    }
                }
                if (z3) {
                    i11--;
                }
                iVar2.mo2600d(z3);
            } else {
                i4 = i;
                iVar2.mo2600d(false);
                i13++;
                i = i4;
                view = null;
                i5 = 0;
                cVar = this;
            }
            i13++;
            i = i4;
            view = null;
            i5 = 0;
            cVar = this;
        }
        return true;
    }

    /* renamed from: a */
    public void mo3366a(Configuration configuration) {
        if (!this.f1375q) {
            this.f1374p = C0454a.m719a(this.f764b).mo2295c();
        }
        C0482g gVar = this.f765c;
        if (gVar != null) {
            gVar.mo2544b(true);
        }
    }

    /* renamed from: a */
    public View mo2451a(C0486i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.mo2601e()) {
            actionView = super.mo2451a(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    /* renamed from: a */
    public void mo2458a(C0486i iVar, C0499n.C0500a aVar) {
        aVar.mo2367a(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.mo2366a((C0482g.C0484b) (ActionMenuView) this.f770h);
        if (this.f1384z == null) {
            this.f1384z = new C0578b();
        }
        actionMenuItemView.mo2365a((ActionMenuItemView.C0469b) this.f1384z);
    }

    /* renamed from: a */
    public boolean mo2461a(int i, C0486i iVar) {
        return iVar.mo2604g();
    }

    /* renamed from: a */
    public void mo2460a(boolean z) {
        C0499n nVar;
        super.mo2460a(z);
        ((View) this.f770h).requestLayout();
        C0482g gVar = this.f765c;
        boolean z2 = false;
        if (gVar != null) {
            ArrayList<C0486i> c = gVar.mo2547c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                C0800b a = c.get(i).mo2396a();
                if (a != null) {
                    a.mo4096a((C0800b.C0801a) this);
                }
            }
        }
        C0482g gVar2 = this.f765c;
        ArrayList<C0486i> j = gVar2 != null ? gVar2.mo2566j() : null;
        if (this.f1370l && j != null) {
            int size2 = j.size();
            if (size2 == 1) {
                z2 = !j.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.f1367i == null) {
                this.f1367i = new C0580d(this.f763a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1367i.getParent();
            if (viewGroup != this.f770h) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1367i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f770h;
                actionMenuView.addView(this.f1367i, actionMenuView.mo2877h());
            }
        } else {
            C0580d dVar = this.f1367i;
            if (dVar != null && dVar.getParent() == (nVar = this.f770h)) {
                ((ViewGroup) nVar).removeView(this.f1367i);
            }
        }
        ((ActionMenuView) this.f770h).mo2868c(this.f1370l);
    }

    /* renamed from: b */
    public void mo3368b(boolean z) {
        if (z) {
            super.mo2464a((C0506r) null);
            return;
        }
        C0482g gVar = this.f765c;
        if (gVar != null) {
            gVar.mo2526a(false);
        }
    }

    /* renamed from: a */
    public boolean mo2462a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f1367i) {
            return false;
        }
        return super.mo2462a(viewGroup, i);
    }

    /* renamed from: a */
    public boolean mo2464a(C0506r rVar) {
        boolean z = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        C0506r rVar2 = rVar;
        while (rVar2.mo2767t() != this.f765c) {
            rVar2 = (C0506r) rVar2.mo2767t();
        }
        View a = m1511a(rVar2.getItem());
        if (a == null) {
            return false;
        }
        rVar.getItem().getItemId();
        int size = rVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        C0577a aVar = new C0577a(this.f764b, rVar, a);
        this.f1382x = aVar;
        aVar.mo2722a(z);
        this.f1382x.mo2727e();
        super.mo2464a(rVar);
        return true;
    }

    /* renamed from: a */
    private View m1511a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f770h;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof C0499n.C0500a) && ((C0499n.C0500a) childAt).mo2363a() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo2457a(C0482g gVar, boolean z) {
        mo3370c();
        super.mo2457a(gVar, z);
    }

    /* renamed from: a */
    public void mo3367a(ActionMenuView actionMenuView) {
        this.f770h = actionMenuView;
        actionMenuView.mo2382a(this.f765c);
    }
}
