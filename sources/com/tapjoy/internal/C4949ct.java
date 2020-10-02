package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.ct */
public final class C4949ct {

    /* renamed from: a */
    public final C4952cw f13440a;

    /* renamed from: b */
    public final C4952cw f13441b;

    /* renamed from: c */
    public final boolean f13442c;

    private C4949ct(C4952cw cwVar, C4952cw cwVar2) {
        this.f13440a = cwVar;
        if (cwVar2 == null) {
            this.f13441b = C4952cw.NONE;
        } else {
            this.f13441b = cwVar2;
        }
        this.f13442c = false;
    }

    /* renamed from: a */
    public static C4949ct m16790a(C4952cw cwVar, C4952cw cwVar2) {
        C4975do.m16853a((Object) cwVar, "Impression owner is null");
        if (!cwVar.equals(C4952cw.NONE)) {
            return new C4949ct(cwVar, cwVar2);
        }
        throw new IllegalArgumentException("Impression owner is none");
    }
}
