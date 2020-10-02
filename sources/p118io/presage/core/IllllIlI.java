package p118io.presage.core;

import org.json.JSONObject;

/* renamed from: io.presage.core.IllllIlI */
public class IllllIlI extends IllIIIll {
    public static final String IIIIIIlI = C6281a1.IIIIIIII;
    public static final String IIIIIIll = C6281a1.IIIIIIIl;
    public static final String IIIIIlII = C6281a1.IIIIIIlI;
    public static final String IIIIIlIl = C6281a1.IIIIIIll;
    public static final String IIIIIllI = C6281a1.IIIIIlII;
    public static final String IIIIIlll = C6281a1.IIIIIlIl;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIllIIll) {
            IIllIIll iIllIIll = (IIllIIll) iIIlIIlI;
            jSONObject.put(IIIIIIlI, iIllIIll.IIIIIIIl);
            jSONObject.put(IIIIIIll, iIllIIll.IIIIIIlI);
            jSONObject.put(IIIIIlII, iIllIIll.IIIIIIll);
            jSONObject.put(IIIIIlIl, iIllIIll.IIIIIlII);
            jSONObject.put(IIIIIllI, iIllIIll.IIIIIlIl);
            jSONObject.put(IIIIIlll, iIllIIll.IIIIIllI);
            return;
        }
        throw new IllIIIIl();
    }
}
