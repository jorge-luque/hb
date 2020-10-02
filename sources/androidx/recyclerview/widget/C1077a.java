package androidx.recyclerview.widget;

import androidx.core.p019e.C0792e;
import androidx.core.p019e.C0793f;
import androidx.recyclerview.widget.C1104g;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.a */
/* compiled from: AdapterHelper */
class C1077a implements C1104g.C1105a {

    /* renamed from: a */
    private C0792e<C1079b> f2884a;

    /* renamed from: b */
    final ArrayList<C1079b> f2885b;

    /* renamed from: c */
    final ArrayList<C1079b> f2886c;

    /* renamed from: d */
    final C1078a f2887d;

    /* renamed from: e */
    Runnable f2888e;

    /* renamed from: f */
    final boolean f2889f;

    /* renamed from: g */
    final C1104g f2890g;

    /* renamed from: h */
    private int f2891h;

    /* renamed from: androidx.recyclerview.widget.a$a */
    /* compiled from: AdapterHelper */
    interface C1078a {
        /* renamed from: a */
        RecyclerView.C1039c0 mo5453a(int i);

        /* renamed from: a */
        void mo5454a(int i, int i2);

        /* renamed from: a */
        void mo5455a(int i, int i2, Object obj);

        /* renamed from: a */
        void mo5456a(C1079b bVar);

        /* renamed from: b */
        void mo5457b(int i, int i2);

        /* renamed from: b */
        void mo5458b(C1079b bVar);

        /* renamed from: c */
        void mo5459c(int i, int i2);

