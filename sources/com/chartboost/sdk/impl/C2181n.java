package com.chartboost.sdk.impl;

import com.chartboost.sdk.Libraries.C2078f;
import com.chartboost.sdk.Libraries.C2082i;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C2087b;
import com.chartboost.sdk.Model.C2093h;
import com.chartboost.sdk.Tracking.C2098a;
import java.io.File;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.chartboost.sdk.impl.n */
public class C2181n {

    /* renamed from: a */
    private final Executor f7366a;

    /* renamed from: b */
    private final C2218v0 f7367b;

    /* renamed from: c */
    private final C2222w0 f7368c;

    /* renamed from: d */
    private final AtomicReference<C2093h> f7369d;

    /* renamed from: e */
    private final C2082i f7370e;

    /* renamed from: f */
    private final C2098a f7371f;

    /* renamed from: g */
    private final C2078f f7372g;

    /* renamed from: h */
    int f7373h = 1;

    /* renamed from: i */
    private C2177m f7374i = null;

    /* renamed from: j */
    private final PriorityQueue<C2173l> f7375j;

    /* renamed from: com.chartboost.sdk.impl.n$a */
    class C2182a implements Comparator<File> {
        C2182a(C2181n nVar) {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
        }
    }

    public C2181n(Executor executor, C2078f fVar, C2218v0 v0Var, C2222w0 w0Var, AtomicReference<C2093h> atomicReference, C2082i iVar, C2098a aVar) {
        this.f7366a = executor;
        this.f7372g = fVar;
        this.f7367b = v0Var;
        this.f7368c = w0Var;
        this.f7369d = atomicReference;
        this.f7370e = iVar;
        this.f7371f = aVar;
        this.f7375j = new PriorityQueue<>();
    }

    /* renamed from: d */
    private void m8680d() {
        C2173l poll;
        C2173l peek;
        if (!(this.f7374i == null || (peek = this.f7375j.peek()) == null)) {
            C2177m mVar = this.f7374i;
            if (mVar.f7348l.f7317b > peek.f7317b && mVar.mo9499b()) {
                this.f7375j.add(this.f7374i.f7348l);
                this.f7374i = null;
            }
        }
        while (this.f7374i == null && (poll = this.f7375j.poll()) != null) {
            if (poll.f7321f.get() > 0) {
                File file = new File(this.f7372g.mo9089a().f6867a, poll.f7320e);
                if (file.exists() || file.mkdirs() || file.isDirectory()) {
                    File file2 = new File(file, poll.f7318c);
                    if (file2.exists()) {
                        this.f7372g.mo9095c(file2);
                        poll.mo9391a(this.f7366a, true);
                    } else {
                        C2177m mVar2 = new C2177m(this, this.f7368c, poll, file2);
                        this.f7374i = mVar2;
                        this.f7367b.mo9524a(mVar2);
                        this.f7371f.mo9160a(poll.f7319d, poll.f7318c);
                    }
                } else {
                    CBLogging.m8154b("Downloader", "Unable to create directory " + file.getPath());
                    poll.mo9391a(this.f7366a, false);
                }
            }
        }
        if (this.f7374i != null) {
            if (this.f7373h != 2) {
                CBLogging.m8152a("Downloader", "Change state to DOWNLOADING");
                this.f7373h = 2;
            }
        } else if (this.f7373h != 1) {
            CBLogging.m8152a("Downloader", "Change state to IDLE");
            this.f7373h = 1;
        }
    }

