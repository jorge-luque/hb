package p118io.presage.core;

import org.json.JSONObject;
import p118io.presage.core.IIIlllll;

/* renamed from: io.presage.core.IllIlllI */
public class IllIlllI extends IllIIIll {
    public static final String IIIIIIlI = C6323l.IIIIIIII;
    public static final String IIIIIIll = C6323l.IIIIIIIl;
    public static final String IIIIIlII = C6323l.IIIIIIlI;
    public static final String IIIIIlIl = C6323l.IIIIIIll;
    public static final String IIIIIllI = C6323l.IIIIIlII;
    public static final String IIIIIlll = C6323l.IIIIIlIl;
    public static final String IIIIlIII = C6323l.IIIIIllI;
    public static final String IIIIlIIl = C6323l.IIIIIlll;
    public static final String IIIIlIlI = C6323l.IIIIlIII;
    public static final String IIIIlIll = C6323l.IIIIlIIl;
    public static final String IIIIllII = C6323l.IIIIlIlI;
    public static final String IIIIllIl = C6323l.IIIIlIll;
    public static final String IIIIlllI = C6323l.IIIIllII;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIlIIIII) {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            IIIlllll iIIlllll = ((IIlIIIII) iIIlIIlI).IIIIIIIl;
            if (iIIlllll != null) {
                IIIlllll.IIIIIIII iiiiiiii = iIIlllll.IIIIIllI;
                if (iiiiiiii != null) {
                    jSONObject2.put(IIIIIIll, (double) iiiiiiii.IIIIIIII);
                    jSONObject2.put(IIIIIlII, iiiiiiii.IIIIIIIl);
                    jSONObject2.put(IIIIIlIl, iiiiiiii.IIIIIIlI);
                }
                IIIlllll.IIIIIIIl iIIIIIIl = iIIlllll.IIIIIlll;
                if (iIIIIIIl != null) {
                    jSONObject3.put(IIIIIlll, iIIIIIIl.IIIIIIII);
                    jSONObject3.put(IIIIlIII, iIIIIIIl.IIIIIIIl);
                }
                jSONObject.put(IIIIlIIl, iIIlllll.IIIIIIII);
                jSONObject.put(IIIIlIlI, iIIlllll.IIIIIIIl);
                jSONObject.put(IIIIlIll, iIIlllll.IIIIIIlI);
                jSONObject.put(IIIIllII, iIIlllll.IIIIIIll);
                jSONObject.put(IIIIllIl, iIIlllll.IIIIIlII);
                jSONObject.put(IIIIlllI, iIIlllll.IIIIIlIl);
            }
            jSONObject.put(IIIIIIlI, jSONObject2);
            jSONObject.put(IIIIIllI, jSONObject3);
            return;
        }
        throw new IllIIIIl();
    }
}
