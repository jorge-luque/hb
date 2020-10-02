package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.C3614a;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.C3764h;
import com.google.firebase.p073h.C3687h;
import com.google.firebase.p123d.C3660b;
import com.google.firebase.p123d.C3662d;
import com.google.firebase.p124e.C3666c;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
public class FirebaseInstanceId {

    /* renamed from: i */
    private static final long f10263i = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: j */
    private static C3694b0 f10264j;

    /* renamed from: k */
    private static final Pattern f10265k = Pattern.compile("\\AA[\\w-]{38}\\z");
    @GuardedBy("FirebaseInstanceId.class")
    @VisibleForTesting

    /* renamed from: l */
    private static ScheduledExecutorService f10266l;
    @VisibleForTesting

    /* renamed from: a */
    private final Executor f10267a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final FirebaseApp f10268b;

    /* renamed from: c */
    private final C3731q f10269c;

    /* renamed from: d */
    private final C3700d1 f10270d;

    /* renamed from: e */
    private final C3741v f10271e;

    /* renamed from: f */
    private final C3764h f10272f;
    @GuardedBy("this")

    /* renamed from: g */
    private boolean f10273g;

    /* renamed from: h */
    private final C3688a f10274h;

    /* renamed from: com.google.firebase.iid.FirebaseInstanceId$a */
    /* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
    private class C3688a {

        /* renamed from: a */
        private boolean f10275a;

        /* renamed from: b */
        private final C3662d f10276b;
        @GuardedBy("this")

        /* renamed from: c */
        private boolean f10277c;
        @GuardedBy("this")

        /* renamed from: d */
        private C3660b<C3614a> f10278d;
        @GuardedBy("this")

        /* renamed from: e */
        private Boolean f10279e;

        C3688a(C3662d dVar) {
            this.f10276b = dVar;
        }

        /* renamed from: b */
        private final synchronized void m12554b() {
            if (!this.f10277c) {
                this.f10275a = m12556d();
                Boolean c = m12555c();
                this.f10279e = c;
                if (c == null && this.f10275a) {
                    C3692a1 a1Var = new C3692a1(this);
                    this.f10278d = a1Var;
                    this.f10276b.mo27260a(C3614a.class, a1Var);
                }
                this.f10277c = true;
            }
        }

