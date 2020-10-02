package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.p004v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.applovin.impl.adview.C1548c;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1888i;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C1991g;
import com.applovin.impl.sdk.utils.C2022l;
import com.applovin.impl.sdk.utils.C2023m;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.loopj.android.http.C4250c;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.k */
public class C1945k {

    /* renamed from: e */
    private static String f6459e;

    /* renamed from: f */
    private static int f6460f;

    /* renamed from: a */
    private final C1941j f6461a;

    /* renamed from: b */
    private final C1977q f6462b;

    /* renamed from: c */
    private final Context f6463c;

    /* renamed from: d */
    private final Map<Class, Object> f6464d;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final AtomicReference<C1947a> f6465g = new AtomicReference<>();

    /* renamed from: com.applovin.impl.sdk.k$a */
    public static class C1947a {

        /* renamed from: a */
        public boolean f6467a;

        /* renamed from: b */
        public String f6468b = "";
    }

    /* renamed from: com.applovin.impl.sdk.k$b */
    public static class C1948b {

        /* renamed from: a */
        public String f6469a;

        /* renamed from: b */
        public String f6470b;

        /* renamed from: c */
        public String f6471c;

        /* renamed from: d */
        public String f6472d;

        /* renamed from: e */
        public String f6473e;

        /* renamed from: f */
        public String f6474f;

        /* renamed from: g */
        public boolean f6475g;

        /* renamed from: h */
        public long f6476h;

        /* renamed from: i */
        public boolean f6477i;

