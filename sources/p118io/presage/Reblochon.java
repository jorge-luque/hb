package p118io.presage;

import org.json.JSONObject;

/* renamed from: io.presage.Reblochon */
public final class Reblochon {

    /* renamed from: a */
    public static final Reblochon f16665a = new Reblochon();

    private Reblochon() {
    }

    /* renamed from: a */
    public static String m20625a(RegaldeBourgogne regaldeBourgogne, RaclettedeSavoie raclettedeSavoie, String str, Soumaintrain soumaintrain) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", raclettedeSavoie.mo34650a());
        jSONObject.put("ad_sync_type", "load");
        if (soumaintrain != null) {
            jSONObject.put("overlay", m20626a(soumaintrain, regaldeBourgogne.mo34661j()));
        }
        if (raclettedeSavoie.mo34651b() != null) {
            jSONObject.put("ad_unit_id", raclettedeSavoie.mo34651b());
        }
        if (str.length() > 0) {
            jSONObject.put("app_user_id", str);
        }
        jSONObject.put("is_moat_compliant", regaldeBourgogne.mo34656e());
        jSONObject.put("is_omid_compliant", regaldeBourgogne.mo34657f());
        jSONObject.put("omid_integration_version", 3);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("width", regaldeBourgogne.mo34658g());
        jSONObject2.put("height", regaldeBourgogne.mo34659h());
        return "{\"connectivity\":\"" + regaldeBourgogne.mo34652a() + "\",\"at\":\"" + regaldeBourgogne.mo34653b() + "\",\"country\":\"" + regaldeBourgogne.mo34654c() + "\",\"build\":30070,\"apps_publishers\":[\"" + regaldeBourgogne.mo34655d() + "\"],\"version\":\"" + regaldeBourgogne.mo34660i() + "\",\"device\":" + jSONObject2 + ',' + "\"content\":" + jSONObject + '}';
    }

    /* renamed from: a */
    private static JSONObject m20626a(Soumaintrain soumaintrain, float f) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("width", soumaintrain.mo34680a());
        jSONObject2.put("height", soumaintrain.mo34681b());
        jSONObject2.put("scaler", Float.valueOf(f));
        jSONObject.put("overlay_max_size", jSONObject2);
        return jSONObject;
    }
}
