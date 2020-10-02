package p118io.presage;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.presage.OlivetauPoivre */
public final class OlivetauPoivre {

    /* renamed from: a */
    private final Taleggio f16600a;

    /* renamed from: b */
    private final TetedeMoine f16601b;

    private OlivetauPoivre(Taleggio taleggio, TetedeMoine tetedeMoine) {
        this.f16600a = taleggio;
        this.f16601b = tetedeMoine;
    }

    /* renamed from: a */
    public final JSONObject mo34590a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("connectivity", this.f16600a.mo34696i());
        jSONObject.put("at", this.f16600a.mo34693f());
        jSONObject.put("build", 30070);
        jSONObject.put("version", "3.3.9-moat");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.f16601b.mo34702a());
        jSONObject.put("apps_publishers", jSONArray);
        return jSONObject;
    }

    public /* synthetic */ OlivetauPoivre(Context context) {
        this(new Taleggio(context), new TetedeMoine(context));
    }
}
