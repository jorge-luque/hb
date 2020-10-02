package p118io.presage.core;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.presage.core.IllIIlll */
public class IllIIlll extends IllIIIll {
    public static final String IIIIIIlI = llllllIl.IIIIIIII;
    public static final String IIIIIIll = llllllIl.IIIIIIIl;
    public static final String IIIIIlII = llllllIl.IIIIIIlI;
    public static final String IIIIIlIl = llllllIl.IIIIIIll;
    public static final String IIIIIllI = llllllIl.IIIIIlII;
    public static final String IIIIIlll = llllllIl.IIIIIlIl;
    public static final String IIIIlIII = llllllIl.IIIIIllI;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIIlIlll) {
            JSONArray jSONArray = new JSONArray();
            ArrayList<IIIlIllI> arrayList = ((IIIlIlll) iIIlIIlI).IIIIIIIl;
            if (arrayList != null) {
                Iterator<IIIlIllI> it = arrayList.iterator();
                while (it.hasNext()) {
                    IIIlIllI next = it.next();
                    JSONObject jSONObject2 = new JSONObject();
                    if (next != null) {
                        jSONObject2.put(IIIIIIll, next.IIIIIIII);
                        jSONObject2.put(IIIIIlII, next.IIIIIIIl);
                        jSONObject2.put(IIIIIlIl, next.IIIIIIlI);
                        jSONObject2.put(IIIIIllI, next.IIIIIIll);
                        jSONObject2.put(IIIIIlll, next.IIIIIlII);
                        jSONObject2.put(IIIIlIII, next.IIIIIlIl);
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
