package p118io.presage;

import org.json.JSONObject;

/* renamed from: io.presage.OlivetalaSauge */
public final class OlivetalaSauge {
    /* renamed from: a */
    public static void m20523a(JSONObject jSONObject) throws Salers {
        if (jSONObject.has("error")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("error");
            Salers salers = new Salers();
            String optString = jSONObject2.optString("type", "");
            C6514hl.m21414a((Object) optString, "error.optString(\"type\", \"\")");
            salers.mo34676a(optString);
            String optString2 = jSONObject2.optString("message", "");
            C6514hl.m21414a((Object) optString2, "error.optString(\"message\", \"\")");
            salers.mo34677b(optString2);
            C6578x xVar = C6578x.f17137a;
            C6578x.m21579a(salers.getMessage());
            throw salers;
        }
    }
}
