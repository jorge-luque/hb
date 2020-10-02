package p118io.presage.core;

import android.content.Context;

/* renamed from: io.presage.core.IlIlIllI */
public class IlIlIllI extends IIllllll {
    public IlIlIllI(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 13;
    }

    public Object IIIIIIll() {
        return IlIlIllI.class;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008e A[LOOP:2: B:22:0x0088->B:24:0x008e, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void IIIIIlIl() {
        /*
            r6 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            android.content.Context r1 = r6.IIIIIIlI
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ RuntimeException -> 0x003f, Exception -> 0x003c }
            if (r1 != 0) goto L_0x0013
            goto L_0x0044
        L_0x0013:
            android.content.Intent r3 = new android.content.Intent     // Catch:{ RuntimeException -> 0x003f, Exception -> 0x003c }
            java.lang.String r4 = "android.intent.action.MAIN"
            r3.<init>(r4)     // Catch:{ RuntimeException -> 0x003f, Exception -> 0x003c }
            java.lang.String r4 = "android.intent.category.LAUNCHER"
            android.content.Intent r3 = r3.addCategory(r4)     // Catch:{ RuntimeException -> 0x003f, Exception -> 0x003c }
            r4 = 128(0x80, float:1.794E-43)
            java.util.List r1 = r1.queryIntentActivities(r3, r4)     // Catch:{ RuntimeException -> 0x003f, Exception -> 0x003c }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ RuntimeException -> 0x003f, Exception -> 0x003c }
        L_0x002a:
            boolean r3 = r1.hasNext()     // Catch:{ RuntimeException -> 0x003f, Exception -> 0x003c }
            if (r3 == 0) goto L_0x0044
            java.lang.Object r3 = r1.next()     // Catch:{ RuntimeException -> 0x003f, Exception -> 0x003c }
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3     // Catch:{ RuntimeException -> 0x003f, Exception -> 0x003c }
            android.content.pm.ActivityInfo r3 = r3.activityInfo     // Catch:{ RuntimeException -> 0x003f, Exception -> 0x003c }
            r2.add(r3)     // Catch:{ RuntimeException -> 0x003f, Exception -> 0x003c }
            goto L_0x002a
        L_0x003c:
            r1 = move-exception
            r3 = 1
            goto L_0x0041
        L_0x003f:
            r1 = move-exception
            r3 = 0
        L_0x0041:
            p118io.presage.core.lIIIIlIl.IIIIIIII(r1, r3)
        L_0x0044:
            java.util.Iterator r1 = r2.iterator()
        L_0x0048:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x007b
            java.lang.Object r2 = r1.next()
            android.content.pm.ActivityInfo r2 = (android.content.pm.ActivityInfo) r2
            java.lang.String r3 = r2.packageName
            boolean r3 = r0.containsKey(r3)
            if (r3 == 0) goto L_0x006c
            java.lang.String r3 = r2.packageName
            java.lang.Object r3 = r0.get(r3)
            io.presage.core.IIlIIlll r3 = (p118io.presage.core.IIlIIlll) r3
            java.lang.String r2 = r2.name
            java.util.HashSet<java.lang.String> r3 = r3.IIIIIIIl
            r3.add(r2)
            goto L_0x0048
        L_0x006c:
            io.presage.core.IIlIIlll r3 = new io.presage.core.IIlIIlll
            java.lang.String r4 = r2.packageName
            java.lang.String r5 = r2.name
            r3.<init>(r4, r5)
            java.lang.String r2 = r2.packageName
            r0.put(r2, r3)
            goto L_0x0048
        L_0x007b:
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0088:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x009c
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r3 = r0.get(r3)
            r1.add(r3)
            goto L_0x0088
        L_0x009c:
            io.presage.core.IIlIlIII r0 = new io.presage.core.IIlIlIII
            long r2 = java.lang.System.currentTimeMillis()
            r0.<init>(r2, r1)
            r6.IIIIIIIl(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.IlIlIllI.IIIIIlIl():void");
    }

    public void IIIIIllI() {
    }
}
