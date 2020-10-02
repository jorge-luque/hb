package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.C6637g;
import p113i.p114e0.C3500c;
import p113i.p114e0.C5927b;
import p113i.p114e0.p117i.C3521f;
import p119j.C3577c;
import p119j.C3579d;
import p119j.C3580e;
import p119j.C3581f;

/* renamed from: okhttp3.internal.http2.f */
/* compiled from: Http2Connection */
public final class C6624f implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: u */
    public static final ExecutorService f17370u = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C3500c.m11646a("OkHttp Http2Connection", true));

    /* renamed from: a */
    final boolean f17371a;

    /* renamed from: b */
    final C3590h f17372b;

    /* renamed from: c */
    final Map<Integer, C3592h> f17373c = new LinkedHashMap();

    /* renamed from: d */
    final String f17374d;

    /* renamed from: e */
    int f17375e;

    /* renamed from: f */
    int f17376f;

    /* renamed from: g */
    boolean f17377g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final ScheduledExecutorService f17378h;

    /* renamed from: i */
    private final ExecutorService f17379i;

    /* renamed from: j */
    final C6643k f17380j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f17381k;

    /* renamed from: l */
    long f17382l = 0;

    /* renamed from: m */
    long f17383m;

    /* renamed from: n */
    C6645l f17384n = new C6645l();

    /* renamed from: o */
    final C6645l f17385o = new C6645l();

    /* renamed from: p */
    boolean f17386p = false;

    /* renamed from: q */
    final Socket f17387q;

    /* renamed from: r */
    final C6640i f17388r;

    /* renamed from: s */
    final C6633j f17389s;

    /* renamed from: t */
    final Set<Integer> f17390t = new LinkedHashSet();

    /* renamed from: okhttp3.internal.http2.f$h */
    /* compiled from: Http2Connection */
    public static abstract class C3590h {

        /* renamed from: a */
        public static final C3590h f10067a = new C3591a();

        /* renamed from: okhttp3.internal.http2.f$h$a */
        /* compiled from: Http2Connection */
        class C3591a extends C3590h {
            C3591a() {
            }

            /* renamed from: a */
            public void mo19783a(C3592h hVar) throws IOException {
                hVar.mo19796a(C6615a.REFUSED_STREAM);
            }
        }

        /* renamed from: a */
        public void mo19782a(C6624f fVar) {
        }

        /* renamed from: a */
        public abstract void mo19783a(C3592h hVar) throws IOException;
    }

    /* renamed from: okhttp3.internal.http2.f$a */
    /* compiled from: Http2Connection */
    class C6625a extends C5927b {

        /* renamed from: b */
        final /* synthetic */ int f17391b;

        /* renamed from: c */
        final /* synthetic */ C6615a f17392c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C6625a(String str, Object[] objArr, int i, C6615a aVar) {
            super(str, objArr);
            this.f17391b = i;
            this.f17392c = aVar;
        }

        /* renamed from: b */
        public void mo19596b() {
            try {
                C6624f.this.mo35695b(this.f17391b, this.f17392c);
            } catch (IOException unused) {
                C6624f.this.m21790w();
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.f$b */
    /* compiled from: Http2Connection */
    class C6626b extends C5927b {

        /* renamed from: b */
        final /* synthetic */ int f17394b;

        /* renamed from: c */
        final /* synthetic */ long f17395c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C6626b(String str, Object[] objArr, int i, long j) {
            super(str, objArr);
            this.f17394b = i;
            this.f17395c = j;
        }

        /* renamed from: b */
        public void mo19596b() {
            try {
                C6624f.this.f17388r.mo35725a(this.f17394b, this.f17395c);
            } catch (IOException unused) {
                C6624f.this.m21790w();
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.f$c */
    /* compiled from: Http2Connection */
    class C6627c extends C5927b {

        /* renamed from: b */
        final /* synthetic */ int f17397b;

        /* renamed from: c */
        final /* synthetic */ List f17398c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C6627c(String str, Object[] objArr, int i, List list) {
            super(str, objArr);
            this.f17397b = i;
            this.f17398c = list;
        }

        /* renamed from: b */
        public void mo19596b() {
            if (C6624f.this.f17380j.mo35743a(this.f17397b, (List<C6616b>) this.f17398c)) {
                try {
                    C6624f.this.f17388r.mo35726a(this.f17397b, C6615a.CANCEL);
                    synchronized (C6624f.this) {
                        C6624f.this.f17390t.remove(Integer.valueOf(this.f17397b));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.f$d */
    /* compiled from: Http2Connection */
    class C6628d extends C5927b {

        /* renamed from: b */
        final /* synthetic */ int f17400b;

        /* renamed from: c */
        final /* synthetic */ List f17401c;

        /* renamed from: d */
        final /* synthetic */ boolean f17402d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C6628d(String str, Object[] objArr, int i, List list, boolean z) {
            super(str, objArr);
            this.f17400b = i;
            this.f17401c = list;
            this.f17402d = z;
        }

        /* renamed from: b */
        public void mo19596b() {
            boolean a = C6624f.this.f17380j.mo35744a(this.f17400b, this.f17401c, this.f17402d);
            if (a) {
                try {
                    C6624f.this.f17388r.mo35726a(this.f17400b, C6615a.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (a || this.f17402d) {
                synchronized (C6624f.this) {
                    C6624f.this.f17390t.remove(Integer.valueOf(this.f17400b));
                }
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.f$e */
    /* compiled from: Http2Connection */
    class C6629e extends C5927b {

        /* renamed from: b */
        final /* synthetic */ int f17404b;

        /* renamed from: c */
        final /* synthetic */ C3577c f17405c;

        /* renamed from: d */
        final /* synthetic */ int f17406d;

        /* renamed from: e */
        final /* synthetic */ boolean f17407e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C6629e(String str, Object[] objArr, int i, C3577c cVar, int i2, boolean z) {
            super(str, objArr);
            this.f17404b = i;
            this.f17405c = cVar;
            this.f17406d = i2;
            this.f17407e = z;
        }

        /* renamed from: b */
        public void mo19596b() {
            try {
                boolean a = C6624f.this.f17380j.mo35742a(this.f17404b, this.f17405c, this.f17406d, this.f17407e);
                if (a) {
                    C6624f.this.f17388r.mo35726a(this.f17404b, C6615a.CANCEL);
                }
                if (a || this.f17407e) {
                    synchronized (C6624f.this) {
                        C6624f.this.f17390t.remove(Integer.valueOf(this.f17404b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.f$f */
    /* compiled from: Http2Connection */
    class C6630f extends C5927b {

        /* renamed from: b */
        final /* synthetic */ int f17409b;

        /* renamed from: c */
        final /* synthetic */ C6615a f17410c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C6630f(String str, Object[] objArr, int i, C6615a aVar) {
            super(str, objArr);
            this.f17409b = i;
            this.f17410c = aVar;
        }

        /* renamed from: b */
        public void mo19596b() {
            C6624f.this.f17380j.mo35741a(this.f17409b, this.f17410c);
            synchronized (C6624f.this) {
                C6624f.this.f17390t.remove(Integer.valueOf(this.f17409b));
            }
        }
    }

    /* renamed from: okhttp3.internal.http2.f$i */
    /* compiled from: Http2Connection */
    final class C6632i extends C5927b {

        /* renamed from: b */
        final boolean f17420b;

        /* renamed from: c */
        final int f17421c;

        /* renamed from: d */
        final int f17422d;

        C6632i(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", C6624f.this.f17374d, Integer.valueOf(i), Integer.valueOf(i2));
            this.f17420b = z;
            this.f17421c = i;
            this.f17422d = i2;
        }

        /* renamed from: b */
        public void mo19596b() {
            C6624f.this.mo35694a(this.f17420b, this.f17421c, this.f17422d);
        }
    }

    static {
        Class<C6624f> cls = C6624f.class;
    }

    C6624f(C6631g gVar) {
        C6631g gVar2 = gVar;
        this.f17380j = gVar2.f17417f;
        boolean z = gVar2.f17418g;
        this.f17371a = z;
        this.f17372b = gVar2.f17416e;
        int i = z ? 1 : 2;
        this.f17376f = i;
        if (gVar2.f17418g) {
            this.f17376f = i + 2;
        }
        if (gVar2.f17418g) {
            this.f17384n.mo35746a(7, 16777216);
        }
        this.f17374d = gVar2.f17413b;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, C3500c.m11646a(C3500c.m11639a("OkHttp %s Writer", this.f17374d), false));
        this.f17378h = scheduledThreadPoolExecutor;
        if (gVar2.f17419h != 0) {
            C6632i iVar = new C6632i(false, 0, 0);
            int i2 = gVar2.f17419h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, (long) i2, (long) i2, TimeUnit.MILLISECONDS);
        }
        this.f17379i = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C3500c.m11646a(C3500c.m11639a("OkHttp %s Push Observer", this.f17374d), true));
        this.f17385o.mo35746a(7, 65535);
        this.f17385o.mo35746a(5, 16384);
        this.f17383m = (long) this.f17385o.mo35751c();
        this.f17387q = gVar2.f17412a;
        this.f17388r = new C6640i(gVar2.f17415d, this.f17371a);
        this.f17389s = new C6633j(new C6637g(gVar2.f17414c, this.f17371a));
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public void m21790w() {
        try {
            mo35692a(C6615a.PROTOCOL_ERROR, C6615a.PROTOCOL_ERROR);
        } catch (IOException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo35696b(int i) {
        return i != 0 && (i & 1) == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized C3592h mo35697c(int i) {
        C3592h remove;
        remove = this.f17373c.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public void close() throws IOException {
        mo35692a(C6615a.NO_ERROR, C6615a.CANCEL);
    }

    /* renamed from: d */
    public synchronized boolean mo35700d() {
        return this.f17377g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public synchronized void mo35701e(long j) {
        long j2 = this.f17382l + j;
        this.f17382l = j2;
        if (j2 >= ((long) (this.f17384n.mo35751c() / 2))) {
            mo35685a(0, this.f17382l);
            this.f17382l = 0;
        }
    }

    public void flush() throws IOException {
        this.f17388r.flush();
    }

    /* renamed from: t */
    public synchronized int mo35703t() {
        return this.f17385o.mo35750b(Integer.MAX_VALUE);
    }

    /* renamed from: u */
    public void mo35704u() throws IOException {
        mo35693a(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.http2.C3592h m21788b(int r11, java.util.List<okhttp3.internal.http2.C6616b> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            okhttp3.internal.http2.i r7 = r10.f17388r
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0078 }
            int r0 = r10.f17376f     // Catch:{ all -> 0x0075 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0013
            okhttp3.internal.http2.a r0 = okhttp3.internal.http2.C6615a.REFUSED_STREAM     // Catch:{ all -> 0x0075 }
            r10.mo35691a((okhttp3.internal.http2.C6615a) r0)     // Catch:{ all -> 0x0075 }
        L_0x0013:
            boolean r0 = r10.f17377g     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x006f
            int r8 = r10.f17376f     // Catch:{ all -> 0x0075 }
            int r0 = r10.f17376f     // Catch:{ all -> 0x0075 }
            int r0 = r0 + 2
            r10.f17376f = r0     // Catch:{ all -> 0x0075 }
            okhttp3.internal.http2.h r9 = new okhttp3.internal.http2.h     // Catch:{ all -> 0x0075 }
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0075 }
            if (r13 == 0) goto L_0x003c
            long r0 = r10.f17383m     // Catch:{ all -> 0x0075 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x003c
            long r0 = r9.f10069b     // Catch:{ all -> 0x0075 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r13 = 0
            goto L_0x003d
        L_0x003c:
            r13 = 1
        L_0x003d:
            boolean r0 = r9.mo19804g()     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x004c
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.h> r0 = r10.f17373c     // Catch:{ all -> 0x0075 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0075 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0075 }
        L_0x004c:
            monitor-exit(r10)     // Catch:{ all -> 0x0075 }
            if (r11 != 0) goto L_0x0055
            okhttp3.internal.http2.i r0 = r10.f17388r     // Catch:{ all -> 0x0078 }
            r0.mo35730a((boolean) r6, (int) r8, (int) r11, (java.util.List<okhttp3.internal.http2.C6616b>) r12)     // Catch:{ all -> 0x0078 }
            goto L_0x005e
        L_0x0055:
            boolean r0 = r10.f17371a     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x0067
            okhttp3.internal.http2.i r0 = r10.f17388r     // Catch:{ all -> 0x0078 }
            r0.mo35724a((int) r11, (int) r8, (java.util.List<okhttp3.internal.http2.C6616b>) r12)     // Catch:{ all -> 0x0078 }
        L_0x005e:
            monitor-exit(r7)     // Catch:{ all -> 0x0078 }
            if (r13 == 0) goto L_0x0066
            okhttp3.internal.http2.i r11 = r10.f17388r
            r11.flush()
        L_0x0066:
            return r9
        L_0x0067:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0078 }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x0078 }
            throw r11     // Catch:{ all -> 0x0078 }
        L_0x006f:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0075 }
            r11.<init>()     // Catch:{ all -> 0x0075 }
            throw r11     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0075 }
            throw r11     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0078 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C6624f.m21788b(int, java.util.List, boolean):okhttp3.internal.http2.h");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized C3592h mo35683a(int i) {
        return this.f17373c.get(Integer.valueOf(i));
    }

    /* renamed from: okhttp3.internal.http2.f$g */
    /* compiled from: Http2Connection */
    public static class C6631g {

        /* renamed from: a */
        Socket f17412a;

        /* renamed from: b */
        String f17413b;

        /* renamed from: c */
        C3580e f17414c;

        /* renamed from: d */
        C3579d f17415d;

        /* renamed from: e */
        C3590h f17416e = C3590h.f10067a;

        /* renamed from: f */
        C6643k f17417f = C6643k.f17456a;

        /* renamed from: g */
        boolean f17418g;

        /* renamed from: h */
        int f17419h;

        public C6631g(boolean z) {
            this.f17418g = z;
        }

        /* renamed from: a */
        public C6631g mo35706a(Socket socket, String str, C3580e eVar, C3579d dVar) {
            this.f17412a = socket;
            this.f17413b = str;
            this.f17414c = eVar;
            this.f17415d = dVar;
            return this;
        }

        /* renamed from: a */
        public C6631g mo35707a(C3590h hVar) {
            this.f17416e = hVar;
            return this;
        }

        /* renamed from: a */
        public C6631g mo35705a(int i) {
            this.f17419h = i;
            return this;
        }

        /* renamed from: a */
        public C6624f mo35708a() {
            return new C6624f(this);
        }
    }

    /* renamed from: a */
    public C3592h mo35684a(List<C6616b> list, boolean z) throws IOException {
        return m21788b(0, list, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo35698c(int i, C6615a aVar) {
        try {
            this.f17378h.execute(new C6625a("OkHttp %s stream %d", new Object[]{this.f17374d, Integer.valueOf(i)}, i, aVar));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.f17383m), r8.f17388r.mo35737t());
        r6 = (long) r3;
        r8.f17383m -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005a */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo35690a(int r9, boolean r10, p119j.C3577c r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            okhttp3.internal.http2.i r12 = r8.f17388r
            r12.mo35731a((boolean) r10, (int) r9, (p119j.C3577c) r11, (int) r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0069
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.f17383m     // Catch:{ InterruptedException -> 0x005a }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.h> r3 = r8.f17373c     // Catch:{ InterruptedException -> 0x005a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x005a }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x005a }
            if (r3 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x005a }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x005a }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x005a }
            throw r9     // Catch:{ InterruptedException -> 0x005a }
        L_0x0030:
            long r3 = r8.f17383m     // Catch:{ all -> 0x0058 }
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0058 }
            int r4 = (int) r3     // Catch:{ all -> 0x0058 }
            okhttp3.internal.http2.i r3 = r8.f17388r     // Catch:{ all -> 0x0058 }
            int r3 = r3.mo35737t()     // Catch:{ all -> 0x0058 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0058 }
            long r4 = r8.f17383m     // Catch:{ all -> 0x0058 }
            long r6 = (long) r3     // Catch:{ all -> 0x0058 }
            long r4 = r4 - r6
            r8.f17383m = r4     // Catch:{ all -> 0x0058 }
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            long r12 = r12 - r6
            okhttp3.internal.http2.i r4 = r8.f17388r
            if (r10 == 0) goto L_0x0053
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0053
            r5 = 1
            goto L_0x0054
        L_0x0053:
            r5 = 0
        L_0x0054:
            r4.mo35731a((boolean) r5, (int) r9, (p119j.C3577c) r11, (int) r3)
            goto L_0x000d
        L_0x0058:
            r9 = move-exception
            goto L_0x0067
        L_0x005a:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0058 }
            r9.interrupt()     // Catch:{ all -> 0x0058 }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0058 }
            r9.<init>()     // Catch:{ all -> 0x0058 }
            throw r9     // Catch:{ all -> 0x0058 }
        L_0x0067:
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            throw r9
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C6624f.mo35690a(int, boolean, j.c, long):void");
    }

    /* renamed from: okhttp3.internal.http2.f$j */
    /* compiled from: Http2Connection */
    class C6633j extends C5927b implements C6637g.C6639b {

        /* renamed from: b */
        final C6637g f17424b;

        /* renamed from: okhttp3.internal.http2.f$j$a */
        /* compiled from: Http2Connection */
        class C6634a extends C5927b {

            /* renamed from: b */
            final /* synthetic */ C3592h f17426b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C6634a(String str, Object[] objArr, C3592h hVar) {
                super(str, objArr);
                this.f17426b = hVar;
            }

            /* renamed from: b */
            public void mo19596b() {
                try {
                    C6624f.this.f17372b.mo19783a(this.f17426b);
                } catch (IOException e) {
                    C3521f d = C3521f.m11740d();
                    d.mo19409a(4, "Http2Connection.Listener failure for " + C6624f.this.f17374d, (Throwable) e);
                    try {
                        this.f17426b.mo19796a(C6615a.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* renamed from: okhttp3.internal.http2.f$j$b */
        /* compiled from: Http2Connection */
        class C6635b extends C5927b {
            C6635b(String str, Object... objArr) {
                super(str, objArr);
            }

            /* renamed from: b */
            public void mo19596b() {
                C6624f fVar = C6624f.this;
                fVar.f17372b.mo19782a(fVar);
            }
        }

        /* renamed from: okhttp3.internal.http2.f$j$c */
        /* compiled from: Http2Connection */
        class C6636c extends C5927b {

            /* renamed from: b */
            final /* synthetic */ C6645l f17429b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C6636c(String str, Object[] objArr, C6645l lVar) {
                super(str, objArr);
                this.f17429b = lVar;
            }

            /* renamed from: b */
            public void mo19596b() {
                try {
                    C6624f.this.f17388r.mo35728a(this.f17429b);
                } catch (IOException unused) {
                    C6624f.this.m21790w();
                }
            }
        }

        C6633j(C6637g gVar) {
            super("OkHttp %s", C6624f.this.f17374d);
            this.f17424b = gVar;
        }

        /* renamed from: a */
        public void mo35709a() {
        }

        /* renamed from: a */
        public void mo35710a(int i, int i2, int i3, boolean z) {
        }

        /* renamed from: a */
        public void mo35717a(boolean z, int i, C3580e eVar, int i2) throws IOException {
            if (C6624f.this.mo35696b(i)) {
                C6624f.this.mo35686a(i, eVar, i2, z);
                return;
            }
            C3592h a = C6624f.this.mo35683a(i);
            if (a == null) {
                C6624f.this.mo35698c(i, C6615a.PROTOCOL_ERROR);
                long j = (long) i2;
                C6624f.this.mo35701e(j);
                eVar.skip(j);
                return;
            }
            a.mo19794a(eVar, i2);
            if (z) {
                a.mo19806i();
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r1 = okhttp3.internal.http2.C6615a.PROTOCOL_ERROR;
            r0 = okhttp3.internal.http2.C6615a.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r2 = r4.f17425c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x002b, code lost:
            r2 = th;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001c */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo19596b() {
            /*
                r4 = this;
                okhttp3.internal.http2.a r0 = okhttp3.internal.http2.C6615a.INTERNAL_ERROR
                okhttp3.internal.http2.g r1 = r4.f17424b     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
                r1.mo35719a((okhttp3.internal.http2.C6637g.C6639b) r4)     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
            L_0x0007:
                okhttp3.internal.http2.g r1 = r4.f17424b     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
                r2 = 0
                boolean r1 = r1.mo35720a((boolean) r2, (okhttp3.internal.http2.C6637g.C6639b) r4)     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
                if (r1 == 0) goto L_0x0011
                goto L_0x0007
            L_0x0011:
                okhttp3.internal.http2.a r1 = okhttp3.internal.http2.C6615a.NO_ERROR     // Catch:{ IOException -> 0x001b, all -> 0x0018 }
                okhttp3.internal.http2.a r0 = okhttp3.internal.http2.C6615a.CANCEL     // Catch:{ IOException -> 0x001c }
                okhttp3.internal.http2.f r2 = okhttp3.internal.http2.C6624f.this     // Catch:{ IOException -> 0x0025 }
                goto L_0x0022
            L_0x0018:
                r2 = move-exception
                r1 = r0
                goto L_0x002c
            L_0x001b:
                r1 = r0
            L_0x001c:
                okhttp3.internal.http2.a r1 = okhttp3.internal.http2.C6615a.PROTOCOL_ERROR     // Catch:{ all -> 0x002b }
                okhttp3.internal.http2.a r0 = okhttp3.internal.http2.C6615a.PROTOCOL_ERROR     // Catch:{ all -> 0x002b }
                okhttp3.internal.http2.f r2 = okhttp3.internal.http2.C6624f.this     // Catch:{ IOException -> 0x0025 }
            L_0x0022:
                r2.mo35692a((okhttp3.internal.http2.C6615a) r1, (okhttp3.internal.http2.C6615a) r0)     // Catch:{ IOException -> 0x0025 }
            L_0x0025:
                okhttp3.internal.http2.g r0 = r4.f17424b
                p113i.p114e0.C3500c.m11649a((java.io.Closeable) r0)
                return
            L_0x002b:
                r2 = move-exception
            L_0x002c:
                okhttp3.internal.http2.f r3 = okhttp3.internal.http2.C6624f.this     // Catch:{ IOException -> 0x0031 }
                r3.mo35692a((okhttp3.internal.http2.C6615a) r1, (okhttp3.internal.http2.C6615a) r0)     // Catch:{ IOException -> 0x0031 }
            L_0x0031:
                okhttp3.internal.http2.g r0 = r4.f17424b
                p113i.p114e0.C3500c.m11649a((java.io.Closeable) r0)
                goto L_0x0038
            L_0x0037:
                throw r2
            L_0x0038:
                goto L_0x0037
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C6624f.C6633j.mo19596b():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0074, code lost:
            r0.mo19795a(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0077, code lost:
            if (r10 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0079, code lost:
            r0.mo19806i();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo35716a(boolean r10, int r11, int r12, java.util.List<okhttp3.internal.http2.C6616b> r13) {
            /*
                r9 = this;
                okhttp3.internal.http2.f r12 = okhttp3.internal.http2.C6624f.this
                boolean r12 = r12.mo35696b((int) r11)
                if (r12 == 0) goto L_0x000e
                okhttp3.internal.http2.f r12 = okhttp3.internal.http2.C6624f.this
                r12.mo35688a((int) r11, (java.util.List<okhttp3.internal.http2.C6616b>) r13, (boolean) r10)
                return
            L_0x000e:
                okhttp3.internal.http2.f r12 = okhttp3.internal.http2.C6624f.this
                monitor-enter(r12)
                okhttp3.internal.http2.f r0 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x007d }
                okhttp3.internal.http2.h r0 = r0.mo35683a((int) r11)     // Catch:{ all -> 0x007d }
                if (r0 != 0) goto L_0x0073
                okhttp3.internal.http2.f r0 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x007d }
                boolean r0 = r0.f17377g     // Catch:{ all -> 0x007d }
                if (r0 == 0) goto L_0x0021
                monitor-exit(r12)     // Catch:{ all -> 0x007d }
                return
            L_0x0021:
                okhttp3.internal.http2.f r0 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x007d }
                int r0 = r0.f17375e     // Catch:{ all -> 0x007d }
                if (r11 > r0) goto L_0x0029
                monitor-exit(r12)     // Catch:{ all -> 0x007d }
                return
            L_0x0029:
                int r0 = r11 % 2
                okhttp3.internal.http2.f r1 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x007d }
                int r1 = r1.f17376f     // Catch:{ all -> 0x007d }
                r2 = 2
                int r1 = r1 % r2
                if (r0 != r1) goto L_0x0035
                monitor-exit(r12)     // Catch:{ all -> 0x007d }
                return
            L_0x0035:
                i.r r8 = p113i.p114e0.C3500c.m11659b((java.util.List<okhttp3.internal.http2.C6616b>) r13)     // Catch:{ all -> 0x007d }
                okhttp3.internal.http2.h r13 = new okhttp3.internal.http2.h     // Catch:{ all -> 0x007d }
                okhttp3.internal.http2.f r5 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x007d }
                r6 = 0
                r3 = r13
                r4 = r11
                r7 = r10
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x007d }
                okhttp3.internal.http2.f r10 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x007d }
                r10.f17375e = r11     // Catch:{ all -> 0x007d }
                okhttp3.internal.http2.f r10 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x007d }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.h> r10 = r10.f17373c     // Catch:{ all -> 0x007d }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x007d }
                r10.put(r0, r13)     // Catch:{ all -> 0x007d }
                java.util.concurrent.ExecutorService r10 = okhttp3.internal.http2.C6624f.f17370u     // Catch:{ all -> 0x007d }
                okhttp3.internal.http2.f$j$a r0 = new okhttp3.internal.http2.f$j$a     // Catch:{ all -> 0x007d }
                java.lang.String r1 = "OkHttp %s stream %d"
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x007d }
                r3 = 0
                okhttp3.internal.http2.f r4 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x007d }
                java.lang.String r4 = r4.f17374d     // Catch:{ all -> 0x007d }
                r2[r3] = r4     // Catch:{ all -> 0x007d }
                r3 = 1
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x007d }
                r2[r3] = r11     // Catch:{ all -> 0x007d }
                r0.<init>(r1, r2, r13)     // Catch:{ all -> 0x007d }
                r10.execute(r0)     // Catch:{ all -> 0x007d }
                monitor-exit(r12)     // Catch:{ all -> 0x007d }
                return
            L_0x0073:
                monitor-exit(r12)     // Catch:{ all -> 0x007d }
                r0.mo19795a((java.util.List<okhttp3.internal.http2.C6616b>) r13)
                if (r10 == 0) goto L_0x007c
                r0.mo19806i()
            L_0x007c:
                return
            L_0x007d:
                r10 = move-exception
                monitor-exit(r12)     // Catch:{ all -> 0x007d }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C6624f.C6633j.mo35716a(boolean, int, int, java.util.List):void");
        }

        /* renamed from: a */
        public void mo35713a(int i, C6615a aVar) {
            if (C6624f.this.mo35696b(i)) {
                C6624f.this.mo35689a(i, aVar);
                return;
            }
            C3592h c = C6624f.this.mo35697c(i);
            if (c != null) {
                c.mo19800c(aVar);
            }
        }

        /* JADX WARNING: type inference failed for: r1v13, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo35718a(boolean r11, okhttp3.internal.http2.C6645l r12) {
            /*
                r10 = this;
                okhttp3.internal.http2.f r0 = okhttp3.internal.http2.C6624f.this
                monitor-enter(r0)
                okhttp3.internal.http2.f r1 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.l r1 = r1.f17385o     // Catch:{ all -> 0x008f }
                int r1 = r1.mo35751c()     // Catch:{ all -> 0x008f }
                if (r11 == 0) goto L_0x0014
                okhttp3.internal.http2.f r11 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.l r11 = r11.f17385o     // Catch:{ all -> 0x008f }
                r11.mo35747a()     // Catch:{ all -> 0x008f }
            L_0x0014:
                okhttp3.internal.http2.f r11 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.l r11 = r11.f17385o     // Catch:{ all -> 0x008f }
                r11.mo35748a((okhttp3.internal.http2.C6645l) r12)     // Catch:{ all -> 0x008f }
                r10.m21822a(r12)     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.f r11 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.l r11 = r11.f17385o     // Catch:{ all -> 0x008f }
                int r11 = r11.mo35751c()     // Catch:{ all -> 0x008f }
                r12 = -1
                r2 = 0
                r4 = 1
                r5 = 0
                if (r11 == r12) goto L_0x005f
                if (r11 == r1) goto L_0x005f
                int r11 = r11 - r1
                long r11 = (long) r11     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.f r1 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x008f }
                boolean r1 = r1.f17386p     // Catch:{ all -> 0x008f }
                if (r1 != 0) goto L_0x003b
                okhttp3.internal.http2.f r1 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x008f }
                r1.f17386p = r4     // Catch:{ all -> 0x008f }
            L_0x003b:
                okhttp3.internal.http2.f r1 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x008f }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.h> r1 = r1.f17373c     // Catch:{ all -> 0x008f }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x008f }
                if (r1 != 0) goto L_0x0060
                okhttp3.internal.http2.f r1 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x008f }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.h> r1 = r1.f17373c     // Catch:{ all -> 0x008f }
                java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.f r5 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x008f }
                java.util.Map<java.lang.Integer, okhttp3.internal.http2.h> r5 = r5.f17373c     // Catch:{ all -> 0x008f }
                int r5 = r5.size()     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.h[] r5 = new okhttp3.internal.http2.C3592h[r5]     // Catch:{ all -> 0x008f }
                java.lang.Object[] r1 = r1.toArray(r5)     // Catch:{ all -> 0x008f }
                r5 = r1
                okhttp3.internal.http2.h[] r5 = (okhttp3.internal.http2.C3592h[]) r5     // Catch:{ all -> 0x008f }
                goto L_0x0060
            L_0x005f:
                r11 = r2
            L_0x0060:
                java.util.concurrent.ExecutorService r1 = okhttp3.internal.http2.C6624f.f17370u     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.f$j$b r6 = new okhttp3.internal.http2.f$j$b     // Catch:{ all -> 0x008f }
                java.lang.String r7 = "OkHttp %s settings"
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x008f }
                okhttp3.internal.http2.f r8 = okhttp3.internal.http2.C6624f.this     // Catch:{ all -> 0x008f }
                java.lang.String r8 = r8.f17374d     // Catch:{ all -> 0x008f }
                r9 = 0
                r4[r9] = r8     // Catch:{ all -> 0x008f }
                r6.<init>(r7, r4)     // Catch:{ all -> 0x008f }
                r1.execute(r6)     // Catch:{ all -> 0x008f }
                monitor-exit(r0)     // Catch:{ all -> 0x008f }
                if (r5 == 0) goto L_0x008e
                int r0 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r0 == 0) goto L_0x008e
                int r0 = r5.length
            L_0x007f:
                if (r9 >= r0) goto L_0x008e
                r1 = r5[r9]
                monitor-enter(r1)
                r1.mo19793a((long) r11)     // Catch:{ all -> 0x008b }
                monitor-exit(r1)     // Catch:{ all -> 0x008b }
                int r9 = r9 + 1
                goto L_0x007f
            L_0x008b:
                r11 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x008b }
                throw r11
            L_0x008e:
                return
            L_0x008f:
                r11 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x008f }
                goto L_0x0093
            L_0x0092:
                throw r11
            L_0x0093:
                goto L_0x0092
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C6624f.C6633j.mo35718a(boolean, okhttp3.internal.http2.l):void");
        }

        /* renamed from: a */
        private void m21822a(C6645l lVar) {
            try {
                C6624f.this.f17378h.execute(new C6636c("OkHttp %s ACK Settings", new Object[]{C6624f.this.f17374d}, lVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        /* renamed from: a */
        public void mo35715a(boolean z, int i, int i2) {
            if (z) {
                synchronized (C6624f.this) {
                    boolean unused = C6624f.this.f17381k = false;
                    C6624f.this.notifyAll();
                }
                return;
            }
            try {
                C6624f.this.f17378h.execute(new C6632i(true, i, i2));
            } catch (RejectedExecutionException unused2) {
            }
        }

        /* renamed from: a */
        public void mo35714a(int i, C6615a aVar, C3581f fVar) {
            C3592h[] hVarArr;
            fVar.mo19759f();
            synchronized (C6624f.this) {
                hVarArr = (C3592h[]) C6624f.this.f17373c.values().toArray(new C3592h[C6624f.this.f17373c.size()]);
                C6624f.this.f17377g = true;
            }
            for (C3592h hVar : hVarArr) {
                if (hVar.mo19799c() > i && hVar.mo19803f()) {
                    hVar.mo19800c(C6615a.REFUSED_STREAM);
                    C6624f.this.mo35697c(hVar.mo19799c());
                }
            }
        }

        /* renamed from: a */
        public void mo35712a(int i, long j) {
            if (i == 0) {
                synchronized (C6624f.this) {
                    C6624f.this.f17383m += j;
                    C6624f.this.notifyAll();
                }
                return;
            }
            C3592h a = C6624f.this.mo35683a(i);
            if (a != null) {
                synchronized (a) {
                    a.mo19793a(j);
                }
            }
        }

        /* renamed from: a */
        public void mo35711a(int i, int i2, List<C6616b> list) {
            C6624f.this.mo35687a(i2, list);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo35685a(int i, long j) {
        try {
            this.f17378h.execute(new C6626b("OkHttp Window Update %s stream %d", new Object[]{this.f17374d, Integer.valueOf(i)}, i, j));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo35694a(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.f17381k;
                this.f17381k = true;
            }
            if (z2) {
                m21790w();
                return;
            }
        }
        try {
            this.f17388r.mo35729a(z, i, i2);
        } catch (IOException unused) {
            m21790w();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo35695b(int i, C6615a aVar) throws IOException {
        this.f17388r.mo35726a(i, aVar);
    }

    /* renamed from: a */
    public void mo35691a(C6615a aVar) throws IOException {
        synchronized (this.f17388r) {
            synchronized (this) {
                if (!this.f17377g) {
                    this.f17377g = true;
                    int i = this.f17375e;
                    this.f17388r.mo35727a(i, aVar, C3500c.f9701a);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo35692a(C6615a aVar, C6615a aVar2) throws IOException {
        C3592h[] hVarArr = null;
        try {
            mo35691a(aVar);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (!this.f17373c.isEmpty()) {
                hVarArr = (C3592h[]) this.f17373c.values().toArray(new C3592h[this.f17373c.size()]);
                this.f17373c.clear();
            }
        }
        if (hVarArr != null) {
            for (C3592h a : hVarArr) {
                try {
                    a.mo19796a(aVar2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        try {
            this.f17388r.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.f17387q.close();
        } catch (IOException e4) {
            e = e4;
        }
        this.f17378h.shutdown();
        this.f17379i.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo35693a(boolean z) throws IOException {
        if (z) {
            this.f17388r.mo35735d();
            this.f17388r.mo35733b(this.f17384n);
            int c = this.f17384n.mo35751c();
            if (c != 65535) {
                this.f17388r.mo35725a(0, (long) (c - 65535));
            }
        }
        new Thread(this.f17389s).start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo35687a(int i, List<C6616b> list) {
        synchronized (this) {
            if (this.f17390t.contains(Integer.valueOf(i))) {
                mo35698c(i, C6615a.PROTOCOL_ERROR);
                return;
            }
            this.f17390t.add(Integer.valueOf(i));
            try {
                m21784a((C5927b) new C6627c("OkHttp %s Push Request[%s]", new Object[]{this.f17374d, Integer.valueOf(i)}, i, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo35688a(int i, List<C6616b> list, boolean z) {
        try {
            m21784a((C5927b) new C6628d("OkHttp %s Push Headers[%s]", new Object[]{this.f17374d, Integer.valueOf(i)}, i, list, z));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo35686a(int i, C3580e eVar, int i2, boolean z) throws IOException {
        C3577c cVar = new C3577c();
        long j = (long) i2;
        eVar.mo19718l(j);
        eVar.read(cVar, j);
        if (cVar.size() == j) {
            m21784a((C5927b) new C6629e("OkHttp %s Push Data[%s]", new Object[]{this.f17374d, Integer.valueOf(i)}, i, cVar, i2, z));
            return;
        }
        throw new IOException(cVar.size() + " != " + i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo35689a(int i, C6615a aVar) {
        m21784a((C5927b) new C6630f("OkHttp %s Push Reset[%s]", new Object[]{this.f17374d, Integer.valueOf(i)}, i, aVar));
    }

    /* renamed from: a */
    private synchronized void m21784a(C5927b bVar) {
        if (!mo35700d()) {
            this.f17379i.execute(bVar);
        }
    }
}
