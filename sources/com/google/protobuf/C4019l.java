package com.google.protobuf;

import com.google.protobuf.C4005f0;
import com.google.protobuf.C4019l.C4021b;
import com.google.protobuf.C4047q;
import com.google.protobuf.C4054u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.protobuf.l */
/* compiled from: FieldSet */
final class C4019l<FieldDescriptorType extends C4021b<FieldDescriptorType>> {

    /* renamed from: a */
    private final C3972a0<FieldDescriptorType, Object> f10821a = C3972a0.m13224b(16);

    /* renamed from: b */
    private boolean f10822b;

    /* renamed from: c */
    private boolean f10823c = false;

    /* renamed from: com.google.protobuf.l$a */
    /* compiled from: FieldSet */
    static /* synthetic */ class C4020a {

        /* renamed from: a */
        static final /* synthetic */ int[] f10824a;

        /* renamed from: b */
        static final /* synthetic */ int[] f10825b;

        /* JADX WARNING: Can't wrap try/catch for region: R(55:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|(3:71|72|74)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Can't wrap try/catch for region: R(65:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|74) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00f3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00fd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0107 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0111 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x011b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0125 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x012f */
        static {
            /*
                com.google.protobuf.f0$b[] r0 = com.google.protobuf.C4005f0.C4007b.m13360b()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10825b = r0
                r1 = 1
                com.google.protobuf.f0$b r2 = com.google.protobuf.C4005f0.C4007b.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f10825b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.f0$b r3 = com.google.protobuf.C4005f0.C4007b.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f10825b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.f0$b r4 = com.google.protobuf.C4005f0.C4007b.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f10825b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.f0$b r5 = com.google.protobuf.C4005f0.C4007b.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f10825b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.f0$b r6 = com.google.protobuf.C4005f0.C4007b.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f10825b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.f0$b r7 = com.google.protobuf.C4005f0.C4007b.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f10825b     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.f0$b r8 = com.google.protobuf.C4005f0.C4007b.FIXED32     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = f10825b     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.f0$b r9 = com.google.protobuf.C4005f0.C4007b.BOOL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                r8 = 9
                int[] r9 = f10825b     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.f0$b r10 = com.google.protobuf.C4005f0.C4007b.GROUP     // Catch:{ NoSuchFieldError -> 0x006c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r9 = f10825b     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.f0$b r10 = com.google.protobuf.C4005f0.C4007b.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r11 = 10
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r9 = f10825b     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.f0$b r10 = com.google.protobuf.C4005f0.C4007b.STRING     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r11 = 11
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r9 = f10825b     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.f0$b r10 = com.google.protobuf.C4005f0.C4007b.BYTES     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r11 = 12
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r9 = f10825b     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.f0$b r10 = com.google.protobuf.C4005f0.C4007b.UINT32     // Catch:{ NoSuchFieldError -> 0x009c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r11 = 13
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r9 = f10825b     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.f0$b r10 = com.google.protobuf.C4005f0.C4007b.SFIXED32     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r11 = 14
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r9 = f10825b     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.f0$b r10 = com.google.protobuf.C4005f0.C4007b.SFIXED64     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r11 = 15
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r9 = f10825b     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.f0$b r10 = com.google.protobuf.C4005f0.C4007b.SINT32     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r11 = 16
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r9 = f10825b     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.f0$b r10 = com.google.protobuf.C4005f0.C4007b.SINT64     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r11 = 17
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r9 = f10825b     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.google.protobuf.f0$b r10 = com.google.protobuf.C4005f0.C4007b.ENUM     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r11 = 18
                r9[r10] = r11     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                com.google.protobuf.f0$c[] r9 = com.google.protobuf.C4005f0.C4012c.m13362a()
                int r9 = r9.length
                int[] r9 = new int[r9]
                f10824a = r9
                com.google.protobuf.f0$c r10 = com.google.protobuf.C4005f0.C4012c.INT     // Catch:{ NoSuchFieldError -> 0x00e9 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e9 }
                r9[r10] = r1     // Catch:{ NoSuchFieldError -> 0x00e9 }
            L_0x00e9:
                int[] r1 = f10824a     // Catch:{ NoSuchFieldError -> 0x00f3 }
                com.google.protobuf.f0$c r9 = com.google.protobuf.C4005f0.C4012c.LONG     // Catch:{ NoSuchFieldError -> 0x00f3 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f3 }
                r1[r9] = r0     // Catch:{ NoSuchFieldError -> 0x00f3 }
            L_0x00f3:
                int[] r0 = f10824a     // Catch:{ NoSuchFieldError -> 0x00fd }
                com.google.protobuf.f0$c r1 = com.google.protobuf.C4005f0.C4012c.FLOAT     // Catch:{ NoSuchFieldError -> 0x00fd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fd }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fd }
            L_0x00fd:
                int[] r0 = f10824a     // Catch:{ NoSuchFieldError -> 0x0107 }
                com.google.protobuf.f0$c r1 = com.google.protobuf.C4005f0.C4012c.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0107 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0107 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0107 }
            L_0x0107:
                int[] r0 = f10824a     // Catch:{ NoSuchFieldError -> 0x0111 }
                com.google.protobuf.f0$c r1 = com.google.protobuf.C4005f0.C4012c.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0111 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0111 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0111 }
            L_0x0111:
                int[] r0 = f10824a     // Catch:{ NoSuchFieldError -> 0x011b }
                com.google.protobuf.f0$c r1 = com.google.protobuf.C4005f0.C4012c.STRING     // Catch:{ NoSuchFieldError -> 0x011b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x011b }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x011b }
            L_0x011b:
                int[] r0 = f10824a     // Catch:{ NoSuchFieldError -> 0x0125 }
                com.google.protobuf.f0$c r1 = com.google.protobuf.C4005f0.C4012c.BYTE_STRING     // Catch:{ NoSuchFieldError -> 0x0125 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0125 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x0125 }
            L_0x0125:
                int[] r0 = f10824a     // Catch:{ NoSuchFieldError -> 0x012f }
                com.google.protobuf.f0$c r1 = com.google.protobuf.C4005f0.C4012c.ENUM     // Catch:{ NoSuchFieldError -> 0x012f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012f }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x012f }
            L_0x012f:
                int[] r0 = f10824a     // Catch:{ NoSuchFieldError -> 0x0139 }
                com.google.protobuf.f0$c r1 = com.google.protobuf.C4005f0.C4012c.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0139 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0139 }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x0139 }
            L_0x0139:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C4019l.C4020a.<clinit>():void");
        }
    }

    /* renamed from: com.google.protobuf.l$b */
    /* compiled from: FieldSet */
    public interface C4021b<T extends C4021b<T>> extends Comparable<T> {
        /* renamed from: a */
        C4054u.C4055a mo28177a(C4054u.C4055a aVar, C4054u uVar);

        /* renamed from: p */
        boolean mo28178p();

        /* renamed from: q */
        C4005f0.C4007b mo28179q();

        /* renamed from: r */
        C4005f0.C4012c mo28180r();
    }

    static {
        new C4019l(true);
    }

    private C4019l() {
    }

    /* renamed from: d */
    public static <T extends C4021b<T>> C4019l<T> m13419d() {
        return new C4019l<>();
    }

    /* renamed from: a */
    public boolean mo28171a() {
        return this.f10822b;
    }

    /* renamed from: b */
    public Iterator<Map.Entry<FieldDescriptorType, Object>> mo28172b() {
        if (this.f10823c) {
            return new C4047q.C4050c(this.f10821a.entrySet().iterator());
        }
        return this.f10821a.entrySet().iterator();
    }

    /* renamed from: c */
    public void mo28173c() {
        if (!this.f10822b) {
            this.f10821a.mo28035e();
            this.f10822b = true;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4019l)) {
            return false;
        }
        return this.f10821a.equals(((C4019l) obj).f10821a);
    }

    public int hashCode() {
        return this.f10821a.hashCode();
    }

    /* renamed from: a */
    public Object mo28168a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f10821a.get(fielddescriptortype);
        return obj instanceof C4047q ? ((C4047q) obj).mo28237a() : obj;
    }

