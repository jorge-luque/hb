package p118io.presage;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.facebook.internal.NativeProtocol;
import com.tapjoy.TapjoyConstants;
import org.json.JSONObject;

/* renamed from: io.presage.TommedeSavoie */
public final class TommedeSavoie {

    /* renamed from: a */
    private final Taleggio f16720a;

    /* renamed from: b */
    private final TetedeMoine f16721b;

    public TommedeSavoie(Taleggio taleggio, TetedeMoine tetedeMoine) {
        this.f16720a = taleggio;
        this.f16721b = tetedeMoine;
    }

    /* renamed from: b */
    private static JSONObject m20737b() {
        Resources system = Resources.getSystem();
        C6514hl.m21414a((Object) system, "Resources.getSystem()");
        DisplayMetrics displayMetrics = system.getDisplayMetrics();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("density", Float.valueOf(displayMetrics.density));
        jSONObject.put("height", displayMetrics.heightPixels);
        jSONObject.put("width", displayMetrics.widthPixels);
        return jSONObject;
    }

    /* renamed from: c */
    private final JSONObject m20738c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ACCESS_NETWORK_STATE", this.f16721b.mo34703a("android.permission.ACCESS_NETWORK_STATE"));
        jSONObject.put("RECEIVE_BOOT_COMPLETED", this.f16721b.mo34703a("android.permission.RECEIVE_BOOT_COMPLETED"));
        jSONObject.put("SYSTEM_ALERT_WINDOW", this.f16721b.mo34703a("android.permission.SYSTEM_ALERT_WINDOW"));
        jSONObject.put("GET_ACCOUNTS", this.f16721b.mo34703a("android.permission.GET_ACCOUNTS"));
        return jSONObject;
    }

    /* renamed from: a */
    public final JSONObject mo34712a(C6263c cVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TapjoyConstants.TJC_DEVICE_TIMEZONE, Taleggio.m20691e());
        jSONObject.put("aaid", cVar.mo34854a());
        jSONObject.put(TapjoyConstants.TJC_DEVICE_LANGUAGE, this.f16721b.mo34704b());
        jSONObject.put(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, this.f16721b.mo34705c());
        jSONObject.put("install_unknown_sources", this.f16720a.mo34694g());
        jSONObject.put("aaid_optin", cVar.mo34855b());
        jSONObject.put("fake_aaid", cVar.mo34856c());
        jSONObject.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, m20736a());
        jSONObject.put(NativeProtocol.RESULT_ARGS_PERMISSIONS, m20738c());
        return jSONObject;
    }

    /* renamed from: a */
    private final JSONObject m20736a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", this.f16720a.mo34695h());
        jSONObject.put("screen", m20737b());
        jSONObject.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, Taleggio.m20685a());
        jSONObject.put("vm_name", Taleggio.m20689c());
        jSONObject.put("phone_arch", Taleggio.m20690d());
        jSONObject.put("vm_version", Taleggio.m20688b());
        return jSONObject;
    }
}
