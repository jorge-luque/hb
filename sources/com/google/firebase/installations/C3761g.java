package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.p129p.C3776b;
import com.google.firebase.installations.p129p.C3777c;
import com.google.firebase.installations.p129p.C3779d;
import com.google.firebase.installations.p130q.C3787c;
import com.google.firebase.installations.p130q.C3788d;
import com.google.firebase.installations.p130q.C3791e;
import com.google.firebase.p073h.C3687h;
import com.google.firebase.p124e.C3666c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.firebase.installations.g */
/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
public class C3761g implements C3764h {

    /* renamed from: k */
    private static final Object f10422k = new Object();

    /* renamed from: l */
    private static final ThreadFactory f10423l = new C3762a();

    /* renamed from: a */
    private final FirebaseApp f10424a;

    /* renamed from: b */
    private final C3787c f10425b;

    /* renamed from: c */
    private final C3777c f10426c;

    /* renamed from: d */
    private final C3772o f10427d;

    /* renamed from: e */
    private final C3776b f10428e;

    /* renamed from: f */
    private final C3770m f10429f;

    /* renamed from: g */
    private final Object f10430g;

    /* renamed from: h */
    private final ExecutorService f10431h;

    /* renamed from: i */
    private final ExecutorService f10432i;

    /* renamed from: j */
    private final List<C3771n> f10433j;

    /* renamed from: com.google.firebase.installations.g$a */
    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    class C3762a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f10434a = new AtomicInteger(1);

