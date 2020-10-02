package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.device.messaging.ADMMessageHandlerBase;
import com.onesignal.C4564n1;

public class ADMMessageHandler extends ADMMessageHandlerBase {
    public ADMMessageHandler() {
        super("ADMMessageHandler");
    }

    /* access modifiers changed from: protected */
    public void onMessage(Intent intent) {
        Context applicationContext = getApplicationContext();
        Bundle extras = intent.getExtras();
        if (!C4714x.m16401a(applicationContext, extras).mo30027a()) {
            C4467a0 a0Var = new C4467a0(applicationContext);
            a0Var.f12268b = C4714x.m16412b(extras);
            C4714x.m16400a(a0Var);
        }
    }

    /* access modifiers changed from: protected */
    public void onRegistered(String str) {
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.INFO;
        C4564n1.m15789a(a0Var, "ADM registration ID: " + str);
        C4526i2.m15568a(str);
    }

    /* access modifiers changed from: protected */
    public void onRegistrationError(String str) {
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.ERROR;
        C4564n1.m15789a(a0Var, "ADM:onRegistrationError: " + str);
        if ("INVALID_SENDER".equals(str)) {
            C4564n1.m15789a(C4564n1.C4566a0.ERROR, "Please double check that you have a matching package name (NOTE: Case Sensitive), api_key.txt, and the apk was signed with the same Keystore and Alias.");
        }
        C4526i2.m15568a((String) null);
    }

    /* access modifiers changed from: protected */
    public void onUnregistered(String str) {
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.INFO;
        C4564n1.m15789a(a0Var, "ADM:onUnregistered: " + str);
    }
}
