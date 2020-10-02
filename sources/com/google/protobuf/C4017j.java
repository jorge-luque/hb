package com.google.protobuf;

/* renamed from: com.google.protobuf.j */
/* compiled from: ExtensionRegistryFactory */
final class C4017j {

    /* renamed from: a */
    static final Class<?> f10819a = m13413b();

    /* renamed from: a */
    public static C4018k m13411a() {
        if (f10819a != null) {
            try {
                return m13412a("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return C4018k.f10820a;
    }

    /* renamed from: b */
    static Class<?> m13413b() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static final C4018k m13412a(String str) throws Exception {
        return (C4018k) f10819a.getMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
    }
}
