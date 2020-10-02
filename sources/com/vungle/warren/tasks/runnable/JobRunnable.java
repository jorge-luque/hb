package com.vungle.warren.tasks.runnable;

import android.os.Process;
import android.util.Log;
import com.vungle.warren.tasks.JobCreator;
import com.vungle.warren.tasks.JobInfo;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.tasks.UnknownTagException;
import com.vungle.warren.tasks.utility.ThreadPriorityHelper;
import com.vungle.warren.utility.PriorityRunnable;

public class JobRunnable extends PriorityRunnable {
    private static final String TAG = JobRunnable.class.getSimpleName();
    private final JobCreator creator;
    private final JobRunner jobRunner;
    private final JobInfo jobinfo;
    private final ThreadPriorityHelper threadPriorityHelper;

    public JobRunnable(JobInfo jobInfo, JobCreator jobCreator, JobRunner jobRunner2, ThreadPriorityHelper threadPriorityHelper2) {
        this.jobinfo = jobInfo;
        this.creator = jobCreator;
        this.jobRunner = jobRunner2;
        this.threadPriorityHelper = threadPriorityHelper2;
    }

    public Integer getPriority() {
        return Integer.valueOf(this.jobinfo.getPriority());
    }

    public void run() {
        ThreadPriorityHelper threadPriorityHelper2 = this.threadPriorityHelper;
        if (threadPriorityHelper2 != null) {
            try {
                int makeAndroidThreadPriority = threadPriorityHelper2.makeAndroidThreadPriority(this.jobinfo);
                Process.setThreadPriority(makeAndroidThreadPriority);
                "Setting process thread prio = " + makeAndroidThreadPriority + " for " + this.jobinfo.getJobTag();
            } catch (Throwable unused) {
                Log.e(TAG, "Error on setting process thread priority");
            }
        }
        try {
            String jobTag = this.jobinfo.getJobTag();
            "Start job " + jobTag + "Thread " + Thread.currentThread().getName();
            int onRunJob = this.creator.create(jobTag).onRunJob(this.jobinfo.getExtras(), this.jobRunner);
            "On job finished " + jobTag + " with result " + onRunJob;
            if (onRunJob == 2) {
                long makeNextRescedule = this.jobinfo.makeNextRescedule();
                if (makeNextRescedule > 0) {
                    this.jobinfo.setDelay(makeNextRescedule);
                    this.jobRunner.execute(this.jobinfo);
                    "Rescheduling " + jobTag + " in " + makeNextRescedule;
                }
            }
        } catch (UnknownTagException e) {
            Log.e(TAG, "Cannot create job" + e.getLocalizedMessage());
        } catch (Throwable th) {
            Log.e(TAG, "Can't start job", th);
        }
    }
}
