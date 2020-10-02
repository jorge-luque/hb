package p118io.presage.core;

import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.presage.core.IllIlIIl */
public class IllIlIIl extends IllIIIll {
    public static final String IIIIIIlI = C6295e.IIIIIIII;
    public static final String IIIIIIll = C6295e.IIIIIIIl;
    public static final String IIIIIlII = C6295e.IIIIIIlI;
    public static final String IIIIIlIl = C6295e.IIIIIIll;
    public static final String IIIIIllI = C6295e.IIIIIlII;
    public static final String IIIIIlll = C6295e.IIIIIlIl;
    public static final String IIIIlIII = C6295e.IIIIIllI;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIIllIll) {
            JSONArray jSONArray = new JSONArray();
            Set<IIIllIlI> set = ((IIIllIll) iIIlIIlI).IIIIIIIl;
            if (set != null) {
                for (IIIllIlI next : set) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IIIIIlll, next.IIIIIIII);
                    jSONObject2.put(IIIIlIII, next.IIIIIIIl);
                    jSONObject2.put(IIIIIIll, next.IIIIIIlI);
                    jSONObject2.put(IIIIIlII, next.IIIIIIll);
                    jSONObject2.put(IIIIIlIl, next.IIIIIlIl);
                    jSONObject2.put(IIIIIllI, next.IIIIIlII);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put(IIIIIIlI, jSONArray);
            return;
        }
        throw new IllIIIIl();
    }
}
