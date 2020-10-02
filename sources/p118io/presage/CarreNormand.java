package p118io.presage;

import android.app.Activity;
import android.app.Application;

/* renamed from: io.presage.CarreNormand */
public final class CarreNormand implements CoeurdArras {

    /* renamed from: a */
    private final Application f16444a;

    /* renamed from: b */
    private Application.ActivityLifecycleCallbacks f16445b;

    /* renamed from: c */
    private final Activity f16446c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Chaource f16447d;

    /* renamed from: e */
    private final CarreMirabelle f16448e;

    /* renamed from: f */
    private final C6219aj f16449f;

    /* renamed from: io.presage.CarreNormand$CamembertauCalvados */
    public static final class CamembertauCalvados extends GrandMunster {

        /* renamed from: a */
        final /* synthetic */ CarreNormand f16450a;

        CamembertauCalvados(CarreNormand carreNormand) {
            this.f16450a = carreNormand;
        }

        public final void onActivityPaused(Activity activity) {
            if (!(activity instanceof Livarot)) {
                this.f16450a.f16447d.mo34522a();
            }
        }

        public final void onActivityResumed(Activity activity) {
            if (!(activity instanceof Livarot)) {
                this.f16450a.m20306a(activity);
            }
        }
    }

    private CarreNormand(Activity activity, Chaource chaource, CarreMirabelle carreMirabelle, C6219aj ajVar) {
        this.f16446c = activity;
        this.f16447d = chaource;
        this.f16448e = carreMirabelle;
        this.f16449f = ajVar;
        this.f16444a = activity.getApplication();
    }

    public final void injectInitialOverlay() {
        Activity a = C6219aj.m20783a();
        if (a == null) {
            a = this.f16446c;
        }
        m20306a(a);
    }

    public final void registerLifecycleListener() {
        CamembertauCalvados camembertauCalvados = new CamembertauCalvados(this);
        this.f16445b = camembertauCalvados;
        this.f16444a.registerActivityLifecycleCallbacks(camembertauCalvados);
    }

    public final void unregisterLifecycleListener() {
        this.f16444a.unregisterActivityLifecycleCallbacks(this.f16445b);
    }

    public /* synthetic */ CarreNormand(Activity activity, Chaource chaource, CarreMirabelle carreMirabelle) {
        this(activity, chaource, carreMirabelle, C6219aj.f16747a);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m20306a(Activity activity) {
        if (this.f16448e.mo34512b(activity)) {
            this.f16447d.mo34523a(activity);
        }
    }
}