        /* renamed from: d */
        void mo5461d(int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.a$b */
    /* compiled from: AdapterHelper */
    static class C1079b {

        /* renamed from: a */
        int f2892a;

        /* renamed from: b */
        int f2893b;

        /* renamed from: c */
        Object f2894c;

        /* renamed from: d */
        int f2895d;

        C1079b(int i, int i2, int i3, Object obj) {
            this.f2892a = i;
            this.f2893b = i2;
            this.f2895d = i3;
            this.f2894c = obj;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo5794a() {
            int i = this.f2892a;
            if (i == 1) {
                return "add";
            }
            if (i == 2) {
                return "rm";
            }
            if (i != 4) {
                return i != 8 ? "??" : "mv";
            }
            return "up";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C1079b.class != obj.getClass()) {
                return false;
            }
            C1079b bVar = (C1079b) obj;
            int i = this.f2892a;
            if (i != bVar.f2892a) {
                return false;
            }
            if (i == 8 && Math.abs(this.f2895d - this.f2893b) == 1 && this.f2895d == bVar.f2893b && this.f2893b == bVar.f2895d) {
                return true;
            }
            if (this.f2895d != bVar.f2895d || this.f2893b != bVar.f2893b) {
                return false;
            }
            Object obj2 = this.f2894c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f2894c)) {
                    return false;
                }
            } else if (bVar.f2894c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f2892a * 31) + this.f2893b) * 31) + this.f2895d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + mo5794a() + ",s:" + this.f2893b + "c:" + this.f2895d + ",p:" + this.f2894c + "]";
        }
    }

    C1077a(C1078a aVar) {
        this(aVar, false);
    }

    /* renamed from: b */
    private void m4311b(C1079b bVar) {
        m4318g(bVar);
    }

    /* renamed from: c */
    private void m4312c(C1079b bVar) {
        m4318g(bVar);
    }

    /* renamed from: d */
    private void m4314d(C1079b bVar) {
        char c;
        boolean z;
        boolean z2;
        int i = bVar.f2893b;
        int i2 = bVar.f2895d + i;
        char c2 = 65535;
        int i3 = i;
        int i4 = 0;
        while (i3 < i2) {
            if (this.f2887d.mo5453a(i3) != null || m4315d(i3)) {
                if (c2 == 0) {
                    m4317f(mo5778a(2, i, i4, (Object) null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    m4318g(mo5778a(2, i, i4, (Object) null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            c2 = c;
        }
        if (i4 != bVar.f2895d) {
            mo5780a(bVar);
            bVar = mo5778a(2, i, i4, (Object) null);
        }
        if (c2 == 0) {
            m4317f(bVar);
        } else {
            m4318g(bVar);
        }
    }

    /* renamed from: g */
    private void m4318g(C1079b bVar) {
        this.f2886c.add(bVar);
        int i = bVar.f2892a;
        if (i == 1) {
            this.f2887d.mo5459c(bVar.f2893b, bVar.f2895d);
        } else if (i == 2) {
            this.f2887d.mo5457b(bVar.f2893b, bVar.f2895d);
        } else if (i == 4) {
            this.f2887d.mo5455a(bVar.f2893b, bVar.f2895d, bVar.f2894c);
        } else if (i == 8) {
            this.f2887d.mo5454a(bVar.f2893b, bVar.f2895d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5779a() {
        int size = this.f2886c.size();
        for (int i = 0; i < size; i++) {
            this.f2887d.mo5458b(this.f2886c.get(i));
        }
        mo5782a((List<C1079b>) this.f2886c);
        this.f2891h = 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo5792e() {
        this.f2890g.mo5876a(this.f2885b);
        int size = this.f2885b.size();
        for (int i = 0; i < size; i++) {
            C1079b bVar = this.f2885b.get(i);
            int i2 = bVar.f2892a;
            if (i2 == 1) {
                m4311b(bVar);
            } else if (i2 == 2) {
                m4314d(bVar);
            } else if (i2 == 4) {
                m4316e(bVar);
            } else if (i2 == 8) {
                m4312c(bVar);
            }
            Runnable runnable = this.f2888e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f2885b.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo5793f() {
        mo5782a((List<C1079b>) this.f2885b);
        mo5782a((List<C1079b>) this.f2886c);
        this.f2891h = 0;
    }

    C1077a(C1078a aVar, boolean z) {
        this.f2884a = new C0793f(30);
        this.f2885b = new ArrayList<>();
        this.f2886c = new ArrayList<>();
        this.f2891h = 0;
        this.f2887d = aVar;
        this.f2889f = z;
        this.f2890g = new C1104g(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5785b(int i) {
        return mo5777a(i, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo5788c() {
        return this.f2885b.size() > 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5787b(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f2885b.add(mo5778a(1, i, i2, (Object) null));
        this.f2891h |= 1;
        if (this.f2885b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo5789c(int i) {
        return (i & this.f2891h) != 0;
    }

    /* renamed from: f */
    private void m4317f(C1079b bVar) {
        int i;
        int i2 = bVar.f2892a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int d = m4313d(bVar.f2893b, i2);
        int i3 = bVar.f2893b;
        int i4 = bVar.f2892a;
        if (i4 == 2) {
            i = 0;
        } else if (i4 == 4) {
            i = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i5 = 1;
        for (int i6 = 1; i6 < bVar.f2895d; i6++) {
            int d2 = m4313d(bVar.f2893b + (i * i6), bVar.f2892a);
            int i7 = bVar.f2892a;
            if (i7 == 2 ? d2 == d : i7 == 4 && d2 == d + 1) {
                i5++;
            } else {
                C1079b a = mo5778a(bVar.f2892a, d, i5, bVar.f2894c);
                mo5781a(a, i3);
                mo5780a(a);
                if (bVar.f2892a == 4) {
                    i3 += i5;
                }
                d = d2;
                i5 = 1;
            }
        }
        Object obj = bVar.f2894c;
        mo5780a(bVar);
        if (i5 > 0) {
            C1079b a2 = mo5778a(bVar.f2892a, d, i5, obj);
            mo5781a(a2, i3);
            mo5780a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo5790c(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f2885b.add(mo5778a(2, i, i2, (Object) null));
        this.f2891h |= 2;
        if (this.f2885b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5781a(C1079b bVar, int i) {
        this.f2887d.mo5456a(bVar);
        int i2 = bVar.f2892a;
        if (i2 == 2) {
            this.f2887d.mo5461d(i, bVar.f2895d);
        } else if (i2 == 4) {
            this.f2887d.mo5455a(i, bVar.f2895d, bVar.f2894c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5786b() {
        mo5779a();
        int size = this.f2885b.size();
        for (int i = 0; i < size; i++) {
            C1079b bVar = this.f2885b.get(i);
            int i2 = bVar.f2892a;
            if (i2 == 1) {
                this.f2887d.mo5458b(bVar);
                this.f2887d.mo5459c(bVar.f2893b, bVar.f2895d);
            } else if (i2 == 2) {
                this.f2887d.mo5458b(bVar);
                this.f2887d.mo5461d(bVar.f2893b, bVar.f2895d);
            } else if (i2 == 4) {
                this.f2887d.mo5458b(bVar);
                this.f2887d.mo5455a(bVar.f2893b, bVar.f2895d, bVar.f2894c);
            } else if (i2 == 8) {
                this.f2887d.mo5458b(bVar);
                this.f2887d.mo5454a(bVar.f2893b, bVar.f2895d);
            }
            Runnable runnable = this.f2888e;
            if (runnable != null) {
                runnable.run();
            }
        }
        mo5782a((List<C1079b>) this.f2885b);
        this.f2891h = 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5777a(int i, int i2) {
        int size = this.f2886c.size();
        while (i2 < size) {
            C1079b bVar = this.f2886c.get(i2);
            int i3 = bVar.f2892a;
            if (i3 == 8) {
                int i4 = bVar.f2893b;
                if (i4 == i) {
                    i = bVar.f2895d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.f2895d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bVar.f2893b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bVar.f2895d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bVar.f2895d;
                }
            }
            i2++;
        }
        return i;
    }

    /* renamed from: e */
    private void m4316e(C1079b bVar) {
        int i = bVar.f2893b;
        int i2 = bVar.f2895d + i;
        int i3 = i;
        char c = 65535;
        int i4 = 0;
        while (i < i2) {
            if (this.f2887d.mo5453a(i) != null || m4315d(i)) {
                if (c == 0) {
                    m4317f(mo5778a(4, i3, i4, bVar.f2894c));
                    i3 = i;
                    i4 = 0;
                }
                c = 1;
            } else {
                if (c == 1) {
                    m4318g(mo5778a(4, i3, i4, bVar.f2894c));
                    i3 = i;
                    i4 = 0;
                }
                c = 0;
            }
            i4++;
            i++;
        }
        if (i4 != bVar.f2895d) {
            Object obj = bVar.f2894c;
            mo5780a(bVar);
            bVar = mo5778a(4, i3, i4, obj);
        }
        if (c == 0) {
            m4317f(bVar);
        } else {
            m4318g(bVar);
        }
    }

    /* renamed from: d */
    private int m4313d(int i, int i2) {
        for (int size = this.f2886c.size() - 1; size >= 0; size--) {
            C1079b bVar = this.f2886c.get(size);
            int i3 = bVar.f2892a;
            if (i3 == 8) {
                int i4 = bVar.f2893b;
                int i5 = bVar.f2895d;
                if (i4 >= i5) {
                    int i6 = i5;
                    i5 = i4;
                    i4 = i6;
                }
                if (i < i4 || i > i5) {
                    int i7 = bVar.f2893b;
                    if (i < i7) {
                        if (i2 == 1) {
                            bVar.f2893b = i7 + 1;
                            bVar.f2895d++;
                        } else if (i2 == 2) {
                            bVar.f2893b = i7 - 1;
                            bVar.f2895d--;
                        }
                    }
                } else {
                    int i8 = bVar.f2893b;
                    if (i4 == i8) {
                        if (i2 == 1) {
                            bVar.f2895d++;
                        } else if (i2 == 2) {
                            bVar.f2895d--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            bVar.f2893b = i8 + 1;
                        } else if (i2 == 2) {
                            bVar.f2893b = i8 - 1;
                        }
                        i--;
                    }
                }
            } else {
                int i9 = bVar.f2893b;
                if (i9 <= i) {
                    if (i3 == 1) {
                        i -= bVar.f2895d;
                    } else if (i3 == 2) {
                        i += bVar.f2895d;
                    }
                } else if (i2 == 1) {
                    bVar.f2893b = i9 + 1;
                } else if (i2 == 2) {
                    bVar.f2893b = i9 - 1;
                }
            }
        }
        for (int size2 = this.f2886c.size() - 1; size2 >= 0; size2--) {
            C1079b bVar2 = this.f2886c.get(size2);
            if (bVar2.f2892a == 8) {
                int i10 = bVar2.f2895d;
                if (i10 == bVar2.f2893b || i10 < 0) {
                    this.f2886c.remove(size2);
                    mo5780a(bVar2);
                }
            } else if (bVar2.f2895d <= 0) {
                this.f2886c.remove(size2);
                mo5780a(bVar2);
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5784a(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f2885b.add(mo5778a(4, i, i2, obj));
        this.f2891h |= 4;
        if (this.f2885b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5783a(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 == 1) {
            this.f2885b.add(mo5778a(8, i, i2, (Object) null));
            this.f2891h |= 8;
            if (this.f2885b.size() == 1) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* renamed from: a */
    public int mo5776a(int i) {
        int size = this.f2885b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1079b bVar = this.f2885b.get(i2);
            int i3 = bVar.f2892a;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = bVar.f2893b;
                    if (i4 <= i) {
                        int i5 = bVar.f2895d;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = bVar.f2893b;
                    if (i6 == i) {
                        i = bVar.f2895d;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (bVar.f2895d <= i) {
                            i++;
                        }
                    }
                }
            } else if (bVar.f2893b <= i) {
                i += bVar.f2895d;
            }
        }
        return i;
    }

    /* renamed from: a */
    public C1079b mo5778a(int i, int i2, int i3, Object obj) {
        C1079b a = this.f2884a.mo4075a();
        if (a == null) {
            return new C1079b(i, i2, i3, obj);
        }
        a.f2892a = i;
        a.f2893b = i2;
        a.f2895d = i3;
        a.f2894c = obj;
        return a;
    }

    /* renamed from: d */
    private boolean m4315d(int i) {
        int size = this.f2886c.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1079b bVar = this.f2886c.get(i2);
            int i3 = bVar.f2892a;
            if (i3 == 8) {
                if (mo5777a(bVar.f2895d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bVar.f2893b;
                int i5 = bVar.f2895d + i4;
                while (i4 < i5) {
                    if (mo5777a(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo5780a(C1079b bVar) {
        if (!this.f2889f) {
            bVar.f2894c = null;
            this.f2884a.mo4076a(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5782a(List<C1079b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo5780a(list.get(i));
        }
        list.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo5791d() {
        return !this.f2886c.isEmpty() && !this.f2885b.isEmpty();
    }
}
