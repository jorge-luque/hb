package p118io.presage;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import p118io.presage.common.profig.schedule.ProfigJobService;

@TargetApi(21)
/* renamed from: io.presage.o */
public final class C6569o implements C6572r {

    /* renamed from: a */
    public static final CamembertauCalvados f17127a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private JobScheduler f17128b;

    /* renamed from: c */
    private final Context f17129c;

    /* renamed from: io.presage.o$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public C6569o(Context context) {
        this.f17129c = context;
        Object systemService = context.getSystemService("jobscheduler");
        if (systemService != null) {
            this.f17128b = (JobScheduler) systemService;
            return;
        }
        throw new C6434em("null cannot be cast to non-null type android.app.job.JobScheduler");
    }

    /* renamed from: a */
    public final void mo35602a(long j) {
        JobInfo.Builder builder = new JobInfo.Builder(475439765, new ComponentName(this.f17129c, ProfigJobService.class));
        builder.setMinimumLatency(j);
        double d = (double) j;
        Double.isNaN(d);
        builder.setOverrideDeadline((long) (d * 1.2d));
        builder.setRequiredNetworkType(1);
        builder.setRequiresCharging(false);
        builder.setRequiresDeviceIdle(false);
        this.f17128b.schedule(builder.build());
    }

    /* renamed from: a */
    public final void mo35601a() {
        this.f17128b.cancel(475439765);
    }
}
