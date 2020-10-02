package p118io.presage.core;

import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.presage.core.IlllIIII */
public class IlllIIII extends IllIIIll {
    public static final String IIIIIIlI = C6355t.IIIIIIII;
    public static final String IIIIIIll = C6355t.IIIIIIIl;
    public static final String IIIIIlII = C6355t.IIIIIIlI;
    public static final String IIIIIlIl = C6355t.IIIIIIll;
    public static final String IIIIIllI = C6355t.IIIIIlII;
    public static final String IIIIIlll = C6355t.IIIIIlIl;
    public static final String IIIIlIII = C6355t.IIIIIllI;
    public static final String IIIIlIIl = C6355t.IIIIIlll;
    public static final String IIIIlIlI = C6355t.IIIIlIII;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIlIIlIl) {
            JSONArray jSONArray = new JSONArray();
            Set<IIlIIlII> set = ((IIlIIlIl) iIIlIIlI).IIIIIIIl;
            if (set != null) {
                for (IIlIIlII next : set) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (next != null) {
                        jSONObject2.put(IIIIIIll, next.IIIIIIII);
                        jSONObject2.put(IIIIIlII, next.IIIIIIIl);
                        jSONObject2.put(IIIIIlIl, next.IIIIIIlI);
                        jSONObject2.put(IIIIIllI, next.IIIIIIll);
                        jSONObject2.put(IIIIIlll, next.IIIIIlII);
                        jSONObject2.put(IIIIlIII, next.IIIIIlIl);
                        jSONObject2.put(IIIIlIIl, next.IIIIIllI);
                        jSONObject2.put(IIIIlIlI, next.IIIIIlll);
                    }
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put(IIIIIIlI, jSONArray);
            return;
        }
        throw new IllIIIIl();
    }
}
