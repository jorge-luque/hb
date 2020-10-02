package p118io.presage.core;

import android.location.Location;
import org.json.JSONObject;

/* renamed from: io.presage.core.IlllIlIl */
public class IlllIlIl extends IllIIIll {
    public static final String IIIIIIlI = C6308h0.IIIIIIII;
    public static final String IIIIIIll = C6308h0.IIIIIIIl;
    public static final String IIIIIlII = C6308h0.IIIIIIlI;
    public static final String IIIIIlIl = C6308h0.IIIIIIll;
    public static final String IIIIIllI = C6308h0.IIIIIlII;
    public static final String IIIIIlll = C6308h0.IIIIIlIl;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIlIllIl) {
            Location location = ((IIlIllIl) iIIlIIlI).IIIIIIIl;
            if (location != null) {
                jSONObject.put(IIIIIIlI, location.getProvider());
                jSONObject.put(IIIIIIll, location.getTime());
                jSONObject.put(IIIIIlII, location.getLatitude());
                jSONObject.put(IIIIIlIl, location.getLongitude());
                jSONObject.put(IIIIIllI, location.getAltitude());
                jSONObject.put(IIIIIlll, Math.round(location.getAccuracy()));
                return;
            }
            return;
        }
        throw new IllIIIIl();
    }
}
