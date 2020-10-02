package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.p022os.C0865c;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.C3634d;
import com.google.firebase.components.C3638f;
import com.google.firebase.components.C3643h;
import com.google.firebase.components.C3647l;
import com.google.firebase.components.C3655q;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.p073h.C3683c;
import com.google.firebase.p073h.C3685e;
import com.google.firebase.p073h.C3686g;
import com.google.firebase.p123d.C3661c;
import com.google.firebase.p124e.C3665b;
import com.google.firebase.p127g.C3681a;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;
import p075d.p080b.C3191a;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
public class FirebaseApp {
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final Object f10104i = new Object();

    /* renamed from: j */
    private static final Executor f10105j = new C3612d();
    @GuardedBy("LOCK")

    /* renamed from: k */
    static final Map<String, FirebaseApp> f10106k = new C3191a();

    /* renamed from: a */
    private final Context f10107a;

    /* renamed from: b */
    private final String f10108b;

    /* renamed from: c */
    private final C3628c f10109c;

    /* renamed from: d */
    private final C3647l f10110d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final AtomicBoolean f10111e = new AtomicBoolean(false);

    /* renamed from: f */
    private final AtomicBoolean f10112f = new AtomicBoolean();

    /* renamed from: g */
    private final C3655q<C3681a> f10113g;

    /* renamed from: h */
    private final List<C3610b> f10114h = new CopyOnWriteArrayList();

    @KeepForSdk
    /* renamed from: com.google.firebase.FirebaseApp$b */
    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    public interface C3610b {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    @TargetApi(14)
    /* renamed from: com.google.firebase.FirebaseApp$c */
    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    private static class C3611c implements BackgroundDetector.BackgroundStateChangeListener {

        /* renamed from: a */
        private static AtomicReference<C3611c> f10115a = new AtomicReference<>();

        private C3611c() {
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public static void m12309b(Context context) {
            if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f10115a.get() == null) {
                    C3611c cVar = new C3611c();
                    if (f10115a.compareAndSet((Object) null, cVar)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector.getInstance().addListener(cVar);
                    }
                }
            }
        }

        public void onBackgroundStateChanged(boolean z) {
            synchronized (FirebaseApp.f10104i) {
                Iterator it = new ArrayList(FirebaseApp.f10106k.values()).iterator();
                while (it.hasNext()) {
                    FirebaseApp firebaseApp = (FirebaseApp) it.next();
                    if (firebaseApp.f10111e.get()) {
                        firebaseApp.m12297a(z);
                    }
                }
            }
        }
    }

    /* renamed from: com.google.firebase.FirebaseApp$d */
    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    private static class C3612d implements Executor {

        /* renamed from: a */
        private static final Handler f10116a = new Handler(Looper.getMainLooper());

        private C3612d() {
        }

        public void execute(Runnable runnable) {
            f10116a.post(runnable);
        }
    }

    @TargetApi(24)
    /* renamed from: com.google.firebase.FirebaseApp$e */
    /* compiled from: com.google.firebase:firebase-common@@19.3.0 */
    private static class C3613e extends BroadcastReceiver {

        /* renamed from: b */
        private static AtomicReference<C3613e> f10117b = new AtomicReference<>();

        /* renamed from: a */
        private final Context f10118a;

