package com.onesignal;

import admost.sdk.base.AdMost;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import androidx.core.app.C0713f;
import androidx.core.app.C0736l;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.ogury.p159cm.OguryChoiceManager;
import com.onesignal.C4564n1;
import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p075d.p088f.p089a.C3217a;

/* renamed from: com.onesignal.k1 */
/* compiled from: OSUtils */
class C4536k1 {

    /* renamed from: a */
    public static int f12402a = 3;

    /* renamed from: b */
    static final int[] f12403b = {AdMost.AD_ERROR_WATERFALL_EMPTY, AdMost.AD_ERROR_INCOMPATIBLE_APP_ZONE_ID, AdMost.AD_ERROR_NOT_CACHABLE, 404, 410};

    /* renamed from: com.onesignal.k1$a */
    /* compiled from: OSUtils */
    static /* synthetic */ class C4537a {

        /* renamed from: a */
        static final /* synthetic */ int[] f12404a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.onesignal.k1$b[] r0 = com.onesignal.C4536k1.C4538b.m15649a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12404a = r0
                com.onesignal.k1$b r1 = com.onesignal.C4536k1.C4538b.DATA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12404a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.onesignal.k1$b r1 = com.onesignal.C4536k1.C4538b.HTTPS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12404a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.onesignal.k1$b r1 = com.onesignal.C4536k1.C4538b.HTTP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4536k1.C4537a.<clinit>():void");
        }
    }

    /* renamed from: com.onesignal.k1$b */
    /* compiled from: OSUtils */
    public enum C4538b {
        DATA("data"),
        HTTPS("https"),
        HTTP("http");
        

        /* renamed from: a */
        private final String f12409a;

        private C4538b(String str) {
            this.f12409a = str;
        }

        /* renamed from: a */
        public static C4538b[] m15649a() {
            return (C4538b[]) f12408e.clone();
        }

        /* renamed from: a */
        public static C4538b m15648a(String str) {
            for (C4538b bVar : m15649a()) {
                if (bVar.f12409a.equalsIgnoreCase(str)) {
                    return bVar;
                }
            }
            return null;
        }
    }

    C4536k1() {
    }

    /* renamed from: a */
    public static boolean m15624a(int i) {
        for (int i2 : f12403b) {
            if (i == i2) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private Integer m15629b(Context context) {
        boolean j = m15641j();
        boolean i = m15640i();
        if (!j && !i) {
            C4564n1.m15789a(C4564n1.C4566a0.FATAL, "Could not find the Android Support Library. Please make sure it has been correctly added to your project.");
            return -3;
        } else if (!j || !i) {
            C4564n1.m15789a(C4564n1.C4566a0.FATAL, "The included Android Support Library is to old or incomplete. Please update to the 26.0.0 revision or newer.");
            return -5;
        } else if (Build.VERSION.SDK_INT < 26 || m15633c(context) < 26 || m15639h()) {
            return null;
        } else {
            C4564n1.m15789a(C4564n1.C4566a0.FATAL, "The included Android Support Library is to old or incomplete. Please update to the 26.0.0 revision or newer.");
            return -5;
        }
    }

    /* renamed from: e */
    static String m15636e() {
        String language = Locale.getDefault().getLanguage();
        if (language.equals("iw")) {
            return "he";
        }
        if (language.equals("in")) {
            return "id";
        }
        if (language.equals("ji")) {
            return "yi";
        }
        if (!language.equals("zh")) {
            return language;
        }
        return language + "-" + Locale.getDefault().getCountry();
    }

    /* renamed from: f */
    static boolean m15637f() {
        return true;
    }

    /* renamed from: g */
    private static boolean m15638g() {
        Class<GoogleCloudMessaging> cls = GoogleCloudMessaging.class;
        return true;
    }

    /* renamed from: h */
    private static boolean m15639h() {
        Class<C0713f> cls = C0713f.class;
        return true;
    }

    /* renamed from: i */
    private static boolean m15640i() {
        return true;
    }

    /* renamed from: j */
    private static boolean m15641j() {
        Class<C3217a> cls = C3217a.class;
        return true;
    }

    /* renamed from: k */
    static <T> Set<T> m15642k() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo29827c() {
        try {
            Class.forName("com.amazon.device.messaging.ADM");
            return 2;
        } catch (ClassNotFoundException unused) {
            return 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Integer mo29828d() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) C4564n1.f12495e.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1 || type == 9) {
            return 0;
        }
        return 1;
    }

    /* renamed from: c */
    static int m15633c(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 15;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo29824a(Context context, String str) {
        Integer a;
        int c = mo29827c();
        try {
            UUID.fromString(str);
            if ("b2f7f966-d8cc-11e4-bed1-df8f05be55ba".equals(str) || "5eb5a37e-b458-11e3-ac11-000c2940e62c".equals(str)) {
                C4564n1.m15789a(C4564n1.C4566a0.ERROR, "OneSignal Example AppID detected, please update to your app's id found on OneSignal.com");
            }
            int i = 1;
            if (c == 1 && (a = mo29825a()) != null) {
                i = a.intValue();
            }
            Integer b = m15629b(context);
            return b != null ? b.intValue() : i;
        } catch (Throwable th) {
            C4564n1.m15790a(C4564n1.C4566a0.FATAL, "OneSignal AppId format is invalid.\nExample: 'b2f7f966-d8cc-11e4-bed1-df8f05be55ba'\n", th);
            return -999;
        }
    }

    /* renamed from: c */
    static Uri m15634c(Context context, String str) {
        int identifier;
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        if (!m15627a(str) || (identifier = resources.getIdentifier(str, "raw", packageName)) == 0) {
            int identifier2 = resources.getIdentifier("onesignal_default_sound", "raw", packageName);
            if (identifier2 == 0) {
                return null;
            }
            return Uri.parse("android.resource://" + packageName + "/" + identifier2);
        }
        return Uri.parse("android.resource://" + packageName + "/" + identifier);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Integer mo29825a() {
        boolean f = m15637f();
        boolean g = m15638g();
        if (f || g) {
            if (g && !f) {
                C4564n1.m15789a(C4564n1.C4566a0.WARN, "GCM Library detected, please upgrade to Firebase FCM library as GCM is deprecated!");
            }
            if (!g || !f) {
                return null;
            }
            C4564n1.m15789a(C4564n1.C4566a0.WARN, "Both GCM & FCM Libraries detected! Please remove the deprecated GCM library.");
            return null;
        }
        C4564n1.m15789a(C4564n1.C4566a0.FATAL, "The Firebase FCM library is missing! Please make sure to include it in your project.");
        return -4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo29826b() {
        try {
            String networkOperatorName = ((TelephonyManager) C4564n1.f12495e.getSystemService(PlaceFields.PHONE)).getNetworkOperatorName();
            if ("".equals(networkOperatorName)) {
                return null;
            }
            return networkOperatorName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    static boolean m15635c(String str) {
        if (str != null) {
            return false;
        }
        C4564n1.m15789a(C4564n1.C4566a0.INFO, "OneSignal was not initialized, ensure to always initialize OneSignal from the onCreate of your Application class.");
        return true;
    }

    /* renamed from: b */
    static String m15630b(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).metaData.getString(str);
        } catch (Throwable th) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "", th);
            return null;
        }
    }

    /* renamed from: a */
    static String m15620a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(str, "string", context.getPackageName());
        return identifier != 0 ? resources.getString(identifier) : str2;
    }

    /* renamed from: b */
    static void m15631b(int i) {
        try {
            Thread.sleep((long) i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    static boolean m15626a(Context context) {
        try {
            return C0736l.m2316a(C4564n1.f12495e).mo3962a();
        } catch (Throwable unused) {
            return true;
        }
    }

    /* renamed from: a */
    static void m15622a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    /* renamed from: b */
    static void m15632b(String str) {
        m15621a(Uri.parse(str.trim()));
    }

    /* renamed from: a */
    static void m15623a(Runnable runnable, int i) {
        new Handler(Looper.getMainLooper()).postDelayed(runnable, (long) i);
    }

    /* renamed from: a */
    static boolean m15627a(String str) {
        return str != null && !str.matches("^[0-9]");
    }

    /* renamed from: a */
    static long[] m15628a(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            Object opt = jSONObject.opt("vib_pt");
            if (opt instanceof String) {
                jSONArray = new JSONArray((String) opt);
            } else {
                jSONArray = (JSONArray) opt;
            }
            long[] jArr = new long[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                jArr[i] = jSONArray.optLong(i);
            }
            return jArr;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static void m15621a(Uri uri) {
        Intent intent;
        C4538b a = uri.getScheme() != null ? C4538b.m15648a(uri.getScheme()) : null;
        if (a == null) {
            a = C4538b.HTTP;
            if (!uri.toString().contains("://")) {
                uri = Uri.parse("http://" + uri.toString());
            }
        }
        if (C4537a.f12404a[a.ordinal()] != 1) {
            intent = new Intent("android.intent.action.VIEW", uri);
        } else {
            intent = Intent.makeMainSelectorActivity("android.intent.action.MAIN", "android.intent.category.APP_BROWSER");
            intent.setData(uri);
        }
        intent.addFlags(1476919296);
        C4564n1.f12495e.startActivity(intent);
    }

    /* renamed from: a */
    static boolean m15625a(Activity activity, int i) {
        try {
            return (activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).configChanges & i) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
