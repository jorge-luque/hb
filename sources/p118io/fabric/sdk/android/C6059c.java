package p118io.fabric.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import p118io.fabric.sdk.android.C6054a;
import p118io.fabric.sdk.android.p200m.p202b.C6097l;
import p118io.fabric.sdk.android.p200m.p202b.C6107s;
import p118io.fabric.sdk.android.services.concurrency.C3572d;
import p118io.fabric.sdk.android.services.concurrency.C6182k;
import p118io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

/* renamed from: io.fabric.sdk.android.c */
/* compiled from: Fabric */
public class C6059c {

    /* renamed from: l */
    static volatile C6059c f15959l;

    /* renamed from: m */
    static final C6072k f15960m = new C6058b();

    /* renamed from: a */
    private final Context f15961a;

    /* renamed from: b */
    private final Map<Class<? extends C6069h>, C6069h> f15962b;

    /* renamed from: c */
    private final ExecutorService f15963c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C6065f<C6059c> f15964d;

    /* renamed from: e */
    private final C6065f<?> f15965e;

    /* renamed from: f */
    private final C6107s f15966f;

    /* renamed from: g */
    private C6054a f15967g;

    /* renamed from: h */
    private WeakReference<Activity> f15968h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public AtomicBoolean f15969i = new AtomicBoolean(false);

    /* renamed from: j */
    final C6072k f15970j;

    /* renamed from: k */
    final boolean f15971k;

    /* renamed from: io.fabric.sdk.android.c$a */
    /* compiled from: Fabric */
    class C6060a extends C6054a.C6057b {
        C6060a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            C6059c.this.mo34098a(activity);
        }

        public void onActivityResumed(Activity activity) {
            C6059c.this.mo34098a(activity);
        }

