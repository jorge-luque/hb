package com.vungle.warren;

import admost.sdk.base.AdMostExperimentManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import androidx.annotation.Keep;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.moat.analytics.mobile.vng.MoatAnalytics;
import com.moat.analytics.mobile.vng.MoatOptions;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.AdvertisementDBAdapter;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.JsonUtil;
import com.vungle.warren.network.APIFactory;
import com.vungle.warren.network.Call;
import com.vungle.warren.network.Response;
import com.vungle.warren.network.VungleApi;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.ViewUtility;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p113i.C3480a0;
import p113i.C3484b0;
import p113i.C3539s;
import p113i.C3541u;
import p113i.C3542v;
import p113i.C3548y;
import p113i.C3550z;
import p113i.C5970t;
import p113i.C5972w;
import p119j.C3577c;
import p119j.C3579d;
import p119j.C3585t;
import p119j.C6586k;
import p119j.C6589n;

public class VungleApiClient {
    private static String BASE_URL = "https://ads.api.vungle.com/";
    public static String HEADER_UA = (MANUFACTURER_AMAZON.equals(Build.MANUFACTURER) ? "VungleAmazon/6.7.0" : "VungleDroid/6.7.0");
    static final String MANUFACTURER_AMAZON = "Amazon";
    /* access modifiers changed from: private */
    public static final String TAG = "com.vungle.warren.VungleApiClient";
    protected static WrapperFramework WRAPPER_FRAMEWORK_SELECTED;
    private static Set<C5970t> logInterceptors = new HashSet();
    private static Set<C5970t> networkInterceptors = new HashSet();
    private VungleApi api;
    private JsonObject appBody;
    private CacheManager cacheManager;
    private C3542v client;
    /* access modifiers changed from: private */
    public Context context;
    private boolean defaultIdFallbackDisabled;
    /* access modifiers changed from: private */
    public JsonObject deviceBody;
    private boolean enableMoat;
    private VungleApi gzipApi;
    private String newEndpoint;
    private String reportAdEndpoint;
    private Repository repository;
    private String requestAdEndpoint;
    /* access modifiers changed from: private */
    public Map<String, Long> retryAfterDataMap = new ConcurrentHashMap();
    private String riEndpoint;
    private boolean shouldTransmitIMEI;
    private VungleApi timeoutApi;
    /* access modifiers changed from: private */
    public String uaString = System.getProperty("http.agent");
    private JsonObject userBody;
    private String userImei;
    private boolean willPlayAdEnabled;
    private String willPlayAdEndpoint;
    private int willPlayAdTimeout;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionTypeDetail {
        public static final String CDMA_1XRTT = "cdma_1xrtt";
        public static final String CDMA_EVDO_0 = "cdma_evdo_0";
        public static final String CDMA_EVDO_A = "cdma_evdo_a";
        public static final String CDMA_EVDO_B = "cdma_evdo_b";
        public static final String EDGE = "edge";
        public static final String GPRS = "gprs";
        public static final String HRPD = "hrpd";
        public static final String HSDPA = "hsdpa";
        public static final String HSUPA = "hsupa";
        public static final String LTE = "LTE";
        public static final String UNKNOWN = "unknown";
        public static final String WCDMA = "wcdma";
    }

    public static class ClearTextTrafficException extends IOException {
        ClearTextTrafficException(String str) {
            super(str);
        }
    }

    static class GzipRequestInterceptor implements C5970t {
        private static final String CONTENT_ENCODING = "Content-Encoding";
        private static final String GZIP = "gzip";

        GzipRequestInterceptor() {
        }

        private C3550z gzip(final C3550z zVar) throws IOException {
            final C3577c cVar = new C3577c();
            C3579d a = C6589n.m21609a((C3585t) new C6586k(cVar));
            zVar.writeTo(a);
            a.close();
            return new C3550z() {
                public long contentLength() {
                    return cVar.size();
                }

                public C3541u contentType() {
                    return zVar.contentType();
                }

                public void writeTo(C3579d dVar) throws IOException {
                    dVar.mo19694a(cVar.mo19733w());
                }
            };
        }

        public C3480a0 intercept(C5970t.C5971a aVar) throws IOException {
            C3548y d = aVar.mo33734d();
            if (d.mo19599a() == null || d.mo19600a(CONTENT_ENCODING) != null) {
                return aVar.mo33730a(d);
            }
            C3548y.C3549a f = d.mo19606f();
            f.mo19619b(CONTENT_ENCODING, GZIP);
            f.mo19614a(d.mo19605e(), gzip(d.mo19599a()));
            return aVar.mo33730a(f.mo19616a());
        }
    }

    @Keep
    public enum WrapperFramework {
        admob,
        air,
        cocos2dx,
        corona,
        dfp,
        heyzap,
        marmalade,
        mopub,
        unity,
        fyber,
        ironsource,
        upsight,
        appodeal,
        aerserv,
        adtoapp,
        tapdaq,
        vunglehbs,
        none
    }

