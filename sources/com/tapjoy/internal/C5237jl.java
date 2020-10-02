package com.tapjoy.internal;

import android.app.RemoteInput;
import android.os.Bundle;
import java.util.Set;

/* renamed from: com.tapjoy.internal.jl */
public final class C5237jl {

    /* renamed from: a */
    final String f14411a;

    /* renamed from: b */
    final CharSequence f14412b;

    /* renamed from: c */
    final CharSequence[] f14413c;

    /* renamed from: d */
    final boolean f14414d;

    /* renamed from: e */
    final Bundle f14415e;

    /* renamed from: f */
    final Set f14416f;

    /* renamed from: a */
    static RemoteInput[] m17606a(C5237jl[] jlVarArr) {
        if (jlVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[jlVarArr.length];
        for (int i = 0; i < jlVarArr.length; i++) {
            C5237jl jlVar = jlVarArr[i];
            remoteInputArr[i] = new RemoteInput.Builder(jlVar.f14411a).setLabel(jlVar.f14412b).setChoices(jlVar.f14413c).setAllowFreeFormInput(jlVar.f14414d).addExtras(jlVar.f14415e).build();
        }
        return remoteInputArr;
    }
}
