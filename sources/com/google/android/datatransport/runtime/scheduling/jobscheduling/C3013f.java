package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;

/* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.f */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C3013f implements Runnable {

    /* renamed from: a */
    private final JobInfoSchedulerService f8383a;

    /* renamed from: b */
    private final JobParameters f8384b;

    private C3013f(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f8383a = jobInfoSchedulerService;
        this.f8384b = jobParameters;
    }

    /* renamed from: a */
    public static Runnable m9903a(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        return new C3013f(jobInfoSchedulerService, jobParameters);
    }

    public void run() {
        this.f8383a.jobFinished(this.f8384b, false);
    }
}
