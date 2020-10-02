package org.cocos2dx.lib;

import com.loopj.android.http.C4253e;
import java.io.File;
import p163cz.msebera.android.httpclient.C5691d;

/* compiled from: Cocos2dxDownloader */
class FileTaskHandler extends C4253e {
    private Cocos2dxDownloader _downloader;
    File _finalFile;
    int _id;
    private long _initFileLen = getTargetFile().length();
    private long _lastBytesWritten = 0;

    public FileTaskHandler(Cocos2dxDownloader cocos2dxDownloader, int i, File file, File file2) {
        super(file, true);
        this._finalFile = file2;
        this._downloader = cocos2dxDownloader;
        this._id = i;
    }

    /* access modifiers changed from: package-private */
    public void LogD(String str) {
    }

    public void onFailure(int i, C5691d[] dVarArr, Throwable th, File file) {
        LogD("onFailure(i:" + i + " headers:" + dVarArr + " throwable:" + th + " file:" + file);
        this._downloader.onFinish(this._id, i, th != null ? th.toString() : "", (byte[]) null);
    }

    public void onFinish() {
        this._downloader.runNextTaskIfExists();
    }

    public void onProgress(long j, long j2) {
        long j3 = j - this._lastBytesWritten;
        long j4 = this._initFileLen;
        this._downloader.onProgress(this._id, j3, j + j4, j2 + j4);
        this._lastBytesWritten = j;
    }

    public void onStart() {
        this._downloader.onStart(this._id);
    }

    public void onSuccess(int i, C5691d[] dVarArr, File file) {
        String str;
        LogD("onSuccess(i:" + i + " headers:" + dVarArr + " file:" + file);
        if (this._finalFile.exists()) {
            if (this._finalFile.isDirectory()) {
                str = "Dest file is directory:" + this._finalFile.getAbsolutePath();
            } else if (!this._finalFile.delete()) {
                str = "Can't remove old file:" + this._finalFile.getAbsolutePath();
            }
            this._downloader.onFinish(this._id, 0, str, (byte[]) null);
        }
        getTargetFile().renameTo(this._finalFile);
        str = null;
        this._downloader.onFinish(this._id, 0, str, (byte[]) null);
    }
}
