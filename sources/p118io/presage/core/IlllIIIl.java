package p118io.presage.core;

import android.location.Location;
import org.json.JSONObject;

/* renamed from: io.presage.core.IlllIIIl */
public class IlllIIIl extends IllIIIll {
    public static final String IIIIIIlI = C6363v.IIIIIIII;
    public static final String IIIIIIll = C6363v.IIIIIIIl;
    public static final String IIIIIlII = C6363v.IIIIIIlI;
    public static final String IIIIIlIl = C6363v.IIIIIIll;
    public static final String IIIIIllI = C6363v.IIIIIlII;
    public static final String IIIIIlll = C6363v.IIIIIlIl;

    public void IIIIIIII(JSONObject jSONObject, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI instanceof IIlIIllI) {
            Location location = ((IIlIIllI) iIIlIIlI).IIIIIIIl;
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
