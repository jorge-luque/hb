package com.tapjoy.internal;

import com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.util.Map;

/* renamed from: com.tapjoy.internal.il */
public final class C5199il extends C3164ii {

    /* renamed from: c */
    private final C5056fa f14268c;

    /* renamed from: d */
    private final C5038eu f14269d;

    /* renamed from: e */
    private final C5077fh f14270e;

    /* renamed from: f */
    private final String f14271f;

    private C5199il(C5056fa faVar, C5038eu euVar, C5077fh fhVar, String str) {
        this.f14268c = faVar;
        this.f14269d = euVar;
        this.f14270e = fhVar;
        this.f14271f = str;
    }

    /* renamed from: c */
    public final String mo18509c() {
        return "api/v1/tokens";
    }

    /* renamed from: e */
    public final Map mo18511e() {
        Map e = super.mo18511e();
        e.put(TJAdUnitConstants.String.VIDEO_INFO, new C4917bm(C5164hp.m17393a(this.f14268c)));
        e.put(TapjoyConstants.TJC_APP_PLACEMENT, new C4917bm(C5164hp.m17389a(this.f14269d)));
        e.put(QumparaOfferwallUtil.TABLE_NAME, new C4917bm(C5164hp.m17394a(this.f14270e)));
        if (!C4889al.m16672a(this.f14271f)) {
            e.put("push_token", this.f14271f);
        }
        return e;
    }

    public C5199il(C5059fb fbVar, String str) {
        this(fbVar.f13785d, fbVar.f13786e, fbVar.f13787f, str);
    }
}
