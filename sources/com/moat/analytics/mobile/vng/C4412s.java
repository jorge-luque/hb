package com.moat.analytics.mobile.vng;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.facebook.places.model.PlaceFields;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.vng.s */
class C4412s {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f11837a;

    /* renamed from: b */
    private static C4414a f11838b;

    /* renamed from: c */
    private static C4415b f11839c;

    /* renamed from: com.moat.analytics.mobile.vng.s$a */
    static class C4414a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public boolean f11841a;

        /* renamed from: b */
        private String f11842b;

        /* renamed from: c */
        private String f11843c;

        /* renamed from: d */
        private String f11844d;

        private C4414a() {
            this.f11841a = false;
            this.f11842b = "_unknown_";
            this.f11843c = "_unknown_";
            this.f11844d = "_unknown_";
            try {
                Context b = C4412s.m14783b();
                if (b != null) {
                    this.f11841a = true;
                    PackageManager packageManager = b.getPackageManager();
                    this.f11843c = b.getPackageName();
                    this.f11842b = packageManager.getApplicationLabel(b.getApplicationInfo()).toString();
                    this.f11844d = packageManager.getInstallerPackageName(this.f11843c);
                    return;
                }
                C4409p.m14772a(3, "Util", (Object) this, "Can't get app name, appContext is null.");
            } catch (Exception e) {
                C4403n.m14758a(e);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo29337a() {
            return this.f11842b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public String mo29338b() {
            return this.f11843c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public String mo29339c() {
            String str = this.f11844d;
            return str != null ? str : "_unknown_";
        }
    }

    /* renamed from: com.moat.analytics.mobile.vng.s$b */
    static class C4415b {

        /* renamed from: a */
        String f11845a;

        /* renamed from: b */
        String f11846b;

        /* renamed from: c */
        Integer f11847c;

        /* renamed from: d */
        boolean f11848d;

        /* renamed from: e */
        boolean f11849e;

        /* renamed from: f */
        boolean f11850f;

        private C4415b() {
            this.f11845a = "_unknown_";
            this.f11846b = "_unknown_";
            this.f11847c = -1;
            this.f11848d = false;
            this.f11849e = false;
            this.f11850f = false;
            try {
                Context b = C4412s.m14783b();
                if (b != null) {
                    this.f11850f = true;
                    TelephonyManager telephonyManager = (TelephonyManager) b.getSystemService(PlaceFields.PHONE);
                    this.f11845a = telephonyManager.getSimOperatorName();
                    this.f11846b = telephonyManager.getNetworkOperatorName();
                    this.f11847c = Integer.valueOf(telephonyManager.getPhoneType());
                    this.f11848d = C4412s.m14789g();
                    this.f11849e = C4412s.m14784b(b);
                }
            } catch (Exception e) {
                C4403n.m14758a(e);
            }
        }
    }

    C4412s() {
    }

    /* renamed from: a */
    static String m14780a() {
        return f11837a;
    }

    /* renamed from: a */
    static void m14782a(final Context context) {
        try {
            AsyncTask.execute(new Runnable() {
                public void run() {
                    String str;
                    String str2;
                    try {
                        Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                        Class<?> cls2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
                        Object invoke = cls.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
                        if (!((Boolean) cls2.getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, new Object[0])).booleanValue()) {
                            String unused = C4412s.f11837a = (String) cls2.getMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
                            str2 = "Retrieved Advertising ID = " + C4412s.f11837a;
                        } else {
                            str2 = "User has limited ad tracking";
                        }
                        C4409p.m14772a(3, "Util", (Object) this, str2);
                    } catch (ClassNotFoundException e) {
                        e = e;
                        str = "ClassNotFoundException while retrieving Advertising ID";
                        C4409p.m14774a("Util", (Object) this, str, e);
                    } catch (NoSuchMethodException e2) {
                        e = e2;
                        str = "NoSuchMethodException while retrieving Advertising ID";
                        C4409p.m14774a("Util", (Object) this, str, e);
                    } catch (Exception e3) {
                        C4403n.m14758a(e3);
                    }
                }
            });
        } catch (Exception e) {
            C4403n.m14758a(e);
        }
    }

    /* renamed from: b */
    static Context m14783b() {
        WeakReference<Context> weakReference = ((C4400k) MoatAnalytics.getInstance()).f11810d;
        if (weakReference != null) {
            return (Context) weakReference.get();
        }
        return null;
    }

    /* renamed from: b */
    static boolean m14784b(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: c */
    static C4414a m14785c() {
        C4414a aVar = f11838b;
        if (aVar == null || !aVar.f11841a) {
            f11838b = new C4414a();
        }
        return f11838b;
    }

    /* renamed from: d */
    static C4415b m14786d() {
        C4415b bVar = f11839c;
        if (bVar == null || !bVar.f11850f) {
            f11839c = new C4415b();
        }
        return f11839c;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static boolean m14789g() {
        int i;
        Context b = m14783b();
        if (b != null) {
            int i2 = Build.VERSION.SDK_INT;
            ContentResolver contentResolver = b.getContentResolver();
            i = i2 >= 17 ? Settings.Global.getInt(contentResolver, "adb_enabled", 0) : Settings.Secure.getInt(contentResolver, "adb_enabled", 0);
        } else {
            i = 0;
        }
        return i == 1;
    }
}
