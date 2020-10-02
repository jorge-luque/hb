package com.tapjoy.internal;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.TJConnectListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tapjoy.internal.gb */
public abstract class C5108gb {

    /* renamed from: a */
    private final ReentrantLock f13976a;

    /* renamed from: b */
    volatile int f13977b = C5116c.f13999a;

    /* renamed from: c */
    C5113b f13978c;

    /* renamed from: d */
    long f13979d = 1000;

    /* renamed from: e */
    C5112a f13980e;

    /* renamed from: f */
    private final Condition f13981f;

    /* renamed from: g */
    private final LinkedList f13982g = new LinkedList();

    /* renamed from: h */
    private C5112a f13983h;

    /* renamed from: com.tapjoy.internal.gb$3 */
    static /* synthetic */ class C51113 {

        /* renamed from: a */
        static final /* synthetic */ int[] f13986a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0027 */
        static {
            /*
                int[] r0 = com.tapjoy.internal.C5108gb.C5116c.m17256a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13986a = r0
                r1 = 1
                int r2 = com.tapjoy.internal.C5108gb.C5116c.f14003e     // Catch:{ NoSuchFieldError -> 0x000f }
                int r2 = r2 - r1
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f13986a     // Catch:{ NoSuchFieldError -> 0x0017 }
                int r2 = com.tapjoy.internal.C5108gb.C5116c.f13999a     // Catch:{ NoSuchFieldError -> 0x0017 }
                int r2 = r2 - r1
                r3 = 2
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r0 = f13986a     // Catch:{ NoSuchFieldError -> 0x001f }
                int r2 = com.tapjoy.internal.C5108gb.C5116c.f14000b     // Catch:{ NoSuchFieldError -> 0x001f }
                int r2 = r2 - r1
                r3 = 3
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f13986a     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r2 = com.tapjoy.internal.C5108gb.C5116c.f14001c     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r2 = r2 - r1
                r3 = 4
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0027 }
            L_0x0027:
                int[] r0 = f13986a     // Catch:{ NoSuchFieldError -> 0x002f }
                int r2 = com.tapjoy.internal.C5108gb.C5116c.f14002d     // Catch:{ NoSuchFieldError -> 0x002f }
                int r2 = r2 - r1
                r1 = 5
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x002f }
            L_0x002f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5108gb.C51113.<clinit>():void");
        }
    }

    /* renamed from: com.tapjoy.internal.gb$a */
    class C5112a {

        /* renamed from: a */
        public final Context f13987a;

        /* renamed from: b */
        public final String f13988b;

        /* renamed from: c */
        public final Hashtable f13989c;

        public C5112a(Context context, String str, Hashtable hashtable) {
            Context context2;
            if (context != null) {
                context2 = context instanceof Application ? context : context.getApplicationContext();
            } else {
                context2 = null;
            }
            this.f13987a = context2 != null ? context2 : context;
            this.f13988b = str;
            this.f13989c = hashtable;
        }
    }

    /* renamed from: com.tapjoy.internal.gb$b */
    class C5113b extends C5252ka {

        /* renamed from: b */
        private boolean f13992b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public boolean f13993c;

        /* renamed from: d */
        private Context f13994d;

        /* renamed from: e */
        private BroadcastReceiver f13995e;

        private C5113b() {
            this.f13995e = new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    C5108gb.this.mo31286b();
                }
            };
        }

        /* renamed from: h */
        private void m17251h() {
            this.f13994d.unregisterReceiver(this.f13995e);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public final void mo31290b() {
            C5108gb gbVar = C5108gb.this;
            int i = C5116c.f14001c;
            int i2 = C5116c.f14000b;
            gbVar.mo31283a(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public final void mo31291c() {
            C5108gb gbVar = C5108gb.this;
            if (gbVar.f13978c == this) {
                gbVar.f13978c = null;
            }
            if (C5108gb.this.f13977b == C5116c.f14001c) {
                C5108gb gbVar2 = C5108gb.this;
                int i = C5116c.f13999a;
                int i2 = C5116c.f14001c;
                gbVar2.mo31283a(i);
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x004e */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0064 A[SYNTHETIC, Splitter:B:17:0x0064] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0052 A[SYNTHETIC] */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo31292d() {
            /*
                r7 = this;
                com.tapjoy.internal.gb r0 = com.tapjoy.internal.C5108gb.this
                com.tapjoy.internal.gb$a r0 = r0.mo31282a()
                android.content.Context r0 = r0.f13987a
                r7.f13994d = r0
                android.content.IntentFilter r0 = new android.content.IntentFilter
                java.lang.String r1 = "android.net.conn.CONNECTIVITY_CHANGE"
                r0.<init>(r1)
                android.content.Context r1 = r7.f13994d
                android.content.BroadcastReceiver r2 = r7.f13995e
                r1.registerReceiver(r2, r0)
            L_0x0018:
                boolean r0 = r7.f13992b     // Catch:{ all -> 0x008b }
                if (r0 != 0) goto L_0x0087
                java.util.concurrent.CountDownLatch r0 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x008b }
                r1 = 1
                r0.<init>(r1)     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.fs$a r2 = com.tapjoy.internal.C5096fs.f13949b     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.gb$b$1 r3 = new com.tapjoy.internal.gb$b$1     // Catch:{ all -> 0x008b }
                r3.<init>(r0)     // Catch:{ all -> 0x008b }
                r2.addObserver(r3)     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.gb r2 = com.tapjoy.internal.C5108gb.this     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.gb$a r2 = r2.mo31282a()     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.gb r3 = com.tapjoy.internal.C5108gb.this     // Catch:{ all -> 0x008b }
                android.content.Context r4 = r2.f13987a     // Catch:{ all -> 0x008b }
                java.lang.String r5 = r2.f13988b     // Catch:{ all -> 0x008b }
                java.util.Hashtable r2 = r2.f13989c     // Catch:{ all -> 0x008b }
                r6 = 0
                boolean r2 = r3.mo31194a(r4, r5, r2, r6)     // Catch:{ all -> 0x008b }
                r3 = 0
                if (r2 != 0) goto L_0x004b
                com.tapjoy.internal.gb r0 = com.tapjoy.internal.C5108gb.this     // Catch:{ all -> 0x008b }
                r0.mo31284a((boolean) r3)     // Catch:{ all -> 0x008b }
                r7.m17251h()
                return
            L_0x004b:
                r0.await()     // Catch:{ InterruptedException -> 0x004e }
            L_0x004e:
                boolean r0 = r7.f13993c     // Catch:{ all -> 0x008b }
                if (r0 == 0) goto L_0x0064
                com.tapjoy.internal.gb r0 = com.tapjoy.internal.C5108gb.this     // Catch:{ all -> 0x008b }
                int r2 = com.tapjoy.internal.C5108gb.C5116c.f14003e     // Catch:{ all -> 0x008b }
                int r3 = com.tapjoy.internal.C5108gb.C5116c.f14001c     // Catch:{ all -> 0x008b }
                r0.mo31283a((int) r2)     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.gb r0 = com.tapjoy.internal.C5108gb.this     // Catch:{ all -> 0x008b }
                r0.mo31284a((boolean) r1)     // Catch:{ all -> 0x008b }
                r7.m17251h()
                return
            L_0x0064:
                com.tapjoy.internal.gb r0 = com.tapjoy.internal.C5108gb.this     // Catch:{ all -> 0x008b }
                r0.mo31284a((boolean) r3)     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.gb r0 = com.tapjoy.internal.C5108gb.this     // Catch:{ all -> 0x008b }
                long r0 = r0.f13979d     // Catch:{ all -> 0x008b }
                r2 = 1000(0x3e8, double:4.94E-321)
                long r0 = java.lang.Math.max(r0, r2)     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.gb r2 = com.tapjoy.internal.C5108gb.this     // Catch:{ all -> 0x008b }
                r3 = 2
                long r3 = r0 << r3
                r5 = 3600000(0x36ee80, double:1.7786363E-317)
                long r3 = java.lang.Math.min(r3, r5)     // Catch:{ all -> 0x008b }
                r2.f13979d = r3     // Catch:{ all -> 0x008b }
                com.tapjoy.internal.gb r2 = com.tapjoy.internal.C5108gb.this     // Catch:{ all -> 0x008b }
                r2.mo31285a((long) r0)     // Catch:{ all -> 0x008b }
                goto L_0x0018
            L_0x0087:
                r7.m17251h()
                return
            L_0x008b:
                r0 = move-exception
                r7.m17251h()
                goto L_0x0091
            L_0x0090:
                throw r0
            L_0x0091:
                goto L_0x0090
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5108gb.C5113b.mo31292d():void");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo31289a() {
            this.f13992b = true;
            C5108gb.this.mo31286b();
        }

        /* synthetic */ C5113b(C5108gb gbVar, byte b) {
            this();
        }
    }

    /* renamed from: com.tapjoy.internal.gb$c */
    enum C5116c {
        ;
        

        /* renamed from: a */
        public static final int f13999a = 1;

        /* renamed from: b */
        public static final int f14000b = 2;

        /* renamed from: c */
        public static final int f14001c = 3;

        /* renamed from: d */
        public static final int f14002d = 4;

        /* renamed from: e */
        public static final int f14003e = 5;

        static {
            f14004f = new int[]{1, 2, 3, 4, 5};
        }

        /* renamed from: a */
        public static int[] m17256a() {
            return (int[]) f14004f.clone();
        }
    }

    public C5108gb() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f13976a = reentrantLock;
        this.f13981f = reentrantLock.newCondition();
    }

    /* renamed from: a */
    public abstract boolean mo31194a(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener);

    /* renamed from: b */
    public final boolean mo31287b(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener) {
        this.f13976a.lock();
        if (tJConnectListener != null) {
            try {
                this.f13982g.addLast(C5087fn.m17200a(tJConnectListener, TJConnectListener.class));
            } catch (Throwable th) {
                this.f13976a.unlock();
                throw th;
            }
        }
        C5112a aVar = new C5112a(context, str, hashtable);
        int i = C51113.f13986a[this.f13977b - 1];
        if (i != 1) {
            if (i == 2) {
                this.f13980e = aVar;
                C5096fs.f13949b.addObserver(new Observer() {
                    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
                        r3 = r2.f13984a;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void update(java.util.Observable r3, java.lang.Object r4) {
                        /*
                            r2 = this;
                            com.tapjoy.internal.fs$a r3 = com.tapjoy.internal.C5096fs.f13949b
                            r3.deleteObserver(r2)
                            java.lang.Boolean r3 = java.lang.Boolean.TRUE
                            boolean r3 = r3.equals(r4)
                            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                            boolean r3 = r3.booleanValue()
                            if (r3 != 0) goto L_0x0030
                            com.tapjoy.internal.gb r3 = com.tapjoy.internal.C5108gb.this
                            com.tapjoy.internal.gb$a r4 = r3.f13980e
                            if (r4 == 0) goto L_0x0030
                            android.content.Context r4 = r4.f13987a
                            if (r4 == 0) goto L_0x0030
                            com.tapjoy.internal.gb$b r4 = new com.tapjoy.internal.gb$b
                            com.tapjoy.internal.gb r0 = com.tapjoy.internal.C5108gb.this
                            r1 = 0
                            r4.<init>(r0, r1)
                            r3.f13978c = r4
                            com.tapjoy.internal.gb r3 = com.tapjoy.internal.C5108gb.this
                            com.tapjoy.internal.gb$b r3 = r3.f13978c
                            r3.mo31467e()
                        L_0x0030:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5108gb.C51091.update(java.util.Observable, java.lang.Object):void");
                    }
                });
                if (mo31194a(aVar.f13987a, aVar.f13988b, aVar.f13989c, new TJConnectListener() {
                    public final void onConnectFailure() {
                        C5108gb.this.mo31284a(false);
                    }

                    public final void onConnectSuccess() {
                        C5108gb gbVar = C5108gb.this;
                        int i = C5116c.f14003e;
                        int i2 = C5116c.f14000b;
                        gbVar.mo31283a(i);
                        C5108gb.this.mo31284a(true);
                    }
                })) {
                    int i2 = C5116c.f14000b;
                    int i3 = C5116c.f13999a;
                    mo31283a(i2);
                } else {
                    this.f13982g.clear();
                }
            } else if (i == 3 || i == 4) {
                this.f13983h = aVar;
            } else if (i != 5) {
                mo31283a(C5116c.f13999a);
            } else {
                this.f13983h = aVar;
                mo31286b();
            }
            this.f13976a.unlock();
            return false;
        }
        mo31284a(true);
        this.f13976a.unlock();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo31283a(int i) {
        this.f13976a.lock();
        try {
            this.f13977b = i;
        } finally {
            this.f13976a.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C5112a mo31282a() {
        this.f13976a.lock();
        try {
            if (this.f13983h != null) {
                this.f13980e = this.f13983h;
                this.f13983h = null;
            }
            return this.f13980e;
        } finally {
            this.f13976a.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo31284a(boolean z) {
        this.f13976a.lock();
        try {
            if (this.f13982g.size() != 0) {
                ArrayList arrayList = new ArrayList(this.f13982g);
                this.f13982g.clear();
                this.f13976a.unlock();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    TJConnectListener tJConnectListener = (TJConnectListener) it.next();
                    if (z) {
                        tJConnectListener.onConnectSuccess();
                    } else {
                        tJConnectListener.onConnectFailure();
                    }
                }
            }
        } finally {
            this.f13976a.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo31286b() {
        this.f13976a.lock();
        try {
            this.f13979d = 1000;
            this.f13981f.signal();
        } finally {
            this.f13976a.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo31285a(long j) {
        this.f13976a.lock();
        try {
            int i = C5116c.f14002d;
            int i2 = C5116c.f14001c;
            mo31283a(i);
            if (this.f13981f.await(j, TimeUnit.MILLISECONDS)) {
                this.f13979d = 1000;
            }
        } catch (InterruptedException unused) {
        } catch (Throwable th) {
            int i3 = C5116c.f14001c;
            int i4 = C5116c.f14002d;
            mo31283a(i3);
            this.f13976a.unlock();
            throw th;
        }
        int i5 = C5116c.f14001c;
        int i6 = C5116c.f14002d;
        mo31283a(i5);
        this.f13976a.unlock();
        return false;
    }
}