    VungleApiClient(Context context2, CacheManager cacheManager2, Repository repository2) {
        this.cacheManager = cacheManager2;
        this.context = context2.getApplicationContext();
        this.repository = repository2;
        C54561 r2 = new C5970t() {
            public C3480a0 intercept(C5970t.C5971a aVar) throws IOException {
                int v;
                C3548y d = aVar.mo33734d();
                String c = d.mo19607g().mo19520c();
                Long l = (Long) VungleApiClient.this.retryAfterDataMap.get(c);
                if (l != null) {
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(l.longValue() - System.currentTimeMillis());
                    if (seconds > 0) {
                        C3480a0.C3481a aVar2 = new C3480a0.C3481a();
                        aVar2.mo19300a(d);
                        aVar2.mo19302a("Retry-After", String.valueOf(seconds));
                        aVar2.mo19293a(500);
                        aVar2.mo19299a(C5972w.HTTP_1_1);
                        aVar2.mo19301a("Server is busy");
                        aVar2.mo19296a(C3484b0.create(C3541u.m11900b("application/json; charset=utf-8"), "{\"Error\":\"Retry-After\"}"));
                        return aVar2.mo19303a();
                    }
                    VungleApiClient.this.retryAfterDataMap.remove(c);
                }
                C3480a0 a = aVar.mo33730a(d);
                if (a != null && ((v = a.mo19288v()) == 429 || v == 500 || v == 502 || v == 503)) {
                    String a2 = a.mo19290x().mo19502a("Retry-After");
                    if (!TextUtils.isEmpty(a2)) {
                        try {
                            long parseLong = Long.parseLong(a2);
                            if (parseLong > 0) {
                                VungleApiClient.this.retryAfterDataMap.put(c, Long.valueOf((parseLong * 1000) + System.currentTimeMillis()));
                            }
                        } catch (NumberFormatException unused) {
                            String unused2 = VungleApiClient.TAG;
                        }
                    }
                }
                return a;
            }
        };
        C3542v.C3544b bVar = new C3542v.C3544b();
        bVar.mo19583a((C5970t) r2);
        this.client = bVar.mo19585a();
        bVar.mo19583a((C5970t) new GzipRequestInterceptor());
        C3542v a = bVar.mo19585a();
        this.api = new APIFactory(this.client, BASE_URL).createAPI();
        this.gzipApi = new APIFactory(a, BASE_URL).createAPI();
    }

    /* access modifiers changed from: private */
    public void addUserAgentInCookie(String str) throws DatabaseHelper.DBException {
        Cookie cookie = new Cookie("userAgent");
        cookie.putValue("userAgent", str);
        this.repository.save(cookie);
    }

