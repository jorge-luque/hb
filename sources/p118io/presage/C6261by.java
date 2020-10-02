package p118io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"StaticFieldLeak"})
/* renamed from: io.presage.by */
public final class C6261by {

    /* renamed from: a */
    public static final C6261by f16869a = new C6261by();

    /* renamed from: b */
    private static final Map<String, C6260bx> f16870b = new ConcurrentHashMap();

    /* renamed from: c */
    private static Handler f16871c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private static final Runnable f16872d = CamembertauCalvados.f16875a;

    /* renamed from: e */
    private static Integer f16873e;

    /* renamed from: f */
    private static C6565k f16874f = C6565k.f17116a;

    /* renamed from: io.presage.by$CamembertauCalvados */
    static final class CamembertauCalvados implements Runnable {

        /* renamed from: a */
        public static final CamembertauCalvados f16875a = new CamembertauCalvados();

        CamembertauCalvados() {
        }

        public final void run() {
            C6261by byVar = C6261by.f16869a;
            C6261by.m21028d();
        }
    }

    private C6261by() {
    }

    /* renamed from: a */
    public static void m21021a(C6265cb cbVar) {
        Iterator<Map.Entry<String, C6260bx>> it = f16870b.entrySet().iterator();
        while (it.hasNext()) {
            if (C6514hl.m21416a((Object) (C6265cb) ((C6260bx) it.next().getValue()).mo34847a().get(), (Object) cbVar)) {
                it.remove();
            }
        }
    }

    /* renamed from: c */
    private static boolean m21027c(C6260bx bxVar) {
        Context context = bxVar.mo34848b().getContext();
        C6514hl.m21414a((Object) context, "mraidCacheItem.webView.context");
        C6556j a = C6565k.m21538a(context);
        return a != null && System.currentTimeMillis() - bxVar.mo34850d() > a.mo35591l();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m21028d() {
        new StringBuilder("clean cache ").append(f16870b.size());
        m21019a();
        m21026c();
        new StringBuilder("after cache ").append(f16870b.size());
    }

    /* renamed from: b */
    private static void m21025b(C6260bx bxVar) {
        if (f16873e == null) {
            Context context = bxVar.mo34848b().getContext();
            C6514hl.m21414a((Object) context, "mraidCacheItem.webView.context");
            C6556j a = C6565k.m21538a(context);
            if (a != null) {
                f16873e = a.mo35587h() > 0 ? Integer.valueOf(a.mo35587h()) : null;
            }
        }
    }

    /* renamed from: c */
    private static void m21026c() {
        Iterator<Map.Entry<String, C6260bx>> it = f16870b.entrySet().iterator();
        while (it.hasNext()) {
            if (((C6260bx) it.next().getValue()).mo34847a().get() == null) {
                it.remove();
            }
        }
        f16871c.removeCallbacksAndMessages((Object) null);
        if (!f16870b.isEmpty()) {
            f16871c.postDelayed(f16872d, 1200000);
        }
    }

    /* renamed from: b */
    public static C6396db m21023b(String str) {
        C6396db dbVar = null;
        if (f16870b.containsKey(str)) {
            C6260bx bxVar = f16870b.get(str);
            if (bxVar != null) {
                dbVar = bxVar.mo34848b();
            }
            f16870b.remove(str);
        }
        return dbVar;
    }

    /* renamed from: a */
    public static void m21022a(String str) {
        Iterator<Map.Entry<String, C6260bx>> it = f16870b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (C6514hl.m21416a((Object) (String) next.getKey(), (Object) str)) {
                it.remove();
                C6265cb cbVar = (C6265cb) ((C6260bx) next.getValue()).mo34847a().get();
                if (cbVar != null) {
                    cbVar.mo34437b(((C6260bx) next.getValue()).mo34849c());
                }
            }
        }
    }

    /* renamed from: a */
    public static void m21020a(C6260bx bxVar) {
        m21025b(bxVar);
        f16870b.put(bxVar.mo34849c().mo34601a(), bxVar);
        m21026c();
    }

    /* renamed from: a */
    public static void m21019a() {
        Iterator<Map.Entry<String, C6260bx>> it = f16870b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (m21027c((C6260bx) next.getValue())) {
                it.remove();
                MoelleuxduRevard moelleuxduRevard = MoelleuxduRevard.f16573a;
                MoelleuxduRevard.m20487a((Mimolette24mois) new Munster("expired", ((C6260bx) next.getValue()).mo34849c()));
                C6265cb cbVar = (C6265cb) ((C6260bx) next.getValue()).mo34847a().get();
                if (cbVar != null) {
                    cbVar.mo34431a(((C6260bx) next.getValue()).mo34849c());
                }
            }
        }
    }
}
