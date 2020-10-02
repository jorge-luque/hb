package androidx.core.p013a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* renamed from: androidx.core.a.j */
/* compiled from: TypefaceCompatUtil */
public class C0694j {
    /* renamed from: a */
    public static File m2180a(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        int i = 0;
        while (i < 100) {
            File file = new File(cacheDir, str + i);
            try {
                if (file.createNewFile()) {
                    return file;
                }
                i++;
            } catch (IOException unused) {
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001f */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.nio.ByteBuffer m2183a(java.io.File r7) {
        /*
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0020 }
            r0.<init>(r7)     // Catch:{ IOException -> 0x0020 }
            java.nio.channels.FileChannel r1 = r0.getChannel()     // Catch:{ all -> 0x0019 }
            long r5 = r1.size()     // Catch:{ all -> 0x0019 }
            java.nio.channels.FileChannel$MapMode r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ all -> 0x0019 }
            r3 = 0
            java.nio.MappedByteBuffer r7 = r1.map(r2, r3, r5)     // Catch:{ all -> 0x0019 }
            r0.close()     // Catch:{ IOException -> 0x0020 }
            return r7
        L_0x0019:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x001b }
        L_0x001b:
            r7 = move-exception
            r0.close()     // Catch:{ all -> 0x001f }
        L_0x001f:
            throw r7     // Catch:{ IOException -> 0x0020 }
        L_0x0020:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.p013a.C0694j.m2183a(java.io.File):java.nio.ByteBuffer");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:20|21|22|23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        throw r9;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x003b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0044 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.nio.ByteBuffer m2182a(android.content.Context r7, android.os.CancellationSignal r8, android.net.Uri r9) {
        /*
            android.content.ContentResolver r7 = r7.getContentResolver()
            r0 = 0
            java.lang.String r1 = "r"
            android.os.ParcelFileDescriptor r7 = r7.openFileDescriptor(r9, r1, r8)     // Catch:{ IOException -> 0x0045 }
            if (r7 != 0) goto L_0x0013
            if (r7 == 0) goto L_0x0012
            r7.close()     // Catch:{ IOException -> 0x0045 }
        L_0x0012:
            return r0
        L_0x0013:
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ all -> 0x003c }
            java.io.FileDescriptor r9 = r7.getFileDescriptor()     // Catch:{ all -> 0x003c }
            r8.<init>(r9)     // Catch:{ all -> 0x003c }
            java.nio.channels.FileChannel r1 = r8.getChannel()     // Catch:{ all -> 0x0035 }
            long r5 = r1.size()     // Catch:{ all -> 0x0035 }
            java.nio.channels.FileChannel$MapMode r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ all -> 0x0035 }
            r3 = 0
            java.nio.MappedByteBuffer r9 = r1.map(r2, r3, r5)     // Catch:{ all -> 0x0035 }
            r8.close()     // Catch:{ all -> 0x003c }
            if (r7 == 0) goto L_0x0034
            r7.close()     // Catch:{ IOException -> 0x0045 }
        L_0x0034:
            return r9
        L_0x0035:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0037 }
        L_0x0037:
            r9 = move-exception
            r8.close()     // Catch:{ all -> 0x003b }
        L_0x003b:
            throw r9     // Catch:{ all -> 0x003c }
        L_0x003c:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x003e }
        L_0x003e:
            r8 = move-exception
            if (r7 == 0) goto L_0x0044
            r7.close()     // Catch:{ all -> 0x0044 }
        L_0x0044:
            throw r8     // Catch:{ IOException -> 0x0045 }
        L_0x0045:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.p013a.C0694j.m2182a(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    /* renamed from: a */
    public static ByteBuffer m2181a(Context context, Resources resources, int i) {
        File a = m2180a(context);
        if (a == null) {
            return null;
        }
        try {
            if (!m2185a(a, resources, i)) {
                return null;
            }
            ByteBuffer a2 = m2183a(a);
            a.delete();
            return a2;
        } finally {
            a.delete();
        }
    }

    /* renamed from: a */
    public static boolean m2186a(File file, InputStream inputStream) {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
            try {
                byte[] bArr = new byte[OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        m2184a((Closeable) fileOutputStream2);
                        StrictMode.setThreadPolicy(allowThreadDiskWrites);
                        return true;
                    }
                }
            } catch (IOException e) {
                e = e;
                fileOutputStream = fileOutputStream2;
                try {
                    Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
                    m2184a((Closeable) fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    m2184a((Closeable) fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                m2184a((Closeable) fileOutputStream);
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            m2184a((Closeable) fileOutputStream);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m2185a(File file, Resources resources, int i) {
        InputStream inputStream;
        try {
            inputStream = resources.openRawResource(i);
            try {
                boolean a = m2186a(file, inputStream);
                m2184a((Closeable) inputStream);
                return a;
            } catch (Throwable th) {
                th = th;
                m2184a((Closeable) inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            m2184a((Closeable) inputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static void m2184a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
