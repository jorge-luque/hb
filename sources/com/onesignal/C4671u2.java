package com.onesignal;

import com.google.android.gms.common.Scopes;
import com.onesignal.C4677v2;
import com.onesignal.C4731y1;
import com.onesignal.C4742z1;
import com.tapjoy.TapjoyConstants;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.u2 */
/* compiled from: UserStatePushSynchronizer */
class C4671u2 extends C4677v2 {
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static boolean f12707l;

    /* renamed from: com.onesignal.u2$a */
    /* compiled from: UserStatePushSynchronizer */
    class C4672a extends C4731y1.C4738g {
        C4672a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29737a(String str) {
            boolean unused = C4671u2.f12707l = true;
            if (str == null || str.isEmpty()) {
                str = "{}";
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("tags")) {
                    synchronized (C4671u2.this.f12713c) {
                        JSONObject a = C4671u2.this.mo29996a(C4671u2.this.f12720j.f12625c.optJSONObject("tags"), C4671u2.this.mo30005f().f12625c.optJSONObject("tags"), (JSONObject) null, (Set<String>) null);
                        C4671u2.this.f12720j.f12625c.put("tags", jSONObject.optJSONObject("tags"));
                        C4671u2.this.f12720j.mo29932c();
                        C4671u2.this.mo30005f().mo29928a(jSONObject, a);
                        C4671u2.this.mo30005f().mo29932c();
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    C4671u2() {
        super(C4742z1.C4743a.PUSH);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C4629q2 mo29946a(String str, boolean z) {
        return new C4656t2(str, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29948a(JSONObject jSONObject) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo29949b(JSONObject jSONObject) {
        if (jSONObject.has(Scopes.EMAIL)) {
            C4564n1.m15871n();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C4677v2.C4683f mo29989c(boolean z) {
        C4677v2.C4683f fVar;
        if (z) {
            String I = C4564n1.m15759I();
            String C = C4564n1.m15753C();
            C4731y1.m16448b("players/" + I + "?app_id=" + C, (C4731y1.C4738g) new C4672a(), "CACHE_KEY_GET_TAGS");
        }
        synchronized (this.f12713c) {
            fVar = new C4677v2.C4683f(f12707l, C4673v.m16246a(this.f12721k.f12625c, "tags"));
        }
        return fVar;
    }

    /* renamed from: d */
    public void mo29990d(boolean z) {
        try {
            mo30006g().f12624b.put("androidPermission", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo29991e(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("identifier", jSONObject.optString("identifier", (String) null));
            if (jSONObject.has(TapjoyConstants.TJC_DEVICE_TYPE_NAME)) {
                jSONObject2.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, jSONObject.optInt(TapjoyConstants.TJC_DEVICE_TYPE_NAME));
            }
            jSONObject2.putOpt("parent_player_id", jSONObject.optString("parent_player_id", (String) null));
            JSONObject jSONObject3 = mo30006g().f12625c;
            mo29996a(jSONObject3, jSONObject2, jSONObject3, (Set<String>) null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            JSONObject jSONObject4 = new JSONObject();
            if (jSONObject.has("subscribableStatus")) {
                jSONObject4.put("subscribableStatus", jSONObject.optInt("subscribableStatus"));
            }
            if (jSONObject.has("androidPermission")) {
                jSONObject4.put("androidPermission", jSONObject.optBoolean("androidPermission"));
            }
            JSONObject jSONObject5 = mo30006g().f12624b;
            mo29996a(jSONObject5, jSONObject4, jSONObject5, (Set<String>) null);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo29952k() {
        mo29994a((Integer) 0).mo30012b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public boolean mo29953m() {
        return mo30005f().mo29931b();
    }

    /* renamed from: n */
    public boolean mo29993n() {
        return mo30005f().f12624b.optBoolean("userSubscribePref", true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29947a(String str) {
        C4564n1.m15860j(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo29950c() {
        return C4564n1.m15759I();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo29951c(JSONObject jSONObject) {
        if (jSONObject.has(Scopes.EMAIL)) {
            C4564n1.m15873o();
        }
        if (jSONObject.has("identifier")) {
            C4564n1.m15874p();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo29992e(boolean z) {
        try {
            mo30006g().f12624b.put("userSubscribePref", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