        public void onActivityStarted(Activity activity) {
            C6059c.this.mo34098a(activity);
        }
    }

    C6059c(Context context, Map<Class<? extends C6069h>, C6069h> map, C6182k kVar, Handler handler, C6072k kVar2, boolean z, C6065f fVar, C6107s sVar, Activity activity) {
        this.f15961a = context;
        this.f15962b = map;
        this.f15963c = kVar;
        this.f15970j = kVar2;
        this.f15971k = z;
        this.f15964d = fVar;
        this.f15965e = mo34099a(map.size());
        this.f15966f = sVar;
        mo34098a(activity);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static Activity m19629d(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    /* renamed from: f */
    public static C6072k m19630f() {
        if (f15959l == null) {
            return f15960m;
        }
        return f15959l.f15970j;
    }

    /* renamed from: g */
    private void m19631g() {
        C6054a aVar = new C6054a(this.f15961a);
        this.f15967g = aVar;
        aVar.mo34076a(new C6060a());
        mo34103b(this.f15961a);
    }

    /* renamed from: h */
    public static boolean m19632h() {
        if (f15959l == null) {
            return false;
        }
        return f15959l.f15971k;
    }

    /* renamed from: i */
    static C6059c m19633i() {
        if (f15959l != null) {
            return f15959l;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    /* renamed from: c */
    public String mo34104c() {
        return "io.fabric.sdk.android:fabric";
    }

    /* renamed from: e */
    public String mo34106e() {
        return "1.4.8.32";
    }

    /* renamed from: c */
    private static void m19628c(C6059c cVar) {
        f15959l = cVar;
        cVar.m19631g();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo34103b(Context context) {
        StringBuilder sb;
        Future<Map<String, C6071j>> a = mo34100a(context);
        Collection<C6069h> d = mo34105d();
        C6073l lVar = new C6073l(a, d);
        ArrayList<C6069h> arrayList = new ArrayList<>(d);
        Collections.sort(arrayList);
        lVar.injectParameters(context, this, C6065f.f15988a, this.f15966f);
        for (C6069h injectParameters : arrayList) {
            injectParameters.injectParameters(context, this, this.f15965e, this.f15966f);
        }
        lVar.initialize();
        if (m19630f().mo34088a("Fabric", 3)) {
            sb = new StringBuilder("Initializing ");
            sb.append(mo34104c());
            sb.append(" [Version: ");
            sb.append(mo34106e());
            sb.append("], with the following kits:\n");
        } else {
            sb = null;
        }
        for (C6069h hVar : arrayList) {
            hVar.initializationTask.addDependency(lVar.initializationTask);
            mo34101a(this.f15962b, hVar);
            hVar.initialize();
            if (sb != null) {
                sb.append(hVar.getIdentifier());
                sb.append(" [Version: ");
                sb.append(hVar.getVersion());
                sb.append("]\n");
            }
        }
        if (sb != null) {
            m19630f().mo34093d("Fabric", sb.toString());
        }
    }

    /* renamed from: a */
    public static C6059c m19620a(Context context, C6069h... hVarArr) {
        if (f15959l == null) {
            synchronized (C6059c.class) {
                if (f15959l == null) {
                    C6062c cVar = new C6062c(context);
                    cVar.mo34109a(hVarArr);
                    m19628c(cVar.mo34110a());
                }
            }
        }
        return f15959l;
    }

    /* renamed from: d */
    public Collection<C6069h> mo34105d() {
        return this.f15962b.values();
    }

    /* renamed from: io.fabric.sdk.android.c$b */
    /* compiled from: Fabric */
    class C6061b implements C6065f {

        /* renamed from: b */
        final CountDownLatch f15973b = new CountDownLatch(this.f15974c);

        /* renamed from: c */
        final /* synthetic */ int f15974c;

        C6061b(int i) {
            this.f15974c = i;
        }

        /* renamed from: a */
        public void mo34108a(Object obj) {
            this.f15973b.countDown();
            if (this.f15973b.getCount() == 0) {
                C6059c.this.f15969i.set(true);
                C6059c.this.f15964d.mo34108a(C6059c.this);
            }
        }

        /* renamed from: a */
        public void mo34107a(Exception exc) {
            C6059c.this.f15964d.mo34107a(exc);
        }
    }

    /* renamed from: a */
    public C6059c mo34098a(Activity activity) {
        this.f15968h = new WeakReference<>(activity);
        return this;
    }

    /* renamed from: io.fabric.sdk.android.c$c */
    /* compiled from: Fabric */
    public static class C6062c {

        /* renamed from: a */
        private final Context f15976a;

        /* renamed from: b */
        private C6069h[] f15977b;

        /* renamed from: c */
        private C6182k f15978c;

        /* renamed from: d */
        private Handler f15979d;

        /* renamed from: e */
        private C6072k f15980e;

        /* renamed from: f */
        private boolean f15981f;

        /* renamed from: g */
        private String f15982g;

        /* renamed from: h */
        private String f15983h;

        /* renamed from: i */
        private C6065f<C6059c> f15984i;

        public C6062c(Context context) {
            if (context != null) {
                this.f15976a = context;
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        /* renamed from: a */
        public C6062c mo34109a(C6069h... hVarArr) {
            if (this.f15977b == null) {
                if (!C6097l.m19766a(this.f15976a).mo34177a()) {
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (C6069h hVar : hVarArr) {
                        String identifier = hVar.getIdentifier();
                        char c = 65535;
                        int hashCode = identifier.hashCode();
                        if (hashCode != 607220212) {
                            if (hashCode == 1830452504 && identifier.equals("com.crashlytics.sdk.android:crashlytics")) {
                                c = 0;
                            }
                        } else if (identifier.equals("com.crashlytics.sdk.android:answers")) {
                            c = 1;
                        }
                        if (c == 0 || c == 1) {
                            arrayList.add(hVar);
                        } else if (!z) {
                            C6059c.m19630f().mo34086a("Fabric", "Fabric will not initialize any kits when Firebase automatic data collection is disabled; to use Third-party kits with automatic data collection disabled, initialize these kits via non-Fabric means.");
                            z = true;
                        }
                    }
                    hVarArr = (C6069h[]) arrayList.toArray(new C6069h[0]);
                }
                this.f15977b = hVarArr;
                return this;
            }
            throw new IllegalStateException("Kits already set.");
        }

        /* renamed from: a */
        public C6059c mo34110a() {
            Map map;
            if (this.f15978c == null) {
                this.f15978c = C6182k.m19947a();
            }
            if (this.f15979d == null) {
                this.f15979d = new Handler(Looper.getMainLooper());
            }
            if (this.f15980e == null) {
                if (this.f15981f) {
                    this.f15980e = new C6058b(3);
                } else {
                    this.f15980e = new C6058b();
                }
            }
            if (this.f15983h == null) {
                this.f15983h = this.f15976a.getPackageName();
            }
            if (this.f15984i == null) {
                this.f15984i = C6065f.f15988a;
            }
            C6069h[] hVarArr = this.f15977b;
            if (hVarArr == null) {
                map = new HashMap();
            } else {
                map = C6059c.m19626b((Collection<? extends C6069h>) Arrays.asList(hVarArr));
            }
            Map map2 = map;
            Context applicationContext = this.f15976a.getApplicationContext();
            return new C6059c(applicationContext, map2, this.f15978c, this.f15979d, this.f15980e, this.f15981f, this.f15984i, new C6107s(applicationContext, this.f15983h, this.f15982g, map2.values()), C6059c.m19629d(this.f15976a));
        }
    }

    /* renamed from: a */
    public Activity mo34097a() {
        WeakReference<Activity> weakReference = this.f15968h;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo34101a(Map<Class<? extends C6069h>, C6069h> map, C6069h hVar) {
        C3572d dVar = hVar.dependsOnAnnotation;
        if (dVar != null) {
            for (Class cls : dVar.value()) {
                if (cls.isInterface()) {
                    for (C6069h next : map.values()) {
                        if (cls.isAssignableFrom(next.getClass())) {
                            hVar.initializationTask.addDependency(next.initializationTask);
                        }
                    }
                } else if (map.get(cls) != null) {
                    hVar.initializationTask.addDependency(map.get(cls).initializationTask);
                } else {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                }
            }
        }
    }

    /* renamed from: a */
    public static <T extends C6069h> T m19621a(Class<T> cls) {
        return (C6069h) m19633i().f15962b.get(cls);
    }

    /* renamed from: a */
    private static void m19624a(Map<Class<? extends C6069h>, C6069h> map, Collection<? extends C6069h> collection) {
        for (C6069h hVar : collection) {
            map.put(hVar.getClass(), hVar);
            if (hVar instanceof C6070i) {
                m19624a(map, ((C6070i) hVar).getKits());
            }
        }
    }

    /* renamed from: b */
    public ExecutorService mo34102b() {
        return this.f15963c;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Map<Class<? extends C6069h>, C6069h> m19626b(Collection<? extends C6069h> collection) {
        HashMap hashMap = new HashMap(collection.size());
        m19624a((Map<Class<? extends C6069h>, C6069h>) hashMap, collection);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C6065f<?> mo34099a(int i) {
        return new C6061b(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Future<Map<String, C6071j>> mo34100a(Context context) {
        return mo34102b().submit(new C6064e(context.getPackageCodePath()));
    }
}
