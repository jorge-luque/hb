package p093e.p094a.p095a;

import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;

/* renamed from: e.a.a.b */
/* compiled from: ActivityKind */
public enum C3270b {
    UNKNOWN,
    SESSION,
    EVENT,
    CLICK,
    ATTRIBUTION,
    REVENUE,
    REATTRIBUTION,
    INFO,
    GDPR;

    /* renamed from: e.a.a.b$a */
    /* compiled from: ActivityKind */
    static /* synthetic */ class C3271a {

        /* renamed from: a */
        static final /* synthetic */ int[] f9103a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                e.a.a.b[] r0 = p093e.p094a.p095a.C3270b.m10869a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9103a = r0
                e.a.a.b r1 = p093e.p094a.p095a.C3270b.SESSION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9103a     // Catch:{ NoSuchFieldError -> 0x001d }
                e.a.a.b r1 = p093e.p094a.p095a.C3270b.EVENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9103a     // Catch:{ NoSuchFieldError -> 0x0028 }
                e.a.a.b r1 = p093e.p094a.p095a.C3270b.CLICK     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9103a     // Catch:{ NoSuchFieldError -> 0x0033 }
                e.a.a.b r1 = p093e.p094a.p095a.C3270b.ATTRIBUTION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f9103a     // Catch:{ NoSuchFieldError -> 0x003e }
                e.a.a.b r1 = p093e.p094a.p095a.C3270b.INFO     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f9103a     // Catch:{ NoSuchFieldError -> 0x0049 }
                e.a.a.b r1 = p093e.p094a.p095a.C3270b.GDPR     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p093e.p094a.p095a.C3270b.C3271a.<clinit>():void");
        }
    }

    /* renamed from: a */
    public static C3270b[] m10869a() {
        return (C3270b[]) f9102j.clone();
    }

    public String toString() {
        switch (C3271a.f9103a[ordinal()]) {
            case 1:
                return "session";
            case 2:
                return TapjoyConstants.TJC_SDK_TYPE_DEFAULT;
            case 3:
                return TJAdUnitConstants.String.CLICK;
            case 4:
                return "attribution";
            case 5:
                return TJAdUnitConstants.String.VIDEO_INFO;
            case 6:
                return "gdpr";
            default:
                return "unknown";
        }
    }
}
