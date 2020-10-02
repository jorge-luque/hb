package p118io.presage.core;

import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.presage.core.IllIllIl */
public class IllIllIl extends IllIIIll {
    public static final String IIIIIIlI = C6319k.IIIIIIII;
    public static final String IIIIIIll = C6319k.IIIIIIIl;
    public static final String IIIIIlII = C6319k.IIIIIIlI;

    static {
        String str = C6319k.IIIIIIll;
    }

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIlIIIlI) {
            JSONArray jSONArray = new JSONArray();
            Set<IIlIIIIl> set = ((IIlIIIlI) iIIlIIlI).IIIIIIIl;
            if (set != null) {
                for (IIlIIIIl next : set) {
                    if (next != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(IIIIIIll, next.IIIIIIII);
                        jSONObject2.put(IIIIIlII, next.IIIIIIIl);
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.put(IIIIIIlI, jSONArray);
            return;
        }
        throw new IllIIIIl();
    }
}
