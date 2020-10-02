package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.eg */
public enum C5001eg {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);
    

    /* renamed from: e */
    final int f13575e;

    /* renamed from: com.tapjoy.internal.eg$1 */
    static /* synthetic */ class C50021 {

        /* renamed from: a */
        static final /* synthetic */ int[] f13576a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.tapjoy.internal.eg[] r0 = com.tapjoy.internal.C5001eg.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13576a = r0
                com.tapjoy.internal.eg r1 = com.tapjoy.internal.C5001eg.VARINT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f13576a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tapjoy.internal.eg r1 = com.tapjoy.internal.C5001eg.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f13576a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tapjoy.internal.eg r1 = com.tapjoy.internal.C5001eg.FIXED64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f13576a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tapjoy.internal.eg r1 = com.tapjoy.internal.C5001eg.LENGTH_DELIMITED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5001eg.C50021.<clinit>():void");
        }
    }

    private C5001eg(int i) {
        this.f13575e = i;
    }

    /* renamed from: a */
    public final C5006ej mo31096a() {
        int i = C50021.f13576a[ordinal()];
        if (i == 1) {
            return C5006ej.f13590j;
        }
        if (i == 2) {
            return C5006ej.f13587g;
        }
        if (i == 3) {
            return C5006ej.f13592l;
        }
        if (i == 4) {
            return C5006ej.f13597q;
        }
        throw new AssertionError();
    }
}
