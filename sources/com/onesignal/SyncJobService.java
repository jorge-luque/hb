package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import com.onesignal.C4469a2;

public class SyncJobService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        C4469a2.m15409a((Context) this, (C4469a2.C4472c) new C4469a2.C4471b(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return C4469a2.m15410a();
    }
}
