package com.iab.omid.library.oguryco.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.oguryco.adsession.AdSessionContext;
import com.iab.omid.library.oguryco.adsession.C4199a;
import com.iab.omid.library.oguryco.adsession.VerificationScriptResource;
import com.iab.omid.library.oguryco.p150b.C4206d;
import com.iab.omid.library.oguryco.p150b.C4207e;
import com.iab.omid.library.oguryco.p152d.C4217b;
import com.iab.omid.library.oguryco.p152d.C4220d;
import com.vungle.warren.AdLoader;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.oguryco.publisher.b */
public class C4227b extends AdSessionStatePublisher {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WebView f11338a;

    /* renamed from: b */
    private Long f11339b = null;

    /* renamed from: c */
    private Map<String, VerificationScriptResource> f11340c;

    /* renamed from: d */
    private final String f11341d;

    public C4227b(Map<String, VerificationScriptResource> map, String str) {
        this.f11340c = map;
        this.f11341d = str;
    }

    /* renamed from: a */
    public void mo28764a() {
        super.mo28764a();
        mo28788j();
    }

    /* renamed from: a */
    public void mo28770a(C4199a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String next : injectedResourcesMap.keySet()) {
            C4217b.m14214a(jSONObject, next, injectedResourcesMap.get(next));
        }
        mo28771a(aVar, adSessionContext, jSONObject);
    }

    /* renamed from: b */
    public void mo28778b() {
        super.mo28778b();
        new Handler().postDelayed(new Runnable() {

            /* renamed from: b */
            private WebView f11343b = C4227b.this.f11338a;

            public void run() {
                this.f11343b.destroy();
            }
        }, Math.max(4000 - (this.f11339b == null ? 4000 : TimeUnit.MILLISECONDS.convert(C4220d.m14226a() - this.f11339b.longValue(), TimeUnit.NANOSECONDS)), AdLoader.RETRY_DELAY));
        this.f11338a = null;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: j */
    public void mo28788j() {
        WebView webView = new WebView(C4206d.m14158a().mo28736b());
        this.f11338a = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        mo28766a(this.f11338a);
        C4207e.m14161a().mo28747a(this.f11338a, this.f11341d);
        for (String next : this.f11340c.keySet()) {
            C4207e.m14161a().mo28740a(this.f11338a, this.f11340c.get(next).getResourceUrl().toExternalForm(), next);
        }
        this.f11339b = Long.valueOf(C4220d.m14226a());
    }
}
