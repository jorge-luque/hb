package p113i;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import p113i.p114e0.C3500c;
import p119j.C3577c;

/* renamed from: i.s */
/* compiled from: HttpUrl */
public final class C3539s {

    /* renamed from: j */
    private static final char[] f9857j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    final String f9858a;

    /* renamed from: b */
    private final String f9859b;

    /* renamed from: c */
    private final String f9860c;

    /* renamed from: d */
    final String f9861d;

    /* renamed from: e */
    final int f9862e;

    /* renamed from: f */
    private final List<String> f9863f;
    @Nullable

    /* renamed from: g */
    private final List<String> f9864g;
    @Nullable

    /* renamed from: h */
    private final String f9865h;

    /* renamed from: i */
    private final String f9866i;

    /* renamed from: i.s$a */
    /* compiled from: HttpUrl */
    public static final class C3540a {
        @Nullable

        /* renamed from: a */
        String f9867a;

        /* renamed from: b */
        String f9868b = "";

        /* renamed from: c */
        String f9869c = "";
        @Nullable

        /* renamed from: d */
        String f9870d;

        /* renamed from: e */
        int f9871e = -1;

        /* renamed from: f */
        final List<String> f9872f;
        @Nullable

        /* renamed from: g */
        List<String> f9873g;
        @Nullable

        /* renamed from: h */
        String f9874h;

        public C3540a() {
            ArrayList arrayList = new ArrayList();
            this.f9872f = arrayList;
            arrayList.add("");
        }

        /* renamed from: f */
        private boolean m11886f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        /* renamed from: g */
        private boolean m11887g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* renamed from: a */
        public C3540a mo19536a(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.f9871e = i;
            return this;
        }

        /* renamed from: b */
        public C3540a mo19542b(String str) {
            if (str != null) {
                String a = m11878a(str, 0, str.length());
                if (a != null) {
                    this.f9870d = a;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        /* renamed from: c */
        public C3540a mo19544c(String str) {
            if (str != null) {
                this.f9869c = C3539s.m11849a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        /* renamed from: d */
        public C3540a mo19545d(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.f9867a = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.f9867a = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        /* renamed from: e */
        public C3540a mo19546e(String str) {
            if (str != null) {
                this.f9868b = C3539s.m11849a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f9867a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.f9868b.isEmpty() || !this.f9869c.isEmpty()) {
                sb.append(this.f9868b);
                if (!this.f9869c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f9869c);
                }
                sb.append('@');
            }
            String str2 = this.f9870d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f9870d);
                    sb.append(']');
                } else {
                    sb.append(this.f9870d);
                }
            }
            if (!(this.f9871e == -1 && this.f9867a == null)) {
                int b = mo19541b();
                String str3 = this.f9867a;
                if (str3 == null || b != C3539s.m11857c(str3)) {
                    sb.append(':');
                    sb.append(b);
                }
            }
            C3539s.m11856b(sb, this.f9872f);
            if (this.f9873g != null) {
                sb.append('?');
                C3539s.m11854a(sb, this.f9873g);
            }
            if (this.f9874h != null) {
                sb.append('#');
                sb.append(this.f9874h);
            }
            return sb.toString();
        }

        /* renamed from: f */
        private static int m11885f(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* renamed from: e */
        private static int m11884e(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i;
                        }
                    }
                }
            }
            return -1;
        }

