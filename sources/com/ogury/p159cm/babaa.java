package com.ogury.p159cm;

import com.loopj.android.http.C4250c;
import java.nio.charset.Charset;

/* renamed from: com.ogury.cm.babaa */
public final class babaa {

    /* renamed from: a */
    public static final Charset f12165a;

    /* renamed from: b */
    public static final Charset f12166b;

    /* renamed from: c */
    public static final Charset f12167c;

    /* renamed from: d */
    public static final Charset f12168d;

    /* renamed from: e */
    public static final Charset f12169e;

    /* renamed from: f */
    public static final Charset f12170f;

    /* renamed from: g */
    public static final babaa f12171g = new babaa();

    static {
        Charset forName = Charset.forName(C4250c.DEFAULT_CHARSET);
        accbb.m15215a((Object) forName, "Charset.forName(\"UTF-8\")");
        f12165a = forName;
        Charset forName2 = Charset.forName("UTF-16");
        accbb.m15215a((Object) forName2, "Charset.forName(\"UTF-16\")");
        f12166b = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        accbb.m15215a((Object) forName3, "Charset.forName(\"UTF-16BE\")");
        f12167c = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        accbb.m15215a((Object) forName4, "Charset.forName(\"UTF-16LE\")");
        f12168d = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        accbb.m15215a((Object) forName5, "Charset.forName(\"US-ASCII\")");
        f12169e = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        accbb.m15215a((Object) forName6, "Charset.forName(\"ISO-8859-1\")");
        f12170f = forName6;
    }

    private babaa() {
    }
}
