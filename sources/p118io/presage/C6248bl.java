package p118io.presage;

import android.content.Context;
import com.tapjoy.TJAdUnitConstants;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: io.presage.bl */
public final class C6248bl implements C6241be {

    /* renamed from: a */
    public static final CamembertauCalvados f16815a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private C6481gf<C6437ep> f16816b;

    /* renamed from: c */
    private C6481gf<C6437ep> f16817c;

    /* renamed from: d */
    private C6579y f16818d = new C6580z();

    /* renamed from: e */
    private final String[] f16819e = {"ogyCreateWebView", "ogyUpdateWebView", "ogyCloseWebView", "ogyNavigateBack", "ogyNavigateForward"};

    /* renamed from: f */
    private final C6246bj f16820f;

    /* renamed from: g */
    private final C6247bk f16821g;

    /* renamed from: io.presage.bl$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public C6248bl(C6246bj bjVar, C6247bk bkVar) {
        this.f16820f = bjVar;
        this.f16821g = bkVar;
    }

    /* renamed from: c */
    private final void m20944c(JSONObject jSONObject, String str, C6396db dbVar) {
        String optString = jSONObject.optString("webViewId", "");
        C6246bj bjVar = this.f16820f;
        C6514hl.m21414a((Object) optString, "webViewId");
        bjVar.mo34788a(optString);
        C6247bk.m20932a(dbVar, str, optString);
    }

    /* renamed from: a */
    public final void mo34806a(C6481gf<C6437ep> gfVar) {
        this.f16816b = gfVar;
    }

    /* renamed from: b */
    public final void mo34807b(C6481gf<C6437ep> gfVar) {
        this.f16817c = gfVar;
    }

    /* renamed from: b */
    private final void m20943b(JSONObject jSONObject, String str, C6396db dbVar) {
        C6254br brVar = C6254br.f16850a;
        C6253bq a = C6254br.m20993a(jSONObject);
        this.f16820f.mo34790b(a);
        C6247bk.m20932a(dbVar, str, a.mo34823c());
    }

    /* renamed from: a */
    public final boolean mo34777a(String str, C6396db dbVar, SaintFelicien saintFelicien) {
        Locale locale = Locale.US;
        C6514hl.m21414a((Object) locale, "Locale.US");
        String lowerCase = str.toLowerCase(locale);
        C6514hl.m21414a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        if (!C6561je.m21509a(lowerCase, "http://ogymraid")) {
            return false;
        }
        String substring = str.substring(19);
        C6514hl.m21414a((Object) substring, "(this as java.lang.String).substring(startIndex)");
        JSONObject jSONObject = new JSONObject(C6220ak.m20786a(substring));
        String optString = jSONObject.optString(TJAdUnitConstants.String.METHOD, "");
        String optString2 = jSONObject.optString(TJAdUnitConstants.String.CALLBACK_ID, "");
        JSONObject optJSONObject = jSONObject.optJSONObject("args");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        C6514hl.m21414a((Object) optString, "command");
        C6514hl.m21414a((Object) optString2, TJAdUnitConstants.String.CALLBACK_ID);
        m20939a(optString, optJSONObject, optString2, dbVar);
        return C6443ev.m21309a(this.f16819e, optString);
    }

    /* renamed from: b */
    private final void m20942b(JSONObject jSONObject) {
        String optString = jSONObject.optString("webViewId", "");
        C6246bj bjVar = this.f16820f;
        C6514hl.m21414a((Object) optString, "webViewId");
        bjVar.mo34795c(optString);
    }

    /* renamed from: a */
    private final void m20939a(String str, JSONObject jSONObject, String str2, C6396db dbVar) {
        switch (str.hashCode()) {
            case -1797727422:
                if (str.equals("ogyCloseWebView")) {
                    m20944c(jSONObject, str2, dbVar);
                    return;
                }
                return;
            case -1244773540:
                if (str.equals("ogyCreateWebView")) {
                    m20941a(jSONObject, str2, dbVar);
                    return;
                }
                return;
            case -692274449:
                if (str.equals("ogyUpdateWebView")) {
                    m20943b(jSONObject, str2, dbVar);
                    return;
                }
                return;
            case 960350259:
                if (str.equals("ogyNavigateForward")) {
                    m20942b(jSONObject);
                    return;
                }
                return;
            case 1635219001:
                if (str.equals("ogyNavigateBack")) {
                    m20940a(jSONObject);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private final void m20941a(JSONObject jSONObject, String str, C6396db dbVar) {
        C6579y yVar = this.f16818d;
        Context context = dbVar.getContext();
        C6514hl.m21414a((Object) context, "webView.context");
        if (yVar.mo35605a(context)) {
            C6254br brVar = C6254br.f16850a;
            C6253bq a = C6254br.m20993a(jSONObject);
            this.f16820f.mo34786a(a);
            C6247bk.m20932a(dbVar, str, a.mo34823c());
            C6481gf<C6437ep> gfVar = this.f16816b;
            if (gfVar != null) {
                gfVar.mo34405a();
                return;
            }
            return;
        }
        C6481gf<C6437ep> gfVar2 = this.f16817c;
        if (gfVar2 != null) {
            gfVar2.mo34405a();
        }
    }

    /* renamed from: a */
    private final void m20940a(JSONObject jSONObject) {
        String optString = jSONObject.optString("webViewId", "");
        C6246bj bjVar = this.f16820f;
        C6514hl.m21414a((Object) optString, "webViewId");
        bjVar.mo34792b(optString);
    }
}
