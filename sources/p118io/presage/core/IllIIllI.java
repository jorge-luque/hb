package p118io.presage.core;

import org.json.JSONObject;

/* renamed from: io.presage.core.IllIIllI */
public class IllIIllI extends IllIIIll {
    public static final String IIIIIIlI = lllllIll.IIIIIIII;
    public static final String IIIIIIll = lllllIll.IIIIIIIl;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIIlIlIl) {
            IIIlIlIl iIIlIlIl = (IIIlIlIl) iIIlIIlI;
            jSONObject.put(IIIIIIlI, iIIlIlIl.IIIIIIIl);
            jSONObject.put(IIIIIIll, iIIlIlIl.IIIIIIlI);
            return;
        }
        throw new IllIIIIl();
    }
}
