package com.google.firebase.installations;

import android.util.Log;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* renamed from: com.google.firebase.installations.b */
/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
class C3756b {

    /* renamed from: a */
    private final FileChannel f10415a;

    /* renamed from: b */
    private final FileLock f10416b;

    private C3756b(FileChannel fileChannel, FileLock fileLock) {
        this.f10415a = fileChannel;
        this.f10416b = fileLock;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0030 A[SYNTHETIC, Splitter:B:15:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037 A[SYNTHETIC, Splitter:B:19:0x0037] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.firebase.installations.C3756b m12664a(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0024 }
            java.io.File r4 = r4.getFilesDir()     // Catch:{ IOException -> 0x0024 }
            r1.<init>(r4, r5)     // Catch:{ IOException -> 0x0024 }
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0024 }
            java.lang.String r5 = "rw"
            r4.<init>(r1, r5)     // Catch:{ IOException -> 0x0024 }
            java.nio.channels.FileChannel r4 = r4.getChannel()     // Catch:{ IOException -> 0x0024 }
            java.nio.channels.FileLock r5 = r4.lock()     // Catch:{ IOException -> 0x0021 }
            com.google.firebase.installations.b r1 = new com.google.firebase.installations.b     // Catch:{ IOException -> 0x001f }
            r1.<init>(r4, r5)     // Catch:{ IOException -> 0x001f }
            return r1
        L_0x001f:
            r1 = move-exception
            goto L_0x0027
        L_0x0021:
            r1 = move-exception
            r5 = r0
            goto L_0x0027
        L_0x0024:
            r1 = move-exception
            r4 = r0
            r5 = r4
        L_0x0027:
            java.lang.String r2 = "CrossProcessLock"
            java.lang.String r3 = "encountered error while creating and acquiring the lock, ignoring"
            android.util.Log.e(r2, r3, r1)
            if (r5 == 0) goto L_0x0035
            r5.release()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0035
        L_0x0034:
        L_0x0035:
            if (r4 == 0) goto L_0x003a
            r4.close()     // Catch:{ IOException -> 0x003a }
        L_0x003a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.C3756b.m12664a(android.content.Context, java.lang.String):com.google.firebase.installations.b");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27397a() {
        try {
            this.f10416b.release();
            this.f10415a.close();
        } catch (IOException e) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e);
        }
    }
}
