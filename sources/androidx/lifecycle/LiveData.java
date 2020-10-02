package androidx.lifecycle;

import androidx.lifecycle.C0965e;
import java.util.Map;
import p075d.p076a.p077a.p078a.C3177a;
import p075d.p076a.p077a.p079b.C3184b;

public abstract class LiveData<T> {

    /* renamed from: j */
    static final Object f2488j = new Object();

    /* renamed from: a */
    final Object f2489a = new Object();

    /* renamed from: b */
    private C3184b<C0978n<? super T>, LiveData<T>.C1155b> f2490b = new C3184b<>();

    /* renamed from: c */
    int f2491c = 0;

    /* renamed from: d */
    private volatile Object f2492d = f2488j;

    /* renamed from: e */
    volatile Object f2493e = f2488j;

    /* renamed from: f */
    private int f2494f = -1;

    /* renamed from: g */
    private boolean f2495g;

    /* renamed from: h */
    private boolean f2496h;

    /* renamed from: i */
    private final Runnable f2497i = new C0957a();

    /* renamed from: androidx.lifecycle.LiveData$a */
    class C0957a implements Runnable {
        C0957a() {
        }

        public void run() {
            Object obj;
            synchronized (LiveData.this.f2489a) {
                obj = LiveData.this.f2493e;
                LiveData.this.f2493e = LiveData.f2488j;
            }
            LiveData.this.mo4973b(obj);
        }
    }

    /* renamed from: androidx.lifecycle.LiveData$b */
    private abstract class C0958b {

        /* renamed from: a */
        final C0978n<? super T> f2501a;

        /* renamed from: b */
        boolean f2502b;

        /* renamed from: c */
        int f2503c = -1;

        C0958b(C0978n<? super T> nVar) {
            this.f2501a = nVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4977a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4981a(boolean z) {
            if (z != this.f2502b) {
                this.f2502b = z;
                int i = 1;
                boolean z2 = LiveData.this.f2491c == 0;
                LiveData liveData = LiveData.this;
                int i2 = liveData.f2491c;
                if (!this.f2502b) {
                    i = -1;
                }
                liveData.f2491c = i2 + i;
                if (z2 && this.f2502b) {
                    LiveData.this.mo4975c();
                }
                LiveData liveData2 = LiveData.this;
                if (liveData2.f2491c == 0 && !this.f2502b) {
                    liveData2.mo4976d();
                }
                if (this.f2502b) {
                    LiveData.this.mo4969a((LiveData<T>.C1155b) this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract boolean mo4978b();

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public boolean mo4979g(C0970h hVar) {
            return false;
        }
    }

    /* renamed from: b */
    private void m3418b(LiveData<T>.C1155b bVar) {
        if (bVar.f2502b) {
            if (!bVar.mo4978b()) {
                bVar.mo4981a(false);
                return;
            }
            int i = bVar.f2503c;
            int i2 = this.f2494f;
            if (i < i2) {
                bVar.f2503c = i2;
                bVar.f2501a.mo5003a(this.f2492d);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4969a(LiveData<T>.C1155b bVar) {
        if (this.f2495g) {
            this.f2496h = true;
            return;
        }
        this.f2495g = true;
        do {
            this.f2496h = false;
            if (bVar == null) {
                C3184b<K, V>.d c = this.f2490b.mo18652c();
                while (c.hasNext()) {
                    m3418b((LiveData<T>.C1155b) (C0958b) ((Map.Entry) c.next()).getValue());
                    if (this.f2496h) {
                        break;
                    }
                }
            } else {
                m3418b(bVar);
                bVar = null;
            }
        } while (this.f2496h);
        this.f2495g = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo4975c() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo4976d() {
    }

    class LifecycleBoundObserver extends LiveData<T>.C1155b implements C0964d {

        /* renamed from: e */
        final C0970h f2498e;

        LifecycleBoundObserver(C0970h hVar, C0978n<? super T> nVar) {
            super(nVar);
            this.f2498e = hVar;
        }

        /* renamed from: a */
        public void mo1895a(C0970h hVar, C0965e.C0966a aVar) {
            if (this.f2498e.getLifecycle().mo4995a() == C0965e.C0967b.DESTROYED) {
                LiveData.this.mo4971a(this.f2501a);
            } else {
                mo4981a(mo4978b());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo4978b() {
            return this.f2498e.getLifecycle().mo4995a().mo4998a(C0965e.C0967b.STARTED);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public boolean mo4979g(C0970h hVar) {
            return this.f2498e == hVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo4977a() {
            this.f2498e.getLifecycle().mo4997b(this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4973b(T t) {
        m3417a("setValue");
        this.f2494f++;
        this.f2492d = t;
        mo4969a((LiveData<T>.C1155b) null);
    }

    /* renamed from: b */
    public boolean mo4974b() {
        return this.f2491c > 0;
    }

    /* renamed from: a */
    public void mo4970a(C0970h hVar, C0978n<? super T> nVar) {
        m3417a("observe");
        if (hVar.getLifecycle().mo4995a() != C0965e.C0967b.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(hVar, nVar);
            C0958b b = this.f2490b.mo18645b(nVar, lifecycleBoundObserver);
            if (b != null && !b.mo4979g(hVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (b == null) {
                hVar.getLifecycle().mo4996a(lifecycleBoundObserver);
            }
        }
    }

    /* renamed from: a */
    public void mo4971a(C0978n<? super T> nVar) {
        m3417a("removeObserver");
        C0958b remove = this.f2490b.remove(nVar);
        if (remove != null) {
            remove.mo4977a();
            remove.mo4981a(false);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4972a(T t) {
        boolean z;
        synchronized (this.f2489a) {
            z = this.f2493e == f2488j;
            this.f2493e = t;
        }
        if (z) {
            C3177a.m10473b().mo18640b(this.f2497i);
        }
    }

    /* renamed from: a */
    public T mo4968a() {
        T t = this.f2492d;
        if (t != f2488j) {
            return t;
        }
        return null;
    }

    /* renamed from: a */
    private static void m3417a(String str) {
        if (!C3177a.m10473b().mo18639a()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background" + " thread");
        }
    }
}
