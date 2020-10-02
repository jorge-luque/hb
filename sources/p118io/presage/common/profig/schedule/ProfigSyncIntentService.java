package p118io.presage.common.profig.schedule;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import p118io.presage.C6514hl;
import p118io.presage.TommedAuvergne;

/* renamed from: io.presage.common.profig.schedule.ProfigSyncIntentService */
public final class ProfigSyncIntentService extends IntentService {

    /* renamed from: a */
    public static final CamembertauCalvados f16932a = new CamembertauCalvados((byte) 0);

    /* renamed from: io.presage.common.profig.schedule.ProfigSyncIntentService$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static void m21164a(Context context) {
            context.startService(new Intent(context, ProfigSyncIntentService.class));
        }

        /* renamed from: b */
        public static void m21165b(Context context) {
            try {
                TommedAuvergne.CamembertauCalvados camembertauCalvados = TommedAuvergne.f16707a;
                Context applicationContext = context.getApplicationContext();
                C6514hl.m21414a((Object) applicationContext, "context.applicationContext");
                camembertauCalvados.mo34711a(applicationContext).m20730b(false);
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public ProfigSyncIntentService() {
        super("ProfigService");
    }

    /* access modifiers changed from: protected */
    public final void onHandleIntent(Intent intent) {
        Context applicationContext = getApplicationContext();
        C6514hl.m21414a((Object) applicationContext, "applicationContext");
        CamembertauCalvados.m21165b(applicationContext);
    }
}
