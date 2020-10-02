package p118io.presage;

import android.webkit.WebView;
import com.iab.omid.library.oguryco.adsession.AdSessionConfiguration;
import com.iab.omid.library.oguryco.adsession.AdSessionContext;
import com.iab.omid.library.oguryco.adsession.CreativeType;
import com.iab.omid.library.oguryco.adsession.ImpressionType;
import com.iab.omid.library.oguryco.adsession.Owner;
import com.iab.omid.library.oguryco.adsession.Partner;

/* renamed from: io.presage.dt */
public final class C6414dt {

    /* renamed from: a */
    public static final C6414dt f16999a = new C6414dt();

    private C6414dt() {
    }

    /* renamed from: a */
    public static C6415du m21279a(WebView webView, boolean z) {
        C6415du duVar = new C6415du();
        Partner a = m21278a();
        if (a == null) {
            return null;
        }
        duVar.mo35383a(m21277a(a, webView));
        duVar.mo35382a(m21276a(z));
        return duVar;
    }

    /* renamed from: a */
    private static Partner m21278a() {
        try {
            return Partner.createPartner("Ogury", "3.3.9-moat");
        } catch (IllegalArgumentException e) {
            C6416dv dvVar = C6416dv.f17002a;
            C6416dv.m21284a(e);
            return null;
        }
    }

    /* renamed from: a */
    private static AdSessionContext m21277a(Partner partner, WebView webView) {
        try {
            return AdSessionContext.createHtmlAdSessionContext(partner, webView, "", (String) null);
        } catch (IllegalArgumentException e) {
            C6416dv dvVar = C6416dv.f17002a;
            C6416dv.m21284a(e);
            return null;
        }
    }

    /* renamed from: a */
    private static AdSessionConfiguration m21276a(boolean z) {
        ImpressionType impressionType = ImpressionType.DEFINED_BY_JAVASCRIPT;
        CreativeType creativeType = CreativeType.DEFINED_BY_JAVASCRIPT;
        Owner owner = Owner.JAVASCRIPT;
        Owner owner2 = Owner.NONE;
        if (z) {
            owner2 = Owner.JAVASCRIPT;
        }
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner2, false);
        } catch (IllegalArgumentException e) {
            C6416dv dvVar = C6416dv.f17002a;
            C6416dv.m21284a(e);
            return null;
        }
    }
}
