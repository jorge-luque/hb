package com.onesignal;

import com.onesignal.C4564n1;
import com.onesignal.C4731y1;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.d1 */
/* compiled from: OSReceiveReceiptRepository */
class C4486d1 {
    C4486d1() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29738a(String str, String str2, String str3, C4731y1.C4738g gVar) {
        try {
            JSONObject put = new JSONObject().put("app_id", str).put("player_id", str2);
            C4731y1.m16451c("notifications/" + str3 + "/report_received", put, gVar);
        } catch (JSONException e) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Generating direct receive receipt:JSON Failed.", (Throwable) e);
        }
    }
}
