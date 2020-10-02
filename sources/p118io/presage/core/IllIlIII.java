package p118io.presage.core;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.presage.core.IllIlIII */
public class IllIlIII extends IllIIIll {
    public static final String IIIIIIlI = C6287c.IIIIIIII;
    public static final String IIIIIIll = C6287c.IIIIIIIl;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIIllIIl) {
            JSONArray jSONArray = new JSONArray();
            Iterator<IIIllIII> it = ((IIIllIIl) iIIlIIlI).IIIIIIIl.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(IIIIIIll, it.next().IIIIIIII);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put(IIIIIIlI, jSONArray);
            return;
        }
        throw new IllIIIIl();
    }
}
