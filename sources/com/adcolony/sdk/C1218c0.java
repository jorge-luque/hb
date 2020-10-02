package com.adcolony.sdk;

import android.webkit.WebView;
import com.adcolony.sdk.C1439u;
import com.iab.omid.library.adcolony.adsession.AdEvents;
import com.iab.omid.library.adcolony.adsession.AdSession;
import com.iab.omid.library.adcolony.adsession.AdSessionConfiguration;
import com.iab.omid.library.adcolony.adsession.AdSessionContext;
import com.iab.omid.library.adcolony.adsession.CreativeType;
import com.iab.omid.library.adcolony.adsession.ImpressionType;
import com.iab.omid.library.adcolony.adsession.Owner;
import com.iab.omid.library.adcolony.adsession.VerificationScriptResource;
import com.iab.omid.library.adcolony.adsession.media.InteractionType;
import com.iab.omid.library.adcolony.adsession.media.MediaEvents;
import com.iab.omid.library.adcolony.adsession.media.Position;
import com.iab.omid.library.adcolony.adsession.media.VastProperties;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.c0 */
class C1218c0 {

    /* renamed from: a */
    private AdSessionContext f3397a;

    /* renamed from: b */
    private AdSessionConfiguration f3398b;

    /* renamed from: c */
    private AdSession f3399c;

    /* renamed from: d */
    private AdEvents f3400d;

    /* renamed from: e */
    private MediaEvents f3401e;

    /* renamed from: f */
    private AdColonyCustomMessageListener f3402f;

    /* renamed from: g */
    private List<VerificationScriptResource> f3403g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f3404h = -1;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f3405i = "";

    /* renamed from: j */
    private int f3406j;

    /* renamed from: k */
    private boolean f3407k;

    /* renamed from: l */
    private boolean f3408l;

    /* renamed from: m */
    private boolean f3409m;

    /* renamed from: n */
    private boolean f3410n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f3411o;

    /* renamed from: p */
    private int f3412p;

    /* renamed from: q */
    private int f3413q;

    /* renamed from: r */
    private String f3414r = "";
    /* access modifiers changed from: private */

    /* renamed from: s */
    public String f3415s = "";

    /* renamed from: com.adcolony.sdk.c0$a */
    class C1219a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f3416a;

        C1219a(String str) {
            this.f3416a = str;
        }

