package org.cocos2dx.lib;

import com.loopj.android.http.C4250c;
import com.loopj.android.http.C4261l;

/* compiled from: Cocos2dxDownloader */
class DownloadTask {
    long bytesReceived;
    byte[] data;
    C4261l handle = null;
    C4250c handler = null;
    long totalBytesExpected;
    long totalBytesReceived;

    DownloadTask() {
        resetStatus();
    }

    /* access modifiers changed from: package-private */
    public void resetStatus() {
        this.bytesReceived = 0;
        this.totalBytesReceived = 0;
        this.totalBytesExpected = 0;
        this.data = null;
    }
}
