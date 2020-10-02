package androidx.core.p016c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: androidx.core.c.c */
/* compiled from: SelfDestructiveThread */
public class C0760c {

    /* renamed from: a */
    private final Object f1937a = new Object();

    /* renamed from: b */
    private HandlerThread f1938b;

    /* renamed from: c */
    private Handler f1939c;

    /* renamed from: d */
    private int f1940d;

    /* renamed from: e */
    private Handler.Callback f1941e = new C0761a();

    /* renamed from: f */
    private final int f1942f;

    /* renamed from: g */
    private final int f1943g;

    /* renamed from: h */
    private final String f1944h;

    /* renamed from: androidx.core.c.c$a */
    /* compiled from: SelfDestructiveThread */
    class C0761a implements Handler.Callback {
        C0761a() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                C0760c.this.mo4005a();
                return true;
            } else if (i != 1) {
                return true;
            } else {
                C0760c.this.mo4006a((Runnable) message.obj);
                return true;
            }
        }
    }

    /* renamed from: androidx.core.c.c$b */
    /* compiled from: SelfDestructiveThread */
    class C0762b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Callable f1946a;

        /* renamed from: b */
        final /* synthetic */ Handler f1947b;

        /* renamed from: c */
        final /* synthetic */ C0765d f1948c;

        /* renamed from: androidx.core.c.c$b$a */
        /* compiled from: SelfDestructiveThread */
        class C0763a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Object f1949a;

            C0763a(Object obj) {
                this.f1949a = obj;
            }

            public void run() {
                C0762b.this.f1948c.mo3993a(this.f1949a);
            }
        }

        C0762b(C0760c cVar, Callable callable, Handler handler, C0765d dVar) {
            this.f1946a = callable;
            this.f1947b = handler;
            this.f1948c = dVar;
        }

        public void run() {
            Object obj;
            try {
                obj = this.f1946a.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.f1947b.post(new C0763a(obj));
        }
    }

    /* renamed from: androidx.core.c.c$c */
    /* compiled from: SelfDestructiveThread */
    class C0764c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AtomicReference f1951a;

        /* renamed from: b */
        final /* synthetic */ Callable f1952b;

        /* renamed from: c */
        final /* synthetic */ ReentrantLock f1953c;

        /* renamed from: d */
        final /* synthetic */ AtomicBoolean f1954d;

        /* renamed from: e */
        final /* synthetic */ Condition f1955e;

        C0764c(C0760c cVar, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.f1951a = atomicReference;
            this.f1952b = callable;
            this.f1953c = reentrantLock;
            this.f1954d = atomicBoolean;
            this.f1955e = condition;
        }

        public void run() {
            try {
                this.f1951a.set(this.f1952b.call());
            } catch (Exception unused) {
            }
            this.f1953c.lock();
            try {
                this.f1954d.set(false);
                this.f1955e.signal();
            } finally {
                this.f1953c.unlock();
            }
        }
    }

    /* renamed from: androidx.core.c.c$d */
    /* compiled from: SelfDestructiveThread */
    public interface C0765d<T> {
        /* renamed from: a */
        void mo3993a(T t);
    }

    public C0760c(String str, int i, int i2) {
        this.f1944h = str;
        this.f1943g = i;
        this.f1942f = i2;
        this.f1940d = 0;
    }

    /* renamed from: b */
    private void m2384b(Runnable runnable) {
        synchronized (this.f1937a) {
            if (this.f1938b == null) {
                HandlerThread handlerThread = new HandlerThread(this.f1944h, this.f1943g);
                this.f1938b = handlerThread;
                handlerThread.start();
                this.f1939c = new Handler(this.f1938b.getLooper(), this.f1941e);
                this.f1940d++;
            }
            this.f1939c.removeMessages(0);
            this.f1939c.sendMessage(this.f1939c.obtainMessage(1, runnable));
        }
    }

    /* renamed from: a */
    public <T> void mo4007a(Callable<T> callable, C0765d<T> dVar) {
        m2384b(new C0762b(this, callable, new Handler(), dVar));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:9|10|11|12|(4:25|14|15|16)(1:17)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T mo4004a(java.util.concurrent.Callable<T> r13, int r14) throws java.lang.InterruptedException {
        /*
            r12 = this;
            java.util.concurrent.locks.ReentrantLock r7 = new java.util.concurrent.locks.ReentrantLock
            r7.<init>()
            java.util.concurrent.locks.Condition r8 = r7.newCondition()
            java.util.concurrent.atomic.AtomicReference r9 = new java.util.concurrent.atomic.AtomicReference
            r9.<init>()
            java.util.concurrent.atomic.AtomicBoolean r10 = new java.util.concurrent.atomic.AtomicBoolean
            r0 = 1
            r10.<init>(r0)
            androidx.core.c.c$c r11 = new androidx.core.c.c$c
            r0 = r11
            r1 = r12
            r2 = r9
            r3 = r13
            r4 = r7
            r5 = r10
            r6 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r12.m2384b(r11)
            r7.lock()
            boolean r13 = r10.get()     // Catch:{ all -> 0x005c }
            if (r13 != 0) goto L_0x0034
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x005c }
            r7.unlock()
            return r13
        L_0x0034:
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x005c }
            long r0 = (long) r14     // Catch:{ all -> 0x005c }
            long r13 = r13.toNanos(r0)     // Catch:{ all -> 0x005c }
        L_0x003b:
            long r13 = r8.awaitNanos(r13)     // Catch:{ InterruptedException -> 0x003f }
        L_0x003f:
            boolean r0 = r10.get()     // Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x004d
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x005c }
            r7.unlock()
            return r13
        L_0x004d:
            r0 = 0
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0054
            goto L_0x003b
        L_0x0054:
            java.lang.InterruptedException r13 = new java.lang.InterruptedException     // Catch:{ all -> 0x005c }
            java.lang.String r14 = "timeout"
            r13.<init>(r14)     // Catch:{ all -> 0x005c }
            throw r13     // Catch:{ all -> 0x005c }
        L_0x005c:
            r13 = move-exception
            r7.unlock()
            goto L_0x0062
        L_0x0061:
            throw r13
        L_0x0062:
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.p016c.C0760c.mo4004a(java.util.concurrent.Callable, int):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4006a(Runnable runnable) {
        runnable.run();
        synchronized (this.f1937a) {
            this.f1939c.removeMessages(0);
            this.f1939c.sendMessageDelayed(this.f1939c.obtainMessage(0), (long) this.f1942f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4005a() {
        synchronized (this.f1937a) {
            if (!this.f1939c.hasMessages(1)) {
                this.f1938b.quit();
                this.f1938b = null;
                this.f1939c = null;
            }
        }
    }
}
