package p118io.presage.core;

import org.json.JSONObject;

/* renamed from: io.presage.core.IlllllII */
public class IlllllII extends IllIIIll {
    public static final String IIIIIIlI = C6301f1.IIIIIIII;
    public static final String IIIIIIll = C6301f1.IIIIIIIl;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIllIlll) {
            IIllIlll iIllIlll = (IIllIlll) iIIlIIlI;
            jSONObject.put(IIIIIIlI, iIllIlll.IIIIIIIl);
            jSONObject.put(IIIIIIll, iIllIlll.IIIIIIlI);
            return;
        }
        throw new IllIIIIl();
    }
}
