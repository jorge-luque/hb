package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.p020f.p021c0.C0807c;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.C1054o {

    /* renamed from: A */
    boolean f2828A = false;

    /* renamed from: B */
    private BitSet f2829B;

    /* renamed from: C */
    int f2830C = -1;

    /* renamed from: D */
    int f2831D = Integer.MIN_VALUE;

    /* renamed from: E */
    LazySpanLookup f2832E = new LazySpanLookup();

    /* renamed from: F */
    private int f2833F = 2;

    /* renamed from: G */
    private boolean f2834G;

    /* renamed from: H */
    private boolean f2835H;

    /* renamed from: I */
    private SavedState f2836I;

    /* renamed from: J */
    private int f2837J;

    /* renamed from: K */
    private final Rect f2838K = new Rect();

    /* renamed from: L */
    private final C1074b f2839L = new C1074b();

    /* renamed from: M */
    private boolean f2840M = false;

    /* renamed from: N */
    private boolean f2841N = true;

    /* renamed from: O */
    private int[] f2842O;

    /* renamed from: P */
    private final Runnable f2843P = new C1073a();

    /* renamed from: s */
    private int f2844s = -1;

    /* renamed from: t */
    C1076d[] f2845t;

    /* renamed from: u */
    C1106h f2846u;

    /* renamed from: v */
    C1106h f2847v;

    /* renamed from: w */
    private int f2848w;

    /* renamed from: x */
    private int f2849x;

    /* renamed from: y */
    private final C1103f f2850y;

    /* renamed from: z */
    boolean f2851z = false;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1072a();

        /* renamed from: a */
        int f2858a;

        /* renamed from: b */
        int f2859b;

        /* renamed from: c */
        int f2860c;

        /* renamed from: d */
        int[] f2861d;

        /* renamed from: e */
        int f2862e;

        /* renamed from: f */
        int[] f2863f;

        /* renamed from: g */
        List<LazySpanLookup.FullSpanItem> f2864g;

        /* renamed from: h */
        boolean f2865h;

        /* renamed from: i */
        boolean f2866i;

        /* renamed from: j */
        boolean f2867j;

        /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState$a */
        static class C1072a implements Parcelable.Creator<SavedState> {
            C1072a() {
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
        public void mo5742a() {
            this.f2861d = null;
            this.f2860c = 0;
            this.f2862e = 0;
            this.f2863f = null;
            this.f2864g = null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2858a);
            parcel.writeInt(this.f2859b);
            parcel.writeInt(this.f2860c);
            if (this.f2860c > 0) {
                parcel.writeIntArray(this.f2861d);
            }
            parcel.writeInt(this.f2862e);
            if (this.f2862e > 0) {
                parcel.writeIntArray(this.f2863f);
            }
            parcel.writeInt(this.f2865h ? 1 : 0);
            parcel.writeInt(this.f2866i ? 1 : 0);
            parcel.writeInt(this.f2867j ? 1 : 0);
            parcel.writeList(this.f2864g);
        }

        SavedState(Parcel parcel) {
            this.f2858a = parcel.readInt();
            this.f2859b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f2860c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f2861d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f2862e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f2863f = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z = false;
            this.f2865h = parcel.readInt() == 1;
            this.f2866i = parcel.readInt() == 1;
            this.f2867j = parcel.readInt() == 1 ? true : z;
            this.f2864g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f2860c = savedState.f2860c;
            this.f2858a = savedState.f2858a;
            this.f2859b = savedState.f2859b;
            this.f2861d = savedState.f2861d;
            this.f2862e = savedState.f2862e;
            this.f2863f = savedState.f2863f;
            this.f2865h = savedState.f2865h;
            this.f2866i = savedState.f2866i;
            this.f2867j = savedState.f2867j;
            this.f2864g = savedState.f2864g;
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$a */
    class C1073a implements Runnable {
        C1073a() {
        }

        public void run() {
            StaggeredGridLayoutManager.this.mo5707F();
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$c */
    public static class C1075c extends RecyclerView.C1059p {

        /* renamed from: e */
        C1076d f2876e;

        /* renamed from: f */
        boolean f2877f;

        public C1075c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* renamed from: e */
        public final int mo5752e() {
            C1076d dVar = this.f2876e;
            if (dVar == null) {
                return -1;
            }
            return dVar.f2882e;
        }

        /* renamed from: f */
        public boolean mo5753f() {
            return this.f2877f;
        }

        public C1075c(int i, int i2) {
            super(i, i2);
        }

        public C1075c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C1075c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d */
    class C1076d {

        /* renamed from: a */
        ArrayList<View> f2878a = new ArrayList<>();

        /* renamed from: b */
        int f2879b = Integer.MIN_VALUE;

        /* renamed from: c */
        int f2880c = Integer.MIN_VALUE;

        /* renamed from: d */
        int f2881d = 0;

        /* renamed from: e */
        final int f2882e;

        C1076d(int i) {
            this.f2882e = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo5754a(int i) {
            int i2 = this.f2880c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f2878a.size() == 0) {
                return i;
            }
            mo5758a();
            return this.f2880c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo5761b(int i) {
            int i2 = this.f2879b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f2878a.size() == 0) {
                return i;
            }
            mo5763b();
            return this.f2879b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5766c(View view) {
            C1075c b = mo5762b(view);
            b.f2876e = this;
            this.f2878a.add(0, view);
            this.f2879b = Integer.MIN_VALUE;
            if (this.f2878a.size() == 1) {
                this.f2880c = Integer.MIN_VALUE;
            }
            if (b.mo5635c() || b.mo5634b()) {
                this.f2881d += StaggeredGridLayoutManager.this.f2846u.mo5883b(view);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo5768d(int i) {
            this.f2879b = i;
            this.f2880c = i;
        }

        /* renamed from: e */
        public int mo5769e() {
            if (StaggeredGridLayoutManager.this.f2851z) {
                return mo5755a(0, this.f2878a.size(), true);
            }
            return mo5755a(this.f2878a.size() - 1, -1, true);
        }

        /* renamed from: f */
        public int mo5770f() {
            return this.f2881d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public int mo5771g() {
            int i = this.f2880c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            mo5758a();
            return this.f2880c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public int mo5772h() {
            int i = this.f2879b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            mo5763b();
            return this.f2879b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public void mo5773i() {
            this.f2879b = Integer.MIN_VALUE;
            this.f2880c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void mo5774j() {
            int size = this.f2878a.size();
            View remove = this.f2878a.remove(size - 1);
            C1075c b = mo5762b(remove);
            b.f2876e = null;
            if (b.mo5635c() || b.mo5634b()) {
                this.f2881d -= StaggeredGridLayoutManager.this.f2846u.mo5883b(remove);
            }
            if (size == 1) {
                this.f2879b = Integer.MIN_VALUE;
            }
            this.f2880c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void mo5775k() {
            View remove = this.f2878a.remove(0);
            C1075c b = mo5762b(remove);
            b.f2876e = null;
            if (this.f2878a.size() == 0) {
                this.f2880c = Integer.MIN_VALUE;
            }
            if (b.mo5635c() || b.mo5634b()) {
                this.f2881d -= StaggeredGridLayoutManager.this.f2846u.mo5883b(remove);
            }
            this.f2879b = Integer.MIN_VALUE;
        }

        /* renamed from: d */
        public int mo5767d() {
            if (StaggeredGridLayoutManager.this.f2851z) {
                return mo5755a(this.f2878a.size() - 1, -1, true);
            }
            return mo5755a(0, this.f2878a.size(), true);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5758a() {
            LazySpanLookup.FullSpanItem c;
            ArrayList<View> arrayList = this.f2878a;
            View view = arrayList.get(arrayList.size() - 1);
            C1075c b = mo5762b(view);
            this.f2880c = StaggeredGridLayoutManager.this.f2846u.mo5880a(view);
            if (b.f2877f && (c = StaggeredGridLayoutManager.this.f2832E.mo5732c(b.mo5633a())) != null && c.f2855b == 1) {
                this.f2880c += c.mo5736a(this.f2882e);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5763b() {
            LazySpanLookup.FullSpanItem c;
            View view = this.f2878a.get(0);
            C1075c b = mo5762b(view);
            this.f2879b = StaggeredGridLayoutManager.this.f2846u.mo5887d(view);
            if (b.f2877f && (c = StaggeredGridLayoutManager.this.f2832E.mo5732c(b.mo5633a())) != null && c.f2855b == -1) {
                this.f2879b -= c.mo5736a(this.f2882e);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5764c() {
            this.f2878a.clear();
            mo5773i();
            this.f2881d = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo5765c(int i) {
            int i2 = this.f2879b;
            if (i2 != Integer.MIN_VALUE) {
                this.f2879b = i2 + i;
            }
            int i3 = this.f2880c;
            if (i3 != Integer.MIN_VALUE) {
                this.f2880c = i3 + i;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5759a(View view) {
            C1075c b = mo5762b(view);
            b.f2876e = this;
            this.f2878a.add(view);
            this.f2880c = Integer.MIN_VALUE;
            if (this.f2878a.size() == 1) {
                this.f2879b = Integer.MIN_VALUE;
            }
            if (b.mo5635c() || b.mo5634b()) {
                this.f2881d += StaggeredGridLayoutManager.this.f2846u.mo5883b(view);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C1075c mo5762b(View view) {
            return (C1075c) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5760a(boolean z, int i) {
            int i2;
            if (z) {
                i2 = mo5754a(Integer.MIN_VALUE);
            } else {
                i2 = mo5761b(Integer.MIN_VALUE);
            }
            mo5764c();
            if (i2 != Integer.MIN_VALUE) {
                if (z && i2 < StaggeredGridLayoutManager.this.f2846u.mo5882b()) {
                    return;
                }
                if (z || i2 <= StaggeredGridLayoutManager.this.f2846u.mo5890f()) {
                    if (i != Integer.MIN_VALUE) {
                        i2 += i;
                    }
                    this.f2880c = i2;
                    this.f2879b = i2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo5756a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int f = StaggeredGridLayoutManager.this.f2846u.mo5890f();
            int b = StaggeredGridLayoutManager.this.f2846u.mo5882b();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f2878a.get(i);
                int d = StaggeredGridLayoutManager.this.f2846u.mo5887d(view);
                int a = StaggeredGridLayoutManager.this.f2846u.mo5880a(view);
                boolean z4 = false;
                boolean z5 = !z3 ? d < b : d <= b;
                if (!z3 ? a > f : a >= f) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.mo5611l(view);
                        }
                        if (d < f || a > b) {
                            return StaggeredGridLayoutManager.this.mo5611l(view);
                        }
                    } else if (d >= f && a <= b) {
                        return StaggeredGridLayoutManager.this.mo5611l(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo5755a(int i, int i2, boolean z) {
            return mo5756a(i, i2, false, false, z);
        }

        /* renamed from: a */
        public View mo5757a(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f2878a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f2878a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f2851z && staggeredGridLayoutManager.mo5611l(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f2851z && staggeredGridLayoutManager2.mo5611l(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f2878a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f2878a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f2851z && staggeredGridLayoutManager3.mo5611l(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f2851z && staggeredGridLayoutManager4.mo5611l(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.C1054o.C1058d a = RecyclerView.C1054o.m3945a(context, attributeSet, i, i2);
        mo5721h(a.f2787a);
        mo5722i(a.f2788b);
        mo5720c(a.f2789c);
        this.f2850y = new C1103f();
        m4171M();
    }

    /* renamed from: M */
    private void m4171M() {
        this.f2846u = C1106h.m4455a(this, this.f2848w);
        this.f2847v = C1106h.m4455a(this, 1 - this.f2848w);
    }

    /* renamed from: N */
    private void m4172N() {
        if (this.f2847v.mo5886d() != 1073741824) {
            float f = 0.0f;
            int e = mo5591e();
            for (int i = 0; i < e; i++) {
                View c = mo5578c(i);
                float b = (float) this.f2847v.mo5883b(c);
                if (b >= f) {
                    if (((C1075c) c.getLayoutParams()).mo5753f()) {
                        b = (b * 1.0f) / ((float) this.f2844s);
                    }
                    f = Math.max(f, b);
                }
            }
            int i2 = this.f2849x;
            int round = Math.round(f * ((float) this.f2844s));
            if (this.f2847v.mo5886d() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f2847v.mo5892g());
            }
            mo5723j(round);
            if (this.f2849x != i2) {
                for (int i3 = 0; i3 < e; i3++) {
                    View c2 = mo5578c(i3);
                    C1075c cVar = (C1075c) c2.getLayoutParams();
                    if (!cVar.f2877f) {
                        if (!mo5713L() || this.f2848w != 1) {
                            int i4 = cVar.f2876e.f2882e;
                            int i5 = this.f2849x * i4;
                            int i6 = i4 * i2;
                            if (this.f2848w == 1) {
                                c2.offsetLeftAndRight(i5 - i6);
                            } else {
                                c2.offsetTopAndBottom(i5 - i6);
                            }
                        } else {
                            int i7 = this.f2844s;
                            int i8 = cVar.f2876e.f2882e;
                            c2.offsetLeftAndRight(((-((i7 - 1) - i8)) * this.f2849x) - ((-((i7 - 1) - i8)) * i2));
                        }
                    }
                }
            }
        }
    }

    /* renamed from: O */
    private void m4173O() {
        if (this.f2848w == 1 || !mo5713L()) {
            this.f2828A = this.f2851z;
        } else {
            this.f2828A = !this.f2851z;
        }
    }

    /* renamed from: a */
    private boolean m4184a(C1076d dVar) {
        if (this.f2828A) {
            if (dVar.mo5771g() < this.f2846u.mo5882b()) {
                ArrayList<View> arrayList = dVar.f2878a;
                return !dVar.mo5762b(arrayList.get(arrayList.size() - 1)).f2877f;
            }
        } else if (dVar.mo5772h() > this.f2846u.mo5890f()) {
            return !dVar.mo5762b(dVar.f2878a.get(0)).f2877f;
        }
        return false;
    }

    /* renamed from: k */
    private int m4196k(int i) {
        if (mo5591e() != 0) {
            if ((i < mo5709H()) != this.f2828A) {
                return -1;
            }
            return 1;
        } else if (this.f2828A) {
            return 1;
        } else {
            return -1;
        }
    }

    /* renamed from: l */
    private int m4197l(int i) {
        if (i == 1) {
            return (this.f2848w != 1 && mo5713L()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.f2848w != 1 && mo5713L()) ? -1 : 1;
        }
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    return (i == 130 && this.f2848w == 1) ? 1 : Integer.MIN_VALUE;
                }
                if (this.f2848w == 0) {
                    return 1;
                }
                return Integer.MIN_VALUE;
            } else if (this.f2848w == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.f2848w == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    /* renamed from: m */
    private LazySpanLookup.FullSpanItem m4198m(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f2856c = new int[this.f2844s];
        for (int i2 = 0; i2 < this.f2844s; i2++) {
            fullSpanItem.f2856c[i2] = i - this.f2845t[i2].mo5754a(i);
        }
        return fullSpanItem;
    }

    /* renamed from: n */
    private LazySpanLookup.FullSpanItem m4199n(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f2856c = new int[this.f2844s];
        for (int i2 = 0; i2 < this.f2844s; i2++) {
            fullSpanItem.f2856c[i2] = this.f2845t[i2].mo5761b(i) - i;
        }
        return fullSpanItem;
    }

    /* renamed from: o */
    private int m4200o(int i) {
        int e = mo5591e();
        for (int i2 = 0; i2 < e; i2++) {
            int l = mo5611l(mo5578c(i2));
            if (l >= 0 && l < i) {
                return l;
            }
        }
        return 0;
    }

    /* renamed from: p */
    private void m4202p(View view) {
        for (int i = this.f2844s - 1; i >= 0; i--) {
            this.f2845t[i].mo5759a(view);
        }
    }

    /* renamed from: q */
    private void m4204q(View view) {
        for (int i = this.f2844s - 1; i >= 0; i--) {
            this.f2845t[i].mo5766c(view);
        }
    }

    /* renamed from: r */
    private int m4205r(int i) {
        int b = this.f2845t[0].mo5761b(i);
        for (int i2 = 1; i2 < this.f2844s; i2++) {
            int b2 = this.f2845t[i2].mo5761b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    /* renamed from: s */
    private int m4206s(int i) {
        int a = this.f2845t[0].mo5754a(i);
        for (int i2 = 1; i2 < this.f2844s; i2++) {
            int a2 = this.f2845t[i2].mo5754a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    /* renamed from: t */
    private int m4207t(int i) {
        int b = this.f2845t[0].mo5761b(i);
        for (int i2 = 1; i2 < this.f2844s; i2++) {
            int b2 = this.f2845t[i2].mo5761b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    /* renamed from: v */
    private void m4209v(int i) {
        C1103f fVar = this.f2850y;
        fVar.f3007e = i;
        int i2 = 1;
        if (this.f2828A != (i == -1)) {
            i2 = -1;
        }
        fVar.f3006d = i2;
    }

    /* renamed from: C */
    public boolean mo5151C() {
        return this.f2836I == null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public boolean mo5705D() {
        int a = this.f2845t[0].mo5754a(Integer.MIN_VALUE);
        for (int i = 1; i < this.f2844s; i++) {
            if (this.f2845t[i].mo5754a(Integer.MIN_VALUE) != a) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public boolean mo5706E() {
        int b = this.f2845t[0].mo5761b(Integer.MIN_VALUE);
        for (int i = 1; i < this.f2844s; i++) {
            if (this.f2845t[i].mo5761b(Integer.MIN_VALUE) != b) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F */
    public boolean mo5707F() {
        int i;
        int i2;
        if (mo5591e() == 0 || this.f2833F == 0 || !mo5622t()) {
            return false;
        }
        if (this.f2828A) {
            i2 = mo5710I();
            i = mo5709H();
        } else {
            i2 = mo5709H();
            i = mo5710I();
        }
        if (i2 == 0 && mo5711J() != null) {
            this.f2832E.mo5725a();
            mo5626z();
            mo5625y();
            return true;
        } else if (!this.f2840M) {
            return false;
        } else {
            int i3 = this.f2828A ? -1 : 1;
            int i4 = i + 1;
            LazySpanLookup.FullSpanItem a = this.f2832E.mo5724a(i2, i4, i3, true);
            if (a == null) {
                this.f2840M = false;
                this.f2832E.mo5730b(i4);
                return false;
            }
            LazySpanLookup.FullSpanItem a2 = this.f2832E.mo5724a(i2, a.f2854a, i3 * -1, true);
            if (a2 == null) {
                this.f2832E.mo5730b(a.f2854a);
            } else {
                this.f2832E.mo5730b(a2.f2854a + 1);
            }
            mo5626z();
            mo5625y();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: G */
    public int mo5708G() {
        View view;
        if (this.f2828A) {
            view = mo5714a(true);
        } else {
            view = mo5717b(true);
        }
        if (view == null) {
            return -1;
        }
        return mo5611l(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public int mo5709H() {
        if (mo5591e() == 0) {
            return 0;
        }
        return mo5611l(mo5578c(0));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public int mo5710I() {
        int e = mo5591e();
        if (e == 0) {
            return 0;
        }
        return mo5611l(mo5578c(e - 1));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* renamed from: J */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View mo5711J() {
        /*
            r12 = this;
            int r0 = r12.mo5591e()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f2844s
            r2.<init>(r3)
            int r3 = r12.f2844s
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f2848w
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.mo5713L()
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            boolean r6 = r12.f2828A
            if (r6 == 0) goto L_0x0027
            r6 = -1
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = 1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.mo5578c((int) r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.C1075c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r8.f2876e
            int r9 = r9.f2882e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r8.f2876e
            boolean r9 = r12.m4184a((androidx.recyclerview.widget.StaggeredGridLayoutManager.C1076d) r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r8.f2876e
            int r9 = r9.f2882e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f2877f
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.mo5578c((int) r9)
            boolean r10 = r12.f2828A
            if (r10 == 0) goto L_0x0077
            androidx.recyclerview.widget.h r10 = r12.f2846u
            int r10 = r10.mo5880a((android.view.View) r7)
            androidx.recyclerview.widget.h r11 = r12.f2846u
            int r11 = r11.mo5880a((android.view.View) r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            androidx.recyclerview.widget.h r10 = r12.f2846u
            int r10 = r10.mo5887d(r7)
            androidx.recyclerview.widget.h r11 = r12.f2846u
            int r11 = r11.mo5887d(r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = 1
            goto L_0x008b
        L_0x008a:
            r10 = 0
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.C1075c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r8 = r8.f2876e
            int r8 = r8.f2882e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r9.f2876e
            int r9 = r9.f2882e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = 1
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = 1
            goto L_0x00a6
        L_0x00a5:
            r9 = 0
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.mo5711J():android.view.View");
    }

    /* renamed from: K */
    public void mo5712K() {
        this.f2832E.mo5725a();
        mo5625y();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: L */
    public boolean mo5713L() {
        return mo5606j() == 1;
    }

    /* renamed from: b */
    public void mo5213b(RecyclerView recyclerView, RecyclerView.C1066v vVar) {
        super.mo5213b(recyclerView, vVar);
        mo5569a(this.f2843P);
        for (int i = 0; i < this.f2844s; i++) {
            this.f2845t[i].mo5764c();
        }
        recyclerView.requestLayout();
    }

    /* renamed from: c */
    public void mo5720c(boolean z) {
        mo5208a((String) null);
        SavedState savedState = this.f2836I;
        if (!(savedState == null || savedState.f2865h == z)) {
            savedState.f2865h = z;
        }
        this.f2851z = z;
        mo5625y();
    }

    /* renamed from: d */
    public int mo5216d(RecyclerView.C1070z zVar) {
        return m4193h(zVar);
    }

    /* renamed from: e */
    public void mo5176e(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        m4190c(vVar, zVar, true);
    }

    /* renamed from: f */
    public void mo5596f(int i) {
        if (i == 0) {
            mo5707F();
        }
    }

    /* renamed from: g */
    public void mo5179g(RecyclerView.C1070z zVar) {
        super.mo5179g(zVar);
        this.f2830C = -1;
        this.f2831D = Integer.MIN_VALUE;
        this.f2836I = null;
        this.f2839L.mo5751b();
    }

    /* renamed from: h */
    public void mo5721h(int i) {
        if (i == 0 || i == 1) {
            mo5208a((String) null);
            if (i != this.f2848w) {
                this.f2848w = i;
                C1106h hVar = this.f2846u;
                this.f2846u = this.f2847v;
                this.f2847v = hVar;
                mo5625y();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    /* renamed from: i */
    public void mo5722i(int i) {
        mo5208a((String) null);
        if (i != this.f2844s) {
            mo5712K();
            this.f2844s = i;
            this.f2829B = new BitSet(this.f2844s);
            this.f2845t = new C1076d[this.f2844s];
            for (int i2 = 0; i2 < this.f2844s; i2++) {
                this.f2845t[i2] = new C1076d(i2);
            }
            mo5625y();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo5723j(int i) {
        this.f2849x = i / this.f2844s;
        this.f2837J = View.MeasureSpec.makeMeasureSpec(i, this.f2847v.mo5886d());
    }

    /* renamed from: u */
    public boolean mo5221u() {
        return this.f2833F != 0;
    }

    /* renamed from: x */
    public Parcelable mo5222x() {
        int i;
        int i2;
        int i3;
        int[] iArr;
        if (this.f2836I != null) {
            return new SavedState(this.f2836I);
        }
        SavedState savedState = new SavedState();
        savedState.f2865h = this.f2851z;
        savedState.f2866i = this.f2834G;
        savedState.f2867j = this.f2835H;
        LazySpanLookup lazySpanLookup = this.f2832E;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f2852a) == null) {
            savedState.f2862e = 0;
        } else {
            savedState.f2863f = iArr;
            savedState.f2862e = iArr.length;
            savedState.f2864g = lazySpanLookup.f2853b;
        }
        if (mo5591e() > 0) {
            if (this.f2834G) {
                i = mo5710I();
            } else {
                i = mo5709H();
            }
            savedState.f2858a = i;
            savedState.f2859b = mo5708G();
            int i4 = this.f2844s;
            savedState.f2860c = i4;
            savedState.f2861d = new int[i4];
            for (int i5 = 0; i5 < this.f2844s; i5++) {
                if (this.f2834G) {
                    i2 = this.f2845t[i5].mo5754a(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.f2846u.mo5882b();
                    } else {
                        savedState.f2861d[i5] = i2;
                    }
                } else {
                    i2 = this.f2845t[i5].mo5761b(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.f2846u.mo5890f();
                    } else {
                        savedState.f2861d[i5] = i2;
                    }
                }
                i2 -= i3;
                savedState.f2861d[i5] = i2;
            }
        } else {
            savedState.f2858a = -1;
            savedState.f2859b = -1;
            savedState.f2860c = 0;
        }
        return savedState;
    }

    static class LazySpanLookup {

        /* renamed from: a */
        int[] f2852a;

        /* renamed from: b */
        List<FullSpanItem> f2853b;

        LazySpanLookup() {
        }

        /* renamed from: c */
        private void m4266c(int i, int i2) {
            List<FullSpanItem> list = this.f2853b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f2853b.get(size);
                    int i3 = fullSpanItem.f2854a;
                    if (i3 >= i) {
                        fullSpanItem.f2854a = i3 + i2;
                    }
                }
            }
        }

        /* renamed from: g */
        private int m4268g(int i) {
            if (this.f2853b == null) {
                return -1;
            }
            FullSpanItem c = mo5732c(i);
            if (c != null) {
                this.f2853b.remove(c);
            }
            int size = this.f2853b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.f2853b.get(i2).f2854a >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return -1;
            }
            this.f2853b.remove(i2);
            return this.f2853b.get(i2).f2854a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5728a(int i, C1076d dVar) {
            mo5726a(i);
            this.f2852a[i] = dVar.f2882e;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo5730b(int i) {
            List<FullSpanItem> list = this.f2853b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f2853b.get(size).f2854a >= i) {
                        this.f2853b.remove(size);
                    }
                }
            }
            return mo5734e(i);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public int mo5733d(int i) {
            int[] iArr = this.f2852a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public int mo5734e(int i) {
            int[] iArr = this.f2852a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int g = m4268g(i);
            if (g == -1) {
                int[] iArr2 = this.f2852a;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.f2852a.length;
            }
            int i2 = g + 1;
            Arrays.fill(this.f2852a, i, i2, -1);
            return i2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public int mo5735f(int i) {
            int length = this.f2852a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* renamed from: d */
        private void m4267d(int i, int i2) {
            List<FullSpanItem> list = this.f2853b;
            if (list != null) {
                int i3 = i + i2;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f2853b.get(size);
                    int i4 = fullSpanItem.f2854a;
                    if (i4 >= i) {
                        if (i4 < i3) {
                            this.f2853b.remove(size);
                        } else {
                            fullSpanItem.f2854a = i4 - i2;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5726a(int i) {
            int[] iArr = this.f2852a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i, 10) + 1)];
                this.f2852a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[mo5735f(i)];
                this.f2852a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f2852a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        /* renamed from: c */
        public FullSpanItem mo5732c(int i) {
            List<FullSpanItem> list = this.f2853b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f2853b.get(size);
                if (fullSpanItem.f2854a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        @SuppressLint({"BanParcelableUsage"})
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new C1071a();

            /* renamed from: a */
            int f2854a;

            /* renamed from: b */
            int f2855b;

            /* renamed from: c */
            int[] f2856c;

            /* renamed from: d */
            boolean f2857d;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$a */
            static class C1071a implements Parcelable.Creator<FullSpanItem> {
                C1071a() {
                }

                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            }

            FullSpanItem(Parcel parcel) {
                this.f2854a = parcel.readInt();
                this.f2855b = parcel.readInt();
                this.f2857d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f2856c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public int mo5736a(int i) {
                int[] iArr = this.f2856c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f2854a + ", mGapDir=" + this.f2855b + ", mHasUnwantedGapAfter=" + this.f2857d + ", mGapPerSpan=" + Arrays.toString(this.f2856c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f2854a);
                parcel.writeInt(this.f2855b);
                parcel.writeInt(this.f2857d ? 1 : 0);
                int[] iArr = this.f2856c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f2856c);
            }

            FullSpanItem() {
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5731b(int i, int i2) {
            int[] iArr = this.f2852a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                mo5726a(i3);
                int[] iArr2 = this.f2852a;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.f2852a;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
                m4267d(i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5725a() {
            int[] iArr = this.f2852a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2853b = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5727a(int i, int i2) {
            int[] iArr = this.f2852a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                mo5726a(i3);
                int[] iArr2 = this.f2852a;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.f2852a, i, i3, -1);
                m4266c(i, i2);
            }
        }

        /* renamed from: a */
        public void mo5729a(FullSpanItem fullSpanItem) {
            if (this.f2853b == null) {
                this.f2853b = new ArrayList();
            }
            int size = this.f2853b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.f2853b.get(i);
                if (fullSpanItem2.f2854a == fullSpanItem.f2854a) {
                    this.f2853b.remove(i);
                }
                if (fullSpanItem2.f2854a >= fullSpanItem.f2854a) {
                    this.f2853b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f2853b.add(fullSpanItem);
        }

        /* renamed from: a */
        public FullSpanItem mo5724a(int i, int i2, int i3, boolean z) {
            List<FullSpanItem> list = this.f2853b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.f2853b.get(i4);
                int i5 = fullSpanItem.f2854a;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || fullSpanItem.f2855b == i3 || (z && fullSpanItem.f2857d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    /* renamed from: u */
    private boolean m4208u(int i) {
        if (this.f2848w == 0) {
            if ((i == -1) != this.f2828A) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.f2828A) == mo5713L()) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public void mo5588d(int i) {
        super.mo5588d(i);
        for (int i2 = 0; i2 < this.f2844s; i2++) {
            this.f2845t[i2].mo5765c(i);
        }
    }

    /* renamed from: e */
    public int mo5175e(RecyclerView.C1070z zVar) {
        return m4194i(zVar);
    }

    /* renamed from: f */
    public int mo5178f(RecyclerView.C1070z zVar) {
        return m4195j(zVar);
    }

    /* renamed from: p */
    private int m4201p(int i) {
        for (int e = mo5591e() - 1; e >= 0; e--) {
            int l = mo5611l(mo5578c(e));
            if (l >= 0 && l < i) {
                return l;
            }
        }
        return 0;
    }

    /* renamed from: q */
    private int m4203q(int i) {
        int a = this.f2845t[0].mo5754a(i);
        for (int i2 = 1; i2 < this.f2844s; i2++) {
            int a2 = this.f2845t[i2].mo5754a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    /* renamed from: e */
    public void mo5593e(int i) {
        super.mo5593e(i);
        for (int i2 = 0; i2 < this.f2844s; i2++) {
            this.f2845t[i2].mo5765c(i);
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$b */
    class C1074b {

        /* renamed from: a */
        int f2869a;

        /* renamed from: b */
        int f2870b;

        /* renamed from: c */
        boolean f2871c;

        /* renamed from: d */
        boolean f2872d;

        /* renamed from: e */
        boolean f2873e;

        /* renamed from: f */
        int[] f2874f;

        C1074b() {
            mo5751b();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5750a(C1076d[] dVarArr) {
            int length = dVarArr.length;
            int[] iArr = this.f2874f;
            if (iArr == null || iArr.length < length) {
                this.f2874f = new int[StaggeredGridLayoutManager.this.f2845t.length];
            }
            for (int i = 0; i < length; i++) {
                this.f2874f[i] = dVarArr[i].mo5761b(Integer.MIN_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5751b() {
            this.f2869a = -1;
            this.f2870b = Integer.MIN_VALUE;
            this.f2871c = false;
            this.f2872d = false;
            this.f2873e = false;
            int[] iArr = this.f2874f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5748a() {
            int i;
            if (this.f2871c) {
                i = StaggeredGridLayoutManager.this.f2846u.mo5882b();
            } else {
                i = StaggeredGridLayoutManager.this.f2846u.mo5890f();
            }
            this.f2870b = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5749a(int i) {
            if (this.f2871c) {
                this.f2870b = StaggeredGridLayoutManager.this.f2846u.mo5882b() - i;
            } else {
                this.f2870b = StaggeredGridLayoutManager.this.f2846u.mo5890f() + i;
            }
        }
    }

    /* renamed from: j */
    private int m4195j(RecyclerView.C1070z zVar) {
        if (mo5591e() == 0) {
            return 0;
        }
        return C1111j.m4519b(zVar, this.f2846u, mo5717b(!this.f2841N), mo5714a(!this.f2841N), this, this.f2841N);
    }

    /* renamed from: d */
    public void mo5174d(RecyclerView recyclerView) {
        this.f2832E.mo5725a();
        mo5625y();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0157, code lost:
        if (mo5707F() != false) goto L_0x015b;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4190c(androidx.recyclerview.widget.RecyclerView.C1066v r9, androidx.recyclerview.widget.RecyclerView.C1070z r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r0 = r8.f2839L
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.f2836I
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.f2830C
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.mo5697a()
            if (r1 != 0) goto L_0x0018
            r8.mo5574b((androidx.recyclerview.widget.RecyclerView.C1066v) r9)
            r0.mo5751b()
            return
        L_0x0018:
            boolean r1 = r0.f2873e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.f2830C
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.f2836I
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.mo5751b()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.f2836I
            if (r5 == 0) goto L_0x0037
            r8.m4182a((androidx.recyclerview.widget.StaggeredGridLayoutManager.C1074b) r0)
            goto L_0x003e
        L_0x0037:
            r8.m4173O()
            boolean r5 = r8.f2828A
            r0.f2871c = r5
        L_0x003e:
            r8.mo5718b((androidx.recyclerview.widget.RecyclerView.C1070z) r10, (androidx.recyclerview.widget.StaggeredGridLayoutManager.C1074b) r0)
            r0.f2873e = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.f2836I
            if (r5 != 0) goto L_0x0060
            int r5 = r8.f2830C
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.f2871c
            boolean r6 = r8.f2834G
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.mo5713L()
            boolean r6 = r8.f2835H
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r5 = r8.f2832E
            r5.mo5725a()
            r0.f2872d = r4
        L_0x0060:
            int r5 = r8.mo5591e()
            if (r5 <= 0) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.f2836I
            if (r5 == 0) goto L_0x006e
            int r5 = r5.f2860c
            if (r5 >= r4) goto L_0x00c9
        L_0x006e:
            boolean r5 = r0.f2872d
            if (r5 == 0) goto L_0x008e
            r1 = 0
        L_0x0073:
            int r5 = r8.f2844s
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d[] r5 = r8.f2845t
            r5 = r5[r1]
            r5.mo5764c()
            int r5 = r0.f2870b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008b
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d[] r6 = r8.f2845t
            r6 = r6[r1]
            r6.mo5768d(r5)
        L_0x008b:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x008e:
            if (r1 != 0) goto L_0x00af
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r1 = r8.f2839L
            int[] r1 = r1.f2874f
            if (r1 != 0) goto L_0x0097
            goto L_0x00af
        L_0x0097:
            r1 = 0
        L_0x0098:
            int r5 = r8.f2844s
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d[] r5 = r8.f2845t
            r5 = r5[r1]
            r5.mo5764c()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r6 = r8.f2839L
            int[] r6 = r6.f2874f
            r6 = r6[r1]
            r5.mo5768d(r6)
            int r1 = r1 + 1
            goto L_0x0098
        L_0x00af:
            r1 = 0
        L_0x00b0:
            int r5 = r8.f2844s
            if (r1 >= r5) goto L_0x00c2
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d[] r5 = r8.f2845t
            r5 = r5[r1]
            boolean r6 = r8.f2828A
            int r7 = r0.f2870b
            r5.mo5760a((boolean) r6, (int) r7)
            int r1 = r1 + 1
            goto L_0x00b0
        L_0x00c2:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r1 = r8.f2839L
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d[] r5 = r8.f2845t
            r1.mo5750a((androidx.recyclerview.widget.StaggeredGridLayoutManager.C1076d[]) r5)
        L_0x00c9:
            r8.mo5552a((androidx.recyclerview.widget.RecyclerView.C1066v) r9)
            androidx.recyclerview.widget.f r1 = r8.f2850y
            r1.f3003a = r3
            r8.f2840M = r3
            androidx.recyclerview.widget.h r1 = r8.f2847v
            int r1 = r1.mo5892g()
            r8.mo5723j((int) r1)
            int r1 = r0.f2869a
            r8.m4186b((int) r1, (androidx.recyclerview.widget.RecyclerView.C1070z) r10)
            boolean r1 = r0.f2871c
            if (r1 == 0) goto L_0x00fc
            r8.m4209v(r2)
            androidx.recyclerview.widget.f r1 = r8.f2850y
            r8.m4174a((androidx.recyclerview.widget.RecyclerView.C1066v) r9, (androidx.recyclerview.widget.C1103f) r1, (androidx.recyclerview.widget.RecyclerView.C1070z) r10)
            r8.m4209v(r4)
            androidx.recyclerview.widget.f r1 = r8.f2850y
            int r2 = r0.f2869a
            int r5 = r1.f3006d
            int r2 = r2 + r5
            r1.f3005c = r2
            r8.m4174a((androidx.recyclerview.widget.RecyclerView.C1066v) r9, (androidx.recyclerview.widget.C1103f) r1, (androidx.recyclerview.widget.RecyclerView.C1070z) r10)
            goto L_0x0113
        L_0x00fc:
            r8.m4209v(r4)
            androidx.recyclerview.widget.f r1 = r8.f2850y
            r8.m4174a((androidx.recyclerview.widget.RecyclerView.C1066v) r9, (androidx.recyclerview.widget.C1103f) r1, (androidx.recyclerview.widget.RecyclerView.C1070z) r10)
            r8.m4209v(r2)
            androidx.recyclerview.widget.f r1 = r8.f2850y
            int r2 = r0.f2869a
            int r5 = r1.f3006d
            int r2 = r2 + r5
            r1.f3005c = r2
            r8.m4174a((androidx.recyclerview.widget.RecyclerView.C1066v) r9, (androidx.recyclerview.widget.C1103f) r1, (androidx.recyclerview.widget.RecyclerView.C1070z) r10)
        L_0x0113:
            r8.m4172N()
            int r1 = r8.mo5591e()
            if (r1 <= 0) goto L_0x012d
            boolean r1 = r8.f2828A
            if (r1 == 0) goto L_0x0127
            r8.m4180a((androidx.recyclerview.widget.RecyclerView.C1066v) r9, (androidx.recyclerview.widget.RecyclerView.C1070z) r10, (boolean) r4)
            r8.m4188b((androidx.recyclerview.widget.RecyclerView.C1066v) r9, (androidx.recyclerview.widget.RecyclerView.C1070z) r10, (boolean) r3)
            goto L_0x012d
        L_0x0127:
            r8.m4188b((androidx.recyclerview.widget.RecyclerView.C1066v) r9, (androidx.recyclerview.widget.RecyclerView.C1070z) r10, (boolean) r4)
            r8.m4180a((androidx.recyclerview.widget.RecyclerView.C1066v) r9, (androidx.recyclerview.widget.RecyclerView.C1070z) r10, (boolean) r3)
        L_0x012d:
            if (r11 == 0) goto L_0x015a
            boolean r11 = r10.mo5702d()
            if (r11 != 0) goto L_0x015a
            int r11 = r8.f2833F
            if (r11 == 0) goto L_0x014b
            int r11 = r8.mo5591e()
            if (r11 <= 0) goto L_0x014b
            boolean r11 = r8.f2840M
            if (r11 != 0) goto L_0x0149
            android.view.View r11 = r8.mo5711J()
            if (r11 == 0) goto L_0x014b
        L_0x0149:
            r11 = 1
            goto L_0x014c
        L_0x014b:
            r11 = 0
        L_0x014c:
            if (r11 == 0) goto L_0x015a
            java.lang.Runnable r11 = r8.f2843P
            r8.mo5569a((java.lang.Runnable) r11)
            boolean r11 = r8.mo5707F()
            if (r11 == 0) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r4 = 0
        L_0x015b:
            boolean r11 = r10.mo5702d()
            if (r11 == 0) goto L_0x0166
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r11 = r8.f2839L
            r11.mo5751b()
        L_0x0166:
            boolean r11 = r0.f2871c
            r8.f2834G = r11
            boolean r11 = r8.mo5713L()
            r8.f2835H = r11
            if (r4 == 0) goto L_0x017a
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r11 = r8.f2839L
            r11.mo5751b()
            r8.m4190c((androidx.recyclerview.widget.RecyclerView.C1066v) r9, (androidx.recyclerview.widget.RecyclerView.C1070z) r10, (boolean) r3)
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m4190c(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$z, boolean):void");
    }

    /* renamed from: e */
    private void m4192e(int i, int i2) {
        for (int i3 = 0; i3 < this.f2844s; i3++) {
            if (!this.f2845t[i3].f2878a.isEmpty()) {
                m4183a(this.f2845t[i3], i, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5718b(RecyclerView.C1070z zVar, C1074b bVar) {
        if (!mo5716a(zVar, bVar) && !m4191c(zVar, bVar)) {
            bVar.mo5748a();
            bVar.f2869a = 0;
        }
    }

    /* renamed from: h */
    private int m4193h(RecyclerView.C1070z zVar) {
        if (mo5591e() == 0) {
            return 0;
        }
        return C1111j.m4517a(zVar, this.f2846u, mo5717b(!this.f2841N), mo5714a(!this.f2841N), this, this.f2841N);
    }

    /* renamed from: i */
    private int m4194i(RecyclerView.C1070z zVar) {
        if (mo5591e() == 0) {
            return 0;
        }
        return C1111j.m4518a(zVar, this.f2846u, mo5717b(!this.f2841N), mo5714a(!this.f2841N), this, this.f2841N, this.f2828A);
    }

    /* renamed from: a */
    public void mo5208a(String str) {
        if (this.f2836I == null) {
            super.mo5208a(str);
        }
    }

    /* renamed from: b */
    public int mo5169b(RecyclerView.C1070z zVar) {
        return m4194i(zVar);
    }

    /* renamed from: b */
    public int mo5168b(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        if (this.f2848w == 0) {
            return this.f2844s;
        }
        return super.mo5168b(vVar, zVar);
    }

    /* renamed from: a */
    public void mo5158a(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int n = mo5614n() + mo5616o();
        int p = mo5618p() + mo5612m();
        if (this.f2848w == 1) {
            i4 = RecyclerView.C1054o.m3943a(i2, rect.height() + p, mo5608k());
            i3 = RecyclerView.C1054o.m3943a(i, (this.f2849x * this.f2844s) + n, mo5610l());
        } else {
            i3 = RecyclerView.C1054o.m3943a(i, rect.width() + n, mo5610l());
            i4 = RecyclerView.C1054o.m3943a(i2, (this.f2849x * this.f2844s) + p, mo5608k());
        }
        mo5580c(i3, i4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public View mo5717b(boolean z) {
        int f = this.f2846u.mo5890f();
        int b = this.f2846u.mo5882b();
        int e = mo5591e();
        View view = null;
        for (int i = 0; i < e; i++) {
            View c = mo5578c(i);
            int d = this.f2846u.mo5887d(c);
            if (this.f2846u.mo5880a(c) > f && d < b) {
                if (d >= f || !z) {
                    return c;
                }
                if (view == null) {
                    view = c;
                }
            }
        }
        return view;
    }

    /* renamed from: b */
    private void m4188b(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, boolean z) {
        int f;
        int t = m4207t(Integer.MAX_VALUE);
        if (t != Integer.MAX_VALUE && (f = t - this.f2846u.mo5890f()) > 0) {
            int c = f - mo5719c(f, vVar, zVar);
            if (z && c > 0) {
                this.f2846u.mo5881a(-c);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4186b(int r5, androidx.recyclerview.widget.RecyclerView.C1070z r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.f r0 = r4.f2850y
            r1 = 0
            r0.f3004b = r1
            r0.f3005c = r5
            boolean r0 = r4.mo5624w()
            r2 = 1
            if (r0 == 0) goto L_0x002e
            int r6 = r6.mo5700b()
            r0 = -1
            if (r6 == r0) goto L_0x002e
            boolean r0 = r4.f2828A
            if (r6 >= r5) goto L_0x001b
            r5 = 1
            goto L_0x001c
        L_0x001b:
            r5 = 0
        L_0x001c:
            if (r0 != r5) goto L_0x0025
            androidx.recyclerview.widget.h r5 = r4.f2846u
            int r5 = r5.mo5892g()
            goto L_0x002f
        L_0x0025:
            androidx.recyclerview.widget.h r5 = r4.f2846u
            int r5 = r5.mo5892g()
            r6 = r5
            r5 = 0
            goto L_0x0030
        L_0x002e:
            r5 = 0
        L_0x002f:
            r6 = 0
        L_0x0030:
            boolean r0 = r4.mo5598f()
            if (r0 == 0) goto L_0x004d
            androidx.recyclerview.widget.f r0 = r4.f2850y
            androidx.recyclerview.widget.h r3 = r4.f2846u
            int r3 = r3.mo5890f()
            int r3 = r3 - r6
            r0.f3008f = r3
            androidx.recyclerview.widget.f r6 = r4.f2850y
            androidx.recyclerview.widget.h r0 = r4.f2846u
            int r0 = r0.mo5882b()
            int r0 = r0 + r5
            r6.f3009g = r0
            goto L_0x005d
        L_0x004d:
            androidx.recyclerview.widget.f r0 = r4.f2850y
            androidx.recyclerview.widget.h r3 = r4.f2846u
            int r3 = r3.mo5879a()
            int r3 = r3 + r5
            r0.f3009g = r3
            androidx.recyclerview.widget.f r5 = r4.f2850y
            int r6 = -r6
            r5.f3008f = r6
        L_0x005d:
            androidx.recyclerview.widget.f r5 = r4.f2850y
            r5.f3010h = r1
            r5.f3003a = r2
            androidx.recyclerview.widget.h r6 = r4.f2846u
            int r6 = r6.mo5886d()
            if (r6 != 0) goto L_0x0074
            androidx.recyclerview.widget.h r6 = r4.f2846u
            int r6 = r6.mo5879a()
            if (r6 != 0) goto L_0x0074
            r1 = 1
        L_0x0074:
            r5.f3011i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m4186b(int, androidx.recyclerview.widget.RecyclerView$z):void");
    }

    /* renamed from: a */
    private void m4182a(C1074b bVar) {
        int i;
        SavedState savedState = this.f2836I;
        int i2 = savedState.f2860c;
        if (i2 > 0) {
            if (i2 == this.f2844s) {
                for (int i3 = 0; i3 < this.f2844s; i3++) {
                    this.f2845t[i3].mo5764c();
                    SavedState savedState2 = this.f2836I;
                    int i4 = savedState2.f2861d[i3];
                    if (i4 != Integer.MIN_VALUE) {
                        if (savedState2.f2866i) {
                            i = this.f2846u.mo5882b();
                        } else {
                            i = this.f2846u.mo5890f();
                        }
                        i4 += i;
                    }
                    this.f2845t[i3].mo5768d(i4);
                }
            } else {
                savedState.mo5742a();
                SavedState savedState3 = this.f2836I;
                savedState3.f2858a = savedState3.f2859b;
            }
        }
        SavedState savedState4 = this.f2836I;
        this.f2835H = savedState4.f2867j;
        mo5720c(savedState4.f2865h);
        m4173O();
        SavedState savedState5 = this.f2836I;
        int i5 = savedState5.f2858a;
        if (i5 != -1) {
            this.f2830C = i5;
            bVar.f2871c = savedState5.f2866i;
        } else {
            bVar.f2871c = this.f2828A;
        }
        SavedState savedState6 = this.f2836I;
        if (savedState6.f2862e > 1) {
            LazySpanLookup lazySpanLookup = this.f2832E;
            lazySpanLookup.f2852a = savedState6.f2863f;
            lazySpanLookup.f2853b = savedState6.f2864g;
        }
    }

    /* renamed from: b */
    public void mo5170b(RecyclerView recyclerView, int i, int i2) {
        m4185b(i, i2, 2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4185b(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f2828A
            if (r0 == 0) goto L_0x0009
            int r0 = r6.mo5710I()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.mo5709H()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001a
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001c
        L_0x0016:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001d
        L_0x001a:
            int r2 = r7 + r8
        L_0x001c:
            r3 = r7
        L_0x001d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.f2832E
            r4.mo5734e(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003c
            r5 = 2
            if (r9 == r5) goto L_0x0036
            if (r9 == r1) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f2832E
            r9.mo5731b(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.f2832E
            r7.mo5727a((int) r8, (int) r4)
            goto L_0x0041
        L_0x0036:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f2832E
            r9.mo5731b(r7, r8)
            goto L_0x0041
        L_0x003c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f2832E
            r9.mo5727a((int) r7, (int) r8)
        L_0x0041:
            if (r2 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r7 = r6.f2828A
            if (r7 == 0) goto L_0x004d
            int r7 = r6.mo5709H()
            goto L_0x0051
        L_0x004d:
            int r7 = r6.mo5710I()
        L_0x0051:
            if (r3 > r7) goto L_0x0056
            r6.mo5625y()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m4185b(int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5716a(RecyclerView.C1070z zVar, C1074b bVar) {
        int i;
        int i2;
        int i3;
        boolean z = false;
        if (!zVar.mo5702d() && (i = this.f2830C) != -1) {
            if (i < 0 || i >= zVar.mo5697a()) {
                this.f2830C = -1;
                this.f2831D = Integer.MIN_VALUE;
            } else {
                SavedState savedState = this.f2836I;
                if (savedState == null || savedState.f2858a == -1 || savedState.f2860c < 1) {
                    View b = mo5211b(this.f2830C);
                    if (b != null) {
                        if (this.f2828A) {
                            i2 = mo5710I();
                        } else {
                            i2 = mo5709H();
                        }
                        bVar.f2869a = i2;
                        if (this.f2831D != Integer.MIN_VALUE) {
                            if (bVar.f2871c) {
                                bVar.f2870b = (this.f2846u.mo5882b() - this.f2831D) - this.f2846u.mo5880a(b);
                            } else {
                                bVar.f2870b = (this.f2846u.mo5890f() + this.f2831D) - this.f2846u.mo5887d(b);
                            }
                            return true;
                        } else if (this.f2846u.mo5883b(b) > this.f2846u.mo5892g()) {
                            if (bVar.f2871c) {
                                i3 = this.f2846u.mo5882b();
                            } else {
                                i3 = this.f2846u.mo5890f();
                            }
                            bVar.f2870b = i3;
                            return true;
                        } else {
                            int d = this.f2846u.mo5887d(b) - this.f2846u.mo5890f();
                            if (d < 0) {
                                bVar.f2870b = -d;
                                return true;
                            }
                            int b2 = this.f2846u.mo5882b() - this.f2846u.mo5880a(b);
                            if (b2 < 0) {
                                bVar.f2870b = b2;
                                return true;
                            }
                            bVar.f2870b = Integer.MIN_VALUE;
                        }
                    } else {
                        int i4 = this.f2830C;
                        bVar.f2869a = i4;
                        int i5 = this.f2831D;
                        if (i5 == Integer.MIN_VALUE) {
                            if (m4196k(i4) == 1) {
                                z = true;
                            }
                            bVar.f2871c = z;
                            bVar.mo5748a();
                        } else {
                            bVar.mo5749a(i5);
                        }
                        bVar.f2872d = true;
                    }
                } else {
                    bVar.f2870b = Integer.MIN_VALUE;
                    bVar.f2869a = this.f2830C;
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m4187b(RecyclerView.C1066v vVar, int i) {
        while (mo5591e() > 0) {
            View c = mo5578c(0);
            if (this.f2846u.mo5880a(c) <= i && this.f2846u.mo5889e(c) <= i) {
                C1075c cVar = (C1075c) c.getLayoutParams();
                if (cVar.f2877f) {
                    int i2 = 0;
                    while (i2 < this.f2844s) {
                        if (this.f2845t[i2].f2878a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.f2844s; i3++) {
                        this.f2845t[i3].mo5775k();
                    }
                } else if (cVar.f2876e.f2878a.size() != 1) {
                    cVar.f2876e.mo5775k();
                } else {
                    return;
                }
                mo5548a(c, vVar);
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public boolean mo5214b() {
        return this.f2848w == 1;
    }

    /* renamed from: b */
    public int mo5167b(int i, RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        return mo5719c(i, vVar, zVar);
    }

    /* renamed from: c */
    private boolean m4191c(RecyclerView.C1070z zVar, C1074b bVar) {
        int i;
        if (this.f2834G) {
            i = m4201p(zVar.mo5697a());
        } else {
            i = m4200o(zVar.mo5697a());
        }
        bVar.f2869a = i;
        bVar.f2870b = Integer.MIN_VALUE;
        return true;
    }

    /* renamed from: c */
    public int mo5172c(RecyclerView.C1070z zVar) {
        return m4195j(zVar);
    }

    /* renamed from: c */
    private int m4189c(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo5719c(int i, RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        if (mo5591e() == 0 || i == 0) {
            return 0;
        }
        mo5715a(i, zVar);
        int a = m4174a(vVar, this.f2850y, zVar);
        if (this.f2850y.f3004b >= a) {
            i = i < 0 ? -a : a;
        }
        this.f2846u.mo5881a(-i);
        this.f2834G = this.f2828A;
        C1103f fVar = this.f2850y;
        fVar.f3004b = 0;
        m4181a(vVar, fVar);
        return i;
    }

    /* renamed from: a */
    public int mo5200a(RecyclerView.C1070z zVar) {
        return m4193h(zVar);
    }

    /* renamed from: a */
    private void m4178a(View view, C1075c cVar, boolean z) {
        if (cVar.f2877f) {
            if (this.f2848w == 1) {
                m4176a(view, this.f2837J, RecyclerView.C1054o.m3944a(mo5602h(), mo5604i(), mo5618p() + mo5612m(), cVar.height, true), z);
            } else {
                m4176a(view, RecyclerView.C1054o.m3944a(mo5619q(), mo5620r(), mo5614n() + mo5616o(), cVar.width, true), this.f2837J, z);
            }
        } else if (this.f2848w == 1) {
            m4176a(view, RecyclerView.C1054o.m3944a(this.f2849x, mo5620r(), 0, cVar.width, false), RecyclerView.C1054o.m3944a(mo5602h(), mo5604i(), mo5618p() + mo5612m(), cVar.height, true), z);
        } else {
            m4176a(view, RecyclerView.C1054o.m3944a(mo5619q(), mo5620r(), mo5614n() + mo5616o(), cVar.width, true), RecyclerView.C1054o.m3944a(this.f2849x, mo5604i(), 0, cVar.height, false), z);
        }
    }

    /* renamed from: c */
    public RecyclerView.C1059p mo5173c() {
        if (this.f2848w == 0) {
            return new C1075c(-2, -1);
        }
        return new C1075c(-1, -2);
    }

    /* renamed from: a */
    private void m4176a(View view, int i, int i2, boolean z) {
        boolean z2;
        mo5546a(view, this.f2838K);
        C1075c cVar = (C1075c) view.getLayoutParams();
        int i3 = cVar.leftMargin;
        Rect rect = this.f2838K;
        int c = m4189c(i, i3 + rect.left, cVar.rightMargin + rect.right);
        int i4 = cVar.topMargin;
        Rect rect2 = this.f2838K;
        int c2 = m4189c(i2, i4 + rect2.top, cVar.bottomMargin + rect2.bottom);
        if (z) {
            z2 = mo5576b(view, c, c2, cVar);
        } else {
            z2 = mo5559a(view, c, c2, (RecyclerView.C1059p) cVar);
        }
        if (z2) {
            view.measure(c, c2);
        }
    }

    /* renamed from: a */
    public void mo5205a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f2836I = (SavedState) parcelable;
            mo5625y();
        }
    }

    /* renamed from: a */
    public void mo5159a(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, View view, C0807c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof C1075c)) {
            super.mo5547a(view, cVar);
            return;
        }
        C1075c cVar2 = (C1075c) layoutParams;
        if (this.f2848w == 0) {
            cVar.mo4124b((Object) C0807c.C0810c.m2620a(cVar2.mo5752e(), cVar2.f2877f ? this.f2844s : 1, -1, -1, false, false));
        } else {
            cVar.mo4124b((Object) C0807c.C0810c.m2620a(-1, -1, cVar2.mo5752e(), cVar2.f2877f ? this.f2844s : 1, false, false));
        }
    }

    /* renamed from: a */
    public void mo5206a(AccessibilityEvent accessibilityEvent) {
        super.mo5206a(accessibilityEvent);
        if (mo5591e() > 0) {
            View b = mo5717b(false);
            View a = mo5714a(false);
            if (b != null && a != null) {
                int l = mo5611l(b);
                int l2 = mo5611l(a);
                if (l < l2) {
                    accessibilityEvent.setFromIndex(l);
                    accessibilityEvent.setToIndex(l2);
                    return;
                }
                accessibilityEvent.setFromIndex(l2);
                accessibilityEvent.setToIndex(l);
            }
        }
    }

    /* renamed from: a */
    public int mo5153a(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        if (this.f2848w == 1) {
            return this.f2844s;
        }
        return super.mo5153a(vVar, zVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo5714a(boolean z) {
        int f = this.f2846u.mo5890f();
        int b = this.f2846u.mo5882b();
        View view = null;
        for (int e = mo5591e() - 1; e >= 0; e--) {
            View c = mo5578c(e);
            int d = this.f2846u.mo5887d(c);
            int a = this.f2846u.mo5880a(c);
            if (a > f && d < b) {
                if (a <= b || !z) {
                    return c;
                }
                if (view == null) {
                    view = c;
                }
            }
        }
        return view;
    }

    /* renamed from: a */
    private void m4180a(RecyclerView.C1066v vVar, RecyclerView.C1070z zVar, boolean z) {
        int b;
        int q = m4203q(Integer.MIN_VALUE);
        if (q != Integer.MIN_VALUE && (b = this.f2846u.mo5882b() - q) > 0) {
            int i = b - (-mo5719c(-b, vVar, zVar));
            if (z && i > 0) {
                this.f2846u.mo5881a(i);
            }
        }
    }

    /* renamed from: a */
    public void mo5163a(RecyclerView recyclerView, int i, int i2) {
        m4185b(i, i2, 1);
    }

    /* renamed from: a */
    public void mo5164a(RecyclerView recyclerView, int i, int i2, int i3) {
        m4185b(i, i2, 8);
    }

    /* renamed from: a */
    public void mo5165a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m4185b(i, i2, 4);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* renamed from: a */
    private int m4174a(RecyclerView.C1066v vVar, C1103f fVar, RecyclerView.C1070z zVar) {
        int i;
        int i2;
        int i3;
        C1076d dVar;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        int i12;
        RecyclerView.C1066v vVar2 = vVar;
        C1103f fVar2 = fVar;
        ? r9 = 0;
        this.f2829B.set(0, this.f2844s, true);
        if (this.f2850y.f3011i) {
            i = fVar2.f3007e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (fVar2.f3007e == 1) {
                i12 = fVar2.f3009g + fVar2.f3004b;
            } else {
                i12 = fVar2.f3008f - fVar2.f3004b;
            }
            i = i12;
        }
        m4192e(fVar2.f3007e, i);
        if (this.f2828A) {
            i2 = this.f2846u.mo5882b();
        } else {
            i2 = this.f2846u.mo5890f();
        }
        int i13 = i2;
        boolean z2 = false;
        while (fVar.mo5874a(zVar) && (this.f2850y.f3011i || !this.f2829B.isEmpty())) {
            View a = fVar2.mo5873a(vVar2);
            C1075c cVar = (C1075c) a.getLayoutParams();
            int a2 = cVar.mo5633a();
            int d = this.f2832E.mo5733d(a2);
            boolean z3 = d == -1;
            if (z3) {
                dVar = cVar.f2877f ? this.f2845t[r9] : m4175a(fVar2);
                this.f2832E.mo5728a(a2, dVar);
            } else {
                dVar = this.f2845t[d];
            }
            C1076d dVar2 = dVar;
            cVar.f2876e = dVar2;
            if (fVar2.f3007e == 1) {
                mo5571b(a);
            } else {
                mo5572b(a, (int) r9);
            }
            m4178a(a, cVar, (boolean) r9);
            if (fVar2.f3007e == 1) {
                if (cVar.f2877f) {
                    i11 = m4203q(i13);
                } else {
                    i11 = dVar2.mo5754a(i13);
                }
                int b = this.f2846u.mo5883b(a) + i11;
                if (z3 && cVar.f2877f) {
                    LazySpanLookup.FullSpanItem m = m4198m(i11);
                    m.f2855b = -1;
                    m.f2854a = a2;
                    this.f2832E.mo5729a(m);
                }
                i4 = b;
                i5 = i11;
            } else {
                if (cVar.f2877f) {
                    i10 = m4207t(i13);
                } else {
                    i10 = dVar2.mo5761b(i13);
                }
                i5 = i10 - this.f2846u.mo5883b(a);
                if (z3 && cVar.f2877f) {
                    LazySpanLookup.FullSpanItem n = m4199n(i10);
                    n.f2855b = 1;
                    n.f2854a = a2;
                    this.f2832E.mo5729a(n);
                }
                i4 = i10;
            }
            if (cVar.f2877f && fVar2.f3006d == -1) {
                if (z3) {
                    this.f2840M = true;
                } else {
                    if (fVar2.f3007e == 1) {
                        z = mo5705D();
                    } else {
                        z = mo5706E();
                    }
                    if (!z) {
                        LazySpanLookup.FullSpanItem c = this.f2832E.mo5732c(a2);
                        if (c != null) {
                            c.f2857d = true;
                        }
                        this.f2840M = true;
                    }
                }
            }
            m4177a(a, cVar, fVar2);
            if (!mo5713L() || this.f2848w != 1) {
                if (cVar.f2877f) {
                    i8 = this.f2847v.mo5890f();
                } else {
                    i8 = (dVar2.f2882e * this.f2849x) + this.f2847v.mo5890f();
                }
                i7 = i8;
                i6 = this.f2847v.mo5883b(a) + i8;
            } else {
                if (cVar.f2877f) {
                    i9 = this.f2847v.mo5882b();
                } else {
                    i9 = this.f2847v.mo5882b() - (((this.f2844s - 1) - dVar2.f2882e) * this.f2849x);
                }
                i6 = i9;
                i7 = i9 - this.f2847v.mo5883b(a);
            }
            if (this.f2848w == 1) {
                mo5544a(a, i7, i5, i6, i4);
            } else {
                mo5544a(a, i5, i7, i4, i6);
            }
            if (cVar.f2877f) {
                m4192e(this.f2850y.f3007e, i);
            } else {
                m4183a(dVar2, this.f2850y.f3007e, i);
            }
            m4181a(vVar2, this.f2850y);
            if (this.f2850y.f3010h && a.hasFocusable()) {
                if (cVar.f2877f) {
                    this.f2829B.clear();
                } else {
                    this.f2829B.set(dVar2.f2882e, false);
                    z2 = true;
                    r9 = 0;
                }
            }
            z2 = true;
            r9 = 0;
        }
        if (!z2) {
            m4181a(vVar2, this.f2850y);
        }
        if (this.f2850y.f3007e == -1) {
            i3 = this.f2846u.mo5890f() - m4207t(this.f2846u.mo5890f());
        } else {
            i3 = m4203q(this.f2846u.mo5882b()) - this.f2846u.mo5882b();
        }
        if (i3 > 0) {
            return Math.min(fVar2.f3004b, i3);
        }
        return 0;
    }

    /* renamed from: a */
    private void m4177a(View view, C1075c cVar, C1103f fVar) {
        if (fVar.f3007e == 1) {
            if (cVar.f2877f) {
                m4202p(view);
            } else {
                cVar.f2876e.mo5759a(view);
            }
        } else if (cVar.f2877f) {
            m4204q(view);
        } else {
            cVar.f2876e.mo5766c(view);
        }
    }

    /* renamed from: a */
    private void m4181a(RecyclerView.C1066v vVar, C1103f fVar) {
        int i;
        int i2;
        if (fVar.f3003a && !fVar.f3011i) {
            if (fVar.f3004b == 0) {
                if (fVar.f3007e == -1) {
                    m4179a(vVar, fVar.f3009g);
                } else {
                    m4187b(vVar, fVar.f3008f);
                }
            } else if (fVar.f3007e == -1) {
                int i3 = fVar.f3008f;
                int r = i3 - m4205r(i3);
                if (r < 0) {
                    i2 = fVar.f3009g;
                } else {
                    i2 = fVar.f3009g - Math.min(r, fVar.f3004b);
                }
                m4179a(vVar, i2);
            } else {
                int s = m4206s(fVar.f3009g) - fVar.f3009g;
                if (s < 0) {
                    i = fVar.f3008f;
                } else {
                    i = Math.min(s, fVar.f3004b) + fVar.f3008f;
                }
                m4187b(vVar, i);
            }
        }
    }

    /* renamed from: a */
    private void m4183a(C1076d dVar, int i, int i2) {
        int f = dVar.mo5770f();
        if (i == -1) {
            if (dVar.mo5772h() + f <= i2) {
                this.f2829B.set(dVar.f2882e, false);
            }
        } else if (dVar.mo5771g() - f >= i2) {
            this.f2829B.set(dVar.f2882e, false);
        }
    }

    /* renamed from: a */
    private void m4179a(RecyclerView.C1066v vVar, int i) {
        int e = mo5591e() - 1;
        while (e >= 0) {
            View c = mo5578c(e);
            if (this.f2846u.mo5887d(c) >= i && this.f2846u.mo5891f(c) >= i) {
                C1075c cVar = (C1075c) c.getLayoutParams();
                if (cVar.f2877f) {
                    int i2 = 0;
                    while (i2 < this.f2844s) {
                        if (this.f2845t[i2].f2878a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.f2844s; i3++) {
                        this.f2845t[i3].mo5774j();
                    }
                } else if (cVar.f2876e.f2878a.size() != 1) {
                    cVar.f2876e.mo5774j();
                } else {
                    return;
                }
                mo5548a(c, vVar);
                e--;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private C1076d m4175a(C1103f fVar) {
        int i;
        int i2;
        int i3 = -1;
        if (m4208u(fVar.f3007e)) {
            i2 = this.f2844s - 1;
            i = -1;
        } else {
            i2 = 0;
            i3 = this.f2844s;
            i = 1;
        }
        C1076d dVar = null;
        if (fVar.f3007e == 1) {
            int i4 = Integer.MAX_VALUE;
            int f = this.f2846u.mo5890f();
            while (i2 != i3) {
                C1076d dVar2 = this.f2845t[i2];
                int a = dVar2.mo5754a(f);
                if (a < i4) {
                    dVar = dVar2;
                    i4 = a;
                }
                i2 += i;
            }
            return dVar;
        }
        int i5 = Integer.MIN_VALUE;
        int b = this.f2846u.mo5882b();
        while (i2 != i3) {
            C1076d dVar3 = this.f2845t[i2];
            int b2 = dVar3.mo5761b(b);
            if (b2 > i5) {
                dVar = dVar3;
                i5 = b2;
            }
            i2 += i;
        }
        return dVar;
    }

    /* renamed from: a */
    public boolean mo5210a() {
        return this.f2848w == 0;
    }

    /* renamed from: a */
    public int mo5152a(int i, RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        return mo5719c(i, vVar, zVar);
    }

    /* renamed from: a */
    public void mo5203a(int i, int i2, RecyclerView.C1070z zVar, RecyclerView.C1054o.C1057c cVar) {
        int i3;
        int i4;
        if (this.f2848w != 0) {
            i = i2;
        }
        if (mo5591e() != 0 && i != 0) {
            mo5715a(i, zVar);
            int[] iArr = this.f2842O;
            if (iArr == null || iArr.length < this.f2844s) {
                this.f2842O = new int[this.f2844s];
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.f2844s; i6++) {
                C1103f fVar = this.f2850y;
                if (fVar.f3006d == -1) {
                    i4 = fVar.f3008f;
                    i3 = this.f2845t[i6].mo5761b(i4);
                } else {
                    i4 = this.f2845t[i6].mo5754a(fVar.f3009g);
                    i3 = this.f2850y.f3009g;
                }
                int i7 = i4 - i3;
                if (i7 >= 0) {
                    this.f2842O[i5] = i7;
                    i5++;
                }
            }
            Arrays.sort(this.f2842O, 0, i5);
            for (int i8 = 0; i8 < i5 && this.f2850y.mo5874a(zVar); i8++) {
                cVar.mo5632a(this.f2850y.f3005c, this.f2842O[i8]);
                C1103f fVar2 = this.f2850y;
                fVar2.f3005c += fVar2.f3006d;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5715a(int i, RecyclerView.C1070z zVar) {
        int i2;
        int i3;
        if (i > 0) {
            i3 = mo5710I();
            i2 = 1;
        } else {
            i3 = mo5709H();
            i2 = -1;
        }
        this.f2850y.f3003a = true;
        m4186b(i3, zVar);
        m4209v(i2);
        C1103f fVar = this.f2850y;
        fVar.f3005c = i3 + fVar.f3006d;
        fVar.f3004b = Math.abs(i);
    }

    /* renamed from: a */
    public RecyclerView.C1059p mo5156a(Context context, AttributeSet attributeSet) {
        return new C1075c(context, attributeSet);
    }

    /* renamed from: a */
    public RecyclerView.C1059p mo5157a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C1075c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C1075c(layoutParams);
    }

    /* renamed from: a */
    public boolean mo5166a(RecyclerView.C1059p pVar) {
        return pVar instanceof C1075c;
    }

    /* renamed from: a */
    public View mo5154a(View view, int i, RecyclerView.C1066v vVar, RecyclerView.C1070z zVar) {
        View c;
        int i2;
        int i3;
        int i4;
        int i5;
        View a;
        if (mo5591e() == 0 || (c = mo5579c(view)) == null) {
            return null;
        }
        m4173O();
        int l = m4197l(i);
        if (l == Integer.MIN_VALUE) {
            return null;
        }
        C1075c cVar = (C1075c) c.getLayoutParams();
        boolean z = cVar.f2877f;
        C1076d dVar = cVar.f2876e;
        if (l == 1) {
            i2 = mo5710I();
        } else {
            i2 = mo5709H();
        }
        m4186b(i2, zVar);
        m4209v(l);
        C1103f fVar = this.f2850y;
        fVar.f3005c = fVar.f3006d + i2;
        fVar.f3004b = (int) (((float) this.f2846u.mo5892g()) * 0.33333334f);
        C1103f fVar2 = this.f2850y;
        fVar2.f3010h = true;
        fVar2.f3003a = false;
        m4174a(vVar, fVar2, zVar);
        this.f2834G = this.f2828A;
        if (!z && (a = dVar.mo5757a(i2, l)) != null && a != c) {
            return a;
        }
        if (m4208u(l)) {
            for (int i6 = this.f2844s - 1; i6 >= 0; i6--) {
                View a2 = this.f2845t[i6].mo5757a(i2, l);
                if (a2 != null && a2 != c) {
                    return a2;
                }
            }
        } else {
            for (int i7 = 0; i7 < this.f2844s; i7++) {
                View a3 = this.f2845t[i7].mo5757a(i2, l);
                if (a3 != null && a3 != c) {
                    return a3;
                }
            }
        }
        boolean z2 = (this.f2851z ^ true) == (l == -1);
        if (!z) {
            if (z2) {
                i5 = dVar.mo5767d();
            } else {
                i5 = dVar.mo5769e();
            }
            View b = mo5211b(i5);
            if (!(b == null || b == c)) {
                return b;
            }
        }
        if (m4208u(l)) {
            for (int i8 = this.f2844s - 1; i8 >= 0; i8--) {
                if (i8 != dVar.f2882e) {
                    if (z2) {
                        i4 = this.f2845t[i8].mo5767d();
                    } else {
                        i4 = this.f2845t[i8].mo5769e();
                    }
                    View b2 = mo5211b(i4);
                    if (!(b2 == null || b2 == c)) {
                        return b2;
                    }
                }
            }
        } else {
            for (int i9 = 0; i9 < this.f2844s; i9++) {
                if (z2) {
                    i3 = this.f2845t[i9].mo5767d();
                } else {
                    i3 = this.f2845t[i9].mo5769e();
                }
                View b3 = mo5211b(i3);
                if (b3 != null && b3 != c) {
                    return b3;
                }
            }
        }
        return null;
    }
}
