package androidx.lifecycle;

import androidx.lifecycle.C0965e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p075d.p076a.p077a.p079b.C3183a;
import p075d.p076a.p077a.p079b.C3184b;

/* renamed from: androidx.lifecycle.i */
/* compiled from: LifecycleRegistry */
public class C0971i extends C0965e {

    /* renamed from: a */
    private C3183a<C0969g, C0973b> f2521a = new C3183a<>();

    /* renamed from: b */
    private C0965e.C0967b f2522b;

    /* renamed from: c */
    private final WeakReference<C0970h> f2523c;

    /* renamed from: d */
    private int f2524d = 0;

    /* renamed from: e */
    private boolean f2525e = false;

    /* renamed from: f */
    private boolean f2526f = false;

    /* renamed from: g */
    private ArrayList<C0965e.C0967b> f2527g = new ArrayList<>();

    /* renamed from: androidx.lifecycle.i$a */
    /* compiled from: LifecycleRegistry */
    static /* synthetic */ class C0972a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2528a;

        /* renamed from: b */
        static final /* synthetic */ int[] f2529b;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0063 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0077 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0082 */
        static {
            /*
                androidx.lifecycle.e$b[] r0 = androidx.lifecycle.C0965e.C0967b.m3457a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2529b = r0
                r1 = 1
                androidx.lifecycle.e$b r2 = androidx.lifecycle.C0965e.C0967b.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f2529b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.e$b r3 = androidx.lifecycle.C0965e.C0967b.CREATED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f2529b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.e$b r4 = androidx.lifecycle.C0965e.C0967b.STARTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f2529b     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.e$b r5 = androidx.lifecycle.C0965e.C0967b.RESUMED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f2529b     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.lifecycle.e$b r6 = androidx.lifecycle.C0965e.C0967b.DESTROYED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                androidx.lifecycle.e$a[] r5 = androidx.lifecycle.C0965e.C0966a.m3456a()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f2528a = r5
                androidx.lifecycle.e$a r6 = androidx.lifecycle.C0965e.C0966a.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x004f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = f2528a     // Catch:{ NoSuchFieldError -> 0x0059 }
                androidx.lifecycle.e$a r5 = androidx.lifecycle.C0965e.C0966a.ON_STOP     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f2528a     // Catch:{ NoSuchFieldError -> 0x0063 }
                androidx.lifecycle.e$a r1 = androidx.lifecycle.C0965e.C0966a.ON_START     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = f2528a     // Catch:{ NoSuchFieldError -> 0x006d }
                androidx.lifecycle.e$a r1 = androidx.lifecycle.C0965e.C0966a.ON_PAUSE     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f2528a     // Catch:{ NoSuchFieldError -> 0x0077 }
                androidx.lifecycle.e$a r1 = androidx.lifecycle.C0965e.C0966a.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x0077 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0077 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0077 }
            L_0x0077:
                int[] r0 = f2528a     // Catch:{ NoSuchFieldError -> 0x0082 }
                androidx.lifecycle.e$a r1 = androidx.lifecycle.C0965e.C0966a.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                int[] r0 = f2528a     // Catch:{ NoSuchFieldError -> 0x008d }
                androidx.lifecycle.e$a r1 = androidx.lifecycle.C0965e.C0966a.ON_ANY     // Catch:{ NoSuchFieldError -> 0x008d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008d }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008d }
            L_0x008d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.C0971i.C0972a.<clinit>():void");
        }
    }

    /* renamed from: androidx.lifecycle.i$b */
    /* compiled from: LifecycleRegistry */
    static class C0973b {

        /* renamed from: a */
        C0965e.C0967b f2530a;

        /* renamed from: b */
        C0968f f2531b;

        C0973b(C0969g gVar, C0965e.C0967b bVar) {
            this.f2531b = C0975k.m3480a((Object) gVar);
            this.f2530a = bVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5002a(C0970h hVar, C0965e.C0966a aVar) {
            C0965e.C0967b b = C0971i.m3462b(aVar);
            this.f2530a = C0971i.m3460a(this.f2530a, b);
            this.f2531b.mo1895a(hVar, aVar);
            this.f2530a = b;
        }
    }

    public C0971i(C0970h hVar) {
        this.f2523c = new WeakReference<>(hVar);
        this.f2522b = C0965e.C0967b.INITIALIZED;
    }

    /* renamed from: c */
    private C0965e.C0967b m3466c(C0969g gVar) {
        Map.Entry<C0969g, C0973b> b = this.f2521a.mo18646b(gVar);
        C0965e.C0967b bVar = null;
        C0965e.C0967b bVar2 = b != null ? b.getValue().f2530a : null;
        if (!this.f2527g.isEmpty()) {
            ArrayList<C0965e.C0967b> arrayList = this.f2527g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return m3460a(m3460a(this.f2522b, bVar2), bVar);
    }

    /* renamed from: d */
    private void m3469d(C0965e.C0967b bVar) {
        if (this.f2522b != bVar) {
            this.f2522b = bVar;
            if (this.f2525e || this.f2524d != 0) {
                this.f2526f = true;
                return;
            }
            this.f2525e = true;
            m3468d();
            this.f2525e = false;
        }
    }

    /* renamed from: e */
    private void m3470e(C0965e.C0967b bVar) {
        this.f2527g.add(bVar);
    }

    /* renamed from: f */
    private static C0965e.C0966a m3471f(C0965e.C0967b bVar) {
        int i = C0972a.f2529b[bVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return C0965e.C0966a.ON_START;
            }
            if (i == 3) {
                return C0965e.C0966a.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            } else if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return C0965e.C0966a.ON_CREATE;
    }

    @Deprecated
    /* renamed from: a */
    public void mo5000a(C0965e.C0967b bVar) {
        mo5001b(bVar);
    }

    /* renamed from: b */
    public void mo5001b(C0965e.C0967b bVar) {
        m3469d(bVar);
    }

    /* renamed from: b */
    private boolean m3464b() {
        if (this.f2521a.size() == 0) {
            return true;
        }
        C0965e.C0967b bVar = this.f2521a.mo18651b().getValue().f2530a;
        C0965e.C0967b bVar2 = this.f2521a.mo18653d().getValue().f2530a;
        if (bVar == bVar2 && this.f2522b == bVar2) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo4999a(C0965e.C0966a aVar) {
        m3469d(m3462b(aVar));
    }

    /* renamed from: a */
    public void mo4996a(C0969g gVar) {
        C0970h hVar;
        C0965e.C0967b bVar = this.f2522b;
        C0965e.C0967b bVar2 = C0965e.C0967b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = C0965e.C0967b.INITIALIZED;
        }
        C0973b bVar3 = new C0973b(gVar, bVar2);
        if (this.f2521a.mo18645b(gVar, bVar3) == null && (hVar = (C0970h) this.f2523c.get()) != null) {
            boolean z = this.f2524d != 0 || this.f2525e;
            C0965e.C0967b c = m3466c(gVar);
            this.f2524d++;
            while (bVar3.f2530a.compareTo(c) < 0 && this.f2521a.contains(gVar)) {
                m3470e(bVar3.f2530a);
                bVar3.mo5002a(hVar, m3471f(bVar3.f2530a));
                m3467c();
                c = m3466c(gVar);
            }
            if (!z) {
                m3468d();
            }
            this.f2524d--;
        }
    }

    /* renamed from: c */
    private void m3467c() {
        ArrayList<C0965e.C0967b> arrayList = this.f2527g;
        arrayList.remove(arrayList.size() - 1);
    }

    /* renamed from: c */
    private static C0965e.C0966a m3465c(C0965e.C0967b bVar) {
        int i = C0972a.f2529b[bVar.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException();
        } else if (i == 2) {
            return C0965e.C0966a.ON_DESTROY;
        } else {
            if (i == 3) {
                return C0965e.C0966a.ON_STOP;
            }
            if (i == 4) {
                return C0965e.C0966a.ON_PAUSE;
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: b */
    public void mo4997b(C0969g gVar) {
        this.f2521a.remove(gVar);
    }

    /* renamed from: b */
    static C0965e.C0967b m3462b(C0965e.C0966a aVar) {
        switch (C0972a.f2528a[aVar.ordinal()]) {
            case 1:
            case 2:
                return C0965e.C0967b.CREATED;
            case 3:
            case 4:
                return C0965e.C0967b.STARTED;
            case 5:
                return C0965e.C0967b.RESUMED;
            case 6:
                return C0965e.C0967b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    /* renamed from: d */
    private void m3468d() {
        C0970h hVar = (C0970h) this.f2523c.get();
        if (hVar != null) {
            while (!m3464b()) {
                this.f2526f = false;
                if (this.f2522b.compareTo(this.f2521a.mo18651b().getValue().f2530a) < 0) {
                    m3461a(hVar);
                }
                Map.Entry<C0969g, C0973b> d = this.f2521a.mo18653d();
                if (!this.f2526f && d != null && this.f2522b.compareTo(d.getValue().f2530a) > 0) {
                    m3463b(hVar);
                }
            }
            this.f2526f = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    /* renamed from: b */
    private void m3463b(C0970h hVar) {
        C3184b<K, V>.d c = this.f2521a.mo18652c();
        while (c.hasNext() && !this.f2526f) {
            Map.Entry entry = (Map.Entry) c.next();
            C0973b bVar = (C0973b) entry.getValue();
            while (bVar.f2530a.compareTo(this.f2522b) < 0 && !this.f2526f && this.f2521a.contains(entry.getKey())) {
                m3470e(bVar.f2530a);
                bVar.mo5002a(hVar, m3471f(bVar.f2530a));
                m3467c();
            }
        }
    }

    /* renamed from: a */
    public C0965e.C0967b mo4995a() {
        return this.f2522b;
    }

    /* renamed from: a */
    private void m3461a(C0970h hVar) {
        Iterator<Map.Entry<C0969g, C0973b>> a = this.f2521a.mo18650a();
        while (a.hasNext() && !this.f2526f) {
            Map.Entry next = a.next();
            C0973b bVar = (C0973b) next.getValue();
            while (bVar.f2530a.compareTo(this.f2522b) > 0 && !this.f2526f && this.f2521a.contains(next.getKey())) {
                C0965e.C0966a c = m3465c(bVar.f2530a);
                m3470e(m3462b(c));
                bVar.mo5002a(hVar, c);
                m3467c();
            }
        }
    }

    /* renamed from: a */
    static C0965e.C0967b m3460a(C0965e.C0967b bVar, C0965e.C0967b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }
}
