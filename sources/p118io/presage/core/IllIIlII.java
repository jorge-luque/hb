package p118io.presage.core;

import android.accounts.Account;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.presage.core.IllIIlII */
public class IllIIlII extends IllIIIll {
    public static final String IIIIIIlI = llllIllI.IIIIIIII;
    public static final String IIIIIIll = llllIllI.IIIIIIIl;
    public static final String IIIIIlII = llllIllI.IIIIIIlI;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIIlIIll) {
            JSONArray jSONArray = new JSONArray();
            for (Account next : ((IIIlIIll) iIIlIIlI).IIIIIIIl) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(IIIIIIll, next.name);
                jSONObject2.put(IIIIIlII, next.type);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put(IIIIIIlI, jSONArray);
            return;
        }
        throw new IllIIIIl();
    }
}
