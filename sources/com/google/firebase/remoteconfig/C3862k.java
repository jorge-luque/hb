package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.C3616b;
import com.google.firebase.analytics.p122a.C3619a;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.remoteconfig.internal.C3101n;
import com.google.firebase.remoteconfig.internal.C3842e;
import com.google.firebase.remoteconfig.internal.C3852k;
import com.google.firebase.remoteconfig.internal.C3854l;
import com.google.firebase.remoteconfig.internal.C3855m;
import com.google.firebase.remoteconfig.internal.C3858p;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@KeepForSdk
/* renamed from: com.google.firebase.remoteconfig.k */
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class C3862k {

    /* renamed from: j */
    private static final Clock f10666j = DefaultClock.getInstance();

    /* renamed from: k */
    private static final Random f10667k = new Random();

    /* renamed from: a */
    private final Map<String, C3833g> f10668a;

    /* renamed from: b */
    private final Context f10669b;

    /* renamed from: c */
    private final ExecutorService f10670c;

    /* renamed from: d */
    private final FirebaseApp f10671d;

    /* renamed from: e */
    private final FirebaseInstanceId f10672e;

    /* renamed from: f */
    private final C3616b f10673f;

    /* renamed from: g */
    private final C3619a f10674g;

    /* renamed from: h */
    private final String f10675h;

    /* renamed from: i */
    private Map<String, String> f10676i;

    C3862k(Context context, FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, C3616b bVar, C3619a aVar) {
        this(context, Executors.newCachedThreadPool(), firebaseApp, firebaseInstanceId, bVar, aVar, new C3858p(context, firebaseApp.mo27173c().mo27208b()), true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3833g mo27604a() {
        return mo27606a("firebase");
    }

    @KeepForSdk
    /* renamed from: a */
    public synchronized C3833g mo27606a(String str) {
        C3842e a;
        C3842e a2;
        C3842e a3;
        C3855m a4;
        a = m13086a(str, "fetch");
        a2 = m13086a(str, "activate");
        a3 = m13086a(str, "defaults");
        a4 = m13088a(this.f10669b, this.f10675h, str);
        return mo27605a(this.f10671d, str, this.f10672e, this.f10673f, this.f10670c, a, a2, a3, mo27608a(str, a, a4), m13087a(a2, a3), a4);
    }

    protected C3862k(Context context, ExecutorService executorService, FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, C3616b bVar, C3619a aVar, C3858p pVar, boolean z) {
        this.f10668a = new HashMap();
        this.f10676i = new HashMap();
        this.f10669b = context;
        this.f10670c = executorService;
        this.f10671d = firebaseApp;
        this.f10672e = firebaseInstanceId;
        this.f10673f = bVar;
        this.f10674g = aVar;
        this.f10675h = firebaseApp.mo27173c().mo27208b();
        if (z) {
            Tasks.call(executorService, C3837i.m12972a(this));
            pVar.getClass();
            Tasks.call(executorService, C3861j.m13084a(pVar));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized C3833g mo27605a(FirebaseApp firebaseApp, String str, FirebaseInstanceId firebaseInstanceId, C3616b bVar, Executor executor, C3842e eVar, C3842e eVar2, C3842e eVar3, C3852k kVar, C3854l lVar, C3855m mVar) {
        C3833g gVar;
        String str2 = str;
        synchronized (this) {
            if (!this.f10668a.containsKey(str2)) {
                C3833g gVar2 = new C3833g(this.f10669b, firebaseApp, firebaseInstanceId, m13090a(firebaseApp, str) ? bVar : null, executor, eVar, eVar2, eVar3, kVar, lVar, mVar);
                gVar2.mo27549d();
                this.f10668a.put(str2, gVar2);
            }
            gVar = this.f10668a.get(str2);
        }
        return gVar;
    }

    /* renamed from: a */
    private C3842e m13086a(String str, String str2) {
        return m13085a(this.f10669b, this.f10675h, str, str2);
    }

    /* renamed from: a */
    public static C3842e m13085a(Context context, String str, String str2, String str3) {
        return C3842e.m12990a(Executors.newCachedThreadPool(), C3101n.m10167a(context, String.format("%s_%s_%s_%s.json", new Object[]{"frc", str, str2, str3})));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ConfigFetchHttpClient mo27607a(String str, String str2, C3855m mVar) {
        return new ConfigFetchHttpClient(this.f10669b, this.f10671d.mo27173c().mo27208b(), str, str2, mVar.mo27590b(), mVar.mo27590b());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized C3852k mo27608a(String str, C3842e eVar, C3855m mVar) {
        return new C3852k(this.f10672e, m13089a(this.f10671d) ? this.f10674g : null, this.f10670c, f10666j, f10667k, eVar, mo27607a(this.f10671d.mo27173c().mo27207a(), str, mVar), mVar, this.f10676i);
    }

    /* renamed from: a */
    private C3854l m13087a(C3842e eVar, C3842e eVar2) {
        return new C3854l(eVar, eVar2);
    }

    /* renamed from: a */
    static C3855m m13088a(Context context, String str, String str2) {
        return new C3855m(context.getSharedPreferences(String.format("%s_%s_%s_%s", new Object[]{"frc", str, str2, "settings"}), 0));
    }

    /* renamed from: a */
    private static boolean m13090a(FirebaseApp firebaseApp, String str) {
        return str.equals("firebase") && m13089a(firebaseApp);
    }

    /* renamed from: a */
    private static boolean m13089a(FirebaseApp firebaseApp) {
        return firebaseApp.mo27172b().equals("[DEFAULT]");
    }
}
