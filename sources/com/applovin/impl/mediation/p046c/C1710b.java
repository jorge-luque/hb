package com.applovin.impl.mediation.p046c;

import android.app.Activity;
import com.applovin.impl.mediation.p045b.C1702f;
import com.applovin.impl.mediation.p045b.C1704g;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p050b.C1840b;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.utils.C1989e;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.mediation.MaxAdFormat;
import com.facebook.internal.AnalyticsEvents;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;
import com.tapjoy.TapjoyConstants;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.b */
public class C1710b extends C1864a {

    /* renamed from: a */
    private static String f5321a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final MaxAdFormat f5322c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Activity f5323d;

    /* renamed from: e */
    private final C1714a f5324e;

    /* renamed from: com.applovin.impl.mediation.c.b$a */
    public interface C1714a {
        /* renamed from: a */
        void mo7858a(JSONArray jSONArray);
    }

    static {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(m6541a("APPLOVIN_NETWORK", "com.applovin.mediation.adapters.AppLovinMediationAdapter"));
            m6541a("FACEBOOK_NETWORK", "com.applovin.mediation.adapters.FacebookMediationAdapter").put("run_on_ui_thread", false);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("signal_providers", jSONArray);
            f5321a = jSONObject.toString();
        } catch (JSONException unused) {
        }
    }

    public C1710b(MaxAdFormat maxAdFormat, Activity activity, C1941j jVar, C1714a aVar) {
        super("TaskCollectSignals", jVar);
        this.f5322c = maxAdFormat;
        this.f5323d = activity;
        this.f5324e = aVar;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.applovin.impl.sdk.b.c, com.applovin.impl.sdk.b.c<java.lang.Integer>] */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r4 = ((java.lang.Integer) r2.f6217b.mo8549a(r4)).intValue();
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m6540a(java.lang.String r3, com.applovin.impl.sdk.p050b.C1841c<java.lang.Integer> r4) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            com.applovin.impl.sdk.j r0 = r2.f6217b
            java.lang.Object r4 = r0.mo8549a(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 <= 0) goto L_0x0025
            r0 = 0
            int r1 = r3.length()
            int r4 = java.lang.Math.min(r1, r4)
            java.lang.String r3 = r3.substring(r0, r4)
            return r3
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.p046c.C1710b.m6540a(java.lang.String, com.applovin.impl.sdk.b.c):java.lang.String");
    }

    /* renamed from: a */
    private static JSONObject m6541a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", str);
        jSONObject.put("class", str2);
        jSONObject.put("adapter_timeout_ms", QumparaOfferwallModels.OfferwallStatus.VIRTUAL_CURRENCY_MIN_INTERVAL);
        jSONObject.put("max_signal_length", 32768);
        jSONObject.put("scode", "");
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6542a(final C1704g gVar, final C1702f.C1703a aVar) {
        C17132 r0 = new Runnable() {
            public void run() {
                C1710b.this.f6217b.mo8605y().collectSignal(C1710b.this.f5322c, gVar, C1710b.this.f5323d, aVar);
            }
        };
        if (gVar.mo7816H()) {
            mo8405a("Running signal collection for " + gVar + " on the main thread");
            this.f5323d.runOnUiThread(r0);
            return;
        }
        mo8405a("Running signal collection for " + gVar + " on the background thread");
        r0.run();
    }

    /* renamed from: a */
    private void m6544a(Collection<C1702f> collection) {
        String str;
        String a;
        JSONArray jSONArray = new JSONArray();
        for (C1702f next : collection) {
            try {
                JSONObject jSONObject = new JSONObject();
                C1704g a2 = next.mo7842a();
                jSONObject.put("name", a2.mo7813E());
                jSONObject.put("class", a2.mo7812D());
                jSONObject.put(TapjoyConstants.TJC_ADAPTER_VERSION, m6540a(next.mo7844c(), C1840b.f5773k));
                jSONObject.put("sdk_version", m6540a(next.mo7843b(), C1840b.f5774l));
                JSONObject jSONObject2 = new JSONObject();
                if (C2025o.m7963b(next.mo7846e())) {
                    str = AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE;
                    a = next.mo7846e();
                } else {
                    str = "signal";
                    a = m6540a(next.mo7845d(), C1840b.f5775m);
                }
                jSONObject2.put(str, a);
                jSONObject.put("data", jSONObject2);
                jSONArray.put(jSONObject);
                mo8405a("Collected signal from " + a2);
            } catch (JSONException e) {
                mo8406a("Failed to create signal data", e);
            }
        }
        m6545a(jSONArray);
    }

    /* renamed from: a */
    private void m6545a(JSONArray jSONArray) {
        C1714a aVar = this.f5324e;
        if (aVar != null) {
            aVar.mo7858a(jSONArray);
        }
    }

    /* renamed from: a */
    private void m6546a(JSONArray jSONArray, JSONObject jSONObject) throws JSONException, InterruptedException {
        List a = C1989e.m7830a(jSONArray.length());
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        CountDownLatch countDownLatch = new CountDownLatch(jSONArray.length());
        ScheduledExecutorService b = this.f6217b.mo8533L().mo8479b();
        for (int i = 0; i < jSONArray.length(); i++) {
            final C1704g gVar = new C1704g(jSONArray.getJSONObject(i), jSONObject, this.f6217b);
            final AtomicBoolean atomicBoolean2 = atomicBoolean;
            final List list = a;
            final CountDownLatch countDownLatch2 = countDownLatch;
            b.execute(new Runnable() {
                public void run() {
                    C1710b.this.m6542a(gVar, (C1702f.C1703a) new C1702f.C1703a() {
                        /* renamed from: a */
                        public void mo7848a(C1702f fVar) {
                            if (atomicBoolean2.get() && fVar != null) {
                                list.add(fVar);
                            }
                            countDownLatch2.countDown();
                        }
                    });
                }
            });
        }
        countDownLatch.await(((Long) this.f6217b.mo8549a(C1840b.f5772j)).longValue(), TimeUnit.MILLISECONDS);
        atomicBoolean.set(false);
        m6544a((Collection<C1702f>) a);
    }

    /* renamed from: b */
    private void m6548b(String str, Throwable th) {
        mo8406a("No signals collected: " + str, th);
        m6545a(new JSONArray());
    }

    public void run() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject((String) this.f6217b.mo8574b(C1843e.f6109w, f5321a));
            JSONArray b = C1993i.m7900b(jSONObject, "signal_providers", (JSONArray) null, this.f6217b);
            if (b.length() == 0) {
                m6548b("No signal providers found", (Throwable) null);
            } else {
                m6546a(b, jSONObject);
            }
        } catch (JSONException e) {
            th = e;
            str = "Failed to parse signals JSON";
            m6548b(str, th);
        } catch (InterruptedException e2) {
            th = e2;
            str = "Failed to wait for signals";
            m6548b(str, th);
        } catch (Throwable th) {
            th = th;
            str = "Failed to collect signals";
            m6548b(str, th);
        }
    }
}
