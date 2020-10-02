package com.adcolony.sdk;

import org.json.JSONObject;

/* renamed from: com.adcolony.sdk.i */
class C1314i implements C1458z {

    /* renamed from: com.adcolony.sdk.i$a */
    class C1315a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f4164a;

        /* renamed from: b */
        final /* synthetic */ String f4165b;

        C1315a(String str, String str2) {
            this.f4164a = str;
            this.f4165b = str2;
        }

        public void run() {
            try {
                AdColonyCustomMessageListener adColonyCustomMessageListener = C1199a.m4880c().mo6541g().get(this.f4164a);
                if (adColonyCustomMessageListener != null) {
                    adColonyCustomMessageListener.onAdColonyCustomMessage(new AdColonyCustomMessage(this.f4164a, this.f4165b));
                }
            } catch (RuntimeException unused) {
            }
        }
    }

    C1314i() {
        C1199a.m4876a("CustomMessage.controller_send", (C1458z) this);
    }

    /* renamed from: a */
    public void mo6395a(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        C1359k0.m5309a((Runnable) new C1315a(C1437s.m5613h(b, "type"), C1437s.m5613h(b, "message")));
    }
}
