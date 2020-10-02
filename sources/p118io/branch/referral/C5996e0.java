package p118io.branch.referral;

import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.branch.referral.e0 */
/* compiled from: ServerResponse */
public class C5996e0 {

    /* renamed from: a */
    private int f15343a;

    /* renamed from: b */
    private Object f15344b;

    public C5996e0(String str, int i) {
        this.f15343a = i;
    }

    /* renamed from: a */
    public void mo33851a(Object obj) {
        this.f15344b = obj;
    }

    /* renamed from: b */
    public String mo33852b() {
        try {
            JSONObject c = mo33853c();
            if (c == null || !c.has("error") || !c.getJSONObject("error").has("message")) {
                return "";
            }
            String string = c.getJSONObject("error").getString("message");
            if (string == null || string.trim().length() <= 0) {
                return string;
            }
            return string + ".";
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: c */
    public JSONObject mo33853c() {
        Object obj = this.f15344b;
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        return new JSONObject();
    }

    /* renamed from: d */
    public int mo33854d() {
        return this.f15343a;
    }

    /* renamed from: a */
    public JSONArray mo33850a() {
        Object obj = this.f15344b;
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        return null;
    }
}
