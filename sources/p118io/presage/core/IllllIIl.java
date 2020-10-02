package p118io.presage.core;

import org.json.JSONObject;

/* renamed from: io.presage.core.IllllIIl */
public class IllllIIl extends IllIIIll {
    public static final String IIIIIIlI = C6376y0.IIIIIIII;
    public static final String IIIIIIll = C6376y0.IIIIIIIl;
    public static final String IIIIIlII = C6376y0.IIIIIIlI;
    public static final String IIIIIlIl = C6376y0.IIIIIIll;
    public static final String IIIIIllI = C6376y0.IIIIIlII;
    public static final String IIIIIlll = C6376y0.IIIIIlIl;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIllIIlI) {
            IIllIIlI iIllIIlI = (IIllIIlI) iIIlIIlI;
            jSONObject.put(IIIIIIlI, iIllIIlI.IIIIIIIl);
            jSONObject.put(IIIIIIll, iIllIIlI.IIIIIIlI);
            jSONObject.put(IIIIIlII, iIllIIlI.IIIIIIll);
            jSONObject.put(IIIIIlIl, iIllIIlI.IIIIIlII);
            jSONObject.put(IIIIIllI, iIllIIlI.IIIIIlIl);
            jSONObject.put(IIIIIlll, iIllIIlI.IIIIIllI);
            return;
        }
        throw new IllIIIIl();
    }
}