    private String getConnectionTypeDetail(int i) {
        switch (i) {
            case 1:
                return ConnectionTypeDetail.GPRS;
            case 2:
                return ConnectionTypeDetail.EDGE;
            case 4:
                return ConnectionTypeDetail.WCDMA;
            case 5:
                return ConnectionTypeDetail.CDMA_EVDO_0;
            case 6:
                return ConnectionTypeDetail.CDMA_EVDO_A;
            case 7:
                return ConnectionTypeDetail.CDMA_1XRTT;
            case 8:
                return ConnectionTypeDetail.HSDPA;
            case 9:
                return ConnectionTypeDetail.HSUPA;
            case 12:
                return ConnectionTypeDetail.CDMA_EVDO_B;
            case 13:
                return ConnectionTypeDetail.LTE;
            case 14:
                return ConnectionTypeDetail.HRPD;
            default:
                return "unknown";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02ed A[Catch:{ SettingNotFoundException -> 0x0317 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0307 A[Catch:{ SettingNotFoundException -> 0x0317 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x035d  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0180  */
    @android.annotation.SuppressLint({"HardwareIds"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.gson.JsonObject getDeviceBody() throws java.lang.IllegalStateException {
        /*
            r14 = this;
            java.lang.String r0 = "ifa"
            java.lang.String r1 = "Amazon"
            com.google.gson.JsonObject r2 = new com.google.gson.JsonObject
            r2.<init>()
            r3 = 0
            r4 = 0
            r5 = 1
            java.lang.String r6 = android.os.Build.MANUFACTURER     // Catch:{ Exception -> 0x0084 }
            boolean r6 = r1.equals(r6)     // Catch:{ Exception -> 0x0084 }
            java.lang.String r7 = "advertising_id"
            if (r6 == 0) goto L_0x003d
            android.content.Context r6 = r14.context     // Catch:{ SettingNotFoundException -> 0x002f }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x002f }
            java.lang.String r8 = "limit_ad_tracking"
            int r8 = android.provider.Settings.Secure.getInt(r6, r8)     // Catch:{ SettingNotFoundException -> 0x002f }
            if (r8 != r5) goto L_0x0026
            r8 = 1
            goto L_0x0027
        L_0x0026:
            r8 = 0
        L_0x0027:
            java.lang.String r6 = android.provider.Settings.Secure.getString(r6, r7)     // Catch:{ SettingNotFoundException -> 0x002d }
            goto L_0x0090
        L_0x002d:
            r6 = move-exception
            goto L_0x0031
        L_0x002f:
            r6 = move-exception
            r8 = 1
        L_0x0031:
            java.lang.String r7 = TAG     // Catch:{ Exception -> 0x003a }
            java.lang.String r9 = "Error getting Amazon advertising info"
            android.util.Log.w(r7, r9, r6)     // Catch:{ Exception -> 0x003a }
            r6 = r3
            goto L_0x0090
        L_0x003a:
            r6 = r8
            r8 = r3
            goto L_0x0086
        L_0x003d:
            android.content.Context r6 = r14.context     // Catch:{ NoClassDefFoundError -> 0x005a }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r6 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r6)     // Catch:{ NoClassDefFoundError -> 0x005a }
            if (r6 == 0) goto L_0x0057
            java.lang.String r8 = r6.getId()     // Catch:{ NoClassDefFoundError -> 0x005a }
            boolean r6 = r6.isLimitAdTrackingEnabled()     // Catch:{ NoClassDefFoundError -> 0x0055, Exception -> 0x0085 }
            com.google.gson.JsonObject r9 = r14.deviceBody     // Catch:{ NoClassDefFoundError -> 0x0053 }
            r9.addProperty((java.lang.String) r0, (java.lang.String) r8)     // Catch:{ NoClassDefFoundError -> 0x0053 }
            goto L_0x008d
        L_0x0053:
            r9 = move-exception
            goto L_0x005d
        L_0x0055:
            r9 = move-exception
            goto L_0x005c
        L_0x0057:
            r6 = r3
            r8 = 1
            goto L_0x0090
        L_0x005a:
            r9 = move-exception
            r8 = r3
        L_0x005c:
            r6 = 1
        L_0x005d:
            java.lang.String r10 = TAG     // Catch:{ Exception -> 0x0086 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0086 }
            r11.<init>()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r12 = "Play services Not available: "
            r11.append(r12)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r9 = r9.getLocalizedMessage()     // Catch:{ Exception -> 0x0086 }
            r11.append(r9)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r9 = r11.toString()     // Catch:{ Exception -> 0x0086 }
            android.util.Log.e(r10, r9)     // Catch:{ Exception -> 0x0086 }
            android.content.Context r9 = r14.context     // Catch:{ Exception -> 0x0086 }
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r7 = android.provider.Settings.Secure.getString(r9, r7)     // Catch:{ Exception -> 0x0086 }
            r8 = r6
            r6 = r7
            goto L_0x0090
        L_0x0084:
            r8 = r3
        L_0x0085:
            r6 = 1
        L_0x0086:
            java.lang.String r7 = TAG
            java.lang.String r9 = "Cannot load Advertising ID"
            android.util.Log.e(r7, r9)
        L_0x008d:
            r13 = r8
            r8 = r6
            r6 = r13
        L_0x0090:
            java.lang.String r7 = ""
            if (r6 == 0) goto L_0x00aa
            java.lang.String r9 = android.os.Build.MANUFACTURER
            boolean r9 = r1.equals(r9)
            if (r9 == 0) goto L_0x009f
            java.lang.String r9 = "amazon_advertising_id"
            goto L_0x00a1
        L_0x009f:
            java.lang.String r9 = "gaid"
        L_0x00a1:
            r2.addProperty((java.lang.String) r9, (java.lang.String) r6)
            com.google.gson.JsonObject r9 = r14.deviceBody
            r9.addProperty((java.lang.String) r0, (java.lang.String) r6)
            goto L_0x00d5
        L_0x00aa:
            android.content.Context r6 = r14.context
            android.content.ContentResolver r6 = r6.getContentResolver()
            java.lang.String r9 = "android_id"
            java.lang.String r6 = android.provider.Settings.Secure.getString(r6, r9)
            com.google.gson.JsonObject r10 = r14.deviceBody
            boolean r11 = r14.defaultIdFallbackDisabled
            if (r11 == 0) goto L_0x00be
        L_0x00bc:
            r11 = r7
            goto L_0x00c5
        L_0x00be:
            boolean r11 = android.text.TextUtils.isEmpty(r6)
            if (r11 != 0) goto L_0x00bc
            r11 = r6
        L_0x00c5:
            r10.addProperty((java.lang.String) r0, (java.lang.String) r11)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x00d5
            boolean r0 = r14.defaultIdFallbackDisabled
            if (r0 != 0) goto L_0x00d5
            r2.addProperty((java.lang.String) r9, (java.lang.String) r6)
        L_0x00d5:
            com.google.gson.JsonObject r0 = r14.deviceBody
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            java.lang.String r8 = "lmt"
            r0.addProperty((java.lang.String) r8, (java.lang.Number) r6)
            android.content.Context r0 = r14.context
            boolean r0 = isGooglePlayServicesAvailable(r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            java.lang.String r6 = "is_google_play_services_available"
            r2.addProperty((java.lang.String) r6, (java.lang.Boolean) r0)
            android.content.Context r0 = r14.context
            if (r0 == 0) goto L_0x00fe
            android.content.IntentFilter r6 = new android.content.IntentFilter
            java.lang.String r8 = "android.intent.action.BATTERY_CHANGED"
            r6.<init>(r8)
            android.content.Intent r3 = r0.registerReceiver(r3, r6)
        L_0x00fe:
            r0 = 4
            r6 = 2
            java.lang.String r8 = "UNKNOWN"
            if (r3 == 0) goto L_0x014b
            r9 = -1
            java.lang.String r10 = "level"
            int r10 = r3.getIntExtra(r10, r9)
            java.lang.String r11 = "scale"
            int r11 = r3.getIntExtra(r11, r9)
            if (r10 <= 0) goto L_0x0121
            if (r11 <= 0) goto L_0x0121
            float r10 = (float) r10
            float r11 = (float) r11
            float r10 = r10 / r11
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            java.lang.String r11 = "battery_level"
            r2.addProperty((java.lang.String) r11, (java.lang.Number) r10)
        L_0x0121:
            java.lang.String r10 = "status"
            int r10 = r3.getIntExtra(r10, r9)
            if (r10 != r9) goto L_0x012a
            goto L_0x014b
        L_0x012a:
            if (r10 == r6) goto L_0x0133
            r11 = 5
            if (r10 != r11) goto L_0x0130
            goto L_0x0133
        L_0x0130:
            java.lang.String r3 = "NOT_CHARGING"
            goto L_0x014c
        L_0x0133:
            java.lang.String r10 = "plugged"
            int r3 = r3.getIntExtra(r10, r9)
            if (r3 == r5) goto L_0x0148
            if (r3 == r6) goto L_0x0145
            if (r3 == r0) goto L_0x0142
            java.lang.String r3 = "BATTERY_PLUGGED_OTHERS"
            goto L_0x014c
        L_0x0142:
            java.lang.String r3 = "BATTERY_PLUGGED_WIRELESS"
            goto L_0x014c
        L_0x0145:
            java.lang.String r3 = "BATTERY_PLUGGED_USB"
            goto L_0x014c
        L_0x0148:
            java.lang.String r3 = "BATTERY_PLUGGED_AC"
            goto L_0x014c
        L_0x014b:
            r3 = r8
        L_0x014c:
            java.lang.String r9 = "battery_state"
            r2.addProperty((java.lang.String) r9, (java.lang.String) r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            r9 = 21
            if (r3 < r9) goto L_0x0175
            android.content.Context r3 = r14.context
            java.lang.String r9 = "power"
            java.lang.Object r3 = r3.getSystemService(r9)
            android.os.PowerManager r3 = (android.os.PowerManager) r3
            if (r3 == 0) goto L_0x016b
            boolean r3 = r3.isPowerSaveMode()
            if (r3 == 0) goto L_0x016b
            r3 = 1
            goto L_0x016c
        L_0x016b:
            r3 = 0
        L_0x016c:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r9 = "battery_saver_enabled"
            r2.addProperty((java.lang.String) r9, (java.lang.Number) r3)
        L_0x0175:
            android.content.Context r3 = r14.context
            java.lang.String r9 = "android.permission.ACCESS_NETWORK_STATE"
            int r3 = androidx.core.content.C0769b.m2414a(r3, r9)
            r9 = 3
            if (r3 != 0) goto L_0x0202
            android.content.Context r3 = r14.context
            java.lang.String r10 = "connectivity"
            java.lang.Object r3 = r3.getSystemService(r10)
            android.net.ConnectivityManager r3 = (android.net.ConnectivityManager) r3
            java.lang.String r10 = "unknown"
            if (r3 == 0) goto L_0x01bc
            android.net.NetworkInfo r11 = r3.getActiveNetworkInfo()
            if (r11 == 0) goto L_0x01bc
            int r12 = r11.getType()
            if (r12 == 0) goto L_0x01b1
            if (r12 == r5) goto L_0x01ae
            r11 = 6
            if (r12 == r11) goto L_0x01ae
            r11 = 7
            if (r12 == r11) goto L_0x01ab
            r11 = 9
            if (r12 == r11) goto L_0x01a8
            r11 = r8
            goto L_0x01be
        L_0x01a8:
            java.lang.String r11 = "ETHERNET"
            goto L_0x01be
        L_0x01ab:
            java.lang.String r11 = "BLUETOOTH"
            goto L_0x01be
        L_0x01ae:
            java.lang.String r11 = "WIFI"
            goto L_0x01be
        L_0x01b1:
            int r10 = r11.getSubtype()
            java.lang.String r10 = r14.getConnectionTypeDetail(r10)
            java.lang.String r11 = "MOBILE"
            goto L_0x01be
        L_0x01bc:
            java.lang.String r11 = "NONE"
        L_0x01be:
            java.lang.String r12 = "connection_type"
            r2.addProperty((java.lang.String) r12, (java.lang.String) r11)
            java.lang.String r11 = "connection_type_detail"
            r2.addProperty((java.lang.String) r11, (java.lang.String) r10)
            int r10 = android.os.Build.VERSION.SDK_INT
            r11 = 24
            if (r10 < r11) goto L_0x0202
            boolean r10 = r3.isActiveNetworkMetered()
            java.lang.String r11 = "network_metered"
            java.lang.String r12 = "data_saver_status"
            if (r10 == 0) goto L_0x01f6
            int r3 = r3.getRestrictBackgroundStatus()
            if (r3 == r5) goto L_0x01e9
            if (r3 == r6) goto L_0x01e6
            if (r3 == r9) goto L_0x01e3
            goto L_0x01eb
        L_0x01e3:
            java.lang.String r8 = "ENABLED"
            goto L_0x01eb
        L_0x01e6:
            java.lang.String r8 = "WHITELISTED"
            goto L_0x01eb
        L_0x01e9:
            java.lang.String r8 = "DISABLED"
        L_0x01eb:
            r2.addProperty((java.lang.String) r12, (java.lang.String) r8)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r2.addProperty((java.lang.String) r11, (java.lang.Number) r3)
            goto L_0x0202
        L_0x01f6:
            java.lang.String r3 = "NOT_APPLICABLE"
            r2.addProperty((java.lang.String) r12, (java.lang.String) r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r2.addProperty((java.lang.String) r11, (java.lang.Number) r3)
        L_0x0202:
            java.util.Locale r3 = java.util.Locale.getDefault()
            java.lang.String r3 = r3.toString()
            java.lang.String r6 = "locale"
            r2.addProperty((java.lang.String) r6, (java.lang.String) r3)
            java.util.Locale r3 = java.util.Locale.getDefault()
            java.lang.String r3 = r3.getLanguage()
            java.lang.String r6 = "language"
            r2.addProperty((java.lang.String) r6, (java.lang.String) r3)
            java.util.TimeZone r3 = java.util.TimeZone.getDefault()
            java.lang.String r3 = r3.getID()
            java.lang.String r6 = "time_zone"
            r2.addProperty((java.lang.String) r6, (java.lang.String) r3)
            android.content.Context r3 = r14.context
            java.lang.String r6 = "audio"
            java.lang.Object r3 = r3.getSystemService(r6)
            android.media.AudioManager r3 = (android.media.AudioManager) r3
            if (r3 == 0) goto L_0x0257
            int r6 = r3.getStreamMaxVolume(r9)
            int r3 = r3.getStreamVolume(r9)
            float r8 = (float) r3
            float r6 = (float) r6
            float r8 = r8 / r6
            java.lang.Float r6 = java.lang.Float.valueOf(r8)
            java.lang.String r8 = "volume_level"
            r2.addProperty((java.lang.String) r8, (java.lang.Number) r6)
            if (r3 <= 0) goto L_0x024d
            r3 = 1
            goto L_0x024e
        L_0x024d:
            r3 = 0
        L_0x024e:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r6 = "sound_enabled"
            r2.addProperty((java.lang.String) r6, (java.lang.Number) r3)
        L_0x0257:
            com.vungle.warren.persistence.CacheManager r3 = r14.cacheManager
            java.io.File r3 = r3.getCache()
            r3.getPath()
            boolean r6 = r3.exists()
            if (r6 == 0) goto L_0x027b
            boolean r3 = r3.isDirectory()
            if (r3 == 0) goto L_0x027b
            com.vungle.warren.persistence.CacheManager r3 = r14.cacheManager
            long r8 = r3.getBytesAvailable()
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            java.lang.String r6 = "storage_bytes_available"
            r2.addProperty((java.lang.String) r6, (java.lang.Number) r3)
        L_0x027b:
            java.lang.String r3 = android.os.Build.MANUFACTURER
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0294
            android.content.Context r0 = r14.context
            android.content.Context r0 = r0.getApplicationContext()
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            java.lang.String r3 = "amazon.hardware.fire_tv"
            boolean r0 = r0.hasSystemFeature(r3)
            goto L_0x02d3
        L_0x0294:
            int r3 = android.os.Build.VERSION.SDK_INT
            r6 = 23
            if (r3 < r6) goto L_0x02ae
            android.content.Context r3 = r14.context
            java.lang.String r6 = "uimode"
            java.lang.Object r3 = r3.getSystemService(r6)
            android.app.UiModeManager r3 = (android.app.UiModeManager) r3
            int r3 = r3.getCurrentModeType()
            if (r3 != r0) goto L_0x02ac
        L_0x02aa:
            r0 = 1
            goto L_0x02d3
        L_0x02ac:
            r0 = 0
            goto L_0x02d3
        L_0x02ae:
            android.content.Context r0 = r14.context
            android.content.Context r0 = r0.getApplicationContext()
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            java.lang.String r3 = "com.google.android.tv"
            boolean r0 = r0.hasSystemFeature(r3)
            if (r0 != 0) goto L_0x02aa
            android.content.Context r0 = r14.context
            android.content.Context r0 = r0.getApplicationContext()
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            java.lang.String r3 = "android.hardware.touchscreen"
            boolean r0 = r0.hasSystemFeature(r3)
            if (r0 != 0) goto L_0x02ac
            goto L_0x02aa
        L_0x02d3:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            java.lang.String r3 = "is_tv"
            r2.addProperty((java.lang.String) r3, (java.lang.Boolean) r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r3 = "os_api_level"
            r2.addProperty((java.lang.String) r3, (java.lang.Number) r0)
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ SettingNotFoundException -> 0x0317 }
            r3 = 26
            if (r0 < r3) goto L_0x0307
            android.content.Context r0 = r14.context     // Catch:{ SettingNotFoundException -> 0x0317 }
            java.lang.String r3 = "android.permission.REQUEST_INSTALL_PACKAGES"
            int r0 = r0.checkCallingOrSelfPermission(r3)     // Catch:{ SettingNotFoundException -> 0x0317 }
            if (r0 != 0) goto L_0x031f
            android.content.Context r0 = r14.context     // Catch:{ SettingNotFoundException -> 0x0317 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ SettingNotFoundException -> 0x0317 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ SettingNotFoundException -> 0x0317 }
            boolean r0 = r0.canRequestPackageInstalls()     // Catch:{ SettingNotFoundException -> 0x0317 }
            r4 = r0
            goto L_0x031f
        L_0x0307:
            android.content.Context r0 = r14.context     // Catch:{ SettingNotFoundException -> 0x0317 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x0317 }
            java.lang.String r3 = "install_non_market_apps"
            int r0 = android.provider.Settings.Secure.getInt(r0, r3)     // Catch:{ SettingNotFoundException -> 0x0317 }
            if (r0 != r5) goto L_0x031f
            r4 = 1
            goto L_0x031f
        L_0x0317:
            r0 = move-exception
            java.lang.String r3 = TAG
            java.lang.String r5 = "isInstallNonMarketAppsEnabled Settings not found"
            android.util.Log.e(r3, r5, r0)
        L_0x031f:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            java.lang.String r3 = "is_sideload_enabled"
            r2.addProperty((java.lang.String) r3, (java.lang.Boolean) r0)
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r3 = "mounted"
            boolean r0 = r0.equals(r3)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r3 = "sd_card_available"
            r2.addProperty((java.lang.String) r3, (java.lang.Number) r0)
            java.lang.String r0 = android.os.Build.FINGERPRINT
            java.lang.String r3 = "os_name"
            r2.addProperty((java.lang.String) r3, (java.lang.String) r0)
            java.lang.String r0 = "vduid"
            r2.addProperty((java.lang.String) r0, (java.lang.String) r7)
            com.google.gson.JsonObject r0 = r14.deviceBody
            java.lang.String r3 = "ext"
            com.google.gson.JsonObject r0 = r0.getAsJsonObject(r3)
            java.lang.String r3 = "vungle"
            com.google.gson.JsonObject r0 = r0.getAsJsonObject(r3)
            java.lang.String r3 = android.os.Build.MANUFACTURER
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0360
            java.lang.String r1 = "amazon"
            goto L_0x0362
        L_0x0360:
            java.lang.String r1 = "android"
        L_0x0362:
            r0.add(r1, r2)
            com.google.gson.JsonObject r0 = r14.deviceBody
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.VungleApiClient.getDeviceBody():com.google.gson.JsonObject");
    }

    private String getUserAgentFromCookie() {
        Cookie cookie = this.repository.load("userAgent", Cookie.class).get();
        if (cookie == null) {
            return System.getProperty("http.agent");
        }
        String string = cookie.getString("userAgent");
        return TextUtils.isEmpty(string) ? System.getProperty("http.agent") : string;
    }

    private JsonObject getUserBody() {
        long j;
        String str;
        String str2;
        String str3;
        Class<Cookie> cls = Cookie.class;
        JsonObject jsonObject = new JsonObject();
        Cookie cookie = this.repository.load(Cookie.CONSENT_COOKIE, cls).get();
        String str4 = "";
        if (cookie != null) {
            str2 = cookie.getString("consent_status");
            str = cookie.getString("consent_source");
            j = cookie.getLong("timestamp").longValue();
            str3 = cookie.getString("consent_message_version");
        } else {
            j = 0;
            str2 = "unknown";
            str = "no_interaction";
            str3 = str4;
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("consent_status", str2);
        jsonObject2.addProperty("consent_source", str);
        jsonObject2.addProperty("consent_timestamp", (Number) Long.valueOf(j));
        if (!TextUtils.isEmpty(str3)) {
            str4 = str3;
        }
        jsonObject2.addProperty("consent_message_version", str4);
        jsonObject.add("gdpr", jsonObject2);
        Cookie cookie2 = this.repository.load(Cookie.CCPA_COOKIE, cls).get();
        String string = cookie2 != null ? cookie2.getString(Cookie.CCPA_CONSENT_STATUS) : Cookie.CONSENT_STATUS_OPTED_IN;
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("status", string);
        jsonObject.add("ccpa", jsonObject3);
        return jsonObject;
    }

    private void initUserAgentLazy() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    String unused = VungleApiClient.this.uaString = WebSettings.getDefaultUserAgent(VungleApiClient.this.context);
                    VungleApiClient.this.deviceBody.addProperty("ua", VungleApiClient.this.uaString);
                    VungleApiClient.this.addUserAgentInCookie(VungleApiClient.this.uaString);
                } catch (Exception e) {
                    String access$100 = VungleApiClient.TAG;
                    Log.e(access$100, "Cannot Get UserAgent. Setting Default Device UserAgent." + e.getLocalizedMessage());
                }
            }
        }).start();
    }

    public static boolean isGooglePlayServicesAvailable(Context context2) {
        try {
            GoogleApiAvailabilityLight instance = GoogleApiAvailabilityLight.getInstance();
            if (instance == null || instance.isGooglePlayServicesAvailable(context2) != 0) {
                return false;
            }
            return true;
        } catch (NoClassDefFoundError unused) {
            Log.w(TAG, "Play services Not available");
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean canCallWillPlayAd() {
        return this.willPlayAdEnabled && !TextUtils.isEmpty(this.willPlayAdEndpoint);
    }

    public Response config() throws VungleException, IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, getDeviceBody());
        jsonObject.add(TapjoyConstants.TJC_APP_PLACEMENT, this.appBody);
        jsonObject.add(QumparaOfferwallUtil.TABLE_NAME, getUserBody());
        Response<JsonObject> execute = this.api.config(HEADER_UA, jsonObject).execute();
        if (!execute.isSuccessful()) {
            return execute;
        }
        JsonObject body = execute.body();
        "Config Response: " + body;
        if (JsonUtil.hasNonNull(body, "sleep")) {
            String asString = JsonUtil.hasNonNull(body, TJAdUnitConstants.String.VIDEO_INFO) ? body.get(TJAdUnitConstants.String.VIDEO_INFO).getAsString() : "";
            Log.e(TAG, "Error Initializing Vungle. Please try again. " + asString);
            throw new VungleException(3);
        } else if (JsonUtil.hasNonNull(body, "endpoints")) {
            JsonObject asJsonObject = body.getAsJsonObject("endpoints");
            C3539s e = C3539s.m11859e(asJsonObject.get(AdMostExperimentManager.EXPERIMENT_TYPE_NEW_INSTALL).getAsString());
            C3539s e2 = C3539s.m11859e(asJsonObject.get("ads").getAsString());
            C3539s e3 = C3539s.m11859e(asJsonObject.get("will_play_ad").getAsString());
            C3539s e4 = C3539s.m11859e(asJsonObject.get("report_ad").getAsString());
            C3539s e5 = C3539s.m11859e(asJsonObject.get("ri").getAsString());
            if (e == null || e2 == null || e3 == null || e4 == null || e5 == null) {
                Log.e(TAG, "Error Initializing Vungle. Please try again. ");
                throw new VungleException(3);
            }
            this.newEndpoint = e.toString();
            this.requestAdEndpoint = e2.toString();
            this.willPlayAdEndpoint = e3.toString();
            this.reportAdEndpoint = e4.toString();
            this.riEndpoint = e5.toString();
            JsonObject asJsonObject2 = body.getAsJsonObject("will_play_ad");
            this.willPlayAdTimeout = asJsonObject2.get("request_timeout").getAsInt();
            this.willPlayAdEnabled = asJsonObject2.get("enabled").getAsBoolean();
            this.enableMoat = body.getAsJsonObject("viewability").get("moat").getAsBoolean();
            if (this.willPlayAdEnabled) {
                C3542v.C3544b r = this.client.mo19572r();
                r.mo19586b((long) this.willPlayAdTimeout, TimeUnit.MILLISECONDS);
                this.timeoutApi = new APIFactory(r.mo19585a(), "https://api.vungle.com/").createAPI();
            }
            if (getMoatEnabled()) {
                MoatOptions moatOptions = new MoatOptions();
                moatOptions.disableAdIdCollection = true;
                moatOptions.disableLocationServices = true;
                moatOptions.loggingEnabled = true;
                MoatAnalytics.getInstance().start(moatOptions, (Application) this.context.getApplicationContext());
            }
            return execute;
        } else {
            Log.e(TAG, "Error Initializing Vungle. Please try again. ");
            throw new VungleException(3);
        }
    }

    public boolean getMoatEnabled() {
        return this.enableMoat && Build.VERSION.SDK_INT >= 16;
    }

    public long getRetryAfterHeaderValue(Response response) {
        try {
            return Long.parseLong(response.headers().mo19502a("Retry-After")) * 1000;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public void init(String str) {
        init(this.context, str);
    }

    /* access modifiers changed from: package-private */
    public void overrideApi(VungleApi vungleApi) {
        this.api = vungleApi;
    }

    public boolean pingTPAT(String str) throws ClearTextTrafficException, MalformedURLException {
        boolean z;
        if (TextUtils.isEmpty(str) || C3539s.m11859e(str) == null) {
            throw new MalformedURLException("Invalid URL : " + str);
        }
        try {
            String host = new URL(str).getHost();
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                z = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(host);
            } else {
                z = i >= 23 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() : true;
            }
            if (z || !URLUtil.isHttpUrl(str)) {
                if (!TextUtils.isEmpty(this.userImei) && this.shouldTransmitIMEI) {
                    str = str.replace("%imei%", this.userImei);
                }
                try {
                    this.api.pingTPAT(this.uaString, str).execute();
                    return true;
                } catch (IOException unused) {
                    return false;
                }
            } else {
                throw new ClearTextTrafficException("Clear Text Traffic is blocked");
            }
        } catch (MalformedURLException unused2) {
            throw new MalformedURLException("Invalid URL : " + str);
        }
    }

    public Call<JsonObject> reportAd(JsonObject jsonObject) {
        if (this.reportAdEndpoint != null) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, getDeviceBody());
            jsonObject2.add(TapjoyConstants.TJC_APP_PLACEMENT, this.appBody);
            jsonObject2.add(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, jsonObject);
            jsonObject2.add(QumparaOfferwallUtil.TABLE_NAME, getUserBody());
            return this.gzipApi.reportAd(HEADER_UA, this.reportAdEndpoint, jsonObject2);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public Call<JsonObject> reportNew() throws IllegalStateException {
        if (this.newEndpoint != null) {
            HashMap hashMap = new HashMap(2);
            JsonElement jsonElement = this.appBody.get("id");
            JsonElement jsonElement2 = this.deviceBody.get("ifa");
            String str = "";
            hashMap.put("app_id", jsonElement != null ? jsonElement.getAsString() : str);
            if (jsonElement2 != null) {
                str = jsonElement2.getAsString();
            }
            hashMap.put("ifa", str);
            return this.api.reportNew(HEADER_UA, this.newEndpoint, hashMap);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public Call<JsonObject> requestAd(String str, String str2, boolean z, JsonObject jsonObject) throws IllegalStateException {
        if (this.requestAdEndpoint != null) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, getDeviceBody());
            jsonObject2.add(TapjoyConstants.TJC_APP_PLACEMENT, this.appBody);
            JsonObject userBody2 = getUserBody();
            if (jsonObject != null) {
                userBody2.add("vision", jsonObject);
            }
            jsonObject2.add(QumparaOfferwallUtil.TABLE_NAME, userBody2);
            JsonObject jsonObject3 = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            jsonArray.add(str);
            jsonObject3.add("placements", jsonArray);
            jsonObject3.addProperty("header_bidding", Boolean.valueOf(z));
            if (!TextUtils.isEmpty(str2)) {
                jsonObject3.addProperty("ad_size", str2);
            }
            jsonObject2.add(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, jsonObject3);
            return this.gzipApi.ads(HEADER_UA, this.requestAdEndpoint, jsonObject2);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    /* renamed from: ri */
    public Call<JsonObject> mo32288ri(JsonObject jsonObject) {
        if (this.riEndpoint != null) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, getDeviceBody());
            jsonObject2.add(TapjoyConstants.TJC_APP_PLACEMENT, this.appBody);
            jsonObject2.add(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, jsonObject);
            return this.api.mo32534ri(HEADER_UA, this.riEndpoint, jsonObject2);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public void setDefaultIdFallbackDisabled(boolean z) {
        this.defaultIdFallbackDisabled = z;
    }

    public void updateIMEI(String str, boolean z) {
        this.userImei = str;
        this.shouldTransmitIMEI = z;
    }

    /* access modifiers changed from: package-private */
    public Call<JsonObject> willPlayAd(String str, boolean z, String str2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, getDeviceBody());
        jsonObject.add(TapjoyConstants.TJC_APP_PLACEMENT, this.appBody);
        jsonObject.add(QumparaOfferwallUtil.TABLE_NAME, getUserBody());
        JsonObject jsonObject2 = new JsonObject();
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("reference_id", str);
        jsonObject3.addProperty("is_auto_cached", Boolean.valueOf(z));
        jsonObject2.add("placement", jsonObject3);
        jsonObject2.addProperty(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_AD_TOKEN, str2);
        jsonObject.add(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, jsonObject2);
        return this.timeoutApi.willPlayAd(HEADER_UA, this.willPlayAdEndpoint, jsonObject);
    }

    private synchronized void init(final Context context2, String str) {
        this.shouldTransmitIMEI = false;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", str);
        jsonObject.addProperty(TJAdUnitConstants.String.BUNDLE, context2.getPackageName());
        String str2 = null;
        try {
            str2 = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (str2 == null) {
            str2 = "1.0";
        }
        jsonObject.addProperty("ver", str2);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("make", Build.MANUFACTURER);
        jsonObject2.addProperty("model", Build.MODEL);
        jsonObject2.addProperty("osv", Build.VERSION.RELEASE);
        jsonObject2.addProperty("carrier", ((TelephonyManager) context2.getSystemService(PlaceFields.PHONE)).getNetworkOperatorName());
        jsonObject2.addProperty("os", MANUFACTURER_AMAZON.equals(Build.MANUFACTURER) ? "amazon" : "android");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context2.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        jsonObject2.addProperty("w", (Number) Integer.valueOf(displayMetrics.widthPixels));
        jsonObject2.addProperty("h", (Number) Integer.valueOf(displayMetrics.heightPixels));
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.add("vungle", new JsonObject());
        jsonObject2.add("ext", jsonObject3);
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                this.uaString = getUserAgentFromCookie();
                initUserAgentLazy();
            } else if (Looper.getMainLooper() == Looper.myLooper()) {
                this.uaString = ViewUtility.getWebView(context2.getApplicationContext()).getSettings().getUserAgentString();
            } else {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        try {
                            String unused = VungleApiClient.this.uaString = ViewUtility.getWebView(context2.getApplicationContext()).getSettings().getUserAgentString();
                        } catch (InstantiationException e) {
                            String access$100 = VungleApiClient.TAG;
                            Log.e(access$100, "Cannot Get UserAgent. Setting Default Device UserAgent." + e.getLocalizedMessage());
                        }
                        countDownLatch.countDown();
                    }
                });
                if (!countDownLatch.await(2, TimeUnit.SECONDS)) {
                    Log.e(TAG, "Unable to get User Agent String in specified time");
                }
            }
        } catch (Exception e) {
            String str3 = TAG;
            Log.e(str3, "Cannot Get UserAgent. Setting Default Device UserAgent." + e.getLocalizedMessage());
        }
        jsonObject2.addProperty("ua", this.uaString);
        this.deviceBody = jsonObject2;
        this.appBody = jsonObject;
    }
}
