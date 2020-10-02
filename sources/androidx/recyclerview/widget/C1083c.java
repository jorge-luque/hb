package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.p020f.C0839t;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.c */
/* compiled from: DefaultItemAnimator */
public class C1083c extends C1112k {

    /* renamed from: s */
    private static TimeInterpolator f2901s;

    /* renamed from: h */
    private ArrayList<RecyclerView.C1039c0> f2902h = new ArrayList<>();

    /* renamed from: i */
    private ArrayList<RecyclerView.C1039c0> f2903i = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<C1093j> f2904j = new ArrayList<>();

    /* renamed from: k */
    private ArrayList<C1092i> f2905k = new ArrayList<>();

    /* renamed from: l */
    ArrayList<ArrayList<RecyclerView.C1039c0>> f2906l = new ArrayList<>();

    /* renamed from: m */
    ArrayList<ArrayList<C1093j>> f2907m = new ArrayList<>();

    /* renamed from: n */
    ArrayList<ArrayList<C1092i>> f2908n = new ArrayList<>();

    /* renamed from: o */
    ArrayList<RecyclerView.C1039c0> f2909o = new ArrayList<>();

    /* renamed from: p */
    ArrayList<RecyclerView.C1039c0> f2910p = new ArrayList<>();

    /* renamed from: q */
    ArrayList<RecyclerView.C1039c0> f2911q = new ArrayList<>();

    /* renamed from: r */
    ArrayList<RecyclerView.C1039c0> f2912r = new ArrayList<>();

    /* renamed from: androidx.recyclerview.widget.c$a */
    /* compiled from: DefaultItemAnimator */
    class C1084a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f2913a;

        C1084a(ArrayList arrayList) {
            this.f2913a = arrayList;
        }

