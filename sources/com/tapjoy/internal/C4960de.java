package com.tapjoy.internal;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import java.util.Collections;

/* renamed from: com.tapjoy.internal.de */
public final class C4960de {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f */
    private static C4960de f13486f = new C4960de();

    /* renamed from: a */
    public Context f13487a;

    /* renamed from: b */
    public BroadcastReceiver f13488b;

    /* renamed from: c */
    public boolean f13489c;

    /* renamed from: d */
    public boolean f13490d;

    /* renamed from: e */
    public C4962a f13491e;

    /* renamed from: com.tapjoy.internal.de$a */
    public interface C4962a {
        /* renamed from: a */
        void mo31060a(boolean z);
    }

    private C4960de() {
    }

    /* renamed from: a */
    public static C4960de m16819a() {
        return f13486f;
    }

    /* renamed from: a */
    static /* synthetic */ void m16820a(C4960de deVar, boolean z) {
        if (deVar.f13490d != z) {
            deVar.f13490d = z;
            if (deVar.f13489c) {
                deVar.mo31058c();
                C4962a aVar = deVar.f13491e;
                if (aVar != null) {
                    aVar.mo31060a(deVar.mo31057b());
                }
            }
        }
    }

    /* renamed from: b */
    public final boolean mo31057b() {
        return !this.f13490d;
    }

    /* renamed from: c */
    public final void mo31058c() {
        boolean z = !this.f13490d;
        for (C4955cz czVar : Collections.unmodifiableCollection(C4959dd.m16817a().f13484a)) {
            C4979ds dsVar = czVar.f13465c;
            if (dsVar.f13514a.get() != null) {
                C4964dg.m16825a().mo31062a(dsVar.mo31075c(), "setState", z ? "foregrounded" : "backgrounded");
            }
        }
    }
}
