package okhttp3.internal.http2;

import android.support.p004v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.http2.C6616b;
import p113i.C3537r;
import p113i.p114e0.C3500c;
import p119j.C3573a;
import p119j.C3577c;
import p119j.C3580e;
import p119j.C3585t;
import p119j.C3586u;
import p119j.C3587v;

/* renamed from: okhttp3.internal.http2.h */
/* compiled from: Http2Stream */
public final class C3592h {

    /* renamed from: a */
    long f10068a = 0;

    /* renamed from: b */
    long f10069b;

    /* renamed from: c */
    final int f10070c;

    /* renamed from: d */
    final C6624f f10071d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Deque<C3537r> f10072e = new ArrayDeque();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C6616b.C6617a f10073f;

    /* renamed from: g */
    private boolean f10074g;

    /* renamed from: h */
    private final C3594b f10075h;

    /* renamed from: i */
    final C3593a f10076i;

    /* renamed from: j */
    final C3595c f10077j = new C3595c();

    /* renamed from: k */
    final C3595c f10078k = new C3595c();

    /* renamed from: l */
    C6615a f10079l = null;

    /* renamed from: okhttp3.internal.http2.h$b */
    /* compiled from: Http2Stream */
    private final class C3594b implements C3586u {

        /* renamed from: a */
        private final C3577c f10084a = new C3577c();

        /* renamed from: b */
        private final C3577c f10085b = new C3577c();

        /* renamed from: c */
        private final long f10086c;

        /* renamed from: d */
        boolean f10087d;

        /* renamed from: e */
        boolean f10088e;

        C3594b(long j) {
            this.f10086c = j;
        }

