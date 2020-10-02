package p118io.presage.core;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@TargetApi(14)
/* renamed from: io.presage.core.b2 */
public final class C6286b2 {
    public static final String[] IIIIIlII = {C6331n.IIIIIIII, C6331n.IIIIIIIl, C6331n.IIIIIIlI, C6331n.IIIIIIll, C6331n.IIIIIlII, C6331n.IIIIIlIl, C6331n.IIIIIllI, C6331n.IIIIIlll, C6331n.IIIIlIII, C6331n.IIIIlIIl, C6331n.IIIIlIlI, C6331n.IIIIlIll, C6331n.IIIIllII, C6331n.IIIIllIl, C6331n.IIIIlllI, C6331n.IIIIllll};
    public static final String[] IIIIIlIl = {C6331n.IIIlIIII, C6331n.IIIlIIIl, C6331n.IIIlIIlI};
    public static final String[] IIIIIllI = {C6331n.IIIlIIll};
    public static final String[] IIIIIlll = {C6331n.IIIlIlII, C6331n.IIIlIlIl};
    public static final String[] IIIIlIII = {C6331n.IIIlIllI};
    public static final String[] IIIIlIIl = {C6331n.IIIlIlll, C6331n.IIIllIII};
    public static final String[] IIIIlIlI = {C6331n.IIIllIIl, C6331n.IIIllIlI, C6331n.IIIllIll, C6331n.IIIlllII, C6331n.IIIlllIl, C6331n.IIIllllI, C6331n.IIIlllll, C6331n.IIlIIIII};
    public static final String[] IIIIlIll = {C6331n.IIlIIIIl, C6331n.IIlIIIlI};
    public static final String[] IIIIllII = {C6331n.IIlIIIll, C6331n.IIlIIlII, C6331n.IIlIIlIl};
    public static final String IIIIllIl = C6331n.IIlllIIl;
    public static final String IIIIlllI = C6331n.IIlllIlI;
    public static final String IIIIllll = C6331n.IIlllIll;
    public static final String IIIlIIII = C6331n.IIllllII;
    public static final String IIIlIIIl = C6331n.IIllllIl;
    public static final C6294d2[] IIIlIIlI = {new C6294d2(C6331n.IIlIIllI, (String) null), new C6294d2(C6331n.IIlIIlll, (String) null), new C6294d2(C6331n.IIlIlIII, (String) null), new C6294d2(C6331n.IIlIlIIl, (String) null), new C6294d2(C6331n.IIlIlIlI, (String) null), new C6294d2(C6331n.IIlIlIll, IIIIllIl), new C6294d2(C6331n.IIlIllII, IIIIllIl), new C6294d2(C6331n.IIlIllIl, IIIIlllI), new C6294d2(C6331n.IIlIlllI, (String) null), new C6294d2(C6331n.IIlIllll, (String) null), new C6294d2(C6331n.IIllIIII, IIIlIIIl), new C6294d2(C6331n.IIllIIIl, IIIIllll), new C6294d2(C6331n.IIllIIlI, IIIlIIII), new C6294d2(C6331n.IIllIIll, IIIlIIII), new C6294d2(C6331n.IIllIlII, (String) null)};
    public static final String IIIlIIll = C6331n.IIllIlIl;
    public static final String IIIlIlII = C6331n.IIllIllI;
    public static final String IIIlIlIl = C6331n.IIllIlll;
    public static final String IIIlIllI = C6331n.IIlllIII;
    public static final String IIIlIlll = C6331n.IIlllllI;
    public static final String IIIllIII = C6331n.IIllllll;
    public static final String IIIllIIl = C6331n.IlIIIIII;
    public static final String IIIllIlI = C6331n.IlIIIIIl;
    public static final String IIIllIll = C6331n.IlIIIIlI;
    public static final String IIIlllII = C6331n.IlIIIIll;
    public static final String IIIlllIl = C6331n.IlIIIlII;
    public static final String IIIllllI = C6331n.IlIIIlIl;
    public static final String IIIlllll = C6331n.IlIIIllI;
    public static final String IIlIIIII = C6331n.IlIIIlll;
    public static final String IIlIIIIl = C6331n.IlIIlIII;
    public static final String IIlIIIlI = C6331n.IlIIlIIl;
    public static final String IIlIIIll = C6331n.IlIIlIlI;
    public static final String IIlIIlII = C6331n.IlIIlIll;
    public static final String IIlIIlIl = C6331n.IlIIllII;
    public static final String IIlIIllI = C6331n.IlIIllIl;
    public static final String IIlIIlll = C6331n.IlIIlllI;
    public static final String IIlIlIII = C6331n.IlIIllll;
    public static final String IIlIlIIl = C6331n.IlIlIIII;
    public static final String IIlIlIlI = C6331n.IlIlIIIl;
    public static final String IIlIlIll = C6331n.IlIlIIlI;
    public static final String IIlIllII = C6331n.IlIlIIll;
    @SuppressLint({"StaticFieldLeak"})
    public static C6286b2 IIlIllIl;
    public final Context IIIIIIII;
    public boolean IIIIIIIl = false;
    public boolean IIIIIIlI = true;
    public List<String> IIIIIIll;