        /* renamed from: a */
        public Map<String, String> mo8617a() {
            HashMap hashMap = new HashMap(9);
            hashMap.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, this.f6469a);
            hashMap.put(TapjoyConstants.TJC_APP_VERSION_NAME, C2025o.m7966e(this.f6470b));
            hashMap.put("package_name", C2025o.m7966e(this.f6471c));
            hashMap.put("installer_name", C2025o.m7966e(this.f6472d));
            hashMap.put("tg", String.valueOf(this.f6473e));
            hashMap.put("ltg", String.valueOf(this.f6474f));
            hashMap.put("debug", String.valueOf(this.f6475g));
            hashMap.put("test_ads", String.valueOf(this.f6477i));
            hashMap.put("ia", String.valueOf(this.f6476h));
            hashMap.put("sdk_version", AppLovinSdk.VERSION);
            return hashMap;
        }
    }

    /* renamed from: com.applovin.impl.sdk.k$c */
    public static class C1949c {

        /* renamed from: a */
        public int f6478a = -1;

        /* renamed from: b */
        public int f6479b = -1;
    }

    /* renamed from: com.applovin.impl.sdk.k$d */
    public static class C1950d {

        /* renamed from: A */
        public boolean f6480A;

        /* renamed from: B */
        public boolean f6481B;

        /* renamed from: C */
        public boolean f6482C;

        /* renamed from: D */
        public boolean f6483D;

        /* renamed from: E */
        public boolean f6484E;

        /* renamed from: F */
        public int f6485F = -1;

        /* renamed from: G */
        public String f6486G;

        /* renamed from: H */
        public long f6487H;

        /* renamed from: I */
        public long f6488I;

        /* renamed from: J */
        public C1951e f6489J = new C1951e();

        /* renamed from: K */
        public Boolean f6490K;

        /* renamed from: L */
        public Boolean f6491L;

        /* renamed from: M */
        public Boolean f6492M;

        /* renamed from: N */
        public boolean f6493N;

        /* renamed from: O */
        public float f6494O;

        /* renamed from: P */
        public float f6495P;

        /* renamed from: Q */
        public long f6496Q;

        /* renamed from: R */
        public int f6497R = C1924e.f6359a;

        /* renamed from: a */
        public String f6498a;

        /* renamed from: b */
        public String f6499b;

        /* renamed from: c */
        public int f6500c;

        /* renamed from: d */
        public String f6501d;

        /* renamed from: e */
        public String f6502e;

        /* renamed from: f */
        public String f6503f;

        /* renamed from: g */
        public String f6504g;

        /* renamed from: h */
        public String f6505h;

        /* renamed from: i */
        public String f6506i;

        /* renamed from: j */
        public String f6507j;

        /* renamed from: k */
        public Locale f6508k;

        /* renamed from: l */
        public String f6509l;

        /* renamed from: m */
        public float f6510m;

        /* renamed from: n */
        public int f6511n;

        /* renamed from: o */
        public float f6512o;

        /* renamed from: p */
        public float f6513p;

        /* renamed from: q */
        public double f6514q;

        /* renamed from: r */
        public double f6515r;

        /* renamed from: s */
        public int f6516s;

        /* renamed from: t */
        public boolean f6517t;

        /* renamed from: u */
        public C1949c f6518u;

        /* renamed from: v */
        public long f6519v;

        /* renamed from: w */
        public float f6520w;

        /* renamed from: x */
        public int f6521x;

        /* renamed from: y */
        public int f6522y;

        /* renamed from: z */
        public String f6523z;

        /* renamed from: a */
        public Map<String, String> mo8618a() {
            HashMap hashMap = new HashMap(64);
            hashMap.put(TapjoyConstants.TJC_PLATFORM, C2025o.m7966e(this.f6498a));
            hashMap.put("api_level", String.valueOf(this.f6500c));
            hashMap.put("model", C2025o.m7966e(this.f6501d));
            hashMap.put("locale", C2025o.m7966e(this.f6508k.toString()));
            hashMap.put("brand", C2025o.m7966e(this.f6502e));
            hashMap.put("brand_name", C2025o.m7966e(this.f6503f));
            hashMap.put("hardware", C2025o.m7966e(this.f6504g));
            hashMap.put("revision", C2025o.m7966e(this.f6505h));
            hashMap.put("os", C2025o.m7966e(this.f6499b));
            hashMap.put("orientation_lock", this.f6509l);
            hashMap.put(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, C2025o.m7966e(this.f6506i));
            hashMap.put("carrier", C2025o.m7966e(this.f6507j));
            hashMap.put("tz_offset", String.valueOf(this.f6515r));
            hashMap.put("aida", String.valueOf(this.f6493N));
            hashMap.put("adr", String.valueOf(this.f6517t));
            hashMap.put("volume", String.valueOf(this.f6521x));
            hashMap.put("sb", String.valueOf(this.f6522y));
            hashMap.put("sim", String.valueOf(this.f6480A));
            hashMap.put("gy", String.valueOf(this.f6481B));
            hashMap.put("is_tablet", String.valueOf(this.f6482C));
            hashMap.put("tv", String.valueOf(this.f6483D));
            hashMap.put("vs", String.valueOf(this.f6484E));
            hashMap.put("lpm", String.valueOf(this.f6485F));
            hashMap.put("fs", String.valueOf(this.f6487H));
            hashMap.put("tds", String.valueOf(this.f6488I));
            hashMap.put("fm", String.valueOf(this.f6489J.f6525b));
            hashMap.put("tm", String.valueOf(this.f6489J.f6524a));
            hashMap.put("lmt", String.valueOf(this.f6489J.f6526c));
            hashMap.put("lm", String.valueOf(this.f6489J.f6527d));
            hashMap.put("adns", String.valueOf(this.f6510m));
            hashMap.put("adnsd", String.valueOf(this.f6511n));
            hashMap.put("xdpi", String.valueOf(this.f6512o));
            hashMap.put("ydpi", String.valueOf(this.f6513p));
            hashMap.put("screen_size_in", String.valueOf(this.f6514q));
            hashMap.put("af", String.valueOf(this.f6519v));
            hashMap.put("font", String.valueOf(this.f6520w));
            hashMap.put("bt_ms", String.valueOf(this.f6496Q));
            hashMap.put("wvvc", String.valueOf(this.f6516s));
            hashMap.put("mute_switch", String.valueOf(this.f6497R));
            if (C2025o.m7963b(this.f6486G)) {
                hashMap.put("so", C2025o.m7966e(this.f6486G));
            }
            float f = this.f6494O;
            if (f > 0.0f) {
                hashMap.put("da", String.valueOf(f));
            }
            float f2 = this.f6495P;
            if (f2 > 0.0f) {
                hashMap.put("dm", String.valueOf(f2));
            }
            if (C2025o.m7963b(this.f6523z)) {
                hashMap.put("ua", C2025o.m7966e(this.f6523z));
            }
            C1949c cVar = this.f6518u;
            if (cVar != null) {
                hashMap.put("act", String.valueOf(cVar.f6478a));
                hashMap.put("acm", String.valueOf(this.f6518u.f6479b));
            }
            Boolean bool = this.f6490K;
            if (bool != null) {
                hashMap.put("huc", bool.toString());
            }
            Boolean bool2 = this.f6491L;
            if (bool2 != null) {
                hashMap.put("aru", bool2.toString());
            }
            Boolean bool3 = this.f6492M;
            if (bool3 != null) {
                hashMap.put("dns", bool3.toString());
            }
            return hashMap;
        }
    }

    /* renamed from: com.applovin.impl.sdk.k$e */
    public static class C1951e {

        /* renamed from: a */
        public long f6524a = -1;

        /* renamed from: b */
        public long f6525b = -1;

        /* renamed from: c */
        public long f6526c = -1;

        /* renamed from: d */
        public boolean f6527d = false;
    }

    protected C1945k(C1941j jVar) {
        if (jVar != null) {
            this.f6461a = jVar;
            this.f6462b = jVar.mo8602v();
            this.f6463c = jVar.mo8527E();
            this.f6464d = Collections.synchronizedMap(new HashMap());
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: a */
    private C1950d m7536a(C1950d dVar) {
        PowerManager powerManager;
        if (dVar == null) {
            dVar = new C1950d();
        }
        dVar.f6490K = C1928g.m7409a(this.f6463c);
        dVar.f6491L = C1928g.m7413b(this.f6463c);
        dVar.f6492M = C1928g.m7415c(this.f6463c);
        dVar.f6518u = ((Boolean) this.f6461a.mo8549a(C1841c.f5976dS)).booleanValue() ? m7547j() : null;
        if (((Boolean) this.f6461a.mo8549a(C1841c.f6041ef)).booleanValue()) {
            dVar.f6517t = m7553p();
        }
        AudioManager audioManager = (AudioManager) this.f6463c.getSystemService("audio");
        if (audioManager != null) {
            dVar.f6521x = (int) (((float) audioManager.getStreamVolume(3)) * ((Float) this.f6461a.mo8549a(C1841c.f6042eg)).floatValue());
        }
        try {
            dVar.f6522y = (int) ((((float) Settings.System.getInt(this.f6463c.getContentResolver(), "screen_brightness")) / 255.0f) * 100.0f);
        } catch (Settings.SettingNotFoundException e) {
            this.f6462b.mo8743b("DataCollector", "Unable to collect screen brightness", e);
        }
        if (((Boolean) this.f6461a.mo8549a(C1841c.f6043eh)).booleanValue()) {
            String a = C1548c.m5986a(((Long) this.f6461a.mo8549a(C1841c.f6044ei)).longValue());
            if (C2025o.m7963b(a)) {
                dVar.f6523z = a;
            }
        }
        if (((Boolean) this.f6461a.mo8549a(C1841c.f5980dW)).booleanValue()) {
            try {
                dVar.f6487H = Environment.getDataDirectory().getFreeSpace();
                dVar.f6488I = Environment.getDataDirectory().getTotalSpace();
            } catch (Throwable th) {
                dVar.f6487H = -1;
                dVar.f6488I = -1;
                this.f6462b.mo8743b("DataCollector", "Unable to collect total & free space.", th);
            }
        }
        if (((Boolean) this.f6461a.mo8549a(C1841c.f5981dX)).booleanValue()) {
            ActivityManager activityManager = (ActivityManager) this.f6463c.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                C1951e eVar = dVar.f6489J;
                eVar.f6525b = memoryInfo.availMem;
                eVar.f6527d = memoryInfo.lowMemory;
                eVar.f6526c = memoryInfo.threshold;
                eVar.f6524a = memoryInfo.totalMem;
            }
        }
        String str = (String) this.f6461a.mo8526D().mo8302a(C1841c.f6047el);
        if (!str.equalsIgnoreCase(f6459e)) {
            try {
                f6459e = str;
                PackageInfo packageInfo = this.f6463c.getPackageManager().getPackageInfo(str, 0);
                dVar.f6516s = packageInfo.versionCode;
                f6460f = packageInfo.versionCode;
            } catch (Throwable unused) {
                f6460f = 0;
            }
        } else {
            dVar.f6516s = f6460f;
        }
        if (((Boolean) this.f6461a.mo8549a(C1841c.f5977dT)).booleanValue()) {
            dVar.f6482C = AppLovinSdkUtils.isTablet(this.f6463c);
        }
        if (((Boolean) this.f6461a.mo8549a(C1841c.f5978dU)).booleanValue()) {
            dVar.f6483D = m7552o();
        }
        if (((Boolean) this.f6461a.mo8549a(C1841c.f5979dV)).booleanValue()) {
            String m = m7550m();
            if (!TextUtils.isEmpty(m)) {
                dVar.f6486G = m;
            }
        }
        dVar.f6509l = m7544g();
        if (((Boolean) this.f6461a.mo8549a(C1841c.f5982dY)).booleanValue()) {
            dVar.f6484E = C2029r.m8036d();
        }
        if (C1991g.m7841d() && (powerManager = (PowerManager) this.f6463c.getSystemService("power")) != null) {
            dVar.f6485F = powerManager.isPowerSaveMode() ? 1 : 0;
        }
        if (((Boolean) this.f6461a.mo8549a(C1841c.f6048em)).booleanValue() && this.f6461a.mo8568ad() != null) {
            dVar.f6494O = this.f6461a.mo8568ad().mo8808c();
        }
        if (((Boolean) this.f6461a.mo8549a(C1841c.f6049en)).booleanValue() && this.f6461a.mo8568ad() != null) {
            dVar.f6495P = this.f6461a.mo8568ad().mo8807b();
        }
        dVar.f6497R = this.f6461a.mo8569ae().mo8500a();
        return dVar;
    }

    /* renamed from: a */
    private String m7537a(int i) {
        if (i == 1) {
            return "receiver";
        }
        if (i == 2) {
            return "speaker";
        }
        if (i == 4 || i == 3) {
            return "headphones";
        }
        if (i == 8) {
            return "bluetootha2dpoutput";
        }
        if (i == 13 || i == 19 || i == 5 || i == 6 || i == 12 || i == 11) {
            return "lineout";
        }
        if (i == 9 || i == 10) {
            return "hdmioutput";
        }
        return null;
    }

    /* renamed from: a */
    private boolean m7539a(String str) {
        try {
            return Settings.Secure.getInt(this.f6463c.getContentResolver(), str) == 1;
        } catch (Settings.SettingNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.applovin.impl.sdk.b.c<java.lang.String>, com.applovin.impl.sdk.b.c] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m7540a(java.lang.String r2, com.applovin.impl.sdk.p050b.C1841c<java.lang.String> r3) {
        /*
            r1 = this;
            com.applovin.impl.sdk.j r0 = r1.f6461a
            java.lang.Object r3 = r0.mo8549a(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.util.List r3 = com.applovin.impl.sdk.utils.C1989e.m7831a((java.lang.String) r3)
            java.util.Iterator r3 = r3.iterator()
        L_0x0010:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0024
            java.lang.Object r0 = r3.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r2.startsWith(r0)
            if (r0 == 0) goto L_0x0010
            r2 = 1
            return r2
        L_0x0024:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1945k.m7540a(java.lang.String, com.applovin.impl.sdk.b.c):boolean");
    }

    /* renamed from: b */
    private boolean m7541b(String str) {
        if (str != null) {
            Context context = this.f6463c;
            if (context != null) {
                return C2022l.m7939a(str, context.getPackageName(), this.f6463c.getPackageManager()) == 0;
            }
            throw new IllegalArgumentException("No context specified");
        }
        throw new IllegalArgumentException("No permission name specified");
    }

    /* renamed from: c */
    private String m7542c(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = str.charAt(i);
            for (int i2 = 9; i2 >= 0; i2--) {
                cArr[i] = (char) (cArr[i] ^ iArr[i2]);
            }
        }
        return new String(cArr);
    }

    /* renamed from: f */
    private Map<String, String> m7543f() {
        return mo8612a((Map<String, String>) null, false, true);
    }

    /* renamed from: g */
    private String m7544g() {
        int b = C2029r.m8022b(this.f6463c);
        return b == 1 ? TJAdUnitConstants.String.PORTRAIT : b == 2 ? TJAdUnitConstants.String.LANDSCAPE : "none";
    }

    /* renamed from: h */
    private C1947a m7545h() {
        if (m7546i()) {
            try {
                C1947a aVar = new C1947a();
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f6463c);
                aVar.f6467a = advertisingIdInfo.isLimitAdTrackingEnabled();
                aVar.f6468b = advertisingIdInfo.getId();
                return aVar;
            } catch (Throwable th) {
                this.f6462b.mo8743b("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", th);
            }
        } else {
            C1977q.m7751i("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }");
            return new C1947a();
        }
    }

    /* renamed from: i */
    private boolean m7546i() {
        return C2029r.m8038e("com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }

    /* renamed from: j */
    private C1949c m7547j() {
        C1949c cVar = new C1949c();
        Intent registerReceiver = this.f6463c.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i = -1;
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1) : -1;
        int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra <= 0 || intExtra2 <= 0) {
            cVar.f6479b = -1;
        } else {
            cVar.f6479b = (int) ((((float) intExtra) / ((float) intExtra2)) * 100.0f);
        }
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra("status", -1);
        }
        cVar.f6478a = i;
        return cVar;
    }

    /* renamed from: k */
    private long m7548k() {
        List asList = Arrays.asList(C2025o.m7964c(Settings.Secure.getString(this.f6463c.getContentResolver(), "enabled_accessibility_services")).split(":"));
        long j = asList.contains("AccessibilityMenuService") ? 256 : 0;
        if (asList.contains("SelectToSpeakService")) {
            j |= 512;
        }
        if (asList.contains("SoundAmplifierService")) {
            j |= 2;
        }
        if (asList.contains("SpeechToTextAccessibilityService")) {
            j |= 128;
        }
        if (asList.contains("SwitchAccessService")) {
            j |= 4;
        }
        if ((this.f6463c.getResources().getConfiguration().uiMode & 48) == 32) {
            j |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        if (m7539a("accessibility_enabled")) {
            j |= 8;
        }
        if (m7539a("touch_exploration_enabled")) {
            j |= 16;
        }
        if (!C1991g.m7841d()) {
            return j;
        }
        if (m7539a("accessibility_display_inversion_enabled")) {
            j |= 32;
        }
        return m7539a("skip_first_use_hints") ? j | 64 : j;
    }

    /* renamed from: l */
    private float m7549l() {
        try {
            return Settings.System.getFloat(this.f6463c.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e) {
            this.f6462b.mo8743b("DataCollector", "Error collecting font scale", e);
            return -1.0f;
        }
    }

    /* renamed from: m */
    private String m7550m() {
        AudioManager audioManager = (AudioManager) this.f6463c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (C1991g.m7842e()) {
            for (AudioDeviceInfo type : audioManager.getDevices(2)) {
                String a = m7537a(type.getType());
                if (!TextUtils.isEmpty(a)) {
                    sb.append(a);
                    sb.append(",");
                }
            }
        } else {
            if (audioManager.isWiredHeadsetOn()) {
                sb.append("headphones");
                sb.append(",");
            }
            if (audioManager.isBluetoothA2dpOn()) {
                sb.append("bluetootha2dpoutput");
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            this.f6462b.mo8742b("DataCollector", "No sound outputs detected");
        }
        return sb2;
    }

    /* renamed from: n */
    private double m7551n() {
        double offset = (double) TimeZone.getDefault().getOffset(new Date().getTime());
        Double.isNaN(offset);
        double round = (double) Math.round((offset * 10.0d) / 3600000.0d);
        Double.isNaN(round);
        return round / 10.0d;
    }

    /* renamed from: o */
    private boolean m7552o() {
        return this.f6463c.getPackageManager().hasSystemFeature(C1991g.m7841d() ? "android.software.leanback" : "android.hardware.type.television");
    }

    /* renamed from: p */
    private boolean m7553p() {
        try {
            return m7554q() || m7555r();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: q */
    private boolean m7554q() {
        String str = Build.TAGS;
        return str != null && str.contains(m7542c("lz}$blpz"));
    }

    /* renamed from: r */
    private boolean m7555r() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i = 0; i < 9; i++) {
            if (new File(m7542c(strArr[i])).exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: s */
    private boolean m7556s() {
        return m7540a(Build.DEVICE, C1841c.f6038ec) || m7540a(Build.HARDWARE, C1841c.f6037eb) || m7540a(Build.MANUFACTURER, C1841c.f6039ed) || m7540a(Build.MODEL, C1841c.f6040ee);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo8611a() {
        String encodeToString = Base64.encodeToString(new JSONObject(m7543f()).toString().getBytes(Charset.defaultCharset()), 2);
        if (!((Boolean) this.f6461a.mo8549a(C1841c.f6021eL)).booleanValue()) {
            return encodeToString;
        }
        return C2023m.m7941a(encodeToString, this.f6461a.mo8599t(), C2029r.m7987a(this.f6461a));
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0461  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0481  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x049c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x04b7  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x04c4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x04e0  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.String> mo8612a(java.util.Map<java.lang.String, java.lang.String> r6, boolean r7, boolean r8) {
        /*
            r5 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.applovin.impl.sdk.k$d r1 = r5.mo8613b()
            java.lang.String r2 = r1.f6502e
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7966e(r2)
            java.lang.String r3 = "brand"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f6503f
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7966e(r2)
            java.lang.String r3 = "brand_name"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f6504g
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7966e(r2)
            java.lang.String r3 = "hardware"
            r0.put(r3, r2)
            int r2 = r1.f6500c
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "api_level"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f6507j
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7966e(r2)
            java.lang.String r3 = "carrier"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f6506i
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7966e(r2)
            java.lang.String r3 = "country_code"
            r0.put(r3, r2)
            java.util.Locale r2 = r1.f6508k
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7966e(r2)
            java.lang.String r3 = "locale"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f6501d
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7966e(r2)
            java.lang.String r3 = "model"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f6499b
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7966e(r2)
            java.lang.String r3 = "os"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f6498a
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7966e(r2)
            java.lang.String r3 = "platform"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f6505h
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7966e(r2)
            java.lang.String r3 = "revision"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f6509l
            java.lang.String r3 = "orientation_lock"
            r0.put(r3, r2)
            double r2 = r1.f6515r
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "tz_offset"
            r0.put(r3, r2)
            boolean r2 = r1.f6493N
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "aida"
            r0.put(r3, r2)
            int r2 = r1.f6516s
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "wvvc"
            r0.put(r3, r2)
            float r2 = r1.f6510m
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "adns"
            r0.put(r3, r2)
            int r2 = r1.f6511n
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "adnsd"
            r0.put(r3, r2)
            float r2 = r1.f6512o
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "xdpi"
            r0.put(r3, r2)
            float r2 = r1.f6513p
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "ydpi"
            r0.put(r3, r2)
            double r2 = r1.f6514q
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "screen_size_in"
            r0.put(r3, r2)
            boolean r2 = r1.f6480A
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7959a((boolean) r2)
            java.lang.String r3 = "sim"
            r0.put(r3, r2)
            boolean r2 = r1.f6481B
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7959a((boolean) r2)
            java.lang.String r3 = "gy"
            r0.put(r3, r2)
            boolean r2 = r1.f6482C
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7959a((boolean) r2)
            java.lang.String r3 = "is_tablet"
            r0.put(r3, r2)
            boolean r2 = r1.f6483D
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7959a((boolean) r2)
            java.lang.String r3 = "tv"
            r0.put(r3, r2)
            boolean r2 = r1.f6484E
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7959a((boolean) r2)
            java.lang.String r3 = "vs"
            r0.put(r3, r2)
            int r2 = r1.f6485F
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "lpm"
            r0.put(r3, r2)
            long r2 = r1.f6487H
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "fs"
            r0.put(r3, r2)
            long r2 = r1.f6488I
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "tds"
            r0.put(r3, r2)
            com.applovin.impl.sdk.k$e r2 = r1.f6489J
            long r2 = r2.f6525b
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "fm"
            r0.put(r3, r2)
            com.applovin.impl.sdk.k$e r2 = r1.f6489J
            long r2 = r2.f6524a
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "tm"
            r0.put(r3, r2)
            com.applovin.impl.sdk.k$e r2 = r1.f6489J
            long r2 = r2.f6526c
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "lmt"
            r0.put(r3, r2)
            com.applovin.impl.sdk.k$e r2 = r1.f6489J
            boolean r2 = r2.f6527d
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "lm"
            r0.put(r3, r2)
            boolean r2 = r1.f6517t
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7959a((boolean) r2)
            java.lang.String r3 = "adr"
            r0.put(r3, r2)
            int r2 = r1.f6521x
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "volume"
            r0.put(r3, r2)
            int r2 = r1.f6522y
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "sb"
            r0.put(r3, r2)
            long r2 = r1.f6519v
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "af"
            r0.put(r3, r2)
            float r2 = r1.f6520w
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "font"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f6523z
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7966e(r2)
            java.lang.String r3 = "ua"
            com.applovin.impl.sdk.utils.C2029r.m8011a((java.lang.String) r3, (java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.String>) r0)
            java.lang.String r2 = r1.f6486G
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7966e(r2)
            java.lang.String r3 = "so"
            com.applovin.impl.sdk.utils.C2029r.m8011a((java.lang.String) r3, (java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.String>) r0)
            long r2 = r1.f6496Q
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "bt_ms"
            r0.put(r3, r2)
            int r2 = r1.f6497R
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "mute_switch"
            r0.put(r3, r2)
            float r2 = r1.f6494O
            r3 = 0
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x01e4
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r4 = "da"
            r0.put(r4, r2)
        L_0x01e4:
            float r2 = r1.f6495P
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x01f3
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "dm"
            r0.put(r3, r2)
        L_0x01f3:
            com.applovin.impl.sdk.k$c r2 = r1.f6518u
            if (r2 == 0) goto L_0x020d
            int r3 = r2.f6478a
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "act"
            r0.put(r4, r3)
            int r2 = r2.f6479b
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "acm"
            r0.put(r3, r2)
        L_0x020d:
            java.lang.Boolean r2 = r1.f6490K
            if (r2 == 0) goto L_0x021a
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "huc"
            r0.put(r3, r2)
        L_0x021a:
            java.lang.Boolean r2 = r1.f6491L
            if (r2 == 0) goto L_0x0227
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "aru"
            r0.put(r3, r2)
        L_0x0227:
            java.lang.Boolean r1 = r1.f6492M
            if (r1 == 0) goto L_0x0234
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "dns"
            r0.put(r2, r1)
        L_0x0234:
            android.content.Context r1 = r5.f6463c
            android.graphics.Point r1 = com.applovin.impl.sdk.utils.C1991g.m7836a(r1)
            int r2 = r1.x
            java.lang.String r2 = java.lang.Integer.toString(r2)
            java.lang.String r3 = "dx"
            r0.put(r3, r2)
            int r1 = r1.y
            java.lang.String r1 = java.lang.Integer.toString(r1)
            java.lang.String r2 = "dy"
            r0.put(r2, r1)
            java.lang.String r1 = "accept"
            java.lang.String r2 = "custom_size,launch_app,video"
            r0.put(r1, r2)
            com.applovin.impl.sdk.j r1 = r5.f6461a
            com.applovin.impl.sdk.b.c<java.lang.String> r2 = com.applovin.impl.sdk.p050b.C1841c.f5792S
            java.lang.Object r1 = r1.mo8549a(r2)
            java.lang.String r2 = "api_did"
            r0.put(r2, r1)
            java.lang.String r1 = com.applovin.sdk.AppLovinSdk.VERSION
            java.lang.String r2 = "sdk_version"
            r0.put(r2, r1)
            r1 = 131(0x83, float:1.84E-43)
            java.lang.String r1 = java.lang.Integer.toString(r1)
            java.lang.String r2 = "build"
            r0.put(r2, r1)
            java.lang.String r1 = "format"
            java.lang.String r2 = "json"
            r0.put(r1, r2)
            com.applovin.impl.sdk.k$b r1 = r5.mo8614c()
            java.lang.String r2 = r1.f6470b
            java.lang.String r2 = com.applovin.impl.sdk.utils.C2025o.m7966e(r2)
            java.lang.String r3 = "app_version"
            r0.put(r3, r2)
            long r2 = r1.f6476h
            java.lang.String r2 = java.lang.Long.toString(r2)
            java.lang.String r3 = "ia"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f6473e
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "tg"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f6474f
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "ltg"
            r0.put(r3, r2)
            java.lang.String r2 = r1.f6472d
            java.lang.String r3 = "installer_name"
            r0.put(r3, r2)
            boolean r2 = r1.f6477i
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "test_ads"
            r0.put(r3, r2)
            boolean r1 = r1.f6475g
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "debug"
            r0.put(r2, r1)
            com.applovin.impl.sdk.j r1 = r5.f6461a
            java.lang.String r1 = r1.mo8593n()
            java.lang.String r1 = com.applovin.impl.sdk.utils.C2025o.m7966e(r1)
            java.lang.String r2 = "mediation_provider"
            com.applovin.impl.sdk.utils.C2029r.m8011a((java.lang.String) r2, (java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.String>) r0)
            com.applovin.impl.sdk.j r1 = r5.f6461a
            java.lang.String r1 = com.applovin.impl.sdk.utils.C1992h.m7861f(r1)
            java.lang.String r2 = "network"
            r0.put(r2, r1)
            com.applovin.impl.sdk.j r1 = r5.f6461a
            com.applovin.impl.sdk.b.c<java.lang.String> r2 = com.applovin.impl.sdk.p050b.C1841c.f5975dR
            java.lang.Object r1 = r1.mo8549a(r2)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "plugin_version"
            com.applovin.impl.sdk.utils.C2029r.m8011a((java.lang.String) r2, (java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.String>) r0)
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r1 = "preloading"
            r0.put(r1, r7)
            com.applovin.impl.sdk.j r7 = r5.f6461a
            boolean r7 = r7.mo8530I()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r1 = "first_install"
            r0.put(r1, r7)
            com.applovin.impl.sdk.j r7 = r5.f6461a
            boolean r7 = r7.mo8531J()
            r1 = 1
            r7 = r7 ^ r1
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r2 = "first_install_v2"
            r0.put(r2, r7)
            com.applovin.impl.sdk.j r7 = r5.f6461a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r2 = com.applovin.impl.sdk.p050b.C1841c.f6020eK
            java.lang.Object r7 = r7.mo8549a(r2)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x0337
            com.applovin.impl.sdk.j r7 = r5.f6461a
            java.lang.String r7 = r7.mo8599t()
            java.lang.String r2 = "sdk_key"
            r0.put(r2, r7)
        L_0x0337:
            com.applovin.impl.sdk.j r7 = r5.f6461a
            com.applovin.impl.sdk.b.c<java.lang.String> r2 = com.applovin.impl.sdk.p050b.C1841c.f5796W
            java.lang.Object r7 = r7.mo8549a(r2)
            java.lang.String r2 = "sc"
            r0.put(r2, r7)
            com.applovin.impl.sdk.j r7 = r5.f6461a
            com.applovin.impl.sdk.b.c<java.lang.String> r2 = com.applovin.impl.sdk.p050b.C1841c.f5797X
            java.lang.Object r7 = r7.mo8549a(r2)
            java.lang.String r2 = "sc2"
            r0.put(r2, r7)
            com.applovin.impl.sdk.j r7 = r5.f6461a
            com.applovin.impl.sdk.b.c<java.lang.String> r2 = com.applovin.impl.sdk.p050b.C1841c.f5798Y
            java.lang.Object r7 = r7.mo8549a(r2)
            java.lang.String r2 = "sc3"
            r0.put(r2, r7)
            com.applovin.impl.sdk.j r7 = r5.f6461a
            com.applovin.impl.sdk.b.c<java.lang.String> r2 = com.applovin.impl.sdk.p050b.C1841c.f5799Z
            java.lang.Object r7 = r7.mo8549a(r2)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = com.applovin.impl.sdk.utils.C2025o.m7966e(r7)
            java.lang.String r2 = "server_installed_at"
            r0.put(r2, r7)
            com.applovin.impl.sdk.j r7 = r5.f6461a
            com.applovin.impl.sdk.b.e<java.lang.String> r2 = com.applovin.impl.sdk.p050b.C1843e.f6111y
            java.lang.Object r7 = r7.mo8550a(r2)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = com.applovin.impl.sdk.utils.C2025o.m7966e(r7)
            java.lang.String r2 = "persisted_data"
            com.applovin.impl.sdk.utils.C2029r.m8011a((java.lang.String) r2, (java.lang.String) r7, (java.util.Map<java.lang.String, java.lang.String>) r0)
            android.content.Context r7 = r5.f6463c
            java.lang.String r2 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r7 = com.applovin.impl.sdk.utils.C1991g.m7838a(r2, r7)
            java.lang.String r7 = java.lang.Boolean.toString(r7)
            java.lang.String r2 = "v1"
            r0.put(r2, r7)
            java.lang.String r7 = "true"
            java.lang.String r2 = "v2"
            r0.put(r2, r7)
            java.lang.String r2 = "v3"
            r0.put(r2, r7)
            java.lang.String r2 = "v4"
            r0.put(r2, r7)
            java.lang.String r2 = "v5"
            r0.put(r2, r7)
            com.applovin.impl.sdk.j r7 = r5.f6461a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r2 = com.applovin.impl.sdk.p050b.C1841c.f6053er
            java.lang.Object r7 = r7.mo8549a(r2)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x041b
            com.applovin.impl.sdk.j r7 = r5.f6461a
            com.applovin.impl.sdk.c.h r7 = r7.mo8534M()
            com.applovin.impl.sdk.c.g r2 = com.applovin.impl.sdk.p051c.C1859g.f6187b
            long r2 = r7.mo8390b(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "li"
            r0.put(r3, r2)
            com.applovin.impl.sdk.c.g r2 = com.applovin.impl.sdk.p051c.C1859g.f6189d
            long r2 = r7.mo8390b(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "si"
            r0.put(r3, r2)
            com.applovin.impl.sdk.c.g r2 = com.applovin.impl.sdk.p051c.C1859g.f6193h
            long r2 = r7.mo8390b(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "pf"
            r0.put(r3, r2)
            com.applovin.impl.sdk.c.g r2 = com.applovin.impl.sdk.p051c.C1859g.f6200o
            long r2 = r7.mo8390b(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "mpf"
            r0.put(r3, r2)
            com.applovin.impl.sdk.c.g r2 = com.applovin.impl.sdk.p051c.C1859g.f6194i
            long r2 = r7.mo8390b(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "gpf"
            r0.put(r3, r2)
            com.applovin.impl.sdk.c.g r2 = com.applovin.impl.sdk.p051c.C1859g.f6198m
            long r2 = r7.mo8390b(r2)
            java.lang.String r7 = java.lang.String.valueOf(r2)
            java.lang.String r2 = "asoac"
            r0.put(r2, r7)
        L_0x041b:
            android.content.Context r7 = r5.f6463c
            java.lang.String r7 = r7.getPackageName()
            java.lang.String r7 = com.applovin.impl.sdk.utils.C2025o.m7967f(r7)
            java.lang.String r2 = "vz"
            r0.put(r2, r7)
            if (r8 == 0) goto L_0x044f
            java.util.concurrent.atomic.AtomicReference<com.applovin.impl.sdk.k$a> r7 = r5.f6465g
            java.lang.Object r7 = r7.get()
            com.applovin.impl.sdk.k$a r7 = (com.applovin.impl.sdk.C1945k.C1947a) r7
            if (r7 == 0) goto L_0x043a
            r5.mo8616e()
            goto L_0x0459
        L_0x043a:
            boolean r7 = com.applovin.impl.sdk.utils.C2029r.m8028b()
            if (r7 == 0) goto L_0x044f
            com.applovin.impl.sdk.k$a r7 = new com.applovin.impl.sdk.k$a
            r7.<init>()
            java.lang.String r8 = java.lang.Boolean.toString(r1)
            java.lang.String r1 = "inc"
            r0.put(r1, r8)
            goto L_0x0459
        L_0x044f:
            com.applovin.impl.sdk.j r7 = r5.f6461a
            com.applovin.impl.sdk.k r7 = r7.mo8536O()
            com.applovin.impl.sdk.k$a r7 = r7.mo8615d()
        L_0x0459:
            java.lang.String r8 = r7.f6468b
            boolean r1 = com.applovin.impl.sdk.utils.C2025o.m7963b(r8)
            if (r1 == 0) goto L_0x0466
            java.lang.String r1 = "idfa"
            r0.put(r1, r8)
        L_0x0466:
            boolean r7 = r7.f6467a
            java.lang.String r7 = java.lang.Boolean.toString(r7)
            java.lang.String r8 = "dnt"
            r0.put(r8, r7)
            com.applovin.impl.sdk.j r7 = r5.f6461a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r8 = com.applovin.impl.sdk.p050b.C1841c.f5968dK
            java.lang.Object r7 = r7.mo8549a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x048c
            com.applovin.impl.sdk.j r7 = r5.f6461a
            java.lang.String r7 = r7.mo8588i()
            java.lang.String r8 = "cuid"
            com.applovin.impl.sdk.utils.C2029r.m8011a((java.lang.String) r8, (java.lang.String) r7, (java.util.Map<java.lang.String, java.lang.String>) r0)
        L_0x048c:
            com.applovin.impl.sdk.j r7 = r5.f6461a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r8 = com.applovin.impl.sdk.p050b.C1841c.f5971dN
            java.lang.Object r7 = r7.mo8549a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x04a7
            com.applovin.impl.sdk.j r7 = r5.f6461a
            java.lang.String r7 = r7.mo8589j()
            java.lang.String r8 = "compass_random_token"
            r0.put(r8, r7)
        L_0x04a7:
            com.applovin.impl.sdk.j r7 = r5.f6461a
            com.applovin.impl.sdk.b.c<java.lang.Boolean> r8 = com.applovin.impl.sdk.p050b.C1841c.f5973dP
            java.lang.Object r7 = r7.mo8549a(r8)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x04c2
            com.applovin.impl.sdk.j r7 = r5.f6461a
            java.lang.String r7 = r7.mo8590k()
            java.lang.String r8 = "applovin_random_token"
            r0.put(r8, r7)
        L_0x04c2:
            if (r6 == 0) goto L_0x04c7
            r0.putAll(r6)
        L_0x04c7:
            java.util.UUID r6 = java.util.UUID.randomUUID()
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "rid"
            r0.put(r7, r6)
            com.applovin.impl.sdk.j r6 = r5.f6461a
            com.applovin.impl.sdk.network.a r6 = r6.mo8532K()
            com.applovin.impl.sdk.network.a$b r6 = r6.mo8632a()
            if (r6 == 0) goto L_0x0510
            long r7 = r6.mo8636a()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = "lrm_ts_ms"
            r0.put(r8, r7)
            java.lang.String r7 = r6.mo8637b()
            java.lang.String r8 = "lrm_url"
            r0.put(r8, r7)
            long r7 = r6.mo8639d()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = "lrm_ct_ms"
            r0.put(r8, r7)
            long r6 = r6.mo8638c()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r7 = "lrm_rs"
            r0.put(r7, r6)
        L_0x0510:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1945k.mo8612a(java.util.Map, boolean, boolean):java.util.Map");
    }

    /* renamed from: b */
    public C1950d mo8613b() {
        C1950d dVar;
        TelephonyManager telephonyManager;
        Class<C1950d> cls = C1950d.class;
        Object obj = this.f6464d.get(cls);
        if (obj != null) {
            dVar = (C1950d) obj;
        } else {
            dVar = new C1950d();
            dVar.f6508k = Locale.getDefault();
            dVar.f6501d = Build.MODEL;
            dVar.f6499b = Build.VERSION.RELEASE;
            dVar.f6498a = "android";
            dVar.f6502e = Build.MANUFACTURER;
            dVar.f6503f = Build.BRAND;
            dVar.f6504g = Build.HARDWARE;
            dVar.f6500c = Build.VERSION.SDK_INT;
            dVar.f6505h = Build.DEVICE;
            dVar.f6515r = m7551n();
            dVar.f6480A = m7556s();
            dVar.f6493N = m7546i();
            SensorManager sensorManager = (SensorManager) this.f6463c.getSystemService("sensor");
            if (sensorManager != null) {
                dVar.f6481B = sensorManager.getDefaultSensor(4) != null;
            }
            if (m7541b("android.permission.READ_PHONE_STATE") && (telephonyManager = (TelephonyManager) this.f6463c.getSystemService(PlaceFields.PHONE)) != null) {
                dVar.f6506i = telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH);
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                try {
                    dVar.f6507j = URLEncoder.encode(networkOperatorName, C4250c.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException unused) {
                    dVar.f6507j = networkOperatorName;
                }
            }
            DisplayMetrics displayMetrics = this.f6463c.getResources().getDisplayMetrics();
            dVar.f6510m = displayMetrics.density;
            dVar.f6511n = displayMetrics.densityDpi;
            dVar.f6512o = displayMetrics.xdpi;
            dVar.f6513p = displayMetrics.ydpi;
            Point a = C1991g.m7836a(this.f6463c);
            double sqrt = Math.sqrt(Math.pow((double) a.x, 2.0d) + Math.pow((double) a.y, 2.0d));
            double d = (double) dVar.f6512o;
            Double.isNaN(d);
            dVar.f6514q = sqrt / d;
            if (((Boolean) this.f6461a.mo8549a(C1841c.f5983dZ)).booleanValue()) {
                dVar.f6519v = m7548k();
            }
            if (((Boolean) this.f6461a.mo8549a(C1841c.f6036ea)).booleanValue()) {
                dVar.f6520w = m7549l();
            }
            dVar.f6496Q = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            this.f6464d.put(cls, dVar);
        }
        return m7536a(dVar);
    }

    /* renamed from: c */
    public C1948b mo8614c() {
        PackageInfo packageInfo;
        Class<C1948b> cls = C1948b.class;
        Object obj = this.f6464d.get(cls);
        if (obj != null) {
            return (C1948b) obj;
        }
        ApplicationInfo applicationInfo = this.f6463c.getApplicationInfo();
        long lastModified = new File(applicationInfo.sourceDir).lastModified();
        PackageManager packageManager = this.f6463c.getPackageManager();
        String str = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.f6463c.getPackageName(), 0);
            try {
                str = packageManager.getInstallerPackageName(applicationInfo.packageName);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            packageInfo = null;
        }
        C1948b bVar = new C1948b();
        bVar.f6471c = applicationInfo.packageName;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        bVar.f6472d = str;
        bVar.f6476h = lastModified;
        bVar.f6469a = String.valueOf(packageManager.getApplicationLabel(applicationInfo));
        if (packageInfo != null) {
            str2 = packageInfo.versionName;
        }
        bVar.f6470b = str2;
        bVar.f6473e = C2029r.m7996a(C1843e.f6093g, this.f6461a);
        bVar.f6474f = C2029r.m7996a(C1843e.f6094h, this.f6461a);
        bVar.f6475g = C2029r.m8029b(this.f6461a);
        this.f6464d.put(cls, bVar);
        return bVar;
    }

    /* renamed from: d */
    public C1947a mo8615d() {
        C1947a h = m7545h();
        if (!((Boolean) this.f6461a.mo8549a(C1841c.f5967dJ)).booleanValue()) {
            h = new C1947a();
        } else if (h.f6467a && !((Boolean) this.f6461a.mo8549a(C1841c.f5966dI)).booleanValue()) {
            h.f6468b = "";
        }
        mo8614c().f6477i = C2025o.m7963b(h.f6468b) ? this.f6461a.mo8591l().getTestDeviceAdvertisingIds().contains(h.f6468b) : false;
        return h;
    }

    /* renamed from: e */
    public void mo8616e() {
        this.f6461a.mo8533L().mo8475a((C1864a) new C1888i(this.f6461a, new C1888i.C1889a() {
            /* renamed from: a */
            public void mo8046a(C1947a aVar) {
                C1945k.this.f6465g.set(aVar);
            }
        }), C1907s.C1909a.ADVERTISING_INFO_COLLECTION);
    }
}
