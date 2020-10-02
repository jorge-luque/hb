package com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URI;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.C5910y;
import p163cz.msebera.android.httpclient.client.HttpResponseException;

/* renamed from: com.loopj.android.http.c */
/* compiled from: AsyncHttpResponseHandler */
public abstract class C4250c implements C4264n {
    protected static final int BUFFER_SIZE = 4096;
    protected static final int CANCEL_MESSAGE = 6;
    public static final String DEFAULT_CHARSET = "UTF-8";
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    private static final String LOG_TAG = "AsyncHttpRH";
    protected static final int PROGRESS_MESSAGE = 4;
    protected static final int RETRY_MESSAGE = 5;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    public static final String UTF8_BOM = "﻿";
    private WeakReference<Object> TAG;
    private Handler handler;
    private Looper looper;
    private C5691d[] requestHeaders;
    private URI requestURI;
    private String responseCharset;
    private boolean usePoolThread;
    private boolean useSynchronousMode;

    /* renamed from: com.loopj.android.http.c$a */
    /* compiled from: AsyncHttpResponseHandler */
    private static class C4251a extends Handler {

        /* renamed from: a */
        private final C4250c f11404a;

        C4251a(C4250c cVar, Looper looper) {
            super(looper);
            this.f11404a = cVar;
        }

        public void handleMessage(Message message) {
            this.f11404a.handleMessage(message);
        }
    }

    public C4250c() {
        this((Looper) null);
    }

    public String getCharset() {
        String str = this.responseCharset;
        return str == null ? DEFAULT_CHARSET : str;
    }

    public C5691d[] getRequestHeaders() {
        return this.requestHeaders;
    }

