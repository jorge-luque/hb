package p118io.presage.core;

import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.presage.core.IlllIIlI */
public class IlllIIlI extends IllIIIll {
    public static final String IIIIIIlI = C6367w.IIIIIIII;
    public static final String IIIIIIll = C6367w.IIIIIIIl;
    public static final String IIIIIlII = C6367w.IIIIIIlI;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIlIlIII) {
            JSONArray jSONArray = new JSONArray();
            HashSet<IIlIIlll> hashSet = ((IIlIlIII) iIIlIIlI).IIIIIIIl;
            if (hashSet != null) {
                for (IIlIIlll next : hashSet) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (next != null) {
                        jSONObject2.put(IIIIIIll, next.IIIIIIII);
                        JSONArray jSONArray2 = new JSONArray();
                        HashSet<String> hashSet2 = next.IIIIIIIl;
                        if (hashSet2 != null) {
                            for (String put : hashSet2) {
                                jSONArray2.put(put);
                            }
                        }
                        jSONObject2.put(IIIIIlII, jSONArray2);
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
