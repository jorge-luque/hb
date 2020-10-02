package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.C3123b;
import com.tapjoy.internal.C3137gf;
import com.tapjoy.internal.C3145gz;
import com.tapjoy.internal.C3151hg;
import com.tapjoy.internal.C3166jq;
import com.tapjoy.internal.C4932cb;
import com.tapjoy.internal.C5080fi;
import com.tapjoy.internal.C5086fm;
import com.tapjoy.internal.C5093fq;
import com.tapjoy.internal.C5098fu;
import com.tapjoy.internal.C5099fv;
import com.tapjoy.internal.C5100fw;
import com.tapjoy.internal.C5106ga;
import com.tapjoy.internal.C5122gi;
import com.tapjoy.internal.C5135gv;
import com.tapjoy.internal.C5139gw;
import com.tapjoy.internal.C5151he;
import com.tapjoy.internal.C5158hi;
import com.tapjoy.internal.C5196ij;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class TJCorePlacement {
    /* access modifiers changed from: package-private */

    /* renamed from: a */
    public static final String f12993a = "TJCorePlacement";

    /* renamed from: A */
    private TJAdUnit.TJAdUnitVideoListener f12994A = new TJAdUnit.TJAdUnitVideoListener() {
        public final void onVideoCompleted() {
            TJPlacement a = TJCorePlacement.this.mo30682a("SHOW");
            if (a != null && a.getVideoListener() != null) {
                a.getVideoListener().onVideoComplete(a);
            }
        }

        public final void onVideoError(String str) {
            TJPlacement a = TJCorePlacement.this.mo30682a("SHOW");
            if (a != null && a.getVideoListener() != null) {
                a.getVideoListener().onVideoError(a, str);
            }
        }

        public final void onVideoStart() {
            TJPlacement a = TJCorePlacement.this.mo30682a("SHOW");
            if (a != null && a.getVideoListener() != null) {
                a.getVideoListener().onVideoStart(a);
            }
        }
    };
    /* access modifiers changed from: package-private */

    /* renamed from: b */
    public Context f12995b;
    /* access modifiers changed from: package-private */

    /* renamed from: c */
    public TJPlacementData f12996c;

    /* renamed from: d */
    String f12997d;
    /* access modifiers changed from: package-private */

    /* renamed from: e */
    public long f12998e;

    /* renamed from: f */
    final C5100fw f12999f = new C5100fw();

    /* renamed from: g */
    TJAdUnit f13000g;
    /* access modifiers changed from: package-private */

    /* renamed from: h */
    public boolean f13001h = false;
    /* access modifiers changed from: package-private */

    /* renamed from: i */
    public C3151hg f13002i = null;

    /* renamed from: j */
    boolean f13003j;

    /* renamed from: k */
    volatile boolean f13004k = false;

    /* renamed from: l */
    volatile boolean f13005l = false;

    /* renamed from: m */
    String f13006m;

    /* renamed from: n */
    String f13007n;

    /* renamed from: o */
    String f13008o;

    /* renamed from: p */
    String f13009p;

    /* renamed from: q */
    HashMap f13010q;

    /* renamed from: r */
    private Map f13011r = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: s */
    public Map f13012s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C5086fm f13013t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f13014u = false;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public C5196ij f13015v = null;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public volatile boolean f13016w = false;

    /* renamed from: x */
    private volatile boolean f13017x = false;

    /* renamed from: y */
    private boolean f13018y;

    /* renamed from: z */
    private TJAdUnit.TJAdUnitWebViewListener f13019z = new TJAdUnit.TJAdUnitWebViewListener() {
        public final void onClick() {
            TJCorePlacement.m16562e(TJCorePlacement.this);
        }

        public final void onClosed() {
            if (TJCorePlacement.this.f13001h) {
                TJPlacementManager.decrementPlacementCacheCount();
                boolean unused = TJCorePlacement.this.f13001h = false;
            }
            if (TJCorePlacement.this.f13014u) {
                TJPlacementManager.decrementPlacementPreRenderCount();
                boolean unused2 = TJCorePlacement.this.f13014u = false;
            }
        }

        public final void onContentReady() {
            TJCorePlacement.this.m16561e();
        }
    };

    TJCorePlacement(String str, String str2, boolean z) {
        Activity c = C3123b.m10222c();
        this.f12995b = c;
        if (c == null) {
            TapjoyLog.m16649d(f12993a, "getVisibleActivity() is NULL. Activity can be explicitly set via `Tapjoy.setActivity(Activity)`");
        }
        this.f13018y = z;
        TJPlacementData tJPlacementData = new TJPlacementData(str2, getPlacementContentUrl());
        this.f12996c = tJPlacementData;
        tJPlacementData.setPlacementName(str);
        this.f12997d = UUID.randomUUID().toString();
        TJAdUnit tJAdUnit = new TJAdUnit();
        this.f13000g = tJAdUnit;
        tJAdUnit.setWebViewListener(this.f13019z);
        this.f13000g.setVideoListener(this.f12994A);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m16561e() {
        if (!this.f13017x) {
            this.f13005l = true;
            String str = f12993a;
            TapjoyLog.m16652i(str, "Content is ready for placement " + this.f12996c.getPlacementName());
            if (this.f13000g.isPrerendered()) {
                C5100fw fwVar = this.f12999f;
                C3137gf.C3139a aVar = fwVar.f13956b;
                if (aVar != null) {
                    aVar.mo18524a("prerendered", (Object) true);
                }
                C3137gf.C3139a aVar2 = fwVar.f13959e;
                if (aVar2 != null) {
                    aVar2.mo18524a("prerendered", (Object) true);
                }
            }
            C5100fw fwVar2 = this.f12999f;
            C3137gf.C3139a aVar3 = fwVar2.f13959e;
            if (aVar3 != null) {
                fwVar2.f13959e = null;
                aVar3.mo18526b().mo18529c();
            }
            TJPlacement a = mo30682a("REQUEST");
            if (a != null && a.getListener() != null) {
                a.getListener().onContentReady(a);
                this.f13017x = true;
            }
        }
    }

    /* renamed from: j */
    static /* synthetic */ void m16567j(TJCorePlacement tJCorePlacement) {
        C5086fm fmVar = new C5086fm(tJCorePlacement.f12996c.getPlacementName(), tJCorePlacement.f12996c.getPlacementType());
        tJCorePlacement.f13013t = fmVar;
        tJCorePlacement.f13000g.setAdContentTracker(fmVar);
    }

    /* renamed from: l */
    static /* synthetic */ void m16569l(TJCorePlacement tJCorePlacement) {
        tJCorePlacement.f13004k = true;
        tJCorePlacement.m16553b(tJCorePlacement.mo30682a("REQUEST"));
    }

    public TJAdUnit getAdUnit() {
        return this.f13000g;
    }

    public Context getContext() {
        return this.f12995b;
    }

    public String getPlacementContentUrl() {
        String b = mo30688b();
        if (!C3166jq.m10436c(b)) {
            return TapjoyConnectCore.getPlacementURL() + "v1/apps/" + b + "/content?";
        }
        TapjoyLog.m16652i(f12993a, "Placement content URL cannot be generated for null app ID");
        return "";
    }

    public TJPlacementData getPlacementData() {
        return this.f12996c;
    }

    public boolean isContentAvailable() {
        return this.f13004k;
    }

    public boolean isContentReady() {
        return this.f13005l;
    }

    public boolean isLimited() {
        return this.f13018y;
    }

    public void setContext(Context context) {
        this.f12995b = context;
    }

    /* renamed from: d */
    private synchronized void m16559d() {
        String url = this.f12996c.getUrl();
        if (C3166jq.m10436c(url)) {
            url = getPlacementContentUrl();
            if (C3166jq.m10436c(url)) {
                C3137gf.m10287b("TJPlacement.requestContent").mo18522a("TJPlacement is missing APP_ID").mo18529c();
                mo30686a(TapjoyErrorMessage.ErrorType.SDK_ERROR, new TJError(0, "TJPlacement is missing APP_ID"));
                return;
            }
            this.f12996c.updateUrl(url);
        }
        String str = f12993a;
        TapjoyLog.m16649d(str, "sendContentRequest -- URL: " + url + " name: " + this.f12996c.getPlacementName());
        m16551a(url, (Map) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m16556b(String str) {
        try {
            C5196ij.C5197a aVar = (C5196ij.C5197a) this.f13015v.mo18505a(URI.create(this.f12996c.getUrl()), new ByteArrayInputStream(str.getBytes()));
            this.f13002i = aVar.f14264a;
            aVar.f14264a.mo18599b();
            if (!aVar.f14264a.mo18600c()) {
                TapjoyLog.m16651e(f12993a, "Failed to load fiverocks placement");
                return false;
            }
            C5093fq fqVar = null;
            if (this.f13002i instanceof C5151he) {
                fqVar = new C5098fu(this.f12996c.getPlacementName(), this.f12996c.getPlacementType(), this.f13013t);
            } else if (this.f13002i instanceof C5135gv) {
                fqVar = new C5099fv(this.f12996c.getPlacementName(), this.f12996c.getPlacementType(), this.f13013t);
            }
            this.f12999f.f13955a = fqVar;
            return true;
        } catch (IOException e) {
            TapjoyLog.m16651e(f12993a, e.toString());
            e.printStackTrace();
            return false;
        } catch (C4932cb e2) {
            TapjoyLog.m16651e(f12993a, e2.toString());
            e2.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo30684a(TJPlacement tJPlacement) {
        boolean z = false;
        if (tJPlacement == null) {
            mo30686a(TapjoyErrorMessage.ErrorType.SDK_ERROR, new TJError(0, "Cannot request content from a NULL placement"));
            return;
        }
        mo30687a("REQUEST", tJPlacement);
        if (this.f12998e - SystemClock.elapsedRealtime() > 0) {
            String str = f12993a;
            TapjoyLog.m16649d(str, "Content has not expired yet for " + this.f12996c.getPlacementName());
            if (this.f13004k) {
                C3137gf.m10287b("TJPlacement.requestContent").mo18524a("content_type", (Object) mo30683a()).mo18524a("from", (Object) "cache").mo18529c();
                this.f13017x = false;
                m16553b(tJPlacement);
                m16561e();
                return;
            }
            C3137gf.m10287b("TJPlacement.requestContent").mo18524a("content_type", (Object) "none").mo18524a("from", (Object) "cache").mo18529c();
            m16553b(tJPlacement);
            return;
        }
        if (this.f13004k) {
            C3137gf.m10289c("TJPlacement.requestContent").mo18524a("was_available", (Object) true);
        }
        if (this.f13005l) {
            C3137gf.m10289c("TJPlacement.requestContent").mo18524a("was_ready", (Object) true);
        }
        if (!C3166jq.m10436c(this.f13008o)) {
            HashMap hashMap = new HashMap();
            hashMap.put(TJAdUnitConstants.PARAM_PLACEMENT_MEDIATION_AGENT, this.f13008o);
            hashMap.put(TJAdUnitConstants.PARAM_PLACEMENT_MEDIATION_ID, this.f13009p);
            HashMap hashMap2 = this.f13010q;
            if (hashMap2 != null && !hashMap2.isEmpty()) {
                z = true;
            }
            if (z) {
                for (String str2 : this.f13010q.keySet()) {
                    hashMap.put(TJAdUnitConstants.AUCTION_PARAM_PREFIX + str2, this.f13010q.get(str2));
                }
                m16551a(this.f12996c.getAuctionMediationURL(), (Map) hashMap);
                return;
            }
            m16551a(this.f12996c.getMediationURL(), (Map) hashMap);
            return;
        }
        m16559d();
    }

    /* renamed from: e */
    static /* synthetic */ void m16562e(TJCorePlacement tJCorePlacement) {
        TJPlacement a = tJCorePlacement.mo30682a("SHOW");
        String str = f12993a;
        TapjoyLog.m16652i(str, "Handle onClick for placement " + tJCorePlacement.f12996c.getPlacementName());
        if (a != null && a.getListener() != null) {
            a.getListener().onClick(a);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16553b(TJPlacement tJPlacement) {
        C5100fw fwVar = this.f12999f;
        String placementName = this.f12996c.getPlacementName();
        String placementType = this.f12996c.getPlacementType();
        String a = mo30683a();
        fwVar.f13957c = 0;
        fwVar.f13956b = C3137gf.m10291e("PlacementContent.funnel").mo18521a().mo18524a("placement", (Object) placementName).mo18524a("placement_type", (Object) placementType).mo18524a("content_type", (Object) a).mo18524a("state", (Object) Integer.valueOf(fwVar.f13957c));
        fwVar.f13956b.mo18529c();
        if (!"none".equals(a)) {
            fwVar.f13959e = C3137gf.m10291e("PlacementContent.ready").mo18521a().mo18524a("placement", (Object) placementName).mo18524a("placement_type", (Object) placementType).mo18524a("content_type", (Object) a);
        }
        if (tJPlacement != null && tJPlacement.getListener() != null) {
            String str = f12993a;
            TapjoyLog.m16652i(str, "Content request delivered successfully for placement " + this.f12996c.getPlacementName() + ", contentAvailable: " + isContentAvailable() + ", mediationAgent: " + this.f13008o);
            tJPlacement.getListener().onRequestSuccess(tJPlacement);
        }
    }

    /* renamed from: a */
    private synchronized void m16551a(String str, Map map) {
        if (this.f13016w) {
            String str2 = f12993a;
            TapjoyLog.m16652i(str2, "Placement " + this.f12996c.getPlacementName() + " is already requesting content");
            C3137gf.m10287b("TJPlacement.requestContent").mo18527b("already doing").mo18529c();
            return;
        }
        this.f12996c.resetPlacementRequestData();
        C5100fw fwVar = this.f12999f;
        String str3 = null;
        fwVar.f13956b = null;
        fwVar.f13958d = null;
        fwVar.f13955a = null;
        this.f13000g.resetContentLoadState();
        this.f13016w = false;
        this.f13017x = false;
        this.f13004k = false;
        this.f13005l = false;
        this.f13002i = null;
        this.f13015v = null;
        this.f13016w = true;
        final TJPlacement a = mo30682a("REQUEST");
        if (!this.f13018y) {
            Map genericURLParams = TapjoyConnectCore.getGenericURLParams();
            this.f13012s = genericURLParams;
            genericURLParams.putAll(TapjoyConnectCore.getTimeStampAndVerifierParams());
        } else {
            Map limitedGenericURLParams = TapjoyConnectCore.getLimitedGenericURLParams();
            this.f13012s = limitedGenericURLParams;
            limitedGenericURLParams.putAll(TapjoyConnectCore.getLimitedTimeStampAndVerifierParams());
        }
        TapjoyUtil.safePut(this.f13012s, TJAdUnitConstants.PARAM_PLACEMENT_NAME, this.f12996c.getPlacementName(), true);
        TapjoyUtil.safePut(this.f13012s, TJAdUnitConstants.PARAM_PLACEMENT_PRELOAD, "true", true);
        TapjoyUtil.safePut(this.f13012s, "debug", Boolean.toString(C5139gw.f14055a), true);
        C3145gz a2 = C3145gz.m10321a();
        Map map2 = this.f13012s;
        if (a2.f8758b != null) {
            C5158hi hiVar = a2.f8758b;
            hiVar.mo31333b();
            str3 = hiVar.f14107b.mo31485a();
        }
        TapjoyUtil.safePut(map2, TJAdUnitConstants.PARAM_ACTION_ID_EXCLUSION, str3, true);
        TapjoyUtil.safePut(this.f13012s, TJAdUnitConstants.PARAM_PLACEMENT_BY_SDK, String.valueOf(this.f13003j), true);
        TapjoyUtil.safePut(this.f13012s, TJAdUnitConstants.PARAM_PUSH_ID, a.pushId, true);
        TapjoyUtil.safePut(this.f13012s, TapjoyConstants.TJC_MEDIATION_SOURCE, this.f13006m, true);
        TapjoyUtil.safePut(this.f13012s, TapjoyConstants.TJC_ADAPTER_VERSION, this.f13007n, true);
        if (!C3166jq.m10436c(TapjoyConnectCore.getCustomParameter())) {
            TapjoyUtil.safePut(this.f13012s, TapjoyConstants.TJC_CUSTOM_PARAMETER, TapjoyConnectCore.getCustomParameter(), true);
        }
        if (map != null) {
            this.f13012s.putAll(map);
        }
        final C5080fi fiVar = new C5080fi(C5106ga.m17239b().mo18533b("placement_request_content_retry_timeout"));
        final C5122gi c = C5106ga.m17239b().mo18534c("placement_request_content_retry_backoff");
        final C3137gf.C3139a d = C3137gf.m10290d("TJPlacement.requestContent");
        final String str4 = str;
        new Thread() {
            /* JADX WARNING: Code restructure failed: missing block: B:55:0x02fd, code lost:
                if (r3 > r7) goto L_0x02f7;
             */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x030d */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private boolean m16579a() {
                /*
                    r12 = this;
                    java.lang.String r0 = com.tapjoy.TJCorePlacement.f12993a
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "Sending content request for placement "
                    r1.<init>(r2)
                    com.tapjoy.TJCorePlacement r2 = com.tapjoy.TJCorePlacement.this
                    java.lang.String r2 = r2.f12996c.getPlacementName()
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    com.tapjoy.TapjoyLog.m16652i(r0, r1)
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.internal.gz r1 = com.tapjoy.internal.C3145gz.m10321a()
                    com.tapjoy.TJCorePlacement r2 = com.tapjoy.TJCorePlacement.this
                    java.lang.String r8 = r2.f12996c.getPlacementName()
                    com.tapjoy.TJCorePlacement r2 = com.tapjoy.TJCorePlacement.this
                    android.content.Context r9 = r2.f12995b
                    com.tapjoy.internal.hh r1 = r1.f8757a
                    com.tapjoy.internal.gz r2 = r1.f14102a
                    r10 = 0
                    com.tapjoy.internal.fb r2 = r2.mo18543a((boolean) r10)
                    com.tapjoy.internal.ij r11 = new com.tapjoy.internal.ij
                    com.tapjoy.internal.gz r4 = r1.f14102a
                    com.tapjoy.internal.fa r5 = r2.f13785d
                    com.tapjoy.internal.eu r6 = r2.f13786e
                    com.tapjoy.internal.fh r7 = r2.f13787f
                    r3 = r11
                    r3.<init>(r4, r5, r6, r7, r8, r9)
                    com.tapjoy.internal.C5196ij unused = r0.f13015v = r11
                    com.tapjoy.TapjoyURLConnection r0 = new com.tapjoy.TapjoyURLConnection
                    r0.<init>()
                    java.lang.String r1 = r7
                    com.tapjoy.TJCorePlacement r2 = com.tapjoy.TJCorePlacement.this
                    java.util.Map r2 = r2.f13012s
                    r3 = 0
                    com.tapjoy.TapjoyHttpURLResponse r0 = r0.getResponseFromURL((java.lang.String) r1, (java.util.Map) r3, (java.util.Map) r3, (java.util.Map) r2)
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJPlacementData r1 = r1.f12996c
                    int r2 = r0.statusCode
                    r1.setHttpStatusCode(r2)
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJPlacementData r1 = r1.f12996c
                    java.lang.String r2 = r0.response
                    r1.setHttpResponse(r2)
                    java.lang.String r1 = "x-tapjoy-prerender"
                    java.lang.String r1 = r0.getHeaderFieldAsString(r1)
                    java.lang.String r2 = "0"
                    boolean r1 = r1.equals(r2)
                    r2 = 1
                    if (r1 != 0) goto L_0x0087
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJPlacementData r1 = r1.f12996c
                    r1.setPrerenderingRequested(r2)
                L_0x0087:
                    java.lang.String r1 = "X-Tapjoy-Debug"
                    java.lang.String r1 = r0.getHeaderFieldAsString(r1)
                    if (r1 == 0) goto L_0x00a4
                    java.lang.String r3 = com.tapjoy.TJCorePlacement.f12993a
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    java.lang.String r5 = "Tapjoy-Server-Debug: "
                    r4.<init>(r5)
                    r4.append(r1)
                    java.lang.String r1 = r4.toString()
                    com.tapjoy.TapjoyLog.m16653v(r3, r1)
                L_0x00a4:
                    long r3 = r0.expires
                    r5 = 0
                    int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r1 <= 0) goto L_0x00c7
                    long r7 = r0.date
                    int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                    if (r1 <= 0) goto L_0x00b3
                    goto L_0x00b7
                L_0x00b3:
                    long r7 = com.tapjoy.internal.C5271v.m17676b()
                L_0x00b7:
                    long r3 = r3 - r7
                    int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r1 <= 0) goto L_0x00cc
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    long r7 = android.os.SystemClock.elapsedRealtime()
                    long r7 = r7 + r3
                    long unused = r1.f12998e = r7
                    goto L_0x00cc
                L_0x00c7:
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    long unused = r1.f12998e = r5
                L_0x00cc:
                    if (r0 == 0) goto L_0x0312
                    com.tapjoy.TJPlacement r1 = r8
                    com.tapjoy.TJPlacementListener r1 = r1.getListener()
                    if (r1 == 0) goto L_0x0312
                    int r1 = r0.statusCode
                    if (r1 == 0) goto L_0x02a8
                    r3 = 200(0xc8, float:2.8E-43)
                    if (r1 == r3) goto L_0x0104
                    java.lang.String r1 = "TJPlacement.requestContent"
                    com.tapjoy.internal.gf$a r1 = com.tapjoy.internal.C3137gf.m10287b(r1)
                    java.lang.String r3 = "content_type"
                    java.lang.String r4 = "none"
                    com.tapjoy.internal.gf$a r1 = r1.mo18524a((java.lang.String) r3, (java.lang.Object) r4)
                    int r0 = r0.statusCode
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                    java.lang.String r3 = "code"
                    com.tapjoy.internal.gf$a r0 = r1.mo18524a((java.lang.String) r3, (java.lang.Object) r0)
                    r0.mo18529c()
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJPlacement r1 = r8
                    r0.m16553b((com.tapjoy.TJPlacement) r1)
                    goto L_0x0312
                L_0x0104:
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJCorePlacement.m16567j(r1)
                    java.lang.String r1 = "Content-Type"
                    java.lang.String r1 = r0.getHeaderFieldAsString(r1)
                    boolean r3 = com.tapjoy.internal.C3166jq.m10436c(r1)
                    if (r3 != 0) goto L_0x01e5
                    java.lang.String r3 = "json"
                    boolean r1 = r1.contains(r3)
                    if (r1 == 0) goto L_0x01e5
                    java.lang.String r1 = "X-Tapjoy-Disable-Preload"
                    java.lang.String r1 = r0.getHeaderFieldAsString(r1)
                    java.lang.String r3 = "1"
                    boolean r1 = r1.equals(r3)
                    if (r1 == 0) goto L_0x019b
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this     // Catch:{ TapjoyException -> 0x015b }
                    java.lang.String r3 = r0.response     // Catch:{ TapjoyException -> 0x015b }
                    com.tapjoy.TJCorePlacement.m16550a((com.tapjoy.TJCorePlacement) r1, (java.lang.String) r3)     // Catch:{ TapjoyException -> 0x015b }
                    java.lang.String r1 = "TJPlacement.requestContent"
                    com.tapjoy.internal.gf$a r1 = com.tapjoy.internal.C3137gf.m10287b(r1)     // Catch:{ TapjoyException -> 0x015b }
                    java.lang.String r3 = "content_type"
                    java.lang.String r4 = "ad"
                    com.tapjoy.internal.gf$a r1 = r1.mo18524a((java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ TapjoyException -> 0x015b }
                    r1.mo18529c()     // Catch:{ TapjoyException -> 0x015b }
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this     // Catch:{ TapjoyException -> 0x015b }
                    com.tapjoy.internal.fw r1 = r1.f12999f     // Catch:{ TapjoyException -> 0x015b }
                    com.tapjoy.TJCorePlacement r3 = com.tapjoy.TJCorePlacement.this     // Catch:{ TapjoyException -> 0x015b }
                    com.tapjoy.internal.fm r3 = r3.f13013t     // Catch:{ TapjoyException -> 0x015b }
                    r1.f13955a = r3     // Catch:{ TapjoyException -> 0x015b }
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this     // Catch:{ TapjoyException -> 0x015b }
                    com.tapjoy.TJCorePlacement.m16569l(r1)     // Catch:{ TapjoyException -> 0x015b }
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this     // Catch:{ TapjoyException -> 0x015b }
                    r1.m16561e()     // Catch:{ TapjoyException -> 0x015b }
                    goto L_0x0312
                L_0x015b:
                    r1 = move-exception
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r1 = r1.getMessage()
                    r3.append(r1)
                    java.lang.String r1 = " for placement "
                    r3.append(r1)
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    java.lang.String r1 = r1.f12996c.getPlacementName()
                    r3.append(r1)
                    java.lang.String r1 = r3.toString()
                    java.lang.String r3 = "TJPlacement.requestContent"
                    com.tapjoy.internal.gf$a r3 = com.tapjoy.internal.C3137gf.m10287b(r3)
                    java.lang.String r4 = "server error"
                    com.tapjoy.internal.gf$a r3 = r3.mo18522a((java.lang.String) r4)
                    r3.mo18529c()
                    com.tapjoy.TJCorePlacement r3 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJPlacement r4 = r8
                    com.tapjoy.TapjoyErrorMessage$ErrorType r5 = com.tapjoy.TapjoyErrorMessage.ErrorType.SERVER_ERROR
                    com.tapjoy.TJError r6 = new com.tapjoy.TJError
                    int r0 = r0.statusCode
                    r6.<init>(r0, r1)
                    r3.mo30685a(r4, r5, r6)
                    goto L_0x0312
                L_0x019b:
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    java.lang.String r3 = r0.response
                    boolean r1 = r1.m16556b((java.lang.String) r3)
                    if (r1 == 0) goto L_0x01c2
                    java.lang.String r0 = "TJPlacement.requestContent"
                    com.tapjoy.internal.gf$a r0 = com.tapjoy.internal.C3137gf.m10287b(r0)
                    java.lang.String r1 = "content_type"
                    java.lang.String r3 = "mm"
                    com.tapjoy.internal.gf$a r0 = r0.mo18524a((java.lang.String) r1, (java.lang.Object) r3)
                    r0.mo18529c()
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJCorePlacement.m16569l(r0)
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    r0.m16561e()
                    goto L_0x0312
                L_0x01c2:
                    java.lang.String r1 = "TJPlacement.requestContent"
                    com.tapjoy.internal.gf$a r1 = com.tapjoy.internal.C3137gf.m10287b(r1)
                    java.lang.String r3 = "asset error"
                    com.tapjoy.internal.gf$a r1 = r1.mo18522a((java.lang.String) r3)
                    r1.mo18529c()
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJPlacement r3 = r8
                    com.tapjoy.TapjoyErrorMessage$ErrorType r4 = com.tapjoy.TapjoyErrorMessage.ErrorType.SERVER_ERROR
                    com.tapjoy.TJError r5 = new com.tapjoy.TJError
                    int r6 = r0.statusCode
                    java.lang.String r0 = r0.response
                    r5.<init>(r6, r0)
                    r1.mo30685a(r3, r4, r5)
                    goto L_0x0312
                L_0x01e5:
                    java.lang.String r1 = "TJPlacement.requestContent"
                    com.tapjoy.internal.gf$a r1 = com.tapjoy.internal.C3137gf.m10287b(r1)
                    java.lang.String r3 = "content_type"
                    java.lang.String r4 = "ad"
                    com.tapjoy.internal.gf$a r1 = r1.mo18524a((java.lang.String) r3, (java.lang.Object) r4)
                    r1.mo18529c()
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.internal.fw r3 = r1.f12999f
                    com.tapjoy.internal.fm r1 = r1.f13013t
                    r3.f13955a = r1
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJCorePlacement.m16569l(r1)
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJCorePlacement$3$1 r3 = new com.tapjoy.TJCorePlacement$3$1
                    r3.<init>()
                    java.lang.String r4 = com.tapjoy.TJCorePlacement.f12993a
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    java.lang.String r6 = "Checking if there is content to cache for placement "
                    r5.<init>(r6)
                    com.tapjoy.TJPlacementData r6 = r1.f12996c
                    java.lang.String r6 = r6.getPlacementName()
                    r5.append(r6)
                    java.lang.String r5 = r5.toString()
                    com.tapjoy.TapjoyLog.m16652i(r4, r5)
                    java.lang.String r4 = "x-tapjoy-cacheable-assets"
                    java.lang.String r0 = r0.getHeaderFieldAsString(r4)
                    r4 = 2
                    boolean r5 = com.tapjoy.TJPlacementManager.canCachePlacement()     // Catch:{ Exception -> 0x028c }
                    if (r5 != 0) goto L_0x0250
                    java.lang.String r0 = com.tapjoy.TJCorePlacement.f12993a     // Catch:{ Exception -> 0x028c }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x028c }
                    java.lang.String r6 = "Placement caching limit reached. No content will be cached for placement "
                    r5.<init>(r6)     // Catch:{ Exception -> 0x028c }
                    com.tapjoy.TJPlacementData r1 = r1.f12996c     // Catch:{ Exception -> 0x028c }
                    java.lang.String r1 = r1.getPlacementName()     // Catch:{ Exception -> 0x028c }
                    r5.append(r1)     // Catch:{ Exception -> 0x028c }
                    java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x028c }
                    com.tapjoy.TapjoyLog.m16652i(r0, r1)     // Catch:{ Exception -> 0x028c }
                    r3.onCachingComplete(r4)     // Catch:{ Exception -> 0x028c }
                    goto L_0x0312
                L_0x0250:
                    org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ Exception -> 0x028c }
                    r5.<init>(r0)     // Catch:{ Exception -> 0x028c }
                    int r0 = r5.length()     // Catch:{ Exception -> 0x028c }
                    if (r0 <= 0) goto L_0x0287
                    java.lang.String r0 = com.tapjoy.TJCorePlacement.f12993a     // Catch:{ Exception -> 0x028c }
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x028c }
                    java.lang.String r7 = "Begin caching content for placement "
                    r6.<init>(r7)     // Catch:{ Exception -> 0x028c }
                    com.tapjoy.TJPlacementData r7 = r1.f12996c     // Catch:{ Exception -> 0x028c }
                    java.lang.String r7 = r7.getPlacementName()     // Catch:{ Exception -> 0x028c }
                    r6.append(r7)     // Catch:{ Exception -> 0x028c }
                    java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x028c }
                    com.tapjoy.TapjoyLog.m16652i(r0, r6)     // Catch:{ Exception -> 0x028c }
                    com.tapjoy.TJPlacementManager.incrementPlacementCacheCount()     // Catch:{ Exception -> 0x028c }
                    r1.f13001h = r2     // Catch:{ Exception -> 0x028c }
                    com.tapjoy.TapjoyCache r0 = com.tapjoy.TapjoyCache.getInstance()     // Catch:{ Exception -> 0x028c }
                    com.tapjoy.TJCorePlacement$6 r6 = new com.tapjoy.TJCorePlacement$6     // Catch:{ Exception -> 0x028c }
                    r6.<init>(r3)     // Catch:{ Exception -> 0x028c }
                    r0.cacheAssetGroup(r5, r6)     // Catch:{ Exception -> 0x028c }
                    goto L_0x0312
                L_0x0287:
                    r3.onCachingComplete(r2)     // Catch:{ Exception -> 0x028c }
                    goto L_0x0312
                L_0x028c:
                    r0 = move-exception
                    r3.onCachingComplete(r4)
                    java.lang.String r1 = com.tapjoy.TJCorePlacement.f12993a
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    java.lang.String r4 = "Error while handling placement cache: "
                    r3.<init>(r4)
                    java.lang.String r0 = r0.getMessage()
                    r3.append(r0)
                    java.lang.String r0 = r3.toString()
                    com.tapjoy.TapjoyLog.m16649d(r1, r0)
                    goto L_0x0312
                L_0x02a8:
                    com.tapjoy.internal.fi r1 = r6
                    com.tapjoy.internal.gi r3 = r9
                    long r3 = r3.f14026e
                    boolean r1 = r1.mo31236a(r3)
                    if (r1 == 0) goto L_0x02e4
                    java.lang.String r1 = "TJPlacement.requestContent"
                    com.tapjoy.internal.gf$a r1 = com.tapjoy.internal.C3137gf.m10287b(r1)
                    java.lang.String r3 = "network error"
                    com.tapjoy.internal.gf$a r1 = r1.mo18522a((java.lang.String) r3)
                    com.tapjoy.internal.fi r3 = r6
                    long r3 = r3.f13915b
                    java.lang.Long r3 = java.lang.Long.valueOf(r3)
                    java.lang.String r4 = "retry_timeout"
                    com.tapjoy.internal.gf$a r1 = r1.mo18524a((java.lang.String) r4, (java.lang.Object) r3)
                    r1.mo18529c()
                    com.tapjoy.TJCorePlacement r1 = com.tapjoy.TJCorePlacement.this
                    com.tapjoy.TJPlacement r3 = r8
                    com.tapjoy.TapjoyErrorMessage$ErrorType r4 = com.tapjoy.TapjoyErrorMessage.ErrorType.NETWORK_ERROR
                    com.tapjoy.TJError r5 = new com.tapjoy.TJError
                    int r6 = r0.statusCode
                    java.lang.String r0 = r0.response
                    r5.<init>(r6, r0)
                    r1.mo30685a(r3, r4, r5)
                    goto L_0x0312
                L_0x02e4:
                    com.tapjoy.internal.gi r0 = r9
                    long r1 = r0.f14026e
                    double r3 = (double) r1
                    double r7 = r0.f14025d
                    java.lang.Double.isNaN(r3)
                    double r3 = r3 * r7
                    long r3 = (long) r3
                    long r7 = r0.f14023b
                    int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
                    if (r9 >= 0) goto L_0x02f9
                L_0x02f7:
                    r3 = r7
                    goto L_0x0300
                L_0x02f9:
                    long r7 = r0.f14024c
                    int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
                    if (r9 <= 0) goto L_0x0300
                    goto L_0x02f7
                L_0x0300:
                    r0.f14026e = r3
                    int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
                    if (r3 <= 0) goto L_0x0311
                    monitor-enter(r0)
                    r0.wait(r1)     // Catch:{ InterruptedException -> 0x030d }
                    goto L_0x030d
                L_0x030b:
                    r1 = move-exception
                    goto L_0x030f
                L_0x030d:
                    monitor-exit(r0)     // Catch:{ all -> 0x030b }
                    goto L_0x0311
                L_0x030f:
                    monitor-exit(r0)     // Catch:{ all -> 0x030b }
                    throw r1
                L_0x0311:
                    return r10
                L_0x0312:
                    com.tapjoy.TJCorePlacement r0 = com.tapjoy.TJCorePlacement.this
                    boolean unused = r0.f13016w = false
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TJCorePlacement.C48423.m16579a():boolean");
            }

            public final void run() {
                C3137gf.m10282a("TJPlacement.requestContent", d);
                int i = 0;
                while (!m16579a()) {
                    i++;
                    TJCorePlacement.this.f13012s.put(TapjoyConstants.TJC_RETRY, Integer.toString(i));
                    if (i == 1) {
                        d.mo18524a("retry_timeout", (Object) Long.valueOf(fiVar.f13915b));
                    }
                    d.mo18523a("retry_count", (long) i);
                }
            }
        }.start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final String mo30688b() {
        if (!this.f13018y) {
            return TapjoyConnectCore.getAppID();
        }
        return TapjoyConnectCore.getLimitedAppID();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final String mo30683a() {
        if (this.f13002i != null) {
            return "mm";
        }
        return this.f13004k ? "ad" : "none";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo30687a(String str, TJPlacement tJPlacement) {
        synchronized (this.f13011r) {
            this.f13011r.put(str, tJPlacement);
            if (tJPlacement != null) {
                String str2 = f12993a;
                TapjoyLog.m16649d(str2, "Setting " + str + " placement: " + tJPlacement.getGUID());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final TJPlacement mo30682a(String str) {
        TJPlacement tJPlacement;
        synchronized (this.f13011r) {
            tJPlacement = (TJPlacement) this.f13011r.get(str);
            if (tJPlacement != null) {
                String str2 = f12993a;
                TapjoyLog.m16649d(str2, "Returning " + str + " placement: " + tJPlacement.getGUID());
            }
        }
        return tJPlacement;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo30686a(TapjoyErrorMessage.ErrorType errorType, TJError tJError) {
        mo30685a(mo30682a("REQUEST"), errorType, tJError);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo30685a(TJPlacement tJPlacement, TapjoyErrorMessage.ErrorType errorType, TJError tJError) {
        String str = f12993a;
        TapjoyLog.m16650e(str, new TapjoyErrorMessage(errorType, "Content request failed for placement " + this.f12996c.getPlacementName() + "; Reason= " + tJError.message));
        if (tJPlacement != null && tJPlacement.getListener() != null) {
            tJPlacement.getListener().onRequestFailure(tJPlacement, tJError);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m16550a(TJCorePlacement tJCorePlacement, String str) {
        if (str != null) {
            try {
                String str2 = f12993a;
                TapjoyLog.m16649d(str2, "Disable preload flag is set for placement " + tJCorePlacement.f12996c.getPlacementName());
                tJCorePlacement.f12996c.setRedirectURL(new JSONObject(str).getString(TapjoyConstants.TJC_REDIRECT_URL));
                tJCorePlacement.f12996c.setPreloadDisabled(true);
                tJCorePlacement.f12996c.setHasProgressSpinner(true);
                String str3 = f12993a;
                TapjoyLog.m16649d(str3, "redirect_url:" + tJCorePlacement.f12996c.getRedirectURL());
            } catch (JSONException unused) {
                throw new TapjoyException("TJPlacement request failed, malformed server response");
            }
        } else {
            throw new TapjoyException("TJPlacement request failed due to null response");
        }
    }
}
