package p118io.presage.core;

import android.content.Context;

/* renamed from: io.presage.core.IlIlIIlI */
public class IlIlIIlI extends IIllllll {
    public static final String IIIIlllI = C6315j.IIIIIIIl;
    public static final String IIIIllll = C6315j.IIIIIIlI;
    public static final String IIIlIIII = C6315j.IIIIIIll;
    public static final String IIIlIIIl = C6315j.IIIIIlII;
    public static final String IIIlIIlI = C6315j.IIIIIlIl;
    public static final String IIIlIIll = C6315j.IIIIIllI;
    public static final String IIIlIlII = C6315j.IIIIIlll;
    public static final String IIIlIlIl = C6315j.IIIIlIII;
    public static final String IIIlIllI = C6315j.IIIIIIII;
    public static final String IIIlIlll = C6315j.IIIIlIIl;

    public IlIlIIlI(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 21;
    }

    public final String IIIIIIIl(String str) {
        return new C6377y1().IIIIIIII(1).IIIIIIII(IIIlIlll.getBytes(), 0).IIIIIIII(str);
    }

    public Object IIIIIIll() {
        return IlIlIIlI.class;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0171 A[Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }] */
    @android.annotation.SuppressLint({"MissingPermission", "HardwareIds"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void IIIIIlIl() {
        /*
            r11 = this;
            android.content.Context r0 = r11.IIIIIIlI
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            java.lang.String r1 = IIIlIllI
            android.content.Context r2 = r11.IIIIIIlI
            java.lang.String r2 = r2.getPackageName()
            int r0 = r0.checkPermission(r1, r2)
            if (r0 != 0) goto L_0x0182
            android.content.Context r0 = r11.IIIIIIlI     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Class r0 = r0.getClass()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r1 = IIIlIlII     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            r5 = 0
            r3[r5] = r4     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r3)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            android.content.Context r1 = r11.IIIIIIlI     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r4 = IIIIlllI     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r3[r5] = r4     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Object r0 = r0.invoke(r1, r3)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            if (r0 != 0) goto L_0x003a
            r11.IIIIlIII()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            return
        L_0x003a:
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r1.<init>()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r4 = 23
            java.lang.String r6 = ""
            if (r3 < r4) goto L_0x012a
            java.lang.Class r3 = r0.getClass()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r4 = IIIlIIll     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r7)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Object r3 = r3.invoke(r0, r4)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            int r3 = r3.intValue()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            if (r3 == 0) goto L_0x0124
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r6 = 26
            if (r4 < r6) goto L_0x00d2
            java.lang.Class r4 = r0.getClass()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r6 = IIIIllll     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r7[r5] = r8     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.reflect.Method r4 = r4.getMethod(r6, r7)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Class r6 = r0.getClass()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r7 = IIIlIIII     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Class[] r8 = new java.lang.Class[r2]     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r8[r5] = r9     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.reflect.Method r6 = r6.getMethod(r7, r8)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r7 = 0
        L_0x0088:
            if (r7 >= r3) goto L_0x016b
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r8[r5] = r9     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Object r8 = r4.invoke(r0, r8)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            if (r8 == 0) goto L_0x00ac
            boolean r9 = r8.isEmpty()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            if (r9 != 0) goto L_0x00ac
            io.presage.core.IIlIIIIl r9 = new io.presage.core.IIlIIIIl     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r8 = r11.IIIIIIIl(r8)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r9.<init>(r8, r2)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r1.add(r9)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
        L_0x00ac:
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r8[r5] = r9     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Object r8 = r6.invoke(r0, r8)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            if (r8 == 0) goto L_0x00cf
            boolean r9 = r8.isEmpty()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            if (r9 != 0) goto L_0x00cf
            io.presage.core.IIlIIIIl r9 = new io.presage.core.IIlIIIIl     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r8 = r11.IIIIIIIl(r8)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r10 = 2
            r9.<init>(r8, r10)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r1.add(r9)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
        L_0x00cf:
            int r7 = r7 + 1
            goto L_0x0088
        L_0x00d2:
            java.lang.Class r4 = r0.getClass()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r6 = IIIlIlIl     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r7[r5] = r8     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.reflect.Method r4 = r4.getMethod(r6, r7)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Class r6 = r0.getClass()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r7 = IIIlIIIl     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Class[] r8 = new java.lang.Class[r2]     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r8[r5] = r9     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.reflect.Method r6 = r6.getMethod(r7, r8)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r7 = 0
        L_0x00f3:
            if (r7 >= r3) goto L_0x016b
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r8[r5] = r9     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Object r8 = r6.invoke(r0, r8)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            int r8 = r8.intValue()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r9[r5] = r10     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Object r9 = r4.invoke(r0, r9)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            io.presage.core.IIlIIIIl r10 = new io.presage.core.IIlIIIIl     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r9 = r11.IIIIIIIl(r9)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r10.<init>(r9, r8)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r1.add(r10)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            int r7 = r7 + 1
            goto L_0x00f3
        L_0x0124:
            io.presage.core.IIlIIIIl r0 = new io.presage.core.IIlIIIIl     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r0.<init>(r6, r5)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            goto L_0x0168
        L_0x012a:
            java.lang.Class r2 = r0.getClass()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r3 = IIIlIlIl     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Class[] r4 = new java.lang.Class[r5]     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Class r3 = r0.getClass()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r4 = IIIlIIlI     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r7)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Object r3 = r3.invoke(r0, r4)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            int r3 = r3.intValue()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            if (r3 == 0) goto L_0x0163
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.Object r0 = r2.invoke(r0, r4)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            io.presage.core.IIlIIIIl r2 = new io.presage.core.IIlIIIIl     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            java.lang.String r0 = r11.IIIIIIIl(r0)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r2.<init>(r0, r3)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r0 = r2
            goto L_0x0168
        L_0x0163:
            io.presage.core.IIlIIIIl r0 = new io.presage.core.IIlIIIIl     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r0.<init>(r6, r3)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
        L_0x0168:
            r1.add(r0)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
        L_0x016b:
            boolean r0 = r1.isEmpty()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            if (r0 != 0) goto L_0x0182
            io.presage.core.IIlIIIlI r0 = new io.presage.core.IIlIIIlI     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            long r2 = p118io.presage.core.C6325l1.IIIIIIII()     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r0.<init>(r2, r1)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            r11.IIIIIIII((p118io.presage.core.IIIlIIlI) r0)     // Catch:{ IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException -> 0x0182, Exception -> 0x017e }
            goto L_0x0182
        L_0x017e:
            r0 = move-exception
            r11.IIIIIIII((java.lang.Exception) r0)
        L_0x0182:
            r11.IIIIlIII()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.IlIlIIlI.IIIIIlIl():void");
    }

    public void IIIIIllI() {
    }
}
