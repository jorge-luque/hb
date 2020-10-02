package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.b */
/* compiled from: ChildHelper */
class C1080b {

    /* renamed from: a */
    final C1082b f2896a;

    /* renamed from: b */
    final C1081a f2897b = new C1081a();

    /* renamed from: c */
    final List<View> f2898c = new ArrayList();

    /* renamed from: androidx.recyclerview.widget.b$b */
    /* compiled from: ChildHelper */
    interface C1082b {
        /* renamed from: a */
        int mo5442a();

        /* renamed from: a */
        View mo5443a(int i);

        /* renamed from: a */
        void mo5444a(View view);

        /* renamed from: a */
        void mo5445a(View view, int i, ViewGroup.LayoutParams layoutParams);

        void addView(View view, int i);

        /* renamed from: b */
        int mo5447b(View view);

        /* renamed from: b */
        void mo5448b();

        /* renamed from: b */
        void mo5449b(int i);

        /* renamed from: c */
        RecyclerView.C1039c0 mo5450c(View view);

        /* renamed from: c */
        void mo5451c(int i);

        /* renamed from: d */
        void mo5452d(View view);
    }

    C1080b(C1082b bVar) {
        this.f2896a = bVar;
    }

    /* renamed from: f */
    private int m4346f(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f2896a.mo5442a();
        int i2 = i;
        while (i2 < a) {
            int b = i - (i2 - this.f2897b.mo5819b(i2));
            if (b == 0) {
                while (this.f2897b.mo5820c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += b;
        }
        return -1;
    }

    /* renamed from: g */
    private void m4347g(View view) {
        this.f2898c.add(view);
        this.f2896a.mo5444a(view);
    }

    /* renamed from: h */
    private boolean m4348h(View view) {
        if (!this.f2898c.remove(view)) {
            return false;
        }
        this.f2896a.mo5452d(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5803a(View view, boolean z) {
        mo5802a(view, -1, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public View mo5806b(int i) {
        int size = this.f2898c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f2898c.get(i2);
            RecyclerView.C1039c0 c = this.f2896a.mo5450c(view);
            if (c.getLayoutPosition() == i && !c.isInvalid() && !c.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public View mo5807c(int i) {
        return this.f2896a.mo5443a(m4346f(i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5811d(View view) {
        int b = this.f2896a.mo5447b(view);
        if (b >= 0) {
            if (this.f2897b.mo5821d(b)) {
                m4348h(view);
            }
            this.f2896a.mo5451c(b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo5812e(int i) {
        int f = m4346f(i);
        View a = this.f2896a.mo5443a(f);
        if (a != null) {
            if (this.f2897b.mo5821d(f)) {
                m4348h(a);
            }
            this.f2896a.mo5451c(f);
        }
    }

    public String toString() {
        return this.f2897b.toString() + ", hidden list:" + this.f2898c.size();
    }

    /* renamed from: androidx.recyclerview.widget.b$a */
    /* compiled from: ChildHelper */
    static class C1081a {

        /* renamed from: a */
        long f2899a = 0;

        /* renamed from: b */
        C1081a f2900b;

        C1081a() {
        }

        /* renamed from: b */
        private void m4366b() {
            if (this.f2900b == null) {
                this.f2900b = new C1081a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5817a(int i) {
            if (i >= 64) {
                C1081a aVar = this.f2900b;
                if (aVar != null) {
                    aVar.mo5817a(i - 64);
                    return;
                }
                return;
            }
            this.f2899a &= (1 << i) ^ -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo5820c(int i) {
            if (i < 64) {
                return (this.f2899a & (1 << i)) != 0;
            }
            m4366b();
            return this.f2900b.mo5820c(i - 64);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo5821d(int i) {
            if (i >= 64) {
                m4366b();
                return this.f2900b.mo5821d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f2899a & j) != 0;
            long j2 = this.f2899a & (j ^ -1);
            this.f2899a = j2;
            long j3 = j - 1;
            this.f2899a = (j2 & j3) | Long.rotateRight((j3 ^ -1) & j2, 1);
            C1081a aVar = this.f2900b;
            if (aVar != null) {
                if (aVar.mo5820c(0)) {
                    mo5822e(63);
                }
                this.f2900b.mo5821d(0);
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo5822e(int i) {
            if (i >= 64) {
                m4366b();
                this.f2900b.mo5822e(i - 64);
                return;
            }
            this.f2899a |= 1 << i;
        }

        public String toString() {
            if (this.f2900b == null) {
                return Long.toBinaryString(this.f2899a);
            }
            return this.f2900b.toString() + "xx" + Long.toBinaryString(this.f2899a);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo5819b(int i) {
            C1081a aVar = this.f2900b;
            if (aVar == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f2899a);
                }
                return Long.bitCount(this.f2899a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f2899a & ((1 << i) - 1));
            } else {
                return aVar.mo5819b(i - 64) + Long.bitCount(this.f2899a);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5816a() {
            this.f2899a = 0;
            C1081a aVar = this.f2900b;
            if (aVar != null) {
                aVar.mo5816a();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5818a(int i, boolean z) {
            if (i >= 64) {
                m4366b();
                this.f2900b.mo5818a(i - 64, z);
                return;
            }
            boolean z2 = (this.f2899a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f2899a;
            this.f2899a = ((j2 & (j ^ -1)) << 1) | (j2 & j);
            if (z) {
                mo5822e(i);
            } else {
                mo5817a(i);
            }
            if (z2 || this.f2900b != null) {
                m4366b();
                this.f2900b.mo5818a(0, z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5802a(View view, int i, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f2896a.mo5442a();
        } else {
            i2 = m4346f(i);
        }
        this.f2897b.mo5818a(i2, z);
        if (z) {
            m4347g(view);
        }
        this.f2896a.addView(view, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5808c() {
        this.f2897b.mo5816a();
        for (int size = this.f2898c.size() - 1; size >= 0; size--) {
            this.f2896a.mo5452d(this.f2898c.get(size));
            this.f2898c.remove(size);
        }
        this.f2896a.mo5448b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo5814f(View view) {
        int b = this.f2896a.mo5447b(view);
        if (b < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f2897b.mo5820c(b)) {
            this.f2897b.mo5817a(b);
            m4348h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public View mo5810d(int i) {
        return this.f2896a.mo5443a(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo5813e(View view) {
        int b = this.f2896a.mo5447b(view);
        if (b == -1) {
            m4348h(view);
            return true;
        } else if (!this.f2897b.mo5820c(b)) {
            return false;
        } else {
            this.f2897b.mo5821d(b);
            m4348h(view);
            this.f2896a.mo5451c(b);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5801a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f2896a.mo5442a();
        } else {
            i2 = m4346f(i);
        }
        this.f2897b.mo5818a(i2, z);
        if (z) {
            m4347g(view);
        }
        this.f2896a.mo5445a(view, i2, layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5804b() {
        return this.f2896a.mo5442a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5805b(View view) {
        int b = this.f2896a.mo5447b(view);
        if (b != -1 && !this.f2897b.mo5820c(b)) {
            return b - this.f2897b.mo5819b(b);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo5809c(View view) {
        return this.f2898c.contains(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5798a() {
        return this.f2896a.mo5442a() - this.f2898c.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5799a(int i) {
        int f = m4346f(i);
        this.f2897b.mo5821d(f);
        this.f2896a.mo5449b(f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5800a(View view) {
        int b = this.f2896a.mo5447b(view);
        if (b >= 0) {
            this.f2897b.mo5822e(b);
            m4347g(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }
}
