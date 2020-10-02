package p118io.presage.core;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.presage.core.IlllIlII */
public class IlllIlII extends IllIIIll {
    public static final String IIIIIIlI = C6304g0.IIIIIIII;
    public static final String IIIIIIll = C6304g0.IIIIIIIl;
    public static final String IIIIIlII = C6304g0.IIIIIIlI;
    public static final String IIIIIlIl = C6304g0.IIIIIIll;
    public static final String IIIIIllI = C6304g0.IIIIIlII;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIlIllII) {
            JSONArray jSONArray = new JSONArray();
            Iterator<IIlIlIll> it = ((IIlIllII) iIIlIIlI).IIIIIIIl.iterator();
            while (it.hasNext()) {
                IIlIlIll next = it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(IIIIIIll, next.IIIIIIII);
                jSONObject2.put(IIIIIlII, next.IIIIIIll);
                jSONObject2.put(IIIIIlIl, next.IIIIIIIl);
                jSONObject2.put(IIIIIllI, next.IIIIIIlI);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put(IIIIIIlI, jSONArray);
            return;
        }
        throw new IllIIIIl();
    }
}
