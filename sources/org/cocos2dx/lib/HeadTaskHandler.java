package org.cocos2dx.lib;

import com.loopj.android.http.C4250c;
import p163cz.msebera.android.httpclient.C5691d;

/* compiled from: Cocos2dxDownloader */
class HeadTaskHandler extends C4250c {
    private Cocos2dxDownloader _downloader;
    String _host;
    int _id;
    String _path;
    String _url;

    public HeadTaskHandler(Cocos2dxDownloader cocos2dxDownloader, int i, String str, String str2, String str3) {
        this._downloader = cocos2dxDownloader;
        this._id = i;
        this._host = str;
        this._url = str2;
        this._path = str3;
    }

    /* access modifiers changed from: package-private */
    public void LogD(String str) {
    }

    public void onFailure(int i, C5691d[] dVarArr, byte[] bArr, Throwable th) {
        LogD("onFailure(code:" + i + " headers:" + dVarArr + " throwable:" + th + " id:" + this._id);
        this._downloader.onFinish(this._id, i, th != null ? th.toString() : "", (byte[]) null);
    }

    public void onFinish() {
        this._downloader.runNextTaskIfExists();
    }

    public void onSuccess(int i, C5691d[] dVarArr, byte[] bArr) {
        int i2 = 0;
        boolean z = false;
        while (true) {
            if (i2 >= dVarArr.length) {
                break;
            }
            C5691d dVar = dVarArr[i2];
            if (dVar.getName().equals("Accept-Ranges")) {
                z = Boolean.valueOf(dVar.getValue().equals("bytes"));
                break;
            }
            i2++;
        }
        Cocos2dxDownloader.setResumingSupport(this._host, z);
        Cocos2dxDownloader.createTask(this._downloader, this._id, this._url, this._path);
    }
}
