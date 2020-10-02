package org.cocos2dx.lib;

import com.loopj.android.http.C4252d;
import p163cz.msebera.android.httpclient.C5691d;

/* compiled from: Cocos2dxDownloader */
class DataTaskHandler extends C4252d {
    private Cocos2dxDownloader _downloader;
    int _id;
    private long _lastBytesWritten = 0;

    public DataTaskHandler(Cocos2dxDownloader cocos2dxDownloader, int i) {
        super(new String[]{".*"});
        this._downloader = cocos2dxDownloader;
        this._id = i;
    }

    /* access modifiers changed from: package-private */
    public void LogD(String str) {
    }

    public void onFailure(int i, C5691d[] dVarArr, byte[] bArr, Throwable th) {
        LogD("onFailure(i:" + i + " headers:" + dVarArr + " throwable:" + th);
        this._downloader.onFinish(this._id, i, th != null ? th.toString() : "", (byte[]) null);
    }

    public void onFinish() {
        this._downloader.runNextTaskIfExists();
    }

    public void onProgress(long j, long j2) {
        this._downloader.onProgress(this._id, j - this._lastBytesWritten, j, j2);
        this._lastBytesWritten = j;
    }

    public void onStart() {
        this._downloader.onStart(this._id);
    }

    public void onSuccess(int i, C5691d[] dVarArr, byte[] bArr) {
        LogD("onSuccess(i:" + i + " headers:" + dVarArr);
        this._downloader.onFinish(this._id, 0, (String) null, bArr);
    }
}
