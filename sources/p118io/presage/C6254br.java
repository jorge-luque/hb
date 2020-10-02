package p118io.presage;

import com.applovin.sdk.AppLovinEventTypes;
import org.json.JSONObject;

/* renamed from: io.presage.br */
public final class C6254br {

    /* renamed from: a */
    public static final C6254br f16850a = new C6254br();

    private C6254br() {
    }

    /* renamed from: a */
    public static C6253bq m20992a(String str) {
        try {
            return m20993a(new JSONObject(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static C6253bq m20993a(JSONObject jSONObject) {
        C6253bq bqVar = new C6253bq();
        String optString = jSONObject.optString("url", "");
        C6514hl.m21414a((Object) optString, "zoneJson.optString(\"url\", \"\")");
        bqVar.mo34817a(optString);
        String optString2 = jSONObject.optString(AppLovinEventTypes.USER_VIEWED_CONTENT, "");
        C6514hl.m21414a((Object) optString2, "zoneJson.optString(\"content\", \"\")");
        bqVar.mo34821b(optString2);
        String optString3 = jSONObject.optString("webViewId", jSONObject.optString("id", ""));
        C6514hl.m21414a((Object) optString3, "zoneJson.optString(\"webViewId\", id)");
        bqVar.mo34825c(optString3);
        JSONObject optJSONObject = jSONObject.optJSONObject("size");
        int i = -1;
        bqVar.mo34820b(optJSONObject != null ? optJSONObject.optInt("width", -1) : -1);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("size");
        bqVar.mo34816a(optJSONObject2 != null ? optJSONObject2.optInt("height", -1) : -1);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("position");
        bqVar.mo34828d(optJSONObject3 != null ? optJSONObject3.optInt("x", -1) : -1);
        JSONObject optJSONObject4 = jSONObject.optJSONObject("position");
        if (optJSONObject4 != null) {
            i = optJSONObject4.optInt("y", -1);
        }
        bqVar.mo34824c(i);
        bqVar.mo34818a(jSONObject.optBoolean("enableTracking", false));
        bqVar.mo34822b(jSONObject.optBoolean("keepAlive", false));
        bqVar.mo34826c(jSONObject.optBoolean("isLandingPage", false));
        return bqVar;
    }
}
