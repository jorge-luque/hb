package com.onesignal;

import com.onesignal.C4564n1;
import com.onesignal.C4731y1;

/* renamed from: com.onesignal.c1 */
/* compiled from: OSReceiveReceiptController */
class C4481c1 {

    /* renamed from: b */
    private static C4481c1 f12300b;

    /* renamed from: a */
    private final C4486d1 f12301a = new C4486d1();

    /* renamed from: com.onesignal.c1$a */
    /* compiled from: OSReceiveReceiptController */
    class C4482a extends C4731y1.C4738g {

        /* renamed from: a */
        final /* synthetic */ String f12302a;

        C4482a(C4481c1 c1Var, String str) {
            this.f12302a = str;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29737a(String str) {
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
            C4564n1.m15789a(a0Var, "Receive receipt sent for notificationID: " + this.f12302a);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo29736a(int i, String str, Throwable th) {
            C4564n1.C4566a0 a0Var = C4564n1.C4566a0.ERROR;
            C4564n1.m15789a(a0Var, "Receive receipt failed with statusCode: " + i + " response: " + str);
        }
    }

    private C4481c1() {
    }

    /* renamed from: a */
    public static synchronized C4481c1 m15439a() {
        C4481c1 c1Var;
        synchronized (C4481c1.class) {
            if (f12300b == null) {
                f12300b = new C4481c1();
            }
            c1Var = f12300b;
        }
        return c1Var;
    }

    /* renamed from: b */
    private boolean m15440b() {
        return C4698w1.m16348a(C4698w1.f12761a, "PREFS_OS_RECEIVE_RECEIPTS_ENABLED", false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29735a(String str) {
        String str2 = C4564n1.f12493c;
        String C = (str2 == null || str2.isEmpty()) ? C4564n1.m15753C() : C4564n1.f12493c;
        String I = C4564n1.m15759I();
        if (!m15440b()) {
            C4564n1.m15789a(C4564n1.C4566a0.DEBUG, "sendReceiveReceipt disable");
            return;
        }
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.DEBUG;
        C4564n1.m15789a(a0Var, "sendReceiveReceipt appId: " + C + " playerId: " + I + " notificationId: " + str);
        this.f12301a.mo29738a(C, I, str, new C4482a(this, str));
    }
}
