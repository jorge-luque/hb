package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.C0497m;
import androidx.appcompat.view.menu.C0499n;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.b */
/* compiled from: BaseMenuPresenter */
public abstract class C0471b implements C0497m {

    /* renamed from: a */
    protected Context f763a;

    /* renamed from: b */
    protected Context f764b;

    /* renamed from: c */
    protected C0482g f765c;

    /* renamed from: d */
    protected LayoutInflater f766d;

    /* renamed from: e */
    private C0497m.C0498a f767e;

    /* renamed from: f */
    private int f768f;

    /* renamed from: g */
    private int f769g;

    /* renamed from: h */
    protected C0499n f770h;

    public C0471b(Context context, int i, int i2) {
        this.f763a = context;
        this.f766d = LayoutInflater.from(context);
        this.f768f = i;
        this.f769g = i2;
    }

    /* renamed from: a */
    public void mo2454a(int i) {
    }

    /* renamed from: a */
    public void mo2455a(Context context, C0482g gVar) {
        this.f764b = context;
        LayoutInflater.from(context);
        this.f765c = gVar;
    }

    /* renamed from: a */
    public abstract void mo2458a(C0486i iVar, C0499n.C0500a aVar);

    /* renamed from: a */
    public abstract boolean mo2461a(int i, C0486i iVar);

    /* renamed from: a */
    public boolean mo2463a(C0482g gVar, C0486i iVar) {
        return false;
    }

    /* renamed from: b */
    public C0499n mo2465b(ViewGroup viewGroup) {
        if (this.f770h == null) {
            C0499n nVar = (C0499n) this.f766d.inflate(this.f768f, viewGroup, false);
            this.f770h = nVar;
            nVar.mo2382a(this.f765c);
            mo2460a(true);
        }
        return this.f770h;
    }

    /* renamed from: b */
    public boolean mo2466b(C0482g gVar, C0486i iVar) {
        return false;
    }

    /* renamed from: a */
    public void mo2460a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f770h;
        if (viewGroup != null) {
            C0482g gVar = this.f765c;
            int i = 0;
            if (gVar != null) {
                gVar.mo2541b();
                ArrayList<C0486i> n = this.f765c.mo2570n();
                int size = n.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    C0486i iVar = n.get(i3);
                    if (mo2461a(i2, iVar)) {
                        View childAt = viewGroup.getChildAt(i2);
                        C0486i a = childAt instanceof C0499n.C0500a ? ((C0499n.C0500a) childAt).mo2363a() : null;
                        View a2 = mo2451a(iVar, childAt, viewGroup);
                        if (iVar != a) {
                            a2.setPressed(false);
                            a2.jumpDrawablesToCurrentState();
                        }
                        if (a2 != childAt) {
                            mo2456a(a2, i2);
                        }
                        i2++;
                    }
                }
                i = i2;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo2462a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo2456a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f770h).addView(view, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo2462a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    /* renamed from: a */
    public void mo2459a(C0497m.C0498a aVar) {
        this.f767e = aVar;
    }

    /* renamed from: a */
    public C0497m.C0498a mo2452a() {
        return this.f767e;
    }

    /* renamed from: a */
    public C0499n.C0500a mo2453a(ViewGroup viewGroup) {
        return (C0499n.C0500a) this.f766d.inflate(this.f769g, viewGroup, false);
    }

    /* renamed from: a */
    public View mo2451a(C0486i iVar, View view, ViewGroup viewGroup) {
        C0499n.C0500a aVar;
        if (view instanceof C0499n.C0500a) {
            aVar = (C0499n.C0500a) view;
        } else {
            aVar = mo2453a(viewGroup);
        }
        mo2458a(iVar, aVar);
        return (View) aVar;
    }

    /* renamed from: a */
    public void mo2457a(C0482g gVar, boolean z) {
        C0497m.C0498a aVar = this.f767e;
        if (aVar != null) {
            aVar.mo2088a(gVar, z);
        }
    }

    /* renamed from: a */
    public boolean mo2464a(C0506r rVar) {
        C0497m.C0498a aVar = this.f767e;
        if (aVar != null) {
            return aVar.mo2089a(rVar);
        }
        return false;
    }
}
