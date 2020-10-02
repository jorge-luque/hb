package p118io.presage;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.C0911c;
import androidx.fragment.app.C0917h;
import androidx.fragment.app.Fragment;
import java.util.List;

/* renamed from: io.presage.EpoissesdeBourgogne */
public final class EpoissesdeBourgogne implements CoeurdArras {

    /* renamed from: a */
    private C0911c f16498a;

    /* renamed from: b */
    private final Application f16499b;

    /* renamed from: c */
    private final CamembertauCalvados f16500c;

    /* renamed from: d */
    private final CamembertdeNormandie f16501d;

    /* renamed from: e */
    private final Chaource f16502e;

    /* renamed from: f */
    private final Entrammes f16503f;

    /* renamed from: g */
    private final C6219aj f16504g;

    /* renamed from: io.presage.EpoissesdeBourgogne$CamembertauCalvados */
    public static final class CamembertauCalvados extends C0917h.C0918a {

        /* renamed from: a */
        final /* synthetic */ EpoissesdeBourgogne f16505a;

        CamembertauCalvados(EpoissesdeBourgogne epoissesdeBourgogne) {
            this.f16505a = epoissesdeBourgogne;
        }

        public final void onFragmentPaused(C0917h hVar, Fragment fragment) {
            C0911c activity = fragment.getActivity();
            C0917h supportFragmentManager = activity != null ? activity.getSupportFragmentManager() : null;
            if (supportFragmentManager != null) {
                this.f16505a.m20372b(supportFragmentManager);
            }
        }

        public final void onFragmentResumed(C0917h hVar, Fragment fragment) {
            C0911c activity = fragment.getActivity();
            C0917h supportFragmentManager = activity != null ? activity.getSupportFragmentManager() : null;
            if (supportFragmentManager != null) {
                this.f16505a.m20370a(supportFragmentManager);
            }
        }
    }

    /* renamed from: io.presage.EpoissesdeBourgogne$CamembertdeNormandie */
    public static final class CamembertdeNormandie extends GrandMunster {

        /* renamed from: a */
        final /* synthetic */ EpoissesdeBourgogne f16506a;

        CamembertdeNormandie(EpoissesdeBourgogne epoissesdeBourgogne) {
            this.f16506a = epoissesdeBourgogne;
        }

        public final void onActivityPaused(Activity activity) {
            if (activity instanceof C0911c) {
                this.f16506a.m20371b((C0911c) activity);
            }
        }

        public final void onActivityResumed(Activity activity) {
            if (activity instanceof C0911c) {
                this.f16506a.m20369a((C0911c) activity);
            }
        }
    }

    public EpoissesdeBourgogne(Activity activity, Chaource chaource, Entrammes entrammes, C6219aj ajVar) {
        this.f16502e = chaource;
        this.f16503f = entrammes;
        this.f16504g = ajVar;
        this.f16498a = (C0911c) activity;
        this.f16499b = activity.getApplication();
        this.f16500c = new CamembertauCalvados(this);
        this.f16501d = new CamembertdeNormandie(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m20369a(C0911c cVar) {
        this.f16498a = cVar;
        cVar.getSupportFragmentManager().mo4782a((C0917h.C0918a) this.f16500c, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m20371b(C0911c cVar) {
        cVar.getSupportFragmentManager().mo4781a((C0917h.C0918a) this.f16500c);
        this.f16502e.mo34522a();
    }

    /* renamed from: c */
    private final void m20373c(C0917h hVar) {
        if (this.f16503f.mo34547a((List<? extends Object>) Echourgnacalaliqueurdenoix.m20352a(hVar))) {
            this.f16502e.mo34523a(this.f16498a);
        } else {
            this.f16502e.mo34522a();
        }
    }

    public final void injectInitialOverlay() {
        Activity a = C6219aj.m20783a();
        if (!(a instanceof C0911c)) {
            a = null;
        }
        C0911c cVar = (C0911c) a;
        if (cVar == null) {
            cVar = this.f16498a;
        }
        m20369a(cVar);
        C0917h supportFragmentManager = this.f16498a.getSupportFragmentManager();
        C6514hl.m21414a((Object) supportFragmentManager, "fragmentActivity.supportFragmentManager");
        m20373c(supportFragmentManager);
    }

    public final void registerLifecycleListener() {
        this.f16499b.registerActivityLifecycleCallbacks(this.f16501d);
    }

    public final void unregisterLifecycleListener() {
        this.f16499b.unregisterActivityLifecycleCallbacks(this.f16501d);
        m20371b(this.f16498a);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m20370a(C0917h hVar) {
        m20373c(hVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m20372b(C0917h hVar) {
        m20373c(hVar);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EpoissesdeBourgogne(Activity activity, Chaource chaource, Entrammes entrammes, C6219aj ajVar, int i, C6511hi hiVar) {
        this(activity, chaource, entrammes, (i & 8) != 0 ? C6219aj.f16747a : ajVar);
    }
}
