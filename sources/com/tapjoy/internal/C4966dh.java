package com.tapjoy.internal;

import com.tapjoy.internal.C4960de;
import java.util.Collections;

/* renamed from: com.tapjoy.internal.dh */
public final class C4966dh implements C4944co, C4960de.C4962a {

    /* renamed from: c */
    private static C4966dh f13499c;

    /* renamed from: a */
    public float f13500a = 0.0f;

    /* renamed from: b */
    public C4945cp f13501b;

    /* renamed from: d */
    private final C4946cq f13502d;

    /* renamed from: e */
    private final C4943cn f13503e;

    /* renamed from: f */
    private C4959dd f13504f;

    private C4966dh(C4946cq cqVar, C4943cn cnVar) {
        this.f13502d = cqVar;
        this.f13503e = cnVar;
    }

    /* renamed from: a */
    public static C4966dh m16831a() {
        if (f13499c == null) {
            f13499c = new C4966dh(new C4946cq(), new C4943cn());
        }
        return f13499c;
    }

    /* renamed from: a */
    public final void mo31030a(float f) {
        this.f13500a = f;
        if (this.f13504f == null) {
            this.f13504f = C4959dd.m16817a();
        }
        for (C4955cz czVar : Collections.unmodifiableCollection(this.f13504f.f13485b)) {
            czVar.f13465c.mo31069a(f);
        }
    }

    /* renamed from: a */
    public final void mo31060a(boolean z) {
        C4984dv.m16870a();
        if (z) {
            C4984dv.m16874b();
        } else {
            C4984dv.m16876c();
        }
    }
}
