package androidx.core.p013a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.p017c.C0772c;
import androidx.core.p016c.C0752b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: androidx.core.a.i */
/* compiled from: TypefaceCompatBaseImpl */
class C0690i {

    /* renamed from: a */
    private ConcurrentHashMap<Long, C0772c.C0774b> f1749a = new ConcurrentHashMap<>();

    /* renamed from: androidx.core.a.i$a */
    /* compiled from: TypefaceCompatBaseImpl */
    class C0691a implements C0693c<C0752b.C0758f> {
        C0691a(C0690i iVar) {
        }

        /* renamed from: a */
        public int mo3838a(C0752b.C0758f fVar) {
            return fVar.mo4002d();
        }

        /* renamed from: b */
        public boolean mo3840b(C0752b.C0758f fVar) {
            return fVar.mo4003e();
        }
    }

    /* renamed from: androidx.core.a.i$b */
    /* compiled from: TypefaceCompatBaseImpl */
    class C0692b implements C0693c<C0772c.C0775c> {
        C0692b(C0690i iVar) {
        }

        /* renamed from: a */
        public int mo3838a(C0772c.C0775c cVar) {
            return cVar.mo4035e();
        }

        /* renamed from: b */
        public boolean mo3840b(C0772c.C0775c cVar) {
            return cVar.mo4036f();
        }
    }

    /* renamed from: androidx.core.a.i$c */
    /* compiled from: TypefaceCompatBaseImpl */
    private interface C0693c<T> {
        /* renamed from: a */
        int mo3838a(T t);

        /* renamed from: b */
        boolean mo3840b(T t);
    }

    C0690i() {
    }

    /* renamed from: a */
    private static <T> T m2161a(T[] tArr, int i, C0693c<T> cVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(cVar.mo3838a(t2) - i2) * 2) + (cVar.mo3840b(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    /* renamed from: b */
    private static long m2163b(Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (NoSuchFieldException e) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e);
            return 0;
        } catch (IllegalAccessException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0752b.C0758f mo3835a(C0752b.C0758f[] fVarArr, int i) {
        return (C0752b.C0758f) m2161a(fVarArr, i, new C0691a(this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Typeface mo3834a(Context context, InputStream inputStream) {
        File a = C0694j.m2180a(context);
        if (a == null) {
            return null;
        }
        try {
            if (!C0694j.m2186a(a, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(a.getPath());
            a.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a.delete();
        }
    }

    /* renamed from: a */
    public Typeface mo3823a(Context context, CancellationSignal cancellationSignal, C0752b.C0758f[] fVarArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (fVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(mo3835a(fVarArr, i).mo4001c());
            try {
                Typeface a = mo3834a(context, inputStream);
                C0694j.m2184a((Closeable) inputStream);
                return a;
            } catch (IOException unused) {
                C0694j.m2184a((Closeable) inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                C0694j.m2184a((Closeable) inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            C0694j.m2184a((Closeable) inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            C0694j.m2184a((Closeable) inputStream2);
            throw th;
        }
    }

    /* renamed from: a */
    private C0772c.C0775c m2160a(C0772c.C0774b bVar, int i) {
        return (C0772c.C0775c) m2161a(bVar.mo4030a(), i, new C0692b(this));
    }

    /* renamed from: a */
    public Typeface mo3824a(Context context, C0772c.C0774b bVar, Resources resources, int i) {
        C0772c.C0775c a = m2160a(bVar, i);
        if (a == null) {
            return null;
        }
        Typeface a2 = C0684c.m2116a(context, resources, a.mo4032b(), a.mo4031a(), i);
        m2162a(a2, bVar);
        return a2;
    }

    /* renamed from: a */
    public Typeface mo3825a(Context context, Resources resources, int i, String str, int i2) {
        File a = C0694j.m2180a(context);
        if (a == null) {
            return null;
        }
        try {
            if (!C0694j.m2185a(a, resources, i)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(a.getPath());
            a.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a.delete();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0772c.C0774b mo3836a(Typeface typeface) {
        long b = m2163b(typeface);
        if (b == 0) {
            return null;
        }
        return this.f1749a.get(Long.valueOf(b));
    }

    /* renamed from: a */
    private void m2162a(Typeface typeface, C0772c.C0774b bVar) {
        long b = m2163b(typeface);
        if (b != 0) {
            this.f1749a.put(Long.valueOf(b), bVar);
        }
    }
}
