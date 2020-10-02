package com.vungle.warren.tasks;

import android.os.Bundle;

public class ReconfigJob implements Job {
    public static final String TAG = "com.vungle.warren.tasks.ReconfigJob";
    private ReconfigCall reconfigCall;

    public interface ReconfigCall {
        void reConfigVungle();
    }

    public ReconfigJob(ReconfigCall reconfigCall2) {
        this.reconfigCall = reconfigCall2;
    }

    public static JobInfo makeJobInfo(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("appID", str);
        return new JobInfo(TAG).setExtras(bundle).setUpdateCurrent(true).setPriority(4);
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        if (bundle.getString("appID", (String) null) == null) {
            return 1;
        }
        this.reconfigCall.reConfigVungle();
        return 0;
    }
}
