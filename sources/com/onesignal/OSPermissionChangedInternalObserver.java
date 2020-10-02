package com.onesignal;

class OSPermissionChangedInternalObserver {
    OSPermissionChangedInternalObserver() {
    }

    /* renamed from: a */
    static void m15353a(C4741z0 z0Var) {
        C4468a1 a1Var = new C4468a1();
        a1Var.f12281b = C4564n1.f12483O;
        a1Var.f12280a = (C4741z0) z0Var.clone();
        if (C4564n1.m15884z().mo30031c(a1Var)) {
            C4741z0 z0Var2 = (C4741z0) z0Var.clone();
            C4564n1.f12483O = z0Var2;
            z0Var2.mo30040b();
        }
    }

    /* renamed from: b */
    static void m15354b(C4741z0 z0Var) {
        if (!z0Var.mo30039a()) {
            C4521i.m15557a(0, C4564n1.f12495e);
        }
        C4742z1.m16471c(C4564n1.m15861j());
    }

    /* access modifiers changed from: package-private */
    public void changed(C4741z0 z0Var) {
        m15354b(z0Var);
        m15353a(z0Var);
    }
}
