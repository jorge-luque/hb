package com.ogury.p159cm;

/* renamed from: com.ogury.cm.aaabb */
public final class aaabb {

    /* renamed from: a */
    public static final aaabb f11975a = new aaabb();

    /* renamed from: b */
    private static aaaba f11976b;

    private aaabb() {
    }

    /* renamed from: a */
    public static aaaba m14949a(int i) {
        if (f11976b != null) {
            return f11976b;
        }
        if (i == 1) {
            return new aaabc();
        }
        if (i == 2) {
            return new aaacb();
        }
        throw new IllegalStateException("Bad TCF version used! Please use one of the declared ones in OguryChoiceManager class.");
    }
}
