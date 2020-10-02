package com.onesignal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import com.tapjoy.TapjoyConstants;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.onesignal.o2 */
/* compiled from: TrackFirebaseAnalytics */
class C4608o2 {

    /* renamed from: c */
    private static Class<?> f12566c;

    /* renamed from: d */
    private static AtomicLong f12567d;

    /* renamed from: e */
    private static AtomicLong f12568e;

    /* renamed from: f */
    private static C4717x0 f12569f;

    /* renamed from: a */
    private Object f12570a;

    /* renamed from: b */
    private Context f12571b;

    C4608o2(Context context) {
        this.f12571b = context;
    }

    /* renamed from: b */
    static boolean m15929b() {
        try {
            f12566c = Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29892a() {
        if (f12567d != null && f12569f != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f12567d.get() <= 120000) {
                AtomicLong atomicLong = f12568e;
                if (atomicLong == null || currentTimeMillis - atomicLong.get() >= 30000) {
                    try {
                        Object a = m15925a(this.f12571b);
                        Method b = m15928b((Class) f12566c);
                        Bundle bundle = new Bundle();
                        bundle.putString(ShareConstants.FEED_SOURCE_PARAM, "OneSignal");
                        bundle.putString("medium", "notification");
                        bundle.putString(TapjoyConstants.TJC_NOTIFICATION_ID, f12569f.f12806a);
                        bundle.putString("campaign", m15926a(f12569f));
                        b.invoke(a, new Object[]{"os_notification_influence_open", bundle});
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29894b(C4697w0 w0Var) {
        try {
            Object a = m15925a(this.f12571b);
            Method b = m15928b((Class) f12566c);
            Bundle bundle = new Bundle();
            bundle.putString(ShareConstants.FEED_SOURCE_PARAM, "OneSignal");
            bundle.putString("medium", "notification");
            bundle.putString(TapjoyConstants.TJC_NOTIFICATION_ID, w0Var.f12759a.f12698a.f12806a);
            bundle.putString("campaign", m15926a(w0Var.f12759a.f12698a));
            b.invoke(a, new Object[]{"os_notification_received", bundle});
            if (f12567d == null) {
                f12567d = new AtomicLong();
            }
            f12567d.set(System.currentTimeMillis());
            f12569f = w0Var.f12759a.f12698a;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29893a(C4697w0 w0Var) {
        if (f12568e == null) {
            f12568e = new AtomicLong();
        }
        f12568e.set(System.currentTimeMillis());
        try {
            Object a = m15925a(this.f12571b);
            Method b = m15928b((Class) f12566c);
            Bundle bundle = new Bundle();
            bundle.putString(ShareConstants.FEED_SOURCE_PARAM, "OneSignal");
            bundle.putString("medium", "notification");
            bundle.putString(TapjoyConstants.TJC_NOTIFICATION_ID, w0Var.f12759a.f12698a.f12806a);
            bundle.putString("campaign", m15926a(w0Var.f12759a.f12698a));
            b.invoke(a, new Object[]{"os_notification_opened", bundle});
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private static Method m15928b(Class cls) {
        try {
            return cls.getMethod("logEvent", new Class[]{String.class, Bundle.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private String m15926a(C4717x0 x0Var) {
        if (x0Var.f12807b.isEmpty() || x0Var.f12808c.isEmpty()) {
            String str = x0Var.f12809d;
            return str != null ? str.substring(0, Math.min(10, str.length())) : "";
        }
        return x0Var.f12807b + " - " + x0Var.f12808c;
    }

    /* renamed from: a */
    private Object m15925a(Context context) {
        if (this.f12570a == null) {
            try {
                this.f12570a = m15927a((Class) f12566c).invoke((Object) null, new Object[]{context});
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return this.f12570a;
    }

    /* renamed from: a */
    private static Method m15927a(Class cls) {
        try {
            return cls.getMethod("getInstance", new Class[]{Context.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }
}