    public URI getRequestURI() {
        return this.requestURI;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        com.loopj.android.http.C4244a.m14334a(r0);
        com.loopj.android.http.C4244a.m14333a(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return r7.mo33663g();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getResponseData(p163cz.msebera.android.httpclient.C5870j r13) throws java.io.IOException {
        /*
            r12 = this;
            if (r13 == 0) goto L_0x0070
            java.io.InputStream r0 = r13.getContent()
            if (r0 == 0) goto L_0x0070
            long r1 = r13.mo28849h()
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0068
            r3 = 4096(0x1000, float:5.74E-42)
            r4 = 0
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x001e
            r6 = 4096(0x1000, float:5.74E-42)
            goto L_0x001f
        L_0x001e:
            int r6 = (int) r1
        L_0x001f:
            cz.msebera.android.httpclient.k0.c r7 = new cz.msebera.android.httpclient.k0.c     // Catch:{ OutOfMemoryError -> 0x005d }
            r7.<init>(r6)     // Catch:{ OutOfMemoryError -> 0x005d }
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0055 }
            r8 = r4
        L_0x0027:
            int r6 = r0.read(r3)     // Catch:{ all -> 0x0055 }
            r10 = -1
            if (r6 == r10) goto L_0x004a
            java.lang.Thread r10 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0055 }
            boolean r10 = r10.isInterrupted()     // Catch:{ all -> 0x0055 }
            if (r10 != 0) goto L_0x004a
            long r10 = (long) r6     // Catch:{ all -> 0x0055 }
            long r8 = r8 + r10
            r10 = 0
            r7.mo33654a((byte[]) r3, (int) r10, (int) r6)     // Catch:{ all -> 0x0055 }
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0045
            r10 = 1
            goto L_0x0046
        L_0x0045:
            r10 = r1
        L_0x0046:
            r12.sendProgressMessage(r8, r10)     // Catch:{ all -> 0x0055 }
            goto L_0x0027
        L_0x004a:
            com.loopj.android.http.C4244a.m14334a((java.io.InputStream) r0)     // Catch:{ OutOfMemoryError -> 0x005d }
            com.loopj.android.http.C4244a.m14333a((p163cz.msebera.android.httpclient.C5870j) r13)     // Catch:{ OutOfMemoryError -> 0x005d }
            byte[] r13 = r7.mo33663g()     // Catch:{ OutOfMemoryError -> 0x005d }
            goto L_0x0071
        L_0x0055:
            r1 = move-exception
            com.loopj.android.http.C4244a.m14334a((java.io.InputStream) r0)     // Catch:{ OutOfMemoryError -> 0x005d }
            com.loopj.android.http.C4244a.m14333a((p163cz.msebera.android.httpclient.C5870j) r13)     // Catch:{ OutOfMemoryError -> 0x005d }
            throw r1     // Catch:{ OutOfMemoryError -> 0x005d }
        L_0x005d:
            java.lang.System.gc()
            java.io.IOException r13 = new java.io.IOException
            java.lang.String r0 = "File too large to fit into available memory"
            r13.<init>(r0)
            throw r13
        L_0x0068:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "HTTP entity too large to be buffered in memory"
            r13.<init>(r0)
            throw r13
        L_0x0070:
            r13 = 0
        L_0x0071:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loopj.android.http.C4250c.getResponseData(cz.msebera.android.httpclient.j):byte[]");
    }

    public Object getTag() {
        return this.TAG.get();
    }

    public boolean getUsePoolThread() {
        return this.usePoolThread;
    }

    public boolean getUseSynchronousMode() {
        return this.useSynchronousMode;
    }

    /* access modifiers changed from: protected */
    public void handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    Object[] objArr = (Object[]) message.obj;
                    if (objArr == null || objArr.length < 3) {
                        C4244a.f11381j.mo28907b(LOG_TAG, "SUCCESS_MESSAGE didn't got enough params");
                        return;
                    } else {
                        onSuccess(((Integer) objArr[0]).intValue(), (C5691d[]) objArr[1], (byte[]) objArr[2]);
                        return;
                    }
                case 1:
                    Object[] objArr2 = (Object[]) message.obj;
                    if (objArr2 == null || objArr2.length < 4) {
                        C4244a.f11381j.mo28907b(LOG_TAG, "FAILURE_MESSAGE didn't got enough params");
                        return;
                    } else {
                        onFailure(((Integer) objArr2[0]).intValue(), (C5691d[]) objArr2[1], (byte[]) objArr2[2], (Throwable) objArr2[3]);
                        return;
                    }
                case 2:
                    onStart();
                    return;
                case 3:
                    onFinish();
                    return;
                case 4:
                    Object[] objArr3 = (Object[]) message.obj;
                    if (objArr3 == null || objArr3.length < 2) {
                        C4244a.f11381j.mo28907b(LOG_TAG, "PROGRESS_MESSAGE didn't got enough params");
                        return;
                    } else {
                        onProgress(((Long) objArr3[0]).longValue(), ((Long) objArr3[1]).longValue());
                        return;
                    }
                case 5:
                    Object[] objArr4 = (Object[]) message.obj;
                    if (objArr4 == null || objArr4.length != 1) {
                        C4244a.f11381j.mo28907b(LOG_TAG, "RETRY_MESSAGE didn't get enough params");
                        return;
                    } else {
                        onRetry(((Integer) objArr4[0]).intValue());
                        return;
                    }
                case 6:
                    onCancel();
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            onUserException(th);
        }
        onUserException(th);
    }

    /* access modifiers changed from: protected */
    public Message obtainMessage(int i, Object obj) {
        return Message.obtain(this.handler, i, obj);
    }

    public void onCancel() {
        C4244a.f11381j.mo28910d(LOG_TAG, "Request got cancelled");
    }

    public abstract void onFailure(int i, C5691d[] dVarArr, byte[] bArr, Throwable th);

    public void onFinish() {
    }

    public void onPostProcessResponse(C4264n nVar, C5901q qVar) {
    }

    public void onPreProcessResponse(C4264n nVar, C5901q qVar) {
    }

    public void onProgress(long j, long j2) {
        double d;
        C4256h hVar = C4244a.f11381j;
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(j2);
        if (j2 > 0) {
            double d2 = (double) j;
            Double.isNaN(d2);
            double d3 = (double) j2;
            Double.isNaN(d3);
            d = ((d2 * 1.0d) / d3) * 100.0d;
        } else {
            d = -1.0d;
        }
        objArr[2] = Double.valueOf(d);
        hVar.mo28909c(LOG_TAG, String.format("Progress %d from %d (%2.0f%%)", objArr));
    }

    public void onRetry(int i) {
        C4244a.f11381j.mo28910d(LOG_TAG, String.format("Request retry no. %d", new Object[]{Integer.valueOf(i)}));
    }

    public void onStart() {
    }

    public abstract void onSuccess(int i, C5691d[] dVarArr, byte[] bArr);

    public void onUserException(Throwable th) {
        C4244a.f11381j.mo28908b(LOG_TAG, "User-space exception detected!", th);
        throw new RuntimeException(th);
    }

    /* access modifiers changed from: protected */
    public void postRunnable(Runnable runnable) {
        Handler handler2;
        if (runnable == null) {
            return;
        }
        if (getUseSynchronousMode() || (handler2 = this.handler) == null) {
            runnable.run();
        } else {
            handler2.post(runnable);
        }
    }

    public final void sendCancelMessage() {
        sendMessage(obtainMessage(6, (Object) null));
    }

    public final void sendFailureMessage(int i, C5691d[] dVarArr, byte[] bArr, Throwable th) {
        sendMessage(obtainMessage(1, new Object[]{Integer.valueOf(i), dVarArr, bArr, th}));
    }

    public final void sendFinishMessage() {
        sendMessage(obtainMessage(3, (Object) null));
    }

    /* access modifiers changed from: protected */
    public void sendMessage(Message message) {
        if (getUseSynchronousMode() || this.handler == null) {
            handleMessage(message);
        } else if (!Thread.currentThread().isInterrupted()) {
            C4266p.m14398a(this.handler != null, "handler should not be null!");
            this.handler.sendMessage(message);
        }
    }

    public final void sendProgressMessage(long j, long j2) {
        sendMessage(obtainMessage(4, new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
    }

    public void sendResponseMessage(C5901q qVar) throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            C5910y a = qVar.mo33335a();
            byte[] responseData = getResponseData(qVar.getEntity());
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (a.mo33371a() >= 300) {
                sendFailureMessage(a.mo33371a(), qVar.getAllHeaders(), responseData, new HttpResponseException(a.mo33371a(), a.mo33372b()));
            } else {
                sendSuccessMessage(a.mo33371a(), qVar.getAllHeaders(), responseData);
            }
        }
    }

    public final void sendRetryMessage(int i) {
        sendMessage(obtainMessage(5, new Object[]{Integer.valueOf(i)}));
    }

    public final void sendStartMessage() {
        sendMessage(obtainMessage(2, (Object) null));
    }

    public final void sendSuccessMessage(int i, C5691d[] dVarArr, byte[] bArr) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), dVarArr, bArr}));
    }

    public void setCharset(String str) {
        this.responseCharset = str;
    }

    public void setRequestHeaders(C5691d[] dVarArr) {
        this.requestHeaders = dVarArr;
    }

    public void setRequestURI(URI uri) {
        this.requestURI = uri;
    }

    public void setTag(Object obj) {
        this.TAG = new WeakReference<>(obj);
    }

    public void setUsePoolThread(boolean z) {
        if (z) {
            this.looper = null;
            this.handler = null;
        }
        this.usePoolThread = z;
    }

    public void setUseSynchronousMode(boolean z) {
        if (!z && this.looper == null) {
            z = true;
            C4244a.f11381j.mo28903a(LOG_TAG, "Current thread has not called Looper.prepare(). Forcing synchronous mode.");
        }
        if (!z && this.handler == null) {
            this.handler = new C4251a(this, this.looper);
        } else if (z && this.handler != null) {
            this.handler = null;
        }
        this.useSynchronousMode = z;
    }

    public C4250c(Looper looper2) {
        this.responseCharset = DEFAULT_CHARSET;
        this.requestURI = null;
        this.requestHeaders = null;
        this.looper = null;
        this.TAG = new WeakReference<>((Object) null);
        this.looper = looper2 == null ? Looper.myLooper() : looper2;
        setUseSynchronousMode(false);
        setUsePoolThread(false);
    }

    public C4250c(boolean z) {
        this.responseCharset = DEFAULT_CHARSET;
        this.requestURI = null;
        this.requestHeaders = null;
        this.looper = null;
        this.TAG = new WeakReference<>((Object) null);
        setUsePoolThread(z);
        if (!getUsePoolThread()) {
            this.looper = Looper.myLooper();
            setUseSynchronousMode(false);
        }
    }
}
