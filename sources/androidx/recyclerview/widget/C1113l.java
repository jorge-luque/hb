package androidx.recyclerview.widget;

import android.view.View;

/* renamed from: androidx.recyclerview.widget.l */
/* compiled from: ViewBoundsCheck */
class C1113l {

    /* renamed from: a */
    final C1115b f3021a;

    /* renamed from: b */
    C1114a f3022b = new C1114a();

    /* renamed from: androidx.recyclerview.widget.l$b */
    /* compiled from: ViewBoundsCheck */
    interface C1115b {
        /* renamed from: a */
        int mo5627a();

        /* renamed from: a */
        int mo5628a(View view);

        /* renamed from: a */
        View mo5629a(int i);

        /* renamed from: b */
        int mo5630b();

        /* renamed from: b */
        int mo5631b(View view);
    }

    C1113l(C1115b bVar) {
        this.f3021a = bVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo5915a(int i, int i2, int i3, int i4) {
        int a = this.f3021a.mo5627a();
        int b = this.f3021a.mo5630b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a2 = this.f3021a.mo5629a(i);
            this.f3022b.mo5919a(a, b, this.f3021a.mo5628a(a2), this.f3021a.mo5631b(a2));
            if (i3 != 0) {
                this.f3022b.mo5921b();
                this.f3022b.mo5918a(i3);
                if (this.f3022b.mo5920a()) {
                    return a2;
                }
            }
            if (i4 != 0) {
                this.f3022b.mo5921b();
                this.f3022b.mo5918a(i4);
                if (this.f3022b.mo5920a()) {
                    view = a2;
                }
            }
            i += i5;
        }
        return view;
    }

    /* renamed from: androidx.recyclerview.widget.l$a */
    /* compiled from: ViewBoundsCheck */
    static class C1114a {

        /* renamed from: a */
        int f3023a = 0;

        /* renamed from: b */
        int f3024b;

        /* renamed from: c */
        int f3025c;

        /* renamed from: d */
        int f3026d;

        /* renamed from: e */
        int f3027e;

        C1114a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo5917a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5919a(int i, int i2, int i3, int i4) {
            this.f3024b = i;
            this.f3025c = i2;
            this.f3026d = i3;
            this.f3027e = i4;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo5921b() {
            this.f3023a = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5918a(int i) {
            this.f3023a = i | this.f3023a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo5920a() {
            int i = this.f3023a;
            if ((i & 7) != 0 && (i & (mo5917a(this.f3026d, this.f3024b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f3023a;
            if ((i2 & 112) != 0 && (i2 & (mo5917a(this.f3026d, this.f3025c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f3023a;
            if ((i3 & 1792) != 0 && (i3 & (mo5917a(this.f3027e, this.f3024b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f3023a;
            if ((i4 & 28672) == 0 || (i4 & (mo5917a(this.f3027e, this.f3025c) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5916a(View view, int i) {
        this.f3022b.mo5919a(this.f3021a.mo5627a(), this.f3021a.mo5630b(), this.f3021a.mo5628a(view), this.f3021a.mo5631b(view));
        if (i == 0) {
            return false;
        }
        this.f3022b.mo5921b();
        this.f3022b.mo5918a(i);
        return this.f3022b.mo5920a();
    }
}
