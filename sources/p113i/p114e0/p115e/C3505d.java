package p113i.p114e0.p115e;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import p113i.p114e0.C3500c;
import p113i.p114e0.p117i.C3521f;
import p113i.p114e0.p196h.C5954a;
import p119j.C3579d;
import p119j.C3585t;
import p119j.C3586u;
import p119j.C6589n;

/* renamed from: i.e0.e.d */
/* compiled from: DiskLruCache */
public final class C3505d implements Closeable, Flushable {

    /* renamed from: u */
    static final Pattern f9734u = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: a */
    final C5954a f9735a;

    /* renamed from: b */
    final File f9736b;

    /* renamed from: c */
    private final File f9737c;

    /* renamed from: d */
    private final File f9738d;

    /* renamed from: e */
    private final File f9739e;

    /* renamed from: f */
    private final int f9740f;

    /* renamed from: g */
    private long f9741g;

    /* renamed from: h */
    final int f9742h;

    /* renamed from: i */
    private long f9743i = 0;

    /* renamed from: j */
    C3579d f9744j;

    /* renamed from: k */
    final LinkedHashMap<String, C3511d> f9745k = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l */
    int f9746l;

    /* renamed from: m */
    boolean f9747m;

    /* renamed from: n */
    boolean f9748n;

    /* renamed from: o */
    boolean f9749o;

    /* renamed from: p */
    boolean f9750p;

    /* renamed from: q */
    boolean f9751q;

    /* renamed from: r */
    private long f9752r = 0;

    /* renamed from: s */
    private final Executor f9753s;

    /* renamed from: t */
    private final Runnable f9754t = new C3507a();

    /* renamed from: i.e0.e.d$e */
    /* compiled from: DiskLruCache */
    public final class C3506e implements Closeable {

        /* renamed from: a */
        private final String f9755a;

        /* renamed from: b */
        private final long f9756b;

        /* renamed from: c */
        private final C3586u[] f9757c;

        C3506e(String str, long j, C3586u[] uVarArr, long[] jArr) {
            this.f9755a = str;
            this.f9756b = j;
            this.f9757c = uVarArr;
        }

        /* renamed from: a */
        public C3586u mo19395a(int i) {
            return this.f9757c[i];
        }

        public void close() {
            for (C3586u a : this.f9757c) {
                C3500c.m11649a((Closeable) a);
            }
        }

        @Nullable
        /* renamed from: d */
        public C3509c mo19397d() throws IOException {
            return C3505d.this.mo19382a(this.f9755a, this.f9756b);
        }
    }

