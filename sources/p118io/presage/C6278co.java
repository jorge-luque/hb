package p118io.presage;

import com.tapjoy.TJAdUnitConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
import p118io.presage.C6388cu;

/* renamed from: io.presage.co */
public abstract class C6278co implements C6241be {

    /* renamed from: a */
    public static final CamembertauCalvados f16919a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private Laguiole f16920b = Laguiole.f16541a;

    /* renamed from: c */
    private final C6233ax f16921c;

    /* renamed from: io.presage.co$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public C6278co(C6233ax axVar) {
        this.f16921c = axVar;
    }

    /* renamed from: b */
    private final void m21131b(Map<String, String> map) {
        mo34888e();
        m21133c(map);
    }

    /* renamed from: c */
    private static JSONObject m21132c(String str) {
        int a = C6562jf.m21517a((CharSequence) str, "/?q=", 0, false) + 4;
        if (str != null) {
            String substring = str.substring(a);
            C6514hl.m21414a((Object) substring, "(this as java.lang.String).substring(startIndex)");
            return new JSONObject(C6220ak.m20786a(substring));
        }
        throw new C6434em("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: d */
    private final void m21134d(Map<String, String> map) {
        String str = map.get("useCustomClose");
        mo34877a(str != null ? str.equals("false") : false);
    }

    /* renamed from: e */
    private final void m21135e(Map<String, String> map) {
        C6388cu.CamembertauCalvados camembertauCalvados = C6388cu.f16950a;
        C6388cu a = C6388cu.CamembertauCalvados.m21210a(map);
        mo34880a(a);
        if (a == null) {
            this.f16921c.mo34759a("setResizeProperties", "Wrong parameters");
        }
    }

    /* renamed from: f */
    private final void m21136f() {
        try {
            mo34886c();
        } catch (Throwable th) {
            C6233ax axVar = this.f16921c;
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            axVar.mo34759a("resize", message);
        }
    }

    /* renamed from: a */
    public void mo34876a() {
    }

    /* renamed from: a */
    public void mo34879a(SaintFelicien saintFelicien) {
    }

    /* renamed from: a */
    public void mo34880a(C6388cu cuVar) {
    }

    /* renamed from: a */
    public void mo34881a(String str) {
    }

    /* renamed from: a */
    public void mo34882a(String str, String str2) {
    }

    /* renamed from: a */
    public void mo34883a(Map<String, String> map, String str) {
    }

    /* renamed from: a */
    public void mo34877a(boolean z) {
    }

    /* renamed from: a */
    public final boolean mo34777a(String str, C6396db dbVar, SaintFelicien saintFelicien) {
        C6220ak.m20786a(str);
        if (!m21130a(dbVar)) {
            return true;
        }
        m21127a(str, saintFelicien);
        return true;
    }

    /* renamed from: b */
    public void mo34878b() {
    }

    /* renamed from: b */
    public void mo34884b(String str) {
    }

    /* renamed from: b */
    public void mo34885b(String str, String str2) {
    }

    /* renamed from: c */
    public void mo34886c() {
    }

    /* renamed from: d */
    public void mo34887d() {
    }

    /* renamed from: e */
    public void mo34888e() {
    }

    /* renamed from: a */
    private static boolean m21130a(C6396db dbVar) {
        return (C6514hl.m21416a((Object) dbVar.getAdState(), (Object) "hidden") ^ true) && (C6514hl.m21416a((Object) dbVar.getAdState(), (Object) "loading") ^ true);
    }

    /* renamed from: a */
    private final void m21127a(String str, SaintFelicien saintFelicien) {
        String str2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            JSONObject c = m21132c(str);
            str2 = c.optString(TJAdUnitConstants.String.METHOD, "");
            C6514hl.m21414a((Object) str2, "json.optString(\"method\", \"\")");
            try {
                String optString = c.optString(TJAdUnitConstants.String.CALLBACK_ID);
                C6514hl.m21414a((Object) optString, "json.optString(\"callbackId\")");
                linkedHashMap.put(TJAdUnitConstants.String.CALLBACK_ID, optString);
                Object opt = c.opt("args");
                if (opt == null) {
                    opt = "";
                }
                m21126a(opt, (Map<String, String>) linkedHashMap);
                m21128a(str2, linkedHashMap, opt.toString(), saintFelicien);
            } catch (Exception e) {
                e = e;
                Laguiole.m20426a(e);
                this.f16921c.mo34759a(str2, "");
            }
        } catch (Exception e2) {
            e = e2;
            str2 = "";
            Laguiole.m20426a(e);
            this.f16921c.mo34759a(str2, "");
        }
    }

    /* renamed from: c */
    private final void m21133c(Map<String, String> map) {
        String str = map.get("showNextAd");
        if (str == null) {
            str = "true";
        }
        String str2 = map.get("nextAdId");
        if (str2 == null) {
            str2 = "";
        }
        if (C6514hl.m21416a((Object) str, (Object) "true")) {
            mo34884b(str2);
        }
    }

    /* renamed from: a */
    private static void m21126a(Object obj, Map<String, String> map) {
        if (obj != null && (obj instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            C6514hl.m21414a((Object) keys, "keys");
            while (keys.hasNext()) {
                String next = keys.next();
                C6514hl.m21414a((Object) next, "key");
                String optString = jSONObject.optString(next, "");
                C6514hl.m21414a((Object) optString, "args.optString(key, \"\")");
                map.put(next, optString);
            }
        }
    }

    /* renamed from: a */
    private final void m21128a(String str, Map<String, String> map, String str2, SaintFelicien saintFelicien) {
        String str3 = "";
        switch (str.hashCode()) {
            case -1289167206:
                if (str.equals("expand")) {
                    mo34887d();
                    return;
                }
                return;
            case -984419449:
                if (str.equals("ogyResolveIntent")) {
                    String str4 = map.get("intentUri");
                    String str5 = map.get(TJAdUnitConstants.String.CALLBACK_ID);
                    if (str5 != null) {
                        str3 = str5;
                    }
                    mo34882a(str4, str3);
                    return;
                }
                return;
            case -934437708:
                if (str.equals("resize")) {
                    m21136f();
                    return;
                }
                return;
            case -840442113:
                if (str.equals("unload")) {
                    mo34878b();
                    return;
                }
                return;
            case 3417674:
                if (str.equals("open")) {
                    mo34881a(map.get("url"));
                    return;
                }
                return;
            case 94756344:
                if (str.equals("close")) {
                    m21129a(map);
                    return;
                }
                return;
            case 451326307:
                if (str.equals("ogyCreateShortcut")) {
                    mo34883a(map, str2);
                    return;
                }
                return;
            case 624734601:
                if (str.equals("setResizeProperties")) {
                    m21135e(map);
                    return;
                }
                return;
            case 901631159:
                if (str.equals("ogyOnAdEvent")) {
                    mo34879a(saintFelicien);
                    return;
                }
                return;
            case 1614272768:
                if (str.equals("useCustomClose")) {
                    m21134d(map);
                    return;
                }
                return;
            case 1622028878:
                if (str.equals("ogyForceClose")) {
                    m21131b(map);
                    return;
                }
                return;
            case 1805873469:
                if (str.equals("ogyStartIntent")) {
                    String str6 = map.get("intentUri");
                    String str7 = map.get(TJAdUnitConstants.String.CALLBACK_ID);
                    if (str7 != null) {
                        str3 = str7;
                    }
                    mo34885b(str6, str3);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private final void m21129a(Map<String, String> map) {
        mo34876a();
        m21133c(map);
    }
}
