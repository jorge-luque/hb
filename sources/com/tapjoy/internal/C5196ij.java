package com.tapjoy.internal;

import admost.sdk.AdMostInterstitial;
import android.content.Context;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.List;
import java.util.Map;

/* renamed from: com.tapjoy.internal.ij */
public final class C5196ij extends C3164ii {

    /* renamed from: c */
    public final String f14257c;

    /* renamed from: d */
    public boolean f14258d = false;

    /* renamed from: e */
    private final C3145gz f14259e;

    /* renamed from: f */
    private final C5056fa f14260f;

    /* renamed from: g */
    private final C5038eu f14261g;

    /* renamed from: h */
    private final C5077fh f14262h;

    /* renamed from: i */
    private Context f14263i;

    /* renamed from: com.tapjoy.internal.ij$a */
    public static class C5197a {

        /* renamed from: a */
        public C3151hg f14264a;

        /* renamed from: b */
        public final List f14265b;

        public C5197a(C3151hg hgVar, List list) {
            this.f14264a = hgVar;
            this.f14265b = list;
        }
    }

    public C5196ij(C3145gz gzVar, C5056fa faVar, C5038eu euVar, C5077fh fhVar, String str, Context context) {
        this.f14259e = gzVar;
        this.f14260f = faVar;
        this.f14261g = euVar;
        this.f14262h = fhVar;
        this.f14257c = str;
        this.f14263i = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ Object mo18504a(C3126bn bnVar) {
        bnVar.mo18492h();
        C3159hu huVar = null;
        C5166hr hrVar = null;
        List list = null;
        while (bnVar.mo18494j()) {
            String l = bnVar.mo18496l();
            if (AdMostInterstitial.ZONE_TYPE_INTERSTITIAL.equals(l)) {
                huVar = (C3159hu) bnVar.mo18477a(C3159hu.f8805n);
            } else if ("contextual_button".equals(l)) {
                hrVar = (C5166hr) bnVar.mo18477a(C5166hr.f14152d);
            } else if ("enabled_placements".equals(l)) {
                list = bnVar.mo18483c();
            } else {
                bnVar.mo18503s();
            }
        }
        bnVar.mo18493i();
        if (huVar != null && (huVar.mo18612a() || huVar.mo18613b())) {
            return new C5197a(new C5151he(this.f14259e, this.f14257c, huVar, this.f14263i), list);
        }
        if (hrVar != null) {
            return new C5197a(new C5135gv(this.f14259e, this.f14257c, hrVar, this.f14263i), list);
        }
        return new C5197a(new C5156hf(), list);
    }

    /* renamed from: c */
    public final String mo18509c() {
        return "placement";
    }

    /* renamed from: e */
    public final Map mo18511e() {
        Map e = super.mo18511e();
        e.put(TJAdUnitConstants.String.VIDEO_INFO, new C4917bm(C5164hp.m17393a(this.f14260f)));
        e.put(TapjoyConstants.TJC_APP_PLACEMENT, new C4917bm(C5164hp.m17389a(this.f14261g)));
        e.put(QumparaOfferwallUtil.TABLE_NAME, new C4917bm(C5164hp.m17394a(this.f14262h)));
        e.put("placement", this.f14257c);
        return e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final /* synthetic */ Object mo18512f() {
        C5197a aVar = (C5197a) super.mo18512f();
        C3151hg hgVar = aVar.f14264a;
        if (!(hgVar instanceof C5156hf)) {
            hgVar.mo18599b();
            if (!aVar.f14264a.mo18600c()) {
                aVar.f14264a = new C5156hf();
            }
        }
        return aVar;
    }
}
