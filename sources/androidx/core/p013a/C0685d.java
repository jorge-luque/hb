package androidx.core.p013a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.p017c.C0772c;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.core.a.d */
/* compiled from: TypefaceCompatApi21Impl */
class C0685d extends C0690i {

    /* renamed from: b */
    private static Class<?> f1733b = null;

    /* renamed from: c */
    private static Constructor<?> f1734c = null;

    /* renamed from: d */
    private static Method f1735d = null;

    /* renamed from: e */
    private static Method f1736e = null;

    /* renamed from: f */
    private static boolean f1737f = false;

    C0685d() {
    }

    /* renamed from: a */
    private static void mo3827a() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!f1737f) {
            f1737f = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", new Class[]{String.class, Integer.TYPE, Boolean.TYPE});
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                Log.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
                method2 = null;
                cls = null;
                method = null;
            }
            f1734c = constructor;
            f1733b = cls;
            f1735d = method;
            f1736e = method2;
        }
    }

    /* renamed from: b */
    private static Object m2127b() {
        mo3827a();
        try {
            return f1734c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private File m2124a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    /* renamed from: a */
    private static Typeface mo3826a(Object obj) {
        mo3827a();
        try {
            Object newInstance = Array.newInstance(f1733b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f1736e.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static boolean m2126a(Object obj, String str, int i, boolean z) {
        mo3827a();
        try {
            return ((Boolean) f1735d.invoke(obj, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        throw r4;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0053 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x005c */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface mo3823a(android.content.Context r4, android.os.CancellationSignal r5, androidx.core.p016c.C0752b.C0758f[] r6, int r7) {
        /*
            r3 = this;
            int r0 = r6.length
            r1 = 0
            r2 = 1
            if (r0 >= r2) goto L_0x0006
            return r1
        L_0x0006:
            androidx.core.c.b$f r6 = r3.mo3835a((androidx.core.p016c.C0752b.C0758f[]) r6, (int) r7)
            android.content.ContentResolver r7 = r4.getContentResolver()
            android.net.Uri r6 = r6.mo4001c()     // Catch:{ IOException -> 0x005d }
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r5 = r7.openFileDescriptor(r6, r0, r5)     // Catch:{ IOException -> 0x005d }
            if (r5 != 0) goto L_0x0020
            if (r5 == 0) goto L_0x001f
            r5.close()     // Catch:{ IOException -> 0x005d }
        L_0x001f:
            return r1
        L_0x0020:
            java.io.File r6 = r3.m2124a((android.os.ParcelFileDescriptor) r5)     // Catch:{ all -> 0x0054 }
            if (r6 == 0) goto L_0x0037
            boolean r7 = r6.canRead()     // Catch:{ all -> 0x0054 }
            if (r7 != 0) goto L_0x002d
            goto L_0x0037
        L_0x002d:
            android.graphics.Typeface r4 = android.graphics.Typeface.createFromFile(r6)     // Catch:{ all -> 0x0054 }
            if (r5 == 0) goto L_0x0036
            r5.close()     // Catch:{ IOException -> 0x005d }
        L_0x0036:
            return r4
        L_0x0037:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ all -> 0x0054 }
            java.io.FileDescriptor r7 = r5.getFileDescriptor()     // Catch:{ all -> 0x0054 }
            r6.<init>(r7)     // Catch:{ all -> 0x0054 }
            android.graphics.Typeface r4 = super.mo3834a((android.content.Context) r4, (java.io.InputStream) r6)     // Catch:{ all -> 0x004d }
            r6.close()     // Catch:{ all -> 0x0054 }
            if (r5 == 0) goto L_0x004c
            r5.close()     // Catch:{ IOException -> 0x005d }
        L_0x004c:
            return r4
        L_0x004d:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x004f }
        L_0x004f:
            r4 = move-exception
            r6.close()     // Catch:{ all -> 0x0053 }
        L_0x0053:
            throw r4     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r4 = move-exception
            if (r5 == 0) goto L_0x005c
            r5.close()     // Catch:{ all -> 0x005c }
        L_0x005c:
            throw r4     // Catch:{ IOException -> 0x005d }
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.p013a.C0685d.mo3823a(android.content.Context, android.os.CancellationSignal, androidx.core.c.b$f[], int):android.graphics.Typeface");
    }

    /* renamed from: a */
    public Typeface mo3824a(Context context, C0772c.C0774b bVar, Resources resources, int i) {
        Object b = m2127b();
        C0772c.C0775c[] a = bVar.mo4030a();
        int length = a.length;
        int i2 = 0;
        while (i2 < length) {
            C0772c.C0775c cVar = a[i2];
            File a2 = C0694j.m2180a(context);
            if (a2 == null) {
                return null;
            }
            try {
                if (!C0694j.m2185a(a2, resources, cVar.mo4032b())) {
                    a2.delete();
                    return null;
                } else if (!m2126a(b, a2.getPath(), cVar.mo4035e(), cVar.mo4036f())) {
                    return null;
                } else {
                    a2.delete();
                    i2++;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                a2.delete();
            }
        }
        return mo3826a(b);
    }
}
