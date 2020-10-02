package com.tapjoy.internal;

import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.internal.C3126bn;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tapjoy.internal.bo */
public final class C4918bo extends C3126bn {

    /* renamed from: a */
    public static final C3126bn.C3128a f13381a = new C3126bn.C3128a() {
        /* renamed from: a */
        public final C3126bn mo18487a(Reader reader) {
            return new C4918bo(reader);
        }

        /* renamed from: a */
        public final C3126bn mo18488a(String str) {
            return new C4918bo(new StringReader(str));
        }
    };

    /* renamed from: b */
    private final C4939cj f13382b = new C4939cj();

    /* renamed from: c */
    private final Reader f13383c;

    /* renamed from: d */
    private boolean f13384d = false;

    /* renamed from: e */
    private final char[] f13385e = new char[OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS];

    /* renamed from: f */
    private int f13386f = 0;

    /* renamed from: g */
    private int f13387g = 0;

    /* renamed from: h */
    private int f13388h = 1;

    /* renamed from: i */
    private int f13389i = 1;

    /* renamed from: j */
    private final List f13390j = new ArrayList();

    /* renamed from: k */
    private C4923bs f13391k;

    /* renamed from: l */
    private String f13392l;

    /* renamed from: m */
    private String f13393m;

    /* renamed from: n */
    private int f13394n;

    /* renamed from: o */
    private int f13395o;

    /* renamed from: p */
    private boolean f13396p;

