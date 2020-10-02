package com.applovin.impl.sdk;

import android.content.Intent;
import android.text.TextUtils;
import com.applovin.impl.sdk.C1945k;
import com.applovin.impl.sdk.network.C1968f;
import com.applovin.impl.sdk.network.C1971g;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1888i;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.appevents.AppEventsConstants;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class EventServiceImpl implements AppLovinEventService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1941j f5531a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<String, Object> f5532b;

    /* renamed from: c */
    private final AtomicBoolean f5533c = new AtomicBoolean();

    public EventServiceImpl(C1941j jVar) {
        this.f5531a = jVar;
        if (((Boolean) jVar.mo8549a(C1841c.f5822aV)).booleanValue()) {
            this.f5532b = C1993i.m7878a((String) this.f5531a.mo8574b(C1843e.f6104r, "{}"), (Map<String, Object>) new HashMap(), this.f5531a);
            return;
        }
        this.f5532b = new HashMap();
        jVar.mo8556a(C1843e.f6104r, "{}");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m6736a() {
        return ((String) this.f5531a.mo8549a(C1841c.f5813aM)) + "4.0/pix";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public HashMap<String, String> m6738a(C1954m mVar, C1945k.C1947a aVar) {
        C1945k O = this.f5531a.mo8536O();
        C1945k.C1950d b = O.mo8613b();
        C1945k.C1948b c = O.mo8614c();
        boolean contains = this.f5531a.mo8576b(C1841c.f5819aS).contains(mVar.mo8622a());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(TapjoyConstants.TJC_SDK_TYPE_DEFAULT, contains ? C2025o.m7966e(mVar.mo8622a()) : "postinstall");
        hashMap.put("ts", Long.toString(mVar.mo8624c()));
        hashMap.put(TapjoyConstants.TJC_PLATFORM, C2025o.m7966e(b.f6498a));
        hashMap.put("model", C2025o.m7966e(b.f6501d));
        hashMap.put("api_level", String.valueOf(b.f6500c));
        hashMap.put("package_name", C2025o.m7966e(c.f6471c));
        hashMap.put("installer_name", C2025o.m7966e(c.f6472d));
        hashMap.put("ia", Long.toString(c.f6476h));
        hashMap.put("api_did", this.f5531a.mo8549a(C1841c.f5792S));
        hashMap.put("brand", C2025o.m7966e(b.f6502e));
        hashMap.put("brand_name", C2025o.m7966e(b.f6503f));
        hashMap.put("hardware", C2025o.m7966e(b.f6504g));
        hashMap.put("revision", C2025o.m7966e(b.f6505h));
        hashMap.put("sdk_version", AppLovinSdk.VERSION);
        hashMap.put("os", C2025o.m7966e(b.f6499b));
        hashMap.put("orientation_lock", b.f6509l);
        hashMap.put(TapjoyConstants.TJC_APP_VERSION_NAME, C2025o.m7966e(c.f6470b));
        hashMap.put(TapjoyConstants.TJC_DEVICE_COUNTRY_CODE, C2025o.m7966e(b.f6506i));
        hashMap.put("carrier", C2025o.m7966e(b.f6507j));
        hashMap.put("tz_offset", String.valueOf(b.f6515r));
        hashMap.put("aida", String.valueOf(b.f6493N));
        String str = "1";
        hashMap.put("adr", b.f6517t ? str : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("volume", String.valueOf(b.f6521x));
        hashMap.put("sb", String.valueOf(b.f6522y));
        if (!b.f6480A) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        hashMap.put("sim", str);
        hashMap.put("gy", String.valueOf(b.f6481B));
        hashMap.put("is_tablet", String.valueOf(b.f6482C));
        hashMap.put("tv", String.valueOf(b.f6483D));
        hashMap.put("vs", String.valueOf(b.f6484E));
        hashMap.put("lpm", String.valueOf(b.f6485F));
        hashMap.put("tg", c.f6473e);
        hashMap.put("ltg", c.f6474f);
        hashMap.put("fs", String.valueOf(b.f6487H));
        hashMap.put("tds", String.valueOf(b.f6488I));
        hashMap.put("fm", String.valueOf(b.f6489J.f6525b));
        hashMap.put("tm", String.valueOf(b.f6489J.f6524a));
        hashMap.put("lmt", String.valueOf(b.f6489J.f6526c));
        hashMap.put("lm", String.valueOf(b.f6489J.f6527d));
        hashMap.put("adns", String.valueOf(b.f6510m));
        hashMap.put("adnsd", String.valueOf(b.f6511n));
        hashMap.put("xdpi", String.valueOf(b.f6512o));
        hashMap.put("ydpi", String.valueOf(b.f6513p));
        hashMap.put("screen_size_in", String.valueOf(b.f6514q));
        hashMap.put("debug", Boolean.toString(c.f6475g));
        hashMap.put("af", String.valueOf(b.f6519v));
        hashMap.put("font", String.valueOf(b.f6520w));
        hashMap.put("bt_ms", String.valueOf(b.f6496Q));
        hashMap.put("mute_switch", String.valueOf(b.f6497R));
        hashMap.put("test_ads", C2025o.m7959a(c.f6477i));
        if (!((Boolean) this.f5531a.mo8549a(C1841c.f6020eK)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f5531a.mo8599t());
        }
        m6741a(aVar, (Map<String, String>) hashMap);
        if (((Boolean) this.f5531a.mo8549a(C1841c.f5968dK)).booleanValue()) {
            C2029r.m8011a("cuid", this.f5531a.mo8588i(), (Map<String, String>) hashMap);
        }
        if (((Boolean) this.f5531a.mo8549a(C1841c.f5971dN)).booleanValue()) {
            hashMap.put("compass_random_token", this.f5531a.mo8589j());
        }
        if (((Boolean) this.f5531a.mo8549a(C1841c.f5973dP)).booleanValue()) {
            hashMap.put("applovin_random_token", this.f5531a.mo8590k());
        }
        Boolean bool = b.f6490K;
        if (bool != null) {
            hashMap.put("huc", bool.toString());
        }
        Boolean bool2 = b.f6491L;
        if (bool2 != null) {
            hashMap.put("aru", bool2.toString());
        }
        Boolean bool3 = b.f6492M;
        if (bool3 != null) {
            hashMap.put("dns", bool3.toString());
        }
        C1945k.C1949c cVar = b.f6518u;
        if (cVar != null) {
            hashMap.put("act", String.valueOf(cVar.f6478a));
            hashMap.put("acm", String.valueOf(cVar.f6479b));
        }
        String str2 = b.f6523z;
        if (C2025o.m7963b(str2)) {
            hashMap.put("ua", C2025o.m7966e(str2));
        }
        String str3 = b.f6486G;
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("so", C2025o.m7966e(str3));
        }
        if (!contains) {
            hashMap.put("sub_event", C2025o.m7966e(mVar.mo8622a()));
        }
        float f = b.f6494O;
        if (f > 0.0f) {
            hashMap.put("da", String.valueOf(f));
        }
        float f2 = b.f6495P;
        if (f2 > 0.0f) {
            hashMap.put("dm", String.valueOf(f2));
        }
        hashMap.put("sc", C2025o.m7966e((String) this.f5531a.mo8549a(C1841c.f5796W)));
        hashMap.put("sc2", C2025o.m7966e((String) this.f5531a.mo8549a(C1841c.f5797X)));
        hashMap.put("sc3", C2025o.m7966e((String) this.f5531a.mo8549a(C1841c.f5798Y)));
        hashMap.put("server_installed_at", C2025o.m7966e((String) this.f5531a.mo8549a(C1841c.f5799Z)));
        C2029r.m8011a("persisted_data", C2025o.m7966e((String) this.f5531a.mo8550a(C1843e.f6111y)), (Map<String, String>) hashMap);
        C2029r.m8011a("plugin_version", C2025o.m7966e((String) this.f5531a.mo8549a(C1841c.f5975dR)), (Map<String, String>) hashMap);
        C2029r.m8011a("mediation_provider", C2025o.m7966e(this.f5531a.mo8593n()), (Map<String, String>) hashMap);
        return hashMap;
    }

    /* renamed from: a */
    private void m6740a(C1888i.C1889a aVar) {
        this.f5531a.mo8533L().mo8475a((C1864a) new C1888i(this.f5531a, aVar), C1907s.C1909a.ADVERTISING_INFO_COLLECTION);
    }

    /* renamed from: a */
    private void m6741a(C1945k.C1947a aVar, Map<String, String> map) {
        String str = aVar.f6468b;
        if (C2025o.m7963b(str)) {
            map.put(QumparaOfferwallUtil.COLUMN_IDFA, str);
        }
        map.put("dnt", Boolean.toString(aVar.f6467a));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m6743b() {
        return ((String) this.f5531a.mo8549a(C1841c.f5814aN)) + "4.0/pix";
    }

    /* renamed from: c */
    private void m6745c() {
        if (((Boolean) this.f5531a.mo8549a(C1841c.f5822aV)).booleanValue()) {
            this.f5531a.mo8556a(C1843e.f6104r, C1993i.m7873a(this.f5532b, "{}", this.f5531a));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8036a(String str, boolean z) {
        trackEvent(str, new HashMap(), (Map<String, String>) null, z);
    }

    public Map<String, Object> getSuperProperties() {
        return new HashMap(this.f5532b);
    }

    public void maybeTrackAppOpenEvent() {
        if (this.f5533c.compareAndSet(false, true)) {
            this.f5531a.mo8596q().trackEvent("landing");
        }
    }

    public void setSuperProperty(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            C1977q.m7751i("AppLovinEventService", "Super property key cannot be null or empty");
        } else if (obj == null) {
            this.f5532b.remove(str);
            m6745c();
        } else {
            List<String> b = this.f5531a.mo8576b(C1841c.f5821aU);
            if (!C2029r.m8020a(obj, b, this.f5531a)) {
                C1977q.m7751i("AppLovinEventService", "Failed to set super property '" + obj + "' for key '" + str + "' - valid super property types include: " + b);
                return;
            }
            this.f5532b.put(str, C2029r.m7995a(obj, this.f5531a));
            m6745c();
        }
    }

    public String toString() {
        return "EventService{}";
    }

    public void trackCheckout(String str, Map<String, String> map) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap(1);
        }
        hashMap.put(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER, str);
        trackEvent(AppLovinEventTypes.USER_COMPLETED_CHECKOUT, hashMap);
    }

    public void trackEvent(String str) {
        trackEvent(str, new HashMap());
    }

    public void trackEvent(String str, Map<String, String> map) {
        trackEvent(str, map, (Map<String, String>) null, true);
    }

    public void trackEvent(String str, Map<String, String> map, Map<String, String> map2, boolean z) {
        if (((Boolean) this.f5531a.mo8549a(C1841c.f5820aT)).booleanValue()) {
            C1977q v = this.f5531a.mo8602v();
            v.mo8742b("AppLovinEventService", "Tracking event: \"" + str + "\" with parameters: " + map);
            final String str2 = str;
            final Map<String, String> map3 = map;
            final boolean z2 = z;
            final Map<String, String> map4 = map2;
            m6740a((C1888i.C1889a) new C1888i.C1889a() {
                /* renamed from: a */
                public void mo8046a(C1945k.C1947a aVar) {
                    C1954m mVar = new C1954m(str2, map3, EventServiceImpl.this.f5532b);
                    try {
                        if (z2) {
                            EventServiceImpl.this.f5531a.mo8535N().mo8678a(C1968f.m7656m().mo8703c(EventServiceImpl.this.m6736a()).mo8705d(EventServiceImpl.this.m6743b()).mo8698a((Map<String, String>) EventServiceImpl.this.m6738a(mVar, aVar)).mo8702b((Map<String, String>) map4).mo8704c(mVar.mo8623b()).mo8699a(((Boolean) EventServiceImpl.this.f5531a.mo8549a(C1841c.f6020eK)).booleanValue()).mo8700a());
                            return;
                        }
                        EventServiceImpl.this.f5531a.mo8539R().dispatchPostbackRequest(C1971g.m7686b(EventServiceImpl.this.f5531a).mo8663a(EventServiceImpl.this.m6736a()).mo8673c(EventServiceImpl.this.m6743b()).mo8664a((Map<String, String>) EventServiceImpl.this.m6738a(mVar, aVar)).mo8670b((Map<String, String>) map4).mo8665a(C1993i.m7882a((Map<String, ?>) mVar.mo8623b())).mo8666a(((Boolean) EventServiceImpl.this.f5531a.mo8549a(C1841c.f6020eK)).booleanValue()).mo8667a(), (AppLovinPostbackListener) null);
                    } catch (Throwable th) {
                        C1977q v = EventServiceImpl.this.f5531a.mo8602v();
                        v.mo8743b("AppLovinEventService", "Unable to track event: " + mVar, th);
                    }
                }
            });
        }
    }

    public void trackInAppPurchase(Intent intent, Map<String, String> map) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap();
        }
        try {
            hashMap.put(AppLovinEventParameters.IN_APP_PURCHASE_DATA, intent.getStringExtra("INAPP_PURCHASE_DATA"));
            hashMap.put(AppLovinEventParameters.IN_APP_DATA_SIGNATURE, intent.getStringExtra("INAPP_DATA_SIGNATURE"));
        } catch (Throwable th) {
            C1977q.m7747c("AppLovinEventService", "Unable to track in app purchase - invalid purchase intent", th);
        }
        trackEvent("iap", hashMap);
    }
}
