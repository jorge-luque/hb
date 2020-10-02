package androidx.recyclerview.widget;

import androidx.core.p019e.C0792e;
import androidx.core.p019e.C0793f;
import androidx.recyclerview.widget.RecyclerView;
import p075d.p080b.C3196d;
import p075d.p080b.C3204g;

/* renamed from: androidx.recyclerview.widget.m */
/* compiled from: ViewInfoStore */
class C1116m {

    /* renamed from: a */
    final C3204g<RecyclerView.C1039c0, C1117a> f3028a = new C3204g<>();

    /* renamed from: b */
    final C3196d<RecyclerView.C1039c0> f3029b = new C3196d<>();

    /* renamed from: androidx.recyclerview.widget.m$b */
    /* compiled from: ViewInfoStore */
    interface C1118b {
        /* renamed from: a */
        void mo5438a(RecyclerView.C1039c0 c0Var);

        /* renamed from: a */
        void mo5439a(RecyclerView.C1039c0 c0Var, RecyclerView.C1048l.C1051c cVar, RecyclerView.C1048l.C1051c cVar2);

        /* renamed from: b */
        void mo5440b(RecyclerView.C1039c0 c0Var, RecyclerView.C1048l.C1051c cVar, RecyclerView.C1048l.C1051c cVar2);

        /* renamed from: c */
        void mo5441c(RecyclerView.C1039c0 c0Var, RecyclerView.C1048l.C1051c cVar, RecyclerView.C1048l.C1051c cVar2);
    }

    C1116m() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5923a() {
        this.f3028a.clear();
        this.f3029b.mo18707a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5930b(RecyclerView.C1039c0 c0Var) {
        C1117a aVar = this.f3028a.get(c0Var);
        if (aVar == null || (aVar.f3031a & 1) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5931c(RecyclerView.C1039c0 c0Var, RecyclerView.C1048l.C1051c cVar) {
        C1117a aVar = this.f3028a.get(c0Var);
        if (aVar == null) {
            aVar = C1117a.m4576b();
            this.f3028a.put(c0Var, aVar);
        }
        aVar.f3032b = cVar;
        aVar.f3031a |= 4;
    }

    /* renamed from: d */
    public void mo5933d(RecyclerView.C1039c0 c0Var) {
        mo5936g(c0Var);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public RecyclerView.C1048l.C1051c mo5934e(RecyclerView.C1039c0 c0Var) {
        return m4557a(c0Var, 8);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public RecyclerView.C1048l.C1051c mo5935f(RecyclerView.C1039c0 c0Var) {
        return m4557a(c0Var, 4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo5936g(RecyclerView.C1039c0 c0Var) {
        C1117a aVar = this.f3028a.get(c0Var);
        if (aVar != null) {
            aVar.f3031a &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo5937h(RecyclerView.C1039c0 c0Var) {
        int b = this.f3029b.mo18710b() - 1;
        while (true) {
            if (b < 0) {
                break;
            } else if (c0Var == this.f3029b.mo18714c(b)) {
                this.f3029b.mo18713b(b);
                break;
            } else {
                b--;
            }
        }
        C1117a remove = this.f3028a.remove(c0Var);
        if (remove != null) {
            C1117a.m4575a(remove);
        }
    }

    /* renamed from: a */
    private RecyclerView.C1048l.C1051c m4557a(RecyclerView.C1039c0 c0Var, int i) {
        C1117a d;
        RecyclerView.C1048l.C1051c cVar;
        int a = this.f3028a.mo18797a((Object) c0Var);
        if (a >= 0 && (d = this.f3028a.mo18808d(a)) != null) {
            int i2 = d.f3031a;
            if ((i2 & i) != 0) {
                d.f3031a = (i ^ -1) & i2;
                if (i == 4) {
                    cVar = d.f3032b;
                } else if (i == 8) {
                    cVar = d.f3033c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((d.f3031a & 12) == 0) {
                    this.f3028a.mo18804c(a);
                    C1117a.m4575a(d);
                }
                return cVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5929b(RecyclerView.C1039c0 c0Var, RecyclerView.C1048l.C1051c cVar) {
        C1117a aVar = this.f3028a.get(c0Var);
        if (aVar == null) {
            aVar = C1117a.m4576b();
            this.f3028a.put(c0Var, aVar);
        }
        aVar.f3033c = cVar;
        aVar.f3031a |= 8;
    }

    /* renamed from: androidx.recyclerview.widget.m$a */
    /* compiled from: ViewInfoStore */
    static class C1117a {

        /* renamed from: d */
        static C0792e<C1117a> f3030d = new C0793f(20);

        /* renamed from: a */
        int f3031a;

        /* renamed from: b */
        RecyclerView.C1048l.C1051c f3032b;

        /* renamed from: c */
        RecyclerView.C1048l.C1051c f3033c;

        private C1117a() {
        }

        /* renamed from: a */
        static void m4575a(C1117a aVar) {
            aVar.f3031a = 0;
            aVar.f3032b = null;
            aVar.f3033c = null;
            f3030d.mo4076a(aVar);
        }

        /* renamed from: b */
        static C1117a m4576b() {
            C1117a a = f3030d.mo4075a();
            return a == null ? new C1117a() : a;
        }

        /* renamed from: a */
        static void m4574a() {
            do {
            } while (f3030d.mo4075a() != null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo5932c(RecyclerView.C1039c0 c0Var) {
        C1117a aVar = this.f3028a.get(c0Var);
        return (aVar == null || (aVar.f3031a & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5928b() {
        C1117a.m4574a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5924a(long j, RecyclerView.C1039c0 c0Var) {
        this.f3029b.mo18716c(j, c0Var);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5926a(RecyclerView.C1039c0 c0Var, RecyclerView.C1048l.C1051c cVar) {
        C1117a aVar = this.f3028a.get(c0Var);
        if (aVar == null) {
            aVar = C1117a.m4576b();
            this.f3028a.put(c0Var, aVar);
        }
        aVar.f3031a |= 2;
        aVar.f3032b = cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public RecyclerView.C1039c0 mo5922a(long j) {
        return this.f3029b.mo18711b(j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5925a(RecyclerView.C1039c0 c0Var) {
        C1117a aVar = this.f3028a.get(c0Var);
        if (aVar == null) {
            aVar = C1117a.m4576b();
            this.f3028a.put(c0Var, aVar);
        }
        aVar.f3031a |= 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5927a(C1118b bVar) {
        for (int size = this.f3028a.size() - 1; size >= 0; size--) {
            RecyclerView.C1039c0 b = this.f3028a.mo18803b(size);
            C1117a c = this.f3028a.mo18804c(size);
            int i = c.f3031a;
            if ((i & 3) == 3) {
                bVar.mo5438a(b);
            } else if ((i & 1) != 0) {
                RecyclerView.C1048l.C1051c cVar = c.f3032b;
                if (cVar == null) {
                    bVar.mo5438a(b);
                } else {
                    bVar.mo5440b(b, cVar, c.f3033c);
                }
            } else if ((i & 14) == 14) {
                bVar.mo5439a(b, c.f3032b, c.f3033c);
            } else if ((i & 12) == 12) {
                bVar.mo5441c(b, c.f3032b, c.f3033c);
            } else if ((i & 4) != 0) {
                bVar.mo5440b(b, c.f3032b, (RecyclerView.C1048l.C1051c) null);
            } else if ((i & 8) != 0) {
                bVar.mo5439a(b, c.f3032b, c.f3033c);
            }
            C1117a.m4575a(c);
        }
    }
}
