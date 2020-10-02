package p118io.presage;

import com.applovin.sdk.AppLovinMediationProvider;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.presage.l */
public final class C6566l {

    /* renamed from: a */
    public static final C6566l f17118a = new C6566l();

    private C6566l() {
    }

    /* renamed from: a */
    public static C6568n m21542a(JSONObject jSONObject) {
        if (jSONObject.optBoolean("force")) {
            return C6394d.f16966a;
        }
        if (C6211ab.m20769a(jSONObject)) {
            return C6529i.f17063a;
        }
        try {
            return m21546b(jSONObject);
        } catch (JSONException e) {
            Laguiole laguiole = Laguiole.f16541a;
            Laguiole.m20426a(e);
            return C6529i.f17063a;
        }
    }

    /* renamed from: b */
    private static C6556j m21546b(JSONObject jSONObject) {
        C6556j jVar = new C6556j();
        JSONObject optJSONObject = jSONObject.optJSONObject("profig");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        m21545a(optJSONObject, jVar);
        jVar.mo35564a(C6211ab.m20766a(optJSONObject.optJSONObject("max_per_day"), "profig", 10));
        jVar.mo35573c(C6567m.m21549a(C6211ab.m20766a(optJSONObject.optJSONObject("timeout"), "ads", 3)));
        jVar.mo35566a(C6211ab.m20768a(optJSONObject.optJSONObject("logs"), "crash_report", ""));
        m21547b(optJSONObject, jVar);
        m21548c(optJSONObject, jVar);
        m21544a(optJSONObject, jVar.mo35595p(), jVar.mo35596q());
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("cache");
        jVar.mo35569b(C6211ab.m20766a(optJSONObject2 != null ? optJSONObject2.optJSONObject("ads_to_precache") : null, AppLovinMediationProvider.MAX, -1));
        jVar.mo35577d(C6567m.m21550a(C6211ab.m20767a(optJSONObject2, "ad_expiration", 14400)));
        return jVar;
    }

    /* renamed from: c */
    private static void m21548c(JSONObject jSONObject, C6556j jVar) {
        JSONArray optJSONArray = jSONObject.optJSONArray("enabled");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        String jSONArray = optJSONArray.toString();
        C6514hl.m21414a((Object) jSONArray, "enabledArray.toString()");
        jVar.mo35567a(C6562jf.m21524a((CharSequence) jSONArray, (CharSequence) "profig"));
        jVar.mo35571b(C6562jf.m21524a((CharSequence) jSONArray, (CharSequence) "ads"));
        jVar.mo35575c(C6562jf.m21524a((CharSequence) jSONArray, (CharSequence) "launch"));
        jVar.mo35578d(C6562jf.m21524a((CharSequence) jSONArray, (CharSequence) "moat"));
        jVar.mo35582e(C6562jf.m21524a((CharSequence) jSONArray, (CharSequence) "omid"));
    }

    /* renamed from: a */
    private static void m21545a(JSONObject jSONObject, C6556j jVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject("timing_finder");
        jVar.mo35570b(C6567m.m21550a(C6211ab.m20767a(optJSONObject, "profig", 43200)));
        jVar.mo35565a(C6567m.m21550a(C6211ab.m20767a(optJSONObject, "no_internet_retry", 7200)));
        jVar.mo35581e(C6567m.m21550a(C6211ab.m20767a(optJSONObject, "show_close_button", 2)));
    }

    /* renamed from: a */
    private static void m21544a(JSONObject jSONObject, C6421e eVar, C6475g gVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject("overlay_config");
        if (optJSONObject != null) {
            eVar.mo35389a(optJSONObject.optBoolean("multiactivity_enabled", eVar.mo35390a()));
            m21543a((C6448f) eVar, optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("overlay_fragment_config");
        if (optJSONObject2 != null) {
            gVar.mo35495a(optJSONObject2.optBoolean("fragment_filter_enabled", gVar.mo35496a()));
            m21543a((C6448f) gVar, optJSONObject2);
        }
    }

    /* renamed from: b */
    private static void m21547b(JSONObject jSONObject, C6556j jVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject("webview");
        jVar.mo35584f(C6211ab.m20770a(optJSONObject, "back_button_enabled", false));
        jVar.mo35586g(C6211ab.m20770a(optJSONObject, "close_ad_when_leaving_app", true));
        jVar.mo35574c(C6567m.m21550a(C6211ab.m20767a(optJSONObject, "webview_load_timeout", 80)));
    }

    /* renamed from: a */
    private static void m21543a(C6448f fVar, JSONObject jSONObject) {
        fVar.mo35417b(jSONObject.optBoolean("default_whitelist_enabled", fVar.mo35418b()));
        fVar.mo35421d(jSONObject.optBoolean("publisher_blacklist_enabled", fVar.mo35422d()));
        fVar.mo35419c(jSONObject.optBoolean("publisher_whitelist_enabled", fVar.mo35420c()));
        fVar.mo35415a(C6210aa.m20765a(jSONObject.optJSONArray("whitelist")));
        fVar.mo35416b(C6210aa.m20765a(jSONObject.optJSONArray("blacklist")));
    }

    /* renamed from: a */
    public static C6556j m21541a(String str) {
        try {
            if (!(str.length() > 0) || !(!C6514hl.m21416a((Object) str, (Object) "{}"))) {
                return null;
            }
            return m21546b(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }
}