        public C3613e(Context context) {
            this.f10118a = context;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public static void m12311b(Context context) {
            if (f10117b.get() == null) {
                C3613e eVar = new C3613e(context);
                if (f10117b.compareAndSet((Object) null, eVar)) {
                    context.registerReceiver(eVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.f10104i) {
                for (FirebaseApp a : FirebaseApp.f10106k.values()) {
                    a.m12301h();
                }
            }
            mo27182a();
        }

        /* renamed from: a */
        public void mo27182a() {
            this.f10118a.unregisterReceiver(this);
        }
    }

    protected FirebaseApp(Context context, String str, C3628c cVar) {
        new CopyOnWriteArrayList();
        this.f10107a = (Context) Preconditions.checkNotNull(context);
        this.f10108b = Preconditions.checkNotEmpty(str);
        this.f10109c = (C3628c) Preconditions.checkNotNull(cVar);
        List<C3643h> a = C3638f.m12399a(context, ComponentDiscoveryService.class).mo27237a();
        String a2 = C3685e.m12519a();
        Executor executor = f10105j;
        C3634d[] dVarArr = new C3634d[8];
        dVarArr[0] = C3634d.m12375a(context, Context.class, new Class[0]);
        dVarArr[1] = C3634d.m12375a(this, FirebaseApp.class, new Class[0]);
        dVarArr[2] = C3634d.m12375a(cVar, C3628c.class, new Class[0]);
        dVarArr[3] = C3686g.m12520a("fire-android", "");
        dVarArr[4] = C3686g.m12520a("fire-core", "19.3.0");
        dVarArr[5] = a2 != null ? C3686g.m12520a("kotlin", a2) : null;
        dVarArr[6] = C3683c.m12515b();
        dVarArr[7] = C3665b.m12460a();
        this.f10110d = new C3647l(executor, a, dVarArr);
        this.f10113g = new C3655q<>(C3627b.m12355a(this, context));
    }

    /* renamed from: g */
    private void m12300g() {
        Preconditions.checkState(!this.f10112f.get(), "FirebaseApp was deleted");
    }

    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (f10104i) {
            firebaseApp = f10106k.get("[DEFAULT]");
            if (firebaseApp == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m12301h() {
        if (!C0865c.m2833a(this.f10107a)) {
            C3613e.m12311b(this.f10107a);
        } else {
            this.f10110d.mo27240a(mo27175e());
        }
    }

    /* renamed from: c */
    public C3628c mo27173c() {
        m12300g();
        return this.f10109c;
    }

    @KeepForSdk
    /* renamed from: d */
    public String mo27174d() {
        return Base64Utils.encodeUrlSafeNoPadding(mo27172b().getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(mo27173c().mo27208b().getBytes(Charset.defaultCharset()));
    }

    @KeepForSdk
    /* renamed from: e */
    public boolean mo27175e() {
        return "[DEFAULT]".equals(mo27172b());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        return this.f10108b.equals(((FirebaseApp) obj).mo27172b());
    }

    public int hashCode() {
        return this.f10108b.hashCode();
    }

    @KeepForSdk
    public boolean isDataCollectionDefaultEnabled() {
        m12300g();
        return this.f10113g.get().mo27286a();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.f10108b).add("options", this.f10109c).toString();
    }

    /* renamed from: b */
    public String mo27172b() {
        m12300g();
        return this.f10108b;
    }

    /* renamed from: a */
    public Context mo27170a() {
        m12300g();
        return this.f10107a;
    }

    /* renamed from: a */
    public static FirebaseApp m12290a(Context context) {
        synchronized (f10104i) {
            if (f10106k.containsKey("[DEFAULT]")) {
                FirebaseApp instance = getInstance();
                return instance;
            }
            C3628c a = C3628c.m12356a(context);
            if (a == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            FirebaseApp a2 = m12291a(context, a);
            return a2;
        }
    }

    /* renamed from: a */
    public static FirebaseApp m12291a(Context context, C3628c cVar) {
        return m12292a(context, cVar, "[DEFAULT]");
    }

    /* renamed from: a */
    public static FirebaseApp m12292a(Context context, C3628c cVar, String str) {
        FirebaseApp firebaseApp;
        C3611c.m12309b(context);
        String a = m12294a(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f10104i) {
            boolean z = !f10106k.containsKey(a);
            Preconditions.checkState(z, "FirebaseApp name " + a + " already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, a, cVar);
            f10106k.put(a, firebaseApp);
        }
        firebaseApp.m12301h();
        return firebaseApp;
    }

    @KeepForSdk
    /* renamed from: a */
    public <T> T mo27171a(Class<T> cls) {
        m12300g();
        return this.f10110d.mo27220a(cls);
    }

    /* renamed from: a */
    static /* synthetic */ C3681a m12293a(FirebaseApp firebaseApp, Context context) {
        return new C3681a(context, firebaseApp.mo27174d(), (C3661c) firebaseApp.f10110d.mo27220a(C3661c.class));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12297a(boolean z) {
        for (C3610b onBackgroundStateChanged : this.f10114h) {
            onBackgroundStateChanged.onBackgroundStateChanged(z);
        }
    }

    /* renamed from: a */
    private static String m12294a(String str) {
        return str.trim();
    }
}
