package com.moat.analytics.mobile.vng;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.ShareConstants;
import com.moat.analytics.mobile.vng.C4412s;
import com.moat.analytics.mobile.vng.C4424w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.vng.j */
class C4395j {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f11784a = 0;

    /* renamed from: b */
    private boolean f11785b = false;

    /* renamed from: c */
    private boolean f11786c = false;

    /* renamed from: d */
    private final AtomicBoolean f11787d = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f11788e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f11789f = false;

    /* renamed from: g */
    private boolean f11790g = false;

    /* renamed from: h */
    private final WeakReference<WebView> f11791h;

    /* renamed from: i */
    private final Map<C4377b, String> f11792i;

    /* renamed from: j */
    private final LinkedList<String> f11793j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final long f11794k;

    /* renamed from: l */
    private final String f11795l;

    /* renamed from: m */
    private final List<String> f11796m;

    /* renamed from: n */
    private final C4399a f11797n;

    /* renamed from: o */
    private final BroadcastReceiver f11798o = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                C4395j.this.m14712d();
            } catch (Exception e) {
                C4403n.m14758a(e);
            }
            if (System.currentTimeMillis() - C4395j.this.f11794k > 30000) {
                C4395j.this.m14727i();
            }
        }
    };

    /* renamed from: p */
    private final BroadcastReceiver f11799p = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                C4395j.this.m14716e();
            } catch (Exception e) {
                C4403n.m14758a(e);
            }
        }
    };

    /* renamed from: com.moat.analytics.mobile.vng.j$a */
    enum C4399a {
        WEBVIEW,
        NATIVE_DISPLAY,
        NATIVE_VIDEO
    }

    C4395j(WebView webView, C4399a aVar) {
        this.f11791h = new WeakReference<>(webView);
        this.f11797n = aVar;
        this.f11793j = new LinkedList<>();
        this.f11796m = new ArrayList();
        this.f11792i = new WeakHashMap();
        this.f11794k = System.currentTimeMillis();
        this.f11795l = String.format("javascript:(function(d,k){function l(){function d(a,b){var c=ipkn[b]||ipkn[kuea];if(c){var h=function(b){var c=b.b;c.ts=b.i;c.ticks=b.g;c.buffered=!0;a(c)};h(c.first);c.a.forEach(function(a){h(a)})}}function e(a){var b=a.a,c=a.c,h=a.b;a=a.f;var d=[];if(c)b[c]&&d.push(b[c].fn[0]);else for(key in b)if(b[key])for(var g=0,e=b[key].fn.length;g<e;g++)d.push(b[key].fn[g]);g=0;for(e=d.length;g<e;g++){var f=d[g];if('function'===typeof f)try{h?f(h):f()}catch(k){}a&&delete b[c]}}function f(a,b,c){'function'===typeof a&& (b===kuea&&c[b]?c[b].fn.push(a):c[b]={ts:+new Date,fn:[a]},c===yhgt&&d(a,b))}kuea=+new Date;iymv={};briz=!1;ewat=+new Date;bnkr=[];bjmk={};dptk={};uqaj={};ryup={};yhgt={};ipkn={};csif={};this.h=function(a){this.namespace=a.namespace;this.version=a.version;this.appName=a.appName;this.deviceOS=a.deviceOS;this.isNative=a.isNative;this.versionHash=a.versionHash;this.aqzx=a.aqzx;this.appId=a.appId;this.metadata=a};this.nvsj=function(a){briz||(f(a,ewat,iymv),briz=!0)};this.bpsy=function(a,b){var c=b||kuea; c!==kuea&&bjmk[c]||f(a,c,bjmk)};this.qmrv=function(a,b){var c=b||kuea;c!==kuea&&uqaj[c]||f(a,c,uqaj)};this.lgpr=function(a,b){f(a,b||kuea,yhgt)};this.hgen=function(a,b){f(a,b||kuea,csif)};this.xrnk=function(a){delete yhgt[a||kuea]};this.vgft=function(a){return dptk[a||kuea]||!1};this.lkpu=function(a){return ryup[a||kuea]||!1};this.crts=function(a){var b={a:iymv,b:a,c:ewat};briz?e(b):bnkr.push(a)};this.mqjh=function(a){var b=a||kuea;dptk[b]=!0;var c={a:bjmk,f:!0};b!==kuea&&(c.b=a,c.c=a);e(c)};this.egpw= function(a){var b=a||kuea;ryup[b]=!0;var c={a:uqaj,f:!0};b!==kuea&&(c.b=a,c.c=a);e(c)};this.sglu=function(a){var b=a.adKey||kuea,c={a:yhgt,b:a.event||a,g:1,i:+new Date,f:!1};b!==kuea&&(c.c=a.adKey);a=0<Object.keys(yhgt).length;if(!a||!this.isNative)if(ipkn[b]){var d=ipkn[b].a.slice(-1)[0]||ipkn[b].first;JSON.stringify(c.b)==JSON.stringify(d.b)?d.g+=1:(5<=ipkn[b].a.length&&ipkn[b].a.shift(),ipkn[b].a.push(c))}else ipkn[b]={first:c,a:[]};a&&e(c);return a};this.ucbx=function(a){e({c:a.adKey||kuea,a:csif, b:a.event,f:!1})}}'undefined'===typeof d.MoatMAK&&(d.MoatMAK=new l,d.MoatMAK.h(k),d.__zMoatInit__=!0)})(window,%s);", new Object[]{m14725h()});
        if (m14715d("Initialize")) {
            IntentFilter intentFilter = new IntentFilter("UPDATE_METADATA");
            IntentFilter intentFilter2 = new IntentFilter("UPDATE_VIEW_INFO");
            C4392i.m14686a().mo29304a(C4412s.m14783b(), this.f11798o, intentFilter);
            C4392i.m14686a().mo29304a(C4412s.m14783b(), this.f11799p, intentFilter2);
            m14712d();
            C4392i.m14686a().mo29306a(C4412s.m14783b(), this);
            C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "bridge initialization succeeded");
        }
    }

    /* renamed from: a */
    private boolean m14706a(WebView webView) {
        return webView.getSettings().getJavaScriptEnabled();
    }

    /* renamed from: b */
    static /* synthetic */ int m14708b(C4395j jVar) {
        int i = jVar.f11784a;
        jVar.f11784a = i + 1;
        return i;
    }

    /* renamed from: c */
    private void m14710c() {
        for (Map.Entry<C4377b, String> key : this.f11792i.entrySet()) {
            C4377b bVar = (C4377b) key.getKey();
            if (bVar.mo29266e()) {
                m14724g(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.mqjh(\"%s\");}", new Object[]{bVar.f11724e}));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m14712d() {
        try {
            if (C4424w.m14808a().f11856a != C4424w.C4432d.OFF) {
                if (!this.f11786c) {
                    C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "Attempting to establish communication (setting environment variables).");
                    this.f11786c = true;
                }
                m14724g(this.f11795l);
            }
        } catch (Exception e) {
            C4409p.m14774a("JavaScriptBridge", (Object) this, "Attempt failed to establish communication (did not set environment variables).", (Throwable) e);
        }
    }

    /* renamed from: d */
    private void m14713d(C4377b bVar) {
        C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "Stopping view update loop");
        if (bVar != null) {
            C4392i.m14686a().mo29307a(bVar);
        }
    }

    /* renamed from: d */
    private boolean m14715d(String str) {
        WebView g = m14722g();
        if (g == null) {
            C4409p.m14772a(6, "JavaScriptBridge", (Object) this, "WebView is null. Can't " + str);
            throw new C4403n("WebView is null");
        } else if (m14706a(g)) {
            return true;
        } else {
            C4409p.m14772a(6, "JavaScriptBridge", (Object) this, "JavaScript is not enabled in the given WebView. Can't " + str);
            throw new C4403n("JavaScript is not enabled in the WebView");
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(19)
    /* renamed from: e */
    public void m14716e() {
        try {
            if (C4424w.m14808a().f11856a != C4424w.C4432d.OFF) {
                if (this.f11790g) {
                    C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "Can't send info, already cleaned up");
                    return;
                }
                if (m14721f()) {
                    if (!this.f11785b || m14722g().getUrl() != null) {
                        if (m14722g().getUrl() != null) {
                            this.f11785b = true;
                        }
                        for (Map.Entry<C4377b, String> key : this.f11792i.entrySet()) {
                            C4377b bVar = (C4377b) key.getKey();
                            if (bVar == null || bVar.mo29267f() == null) {
                                C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "Tracker has no subject");
                                if (bVar != null) {
                                    if (!bVar.f11725f) {
                                    }
                                }
                                mo29319c(bVar);
                            }
                            if (bVar.mo29266e()) {
                                if (!this.f11787d.get()) {
                                    m14724g(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.mqjh(\"%s\");}", new Object[]{bVar.f11724e}));
                                }
                                String format = String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.sglu(%s);}", new Object[]{bVar.mo29269h()});
                                if (Build.VERSION.SDK_INT >= 19) {
                                    m14722g().evaluateJavascript(format, new ValueCallback<String>() {
                                        /* renamed from: a */
                                        public void onReceiveValue(String str) {
                                            String str2 = "null";
                                            if (str == null || str.equalsIgnoreCase(str2) || str.equalsIgnoreCase("false")) {
                                                C4395j jVar = C4395j.this;
                                                StringBuilder sb = new StringBuilder();
                                                sb.append("Received value is:");
                                                if (str != null) {
                                                    str2 = "(String)" + str;
                                                }
                                                sb.append(str2);
                                                C4409p.m14772a(3, "JavaScriptBridge", (Object) jVar, sb.toString());
                                                if (C4395j.this.f11784a >= 150) {
                                                    C4409p.m14772a(3, "JavaScriptBridge", (Object) C4395j.this, "Giving up on finding ad");
                                                    C4395j.this.mo29316b();
                                                }
                                                C4395j.m14708b(C4395j.this);
                                                if (str != null && str.equalsIgnoreCase("false") && !C4395j.this.f11788e) {
                                                    boolean unused = C4395j.this.f11788e = true;
                                                    C4409p.m14772a(3, "JavaScriptBridge", (Object) C4395j.this, "Bridge connection established");
                                                }
                                            } else if (str.equalsIgnoreCase("true")) {
                                                if (!C4395j.this.f11789f) {
                                                    boolean unused2 = C4395j.this.f11789f = true;
                                                    C4409p.m14772a(3, "JavaScriptBridge", (Object) C4395j.this, "Javascript has found ad");
                                                    C4395j.this.mo29312a();
                                                }
                                                int unused3 = C4395j.this.f11784a = 0;
                                            } else {
                                                C4409p.m14772a(3, "JavaScriptBridge", (Object) C4395j.this, "Received unusual value from Javascript:" + str);
                                            }
                                        }
                                    });
                                } else {
                                    m14722g().loadUrl(format);
                                }
                            }
                        }
                        return;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("WebView became null");
                sb.append(m14722g() == null ? "" : "based on null url");
                sb.append(", stopping tracking loop");
                C4409p.m14772a(3, "JavaScriptBridge", (Object) this, sb.toString());
                mo29316b();
            }
        } catch (Exception e) {
            C4403n.m14758a(e);
            mo29316b();
        }
    }

    /* renamed from: e */
    private void m14718e(String str) {
        if (this.f11796m.size() >= 50) {
            this.f11796m.subList(0, 25).clear();
        }
        this.f11796m.add(str);
    }

    /* renamed from: f */
    private void m14720f(String str) {
        if (this.f11787d.get()) {
            m14724g(str);
        } else {
            m14718e(str);
        }
    }

    /* renamed from: f */
    private boolean m14721f() {
        return m14722g() != null;
    }

    /* renamed from: g */
    private WebView m14722g() {
        return (WebView) this.f11791h.get();
    }

    /* renamed from: g */
    private void m14724g(String str) {
        if (this.f11790g) {
            C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "Can't send, already cleaned up");
        } else if (m14721f()) {
            C4409p.m14776b(2, "JavaScriptBridge", this, str);
            if (Build.VERSION.SDK_INT >= 19) {
                m14722g().evaluateJavascript(str, (ValueCallback) null);
            } else {
                m14722g().loadUrl(str);
            }
        }
    }

    /* renamed from: h */
    private String m14725h() {
        try {
            C4412s.C4414a c = C4412s.m14785c();
            C4412s.C4415b d = C4412s.m14786d();
            HashMap hashMap = new HashMap();
            String a = c.mo29337a();
            String b = c.mo29338b();
            String c2 = c.mo29339c();
            String num = Integer.toString(Build.VERSION.SDK_INT);
            String a2 = C4412s.m14780a();
            C4399a aVar = this.f11797n;
            C4399a aVar2 = C4399a.WEBVIEW;
            String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            String str2 = aVar == aVar2 ? str : "1";
            String str3 = d.f11849e ? "1" : str;
            if (d.f11848d) {
                str = "1";
            }
            hashMap.put("versionHash", "fe5b19d82fecca4c1d668e2e40e2636224135a71");
            hashMap.put("appName", a);
            hashMap.put("namespace", "VNG");
            hashMap.put("version", "2.6.3");
            hashMap.put("deviceOS", num);
            hashMap.put("isNative", str2);
            hashMap.put("appId", b);
            hashMap.put(ShareConstants.FEED_SOURCE_PARAM, c2);
            hashMap.put("carrier", d.f11846b);
            hashMap.put("sim", d.f11845a);
            hashMap.put(PlaceFields.PHONE, String.valueOf(d.f11847c));
            hashMap.put("buildFp", Build.FINGERPRINT);
            hashMap.put("buildModel", Build.MODEL);
            hashMap.put("buildMfg", Build.MANUFACTURER);
            hashMap.put("buildBrand", Build.BRAND);
            hashMap.put("buildProduct", Build.PRODUCT);
            hashMap.put("buildTags", Build.TAGS);
            hashMap.put("f1", str);
            hashMap.put("f2", str3);
            if (a2 != null) {
                hashMap.put("aqzx", a2);
            }
            return new JSONObject(hashMap).toString();
        } catch (Exception unused) {
            return "{}";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m14727i() {
        C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "Stopping metadata reporting loop");
        C4392i.m14686a().mo29308a(this);
        C4392i.m14686a().mo29303a(C4412s.m14783b(), this.f11798o);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29312a() {
        C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "webViewReady");
        if (this.f11787d.compareAndSet(false, true)) {
            C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "webViewReady first time");
            m14727i();
            for (String g : this.f11796m) {
                m14724g(g);
            }
            this.f11796m.clear();
        }
        m14710c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29313a(C4377b bVar) {
        if (bVar != null) {
            C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "adding tracker" + bVar.f11724e);
            this.f11792i.put(bVar, "");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29314a(String str) {
        m14720f(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.crts(%s);}", new Object[]{str}));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29315a(String str, JSONObject jSONObject) {
        if (this.f11790g) {
            C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "Can't dispatch, already cleaned up");
            return;
        }
        String jSONObject2 = jSONObject.toString();
        if (!this.f11787d.get() || !m14721f()) {
            this.f11793j.add(jSONObject2);
            return;
        }
        m14724g(String.format("javascript:%s.dispatchEvent(%s);", new Object[]{str, jSONObject2}));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29316b() {
        C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "Cleaning up");
        this.f11790g = true;
        m14727i();
        for (Map.Entry<C4377b, String> key : this.f11792i.entrySet()) {
            m14713d((C4377b) key.getKey());
        }
        this.f11792i.clear();
        C4392i.m14686a().mo29303a(C4412s.m14783b(), this.f11799p);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29317b(C4377b bVar) {
        if (m14715d("startTracking")) {
            C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "Starting tracking on tracker" + bVar.f11724e);
            m14724g(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.mqjh(\"%s\");}", new Object[]{bVar.f11724e}));
            C4392i.m14686a().mo29305a(C4412s.m14783b(), bVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29318b(String str) {
        C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "markUserInteractionEvent:" + str);
        m14720f(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.ucbx(%s);}", new Object[]{str}));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo29319c(C4377b bVar) {
        C4403n nVar = null;
        if (!this.f11790g) {
            try {
                if (m14715d("stopTracking")) {
                    try {
                        C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "Ending tracking on tracker" + bVar.f11724e);
                        m14724g(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.egpw(\"%s\");}", new Object[]{bVar.f11724e}));
                    } catch (Exception e) {
                        C4409p.m14774a("JavaScriptBridge", (Object) this, "Failed to end impression.", (Throwable) e);
                    }
                }
            } catch (C4403n e2) {
                nVar = e2;
            }
            if (this.f11797n == C4399a.NATIVE_DISPLAY) {
                m14713d(bVar);
            } else {
                mo29316b();
            }
            this.f11792i.remove(bVar);
        }
        if (nVar != null) {
            throw nVar;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo29320c(String str) {
        C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "flushDispatchQueue");
        if (this.f11793j.size() >= 200) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < 10; i++) {
                linkedList.addFirst(this.f11793j.removeFirst());
            }
            int min = Math.min(Math.min(this.f11793j.size() / 200, 10) + 200, this.f11793j.size());
            for (int i2 = 0; i2 < min; i2++) {
                this.f11793j.removeFirst();
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                this.f11793j.addFirst((String) it.next());
            }
        }
        if (!this.f11793j.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            String str2 = "";
            int i3 = 1;
            while (!this.f11793j.isEmpty() && i3 < 200) {
                i3++;
                String removeFirst = this.f11793j.removeFirst();
                if (sb.length() + removeFirst.length() > 2000) {
                    break;
                }
                sb.append(str2);
                sb.append(removeFirst);
                str2 = ",";
            }
            m14724g(String.format("javascript:%s.dispatchMany([%s])", new Object[]{str, sb.toString()}));
        }
        this.f11793j.clear();
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            super.finalize();
            C4409p.m14772a(3, "JavaScriptBridge", (Object) this, "finalize");
            mo29316b();
        } catch (Exception e) {
            C4403n.m14758a(e);
        }
    }
}
