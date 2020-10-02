package com.ogury.crashreport;

import com.loopj.android.http.C4250c;
import java.nio.charset.Charset;

/* renamed from: com.ogury.crashreport.dd */
/* compiled from: Charsets.kt */
public final class C4452dd {

    /* renamed from: a */
    public static final Charset f12200a;

    static {
        new C4452dd();
        Charset forName = Charset.forName(C4250c.DEFAULT_CHARSET);
        tx7920.m15330a((Object) forName, "Charset.forName(\"UTF-8\")");
        f12200a = forName;
        tx7920.m15330a((Object) Charset.forName("UTF-16"), "Charset.forName(\"UTF-16\")");
        tx7920.m15330a((Object) Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        tx7920.m15330a((Object) Charset.forName("UTF-16LE"), "Charset.forName(\"UTF-16LE\")");
        tx7920.m15330a((Object) Charset.forName("US-ASCII"), "Charset.forName(\"US-ASCII\")");
        tx7920.m15330a((Object) Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }

    private C4452dd() {
    }
}
