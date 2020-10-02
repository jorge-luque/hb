package com.onesignal;

import com.onesignal.C4742z1;
import com.tapjoy.TapjoyConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.s2 */
/* compiled from: UserStateEmailSynchronizer */
class C4643s2 extends C4677v2 {
    C4643s2() {
        super(C4742z1.C4743a.EMAIL);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C4629q2 mo29946a(String str, boolean z) {
        return new C4639r2(str, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo29949b(JSONObject jSONObject) {
        if (jSONObject.has("identifier")) {
            C4564n1.m15871n();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo29950c() {
        return C4564n1.m15878t();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo29952k() {
        if (!(mo29950c() == null && mo30002d() == null) && C4564n1.m15759I() != null) {
            mo29994a((Integer) 0).mo30012b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo29953m() {
        mo29952k();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29947a(String str) {
        C4564n1.m15858i(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo29951c(JSONObject jSONObject) {
        if (jSONObject.has("identifier")) {
            C4564n1.m15873o();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29948a(JSONObject jSONObject) {
        try {
            jSONObject.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, 11);
            jSONObject.putOpt("device_player_id", C4564n1.m15759I());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