        /* renamed from: a */
        public C3540a mo19538a(@Nullable String str) {
            this.f9873g = str != null ? C3539s.m11860f(C3539s.m11849a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public C3540a mo19543c() {
            int size = this.f9872f.size();
            for (int i = 0; i < size; i++) {
                this.f9872f.set(i, C3539s.m11849a(this.f9872f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.f9873g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.f9873g.get(i2);
                    if (str != null) {
                        this.f9873g.set(i2, C3539s.m11849a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f9874h;
            if (str2 != null) {
                this.f9874h = C3539s.m11849a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo19541b() {
            int i = this.f9871e;
            return i != -1 ? i : C3539s.m11857c(this.f9867a);
        }

        /* renamed from: b */
        private static int m11880b(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(C3539s.m11847a(str, i, i2, "", false, false, false, true, (Charset) null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }

        /* renamed from: a */
        public C3540a mo19539a(String str, @Nullable String str2) {
            if (str != null) {
                if (this.f9873g == null) {
                    this.f9873g = new ArrayList();
                }
                this.f9873g.add(C3539s.m11849a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
                this.f9873g.add(str2 != null ? C3539s.m11849a(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC] */
        /* renamed from: d */
        private void m11883d(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L_0x0003
                return
            L_0x0003:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L_0x001e
                r1 = 92
                if (r0 != r1) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.util.List<java.lang.String> r0 = r10.f9872f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x0029
            L_0x001e:
                java.util.List<java.lang.String> r0 = r10.f9872f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f9872f
                r0.add(r2)
                goto L_0x0041
            L_0x0029:
                r6 = r12
                if (r6 >= r13) goto L_0x0044
                java.lang.String r12 = "/\\"
                int r12 = p113i.p114e0.C3500c.m11633a((java.lang.String) r11, (int) r6, (int) r13, (java.lang.String) r12)
                if (r12 >= r13) goto L_0x0036
                r0 = 1
                goto L_0x0037
            L_0x0036:
                r0 = 0
            L_0x0037:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.m11879a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L_0x0029
            L_0x0041:
                int r12 = r12 + 1
                goto L_0x0029
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p113i.C3539s.C3540a.m11883d(java.lang.String, int, int):void");
        }

        /* renamed from: d */
        private void m11882d() {
            List<String> list = this.f9872f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f9872f.isEmpty()) {
                this.f9872f.add("");
                return;
            }
            List<String> list2 = this.f9872f;
            list2.set(list2.size() - 1, "");
        }

        /* renamed from: a */
        public C3539s mo19540a() {
            if (this.f9867a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f9870d != null) {
                return new C3539s(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        /* renamed from: c */
        private static int m11881c(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) == ']');
                }
                i++;
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C3540a mo19537a(@Nullable C3539s sVar, String str) {
            int a;
            int i;
            C3539s sVar2 = sVar;
            String str2 = str;
            int b = C3500c.m11658b(str2, 0, str.length());
            int c = C3500c.m11664c(str2, b, str.length());
            int e = m11884e(str2, b, c);
            if (e != -1) {
                if (str.regionMatches(true, b, "https:", 0, 6)) {
                    this.f9867a = "https";
                    b += 6;
                } else if (str.regionMatches(true, b, "http:", 0, 5)) {
                    this.f9867a = "http";
                    b += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str2.substring(0, e) + "'");
                }
            } else if (sVar2 != null) {
                this.f9867a = sVar2.f9858a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int f = m11885f(str2, b, c);
            char c2 = '?';
            char c3 = '#';
            if (f >= 2 || sVar2 == null || !sVar2.f9858a.equals(this.f9867a)) {
                int i2 = b + f;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a = C3500c.m11633a(str2, i2, c, "@/\\?#");
                    char charAt = a != c ? str2.charAt(a) : 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        int i3 = a;
                        int c4 = m11881c(str2, i2, i3);
                        int i4 = c4 + 1;
                    } else {
                        if (charAt == '@') {
                            if (!z) {
                                int a2 = C3500c.m11632a(str2, i2, a, ':');
                                int i5 = a2;
                                String str3 = "%40";
                                i = a;
                                String a3 = C3539s.m11847a(str, i2, a2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                if (z2) {
                                    a3 = this.f9868b + str3 + a3;
                                }
                                this.f9868b = a3;
                                if (i5 != i) {
                                    this.f9869c = C3539s.m11847a(str, i5 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                i = a;
                                this.f9869c += "%40" + C3539s.m11847a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                            }
                            i2 = i + 1;
                        }
                        c2 = '?';
                        c3 = '#';
                    }
                }
                int i32 = a;
                int c42 = m11881c(str2, i2, i32);
                int i42 = c42 + 1;
                if (i42 < i32) {
                    this.f9870d = m11878a(str2, i2, c42);
                    int b2 = m11880b(str2, i42, i32);
                    this.f9871e = b2;
                    if (b2 == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str2.substring(i42, i32) + '\"');
                    }
                } else {
                    this.f9870d = m11878a(str2, i2, c42);
                    this.f9871e = C3539s.m11857c(this.f9867a);
                }
                if (this.f9870d != null) {
                    b = i32;
                } else {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str2.substring(i2, c42) + '\"');
                }
            } else {
                this.f9868b = sVar.mo19524f();
                this.f9869c = sVar.mo19519b();
                this.f9870d = sVar2.f9861d;
                this.f9871e = sVar2.f9862e;
                this.f9872f.clear();
                this.f9872f.addAll(sVar.mo19521d());
                if (b == c || str2.charAt(b) == '#') {
                    mo19538a(sVar.mo19522e());
                }
            }
            int a4 = C3500c.m11633a(str2, b, c, "?#");
            m11883d(str2, b, a4);
            if (a4 < c && str2.charAt(a4) == '?') {
                int a5 = C3500c.m11632a(str2, a4, c, '#');
                this.f9873g = C3539s.m11860f(C3539s.m11847a(str, a4 + 1, a5, " \"'<>#", true, false, true, true, (Charset) null));
                a4 = a5;
            }
            if (a4 < c && str2.charAt(a4) == '#') {
                this.f9874h = C3539s.m11847a(str, 1 + a4, c, "", true, false, false, false, (Charset) null);
            }
            return this;
        }

        /* renamed from: a */
        private void m11879a(String str, int i, int i2, boolean z, boolean z2) {
            String a = C3539s.m11847a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, (Charset) null);
            if (!m11886f(a)) {
                if (m11887g(a)) {
                    m11882d();
                    return;
                }
                List<String> list = this.f9872f;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.f9872f;
                    list2.set(list2.size() - 1, a);
                } else {
                    this.f9872f.add(a);
                }
                if (z) {
                    this.f9872f.add("");
                }
            }
        }

        /* renamed from: a */
        private static String m11878a(String str, int i, int i2) {
            return C3500c.m11638a(C3539s.m11848a(str, i, i2, false));
        }
    }

    C3539s(C3540a aVar) {
        this.f9858a = aVar.f9867a;
        this.f9859b = m11850a(aVar.f9868b, false);
        this.f9860c = m11850a(aVar.f9869c, false);
        this.f9861d = aVar.f9870d;
        this.f9862e = aVar.mo19541b();
        this.f9863f = m11851a(aVar.f9872f, false);
        List<String> list = aVar.f9873g;
        String str = null;
        this.f9864g = list != null ? m11851a(list, true) : null;
        String str2 = aVar.f9874h;
        this.f9865h = str2 != null ? m11850a(str2, false) : str;
        this.f9866i = aVar.toString();
    }

    /* renamed from: a */
    static void m11854a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    /* renamed from: c */
    public static int m11857c(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* renamed from: b */
    public String mo19519b() {
        if (this.f9860c.isEmpty()) {
            return "";
        }
        int indexOf = this.f9866i.indexOf(64);
        return this.f9866i.substring(this.f9866i.indexOf(58, this.f9858a.length() + 3) + 1, indexOf);
    }

    /* renamed from: d */
    public List<String> mo19521d() {
        int indexOf = this.f9866i.indexOf(47, this.f9858a.length() + 3);
        String str = this.f9866i;
        int a = C3500c.m11633a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a) {
            int i = indexOf + 1;
            int a2 = C3500c.m11632a(this.f9866i, i, a, '/');
            arrayList.add(this.f9866i.substring(i, a2));
            indexOf = a2;
        }
        return arrayList;
    }

    @Nullable
    /* renamed from: e */
    public String mo19522e() {
        if (this.f9864g == null) {
            return null;
        }
        int indexOf = this.f9866i.indexOf(63) + 1;
        String str = this.f9866i;
        return this.f9866i.substring(indexOf, C3500c.m11632a(str, indexOf, str.length(), '#'));
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof C3539s) && ((C3539s) obj).f9866i.equals(this.f9866i);
    }

    /* renamed from: f */
    public String mo19524f() {
        if (this.f9859b.isEmpty()) {
            return "";
        }
        int length = this.f9858a.length() + 3;
        String str = this.f9866i;
        return this.f9866i.substring(length, C3500c.m11633a(str, length, str.length(), ":@"));
    }

    /* renamed from: g */
    public String mo19525g() {
        return this.f9861d;
    }

    /* renamed from: h */
    public boolean mo19526h() {
        return this.f9858a.equals("https");
    }

    public int hashCode() {
        return this.f9866i.hashCode();
    }

    /* renamed from: i */
    public C3540a mo19528i() {
        C3540a aVar = new C3540a();
        aVar.f9867a = this.f9858a;
        aVar.f9868b = mo19524f();
        aVar.f9869c = mo19519b();
        aVar.f9870d = this.f9861d;
        aVar.f9871e = this.f9862e != m11857c(this.f9858a) ? this.f9862e : -1;
        aVar.f9872f.clear();
        aVar.f9872f.addAll(mo19521d());
        aVar.mo19538a(mo19522e());
        aVar.f9874h = mo19517a();
        return aVar;
    }

    /* renamed from: j */
    public List<String> mo19529j() {
        return this.f9863f;
    }

    /* renamed from: k */
    public int mo19530k() {
        return this.f9862e;
    }

    @Nullable
    /* renamed from: l */
    public String mo19531l() {
        if (this.f9864g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        m11854a(sb, this.f9864g);
        return sb.toString();
    }

    /* renamed from: m */
    public String mo19532m() {
        C3540a a = mo19516a("/...");
        a.mo19546e("");
        a.mo19544c("");
        return a.mo19540a().toString();
    }

    /* renamed from: n */
    public String mo19533n() {
        return this.f9858a;
    }

    /* renamed from: o */
    public URI mo19534o() {
        C3540a i = mo19528i();
        i.mo19543c();
        String aVar = i.toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public String toString() {
        return this.f9866i;
    }

    /* renamed from: c */
    public String mo19520c() {
        int indexOf = this.f9866i.indexOf(47, this.f9858a.length() + 3);
        String str = this.f9866i;
        return this.f9866i.substring(indexOf, C3500c.m11633a(str, indexOf, str.length(), "?#"));
    }

    /* renamed from: b */
    static void m11856b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    @Nullable
    /* renamed from: e */
    public static C3539s m11859e(String str) {
        try {
            return m11858d(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: f */
    static List<String> m11860f(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add((Object) null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    /* renamed from: d */
    public static C3539s m11858d(String str) {
        C3540a aVar = new C3540a();
        aVar.mo19537a((C3539s) null, str);
        return aVar.mo19540a();
    }

    @Nullable
    /* renamed from: a */
    public String mo19517a() {
        if (this.f9865h == null) {
            return null;
        }
        return this.f9866i.substring(this.f9866i.indexOf(35) + 1);
    }

    @Nullable
    /* renamed from: b */
    public C3539s mo19518b(String str) {
        C3540a a = mo19516a(str);
        if (a != null) {
            return a.mo19540a();
        }
        return null;
    }

    @Nullable
    /* renamed from: a */
    public C3540a mo19516a(String str) {
        try {
            C3540a aVar = new C3540a();
            aVar.mo19537a(this, str);
            return aVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: a */
    static String m11850a(String str, boolean z) {
        return m11848a(str, 0, str.length(), z);
    }

    /* renamed from: a */
    private List<String> m11851a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? m11850a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    static String m11848a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                C3577c cVar = new C3577c();
                cVar.mo19695a(str, i, i3);
                m11853a(cVar, str, i3, i2, z);
                return cVar.mo19732v();
            }
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m11853a(C3577c cVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int a = C3500c.m11631a(str.charAt(i + 1));
                int a2 = C3500c.m11631a(str.charAt(i3));
                if (!(a == -1 || a2 == -1)) {
                    cVar.writeByte((a << 4) + a2);
                    i = i3;
                    i += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z) {
                cVar.writeByte(32);
                i += Character.charCount(codePointAt);
            }
            cVar.mo19704c(codePointAt);
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static boolean m11855a(String str, int i, int i2) {
        int i3 = i + 2;
        if (i3 >= i2 || str.charAt(i) != '%' || C3500c.m11631a(str.charAt(i + 1)) == -1 || C3500c.m11631a(str.charAt(i3)) == -1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    static String m11847a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        String str3 = str;
        int i3 = i2;
        int i4 = i;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt < 32 || codePointAt == 127 || (codePointAt >= 128 && z4)) {
                String str4 = str2;
            } else {
                String str5 = str2;
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || m11855a(str, i4, i2)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            C3577c cVar = new C3577c();
            int i5 = i;
            cVar.mo19695a(str, i, i4);
            m11852a(cVar, str, i4, i2, str2, z, z2, z3, z4, charset);
            return cVar.mo19732v();
        }
        int i6 = i;
        return str.substring(i, i2);
    }

    /* renamed from: a */
    static void m11852a(C3577c cVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        C3577c cVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.mo19708e(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !m11855a(str, i, i2)))))) {
                    if (cVar2 == null) {
                        cVar2 = new C3577c();
                    }
                    if (charset == null || charset.equals(C3500c.f9709i)) {
                        cVar2.mo19704c(codePointAt);
                    } else {
                        cVar2.mo19696a(str, i, Character.charCount(codePointAt) + i, charset);
                    }
                    while (!cVar2.mo19681H()) {
                        byte readByte = cVar2.readByte() & 255;
                        cVar.writeByte(37);
                        cVar.writeByte((int) f9857j[(readByte >> 4) & 15]);
                        cVar.writeByte((int) f9857j[readByte & 15]);
                    }
                } else {
                    cVar.mo19704c(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    static String m11849a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m11847a(str, 0, str.length(), str2, z, z2, z3, z4, (Charset) null);
    }
}
