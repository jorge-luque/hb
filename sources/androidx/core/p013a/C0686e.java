package androidx.core.p013a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.p017c.C0772c;
import androidx.core.p016c.C0752b;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import p075d.p080b.C3204g;

/* renamed from: androidx.core.a.e */
/* compiled from: TypefaceCompatApi24Impl */
class C0686e extends C0690i {

    /* renamed from: b */
    private static final Class<?> f1738b;

    /* renamed from: c */
    private static final Constructor<?> f1739c;

    /* renamed from: d */
    private static final Method f1740d;

    /* renamed from: e */
    private static final Method f1741e;

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE});
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method2 = null;
            method = null;
        }
        f1739c = constructor;
        f1738b = cls;
        f1740d = method;
        f1741e = method2;
    }

    C0686e() {
    }

    /* renamed from: a */
    public static boolean m2131a() {
        if (f1740d == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f1740d != null;
    }

    /* renamed from: b */
    private static Object m2133b() {
        try {
            return f1739c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m2132a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f1740d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static Typeface m2130a(Object obj) {
        try {
            Object newInstance = Array.newInstance(f1738b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f1741e.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public Typeface mo3823a(Context context, CancellationSignal cancellationSignal, C0752b.C0758f[] fVarArr, int i) {
        Object b = m2133b();
        if (b == null) {
            return null;
        }
        C3204g gVar = new C3204g();
        for (C0752b.C0758f fVar : fVarArr) {
            Uri c = fVar.mo4001c();
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(c);
            if (byteBuffer == null) {
                byteBuffer = C0694j.m2182a(context, cancellationSignal, c);
                gVar.put(c, byteBuffer);
            }
            if (byteBuffer == null || !m2132a(b, byteBuffer, fVar.mo4000b(), fVar.mo4002d(), fVar.mo4003e())) {
                return null;
            }
        }
        Typeface a = m2130a(b);
        if (a == null) {
            return null;
        }
        return Typeface.create(a, i);
    }

    /* renamed from: a */
    public Typeface mo3824a(Context context, C0772c.C0774b bVar, Resources resources, int i) {
        Object b = m2133b();
        if (b == null) {
            return null;
        }
        for (C0772c.C0775c cVar : bVar.mo4030a()) {
            ByteBuffer a = C0694j.m2181a(context, resources, cVar.mo4032b());
            if (a == null || !m2132a(b, a, cVar.mo4033c(), cVar.mo4035e(), cVar.mo4036f())) {
                return null;
            }
        }
        return m2130a(b);
    }
}
