package p093e.p094a.p095a;

import android.content.ContentResolver;
import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.tapjoy.TapjoyConstants;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: e.a.a.o0 */
/* compiled from: PackageBuilder */
public class C3321o0 {

    /* renamed from: o */
    private static C3364y f9283o = C3309k.m11002d();

    /* renamed from: a */
    private long f9284a;

    /* renamed from: b */
    private C3345t f9285b;

    /* renamed from: c */
    private C3301g f9286c;

    /* renamed from: d */
    private C3322a f9287d;

    /* renamed from: e */
    private C3361w0 f9288e;

    /* renamed from: f */
    long f9289f = -1;

    /* renamed from: g */
    long f9290g = -1;

    /* renamed from: h */
    long f9291h = -1;

    /* renamed from: i */
    String f9292i;

    /* renamed from: j */
    String f9293j;

    /* renamed from: k */
    String f9294k;

    /* renamed from: l */
    String f9295l;

    /* renamed from: m */
    C3299f f9296m;

    /* renamed from: n */
    Map<String, String> f9297n;

    /* renamed from: e.a.a.o0$a */
    /* compiled from: PackageBuilder */
    private class C3322a {

        /* renamed from: a */
        int f9298a = -1;

        /* renamed from: b */
        int f9299b = -1;

        /* renamed from: c */
        int f9300c = -1;

        /* renamed from: d */
        long f9301d = -1;

        /* renamed from: e */
        long f9302e = -1;

        /* renamed from: f */
        long f9303f = -1;

        /* renamed from: g */
        String f9304g = null;

        /* renamed from: h */
        String f9305h = null;

        C3322a(C3321o0 o0Var, C3294d dVar) {
            if (dVar != null) {
                this.f9298a = dVar.f9150e;
                this.f9299b = dVar.f9151f;
                this.f9300c = dVar.f9152g;
                this.f9301d = dVar.f9154i;
                this.f9302e = dVar.f9156k;
                this.f9303f = dVar.f9153h;
                this.f9304g = dVar.f9146a;
                this.f9305h = dVar.f9159n;
            }
        }
    }

    C3321o0(C3301g gVar, C3345t tVar, C3294d dVar, C3361w0 w0Var, long j) {
        this.f9284a = j;
        this.f9285b = tVar;
        this.f9286c = gVar;
        this.f9287d = new C3322a(this, dVar);
        this.f9288e = w0Var;
    }

