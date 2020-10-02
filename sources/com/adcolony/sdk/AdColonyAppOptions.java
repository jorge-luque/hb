package com.adcolony.sdk;

import android.content.Context;
import android.util.Log;
import com.tapjoy.TapjoyConstants;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdColonyAppOptions {
    public static final String ADMARVEL = "AdMarvel";
    public static final String ADMOB = "AdMob";
    public static final String ADOBEAIR = "Adobe AIR";
    public static final String AERSERVE = "AerServe";
    @Deprecated
    public static final int ALL = 2;
    public static final String APPODEAL = "Appodeal";
    public static final String CCPA = "CCPA";
    public static final String COCOS2DX = "Cocos2d-x";
    public static final String COPPA = "COPPA";
    public static final String CORONA = "Corona";
    public static final String FUSEPOWERED = "Fuse Powered";
    public static final String FYBER = "Fyber";
    public static final String GDPR = "GDPR";
    public static final String IRONSOURCE = "ironSource";
    @Deprecated
    public static final int LANDSCAPE = 1;
    public static final String MOPUB = "MoPub";
    @Deprecated
    public static final int PORTRAIT = 0;
    @Deprecated
    public static final int SENSOR = 2;
    public static final String UNITY = "Unity";

    /* renamed from: a */
    private String f3289a = "";

    /* renamed from: b */
    private String[] f3290b;

    /* renamed from: c */
    private JSONArray f3291c = C1437s.m5579a();

    /* renamed from: d */
    private JSONObject f3292d = C1437s.m5599b();

    /* renamed from: e */
    private AdColonyUserMetadata f3293e;

    public AdColonyAppOptions() {
        setOriginStore("google");
        if (C1199a.m4882e()) {
            C1290h c = C1199a.m4880c();
            if (c.mo6559z()) {
                mo6269a(c.mo6552r().f3289a);
                mo6270a(c.mo6552r().f3290b);
            }
        }
    }

    public static AdColonyAppOptions getMoPubAppOptions(String str) {
        AdColonyAppOptions mediationNetwork = new AdColonyAppOptions().setMediationNetwork(MOPUB, "1.0");
        if (str != null && !str.isEmpty()) {
            String[] split = str.split(",");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String[] split2 = split[i].split(":");
                if (split2.length == 2) {
                    String str2 = split2[0];
                    char c = 65535;
                    int hashCode = str2.hashCode();
                    if (hashCode != 109770977) {
                        if (hashCode == 351608024 && str2.equals("version")) {
                            c = 1;
                        }
                    } else if (str2.equals("store")) {
                        c = 0;
                    }
                    if (c == 0) {
                        mediationNetwork.setOriginStore(split2[1]);
                    } else if (c != 1) {
                        Log.e("AdColonyMoPub", "AdColony client options in wrong format - please check your MoPub dashboard");
                        return mediationNetwork;
                    } else {
                        mediationNetwork.setAppVersion(split2[1]);
                    }
                    i++;
                } else {
                    Log.e("AdColonyMoPub", "AdColony client options not recognized - please check your MoPub dashboard");
                    return null;
                }
            }
        }
        return mediationNetwork;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AdColonyAppOptions mo6269a(String str) {
        if (str == null) {
            return this;
        }
        this.f3289a = str;
        C1437s.m5592a(this.f3292d, "app_id", str);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public JSONObject mo6272b() {
        return this.f3292d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String[] mo6274c() {
        return this.f3290b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public JSONArray mo6275d() {
        return this.f3291c;
    }

    public int getAppOrientation() {
        return C1437s.m5578a(this.f3292d, "app_orientation", -1);
    }

    public String getAppVersion() {
        return C1437s.m5613h(this.f3292d, TapjoyConstants.TJC_APP_VERSION_NAME);
    }

    @Deprecated
    public String getGDPRConsentString() {
        return C1437s.m5613h(this.f3292d, "consent_string");
    }

    @Deprecated
    public boolean getGDPRRequired() {
        return C1437s.m5608d(this.f3292d, "gdpr_required");
    }

    public boolean getKeepScreenOn() {
        return C1437s.m5608d(this.f3292d, "keep_screen_on");
    }

    public JSONObject getMediationInfo() {
        JSONObject b = C1437s.m5599b();
        C1437s.m5592a(b, "name", C1437s.m5613h(this.f3292d, "mediation_network"));
        C1437s.m5592a(b, "version", C1437s.m5613h(this.f3292d, "mediation_network_version"));
        return b;
    }

    public boolean getMultiWindowEnabled() {
        return C1437s.m5608d(this.f3292d, "multi_window_enabled");
    }

    public Object getOption(String str) {
        return C1437s.m5598b(this.f3292d, str);
    }

    public String getOriginStore() {
        return C1437s.m5613h(this.f3292d, "origin_store");
    }

    public JSONObject getPluginInfo() {
        JSONObject b = C1437s.m5599b();
        C1437s.m5592a(b, "name", C1437s.m5613h(this.f3292d, TapjoyConstants.TJC_PLUGIN));
        C1437s.m5592a(b, "version", C1437s.m5613h(this.f3292d, "plugin_version"));
        return b;
    }

    public String getPrivacyConsentString(String str) {
        JSONObject jSONObject = this.f3292d;
        return C1437s.m5613h(jSONObject, str.toLowerCase(Locale.ENGLISH) + "_consent_string");
    }

    public boolean getPrivacyFrameworkRequired(String str) {
        JSONObject jSONObject = this.f3292d;
        return C1437s.m5608d(jSONObject, str.toLowerCase(Locale.ENGLISH) + "_required");
    }

    @Deprecated
    public int getRequestedAdOrientation() {
        return C1437s.m5578a(this.f3292d, "orientation", -1);
    }

    public boolean getTestModeEnabled() {
        return C1437s.m5608d(this.f3292d, "test_mode");
    }

    public String getUserID() {
        return C1437s.m5613h(this.f3292d, "user_id");
    }

    @Deprecated
    public AdColonyUserMetadata getUserMetadata() {
        return this.f3293e;
    }

    public AdColonyAppOptions setAppOrientation(int i) {
        setOption("app_orientation", (double) i);
        return this;
    }

    public AdColonyAppOptions setAppVersion(String str) {
        setOption(TapjoyConstants.TJC_APP_VERSION_NAME, str);
        return this;
    }

    @Deprecated
    public AdColonyAppOptions setGDPRConsentString(String str) {
        C1437s.m5592a(this.f3292d, "consent_string", str);
        return this;
    }

    @Deprecated
    public AdColonyAppOptions setGDPRRequired(boolean z) {
        setOption("gdpr_required", z);
        return this;
    }

    public AdColonyAppOptions setKeepScreenOn(boolean z) {
        C1437s.m5603b(this.f3292d, "keep_screen_on", z);
        return this;
    }

    public AdColonyAppOptions setMediationNetwork(String str, String str2) {
        C1437s.m5592a(this.f3292d, "mediation_network", str);
        C1437s.m5592a(this.f3292d, "mediation_network_version", str2);
        return this;
    }

    public AdColonyAppOptions setMultiWindowEnabled(boolean z) {
        C1437s.m5603b(this.f3292d, "multi_window_enabled", z);
        return this;
    }

    public AdColonyAppOptions setOption(String str, boolean z) {
        C1437s.m5603b(this.f3292d, str, z);
        return this;
    }

    public AdColonyAppOptions setOriginStore(String str) {
        setOption("origin_store", str);
        return this;
    }

    public AdColonyAppOptions setPlugin(String str, String str2) {
        C1437s.m5592a(this.f3292d, TapjoyConstants.TJC_PLUGIN, str);
        C1437s.m5592a(this.f3292d, "plugin_version", str2);
        return this;
    }

    public AdColonyAppOptions setPrivacyConsentString(String str, String str2) {
        JSONObject jSONObject = this.f3292d;
        C1437s.m5592a(jSONObject, str.toLowerCase(Locale.ENGLISH) + "_consent_string", str2);
        return this;
    }

    public AdColonyAppOptions setPrivacyFrameworkRequired(String str, boolean z) {
        setOption(str.toLowerCase(Locale.ENGLISH) + "_required", z);
        return this;
    }

    @Deprecated
    public AdColonyAppOptions setRequestedAdOrientation(int i) {
        setOption("orientation", (double) i);
        return this;
    }

    public AdColonyAppOptions setTestModeEnabled(boolean z) {
        C1437s.m5603b(this.f3292d, "test_mode", z);
        return this;
    }

    public AdColonyAppOptions setUserID(String str) {
        setOption("user_id", str);
        return this;
    }

    @Deprecated
    public AdColonyAppOptions setUserMetadata(AdColonyUserMetadata adColonyUserMetadata) {
        this.f3293e = adColonyUserMetadata;
        C1437s.m5594a(this.f3292d, "user_metadata", adColonyUserMetadata.f3319b);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6273b(Context context) {
        m4826a(context);
        if (C1437s.m5589a(this.f3292d, "use_forced_controller")) {
            C1379m0.f4345N = C1437s.m5608d(this.f3292d, "use_forced_controller");
        }
        if (C1437s.m5589a(this.f3292d, "use_staging_launch_server") && C1437s.m5608d(this.f3292d, "use_staging_launch_server")) {
            C1290h.f4087U = "https://adc3-launch-staging.adcolony.com/v4/launch";
        }
        String b = C1359k0.m5316b(context, "IABUSPrivacy_String");
        String b2 = C1359k0.m5316b(context, "IABTCF_TCString");
        int a = C1359k0.m5295a(context, "IABTCF_gdprApplies");
        if (b != null) {
            C1437s.m5592a(this.f3292d, "ccpa_consent_string", b);
        }
        if (b2 != null) {
            C1437s.m5592a(this.f3292d, "gdpr_consent_string", b2);
        }
        boolean z = true;
        if (a == 0 || a == 1) {
            JSONObject jSONObject = this.f3292d;
            if (a != 1) {
                z = false;
            }
            C1437s.m5603b(jSONObject, "gdpr_required", z);
        }
    }

    public AdColonyAppOptions setOption(String str, double d) {
        C1437s.m5590a(this.f3292d, str, d);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AdColonyAppOptions mo6270a(String... strArr) {
        if (strArr == null) {
            return this;
        }
        this.f3290b = strArr;
        this.f3291c = C1437s.m5579a();
        for (String b : strArr) {
            C1437s.m5601b(this.f3291c, b);
        }
        return this;
    }

    public AdColonyAppOptions setOption(String str, String str2) {
        C1437s.m5592a(this.f3292d, str, str2);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo6271a() {
        return this.f3289a;
    }

    /* renamed from: a */
    private void m4826a(Context context) {
        setOption("bundle_id", C1199a.m4880c().mo6542h().mo6611a(context));
    }
}
