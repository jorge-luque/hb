package androidx.appcompat.p006a.p007a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.C0633w;
import androidx.core.content.C0768a;
import androidx.core.content.p017c.C0770a;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.a.a.a */
/* compiled from: AppCompatResources */
public final class C0383a {

    /* renamed from: a */
    private static final ThreadLocal<TypedValue> f280a = new ThreadLocal<>();

    /* renamed from: b */
    private static final WeakHashMap<Context, SparseArray<C0384a>> f281b = new WeakHashMap<>(0);

    /* renamed from: c */
    private static final Object f282c = new Object();

    /* renamed from: androidx.appcompat.a.a.a$a */
    /* compiled from: AppCompatResources */
    private static class C0384a {

        /* renamed from: a */
        final ColorStateList f283a;

        /* renamed from: b */
        final Configuration f284b;

        C0384a(ColorStateList colorStateList, Configuration configuration) {
            this.f283a = colorStateList;
            this.f284b = configuration;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList m319a(android.content.Context r4, int r5) {
        /*
            java.lang.Object r0 = f282c
            monitor-enter(r0)
            java.util.WeakHashMap<android.content.Context, android.util.SparseArray<androidx.appcompat.a.a.a$a>> r1 = f281b     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0035 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0032
            int r2 = r1.size()     // Catch:{ all -> 0x0035 }
            if (r2 <= 0) goto L_0x0032
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0035 }
            androidx.appcompat.a.a.a$a r2 = (androidx.appcompat.p006a.p007a.C0383a.C0384a) r2     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0032
            android.content.res.Configuration r3 = r2.f284b     // Catch:{ all -> 0x0035 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0035 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0035 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x002f
            android.content.res.ColorStateList r4 = r2.f283a     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return r4
        L_0x002f:
            r1.remove(r5)     // Catch:{ all -> 0x0035 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            r4 = 0
            return r4
        L_0x0035:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.p006a.p007a.C0383a.m319a(android.content.Context, int):android.content.res.ColorStateList");
    }

    /* renamed from: b */
    public static ColorStateList m322b(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList a = m319a(context, i);
        if (a != null) {
            return a;
        }
        ColorStateList d = m324d(context, i);
        if (d == null) {
            return C0768a.m2408b(context, i);
        }
        m321a(context, i, d);
        return d;
    }

    /* renamed from: c */
    public static Drawable m323c(Context context, int i) {
        return C0633w.m1854a().mo3580a(context, i);
    }

    /* renamed from: d */
    private static ColorStateList m324d(Context context, int i) {
        if (m325e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return C0770a.m2419a(resources, (XmlPullParser) resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    /* renamed from: e */
    private static boolean m325e(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue a = m320a();
        resources.getValue(i, a, true);
        int i2 = a.type;
        if (i2 < 28 || i2 > 31) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static void m321a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f282c) {
            SparseArray sparseArray = f281b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                f281b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0384a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    /* renamed from: a */
    private static TypedValue m320a() {
        TypedValue typedValue = f280a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f280a.set(typedValue2);
        return typedValue2;
    }
}