    public C4019l<FieldDescriptorType> clone() {
        C4019l<FieldDescriptorType> d = m13419d();
        for (int i = 0; i < this.f10821a.mo28027a(); i++) {
            Map.Entry<FieldDescriptorType, Object> a = this.f10821a.mo28029a(i);
            d.mo28169a((FieldDescriptorType) (C4021b) a.getKey(), a.getValue());
        }
        for (Map.Entry next : this.f10821a.mo28031c()) {
            d.mo28169a((FieldDescriptorType) (C4021b) next.getKey(), next.getValue());
        }
        d.f10823c = this.f10823c;
        return d;
    }

    private C4019l(boolean z) {
        mo28173c();
    }

    /* renamed from: a */
    public void mo28169a(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.mo28178p()) {
            m13417a(fielddescriptortype.mo28179q(), obj);
        } else if (obj instanceof List) {
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.addAll((List) obj);
            for (Object a : arrayList) {
                m13417a(fielddescriptortype.mo28179q(), a);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof C4047q) {
            this.f10823c = true;
        }
        this.f10821a.put(fielddescriptortype, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        if ((r3 instanceof com.google.protobuf.C4038p.C4041c) == false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if ((r3 instanceof com.google.protobuf.C4047q) == false) goto L_0x002f;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m13417a(com.google.protobuf.C4005f0.C4007b r2, java.lang.Object r3) {
        /*
            if (r3 == 0) goto L_0x004e
            int[] r0 = com.google.protobuf.C4019l.C4020a.f10824a
            com.google.protobuf.f0$c r2 = r2.mo28132a()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0041;
                case 2: goto L_0x003e;
                case 3: goto L_0x003b;
                case 4: goto L_0x0038;
                case 5: goto L_0x0035;
                case 6: goto L_0x0032;
                case 7: goto L_0x0026;
                case 8: goto L_0x001d;
                case 9: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0043
        L_0x0014:
            boolean r2 = r3 instanceof com.google.protobuf.C4054u
            if (r2 != 0) goto L_0x0030
            boolean r2 = r3 instanceof com.google.protobuf.C4047q
            if (r2 == 0) goto L_0x002f
            goto L_0x0030
        L_0x001d:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0030
            boolean r2 = r3 instanceof com.google.protobuf.C4038p.C4041c
            if (r2 == 0) goto L_0x002f
            goto L_0x0030
        L_0x0026:
            boolean r2 = r3 instanceof com.google.protobuf.C3995f
            if (r2 != 0) goto L_0x0030
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r0 = 0
        L_0x0030:
            r1 = r0
            goto L_0x0043
        L_0x0032:
            boolean r1 = r3 instanceof java.lang.String
            goto L_0x0043
        L_0x0035:
            boolean r1 = r3 instanceof java.lang.Boolean
            goto L_0x0043
        L_0x0038:
            boolean r1 = r3 instanceof java.lang.Double
            goto L_0x0043
        L_0x003b:
            boolean r1 = r3 instanceof java.lang.Float
            goto L_0x0043
        L_0x003e:
            boolean r1 = r3 instanceof java.lang.Long
            goto L_0x0043
        L_0x0041:
            boolean r1 = r3 instanceof java.lang.Integer
        L_0x0043:
            if (r1 == 0) goto L_0x0046
            return
        L_0x0046:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        L_0x004e:
            r2 = 0
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C4019l.m13417a(com.google.protobuf.f0$b, java.lang.Object):void");
    }

    /* renamed from: a */
    public void mo28170a(C4019l<FieldDescriptorType> lVar) {
        for (int i = 0; i < lVar.f10821a.mo28027a(); i++) {
            m13418a(lVar.f10821a.mo28029a(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> a : lVar.f10821a.mo28031c()) {
            m13418a(a);
        }
    }

    /* renamed from: a */
    private Object m13416a(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* renamed from: a */
    private void m13418a(Map.Entry<FieldDescriptorType, Object> entry) {
        C4021b bVar = (C4021b) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof C4047q) {
            value = ((C4047q) value).mo28237a();
        }
        if (bVar.mo28178p()) {
            Object a = mo28168a(bVar);
            if (a == null) {
                a = new ArrayList();
            }
            for (Object a2 : (List) value) {
                ((List) a).add(m13416a(a2));
            }
            this.f10821a.put(bVar, a);
        } else if (bVar.mo28180r() == C4005f0.C4012c.MESSAGE) {
            Object a3 = mo28168a(bVar);
            if (a3 == null) {
                this.f10821a.put(bVar, m13416a(value));
                return;
            }
            this.f10821a.put(bVar, bVar.mo28177a(((C4054u) a3).toBuilder(), (C4054u) value).build());
        } else {
            this.f10821a.put(bVar, m13416a(value));
        }
    }
}
