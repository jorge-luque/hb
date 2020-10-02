package p118io.presage.core;

import org.json.JSONObject;

/* renamed from: io.presage.core.IlllIllI */
public class IlllIllI extends IllIIIll {
    public static final String IIIIIIlI = C6352s0.IIIIIIII;
    public static final String IIIIIIll = C6352s0.IIIIIIIl;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIlIllll) {
            IIlIllll iIlIllll = (IIlIllll) iIIlIIlI;
            jSONObject.put(IIIIIIlI, iIlIllll.IIIIIIIl);
            jSONObject.put(IIIIIIll, iIlIllll.IIIIIIlI);
            return;
        }
        throw new IllIIIIl();
    }
}
