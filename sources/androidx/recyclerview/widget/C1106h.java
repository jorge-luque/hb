package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.h */
/* compiled from: OrientationHelper */
public abstract class C1106h {

    /* renamed from: a */
    protected final RecyclerView.C1054o f3013a;

    /* renamed from: b */
    private int f3014b;

    /* renamed from: c */
    final Rect f3015c;

    /* renamed from: androidx.recyclerview.widget.h$a */
    /* compiled from: OrientationHelper */
    static class C1107a extends C1106h {
        C1107a(RecyclerView.C1054o oVar) {
            super(oVar, (C1107a) null);
        }

        /* renamed from: a */
        public int mo5879a() {
            return this.f3013a.mo5619q();
        }

        /* renamed from: b */
        public int mo5882b() {
            return this.f3013a.mo5619q() - this.f3013a.mo5616o();
        }

        /* renamed from: c */
        public int mo5885c(View view) {
            RecyclerView.C1059p pVar = (RecyclerView.C1059p) view.getLayoutParams();
            return this.f3013a.mo5599g(view) + pVar.topMargin + pVar.bottomMargin;
        }

        /* renamed from: d */
        public int mo5887d(View view) {
            return this.f3013a.mo5595f(view) - ((RecyclerView.C1059p) view.getLayoutParams()).leftMargin;
        }

        /* renamed from: e */
        public int mo5889e(View view) {
            this.f3013a.mo5549a(view, true, this.f3015c);
            return this.f3015c.right;
        }

        /* renamed from: f */
        public int mo5890f() {
            return this.f3013a.mo5614n();
        }

        /* renamed from: g */
        public int mo5892g() {
            return (this.f3013a.mo5619q() - this.f3013a.mo5614n()) - this.f3013a.mo5616o();
        }

        /* renamed from: a */
        public void mo5881a(int i) {
            this.f3013a.mo5588d(i);
        }

        /* renamed from: b */
        public int mo5883b(View view) {
            RecyclerView.C1059p pVar = (RecyclerView.C1059p) view.getLayoutParams();
            return this.f3013a.mo5603h(view) + pVar.leftMargin + pVar.rightMargin;
        }

        /* renamed from: f */
        public int mo5891f(View view) {
            this.f3013a.mo5549a(view, true, this.f3015c);
            return this.f3015c.left;
        }

        /* renamed from: a */
        public int mo5880a(View view) {
            return this.f3013a.mo5605i(view) + ((RecyclerView.C1059p) view.getLayoutParams()).rightMargin;
        }

        /* renamed from: c */
        public int mo5884c() {
            return this.f3013a.mo5616o();
        }

        /* renamed from: d */
        public int mo5886d() {
            return this.f3013a.mo5620r();
        }

        /* renamed from: e */
        public int mo5888e() {
            return this.f3013a.mo5604i();
        }
    }

    /* renamed from: androidx.recyclerview.widget.h$b */
    /* compiled from: OrientationHelper */
    static class C1108b extends C1106h {
        C1108b(RecyclerView.C1054o oVar) {
            super(oVar, (C1107a) null);
        }

        /* renamed from: a */
        public int mo5879a() {
            return this.f3013a.mo5602h();
        }

        /* renamed from: b */
        public int mo5882b() {
            return this.f3013a.mo5602h() - this.f3013a.mo5612m();
        }

        /* renamed from: c */
        public int mo5885c(View view) {
            RecyclerView.C1059p pVar = (RecyclerView.C1059p) view.getLayoutParams();
            return this.f3013a.mo5603h(view) + pVar.leftMargin + pVar.rightMargin;
        }

        /* renamed from: d */
        public int mo5887d(View view) {
            return this.f3013a.mo5607j(view) - ((RecyclerView.C1059p) view.getLayoutParams()).topMargin;
        }

        /* renamed from: e */
        public int mo5889e(View view) {
            this.f3013a.mo5549a(view, true, this.f3015c);
            return this.f3015c.bottom;
        }

        /* renamed from: f */
        public int mo5890f() {
            return this.f3013a.mo5618p();
        }

        /* renamed from: g */
        public int mo5892g() {
            return (this.f3013a.mo5602h() - this.f3013a.mo5618p()) - this.f3013a.mo5612m();
        }

        /* renamed from: a */
        public void mo5881a(int i) {
            this.f3013a.mo5593e(i);
        }

        /* renamed from: b */
        public int mo5883b(View view) {
            RecyclerView.C1059p pVar = (RecyclerView.C1059p) view.getLayoutParams();
            return this.f3013a.mo5599g(view) + pVar.topMargin + pVar.bottomMargin;
        }

        /* renamed from: f */
        public int mo5891f(View view) {
            this.f3013a.mo5549a(view, true, this.f3015c);
            return this.f3015c.top;
        }

        /* renamed from: a */
        public int mo5880a(View view) {
            return this.f3013a.mo5592e(view) + ((RecyclerView.C1059p) view.getLayoutParams()).bottomMargin;
        }

        /* renamed from: c */
        public int mo5884c() {
            return this.f3013a.mo5612m();
        }

        /* renamed from: d */
        public int mo5886d() {
            return this.f3013a.mo5604i();
        }

        /* renamed from: e */
        public int mo5888e() {
            return this.f3013a.mo5620r();
        }
    }

    /* synthetic */ C1106h(RecyclerView.C1054o oVar, C1107a aVar) {
        this(oVar);
    }

    /* renamed from: a */
    public static C1106h m4455a(RecyclerView.C1054o oVar, int i) {
        if (i == 0) {
            return m4454a(oVar);
        }
        if (i == 1) {
            return m4456b(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    /* renamed from: b */
    public static C1106h m4456b(RecyclerView.C1054o oVar) {
        return new C1108b(oVar);
    }

    /* renamed from: a */
    public abstract int mo5879a();

    /* renamed from: a */
    public abstract int mo5880a(View view);

    /* renamed from: a */
    public abstract void mo5881a(int i);

    /* renamed from: b */
    public abstract int mo5882b();

    /* renamed from: b */
    public abstract int mo5883b(View view);

    /* renamed from: c */
    public abstract int mo5884c();

    /* renamed from: c */
    public abstract int mo5885c(View view);

    /* renamed from: d */
    public abstract int mo5886d();

    /* renamed from: d */
    public abstract int mo5887d(View view);

    /* renamed from: e */
    public abstract int mo5888e();

    /* renamed from: e */
    public abstract int mo5889e(View view);

    /* renamed from: f */
    public abstract int mo5890f();

    /* renamed from: f */
    public abstract int mo5891f(View view);

    /* renamed from: g */
    public abstract int mo5892g();

    /* renamed from: h */
    public int mo5893h() {
        if (Integer.MIN_VALUE == this.f3014b) {
            return 0;
        }
        return mo5892g() - this.f3014b;
    }

    /* renamed from: i */
    public void mo5894i() {
        this.f3014b = mo5892g();
    }

    private C1106h(RecyclerView.C1054o oVar) {
        this.f3014b = Integer.MIN_VALUE;
        this.f3015c = new Rect();
        this.f3013a = oVar;
    }

    /* renamed from: a */
    public static C1106h m4454a(RecyclerView.C1054o oVar) {
        return new C1107a(oVar);
    }
}
