package com.adcolony.sdk;

import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;

public class AdColonyCustomMessage {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f3294a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f3295b;

    /* renamed from: com.adcolony.sdk.AdColonyCustomMessage$a */
    class C1198a implements Runnable {
        C1198a() {
        }

        public void run() {
            AdColony.m4810b();
            JSONObject b = C1437s.m5599b();
            C1437s.m5592a(b, "type", AdColonyCustomMessage.this.f3294a);
            C1437s.m5592a(b, "message", AdColonyCustomMessage.this.f3295b);
            new C1454x("CustomMessage.native_send", 1, b).mo6834d();
        }
    }

    public AdColonyCustomMessage(String str, String str2) {
        if (C1359k0.m5333g(str) || C1359k0.m5333g(str2)) {
            this.f3294a = str;
            this.f3295b = str2;
        }
    }

    public String getMessage() {
        return this.f3295b;
    }

    public String getType() {
        return this.f3294a;
    }

    public void send() {
        try {
            AdColony.f3234a.execute(new C1198a());
        } catch (RejectedExecutionException unused) {
        }
    }

    public AdColonyCustomMessage set(String str, String str2) {
        this.f3294a = str;
        this.f3295b = str2;
        return this;
    }
}
