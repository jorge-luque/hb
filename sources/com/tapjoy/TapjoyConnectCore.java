package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.places.model.PlaceFields;
import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.C3145gz;
import com.tapjoy.internal.C3149hc;
import com.tapjoy.internal.C3166jq;
import com.tapjoy.internal.C4889al;
import com.tapjoy.internal.C5038eu;
import com.tapjoy.internal.C5056fa;
import com.tapjoy.internal.C5059fb;
import com.tapjoy.internal.C5077fh;
import com.tapjoy.internal.C5090fo;
import com.tapjoy.internal.C5096fs;
import com.tapjoy.internal.C5106ga;
import com.tapjoy.internal.C5119ge;
import com.tapjoy.internal.C5162hn;
import com.tapjoy.internal.C5271v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.w3c.dom.Document;

public class TapjoyConnectCore {

    /* renamed from: A */
    private static float f13160A = 1.0f;

    /* renamed from: B */
    private static int f13161B = 1;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public static String f13162C = "";

    /* renamed from: D */
    private static String f13163D = "";
    public static final float DEFAULT_CURRENCY_MULTIPLIER = 1.0f;

    /* renamed from: E */
    private static String f13164E = "";

    /* renamed from: F */
    private static String f13165F = "";

    /* renamed from: G */
    private static String f13166G = "";

    /* renamed from: H */
    private static String f13167H = "";

    /* renamed from: I */
    private static String f13168I = "";

    /* renamed from: J */
    private static String f13169J = "";

    /* renamed from: K */
    private static String f13170K = "";

    /* renamed from: L */
    private static String f13171L = "";

    /* renamed from: M */
    private static String f13172M = "";

    /* renamed from: N */
    private static String f13173N = "";

    /* renamed from: O */
    private static String f13174O = "native";

    /* renamed from: P */
    private static String f13175P = "";

    /* renamed from: Q */
    private static String f13176Q = "";

    /* renamed from: R */
    private static float f13177R = 1.0f;

    /* renamed from: S */
    private static boolean f13178S = false;

    /* renamed from: T */
    private static String f13179T = "";

    /* renamed from: U */
    private static String f13180U = "";

    /* renamed from: V */
    private static String f13181V = "";

    /* renamed from: W */
    private static String f13182W = "";

    /* renamed from: X */
    private static String f13183X = null;

    /* renamed from: a */
    protected static int f13184a = 0;

    /* renamed from: aA */
    private static Integer f13185aA;

    /* renamed from: aB */
    private static Long f13186aB;

    /* renamed from: aC */
    private static Long f13187aC;

    /* renamed from: aD */
    private static Long f13188aD;

    /* renamed from: aE */
    private static String f13189aE;

    /* renamed from: aF */
    private static Integer f13190aF;

    /* renamed from: aG */
    private static Double f13191aG;

    /* renamed from: aH */
    private static Double f13192aH;

    /* renamed from: aI */
    private static Long f13193aI;

    /* renamed from: aJ */
    private static Integer f13194aJ;

    /* renamed from: aK */
    private static Integer f13195aK;

    /* renamed from: aL */
    private static Integer f13196aL;

    /* renamed from: aM */
    private static String f13197aM;

    /* renamed from: aN */
    private static String f13198aN;

    /* renamed from: aO */
    private static String f13199aO;

    /* renamed from: aP */
    private static String f13200aP = "";

    /* renamed from: aQ */
    private static String f13201aQ = "";

    /* renamed from: aR */
    private static String f13202aR = "";

    /* renamed from: aS */
    private static boolean f13203aS = false;

    /* renamed from: aT */
    private static TJConnectListener f13204aT = null;

    /* renamed from: aU */
    private static boolean f13205aU = false;

    /* renamed from: aa */
    private static long f13206aa = 0;

    /* renamed from: ac */
    private static boolean f13207ac;

    /* renamed from: ad */
    private static PackageManager f13208ad;

    /* renamed from: ae */
    private static TapjoyGpsHelper f13209ae;

    /* renamed from: af */
    private static Hashtable f13210af = TapjoyConnectFlag.CONNECT_FLAG_DEFAULTS;

    /* renamed from: ag */
    private static Map f13211ag = new ConcurrentHashMap();

    /* renamed from: ah */
    private static String f13212ah;

    /* renamed from: ai */
    private static String f13213ai;

    /* renamed from: aj */
    private static String f13214aj;

    /* renamed from: ak */
    private static String f13215ak;

    /* renamed from: al */
    private static Integer f13216al;

    /* renamed from: am */
    private static String f13217am;

    /* renamed from: an */
    private static String f13218an;

    /* renamed from: ao */
    private static Long f13219ao;

    /* renamed from: ap */
    private static String f13220ap;

    /* renamed from: aq */
    private static Integer f13221aq;

    /* renamed from: ar */
    private static Integer f13222ar;

    /* renamed from: as */
    private static String f13223as;

    /* renamed from: at */
    private static String f13224at;

    /* renamed from: au */
    private static String f13225au;

    /* renamed from: av */
    private static String f13226av;

    /* renamed from: aw */
    private static String f13227aw;

    /* renamed from: ax */
    private static Set f13228ax;

    /* renamed from: ay */
    private static Integer f13229ay;

    /* renamed from: az */
    private static Integer f13230az;

    /* renamed from: b */
    protected static int f13231b = 0;

    /* renamed from: c */
    protected static String f13232c = "";

    /* renamed from: d */
    protected static boolean f13233d;

    /* renamed from: e */
    protected static String f13234e = "";

    /* renamed from: f */
    protected static String f13235f = "";

    /* renamed from: g */
    private static Context f13236g;

    /* renamed from: h */
    private static String f13237h;

    /* renamed from: i */
    private static TapjoyConnectCore f13238i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static TapjoyURLConnection f13239j;

    /* renamed from: k */
    private static TJConnectListener f13240k;

    /* renamed from: l */
    private static TJSetUserIDListener f13241l;

    /* renamed from: m */
    private static Vector f13242m = new Vector(Arrays.asList(TapjoyConstants.dependencyClassNames));

    /* renamed from: n */
    private static String f13243n = "";

    /* renamed from: o */
    private static String f13244o = "";

    /* renamed from: p */
    private static String f13245p = "";

    /* renamed from: q */
    private static String f13246q = "";

    /* renamed from: r */
    private static String f13247r = "";

    /* renamed from: s */
    private static String f13248s = "";

    /* renamed from: t */
    private static String f13249t = "";

    /* renamed from: u */
    private static String f13250u = "";

    /* renamed from: v */
    private static String f13251v = "";

    /* renamed from: w */
    private static String f13252w = "";

    /* renamed from: x */
    private static String f13253x = "";

    /* renamed from: y */
    private static String f13254y = "";

    /* renamed from: z */
    private static int f13255z = 1;

    /* renamed from: Y */
    private long f13256Y = 0;

    /* renamed from: Z */
    private boolean f13257Z = false;

    /* renamed from: ab */
    private boolean f13258ab = false;

    public class PPAThread implements Runnable {

        /* renamed from: b */
        private Map f13262b;

        public PPAThread(Map map) {
            this.f13262b = map;
        }

        public void run() {
            TapjoyURLConnection c = TapjoyConnectCore.f13239j;
            String str = c.getResponseFromURL(TapjoyConnectCore.getHostURL() + TapjoyConstants.TJC_CONNECT_URL_PATH, (Map) null, (Map) null, this.f13262b).response;
            if (str != null) {
                boolean unused = TapjoyConnectCore.m16630d(str);
            }
        }
    }