        /* renamed from: e */
        private void m12261e(long j) {
            C3592h.this.f10071d.mo35701e(j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo19810a(C3580e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (C3592h.this) {
                    z = this.f10088e;
                    z2 = true;
                    z3 = this.f10085b.size() + j > this.f10086c;
                }
                if (z3) {
                    eVar.skip(j);
                    C3592h.this.mo19798b(C6615a.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.skip(j);
                    return;
                } else {
                    long read = eVar.read(this.f10084a, j);
                    if (read != -1) {
                        j -= read;
                        synchronized (C3592h.this) {
                            if (this.f10085b.size() != 0) {
                                z2 = false;
                            }
                            this.f10085b.mo19692a((C3586u) this.f10084a);
                            if (z2) {
                                C3592h.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public void close() throws IOException {
            long size;
            C6616b.C6617a aVar;
            ArrayList<C3537r> arrayList;
            synchronized (C3592h.this) {
                this.f10087d = true;
                size = this.f10085b.size();
                this.f10085b.mo19706d();
                aVar = null;
                if (C3592h.this.f10072e.isEmpty() || C3592h.this.f10073f == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList(C3592h.this.f10072e);
                    C3592h.this.f10072e.clear();
                    ArrayList arrayList3 = arrayList2;
                    aVar = C3592h.this.f10073f;
                    arrayList = arrayList3;
                }
                C3592h.this.notifyAll();
            }
            if (size > 0) {
                m12261e(size);
            }
            C3592h.this.mo19792a();
            if (aVar != null) {
                for (C3537r a : arrayList) {
                    aVar.mo35674a(a);
                }
            }
        }

        public long read(C3577c cVar, long j) throws IOException {
            C6615a aVar;
            long j2;
            C6616b.C6617a aVar2;
            C3537r rVar;
            long j3 = j;
            if (j3 >= 0) {
                while (true) {
                    synchronized (C3592h.this) {
                        C3592h.this.f10077j.mo19668g();
                        try {
                            aVar = C3592h.this.f10079l != null ? C3592h.this.f10079l : null;
                            if (!this.f10087d) {
                                if (C3592h.this.f10072e.isEmpty() || C3592h.this.f10073f == null) {
                                    if (this.f10085b.size() > 0) {
                                        j2 = this.f10085b.read(cVar, Math.min(j3, this.f10085b.size()));
                                        C3592h.this.f10068a += j2;
                                        if (aVar == null && C3592h.this.f10068a >= ((long) (C3592h.this.f10071d.f17384n.mo35751c() / 2))) {
                                            C3592h.this.f10071d.mo35685a(C3592h.this.f10070c, C3592h.this.f10068a);
                                            C3592h.this.f10068a = 0;
                                        }
                                    } else {
                                        C3577c cVar2 = cVar;
                                        if (this.f10088e || aVar != null) {
                                            j2 = -1;
                                        } else {
                                            C3592h.this.mo19808k();
                                        }
                                    }
                                    rVar = null;
                                    aVar2 = null;
                                } else {
                                    rVar = (C3537r) C3592h.this.f10072e.removeFirst();
                                    aVar2 = C3592h.this.f10073f;
                                    C3577c cVar3 = cVar;
                                    j2 = -1;
                                }
                                C3592h.this.f10077j.mo19811k();
                                if (rVar != null && aVar2 != null) {
                                    aVar2.mo35674a(rVar);
                                }
                            } else {
                                throw new IOException("stream closed");
                            }
                        } finally {
                            C3592h.this.f10077j.mo19811k();
                        }
                    }
                }
                if (j2 != -1) {
                    m12261e(j2);
                    return j2;
                } else if (aVar == null) {
                    return -1;
                } else {
                    throw new StreamResetException(aVar);
                }
            } else {
                throw new IllegalArgumentException("byteCount < 0: " + j3);
            }
        }

        public C3587v timeout() {
            return C3592h.this.f10077j;
        }
    }

    /* renamed from: okhttp3.internal.http2.h$c */
    /* compiled from: Http2Stream */
    class C3595c extends C3573a {
        C3595c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public IOException mo19667b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        /* renamed from: i */
        public void mo19594i() {
            C3592h.this.mo19798b(C6615a.CANCEL);
        }

        /* renamed from: k */
        public void mo19811k() throws IOException {
            if (mo19669h()) {
                throw mo19667b((IOException) null);
            }
        }
    }

    C3592h(int i, C6624f fVar, boolean z, boolean z2, @Nullable C3537r rVar) {
        if (fVar != null) {
            this.f10070c = i;
            this.f10071d = fVar;
            this.f10069b = (long) fVar.f17385o.mo35751c();
            this.f10075h = new C3594b((long) fVar.f17384n.mo35751c());
            C3593a aVar = new C3593a();
            this.f10076i = aVar;
            this.f10075h.f10088e = z2;
            aVar.f10082c = z;
            if (rVar != null) {
                this.f10072e.add(rVar);
            }
            if (mo19803f() && rVar != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!mo19803f() && rVar == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    /* renamed from: c */
    public int mo19799c() {
        return this.f10070c;
    }

    /* renamed from: d */
    public C3585t mo19801d() {
        synchronized (this) {
            if (!this.f10074g) {
                if (!mo19803f()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f10076i;
    }

    /* renamed from: e */
    public C3586u mo19802e() {
        return this.f10075h;
    }

    /* renamed from: f */
    public boolean mo19803f() {
        if (this.f10071d.f17371a == ((this.f10070c & 1) == 1)) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public synchronized boolean mo19804g() {
        if (this.f10079l != null) {
            return false;
        }
        if ((this.f10075h.f10088e || this.f10075h.f10087d) && ((this.f10076i.f10082c || this.f10076i.f10081b) && this.f10074g)) {
            return false;
        }
        return true;
    }

    /* renamed from: h */
    public C3587v mo19805h() {
        return this.f10077j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo19806i() {
        boolean g;
        synchronized (this) {
            this.f10075h.f10088e = true;
            g = mo19804g();
            notifyAll();
        }
        if (!g) {
            this.f10071d.mo35697c(this.f10070c);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        r2.f10077j.mo19811k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized p113i.C3537r mo19807j() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            okhttp3.internal.http2.h$c r0 = r2.f10077j     // Catch:{ all -> 0x003c }
            r0.mo19668g()     // Catch:{ all -> 0x003c }
        L_0x0006:
            java.util.Deque<i.r> r0 = r2.f10072e     // Catch:{ all -> 0x0035 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0016
            okhttp3.internal.http2.a r0 = r2.f10079l     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0016
            r2.mo19808k()     // Catch:{ all -> 0x0035 }
            goto L_0x0006
        L_0x0016:
            okhttp3.internal.http2.h$c r0 = r2.f10077j     // Catch:{ all -> 0x003c }
            r0.mo19811k()     // Catch:{ all -> 0x003c }
            java.util.Deque<i.r> r0 = r2.f10072e     // Catch:{ all -> 0x003c }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x002d
            java.util.Deque<i.r> r0 = r2.f10072e     // Catch:{ all -> 0x003c }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x003c }
            i.r r0 = (p113i.C3537r) r0     // Catch:{ all -> 0x003c }
            monitor-exit(r2)
            return r0
        L_0x002d:
            okhttp3.internal.http2.StreamResetException r0 = new okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x003c }
            okhttp3.internal.http2.a r1 = r2.f10079l     // Catch:{ all -> 0x003c }
            r0.<init>(r1)     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x0035:
            r0 = move-exception
            okhttp3.internal.http2.h$c r1 = r2.f10077j     // Catch:{ all -> 0x003c }
            r1.mo19811k()     // Catch:{ all -> 0x003c }
            throw r0     // Catch:{ all -> 0x003c }
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)
            goto L_0x0040
        L_0x003f:
            throw r0
        L_0x0040:
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C3592h.mo19807j():i.r");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo19808k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    /* renamed from: l */
    public C3587v mo19809l() {
        return this.f10078k;
    }

    /* renamed from: a */
    public void mo19796a(C6615a aVar) throws IOException {
        if (m12240d(aVar)) {
            this.f10071d.mo35695b(this.f10070c, aVar);
        }
    }

    /* renamed from: b */
    public void mo19798b(C6615a aVar) {
        if (m12240d(aVar)) {
            this.f10071d.mo35698c(this.f10070c, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized void mo19800c(C6615a aVar) {
        if (this.f10079l == null) {
            this.f10079l = aVar;
            notifyAll();
        }
    }

    /* renamed from: okhttp3.internal.http2.h$a */
    /* compiled from: Http2Stream */
    final class C3593a implements C3585t {

        /* renamed from: a */
        private final C3577c f10080a = new C3577c();

        /* renamed from: b */
        boolean f10081b;

        /* renamed from: c */
        boolean f10082c;

        C3593a() {
        }

        /* renamed from: a */
        public void mo19670a(C3577c cVar, long j) throws IOException {
            this.f10080a.mo19670a(cVar, j);
            while (this.f10080a.size() >= PlaybackStateCompat.ACTION_PREPARE) {
                m12259a(false);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
            if (r8.f10080a.size() <= 0) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (r8.f10080a.size() <= 0) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
            m12259a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
            r0 = r8.f10083d;
            r0.f10071d.mo35690a(r0.f10070c, true, (p119j.C3577c) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
            r2 = r8.f10083d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r8.f10081b = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
            r8.f10083d.f10071d.flush();
            r8.f10083d.mo19792a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r8.f10083d.f10076i.f10082c != false) goto L_0x003a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r8 = this;
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C3592h.this
                monitor-enter(r0)
                boolean r1 = r8.f10081b     // Catch:{ all -> 0x0050 }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                return
            L_0x0009:
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C3592h.this
                okhttp3.internal.http2.h$a r0 = r0.f10076i
                boolean r0 = r0.f10082c
                r1 = 1
                if (r0 != 0) goto L_0x003a
                j.c r0 = r8.f10080a
                long r2 = r0.size()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x002d
            L_0x001f:
                j.c r0 = r8.f10080a
                long r2 = r0.size()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x003a
                r8.m12259a(r1)
                goto L_0x001f
            L_0x002d:
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C3592h.this
                okhttp3.internal.http2.f r2 = r0.f10071d
                int r3 = r0.f10070c
                r4 = 1
                r5 = 0
                r6 = 0
                r2.mo35690a((int) r3, (boolean) r4, (p119j.C3577c) r5, (long) r6)
            L_0x003a:
                okhttp3.internal.http2.h r2 = okhttp3.internal.http2.C3592h.this
                monitor-enter(r2)
                r8.f10081b = r1     // Catch:{ all -> 0x004d }
                monitor-exit(r2)     // Catch:{ all -> 0x004d }
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C3592h.this
                okhttp3.internal.http2.f r0 = r0.f10071d
                r0.flush()
                okhttp3.internal.http2.h r0 = okhttp3.internal.http2.C3592h.this
                r0.mo19792a()
                return
            L_0x004d:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x004d }
                throw r0
            L_0x0050:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                goto L_0x0054
            L_0x0053:
                throw r1
            L_0x0054:
                goto L_0x0053
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C3592h.C3593a.close():void");
        }

        public void flush() throws IOException {
            synchronized (C3592h.this) {
                C3592h.this.mo19797b();
            }
            while (this.f10080a.size() > 0) {
                m12259a(false);
                C3592h.this.f10071d.flush();
            }
        }

        public C3587v timeout() {
            return C3592h.this.f10078k;
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        private void m12259a(boolean z) throws IOException {
            long min;
            synchronized (C3592h.this) {
                C3592h.this.f10078k.mo19668g();
                while (C3592h.this.f10069b <= 0 && !this.f10082c && !this.f10081b && C3592h.this.f10079l == null) {
                    try {
                        C3592h.this.mo19808k();
                    } catch (Throwable th) {
                        C3592h.this.f10078k.mo19811k();
                        throw th;
                    }
                }
                C3592h.this.f10078k.mo19811k();
                C3592h.this.mo19797b();
                min = Math.min(C3592h.this.f10069b, this.f10080a.size());
                C3592h.this.f10069b -= min;
            }
            C3592h.this.f10078k.mo19668g();
            try {
                C3592h.this.f10071d.mo35690a(C3592h.this.f10070c, z && min == this.f10080a.size(), this.f10080a, min);
            } finally {
                C3592h.this.f10078k.mo19811k();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19795a(List<C6616b> list) {
        boolean g;
        synchronized (this) {
            this.f10074g = true;
            this.f10072e.add(C3500c.m11659b(list));
            g = mo19804g();
            notifyAll();
        }
        if (!g) {
            this.f10071d.mo35697c(this.f10070c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo19797b() throws IOException {
        C3593a aVar = this.f10076i;
        if (aVar.f10081b) {
            throw new IOException("stream closed");
        } else if (aVar.f10082c) {
            throw new IOException("stream finished");
        } else if (this.f10079l != null) {
            throw new StreamResetException(this.f10079l);
        }
    }

    /* renamed from: d */
    private boolean m12240d(C6615a aVar) {
        synchronized (this) {
            if (this.f10079l != null) {
                return false;
            }
            if (this.f10075h.f10088e && this.f10076i.f10082c) {
                return false;
            }
            this.f10079l = aVar;
            notifyAll();
            this.f10071d.mo35697c(this.f10070c);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19794a(C3580e eVar, int i) throws IOException {
        this.f10075h.mo19810a(eVar, (long) i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19792a() throws IOException {
        boolean z;
        boolean g;
        synchronized (this) {
            z = !this.f10075h.f10088e && this.f10075h.f10087d && (this.f10076i.f10082c || this.f10076i.f10081b);
            g = mo19804g();
        }
        if (z) {
            mo19796a(C6615a.CANCEL);
        } else if (!g) {
            this.f10071d.mo35697c(this.f10070c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo19793a(long j) {
        this.f10069b += j;
        if (j > 0) {
            notifyAll();
        }
    }
}