        C3762a() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", new Object[]{Integer.valueOf(this.f10434a.getAndIncrement())}));
        }
    }

    /* renamed from: com.google.firebase.installations.g$b */
    /* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
    static /* synthetic */ class C3763b {

        /* renamed from: a */
        static final /* synthetic */ int[] f10435a;

        /* renamed from: b */
        static final /* synthetic */ int[] f10436b;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        static {
            /*
                com.google.firebase.installations.q.e$b[] r0 = com.google.firebase.installations.p130q.C3791e.C3793b.m12825a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10436b = r0
                r1 = 1
                com.google.firebase.installations.q.e$b r2 = com.google.firebase.installations.p130q.C3791e.C3793b.OK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f10436b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.firebase.installations.q.e$b r3 = com.google.firebase.installations.p130q.C3791e.C3793b.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = f10436b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.firebase.installations.q.e$b r3 = com.google.firebase.installations.p130q.C3791e.C3793b.AUTH_ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.google.firebase.installations.q.d$b[] r2 = com.google.firebase.installations.p130q.C3788d.C3790b.m12816a()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f10435a = r2
                com.google.firebase.installations.q.d$b r3 = com.google.firebase.installations.p130q.C3788d.C3790b.OK     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f10435a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.google.firebase.installations.q.d$b r2 = com.google.firebase.installations.p130q.C3788d.C3790b.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.C3761g.C3763b.<clinit>():void");
        }
    }

    C3761g(FirebaseApp firebaseApp, C3687h hVar, C3666c cVar) {
        this(new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), f10423l), firebaseApp, new C3787c(firebaseApp.mo27170a(), hVar, cVar), new C3777c(firebaseApp), new C3772o(), new C3776b(firebaseApp), new C3770m());
    }

    /* renamed from: d */
    private Task<C3768l> m12680d() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        C3766j jVar = new C3766j(this.f10427d, taskCompletionSource);
        synchronized (this.f10430g) {
            this.f10433j.add(jVar);
        }
        return taskCompletionSource.getTask();
    }

    /* renamed from: e */
    private Task<String> m12682e() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        C3767k kVar = new C3767k(taskCompletionSource);
        synchronized (this.f10430g) {
            this.f10433j.add(kVar);
        }
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final void m12683f() {
        m12679c(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public final void m12684g() {
        m12679c(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public final void m12685h() {
        m12679c(false);
    }

    /* renamed from: i */
    private C3779d m12686i() {
        C3779d a;
        synchronized (f10422k) {
            C3756b a2 = C3756b.m12664a(this.f10424a.mo27170a(), "generatefid.lock");
            try {
                a = this.f10426c.mo27434a();
                if (a.mo27441i()) {
                    String b = m12674b(a);
                    C3777c cVar = this.f10426c;
                    a = a.mo27439b(b);
                    cVar.mo27435a(a);
                }
                if (a2 != null) {
                    a2.mo27397a();
                }
            } catch (Throwable th) {
                if (a2 != null) {
                    a2.mo27397a();
                }
                throw th;
            }
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo27403a() {
        return this.f10424a.mo27173c().mo27207a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo27404b() {
        return this.f10424a.mo27173c().mo27208b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo27405c() {
        return this.f10424a.mo27173c().mo27210d();
    }

    public Task<String> getId() {
        Task<String> e = m12682e();
        this.f10431h.execute(C3757c.m12666a(this));
        return e;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m12676b(boolean r3) {
        /*
            r2 = this;
            com.google.firebase.installations.p.d r0 = r2.m12686i()
            boolean r1 = r0.mo27440h()     // Catch:{ IOException -> 0x0051 }
            if (r1 != 0) goto L_0x0022
            boolean r1 = r0.mo27443k()     // Catch:{ IOException -> 0x0051 }
            if (r1 == 0) goto L_0x0011
            goto L_0x0022
        L_0x0011:
            if (r3 != 0) goto L_0x001d
            com.google.firebase.installations.o r3 = r2.f10427d     // Catch:{ IOException -> 0x0051 }
            boolean r3 = r3.mo27412a(r0)     // Catch:{ IOException -> 0x0051 }
            if (r3 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            return
        L_0x001d:
            com.google.firebase.installations.p.d r3 = r2.m12670a((com.google.firebase.installations.p129p.C3779d) r0)     // Catch:{ IOException -> 0x0051 }
            goto L_0x0026
        L_0x0022:
            com.google.firebase.installations.p.d r3 = r2.m12677c((com.google.firebase.installations.p129p.C3779d) r0)     // Catch:{ IOException -> 0x0051 }
        L_0x0026:
            com.google.firebase.installations.p.c r0 = r2.f10426c
            r0.mo27435a(r3)
            boolean r0 = r3.mo27440h()
            if (r0 == 0) goto L_0x003c
            com.google.firebase.installations.FirebaseInstallationsException r0 = new com.google.firebase.installations.FirebaseInstallationsException
            com.google.firebase.installations.FirebaseInstallationsException$a r1 = com.google.firebase.installations.FirebaseInstallationsException.C3752a.BAD_CONFIG
            r0.<init>(r1)
            r2.m12673a((com.google.firebase.installations.p129p.C3779d) r3, (java.lang.Exception) r0)
            goto L_0x0050
        L_0x003c:
            boolean r0 = r3.mo27441i()
            if (r0 == 0) goto L_0x004d
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "cleared fid due to auth error"
            r0.<init>(r1)
            r2.m12673a((com.google.firebase.installations.p129p.C3779d) r3, (java.lang.Exception) r0)
            goto L_0x0050
        L_0x004d:
            r2.m12681d(r3)
        L_0x0050:
            return
        L_0x0051:
            r3 = move-exception
            r2.m12673a((com.google.firebase.installations.p129p.C3779d) r0, (java.lang.Exception) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.C3761g.m12676b(boolean):void");
    }

    /* renamed from: c */
    private final void m12679c(boolean z) {
        C3779d i = m12686i();
        if (z) {
            i = i.mo27445n();
        }
        m12681d(i);
        this.f10432i.execute(C3760f.m12669a(this, z));
    }

    /* renamed from: a */
    public Task<C3768l> mo27402a(boolean z) {
        Task<C3768l> d = m12680d();
        if (z) {
            this.f10431h.execute(C3758d.m12667a(this));
        } else {
            this.f10431h.execute(C3759e.m12668a(this));
        }
        return d;
    }

    C3761g(ExecutorService executorService, FirebaseApp firebaseApp, C3787c cVar, C3777c cVar2, C3772o oVar, C3776b bVar, C3770m mVar) {
        this.f10430g = new Object();
        this.f10433j = new ArrayList();
        this.f10424a = firebaseApp;
        this.f10425b = cVar;
        this.f10426c = cVar2;
        this.f10427d = oVar;
        this.f10428e = bVar;
        this.f10429f = mVar;
        this.f10431h = executorService;
        this.f10432i = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), f10423l);
    }

    /* renamed from: a */
    private void m12673a(C3779d dVar, Exception exc) {
        synchronized (this.f10430g) {
            Iterator<C3771n> it = this.f10433j.iterator();
            while (it.hasNext()) {
                if (it.next().mo27409a(dVar, exc)) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: c */
    private C3779d m12677c(C3779d dVar) throws IOException {
        C3788d a = this.f10425b.mo27471a(mo27403a(), dVar.mo27415c(), mo27405c(), mo27404b(), dVar.mo27415c().length() == 11 ? this.f10428e.mo27433b() : null);
        int i = C3763b.f10435a[a.mo27450d().ordinal()];
        if (i == 1) {
            return dVar.mo27438a(a.mo27448b(), a.mo27449c(), this.f10427d.mo27411a(), a.mo27447a().mo27462b(), a.mo27447a().mo27463c());
        } else if (i == 2) {
            return dVar.mo27436a("BAD CONFIG");
        } else {
            throw new IOException();
        }
    }

    /* renamed from: d */
    private void m12681d(C3779d dVar) {
        synchronized (this.f10430g) {
            Iterator<C3771n> it = this.f10433j.iterator();
            while (it.hasNext()) {
                if (it.next().mo27408a(dVar)) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: a */
    private C3779d m12670a(C3779d dVar) throws IOException {
        C3791e a = this.f10425b.mo27472a(mo27403a(), dVar.mo27415c(), mo27405c(), dVar.mo27417e());
        int i = C3763b.f10436b[a.mo27461a().ordinal()];
        if (i == 1) {
            return dVar.mo27437a(a.mo27462b(), a.mo27463c(), this.f10427d.mo27411a());
        } else if (i == 2) {
            return dVar.mo27436a("BAD CONFIG");
        } else {
            if (i == 3) {
                return dVar.mo27446o();
            }
            throw new IOException();
        }
    }

    /* renamed from: b */
    private String m12674b(C3779d dVar) {
        if ((!this.f10424a.mo27172b().equals("CHIME_ANDROID_SDK") && !this.f10424a.mo27175e()) || !dVar.mo27444l()) {
            return this.f10429f.mo27410a();
        }
        String a = this.f10428e.mo27432a();
        return TextUtils.isEmpty(a) ? this.f10429f.mo27410a() : a;
    }
}