    /* renamed from: a */
    private static boolean m16621a(Context context) {
        WifiInfo connectionInfo;
        f13236g = context;
        f13208ad = context.getPackageManager();
        C5119ge.m17262a().mo31297a(context);
        C5106ga.m17238a().mo31279a(context);
        f13209ae = new TapjoyGpsHelper(f13236g);
        if (f13239j == null) {
            f13239j = new TapjoyURLConnection();
        }
        if (f13210af == null) {
            f13210af = new Hashtable();
        }
        m16637j();
        int identifier = f13236g.getResources().getIdentifier("raw/tapjoy_config", (String) null, f13236g.getPackageName());
        Properties properties = new Properties();
        try {
            properties.load(f13236g.getResources().openRawResource(identifier));
            m16619a(properties);
        } catch (Exception unused) {
        }
        if (C3166jq.m10436c(getConnectFlagValue("unit_test_mode"))) {
            m16638k();
        }
        String string = Settings.Secure.getString(f13236g.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
        f13243n = string;
        if (string != null) {
            f13243n = string.toLowerCase();
        }
        try {
            boolean z = false;
            f13252w = f13208ad.getPackageInfo(f13236g.getPackageName(), 0).versionName;
            f13249t = "android";
            f13164E = "android";
            f13247r = Build.MODEL;
            f13248s = Build.MANUFACTURER;
            f13250u = Build.VERSION.RELEASE;
            f13253x = "12.6.0";
            f13254y = TapjoyConstants.TJC_BRIDGE_VERSION_NUMBER;
            try {
                if (Build.VERSION.SDK_INT > 3) {
                    TapjoyDisplayMetricsUtil tapjoyDisplayMetricsUtil = new TapjoyDisplayMetricsUtil(f13236g);
                    f13255z = tapjoyDisplayMetricsUtil.getScreenDensityDPI();
                    f13160A = tapjoyDisplayMetricsUtil.getScreenDensityScale();
                    f13161B = tapjoyDisplayMetricsUtil.getScreenLayoutSize();
                }
            } catch (Exception e) {
                TapjoyLog.m16651e("TapjoyConnect", "Error getting screen density/dimensions/layout: " + e.toString());
            }
            if (m16632e("android.permission.ACCESS_WIFI_STATE")) {
                try {
                    WifiManager wifiManager = (WifiManager) f13236g.getSystemService(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI);
                    if (!(wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null)) {
                        String macAddress = connectionInfo.getMacAddress();
                        f13245p = macAddress;
                        if (macAddress != null) {
                            f13245p = macAddress.replace(":", "").toLowerCase();
                        }
                    }
                } catch (Exception e2) {
                    TapjoyLog.m16651e("TapjoyConnect", "Error getting device mac address: " + e2.toString());
                }
            } else {
                TapjoyLog.m16649d("TapjoyConnect", "*** ignore macAddress");
            }
            TelephonyManager telephonyManager = (TelephonyManager) f13236g.getSystemService(PlaceFields.PHONE);
            if (telephonyManager != null) {
                f13165F = telephonyManager.getNetworkOperatorName();
                f13166G = telephonyManager.getNetworkCountryIso();
                String networkOperator = telephonyManager.getNetworkOperator();
                if (networkOperator != null && (networkOperator.length() == 5 || networkOperator.length() == 6)) {
                    f13167H = networkOperator.substring(0, 3);
                    f13168I = networkOperator.substring(3);
                }
            }
            SharedPreferences sharedPreferences = f13236g.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
            String string2 = sharedPreferences.getString(TapjoyConstants.PREF_INSTALL_ID, "");
            f13246q = string2;
            if (string2 == null || string2.length() == 0) {
                try {
                    f13246q = TapjoyUtil.SHA256(UUID.randomUUID().toString() + System.currentTimeMillis());
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(TapjoyConstants.PREF_INSTALL_ID, f13246q);
                    edit.apply();
                } catch (Exception e3) {
                    TapjoyLog.m16651e("TapjoyConnect", "Error generating install id: " + e3.toString());
                }
            }
            if (getConnectFlagValue(TapjoyConnectFlag.STORE_NAME) != null && getConnectFlagValue(TapjoyConnectFlag.STORE_NAME).length() > 0) {
                f13171L = getConnectFlagValue(TapjoyConnectFlag.STORE_NAME);
                if (!new ArrayList(Arrays.asList(TapjoyConnectFlag.STORE_ARRAY)).contains(f13171L)) {
                    TapjoyLog.m16654w("TapjoyConnect", "Warning -- undefined STORE_NAME: " + f13171L);
                }
            }
            try {
                String str = f13171L;
                Intent intent = new Intent("android.intent.action.VIEW");
                if (str.length() <= 0) {
                    intent.setData(Uri.parse("market://details"));
                    if (f13208ad.queryIntentActivities(intent, 0).size() > 0) {
                        z = true;
                    }
                }
                f13178S = z;
            } catch (Exception e4) {
                TapjoyLog.m16651e("TapjoyConnect", "Error trying to detect store intent on devicee: " + e4.toString());
            }
            m16635h();
            if (getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK) != null && getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK).length() > 0) {
                f13235f = getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK);
            }
            if (getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK) != null && getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK).length() > 0) {
                f13234e = getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK);
            }
            if (getConnectFlagValue(TapjoyConnectFlag.USER_ID) != null && getConnectFlagValue(TapjoyConnectFlag.USER_ID).length() > 0) {
                TapjoyLog.m16652i("TapjoyConnect", "Setting userID to: " + getConnectFlagValue(TapjoyConnectFlag.USER_ID));
                setUserID(getConnectFlagValue(TapjoyConnectFlag.USER_ID), (TJSetUserIDListener) null);
            }
            f13176Q = TapjoyUtil.getRedirectDomain(getConnectFlagValue(TapjoyConnectFlag.SERVICE_URL));
            if (f13210af != null) {
                m16636i();
            }
            return true;
        } catch (PackageManager.NameNotFoundException e5) {
            throw new TapjoyException(e5.getMessage());
        }
    }

    /* renamed from: d */
    private static void m16629d() {
        if (!C3166jq.m10436c(f13173N)) {
            C3145gz.m10321a().mo18544a(f13236g, f13237h, "12.6.0", TapjoyConfig.TJC_ANALYTICS_SERVICE_URL, f13173N, f13172M);
        }
        TJConnectListener tJConnectListener = f13240k;
        if (tJConnectListener != null) {
            tJConnectListener.onConnectFailure();
        }
    }

    /* renamed from: e */
    private static void m16631e() {
        TJConnectListener tJConnectListener = f13204aT;
        if (tJConnectListener != null) {
            tJConnectListener.onConnectFailure();
        }
    }

    /* renamed from: f */
    private static Map m16633f() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_PLUGIN, f13174O, true);
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_SDK_TYPE, f13175P, true);
        TapjoyUtil.safePut(hashMap3, "app_id", f13251v, true);
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_LIBRARY_VERSION, f13253x, true);
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_LIBRARY_REVISION, TapjoyRevision.GIT_REVISION, true);
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_BRIDGE_VERSION, f13254y, true);
        TapjoyUtil.safePut(hashMap3, TapjoyConstants.TJC_APP_VERSION_NAME, f13252w, true);
        hashMap2.putAll(hashMap3);
        HashMap hashMap4 = new HashMap();
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_NAME, f13247r, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_PLATFORM, f13164E, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, f13250u, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_MANUFACTURER, f13248s, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_TYPE_NAME, f13249t, true);
        StringBuilder sb = new StringBuilder();
        sb.append(f13161B);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_SCREEN_LAYOUT_SIZE, sb.toString(), true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_STORE_NAME, f13171L, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_STORE_VIEW, String.valueOf(f13178S), true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_CARRIER_NAME, f13165F, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_CARRIER_COUNTRY_CODE, f13166G, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_MOBILE_NETWORK_CODE, f13168I, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_MOBILE_COUNTRY_CODE, f13167H, true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, Locale.getDefault().getCountry(), true);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_LANGUAGE, Locale.getDefault().getLanguage(), true);
        String connectionType = getConnectionType();
        f13169J = connectionType;
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_CONNECTION_TYPE, connectionType, true);
        String connectionSubType = getConnectionSubType();
        f13170K = connectionSubType;
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_CONNECTION_SUBTYPE, connectionSubType, true);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f13255z);
        TapjoyUtil.safePut(hashMap4, TapjoyConstants.TJC_DEVICE_SCREEN_DENSITY, sb2.toString(), true);
        hashMap2.putAll(hashMap4);
        HashMap hashMap5 = new HashMap();
        if (m16640m()) {
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_ADVERTISING_ID, f13232c, true);
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_AD_TRACKING_ENABLED, String.valueOf(f13233d), true);
        }
        if ((m16641n() && !m16640m()) || !m16642o()) {
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_ANDROID_ID, f13243n, true);
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_DEVICE_MAC_ADDRESS, f13245p, true);
        }
        TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_INSTALL_ID, f13246q, true);
        TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_USER_ID, f13162C, true);
        TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_ADVERTISING_ID_CHECK_DISABLED, f13234e, true);
        TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_LEGACY_ID_FALLBACK_ALLOWED, f13235f, true);
        int i = f13184a;
        if (i != 0) {
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_PACKAGED_GOOGLE_PLAY_SERVICES_VERSION, Integer.toString(i), true);
        }
        int i2 = f13231b;
        if (i2 != 0) {
            TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_DEVICE_GOOGLE_PLAY_SERVICES_VERSION, Integer.toString(i2), true);
        }
        String str = f13244o;
        if (str == null || str.length() == 0 || System.currentTimeMillis() - f13206aa > TapjoyConstants.SESSION_ID_INACTIVITY_TIME) {
            f13244o = m16643p();
        } else {
            f13206aa = System.currentTimeMillis();
        }
        TapjoyUtil.safePut(hashMap5, TapjoyConstants.TJC_SESSION_ID, f13244o, true);
        hashMap2.putAll(hashMap5);
        HashMap hashMap6 = new HashMap();
        TapjoyUtil.safePut(hashMap6, TapjoyConstants.TJC_APP_GROUP_ID, f13179T, true);
        TapjoyUtil.safePut(hashMap6, "store", f13180U, true);
        TapjoyUtil.safePut(hashMap6, TapjoyConstants.TJC_ANALYTICS_API_KEY, f13181V, true);
        TapjoyUtil.safePut(hashMap6, TapjoyConstants.TJC_MANAGED_DEVICE_ID, f13182W, true);
        hashMap2.putAll(hashMap6);
        C5119ge a = C5119ge.m17262a();
        HashMap hashMap7 = new HashMap();
        Boolean bool = a.f14009a;
        String str2 = "1";
        if (bool != null) {
            TapjoyUtil.safePut(hashMap7, "gdpr", bool.booleanValue() ? str2 : AppEventsConstants.EVENT_PARAM_VALUE_NO, true);
        }
        if (!C4889al.m16672a(a.f14010b)) {
            TapjoyUtil.safePut(hashMap7, "cgdpr", a.f14010b, true);
        }
        Boolean bool2 = a.f14011c;
        if (bool2 != null) {
            if (!bool2.booleanValue()) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            TapjoyUtil.safePut(hashMap7, "below_consent_age", str2, true);
        }
        if (!C4889al.m16672a(a.f14012d)) {
            TapjoyUtil.safePut(hashMap7, "us_privacy", a.f14012d, true);
        }
        hashMap2.putAll(hashMap7);
        if (!(TapjoyCache.getInstance() == null || TapjoyCache.getInstance().getCachedOfferIDs() == null || TapjoyCache.getInstance().getCachedOfferIDs().length() <= 0)) {
            TapjoyUtil.safePut(hashMap2, TapjoyConstants.TJC_CACHED_OFFERS, TapjoyCache.getInstance().getCachedOfferIDs(), true);
        }
        TapjoyUtil.safePut(hashMap2, TapjoyConstants.TJC_CURRENCY_MULTIPLIER, Float.toString(f13177R), true);
        hashMap.putAll(hashMap2);
        HashMap hashMap8 = new HashMap();
        m16635h();
        HashMap hashMap9 = new HashMap();
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_ANALYTICS_ID, f13212ah, true);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_PACKAGE_ID, f13213ai, true);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_PACKAGE_SIGN, f13214aj, true);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_DEVICE_DISPLAY_DENSITY, f13194aJ);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_DEVICE_DISPLAY_WIDTH, f13195aK);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_DEVICE_DISPLAY_HEIGHT, f13196aL);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_DEVICE_COUNTRY_SIM, f13197aM, true);
        TapjoyUtil.safePut(hashMap9, TapjoyConstants.TJC_DEVICE_TIMEZONE, f13198aN, true);
        hashMap8.putAll(hashMap9);
        HashMap hashMap10 = new HashMap();
        TapjoyUtil.safePut(hashMap10, TapjoyConstants.TJC_PACKAGE_VERSION, f13215ak, true);
        TapjoyUtil.safePut(hashMap10, TapjoyConstants.TJC_PACKAGE_REVISION, f13216al);
        TapjoyUtil.safePut(hashMap10, TapjoyConstants.TJC_PACKAGE_DATA_VERSION, f13217am, true);
        TapjoyUtil.safePut(hashMap10, TapjoyConstants.TJC_INSTALLER, f13218an, true);
        if (C3166jq.m10436c(f13171L)) {
            TapjoyUtil.safePut(hashMap10, TapjoyConstants.TJC_STORE_NAME, f13199aO, true);
        }
        hashMap8.putAll(hashMap10);
        hashMap8.putAll(m16634g());
        hashMap.putAll(hashMap8);
        return hashMap;
    }

    /* renamed from: g */
    private static Map m16634g() {
        HashMap hashMap = new HashMap();
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_INSTALLED, f13219ao);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_REFERRER, f13220ap, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_LEVEL, f13221aq);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_FRIEND_COUNT, f13222ar);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_VARIABLE_1, f13223as, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_VARIABLE_2, f13224at, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_VARIABLE_3, f13225au, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_VARIABLE_4, f13226av, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_VARIABLE_5, f13227aw, true);
        int i = 0;
        for (String safePut : f13228ax) {
            StringBuilder sb = new StringBuilder("user_tags[");
            int i2 = i + 1;
            sb.append(i);
            sb.append("]");
            TapjoyUtil.safePut(hashMap, sb.toString(), safePut, true);
            i = i2;
        }
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_WEEKLY_FREQUENCY, f13229ay);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_USER_MONTHLY_FREQUENCY, f13230az);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_SESSION_TOTAL_COUNT, f13185aA);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_SESSION_TOTAL_LENGTH, f13186aB);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_SESSION_LAST_AT, f13187aC);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_SESSION_LAST_LENGTH, f13188aD);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_PURCHASE_CURRENCY, f13189aE, true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_PURCHASE_TOTAL_COUNT, f13190aF);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_PURCHASE_TOTAL_PRICE, f13191aG);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_PURCHASE_LAST_PRICE, f13192aH);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_PURCHASE_LAST_AT, f13193aI);
        return hashMap;
    }

    public static String getAndroidID() {
        return f13243n;
    }

    public static String getAppID() {
        return f13251v;
    }

    public static String getAwardCurrencyVerifier(long j, int i, String str) {
        try {
            return TapjoyUtil.SHA256(f13251v + ":" + m16644q() + ":" + j + ":" + f13172M + ":" + i + ":" + str);
        } catch (Exception e) {
            TapjoyErrorMessage.ErrorType errorType = TapjoyErrorMessage.ErrorType.SDK_ERROR;
            TapjoyLog.m16650e("TapjoyConnect", new TapjoyErrorMessage(errorType, "Error in computing awardCurrencyVerifier -- " + e.toString()));
            return "";
        }
    }

    public static String getCarrierName() {
        return f13165F;
    }

    public static String getConnectFlagValue(String str) {
        Hashtable hashtable = f13210af;
        return (hashtable == null || hashtable.get(str) == null) ? "" : f13210af.get(str).toString();
    }

    public static String getConnectURL() {
        return TapjoyConfig.TJC_CONNECT_SERVICE_URL;
    }

    public static String getConnectionSubType() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) f13236g.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "";
            }
            String subtypeName = connectivityManager.getActiveNetworkInfo().getSubtypeName();
            TapjoyLog.m16649d("TapjoyConnect", "connection_sub_type: " + subtypeName);
            return subtypeName;
        } catch (Exception e) {
            TapjoyLog.m16651e("TapjoyConnect", "getConnectionSubType error: " + e.toString());
            return "";
        }
    }

    public static String getConnectionType() {
        String str = "";
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) f13236g.getSystemService("connectivity");
            if (!(connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null)) {
                int type = connectivityManager.getActiveNetworkInfo().getType();
                str = (type == 1 || type == 6) ? TapjoyConstants.TJC_CONNECTION_TYPE_WIFI : TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE;
                TapjoyLog.m16649d("TapjoyConnect", "connectivity: " + connectivityManager.getActiveNetworkInfo().getType());
                TapjoyLog.m16649d("TapjoyConnect", "connection_type: " + str);
            }
        } catch (Exception e) {
            TapjoyLog.m16651e("TapjoyConnect", "getConnectionType error: " + e.toString());
        }
        return str;
    }

    public static Context getContext() {
        return f13236g;
    }

    public static String getCustomParameter() {
        return f13163D;
    }

    public static float getDeviceScreenDensityScale() {
        return f13160A;
    }

    public static Map getGenericURLParams() {
        Map f = m16633f();
        TapjoyUtil.safePut(f, "app_id", f13251v, true);
        return f;
    }

    public static String getHostURL() {
        return getConnectFlagValue(TapjoyConnectFlag.SERVICE_URL);
    }

    public static TapjoyConnectCore getInstance() {
        return f13238i;
    }

    public static String getLimitedAppID() {
        return f13200aP;
    }

    public static Map getLimitedGenericURLParams() {
        Map f = m16633f();
        TapjoyUtil.safePut(f, "app_id", f13200aP, true);
        TapjoyUtil.safePut(f, TapjoyConstants.TJC_APP_GROUP_ID, f13202aR, true);
        TapjoyUtil.safePut(f, TapjoyConstants.TJC_LIMITED, "true", true);
        return f;
    }

    public static Map getLimitedTimeStampAndVerifierParams() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String b = m16625b(currentTimeMillis);
        HashMap hashMap = new HashMap();
        TapjoyUtil.safePut(hashMap, "timestamp", String.valueOf(currentTimeMillis), true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_VERIFIER, b, true);
        return hashMap;
    }

    public static Map getLimitedURLParams() {
        Map limitedGenericURLParams = getLimitedGenericURLParams();
        limitedGenericURLParams.putAll(getLimitedTimeStampAndVerifierParams());
        return limitedGenericURLParams;
    }

    public static String getMacAddress() {
        return f13245p;
    }

    public static String getPlacementURL() {
        return getConnectFlagValue(TapjoyConnectFlag.PLACEMENT_URL);
    }

    public static String getRedirectDomain() {
        return f13176Q;
    }

    public static String getSecretKey() {
        return f13172M;
    }

    public static String getSha1MacAddress() {
        try {
            return TapjoyUtil.SHA1(f13245p);
        } catch (Exception e) {
            TapjoyLog.m16651e("TapjoyConnect", "Error generating sha1 of macAddress: " + e.toString());
            return null;
        }
    }

    public static String getSupportURL(String str) {
        if (str == null) {
            str = f13251v;
        }
        return getHostURL() + "support_requests/new?currency_id=" + str + "&app_id=" + f13251v + "&udid=" + f13182W + "&language_code=" + Locale.getDefault().getLanguage();
    }

    public static Map getTimeStampAndVerifierParams() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String a = m16616a(currentTimeMillis);
        HashMap hashMap = new HashMap();
        TapjoyUtil.safePut(hashMap, "timestamp", String.valueOf(currentTimeMillis), true);
        TapjoyUtil.safePut(hashMap, TapjoyConstants.TJC_VERIFIER, a, true);
        return hashMap;
    }

    public static Map getURLParams() {
        Map genericURLParams = getGenericURLParams();
        genericURLParams.putAll(getTimeStampAndVerifierParams());
        return genericURLParams;
    }

    public static String getUserID() {
        return f13162C;
    }

    public static String getUserToken() {
        if (C3166jq.m10436c(f13162C)) {
            return f13182W;
        }
        return f13182W + ":" + f13162C;
    }

    /* renamed from: h */
    private static void m16635h() {
        C5059fb a = C3145gz.m10322a(f13236g).mo18543a(true);
        C5056fa faVar = a.f13785d;
        f13212ah = faVar.f13749h;
        f13213ai = faVar.f13759r;
        f13214aj = faVar.f13760s;
        f13194aJ = faVar.f13754m;
        f13195aK = faVar.f13755n;
        f13196aL = faVar.f13756o;
        f13197aM = faVar.f13762u;
        f13198aN = faVar.f13758q;
        C5038eu euVar = a.f13786e;
        f13215ak = euVar.f13647e;
        f13216al = euVar.f13648f;
        f13217am = euVar.f13649g;
        f13218an = euVar.f13650h;
        f13199aO = euVar.f13651i;
        C5077fh fhVar = a.f13787f;
        f13219ao = fhVar.f13880s;
        f13220ap = fhVar.f13881t;
        f13221aq = fhVar.f13871J;
        f13222ar = fhVar.f13872K;
        f13223as = fhVar.f13873L;
        f13224at = fhVar.f13874M;
        f13225au = fhVar.f13875N;
        f13226av = fhVar.f13876O;
        f13227aw = fhVar.f13877P;
        f13228ax = new HashSet(fhVar.f13878Q);
        f13229ay = fhVar.f13882u;
        f13230az = fhVar.f13883v;
        f13185aA = fhVar.f13885x;
        f13186aB = fhVar.f13886y;
        f13187aC = fhVar.f13887z;
        f13188aD = fhVar.f13862A;
        f13189aE = fhVar.f13863B;
        f13190aF = fhVar.f13864C;
        f13191aG = fhVar.f13865D;
        f13192aH = fhVar.f13867F;
        f13193aI = fhVar.f13866E;
    }

    /* renamed from: i */
    private static void m16636i() {
        TapjoyLog.m16652i("TapjoyConnect", "Connect Flags:");
        TapjoyLog.m16652i("TapjoyConnect", "--------------------");
        for (Map.Entry entry : f13210af.entrySet()) {
            TapjoyLog.m16652i("TapjoyConnect", "key: " + ((String) entry.getKey()) + ", value: " + Uri.encode(entry.getValue().toString()));
        }
        TapjoyLog.m16652i("TapjoyConnect", "hostURL: [" + getConnectFlagValue(TapjoyConnectFlag.SERVICE_URL) + "]");
        TapjoyLog.m16652i("TapjoyConnect", "redirectDomain: [" + f13176Q + "]");
        TapjoyLog.m16652i("TapjoyConnect", "--------------------");
    }

    public static boolean isConnected() {
        return f13207ac;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isFullScreenViewOpen() {
        /*
            java.util.Map r0 = f13211ag
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0022
            java.lang.Object r1 = r0.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r2 = 1
            if (r1 == r2) goto L_0x0021
            r3 = 2
            if (r1 == r3) goto L_0x0021
            goto L_0x000a
        L_0x0021:
            return r2
        L_0x0022:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyConnectCore.isFullScreenViewOpen():boolean");
    }

    public static boolean isLimitedConnected() {
        return f13203aS;
    }

    public static boolean isUnitTestMode() {
        return getConnectFlagValue("unit_test_mode") == "true";
    }

    public static boolean isViewOpen() {
        TapjoyLog.m16649d("TapjoyConnect", "isViewOpen: " + f13211ag.size());
        return !f13211ag.isEmpty();
    }

    /* renamed from: j */
    private static void m16637j() {
        try {
            if (f13208ad != null) {
                ApplicationInfo applicationInfo = f13208ad.getApplicationInfo(f13236g.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
                if (applicationInfo == null || applicationInfo.metaData == null) {
                    TapjoyLog.m16649d("TapjoyConnect", "No metadata present.");
                    return;
                }
                for (String str : TapjoyConnectFlag.FLAG_ARRAY) {
                    String string = applicationInfo.metaData.getString("tapjoy." + str);
                    if (string != null) {
                        TapjoyLog.m16649d("TapjoyConnect", "Found manifest flag: " + str + ", " + string);
                        m16618a(str, string);
                    }
                }
                TapjoyLog.m16649d("TapjoyConnect", "Metadata successfully loaded");
            }
        } catch (Exception e) {
            TapjoyLog.m16650e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error reading manifest meta-data -- " + e.toString()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0135, code lost:
        throw new com.tapjoy.TapjoyIntegrationException("[ClassNotFoundException] Could not find dependency class " + ((java.lang.String) f13242m.get(r4)));
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x011a */
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m16638k() {
        /*
            android.content.pm.PackageManager r0 = f13208ad     // Catch:{ Exception -> 0x01d9 }
            android.content.Context r1 = f13236g     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ Exception -> 0x01d9 }
            r2 = 1
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r2)     // Catch:{ Exception -> 0x01d9 }
            android.content.pm.ActivityInfo[] r0 = r0.activities     // Catch:{ Exception -> 0x01d9 }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r1 = "TapjoyConnect"
            if (r0 == 0) goto L_0x0136
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x01d9 }
        L_0x001b:
            boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x01d9 }
            if (r3 == 0) goto L_0x0136
            java.lang.Object r3 = r0.next()     // Catch:{ Exception -> 0x01d9 }
            android.content.pm.ActivityInfo r3 = (android.content.pm.ActivityInfo) r3     // Catch:{ Exception -> 0x01d9 }
            java.util.Vector r4 = f13242m     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r5 = r3.name     // Catch:{ Exception -> 0x01d9 }
            boolean r4 = r4.contains(r5)     // Catch:{ Exception -> 0x01d9 }
            if (r4 == 0) goto L_0x001b
            java.util.Vector r4 = f13242m     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r5 = r3.name     // Catch:{ Exception -> 0x01d9 }
            int r4 = r4.indexOf(r5)     // Catch:{ Exception -> 0x01d9 }
            java.util.Vector r5 = f13242m     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.Class.forName(r5)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.util.Vector r5 = new java.util.Vector     // Catch:{ ClassNotFoundException -> 0x011a }
            r5.<init>()     // Catch:{ ClassNotFoundException -> 0x011a }
            int r6 = r3.configChanges     // Catch:{ ClassNotFoundException -> 0x011a }
            r7 = 128(0x80, float:1.794E-43)
            r6 = r6 & r7
            if (r6 == r7) goto L_0x0055
            java.lang.String r6 = "orientation"
            r5.add(r6)     // Catch:{ ClassNotFoundException -> 0x011a }
        L_0x0055:
            int r6 = r3.configChanges     // Catch:{ ClassNotFoundException -> 0x011a }
            r7 = 32
            r6 = r6 & r7
            if (r6 == r7) goto L_0x0061
            java.lang.String r6 = "keyboardHidden"
            r5.add(r6)     // Catch:{ ClassNotFoundException -> 0x011a }
        L_0x0061:
            int r6 = r5.size()     // Catch:{ ClassNotFoundException -> 0x011a }
            if (r6 == 0) goto L_0x00b9
            int r0 = r5.size()     // Catch:{ ClassNotFoundException -> 0x011a }
            if (r0 != r2) goto L_0x0093
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x011a }
            r1.<init>()     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r2 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x011a }
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r2 = " property is not specified in manifest configChanges for "
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.util.Vector r2 = f13242m     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ ClassNotFoundException -> 0x011a }
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r1 = r1.toString()     // Catch:{ ClassNotFoundException -> 0x011a }
            r0.<init>(r1)     // Catch:{ ClassNotFoundException -> 0x011a }
            throw r0     // Catch:{ ClassNotFoundException -> 0x011a }
        L_0x0093:
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x011a }
            r1.<init>()     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r2 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x011a }
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r2 = " properties are not specified in manifest configChanges for "
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.util.Vector r2 = f13242m     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ ClassNotFoundException -> 0x011a }
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r1 = r1.toString()     // Catch:{ ClassNotFoundException -> 0x011a }
            r0.<init>(r1)     // Catch:{ ClassNotFoundException -> 0x011a }
            throw r0     // Catch:{ ClassNotFoundException -> 0x011a }
        L_0x00b9:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ ClassNotFoundException -> 0x011a }
            r6 = 13
            if (r5 < r6) goto L_0x00df
            int r5 = r3.configChanges     // Catch:{ ClassNotFoundException -> 0x011a }
            r6 = 1024(0x400, float:1.435E-42)
            r5 = r5 & r6
            if (r5 == r6) goto L_0x00df
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r6 = "WARNING -- screenSize property is not specified in manifest configChanges for "
            r5.<init>(r6)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.util.Vector r6 = f13242m     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.Object r6 = r6.get(r4)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ ClassNotFoundException -> 0x011a }
            r5.append(r6)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r5 = r5.toString()     // Catch:{ ClassNotFoundException -> 0x011a }
            com.tapjoy.TapjoyLog.m16654w(r1, r5)     // Catch:{ ClassNotFoundException -> 0x011a }
        L_0x00df:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ ClassNotFoundException -> 0x011a }
            r6 = 11
            if (r5 < r6) goto L_0x0113
            java.lang.String r5 = r3.name     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r6 = "com.tapjoy.TJAdUnitActivity"
            boolean r5 = r5.equals(r6)     // Catch:{ ClassNotFoundException -> 0x011a }
            if (r5 == 0) goto L_0x0113
            int r3 = r3.flags     // Catch:{ ClassNotFoundException -> 0x011a }
            r5 = 512(0x200, float:7.175E-43)
            r3 = r3 & r5
            if (r3 != r5) goto L_0x00f7
            goto L_0x0113
        L_0x00f7:
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r2 = "'hardwareAccelerated' property not specified in manifest for "
            r1.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.util.Vector r2 = f13242m     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ ClassNotFoundException -> 0x011a }
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x011a }
            java.lang.String r1 = r1.toString()     // Catch:{ ClassNotFoundException -> 0x011a }
            r0.<init>(r1)     // Catch:{ ClassNotFoundException -> 0x011a }
            throw r0     // Catch:{ ClassNotFoundException -> 0x011a }
        L_0x0113:
            java.util.Vector r3 = f13242m     // Catch:{ ClassNotFoundException -> 0x011a }
            r3.remove(r4)     // Catch:{ ClassNotFoundException -> 0x011a }
            goto L_0x001b
        L_0x011a:
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException     // Catch:{ Exception -> 0x01d9 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r2 = "[ClassNotFoundException] Could not find dependency class "
            r1.<init>(r2)     // Catch:{ Exception -> 0x01d9 }
            java.util.Vector r2 = f13242m     // Catch:{ Exception -> 0x01d9 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x01d9 }
            r1.append(r2)     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01d9 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x01d9 }
            throw r0     // Catch:{ Exception -> 0x01d9 }
        L_0x0136:
            java.util.Vector r0 = f13242m
            int r0 = r0.size()
            if (r0 == 0) goto L_0x0194
            java.util.Vector r0 = f13242m
            int r0 = r0.size()
            java.lang.String r1 = "Missing "
            if (r0 != r2) goto L_0x016e
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.util.Vector r1 = f13242m
            int r1 = r1.size()
            r2.append(r1)
            java.lang.String r1 = " dependency class in manifest: "
            r2.append(r1)
            java.util.Vector r1 = f13242m
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x016e:
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.util.Vector r1 = f13242m
            int r1 = r1.size()
            r2.append(r1)
            java.lang.String r1 = " dependency classes in manifest: "
            r2.append(r1)
            java.util.Vector r1 = f13242m
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0194:
            m16639l()
            java.lang.String r0 = "com.tapjoy.TJAdUnitJSBridge"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x01d1 }
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x01c9 }
            r3 = 0
            java.lang.Class<java.lang.Boolean> r4 = java.lang.Boolean.class
            r2[r3] = r4     // Catch:{ NoSuchMethodException -> 0x01c9 }
            java.lang.String r3 = "closeRequested"
            r0.getMethod(r3, r2)     // Catch:{ NoSuchMethodException -> 0x01c9 }
            java.lang.String r0 = "TJC_OPTION_DISABLE_ADVERTISING_ID_CHECK"
            java.lang.String r2 = getConnectFlagValue(r0)
            if (r2 == 0) goto L_0x01c3
            java.lang.String r0 = getConnectFlagValue(r0)
            java.lang.String r2 = "true"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x01c3
            java.lang.String r0 = "Skipping integration check for Google Play Services and Advertising ID. Do this only if you do not have access to Google Play Services."
            com.tapjoy.TapjoyLog.m16652i(r1, r0)
            return
        L_0x01c3:
            com.tapjoy.TapjoyGpsHelper r0 = f13209ae
            r0.checkGooglePlayIntegration()
            return
        L_0x01c9:
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException
            java.lang.String r1 = "Try configuring Proguard or other code obfuscators to ignore com.tapjoy classes. Visit http://dev.tapjoy.comfor more information."
            r0.<init>(r1)
            throw r0
        L_0x01d1:
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException
            java.lang.String r1 = "ClassNotFoundException: com.tapjoy.TJAdUnitJSBridge was not found."
            r0.<init>(r1)
            throw r0
        L_0x01d9:
            com.tapjoy.TapjoyIntegrationException r0 = new com.tapjoy.TapjoyIntegrationException
            java.lang.String r1 = "Error while getting package info."
            r0.<init>(r1)
            goto L_0x01e2
        L_0x01e1:
            throw r0
        L_0x01e2:
            goto L_0x01e1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyConnectCore.m16638k():void");
    }

    /* renamed from: l */
    private static void m16639l() {
        Vector vector = new Vector();
        for (String str : TapjoyConstants.dependencyPermissions) {
            if (!m16632e(str)) {
                vector.add(str);
            }
        }
        if (vector.size() == 0) {
            Vector vector2 = new Vector();
            for (String str2 : TapjoyConstants.optionalPermissions) {
                if (!m16632e(str2)) {
                    vector2.add(str2);
                }
            }
            if (vector2.size() == 0) {
                return;
            }
            if (vector2.size() == 1) {
                TapjoyLog.m16654w("TapjoyConnect", "WARNING -- " + vector2.toString() + " permission was not found in manifest. The exclusion of this permission could cause problems.");
                return;
            }
            TapjoyLog.m16654w("TapjoyConnect", "WARNING -- " + vector2.toString() + " permissions were not found in manifest. The exclusion of these permissions could cause problems.");
        } else if (vector.size() == 1) {
            throw new TapjoyIntegrationException("Missing 1 permission in manifest: " + vector.toString());
        } else {
            throw new TapjoyIntegrationException("Missing " + vector.size() + " permissions in manifest: " + vector.toString());
        }
    }

    /* renamed from: m */
    private static boolean m16640m() {
        String str = f13232c;
        return str != null && str.length() > 0;
    }

    /* renamed from: n */
    private static boolean m16641n() {
        return getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK) != null && getConnectFlagValue(TapjoyConnectFlag.ALLOW_LEGACY_ID_FALLBACK).equals("true");
    }

    /* renamed from: o */
    private static boolean m16642o() {
        return (f13209ae.isGooglePlayServicesAvailable() && f13209ae.isGooglePlayManifestConfigured()) || getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK) == null || !getConnectFlagValue(TapjoyConnectFlag.DISABLE_ADVERTISING_ID_CHECK).equals("true");
    }

    /* renamed from: p */
    private static String m16643p() {
        TapjoyLog.m16652i("TapjoyConnect", "generating sessionID...");
        String str = null;
        try {
            str = TapjoyUtil.SHA256((System.currentTimeMillis() / 1000) + f13251v);
            f13206aa = System.currentTimeMillis();
            return str;
        } catch (Exception e) {
            TapjoyLog.m16651e("TapjoyConnect", "unable to generate session id: " + e.toString());
            return str;
        }
    }

    /* renamed from: q */
    private static String m16644q() {
        if (m16640m()) {
            return f13232c;
        }
        if (m16641n() || !m16642o()) {
            String str = f13245p;
            boolean z = true;
            if (str != null && str.length() > 0) {
                return f13245p;
            }
            String str2 = f13243n;
            if (str2 == null || str2.length() <= 0) {
                z = false;
            }
            if (z) {
                return f13243n;
            }
        }
        TapjoyLog.m16651e("TapjoyConnect", "Error -- no valid device identifier");
        return null;
    }

    /* renamed from: r */
    private static String m16645r() {
        String str = f13251v + f13252w + f13253x + f13232c + f13246q;
        try {
            return TapjoyUtil.SHA1(str);
        } catch (Exception unused) {
            return str;
        }
    }

    public static void requestLimitedTapjoyConnect(Context context, String str, TJConnectListener tJConnectListener) {
        try {
            C5090fo foVar = new C5090fo(str);
            if (foVar.f13933a == C5090fo.C3134a.SDK_ANDROID) {
                f13200aP = foVar.f13934b;
                f13201aQ = foVar.f13935c;
                if (f13238i == null) {
                    f13238i = new TapjoyConnectCore();
                }
                f13204aT = tJConnectListener;
                TapjoyConnectCore tapjoyConnectCore = f13238i;
                try {
                    m16621a(context);
                    new Thread(new Runnable() {
                        public final void run() {
                            TapjoyConnectCore.m16617a();
                            TapjoyConnectCore.this.completeLimitedConnectCall();
                        }
                    }).start();
                } catch (TapjoyIntegrationException e) {
                    TapjoyLog.m16650e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, e.getMessage()));
                    m16631e();
                    C5096fs.f13949b.notifyObservers(Boolean.FALSE);
                } catch (TapjoyException e2) {
                    TapjoyLog.m16650e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, e2.getMessage()));
                    m16631e();
                    C5096fs.f13949b.notifyObservers(Boolean.FALSE);
                }
                TapjoyLog.m16649d("TapjoyConnect", "requestTapjoyConnect function complete");
                return;
            }
            throw new IllegalArgumentException("The given API key was not for Android.");
        } catch (IllegalArgumentException e3) {
            TapjoyLog.m16649d("TapjoyConnect", e3.getMessage());
            throw new TapjoyIntegrationException(e3.getMessage());
        }
    }

    public static void requestTapjoyConnect(Context context, String str) {
        requestTapjoyConnect(context, str, (Hashtable) null);
    }

    public static void setCustomParameter(String str) {
        f13163D = str;
    }

    public static void setPlugin(String str) {
        f13174O = str;
    }

    public static void setSDKType(String str) {
        f13175P = str;
    }

    public static void setUserID(String str, TJSetUserIDListener tJSetUserIDListener) {
        f13162C = str;
        f13241l = tJSetUserIDListener;
        TapjoyLog.m16649d("TapjoyConnect", "URL parameters: " + getURLParams());
        new Thread(new Runnable() {
            public final void run() {
                TapjoyLog.m16652i("TapjoyConnect", "Setting userID to " + TapjoyConnectCore.f13162C);
                TapjoyURLConnection c = TapjoyConnectCore.f13239j;
                String str = c.getResponseFromURL(TapjoyConnectCore.getHostURL() + TapjoyConstants.TJC_USER_ID_URL_PATH, TapjoyConnectCore.getURLParams()).response;
                TapjoyConnectCore.m16620a(str != null ? TapjoyConnectCore.m16622a(str) : false);
            }
        }).start();
    }

    public static void setViewShowing(boolean z) {
        if (z) {
            f13211ag.put("", 1);
        } else {
            f13211ag.clear();
        }
    }

    public static void viewDidClose(String str) {
        TapjoyLog.m16649d("TapjoyConnect", "viewDidClose: " + str);
        f13211ag.remove(str);
        C5096fs.f13952e.notifyObservers();
    }

    public static void viewWillOpen(String str, int i) {
        TapjoyLog.m16649d("TapjoyConnect", "viewWillOpen: " + str);
        f13211ag.put(str, Integer.valueOf(i));
    }

    public void actionComplete(String str) {
        TapjoyLog.m16652i("TapjoyConnect", "actionComplete: " + str);
        Map f = m16633f();
        TapjoyUtil.safePut(f, "app_id", str, true);
        f.putAll(getTimeStampAndVerifierParams());
        TapjoyLog.m16649d("TapjoyConnect", "PPA URL parameters: " + f);
        new Thread(new PPAThread(f)).start();
    }

    public void appPause() {
        this.f13257Z = true;
    }

    public void appResume() {
        if (this.f13257Z) {
            m16643p();
            this.f13257Z = false;
        }
    }

    public void completeConnectCall() {
        boolean z;
        String connectResult;
        TapjoyLog.m16649d("TapjoyConnect", "starting connect call...");
        String hostURL = getHostURL() != TapjoyConfig.TJC_SERVICE_URL ? getHostURL() : TapjoyConfig.TJC_CONNECT_SERVICE_URL;
        if (isConnected() || (connectResult = TapjoyAppSettings.getInstance().getConnectResult(m16645r(), C5271v.m17676b())) == null || !m16623a(connectResult, true)) {
            z = false;
        } else {
            TapjoyLog.m16652i("TapjoyConnect", "Connect using stored connect result");
            f13207ac = true;
            TJConnectListener tJConnectListener = f13240k;
            if (tJConnectListener != null) {
                tJConnectListener.onConnectSuccess();
            }
            C5096fs.f13948a.notifyObservers();
            z = true;
        }
        TapjoyURLConnection tapjoyURLConnection = f13239j;
        TapjoyHttpURLResponse responseFromURL = tapjoyURLConnection.getResponseFromURL(hostURL + TapjoyConstants.TJC_CONNECT_URL_PATH, (Map) null, (Map) null, getURLParams());
        if (responseFromURL == null || responseFromURL.statusCode != 200) {
            if (!z) {
                m16629d();
            }
            C5096fs.f13949b.notifyObservers(Boolean.FALSE);
        } else if (m16623a(responseFromURL.response, false)) {
            TapjoyLog.m16652i("TapjoyConnect", "Successfully connected to Tapjoy");
            f13207ac = true;
            for (Map.Entry entry : getGenericURLParams().entrySet()) {
                TapjoyLog.m16649d("TapjoyConnect", ((String) entry.getKey()) + ": " + ((String) entry.getValue()));
            }
            if (!z) {
                TJConnectListener tJConnectListener2 = f13240k;
                if (tJConnectListener2 != null) {
                    tJConnectListener2.onConnectSuccess();
                }
                C5096fs.f13948a.notifyObservers();
            }
            C5096fs.f13949b.notifyObservers(Boolean.TRUE);
        } else {
            if (!z) {
                m16629d();
            }
            C5096fs.f13949b.notifyObservers(Boolean.FALSE);
        }
    }

    public void completeLimitedConnectCall() {
        String hostURL = getHostURL() != TapjoyConfig.TJC_SERVICE_URL ? getHostURL() : TapjoyConfig.TJC_CONNECT_SERVICE_URL;
        Map limitedURLParams = getLimitedURLParams();
        TapjoyURLConnection tapjoyURLConnection = f13239j;
        TapjoyHttpURLResponse responseFromURL = tapjoyURLConnection.getResponseFromURL(hostURL + TapjoyConstants.TJC_CONNECT_URL_PATH, (Map) null, (Map) null, limitedURLParams);
        if (responseFromURL == null || responseFromURL.statusCode != 200) {
            m16631e();
            C5096fs.f13949b.notifyObservers(Boolean.FALSE);
        } else if (m16628c(responseFromURL.response)) {
            TapjoyLog.m16652i("TapjoyConnect", "Successfully connected to Tapjoy");
            f13203aS = true;
            for (Map.Entry entry : getLimitedGenericURLParams().entrySet()) {
                TapjoyLog.m16649d("TapjoyConnect", ((String) entry.getKey()) + ": " + ((String) entry.getValue()));
            }
            TJConnectListener tJConnectListener = f13204aT;
            if (tJConnectListener != null) {
                tJConnectListener.onConnectSuccess();
            }
            C5096fs.f13948a.notifyObservers();
            C5096fs.f13949b.notifyObservers(Boolean.TRUE);
        } else {
            m16631e();
            C5096fs.f13949b.notifyObservers(Boolean.FALSE);
        }
    }

    public float getCurrencyMultiplier() {
        return f13177R;
    }

    public boolean isInitialized() {
        return this.f13258ab;
    }

    public void release() {
        f13238i = null;
        f13239j = null;
        TapjoyLog.m16649d("TapjoyConnect", "Releasing core static instance.");
    }

    public void setCurrencyMultiplier(float f) {
        TapjoyLog.m16652i("TapjoyConnect", "setVirtualCurrencyMultiplier: " + f);
        f13177R = f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: com.tapjoy.internal.bn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r9v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r9v12 */
    /* JADX WARNING: type inference failed for: r9v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m16628c(java.lang.String r9) {
        /*
            java.lang.String r0 = "TapjoyConnect"
            r1 = 0
            com.tapjoy.internal.bn r9 = com.tapjoy.internal.C3126bn.m10231b(r9)     // Catch:{ IOException -> 0x007a, RuntimeException -> 0x006e, all -> 0x006c }
            java.util.Map r2 = r9.mo18484d()     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            java.lang.String r3 = "app_group_id"
            java.lang.Object r3 = r2.get(r3)     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            java.lang.String r3 = com.tapjoy.internal.C3166jq.m10434a(r3)     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            java.lang.String r4 = "store"
            java.lang.Object r4 = r2.get(r4)     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            java.lang.String r4 = com.tapjoy.internal.C3166jq.m10434a(r4)     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            java.lang.String r5 = "analytics_api_key"
            java.lang.Object r5 = r2.get(r5)     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            java.lang.String r5 = com.tapjoy.internal.C3166jq.m10434a(r5)     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            java.lang.String r6 = "managed_device_id"
            java.lang.Object r2 = r2.get(r6)     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            java.lang.String r2 = com.tapjoy.internal.C3166jq.m10434a(r2)     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            com.tapjoy.internal.fo r6 = new com.tapjoy.internal.fo     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            com.tapjoy.internal.fo$a r5 = r6.f13933a     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            com.tapjoy.internal.fo$a r7 = com.tapjoy.internal.C5090fo.C3134a.RPC_ANALYTICS     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            if (r5 != r7) goto L_0x005d
            java.lang.String r5 = r6.f13934b     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            java.lang.String r5 = com.tapjoy.internal.C5090fo.m17202a(r5)     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            if (r3 != 0) goto L_0x004f
            r3 = r5
        L_0x004f:
            f13202aR = r3     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            f13180U = r4     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            f13182W = r2     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            r9.close()     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            com.tapjoy.internal.C3168jz.m10439a(r1)
            r9 = 1
            return r9
        L_0x005d:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            java.lang.String r2 = "Invalid analytics_api_key"
            r1.<init>(r2)     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
            throw r1     // Catch:{ IOException -> 0x006a, RuntimeException -> 0x0068 }
        L_0x0065:
            r0 = move-exception
            r1 = r9
            goto L_0x008a
        L_0x0068:
            r1 = move-exception
            goto L_0x0072
        L_0x006a:
            r1 = move-exception
            goto L_0x007e
        L_0x006c:
            r0 = move-exception
            goto L_0x008a
        L_0x006e:
            r9 = move-exception
            r8 = r1
            r1 = r9
            r9 = r8
        L_0x0072:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0065 }
            com.tapjoy.TapjoyLog.m16653v(r0, r1)     // Catch:{ all -> 0x0065 }
            goto L_0x0085
        L_0x007a:
            r9 = move-exception
            r8 = r1
            r1 = r9
            r9 = r8
        L_0x007e:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0065 }
            com.tapjoy.TapjoyLog.m16653v(r0, r1)     // Catch:{ all -> 0x0065 }
        L_0x0085:
            com.tapjoy.internal.C3168jz.m10439a(r9)
            r9 = 0
            return r9
        L_0x008a:
            com.tapjoy.internal.C3168jz.m10439a(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyConnectCore.m16628c(java.lang.String):boolean");
    }

    public static void requestTapjoyConnect(Context context, String str, Hashtable hashtable) {
        requestTapjoyConnect(context, str, hashtable, (TJConnectListener) null);
    }

    /* renamed from: b */
    private static String m16625b(long j) {
        try {
            return TapjoyUtil.SHA256(f13200aP + ":" + m16644q() + ":" + j + ":" + f13201aQ);
        } catch (Exception e) {
            TapjoyErrorMessage.ErrorType errorType = TapjoyErrorMessage.ErrorType.SDK_ERROR;
            TapjoyLog.m16650e("TapjoyConnect", new TapjoyErrorMessage(errorType, "Error in computing verifier value -- " + e.toString()));
            return "";
        }
    }

    /* renamed from: e */
    private static boolean m16632e(String str) {
        return f13208ad.checkPermission(str, f13236g.getPackageName()) == 0;
    }

    public static void requestTapjoyConnect(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener) {
        try {
            C5090fo foVar = new C5090fo(str);
            if (foVar.f13933a == C5090fo.C3134a.SDK_ANDROID) {
                f13237h = str;
                f13251v = foVar.f13934b;
                f13172M = foVar.f13935c;
                f13173N = foVar.f13936d;
                if (hashtable != null) {
                    f13210af.putAll(hashtable);
                    C5106ga.m17239b().mo18515a(hashtable);
                }
                C3145gz.m10322a(context).f8766j = str;
                f13240k = tJConnectListener;
                if (f13238i == null) {
                    f13238i = new TapjoyConnectCore();
                }
                TapjoyConnectCore tapjoyConnectCore = f13238i;
                try {
                    m16621a(context);
                    new Thread(new Runnable() {
                        public final void run() {
                            TapjoyConnectCore.m16617a();
                            TapjoyConnectCore.this.completeConnectCall();
                        }
                    }).start();
                    tapjoyConnectCore.f13258ab = true;
                } catch (TapjoyIntegrationException e) {
                    TapjoyLog.m16650e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, e.getMessage()));
                    m16629d();
                    C5096fs.f13949b.notifyObservers(Boolean.FALSE);
                } catch (TapjoyException e2) {
                    TapjoyLog.m16650e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, e2.getMessage()));
                    m16629d();
                    C5096fs.f13949b.notifyObservers(Boolean.FALSE);
                }
            } else {
                throw new IllegalArgumentException("The given API key was not for Android.");
            }
        } catch (IllegalArgumentException e3) {
            throw new TapjoyIntegrationException(e3.getMessage());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: com.tapjoy.internal.bn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m16630d(java.lang.String r4) {
        /*
            java.lang.String r0 = "TapjoyConnect"
            r1 = 0
            com.tapjoy.internal.bn r4 = com.tapjoy.internal.C3126bn.m10231b(r4)     // Catch:{ IOException -> 0x0039, RuntimeException -> 0x002d, all -> 0x002b }
            boolean r2 = r4.mo18480a()     // Catch:{ IOException -> 0x0029, RuntimeException -> 0x0027 }
            if (r2 == 0) goto L_0x001d
            r4.mo18503s()     // Catch:{ IOException -> 0x0029, RuntimeException -> 0x0027 }
            java.lang.String r2 = "Successfully sent completed Pay-Per-Action to Tapjoy server."
            com.tapjoy.TapjoyLog.m16649d(r0, r2)     // Catch:{ IOException -> 0x0029, RuntimeException -> 0x0027 }
            r4.close()     // Catch:{ IOException -> 0x0029, RuntimeException -> 0x0027 }
            com.tapjoy.internal.C3168jz.m10439a(r1)
            r4 = 1
            return r4
        L_0x001d:
            r4.close()     // Catch:{ IOException -> 0x0029, RuntimeException -> 0x0027 }
            com.tapjoy.internal.C3168jz.m10439a(r1)
            goto L_0x0047
        L_0x0024:
            r0 = move-exception
            r1 = r4
            goto L_0x0055
        L_0x0027:
            r1 = move-exception
            goto L_0x0031
        L_0x0029:
            r1 = move-exception
            goto L_0x003d
        L_0x002b:
            r0 = move-exception
            goto L_0x0055
        L_0x002d:
            r4 = move-exception
            r3 = r1
            r1 = r4
            r4 = r3
        L_0x0031:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0024 }
            com.tapjoy.TapjoyLog.m16653v(r0, r1)     // Catch:{ all -> 0x0024 }
            goto L_0x0044
        L_0x0039:
            r4 = move-exception
            r3 = r1
            r1 = r4
            r4 = r3
        L_0x003d:
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0024 }
            com.tapjoy.TapjoyLog.m16653v(r0, r1)     // Catch:{ all -> 0x0024 }
        L_0x0044:
            com.tapjoy.internal.C3168jz.m10439a(r4)
        L_0x0047:
            com.tapjoy.TapjoyErrorMessage r4 = new com.tapjoy.TapjoyErrorMessage
            com.tapjoy.TapjoyErrorMessage$ErrorType r1 = com.tapjoy.TapjoyErrorMessage.ErrorType.SDK_ERROR
            java.lang.String r2 = "Completed Pay-Per-Action call failed."
            r4.<init>(r1, r2)
            com.tapjoy.TapjoyLog.m16650e((java.lang.String) r0, (com.tapjoy.TapjoyErrorMessage) r4)
            r4 = 0
            return r4
        L_0x0055:
            com.tapjoy.internal.C3168jz.m10439a(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyConnectCore.m16630d(java.lang.String):boolean");
    }

    /* renamed from: a */
    private static void m16619a(Properties properties) {
        Enumeration keys = properties.keys();
        while (keys.hasMoreElements()) {
            try {
                String str = (String) keys.nextElement();
                m16618a(str, (String) properties.get(str));
            } catch (ClassCastException unused) {
                TapjoyLog.m16651e("TapjoyConnect", "Error parsing configuration properties in tapjoy_config.txt");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0111, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0112, code lost:
        r2 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0111 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0004] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m16623a(java.lang.String r18, boolean r19) {
        /*
            java.lang.String r1 = "TapjoyConnect"
            java.lang.String r0 = "configurations"
            com.tapjoy.internal.bn r3 = com.tapjoy.internal.C3126bn.m10231b(r18)     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
            java.util.Map r4 = r3.mo18484d()     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r5 = "app_group_id"
            java.lang.Object r5 = r4.get(r5)     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r5 = com.tapjoy.internal.C3166jq.m10434a(r5)     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r6 = "store"
            java.lang.Object r6 = r4.get(r6)     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r6 = com.tapjoy.internal.C3166jq.m10434a(r6)     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r7 = "analytics_api_key"
            java.lang.Object r7 = r4.get(r7)     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r7 = com.tapjoy.internal.C3166jq.m10434a(r7)     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r8 = "managed_device_id"
            java.lang.Object r8 = r4.get(r8)     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r15 = com.tapjoy.internal.C3166jq.m10434a(r8)     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r8 = "cache_max_age"
            java.lang.Object r14 = r4.get(r8)     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            com.tapjoy.internal.fo r8 = new com.tapjoy.internal.fo     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            r8.<init>(r7)     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            com.tapjoy.internal.fo$a r9 = r8.f13933a     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            com.tapjoy.internal.fo$a r10 = com.tapjoy.internal.C5090fo.C3134a.RPC_ANALYTICS     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            if (r9 != r10) goto L_0x0100
            java.lang.String r9 = r8.f13934b     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r13 = com.tapjoy.internal.C5090fo.m17202a(r9)     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r12 = r8.f13935c     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            if (r5 != 0) goto L_0x0058
            r5 = r13
        L_0x0058:
            com.tapjoy.internal.gz r8 = com.tapjoy.internal.C3145gz.m10321a()     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            android.content.Context r9 = f13236g     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r11 = "12.6.0"
            java.lang.String r16 = "https://rpc.tapjoy.com/"
            r10 = r7
            r17 = r12
            r12 = r16
            r2 = r14
            r14 = r17
            r8.mo18544a(r9, r10, r11, r12, r13, r14)     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            f13179T = r5     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            f13180U = r6     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            f13181V = r7     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            f13182W = r15     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            r3.close()     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            if (r19 != 0) goto L_0x00fa
            boolean r3 = r2 instanceof java.lang.String     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
            r5 = 0
            if (r3 == 0) goto L_0x008c
            r14 = r2
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ NumberFormatException -> 0x0098 }
            java.lang.String r2 = r14.trim()     // Catch:{ NumberFormatException -> 0x0098 }
            long r2 = java.lang.Long.parseLong(r2)     // Catch:{ NumberFormatException -> 0x0098 }
            goto L_0x0099
        L_0x008c:
            boolean r3 = r2 instanceof java.lang.Number     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
            if (r3 == 0) goto L_0x0098
            r14 = r2
            java.lang.Number r14 = (java.lang.Number) r14     // Catch:{ NumberFormatException -> 0x0098 }
            long r2 = r14.longValue()     // Catch:{ NumberFormatException -> 0x0098 }
            goto L_0x0099
        L_0x0098:
            r2 = r5
        L_0x0099:
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x00a5
            com.tapjoy.TapjoyAppSettings r2 = com.tapjoy.TapjoyAppSettings.getInstance()     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
            r2.removeConnectResult()     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
            goto L_0x00bb
        L_0x00a5:
            com.tapjoy.TapjoyAppSettings r5 = com.tapjoy.TapjoyAppSettings.getInstance()     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
            java.lang.String r6 = m16645r()     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
            r7 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r7
            long r7 = com.tapjoy.internal.C5271v.m17676b()     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
            long r2 = r2 + r7
            r7 = r18
            r5.saveConnectResultAndParams(r7, r6, r2)     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
        L_0x00bb:
            com.tapjoy.internal.ga r2 = com.tapjoy.internal.C5106ga.m17238a()     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
            java.lang.Object r3 = r4.get(r0)     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
            boolean r4 = r3 instanceof java.util.Map     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
            if (r4 == 0) goto L_0x00e3
            com.tapjoy.internal.fy r1 = r2.f13973a     // Catch:{ Exception -> 0x00fa, all -> 0x0111 }
            r4 = r3
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x00fa, all -> 0x0111 }
            r1.mo18516a((java.util.Map) r4)     // Catch:{ Exception -> 0x00fa, all -> 0x0111 }
            java.lang.String r1 = com.tapjoy.internal.C4910bh.m16696a((java.lang.Object) r3)     // Catch:{ Exception -> 0x00fa, all -> 0x0111 }
            android.content.SharedPreferences r2 = r2.mo31280c()     // Catch:{ Exception -> 0x00fa, all -> 0x0111 }
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ Exception -> 0x00fa, all -> 0x0111 }
            android.content.SharedPreferences$Editor r0 = r2.putString(r0, r1)     // Catch:{ Exception -> 0x00fa, all -> 0x0111 }
            r0.apply()     // Catch:{ Exception -> 0x00fa, all -> 0x0111 }
            goto L_0x00fa
        L_0x00e3:
            if (r3 != 0) goto L_0x00fa
            com.tapjoy.internal.fy r3 = r2.f13973a     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
            r4 = 0
            r3.mo18516a((java.util.Map) r4)     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
            android.content.SharedPreferences r2 = r2.mo31280c()     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
            android.content.SharedPreferences$Editor r0 = r2.remove(r0)     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
            r0.apply()     // Catch:{ IOException -> 0x011e, RuntimeException -> 0x0114, all -> 0x0111 }
        L_0x00fa:
            r2 = 0
            com.tapjoy.internal.C3168jz.m10439a(r2)
            r0 = 1
            return r0
        L_0x0100:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            java.lang.String r2 = "Invalid analytics_api_key"
            r0.<init>(r2)     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
            throw r0     // Catch:{ IOException -> 0x010e, RuntimeException -> 0x010b, all -> 0x0108 }
        L_0x0108:
            r0 = move-exception
            r2 = r3
            goto L_0x012d
        L_0x010b:
            r0 = move-exception
            r2 = r3
            goto L_0x0116
        L_0x010e:
            r0 = move-exception
            r2 = r3
            goto L_0x0120
        L_0x0111:
            r0 = move-exception
            r2 = 0
            goto L_0x012d
        L_0x0114:
            r0 = move-exception
            r2 = 0
        L_0x0116:
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x012c }
            com.tapjoy.TapjoyLog.m16653v(r1, r0)     // Catch:{ all -> 0x012c }
            goto L_0x0127
        L_0x011e:
            r0 = move-exception
            r2 = 0
        L_0x0120:
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x012c }
            com.tapjoy.TapjoyLog.m16653v(r1, r0)     // Catch:{ all -> 0x012c }
        L_0x0127:
            com.tapjoy.internal.C3168jz.m10439a(r2)
            r0 = 0
            return r0
        L_0x012c:
            r0 = move-exception
        L_0x012d:
            com.tapjoy.internal.C3168jz.m10439a(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyConnectCore.m16623a(java.lang.String, boolean):boolean");
    }

    /* renamed from: a */
    private static String m16616a(long j) {
        try {
            return TapjoyUtil.SHA256(f13251v + ":" + m16644q() + ":" + j + ":" + f13172M);
        } catch (Exception e) {
            TapjoyErrorMessage.ErrorType errorType = TapjoyErrorMessage.ErrorType.SDK_ERROR;
            TapjoyLog.m16650e("TapjoyConnect", new TapjoyErrorMessage(errorType, "Error in computing verifier value -- " + e.toString()));
            return "";
        }
    }

    /* renamed from: a */
    private static void m16618a(String str, String str2) {
        if ((str.equals(TapjoyConnectFlag.SERVICE_URL) || str.equals(TapjoyConnectFlag.PLACEMENT_URL)) && !str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        f13210af.put(str, str2);
    }

    /* renamed from: a */
    static /* synthetic */ void m16617a() {
        if (!f13205aU) {
            try {
                f13209ae.loadAdvertisingId(!m16641n());
                if (f13209ae.isGooglePlayServicesAvailable() && f13209ae.isGooglePlayManifestConfigured()) {
                    f13231b = f13209ae.getDeviceGooglePlayServicesVersion();
                    f13184a = f13209ae.getPackagedGooglePlayServicesVersion();
                }
                if (f13209ae.isAdIdAvailable()) {
                    f13233d = f13209ae.isAdTrackingEnabled();
                    f13232c = f13209ae.getAdvertisingId();
                    C3145gz a = C3145gz.m10321a();
                    String str = f13232c;
                    boolean z = !f13233d;
                    C3149hc hcVar = a.f8762f;
                    String a2 = hcVar.f8783c.f14109A.mo31485a();
                    hcVar.f8782b.f13904q = str;
                    hcVar.f8782b.f13905r = Boolean.valueOf(z);
                    hcVar.f8783c.f14109A.mo31486a(str);
                    hcVar.f8783c.f14110B.mo31321a(z);
                    C5162hn.m17386a(str, z);
                    if (!C3166jq.m10436c(a2) && !str.equals(a2)) {
                        hcVar.f8783c.mo31335a(false);
                    }
                }
            } catch (Exception e) {
                TapjoyLog.m16652i("TapjoyConnect", "Error fetching advertising id: " + e.toString());
                e.printStackTrace();
            }
            f13205aU = true;
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m16622a(String str) {
        Document buildDocument = TapjoyUtil.buildDocument(str);
        if (buildDocument == null) {
            return true;
        }
        String nodeTrimValue = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Success"));
        return nodeTrimValue != null && nodeTrimValue.equals("true");
    }

    /* renamed from: a */
    static /* synthetic */ void m16620a(boolean z) {
        if (z) {
            TapjoyLog.m16652i("TapjoyConnect", "Set userID is successful");
            TJSetUserIDListener tJSetUserIDListener = f13241l;
            if (tJSetUserIDListener != null) {
                tJSetUserIDListener.onSetUserIDSuccess();
                return;
            }
            return;
        }
        TapjoyLog.m16650e("TapjoyConnect", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Failed to set userID"));
        TJSetUserIDListener tJSetUserIDListener2 = f13241l;
        if (tJSetUserIDListener2 != null) {
            tJSetUserIDListener2.onSetUserIDFailure("Failed to set userID");
        }
    }
}