        /* renamed from: c */
        private final Boolean m12555c() {
            ApplicationInfo applicationInfo;
            Context a = FirebaseInstanceId.this.f10268b.mo27170a();
            SharedPreferences sharedPreferences = a.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = a.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(a.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        /* renamed from: d */
        private final boolean m12556d() {
            try {
                Class.forName("com.google.firebase.messaging.FirebaseMessaging");
                return true;
            } catch (ClassNotFoundException unused) {
                Context a = FirebaseInstanceId.this.f10268b.mo27170a();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(a.getPackageName());
                ResolveInfo resolveService = a.getPackageManager().resolveService(intent, 0);
                if (resolveService == null || resolveService.serviceInfo == null) {
                    return false;
                }
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final synchronized boolean mo27306a() {
            m12554b();
            if (this.f10279e == null) {
                return this.f10275a && FirebaseInstanceId.this.f10268b.isDataCollectionDefaultEnabled();
            }
            return this.f10279e.booleanValue();
        }
    }

    FirebaseInstanceId(FirebaseApp firebaseApp, C3662d dVar, C3687h hVar, C3666c cVar, C3764h hVar2) {
        this(firebaseApp, new C3731q(firebaseApp.mo27170a()), C3736s0.m12635b(), C3736s0.m12635b(), dVar, hVar, cVar, hVar2);
    }

    @Keep
    public static FirebaseInstanceId getInstance(FirebaseApp firebaseApp) {
        m12525a(firebaseApp);
        return (FirebaseInstanceId) firebaseApp.mo27171a(FirebaseInstanceId.class);
    }

    /* renamed from: k */
    public static FirebaseInstanceId m12531k() {
        return getInstance(FirebaseApp.getInstance());
    }

    /* renamed from: l */
    static boolean m12532l() {
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public final void m12533m() {
        if (mo27296a(mo27299d())) {
            m12534n();
        }
    }

    /* renamed from: n */
    private final synchronized void m12534n() {
        if (!this.f10273g) {
            mo27294a(0);
        }
    }

    /* renamed from: o */
    private final String m12535o() {
        try {
            f10264j.mo27311a(this.f10268b.mo27174d());
            Task<String> id = this.f10272f.getId();
            Preconditions.checkNotNull(id, "Task must not be null");
            CountDownLatch countDownLatch = new CountDownLatch(1);
            id.addOnCompleteListener(C3746x0.f10390a, (OnCompleteListener<String>) new C3744w0(countDownLatch));
            countDownLatch.await(30000, TimeUnit.MILLISECONDS);
            if (id.isSuccessful()) {
                return id.getResult();
            }
            if (id.isCanceled()) {
                throw new CancellationException("Task is already canceled");
            }
            throw new IllegalStateException(id.getException());
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: p */
    private final String m12536p() {
        if ("[DEFAULT]".equals(this.f10268b.mo27172b())) {
            return "";
        }
        return this.f10268b.mo27174d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo27295a(boolean z) {
        this.f10273g = z;
    }

    /* renamed from: b */
    public Task<C3690a> mo27297b() {
        m12525a(this.f10268b);
        return m12528b(C3731q.m12624a(this.f10268b), "*");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final FirebaseApp mo27298c() {
        return this.f10268b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final C3691a0 mo27299d() {
        return m12530c(C3731q.m12624a(this.f10268b), "*");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final String mo27300e() throws IOException {
        return mo27293a(C3731q.m12624a(this.f10268b), "*");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final synchronized void mo27301f() {
        f10264j.mo27313a();
        if (this.f10274h.mo27306a()) {
            m12534n();
        }
    }

    @VisibleForTesting
    /* renamed from: g */
    public final boolean mo27302g() {
        return this.f10269c.mo27361a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final void mo27303h() {
        f10264j.mo27315b(m12536p());
        m12534n();
    }

    @VisibleForTesting
    /* renamed from: i */
    public final boolean mo27304i() {
        return this.f10274h.mo27306a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final /* synthetic */ void mo27305j() {
        if (this.f10274h.mo27306a()) {
            m12533m();
        }
    }

    @VisibleForTesting
    /* renamed from: c */
    private final C3691a0 m12530c(String str, String str2) {
        return f10264j.mo27312a(m12536p(), str, str2);
    }

    /* renamed from: b */
    private final Task<C3690a> m12528b(String str, String str2) {
        return Tasks.forResult(null).continueWithTask(this.f10267a, new C3740u0(this, str, m12524a(str2)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo27294a(long j) {
        m12526a((Runnable) new C3702e0(this, Math.min(Math.max(30, j << 1), f10263i)), j);
        this.f10273g = true;
    }

    private FirebaseInstanceId(FirebaseApp firebaseApp, C3731q qVar, Executor executor, Executor executor2, C3662d dVar, C3687h hVar, C3666c cVar, C3764h hVar2) {
        Executor executor3 = executor2;
        this.f10273g = false;
        if (C3731q.m12624a(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (f10264j == null) {
                    f10264j = new C3694b0(firebaseApp.mo27170a());
                }
            }
            this.f10268b = firebaseApp;
            this.f10269c = qVar;
            this.f10270d = new C3700d1(firebaseApp, qVar, executor, hVar, cVar, hVar2);
            this.f10267a = executor3;
            this.f10274h = new C3688a(dVar);
            Executor executor4 = executor;
            this.f10271e = new C3741v(executor);
            this.f10272f = hVar2;
            executor3.execute(new C3742v0(this));
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    /* renamed from: a */
    static void m12526a(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (f10266l == null) {
                f10266l = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
            }
            f10266l.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    /* renamed from: a */
    public String mo27292a() {
        m12525a(this.f10268b);
        m12533m();
        return m12535o();
    }

    /* renamed from: a */
    private static void m12525a(FirebaseApp firebaseApp) {
        Preconditions.checkNotEmpty(firebaseApp.mo27173c().mo27210d(), "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        Preconditions.checkNotEmpty(firebaseApp.mo27173c().mo27208b(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        Preconditions.checkNotEmpty(firebaseApp.mo27173c().mo27207a(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        Preconditions.checkArgument(firebaseApp.mo27173c().mo27208b().contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(f10265k.matcher(firebaseApp.mo27173c().mo27207a()).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    /* renamed from: a */
    public String mo27293a(String str, String str2) throws IOException {
        m12525a(this.f10268b);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((C3690a) m12523a(m12528b(str, str2))).getToken();
        }
        throw new IOException("MAIN_THREAD");
    }

    /* renamed from: a */
    private final <T> T m12523a(Task<T> task) throws IOException {
        try {
            return Tasks.await(task, 30000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    mo27301f();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e);
            }
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    /* renamed from: a */
    private static String m12524a(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo27296a(C3691a0 a0Var) {
        return a0Var == null || a0Var.mo27310a(this.f10269c.mo27363c());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ Task mo27289a(String str, String str2, Task task) throws Exception {
        String o = m12535o();
        C3691a0 c = m12530c(str, str2);
        if (!mo27296a(c)) {
            return Tasks.forResult(new C3699d(o, c.f10283a));
        }
        return this.f10271e.mo27370a(str, str2, new C3750z0(this, o, str, str2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ Task mo27290a(String str, String str2, String str3) {
        return this.f10270d.mo27318a(str, str2, str3).onSuccessTask(this.f10267a, new C3748y0(this, str2, str3, str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ Task mo27291a(String str, String str2, String str3, String str4) throws Exception {
        f10264j.mo27314a(m12536p(), str, str2, str4, this.f10269c.mo27363c());
        return Tasks.forResult(new C3699d(str3, str4));
    }
}
