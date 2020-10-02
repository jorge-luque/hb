package com.vungle.warren.tasks;

import android.os.Bundle;
import com.vungle.warren.AdLoader;
import com.vungle.warren.VungleStaticApi;
import java.util.Collection;

public class DownloadJob implements Job {
    private static final String PLACEMENT_KEY = "placement";
    static final String TAG = "com.vungle.warren.tasks.DownloadJob";
    private final AdLoader adLoader;
    private final VungleStaticApi vungleApi;

    public DownloadJob(AdLoader adLoader2, VungleStaticApi vungleStaticApi) {
        this.adLoader = adLoader2;
        this.vungleApi = vungleStaticApi;
    }

    public static JobInfo makeJobInfo(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("placement", str);
        return new JobInfo(TAG + " " + str).setUpdateCurrent(true).setExtras(bundle).setPriority(4);
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        String string = bundle.getString("placement", (String) null);
        Collection<String> validPlacements = this.vungleApi.getValidPlacements();
        if (string == null || !validPlacements.contains(string)) {
            return 1;
        }
        this.adLoader.loadPendingInternal(string);
        return 0;
    }
}
