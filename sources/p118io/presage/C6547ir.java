package p118io.presage;

/* renamed from: io.presage.ir */
class C6547ir extends C6546iq {
    /* renamed from: a */
    public static final boolean m21465a(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        return Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }
}
