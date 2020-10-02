package com.loopj.android.http;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5870j;

/* renamed from: com.loopj.android.http.e */
/* compiled from: FileAsyncHttpResponseHandler */
public abstract class C4253e extends C4250c {
    private static final String LOG_TAG = "FileAsyncHttpRH";
    protected final boolean append;
    protected final File file;
    protected File frontendFile;
    protected final boolean renameIfExists;

    public C4253e(File file2) {
        this(file2, false);
    }

    public boolean deleteTargetFile() {
        return getTargetFile() != null && getTargetFile().delete();
    }

    /* access modifiers changed from: protected */
    public File getOriginalFile() {
        C4266p.m14398a(this.file != null, "Target file is null, fatal!");
        return this.file;
    }

    /* access modifiers changed from: protected */
    public byte[] getResponseData(C5870j jVar) throws IOException {
        if (jVar == null) {
            return null;
        }
        InputStream content = jVar.getContent();
        long h = jVar.mo28849h();
        FileOutputStream fileOutputStream = new FileOutputStream(getTargetFile(), this.append);
        if (content == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
            int i = 0;
            while (true) {
                int read = content.read(bArr);
                if (read != -1 && !Thread.currentThread().isInterrupted()) {
                    i += read;
                    fileOutputStream.write(bArr, 0, read);
                    sendProgressMessage((long) i, h);
                }
            }
            return null;
        } finally {
            C4244a.m14334a(content);
            fileOutputStream.flush();
            C4244a.m14335a((OutputStream) fileOutputStream);
        }
    }

    public File getTargetFile() {
        if (this.frontendFile == null) {
            this.frontendFile = getOriginalFile().isDirectory() ? getTargetFileByParsingURL() : getOriginalFile();
        }
        return this.frontendFile;
    }

    /* access modifiers changed from: protected */
    public File getTargetFileByParsingURL() {
        String str;
        C4266p.m14398a(getOriginalFile().isDirectory(), "Target file is not a directory, cannot proceed");
        C4266p.m14398a(getRequestURI() != null, "RequestURI is null, cannot proceed");
        String uri = getRequestURI().toString();
        String substring = uri.substring(uri.lastIndexOf(47) + 1, uri.length());
        File file2 = new File(getOriginalFile(), substring);
        if (!file2.exists() || !this.renameIfExists) {
            return file2;
        }
        if (!substring.contains(".")) {
            str = substring + " (%d)";
        } else {
            str = substring.substring(0, substring.lastIndexOf(46)) + " (%d)" + substring.substring(substring.lastIndexOf(46), substring.length());
        }
        int i = 0;
        while (true) {
            File file3 = new File(getOriginalFile(), String.format(str, new Object[]{Integer.valueOf(i)}));
            if (!file3.exists()) {
                return file3;
            }
            i++;
        }
    }

    /* access modifiers changed from: protected */
    public File getTemporaryFile(Context context) {
        C4266p.m14398a(context != null, "Tried creating temporary file without having Context");
        try {
            return File.createTempFile("temp_", "_handled", context.getCacheDir());
        } catch (IOException e) {
            C4244a.f11381j.mo28908b(LOG_TAG, "Cannot create temporary file", e);
            return null;
        }
    }

    public abstract void onFailure(int i, C5691d[] dVarArr, Throwable th, File file2);

    public final void onFailure(int i, C5691d[] dVarArr, byte[] bArr, Throwable th) {
        onFailure(i, dVarArr, th, getTargetFile());
    }

    public abstract void onSuccess(int i, C5691d[] dVarArr, File file2);

    public final void onSuccess(int i, C5691d[] dVarArr, byte[] bArr) {
        onSuccess(i, dVarArr, getTargetFile());
    }

    public C4253e(File file2, boolean z) {
        this(file2, z, false);
    }

    public C4253e(File file2, boolean z, boolean z2) {
        this(file2, z, z2, false);
    }

    public C4253e(File file2, boolean z, boolean z2, boolean z3) {
        super(z3);
        C4266p.m14398a(file2 != null, "File passed into FileAsyncHttpResponseHandler constructor must not be null");
        if (!file2.isDirectory() && !file2.getParentFile().isDirectory()) {
            C4266p.m14398a(file2.getParentFile().mkdirs(), "Cannot create parent directories for requested File location");
        }
        if (file2.isDirectory() && !file2.mkdirs()) {
            C4244a.f11381j.mo28910d(LOG_TAG, "Cannot create directories for requested Directory location, might not be a problem");
        }
        this.file = file2;
        this.append = z;
        this.renameIfExists = z2;
    }

    public C4253e(Context context) {
        this.file = getTemporaryFile(context);
        this.append = false;
        this.renameIfExists = false;
    }
}
