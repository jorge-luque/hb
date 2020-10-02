package org.cocos2dx.lib;

import com.loopj.android.http.C4244a;
import com.loopj.android.http.C4261l;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import javax.net.ssl.SSLException;

public class Cocos2dxDownloader {
    /* access modifiers changed from: private */
    public static HashMap<String, Boolean> _resumingSupport = new HashMap<>();
    private int _countOfMaxProcessingTasks;
    /* access modifiers changed from: private */
    public C4244a _httpClient = new C4244a();
    /* access modifiers changed from: private */
    public int _id;
    private int _runningTaskCount = 0;
    /* access modifiers changed from: private */
    public HashMap _taskMap = new HashMap();
    private Queue<Runnable> _taskQueue = new LinkedList();
    /* access modifiers changed from: private */
    public String _tempFileNameSufix;

    public static void cancelAllRequests(Cocos2dxDownloader cocos2dxDownloader) {
        Cocos2dxHelper.getActivity().runOnUiThread(new Runnable(cocos2dxDownloader) {
            final /* synthetic */ Cocos2dxDownloader val$downloader;

            {
                this.val$downloader = r1;
            }

            public void run() {
                for (Map.Entry value : this.val$downloader._taskMap.entrySet()) {
                    C4261l lVar = ((DownloadTask) value.getValue()).handle;
                    if (lVar != null) {
                        lVar.mo28920a(true);
                    }
                }
            }
        });
    }

    public static Cocos2dxDownloader createDownloader(int i, int i2, String str, int i3) {
        Cocos2dxDownloader cocos2dxDownloader = new Cocos2dxDownloader();
        cocos2dxDownloader._id = i;
        cocos2dxDownloader._httpClient.mo28838a(true);
        if (i2 > 0) {
            cocos2dxDownloader._httpClient.mo28844c(i2 * 1000);
        }
        C4244a.m14336a((Class<?>) SSLException.class);
        cocos2dxDownloader._httpClient.mo28843b(false);
        cocos2dxDownloader._tempFileNameSufix = str;
        cocos2dxDownloader._countOfMaxProcessingTasks = i3;
        return cocos2dxDownloader;
    }

