package p118io.presage;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.C0911c;
import androidx.fragment.app.C0917h;
import androidx.fragment.app.Fragment;
import java.util.List;

/* renamed from: io.presage.EmmentalGrandCru */
public final class EmmentalGrandCru implements CoeurdArras {

    /* renamed from: a */
    private C0911c f16488a;

    /* renamed from: b */
    private final Application f16489b;

    /* renamed from: c */
    private final CamembertauCalvados f16490c;

    /* renamed from: d */
    private final CamembertdeNormandie f16491d;

    /* renamed from: e */
    private final Chaource f16492e;

    /* renamed from: f */
    private final Entrammes f16493f;

    /* renamed from: g */
    private final C6219aj f16494g;

    /* renamed from: io.presage.EmmentalGrandCru$CamembertauCalvados */
    public static final class CamembertauCalvados extends C0917h.C0918a {

        /* renamed from: a */
        final /* synthetic */ EmmentalGrandCru f16495a;

        CamembertauCalvados(EmmentalGrandCru emmentalGrandCru) {
            this.f16495a = emmentalGrandCru;
        }

        public final void onFragmentPaused(C0917h hVar, Fragment fragment) {
            C0911c activity = fragment.getActivity();
            C0917h supportFragmentManager = activity != null ? activity.getSupportFragmentManager() : null;
            if (supportFragmentManager != null) {
                this.f16495a.m20364b(supportFragmentManager);
            }
        }

        public final void onFragmentResumed(C0917h hVar, Fragment fragment) {
            C0911c activity = fragment.getActivity();
            C0917h supportFragmentManager = activity != null ? activity.getSupportFragmentManager() : null;
            if (supportFragmentManager != null) {
                this.f16495a.m20362a(supportFragmentManager);
            }
        }
    }

    /* renamed from: io.presage.EmmentalGrandCru$CamembertdeNormandie */
    public static final class CamembertdeNormandie extends GrandMunster {

        /* renamed from: a */
        final /* synthetic */ EmmentalGrandCru f16496a;

        CamembertdeNormandie(EmmentalGrandCru emmentalGrandCru) {
            this.f16496a = emmentalGrandCru;
        }

        public final void onActivityPaused(Activity activity) {
            if (activity instanceof C0911c) {
                this.f16496a.m20363b((C0911c) activity);
            }
        }

        public final void onActivityResumed(Activity activity) {
            if (activity instanceof C0911c) {
                this.f16496a.m20361a((C0911c) activity);
            }
        }
    }

    public EmmentalGrandCru(Activity activity, Chaource chaource, Entrammes entrammes, C6219aj ajVar) {
        this.f16492e = chaource;
        this.f16493f = entrammes;
        this.f16494g = ajVar;
        this.f16488a = (C0911c) activity;
        this.f16489b = activity.getApplication();
        this.f16490c = new CamembertauCalvados(this);
        this.f16491d = new CamembertdeNormandie(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m20361a(C0911c cVar) {
        this.f16488a = cVar;
        cVar.getSupportFragmentManager().mo4782a((C0917h.C0918a) this.f16490c, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m20363b(C0911c cVar) {
        cVar.getSupportFragmentManager().mo4781a((C0917h.C0918a) this.f16490c);
        this.f16492e.mo34522a();
    }

    /* renamed from: c */
    private final void m20365c(C0917h hVar) {
        if (this.f16493f.mo34547a((List<? extends Object>) Dauphin.m20345a(hVar))) {
            this.f16492e.mo34523a(this.f16488a);
        } else {
            this.f16492e.mo34522a();
        }
    }

    public final void injectInitialOverlay() {
        Activity a = C6219aj.m20783a();
        if (!(a instanceof C0911c)) {
            a = null;
        }
        C0911c cVar = (C0911c) a;
        if (cVar == null) {
            cVar = this.f16488a;
        }
        m20361a(cVar);
        C0917h supportFragmentManager = this.f16488a.getSupportFragmentManager();
        C6514hl.m21414a((Object) supportFragmentManager, "fragmentActivity.supportFragmentManager");
        m20365c(supportFragmentManager);
    }

    public final void registerLifecycleListener() {
        this.f16489b.registerActivityLifecycleCallbacks(this.f16491d);
    }

    public final void unregisterLifecycleListener() {
        this.f16489b.unregisterActivityLifecycleCallbacks(this.f16491d);
        m20363b(this.f16488a);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m20362a(C0917h hVar) {
        m20365c(hVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m20364b(C0917h hVar) {
        m20365c(hVar);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EmmentalGrandCru(Activity activity, Chaource chaource, Entrammes entrammes, C6219aj ajVar, int i, C6511hi hiVar) {
        this(activity, chaource, entrammes, (i & 8) != 0 ? C6219aj.f16747a : ajVar);
    }
}