    public C6286b2(Context context) {
        ArrayList arrayList = new ArrayList();
        this.IIIIIIll = arrayList;
        this.IIIIIIII = context;
        arrayList.add(IIIlIlII);
        this.IIIIIIll.add(IIIlIlIl);
        this.IIIIIIll.add(IIIlIllI);
    }

    public static C6286b2 IIIIIIII(Context context) {
        if (context != null) {
            if (IIlIllIl == null) {
                IIlIllIl = new C6286b2(context.getApplicationContext());
            }
            return IIlIllIl;
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    public final boolean IIIIIIII() {
        boolean z = false;
        boolean z2 = Build.FINGERPRINT.startsWith(IIIIllll) || Build.MODEL.contains(IIIllIII) || Build.MODEL.toLowerCase().contains(IIIllIIl) || Build.MODEL.contains(IIIllIlI) || Build.MODEL.contains(IIIllIll) || Build.MANUFACTURER.contains(IIIlllII) || Build.HARDWARE.equals(IIIIlllI) || Build.HARDWARE.equals(IIIlllIl) || Build.PRODUCT.equals(IIIlIIII) || Build.PRODUCT.equals(IIIllIII) || Build.PRODUCT.equals(IIIllllI) || Build.PRODUCT.equals(IIIlllll) || Build.BOARD.toLowerCase().contains(IIIlIlll) || Build.BOOTLOADER.toLowerCase().contains(IIIlIlll) || Build.HARDWARE.toLowerCase().contains(IIIlIlll) || Build.PRODUCT.toLowerCase().contains(IIIlIlll) || Build.SERIAL.toLowerCase().contains(IIIlIlll);
        if (z2) {
            return true;
        }
        if (Build.BRAND.startsWith(IIIIllll) && Build.DEVICE.startsWith(IIIIllll)) {
            z = true;
        }
        boolean z3 = z2 | z;
        if (z3) {
            return true;
        }
        return z3 | IIIllIII.equals(Build.PRODUCT);
    }

    public final boolean IIIIIIII(String[] strArr, String str) {
        for (String file : strArr) {
            if (new File(file).exists()) {
                return true;
            }
        }
        return false;
    }

    public final boolean IIIIIIIl() {
        if (!IIIIlIll.IIIIIIII(this.IIIIIIII, "android.permission.INTERNET")) {
            return false;
        }
        String[] strArr = {IIlIIllI};
        StringBuilder sb = new StringBuilder();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(strArr);
            processBuilder.directory(new File(IIlIIlll));
            processBuilder.redirectErrorStream(true);
            InputStream inputStream = processBuilder.start().getInputStream();
            byte[] bArr = new byte[OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS];
            while (inputStream.read(bArr) != -1) {
                sb.append(new String(bArr));
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return false;
        }
        for (String str : sb2.split("\n")) {
            if ((str.contains(IIlIlIII) || str.contains(IIlIlIIl) || str.contains(IIlIlIlI)) && str.contains(IIIlIIll)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c5, code lost:
        if (((android.telephony.TelephonyManager) r12.IIIIIIII.getSystemService(com.facebook.places.model.PlaceFields.PHONE)).getNetworkOperatorName().equalsIgnoreCase("android") == false) goto L_0x00c9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x013f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x019f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean IIIIIIlI() {
        /*
            r12 = this;
            boolean r0 = r12.IIIIIIII()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x01b0
            android.content.Context r0 = r12.IIIIIIII
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            boolean r0 = p118io.presage.core.IIIIlIll.IIIIIIII((android.content.Context) r0, (java.lang.String) r3)
            if (r0 == 0) goto L_0x00c9
            boolean r0 = r12.IIIIIIIl
            if (r0 == 0) goto L_0x00c9
            boolean r0 = r12.IIIIIIll()
            if (r0 == 0) goto L_0x00c9
            android.content.Context r0 = r12.IIIIIIII
            boolean r0 = p118io.presage.core.IIIIlIll.IIIIIIII((android.content.Context) r0, (java.lang.String) r3)
            java.lang.String r4 = "phone"
            if (r0 != 0) goto L_0x003b
            android.content.Context r0 = r12.IIIIIIII
            java.lang.String r5 = "android.permission.READ_SMS"
            boolean r0 = p118io.presage.core.IIIIlIll.IIIIIIII((android.content.Context) r0, (java.lang.String) r5)
            if (r0 != 0) goto L_0x003b
            android.content.Context r0 = r12.IIIIIIII
            java.lang.String r5 = "android.permission.READ_PHONE_NUMBERS"
            boolean r0 = p118io.presage.core.IIIIlIll.IIIIIIII((android.content.Context) r0, (java.lang.String) r5)
            if (r0 != 0) goto L_0x003b
            goto L_0x0055
        L_0x003b:
            android.content.Context r0 = r12.IIIIIIII
            java.lang.Object r0 = r0.getSystemService(r4)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r0 = r0.getLine1Number()
            java.lang.String[] r5 = IIIIIlII
            int r6 = r5.length
            r7 = 0
        L_0x004b:
            if (r7 >= r6) goto L_0x005a
            r8 = r5[r7]
            boolean r8 = r8.equalsIgnoreCase(r0)
            if (r8 == 0) goto L_0x0057
        L_0x0055:
            r0 = 1
            goto L_0x005b
        L_0x0057:
            int r7 = r7 + 1
            goto L_0x004b
        L_0x005a:
            r0 = 0
        L_0x005b:
            if (r0 != 0) goto L_0x00c7
            android.content.Context r0 = r12.IIIIIIII
            boolean r0 = p118io.presage.core.IIIIlIll.IIIIIIII((android.content.Context) r0, (java.lang.String) r3)
            if (r0 != 0) goto L_0x0066
            goto L_0x0080
        L_0x0066:
            android.content.Context r0 = r12.IIIIIIII
            java.lang.Object r0 = r0.getSystemService(r4)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r0 = r0.getDeviceId()
            java.lang.String[] r5 = IIIIIlIl
            int r6 = r5.length
            r7 = 0
        L_0x0076:
            if (r7 >= r6) goto L_0x0085
            r8 = r5[r7]
            boolean r8 = r8.equalsIgnoreCase(r0)
            if (r8 == 0) goto L_0x0082
        L_0x0080:
            r0 = 1
            goto L_0x0086
        L_0x0082:
            int r7 = r7 + 1
            goto L_0x0076
        L_0x0085:
            r0 = 0
        L_0x0086:
            if (r0 != 0) goto L_0x00c7
            android.content.Context r0 = r12.IIIIIIII
            boolean r0 = p118io.presage.core.IIIIlIll.IIIIIIII((android.content.Context) r0, (java.lang.String) r3)
            if (r0 != 0) goto L_0x0091
            goto L_0x00ab
        L_0x0091:
            android.content.Context r0 = r12.IIIIIIII
            java.lang.Object r0 = r0.getSystemService(r4)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r0 = r0.getSubscriberId()
            java.lang.String[] r3 = IIIIIllI
            int r5 = r3.length
            r6 = 0
        L_0x00a1:
            if (r6 >= r5) goto L_0x00b0
            r7 = r3[r6]
            boolean r7 = r7.equalsIgnoreCase(r0)
            if (r7 == 0) goto L_0x00ad
        L_0x00ab:
            r0 = 1
            goto L_0x00b1
        L_0x00ad:
            int r6 = r6 + 1
            goto L_0x00a1
        L_0x00b0:
            r0 = 0
        L_0x00b1:
            if (r0 != 0) goto L_0x00c7
            android.content.Context r0 = r12.IIIIIIII
            java.lang.Object r0 = r0.getSystemService(r4)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r0 = r0.getNetworkOperatorName()
            java.lang.String r3 = "android"
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x00c9
        L_0x00c7:
            r0 = 1
            goto L_0x00ca
        L_0x00c9:
            r0 = 0
        L_0x00ca:
            if (r0 != 0) goto L_0x01af
            java.lang.String[] r0 = IIIIIlll
            java.lang.String r3 = IIlIIIII
            boolean r0 = r12.IIIIIIII(r0, r3)
            if (r0 != 0) goto L_0x01af
            java.lang.String[] r0 = IIIIlIll
            java.lang.String r3 = IIlIIIIl
            boolean r0 = r12.IIIIIIII(r0, r3)
            if (r0 != 0) goto L_0x01af
            java.lang.String[] r0 = IIIIllII
            java.lang.String r3 = IIIlIlll
            boolean r0 = r12.IIIIIIII(r0, r3)
            if (r0 != 0) goto L_0x01af
            r0 = 2
            java.io.File[] r3 = new java.io.File[r0]
            java.io.File r4 = new java.io.File
            java.lang.String r5 = IIlIIlII
            r4.<init>(r5)
            r3[r1] = r4
            java.io.File r4 = new java.io.File
            java.lang.String r5 = IIlIIlIl
            r4.<init>(r5)
            r3[r2] = r4
            r4 = 0
        L_0x0100:
            if (r4 >= r0) goto L_0x013f
            r5 = r3[r4]
            boolean r6 = r5.exists()
            if (r6 == 0) goto L_0x013c
            boolean r6 = r5.canRead()
            if (r6 == 0) goto L_0x013c
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0120 }
            r7.<init>(r5)     // Catch:{ Exception -> 0x0120 }
            r7.read(r6)     // Catch:{ Exception -> 0x0120 }
            r7.close()     // Catch:{ Exception -> 0x0120 }
            goto L_0x0124
        L_0x0120:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0124:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r6)
            java.lang.String[] r6 = IIIIlIII
            int r7 = r6.length
            r8 = 0
        L_0x012d:
            if (r8 >= r7) goto L_0x013c
            r9 = r6[r8]
            boolean r9 = r5.contains(r9)
            if (r9 == 0) goto L_0x0139
            r0 = 1
            goto L_0x0140
        L_0x0139:
            int r8 = r8 + 1
            goto L_0x012d
        L_0x013c:
            int r4 = r4 + 1
            goto L_0x0100
        L_0x013f:
            r0 = 0
        L_0x0140:
            if (r0 != 0) goto L_0x01af
            java.lang.String[] r0 = IIIIlIIl
            java.lang.String r3 = IIlIIIlI
            boolean r0 = r12.IIIIIIII(r0, r3)
            if (r0 != 0) goto L_0x01af
            boolean r0 = r12.IIIIIIIl()
            if (r0 != 0) goto L_0x01af
            io.presage.core.d2[] r0 = IIIlIIlI
            int r3 = r0.length
            r4 = 0
            r5 = 0
        L_0x0157:
            if (r4 >= r3) goto L_0x019a
            r6 = r0[r4]
            android.content.Context r7 = r12.IIIIIIII
            java.lang.String r8 = r6.IIIIIIII
            java.lang.ClassLoader r7 = r7.getClassLoader()     // Catch:{ Exception -> 0x0180 }
            java.lang.String r9 = IIlIlIll     // Catch:{ Exception -> 0x0180 }
            java.lang.Class r7 = r7.loadClass(r9)     // Catch:{ Exception -> 0x0180 }
            java.lang.String r9 = IIlIllII     // Catch:{ Exception -> 0x0180 }
            java.lang.Class[] r10 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0180 }
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            r10[r1] = r11     // Catch:{ Exception -> 0x0180 }
            java.lang.reflect.Method r9 = r7.getMethod(r9, r10)     // Catch:{ Exception -> 0x0180 }
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0180 }
            r10[r1] = r8     // Catch:{ Exception -> 0x0180 }
            java.lang.Object r7 = r9.invoke(r7, r10)     // Catch:{ Exception -> 0x0180 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0180 }
            goto L_0x0181
        L_0x0180:
            r7 = 0
        L_0x0181:
            java.lang.String r8 = r6.IIIIIIIl
            if (r8 != 0) goto L_0x0189
            if (r7 == 0) goto L_0x0189
            int r5 = r5 + 1
        L_0x0189:
            java.lang.String r6 = r6.IIIIIIIl
            if (r6 == 0) goto L_0x0197
            if (r7 == 0) goto L_0x0197
            boolean r6 = r7.contains(r6)
            if (r6 == 0) goto L_0x0197
            int r5 = r5 + 1
        L_0x0197:
            int r4 = r4 + 1
            goto L_0x0157
        L_0x019a:
            r0 = 5
            if (r5 < r0) goto L_0x019f
            r0 = 1
            goto L_0x01a0
        L_0x019f:
            r0 = 0
        L_0x01a0:
            if (r0 == 0) goto L_0x01ad
            java.lang.String[] r0 = IIIIlIlI
            java.lang.String r3 = IIlIIIll
            boolean r0 = r12.IIIIIIII(r0, r3)
            if (r0 == 0) goto L_0x01ad
            goto L_0x01af
        L_0x01ad:
            r0 = 0
            goto L_0x01b0
        L_0x01af:
            r0 = 1
        L_0x01b0:
            if (r0 != 0) goto L_0x01eb
            boolean r0 = r12.IIIIIIlI
            if (r0 == 0) goto L_0x01ea
            java.util.List<java.lang.String> r0 = r12.IIIIIIll
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x01bf
            goto L_0x01ea
        L_0x01bf:
            android.content.Context r0 = r12.IIIIIIII
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            java.util.List<java.lang.String> r3 = r12.IIIIIIll
            java.util.Iterator r3 = r3.iterator()
        L_0x01cb:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x01ea
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            android.content.Intent r4 = r0.getLaunchIntentForPackage(r4)
            if (r4 == 0) goto L_0x01cb
            r5 = 65536(0x10000, float:9.18355E-41)
            java.util.List r4 = r0.queryIntentActivities(r4, r5)
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x01cb
            r1 = 1
        L_0x01ea:
            r0 = r1
        L_0x01eb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.C6286b2.IIIIIIlI():boolean");
    }

    public final boolean IIIIIIll() {
        return this.IIIIIIII.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }
}
