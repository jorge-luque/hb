package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.C1054o {

    /* renamed from: A */
    int f2622A;

    /* renamed from: B */
    int f2623B;

    /* renamed from: C */
    private boolean f2624C;

    /* renamed from: D */
    SavedState f2625D;

    /* renamed from: E */
    final C1030a f2626E;

    /* renamed from: F */
    private final C1031b f2627F;

    /* renamed from: G */
    private int f2628G;

    /* renamed from: H */
    private int[] f2629H;

    /* renamed from: s */
    int f2630s;

    /* renamed from: t */
    private C1032c f2631t;

    /* renamed from: u */
    C1106h f2632u;

    /* renamed from: v */
    private boolean f2633v;

    /* renamed from: w */
    private boolean f2634w;

    /* renamed from: x */
    boolean f2635x;

    /* renamed from: y */
    private boolean f2636y;

    /* renamed from: z */
    private boolean f2637z;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1029a();

        /* renamed from: a */
        int f2638a;

        /* renamed from: b */
        int f2639b;

        /* renamed from: c */
        boolean f2640c;

        /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$SavedState$a */
        static class C1029a implements Parcelable.Creator<SavedState> {
            C1029a() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5223a() {
            return this.f2638a >= 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5224b() {
            this.f2638a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2638a);
            parcel.writeInt(this.f2639b);
            parcel.writeInt(this.f2640c ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.f2638a = parcel.readInt();
            this.f2639b = parcel.readInt();
            this.f2640c = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.f2638a = savedState.f2638a;
            this.f2639b = savedState.f2639b;
            this.f2640c = savedState.f2640c;
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$b */
    protected static class C1031b {

        /* renamed from: a */
        public int f2646a;

        /* renamed from: b */
        public boolean f2647b;

        /* renamed from: c */
        public boolean f2648c;

        /* renamed from: d */
        public boolean f2649d;

        protected C1031b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5235a() {
            this.f2646a = 0;
            this.f2647b = false;
            this.f2648c = false;
            this.f2649d = false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$c */
    static class C1032c {

        /* renamed from: a */
        boolean f2650a = true;

        /* renamed from: b */
        int f2651b;

        /* renamed from: c */
        int f2652c;

        /* renamed from: d */
        int f2653d;

        /* renamed from: e */
        int f2654e;

        /* renamed from: f */
        int f2655f;

        /* renamed from: g */
        int f2656g;

        /* renamed from: h */
        int f2657h = 0;

        /* renamed from: i */
        int f2658i = 0;

        /* renamed from: j */
        boolean f2659j;

        /* renamed from: k */
        int f2660k;

        /* renamed from: l */
        List<RecyclerView.C1039c0> f2661l = null;

        /* renamed from: m */
        boolean f2662m;

        C1032c() {
        }

        /* renamed from: b */
        private View m3732b() {
            int size = this.f2661l.size();
            for (int i = 0; i < size; i++) {
                View view = this.f2661l.get(i).itemView;
                RecyclerView.C1059p pVar = (RecyclerView.C1059p) view.getLayoutParams();
                if (!pVar.mo5635c() && this.f2653d == pVar.mo5633a()) {
                    mo5238a(view);
                    return view;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5239a(RecyclerView.C1070z zVar) {
            int i = this.f2653d;
            return i >= 0 && i < zVar.mo5697a();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public View mo5236a(RecyclerView.C1066v vVar) {
            if (this.f2661l != null) {
                return m3732b();
            }
            View d = vVar.mo5678d(this.f2653d);
            this.f2653d += this.f2654e;
            return d;
        }

        /* renamed from: a */
        public void mo5237a() {
            mo5238a((View) null);
        }

        /* renamed from: a */
        public void mo5238a(View view) {
            View b = mo5240b(view);
            if (b == null) {
                this.f2653d = -1;
            } else {
                this.f2653d = ((RecyclerView.C1059p) b.getLayoutParams()).mo5633a();
            }
        }

        /* renamed from: b */
        public View mo5240b(View view) {
            int a;
            int size = this.f2661l.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.f2661l.get(i2).itemView;
                RecyclerView.C1059p pVar = (RecyclerView.C1059p) view3.getLayoutParams();
                if (view3 != view && !pVar.mo5635c() && (a = (pVar.mo5633a() - this.f2653d) * this.f2654e) >= 0 && a < i) {
                    view2 = view3;
                    if (a == 0) {
                        break;
                    }
                    i = a;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    /* renamed from: L */
    private View m3646L() {
        return mo5217e(0, mo5591e());
    }

    /* renamed from: M */
    private View m3647M() {
        return mo5217e(mo5591e() - 1, -1);
    }

    /* renamed from: N */
    private View m3648N() {
        if (this.f2635x) {
            return m3646L();
        }
        return m3647M();
    }

    /* renamed from: O */
    private View m3649O() {
        if (this.f2635x) {
            return m3647M();
        }
        return m3646L();
    }

    /* renamed from: P */
    private View m3650P() {
        return mo5578c(this.f2635x ? 0 : mo5591e() - 1);
    }

    /* renamed from: Q */
    private View m3651Q() {
        return mo5578c(this.f2635x ? mo5591e() - 1 : 0);
    }

    /* renamed from: R */
    private void m3652R() {
        if (this.f2630s == 1 || !mo5196I()) {
            this.f2635x = this.f2634w;
        } else {
            this.f2635x = !this.f2634w;
        }
    }

    /* renamed from: f */
    private void mo5177f(int i, int i2) {
        this.f2631t.f2652c = this.f2632u.mo5882b() - i2;
        this.f2631t.f2654e = this.f2635x ? -1 : 1;
        C1032c cVar = this.f2631t;
        cVar.f2653d = i;
        cVar.f2655f = 1;
        cVar.f2651b = i2;
        cVar.f2656g = Integer.MIN_VALUE;
    }

    /* renamed from: j */
    private int m3673j(RecyclerView.C1070z zVar) {
        if (mo5591e() == 0) {
            return 0;
        }
        mo5192E();
        C1106h hVar = this.f2632u;
        View b = mo5212b(!this.f2637z, true);
        return C1111j.m4518a(zVar, hVar, b, mo5202a(!this.f2637z, true), this, this.f2637z, this.f2635x);
    }

    /* renamed from: k */
    private int m3674k(RecyclerView.C1070z zVar) {
        if (mo5591e() == 0) {
            return 0;
        }
        mo5192E();
        C1106h hVar = this.f2632u;
        View b = mo5212b(!this.f2637z, true);
        return C1111j.m4519b(zVar, hVar, b, mo5202a(!this.f2637z, true), this, this.f2637z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public boolean mo5190A() {
        return (mo5604i() == 1073741824 || mo5620r() == 1073741824 || !mo5621s()) ? false : true;
    }

    /* renamed from: C */
    public boolean mo5151C() {
        return this.f2625D == null && this.f2633v == this.f2636y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public C1032c mo5191D() {
        return new C1032c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public void mo5192E() {
        if (this.f2631t == null) {
            this.f2631t = mo5191D();
        }
    }

    /* renamed from: F */
    public int mo5193F() {
        View a = mo5201a(0, mo5591e(), false, true);
        if (a == null) {
            return -1;
        }
        return mo5611l(a);
    }

    /* renamed from: G */
    public int mo5194G() {
        View a = mo5201a(mo5591e() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return mo5611l(a);
    }

    /* renamed from: H */
    public int mo5195H() {
        return this.f2630s;
    }

    /* access modifiers changed from: protected */
    /* renamed from: I */
    public boolean mo5196I() {
        return mo5606j() == 1;
    }

    /* renamed from: J */
    public boolean mo5197J() {
        return this.f2637z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: K */
    public boolean mo5198K() {
        return this.f2632u.mo5886d() == 0 && this.f2632u.mo5879a() == 0;
    }

    /* renamed from: a */
    public void mo5206a(AccessibilityEvent accessibilityEvent) {
        super.mo5206a(accessibilityEvent);
        if (mo5591e() > 0) {
            accessibilityEvent.setFromIndex(mo5193F());
            accessibilityEvent.setToIndex(mo5194G());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5160a(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, C1030a aVar, int i) {
    }

    /* renamed from: b */
    public void mo5213b(RecyclerView recyclerView, RecyclerView.C1066v vVar) {
        super.mo5213b(recyclerView, vVar);
        if (this.f2624C) {
            mo5574b(vVar);
            vVar.mo5660a();
        }
    }

    /* renamed from: c */
    public RecyclerView.C1059p mo5173c() {
        return new RecyclerView.C1059p(-2, -2);
    }

    /* renamed from: d */
    public int mo5216d(RecyclerView.C1070z zVar) {
        return m3671i(zVar);
    }

    /* renamed from: e */
    public void mo5176e(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View b;
        int i7;
        int i8;
        int i9 = -1;
        if (!(this.f2625D == null && this.f2622A == -1) && zVar.mo5697a() == 0) {
            mo5574b(vVar);
            return;
        }
        SavedState savedState = this.f2625D;
        if (savedState != null && savedState.mo5223a()) {
            this.f2622A = this.f2625D.f2638a;
        }
        mo5192E();
        this.f2631t.f2650a = false;
        m3652R();
        View g = mo5600g();
        if (!this.f2626E.f2645e || this.f2622A != -1 || this.f2625D != null) {
            this.f2626E.mo5232b();
            C1030a aVar = this.f2626E;
            aVar.f2644d = this.f2635x ^ this.f2636y;
            m3664b(vVar, zVar, aVar);
            this.f2626E.f2645e = true;
        } else if (g != null && (this.f2632u.mo5887d(g) >= this.f2632u.mo5882b() || this.f2632u.mo5880a(g) <= this.f2632u.mo5890f())) {
            this.f2626E.mo5233b(g, mo5611l(g));
        }
        C1032c cVar = this.f2631t;
        cVar.f2655f = cVar.f2660k >= 0 ? 1 : -1;
        int[] iArr = this.f2629H;
        iArr[0] = 0;
        iArr[1] = 0;
        mo5207a(zVar, iArr);
        int max = Math.max(0, this.f2629H[0]) + this.f2632u.mo5890f();
        int max2 = Math.max(0, this.f2629H[1]) + this.f2632u.mo5884c();
        if (!(!zVar.mo5702d() || (i6 = this.f2622A) == -1 || this.f2623B == Integer.MIN_VALUE || (b = mo5211b(i6)) == null)) {
            if (this.f2635x) {
                i7 = this.f2632u.mo5882b() - this.f2632u.mo5880a(b);
                i8 = this.f2623B;
            } else {
                i8 = this.f2632u.mo5887d(b) - this.f2632u.mo5890f();
                i7 = this.f2623B;
            }
            int i10 = i7 - i8;
            if (i10 > 0) {
                max += i10;
            } else {
                max2 -= i10;
            }
        }
        if (!this.f2626E.f2644d ? !this.f2635x : this.f2635x) {
            i9 = 1;
        }
        mo5160a(vVar, zVar, this.f2626E, i9);
        mo5552a(vVar);
        this.f2631t.f2662m = mo5198K();
        this.f2631t.f2659j = zVar.mo5702d();
        this.f2631t.f2658i = 0;
        C1030a aVar2 = this.f2626E;
        if (aVar2.f2644d) {
            m3661b(aVar2);
            C1032c cVar2 = this.f2631t;
            cVar2.f2657h = max;
            mo5199a(vVar, cVar2, zVar, false);
            C1032c cVar3 = this.f2631t;
            i2 = cVar3.f2651b;
            int i11 = cVar3.f2653d;
            int i12 = cVar3.f2652c;
            if (i12 > 0) {
                max2 += i12;
            }
            m3655a(this.f2626E);
            C1032c cVar4 = this.f2631t;
            cVar4.f2657h = max2;
            cVar4.f2653d += cVar4.f2654e;
            mo5199a(vVar, cVar4, zVar, false);
            C1032c cVar5 = this.f2631t;
            i = cVar5.f2651b;
            int i13 = cVar5.f2652c;
            if (i13 > 0) {
                m3669g(i11, i2);
                C1032c cVar6 = this.f2631t;
                cVar6.f2657h = i13;
                mo5199a(vVar, cVar6, zVar, false);
                i2 = this.f2631t.f2651b;
            }
        } else {
            m3655a(aVar2);
            C1032c cVar7 = this.f2631t;
            cVar7.f2657h = max2;
            mo5199a(vVar, cVar7, zVar, false);
            C1032c cVar8 = this.f2631t;
            i = cVar8.f2651b;
            int i14 = cVar8.f2653d;
            int i15 = cVar8.f2652c;
            if (i15 > 0) {
                max += i15;
            }
            m3661b(this.f2626E);
            C1032c cVar9 = this.f2631t;
            cVar9.f2657h = max;
            cVar9.f2653d += cVar9.f2654e;
            mo5199a(vVar, cVar9, zVar, false);
            C1032c cVar10 = this.f2631t;
            i2 = cVar10.f2651b;
            int i16 = cVar10.f2652c;
            if (i16 > 0) {
                mo5177f(i14, i);
                C1032c cVar11 = this.f2631t;
                cVar11.f2657h = i16;
                mo5199a(vVar, cVar11, zVar, false);
                i = this.f2631t.f2651b;
            }
        }
        if (mo5591e() > 0) {
            if (this.f2635x ^ this.f2636y) {
                int a = m3653a(i, vVar, zVar, true);
                i4 = i2 + a;
                i3 = i + a;
                i5 = m3660b(i4, vVar, zVar, false);
            } else {
                int b2 = m3660b(i2, vVar, zVar, true);
                i4 = i2 + b2;
                i3 = i + b2;
                i5 = m3653a(i3, vVar, zVar, false);
            }
            i2 = i4 + i5;
            i = i3 + i5;
        }
        m3663b(vVar, zVar, i2, i);
        if (!zVar.mo5702d()) {
            this.f2632u.mo5894i();
        } else {
            this.f2626E.mo5232b();
        }
        this.f2633v = this.f2636y;
    }

    /* renamed from: g */
    public void mo5179g(RecyclerView.C1070z zVar) {
        super.mo5179g(zVar);
        this.f2625D = null;
        this.f2622A = -1;
        this.f2623B = Integer.MIN_VALUE;
        this.f2626E.mo5232b();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    /* renamed from: h */
    public int mo5219h(RecyclerView.C1070z zVar) {
        if (zVar.mo5701c()) {
            return this.f2632u.mo5892g();
        }
        return 0;
    }

    /* renamed from: i */
    public void mo5220i(int i) {
        if (i == 0 || i == 1) {
            mo5208a((String) null);
            if (i != this.f2630s || this.f2632u == null) {
                C1106h a = C1106h.m4455a(this, i);
                this.f2632u = a;
                this.f2626E.f2641a = a;
                this.f2630s = i;
                mo5625y();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    /* renamed from: u */
    public boolean mo5221u() {
        return true;
    }

    /* renamed from: x */
    public Parcelable mo5222x() {
        if (this.f2625D != null) {
            return new SavedState(this.f2625D);
        }
        SavedState savedState = new SavedState();
        if (mo5591e() > 0) {
            mo5192E();
            boolean z = this.f2633v ^ this.f2635x;
            savedState.f2640c = z;
            if (z) {
                View P = m3650P();
                savedState.f2639b = this.f2632u.mo5882b() - this.f2632u.mo5880a(P);
                savedState.f2638a = mo5611l(P);
            } else {
                View Q = m3651Q();
                savedState.f2638a = mo5611l(Q);
                savedState.f2639b = this.f2632u.mo5887d(Q) - this.f2632u.mo5890f();
            }
        } else {
            savedState.mo5224b();
        }
        return savedState;
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f2630s = 1;
        this.f2634w = false;
        this.f2635x = false;
        this.f2636y = false;
        this.f2637z = true;
        this.f2622A = -1;
        this.f2623B = Integer.MIN_VALUE;
        this.f2625D = null;
        this.f2626E = new C1030a();
        this.f2627F = new C1031b();
        this.f2628G = 2;
        this.f2629H = new int[2];
        mo5220i(i);
        mo5209a(z);
    }

    /* renamed from: c */
    public int mo5172c(RecyclerView.C1070z zVar) {
        return m3674k(zVar);
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$a */
    static class C1030a {

        /* renamed from: a */
        C1106h f2641a;

        /* renamed from: b */
        int f2642b;

        /* renamed from: c */
        int f2643c;

        /* renamed from: d */
        boolean f2644d;

        /* renamed from: e */
        boolean f2645e;

        C1030a() {
            mo5232b();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5229a() {
            int i;
            if (this.f2644d) {
                i = this.f2641a.mo5882b();
            } else {
                i = this.f2641a.mo5890f();
            }
            this.f2643c = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5232b() {
            this.f2642b = -1;
            this.f2643c = Integer.MIN_VALUE;
            this.f2644d = false;
            this.f2645e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f2642b + ", mCoordinate=" + this.f2643c + ", mLayoutFromEnd=" + this.f2644d + ", mValid=" + this.f2645e + '}';
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5231a(View view, RecyclerView.C1070z zVar) {
            RecyclerView.C1059p pVar = (RecyclerView.C1059p) view.getLayoutParams();
            return !pVar.mo5635c() && pVar.mo5633a() >= 0 && pVar.mo5633a() < zVar.mo5697a();
        }

        /* renamed from: b */
        public void mo5233b(View view, int i) {
            int h = this.f2641a.mo5893h();
            if (h >= 0) {
                mo5230a(view, i);
                return;
            }
            this.f2642b = i;
            if (this.f2644d) {
                int b = (this.f2641a.mo5882b() - h) - this.f2641a.mo5880a(view);
                this.f2643c = this.f2641a.mo5882b() - b;
                if (b > 0) {
                    int b2 = this.f2643c - this.f2641a.mo5883b(view);
                    int f = this.f2641a.mo5890f();
                    int min = b2 - (f + Math.min(this.f2641a.mo5887d(view) - f, 0));
                    if (min < 0) {
                        this.f2643c += Math.min(b, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int d = this.f2641a.mo5887d(view);
            int f2 = d - this.f2641a.mo5890f();
            this.f2643c = d;
            if (f2 > 0) {
                int b3 = (this.f2641a.mo5882b() - Math.min(0, (this.f2641a.mo5882b() - h) - this.f2641a.mo5880a(view))) - (d + this.f2641a.mo5883b(view));
                if (b3 < 0) {
                    this.f2643c -= Math.min(f2, -b3);
                }
            }
        }

        /* renamed from: a */
        public void mo5230a(View view, int i) {
            if (this.f2644d) {
                this.f2643c = this.f2641a.mo5880a(view) + this.f2641a.mo5893h();
            } else {
                this.f2643c = this.f2641a.mo5887d(view);
            }
            this.f2642b = i;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo5215c(int i, RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        if (mo5591e() == 0 || i == 0) {
            return 0;
        }
        mo5192E();
        this.f2631t.f2650a = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        m3654a(i2, abs, true, zVar);
        C1032c cVar = this.f2631t;
        int a = cVar.f2656g + mo5199a(vVar, cVar, zVar, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.f2632u.mo5881a(-i);
        this.f2631t.f2660k = i;
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public int mo5218h(int i) {
        if (i == 1) {
            return (this.f2630s != 1 && mo5196I()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.f2630s != 1 && mo5196I()) ? -1 : 1;
        }
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    return (i == 130 && this.f2630s == 1) ? 1 : Integer.MIN_VALUE;
                }
                if (this.f2630s == 0) {
                    return 1;
                }
                return Integer.MIN_VALUE;
            } else if (this.f2630s == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.f2630s == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    /* renamed from: a */
    public void mo5205a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f2625D = (SavedState) parcelable;
            mo5625y();
        }
    }

    /* renamed from: b */
    public boolean mo5214b() {
        return this.f2630s == 1;
    }

    /* renamed from: g */
    private void m3669g(int i, int i2) {
        this.f2631t.f2652c = i2 - this.f2632u.mo5890f();
        C1032c cVar = this.f2631t;
        cVar.f2653d = i;
        cVar.f2654e = this.f2635x ? 1 : -1;
        C1032c cVar2 = this.f2631t;
        cVar2.f2655f = -1;
        cVar2.f2651b = i2;
        cVar2.f2656g = Integer.MIN_VALUE;
    }

    /* renamed from: b */
    public void mo5171b(boolean z) {
        mo5208a((String) null);
        if (this.f2636y != z) {
            this.f2636y = z;
            mo5625y();
        }
    }

    /* renamed from: f */
    public int mo5178f(RecyclerView.C1070z zVar) {
        return m3674k(zVar);
    }

    /* renamed from: f */
    private View m3666f(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        return mo5155a(vVar, zVar, 0, mo5591e(), zVar.mo5697a());
    }

    /* renamed from: i */
    private int m3671i(RecyclerView.C1070z zVar) {
        if (mo5591e() == 0) {
            return 0;
        }
        mo5192E();
        C1106h hVar = this.f2632u;
        View b = mo5212b(!this.f2637z, true);
        return C1111j.m4517a(zVar, hVar, b, mo5202a(!this.f2637z, true), this, this.f2637z);
    }

    /* renamed from: a */
    public boolean mo5210a() {
        return this.f2630s == 0;
    }

    /* renamed from: a */
    public void mo5209a(boolean z) {
        mo5208a((String) null);
        if (z != this.f2634w) {
            this.f2634w = z;
            mo5625y();
        }
    }

    /* renamed from: b */
    public View mo5211b(int i) {
        int e = mo5591e();
        if (e == 0) {
            return null;
        }
        int l = i - mo5611l(mo5578c(0));
        if (l >= 0 && l < e) {
            View c = mo5578c(l);
            if (mo5611l(c) == i) {
                return c;
            }
        }
        return super.mo5211b(i);
    }

    /* renamed from: h */
    private View m3670h(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        if (this.f2635x) {
            return m3666f(vVar, zVar);
        }
        return m3668g(vVar, zVar);
    }

    /* renamed from: c */
    private void m3665c(RecyclerView.C1066v vVar, int i, int i2) {
        if (i >= 0) {
            int i3 = i - i2;
            int e = mo5591e();
            if (this.f2635x) {
                int i4 = e - 1;
                for (int i5 = i4; i5 >= 0; i5--) {
                    View c = mo5578c(i5);
                    if (this.f2632u.mo5880a(c) > i3 || this.f2632u.mo5889e(c) > i3) {
                        m3656a(vVar, i4, i5);
                        return;
                    }
                }
                return;
            }
            for (int i6 = 0; i6 < e; i6++) {
                View c2 = mo5578c(i6);
                if (this.f2632u.mo5880a(c2) > i3 || this.f2632u.mo5889e(c2) > i3) {
                    m3656a(vVar, 0, i6);
                    return;
                }
            }
        }
    }

    /* renamed from: g */
    private View m3668g(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        return mo5155a(vVar, zVar, mo5591e() - 1, -1, zVar.mo5697a());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5207a(RecyclerView.C1070z zVar, int[] iArr) {
        int i;
        int h = mo5219h(zVar);
        if (this.f2631t.f2655f == -1) {
            i = 0;
        } else {
            i = h;
            h = 0;
        }
        iArr[0] = h;
        iArr[1] = i;
    }

    /* renamed from: i */
    private View m3672i(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        if (this.f2635x) {
            return m3668g(vVar, zVar);
        }
        return m3666f(vVar, zVar);
    }

    /* renamed from: b */
    private void m3663b(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, int i, int i2) {
        RecyclerView.C1066v vVar2 = vVar;
        RecyclerView.C1070z zVar2 = zVar;
        if (zVar.mo5703e() && mo5591e() != 0 && !zVar.mo5702d() && mo5151C()) {
            List<RecyclerView.C1039c0> f = vVar.mo5683f();
            int size = f.size();
            int l = mo5611l(mo5578c(0));
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.C1039c0 c0Var = f.get(i5);
                if (!c0Var.isRemoved()) {
                    char c = 1;
                    if ((c0Var.getLayoutPosition() < l) != this.f2635x) {
                        c = 65535;
                    }
                    if (c == 65535) {
                        i3 += this.f2632u.mo5883b(c0Var.itemView);
                    } else {
                        i4 += this.f2632u.mo5883b(c0Var.itemView);
                    }
                }
            }
            this.f2631t.f2661l = f;
            if (i3 > 0) {
                m3669g(mo5611l(m3651Q()), i);
                C1032c cVar = this.f2631t;
                cVar.f2657h = i3;
                cVar.f2652c = 0;
                cVar.mo5237a();
                mo5199a(vVar2, this.f2631t, zVar2, false);
            }
            if (i4 > 0) {
                mo5177f(mo5611l(m3650P()), i2);
                C1032c cVar2 = this.f2631t;
                cVar2.f2657h = i4;
                cVar2.f2652c = 0;
                cVar2.mo5237a();
                mo5199a(vVar2, this.f2631t, zVar2, false);
            }
            this.f2631t.f2661l = null;
        }
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2630s = 1;
        this.f2634w = false;
        this.f2635x = false;
        this.f2636y = false;
        this.f2637z = true;
        this.f2622A = -1;
        this.f2623B = Integer.MIN_VALUE;
        this.f2625D = null;
        this.f2626E = new C1030a();
        this.f2627F = new C1031b();
        this.f2628G = 2;
        this.f2629H = new int[2];
        RecyclerView.C1054o.C1058d a = RecyclerView.C1054o.m3945a(context, attributeSet, i, i2);
        mo5220i(a.f2787a);
        mo5209a(a.f2789c);
        mo5171b(a.f2790d);
    }

    /* renamed from: a */
    private boolean m3658a(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, C1030a aVar) {
        View view;
        int i;
        boolean z = false;
        if (mo5591e() == 0) {
            return false;
        }
        View g = mo5600g();
        if (g != null && aVar.mo5231a(g, zVar)) {
            aVar.mo5233b(g, mo5611l(g));
            return true;
        } else if (this.f2633v != this.f2636y) {
            return false;
        } else {
            if (aVar.f2644d) {
                view = m3670h(vVar, zVar);
            } else {
                view = m3672i(vVar, zVar);
            }
            if (view == null) {
                return false;
            }
            aVar.mo5230a(view, mo5611l(view));
            if (!zVar.mo5702d() && mo5151C()) {
                if (this.f2632u.mo5887d(view) >= this.f2632u.mo5882b() || this.f2632u.mo5880a(view) < this.f2632u.mo5890f()) {
                    z = true;
                }
                if (z) {
                    if (aVar.f2644d) {
                        i = this.f2632u.mo5882b();
                    } else {
                        i = this.f2632u.mo5890f();
                    }
                    aVar.f2643c = i;
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    private boolean m3659a(RecyclerView.C1070z zVar, C1030a aVar) {
        int i;
        int i2;
        boolean z = false;
        if (!zVar.mo5702d() && (i = this.f2622A) != -1) {
            if (i < 0 || i >= zVar.mo5697a()) {
                this.f2622A = -1;
                this.f2623B = Integer.MIN_VALUE;
            } else {
                aVar.f2642b = this.f2622A;
                SavedState savedState = this.f2625D;
                if (savedState != null && savedState.mo5223a()) {
                    boolean z2 = this.f2625D.f2640c;
                    aVar.f2644d = z2;
                    if (z2) {
                        aVar.f2643c = this.f2632u.mo5882b() - this.f2625D.f2639b;
                    } else {
                        aVar.f2643c = this.f2632u.mo5890f() + this.f2625D.f2639b;
                    }
                    return true;
                } else if (this.f2623B == Integer.MIN_VALUE) {
                    View b = mo5211b(this.f2622A);
                    if (b == null) {
                        if (mo5591e() > 0) {
                            if ((this.f2622A < mo5611l(mo5578c(0))) == this.f2635x) {
                                z = true;
                            }
                            aVar.f2644d = z;
                        }
                        aVar.mo5229a();
                    } else if (this.f2632u.mo5883b(b) > this.f2632u.mo5892g()) {
                        aVar.mo5229a();
                        return true;
                    } else if (this.f2632u.mo5887d(b) - this.f2632u.mo5890f() < 0) {
                        aVar.f2643c = this.f2632u.mo5890f();
                        aVar.f2644d = false;
                        return true;
                    } else if (this.f2632u.mo5882b() - this.f2632u.mo5880a(b) < 0) {
                        aVar.f2643c = this.f2632u.mo5882b();
                        aVar.f2644d = true;
                        return true;
                    } else {
                        if (aVar.f2644d) {
                            i2 = this.f2632u.mo5880a(b) + this.f2632u.mo5893h();
                        } else {
                            i2 = this.f2632u.mo5887d(b);
                        }
                        aVar.f2643c = i2;
                    }
                    return true;
                } else {
                    boolean z3 = this.f2635x;
                    aVar.f2644d = z3;
                    if (z3) {
                        aVar.f2643c = this.f2632u.mo5882b() - this.f2623B;
                    } else {
                        aVar.f2643c = this.f2632u.mo5890f() + this.f2623B;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m3664b(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, C1030a aVar) {
        if (!m3659a(zVar, aVar) && !m3658a(vVar, zVar, aVar)) {
            aVar.mo5229a();
            aVar.f2642b = this.f2636y ? zVar.mo5697a() - 1 : 0;
        }
    }

    /* renamed from: b */
    private int m3660b(int i, RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, boolean z) {
        int f;
        int f2 = i - this.f2632u.mo5890f();
        if (f2 <= 0) {
            return 0;
        }
        int i2 = -mo5215c(f2, vVar, zVar);
        int i3 = i + i2;
        if (!z || (f = i3 - this.f2632u.mo5890f()) <= 0) {
            return i2;
        }
        this.f2632u.mo5881a(-f);
        return i2 - f;
    }

    /* renamed from: b */
    private void m3661b(C1030a aVar) {
        m3669g(aVar.f2642b, aVar.f2643c);
    }

    /* renamed from: b */
    public int mo5167b(int i, RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        if (this.f2630s == 0) {
            return 0;
        }
        return mo5215c(i, vVar, zVar);
    }

    /* renamed from: b */
    public int mo5169b(RecyclerView.C1070z zVar) {
        return m3673j(zVar);
    }

    /* renamed from: b */
    private void m3662b(RecyclerView.C1066v vVar, int i, int i2) {
        int e = mo5591e();
        if (i >= 0) {
            int a = (this.f2632u.mo5879a() - i) + i2;
            if (this.f2635x) {
                for (int i3 = 0; i3 < e; i3++) {
                    View c = mo5578c(i3);
                    if (this.f2632u.mo5887d(c) < a || this.f2632u.mo5891f(c) < a) {
                        m3656a(vVar, 0, i3);
                        return;
                    }
                }
                return;
            }
            int i4 = e - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View c2 = mo5578c(i5);
                if (this.f2632u.mo5887d(c2) < a || this.f2632u.mo5891f(c2) < a) {
                    m3656a(vVar, i4, i5);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public View mo5212b(boolean z, boolean z2) {
        if (this.f2635x) {
            return mo5201a(mo5591e() - 1, -1, z, z2);
        }
        return mo5201a(0, mo5591e(), z, z2);
    }

    /* renamed from: a */
    private int m3653a(int i, RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, boolean z) {
        int b;
        int b2 = this.f2632u.mo5882b() - i;
        if (b2 <= 0) {
            return 0;
        }
        int i2 = -mo5215c(-b2, vVar, zVar);
        int i3 = i + i2;
        if (!z || (b = this.f2632u.mo5882b() - i3) <= 0) {
            return i2;
        }
        this.f2632u.mo5881a(b);
        return b + i2;
    }

    /* renamed from: a */
    private void m3655a(C1030a aVar) {
        mo5177f(aVar.f2642b, aVar.f2643c);
    }

    /* renamed from: a */
    public int mo5152a(int i, RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        if (this.f2630s == 1) {
            return 0;
        }
        return mo5215c(i, vVar, zVar);
    }

    /* renamed from: a */
    public int mo5200a(RecyclerView.C1070z zVar) {
        return m3671i(zVar);
    }

    /* renamed from: a */
    private void m3654a(int i, int i2, boolean z, RecyclerView.C1070z zVar) {
        int i3;
        this.f2631t.f2662m = mo5198K();
        this.f2631t.f2655f = i;
        int[] iArr = this.f2629H;
        boolean z2 = false;
        iArr[0] = 0;
        int i4 = 1;
        iArr[1] = 0;
        mo5207a(zVar, iArr);
        int max = Math.max(0, this.f2629H[0]);
        int max2 = Math.max(0, this.f2629H[1]);
        if (i == 1) {
            z2 = true;
        }
        this.f2631t.f2657h = z2 ? max2 : max;
        C1032c cVar = this.f2631t;
        if (!z2) {
            max = max2;
        }
        cVar.f2658i = max;
        if (z2) {
            this.f2631t.f2657h += this.f2632u.mo5884c();
            View P = m3650P();
            C1032c cVar2 = this.f2631t;
            if (this.f2635x) {
                i4 = -1;
            }
            cVar2.f2654e = i4;
            C1032c cVar3 = this.f2631t;
            int l = mo5611l(P);
            C1032c cVar4 = this.f2631t;
            cVar3.f2653d = l + cVar4.f2654e;
            cVar4.f2651b = this.f2632u.mo5880a(P);
            i3 = this.f2632u.mo5880a(P) - this.f2632u.mo5882b();
        } else {
            View Q = m3651Q();
            this.f2631t.f2657h += this.f2632u.mo5890f();
            C1032c cVar5 = this.f2631t;
            if (!this.f2635x) {
                i4 = -1;
            }
            cVar5.f2654e = i4;
            C1032c cVar6 = this.f2631t;
            int l2 = mo5611l(Q);
            C1032c cVar7 = this.f2631t;
            cVar6.f2653d = l2 + cVar7.f2654e;
            cVar7.f2651b = this.f2632u.mo5887d(Q);
            i3 = (-this.f2632u.mo5887d(Q)) + this.f2632u.mo5890f();
        }
        C1032c cVar8 = this.f2631t;
        cVar8.f2652c = i2;
        if (z) {
            cVar8.f2652c = i2 - i3;
        }
        this.f2631t.f2656g = i3;
    }

    /* renamed from: e */
    public int mo5175e(RecyclerView.C1070z zVar) {
        return m3673j(zVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public View mo5217e(int i, int i2) {
        int i3;
        int i4;
        mo5192E();
        if ((i2 > i ? 1 : i2 < i ? (char) 65535 : 0) == 0) {
            return mo5578c(i);
        }
        if (this.f2632u.mo5887d(mo5578c(i)) < this.f2632u.mo5890f()) {
            i4 = 16644;
            i3 = 16388;
        } else {
            i4 = 4161;
            i3 = 4097;
        }
        if (this.f2630s == 0) {
            return this.f2771e.mo5915a(i, i2, i4, i3);
        }
        return this.f2772f.mo5915a(i, i2, i4, i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5162a(RecyclerView.C1070z zVar, C1032c cVar, RecyclerView.C1054o.C1057c cVar2) {
        int i = cVar.f2653d;
        if (i >= 0 && i < zVar.mo5697a()) {
            cVar2.mo5632a(i, Math.max(0, cVar.f2656g));
        }
    }

    /* renamed from: a */
    public void mo5204a(int i, RecyclerView.C1054o.C1057c cVar) {
        boolean z;
        int i2;
        SavedState savedState = this.f2625D;
        int i3 = -1;
        if (savedState == null || !savedState.mo5223a()) {
            m3652R();
            z = this.f2635x;
            i2 = this.f2622A;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.f2625D;
            z = savedState2.f2640c;
            i2 = savedState2.f2638a;
        }
        if (!z) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.f2628G && i2 >= 0 && i2 < i; i4++) {
            cVar.mo5632a(i2, 0);
            i2 += i3;
        }
    }

    /* renamed from: a */
    public void mo5203a(int i, int i2, RecyclerView.C1070z zVar, RecyclerView.C1054o.C1057c cVar) {
        if (this.f2630s != 0) {
            i = i2;
        }
        if (mo5591e() != 0 && i != 0) {
            mo5192E();
            m3654a(i > 0 ? 1 : -1, Math.abs(i), true, zVar);
            mo5162a(zVar, this.f2631t, cVar);
        }
    }

    /* renamed from: a */
    public void mo5208a(String str) {
        if (this.f2625D == null) {
            super.mo5208a(str);
        }
    }

    /* renamed from: a */
    private void m3656a(RecyclerView.C1066v vVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    mo5540a(i3, vVar);
                }
                return;
            }
            while (i > i2) {
                mo5540a(i, vVar);
                i--;
            }
        }
    }

    /* renamed from: a */
    private void m3657a(RecyclerView.C1066v vVar, C1032c cVar) {
        if (cVar.f2650a && !cVar.f2662m) {
            int i = cVar.f2656g;
            int i2 = cVar.f2658i;
            if (cVar.f2655f == -1) {
                m3662b(vVar, i, i2);
            } else {
                m3665c(vVar, i, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5199a(RecyclerView.C1066v vVar, C1032c cVar, RecyclerView.C1070z zVar, boolean z) {
        int i = cVar.f2652c;
        int i2 = cVar.f2656g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.f2656g = i2 + i;
            }
            m3657a(vVar, cVar);
        }
        int i3 = cVar.f2652c + cVar.f2657h;
        C1031b bVar = this.f2627F;
        while (true) {
            if ((!cVar.f2662m && i3 <= 0) || !cVar.mo5239a(zVar)) {
                break;
            }
            bVar.mo5235a();
            mo5161a(vVar, zVar, cVar, bVar);
            if (!bVar.f2647b) {
                cVar.f2651b += bVar.f2646a * cVar.f2655f;
                if (!bVar.f2648c || cVar.f2661l != null || !zVar.mo5702d()) {
                    int i4 = cVar.f2652c;
                    int i5 = bVar.f2646a;
                    cVar.f2652c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.f2656g;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + bVar.f2646a;
                    cVar.f2656g = i7;
                    int i8 = cVar.f2652c;
                    if (i8 < 0) {
                        cVar.f2656g = i7 + i8;
                    }
                    m3657a(vVar, cVar);
                }
                if (z && bVar.f2649d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.f2652c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5161a(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, C1032c cVar, C1031b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View a = cVar.mo5236a(vVar);
        if (a == null) {
            bVar.f2647b = true;
            return;
        }
        RecyclerView.C1059p pVar = (RecyclerView.C1059p) a.getLayoutParams();
        if (cVar.f2661l == null) {
            if (this.f2635x == (cVar.f2655f == -1)) {
                mo5571b(a);
            } else {
                mo5572b(a, 0);
            }
        } else {
            if (this.f2635x == (cVar.f2655f == -1)) {
                mo5541a(a);
            } else {
                mo5542a(a, 0);
            }
        }
        mo5543a(a, 0, 0);
        bVar.f2646a = this.f2632u.mo5883b(a);
        if (this.f2630s == 1) {
            if (mo5196I()) {
                i5 = mo5619q() - mo5616o();
                i4 = i5 - this.f2632u.mo5885c(a);
            } else {
                i4 = mo5614n();
                i5 = this.f2632u.mo5885c(a) + i4;
            }
            if (cVar.f2655f == -1) {
                int i6 = cVar.f2651b;
                i = i6;
                i2 = i5;
                i3 = i6 - bVar.f2646a;
            } else {
                int i7 = cVar.f2651b;
                i3 = i7;
                i2 = i5;
                i = bVar.f2646a + i7;
            }
        } else {
            int p = mo5618p();
            int c = this.f2632u.mo5885c(a) + p;
            if (cVar.f2655f == -1) {
                int i8 = cVar.f2651b;
                i2 = i8;
                i3 = p;
                i = c;
                i4 = i8 - bVar.f2646a;
            } else {
                int i9 = cVar.f2651b;
                i3 = p;
                i2 = bVar.f2646a + i9;
                i = c;
                i4 = i9;
            }
        }
        mo5544a(a, i4, i3, i2, i);
        if (pVar.mo5635c() || pVar.mo5634b()) {
            bVar.f2648c = true;
        }
        bVar.f2649d = a.hasFocusable();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo5202a(boolean z, boolean z2) {
        if (this.f2635x) {
            return mo5201a(0, mo5591e(), z, z2);
        }
        return mo5201a(mo5591e() - 1, -1, z, z2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo5155a(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, int i, int i2, int i3) {
        mo5192E();
        int f = this.f2632u.mo5890f();
        int b = this.f2632u.mo5882b();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View c = mo5578c(i);
            int l = mo5611l(c);
            if (l >= 0 && l < i3) {
                if (((RecyclerView.C1059p) c.getLayoutParams()).mo5635c()) {
                    if (view2 == null) {
                        view2 = c;
                    }
                } else if (this.f2632u.mo5887d(c) < b && this.f2632u.mo5880a(c) >= f) {
                    return c;
                } else {
                    if (view == null) {
                        view = c;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo5201a(int i, int i2, boolean z, boolean z2) {
        mo5192E();
        int i3 = 320;
        int i4 = z ? 24579 : 320;
        if (!z2) {
            i3 = 0;
        }
        if (this.f2630s == 0) {
            return this.f2771e.mo5915a(i, i2, i4, i3);
        }
        return this.f2772f.mo5915a(i, i2, i4, i3);
    }

    /* renamed from: a */
    public View mo5154a(View view, int i, RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        int h;
        View view2;
        View view3;
        m3652R();
        if (mo5591e() == 0 || (h = mo5218h(i)) == Integer.MIN_VALUE) {
            return null;
        }
        mo5192E();
        m3654a(h, (int) (((float) this.f2632u.mo5892g()) * 0.33333334f), false, zVar);
        C1032c cVar = this.f2631t;
        cVar.f2656g = Integer.MIN_VALUE;
        cVar.f2650a = false;
        mo5199a(vVar, cVar, zVar, true);
        if (h == -1) {
            view2 = m3649O();
        } else {
            view2 = m3648N();
        }
        if (h == -1) {
            view3 = m3651Q();
        } else {
            view3 = m3650P();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }
}
