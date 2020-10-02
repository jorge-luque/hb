package p163cz.msebera.android.httpclient.p187k0;

/* renamed from: cz.msebera.android.httpclient.k0.i */
/* compiled from: TextUtils */
public final class C5894i {
    /* renamed from: a */
    public static boolean m18942a(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        for (int i = 0; i < charSequence.length(); i++) {
            if (Character.isWhitespace(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m18943b(CharSequence charSequence) {
        if (charSequence == null) {
            return true;
        }
        for (int i = 0; i < charSequence.length(); i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m18944c(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
