package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p020f.p021c0.C0807c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: I */
    boolean f2607I = false;

    /* renamed from: J */
    int f2608J = -1;

    /* renamed from: K */
    int[] f2609K;

    /* renamed from: L */
    View[] f2610L;

    /* renamed from: M */
    final SparseIntArray f2611M = new SparseIntArray();

    /* renamed from: N */
    final SparseIntArray f2612N = new SparseIntArray();

    /* renamed from: O */
    C1028c f2613O = new C1026a();

    /* renamed from: P */
    final Rect f2614P = new Rect();

    /* renamed from: Q */
    private boolean f2615Q;

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$a */
    public static final class C1026a extends C1028c {
        /* renamed from: a */
        public int mo5181a(int i) {
            return 1;
        }

        /* renamed from: d */
        public int mo5182d(int i, int i2) {
            return i % i2;
        }
    }

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$c */
    public static abstract class C1028c {

        /* renamed from: a */
        final SparseIntArray f2618a = new SparseIntArray();

        /* renamed from: b */
        final SparseIntArray f2619b = new SparseIntArray();

        /* renamed from: c */
        private boolean f2620c = false;

        /* renamed from: d */
        private boolean f2621d = false;

        /* renamed from: a */
        public abstract int mo5181a(int i);

        /* renamed from: a */
        public void mo5186a() {
            this.f2619b.clear();
        }

        /* renamed from: b */
        public void mo5188b() {
            this.f2618a.clear();
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int mo5189c(int r7, int r8) {
            /*
                r6 = this;
                boolean r0 = r6.f2621d
                r1 = 0
                if (r0 == 0) goto L_0x0024
                android.util.SparseIntArray r0 = r6.f2619b
                int r0 = m3638a((android.util.SparseIntArray) r0, (int) r7)
                r2 = -1
                if (r0 == r2) goto L_0x0024
                android.util.SparseIntArray r2 = r6.f2619b
                int r2 = r2.get(r0)
                int r3 = r0 + 1
                int r4 = r6.mo5187b(r0, r8)
                int r0 = r6.mo5181a(r0)
                int r4 = r4 + r0
                if (r4 != r8) goto L_0x0027
                int r2 = r2 + 1
                goto L_0x0026
            L_0x0024:
                r2 = 0
                r3 = 0
            L_0x0026:
                r4 = 0
            L_0x0027:
                int r0 = r6.mo5181a(r7)
            L_0x002b:
                if (r3 >= r7) goto L_0x0040
                int r5 = r6.mo5181a(r3)
                int r4 = r4 + r5
                if (r4 != r8) goto L_0x0038
                int r2 = r2 + 1
                r4 = 0
                goto L_0x003d
            L_0x0038:
                if (r4 <= r8) goto L_0x003d
                int r2 = r2 + 1
                r4 = r5
            L_0x003d:
                int r3 = r3 + 1
                goto L_0x002b
            L_0x0040:
                int r4 = r4 + r0
                if (r4 <= r8) goto L_0x0045
                int r2 = r2 + 1
            L_0x0045:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.C1028c.mo5189c(int, int):int");
        }

        /* renamed from: d */
        public abstract int mo5182d(int i, int i2);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo5185a(int i, int i2) {
            if (!this.f2621d) {
                return mo5189c(i, i2);
            }
            int i3 = this.f2619b.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int c = mo5189c(i, i2);
            this.f2619b.put(i, c);
            return c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo5187b(int i, int i2) {
            if (!this.f2620c) {
                return mo5182d(i, i2);
            }
            int i3 = this.f2618a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int d = mo5182d(i, i2);
            this.f2618a.put(i, d);
            return d;
        }

        /* renamed from: a */
        static int m3638a(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        mo5180j(RecyclerView.C1054o.m3945a(context, attributeSet, i, i2).f2788b);
    }

    /* renamed from: L */
    private void m3588L() {
        int e = mo5591e();
        for (int i = 0; i < e; i++) {
            C1027b bVar = (C1027b) mo5578c(i).getLayoutParams();
            int a = bVar.mo5633a();
            this.f2611M.put(a, bVar.mo5184f());
            this.f2612N.put(a, bVar.mo5183e());
        }
    }

    /* renamed from: M */
    private void m3589M() {
        this.f2611M.clear();
        this.f2612N.clear();
    }

    /* renamed from: N */
    private void m3590N() {
        View[] viewArr = this.f2610L;
        if (viewArr == null || viewArr.length != this.f2608J) {
            this.f2610L = new View[this.f2608J];
        }
    }

    /* renamed from: O */
    private void m3591O() {
        int i;
        int i2;
        if (mo5195H() == 1) {
            i2 = mo5619q() - mo5616o();
            i = mo5614n();
        } else {
            i2 = mo5602h() - mo5612m();
            i = mo5618p();
        }
        m3603k(i2 - i);
    }

    /* renamed from: i */
    private int m3601i(RecyclerView.C1070z zVar) {
        int i;
        if (!(mo5591e() == 0 || zVar.mo5697a() == 0)) {
            mo5192E();
            boolean J = mo5197J();
            View b = mo5212b(!J, true);
            View a = mo5202a(!J, true);
            if (!(b == null || a == null)) {
                int a2 = this.f2613O.mo5185a(mo5611l(b), this.f2608J);
                int a3 = this.f2613O.mo5185a(mo5611l(a), this.f2608J);
                int min = Math.min(a2, a3);
                int max = Math.max(a2, a3);
                int a4 = this.f2613O.mo5185a(zVar.mo5697a() - 1, this.f2608J) + 1;
                if (this.f2635x) {
                    i = Math.max(0, (a4 - max) - 1);
                } else {
                    i = Math.max(0, min);
                }
                if (!J) {
                    return i;
                }
                return Math.round((((float) i) * (((float) Math.abs(this.f2632u.mo5880a(a) - this.f2632u.mo5887d(b))) / ((float) ((this.f2613O.mo5185a(mo5611l(a), this.f2608J) - this.f2613O.mo5185a(mo5611l(b), this.f2608J)) + 1)))) + ((float) (this.f2632u.mo5890f() - this.f2632u.mo5887d(b))));
            }
        }
        return 0;
    }

    /* renamed from: k */
    private void m3603k(int i) {
        this.f2609K = m3597a(this.f2609K, this.f2608J, i);
    }

    /* renamed from: C */
    public boolean mo5151C() {
        return this.f2625D == null && !this.f2607I;
    }

    /* renamed from: a */
    public int mo5153a(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        if (this.f2630s == 1) {
            return this.f2608J;
        }
        if (zVar.mo5697a() < 1) {
            return 0;
        }
        return m3592a(vVar, zVar, zVar.mo5697a() - 1) + 1;
    }

    /* renamed from: b */
    public void mo5171b(boolean z) {
        if (!z) {
            super.mo5171b(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    /* renamed from: c */
    public RecyclerView.C1059p mo5173c() {
        if (this.f2630s == 0) {
            return new C1027b(-2, -1);
        }
        return new C1027b(-1, -2);
    }

    /* renamed from: d */
    public void mo5174d(RecyclerView recyclerView) {
        this.f2613O.mo5188b();
        this.f2613O.mo5186a();
    }

    /* renamed from: e */
    public void mo5176e(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        if (zVar.mo5702d()) {
            m3588L();
        }
        super.mo5176e(vVar, zVar);
        m3589M();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo5177f(int i, int i2) {
        if (this.f2630s != 1 || !mo5196I()) {
            int[] iArr = this.f2609K;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.f2609K;
        int i3 = this.f2608J;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    /* renamed from: g */
    public void mo5179g(RecyclerView.C1070z zVar) {
        super.mo5179g(zVar);
        this.f2607I = false;
    }

    /* renamed from: j */
    public void mo5180j(int i) {
        if (i != this.f2608J) {
            this.f2607I = true;
            if (i >= 1) {
                this.f2608J = i;
                this.f2613O.mo5188b();
                mo5625y();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$b */
    public static class C1027b extends RecyclerView.C1059p {

        /* renamed from: e */
        int f2616e = -1;

        /* renamed from: f */
        int f2617f = 0;

        public C1027b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* renamed from: e */
        public int mo5183e() {
            return this.f2616e;
        }

        /* renamed from: f */
        public int mo5184f() {
            return this.f2617f;
        }

        public C1027b(int i, int i2) {
            super(i, i2);
        }

        public C1027b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C1027b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: b */
    public int mo5168b(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        if (this.f2630s == 0) {
            return this.f2608J;
        }
        if (zVar.mo5697a() < 1) {
            return 0;
        }
        return m3592a(vVar, zVar, zVar.mo5697a() - 1) + 1;
    }

    /* renamed from: c */
    private int m3600c(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, int i) {
        if (!zVar.mo5702d()) {
            return this.f2613O.mo5181a(i);
        }
        int i2 = this.f2611M.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int a = vVar.mo5656a(i);
        if (a != -1) {
            return this.f2613O.mo5181a(a);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    /* renamed from: f */
    public int mo5178f(RecyclerView.C1070z zVar) {
        if (this.f2615Q) {
            return m3602j(zVar);
        }
        return super.mo5178f(zVar);
    }

    /* renamed from: a */
    public void mo5159a(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, View view, C0807c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof C1027b)) {
            super.mo5547a(view, cVar);
            return;
        }
        C1027b bVar = (C1027b) layoutParams;
        int a = m3592a(vVar, zVar, bVar.mo5633a());
        if (this.f2630s == 0) {
            cVar.mo4124b((Object) C0807c.C0810c.m2620a(bVar.mo5183e(), bVar.mo5184f(), a, 1, false, false));
            return;
        }
        cVar.mo4124b((Object) C0807c.C0810c.m2620a(a, 1, bVar.mo5183e(), bVar.mo5184f(), false, false));
    }

    /* renamed from: e */
    public int mo5175e(RecyclerView.C1070z zVar) {
        if (this.f2615Q) {
            return m3601i(zVar);
        }
        return super.mo5175e(zVar);
    }

    /* renamed from: j */
    private int m3602j(RecyclerView.C1070z zVar) {
        if (!(mo5591e() == 0 || zVar.mo5697a() == 0)) {
            mo5192E();
            View b = mo5212b(!mo5197J(), true);
            View a = mo5202a(!mo5197J(), true);
            if (!(b == null || a == null)) {
                if (!mo5197J()) {
                    return this.f2613O.mo5185a(zVar.mo5697a() - 1, this.f2608J) + 1;
                }
                int a2 = this.f2632u.mo5880a(a) - this.f2632u.mo5887d(b);
                int a3 = this.f2613O.mo5185a(mo5611l(b), this.f2608J);
                return (int) ((((float) a2) / ((float) ((this.f2613O.mo5185a(mo5611l(a), this.f2608J) - a3) + 1))) * ((float) (this.f2613O.mo5185a(zVar.mo5697a() - 1, this.f2608J) + 1)));
            }
        }
        return 0;
    }

    /* renamed from: b */
    public void mo5170b(RecyclerView recyclerView, int i, int i2) {
        this.f2613O.mo5188b();
        this.f2613O.mo5186a();
    }

    /* renamed from: b */
    public int mo5167b(int i, RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        m3591O();
        m3590N();
        return super.mo5167b(i, vVar, zVar);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        mo5180j(i);
    }

    /* renamed from: c */
    public int mo5172c(RecyclerView.C1070z zVar) {
        if (this.f2615Q) {
            return m3602j(zVar);
        }
        return super.mo5172c(zVar);
    }

    /* renamed from: b */
    private void m3599b(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, LinearLayoutManager.C1030a aVar, int i) {
        boolean z = i == 1;
        int b = m3598b(vVar, zVar, aVar.f2642b);
        if (z) {
            while (b > 0) {
                int i2 = aVar.f2642b;
                if (i2 > 0) {
                    int i3 = i2 - 1;
                    aVar.f2642b = i3;
                    b = m3598b(vVar, zVar, i3);
                } else {
                    return;
                }
            }
            return;
        }
        int a = zVar.mo5697a() - 1;
        int i4 = aVar.f2642b;
        while (i4 < a) {
            int i5 = i4 + 1;
            int b2 = m3598b(vVar, zVar, i5);
            if (b2 <= b) {
                break;
            }
            i4 = i5;
            b = b2;
        }
        aVar.f2642b = i4;
    }

    /* renamed from: a */
    public void mo5163a(RecyclerView recyclerView, int i, int i2) {
        this.f2613O.mo5188b();
        this.f2613O.mo5186a();
    }

    /* renamed from: a */
    public void mo5165a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f2613O.mo5188b();
        this.f2613O.mo5186a();
    }

    /* renamed from: a */
    public void mo5164a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f2613O.mo5188b();
        this.f2613O.mo5186a();
    }

    /* renamed from: b */
    private int m3598b(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, int i) {
        if (!zVar.mo5702d()) {
            return this.f2613O.mo5187b(i, this.f2608J);
        }
        int i2 = this.f2612N.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int a = vVar.mo5656a(i);
        if (a != -1) {
            return this.f2613O.mo5187b(a, this.f2608J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    /* renamed from: a */
    public RecyclerView.C1059p mo5156a(Context context, AttributeSet attributeSet) {
        return new C1027b(context, attributeSet);
    }

    /* renamed from: a */
    public RecyclerView.C1059p mo5157a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C1027b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C1027b(layoutParams);
    }

    /* renamed from: a */
    public boolean mo5166a(RecyclerView.C1059p pVar) {
        return pVar instanceof C1027b;
    }

    /* renamed from: a */
    public void mo5158a(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.f2609K == null) {
            super.mo5158a(rect, i, i2);
        }
        int n = mo5614n() + mo5616o();
        int p = mo5618p() + mo5612m();
        if (this.f2630s == 1) {
            i4 = RecyclerView.C1054o.m3943a(i2, rect.height() + p, mo5608k());
            int[] iArr = this.f2609K;
            i3 = RecyclerView.C1054o.m3943a(i, iArr[iArr.length - 1] + n, mo5610l());
        } else {
            i3 = RecyclerView.C1054o.m3943a(i, rect.width() + n, mo5610l());
            int[] iArr2 = this.f2609K;
            i4 = RecyclerView.C1054o.m3943a(i2, iArr2[iArr2.length - 1] + p, mo5608k());
        }
        mo5580c(i3, i4);
    }

    /* renamed from: b */
    public int mo5169b(RecyclerView.C1070z zVar) {
        if (this.f2615Q) {
            return m3601i(zVar);
        }
        return super.mo5169b(zVar);
    }

    /* renamed from: a */
    static int[] m3597a(int[] iArr, int i, int i2) {
        int i3;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5160a(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, LinearLayoutManager.C1030a aVar, int i) {
        super.mo5160a(vVar, zVar, aVar, i);
        m3591O();
        if (zVar.mo5697a() > 0 && !zVar.mo5702d()) {
            m3599b(vVar, zVar, aVar, i);
        }
        m3590N();
    }

    /* renamed from: a */
    public int mo5152a(int i, RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        m3591O();
        m3590N();
        return super.mo5152a(i, vVar, zVar);
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
            if (l >= 0 && l < i3 && m3598b(vVar, zVar, l) == 0) {
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

    /* renamed from: a */
    private int m3592a(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, int i) {
        if (!zVar.mo5702d()) {
            return this.f2613O.mo5185a(i, this.f2608J);
        }
        int a = vVar.mo5656a(i);
        if (a != -1) {
            return this.f2613O.mo5185a(a, this.f2608J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5162a(RecyclerView.C1070z zVar, LinearLayoutManager.C1032c cVar, RecyclerView.C1054o.C1057c cVar2) {
        int i = this.f2608J;
        for (int i2 = 0; i2 < this.f2608J && cVar.mo5239a(zVar) && i > 0; i2++) {
            int i3 = cVar.f2653d;
            cVar2.mo5632a(i3, Math.max(0, cVar.f2656g));
            i -= this.f2613O.mo5181a(i3);
            cVar.f2653d += cVar.f2654e;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x021b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0219  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo5161a(androidx.recyclerview.widget.RecyclerView.C1066v r18, androidx.recyclerview.widget.RecyclerView.C1070z r19, androidx.recyclerview.widget.LinearLayoutManager.C1032c r20, androidx.recyclerview.widget.LinearLayoutManager.C1031b r21) {
        /*
            r17 = this;
            r6 = r17
            r0 = r18
            r1 = r19
            r2 = r20
            r7 = r21
            androidx.recyclerview.widget.h r3 = r6.f2632u
            int r3 = r3.mo5888e()
            r4 = 1073741824(0x40000000, float:2.0)
            r8 = 1
            r5 = 0
            if (r3 == r4) goto L_0x0018
            r9 = 1
            goto L_0x0019
        L_0x0018:
            r9 = 0
        L_0x0019:
            int r10 = r17.mo5591e()
            if (r10 <= 0) goto L_0x0026
            int[] r10 = r6.f2609K
            int r11 = r6.f2608J
            r10 = r10[r11]
            goto L_0x0027
        L_0x0026:
            r10 = 0
        L_0x0027:
            if (r9 == 0) goto L_0x002c
            r17.m3591O()
        L_0x002c:
            int r11 = r2.f2654e
            if (r11 != r8) goto L_0x0032
            r11 = 1
            goto L_0x0033
        L_0x0032:
            r11 = 0
        L_0x0033:
            int r12 = r6.f2608J
            if (r11 != 0) goto L_0x0044
            int r12 = r2.f2653d
            int r12 = r6.m3598b((androidx.recyclerview.widget.RecyclerView.C1066v) r0, (androidx.recyclerview.widget.RecyclerView.C1070z) r1, (int) r12)
            int r13 = r2.f2653d
            int r13 = r6.m3600c(r0, r1, r13)
            int r12 = r12 + r13
        L_0x0044:
            r13 = 0
        L_0x0045:
            int r14 = r6.f2608J
            if (r13 >= r14) goto L_0x009d
            boolean r14 = r2.mo5239a((androidx.recyclerview.widget.RecyclerView.C1070z) r1)
            if (r14 == 0) goto L_0x009d
            if (r12 <= 0) goto L_0x009d
            int r14 = r2.f2653d
            int r15 = r6.m3600c(r0, r1, r14)
            int r4 = r6.f2608J
            if (r15 > r4) goto L_0x006f
            int r12 = r12 - r15
            if (r12 >= 0) goto L_0x005f
            goto L_0x009d
        L_0x005f:
            android.view.View r4 = r2.mo5236a((androidx.recyclerview.widget.RecyclerView.C1066v) r0)
            if (r4 != 0) goto L_0x0066
            goto L_0x009d
        L_0x0066:
            android.view.View[] r14 = r6.f2610L
            r14[r13] = r4
            int r13 = r13 + 1
            r4 = 1073741824(0x40000000, float:2.0)
            goto L_0x0045
        L_0x006f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Item at position "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r2 = " requires "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r2 = " spans but GridLayoutManager has only "
            r1.append(r2)
            int r2 = r6.f2608J
            r1.append(r2)
            java.lang.String r2 = " spans."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x009d:
            if (r13 != 0) goto L_0x00a2
            r7.f2647b = r8
            return
        L_0x00a2:
            r4 = 0
            r6.m3596a((androidx.recyclerview.widget.RecyclerView.C1066v) r0, (androidx.recyclerview.widget.RecyclerView.C1070z) r1, (int) r13, (boolean) r11)
            r0 = 0
            r1 = 0
        L_0x00a8:
            if (r0 >= r13) goto L_0x00f4
            android.view.View[] r12 = r6.f2610L
            r12 = r12[r0]
            java.util.List<androidx.recyclerview.widget.RecyclerView$c0> r14 = r2.f2661l
            if (r14 != 0) goto L_0x00bc
            if (r11 == 0) goto L_0x00b8
            r6.mo5571b((android.view.View) r12)
            goto L_0x00c5
        L_0x00b8:
            r6.mo5572b((android.view.View) r12, (int) r5)
            goto L_0x00c5
        L_0x00bc:
            if (r11 == 0) goto L_0x00c2
            r6.mo5541a((android.view.View) r12)
            goto L_0x00c5
        L_0x00c2:
            r6.mo5542a((android.view.View) r12, (int) r5)
        L_0x00c5:
            android.graphics.Rect r14 = r6.f2614P
            r6.mo5546a((android.view.View) r12, (android.graphics.Rect) r14)
            r6.m3595a((android.view.View) r12, (int) r3, (boolean) r5)
            androidx.recyclerview.widget.h r14 = r6.f2632u
            int r14 = r14.mo5883b((android.view.View) r12)
            if (r14 <= r1) goto L_0x00d6
            r1 = r14
        L_0x00d6:
            android.view.ViewGroup$LayoutParams r14 = r12.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r14 = (androidx.recyclerview.widget.GridLayoutManager.C1027b) r14
            r15 = 1065353216(0x3f800000, float:1.0)
            androidx.recyclerview.widget.h r5 = r6.f2632u
            int r5 = r5.mo5885c(r12)
            float r5 = (float) r5
            float r5 = r5 * r15
            int r12 = r14.f2617f
            float r12 = (float) r12
            float r5 = r5 / r12
            int r12 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x00f0
            r4 = r5
        L_0x00f0:
            int r0 = r0 + 1
            r5 = 0
            goto L_0x00a8
        L_0x00f4:
            if (r9 == 0) goto L_0x0112
            r6.m3593a((float) r4, (int) r10)
            r0 = 0
            r1 = 0
        L_0x00fb:
            if (r0 >= r13) goto L_0x0112
            android.view.View[] r3 = r6.f2610L
            r3 = r3[r0]
            r4 = 1073741824(0x40000000, float:2.0)
            r6.m3595a((android.view.View) r3, (int) r4, (boolean) r8)
            androidx.recyclerview.widget.h r4 = r6.f2632u
            int r3 = r4.mo5883b((android.view.View) r3)
            if (r3 <= r1) goto L_0x010f
            r1 = r3
        L_0x010f:
            int r0 = r0 + 1
            goto L_0x00fb
        L_0x0112:
            r0 = 0
        L_0x0113:
            if (r0 >= r13) goto L_0x0175
            android.view.View[] r3 = r6.f2610L
            r3 = r3[r0]
            androidx.recyclerview.widget.h r4 = r6.f2632u
            int r4 = r4.mo5883b((android.view.View) r3)
            if (r4 == r1) goto L_0x016f
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r4 = (androidx.recyclerview.widget.GridLayoutManager.C1027b) r4
            android.graphics.Rect r5 = r4.f2792b
            int r9 = r5.top
            int r10 = r5.bottom
            int r9 = r9 + r10
            int r10 = r4.topMargin
            int r9 = r9 + r10
            int r10 = r4.bottomMargin
            int r9 = r9 + r10
            int r10 = r5.left
            int r5 = r5.right
            int r10 = r10 + r5
            int r5 = r4.leftMargin
            int r10 = r10 + r5
            int r5 = r4.rightMargin
            int r10 = r10 + r5
            int r5 = r4.f2616e
            int r11 = r4.f2617f
            int r5 = r6.mo5177f(r5, r11)
            int r11 = r6.f2630s
            if (r11 != r8) goto L_0x015b
            int r4 = r4.width
            r11 = 1073741824(0x40000000, float:2.0)
            r12 = 0
            int r4 = androidx.recyclerview.widget.RecyclerView.C1054o.m3944a((int) r5, (int) r11, (int) r10, (int) r4, (boolean) r12)
            int r5 = r1 - r9
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r11)
            goto L_0x016b
        L_0x015b:
            r11 = 1073741824(0x40000000, float:2.0)
            r12 = 0
            int r10 = r1 - r10
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r11)
            int r4 = r4.height
            int r5 = androidx.recyclerview.widget.RecyclerView.C1054o.m3944a((int) r5, (int) r11, (int) r9, (int) r4, (boolean) r12)
            r4 = r10
        L_0x016b:
            r6.m3594a((android.view.View) r3, (int) r4, (int) r5, (boolean) r8)
            goto L_0x0172
        L_0x016f:
            r11 = 1073741824(0x40000000, float:2.0)
            r12 = 0
        L_0x0172:
            int r0 = r0 + 1
            goto L_0x0113
        L_0x0175:
            r12 = 0
            r7.f2646a = r1
            int r0 = r6.f2630s
            r3 = -1
            if (r0 != r8) goto L_0x018f
            int r0 = r2.f2655f
            if (r0 != r3) goto L_0x0187
            int r0 = r2.f2651b
            int r1 = r0 - r1
            r2 = r1
            goto L_0x018c
        L_0x0187:
            int r0 = r2.f2651b
            int r1 = r1 + r0
            r2 = r0
            r0 = r1
        L_0x018c:
            r1 = 0
            r3 = 0
            goto L_0x01a2
        L_0x018f:
            int r0 = r2.f2655f
            if (r0 != r3) goto L_0x019c
            int r0 = r2.f2651b
            int r1 = r0 - r1
            r3 = r1
            r2 = 0
            r1 = r0
            r0 = 0
            goto L_0x01a2
        L_0x019c:
            int r0 = r2.f2651b
            int r1 = r1 + r0
            r3 = r0
            r0 = 0
            r2 = 0
        L_0x01a2:
            if (r12 >= r13) goto L_0x022d
            android.view.View[] r4 = r6.f2610L
            r9 = r4[r12]
            android.view.ViewGroup$LayoutParams r4 = r9.getLayoutParams()
            r10 = r4
            androidx.recyclerview.widget.GridLayoutManager$b r10 = (androidx.recyclerview.widget.GridLayoutManager.C1027b) r10
            int r4 = r6.f2630s
            if (r4 != r8) goto L_0x01eb
            boolean r1 = r17.mo5196I()
            if (r1 == 0) goto L_0x01d3
            int r1 = r17.mo5614n()
            int[] r3 = r6.f2609K
            int r4 = r6.f2608J
            int r5 = r10.f2616e
            int r4 = r4 - r5
            r3 = r3[r4]
            int r1 = r1 + r3
            androidx.recyclerview.widget.h r3 = r6.f2632u
            int r3 = r3.mo5885c(r9)
            int r3 = r1 - r3
            r11 = r0
            r14 = r1
            r15 = r2
            goto L_0x0200
        L_0x01d3:
            int r1 = r17.mo5614n()
            int[] r3 = r6.f2609K
            int r4 = r10.f2616e
            r3 = r3[r4]
            int r1 = r1 + r3
            androidx.recyclerview.widget.h r3 = r6.f2632u
            int r3 = r3.mo5885c(r9)
            int r3 = r3 + r1
            r11 = r0
            r16 = r1
            r15 = r2
            r14 = r3
            goto L_0x0202
        L_0x01eb:
            int r0 = r17.mo5618p()
            int[] r2 = r6.f2609K
            int r4 = r10.f2616e
            r2 = r2[r4]
            int r0 = r0 + r2
            androidx.recyclerview.widget.h r2 = r6.f2632u
            int r2 = r2.mo5885c(r9)
            int r2 = r2 + r0
            r15 = r0
            r14 = r1
            r11 = r2
        L_0x0200:
            r16 = r3
        L_0x0202:
            r0 = r17
            r1 = r9
            r2 = r16
            r3 = r15
            r4 = r14
            r5 = r11
            r0.mo5544a((android.view.View) r1, (int) r2, (int) r3, (int) r4, (int) r5)
            boolean r0 = r10.mo5635c()
            if (r0 != 0) goto L_0x0219
            boolean r0 = r10.mo5634b()
            if (r0 == 0) goto L_0x021b
        L_0x0219:
            r7.f2648c = r8
        L_0x021b:
            boolean r0 = r7.f2649d
            boolean r1 = r9.hasFocusable()
            r0 = r0 | r1
            r7.f2649d = r0
            int r12 = r12 + 1
            r0 = r11
            r1 = r14
            r2 = r15
            r3 = r16
            goto L_0x01a2
        L_0x022d:
            android.view.View[] r0 = r6.f2610L
            r1 = 0
            java.util.Arrays.fill(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.mo5161a(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    /* renamed from: a */
    private void m3595a(View view, int i, boolean z) {
        int i2;
        int i3;
        C1027b bVar = (C1027b) view.getLayoutParams();
        Rect rect = bVar.f2792b;
        int i4 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i5 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int f = mo5177f(bVar.f2616e, bVar.f2617f);
        if (this.f2630s == 1) {
            i2 = RecyclerView.C1054o.m3944a(f, i, i5, bVar.width, false);
            i3 = RecyclerView.C1054o.m3944a(this.f2632u.mo5892g(), mo5604i(), i4, bVar.height, true);
        } else {
            int a = RecyclerView.C1054o.m3944a(f, i, i4, bVar.height, false);
            int a2 = RecyclerView.C1054o.m3944a(this.f2632u.mo5892g(), mo5620r(), i5, bVar.width, true);
            i3 = a;
            i2 = a2;
        }
        m3594a(view, i2, i3, z);
    }

    /* renamed from: a */
    private void m3593a(float f, int i) {
        m3603k(Math.max(Math.round(f * ((float) this.f2608J)), i));
    }

    /* renamed from: a */
    private void m3594a(View view, int i, int i2, boolean z) {
        boolean z2;
        RecyclerView.C1059p pVar = (RecyclerView.C1059p) view.getLayoutParams();
        if (z) {
            z2 = mo5576b(view, i, i2, pVar);
        } else {
            z2 = mo5559a(view, i, i2, pVar);
        }
        if (z2) {
            view.measure(i, i2);
        }
    }

    /* renamed from: a */
    private void m3596a(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, int i, boolean z) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = -1;
        if (z) {
            i5 = i;
            i3 = 0;
            i2 = 1;
        } else {
            i3 = i - 1;
            i2 = -1;
        }
        while (i3 != i5) {
            View view = this.f2610L[i3];
            C1027b bVar = (C1027b) view.getLayoutParams();
            int c = m3600c(vVar, zVar, mo5611l(view));
            bVar.f2617f = c;
            bVar.f2616e = i4;
            i4 += c;
            i3 += i2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d6, code lost:
        if (r13 == (r2 > r15)) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f6, code lost:
        if (r13 == r11) goto L_0x00b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0107  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View mo5154a(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.C1066v r26, androidx.recyclerview.widget.RecyclerView.C1070z r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            android.view.View r3 = r23.mo5579c((android.view.View) r24)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r5 = (androidx.recyclerview.widget.GridLayoutManager.C1027b) r5
            int r6 = r5.f2616e
            int r5 = r5.f2617f
            int r5 = r5 + r6
            android.view.View r7 = super.mo5154a((android.view.View) r24, (int) r25, (androidx.recyclerview.widget.RecyclerView.C1066v) r26, (androidx.recyclerview.widget.RecyclerView.C1070z) r27)
            if (r7 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r7 = r25
            int r7 = r0.mo5218h((int) r7)
            r9 = 1
            if (r7 != r9) goto L_0x002b
            r7 = 1
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            boolean r10 = r0.f2635x
            if (r7 == r10) goto L_0x0032
            r7 = 1
            goto L_0x0033
        L_0x0032:
            r7 = 0
        L_0x0033:
            r10 = -1
            if (r7 == 0) goto L_0x003e
            int r7 = r23.mo5591e()
            int r7 = r7 - r9
            r11 = -1
            r12 = -1
            goto L_0x0045
        L_0x003e:
            int r7 = r23.mo5591e()
            r11 = r7
            r7 = 0
            r12 = 1
        L_0x0045:
            int r13 = r0.f2630s
            if (r13 != r9) goto L_0x0051
            boolean r13 = r23.mo5196I()
            if (r13 == 0) goto L_0x0051
            r13 = 1
            goto L_0x0052
        L_0x0051:
            r13 = 0
        L_0x0052:
            int r14 = r0.m3592a((androidx.recyclerview.widget.RecyclerView.C1066v) r1, (androidx.recyclerview.widget.RecyclerView.C1070z) r2, (int) r7)
            r10 = r7
            r8 = 0
            r15 = -1
            r16 = -1
            r17 = 0
            r7 = r4
        L_0x005e:
            if (r10 == r11) goto L_0x0149
            int r9 = r0.m3592a((androidx.recyclerview.widget.RecyclerView.C1066v) r1, (androidx.recyclerview.widget.RecyclerView.C1070z) r2, (int) r10)
            android.view.View r1 = r0.mo5578c((int) r10)
            if (r1 != r3) goto L_0x006c
            goto L_0x0149
        L_0x006c:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0086
            if (r9 == r14) goto L_0x0086
            if (r4 == 0) goto L_0x0078
            goto L_0x0149
        L_0x0078:
            r18 = r3
            r21 = r7
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
            goto L_0x0135
        L_0x0086:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r9 = (androidx.recyclerview.widget.GridLayoutManager.C1027b) r9
            int r2 = r9.f2616e
            r18 = r3
            int r3 = r9.f2617f
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x009e
            if (r2 != r6) goto L_0x009e
            if (r3 != r5) goto L_0x009e
            return r1
        L_0x009e:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00a6
            if (r4 == 0) goto L_0x00ae
        L_0x00a6:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto L_0x00ba
            if (r7 != 0) goto L_0x00ba
        L_0x00ae:
            r21 = r7
        L_0x00b0:
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
        L_0x00b8:
            r11 = 1
            goto L_0x0105
        L_0x00ba:
            int r19 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r5)
            r21 = r7
            int r7 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00d9
            if (r7 <= r8) goto L_0x00cf
        L_0x00ce:
            goto L_0x00b0
        L_0x00cf:
            if (r7 != r8) goto L_0x00fc
            if (r2 <= r15) goto L_0x00d5
            r7 = 1
            goto L_0x00d6
        L_0x00d5:
            r7 = 0
        L_0x00d6:
            if (r13 != r7) goto L_0x00fc
            goto L_0x00ce
        L_0x00d9:
            if (r4 != 0) goto L_0x00fc
            r19 = r8
            r20 = r11
            r8 = 0
            r11 = 1
            boolean r22 = r0.mo5561a((android.view.View) r1, (boolean) r8, (boolean) r11)
            if (r22 == 0) goto L_0x0100
            r8 = r17
            if (r7 <= r8) goto L_0x00ee
            r7 = r16
            goto L_0x0105
        L_0x00ee:
            if (r7 != r8) goto L_0x00f9
            r7 = r16
            if (r2 <= r7) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r11 = 0
        L_0x00f6:
            if (r13 != r11) goto L_0x0104
            goto L_0x00b8
        L_0x00f9:
            r7 = r16
            goto L_0x0104
        L_0x00fc:
            r19 = r8
            r20 = r11
        L_0x0100:
            r7 = r16
            r8 = r17
        L_0x0104:
            r11 = 0
        L_0x0105:
            if (r11 == 0) goto L_0x0135
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x0123
            int r4 = r9.f2616e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r2 = r3 - r2
            r15 = r4
            r16 = r7
            r17 = r8
            r7 = r21
            r4 = r1
            r8 = r2
            goto L_0x013d
        L_0x0123:
            int r7 = r9.f2616e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r17 = r3 - r2
            r16 = r7
            r8 = r19
            r7 = r1
            goto L_0x013d
        L_0x0135:
            r16 = r7
            r17 = r8
            r8 = r19
            r7 = r21
        L_0x013d:
            int r10 = r10 + r12
            r1 = r26
            r2 = r27
            r3 = r18
            r11 = r20
            r9 = 1
            goto L_0x005e
        L_0x0149:
            r21 = r7
            if (r4 == 0) goto L_0x014e
            goto L_0x0150
        L_0x014e:
            r4 = r21
        L_0x0150:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.mo5154a(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z):android.view.View");
    }
}