    public static void createTask(final Cocos2dxDownloader cocos2dxDownloader, final int i, final String str, final String str2) {
        cocos2dxDownloader.enqueueTask(new Runnable() {
            /* JADX WARNING: type inference failed for: r1v20, types: [java.lang.Object[]] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r10 = this;
                    org.cocos2dx.lib.DownloadTask r0 = new org.cocos2dx.lib.DownloadTask
                    r0.<init>()
                    java.lang.String r1 = r4
                    int r1 = r1.length()
                    if (r1 != 0) goto L_0x002c
                    org.cocos2dx.lib.DataTaskHandler r1 = new org.cocos2dx.lib.DataTaskHandler
                    org.cocos2dx.lib.Cocos2dxDownloader r2 = r1
                    int r3 = r2
                    r1.<init>(r2, r3)
                    r0.handler = r1
                    org.cocos2dx.lib.Cocos2dxDownloader r1 = r1
                    com.loopj.android.http.a r1 = r1._httpClient
                    android.app.Activity r2 = org.cocos2dx.lib.Cocos2dxHelper.getActivity()
                    java.lang.String r3 = r3
                    com.loopj.android.http.c r4 = r0.handler
                    com.loopj.android.http.l r1 = r1.mo28833a((android.content.Context) r2, (java.lang.String) r3, (com.loopj.android.http.C4264n) r4)
                    r0.handle = r1
                L_0x002c:
                    java.lang.String r1 = r4
                    int r1 = r1.length()
                    if (r1 != 0) goto L_0x0036
                    goto L_0x015c
                L_0x0036:
                    java.net.URI r1 = new java.net.URI     // Catch:{ URISyntaxException -> 0x015b }
                    java.lang.String r2 = r3     // Catch:{ URISyntaxException -> 0x015b }
                    r1.<init>(r2)     // Catch:{ URISyntaxException -> 0x015b }
                    java.lang.String r1 = r1.getHost()     // Catch:{ URISyntaxException -> 0x015b }
                    java.lang.String r2 = "www."
                    boolean r2 = r1.startsWith(r2)
                    if (r2 == 0) goto L_0x004e
                    r2 = 4
                    java.lang.String r1 = r1.substring(r2)
                L_0x004e:
                    r5 = r1
                    r1 = 0
                    java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
                    r3 = 1
                    java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                    java.util.HashMap r4 = org.cocos2dx.lib.Cocos2dxDownloader._resumingSupport
                    boolean r4 = r4.containsKey(r5)
                    if (r4 == 0) goto L_0x0071
                    java.util.HashMap r2 = org.cocos2dx.lib.Cocos2dxDownloader._resumingSupport
                    java.lang.Object r2 = r2.get(r5)
                    java.lang.Boolean r2 = (java.lang.Boolean) r2
                    java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)
                L_0x0071:
                    boolean r1 = r3.booleanValue()
                    if (r1 == 0) goto L_0x009f
                    org.cocos2dx.lib.HeadTaskHandler r1 = new org.cocos2dx.lib.HeadTaskHandler
                    org.cocos2dx.lib.Cocos2dxDownloader r3 = r1
                    int r4 = r2
                    java.lang.String r6 = r3
                    java.lang.String r7 = r4
                    r2 = r1
                    r2.<init>(r3, r4, r5, r6, r7)
                    r0.handler = r1
                    org.cocos2dx.lib.Cocos2dxDownloader r1 = r1
                    com.loopj.android.http.a r2 = r1._httpClient
                    android.app.Activity r3 = org.cocos2dx.lib.Cocos2dxHelper.getActivity()
                    java.lang.String r4 = r3
                    r5 = 0
                    r6 = 0
                    com.loopj.android.http.c r7 = r0.handler
                    com.loopj.android.http.l r1 = r2.mo28840b(r3, r4, r5, r6, r7)
                    r0.handle = r1
                    goto L_0x015c
                L_0x009f:
                    java.io.File r1 = new java.io.File
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = r4
                    r3.append(r4)
                    org.cocos2dx.lib.Cocos2dxDownloader r4 = r1
                    java.lang.String r4 = r4._tempFileNameSufix
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    r1.<init>(r3)
                    boolean r3 = r1.isDirectory()
                    if (r3 == 0) goto L_0x00c3
                    goto L_0x015c
                L_0x00c3:
                    java.io.File r3 = r1.getParentFile()
                    boolean r4 = r3.isDirectory()
                    if (r4 != 0) goto L_0x00d5
                    boolean r3 = r3.mkdirs()
                    if (r3 != 0) goto L_0x00d5
                    goto L_0x015c
                L_0x00d5:
                    java.io.File r3 = new java.io.File
                    java.lang.String r4 = r4
                    r3.<init>(r4)
                    boolean r4 = r3.isDirectory()
                    if (r4 == 0) goto L_0x00e4
                    goto L_0x015c
                L_0x00e4:
                    org.cocos2dx.lib.FileTaskHandler r4 = new org.cocos2dx.lib.FileTaskHandler
                    org.cocos2dx.lib.Cocos2dxDownloader r5 = r1
                    int r6 = r2
                    r4.<init>(r5, r6, r1, r3)
                    r0.handler = r4
                    r3 = 0
                    long r4 = r1.length()
                    boolean r2 = r2.booleanValue()
                    r6 = 0
                    if (r2 == 0) goto L_0x0133
                    int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                    if (r2 <= 0) goto L_0x0133
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r1.<init>()
                    cz.msebera.android.httpclient.g0.b r2 = new cz.msebera.android.httpclient.g0.b
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r6 = "bytes="
                    r3.append(r6)
                    r3.append(r4)
                    java.lang.String r4 = "-"
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    java.lang.String r4 = "Range"
                    r2.<init>(r4, r3)
                    r1.add(r2)
                    int r2 = r1.size()
                    cz.msebera.android.httpclient.d[] r2 = new p163cz.msebera.android.httpclient.C5691d[r2]
                    java.lang.Object[] r1 = r1.toArray(r2)
                    r3 = r1
                    cz.msebera.android.httpclient.d[] r3 = (p163cz.msebera.android.httpclient.C5691d[]) r3
                    goto L_0x0144
                L_0x0133:
                    int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                    if (r2 <= 0) goto L_0x0144
                    java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch:{ FileNotFoundException -> 0x0144 }
                    r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0144 }
                    java.lang.String r1 = ""
                    r2.print(r1)     // Catch:{ FileNotFoundException -> 0x0144 }
                    r2.close()     // Catch:{ FileNotFoundException -> 0x0144 }
                L_0x0144:
                    r7 = r3
                    org.cocos2dx.lib.Cocos2dxDownloader r1 = r1
                    com.loopj.android.http.a r4 = r1._httpClient
                    android.app.Activity r5 = org.cocos2dx.lib.Cocos2dxHelper.getActivity()
                    java.lang.String r6 = r3
                    r8 = 0
                    com.loopj.android.http.c r9 = r0.handler
                    com.loopj.android.http.l r1 = r4.mo28834a(r5, r6, r7, r8, r9)
                    r0.handle = r1
                    goto L_0x015c
                L_0x015b:
                L_0x015c:
                    com.loopj.android.http.l r1 = r0.handle
                    if (r1 != 0) goto L_0x017c
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "Can't create DownloadTask for "
                    r0.append(r1)
                    java.lang.String r1 = r3
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    org.cocos2dx.lib.Cocos2dxDownloader$3$1 r1 = new org.cocos2dx.lib.Cocos2dxDownloader$3$1
                    r1.<init>(r0)
                    org.cocos2dx.lib.Cocos2dxHelper.runOnGLThread(r1)
                    goto L_0x018b
                L_0x017c:
                    org.cocos2dx.lib.Cocos2dxDownloader r1 = r1
                    java.util.HashMap r1 = r1._taskMap
                    int r2 = r2
                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                    r1.put(r2, r0)
                L_0x018b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.lib.Cocos2dxDownloader.C67323.run():void");
            }
        });
    }

    public static void setResumingSupport(String str, Boolean bool) {
        _resumingSupport.put(str, bool);
    }

    public void enqueueTask(Runnable runnable) {
        synchronized (this._taskQueue) {
            if (this._runningTaskCount < this._countOfMaxProcessingTasks) {
                Cocos2dxHelper.getActivity().runOnUiThread(runnable);
                this._runningTaskCount++;
            } else {
                this._taskQueue.add(runnable);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public native void nativeOnFinish(int i, int i2, int i3, String str, byte[] bArr);

    /* access modifiers changed from: package-private */
    public native void nativeOnProgress(int i, int i2, long j, long j2, long j3);

    public void onFinish(int i, int i2, String str, byte[] bArr) {
        if (((DownloadTask) this._taskMap.get(Integer.valueOf(i))) != null) {
            this._taskMap.remove(Integer.valueOf(i));
            final int i3 = i;
            final int i4 = i2;
            final String str2 = str;
            final byte[] bArr2 = bArr;
            Cocos2dxHelper.runOnGLThread(new Runnable() {
                public void run() {
                    Cocos2dxDownloader cocos2dxDownloader = Cocos2dxDownloader.this;
                    cocos2dxDownloader.nativeOnFinish(cocos2dxDownloader._id, i3, i4, str2, bArr2);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void onProgress(int i, long j, long j2, long j3) {
        DownloadTask downloadTask = (DownloadTask) this._taskMap.get(Integer.valueOf(i));
        long j4 = j;
        if (downloadTask != null) {
            downloadTask.bytesReceived = j4;
            downloadTask.totalBytesReceived = j2;
            downloadTask.totalBytesExpected = j3;
        } else {
            long j5 = j2;
            long j6 = j3;
        }
        final int i2 = i;
        final long j7 = j;
        final long j8 = j2;
        final long j9 = j3;
        Cocos2dxHelper.runOnGLThread(new Runnable() {
            public void run() {
                Cocos2dxDownloader cocos2dxDownloader = Cocos2dxDownloader.this;
                cocos2dxDownloader.nativeOnProgress(cocos2dxDownloader._id, i2, j7, j8, j9);
            }
        });
    }

    public void onStart(int i) {
        DownloadTask downloadTask = (DownloadTask) this._taskMap.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.resetStatus();
        }
    }

    public void runNextTaskIfExists() {
        synchronized (this._taskQueue) {
            Runnable poll = this._taskQueue.poll();
            if (poll != null) {
                Cocos2dxHelper.getActivity().runOnUiThread(poll);
            } else {
                this._runningTaskCount--;
            }
        }
    }
}
