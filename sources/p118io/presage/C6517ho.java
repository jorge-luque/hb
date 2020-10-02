package p118io.presage;

/* renamed from: io.presage.ho */
public final class C6517ho {
    /* renamed from: a */
    public static C6535if m21421a(Class cls) {
        return new C6509hg(cls);
    }

    /* renamed from: a */
    public static C6537ih m21422a(C6513hk hkVar) {
        return hkVar;
    }

    /* renamed from: a */
    public static String m21424a(C6515hm hmVar) {
        return m21423a((C6512hj) hmVar);
    }

    /* renamed from: a */
    private static String m21423a(C6512hj hjVar) {
        String obj = hjVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }
}
