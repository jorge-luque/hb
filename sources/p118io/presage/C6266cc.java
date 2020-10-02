package p118io.presage;

import java.util.regex.Pattern;

/* renamed from: io.presage.cc */
public class C6266cc extends C6397dc {

    /* renamed from: a */
    private final String f16886a;

    /* renamed from: b */
    private final Pattern f16887b;

    public C6266cc(Pattern pattern) {
        this.f16887b = pattern;
        this.f16886a = pattern.pattern();
    }

    /* renamed from: a */
    public final boolean mo34857a(String str) {
        String str2 = this.f16886a;
        C6514hl.m21414a((Object) str2, "stringPattern");
        return (str2.length() > 0) && !this.f16887b.matcher(str).find();
    }
}
