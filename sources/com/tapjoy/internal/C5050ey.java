package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.ey */
public enum C5050ey implements C5024em {
    APP(0),
    CAMPAIGN(1),
    CUSTOM(2),
    USAGES(3);
    
    public static final C5006ej ADAPTER = null;

    /* renamed from: a */
    private final int f13730a;

    /* renamed from: com.tapjoy.internal.ey$a */
    static final class C5051a extends C5000ef {
        C5051a() {
            super(C5050ey.class);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ C5024em mo31093a(int i) {
            return C5050ey.m17145a(i);
        }
    }

    static {
        ADAPTER = new C5051a();
    }

    private C5050ey(int i) {
        this.f13730a = i;
    }

    /* renamed from: a */
    public static C5050ey m17145a(int i) {
        if (i == 0) {
            return APP;
        }
        if (i == 1) {
            return CAMPAIGN;
        }
        if (i == 2) {
            return CUSTOM;
        }
        if (i != 3) {
            return null;
        }
        return USAGES;
    }

    /* renamed from: a */
    public final int mo31123a() {
        return this.f13730a;
    }
}
