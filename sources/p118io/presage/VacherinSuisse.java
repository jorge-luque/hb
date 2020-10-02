package p118io.presage;

import android.app.Activity;
import android.app.Application;

/* renamed from: io.presage.VacherinSuisse */
public final class VacherinSuisse {

    /* renamed from: a */
    private Application.ActivityLifecycleCallbacks f16737a;

    /* renamed from: b */
    private final Application f16738b;

    /* renamed from: io.presage.VacherinSuisse$CamembertauCalvados */
    public static final class CamembertauCalvados extends GrandMunster {

        /* renamed from: a */
        final /* synthetic */ VacherinSuisse f16739a;

        /* renamed from: b */
        final /* synthetic */ CamembertdeNormandie f16740b;

        CamembertauCalvados(VacherinSuisse vacherinSuisse, CamembertdeNormandie camembertdeNormandie) {
            this.f16739a = vacherinSuisse;
            this.f16740b = camembertdeNormandie;
        }

        public final void onActivityPaused(Activity activity) {
            this.f16740b.mo34472a();
        }

        public final void onActivityResumed(Activity activity) {
            this.f16739a.mo34725a();
            CamembertdeNormandie camembertdeNormandie = this.f16740b;
            activity.addContentView(camembertdeNormandie, camembertdeNormandie.getLayoutParams());
        }
    }

    public VacherinSuisse(Application application) {
        this.f16738b = application;
    }

    /* renamed from: a */
    public final void mo34726a(CamembertdeNormandie camembertdeNormandie) {
        CamembertauCalvados camembertauCalvados = new CamembertauCalvados(this, camembertdeNormandie);
        this.f16737a = camembertauCalvados;
        this.f16738b.registerActivityLifecycleCallbacks(camembertauCalvados);
    }

    /* renamed from: a */
    public final void mo34725a() {
        this.f16738b.unregisterActivityLifecycleCallbacks(this.f16737a);
    }
}
