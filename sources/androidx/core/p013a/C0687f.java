package androidx.core.p013a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.util.Log;
import androidx.core.content.p017c.C0772c;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* renamed from: androidx.core.a.f */
/* compiled from: TypefaceCompatApi26Impl */
public class C0687f extends C0685d {

    /* renamed from: g */
    protected final Class<?> f1742g;

    /* renamed from: h */
    protected final Constructor<?> f1743h;

    /* renamed from: i */
    protected final Method f1744i;

    /* renamed from: j */
    protected final Method f1745j;

    /* renamed from: k */
    protected final Method f1746k;

    /* renamed from: l */
    protected final Method f1747l;

    /* renamed from: m */
    protected final Method f1748m;

    public C0687f() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Constructor<?> constructor;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> a = mo3827a();
            constructor = mo3832e(a);
            method4 = mo3829b(a);
            method3 = mo3830c(a);
            method2 = mo3833f(a);
            method = mo3828a(a);
            Class<?> cls2 = a;
            method5 = mo3831d(a);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            method5 = null;
            constructor = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f1742g = cls;
        this.f1743h = constructor;
        this.f1744i = method4;
        this.f1745j = method3;
        this.f1746k = method2;
        this.f1747l = method;
        this.f1748m = method5;
    }

    /* renamed from: a */
    private boolean m2136a(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f1744i.invoke(obj, new Object[]{context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: b */
    private boolean m2139b() {
        if (this.f1744i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f1744i != null;
    }

    /* renamed from: c */
    private Object m2140c() {
        try {
            return this.f1743h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Method mo3831d(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), cls2, cls2});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Constructor<?> mo3832e(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Method mo3833f(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    /* renamed from: c */
    private boolean m2141c(Object obj) {
        try {
            return ((Boolean) this.f1746k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Method mo3830c(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2});
    }

    /* renamed from: b */
    private void m2138b(Object obj) {
        try {
            this.f1747l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    /* renamed from: a */
    private boolean m2137a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.f1745j.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Method mo3829b(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class});
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Typeface mo3826a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f1742g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f1748m.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public Typeface mo3824a(Context context, C0772c.C0774b bVar, Resources resources, int i) {
        if (!m2139b()) {
            return super.mo3824a(context, bVar, resources, i);
        }
        Object c = m2140c();
        if (c == null) {
            return null;
        }
        for (C0772c.C0775c cVar : bVar.mo4030a()) {
            if (!m2136a(context, c, cVar.mo4031a(), cVar.mo4033c(), cVar.mo4035e(), cVar.mo4036f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.mo4034d()))) {
                m2138b(c);
                return null;
            }
        }
        if (!m2141c(c)) {
            return null;
        }
        return mo3826a(c);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
        if (r11 != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0051 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface mo3823a(android.content.Context r11, android.os.CancellationSignal r12, androidx.core.p016c.C0752b.C0758f[] r13, int r14) {
        /*
            r10 = this;
            int r0 = r13.length
            r1 = 1
            r2 = 0
            if (r0 >= r1) goto L_0x0006
            return r2
        L_0x0006:
            boolean r0 = r10.m2139b()
            if (r0 != 0) goto L_0x0053
            androidx.core.c.b$f r13 = r10.mo3835a((androidx.core.p016c.C0752b.C0758f[]) r13, (int) r14)
            android.content.ContentResolver r11 = r11.getContentResolver()
            android.net.Uri r14 = r13.mo4001c()     // Catch:{ IOException -> 0x0052 }
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r11 = r11.openFileDescriptor(r14, r0, r12)     // Catch:{ IOException -> 0x0052 }
            if (r11 != 0) goto L_0x0026
            if (r11 == 0) goto L_0x0025
            r11.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0025:
            return r2
        L_0x0026:
            android.graphics.Typeface$Builder r12 = new android.graphics.Typeface$Builder     // Catch:{ all -> 0x0049 }
            java.io.FileDescriptor r14 = r11.getFileDescriptor()     // Catch:{ all -> 0x0049 }
            r12.<init>(r14)     // Catch:{ all -> 0x0049 }
            int r14 = r13.mo4002d()     // Catch:{ all -> 0x0049 }
            android.graphics.Typeface$Builder r12 = r12.setWeight(r14)     // Catch:{ all -> 0x0049 }
            boolean r13 = r13.mo4003e()     // Catch:{ all -> 0x0049 }
            android.graphics.Typeface$Builder r12 = r12.setItalic(r13)     // Catch:{ all -> 0x0049 }
            android.graphics.Typeface r12 = r12.build()     // Catch:{ all -> 0x0049 }
            if (r11 == 0) goto L_0x0048
            r11.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0048:
            return r12
        L_0x0049:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x004b }
        L_0x004b:
            r12 = move-exception
            if (r11 == 0) goto L_0x0051
            r11.close()     // Catch:{ all -> 0x0051 }
        L_0x0051:
            throw r12     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            return r2
        L_0x0053:
            java.util.Map r11 = androidx.core.p016c.C0752b.m2369a((android.content.Context) r11, (androidx.core.p016c.C0752b.C0758f[]) r13, (android.os.CancellationSignal) r12)
            java.lang.Object r12 = r10.m2140c()
            if (r12 != 0) goto L_0x005e
            return r2
        L_0x005e:
            int r0 = r13.length
            r3 = 0
            r9 = 0
        L_0x0061:
            if (r9 >= r0) goto L_0x008e
            r4 = r13[r9]
            android.net.Uri r5 = r4.mo4001c()
            java.lang.Object r5 = r11.get(r5)
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            if (r5 != 0) goto L_0x0072
            goto L_0x008b
        L_0x0072:
            int r6 = r4.mo4000b()
            int r7 = r4.mo4002d()
            boolean r8 = r4.mo4003e()
            r3 = r10
            r4 = r12
            boolean r3 = r3.m2137a((java.lang.Object) r4, (java.nio.ByteBuffer) r5, (int) r6, (int) r7, (int) r8)
            if (r3 != 0) goto L_0x008a
            r10.m2138b((java.lang.Object) r12)
            return r2
        L_0x008a:
            r3 = 1
        L_0x008b:
            int r9 = r9 + 1
            goto L_0x0061
        L_0x008e:
            if (r3 != 0) goto L_0x0094
            r10.m2138b((java.lang.Object) r12)
            return r2
        L_0x0094:
            boolean r11 = r10.m2141c((java.lang.Object) r12)
            if (r11 != 0) goto L_0x009b
            return r2
        L_0x009b:
            android.graphics.Typeface r11 = r10.mo3826a((java.lang.Object) r12)
            if (r11 != 0) goto L_0x00a2
            return r2
        L_0x00a2:
            android.graphics.Typeface r11 = android.graphics.Typeface.create(r11, r14)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.p013a.C0687f.mo3823a(android.content.Context, android.os.CancellationSignal, androidx.core.c.b$f[], int):android.graphics.Typeface");
    }

    /* renamed from: a */
    public Typeface mo3825a(Context context, Resources resources, int i, String str, int i2) {
        if (!m2139b()) {
            return super.mo3825a(context, resources, i, str, i2);
        }
        Object c = m2140c();
        if (c == null) {
            return null;
        }
        if (!m2136a(context, c, str, 0, -1, -1, (FontVariationAxis[]) null)) {
            m2138b(c);
            return null;
        } else if (!m2141c(c)) {
            return null;
        } else {
            return mo3826a(c);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Class<?> mo3827a() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Method mo3828a(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }
}
