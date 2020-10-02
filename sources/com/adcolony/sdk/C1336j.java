package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import com.adcolony.sdk.C1439u;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.GraphResponse;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.places.model.PlaceFields;
import com.tapjoy.TapjoyConstants;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"ObsoleteSdkInt"})
/* renamed from: com.adcolony.sdk.j */
class C1336j {

    /* renamed from: i */
    private static int f4189i = 2;

    /* renamed from: j */
    static final String f4190j = "Production";

    /* renamed from: a */
    private String f4191a = "";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f4192b;

    /* renamed from: c */
    private boolean f4193c;

    /* renamed from: d */
    private boolean f4194d;

    /* renamed from: e */
    private JSONObject f4195e = C1437s.m5599b();

    /* renamed from: f */
    private String f4196f = "android";

    /* renamed from: g */
    private String f4197g = "android_native";

    /* renamed from: h */
    private String f4198h = "";

    /* renamed from: com.adcolony.sdk.j$a */
    class C1337a implements C1458z {

        /* renamed from: com.adcolony.sdk.j$a$a */
        class C1338a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C1454x f4200a;

            C1338a(C1454x xVar) {
                this.f4200a = xVar;
            }

            public void run() {
                try {
                    if (C1336j.this.mo6622f() < 14) {
                        new C1341d(this.f4200a, false).execute(new Void[0]);
                    } else {
                        new C1341d(this.f4200a, false).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    }
                } catch (RuntimeException unused) {
                    new C1439u.C1440a().mo6801a("Error retrieving device info, disabling AdColony.").mo6803a(C1439u.f4517j);
                    AdColony.disable();
                } catch (StackOverflowError unused2) {
                    new C1439u.C1440a().mo6801a("StackOverflowError on info AsyncTask execution, disabling AdColony").mo6803a(C1439u.f4517j);
                    AdColony.disable();
                }
            }
        }

