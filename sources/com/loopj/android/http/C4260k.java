package com.loopj.android.http;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5870j;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.C5910y;
import p163cz.msebera.android.httpclient.client.HttpResponseException;
import p163cz.msebera.android.httpclient.client.p169o.C5600i;

/* renamed from: com.loopj.android.http.k */
/* compiled from: RangeFileAsyncHttpResponseHandler */
public abstract class C4260k extends C4253e {

    /* renamed from: a */
    private long f11409a;

    /* renamed from: b */
    private boolean f11410b;

    /* renamed from: a */
    public void mo28918a(C5600i iVar) {
        if (this.file.exists() && this.file.canWrite()) {
            this.f11409a = this.file.length();
        }
        if (this.f11409a > 0) {
            this.f11410b = true;
            iVar.setHeader("Range", "bytes=" + this.f11409a + "-");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] getResponseData(C5870j jVar) throws IOException {
        int read;
        if (jVar == null) {
            return null;
        }
        InputStream content = jVar.getContent();
        long h = jVar.mo28849h() + this.f11409a;
        FileOutputStream fileOutputStream = new FileOutputStream(getTargetFile(), this.f11410b);
        if (content == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
            while (this.f11409a < h && (read = content.read(bArr)) != -1 && !Thread.currentThread().isInterrupted()) {
                this.f11409a += (long) read;
                fileOutputStream.write(bArr, 0, read);
                sendProgressMessage(this.f11409a, h);
            }
            return null;
        } finally {
            content.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        }
    }

    public void sendResponseMessage(C5901q qVar) throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            C5910y a = qVar.mo33335a();
            if (a.mo33371a() == 416) {
                if (!Thread.currentThread().isInterrupted()) {
                    sendSuccessMessage(a.mo33371a(), qVar.getAllHeaders(), (byte[]) null);
                }
            } else if (a.mo33371a() >= 300) {
                if (!Thread.currentThread().isInterrupted()) {
                    sendFailureMessage(a.mo33371a(), qVar.getAllHeaders(), (byte[]) null, new HttpResponseException(a.mo33371a(), a.mo33372b()));
                }
            } else if (!Thread.currentThread().isInterrupted()) {
                C5691d firstHeader = qVar.getFirstHeader("Content-Range");
                if (firstHeader == null) {
                    this.f11410b = false;
                    this.f11409a = 0;
                } else {
                    C4256h hVar = C4244a.f11381j;
                    hVar.mo28909c("RangeFileAsyncHttpRH", "Content-Range: " + firstHeader.getValue());
                }
                sendSuccessMessage(a.mo33371a(), qVar.getAllHeaders(), getResponseData(qVar.getEntity()));
            }
        }
    }
}
