package com.tapjoy.internal;

import android.view.View;

/* renamed from: com.tapjoy.internal.cs */
public abstract class C4948cs {
    /* renamed from: a */
    public static C4948cs m16786a(C4949ct ctVar, C4950cu cuVar) {
        if (C4940ck.m16780b()) {
            C4975do.m16853a((Object) ctVar, "AdSessionConfiguration is null");
            C4975do.m16853a((Object) cuVar, "AdSessionContext is null");
            return new C4955cz(ctVar, cuVar);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }

    /* renamed from: a */
    public abstract void mo31035a();

    /* renamed from: a */
    public abstract void mo31036a(View view);

    /* renamed from: b */
    public abstract void mo31037b();
}
