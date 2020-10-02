package p118io.presage.core;

import org.json.JSONObject;

/* renamed from: io.presage.core.IllIlIll */
public class IllIlIll extends IllIIIll {
    public static final String IIIIIIlI = C6303g.IIIIIIII;
    public static final String IIIIIIll = C6303g.IIIIIIIl;
    public static final String IIIIIlII = C6303g.IIIIIIlI;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIIlllIl) {
            IIIlllIl iIIlllIl = (IIIlllIl) iIIlIIlI;
            jSONObject.put(IIIIIIlI, iIIlllIl.IIIIIIIl);
            jSONObject.put(IIIIIIll, iIIlllIl.IIIIIIlI);
            jSONObject.put(IIIIIlII, iIIlllIl.IIIIIIll);
            return;
        }
        throw new IllIIIIl();
    }
}
