package com.ogury.p159cm;

/* renamed from: com.ogury.cm.acccb */
public final class acccb {

    /* renamed from: a */
    private static final baaca f12149a;

    /* renamed from: b */
    private static final aabcb[] f12150b = new aabcb[0];

    static {
        baaca baaca = null;
        try {
            baaca = (baaca) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (baaca == null) {
            baaca = new baaca();
        }
        f12149a = baaca;
    }

    /* renamed from: a */
    public static String m15229a(accbc accbc) {
        String obj = accbc.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }
}
