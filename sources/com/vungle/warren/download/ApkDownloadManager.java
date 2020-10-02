package com.vungle.warren.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public class ApkDownloadManager {
    public static final int DIRECT_DOWNLOAD_FLAG_DISABLED = 0;
    public static final int DIRECT_DOWNLOAD_FLAG_ENABLED = 1;
    public static final int DIRECT_DOWNLOAD_FLAG_NOT_SET = -1;
    @SuppressLint({"StaticFieldLeak"})
    private static ApkDownloadManager INSTANCE = null;
    private static final String TAG = "ApkDownloadManager";
    private Context context;
    private DefaultApkDownloader defaultApkDownloader;
    private int directDownloadStatus = -1;
    private ApkDownloader inAppApkDownloader;
    private ServiceLoader<ApkDownloader> serviceLoader;

    public static synchronized ApkDownloadManager getInstance() {
        ApkDownloadManager apkDownloadManager;
        synchronized (ApkDownloadManager.class) {
            if (INSTANCE == null) {
                INSTANCE = new ApkDownloadManager();
            }
            apkDownloadManager = INSTANCE;
        }
        return apkDownloadManager;
    }

    public void download(String str, boolean z) {
        Context context2;
        if (TextUtils.isEmpty(str) || (context2 = this.context) == null) {
            Log.e(TAG, "Invalid params found!");
            return;
        }
        ApkDownloader apkDownloader = this.inAppApkDownloader;
        if (apkDownloader == null || !apkDownloader.canDownload(context2, this.directDownloadStatus, z)) {
            DefaultApkDownloader defaultApkDownloader2 = this.defaultApkDownloader;
            if (defaultApkDownloader2 == null || !defaultApkDownloader2.canDownload(this.context, this.directDownloadStatus, z)) {
                Log.e(TAG, "Error occurred processing this URL!");
            } else {
                this.defaultApkDownloader.download(this.context, str);
            }
        } else {
            this.inAppApkDownloader.download(this.context, str);
        }
    }

    /* access modifiers changed from: package-private */
    public ApkDownloader findPlugin() {
        if (this.serviceLoader == null) {
            this.serviceLoader = ServiceLoader.load(ApkDownloader.class);
        }
        ServiceLoader<ApkDownloader> serviceLoader2 = this.serviceLoader;
        if (serviceLoader2 == null) {
            return null;
        }
        try {
            Iterator<ApkDownloader> it = serviceLoader2.iterator();
            if (it.hasNext()) {
                return it.next();
            }
            return null;
        } catch (ServiceConfigurationError e) {
            "find plugin failed:" + e.getMessage();
            return null;
        }
    }

    public void init(Context context2, int i) {
        this.context = context2.getApplicationContext();
        this.directDownloadStatus = i;
        if (this.inAppApkDownloader == null) {
            this.inAppApkDownloader = findPlugin();
        }
        if (this.defaultApkDownloader == null) {
            this.defaultApkDownloader = new DefaultApkDownloader();
        }
    }

    public void setMockDefaultApkDownloader(DefaultApkDownloader defaultApkDownloader2) {
        this.defaultApkDownloader = defaultApkDownloader2;
    }
}
