package com.tapjoy.internal;

import android.app.Activity;
import android.app.Application;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.b */
public final class C3123b {

    /* renamed from: a */
    private static Application f8709a;

    /* renamed from: b */
    private static int f8710b;

    /* renamed from: c */
    private static final C4930by f8711c = new C4930by();

    /* renamed from: d */
    private static final Set f8712d = Collections.synchronizedSet(new C4902ay());

    /* renamed from: e */
    private static final C4930by f8713e = new C4930by();

    /* renamed from: a */
    public static void m10218a(Activity activity) {
        f8711c.mo31019a(activity);
    }

    /* renamed from: b */
    public static boolean m10221b() {
        return f8710b > 0;
    }

    @Nullable
    /* renamed from: c */
    public static Activity m10222c() {
        Activity activity;
        Activity activity2 = (Activity) f8711c.mo31018a();
        if (activity2 != null) {
            return activity2;
        }
        synchronized (f8712d) {
            activity = (Activity) C5243jt.m17609a(f8712d.iterator());
        }
        return activity;
    }

    /* renamed from: a */
    public static synchronized void m10219a(Application application) {
        synchronized (C3123b.class) {
            if (f8709a != application) {
                f8709a = application;
            }
        }
    }

    /* renamed from: b */
    public static void m10220b(Activity activity) {
        f8710b++;
        f8711c.mo31019a(activity);
        f8712d.add(activity);
    }

    @Nullable
    /* renamed from: a */
    public static Activity m10217a() {
        Activity activity = (Activity) f8713e.mo31018a();
        return activity == null ? m10222c() : activity;
    }

    /* renamed from: c */
    public static void m10223c(Activity activity) {
        f8710b--;
        f8711c.f13425a = null;
        f8712d.remove(activity);
        if (f8710b < 0) {
            f8710b = 0;
        }
    }
}
