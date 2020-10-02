package com.onesignal;

import com.onesignal.C4508g0;
import com.onesignal.C4523i1;
import com.onesignal.C4564n1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.onesignal.j1 */
/* compiled from: OSTriggerController */
class C4530j1 {

    /* renamed from: a */
    C4508g0 f12381a;

    /* renamed from: b */
    private final ConcurrentHashMap<String, Object> f12382b = new ConcurrentHashMap<>();

    /* renamed from: com.onesignal.j1$a */
    /* compiled from: OSTriggerController */
    static /* synthetic */ class C4531a {

        /* renamed from: a */
        static final /* synthetic */ int[] f12383a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.onesignal.i1$b[] r0 = com.onesignal.C4523i1.C4525b.m15566b()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12383a = r0
                com.onesignal.i1$b r1 = com.onesignal.C4523i1.C4525b.EQUAL_TO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12383a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.onesignal.i1$b r1 = com.onesignal.C4523i1.C4525b.NOT_EQUAL_TO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12383a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.onesignal.i1$b r1 = com.onesignal.C4523i1.C4525b.EXISTS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12383a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.onesignal.i1$b r1 = com.onesignal.C4523i1.C4525b.CONTAINS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f12383a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.onesignal.i1$b r1 = com.onesignal.C4523i1.C4525b.NOT_EXISTS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f12383a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.onesignal.i1$b r1 = com.onesignal.C4523i1.C4525b.LESS_THAN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f12383a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.onesignal.i1$b r1 = com.onesignal.C4523i1.C4525b.GREATER_THAN     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f12383a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.onesignal.i1$b r1 = com.onesignal.C4523i1.C4525b.LESS_THAN_OR_EQUAL_TO     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f12383a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.onesignal.i1$b r1 = com.onesignal.C4523i1.C4525b.GREATER_THAN_OR_EQUAL_TO     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4530j1.C4531a.<clinit>():void");
        }
    }

    C4530j1(C4508g0.C4511c cVar) {
        this.f12381a = new C4508g0(cVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo29804a(C4535k0 k0Var) {
        if (k0Var.f12394c.size() == 0) {
            return true;
        }
        Iterator<ArrayList<C4523i1>> it = k0Var.f12394c.iterator();
        while (it.hasNext()) {
            if (m15586a(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m15586a(ArrayList<C4523i1> arrayList) {
        Iterator<C4523i1> it = arrayList.iterator();
        while (it.hasNext()) {
            if (!m15581a(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m15581a(C4523i1 i1Var) {
        C4523i1.C4524a aVar = i1Var.f12353b;
        if (aVar == C4523i1.C4524a.UNKNOWN) {
            return false;
        }
        if (aVar != C4523i1.C4524a.CUSTOM) {
            return this.f12381a.mo29773a(i1Var);
        }
        C4523i1.C4525b bVar = i1Var.f12355d;
        Object obj = this.f12382b.get(i1Var.f12354c);
        if (obj == null) {
            if (bVar == C4523i1.C4525b.NOT_EXISTS) {
                return true;
            }
            if (bVar != C4523i1.C4525b.NOT_EQUAL_TO || i1Var.f12356e == null) {
                return false;
            }
            return true;
        } else if (bVar == C4523i1.C4525b.EXISTS) {
            return true;
        } else {
            if (bVar == C4523i1.C4525b.NOT_EXISTS) {
                return false;
            }
            if (bVar != C4523i1.C4525b.CONTAINS) {
                if (obj instanceof String) {
                    Object obj2 = i1Var.f12356e;
                    if ((obj2 instanceof String) && m15585a((String) obj2, (String) obj, bVar)) {
                        return true;
                    }
                }
                Object obj3 = i1Var.f12356e;
                if ((!(obj3 instanceof Number) || !(obj instanceof Number) || !m15582a((Number) obj3, (Number) obj, bVar)) && !m15584a(i1Var.f12356e, obj, bVar)) {
                    return false;
                }
                return true;
            } else if (!(obj instanceof Collection) || !((Collection) obj).contains(i1Var.f12356e)) {
                return false;
            } else {
                return true;
            }
        }
    }

    /* renamed from: a */
    private boolean m15585a(String str, String str2, C4523i1.C4525b bVar) {
        int i = C4531a.f12383a[bVar.ordinal()];
        if (i == 1) {
            return str.equals(str2);
        }
        if (i == 2) {
            return !str.equals(str2);
        }
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.ERROR;
        C4564n1.m15815b(a0Var, "Attempted to use an invalid operator for a string trigger comparison: " + bVar.toString());
        return false;
    }

    /* renamed from: a */
    private boolean m15584a(Object obj, Object obj2, C4523i1.C4525b bVar) {
        if (obj == null) {
            return false;
        }
        if (bVar.mo29787a()) {
            return m15585a(obj.toString(), obj2.toString(), bVar);
        }
        if (!(obj2 instanceof String) || !(obj instanceof Number)) {
            return false;
        }
        return m15583a((Number) obj, (String) obj2, bVar);
    }

    /* renamed from: a */
    private boolean m15583a(Number number, String str, C4523i1.C4525b bVar) {
        try {
            return m15582a((Number) Double.valueOf(number.doubleValue()), (Number) Double.valueOf(Double.parseDouble(str)), bVar);
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m15582a(Number number, Number number2, C4523i1.C4525b bVar) {
        double doubleValue = number.doubleValue();
        double doubleValue2 = number2.doubleValue();
        switch (C4531a.f12383a[bVar.ordinal()]) {
            case 1:
                if (doubleValue2 == doubleValue) {
                    return true;
                }
                return false;
            case 2:
                if (doubleValue2 != doubleValue) {
                    return true;
                }
                return false;
            case 3:
            case 4:
            case 5:
                C4564n1.C4566a0 a0Var = C4564n1.C4566a0.ERROR;
                C4564n1.m15815b(a0Var, "Attempted to use an invalid operator with a numeric value: " + bVar.toString());
                return false;
            case 6:
                return doubleValue2 < doubleValue;
            case 7:
                return doubleValue2 > doubleValue;
            case 8:
                return doubleValue2 < doubleValue || doubleValue2 == doubleValue;
            case 9:
                return doubleValue2 > doubleValue || doubleValue2 == doubleValue;
            default:
                return false;
        }
    }
}