    /* renamed from: d */
    private Map<String, String> m11043d(String str) {
        ContentResolver contentResolver = this.f9286c.f9194c.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> a = C3341r0.m11115a(this.f9286c.f9194c, f9283o);
        if (a != null) {
            hashMap.putAll(a);
        }
        this.f9285b.mo19093b(this.f9286c.f9194c);
        m11035a((Map<String, String>) hashMap, "android_uuid", this.f9287d.f9304g);
        m11033a((Map<String, String>) hashMap, "tracking_enabled", this.f9285b.f9367c);
        m11035a((Map<String, String>) hashMap, "gps_adid", this.f9285b.f9365a);
        m11035a((Map<String, String>) hashMap, "gps_adid_src", this.f9285b.f9366b);
        if (!m11041b((Map<String, String>) hashMap)) {
            f9283o.mo19021b("Google Advertising ID not detected, fallback to non Google Play identifiers will take place", new Object[0]);
            this.f9285b.mo19092a(this.f9286c.f9194c);
            m11035a((Map<String, String>) hashMap, "mac_sha1", this.f9285b.f9369e);
            m11035a((Map<String, String>) hashMap, "mac_md5", this.f9285b.f9370f);
            m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_ANDROID_ID, this.f9285b.f9371g);
        }
        m11035a((Map<String, String>) hashMap, "api_level", this.f9285b.f9381q);
        m11035a((Map<String, String>) hashMap, "app_secret", this.f9286c.f9191A);
        m11035a((Map<String, String>) hashMap, "app_token", this.f9286c.f9195d);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_APP_VERSION_NAME, this.f9285b.f9375k);
        m11033a((Map<String, String>) hashMap, "attribution_deeplink", (Boolean) true);
        m11032a((Map<String, String>) hashMap, "created_at", this.f9284a);
        m11033a((Map<String, String>) hashMap, "device_known", this.f9286c.f9202k);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_NAME, this.f9285b.f9377m);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_TYPE_NAME, this.f9285b.f9376l);
        m11035a((Map<String, String>) hashMap, "environment", this.f9286c.f9196e);
        m11033a((Map<String, String>) hashMap, "event_buffering_enabled", Boolean.valueOf(this.f9286c.f9199h));
        m11035a((Map<String, String>) hashMap, "fire_adid", C3268a1.m10828a(contentResolver));
        m11033a((Map<String, String>) hashMap, "fire_tracking_enabled", C3268a1.m10851b(contentResolver));
        m11035a((Map<String, String>) hashMap, "initiated_by", str);
        m11033a((Map<String, String>) hashMap, "needs_response_details", (Boolean) true);
        m11035a((Map<String, String>) hashMap, "os_name", this.f9285b.f9379o);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, this.f9285b.f9380p);
        m11035a((Map<String, String>) hashMap, "package_name", this.f9285b.f9374j);
        m11035a((Map<String, String>) hashMap, "push_token", this.f9287d.f9305h);
        m11035a((Map<String, String>) hashMap, "secret_id", this.f9286c.f9217z);
        m11031a((Map<String, String>) hashMap);
        return hashMap;
    }

    /* renamed from: e */
    private Map<String, String> m11045e(String str) {
        ContentResolver contentResolver = this.f9286c.f9194c.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> a = C3341r0.m11115a(this.f9286c.f9194c, f9283o);
        if (a != null) {
            hashMap.putAll(a);
        }
        this.f9285b.mo19093b(this.f9286c.f9194c);
        m11035a((Map<String, String>) hashMap, "android_uuid", this.f9287d.f9304g);
        m11033a((Map<String, String>) hashMap, "tracking_enabled", this.f9285b.f9367c);
        m11035a((Map<String, String>) hashMap, "gps_adid", this.f9285b.f9365a);
        m11035a((Map<String, String>) hashMap, "gps_adid_src", this.f9285b.f9366b);
        if (!m11041b((Map<String, String>) hashMap)) {
            f9283o.mo19021b("Google Advertising ID not detected, fallback to non Google Play identifiers will take place", new Object[0]);
            this.f9285b.mo19092a(this.f9286c.f9194c);
            m11035a((Map<String, String>) hashMap, "mac_sha1", this.f9285b.f9369e);
            m11035a((Map<String, String>) hashMap, "mac_md5", this.f9285b.f9370f);
            m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_ANDROID_ID, this.f9285b.f9371g);
        }
        C3299f fVar = this.f9296m;
        if (fVar != null) {
            m11035a((Map<String, String>) hashMap, "tracker", fVar.f9176b);
            m11035a((Map<String, String>) hashMap, "campaign", this.f9296m.f9178d);
            m11035a((Map<String, String>) hashMap, "adgroup", this.f9296m.f9179e);
            m11035a((Map<String, String>) hashMap, VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE, this.f9296m.f9180f);
        }
        m11035a((Map<String, String>) hashMap, "api_level", this.f9285b.f9381q);
        m11035a((Map<String, String>) hashMap, "app_secret", this.f9286c.f9191A);
        m11035a((Map<String, String>) hashMap, "app_token", this.f9286c.f9195d);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_APP_VERSION_NAME, this.f9285b.f9375k);
        m11033a((Map<String, String>) hashMap, "attribution_deeplink", (Boolean) true);
        m11037a((Map<String, String>) hashMap, "callback_params", this.f9288e.f9425a);
        m11032a((Map<String, String>) hashMap, "click_time", this.f9290g);
        m11040b(hashMap, "click_time", this.f9289f);
        m11044d(hashMap, "connectivity_type", (long) C3268a1.m10850b(this.f9286c.f9194c));
        m11035a((Map<String, String>) hashMap, UserDataStore.COUNTRY, this.f9285b.f9383s);
        m11035a((Map<String, String>) hashMap, "cpu_type", this.f9285b.f9390z);
        m11032a((Map<String, String>) hashMap, "created_at", this.f9284a);
        m11035a((Map<String, String>) hashMap, "deeplink", this.f9293j);
        m11033a((Map<String, String>) hashMap, "device_known", this.f9286c.f9202k);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_MANUFACTURER, this.f9285b.f9378n);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_NAME, this.f9285b.f9377m);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_TYPE_NAME, this.f9285b.f9376l);
        m11035a((Map<String, String>) hashMap, "display_height", this.f9285b.f9388x);
        m11035a((Map<String, String>) hashMap, "display_width", this.f9285b.f9387w);
        m11035a((Map<String, String>) hashMap, "environment", this.f9286c.f9196e);
        m11033a((Map<String, String>) hashMap, "event_buffering_enabled", Boolean.valueOf(this.f9286c.f9199h));
        m11035a((Map<String, String>) hashMap, "fb_id", this.f9285b.f9372h);
        m11035a((Map<String, String>) hashMap, "fire_adid", C3268a1.m10828a(contentResolver));
        m11033a((Map<String, String>) hashMap, "fire_tracking_enabled", C3268a1.m10851b(contentResolver));
        m11035a((Map<String, String>) hashMap, "hardware_name", this.f9285b.f9389y);
        m11040b(hashMap, "install_begin_time", this.f9291h);
        m11035a((Map<String, String>) hashMap, "installed_at", this.f9285b.f9363B);
        m11035a((Map<String, String>) hashMap, "language", this.f9285b.f9382r);
        m11042c(hashMap, "last_interval", this.f9287d.f9302e);
        m11035a((Map<String, String>) hashMap, "mcc", C3268a1.m10859d(this.f9286c.f9194c));
        m11035a((Map<String, String>) hashMap, "mnc", C3268a1.m10862e(this.f9286c.f9194c));
        m11033a((Map<String, String>) hashMap, "needs_response_details", (Boolean) true);
        m11044d(hashMap, "network_type", (long) C3268a1.m10865f(this.f9286c.f9194c));
        m11035a((Map<String, String>) hashMap, "os_build", this.f9285b.f9362A);
        m11035a((Map<String, String>) hashMap, "os_name", this.f9285b.f9379o);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, this.f9285b.f9380p);
        m11035a((Map<String, String>) hashMap, "package_name", this.f9285b.f9374j);
        m11037a((Map<String, String>) hashMap, NativeProtocol.WEB_DIALOG_PARAMS, this.f9297n);
        m11037a((Map<String, String>) hashMap, "partner_params", this.f9288e.f9426b);
        m11035a((Map<String, String>) hashMap, "push_token", this.f9287d.f9305h);
        m11035a((Map<String, String>) hashMap, "raw_referrer", this.f9295l);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_REFERRER, this.f9294k);
        m11035a((Map<String, String>) hashMap, "reftag", this.f9292i);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_SCREEN_DENSITY, this.f9285b.f9386v);
        m11035a((Map<String, String>) hashMap, "screen_format", this.f9285b.f9385u);
        m11035a((Map<String, String>) hashMap, "screen_size", this.f9285b.f9384t);
        m11035a((Map<String, String>) hashMap, "secret_id", this.f9286c.f9217z);
        m11044d(hashMap, "session_count", (long) this.f9287d.f9299b);
        m11042c(hashMap, "session_length", this.f9287d.f9303f);
        m11035a((Map<String, String>) hashMap, ShareConstants.FEED_SOURCE_PARAM, str);
        m11044d(hashMap, "subsession_count", (long) this.f9287d.f9300c);
        m11042c(hashMap, "time_spent", this.f9287d.f9301d);
        m11035a((Map<String, String>) hashMap, "updated_at", this.f9285b.f9364C);
        m11031a((Map<String, String>) hashMap);
        return hashMap;
    }

    /* renamed from: f */
    private Map<String, String> m11046f(String str) {
        ContentResolver contentResolver = this.f9286c.f9194c.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> a = C3341r0.m11115a(this.f9286c.f9194c, f9283o);
        if (a != null) {
            hashMap.putAll(a);
        }
        this.f9285b.mo19093b(this.f9286c.f9194c);
        m11035a((Map<String, String>) hashMap, "android_uuid", this.f9287d.f9304g);
        m11033a((Map<String, String>) hashMap, "tracking_enabled", this.f9285b.f9367c);
        m11035a((Map<String, String>) hashMap, "gps_adid", this.f9285b.f9365a);
        m11035a((Map<String, String>) hashMap, "gps_adid_src", this.f9285b.f9366b);
        if (!m11041b((Map<String, String>) hashMap)) {
            f9283o.mo19021b("Google Advertising ID not detected, fallback to non Google Play identifiers will take place", new Object[0]);
            this.f9285b.mo19092a(this.f9286c.f9194c);
            m11035a((Map<String, String>) hashMap, "mac_sha1", this.f9285b.f9369e);
            m11035a((Map<String, String>) hashMap, "mac_md5", this.f9285b.f9370f);
            m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_ANDROID_ID, this.f9285b.f9371g);
        }
        m11035a((Map<String, String>) hashMap, "app_secret", this.f9286c.f9191A);
        m11035a((Map<String, String>) hashMap, "app_token", this.f9286c.f9195d);
        m11033a((Map<String, String>) hashMap, "attribution_deeplink", (Boolean) true);
        m11032a((Map<String, String>) hashMap, "created_at", this.f9284a);
        m11033a((Map<String, String>) hashMap, "device_known", this.f9286c.f9202k);
        m11035a((Map<String, String>) hashMap, "environment", this.f9286c.f9196e);
        m11033a((Map<String, String>) hashMap, "event_buffering_enabled", Boolean.valueOf(this.f9286c.f9199h));
        m11035a((Map<String, String>) hashMap, "fire_adid", C3268a1.m10828a(contentResolver));
        m11033a((Map<String, String>) hashMap, "fire_tracking_enabled", C3268a1.m10851b(contentResolver));
        m11033a((Map<String, String>) hashMap, "needs_response_details", (Boolean) true);
        m11035a((Map<String, String>) hashMap, "push_token", this.f9287d.f9305h);
        m11035a((Map<String, String>) hashMap, "secret_id", this.f9286c.f9217z);
        m11035a((Map<String, String>) hashMap, ShareConstants.FEED_SOURCE_PARAM, str);
        m11031a((Map<String, String>) hashMap);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3276c mo19055a(boolean z) {
        Map<String, String> b = m11039b(z);
        C3276c a = m11029a(C3270b.SESSION);
        a.mo18960b("/session");
        a.mo18964c("");
        a.mo18961b(b);
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C3276c mo19056b(String str) {
        Map<String, String> e = m11045e(str);
        C3276c a = m11029a(C3270b.CLICK);
        a.mo18960b("/sdk_click");
        a.mo18964c("");
        a.mo18955a(this.f9290g);
        a.mo18959b(this.f9289f);
        a.mo18963c(this.f9291h);
        a.mo18961b(e);
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C3276c mo19058c(String str) {
        Map<String, String> f = m11046f(str);
        C3276c a = m11029a(C3270b.INFO);
        a.mo18960b("/sdk_info");
        a.mo18964c("");
        a.mo18961b(f);
        return a;
    }

    /* renamed from: c */
    private static void m11042c(Map<String, String> map, String str, long j) {
        if (j >= 0) {
            m11044d(map, str, (j + 500) / 1000);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3276c mo19053a(C3303h hVar, boolean z) {
        Map<String, String> b = mo19057b(hVar, z);
        C3276c a = m11029a(C3270b.EVENT);
        a.mo18960b("/event");
        a.mo18964c(m11030a(hVar));
        a.mo18961b(b);
        if (z) {
            a.mo18957a(hVar.f9226d);
            a.mo18965c(hVar.f9227e);
        }
        return a;
    }

    /* renamed from: b */
    private Map<String, String> m11039b(boolean z) {
        ContentResolver contentResolver = this.f9286c.f9194c.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> a = C3341r0.m11115a(this.f9286c.f9194c, f9283o);
        if (a != null) {
            hashMap.putAll(a);
        }
        if (!z) {
            m11037a((Map<String, String>) hashMap, "callback_params", this.f9288e.f9425a);
            m11037a((Map<String, String>) hashMap, "partner_params", this.f9288e.f9426b);
        }
        this.f9285b.mo19093b(this.f9286c.f9194c);
        m11035a((Map<String, String>) hashMap, "android_uuid", this.f9287d.f9304g);
        m11033a((Map<String, String>) hashMap, "tracking_enabled", this.f9285b.f9367c);
        m11035a((Map<String, String>) hashMap, "gps_adid", this.f9285b.f9365a);
        m11035a((Map<String, String>) hashMap, "gps_adid_src", this.f9285b.f9366b);
        if (!m11041b((Map<String, String>) hashMap)) {
            f9283o.mo19021b("Google Advertising ID not detected, fallback to non Google Play identifiers will take place", new Object[0]);
            this.f9285b.mo19092a(this.f9286c.f9194c);
            m11035a((Map<String, String>) hashMap, "mac_sha1", this.f9285b.f9369e);
            m11035a((Map<String, String>) hashMap, "mac_md5", this.f9285b.f9370f);
            m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_ANDROID_ID, this.f9285b.f9371g);
        }
        m11035a((Map<String, String>) hashMap, "api_level", this.f9285b.f9381q);
        m11035a((Map<String, String>) hashMap, "app_secret", this.f9286c.f9191A);
        m11035a((Map<String, String>) hashMap, "app_token", this.f9286c.f9195d);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_APP_VERSION_NAME, this.f9285b.f9375k);
        m11033a((Map<String, String>) hashMap, "attribution_deeplink", (Boolean) true);
        m11044d(hashMap, "connectivity_type", (long) C3268a1.m10850b(this.f9286c.f9194c));
        m11035a((Map<String, String>) hashMap, UserDataStore.COUNTRY, this.f9285b.f9383s);
        m11035a((Map<String, String>) hashMap, "cpu_type", this.f9285b.f9390z);
        m11032a((Map<String, String>) hashMap, "created_at", this.f9284a);
        m11035a((Map<String, String>) hashMap, "default_tracker", this.f9286c.f9200i);
        m11033a((Map<String, String>) hashMap, "device_known", this.f9286c.f9202k);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_MANUFACTURER, this.f9285b.f9378n);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_NAME, this.f9285b.f9377m);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_TYPE_NAME, this.f9285b.f9376l);
        m11035a((Map<String, String>) hashMap, "display_height", this.f9285b.f9388x);
        m11035a((Map<String, String>) hashMap, "display_width", this.f9285b.f9387w);
        m11035a((Map<String, String>) hashMap, "environment", this.f9286c.f9196e);
        m11033a((Map<String, String>) hashMap, "event_buffering_enabled", Boolean.valueOf(this.f9286c.f9199h));
        m11035a((Map<String, String>) hashMap, "fb_id", this.f9285b.f9372h);
        m11035a((Map<String, String>) hashMap, "fire_adid", C3268a1.m10828a(contentResolver));
        m11033a((Map<String, String>) hashMap, "fire_tracking_enabled", C3268a1.m10851b(contentResolver));
        m11035a((Map<String, String>) hashMap, "hardware_name", this.f9285b.f9389y);
        m11035a((Map<String, String>) hashMap, "installed_at", this.f9285b.f9363B);
        m11035a((Map<String, String>) hashMap, "language", this.f9285b.f9382r);
        m11042c(hashMap, "last_interval", this.f9287d.f9302e);
        m11035a((Map<String, String>) hashMap, "mcc", C3268a1.m10859d(this.f9286c.f9194c));
        m11035a((Map<String, String>) hashMap, "mnc", C3268a1.m10862e(this.f9286c.f9194c));
        m11033a((Map<String, String>) hashMap, "needs_response_details", (Boolean) true);
        m11044d(hashMap, "network_type", (long) C3268a1.m10865f(this.f9286c.f9194c));
        m11035a((Map<String, String>) hashMap, "os_build", this.f9285b.f9362A);
        m11035a((Map<String, String>) hashMap, "os_name", this.f9285b.f9379o);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, this.f9285b.f9380p);
        m11035a((Map<String, String>) hashMap, "package_name", this.f9285b.f9374j);
        m11035a((Map<String, String>) hashMap, "push_token", this.f9287d.f9305h);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_SCREEN_DENSITY, this.f9285b.f9386v);
        m11035a((Map<String, String>) hashMap, "screen_format", this.f9285b.f9385u);
        m11035a((Map<String, String>) hashMap, "screen_size", this.f9285b.f9384t);
        m11035a((Map<String, String>) hashMap, "secret_id", this.f9286c.f9217z);
        m11044d(hashMap, "session_count", (long) this.f9287d.f9299b);
        m11042c(hashMap, "session_length", this.f9287d.f9303f);
        m11044d(hashMap, "subsession_count", (long) this.f9287d.f9300c);
        m11042c(hashMap, "time_spent", this.f9287d.f9301d);
        m11035a((Map<String, String>) hashMap, "updated_at", this.f9285b.f9364C);
        m11031a((Map<String, String>) hashMap);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3276c mo19054a(String str) {
        Map<String, String> d = m11043d(str);
        C3276c a = m11029a(C3270b.ATTRIBUTION);
        a.mo18960b("attribution");
        a.mo18964c("");
        a.mo18961b(d);
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3276c mo19052a() {
        Map<String, String> b = m11038b();
        C3276c a = m11029a(C3270b.GDPR);
        a.mo18960b("/gdpr_forget_device");
        a.mo18964c("");
        a.mo18961b(b);
        return a;
    }

    /* renamed from: a */
    private C3276c m11029a(C3270b bVar) {
        C3276c cVar = new C3276c(bVar);
        cVar.mo18956a(this.f9285b.f9373i);
        return cVar;
    }

    /* renamed from: a */
    public static void m11035a(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    /* renamed from: a */
    public static void m11033a(Map<String, String> map, String str, Boolean bool) {
        if (bool != null) {
            m11044d(map, str, bool.booleanValue() ? 1 : 0);
        }
    }

    /* renamed from: a */
    static void m11037a(Map<String, String> map, String str, Map<String, String> map2) {
        if (map2 != null && map2.size() != 0) {
            m11035a(map, str, new JSONObject(map2).toString());
        }
    }

    /* renamed from: a */
    private static void m11032a(Map<String, String> map, String str, long j) {
        if (j > 0) {
            m11036a(map, str, new Date(j));
        }
    }

    /* renamed from: a */
    private static void m11036a(Map<String, String> map, String str, Date date) {
        if (date != null) {
            m11035a(map, str, C3268a1.f9092b.format(date));
        }
    }

    /* renamed from: a */
    private static void m11034a(Map<String, String> map, String str, Double d) {
        if (d != null) {
            m11035a(map, str, C3268a1.m10834a("%.5f", d));
        }
    }

    /* renamed from: d */
    private static void m11044d(Map<String, String> map, String str, long j) {
        if (j >= 0) {
            m11035a(map, str, Long.toString(j));
        }
    }

    /* renamed from: a */
    private void m11031a(Map<String, String> map) {
        if (map != null && !map.containsKey("mac_sha1") && !map.containsKey("mac_md5") && !map.containsKey(TapjoyConstants.TJC_ANDROID_ID) && !map.containsKey("gps_adid")) {
            f9283o.mo19022c("Missing device id's. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
        }
    }

    /* renamed from: a */
    private String m11030a(C3303h hVar) {
        Double d = hVar.f9224b;
        if (d == null) {
            return C3268a1.m10834a("'%s'", hVar.f9223a);
        }
        return C3268a1.m10834a("(%.5f %s, '%s')", d, hVar.f9225c, hVar.f9223a);
    }

    /* renamed from: b */
    public Map<String, String> mo19057b(C3303h hVar, boolean z) {
        ContentResolver contentResolver = this.f9286c.f9194c.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> a = C3341r0.m11115a(this.f9286c.f9194c, f9283o);
        if (a != null) {
            hashMap.putAll(a);
        }
        if (!z) {
            m11037a((Map<String, String>) hashMap, "callback_params", C3268a1.m10837a(this.f9288e.f9425a, hVar.f9226d, "Callback"));
            m11037a((Map<String, String>) hashMap, "partner_params", C3268a1.m10837a(this.f9288e.f9426b, hVar.f9227e, "Partner"));
        }
        this.f9285b.mo19093b(this.f9286c.f9194c);
        m11035a((Map<String, String>) hashMap, "android_uuid", this.f9287d.f9304g);
        m11033a((Map<String, String>) hashMap, "tracking_enabled", this.f9285b.f9367c);
        m11035a((Map<String, String>) hashMap, "gps_adid", this.f9285b.f9365a);
        m11035a((Map<String, String>) hashMap, "gps_adid_src", this.f9285b.f9366b);
        if (!m11041b((Map<String, String>) hashMap)) {
            f9283o.mo19021b("Google Advertising ID not detected, fallback to non Google Play identifiers will take place", new Object[0]);
            this.f9285b.mo19092a(this.f9286c.f9194c);
            m11035a((Map<String, String>) hashMap, "mac_sha1", this.f9285b.f9369e);
            m11035a((Map<String, String>) hashMap, "mac_md5", this.f9285b.f9370f);
            m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_ANDROID_ID, this.f9285b.f9371g);
        }
        m11035a((Map<String, String>) hashMap, "api_level", this.f9285b.f9381q);
        m11035a((Map<String, String>) hashMap, "app_secret", this.f9286c.f9191A);
        m11035a((Map<String, String>) hashMap, "app_token", this.f9286c.f9195d);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_APP_VERSION_NAME, this.f9285b.f9375k);
        m11033a((Map<String, String>) hashMap, "attribution_deeplink", (Boolean) true);
        m11044d(hashMap, "connectivity_type", (long) C3268a1.m10850b(this.f9286c.f9194c));
        m11035a((Map<String, String>) hashMap, UserDataStore.COUNTRY, this.f9285b.f9383s);
        m11035a((Map<String, String>) hashMap, "cpu_type", this.f9285b.f9390z);
        m11032a((Map<String, String>) hashMap, "created_at", this.f9284a);
        m11035a((Map<String, String>) hashMap, "currency", hVar.f9225c);
        m11033a((Map<String, String>) hashMap, "device_known", this.f9286c.f9202k);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_MANUFACTURER, this.f9285b.f9378n);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_NAME, this.f9285b.f9377m);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_TYPE_NAME, this.f9285b.f9376l);
        m11035a((Map<String, String>) hashMap, "display_height", this.f9285b.f9388x);
        m11035a((Map<String, String>) hashMap, "display_width", this.f9285b.f9387w);
        m11035a((Map<String, String>) hashMap, "environment", this.f9286c.f9196e);
        m11035a((Map<String, String>) hashMap, "event_callback_id", hVar.f9229g);
        m11044d(hashMap, "event_count", (long) this.f9287d.f9298a);
        m11033a((Map<String, String>) hashMap, "event_buffering_enabled", Boolean.valueOf(this.f9286c.f9199h));
        m11035a((Map<String, String>) hashMap, "event_token", hVar.f9223a);
        m11035a((Map<String, String>) hashMap, "fb_id", this.f9285b.f9372h);
        m11035a((Map<String, String>) hashMap, "fire_adid", C3268a1.m10828a(contentResolver));
        m11033a((Map<String, String>) hashMap, "fire_tracking_enabled", C3268a1.m10851b(contentResolver));
        m11035a((Map<String, String>) hashMap, "hardware_name", this.f9285b.f9389y);
        m11035a((Map<String, String>) hashMap, "language", this.f9285b.f9382r);
        m11035a((Map<String, String>) hashMap, "mcc", C3268a1.m10859d(this.f9286c.f9194c));
        m11035a((Map<String, String>) hashMap, "mnc", C3268a1.m10862e(this.f9286c.f9194c));
        m11033a((Map<String, String>) hashMap, "needs_response_details", (Boolean) true);
        m11044d(hashMap, "network_type", (long) C3268a1.m10865f(this.f9286c.f9194c));
        m11035a((Map<String, String>) hashMap, "os_build", this.f9285b.f9362A);
        m11035a((Map<String, String>) hashMap, "os_name", this.f9285b.f9379o);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, this.f9285b.f9380p);
        m11035a((Map<String, String>) hashMap, "package_name", this.f9285b.f9374j);
        m11035a((Map<String, String>) hashMap, "push_token", this.f9287d.f9305h);
        m11034a((Map<String, String>) hashMap, "revenue", hVar.f9224b);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_SCREEN_DENSITY, this.f9285b.f9386v);
        m11035a((Map<String, String>) hashMap, "screen_format", this.f9285b.f9385u);
        m11035a((Map<String, String>) hashMap, "screen_size", this.f9285b.f9384t);
        m11035a((Map<String, String>) hashMap, "secret_id", this.f9286c.f9217z);
        m11044d(hashMap, "session_count", (long) this.f9287d.f9299b);
        m11042c(hashMap, "session_length", this.f9287d.f9303f);
        m11044d(hashMap, "subsession_count", (long) this.f9287d.f9300c);
        m11042c(hashMap, "time_spent", this.f9287d.f9301d);
        m11031a((Map<String, String>) hashMap);
        return hashMap;
    }

    /* renamed from: b */
    private Map<String, String> m11038b() {
        ContentResolver contentResolver = this.f9286c.f9194c.getContentResolver();
        HashMap hashMap = new HashMap();
        Map<String, String> a = C3341r0.m11115a(this.f9286c.f9194c, f9283o);
        if (a != null) {
            hashMap.putAll(a);
        }
        this.f9285b.mo19093b(this.f9286c.f9194c);
        m11035a((Map<String, String>) hashMap, "android_uuid", this.f9287d.f9304g);
        m11033a((Map<String, String>) hashMap, "tracking_enabled", this.f9285b.f9367c);
        m11035a((Map<String, String>) hashMap, "gps_adid", this.f9285b.f9365a);
        m11035a((Map<String, String>) hashMap, "gps_adid_src", this.f9285b.f9366b);
        if (!m11041b((Map<String, String>) hashMap)) {
            f9283o.mo19021b("Google Advertising ID not detected, fallback to non Google Play identifiers will take place", new Object[0]);
            this.f9285b.mo19092a(this.f9286c.f9194c);
            m11035a((Map<String, String>) hashMap, "mac_sha1", this.f9285b.f9369e);
            m11035a((Map<String, String>) hashMap, "mac_md5", this.f9285b.f9370f);
            m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_ANDROID_ID, this.f9285b.f9371g);
        }
        m11035a((Map<String, String>) hashMap, "api_level", this.f9285b.f9381q);
        m11035a((Map<String, String>) hashMap, "app_secret", this.f9286c.f9191A);
        m11035a((Map<String, String>) hashMap, "app_token", this.f9286c.f9195d);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_APP_VERSION_NAME, this.f9285b.f9375k);
        m11033a((Map<String, String>) hashMap, "attribution_deeplink", (Boolean) true);
        m11032a((Map<String, String>) hashMap, "created_at", this.f9284a);
        m11033a((Map<String, String>) hashMap, "device_known", this.f9286c.f9202k);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_NAME, this.f9285b.f9377m);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_TYPE_NAME, this.f9285b.f9376l);
        m11035a((Map<String, String>) hashMap, "environment", this.f9286c.f9196e);
        m11033a((Map<String, String>) hashMap, "event_buffering_enabled", Boolean.valueOf(this.f9286c.f9199h));
        m11035a((Map<String, String>) hashMap, "fire_adid", C3268a1.m10828a(contentResolver));
        m11033a((Map<String, String>) hashMap, "fire_tracking_enabled", C3268a1.m10851b(contentResolver));
        m11033a((Map<String, String>) hashMap, "needs_response_details", (Boolean) true);
        m11035a((Map<String, String>) hashMap, "os_name", this.f9285b.f9379o);
        m11035a((Map<String, String>) hashMap, TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, this.f9285b.f9380p);
        m11035a((Map<String, String>) hashMap, "package_name", this.f9285b.f9374j);
        m11035a((Map<String, String>) hashMap, "push_token", this.f9287d.f9305h);
        m11035a((Map<String, String>) hashMap, "secret_id", this.f9286c.f9217z);
        m11031a((Map<String, String>) hashMap);
        return hashMap;
    }

    /* renamed from: b */
    private static void m11040b(Map<String, String> map, String str, long j) {
        if (j > 0) {
            m11036a(map, str, new Date(j * 1000));
        }
    }

    /* renamed from: b */
    private boolean m11041b(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return map.containsKey("tracking_enabled") || map.containsKey("gps_adid");
    }
}
