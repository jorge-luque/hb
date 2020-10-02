package com.onesignal;

import com.onesignal.C4564n1;
import com.onesignal.C4731y1;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallModels;
import com.tapjoy.TapjoyConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: com.onesignal.x1 */
/* compiled from: OneSignalRemoteParams */
class C4720x1 {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static int f12815a;

    /* renamed from: com.onesignal.x1$b */
    /* compiled from: OneSignalRemoteParams */
    static class C4723b extends C4727f {

        /* renamed from: j */
        final /* synthetic */ JSONObject f12818j;

        C4723b(JSONObject jSONObject) {
            this.f12818j = jSONObject;
            this.f12828b = this.f12818j.optBoolean("enterp", false);
            this.f12818j.optBoolean("use_email_auth", false);
            this.f12829c = this.f12818j.optJSONArray("chnl_lst");
            this.f12830d = this.f12818j.optBoolean("fba", false);
            this.f12831e = this.f12818j.optBoolean("restore_ttl_filter", true);
            this.f12827a = this.f12818j.optString("android_sender_id", (String) null);
            this.f12832f = this.f12818j.optBoolean("clear_group_on_summary_click", true);
            this.f12833g = this.f12818j.optBoolean("receive_receipts_enable", false);
            this.f12834h = new C4726e();
            if (this.f12818j.has("outcomes")) {
                JSONObject optJSONObject = this.f12818j.optJSONObject("outcomes");
                if (optJSONObject.has("direct")) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("direct");
                    this.f12834h.f12824c = optJSONObject2.optBoolean("enabled");
                }
                if (optJSONObject.has("indirect")) {
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("indirect");
                    this.f12834h.f12825d = optJSONObject3.optBoolean("enabled");
                    if (optJSONObject3.has("notification_attribution")) {
                        JSONObject optJSONObject4 = optJSONObject3.optJSONObject("notification_attribution");
                        this.f12834h.f12822a = optJSONObject4.optInt("minutes_since_displayed", 1440);
                        this.f12834h.f12823b = optJSONObject4.optInt("limit", 10);
                    }
                }
                if (optJSONObject.has("unattributed")) {
                    JSONObject optJSONObject5 = optJSONObject.optJSONObject("unattributed");
                    this.f12834h.f12826e = optJSONObject5.optBoolean("enabled");
                }
            }
            this.f12835i = new C4725d();
            if (this.f12818j.has("fcm")) {
                JSONObject optJSONObject6 = this.f12818j.optJSONObject("fcm");
                this.f12835i.f12821c = optJSONObject6.optString(TapjoyConstants.TJC_API_KEY, (String) null);
                this.f12835i.f12820b = optJSONObject6.optString("app_id", (String) null);
                this.f12835i.f12819a = optJSONObject6.optString("project_id", (String) null);
            }
        }
    }

    /* renamed from: com.onesignal.x1$c */
    /* compiled from: OneSignalRemoteParams */
    interface C4724c {
        /* renamed from: a */
        void mo29874a(C4727f fVar);
    }

    /* renamed from: com.onesignal.x1$d */
    /* compiled from: OneSignalRemoteParams */
    static class C4725d {

        /* renamed from: a */
        String f12819a;

        /* renamed from: b */
        String f12820b;

        /* renamed from: c */
        String f12821c;

        C4725d() {
        }
    }

    /* renamed from: com.onesignal.x1$e */
    /* compiled from: OneSignalRemoteParams */
    static class C4726e {

        /* renamed from: a */
        int f12822a = 1440;

        /* renamed from: b */
        int f12823b = 10;

        /* renamed from: c */
        boolean f12824c = false;

        /* renamed from: d */
        boolean f12825d = false;

        /* renamed from: e */
        boolean f12826e = false;

        C4726e() {
        }
    }

    /* renamed from: com.onesignal.x1$f */
    /* compiled from: OneSignalRemoteParams */
    static class C4727f {

        /* renamed from: a */
        String f12827a;

        /* renamed from: b */
        boolean f12828b;

        /* renamed from: c */
        JSONArray f12829c;

        /* renamed from: d */
        boolean f12830d;

        /* renamed from: e */
        boolean f12831e;

        /* renamed from: f */
        boolean f12832f;

        /* renamed from: g */
        boolean f12833g;

        /* renamed from: h */
        C4726e f12834h;

        /* renamed from: i */
        C4725d f12835i;

        C4727f() {
        }
    }

    /* renamed from: b */
    static /* synthetic */ int m16426b() {
        int i = f12815a;
        f12815a = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m16427b(String str, C4724c cVar) {
        try {
            cVar.mo29874a(new C4723b(new JSONObject(str)));
        } catch (NullPointerException | JSONException e) {
            C4564n1.m15790a(C4564n1.C4566a0.FATAL, "Error parsing android_params!: ", e);
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.FATAL;
            C4564n1.m15789a(a0Var, "Response that errored from android_params!: " + str);
        }
    }

    /* renamed from: com.onesignal.x1$a */
    /* compiled from: OneSignalRemoteParams */
    static class C4721a extends C4731y1.C4738g {

        /* renamed from: a */
        final /* synthetic */ C4724c f12816a;

        /* renamed from: com.onesignal.x1$a$a */
        /* compiled from: OneSignalRemoteParams */
        class C4722a implements Runnable {
            C4722a() {
            }

            public void run() {
                int a = (C4720x1.f12815a * C6078a.DEFAULT_TIMEOUT) + QumparaOfferwallModels.OfferwallStatus.VIRTUAL_CURRENCY_MIN_INTERVAL;
                if (a > 90000) {
                    a = 90000;
                }
                C4564n1.C4566a0 a0Var = C4564n1.C4566a0.INFO;
                C4564n1.m15789a(a0Var, "Failed to get Android parameters, trying again in " + (a / 1000) + " seconds.");
                C4536k1.m15631b(a);
                C4720x1.m16426b();
                C4720x1.m16424a(C4721a.this.f12816a);
            }
        }

        C4721a(C4724c cVar) {
            this.f12816a = cVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29736a(int i, String str, Throwable th) {
            if (i == 403) {
                C4564n1.m15789a(C4564n1.C4566a0.FATAL, "403 error getting OneSignal params, omitting further retries!");
            } else {
                new Thread(new C4722a(), "OS_PARAMS_REQUEST").start();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29737a(String str) {
            C4720x1.m16427b(str, this.f12816a);
        }
    }

    /* renamed from: a */
    static void m16424a(C4724c cVar) {
        C4721a aVar = new C4721a(cVar);
        String str = "apps/" + C4564n1.f12493c + "/android_params.js";
        String I = C4564n1.m15759I();
        if (I != null) {
            str = str + "?player_id=" + I;
        }
        C4564n1.m15789a(C4564n1.C4566a0.DEBUG, "Starting request to get Android parameters.");
        C4731y1.m16444a(str, (C4731y1.C4738g) aVar, "CACHE_KEY_REMOTE_PARAMS");
    }
}
