package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.k */
/* compiled from: SimpleItemAnimator */
public abstract class C1112k extends RecyclerView.C1048l {

    /* renamed from: g */
    boolean f3020g = true;

    /* renamed from: a */
    public boolean mo5510a(RecyclerView.C1039c0 c0Var) {
        return !this.f3020g || c0Var.isInvalid();
    }

    /* renamed from: a */
    public abstract boolean mo5826a(RecyclerView.C1039c0 c0Var, int i, int i2, int i3, int i4);

    /* renamed from: a */
    public abstract boolean mo5827a(RecyclerView.C1039c0 c0Var, RecyclerView.C1039c0 c0Var2, int i, int i2, int i3, int i4);

    /* renamed from: b */
    public boolean mo5516b(RecyclerView.C1039c0 c0Var, RecyclerView.C1048l.C1051c cVar, RecyclerView.C1048l.C1051c cVar2) {
        int i = cVar.f2764a;
        int i2 = cVar.f2765b;
        View view = c0Var.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.f2764a;
        int top = cVar2 == null ? view.getTop() : cVar2.f2765b;
        if (c0Var.isRemoved() || (i == left && i2 == top)) {
            return mo5830g(c0Var);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return mo5826a(c0Var, i, i2, left, top);
    }

    /* renamed from: c */
    public void mo5901c(RecyclerView.C1039c0 c0Var, boolean z) {
    }

    /* renamed from: c */
    public boolean mo5519c(RecyclerView.C1039c0 c0Var, RecyclerView.C1048l.C1051c cVar, RecyclerView.C1048l.C1051c cVar2) {
        if (cVar.f2764a == cVar2.f2764a && cVar.f2765b == cVar2.f2765b) {
            mo5905j(c0Var);
            return false;
        }
        return mo5826a(c0Var, cVar.f2764a, cVar.f2765b, cVar2.f2764a, cVar2.f2765b);
    }

    /* renamed from: d */
    public void mo5902d(RecyclerView.C1039c0 c0Var, boolean z) {
    }

    /* renamed from: f */
    public abstract boolean mo5829f(RecyclerView.C1039c0 c0Var);

    /* renamed from: g */
    public abstract boolean mo5830g(RecyclerView.C1039c0 c0Var);

    /* renamed from: h */
    public final void mo5903h(RecyclerView.C1039c0 c0Var) {
        mo5909n(c0Var);
        mo5515b(c0Var);
    }

    /* renamed from: i */
    public final void mo5904i(RecyclerView.C1039c0 c0Var) {
        mo5910o(c0Var);
    }

    /* renamed from: j */
    public final void mo5905j(RecyclerView.C1039c0 c0Var) {
        mo5911p(c0Var);
        mo5515b(c0Var);
    }

    /* renamed from: k */
    public final void mo5906k(RecyclerView.C1039c0 c0Var) {
        mo5912q(c0Var);
    }

    /* renamed from: l */
    public final void mo5907l(RecyclerView.C1039c0 c0Var) {
        mo5913r(c0Var);
        mo5515b(c0Var);
    }

    /* renamed from: m */
    public final void mo5908m(RecyclerView.C1039c0 c0Var) {
        mo5914s(c0Var);
    }

    /* renamed from: n */
    public void mo5909n(RecyclerView.C1039c0 c0Var) {
    }

    /* renamed from: o */
    public void mo5910o(RecyclerView.C1039c0 c0Var) {
    }

    /* renamed from: p */
    public void mo5911p(RecyclerView.C1039c0 c0Var) {
    }

    /* renamed from: q */
    public void mo5912q(RecyclerView.C1039c0 c0Var) {
    }

    /* renamed from: r */
    public void mo5913r(RecyclerView.C1039c0 c0Var) {
    }

    /* renamed from: s */
    public void mo5914s(RecyclerView.C1039c0 c0Var) {
    }

    /* renamed from: a */
    public boolean mo5512a(RecyclerView.C1039c0 c0Var, RecyclerView.C1048l.C1051c cVar, RecyclerView.C1048l.C1051c cVar2) {
        if (cVar == null || (cVar.f2764a == cVar2.f2764a && cVar.f2765b == cVar2.f2765b)) {
            return mo5829f(c0Var);
        }
        return mo5826a(c0Var, cVar.f2764a, cVar.f2765b, cVar2.f2764a, cVar2.f2765b);
    }

    /* renamed from: a */
    public boolean mo5511a(RecyclerView.C1039c0 c0Var, RecyclerView.C1039c0 c0Var2, RecyclerView.C1048l.C1051c cVar, RecyclerView.C1048l.C1051c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f2764a;
        int i4 = cVar.f2765b;
        if (c0Var2.shouldIgnore()) {
            int i5 = cVar.f2764a;
            i = cVar.f2765b;
            i2 = i5;
        } else {
            i2 = cVar2.f2764a;
            i = cVar2.f2765b;
        }
        return mo5827a(c0Var, c0Var2, i3, i4, i2, i);
    }

    /* renamed from: b */
    public final void mo5900b(RecyclerView.C1039c0 c0Var, boolean z) {
        mo5902d(c0Var, z);
    }

    /* renamed from: a */
    public final void mo5899a(RecyclerView.C1039c0 c0Var, boolean z) {
        mo5901c(c0Var, z);
        mo5515b(c0Var);
    }
}