    /* renamed from: i.e0.e.d$a */
    /* compiled from: DiskLruCache */
    class C3507a implements Runnable {
        C3507a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r5.f9759a.f9751q = true;
            r5.f9759a.f9744j = p119j.C6589n.m21609a(p119j.C6589n.m21611a());
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0033 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                i.e0.e.d r0 = p113i.p114e0.p115e.C3505d.this
                monitor-enter(r0)
                i.e0.e.d r1 = p113i.p114e0.p115e.C3505d.this     // Catch:{ all -> 0x0045 }
                boolean r1 = r1.f9748n     // Catch:{ all -> 0x0045 }
                r2 = 0
                r3 = 1
                if (r1 != 0) goto L_0x000d
                r1 = 1
                goto L_0x000e
            L_0x000d:
                r1 = 0
            L_0x000e:
                i.e0.e.d r4 = p113i.p114e0.p115e.C3505d.this     // Catch:{ all -> 0x0045 }
                boolean r4 = r4.f9749o     // Catch:{ all -> 0x0045 }
                r1 = r1 | r4
                if (r1 == 0) goto L_0x0017
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                return
            L_0x0017:
                i.e0.e.d r1 = p113i.p114e0.p115e.C3505d.this     // Catch:{ IOException -> 0x001d }
                r1.mo19394w()     // Catch:{ IOException -> 0x001d }
                goto L_0x0021
            L_0x001d:
                i.e0.e.d r1 = p113i.p114e0.p115e.C3505d.this     // Catch:{ all -> 0x0045 }
                r1.f9750p = r3     // Catch:{ all -> 0x0045 }
            L_0x0021:
                i.e0.e.d r1 = p113i.p114e0.p115e.C3505d.this     // Catch:{ IOException -> 0x0033 }
                boolean r1 = r1.mo19392u()     // Catch:{ IOException -> 0x0033 }
                if (r1 == 0) goto L_0x0043
                i.e0.e.d r1 = p113i.p114e0.p115e.C3505d.this     // Catch:{ IOException -> 0x0033 }
                r1.mo19393v()     // Catch:{ IOException -> 0x0033 }
                i.e0.e.d r1 = p113i.p114e0.p115e.C3505d.this     // Catch:{ IOException -> 0x0033 }
                r1.f9746l = r2     // Catch:{ IOException -> 0x0033 }
                goto L_0x0043
            L_0x0033:
                i.e0.e.d r1 = p113i.p114e0.p115e.C3505d.this     // Catch:{ all -> 0x0045 }
                r1.f9751q = r3     // Catch:{ all -> 0x0045 }
                i.e0.e.d r1 = p113i.p114e0.p115e.C3505d.this     // Catch:{ all -> 0x0045 }
                j.t r2 = p119j.C6589n.m21611a()     // Catch:{ all -> 0x0045 }
                j.d r2 = p119j.C6589n.m21609a((p119j.C3585t) r2)     // Catch:{ all -> 0x0045 }
                r1.f9744j = r2     // Catch:{ all -> 0x0045 }
            L_0x0043:
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                return
            L_0x0045:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p113i.p114e0.p115e.C3505d.C3507a.run():void");
        }
    }

    /* renamed from: i.e0.e.d$b */
    /* compiled from: DiskLruCache */
    class C3508b extends C5932e {
        static {
            Class<C3505d> cls = C3505d.class;
        }

        C3508b(C3585t tVar) {
            super(tVar);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo19399a(IOException iOException) {
            C3505d.this.f9747m = true;
        }
    }

    static {
        Class<C3505d> cls = C3505d.class;
    }

    C3505d(C5954a aVar, File file, int i, int i2, long j, Executor executor) {
        this.f9735a = aVar;
        this.f9736b = file;
        this.f9740f = i;
        this.f9737c = new File(file, "journal");
        this.f9738d = new File(file, "journal.tmp");
        this.f9739e = new File(file, "journal.bkp");
        this.f9742h = i2;
        this.f9741g = j;
        this.f9753s = executor;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.f9746l = r0 - r9.f9745k.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (r1.mo19681H() == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        mo19393v();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r9.f9744j = m11680y();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005d */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x007a=Splitter:B:23:0x007a, B:16:0x005d=Splitter:B:16:0x005d} */
    /* renamed from: A */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m11675A() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            i.e0.h.a r1 = r9.f9735a
            java.io.File r2 = r9.f9737c
            j.u r1 = r1.mo33753a(r2)
            j.e r1 = p119j.C6589n.m21610a((p119j.C3586u) r1)
            java.lang.String r2 = r1.mo19684M()     // Catch:{ all -> 0x00a8 }
            java.lang.String r3 = r1.mo19684M()     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = r1.mo19684M()     // Catch:{ all -> 0x00a8 }
            java.lang.String r5 = r1.mo19684M()     // Catch:{ all -> 0x00a8 }
            java.lang.String r6 = r1.mo19684M()     // Catch:{ all -> 0x00a8 }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00a8 }
            if (r7 == 0) goto L_0x007a
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00a8 }
            if (r7 == 0) goto L_0x007a
            int r7 = r9.f9740f     // Catch:{ all -> 0x00a8 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00a8 }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            int r4 = r9.f9742h     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00a8 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            r0 = 0
        L_0x0053:
            java.lang.String r2 = r1.mo19684M()     // Catch:{ EOFException -> 0x005d }
            r9.m11677f(r2)     // Catch:{ EOFException -> 0x005d }
            int r0 = r0 + 1
            goto L_0x0053
        L_0x005d:
            java.util.LinkedHashMap<java.lang.String, i.e0.e.d$d> r2 = r9.f9745k     // Catch:{ all -> 0x00a8 }
            int r2 = r2.size()     // Catch:{ all -> 0x00a8 }
            int r0 = r0 - r2
            r9.f9746l = r0     // Catch:{ all -> 0x00a8 }
            boolean r0 = r1.mo19681H()     // Catch:{ all -> 0x00a8 }
            if (r0 != 0) goto L_0x0070
            r9.mo19393v()     // Catch:{ all -> 0x00a8 }
            goto L_0x0076
        L_0x0070:
            j.d r0 = r9.m11680y()     // Catch:{ all -> 0x00a8 }
            r9.f9744j = r0     // Catch:{ all -> 0x00a8 }
        L_0x0076:
            p113i.p114e0.C3500c.m11649a((java.io.Closeable) r1)
            return
        L_0x007a:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00a8 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a8 }
            r7.<init>()     // Catch:{ all -> 0x00a8 }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00a8 }
            r7.append(r2)     // Catch:{ all -> 0x00a8 }
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            r7.append(r3)     // Catch:{ all -> 0x00a8 }
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            r7.append(r5)     // Catch:{ all -> 0x00a8 }
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            r7.append(r6)     // Catch:{ all -> 0x00a8 }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00a8 }
            r4.<init>(r0)     // Catch:{ all -> 0x00a8 }
            throw r4     // Catch:{ all -> 0x00a8 }
        L_0x00a8:
            r0 = move-exception
            p113i.p114e0.C3500c.m11649a((java.io.Closeable) r1)
            goto L_0x00ae
        L_0x00ad:
            throw r0
        L_0x00ae:
            goto L_0x00ad
        */
        throw new UnsupportedOperationException("Method not decompiled: p113i.p114e0.p115e.C3505d.m11675A():void");
    }

    /* renamed from: a */
    public static C3505d m11676a(C5954a aVar, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            return new C3505d(aVar, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C3500c.m11646a("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* renamed from: f */
    private void m11677f(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f9745k.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            C3511d dVar = this.f9745k.get(str2);
            if (dVar == null) {
                dVar = new C3511d(str2);
                this.f9745k.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f9770e = true;
                dVar.f9771f = null;
                dVar.mo19406a(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f9771f = new C3509c(dVar);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* renamed from: g */
    private void m11678g(String str) {
        if (!f9734u.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* renamed from: x */
    private synchronized void m11679x() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: y */
    private C3579d m11680y() throws FileNotFoundException {
        return C6589n.m21609a((C3585t) new C3508b(this.f9735a.mo33759e(this.f9737c)));
    }

    /* renamed from: z */
    private void m11681z() throws IOException {
        this.f9735a.mo33757d(this.f9738d);
        Iterator<C3511d> it = this.f9745k.values().iterator();
        while (it.hasNext()) {
            C3511d next = it.next();
            int i = 0;
            if (next.f9771f == null) {
                while (i < this.f9742h) {
                    this.f9743i += next.f9767b[i];
                    i++;
                }
            } else {
                next.f9771f = null;
                while (i < this.f9742h) {
                    this.f9735a.mo33757d(next.f9768c[i]);
                    this.f9735a.mo33757d(next.f9769d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        return null;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized p113i.p114e0.p115e.C3505d.C3506e mo19385c(java.lang.String r4) throws java.io.IOException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.mo19391t()     // Catch:{ all -> 0x0050 }
            r3.m11679x()     // Catch:{ all -> 0x0050 }
            r3.m11678g(r4)     // Catch:{ all -> 0x0050 }
            java.util.LinkedHashMap<java.lang.String, i.e0.e.d$d> r0 = r3.f9745k     // Catch:{ all -> 0x0050 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0050 }
            i.e0.e.d$d r0 = (p113i.p114e0.p115e.C3505d.C3511d) r0     // Catch:{ all -> 0x0050 }
            r1 = 0
            if (r0 == 0) goto L_0x004e
            boolean r2 = r0.f9770e     // Catch:{ all -> 0x0050 }
            if (r2 != 0) goto L_0x001a
            goto L_0x004e
        L_0x001a:
            i.e0.e.d$e r0 = r0.mo19404a()     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x0022
            monitor-exit(r3)
            return r1
        L_0x0022:
            int r1 = r3.f9746l     // Catch:{ all -> 0x0050 }
            int r1 = r1 + 1
            r3.f9746l = r1     // Catch:{ all -> 0x0050 }
            j.d r1 = r3.f9744j     // Catch:{ all -> 0x0050 }
            java.lang.String r2 = "READ"
            j.d r1 = r1.mo19708e(r2)     // Catch:{ all -> 0x0050 }
            r2 = 32
            j.d r1 = r1.writeByte(r2)     // Catch:{ all -> 0x0050 }
            j.d r4 = r1.mo19708e(r4)     // Catch:{ all -> 0x0050 }
            r1 = 10
            r4.writeByte(r1)     // Catch:{ all -> 0x0050 }
            boolean r4 = r3.mo19392u()     // Catch:{ all -> 0x0050 }
            if (r4 == 0) goto L_0x004c
            java.util.concurrent.Executor r4 = r3.f9753s     // Catch:{ all -> 0x0050 }
            java.lang.Runnable r1 = r3.f9754t     // Catch:{ all -> 0x0050 }
            r4.execute(r1)     // Catch:{ all -> 0x0050 }
        L_0x004c:
            monitor-exit(r3)
            return r0
        L_0x004e:
            monitor-exit(r3)
            return r1
        L_0x0050:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p113i.p114e0.p115e.C3505d.mo19385c(java.lang.String):i.e0.e.d$e");
    }

    public synchronized void close() throws IOException {
        if (this.f9748n) {
            if (!this.f9749o) {
                for (C3511d dVar : (C3511d[]) this.f9745k.values().toArray(new C3511d[this.f9745k.size()])) {
                    if (dVar.f9771f != null) {
                        dVar.f9771f.mo19401a();
                    }
                }
                mo19394w();
                this.f9744j.close();
                this.f9744j = null;
                this.f9749o = true;
                return;
            }
        }
        this.f9749o = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        return r7;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo19388d(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.mo19391t()     // Catch:{ all -> 0x0029 }
            r6.m11679x()     // Catch:{ all -> 0x0029 }
            r6.m11678g(r7)     // Catch:{ all -> 0x0029 }
            java.util.LinkedHashMap<java.lang.String, i.e0.e.d$d> r0 = r6.f9745k     // Catch:{ all -> 0x0029 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0029 }
            i.e0.e.d$d r7 = (p113i.p114e0.p115e.C3505d.C3511d) r7     // Catch:{ all -> 0x0029 }
            r0 = 0
            if (r7 != 0) goto L_0x0017
            monitor-exit(r6)
            return r0
        L_0x0017:
            boolean r7 = r6.mo19384a((p113i.p114e0.p115e.C3505d.C3511d) r7)     // Catch:{ all -> 0x0029 }
            if (r7 == 0) goto L_0x0027
            long r1 = r6.f9743i     // Catch:{ all -> 0x0029 }
            long r3 = r6.f9741g     // Catch:{ all -> 0x0029 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0027
            r6.f9750p = r0     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r6)
            return r7
        L_0x0029:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p113i.p114e0.p115e.C3505d.mo19388d(java.lang.String):boolean");
    }

    public synchronized void flush() throws IOException {
        if (this.f9748n) {
            m11679x();
            mo19394w();
            this.f9744j.flush();
        }
    }

    public synchronized boolean isClosed() {
        return this.f9749o;
    }

    /* renamed from: t */
    public synchronized void mo19391t() throws IOException {
        if (!this.f9748n) {
            if (this.f9735a.mo33756c(this.f9739e)) {
                if (this.f9735a.mo33756c(this.f9737c)) {
                    this.f9735a.mo33757d(this.f9739e);
                } else {
                    this.f9735a.mo33754a(this.f9739e, this.f9737c);
                }
            }
            if (this.f9735a.mo33756c(this.f9737c)) {
                try {
                    m11675A();
                    m11681z();
                    this.f9748n = true;
                    return;
                } catch (IOException e) {
                    C3521f d = C3521f.m11740d();
                    d.mo19409a(5, "DiskLruCache " + this.f9736b + " is corrupt: " + e.getMessage() + ", removing", (Throwable) e);
                    mo19387d();
                    this.f9749o = false;
                } catch (Throwable th) {
                    this.f9749o = false;
                    throw th;
                }
            }
            mo19393v();
            this.f9748n = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public boolean mo19392u() {
        int i = this.f9746l;
        return i >= 2000 && i >= this.f9745k.size();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public synchronized void mo19393v() throws IOException {
        if (this.f9744j != null) {
            this.f9744j.close();
        }
        C3579d a = C6589n.m21609a(this.f9735a.mo33755b(this.f9738d));
        try {
            a.mo19708e("libcore.io.DiskLruCache").writeByte(10);
            a.mo19708e("1").writeByte(10);
            a.mo19719m((long) this.f9740f).writeByte(10);
            a.mo19719m((long) this.f9742h).writeByte(10);
            a.writeByte(10);
            for (C3511d next : this.f9745k.values()) {
                if (next.f9771f != null) {
                    a.mo19708e("DIRTY").writeByte(32);
                    a.mo19708e(next.f9766a);
                    a.writeByte(10);
                } else {
                    a.mo19708e("CLEAN").writeByte(32);
                    a.mo19708e(next.f9766a);
                    next.mo19405a(a);
                    a.writeByte(10);
                }
            }
            a.close();
            if (this.f9735a.mo33756c(this.f9737c)) {
                this.f9735a.mo33754a(this.f9737c, this.f9739e);
            }
            this.f9735a.mo33754a(this.f9738d, this.f9737c);
            this.f9735a.mo33757d(this.f9739e);
            this.f9744j = m11680y();
            this.f9747m = false;
            this.f9751q = false;
        } catch (Throwable th) {
            a.close();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public void mo19394w() throws IOException {
        while (this.f9743i > this.f9741g) {
            mo19384a(this.f9745k.values().iterator().next());
        }
        this.f9750p = false;
    }

    /* renamed from: i.e0.e.d$d */
    /* compiled from: DiskLruCache */
    private final class C3511d {

        /* renamed from: a */
        final String f9766a;

        /* renamed from: b */
        final long[] f9767b;

        /* renamed from: c */
        final File[] f9768c;

        /* renamed from: d */
        final File[] f9769d;

        /* renamed from: e */
        boolean f9770e;

        /* renamed from: f */
        C3509c f9771f;

        /* renamed from: g */
        long f9772g;

        C3511d(String str) {
            this.f9766a = str;
            int i = C3505d.this.f9742h;
            this.f9767b = new long[i];
            this.f9768c = new File[i];
            this.f9769d = new File[i];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < C3505d.this.f9742h; i2++) {
                sb.append(i2);
                this.f9768c[i2] = new File(C3505d.this.f9736b, sb.toString());
                sb.append(".tmp");
                this.f9769d[i2] = new File(C3505d.this.f9736b, sb.toString());
                sb.setLength(length);
            }
        }

        /* renamed from: b */
        private IOException m11701b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo19406a(String[] strArr) throws IOException {
            if (strArr.length == C3505d.this.f9742h) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.f9767b[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        m11701b(strArr);
                        throw null;
                    }
                }
                return;
            }
            m11701b(strArr);
            throw null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo19405a(C3579d dVar) throws IOException {
            for (long m : this.f9767b) {
                dVar.writeByte(32).mo19719m(m);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C3506e mo19404a() {
            if (Thread.holdsLock(C3505d.this)) {
                C3586u[] uVarArr = new C3586u[C3505d.this.f9742h];
                long[] jArr = (long[]) this.f9767b.clone();
                int i = 0;
                int i2 = 0;
                while (i2 < C3505d.this.f9742h) {
                    try {
                        uVarArr[i2] = C3505d.this.f9735a.mo33753a(this.f9768c[i2]);
                        i2++;
                    } catch (FileNotFoundException unused) {
                        while (i < C3505d.this.f9742h && uVarArr[i] != null) {
                            C3500c.m11649a((Closeable) uVarArr[i]);
                            i++;
                        }
                        try {
                            C3505d.this.mo19384a(this);
                            return null;
                        } catch (IOException unused2) {
                            return null;
                        }
                    }
                }
                return new C3506e(this.f9766a, this.f9772g, uVarArr, jArr);
            }
            throw new AssertionError();
        }
    }

    @Nullable
    /* renamed from: a */
    public C3509c mo19381a(String str) throws IOException {
        return mo19382a(str, -1);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized p113i.p114e0.p115e.C3505d.C3509c mo19382a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.mo19391t()     // Catch:{ all -> 0x0074 }
            r5.m11679x()     // Catch:{ all -> 0x0074 }
            r5.m11678g(r6)     // Catch:{ all -> 0x0074 }
            java.util.LinkedHashMap<java.lang.String, i.e0.e.d$d> r0 = r5.f9745k     // Catch:{ all -> 0x0074 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0074 }
            i.e0.e.d$d r0 = (p113i.p114e0.p115e.C3505d.C3511d) r0     // Catch:{ all -> 0x0074 }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0023
            if (r0 == 0) goto L_0x0021
            long r1 = r0.f9772g     // Catch:{ all -> 0x0074 }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0023
        L_0x0021:
            monitor-exit(r5)
            return r3
        L_0x0023:
            if (r0 == 0) goto L_0x002b
            i.e0.e.d$c r7 = r0.f9771f     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x002b
            monitor-exit(r5)
            return r3
        L_0x002b:
            boolean r7 = r5.f9750p     // Catch:{ all -> 0x0074 }
            if (r7 != 0) goto L_0x006b
            boolean r7 = r5.f9751q     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x0034
            goto L_0x006b
        L_0x0034:
            j.d r7 = r5.f9744j     // Catch:{ all -> 0x0074 }
            java.lang.String r8 = "DIRTY"
            j.d r7 = r7.mo19708e(r8)     // Catch:{ all -> 0x0074 }
            r8 = 32
            j.d r7 = r7.writeByte(r8)     // Catch:{ all -> 0x0074 }
            j.d r7 = r7.mo19708e(r6)     // Catch:{ all -> 0x0074 }
            r8 = 10
            r7.writeByte(r8)     // Catch:{ all -> 0x0074 }
            j.d r7 = r5.f9744j     // Catch:{ all -> 0x0074 }
            r7.flush()     // Catch:{ all -> 0x0074 }
            boolean r7 = r5.f9747m     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x0056
            monitor-exit(r5)
            return r3
        L_0x0056:
            if (r0 != 0) goto L_0x0062
            i.e0.e.d$d r0 = new i.e0.e.d$d     // Catch:{ all -> 0x0074 }
            r0.<init>(r6)     // Catch:{ all -> 0x0074 }
            java.util.LinkedHashMap<java.lang.String, i.e0.e.d$d> r7 = r5.f9745k     // Catch:{ all -> 0x0074 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0074 }
        L_0x0062:
            i.e0.e.d$c r6 = new i.e0.e.d$c     // Catch:{ all -> 0x0074 }
            r6.<init>(r0)     // Catch:{ all -> 0x0074 }
            r0.f9771f = r6     // Catch:{ all -> 0x0074 }
            monitor-exit(r5)
            return r6
        L_0x006b:
            java.util.concurrent.Executor r6 = r5.f9753s     // Catch:{ all -> 0x0074 }
            java.lang.Runnable r7 = r5.f9754t     // Catch:{ all -> 0x0074 }
            r6.execute(r7)     // Catch:{ all -> 0x0074 }
            monitor-exit(r5)
            return r3
        L_0x0074:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p113i.p114e0.p115e.C3505d.mo19382a(java.lang.String, long):i.e0.e.d$c");
    }

    /* renamed from: d */
    public void mo19387d() throws IOException {
        close();
        this.f9735a.deleteContents(this.f9736b);
    }

    /* renamed from: i.e0.e.d$c */
    /* compiled from: DiskLruCache */
    public final class C3509c {

        /* renamed from: a */
        final C3511d f9761a;

        /* renamed from: b */
        final boolean[] f9762b;

        /* renamed from: c */
        private boolean f9763c;

        /* renamed from: i.e0.e.d$c$a */
        /* compiled from: DiskLruCache */
        class C3510a extends C5932e {
            C3510a(C3585t tVar) {
                super(tVar);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo19399a(IOException iOException) {
                synchronized (C3505d.this) {
                    C3509c.this.mo19403c();
                }
            }
        }

        C3509c(C3511d dVar) {
            this.f9761a = dVar;
            this.f9762b = dVar.f9770e ? null : new boolean[C3505d.this.f9742h];
        }

        /* renamed from: a */
        public C3585t mo19400a(int i) {
            synchronized (C3505d.this) {
                if (this.f9763c) {
                    throw new IllegalStateException();
                } else if (this.f9761a.f9771f != this) {
                    C3585t a = C6589n.m21611a();
                    return a;
                } else {
                    if (!this.f9761a.f9770e) {
                        this.f9762b[i] = true;
                    }
                    try {
                        C3510a aVar = new C3510a(C3505d.this.f9735a.mo33755b(this.f9761a.f9769d[i]));
                        return aVar;
                    } catch (FileNotFoundException unused) {
                        return C6589n.m21611a();
                    }
                }
            }
        }

        /* renamed from: b */
        public void mo19402b() throws IOException {
            synchronized (C3505d.this) {
                if (!this.f9763c) {
                    if (this.f9761a.f9771f == this) {
                        C3505d.this.mo19383a(this, true);
                    }
                    this.f9763c = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo19403c() {
            if (this.f9761a.f9771f == this) {
                int i = 0;
                while (true) {
                    C3505d dVar = C3505d.this;
                    if (i < dVar.f9742h) {
                        try {
                            dVar.f9735a.mo33757d(this.f9761a.f9769d[i]);
                        } catch (IOException unused) {
                        }
                        i++;
                    } else {
                        this.f9761a.f9771f = null;
                        return;
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo19401a() throws IOException {
            synchronized (C3505d.this) {
                if (!this.f9763c) {
                    if (this.f9761a.f9771f == this) {
                        C3505d.this.mo19383a(this, false);
                    }
                    this.f9763c = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f4, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo19383a(p113i.p114e0.p115e.C3505d.C3509c r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            i.e0.e.d$d r0 = r10.f9761a     // Catch:{ all -> 0x00fb }
            i.e0.e.d$c r1 = r0.f9771f     // Catch:{ all -> 0x00fb }
            if (r1 != r10) goto L_0x00f5
            r1 = 0
            if (r11 == 0) goto L_0x0047
            boolean r2 = r0.f9770e     // Catch:{ all -> 0x00fb }
            if (r2 != 0) goto L_0x0047
            r2 = 0
        L_0x000f:
            int r3 = r9.f9742h     // Catch:{ all -> 0x00fb }
            if (r2 >= r3) goto L_0x0047
            boolean[] r3 = r10.f9762b     // Catch:{ all -> 0x00fb }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x00fb }
            if (r3 == 0) goto L_0x002d
            i.e0.h.a r3 = r9.f9735a     // Catch:{ all -> 0x00fb }
            java.io.File[] r4 = r0.f9769d     // Catch:{ all -> 0x00fb }
            r4 = r4[r2]     // Catch:{ all -> 0x00fb }
            boolean r3 = r3.mo33756c(r4)     // Catch:{ all -> 0x00fb }
            if (r3 != 0) goto L_0x002a
            r10.mo19401a()     // Catch:{ all -> 0x00fb }
            monitor-exit(r9)
            return
        L_0x002a:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x002d:
            r10.mo19401a()     // Catch:{ all -> 0x00fb }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fb }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
            r11.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x00fb }
            r11.append(r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fb }
            r10.<init>(r11)     // Catch:{ all -> 0x00fb }
            throw r10     // Catch:{ all -> 0x00fb }
        L_0x0047:
            int r10 = r9.f9742h     // Catch:{ all -> 0x00fb }
            if (r1 >= r10) goto L_0x007f
            java.io.File[] r10 = r0.f9769d     // Catch:{ all -> 0x00fb }
            r10 = r10[r1]     // Catch:{ all -> 0x00fb }
            if (r11 == 0) goto L_0x0077
            i.e0.h.a r2 = r9.f9735a     // Catch:{ all -> 0x00fb }
            boolean r2 = r2.mo33756c(r10)     // Catch:{ all -> 0x00fb }
            if (r2 == 0) goto L_0x007c
            java.io.File[] r2 = r0.f9768c     // Catch:{ all -> 0x00fb }
            r2 = r2[r1]     // Catch:{ all -> 0x00fb }
            i.e0.h.a r3 = r9.f9735a     // Catch:{ all -> 0x00fb }
            r3.mo33754a(r10, r2)     // Catch:{ all -> 0x00fb }
            long[] r10 = r0.f9767b     // Catch:{ all -> 0x00fb }
            r3 = r10[r1]     // Catch:{ all -> 0x00fb }
            i.e0.h.a r10 = r9.f9735a     // Catch:{ all -> 0x00fb }
            long r5 = r10.mo33760f(r2)     // Catch:{ all -> 0x00fb }
            long[] r10 = r0.f9767b     // Catch:{ all -> 0x00fb }
            r10[r1] = r5     // Catch:{ all -> 0x00fb }
            long r7 = r9.f9743i     // Catch:{ all -> 0x00fb }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f9743i = r7     // Catch:{ all -> 0x00fb }
            goto L_0x007c
        L_0x0077:
            i.e0.h.a r2 = r9.f9735a     // Catch:{ all -> 0x00fb }
            r2.mo33757d(r10)     // Catch:{ all -> 0x00fb }
        L_0x007c:
            int r1 = r1 + 1
            goto L_0x0047
        L_0x007f:
            int r10 = r9.f9746l     // Catch:{ all -> 0x00fb }
            r1 = 1
            int r10 = r10 + r1
            r9.f9746l = r10     // Catch:{ all -> 0x00fb }
            r10 = 0
            r0.f9771f = r10     // Catch:{ all -> 0x00fb }
            boolean r10 = r0.f9770e     // Catch:{ all -> 0x00fb }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00bb
            r0.f9770e = r1     // Catch:{ all -> 0x00fb }
            j.d r10 = r9.f9744j     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = "CLEAN"
            j.d r10 = r10.mo19708e(r1)     // Catch:{ all -> 0x00fb }
            r10.writeByte(r3)     // Catch:{ all -> 0x00fb }
            j.d r10 = r9.f9744j     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = r0.f9766a     // Catch:{ all -> 0x00fb }
            r10.mo19708e(r1)     // Catch:{ all -> 0x00fb }
            j.d r10 = r9.f9744j     // Catch:{ all -> 0x00fb }
            r0.mo19405a((p119j.C3579d) r10)     // Catch:{ all -> 0x00fb }
            j.d r10 = r9.f9744j     // Catch:{ all -> 0x00fb }
            r10.writeByte(r2)     // Catch:{ all -> 0x00fb }
            if (r11 == 0) goto L_0x00d9
            long r10 = r9.f9752r     // Catch:{ all -> 0x00fb }
            r1 = 1
            long r1 = r1 + r10
            r9.f9752r = r1     // Catch:{ all -> 0x00fb }
            r0.f9772g = r10     // Catch:{ all -> 0x00fb }
            goto L_0x00d9
        L_0x00bb:
            java.util.LinkedHashMap<java.lang.String, i.e0.e.d$d> r10 = r9.f9745k     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r0.f9766a     // Catch:{ all -> 0x00fb }
            r10.remove(r11)     // Catch:{ all -> 0x00fb }
            j.d r10 = r9.f9744j     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = "REMOVE"
            j.d r10 = r10.mo19708e(r11)     // Catch:{ all -> 0x00fb }
            r10.writeByte(r3)     // Catch:{ all -> 0x00fb }
            j.d r10 = r9.f9744j     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r0.f9766a     // Catch:{ all -> 0x00fb }
            r10.mo19708e(r11)     // Catch:{ all -> 0x00fb }
            j.d r10 = r9.f9744j     // Catch:{ all -> 0x00fb }
            r10.writeByte(r2)     // Catch:{ all -> 0x00fb }
        L_0x00d9:
            j.d r10 = r9.f9744j     // Catch:{ all -> 0x00fb }
            r10.flush()     // Catch:{ all -> 0x00fb }
            long r10 = r9.f9743i     // Catch:{ all -> 0x00fb }
            long r0 = r9.f9741g     // Catch:{ all -> 0x00fb }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ec
            boolean r10 = r9.mo19392u()     // Catch:{ all -> 0x00fb }
            if (r10 == 0) goto L_0x00f3
        L_0x00ec:
            java.util.concurrent.Executor r10 = r9.f9753s     // Catch:{ all -> 0x00fb }
            java.lang.Runnable r11 = r9.f9754t     // Catch:{ all -> 0x00fb }
            r10.execute(r11)     // Catch:{ all -> 0x00fb }
        L_0x00f3:
            monitor-exit(r9)
            return
        L_0x00f5:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fb }
            r10.<init>()     // Catch:{ all -> 0x00fb }
            throw r10     // Catch:{ all -> 0x00fb }
        L_0x00fb:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x00ff
        L_0x00fe:
            throw r10
        L_0x00ff:
            goto L_0x00fe
        */
        throw new UnsupportedOperationException("Method not decompiled: p113i.p114e0.p115e.C3505d.mo19383a(i.e0.e.d$c, boolean):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo19384a(C3511d dVar) throws IOException {
        C3509c cVar = dVar.f9771f;
        if (cVar != null) {
            cVar.mo19403c();
        }
        for (int i = 0; i < this.f9742h; i++) {
            this.f9735a.mo33757d(dVar.f9768c[i]);
            long j = this.f9743i;
            long[] jArr = dVar.f9767b;
            this.f9743i = j - jArr[i];
            jArr[i] = 0;
        }
        this.f9746l++;
        this.f9744j.mo19708e("REMOVE").writeByte(32).mo19708e(dVar.f9766a).writeByte(10);
        this.f9745k.remove(dVar.f9766a);
        if (mo19392u()) {
            this.f9753s.execute(this.f9754t);
        }
        return true;
    }
}
