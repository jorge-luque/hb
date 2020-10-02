package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;

/* renamed from: com.onesignal.u1 */
/* compiled from: OneSignalJobServiceBase */
abstract class C4669u1 extends JobService {

    /* renamed from: com.onesignal.u1$a */
    /* compiled from: OneSignalJobServiceBase */
    class C4670a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ JobService f12704a;

        /* renamed from: b */
        final /* synthetic */ JobParameters f12705b;

        C4670a(JobService jobService, JobParameters jobParameters) {
            this.f12704a = jobService;
            this.f12705b = jobParameters;
        }

        public void run() {
            C4669u1.this.mo29684a(this.f12704a, this.f12705b);
            C4669u1.this.jobFinished(this.f12705b, false);
        }
    }

    C4669u1() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo29684a(JobService jobService, JobParameters jobParameters);

    public boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters.getExtras() == null) {
            return false;
        }
        new Thread(new C4670a(this, jobParameters), "OS_JOBSERVICE_BASE").start();
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