    /* renamed from: a */
    public synchronized void mo9432a(int i, Map<String, C2087b> map, AtomicInteger atomicInteger, C2167j jVar) {
        synchronized (this) {
            long b = this.f7370e.mo9111b();
            AtomicInteger atomicInteger2 = new AtomicInteger();
            AtomicReference atomicReference = new AtomicReference(jVar);
            for (C2087b next : map.values()) {
                long j = b;
                long j2 = b;
                C2173l lVar = r2;
                C2173l lVar2 = new C2173l(this.f7370e, i, next.f6915b, next.f6916c, next.f6914a, atomicInteger, atomicReference, j, atomicInteger2);
                this.f7375j.add(lVar);
                b = j2;
            }
            int i2 = this.f7373h;
            if (i2 == 1 || i2 == 2) {
                m8680d();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x013d A[Catch:{ Exception -> 0x0193 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x017e A[SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo9435b() {
        /*
            r24 = this;
            r1 = r24
            monitor-enter(r24)
            int r0 = r1.f7373h     // Catch:{ all -> 0x019d }
            r2 = 1
            if (r0 == r2) goto L_0x000a
            monitor-exit(r24)
            return
        L_0x000a:
            java.lang.String r0 = "Downloader"
            java.lang.String r3 = "########### Trimming the disk cache"
            com.chartboost.sdk.Libraries.CBLogging.m8152a(r0, r3)     // Catch:{ Exception -> 0x0193 }
            com.chartboost.sdk.Libraries.f r0 = r1.f7372g     // Catch:{ Exception -> 0x0193 }
            com.chartboost.sdk.Libraries.g r0 = r0.mo9089a()     // Catch:{ Exception -> 0x0193 }
            java.io.File r0 = r0.f6867a     // Catch:{ Exception -> 0x0193 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0193 }
            r3.<init>()     // Catch:{ Exception -> 0x0193 }
            java.lang.String[] r4 = r0.list()     // Catch:{ Exception -> 0x0193 }
            if (r4 == 0) goto L_0x0065
            int r6 = r4.length     // Catch:{ Exception -> 0x0193 }
            if (r6 <= 0) goto L_0x0065
            int r6 = r4.length     // Catch:{ Exception -> 0x0193 }
            r7 = 0
        L_0x0029:
            if (r7 >= r6) goto L_0x0065
            r8 = r4[r7]     // Catch:{ Exception -> 0x0193 }
            java.lang.String r9 = "requests"
            boolean r9 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0193 }
            if (r9 != 0) goto L_0x0062
            java.lang.String r9 = "track"
            boolean r9 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0193 }
            if (r9 != 0) goto L_0x0062
            java.lang.String r9 = "session"
            boolean r9 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0193 }
            if (r9 != 0) goto L_0x0062
            java.lang.String r9 = "videoCompletionEvents"
            boolean r9 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0193 }
            if (r9 != 0) goto L_0x0062
            java.lang.String r9 = "."
            boolean r9 = r8.contains(r9)     // Catch:{ Exception -> 0x0193 }
            if (r9 == 0) goto L_0x0056
            goto L_0x0062
        L_0x0056:
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x0193 }
            r9.<init>(r0, r8)     // Catch:{ Exception -> 0x0193 }
            java.util.ArrayList r8 = com.chartboost.sdk.Libraries.CBUtility.m8163a((java.io.File) r9, (boolean) r2)     // Catch:{ Exception -> 0x0193 }
            r3.addAll(r8)     // Catch:{ Exception -> 0x0193 }
        L_0x0062:
            int r7 = r7 + 1
            goto L_0x0029
        L_0x0065:
            int r0 = r3.size()     // Catch:{ Exception -> 0x0193 }
            java.io.File[] r4 = new java.io.File[r0]     // Catch:{ Exception -> 0x0193 }
            r3.toArray(r4)     // Catch:{ Exception -> 0x0193 }
            if (r0 <= r2) goto L_0x0078
            com.chartboost.sdk.impl.n$a r3 = new com.chartboost.sdk.impl.n$a     // Catch:{ Exception -> 0x0193 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0193 }
            java.util.Arrays.sort(r4, r3)     // Catch:{ Exception -> 0x0193 }
        L_0x0078:
            if (r0 <= 0) goto L_0x0187
            java.util.concurrent.atomic.AtomicReference<com.chartboost.sdk.Model.h> r3 = r1.f7369d     // Catch:{ Exception -> 0x0193 }
            java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x0193 }
            com.chartboost.sdk.Model.h r3 = (com.chartboost.sdk.Model.C2093h) r3     // Catch:{ Exception -> 0x0193 }
            int r6 = r3.f7019s     // Catch:{ Exception -> 0x0193 }
            long r6 = (long) r6     // Catch:{ Exception -> 0x0193 }
            com.chartboost.sdk.Libraries.f r8 = r1.f7372g     // Catch:{ Exception -> 0x0193 }
            com.chartboost.sdk.Libraries.f r9 = r1.f7372g     // Catch:{ Exception -> 0x0193 }
            com.chartboost.sdk.Libraries.g r9 = r9.mo9089a()     // Catch:{ Exception -> 0x0193 }
            java.io.File r9 = r9.f6870d     // Catch:{ Exception -> 0x0193 }
            long r8 = r8.mo9088a((java.io.File) r9)     // Catch:{ Exception -> 0x0193 }
            com.chartboost.sdk.Libraries.i r10 = r1.f7370e     // Catch:{ Exception -> 0x0193 }
            long r10 = r10.mo9110a()     // Catch:{ Exception -> 0x0193 }
            java.util.List<java.lang.String> r12 = r3.f7004d     // Catch:{ Exception -> 0x0193 }
            java.lang.String r13 = "Downloader"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0193 }
            r14.<init>()     // Catch:{ Exception -> 0x0193 }
            java.lang.String r15 = "Total local file count:"
            r14.append(r15)     // Catch:{ Exception -> 0x0193 }
            r14.append(r0)     // Catch:{ Exception -> 0x0193 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0193 }
            com.chartboost.sdk.Libraries.CBLogging.m8152a(r13, r14)     // Catch:{ Exception -> 0x0193 }
            java.lang.String r13 = "Downloader"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0193 }
            r14.<init>()     // Catch:{ Exception -> 0x0193 }
            java.lang.String r15 = "Video Folder Size in bytes :"
            r14.append(r15)     // Catch:{ Exception -> 0x0193 }
            r14.append(r8)     // Catch:{ Exception -> 0x0193 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0193 }
            com.chartboost.sdk.Libraries.CBLogging.m8152a(r13, r14)     // Catch:{ Exception -> 0x0193 }
            java.lang.String r13 = "Downloader"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0193 }
            r14.<init>()     // Catch:{ Exception -> 0x0193 }
            java.lang.String r15 = "Max Bytes allowed:"
            r14.append(r15)     // Catch:{ Exception -> 0x0193 }
            r14.append(r6)     // Catch:{ Exception -> 0x0193 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0193 }
            com.chartboost.sdk.Libraries.CBLogging.m8152a(r13, r14)     // Catch:{ Exception -> 0x0193 }
            r13 = 0
        L_0x00de:
            if (r13 >= r0) goto L_0x0187
            r14 = r4[r13]     // Catch:{ Exception -> 0x0193 }
            java.util.concurrent.TimeUnit r15 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0193 }
            long r16 = r14.lastModified()     // Catch:{ Exception -> 0x0193 }
            r18 = r6
            long r5 = r10 - r16
            long r5 = r15.toDays(r5)     // Catch:{ Exception -> 0x0193 }
            int r7 = r3.f7021u     // Catch:{ Exception -> 0x0193 }
            r16 = r3
            long r2 = (long) r7     // Catch:{ Exception -> 0x0193 }
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 < 0) goto L_0x00fb
            r2 = 1
            goto L_0x00fc
        L_0x00fb:
            r2 = 0
        L_0x00fc:
            java.lang.String r3 = r14.getName()     // Catch:{ Exception -> 0x0193 }
            java.lang.String r5 = ".tmp"
            boolean r3 = r3.endsWith(r5)     // Catch:{ Exception -> 0x0193 }
            java.io.File r5 = r14.getParentFile()     // Catch:{ Exception -> 0x0193 }
            java.lang.String r6 = r5.getAbsolutePath()     // Catch:{ Exception -> 0x0193 }
            java.lang.String r7 = "/videos"
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x0193 }
            int r7 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r7 <= 0) goto L_0x011c
            if (r6 == 0) goto L_0x011c
            r7 = 1
            goto L_0x011d
        L_0x011c:
            r7 = 0
        L_0x011d:
            long r20 = r14.length()     // Catch:{ Exception -> 0x0193 }
            r22 = 0
            int r17 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r17 == 0) goto L_0x013a
            if (r3 != 0) goto L_0x013a
            if (r2 != 0) goto L_0x013a
            java.lang.String r2 = r5.getName()     // Catch:{ Exception -> 0x0193 }
            boolean r2 = r12.contains(r2)     // Catch:{ Exception -> 0x0193 }
            if (r2 != 0) goto L_0x013a
            if (r7 == 0) goto L_0x0138
            goto L_0x013a
        L_0x0138:
            r2 = 0
            goto L_0x013b
        L_0x013a:
            r2 = 1
        L_0x013b:
            if (r2 == 0) goto L_0x017e
            if (r6 == 0) goto L_0x0144
            long r2 = r14.length()     // Catch:{ Exception -> 0x0193 }
            long r8 = r8 - r2
        L_0x0144:
            java.lang.String r2 = "Downloader"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0193 }
            r3.<init>()     // Catch:{ Exception -> 0x0193 }
            java.lang.String r5 = "Deleting file at path:"
            r3.append(r5)     // Catch:{ Exception -> 0x0193 }
            java.lang.String r5 = r14.getPath()     // Catch:{ Exception -> 0x0193 }
            r3.append(r5)     // Catch:{ Exception -> 0x0193 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0193 }
            com.chartboost.sdk.Libraries.CBLogging.m8152a(r2, r3)     // Catch:{ Exception -> 0x0193 }
            boolean r2 = r14.delete()     // Catch:{ Exception -> 0x0193 }
            if (r2 != 0) goto L_0x017e
            java.lang.String r2 = "Downloader"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0193 }
            r3.<init>()     // Catch:{ Exception -> 0x0193 }
            java.lang.String r5 = "Unable to delete "
            r3.append(r5)     // Catch:{ Exception -> 0x0193 }
            java.lang.String r5 = r14.getPath()     // Catch:{ Exception -> 0x0193 }
            r3.append(r5)     // Catch:{ Exception -> 0x0193 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0193 }
            com.chartboost.sdk.Libraries.CBLogging.m8154b(r2, r3)     // Catch:{ Exception -> 0x0193 }
        L_0x017e:
            int r13 = r13 + 1
            r3 = r16
            r6 = r18
            r2 = 1
            goto L_0x00de
        L_0x0187:
            com.chartboost.sdk.Libraries.f r0 = r1.f7372g     // Catch:{ Exception -> 0x0193 }
            org.json.JSONObject r0 = r0.mo9091b()     // Catch:{ Exception -> 0x0193 }
            com.chartboost.sdk.Tracking.a r2 = r1.f7371f     // Catch:{ Exception -> 0x0193 }
            r2.mo9168a((org.json.JSONObject) r0)     // Catch:{ Exception -> 0x0193 }
            goto L_0x019b
        L_0x0193:
            r0 = move-exception
            java.lang.Class<com.chartboost.sdk.impl.n> r2 = com.chartboost.sdk.impl.C2181n.class
            java.lang.String r3 = "reduceCacheSize"
            com.chartboost.sdk.Tracking.C2098a.m8288a((java.lang.Class) r2, (java.lang.String) r3, (java.lang.Exception) r0)     // Catch:{ all -> 0x019d }
        L_0x019b:
            monitor-exit(r24)
            return
        L_0x019d:
            r0 = move-exception
            monitor-exit(r24)
            goto L_0x01a1
        L_0x01a0:
            throw r0
        L_0x01a1:
            goto L_0x01a0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C2181n.mo9435b():void");
    }

    /* renamed from: c */
    public synchronized void mo9436c() {
        int i = this.f7373h;
        if (i == 3) {
            CBLogging.m8152a("Downloader", "Change state to DOWNLOADING");
            this.f7373h = 2;
        } else if (i == 4) {
            CBLogging.m8152a("Downloader", "Change state to IDLE");
            this.f7373h = 1;
            m8680d();
        }
    }

    /* renamed from: a */
    public synchronized void mo9434a(AtomicInteger atomicInteger) {
        atomicInteger.set(-10000);
        int i = this.f7373h;
        boolean z = true;
        if (i != 1) {
            if (i == 2) {
                if (this.f7374i.f7348l.f7321f != atomicInteger) {
                    z = false;
                }
                if (z && this.f7374i.mo9499b()) {
                    this.f7374i = null;
                    m8680d();
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo9431a() {
        int i = this.f7373h;
        if (i == 1) {
            CBLogging.m8152a("Downloader", "Change state to PAUSED");
            this.f7373h = 4;
        } else if (i == 2) {
            if (this.f7374i.mo9499b()) {
                this.f7375j.add(this.f7374i.f7348l);
                this.f7374i = null;
                CBLogging.m8152a("Downloader", "Change state to PAUSED");
                this.f7373h = 4;
            } else {
                CBLogging.m8152a("Downloader", "Change state to PAUSING");
                this.f7373h = 3;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d7, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo9433a(com.chartboost.sdk.impl.C2177m r19, com.chartboost.sdk.Model.CBError r20, com.chartboost.sdk.impl.C2215u0 r21) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r21
            monitor-enter(r18)
            int r3 = r1.f7373h     // Catch:{ all -> 0x00d8 }
            r4 = 1
            if (r3 == r4) goto L_0x00d6
            r5 = 2
            r6 = 3
            if (r3 == r5) goto L_0x0014
            if (r3 == r6) goto L_0x0014
            goto L_0x00d6
        L_0x0014:
            com.chartboost.sdk.impl.m r3 = r1.f7374i     // Catch:{ all -> 0x00d8 }
            if (r0 == r3) goto L_0x001a
            monitor-exit(r18)
            return
        L_0x001a:
            com.chartboost.sdk.impl.l r3 = r0.f7348l     // Catch:{ all -> 0x00d8 }
            r5 = 0
            r1.f7374i = r5     // Catch:{ all -> 0x00d8 }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x00d8 }
            long r7 = r0.f7437f     // Catch:{ all -> 0x00d8 }
            long r12 = r5.toMillis(r7)     // Catch:{ all -> 0x00d8 }
            java.util.concurrent.atomic.AtomicInteger r5 = r3.f7324i     // Catch:{ all -> 0x00d8 }
            int r7 = (int) r12     // Catch:{ all -> 0x00d8 }
            r5.addAndGet(r7)     // Catch:{ all -> 0x00d8 }
            java.util.concurrent.Executor r5 = r1.f7366a     // Catch:{ all -> 0x00d8 }
            if (r20 != 0) goto L_0x0032
            goto L_0x0033
        L_0x0032:
            r4 = 0
        L_0x0033:
            r3.mo9391a(r5, r4)     // Catch:{ all -> 0x00d8 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x00d8 }
            long r7 = r0.f7438g     // Catch:{ all -> 0x00d8 }
            long r14 = r4.toMillis(r7)     // Catch:{ all -> 0x00d8 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x00d8 }
            long r7 = r0.f7439h     // Catch:{ all -> 0x00d8 }
            long r16 = r4.toMillis(r7)     // Catch:{ all -> 0x00d8 }
            if (r20 != 0) goto L_0x006c
            com.chartboost.sdk.Tracking.a r9 = r1.f7371f     // Catch:{ all -> 0x00d8 }
            java.lang.String r10 = r3.f7319d     // Catch:{ all -> 0x00d8 }
            r11 = r12
            r13 = r14
            r15 = r16
            r9.mo9159a((java.lang.String) r10, (long) r11, (long) r13, (long) r15)     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r0.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = "Downloaded "
            r0.append(r2)     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = r3.f7319d     // Catch:{ all -> 0x00d8 }
            r0.append(r2)     // Catch:{ all -> 0x00d8 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = "Downloader"
            com.chartboost.sdk.Libraries.CBLogging.m8152a(r2, r0)     // Catch:{ all -> 0x00d8 }
            goto L_0x00c4
        L_0x006c:
            java.lang.String r0 = r20.mo9115b()     // Catch:{ all -> 0x00d8 }
            com.chartboost.sdk.Tracking.a r9 = r1.f7371f     // Catch:{ all -> 0x00d8 }
            java.lang.String r10 = r3.f7319d     // Catch:{ all -> 0x00d8 }
            r11 = r0
            r9.mo9161a((java.lang.String) r10, (java.lang.String) r11, (long) r12, (long) r14, (long) r16)     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = "Downloader"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r5.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r7 = "Failed to download "
            r5.append(r7)     // Catch:{ all -> 0x00d8 }
            java.lang.String r3 = r3.f7319d     // Catch:{ all -> 0x00d8 }
            r5.append(r3)     // Catch:{ all -> 0x00d8 }
            if (r2 == 0) goto L_0x009f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r3.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r7 = " Status code="
            r3.append(r7)     // Catch:{ all -> 0x00d8 }
            int r2 = r2.f7464a     // Catch:{ all -> 0x00d8 }
            r3.append(r2)     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x00d8 }
            goto L_0x00a1
        L_0x009f:
            java.lang.String r2 = ""
        L_0x00a1:
            r5.append(r2)     // Catch:{ all -> 0x00d8 }
            if (r0 == 0) goto L_0x00b8
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r2.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r3 = " Error message="
            r2.append(r3)     // Catch:{ all -> 0x00d8 }
            r2.append(r0)     // Catch:{ all -> 0x00d8 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00d8 }
            goto L_0x00ba
        L_0x00b8:
            java.lang.String r0 = ""
        L_0x00ba:
            r5.append(r0)     // Catch:{ all -> 0x00d8 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00d8 }
            com.chartboost.sdk.Libraries.CBLogging.m8152a(r4, r0)     // Catch:{ all -> 0x00d8 }
        L_0x00c4:
            int r0 = r1.f7373h     // Catch:{ all -> 0x00d8 }
            if (r0 != r6) goto L_0x00d3
            java.lang.String r0 = "Downloader"
            java.lang.String r2 = "Change state to PAUSED"
            com.chartboost.sdk.Libraries.CBLogging.m8152a(r0, r2)     // Catch:{ all -> 0x00d8 }
            r0 = 4
            r1.f7373h = r0     // Catch:{ all -> 0x00d8 }
            goto L_0x00d6
        L_0x00d3:
            r18.m8680d()     // Catch:{ all -> 0x00d8 }
        L_0x00d6:
            monitor-exit(r18)
            return
        L_0x00d8:
            r0 = move-exception
            monitor-exit(r18)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C2181n.mo9433a(com.chartboost.sdk.impl.m, com.chartboost.sdk.Model.CBError, com.chartboost.sdk.impl.u0):void");
    }
}