        C1337a() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            C1359k0.m5309a((Runnable) new C1338a(xVar));
        }
    }

    /* renamed from: com.adcolony.sdk.j$b */
    class C1339b implements C1458z {
        C1339b() {
        }

        /* renamed from: a */
        public void mo6395a(C1454x xVar) {
            JSONObject b = C1437s.m5599b();
            C1437s.m5603b(b, "result", C1359k0.m5329e(C1437s.m5613h(xVar.mo6830b(), "name")));
            C1437s.m5603b(b, GraphResponse.SUCCESS_KEY, true);
            xVar.mo6829a(b).mo6834d();
        }
    }

    /* renamed from: com.adcolony.sdk.j$c */
    class C1340c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f4203a;

        C1340c(Context context) {
            this.f4203a = context;
        }

        public void run() {
            try {
                String unused = C1336j.this.f4192b = new WebView(this.f4203a).getSettings().getUserAgentString();
            } catch (RuntimeException e) {
                C1439u.C1440a aVar = new C1439u.C1440a();
                aVar.mo6801a(e.toString() + ": during WebView initialization.").mo6801a(" Disabling AdColony.").mo6803a(C1439u.f4516i);
                String unused2 = C1336j.this.f4192b = "";
                AdColony.disable();
            }
            C1199a.m4880c().mo6544j().mo6706a(C1336j.this.f4192b);
        }
    }

    C1336j() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public int mo6601A() {
        Context b = C1199a.m4878b();
        if (b == null) {
            return 2;
        }
        int i = b.getResources().getConfiguration().orientation;
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return 2;
        }
        return 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public String mo6602B() {
        return Build.VERSION.RELEASE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public String mo6603C() {
        return "4.2.0";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public String mo6604D() {
        TelephonyManager telephonyManager;
        Context b = C1199a.m4878b();
        if (b == null || (telephonyManager = (TelephonyManager) b.getSystemService(PlaceFields.PHONE)) == null) {
            return "";
        }
        return telephonyManager.getSimCountryIso();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public int mo6605E() {
        return TimeZone.getDefault().getOffset(15) / 60000;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F */
    public String mo6606F() {
        return TimeZone.getDefault().getID();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: G */
    public String mo6607G() {
        Context b;
        if (this.f4192b == null && (b = C1199a.m4878b()) != null) {
            C1359k0.m5309a((Runnable) new C1340c(b));
        }
        return this.f4192b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public void mo6608H() {
        this.f4193c = false;
        C1199a.m4876a("Device.get_info", (C1458z) new C1337a());
        C1199a.m4876a("Device.application_exists", (C1458z) new C1339b());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public boolean mo6609I() {
        Context b = C1199a.m4878b();
        if (b == null) {
            return false;
        }
        DisplayMetrics displayMetrics = b.getResources().getDisplayMetrics();
        float f = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
        float f2 = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
        if (Math.sqrt((double) ((f * f) + (f2 * f2))) >= 6.0d) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo6615b() {
        return this.f4191a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo6618c() {
        Context b = C1199a.m4878b();
        if (b == null) {
            return "";
        }
        return Settings.Secure.getString(b.getContentResolver(), TapjoyConstants.TJC_ADVERTISING_ID);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo6620d() {
        Context b = C1199a.m4878b();
        if (b == null) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(b.getContentResolver(), "limit_ad_tracking") != 0) {
                return true;
            }
            return false;
        } catch (Settings.SettingNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"HardwareIds"})
    /* renamed from: e */
    public String mo6621e() {
        Context b = C1199a.m4878b();
        if (b == null) {
            return "";
        }
        return Settings.Secure.getString(b.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo6622f() {
        return Build.VERSION.SDK_INT;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public double mo6623g() {
        Context b = C1199a.m4878b();
        if (b == null) {
            return 0.0d;
        }
        try {
            Intent registerReceiver = b.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                return 0.0d;
            }
            int intExtra = registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra < 0 || intExtra2 < 0) {
                return 0.0d;
            }
            double d = (double) intExtra;
            double d2 = (double) intExtra2;
            Double.isNaN(d);
            Double.isNaN(d2);
            return d / d2;
        } catch (IllegalArgumentException unused) {
            return 0.0d;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public String mo6624h() {
        Context b = C1199a.m4878b();
        String str = "";
        if (b == null) {
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) b.getSystemService(PlaceFields.PHONE);
        if (telephonyManager != null) {
            str = telephonyManager.getNetworkOperatorName();
        }
        return str.length() == 0 ? "unknown" : str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo6625i() {
        return Build.VERSION.SDK_INT < 23 || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public String mo6626j() {
        return this.f4198h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public String mo6627k() {
        return Locale.getDefault().getCountry();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public int mo6628l() {
        TimeZone timeZone = TimeZone.getDefault();
        if (!timeZone.inDaylightTime(new Date())) {
            return 0;
        }
        return timeZone.getDSTSavings() / 60000;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public boolean mo6629m() {
        int i;
        Context b = C1199a.m4878b();
        if (b == null || Build.VERSION.SDK_INT < 29 || (i = b.getResources().getConfiguration().uiMode & 48) == 16 || i != 32) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public float mo6630n() {
        Context b = C1199a.m4878b();
        if (b == null) {
            return 0.0f;
        }
        return b.getResources().getDisplayMetrics().density;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public String mo6631o() {
        return mo6609I() ? "tablet" : PlaceFields.PHONE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public int mo6632p() {
        Context b = C1199a.m4878b();
        if (b == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) b.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.densityDpi;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public int mo6633q() {
        Context b = C1199a.m4878b();
        if (b == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) b.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public int mo6634r() {
        Context b = C1199a.m4878b();
        if (b == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) b.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public String mo6635s() {
        return Locale.getDefault().getLanguage();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public JSONObject mo6636t() {
        return this.f4195e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public boolean mo6637u() {
        return this.f4194d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public String mo6638v() {
        return "";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public String mo6639w() {
        return Build.MANUFACTURER;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public int mo6640x() {
        ActivityManager activityManager;
        Context b = C1199a.m4878b();
        if (b == null || (activityManager = (ActivityManager) b.getSystemService("activity")) == null) {
            return 0;
        }
        return activityManager.getMemoryClass();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public long mo6641y() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / ((long) 1048576);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public String mo6642z() {
        return Build.MODEL;
    }

    /* renamed from: com.adcolony.sdk.j$d */
    private static class C1341d extends AsyncTask<Void, Void, JSONObject> {

        /* renamed from: a */
        private C1454x f4205a;

        /* renamed from: b */
        private boolean f4206b;

        C1341d(C1454x xVar, boolean z) {
            this.f4205a = xVar;
            this.f4206b = z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public JSONObject doInBackground(Void... voidArr) {
            if (Build.VERSION.SDK_INT < 14) {
                return null;
            }
            return C1199a.m4880c().mo6542h().mo6612a(true);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(JSONObject jSONObject) {
            if (this.f4206b) {
                new C1454x("Device.update_info", 1, jSONObject).mo6834d();
            } else {
                this.f4205a.mo6829a(jSONObject).mo6834d();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6617b(boolean z) {
        this.f4193c = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6614a(JSONObject jSONObject) {
        this.f4195e = jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6616b(String str) {
        this.f4198h = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6613a(String str) {
        this.f4191a = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6619c(boolean z) {
        this.f4194d = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo6610a() {
        return System.getProperty("os.arch").toLowerCase(Locale.ENGLISH);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo6611a(Context context) {
        return context.getPackageName();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo6612a(boolean z) {
        JSONObject b = C1437s.m5599b();
        C1290h c = C1199a.m4880c();
        C1437s.m5592a(b, TapjoyConstants.TJC_CARRIER_NAME, mo6624h());
        C1437s.m5592a(b, "data_path", C1199a.m4880c().mo6555v().mo6510b());
        C1437s.m5602b(b, "device_api", mo6622f());
        C1437s.m5602b(b, "display_width", mo6634r());
        C1437s.m5602b(b, "display_height", mo6633q());
        C1437s.m5602b(b, "screen_width", mo6634r());
        C1437s.m5602b(b, "screen_height", mo6633q());
        C1437s.m5602b(b, "display_dpi", mo6632p());
        C1437s.m5592a(b, TapjoyConstants.TJC_DEVICE_TYPE_NAME, mo6631o());
        C1437s.m5592a(b, "locale_language_code", mo6635s());
        C1437s.m5592a(b, UserDataStore.LAST_NAME, mo6635s());
        C1437s.m5592a(b, "locale_country_code", mo6627k());
        C1437s.m5592a(b, "locale", mo6627k());
        C1437s.m5592a(b, TapjoyConstants.TJC_DEVICE_MAC_ADDRESS, mo6638v());
        C1437s.m5592a(b, "manufacturer", mo6639w());
        C1437s.m5592a(b, "device_brand", mo6639w());
        C1437s.m5592a(b, "media_path", C1199a.m4880c().mo6555v().mo6511c());
        C1437s.m5592a(b, "temp_storage_path", C1199a.m4880c().mo6555v().mo6512d());
        C1437s.m5602b(b, "memory_class", mo6640x());
        C1437s.m5602b(b, "network_speed", 20);
        C1437s.m5591a(b, "memory_used_mb", mo6641y());
        C1437s.m5592a(b, "model", mo6642z());
        C1437s.m5592a(b, "device_model", mo6642z());
        C1437s.m5592a(b, TapjoyConstants.TJC_SDK_TYPE, this.f4197g);
        C1437s.m5592a(b, "sdk_version", mo6603C());
        C1437s.m5592a(b, "network_type", c.mo6549o().mo6396a());
        C1437s.m5592a(b, TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, mo6602B());
        C1437s.m5592a(b, "os_name", this.f4196f);
        C1437s.m5592a(b, TapjoyConstants.TJC_PLATFORM, this.f4196f);
        C1437s.m5592a(b, "arch", mo6610a());
        C1437s.m5592a(b, "user_id", C1437s.m5613h(c.mo6552r().mo6272b(), "user_id"));
        C1437s.m5592a(b, "app_id", c.mo6552r().mo6271a());
        C1437s.m5592a(b, "app_bundle_name", C1359k0.m5324d());
        C1437s.m5592a(b, "app_bundle_version", C1359k0.m5328e());
        C1437s.m5590a(b, "battery_level", mo6623g());
        C1437s.m5592a(b, "cell_service_country_code", mo6604D());
        C1437s.m5592a(b, "timezone_ietf", mo6606F());
        C1437s.m5602b(b, "timezone_gmt_m", mo6605E());
        C1437s.m5602b(b, "timezone_dst_m", mo6628l());
        C1437s.m5594a(b, "launch_metadata", mo6636t());
        C1437s.m5592a(b, "controller_version", c.mo6534c());
        int A = mo6601A();
        f4189i = A;
        C1437s.m5602b(b, "current_orientation", A);
        C1437s.m5603b(b, "cleartext_permitted", mo6625i());
        C1437s.m5590a(b, "density", (double) mo6630n());
        C1437s.m5603b(b, "dark_mode", mo6629m());
        JSONArray a = C1437s.m5579a();
        if (C1359k0.m5329e("com.android.vending")) {
            a.put("google");
        }
        if (C1359k0.m5329e("com.amazon.venezia")) {
            a.put("amazon");
        }
        C1437s.m5593a(b, "available_stores", a);
        C1437s.m5593a(b, NativeProtocol.RESULT_ARGS_PERMISSIONS, C1359k0.m5325d(C1199a.m4878b()));
        int i = 40;
        while (!this.f4193c && i > 0 && z) {
            try {
                Thread.sleep(50);
                i--;
            } catch (Exception unused) {
            }
        }
        C1437s.m5592a(b, "advertiser_id", mo6615b());
        C1437s.m5603b(b, "limit_tracking", mo6637u());
        if (mo6615b() == null || mo6615b().equals("")) {
            C1437s.m5592a(b, "android_id_sha1", C1359k0.m5318b(mo6621e()));
        }
        return b;
    }
}
