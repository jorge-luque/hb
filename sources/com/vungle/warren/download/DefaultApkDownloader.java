package com.vungle.warren.download;

import android.content.Context;
import android.util.Log;
import com.vungle.warren.utility.ExternalRouter;

public class DefaultApkDownloader implements ApkDownloader {
    private static final String TAG = "DefaultApkDownloader";

    public boolean canDownload(Context context, int i, boolean z) {
        return true;
    }

    public void download(Context context, String str) {
        "Opening " + str;
        if (!ExternalRouter.launch(str, context)) {
            Log.e(TAG, "Cannot open url " + str);
        }
    }
}
