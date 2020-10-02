package p163cz.msebera.android.httpclient.conn.ssl;

import javax.security.auth.x500.X500Principal;

/* renamed from: cz.msebera.android.httpclient.conn.ssl.e */
/* compiled from: DistinguishedNameParser */
public final class C5668e {

    /* renamed from: a */
    private final String f14665a;

    /* renamed from: b */
    private final int f14666b;

    /* renamed from: c */
    private int f14667c;

    /* renamed from: d */
    private int f14668d;

    /* renamed from: e */
    private int f14669e;

    /* renamed from: f */
    private int f14670f;

    /* renamed from: g */
    private char[] f14671g;

    public C5668e(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f14665a = name;
        this.f14666b = name.length();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
        r1 = r8.f14671g;
        r2 = r8.f14668d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a7, code lost:
        return new java.lang.String(r1, r2, r8.f14670f - r2);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m18051a() {
        /*
            r8 = this;
            int r0 = r8.f14667c
            r8.f14668d = r0
            r8.f14669e = r0
        L_0x0006:
            int r0 = r8.f14667c
            int r1 = r8.f14666b
            if (r0 < r1) goto L_0x0019
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f14671g
            int r2 = r8.f14668d
            int r3 = r8.f14669e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0019:
            char[] r1 = r8.f14671g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L_0x0060
            if (r2 == r5) goto L_0x0053
            r5 = 92
            if (r2 == r5) goto L_0x0040
            if (r2 == r4) goto L_0x0053
            if (r2 == r3) goto L_0x0053
            int r2 = r8.f14669e
            int r3 = r2 + 1
            r8.f14669e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f14667c = r0
            goto L_0x0006
        L_0x0040:
            int r0 = r8.f14669e
            int r2 = r0 + 1
            r8.f14669e = r2
            char r2 = r8.m18052b()
            r1[r0] = r2
            int r0 = r8.f14667c
            int r0 = r0 + 1
            r8.f14667c = r0
            goto L_0x0006
        L_0x0053:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f14671g
            int r2 = r8.f14668d
            int r3 = r8.f14669e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0060:
            int r2 = r8.f14669e
            r8.f14670f = r2
            int r0 = r0 + 1
            r8.f14667c = r0
            int r0 = r2 + 1
            r8.f14669e = r0
            r1[r2] = r6
        L_0x006e:
            int r0 = r8.f14667c
            int r1 = r8.f14666b
            if (r0 >= r1) goto L_0x0087
            char[] r1 = r8.f14671g
            char r2 = r1[r0]
            if (r2 != r6) goto L_0x0087
            int r2 = r8.f14669e
            int r7 = r2 + 1
            r8.f14669e = r7
            r1[r2] = r6
            int r0 = r0 + 1
            r8.f14667c = r0
            goto L_0x006e
        L_0x0087:
            int r0 = r8.f14667c
            int r1 = r8.f14666b
            if (r0 == r1) goto L_0x009b
            char[] r1 = r8.f14671g
            char r2 = r1[r0]
            if (r2 == r3) goto L_0x009b
            char r2 = r1[r0]
            if (r2 == r4) goto L_0x009b
            char r0 = r1[r0]
            if (r0 != r5) goto L_0x0006
        L_0x009b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f14671g
            int r2 = r8.f14668d
            int r3 = r8.f14670f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.conn.ssl.C5668e.m18051a():java.lang.String");
    }

    /* renamed from: b */
    private char m18052b() {
        int i = this.f14667c + 1;
        this.f14667c = i;
        if (i != this.f14666b) {
            char c = this.f14671g[i];
            if (!(c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#')) {
                switch (c) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return m18053c();
                        }
                }
            }
            return this.f14671g[this.f14667c];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f14665a);
    }

    /* renamed from: c */
    private char m18053c() {
        int i;
        int i2;
        int a = m18050a(this.f14667c);
        this.f14667c++;
        if (a < 128) {
            return (char) a;
        }
        if (a < 192 || a > 247) {
            return '?';
        }
        if (a <= 223) {
            i2 = a & 31;
            i = 1;
        } else if (a <= 239) {
            i = 2;
            i2 = a & 15;
        } else {
            i = 3;
            i2 = a & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = this.f14667c + 1;
            this.f14667c = i4;
            if (i4 == this.f14666b || this.f14671g[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.f14667c = i5;
            int a2 = m18050a(i5);
            this.f14667c++;
            if ((a2 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a2 & 63);
        }
        return (char) i2;
    }

    /* renamed from: d */
    private String m18054d() {
        int i = this.f14667c;
        if (i + 4 < this.f14666b) {
            this.f14668d = i;
            this.f14667c = i + 1;
            while (true) {
                int i2 = this.f14667c;
                if (i2 == this.f14666b) {
                    break;
                }
                char[] cArr = this.f14671g;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                } else if (cArr[i2] == ' ') {
                    this.f14669e = i2;
                    this.f14667c = i2 + 1;
                    while (true) {
                        int i3 = this.f14667c;
                        if (i3 >= this.f14666b || this.f14671g[i3] != ' ') {
                            break;
                        }
                        this.f14667c = i3 + 1;
                    }
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + ' ');
                    }
                    this.f14667c++;
                }
            }
            this.f14669e = this.f14667c;
            int i4 = this.f14669e;
            int i5 = this.f14668d;
            int i6 = i4 - i5;
            if (i6 < 5 || (i6 & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f14665a);
            }
            int i7 = i6 / 2;
            byte[] bArr = new byte[i7];
            int i8 = i5 + 1;
            for (int i9 = 0; i9 < i7; i9++) {
                bArr[i9] = (byte) m18050a(i8);
                i8 += 2;
            }
            return new String(this.f14671g, this.f14668d, i6);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f14665a);
    }

    /* renamed from: e */
    private String m18055e() {
        while (true) {
            int i = this.f14667c;
            if (i >= this.f14666b || this.f14671g[i] != ' ') {
                int i2 = this.f14667c;
            } else {
                this.f14667c = i + 1;
            }
        }
        int i22 = this.f14667c;
        if (i22 == this.f14666b) {
            return null;
        }
        this.f14668d = i22;
        this.f14667c = i22 + 1;
        while (true) {
            int i3 = this.f14667c;
            if (i3 >= this.f14666b) {
                break;
            }
            char[] cArr = this.f14671g;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.f14667c = i3 + 1;
        }
        int i4 = this.f14667c;
        if (i4 < this.f14666b) {
            this.f14669e = i4;
            if (this.f14671g[i4] == ' ') {
                while (true) {
                    int i5 = this.f14667c;
                    if (i5 >= this.f14666b) {
                        break;
                    }
                    char[] cArr2 = this.f14671g;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.f14667c = i5 + 1;
                }
                char[] cArr3 = this.f14671g;
                int i6 = this.f14667c;
                if (cArr3[i6] != '=' || i6 == this.f14666b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f14665a);
                }
            }
            this.f14667c++;
            while (true) {
                int i7 = this.f14667c;
                if (i7 >= this.f14666b || this.f14671g[i7] != ' ') {
                    int i8 = this.f14669e;
                    int i9 = this.f14668d;
                } else {
                    this.f14667c = i7 + 1;
                }
            }
            int i82 = this.f14669e;
            int i92 = this.f14668d;
            if (i82 - i92 > 4) {
                char[] cArr4 = this.f14671g;
                if (cArr4[i92 + 3] == '.' && (cArr4[i92] == 'O' || cArr4[i92] == 'o')) {
                    char[] cArr5 = this.f14671g;
                    int i10 = this.f14668d;
                    if (cArr5[i10 + 1] == 'I' || cArr5[i10 + 1] == 'i') {
                        char[] cArr6 = this.f14671g;
                        int i11 = this.f14668d;
                        if (cArr6[i11 + 2] == 'D' || cArr6[i11 + 2] == 'd') {
                            this.f14668d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.f14671g;
            int i12 = this.f14668d;
            return new String(cArr7, i12, this.f14669e - i12);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f14665a);
    }

    /* renamed from: f */
    private String m18056f() {
        int i = this.f14667c + 1;
        this.f14667c = i;
        this.f14668d = i;
        this.f14669e = i;
        while (true) {
            int i2 = this.f14667c;
            if (i2 != this.f14666b) {
                char[] cArr = this.f14671g;
                if (cArr[i2] == '\"') {
                    this.f14667c = i2 + 1;
                    while (true) {
                        int i3 = this.f14667c;
                        if (i3 >= this.f14666b || this.f14671g[i3] != ' ') {
                            char[] cArr2 = this.f14671g;
                            int i4 = this.f14668d;
                        } else {
                            this.f14667c = i3 + 1;
                        }
                    }
                    char[] cArr22 = this.f14671g;
                    int i42 = this.f14668d;
                    return new String(cArr22, i42, this.f14669e - i42);
                }
                if (cArr[i2] == '\\') {
                    cArr[this.f14669e] = m18052b();
                } else {
                    cArr[this.f14669e] = cArr[i2];
                }
                this.f14667c++;
                this.f14669e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f14665a);
            }
        }
    }

    /* renamed from: a */
    private int m18050a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.f14666b) {
            char c = this.f14671g[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f14665a);
            } else {
                i2 = c - '7';
            }
            char c2 = this.f14671g[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f14665a);
            } else {
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.f14665a);
    }

    /* renamed from: a */
    public String mo33106a(String str) {
        String str2;
        this.f14667c = 0;
        this.f14668d = 0;
        this.f14669e = 0;
        this.f14670f = 0;
        this.f14671g = this.f14665a.toCharArray();
        String e = m18055e();
        if (e == null) {
            return null;
        }
        do {
            int i = this.f14667c;
            if (i == this.f14666b) {
                return null;
            }
            char c = this.f14671g[i];
            if (c == '\"') {
                str2 = m18056f();
            } else if (c != '#') {
                str2 = (c == '+' || c == ',' || c == ';') ? "" : m18051a();
            } else {
                str2 = m18054d();
            }
            if (str.equalsIgnoreCase(e)) {
                return str2;
            }
            int i2 = this.f14667c;
            if (i2 >= this.f14666b) {
                return null;
            }
            char[] cArr = this.f14671g;
            if (cArr[i2] == ',' || cArr[i2] == ';' || cArr[i2] == '+') {
                this.f14667c++;
                e = m18055e();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.f14665a);
            }
        } while (e != null);
        throw new IllegalStateException("Malformed DN: " + this.f14665a);
    }
}
