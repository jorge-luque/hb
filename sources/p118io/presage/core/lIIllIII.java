package p118io.presage.core;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.presage.core.lIIllIII */
public class lIIllIII extends lIIllllI {
    public static final String IIlIllIl = C6371x.IIIIIIII;

    public lIIllIII(Context context) {
        super(context);
    }

    public lIIllIll IIIIIIII(JSONObject jSONObject) {
        try {
            this.IIIIIIIl = jSONObject.getInt(IIlIllIl);
            return super.IIIIIIII(jSONObject);
        } catch (JSONException e) {
            throw new lIIlllIl(e);
        }
    }

    public JSONObject IIIIIIII(lIIllIll liillill) {
        try {
            JSONObject IIIIIIII = super.IIIIIIII(liillill);
            IIIIIIII.put(IIlIllIl, 3);
            return IIIIIIII;
        } catch (JSONException e) {
            throw new lIIlllIl(e);
        }
    }
}
