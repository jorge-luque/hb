package p118io.presage.core;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.presage.core.IllIIIll */
public abstract class IllIIIll implements IllIIIlI<JSONObject> {
    public static final String IIIIIIII = C6359u.IIIIIIII;
    public static final String IIIIIIIl = C6359u.IIIIIIIl;

    public JSONObject IIIIIIII(IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(IIIIIIII, iIIlIIlI.IIIIIIII());
                jSONObject.put(IIIIIIIl, iIIlIIlI.IIIIIIII);
                IIIIIIII(jSONObject, iIIlIIlI);
                return jSONObject;
            } catch (ClassCastException | JSONException e) {
                throw new IllIIIIl(e);
            }
        } else {
            throw new IllIIIIl();
        }
    }

    public abstract void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI);
}
