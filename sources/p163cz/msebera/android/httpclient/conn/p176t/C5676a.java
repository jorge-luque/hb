package p163cz.msebera.android.httpclient.conn.p176t;

import java.util.regex.Pattern;

/* renamed from: cz.msebera.android.httpclient.conn.t.a */
/* compiled from: InetAddressUtils */
public class C5676a {

    /* renamed from: a */
    private static final Pattern f14685a = Pattern.compile("^(([1-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){1}(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){2}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");

    /* renamed from: b */
    private static final Pattern f14686b = Pattern.compile("^[0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){7}$");

    /* renamed from: c */
    private static final Pattern f14687c = Pattern.compile("^(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)::(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)$");

    static {
        Pattern.compile("^::[fF]{4}:(([1-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){1}(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){2}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
    }

    /* renamed from: a */
    public static boolean m18079a(String str) {
        return f14685a.matcher(str).matches();
    }

    /* renamed from: b */
    public static boolean m18080b(String str) {
        return m18082d(str) || m18081c(str);
    }

    /* renamed from: c */
    public static boolean m18081c(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == ':') {
                i++;
            }
        }
        if (i > 7 || !f14687c.matcher(str).matches()) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m18082d(String str) {
        return f14686b.matcher(str).matches();
    }
}