        public void run() {
            Iterator it = this.f2913a.iterator();
            while (it.hasNext()) {
                C1093j jVar = (C1093j) it.next();
                C1083c.this.mo5828b(jVar.f2947a, jVar.f2948b, jVar.f2949c, jVar.f2950d, jVar.f2951e);
            }
            this.f2913a.clear();
            C1083c.this.f2907m.remove(this.f2913a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$b */
    /* compiled from: DefaultItemAnimator */
    class C1085b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f2915a;

        C1085b(ArrayList arrayList) {
            this.f2915a = arrayList;
        }

        public void run() {
            Iterator it = this.f2915a.iterator();
            while (it.hasNext()) {
                C1083c.this.mo5824a((C1092i) it.next());
            }
            this.f2915a.clear();
            C1083c.this.f2908n.remove(this.f2915a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$c */
    /* compiled from: DefaultItemAnimator */
    class C1086c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f2917a;

        C1086c(ArrayList arrayList) {
            this.f2917a = arrayList;
        }

        public void run() {
            Iterator it = this.f2917a.iterator();
            while (it.hasNext()) {
                C1083c.this.mo5832t((RecyclerView.C1039c0) it.next());
            }
            this.f2917a.clear();
            C1083c.this.f2906l.remove(this.f2917a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$d */
    /* compiled from: DefaultItemAnimator */
    class C1087d extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RecyclerView.C1039c0 f2919a;

        /* renamed from: b */
        final /* synthetic */ ViewPropertyAnimator f2920b;

        /* renamed from: c */
        final /* synthetic */ View f2921c;

        C1087d(RecyclerView.C1039c0 c0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f2919a = c0Var;
            this.f2920b = viewPropertyAnimator;
            this.f2921c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2920b.setListener((Animator.AnimatorListener) null);
            this.f2921c.setAlpha(1.0f);
            C1083c.this.mo5907l(this.f2919a);
            C1083c.this.f2911q.remove(this.f2919a);
            C1083c.this.mo5831j();
        }

        public void onAnimationStart(Animator animator) {
            C1083c.this.mo5908m(this.f2919a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$e */
    /* compiled from: DefaultItemAnimator */
    class C1088e extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RecyclerView.C1039c0 f2923a;

        /* renamed from: b */
        final /* synthetic */ View f2924b;

        /* renamed from: c */
        final /* synthetic */ ViewPropertyAnimator f2925c;

        C1088e(RecyclerView.C1039c0 c0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f2923a = c0Var;
            this.f2924b = view;
            this.f2925c = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            this.f2924b.setAlpha(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            this.f2925c.setListener((Animator.AnimatorListener) null);
            C1083c.this.mo5903h(this.f2923a);
            C1083c.this.f2909o.remove(this.f2923a);
            C1083c.this.mo5831j();
        }

        public void onAnimationStart(Animator animator) {
            C1083c.this.mo5904i(this.f2923a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$f */
    /* compiled from: DefaultItemAnimator */
    class C1089f extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RecyclerView.C1039c0 f2927a;

        /* renamed from: b */
        final /* synthetic */ int f2928b;

        /* renamed from: c */
        final /* synthetic */ View f2929c;

        /* renamed from: d */
        final /* synthetic */ int f2930d;

        /* renamed from: e */
        final /* synthetic */ ViewPropertyAnimator f2931e;

        C1089f(RecyclerView.C1039c0 c0Var, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
            this.f2927a = c0Var;
            this.f2928b = i;
            this.f2929c = view;
            this.f2930d = i2;
            this.f2931e = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f2928b != 0) {
                this.f2929c.setTranslationX(0.0f);
            }
            if (this.f2930d != 0) {
                this.f2929c.setTranslationY(0.0f);
            }
        }

        public void onAnimationEnd(Animator animator) {
            this.f2931e.setListener((Animator.AnimatorListener) null);
            C1083c.this.mo5905j(this.f2927a);
            C1083c.this.f2910p.remove(this.f2927a);
            C1083c.this.mo5831j();
        }

        public void onAnimationStart(Animator animator) {
            C1083c.this.mo5906k(this.f2927a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$g */
    /* compiled from: DefaultItemAnimator */
    class C1090g extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ C1092i f2933a;

        /* renamed from: b */
        final /* synthetic */ ViewPropertyAnimator f2934b;

        /* renamed from: c */
        final /* synthetic */ View f2935c;

        C1090g(C1092i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f2933a = iVar;
            this.f2934b = viewPropertyAnimator;
            this.f2935c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2934b.setListener((Animator.AnimatorListener) null);
            this.f2935c.setAlpha(1.0f);
            this.f2935c.setTranslationX(0.0f);
            this.f2935c.setTranslationY(0.0f);
            C1083c.this.mo5899a(this.f2933a.f2941a, true);
            C1083c.this.f2912r.remove(this.f2933a.f2941a);
            C1083c.this.mo5831j();
        }

        public void onAnimationStart(Animator animator) {
            C1083c.this.mo5900b(this.f2933a.f2941a, true);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$h */
    /* compiled from: DefaultItemAnimator */
    class C1091h extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ C1092i f2937a;

        /* renamed from: b */
        final /* synthetic */ ViewPropertyAnimator f2938b;

        /* renamed from: c */
        final /* synthetic */ View f2939c;

        C1091h(C1092i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f2937a = iVar;
            this.f2938b = viewPropertyAnimator;
            this.f2939c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2938b.setListener((Animator.AnimatorListener) null);
            this.f2939c.setAlpha(1.0f);
            this.f2939c.setTranslationX(0.0f);
            this.f2939c.setTranslationY(0.0f);
            C1083c.this.mo5899a(this.f2937a.f2942b, false);
            C1083c.this.f2912r.remove(this.f2937a.f2942b);
            C1083c.this.mo5831j();
        }

        public void onAnimationStart(Animator animator) {
            C1083c.this.mo5900b(this.f2937a.f2942b, false);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$j */
    /* compiled from: DefaultItemAnimator */
    private static class C1093j {

        /* renamed from: a */
        public RecyclerView.C1039c0 f2947a;

        /* renamed from: b */
        public int f2948b;

        /* renamed from: c */
        public int f2949c;

        /* renamed from: d */
        public int f2950d;

        /* renamed from: e */
        public int f2951e;

        C1093j(RecyclerView.C1039c0 c0Var, int i, int i2, int i3, int i4) {
            this.f2947a = c0Var;
            this.f2948b = i;
            this.f2949c = i2;
            this.f2950d = i3;
            this.f2951e = i4;
        }
    }

    /* renamed from: u */
    private void m4387u(RecyclerView.C1039c0 c0Var) {
        View view = c0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f2911q.add(c0Var);
        animate.setDuration(mo5523f()).alpha(0.0f).setListener(new C1087d(c0Var, animate, view)).start();
    }

    /* renamed from: v */
    private void m4388v(RecyclerView.C1039c0 c0Var) {
        if (f2901s == null) {
            f2901s = new ValueAnimator().getInterpolator();
        }
        c0Var.itemView.animate().setInterpolator(f2901s);
        mo5518c(c0Var);
    }

    /* renamed from: a */
    public boolean mo5826a(RecyclerView.C1039c0 c0Var, int i, int i2, int i3, int i4) {
        View view = c0Var.itemView;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) c0Var.itemView.getTranslationY());
        m4388v(c0Var);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            mo5905j(c0Var);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX((float) (-i5));
        }
        if (i6 != 0) {
            view.setTranslationY((float) (-i6));
        }
        this.f2904j.add(new C1093j(c0Var, translationX, translationY, i3, i4));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5828b(RecyclerView.C1039c0 c0Var, int i, int i2, int i3, int i4) {
        View view = c0Var.itemView;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f2910p.add(c0Var);
        animate.setDuration(mo5522e()).setListener(new C1089f(c0Var, i5, view, i6, animate)).start();
    }

    /* renamed from: c */
    public void mo5518c(RecyclerView.C1039c0 c0Var) {
        View view = c0Var.itemView;
        view.animate().cancel();
        int size = this.f2904j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f2904j.get(size).f2947a == c0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                mo5905j(c0Var);
                this.f2904j.remove(size);
            }
        }
        m4384a((List<C1092i>) this.f2905k, c0Var);
        if (this.f2902h.remove(c0Var)) {
            view.setAlpha(1.0f);
            mo5907l(c0Var);
        }
        if (this.f2903i.remove(c0Var)) {
            view.setAlpha(1.0f);
            mo5903h(c0Var);
        }
        for (int size2 = this.f2908n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.f2908n.get(size2);
            m4384a((List<C1092i>) arrayList, c0Var);
            if (arrayList.isEmpty()) {
                this.f2908n.remove(size2);
            }
        }
        for (int size3 = this.f2907m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.f2907m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((C1093j) arrayList2.get(size4)).f2947a == c0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    mo5905j(c0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f2907m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f2906l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f2906l.get(size5);
            if (arrayList3.remove(c0Var)) {
                view.setAlpha(1.0f);
                mo5903h(c0Var);
                if (arrayList3.isEmpty()) {
                    this.f2906l.remove(size5);
                }
            }
        }
        this.f2911q.remove(c0Var);
        this.f2909o.remove(c0Var);
        this.f2912r.remove(c0Var);
        this.f2910p.remove(c0Var);
        mo5831j();
    }

    /* renamed from: f */
    public boolean mo5829f(RecyclerView.C1039c0 c0Var) {
        m4388v(c0Var);
        c0Var.itemView.setAlpha(0.0f);
        this.f2903i.add(c0Var);
        return true;
    }

    /* renamed from: g */
    public boolean mo5830g(RecyclerView.C1039c0 c0Var) {
        m4388v(c0Var);
        this.f2902h.add(c0Var);
        return true;
    }

    /* renamed from: i */
    public void mo5526i() {
        boolean z = !this.f2902h.isEmpty();
        boolean z2 = !this.f2904j.isEmpty();
        boolean z3 = !this.f2905k.isEmpty();
        boolean z4 = !this.f2903i.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.C1039c0> it = this.f2902h.iterator();
            while (it.hasNext()) {
                m4387u(it.next());
            }
            this.f2902h.clear();
            if (z2) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f2904j);
                this.f2907m.add(arrayList);
                this.f2904j.clear();
                C1084a aVar = new C1084a(arrayList);
                if (z) {
                    C0839t.m2700a(((C1093j) arrayList.get(0)).f2947a.itemView, (Runnable) aVar, mo5523f());
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f2905k);
                this.f2908n.add(arrayList2);
                this.f2905k.clear();
                C1085b bVar = new C1085b(arrayList2);
                if (z) {
                    C0839t.m2700a(((C1092i) arrayList2.get(0)).f2941a.itemView, (Runnable) bVar, mo5523f());
                } else {
                    bVar.run();
                }
            }
            if (z4) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f2903i);
                this.f2906l.add(arrayList3);
                this.f2903i.clear();
                C1086c cVar = new C1086c(arrayList3);
                if (z || z2 || z3) {
                    long j = 0;
                    long f = z ? mo5523f() : 0;
                    long e = z2 ? mo5522e() : 0;
                    if (z3) {
                        j = mo5520d();
                    }
                    C0839t.m2700a(((RecyclerView.C1039c0) arrayList3.get(0)).itemView, (Runnable) cVar, f + Math.max(e, j));
                    return;
                }
                cVar.run();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo5831j() {
        if (!mo5524g()) {
            mo5508a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public void mo5832t(RecyclerView.C1039c0 c0Var) {
        View view = c0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f2909o.add(c0Var);
        animate.alpha(1.0f).setDuration(mo5517c()).setListener(new C1088e(c0Var, view, animate)).start();
    }

    /* renamed from: androidx.recyclerview.widget.c$i */
    /* compiled from: DefaultItemAnimator */
    private static class C1092i {

        /* renamed from: a */
        public RecyclerView.C1039c0 f2941a;

        /* renamed from: b */
        public RecyclerView.C1039c0 f2942b;

        /* renamed from: c */
        public int f2943c;

        /* renamed from: d */
        public int f2944d;

        /* renamed from: e */
        public int f2945e;

        /* renamed from: f */
        public int f2946f;

        private C1092i(RecyclerView.C1039c0 c0Var, RecyclerView.C1039c0 c0Var2) {
            this.f2941a = c0Var;
            this.f2942b = c0Var2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f2941a + ", newHolder=" + this.f2942b + ", fromX=" + this.f2943c + ", fromY=" + this.f2944d + ", toX=" + this.f2945e + ", toY=" + this.f2946f + '}';
        }

        C1092i(RecyclerView.C1039c0 c0Var, RecyclerView.C1039c0 c0Var2, int i, int i2, int i3, int i4) {
            this(c0Var, c0Var2);
            this.f2943c = i;
            this.f2944d = i2;
            this.f2945e = i3;
            this.f2946f = i4;
        }
    }

    /* renamed from: g */
    public boolean mo5524g() {
        return !this.f2903i.isEmpty() || !this.f2905k.isEmpty() || !this.f2904j.isEmpty() || !this.f2902h.isEmpty() || !this.f2910p.isEmpty() || !this.f2911q.isEmpty() || !this.f2909o.isEmpty() || !this.f2912r.isEmpty() || !this.f2907m.isEmpty() || !this.f2906l.isEmpty() || !this.f2908n.isEmpty();
    }

    /* renamed from: b */
    private void m4386b(C1092i iVar) {
        RecyclerView.C1039c0 c0Var = iVar.f2941a;
        if (c0Var != null) {
            m4385a(iVar, c0Var);
        }
        RecyclerView.C1039c0 c0Var2 = iVar.f2942b;
        if (c0Var2 != null) {
            m4385a(iVar, c0Var2);
        }
    }

    /* renamed from: a */
    public boolean mo5827a(RecyclerView.C1039c0 c0Var, RecyclerView.C1039c0 c0Var2, int i, int i2, int i3, int i4) {
        if (c0Var == c0Var2) {
            return mo5826a(c0Var, i, i2, i3, i4);
        }
        float translationX = c0Var.itemView.getTranslationX();
        float translationY = c0Var.itemView.getTranslationY();
        float alpha = c0Var.itemView.getAlpha();
        m4388v(c0Var);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        c0Var.itemView.setTranslationX(translationX);
        c0Var.itemView.setTranslationY(translationY);
        c0Var.itemView.setAlpha(alpha);
        if (c0Var2 != null) {
            m4388v(c0Var2);
            c0Var2.itemView.setTranslationX((float) (-i5));
            c0Var2.itemView.setTranslationY((float) (-i6));
            c0Var2.itemView.setAlpha(0.0f);
        }
        this.f2905k.add(new C1092i(c0Var, c0Var2, i, i2, i3, i4));
        return true;
    }

    /* renamed from: b */
    public void mo5514b() {
        int size = this.f2904j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            C1093j jVar = this.f2904j.get(size);
            View view = jVar.f2947a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            mo5905j(jVar.f2947a);
            this.f2904j.remove(size);
        }
        for (int size2 = this.f2902h.size() - 1; size2 >= 0; size2--) {
            mo5907l(this.f2902h.get(size2));
            this.f2902h.remove(size2);
        }
        int size3 = this.f2903i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.C1039c0 c0Var = this.f2903i.get(size3);
            c0Var.itemView.setAlpha(1.0f);
            mo5903h(c0Var);
            this.f2903i.remove(size3);
        }
        for (int size4 = this.f2905k.size() - 1; size4 >= 0; size4--) {
            m4386b(this.f2905k.get(size4));
        }
        this.f2905k.clear();
        if (mo5524g()) {
            for (int size5 = this.f2907m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.f2907m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    C1093j jVar2 = (C1093j) arrayList.get(size6);
                    View view2 = jVar2.f2947a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    mo5905j(jVar2.f2947a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f2907m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f2906l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f2906l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.C1039c0 c0Var2 = (RecyclerView.C1039c0) arrayList2.get(size8);
                    c0Var2.itemView.setAlpha(1.0f);
                    mo5903h(c0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f2906l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f2908n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.f2908n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    m4386b((C1092i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f2908n.remove(arrayList3);
                    }
                }
            }
            mo5825a((List<RecyclerView.C1039c0>) this.f2911q);
            mo5825a((List<RecyclerView.C1039c0>) this.f2910p);
            mo5825a((List<RecyclerView.C1039c0>) this.f2909o);
            mo5825a((List<RecyclerView.C1039c0>) this.f2912r);
            mo5508a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5824a(C1092i iVar) {
        View view;
        RecyclerView.C1039c0 c0Var = iVar.f2941a;
        View view2 = null;
        if (c0Var == null) {
            view = null;
        } else {
            view = c0Var.itemView;
        }
        RecyclerView.C1039c0 c0Var2 = iVar.f2942b;
        if (c0Var2 != null) {
            view2 = c0Var2.itemView;
        }
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(mo5520d());
            this.f2912r.add(iVar.f2941a);
            duration.translationX((float) (iVar.f2945e - iVar.f2943c));
            duration.translationY((float) (iVar.f2946f - iVar.f2944d));
            duration.alpha(0.0f).setListener(new C1090g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.f2912r.add(iVar.f2942b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(mo5520d()).alpha(1.0f).setListener(new C1091h(iVar, animate, view2)).start();
        }
    }

    /* renamed from: a */
    private void m4384a(List<C1092i> list, RecyclerView.C1039c0 c0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C1092i iVar = list.get(size);
            if (m4385a(iVar, c0Var) && iVar.f2941a == null && iVar.f2942b == null) {
                list.remove(iVar);
            }
        }
    }

    /* renamed from: a */
    private boolean m4385a(C1092i iVar, RecyclerView.C1039c0 c0Var) {
        boolean z = false;
        if (iVar.f2942b == c0Var) {
            iVar.f2942b = null;
        } else if (iVar.f2941a != c0Var) {
            return false;
        } else {
            iVar.f2941a = null;
            z = true;
        }
        c0Var.itemView.setAlpha(1.0f);
        c0Var.itemView.setTranslationX(0.0f);
        c0Var.itemView.setTranslationY(0.0f);
        mo5899a(c0Var, z);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5825a(List<RecyclerView.C1039c0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    /* renamed from: a */
    public boolean mo5513a(RecyclerView.C1039c0 c0Var, List<Object> list) {
        return !list.isEmpty() || super.mo5513a(c0Var, list);
    }
}
