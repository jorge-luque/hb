package p118io.presage.core;

import org.json.JSONObject;

/* renamed from: io.presage.core.IllIlIlI */
public class IllIlIlI extends IllIIIll {
    public static final String IIIIIIlI = C6299f.IIIIIIII;
    public static final String IIIIIIll = C6299f.IIIIIIIl;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIIlllII) {
            IIIlllII iIIlllII = (IIIlllII) iIIlIIlI;
            jSONObject.put(IIIIIIlI, iIIlllII.IIIIIIIl);
            jSONObject.put(IIIIIIll, iIIlllII.IIIIIIlI);
            return;
        }
        throw new IllIIIIl();
    }
}
