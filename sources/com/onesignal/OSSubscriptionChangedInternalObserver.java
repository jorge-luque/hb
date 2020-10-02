package com.onesignal;

class OSSubscriptionChangedInternalObserver {
    OSSubscriptionChangedInternalObserver() {
    }

    /* renamed from: a */
    static void m15355a(OSSubscriptionState oSSubscriptionState) {
        C4512g1 g1Var = new C4512g1();
        g1Var.f12346b = C4564n1.f12486R;
        g1Var.f12345a = (OSSubscriptionState) oSSubscriptionState.clone();
        if (C4564n1.m15757G().mo30031c(g1Var)) {
            OSSubscriptionState oSSubscriptionState2 = (OSSubscriptionState) oSSubscriptionState.clone();
            C4564n1.f12486R = oSSubscriptionState2;
            oSSubscriptionState2.mo29676d();
        }
    }

    public void changed(OSSubscriptionState oSSubscriptionState) {
        m15355a(oSSubscriptionState);
    }
}
