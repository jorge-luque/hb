package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import p093e.p101c.p102a.p103a.p104i.C3406l;
import p093e.p101c.p102a.p103a.p104i.C3412q;
import p093e.p101c.p102a.p103a.p104i.p110x.C3475a;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class JobInfoSchedulerService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        C3412q.m11367a(getApplicationContext());
        C3406l.C3407a d = C3406l.m11350d();
        d.mo19190a(string);
        d.mo19189a(C3475a.m11524a(i));
        if (string2 != null) {
            d.mo19191a(Base64.decode(string2, 0));
        }
        C3412q.m11368b().mo19215a().mo13002a(d.mo19192a(), i2, C3013f.m9903a(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
