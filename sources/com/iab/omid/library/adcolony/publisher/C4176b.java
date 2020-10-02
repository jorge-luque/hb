package com.iab.omid.library.adcolony.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.adcolony.adsession.AdSessionContext;
import com.iab.omid.library.adcolony.adsession.C4148a;
import com.iab.omid.library.adcolony.adsession.VerificationScriptResource;
import com.iab.omid.library.adcolony.p144b.C4155d;
import com.iab.omid.library.adcolony.p144b.C4156e;
import com.iab.omid.library.adcolony.p146d.C4166b;
import com.iab.omid.library.adcolony.p146d.C4169d;
import com.vungle.warren.AdLoader;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.adcolony.publisher.b */
public class C4176b extends AdSessionStatePublisher {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public WebView f11217f;

    /* renamed from: g */
    private Long f11218g = null;

    /* renamed from: h */
    private Map<String, VerificationScriptResource> f11219h;

    /* renamed from: i */
    private final String f11220i;

    /* renamed from: com.iab.omid.library.adcolony.publisher.b$a */
    class C4177a implements Runnable {

        /* renamed from: a */
        private WebView f11221a = C4176b.this.f11217f;

        C4177a() {
        }

        public void run() {
            this.f11221a.destroy();
        }
    }

    public C4176b(Map<String, VerificationScriptResource> map, String str) {
        this.f11219h = map;
        this.f11220i = str;
    }

    /* renamed from: a */
    public void mo28550a() {
        super.mo28550a();
        mo28574j();
    }

    /* renamed from: a */
    public void mo28556a(C4148a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String next : injectedResourcesMap.keySet()) {
            C4166b.m13985a(jSONObject, next, injectedResourcesMap.get(next));
        }
        mo28557a(aVar, adSessionContext, jSONObject);
    }

    /* renamed from: b */
    public void mo28564b() {
        super.mo28564b();
        new Handler().postDelayed(new C4177a(), Math.max(4000 - (this.f11218g == null ? 4000 : TimeUnit.MILLISECONDS.convert(C4169d.m13997a() - this.f11218g.longValue(), TimeUnit.NANOSECONDS)), AdLoader.RETRY_DELAY));
        this.f11217f = null;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: j */
    public void mo28574j() {
        WebView webView = new WebView(C4155d.m13929a().mo28522b());
        this.f11217f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        mo28552a(this.f11217f);
        C4156e.m13932a().mo28533a(this.f11217f, this.f11220i);
        for (String next : this.f11219h.keySet()) {
            C4156e.m13932a().mo28526a(this.f11217f, this.f11219h.get(next).getResourceUrl().toExternalForm(), next);
        }
        this.f11218g = Long.valueOf(C4169d.m13997a());
    }
}
