package p118io.presage.common.profig.schedule;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import p118io.presage.C6437ep;
import p118io.presage.C6481gf;
import p118io.presage.C6482gg;
import p118io.presage.C6514hl;
import p118io.presage.C6515hm;
import p118io.presage.FourmedeMontbrison;
import p118io.presage.common.profig.schedule.ProfigSyncIntentService;

@TargetApi(21)
/* renamed from: io.presage.common.profig.schedule.ProfigJobService */
public final class ProfigJobService extends JobService {

    /* renamed from: a */
    private JobParameters f16928a;

    /* renamed from: io.presage.common.profig.schedule.ProfigJobService$CamembertauCalvados */
    static final class CamembertauCalvados extends C6515hm implements C6481gf<C6437ep> {

        /* renamed from: a */
        final /* synthetic */ ProfigJobService f16929a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        CamembertauCalvados(ProfigJobService profigJobService) {
            super(0);
            this.f16929a = profigJobService;
        }

        /* renamed from: b */
        private void m21158b() {
            ProfigSyncIntentService.CamembertauCalvados camembertauCalvados = ProfigSyncIntentService.f16932a;
            Context applicationContext = this.f16929a.getApplicationContext();
            C6514hl.m21414a((Object) applicationContext, "applicationContext");
            ProfigSyncIntentService.CamembertauCalvados.m21165b(applicationContext);
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo34405a() {
            m21158b();
            return C6437ep.f17017a;
        }
    }

    /* renamed from: io.presage.common.profig.schedule.ProfigJobService$CamembertdeNormandie */
    static final class CamembertdeNormandie extends C6515hm implements C6482gg<Throwable, C6437ep> {

        /* renamed from: a */
        final /* synthetic */ ProfigJobService f16930a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        CamembertdeNormandie(ProfigJobService profigJobService) {
            super(1);
            this.f16930a = profigJobService;
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ Object mo34409a(Object obj) {
            m21160a();
            return C6437ep.f17017a;
        }

        /* renamed from: a */
        private void m21160a() {
            this.f16930a.m21156a();
        }
    }

    /* renamed from: io.presage.common.profig.schedule.ProfigJobService$EcirdelAubrac */
    static final class EcirdelAubrac extends C6515hm implements C6481gf<C6437ep> {

        /* renamed from: a */
        final /* synthetic */ ProfigJobService f16931a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        EcirdelAubrac(ProfigJobService profigJobService) {
            super(0);
            this.f16931a = profigJobService;
        }

        /* renamed from: b */
        private void m21162b() {
            this.f16931a.m21156a();
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo34405a() {
            m21162b();
            return C6437ep.f17017a;
        }
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        this.f16928a = jobParameters;
        FourmedeMontbrison.CamembertauCalvados camembertauCalvados = FourmedeMontbrison.f16513a;
        FourmedeMontbrison.CamembertauCalvados.m20398a(new CamembertauCalvados(this)).mo34554a((C6482gg<? super Throwable, C6437ep>) new CamembertdeNormandie(this)).mo34555a((C6481gf<C6437ep>) new EcirdelAubrac(this));
        return true;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21156a() {
        StringBuilder sb = new StringBuilder("marking job as finished ");
        JobParameters jobParameters = this.f16928a;
        sb.append(jobParameters != null ? jobParameters.toString() : null);
        jobFinished(this.f16928a, false);
    }
}