        public void run() {
            JSONObject b = C1437s.m5599b();
            JSONObject b2 = C1437s.m5599b();
            C1437s.m5602b(b2, "session_type", C1218c0.this.f3404h);
            C1437s.m5592a(b2, TapjoyConstants.TJC_SESSION_ID, C1218c0.this.f3405i);
            C1437s.m5592a(b2, TapjoyConstants.TJC_SDK_TYPE_DEFAULT, this.f3416a);
            C1437s.m5592a(b, "type", "iab_hook");
            C1437s.m5592a(b, "message", b2.toString());
            new C1454x("CustomMessage.controller_send", 0, b).mo6834d();
        }
    }

    /* renamed from: com.adcolony.sdk.c0$b */
    class C1220b implements AdColonyCustomMessageListener {

        /* renamed from: com.adcolony.sdk.c0$b$a */
        class C1221a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f3419a;

            /* renamed from: b */
            final /* synthetic */ String f3420b;

            /* renamed from: c */
            final /* synthetic */ float f3421c;

            C1221a(String str, String str2, float f) {
                this.f3419a = str;
                this.f3420b = str2;
                this.f3421c = f;
            }

            public void run() {
                if (this.f3419a.equals(C1218c0.this.f3415s)) {
                    C1218c0.this.mo6446a(this.f3420b, this.f3421c);
                    return;
                }
                AdColonyAdView adColonyAdView = C1199a.m4880c().mo6530b().mo6458b().get(this.f3419a);
                C1218c0 omidManager = adColonyAdView != null ? adColonyAdView.getOmidManager() : null;
                if (omidManager != null) {
                    omidManager.mo6446a(this.f3420b, this.f3421c);
                }
            }
        }

        C1220b() {
        }

        public void onAdColonyCustomMessage(AdColonyCustomMessage adColonyCustomMessage) {
            JSONObject b = C1437s.m5600b(adColonyCustomMessage.getMessage());
            String h = C1437s.m5613h(b, "event_type");
            float floatValue = BigDecimal.valueOf(C1437s.m5609e(b, "duration")).floatValue();
            boolean d = C1437s.m5608d(b, "replay");
            boolean equals = C1437s.m5613h(b, "skip_type").equals("dec");
            String h2 = C1437s.m5613h(b, "asi");
            if (h.equals("skip") && equals) {
                boolean unused = C1218c0.this.f3411o = true;
            } else if (!d || (!h.equals(TJAdUnitConstants.String.VIDEO_START) && !h.equals("first_quartile") && !h.equals(TJAdUnitConstants.String.VIDEO_MIDPOINT) && !h.equals("third_quartile") && !h.equals(TJAdUnitConstants.String.VIDEO_COMPLETE))) {
                C1359k0.m5309a((Runnable) new C1221a(h2, h, floatValue));
            }
        }
    }

    C1218c0(JSONObject jSONObject, String str) {
        VerificationScriptResource verificationScriptResource;
        this.f3404h = m4961a(jSONObject);
        this.f3410n = C1437s.m5608d(jSONObject, "skippable");
        this.f3412p = C1437s.m5611f(jSONObject, "skip_offset");
        this.f3413q = C1437s.m5611f(jSONObject, "video_duration");
        JSONArray c = C1437s.m5604c(jSONObject, "js_resources");
        JSONArray c2 = C1437s.m5604c(jSONObject, "verification_params");
        JSONArray c3 = C1437s.m5604c(jSONObject, "vendor_keys");
        this.f3415s = str;
        for (int i = 0; i < c.length(); i++) {
            try {
                String d = C1437s.m5607d(c2, i);
                String d2 = C1437s.m5607d(c3, i);
                URL url = new URL(C1437s.m5607d(c, i));
                if (!d.equals("") && !d2.equals("")) {
                    verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithParameters(d2, url, d);
                } else if (!d2.equals("")) {
                    verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url);
                } else {
                    verificationScriptResource = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url);
                }
                this.f3403g.add(verificationScriptResource);
            } catch (MalformedURLException unused) {
                new C1439u.C1440a().mo6801a("Invalid js resource url passed to Omid").mo6803a(C1439u.f4517j);
            }
        }
        try {
            this.f3414r = C1199a.m4880c().mo6545k().mo6777a(C1437s.m5613h(jSONObject, "filepath"), true).toString();
        } catch (IOException unused2) {
            new C1439u.C1440a().mo6801a("Error loading IAB JS Client").mo6803a(C1439u.f4517j);
        }
    }

    /* renamed from: e */
    private void m4967e() {
        C1220b bVar = new C1220b();
        this.f3402f = bVar;
        AdColony.addCustomMessageListener(bVar, "viewability_ad_event");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo6449d() {
        return this.f3404h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo6450f() {
        this.f3408l = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6447b() {
        AdColony.removeCustomMessageListener("viewability_ad_event");
        this.f3399c.finish();
        m4965b("end_session");
        this.f3399c = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public AdSession mo6448c() {
        return this.f3399c;
    }

    /* renamed from: a */
    private int m4961a(JSONObject jSONObject) {
        if (this.f3404h == -1) {
            this.f3406j = C1437s.m5611f(jSONObject, "ad_unit_type");
            String h = C1437s.m5613h(jSONObject, "ad_type");
            int i = this.f3406j;
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                if (h.equals("video")) {
                    return 0;
                }
                if (h.equals("display")) {
                    return 1;
                }
                if (h.equals("banner_display") || h.equals("interstitial_display")) {
                    return 2;
                }
            }
        }
        return this.f3404h;
    }

    /* renamed from: b */
    private void m4965b(String str) {
        C1359k0.f4258b.execute(new C1219a(str));
    }

    /* renamed from: b */
    private void m4964b(C1205c cVar) {
        m4965b("register_ad_view");
        C1379m0 m0Var = C1199a.m4880c().mo6557x().get(Integer.valueOf(cVar.mo6428k()));
        if (m0Var == null && !cVar.mo6431n().isEmpty()) {
            m0Var = (C1379m0) cVar.mo6431n().entrySet().iterator().next().getValue();
        }
        AdSession adSession = this.f3399c;
        if (adSession == null || m0Var == null) {
            AdSession adSession2 = this.f3399c;
            if (adSession2 != null) {
                adSession2.registerAdView(cVar);
                cVar.mo6404a(this.f3399c);
                m4965b("register_obstructions");
                return;
            }
            return;
        }
        adSession.registerAdView(m0Var);
        m0Var.mo6716e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6444a(C1205c cVar) {
        MediaEvents mediaEvents;
        VastProperties vastProperties;
        if (!this.f3409m && this.f3404h >= 0 && this.f3399c != null) {
            m4964b(cVar);
            m4967e();
            if (this.f3404h != 0) {
                mediaEvents = null;
            } else {
                mediaEvents = MediaEvents.createMediaEvents(this.f3399c);
            }
            this.f3401e = mediaEvents;
            this.f3399c.start();
            this.f3400d = AdEvents.createAdEvents(this.f3399c);
            m4965b("start_session");
            if (this.f3401e != null) {
                Position position = Position.PREROLL;
                if (this.f3410n) {
                    vastProperties = VastProperties.createVastPropertiesForSkippableMedia((float) this.f3412p, true, position);
                } else {
                    vastProperties = VastProperties.createVastPropertiesForNonSkippableMedia(true, position);
                }
                this.f3400d.loaded(vastProperties);
            } else {
                this.f3400d.loaded();
            }
            this.f3409m = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6442a() throws IllegalArgumentException {
        mo6443a((WebView) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6443a(WebView webView) throws IllegalArgumentException {
        String str;
        List<VerificationScriptResource> list;
        if (this.f3404h >= 0 && (str = this.f3414r) != null && !str.equals("") && (list = this.f3403g) != null) {
            if (!list.isEmpty() || mo6449d() == 2) {
                C1290h c = C1199a.m4880c();
                Owner owner = Owner.NATIVE;
                ImpressionType impressionType = ImpressionType.BEGIN_TO_RENDER;
                int d = mo6449d();
                if (d == 0) {
                    CreativeType creativeType = CreativeType.VIDEO;
                    this.f3397a = AdSessionContext.createNativeAdSessionContext(c.mo6551q(), this.f3414r, this.f3403g, (String) null, (String) null);
                    AdSessionConfiguration createAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner, false);
                    this.f3398b = createAdSessionConfiguration;
                    AdSession createAdSession = AdSession.createAdSession(createAdSessionConfiguration, this.f3397a);
                    this.f3399c = createAdSession;
                    this.f3405i = createAdSession.getAdSessionId();
                    m4965b("inject_javascript");
                } else if (d == 1) {
                    CreativeType creativeType2 = CreativeType.NATIVE_DISPLAY;
                    this.f3397a = AdSessionContext.createNativeAdSessionContext(c.mo6551q(), this.f3414r, this.f3403g, (String) null, (String) null);
                    AdSessionConfiguration createAdSessionConfiguration2 = AdSessionConfiguration.createAdSessionConfiguration(creativeType2, impressionType, owner, (Owner) null, false);
                    this.f3398b = createAdSessionConfiguration2;
                    AdSession createAdSession2 = AdSession.createAdSession(createAdSessionConfiguration2, this.f3397a);
                    this.f3399c = createAdSession2;
                    this.f3405i = createAdSession2.getAdSessionId();
                    m4965b("inject_javascript");
                } else if (d == 2) {
                    CreativeType creativeType3 = CreativeType.HTML_DISPLAY;
                    this.f3397a = AdSessionContext.createHtmlAdSessionContext(c.mo6551q(), webView, "", (String) null);
                    AdSessionConfiguration createAdSessionConfiguration3 = AdSessionConfiguration.createAdSessionConfiguration(creativeType3, impressionType, owner, (Owner) null, false);
                    this.f3398b = createAdSessionConfiguration3;
                    AdSession createAdSession3 = AdSession.createAdSession(createAdSessionConfiguration3, this.f3397a);
                    this.f3399c = createAdSession3;
                    this.f3405i = createAdSession3.getAdSessionId();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6445a(String str) {
        mo6446a(str, 0.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6446a(String str, float f) {
        if (C1199a.m4881d() && this.f3399c != null) {
            if (this.f3401e != null || str.equals(TJAdUnitConstants.String.VIDEO_START) || str.equals("skip") || str.equals("continue") || str.equals("cancel")) {
                char c = 65535;
                try {
                    switch (str.hashCode()) {
                        case -1941887438:
                            if (str.equals("first_quartile")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1710060637:
                            if (str.equals("buffer_start")) {
                                c = 12;
                                break;
                            }
                            break;
                        case -1638835128:
                            if (str.equals(TJAdUnitConstants.String.VIDEO_MIDPOINT)) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1367724422:
                            if (str.equals("cancel")) {
                                c = 7;
                                break;
                            }
                            break;
                        case -934426579:
                            if (str.equals("resume")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -651914917:
                            if (str.equals("third_quartile")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -599445191:
                            if (str.equals(TJAdUnitConstants.String.VIDEO_COMPLETE)) {
                                c = 4;
                                break;
                            }
                            break;
                        case -567202649:
                            if (str.equals("continue")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -342650039:
                            if (str.equals("sound_mute")) {
                                c = 8;
                                break;
                            }
                            break;
                        case 3532159:
                            if (str.equals("skip")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 106440182:
                            if (str.equals("pause")) {
                                c = 10;
                                break;
                            }
                            break;
                        case 109757538:
                            if (str.equals(TJAdUnitConstants.String.VIDEO_START)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 583742045:
                            if (str.equals("in_video_engagement")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 823102269:
                            if (str.equals("html5_interaction")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 1648173410:
                            if (str.equals("sound_unmute")) {
                                c = 9;
                                break;
                            }
                            break;
                        case 1906584668:
                            if (str.equals("buffer_end")) {
                                c = 13;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            this.f3400d.impressionOccurred();
                            if (this.f3401e != null) {
                                MediaEvents mediaEvents = this.f3401e;
                                if (f <= 0.0f) {
                                    f = (float) this.f3413q;
                                }
                                mediaEvents.start(f, 1.0f);
                            }
                            m4965b(str);
                            return;
                        case 1:
                            this.f3401e.firstQuartile();
                            m4965b(str);
                            return;
                        case 2:
                            this.f3401e.midpoint();
                            m4965b(str);
                            return;
                        case 3:
                            this.f3401e.thirdQuartile();
                            m4965b(str);
                            return;
                        case 4:
                            this.f3411o = true;
                            this.f3401e.complete();
                            m4965b(str);
                            return;
                        case 5:
                            m4965b(str);
                            mo6447b();
                            return;
                        case 6:
                        case 7:
                            if (this.f3401e != null) {
                                this.f3401e.skipped();
                            }
                            m4965b(str);
                            mo6447b();
                            return;
                        case 8:
                            this.f3401e.volumeChange(0.0f);
                            m4965b(str);
                            return;
                        case 9:
                            this.f3401e.volumeChange(1.0f);
                            m4965b(str);
                            return;
                        case 10:
                            if (!this.f3407k && !this.f3408l && !this.f3411o) {
                                this.f3401e.pause();
                                m4965b(str);
                                this.f3407k = true;
                                this.f3408l = false;
                                return;
                            }
                            return;
                        case 11:
                            if (this.f3407k && !this.f3411o) {
                                this.f3401e.resume();
                                m4965b(str);
                                this.f3407k = false;
                                return;
                            }
                            return;
                        case 12:
                            this.f3401e.bufferStart();
                            m4965b(str);
                            return;
                        case 13:
                            this.f3401e.bufferFinish();
                            m4965b(str);
                            return;
                        case 14:
                        case 15:
                            this.f3401e.adUserInteraction(InteractionType.CLICK);
                            m4965b(str);
                            if (this.f3408l && !this.f3407k && !this.f3411o) {
                                this.f3401e.pause();
                                m4965b("pause");
                                this.f3407k = true;
                                this.f3408l = false;
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } catch (IllegalArgumentException | IllegalStateException e) {
                    C1439u.C1440a a = new C1439u.C1440a().mo6801a("Recording IAB event for ").mo6801a(str);
                    a.mo6801a(" caused " + e.getClass()).mo6803a(C1439u.f4515h);
                }
            }
        }
    }
}
