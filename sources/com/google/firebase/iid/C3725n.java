package com.google.firebase.iid;

import android.os.Bundle;

/* renamed from: com.google.firebase.iid.n */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final class C3725n extends C3729p<Void> {
    C3725n(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo27354a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            mo27359a(null);
        } else {
            mo27358a(new zzam(4, "Invalid response to one way request"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo27355a() {
        return true;
    }
}
