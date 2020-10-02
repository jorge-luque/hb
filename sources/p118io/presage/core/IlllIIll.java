package p118io.presage.core;

import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.presage.core.IlllIIll */
public class IlllIIll extends IllIIIll {
    public static final String IIIIIIlI = C6296e0.IIIIIIII;
    public static final String IIIIIIll = C6296e0.IIIIIIIl;
    public static final String IIIIIlII = C6296e0.IIIIIIlI;
    public static final String IIIIIlIl = C6296e0.IIIIIIll;
    public static final String IIIIIllI = C6296e0.IIIIIlII;
    public static final String IIIIIlll = C6296e0.IIIIIlIl;
    public static final String IIIIlIII = C6296e0.IIIIIllI;
    public static final String IIIIlIIl = C6296e0.IIIIIlll;
    public static final String IIIIlIlI = C6296e0.IIIIlIII;
    public static final String IIIIlIll = C6296e0.IIIIlIIl;
    public static final String IIIIllII = C6296e0.IIIIlIlI;
    public static final String IIIIllIl = C6296e0.IIIIlIll;
    public static final String IIIIlllI = C6296e0.IIIIllII;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIlIlIlI) {
            IIlIlIlI iIlIlIlI = (IIlIlIlI) iIIlIIlI;
            JSONArray jSONArray = new JSONArray();
            Set<IIlIIlII> set = iIlIlIlI.IIIIIIIl;
            if (set != null) {
                for (IIlIIlII next : set) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (next != null) {
                        jSONObject2.put(IIIIIllI, next.IIIIIIII);
                        jSONObject2.put(IIIIIlll, next.IIIIIIIl);
                        jSONObject2.put(IIIIlIII, next.IIIIIIlI);
                        jSONObject2.put(IIIIlIIl, next.IIIIIIll);
                        jSONObject2.put(IIIIlIlI, next.IIIIIlII);
                        jSONObject2.put(IIIIlIll, next.IIIIIlIl);
                        jSONObject2.put(IIIIllII, next.IIIIIllI);
                        jSONObject2.put(IIIIllIl, next.IIIIIlll);
                        jSONObject2.put(IIIIlllI, IIIIIIlI);
                    }
                    jSONArray.put(jSONObject2);
                }
            }
            Set<IIlIIlII> set2 = iIlIlIlI.IIIIIIlI;
            if (set2 != null) {
                for (IIlIIlII next2 : set2) {
                    JSONObject jSONObject3 = new JSONObject();
                    if (next2 != null) {
                        jSONObject3.put(IIIIIllI, next2.IIIIIIII);
                        jSONObject3.put(IIIIIlll, next2.IIIIIIIl);
                        jSONObject3.put(IIIIlIII, next2.IIIIIIlI);
                        jSONObject3.put(IIIIlIIl, next2.IIIIIIll);
                        jSONObject3.put(IIIIlIlI, next2.IIIIIlII);
                        jSONObject3.put(IIIIlIll, next2.IIIIIlIl);
                        jSONObject3.put(IIIIllII, next2.IIIIIllI);
                        jSONObject3.put(IIIIllIl, next2.IIIIIlll);
                        jSONObject3.put(IIIIlllI, IIIIIIll);
                    }
                    jSONArray.put(jSONObject3);
                }
            }
            Set<String> set3 = iIlIlIlI.IIIIIIll;
            if (set3 != null) {
                for (String put : set3) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(IIIIIllI, put);
                    jSONObject4.put(IIIIlllI, IIIIIlII);
                    jSONArray.put(jSONObject4);
                }
            }
            jSONObject.put(IIIIIlIl, jSONArray);
            return;
        }
        throw new IllIIIIl();
    }
}
