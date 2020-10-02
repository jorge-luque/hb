package com.onesignal;

import android.content.Context;
import com.amazon.device.messaging.ADM;
import com.onesignal.C4519h2;
import com.onesignal.C4564n1;

/* renamed from: com.onesignal.i2 */
/* compiled from: PushRegistratorADM */
public class C4526i2 implements C4519h2 {

    /* renamed from: a */
    private static C4519h2.C4520a f12374a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static boolean f12375b = false;

    /* renamed from: com.onesignal.i2$a */
    /* compiled from: PushRegistratorADM */
    class C4527a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f12376a;

        /* renamed from: b */
        final /* synthetic */ C4519h2.C4520a f12377b;

        C4527a(C4526i2 i2Var, Context context, C4519h2.C4520a aVar) {
            this.f12376a = context;
            this.f12377b = aVar;
        }

        public void run() {
            ADM adm = new ADM(this.f12376a);
            String registrationId = adm.getRegistrationId();
            if (registrationId == null) {
                adm.startRegister();
            } else {
                C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
                C4564n1.m15789a(a0Var, "ADM Already registered with ID:" + registrationId);
                this.f12377b.mo29784a(registrationId, 1);
            }
            try {
                Thread.sleep(30000);
            } catch (InterruptedException unused) {
            }
            if (!C4526i2.f12375b) {
                C4564n1.m15789a(C4564n1.C4566a0.ERROR, "com.onesignal.ADMMessageHandler timed out, please check that your have the receiver, service, and your package name matches(NOTE: Case Sensitive) per the OneSignal instructions.");
                C4526i2.m15568a((String) null);
            }
        }
    }

    /* renamed from: a */
    public void mo29783a(Context context, String str, C4519h2.C4520a aVar) {
        f12374a = aVar;
        new Thread(new C4527a(this, context, aVar)).start();
    }

    /* renamed from: a */
    public static void m15568a(String str) {
        C4519h2.C4520a aVar = f12374a;
        if (aVar != null) {
            f12375b = true;
            aVar.mo29784a(str, 1);
        }
    }
}
