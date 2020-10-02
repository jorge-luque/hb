package com.tapjoy.internal;

import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.aq */
public abstract class C3122aq implements C3121an {
    /* access modifiers changed from: protected */
    @Nullable
    /* renamed from: a */
    public abstract C4891ao mo18474a(Object obj, boolean z);

    /* renamed from: a */
    public final Object mo18472a(Object obj) {
        C4891ao a = mo18474a(obj, false);
        if (a != null) {
            return a.mo30925a();
        }
        return null;
    }

    /* renamed from: a */
    public void mo18473a(Object obj, Object obj2) {
        mo18474a(obj, true).mo30926a(obj2);
    }
}
