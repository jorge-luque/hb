package p118io.presage;

/* renamed from: io.presage.je */
class C6561je extends C6560jd {
    /* renamed from: a */
    public static final String m21508a(String str, String str2, String str3) {
        int a = C6562jf.m21517a((CharSequence) str, str2, 0, false);
        if (a < 0) {
            return str;
        }
        return C6562jf.m21520a((CharSequence) str, a, str2.length() + a, (CharSequence) str3).toString();
    }

    /* renamed from: a */
    public static final boolean m21509a(String str, String str2) {
        return str.startsWith(str2);
    }

    /* renamed from: a */
    public static final boolean m21510a(String str, String str2, int i, int i2, boolean z) {
        if (!z) {
            return str.regionMatches(0, str2, i, i2);
        }
        return str.regionMatches(z, 0, str2, i, i2);
    }
}
