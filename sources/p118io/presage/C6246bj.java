package p118io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.loopj.android.http.C4250c;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: io.presage.bj */
public final class C6246bj {

    /* renamed from: a */
    public static final CamembertauCalvados f16797a = new CamembertauCalvados((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C6248bl f16798b;

    /* renamed from: c */
    private final Pattern f16799c;

    /* renamed from: d */
    private final PontlEveque f16800d;

    /* renamed from: e */
    private final Map<String, C6396db> f16801e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Map<String, C6255bs> f16802f;

    /* renamed from: g */
    private final C6244bh f16803g;

    /* renamed from: h */
    private final C6247bk f16804h;

    /* renamed from: i */
    private final C6258bv f16805i;

    /* renamed from: j */
    private final MoelleuxduRevard f16806j;

    /* renamed from: k */
    private final C6384cq f16807k;

    /* renamed from: l */
    private final C6256bt f16808l;

    /* renamed from: io.presage.bj$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static C6246bj m20926a(Context context, PontlEveque pontlEveque, FrameLayout frameLayout, C6384cq cqVar) {
            Map synchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
            C6514hl.m21414a((Object) synchronizedMap, "Collections.synchronizedMap(mutableMapOf())");
            Map synchronizedMap2 = Collections.synchronizedMap(new LinkedHashMap());
            C6514hl.m21414a((Object) synchronizedMap2, "Collections.synchronizedMap(mutableMapOf())");
            C6244bh bhVar = new C6244bh(context, frameLayout, pontlEveque);
            C6247bk bkVar = new C6247bk(synchronizedMap, synchronizedMap2);
            PontlEveque pontlEveque2 = pontlEveque;
            C6247bk bkVar2 = bkVar;
            C6246bj bjVar = new C6246bj(pontlEveque2, synchronizedMap, synchronizedMap2, bhVar, bkVar2, new C6258bv(context, bkVar), MoelleuxduRevard.f16573a, cqVar, new C6256bt(context, bkVar), (byte) 0);
            bjVar.f16798b = new C6248bl(bjVar, bkVar);
            return bjVar;
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    private C6246bj(PontlEveque pontlEveque, Map<String, C6396db> map, Map<String, C6255bs> map2, C6244bh bhVar, C6247bk bkVar, C6258bv bvVar, MoelleuxduRevard moelleuxduRevard, C6384cq cqVar, C6256bt btVar) {
        this.f16800d = pontlEveque;
        this.f16801e = map;
        this.f16802f = map2;
        this.f16803g = bhVar;
        this.f16804h = bkVar;
        this.f16805i = bvVar;
        this.f16806j = moelleuxduRevard;
        this.f16807k = cqVar;
        this.f16808l = btVar;
        this.f16799c = Pattern.compile(pontlEveque.mo34627i());
    }

    /* renamed from: e */
    private final boolean m20912e() {
        for (C6396db canGoBack : this.f16801e.values()) {
            if (canGoBack.canGoBack()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    private final boolean m20913f() {
        for (C6396db canGoForward : this.f16801e.values()) {
            if (canGoForward.canGoForward()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final void mo34791b(C6481gf<C6437ep> gfVar) {
        C6248bl blVar = this.f16798b;
        if (blVar == null) {
            C6514hl.m21415a("multiWebViewUrlHandler");
        }
        blVar.mo34807b(gfVar);
    }

    /* renamed from: c */
    public final void mo34794c() {
        for (C6396db next : this.f16801e.values()) {
            if (next.canGoBack()) {
                next.goBack();
            }
        }
    }

    /* renamed from: d */
    public final void mo34796d() {
        this.f16804h.mo34801a();
        this.f16805i.mo34846a();
        this.f16808l.mo34844a();
    }

    /* renamed from: b */
    public final boolean mo34793b() {
        return this.f16804h.mo34805d();
    }

    /* renamed from: io.presage.bj$CamembertdeNormandie */
    public static final class CamembertdeNormandie extends C6397dc {

        /* renamed from: a */
        final /* synthetic */ C6246bj f16809a;

        /* renamed from: b */
        final /* synthetic */ C6396db f16810b;

        /* renamed from: c */
        private String f16811c = "";

        /* renamed from: d */
        private boolean f16812d;

        CamembertdeNormandie(C6246bj bjVar, C6396db dbVar) {
            this.f16809a = bjVar;
            this.f16810b = dbVar;
        }

        /* renamed from: a */
        public final void mo34797a(WebView webView, String str) {
            this.f16811c = str;
            this.f16812d = true;
            this.f16809a.m20903a(webView, str);
        }

        /* renamed from: a */
        public final boolean mo34798a() {
            return false;
        }

        /* renamed from: b */
        public final void mo34799b(WebView webView, String str) {
            this.f16809a.m20905a(webView, str, this.f16812d);
            this.f16812d = false;
        }

        /* renamed from: c */
        public final void mo34800c(WebView webView, String str) {
            this.f16809a.m20904a(webView, this.f16811c, str);
        }

        /* renamed from: a */
        public final void mo34449a(WebView webView) {
            C6255bs bsVar = (C6255bs) this.f16809a.f16802f.get(C6245bi.m20901b(webView));
            if (bsVar != null) {
                bsVar.mo34839e();
            }
            this.f16810b.mo35337c();
        }
    }

    public /* synthetic */ C6246bj(PontlEveque pontlEveque, Map map, Map map2, C6244bh bhVar, C6247bk bkVar, C6258bv bvVar, MoelleuxduRevard moelleuxduRevard, C6384cq cqVar, C6256bt btVar, byte b) {
        this(pontlEveque, map, map2, bhVar, bkVar, bvVar, moelleuxduRevard, cqVar, btVar);
    }

    /* renamed from: b */
    public final void mo34790b(C6253bq bqVar) {
        C6396db dbVar = this.f16801e.get(bqVar.mo34823c());
        if (dbVar != null) {
            C6244bh.m20894a((WebView) dbVar, bqVar);
            boolean z = true;
            if (!(bqVar.mo34815a().length() > 0)) {
                if (bqVar.mo34819b().length() <= 0) {
                    z = false;
                }
                if (!z) {
                    return;
                }
            }
            m20910a(bqVar, (WebView) dbVar);
        }
    }

    /* renamed from: c */
    public final void mo34795c(String str) {
        C6396db dbVar = this.f16801e.get(str);
        if (dbVar != null && dbVar.canGoForward()) {
            dbVar.goForward();
        }
    }

    /* renamed from: a */
    public final void mo34787a(C6481gf<C6437ep> gfVar) {
        C6248bl blVar = this.f16798b;
        if (blVar == null) {
            C6514hl.m21415a("multiWebViewUrlHandler");
        }
        blVar.mo34806a(gfVar);
    }

    /* renamed from: a */
    public final C6241be mo34785a() {
        C6248bl blVar = this.f16798b;
        if (blVar == null) {
            C6514hl.m21415a("multiWebViewUrlHandler");
        }
        return blVar;
    }

    /* renamed from: b */
    public final void mo34792b(String str) {
        C6396db dbVar = this.f16801e.get(str);
        if (dbVar != null && dbVar.canGoBack()) {
            dbVar.goBack();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: a */
    public final void mo34786a(C6253bq bqVar) {
        C6396db a = this.f16803g.mo34783a(bqVar);
        if (a != null) {
            this.f16801e.put(bqVar.mo34823c(), a);
            this.f16802f.put(bqVar.mo34823c(), new C6255bs(bqVar.mo34832h(), bqVar.mo34833i(), bqVar.mo34815a(), false, 56));
            m20911a(a);
            if (bqVar.mo34834j()) {
                C6223an.m20791a(a);
                WebSettings settings = a.getSettings();
                C6514hl.m21414a((Object) settings, "webView.settings");
                settings.setCacheMode(1);
            }
            m20910a(bqVar, (WebView) a);
        }
    }

    /* renamed from: a */
    private final void m20910a(C6253bq bqVar, WebView webView) {
        if (bqVar.mo34815a().length() > 0) {
            webView.loadUrl(bqVar.mo34815a());
        } else {
            webView.loadDataWithBaseURL(this.f16800d.mo34625h(), bqVar.mo34819b(), "text/html", C4250c.DEFAULT_CHARSET, (String) null);
        }
    }

    /* renamed from: a */
    public final void mo34789a(String str, C6396db dbVar, boolean z) {
        dbVar.setTag(str);
        this.f16801e.put(str, dbVar);
        this.f16802f.put(str, new C6255bs(false, z, "", true, 48));
    }

    /* renamed from: a */
    public final void mo34788a(String str) {
        C6396db dbVar = this.f16801e.get(str);
        if (dbVar != null) {
            this.f16803g.mo34784a((WebView) dbVar);
        }
        this.f16801e.remove(str);
        this.f16802f.remove(str);
    }

    /* renamed from: a */
    private final void m20911a(C6396db dbVar) {
        C6241be[] beVarArr = new C6241be[2];
        C6248bl blVar = this.f16798b;
        if (blVar == null) {
            C6514hl.m21415a("multiWebViewUrlHandler");
        }
        beVarArr[0] = blVar;
        beVarArr[1] = this.f16807k.mo35308a(dbVar);
        dbVar.setMraidUrlHandler(new C6383cp(beVarArr));
        dbVar.setClientAdapter(new CamembertdeNormandie(this, dbVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m20903a(WebView webView, String str) {
        this.f16804h.mo34802a("started", m20913f(), m20912e(), C6245bi.m20901b(webView), str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m20905a(WebView webView, String str, boolean z) {
        this.f16804h.mo34802a("finished", m20913f(), m20912e(), C6245bi.m20901b(webView), str);
        C6255bs bsVar = this.f16802f.get(C6245bi.m20901b(webView));
        if (bsVar != null) {
            boolean z2 = false;
            boolean z3 = (!bsVar.mo34840f() || (C6514hl.m21416a((Object) bsVar.mo34837c(), (Object) str) ^ true)) && bsVar.mo34835a();
            if (z && z3) {
                if (this.f16800d.mo34627i().length() == 0) {
                    z2 = true;
                }
                if (z2) {
                    MoelleuxduRevard.m20487a((Mimolette24mois) new Mascare(this.f16800d, str, "format", (String) null, (String) null));
                }
            }
            bsVar.mo34841g();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m20904a(WebView webView, String str, String str2) {
        C6255bs bsVar = this.f16802f.get(C6245bi.m20901b(webView));
        if (bsVar != null && !bsVar.mo34842h()) {
            if ((this.f16800d.mo34627i().length() > 0) && this.f16799c.matcher(str2).matches()) {
                PontlEveque pontlEveque = this.f16800d;
                MoelleuxduRevard.m20487a((Mimolette24mois) new Mascare(pontlEveque, str, "format", pontlEveque.mo34627i(), str2));
                bsVar.mo34843i();
            }
        }
    }
}
