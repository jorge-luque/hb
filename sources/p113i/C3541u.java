package p113i;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* renamed from: i.u */
/* compiled from: MediaType */
public final class C3541u {

    /* renamed from: c */
    private static final Pattern f9875c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: d */
    private static final Pattern f9876d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a */
    private final String f9877a;
    @Nullable

    /* renamed from: b */
    private final String f9878b;

    private C3541u(String str, String str2, String str3, @Nullable String str4) {
        this.f9877a = str;
        this.f9878b = str4;
    }

    /* renamed from: a */
    public static C3541u m11899a(String str) {
        Matcher matcher = f9875c.matcher(str);
        if (matcher.lookingAt()) {
            String lowerCase = matcher.group(1).toLowerCase(Locale.US);
            String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
            String str2 = null;
            Matcher matcher2 = f9876d.matcher(str);
            int end = matcher.end();
            while (end < str.length()) {
                matcher2.region(end, str.length());
                if (matcher2.lookingAt()) {
                    String group = matcher2.group(1);
                    if (group != null && group.equalsIgnoreCase("charset")) {
                        String group2 = matcher2.group(2);
                        if (group2 == null) {
                            group2 = matcher2.group(3);
                        } else if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                            group2 = group2.substring(1, group2.length() - 1);
                        }
                        if (str2 == null || group2.equalsIgnoreCase(str2)) {
                            str2 = group2;
                        } else {
                            throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + group2 + "\" for: \"" + str + '\"');
                        }
                    }
                    end = matcher2.end();
                } else {
                    throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(end) + "\" for: \"" + str + '\"');
                }
            }
            return new C3541u(str, lowerCase, lowerCase2, str2);
        }
        throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
    }

    @Nullable
    /* renamed from: b */
    public static C3541u m11900b(String str) {
        try {
            return m11899a(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof C3541u) && ((C3541u) obj).f9877a.equals(this.f9877a);
    }

    public int hashCode() {
        return this.f9877a.hashCode();
    }

    public String toString() {
        return this.f9877a;
    }

    @Nullable
    /* renamed from: a */
    public Charset mo19548a() {
        return mo19549a((Charset) null);
    }

    @Nullable
    /* renamed from: a */
    public Charset mo19549a(@Nullable Charset charset) {
        try {
            return this.f9878b != null ? Charset.forName(this.f9878b) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
