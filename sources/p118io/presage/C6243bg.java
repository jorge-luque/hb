package p118io.presage;

import java.util.Locale;

/* renamed from: io.presage.bg */
public final class C6243bg {
    /* renamed from: a */
    public static final boolean m20892a(String str) {
        Locale locale = Locale.US;
        C6514hl.m21414a((Object) locale, "Locale.US");
        String lowerCase = str.toLowerCase(locale);
        C6514hl.m21414a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return C6561je.m21509a(lowerCase, "http://ogymraid") || C6561je.m21509a(lowerCase, "https://ogymraid");
    }
}