    /* renamed from: com.tapjoy.internal.bo$2 */
    static /* synthetic */ class C49202 {

        /* renamed from: a */
        static final /* synthetic */ int[] f13397a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.tapjoy.internal.bq[] r0 = com.tapjoy.internal.C4921bq.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13397a = r0
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C4921bq.EMPTY_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f13397a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C4921bq.EMPTY_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f13397a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C4921bq.NONEMPTY_ARRAY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f13397a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C4921bq.EMPTY_OBJECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f13397a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C4921bq.DANGLING_NAME     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f13397a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C4921bq.NONEMPTY_OBJECT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f13397a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C4921bq.NONEMPTY_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f13397a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.C4921bq.CLOSED     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C4918bo.C49202.<clinit>():void");
        }
    }

    public C4918bo(Reader reader) {
        m16718a(C4921bq.EMPTY_DOCUMENT);
        this.f13396p = false;
        if (reader != null) {
            this.f13383c = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000d  */
    /* renamed from: A */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m16715A() {
        /*
            r3 = this;
        L_0x0000:
            int r0 = r3.f13386f
            int r1 = r3.f13387g
            if (r0 < r1) goto L_0x000d
            r0 = 1
            boolean r0 = r3.m16720a((int) r0)
            if (r0 == 0) goto L_0x001f
        L_0x000d:
            char[] r0 = r3.f13385e
            int r1 = r3.f13386f
            int r2 = r1 + 1
            r3.f13386f = r2
            char r0 = r0[r1]
            r1 = 13
            if (r0 == r1) goto L_0x001f
            r1 = 10
            if (r0 != r1) goto L_0x0000
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C4918bo.m16715A():void");
    }

    /* renamed from: a */
    private void m16719a(C4923bs bsVar) {
        mo18495k();
        if (this.f13391k == bsVar) {
            m16725t();
            return;
        }
        throw new IllegalStateException("Expected " + bsVar + " but was " + mo18495k());
    }

    /* renamed from: b */
    private void m16722b(C4921bq bqVar) {
        List list = this.f13390j;
        list.set(list.size() - 1, bqVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0050, code lost:
        m16731z();
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m16723c(boolean r8) {
        /*
            r7 = this;
            r0 = -1
            r7.f13394n = r0
            r0 = 0
            r7.f13395o = r0
            r1 = 0
            r3 = r1
        L_0x0008:
            r2 = 0
        L_0x0009:
            int r4 = r7.f13386f
            int r5 = r4 + r2
            int r6 = r7.f13387g
            if (r5 >= r6) goto L_0x0054
            char[] r5 = r7.f13385e
            int r4 = r4 + r2
            char r4 = r5[r4]
            r5 = 9
            if (r4 == r5) goto L_0x0067
            r5 = 10
            if (r4 == r5) goto L_0x0067
            r5 = 12
            if (r4 == r5) goto L_0x0067
            r5 = 13
            if (r4 == r5) goto L_0x0067
            r5 = 32
            if (r4 == r5) goto L_0x0067
            r5 = 35
            if (r4 == r5) goto L_0x0050
            r5 = 44
            if (r4 == r5) goto L_0x0067
            r5 = 47
            if (r4 == r5) goto L_0x0050
            r5 = 61
            if (r4 == r5) goto L_0x0050
            r5 = 123(0x7b, float:1.72E-43)
            if (r4 == r5) goto L_0x0067
            r5 = 125(0x7d, float:1.75E-43)
            if (r4 == r5) goto L_0x0067
            r5 = 58
            if (r4 == r5) goto L_0x0067
            r5 = 59
            if (r4 == r5) goto L_0x0050
            switch(r4) {
                case 91: goto L_0x0067;
                case 92: goto L_0x0050;
                case 93: goto L_0x0067;
                default: goto L_0x004d;
            }
        L_0x004d:
            int r2 = r2 + 1
            goto L_0x0009
        L_0x0050:
            r7.m16731z()
            goto L_0x0067
        L_0x0054:
            char[] r4 = r7.f13385e
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0069
            int r4 = r2 + 1
            boolean r4 = r7.m16720a((int) r4)
            if (r4 != 0) goto L_0x0009
            char[] r4 = r7.f13385e
            int r5 = r7.f13387g
            r4[r5] = r0
        L_0x0067:
            r0 = r2
            goto L_0x0088
        L_0x0069:
            if (r3 != 0) goto L_0x0070
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x0070:
            char[] r4 = r7.f13385e
            int r5 = r7.f13386f
            r3.append(r4, r5, r2)
            int r4 = r7.f13395o
            int r4 = r4 + r2
            r7.f13395o = r4
            int r4 = r7.f13386f
            int r4 = r4 + r2
            r7.f13386f = r4
            r2 = 1
            boolean r2 = r7.m16720a((int) r2)
            if (r2 != 0) goto L_0x0008
        L_0x0088:
            if (r8 == 0) goto L_0x0091
            if (r3 != 0) goto L_0x0091
            int r8 = r7.f13386f
            r7.f13394n = r8
            goto L_0x00b0
        L_0x0091:
            boolean r8 = r7.f13396p
            if (r8 == 0) goto L_0x0098
            java.lang.String r1 = "skipped!"
            goto L_0x00b0
        L_0x0098:
            if (r3 != 0) goto L_0x00a5
            com.tapjoy.internal.cj r8 = r7.f13382b
            char[] r1 = r7.f13385e
            int r2 = r7.f13386f
            java.lang.String r1 = r8.mo31029a(r1, r2, r0)
            goto L_0x00b0
        L_0x00a5:
            char[] r8 = r7.f13385e
            int r1 = r7.f13386f
            r3.append(r8, r1, r0)
            java.lang.String r1 = r3.toString()
        L_0x00b0:
            int r8 = r7.f13395o
            int r8 = r8 + r0
            r7.f13395o = r8
            int r8 = r7.f13386f
            int r8 = r8 + r0
            r7.f13386f = r8
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C4918bo.m16723c(boolean):java.lang.String");
    }

    /* renamed from: d */
    private IOException m16724d(String str) {
        throw new C4926bu(str + " at line " + m16728w() + " column " + m16729x());
    }

    /* renamed from: t */
    private C4923bs m16725t() {
        mo18495k();
        C4923bs bsVar = this.f13391k;
        this.f13391k = null;
        this.f13393m = null;
        this.f13392l = null;
        return bsVar;
    }

    /* renamed from: u */
    private C4921bq m16726u() {
        List list = this.f13390j;
        return (C4921bq) list.remove(list.size() - 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x01b5  */
    /* renamed from: v */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tapjoy.internal.C4923bs m16727v() {
        /*
            r13 = this;
            int r0 = r13.m16730y()
            r1 = 34
            if (r0 == r1) goto L_0x01d9
            r1 = 39
            if (r0 == r1) goto L_0x01d6
            r1 = 91
            if (r0 == r1) goto L_0x01cc
            r1 = 123(0x7b, float:1.72E-43)
            if (r0 == r1) goto L_0x01c2
            int r0 = r13.f13386f
            r1 = 1
            int r0 = r0 - r1
            r13.f13386f = r0
            java.lang.String r0 = r13.m16723c(r1)
            r13.f13393m = r0
            int r0 = r13.f13395o
            if (r0 == 0) goto L_0x01bb
            int r2 = r13.f13394n
            r3 = -1
            if (r2 == r3) goto L_0x01ad
            r3 = 85
            r4 = 117(0x75, float:1.64E-43)
            r5 = 76
            r6 = 108(0x6c, float:1.51E-43)
            r7 = 4
            if (r0 != r7) goto L_0x0079
            r0 = 110(0x6e, float:1.54E-43)
            char[] r8 = r13.f13385e
            char r9 = r8[r2]
            if (r0 == r9) goto L_0x0042
            r0 = 78
            char r2 = r8[r2]
            if (r0 != r2) goto L_0x0079
        L_0x0042:
            char[] r0 = r13.f13385e
            int r2 = r13.f13394n
            int r8 = r2 + 1
            char r8 = r0[r8]
            if (r4 == r8) goto L_0x0051
            int r2 = r2 + r1
            char r0 = r0[r2]
            if (r3 != r0) goto L_0x0079
        L_0x0051:
            char[] r0 = r13.f13385e
            int r2 = r13.f13394n
            int r8 = r2 + 2
            char r8 = r0[r8]
            if (r6 == r8) goto L_0x0061
            int r2 = r2 + 2
            char r0 = r0[r2]
            if (r5 != r0) goto L_0x0079
        L_0x0061:
            char[] r0 = r13.f13385e
            int r2 = r13.f13394n
            int r8 = r2 + 3
            char r8 = r0[r8]
            if (r6 == r8) goto L_0x0071
            int r2 = r2 + 3
            char r0 = r0[r2]
            if (r5 != r0) goto L_0x0079
        L_0x0071:
            java.lang.String r0 = "null"
            r13.f13393m = r0
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C4923bs.NULL
            goto L_0x01af
        L_0x0079:
            int r0 = r13.f13395o
            r2 = 69
            r8 = 101(0x65, float:1.42E-43)
            if (r0 != r7) goto L_0x00cc
            r0 = 116(0x74, float:1.63E-43)
            char[] r9 = r13.f13385e
            int r10 = r13.f13394n
            char r11 = r9[r10]
            if (r0 == r11) goto L_0x0091
            r0 = 84
            char r9 = r9[r10]
            if (r0 != r9) goto L_0x00cc
        L_0x0091:
            r0 = 114(0x72, float:1.6E-43)
            char[] r9 = r13.f13385e
            int r10 = r13.f13394n
            int r11 = r10 + 1
            char r11 = r9[r11]
            if (r0 == r11) goto L_0x00a4
            r0 = 82
            int r10 = r10 + r1
            char r9 = r9[r10]
            if (r0 != r9) goto L_0x00cc
        L_0x00a4:
            char[] r0 = r13.f13385e
            int r9 = r13.f13394n
            int r10 = r9 + 2
            char r10 = r0[r10]
            if (r4 == r10) goto L_0x00b4
            int r9 = r9 + 2
            char r0 = r0[r9]
            if (r3 != r0) goto L_0x00cc
        L_0x00b4:
            char[] r0 = r13.f13385e
            int r3 = r13.f13394n
            int r4 = r3 + 3
            char r4 = r0[r4]
            if (r8 == r4) goto L_0x00c4
            int r3 = r3 + 3
            char r0 = r0[r3]
            if (r2 != r0) goto L_0x00cc
        L_0x00c4:
            java.lang.String r0 = "true"
            r13.f13393m = r0
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C4923bs.BOOLEAN
            goto L_0x01af
        L_0x00cc:
            int r0 = r13.f13395o
            r3 = 5
            if (r0 != r3) goto L_0x012f
            r0 = 102(0x66, float:1.43E-43)
            char[] r3 = r13.f13385e
            int r4 = r13.f13394n
            char r9 = r3[r4]
            if (r0 == r9) goto L_0x00e1
            r0 = 70
            char r3 = r3[r4]
            if (r0 != r3) goto L_0x012f
        L_0x00e1:
            r0 = 97
            char[] r3 = r13.f13385e
            int r4 = r13.f13394n
            int r9 = r4 + 1
            char r9 = r3[r9]
            if (r0 == r9) goto L_0x00f4
            r0 = 65
            int r4 = r4 + r1
            char r3 = r3[r4]
            if (r0 != r3) goto L_0x012f
        L_0x00f4:
            char[] r0 = r13.f13385e
            int r3 = r13.f13394n
            int r4 = r3 + 2
            char r4 = r0[r4]
            if (r6 == r4) goto L_0x0104
            int r3 = r3 + 2
            char r0 = r0[r3]
            if (r5 != r0) goto L_0x012f
        L_0x0104:
            r0 = 115(0x73, float:1.61E-43)
            char[] r3 = r13.f13385e
            int r4 = r13.f13394n
            int r5 = r4 + 3
            char r5 = r3[r5]
            if (r0 == r5) goto L_0x0118
            r0 = 83
            int r4 = r4 + 3
            char r3 = r3[r4]
            if (r0 != r3) goto L_0x012f
        L_0x0118:
            char[] r0 = r13.f13385e
            int r3 = r13.f13394n
            int r4 = r3 + 4
            char r4 = r0[r4]
            if (r8 == r4) goto L_0x0127
            int r3 = r3 + r7
            char r0 = r0[r3]
            if (r2 != r0) goto L_0x012f
        L_0x0127:
            java.lang.String r0 = "false"
            r13.f13393m = r0
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C4923bs.BOOLEAN
            goto L_0x01af
        L_0x012f:
            com.tapjoy.internal.cj r0 = r13.f13382b
            char[] r3 = r13.f13385e
            int r4 = r13.f13394n
            int r5 = r13.f13395o
            java.lang.String r0 = r0.mo31029a(r3, r4, r5)
            r13.f13393m = r0
            char[] r0 = r13.f13385e
            int r3 = r13.f13394n
            int r4 = r13.f13395o
            char r5 = r0[r3]
            r6 = 45
            if (r5 != r6) goto L_0x0151
            int r5 = r3 + 1
            char r7 = r0[r5]
            r12 = r7
            r7 = r5
            r5 = r12
            goto L_0x0152
        L_0x0151:
            r7 = r3
        L_0x0152:
            r9 = 57
            r10 = 48
            if (r5 != r10) goto L_0x015c
            int r7 = r7 + r1
            char r5 = r0[r7]
            goto L_0x016e
        L_0x015c:
            r11 = 49
            if (r5 < r11) goto L_0x01aa
            if (r5 > r9) goto L_0x01aa
            int r7 = r7 + r1
            char r5 = r0[r7]
        L_0x0165:
            if (r5 < r10) goto L_0x016e
            if (r5 > r9) goto L_0x016e
            int r7 = r7 + 1
            char r5 = r0[r7]
            goto L_0x0165
        L_0x016e:
            r11 = 46
            if (r5 != r11) goto L_0x017f
            int r7 = r7 + 1
            char r5 = r0[r7]
        L_0x0176:
            if (r5 < r10) goto L_0x017f
            if (r5 > r9) goto L_0x017f
            int r7 = r7 + 1
            char r5 = r0[r7]
            goto L_0x0176
        L_0x017f:
            if (r5 == r8) goto L_0x0183
            if (r5 != r2) goto L_0x01a1
        L_0x0183:
            int r7 = r7 + 1
            char r2 = r0[r7]
            r5 = 43
            if (r2 == r5) goto L_0x018d
            if (r2 != r6) goto L_0x0191
        L_0x018d:
            int r7 = r7 + 1
            char r2 = r0[r7]
        L_0x0191:
            if (r2 < r10) goto L_0x01a7
            if (r2 > r9) goto L_0x01a7
            int r7 = r7 + r1
            char r1 = r0[r7]
        L_0x0198:
            if (r1 < r10) goto L_0x01a1
            if (r1 > r9) goto L_0x01a1
            int r7 = r7 + 1
            char r1 = r0[r7]
            goto L_0x0198
        L_0x01a1:
            int r3 = r3 + r4
            if (r7 != r3) goto L_0x01ad
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C4923bs.NUMBER
            goto L_0x01af
        L_0x01a7:
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C4923bs.STRING
            goto L_0x01af
        L_0x01aa:
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C4923bs.STRING
            goto L_0x01af
        L_0x01ad:
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C4923bs.STRING
        L_0x01af:
            r13.f13391k = r0
            com.tapjoy.internal.bs r1 = com.tapjoy.internal.C4923bs.STRING
            if (r0 != r1) goto L_0x01b8
            r13.m16731z()
        L_0x01b8:
            com.tapjoy.internal.bs r0 = r13.f13391k
            return r0
        L_0x01bb:
            java.lang.String r0 = "Expected literal value"
            java.io.IOException r0 = r13.m16724d(r0)
            throw r0
        L_0x01c2:
            com.tapjoy.internal.bq r0 = com.tapjoy.internal.C4921bq.EMPTY_OBJECT
            r13.m16718a((com.tapjoy.internal.C4921bq) r0)
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C4923bs.BEGIN_OBJECT
            r13.f13391k = r0
            return r0
        L_0x01cc:
            com.tapjoy.internal.bq r0 = com.tapjoy.internal.C4921bq.EMPTY_ARRAY
            r13.m16718a((com.tapjoy.internal.C4921bq) r0)
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C4923bs.BEGIN_ARRAY
            r13.f13391k = r0
            return r0
        L_0x01d6:
            r13.m16731z()
        L_0x01d9:
            char r0 = (char) r0
            java.lang.String r0 = r13.m16717a((char) r0)
            r13.f13393m = r0
            com.tapjoy.internal.bs r0 = com.tapjoy.internal.C4923bs.STRING
            r13.f13391k = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C4918bo.m16727v():com.tapjoy.internal.bs");
    }

    /* renamed from: w */
    private int m16728w() {
        int i = this.f13388h;
        for (int i2 = 0; i2 < this.f13386f; i2++) {
            if (this.f13385e[i2] == 10) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: x */
    private int m16729x() {
        int i = this.f13389i;
        for (int i2 = 0; i2 < this.f13386f; i2++) {
            i = this.f13385e[i2] == 10 ? 1 : i + 1;
        }
        return i;
    }

    /* renamed from: y */
    private int m16730y() {
        while (true) {
            boolean z = true;
            if (this.f13386f < this.f13387g || m16720a(1)) {
                char[] cArr = this.f13385e;
                int i = this.f13386f;
                int i2 = i + 1;
                this.f13386f = i2;
                char c = cArr[i];
                if (!(c == 9 || c == 10 || c == 13 || c == ' ')) {
                    if (c == '#') {
                        m16731z();
                        m16715A();
                    } else if (c != '/') {
                        return c;
                    } else {
                        if (i2 == this.f13387g && !m16720a(1)) {
                            return c;
                        }
                        m16731z();
                        char[] cArr2 = this.f13385e;
                        int i3 = this.f13386f;
                        char c2 = cArr2[i3];
                        if (c2 == '*') {
                            this.f13386f = i3 + 1;
                            while (true) {
                                int i4 = 0;
                                if (this.f13386f + 2 > this.f13387g && !m16720a(2)) {
                                    z = false;
                                    break;
                                }
                                while (i4 < 2) {
                                    if (this.f13385e[this.f13386f + i4] == "*/".charAt(i4)) {
                                        i4++;
                                    } else {
                                        this.f13386f++;
                                    }
                                }
                                break;
                            }
                            if (z) {
                                this.f13386f += 2;
                            } else {
                                throw m16724d("Unterminated comment");
                            }
                        } else if (c2 != '/') {
                            return c;
                        } else {
                            this.f13386f = i3 + 1;
                            m16715A();
                        }
                    }
                }
            } else {
                throw new EOFException("End of input");
            }
        }
    }

    /* renamed from: z */
    private void m16731z() {
        if (!this.f13384d) {
            throw m16724d("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    public final void close() {
        this.f13393m = null;
        this.f13391k = null;
        this.f13390j.clear();
        this.f13390j.add(C4921bq.CLOSED);
        this.f13383c.close();
    }

    /* renamed from: f */
    public final void mo18490f() {
        m16719a(C4923bs.BEGIN_ARRAY);
    }

    /* renamed from: g */
    public final void mo18491g() {
        m16719a(C4923bs.END_ARRAY);
    }

    /* renamed from: h */
    public final void mo18492h() {
        m16719a(C4923bs.BEGIN_OBJECT);
    }

    /* renamed from: i */
    public final void mo18493i() {
        m16719a(C4923bs.END_OBJECT);
    }

    /* renamed from: j */
    public final boolean mo18494j() {
        mo18495k();
        C4923bs bsVar = this.f13391k;
        return (bsVar == C4923bs.END_OBJECT || bsVar == C4923bs.END_ARRAY) ? false : true;
    }

    /* renamed from: k */
    public final C4923bs mo18495k() {
        C4923bs bsVar;
        C4923bs bsVar2 = this.f13391k;
        if (bsVar2 != null) {
            return bsVar2;
        }
        int[] iArr = C49202.f13397a;
        List list = this.f13390j;
        switch (iArr[((C4921bq) list.get(list.size() - 1)).ordinal()]) {
            case 1:
                m16722b(C4921bq.NONEMPTY_DOCUMENT);
                C4923bs v = m16727v();
                if (this.f13384d || (bsVar = this.f13391k) == C4923bs.BEGIN_ARRAY || bsVar == C4923bs.BEGIN_OBJECT) {
                    return v;
                }
                throw new IOException("Expected JSON document to start with '[' or '{' but was " + this.f13391k);
            case 2:
                return m16716a(true);
            case 3:
                return m16716a(false);
            case 4:
                return m16721b(true);
            case 5:
                int y = m16730y();
                if (y != 58) {
                    if (y == 61) {
                        m16731z();
                        if (this.f13386f < this.f13387g || m16720a(1)) {
                            char[] cArr = this.f13385e;
                            int i = this.f13386f;
                            if (cArr[i] == '>') {
                                this.f13386f = i + 1;
                            }
                        }
                    } else {
                        throw m16724d("Expected ':'");
                    }
                }
                m16722b(C4921bq.NONEMPTY_OBJECT);
                return m16727v();
            case 6:
                return m16721b(false);
            case 7:
                try {
                    C4923bs v2 = m16727v();
                    if (this.f13384d) {
                        return v2;
                    }
                    throw m16724d("Expected EOF");
                } catch (EOFException unused) {
                    C4923bs bsVar3 = C4923bs.END_DOCUMENT;
                    this.f13391k = bsVar3;
                    return bsVar3;
                }
            case 8:
                throw new IllegalStateException("JsonReader is closed");
            default:
                throw new AssertionError();
        }
    }

    /* renamed from: l */
    public final String mo18496l() {
        mo18495k();
        if (this.f13391k == C4923bs.NAME) {
            String str = this.f13392l;
            m16725t();
            return str;
        }
        throw new IllegalStateException("Expected a name but was " + mo18495k());
    }

    /* renamed from: m */
    public final String mo18497m() {
        mo18495k();
        C4923bs bsVar = this.f13391k;
        if (bsVar == C4923bs.STRING || bsVar == C4923bs.NUMBER) {
            String str = this.f13393m;
            m16725t();
            return str;
        }
        throw new IllegalStateException("Expected a string but was " + mo18495k());
    }

    /* renamed from: n */
    public final boolean mo18498n() {
        mo18495k();
        if (this.f13391k == C4923bs.BOOLEAN) {
            boolean z = this.f13393m == "true";
            m16725t();
            return z;
        }
        throw new IllegalStateException("Expected a boolean but was " + this.f13391k);
    }

    /* renamed from: o */
    public final void mo18499o() {
        mo18495k();
        if (this.f13391k == C4923bs.NULL) {
            m16725t();
            return;
        }
        throw new IllegalStateException("Expected null but was " + this.f13391k);
    }

    /* renamed from: p */
    public final double mo18500p() {
        mo18495k();
        C4923bs bsVar = this.f13391k;
        if (bsVar == C4923bs.STRING || bsVar == C4923bs.NUMBER) {
            double parseDouble = Double.parseDouble(this.f13393m);
            m16725t();
            return parseDouble;
        }
        throw new IllegalStateException("Expected a double but was " + this.f13391k);
    }

    /* renamed from: q */
    public final long mo18501q() {
        long j;
        mo18495k();
        C4923bs bsVar = this.f13391k;
        if (bsVar == C4923bs.STRING || bsVar == C4923bs.NUMBER) {
            try {
                j = Long.parseLong(this.f13393m);
            } catch (NumberFormatException unused) {
                double parseDouble = Double.parseDouble(this.f13393m);
                long j2 = (long) parseDouble;
                if (((double) j2) == parseDouble) {
                    j = j2;
                } else {
                    throw new NumberFormatException(this.f13393m);
                }
            }
            m16725t();
            return j;
        }
        throw new IllegalStateException("Expected a long but was " + this.f13391k);
    }

    /* renamed from: r */
    public final int mo18502r() {
        int i;
        mo18495k();
        C4923bs bsVar = this.f13391k;
        if (bsVar == C4923bs.STRING || bsVar == C4923bs.NUMBER) {
            try {
                i = Integer.parseInt(this.f13393m);
            } catch (NumberFormatException unused) {
                double parseDouble = Double.parseDouble(this.f13393m);
                int i2 = (int) parseDouble;
                if (((double) i2) == parseDouble) {
                    i = i2;
                } else {
                    throw new NumberFormatException(this.f13393m);
                }
            }
            m16725t();
            return i;
        }
        throw new IllegalStateException("Expected an int but was " + this.f13391k);
    }

    /* renamed from: s */
    public final void mo18503s() {
        mo18495k();
        C4923bs bsVar = this.f13391k;
        if (bsVar == C4923bs.END_ARRAY || bsVar == C4923bs.END_OBJECT) {
            throw new IllegalStateException("Expected a value but was " + this.f13391k);
        }
        this.f13396p = true;
        int i = 0;
        do {
            try {
                C4923bs t = m16725t();
                if (t != C4923bs.BEGIN_ARRAY) {
                    if (t != C4923bs.BEGIN_OBJECT) {
                        if (t == C4923bs.END_ARRAY || t == C4923bs.END_OBJECT) {
                            i--;
                            continue;
                        }
                    }
                }
                i++;
                continue;
            } finally {
                this.f13396p = false;
            }
        } while (i != 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(C4918bo.class.getSimpleName());
        sb.append(" near ");
        StringBuilder sb2 = new StringBuilder();
        int min = Math.min(this.f13386f, 20);
        sb2.append(this.f13385e, this.f13386f - min, min);
        sb2.append(this.f13385e, this.f13386f, Math.min(this.f13387g - this.f13386f, 20));
        sb.append(sb2);
        return sb.toString();
    }

    /* renamed from: b */
    private C4923bs m16721b(boolean z) {
        if (!z) {
            int y = m16730y();
            if (!(y == 44 || y == 59)) {
                if (y == 125) {
                    m16726u();
                    C4923bs bsVar = C4923bs.END_OBJECT;
                    this.f13391k = bsVar;
                    return bsVar;
                }
                throw m16724d("Unterminated object");
            }
        } else if (m16730y() != 125) {
            this.f13386f--;
        } else {
            m16726u();
            C4923bs bsVar2 = C4923bs.END_OBJECT;
            this.f13391k = bsVar2;
            return bsVar2;
        }
        int y2 = m16730y();
        if (y2 != 34) {
            if (y2 != 39) {
                m16731z();
                this.f13386f--;
                String c = m16723c(false);
                this.f13392l = c;
                if (c.length() == 0) {
                    throw m16724d("Expected name");
                }
                m16722b(C4921bq.DANGLING_NAME);
                C4923bs bsVar3 = C4923bs.NAME;
                this.f13391k = bsVar3;
                return bsVar3;
            }
            m16731z();
        }
        this.f13392l = m16717a((char) y2);
        m16722b(C4921bq.DANGLING_NAME);
        C4923bs bsVar32 = C4923bs.NAME;
        this.f13391k = bsVar32;
        return bsVar32;
    }

    /* renamed from: a */
    private void m16718a(C4921bq bqVar) {
        this.f13390j.add(bqVar);
    }

    /* renamed from: a */
    private C4923bs m16716a(boolean z) {
        if (z) {
            m16722b(C4921bq.NONEMPTY_ARRAY);
        } else {
            int y = m16730y();
            if (y != 44) {
                if (y == 59) {
                    m16731z();
                } else if (y == 93) {
                    m16726u();
                    C4923bs bsVar = C4923bs.END_ARRAY;
                    this.f13391k = bsVar;
                    return bsVar;
                } else {
                    throw m16724d("Unterminated array");
                }
            }
        }
        int y2 = m16730y();
        if (!(y2 == 44 || y2 == 59)) {
            if (y2 != 93) {
                this.f13386f--;
                return m16727v();
            } else if (z) {
                m16726u();
                C4923bs bsVar2 = C4923bs.END_ARRAY;
                this.f13391k = bsVar2;
                return bsVar2;
            }
        }
        m16731z();
        this.f13386f--;
        this.f13393m = "null";
        C4923bs bsVar3 = C4923bs.NULL;
        this.f13391k = bsVar3;
        return bsVar3;
    }

    /* renamed from: a */
    private boolean m16720a(int i) {
        int i2;
        int i3;
        int i4 = 0;
        while (true) {
            i2 = this.f13386f;
            if (i4 >= i2) {
                break;
            }
            if (this.f13385e[i4] == 10) {
                this.f13388h++;
                this.f13389i = 1;
            } else {
                this.f13389i++;
            }
            i4++;
        }
        int i5 = this.f13387g;
        if (i5 != i2) {
            int i6 = i5 - i2;
            this.f13387g = i6;
            char[] cArr = this.f13385e;
            System.arraycopy(cArr, i2, cArr, 0, i6);
        } else {
            this.f13387g = 0;
        }
        this.f13386f = 0;
        do {
            Reader reader = this.f13383c;
            char[] cArr2 = this.f13385e;
            int i7 = this.f13387g;
            int read = reader.read(cArr2, i7, cArr2.length - i7);
            if (read == -1) {
                return false;
            }
            int i8 = this.f13387g + read;
            this.f13387g = i8;
            if (this.f13388h == 1 && (i3 = this.f13389i) == 1 && i8 > 0 && this.f13385e[0] == 65279) {
                this.f13386f++;
                this.f13389i = i3 - 1;
            }
        } while (this.f13387g < i);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ba, code lost:
        if (r0 != null) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00bc, code lost:
        r0 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c1, code lost:
        r0.append(r6.f13385e, r1, r6.f13386f - r1);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m16717a(char r7) {
        /*
            r6 = this;
            r0 = 0
        L_0x0001:
            int r1 = r6.f13386f
        L_0x0003:
            int r2 = r6.f13386f
            int r3 = r6.f13387g
            r4 = 1
            if (r2 >= r3) goto L_0x00ba
            char[] r3 = r6.f13385e
            int r5 = r2 + 1
            r6.f13386f = r5
            char r2 = r3[r2]
            if (r2 != r7) goto L_0x0030
            boolean r7 = r6.f13396p
            if (r7 == 0) goto L_0x001b
            java.lang.String r7 = "skipped!"
            return r7
        L_0x001b:
            if (r0 != 0) goto L_0x0026
            com.tapjoy.internal.cj r7 = r6.f13382b
            int r5 = r5 - r1
            int r5 = r5 - r4
            java.lang.String r7 = r7.mo31029a(r3, r1, r5)
            return r7
        L_0x0026:
            int r5 = r5 - r1
            int r5 = r5 - r4
            r0.append(r3, r1, r5)
            java.lang.String r7 = r0.toString()
            return r7
        L_0x0030:
            r3 = 92
            if (r2 != r3) goto L_0x0003
            if (r0 != 0) goto L_0x003b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x003b:
            char[] r2 = r6.f13385e
            int r3 = r6.f13386f
            int r3 = r3 - r1
            int r3 = r3 - r4
            r0.append(r2, r1, r3)
            int r1 = r6.f13386f
            int r2 = r6.f13387g
            java.lang.String r3 = "Unterminated escape sequence"
            if (r1 != r2) goto L_0x0058
            boolean r1 = r6.m16720a((int) r4)
            if (r1 == 0) goto L_0x0053
            goto L_0x0058
        L_0x0053:
            java.io.IOException r7 = r6.m16724d(r3)
            throw r7
        L_0x0058:
            char[] r1 = r6.f13385e
            int r2 = r6.f13386f
            int r4 = r2 + 1
            r6.f13386f = r4
            char r1 = r1[r2]
            r2 = 98
            if (r1 == r2) goto L_0x00b1
            r2 = 102(0x66, float:1.43E-43)
            if (r1 == r2) goto L_0x00ae
            r2 = 110(0x6e, float:1.54E-43)
            if (r1 == r2) goto L_0x00ab
            r2 = 114(0x72, float:1.6E-43)
            if (r1 == r2) goto L_0x00a8
            r2 = 116(0x74, float:1.63E-43)
            if (r1 == r2) goto L_0x00a5
            r2 = 117(0x75, float:1.64E-43)
            if (r1 == r2) goto L_0x007b
            goto L_0x00b3
        L_0x007b:
            int r4 = r4 + 4
            int r1 = r6.f13387g
            r2 = 4
            if (r4 <= r1) goto L_0x008e
            boolean r1 = r6.m16720a((int) r2)
            if (r1 == 0) goto L_0x0089
            goto L_0x008e
        L_0x0089:
            java.io.IOException r7 = r6.m16724d(r3)
            throw r7
        L_0x008e:
            com.tapjoy.internal.cj r1 = r6.f13382b
            char[] r3 = r6.f13385e
            int r4 = r6.f13386f
            java.lang.String r1 = r1.mo31029a(r3, r4, r2)
            int r3 = r6.f13386f
            int r3 = r3 + r2
            r6.f13386f = r3
            r2 = 16
            int r1 = java.lang.Integer.parseInt(r1, r2)
            char r1 = (char) r1
            goto L_0x00b3
        L_0x00a5:
            r1 = 9
            goto L_0x00b3
        L_0x00a8:
            r1 = 13
            goto L_0x00b3
        L_0x00ab:
            r1 = 10
            goto L_0x00b3
        L_0x00ae:
            r1 = 12
            goto L_0x00b3
        L_0x00b1:
            r1 = 8
        L_0x00b3:
            r0.append(r1)
            int r1 = r6.f13386f
            goto L_0x0003
        L_0x00ba:
            if (r0 != 0) goto L_0x00c1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x00c1:
            char[] r2 = r6.f13385e
            int r3 = r6.f13386f
            int r3 = r3 - r1
            r0.append(r2, r1, r3)
            boolean r1 = r6.m16720a((int) r4)
            if (r1 == 0) goto L_0x00d1
            goto L_0x0001
        L_0x00d1:
            java.lang.String r7 = "Unterminated string"
            java.io.IOException r7 = r6.m16724d(r7)
            goto L_0x00d9
        L_0x00d8:
            throw r7
        L_0x00d9:
            goto L_0x00d8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C4918bo.m16717a(char):java.lang.String");
    }
}
