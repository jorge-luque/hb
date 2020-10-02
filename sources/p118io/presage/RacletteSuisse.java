package p118io.presage;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
import p118io.presage.common.network.models.RewardItem;

/* renamed from: io.presage.RacletteSuisse */
public final class RacletteSuisse {

    /* renamed from: a */
    public static final RacletteSuisse f16660a = new RacletteSuisse();

    /* renamed from: b */
    private static OlivetalaSauge f16661b = new OlivetalaSauge();

    private RacletteSuisse() {
    }

    /* renamed from: a */
    public static RouedeBrie m20616a(String str, SableduBoulonnais sableduBoulonnais, Soumaintrain soumaintrain) throws Salers {
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject = new JSONObject(str);
        OlivetalaSauge.m20523a(jSONObject);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("ad");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            PontlEveque pontlEveque = new PontlEveque();
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            JSONObject optJSONObject = jSONObject2.optJSONObject("format");
            String optString = jSONObject2.optString("ad_content");
            C6514hl.m21414a((Object) optString, "adJson.optString(\"ad_content\")");
            pontlEveque.mo34611c(optString);
            String optString2 = jSONObject2.optString("impression_url");
            C6514hl.m21414a((Object) optString2, "adJson.optString(\"impression_url\")");
            pontlEveque.mo34617e(optString2);
            String optString3 = jSONObject2.optString("id");
            C6514hl.m21414a((Object) optString3, "adJson.optString(\"id\")");
            pontlEveque.mo34608b(optString3);
            JSONObject optJSONObject2 = jSONObject2.optJSONObject(VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER);
            if (optJSONObject2 == null || (str2 = optJSONObject2.optString("id")) == null) {
                str2 = "";
            }
            pontlEveque.mo34620f(str2);
            String optString4 = jSONObject2.optString("campaign_id");
            C6514hl.m21414a((Object) optString4, "adJson.optString(\"campaign_id\")");
            pontlEveque.mo34623g(optString4);
            if (optJSONObject == null || (str3 = optJSONObject.optString("webview_base_url")) == null) {
                str3 = "";
            }
            pontlEveque.mo34626h(str3);
            if (optJSONObject == null || (str4 = optJSONObject.optString("mraid_download_url")) == null) {
                str4 = "";
            }
            pontlEveque.mo34632k(str4);
            pontlEveque.mo34609b(jSONObject2.optBoolean("moat", false));
            pontlEveque.mo34612c(jSONObject2.optBoolean("omid", false));
            pontlEveque.mo34615d(jSONObject2.optBoolean("is_video", false));
            pontlEveque.mo34604a(m20618a(jSONObject2.optJSONObject("overlay"), soumaintrain));
            pontlEveque.mo34603a(m20617a(jSONObject2.optJSONObject("ad_unit"), jSONObject2.optString("id")));
            C6514hl.m21414a((Object) jSONObject2, "adJson");
            pontlEveque.mo34614d(m20619a("orientation", jSONObject2));
            pontlEveque.mo34630j(m20620a(optJSONObject != null ? optJSONObject.optJSONArray(NativeProtocol.WEB_DIALOG_PARAMS) : null));
            pontlEveque.mo34628i(m20621a(jSONObject2));
            pontlEveque.mo34606a(jSONObject2.optBoolean("has_transparency", false));
            String optString5 = jSONObject2.optString("sdk_close_button_url", "");
            C6514hl.m21414a((Object) optString5, "adJson.optString(\"sdk_close_button_url\", \"\")");
            pontlEveque.mo34634l(optString5);
            String optString6 = jSONObject2.optString("landing_page_prefetch_url", "");
            C6514hl.m21414a((Object) optString6, "adJson.optString(\"landing_page_prefetch_url\", \"\")");
            pontlEveque.mo34636m(optString6);
            pontlEveque.mo34618e(jSONObject2.optBoolean("landing_page_disable_javascript", false));
            String optString7 = jSONObject2.optString("landing_page_prefetch_whitelist", "");
            C6514hl.m21414a((Object) optString7, "adJson.optString(\"landin…_prefetch_whitelist\", \"\")");
            pontlEveque.mo34637n(optString7);
            pontlEveque.mo34624g(jSONObject2.optBoolean("ad_keep_alive", false));
            pontlEveque.mo34605a(UUID.randomUUID().toString() + pontlEveque.mo34622g());
            pontlEveque.mo34621f(jSONObject2.has("overlay") ^ true);
            pontlEveque.mo34602a(sableduBoulonnais);
            if (C6514hl.m21416a((Object) pontlEveque.mo34635m().mo34670c(), (Object) sableduBoulonnais.mo34665c())) {
                arrayList.add(pontlEveque);
            }
        }
        return new RouedeBrie(arrayList);
    }

    /* renamed from: a */
    private static SaintFelicien m20617a(JSONObject jSONObject, String str) {
        SaintFelicien saintFelicien = new SaintFelicien();
        if (jSONObject == null) {
            return saintFelicien;
        }
        String optString = jSONObject.optString("id");
        String str2 = "";
        if (optString == null) {
            optString = str2;
        }
        saintFelicien.mo34667a(optString);
        if (str == null) {
            str = str2;
        }
        saintFelicien.mo34669b(str);
        String optString2 = jSONObject.optString("type");
        if (optString2 == null) {
            optString2 = str2;
        }
        saintFelicien.mo34671c(optString2);
        if (C6514hl.m21416a((Object) saintFelicien.mo34670c(), (Object) "optin_video")) {
            String optString3 = jSONObject.optString("app_user_id");
            if (optString3 == null) {
                optString3 = str2;
            }
            saintFelicien.mo34675e(optString3);
            String optString4 = jSONObject.optString("reward_launch");
            if (optString4 == null) {
                optString4 = str2;
            }
            saintFelicien.mo34673d(optString4);
            RewardItem e = saintFelicien.mo34674e();
            String optString5 = jSONObject.optString("reward_name");
            if (optString5 == null) {
                optString5 = str2;
            }
            e.setName(optString5);
            RewardItem e2 = saintFelicien.mo34674e();
            String optString6 = jSONObject.optString("reward_value");
            if (optString6 != null) {
                str2 = optString6;
            }
            e2.setValue(str2);
        }
        return saintFelicien;
    }

    /* renamed from: a */
    private static String m20621a(JSONObject jSONObject) {
        String str = "";
        String optString = jSONObject.optString("client_tracker_pattern", str);
        if (!C6514hl.m21416a((Object) optString, (Object) "null")) {
            str = optString;
        }
        C6514hl.m21414a((Object) str, "clientTrackerPattern");
        return str;
    }

    /* renamed from: a */
    private static String m20620a(JSONArray jSONArray) {
        JSONObject optJSONObject;
        String optString;
        if (jSONArray == null) {
            return "";
        }
        for (int length = jSONArray.length() - 1; length >= 0; length--) {
            JSONObject jSONObject = jSONArray.getJSONObject(length);
            if (C6514hl.m21416a((Object) jSONObject.getString("name"), (Object) "zones")) {
                JSONArray optJSONArray = jSONObject.optJSONArray(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null || (optString = optJSONObject.optString("name")) == null) {
                    return "";
                }
                return optString;
            }
        }
        return "";
    }

    /* renamed from: a */
    private static String m20619a(String str, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray(NativeProtocol.WEB_DIALOG_PARAMS);
        if (optJSONArray == null) {
            return "";
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            if (C6514hl.m21416a((Object) jSONObject2.getString("name"), (Object) str)) {
                String string = jSONObject2.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                C6514hl.m21414a((Object) string, "paramElement.getString(\"value\")");
                return string;
            }
        }
        return "";
    }

    /* renamed from: a */
    private static StMarcellin m20618a(JSONObject jSONObject, Soumaintrain soumaintrain) {
        StMarcellin stMarcellin = new StMarcellin();
        if (soumaintrain == null) {
            return stMarcellin;
        }
        boolean z = true;
        if (jSONObject != null) {
            z = jSONObject.optBoolean("draggable", true);
        }
        stMarcellin.mo34683a(z);
        JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("initial_size") : null;
        stMarcellin.mo34682a(C6215af.m20776b(optJSONObject != null ? optJSONObject.optInt("width") : soumaintrain.mo34680a()));
        stMarcellin.mo34686b(C6215af.m20776b(optJSONObject != null ? optJSONObject.getInt("height") : soumaintrain.mo34681b()));
        return stMarcellin;
    }
}
