package p118io.presage;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import org.json.JSONObject;

/* renamed from: io.presage.PasdelEscalette */
public final class PasdelEscalette {
    /* renamed from: a */
    public static boolean m20531a(JSONObject jSONObject) {
        return m20530a() && C6211ab.m20769a(jSONObject);
    }

    /* renamed from: a */
    private static boolean m20530a() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        NetworkSecurityPolicy instance = NetworkSecurityPolicy.getInstance();
        C6514hl.m21414a((Object) instance, "NetworkSecurityPolicy.getInstance()");
        return instance.isCleartextTrafficPermitted();
    }
}
