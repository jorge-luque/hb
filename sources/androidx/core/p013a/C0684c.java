package androidx.core.p013a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.p017c.C0772c;
import androidx.core.content.p017c.C0780f;
import androidx.core.p016c.C0752b;
import p075d.p080b.C3197e;

@SuppressLint({"NewApi"})
/* renamed from: androidx.core.a.c */
/* compiled from: TypefaceCompat */
public class C0684c {

    /* renamed from: a */
    private static final C0690i f1731a;

    /* renamed from: b */
    private static final C3197e<String, Typeface> f1732b = new C3197e<>(16);

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            f1731a = new C0689h();
        } else if (i >= 28) {
            f1731a = new C0688g();
        } else if (i >= 26) {
            f1731a = new C0687f();
        } else if (i >= 24 && C0686e.m2131a()) {
            f1731a = new C0686e();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f1731a = new C0685d();
        } else {
            f1731a = new C0690i();
        }
    }

    /* renamed from: a */
    private static String m2120a(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    /* renamed from: b */
    public static Typeface m2122b(Resources resources, int i, int i2) {
        return f1732b.get(m2120a(resources, i, i2));
    }

    /* renamed from: a */
    public static Typeface m2119a(Context context, C0772c.C0773a aVar, Resources resources, int i, int i2, C0780f.C0781a aVar2, Handler handler, boolean z) {
        Typeface typeface;
        if (aVar instanceof C0772c.C0776d) {
            C0772c.C0776d dVar = (C0772c.C0776d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.mo4037a() == 0) {
                z2 = true;
            }
            typeface = C0752b.m2364a(context, dVar.mo4038b(), aVar2, handler, z2, z ? dVar.mo4039c() : -1, i2);
        } else {
            typeface = f1731a.mo3824a(context, (C0772c.C0774b) aVar, resources, i2);
            if (aVar2 != null) {
                if (typeface != null) {
                    aVar2.mo4041a(typeface, handler);
                } else {
                    aVar2.mo4040a(-3, handler);
                }
            }
        }
        if (typeface != null) {
            f1732b.put(m2120a(resources, i, i2), typeface);
        }
        return typeface;
    }

    /* renamed from: b */
    private static Typeface m2121b(Context context, Typeface typeface, int i) {
        C0772c.C0774b a = f1731a.mo3836a(typeface);
        if (a == null) {
            return null;
        }
        return f1731a.mo3824a(context, a, context.getResources(), i);
    }

    /* renamed from: a */
    public static Typeface m2116a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a = f1731a.mo3825a(context, resources, i, str, i2);
        if (a != null) {
            f1732b.put(m2120a(resources, i, i2), a);
        }
        return a;
    }

    /* renamed from: a */
    public static Typeface m2118a(Context context, CancellationSignal cancellationSignal, C0752b.C0758f[] fVarArr, int i) {
        return f1731a.mo3823a(context, cancellationSignal, fVarArr, i);
    }

    /* renamed from: a */
    public static Typeface m2117a(Context context, Typeface typeface, int i) {
        Typeface b;
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        } else if (Build.VERSION.SDK_INT >= 21 || (b = m2121b(context, typeface, i)) == null) {
            return Typeface.create(typeface, i);
        } else {
            return b;
        }
    }
}
