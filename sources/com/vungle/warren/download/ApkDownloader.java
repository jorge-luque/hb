package com.vungle.warren.download;

import android.content.Context;

public interface ApkDownloader {
    boolean canDownload(Context context, int i, boolean z);

    void download(Context context, String str);
}
