package com.vungle.warren.tasks;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.vungle.warren.analytics.AdAnalytics;

public class AnalyticsJob implements Job {
    private static final long DEFAULT_DELAY = 2000;
    public static final String EXTRA_ACTION = "action_extra";
    private static final String EXTRA_BODY = "extra_body";
    private static final String EXTRA_URLS = "extra_urls";
    public static final String TAG = "AnalyticsJob";
    private final AdAnalytics adAnalytics;

    public @interface Action {
        public static final int PING = 1;

        /* renamed from: RI */
        public static final int f8853RI = 0;
    }

    public AnalyticsJob(AdAnalytics adAnalytics2) {
        this.adAnalytics = adAnalytics2;
    }

    public static JobInfo makeJob(@Action int i, String str, String[] strArr) {
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_ACTION, i);
        bundle.putString(EXTRA_BODY, str);
        bundle.putStringArray(EXTRA_URLS, strArr);
        return new JobInfo(TAG).setUpdateCurrent(false).setExtras(bundle).setReschedulePolicy(2000, 1).setRequiredNetworkType(1).setPriority(5);
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        String[] stringArray;
        int i = bundle.getInt(EXTRA_ACTION, -1);
        if (i == 0) {
            this.adAnalytics.mo32325ri(((JsonElement) new Gson().fromJson(bundle.getString(EXTRA_BODY), JsonElement.class)).getAsJsonObject());
            return 0;
        } else if (i != 1 || (stringArray = bundle.getStringArray(EXTRA_URLS)) == null) {
            return 0;
        } else {
            String[] ping = this.adAnalytics.ping(stringArray);
            if (ping.length == 0) {
                return 0;
            }
            bundle.putStringArray(EXTRA_URLS, ping);
            return 2;
        }
    }
}
