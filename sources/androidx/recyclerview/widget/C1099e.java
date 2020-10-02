package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.core.p022os.C0864b;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* renamed from: androidx.recyclerview.widget.e */
/* compiled from: GapWorker */
final class C1099e implements Runnable {

    /* renamed from: e */
    static final ThreadLocal<C1099e> f2988e = new ThreadLocal<>();

    /* renamed from: f */
    static Comparator<C1102c> f2989f = new C1100a();

    /* renamed from: a */
    ArrayList<RecyclerView> f2990a = new ArrayList<>();

    /* renamed from: b */
    long f2991b;

    /* renamed from: c */
    long f2992c;

    /* renamed from: d */
    private ArrayList<C1102c> f2993d = new ArrayList<>();

    /* renamed from: androidx.recyclerview.widget.e$a */
    /* compiled from: GapWorker */
    static class C1100a implements Comparator<C1102c> {
        C1100a() {
        }

        /* renamed from: a */
        public int compare(C1102c cVar, C1102c cVar2) {
            if ((cVar.f3001d == null) == (cVar2.f3001d == null)) {
                boolean z = cVar.f2998a;
                if (z == cVar2.f2998a) {
                    int i = cVar2.f2999b - cVar.f2999b;
                    if (i != 0) {
                        return i;
                    }
                    int i2 = cVar.f3000c - cVar2.f3000c;
                    if (i2 != 0) {
                        return i2;
                    }
                    return 0;
                } else if (z) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (cVar.f3001d == null) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.e$c */
    /* compiled from: GapWorker */
    static class C1102c {

        /* renamed from: a */
        public boolean f2998a;

        /* renamed from: b */
        public int f2999b;

        /* renamed from: c */
        public int f3000c;

        /* renamed from: d */
        public RecyclerView f3001d;

        /* renamed from: e */
        public int f3002e;

        C1102c() {
        }

        /* renamed from: a */
        public void mo5872a() {
            this.f2998a = false;
            this.f2999b = 0;
            this.f3000c = 0;
            this.f3001d = null;
            this.f3002e = 0;
        }
    }

    C1099e() {
    }

    /* renamed from: a */
    public void mo5862a(RecyclerView recyclerView) {
        this.f2990a.add(recyclerView);
    }

    /* renamed from: b */
    public void mo5864b(RecyclerView recyclerView) {
        this.f2990a.remove(recyclerView);
    }

    public void run() {
        try {
            C0864b.m2832a("RV Prefetch");
            if (!this.f2990a.isEmpty()) {
                int size = this.f2990a.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f2990a.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    mo5861a(TimeUnit.MILLISECONDS.toNanos(j) + this.f2992c);
                    this.f2991b = 0;
                    C0864b.m2831a();
                }
            }
        } finally {
            this.f2991b = 0;
            C0864b.m2831a();
        }
    }

    /* renamed from: b */
    private void m4432b(long j) {
        int i = 0;
        while (i < this.f2993d.size()) {
            C1102c cVar = this.f2993d.get(i);
            if (cVar.f3001d != null) {
                m4430a(cVar, j);
                cVar.mo5872a();
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5863a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f2991b == 0) {
            this.f2991b = recyclerView.mo5344k();
            recyclerView.post(this);
        }
        recyclerView.f2709h0.mo5871b(i, i2);
    }

    /* renamed from: a */
    private void m4428a() {
        C1102c cVar;
        int size = this.f2990a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f2990a.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f2709h0.mo5869a(recyclerView, false);
                i += recyclerView.f2709h0.f2997d;
            }
        }
        this.f2993d.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f2990a.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                C1101b bVar = recyclerView2.f2709h0;
                int abs = Math.abs(bVar.f2994a) + Math.abs(bVar.f2995b);
                for (int i5 = 0; i5 < bVar.f2997d * 2; i5 += 2) {
                    if (i3 >= this.f2993d.size()) {
                        cVar = new C1102c();
                        this.f2993d.add(cVar);
                    } else {
                        cVar = this.f2993d.get(i3);
                    }
                    int i6 = bVar.f2996c[i5 + 1];
                    cVar.f2998a = i6 <= abs;
                    cVar.f2999b = abs;
                    cVar.f3000c = i6;
                    cVar.f3001d = recyclerView2;
                    cVar.f3002e = bVar.f2996c[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.f2993d, f2989f);
    }

    @SuppressLint({"VisibleForTests"})
    /* renamed from: androidx.recyclerview.widget.e$b */
    /* compiled from: GapWorker */
    static class C1101b implements RecyclerView.C1054o.C1057c {

        /* renamed from: a */
        int f2994a;

        /* renamed from: b */
        int f2995b;

        /* renamed from: c */
        int[] f2996c;

        /* renamed from: d */
        int f2997d;

        C1101b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5869a(RecyclerView recyclerView, boolean z) {
            this.f2997d = 0;
            int[] iArr = this.f2996c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.C1054o oVar = recyclerView.f2718m;
            if (recyclerView.f2716l != null && oVar != null && oVar.mo5623v()) {
                if (z) {
                    if (!recyclerView.f2700d.mo5788c()) {
                        oVar.mo5204a(recyclerView.f2716l.getItemCount(), (RecyclerView.C1054o.C1057c) this);
                    }
                } else if (!recyclerView.mo5346m()) {
                    oVar.mo5203a(this.f2994a, this.f2995b, recyclerView.f2711i0, (RecyclerView.C1054o.C1057c) this);
                }
                int i = this.f2997d;
                if (i > oVar.f2779m) {
                    oVar.f2779m = i;
                    oVar.f2780n = z;
                    recyclerView.f2696b.mo5687j();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5871b(int i, int i2) {
            this.f2994a = i;
            this.f2995b = i2;
        }

        /* renamed from: a */
        public void mo5632a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.f2997d * 2;
                int[] iArr = this.f2996c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f2996c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i3 >= iArr.length) {
                    int[] iArr3 = new int[(i3 * 2)];
                    this.f2996c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f2996c;
                iArr4[i3] = i;
                iArr4[i3 + 1] = i2;
                this.f2997d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5870a(int i) {
            if (this.f2996c != null) {
                int i2 = this.f2997d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f2996c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5868a() {
            int[] iArr = this.f2996c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2997d = 0;
        }
    }

    /* renamed from: a */
    static boolean m4431a(RecyclerView recyclerView, int i) {
        int b = recyclerView.f2702e.mo5804b();
        for (int i2 = 0; i2 < b; i2++) {
            RecyclerView.C1039c0 l = RecyclerView.m3777l(recyclerView.f2702e.mo5810d(i2));
            if (l.mPosition == i && !l.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private RecyclerView.C1039c0 m4427a(RecyclerView recyclerView, int i, long j) {
        if (m4431a(recyclerView, i)) {
            return null;
        }
        RecyclerView.C1066v vVar = recyclerView.f2696b;
        try {
            recyclerView.mo5378t();
            RecyclerView.C1039c0 a = vVar.mo5658a(i, false, j);
            if (a != null) {
                if (!a.isBound() || a.isInvalid()) {
                    vVar.mo5665a(a, false);
                } else {
                    vVar.mo5671b(a.itemView);
                }
            }
            return a;
        } finally {
            recyclerView.mo5267a(false);
        }
    }

    /* renamed from: a */
    private void m4429a(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.f2675D && recyclerView.f2702e.mo5804b() != 0) {
                recyclerView.mo5381w();
            }
            C1101b bVar = recyclerView.f2709h0;
            bVar.mo5869a(recyclerView, true);
            if (bVar.f2997d != 0) {
                try {
                    C0864b.m2832a("RV Nested Prefetch");
                    recyclerView.f2711i0.mo5699a(recyclerView.f2716l);
                    for (int i = 0; i < bVar.f2997d * 2; i += 2) {
                        m4427a(recyclerView, bVar.f2996c[i], j);
                    }
                } finally {
                    C0864b.m2831a();
                }
            }
        }
    }

    /* renamed from: a */
    private void m4430a(C1102c cVar, long j) {
        RecyclerView.C1039c0 a = m4427a(cVar.f3001d, cVar.f3002e, cVar.f2998a ? Long.MAX_VALUE : j);
        if (a != null && a.mNestedRecyclerView != null && a.isBound() && !a.isInvalid()) {
            m4429a((RecyclerView) a.mNestedRecyclerView.get(), j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5861a(long j) {
        m4428a();
        m4432b(j);
    }
}
