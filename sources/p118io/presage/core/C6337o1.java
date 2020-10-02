package p118io.presage.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* renamed from: io.presage.core.o1 */
public class C6337o1 {
    public static final String IIIIIIlI = lllllIII.IIIIIIII;
    public static final String IIIIIIll = lllllIII.IIIIIIIl;
    public static final String IIIIIlII = lllllIII.IIIIIIlI;
    public static final String IIIIIlIl = lllllIII.IIIIIIll;
    public static final String IIIIIllI = lllllIII.IIIIIlII;
    public static final String IIIIIlll = lllllIII.IIIIIlIl;
    public static final String IIIIlIII = lllllIII.IIIIIllI;
    public static final String IIIIlIIl = lllllIII.IIIIIlll;
    public IIIIIIlI IIIIIIII;
    public Context IIIIIIIl;

    /* renamed from: io.presage.core.o1$IIIIIIIl */
    public class IIIIIIIl extends IIlllIlI<Void, C6333n1> {
        public Exception IIIIIIIl;

        public /* synthetic */ IIIIIIIl(IIIIIIII iiiiiiii) {
        }

        public Object IIIIIIII(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            Thread.currentThread().getId();
            Thread.currentThread().getName();
            try {
                return C6337o1.this.IIIIIIIl();
            } catch (Exception e) {
                this.IIIIIIIl = e;
                return null;
            }
        }

        public void IIIIIIII(Object obj) {
            C6333n1 n1Var = (C6333n1) obj;
            Thread.currentThread().getId();
            Thread.currentThread().getName();
            if (n1Var != null) {
                String str = n1Var.IIIIIIII;
                n1Var.IIIIIIII();
                C6337o1 o1Var = C6337o1.this;
                IIIIIIlI iIIIIIlI = o1Var.IIIIIIII;
                if (iIIIIIlI != null) {
                    iIIIIIlI.IIIIIIII(o1Var, n1Var);
                    return;
                }
                return;
            }
            C6337o1 o1Var2 = C6337o1.this;
            C6337o1.IIIIIIII(o1Var2, o1Var2, this.IIIIIIIl, 1);
        }
    }

    /* renamed from: io.presage.core.o1$IIIIIIlI */
    public interface IIIIIIlI {
        void IIIIIIII(C6337o1 o1Var, C6333n1 n1Var);

        void IIIIIIII(C6337o1 o1Var, Exception exc, int i);
    }

    /* renamed from: io.presage.core.o1$IIIIIIll */
    public class IIIIIIll implements Comparator<ApplicationInfo> {
        public IIIIIIll(C6337o1 o1Var) {
        }

        public int compare(Object obj, Object obj2) {
            return ((ApplicationInfo) obj).packageName.compareTo(((ApplicationInfo) obj2).packageName);
        }
    }

    public C6337o1(Context context) {
        this.IIIIIIIl = context;
    }

    public static /* synthetic */ void IIIIIIII(C6337o1 o1Var, C6337o1 o1Var2, Exception exc, int i) {
        IIIIIIlI iIIIIIlI = o1Var.IIIIIIII;
        if (iIIIIIlI != null) {
            iIIIIIlI.IIIIIIII(o1Var2, exc, i);
        }
    }

    public final C6333n1 IIIIIIII() {
        try {
            ApplicationInfo IIIIIIlI2 = IIIIIIlI();
            return IIIIIIlI2 == null ? new C6333n1(IIIIlIIl, false, true) : new C6333n1(UUID.nameUUIDFromBytes(String.valueOf(this.IIIIIIIl.getPackageManager().getPackageInfo(IIIIIIlI2.packageName, OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).firstInstallTime).getBytes()).toString(), false, true);
        } catch (Exception unused) {
            return new C6333n1(IIIIlIIl, false, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0095, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        return IIIIIIII();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a5, code lost:
        r6.IIIIIIIl.getApplicationContext().unbindService(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ae, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0097 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final p118io.presage.core.C6333n1 IIIIIIIl() {
        /*
            r6 = this;
            java.lang.String r0 = android.os.Build.MODEL
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0048
            java.lang.String r3 = IIIIlIII
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x0048
            java.lang.String r0 = android.os.Build.MANUFACTURER
            if (r0 == 0) goto L_0x0048
            java.lang.String r3 = IIIIIlll
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x0048
            android.content.Context r0 = r6.IIIIIIIl     // Catch:{ SettingNotFoundException -> 0x0043 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x0043 }
            java.lang.String r3 = IIIIIlIl     // Catch:{ SettingNotFoundException -> 0x0043 }
            java.lang.String r0 = android.provider.Settings.Secure.getString(r0, r3)     // Catch:{ SettingNotFoundException -> 0x0043 }
            android.content.Context r3 = r6.IIIIIIIl     // Catch:{ SettingNotFoundException -> 0x0043 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x0043 }
            java.lang.String r4 = IIIIIllI     // Catch:{ SettingNotFoundException -> 0x0043 }
            int r3 = android.provider.Settings.Secure.getInt(r3, r4)     // Catch:{ SettingNotFoundException -> 0x0043 }
            if (r3 != r1) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r1 = 0
        L_0x0036:
            if (r0 != 0) goto L_0x003d
            io.presage.core.n1 r0 = r6.IIIIIIII()
            return r0
        L_0x003d:
            io.presage.core.n1 r3 = new io.presage.core.n1
            r3.<init>(r0, r1, r2)
            return r3
        L_0x0043:
            io.presage.core.n1 r0 = r6.IIIIIIII()
            return r0
        L_0x0048:
            android.content.Context r0 = r6.IIIIIIIl     // Catch:{ NameNotFoundException -> 0x0055 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0055 }
            java.lang.String r3 = IIIIIIlI     // Catch:{ NameNotFoundException -> 0x0055 }
            r0.getPackageInfo(r3, r2)     // Catch:{ NameNotFoundException -> 0x0055 }
            r0 = 1
            goto L_0x0056
        L_0x0055:
            r0 = 0
        L_0x0056:
            if (r0 == 0) goto L_0x00af
            io.presage.core.p1 r0 = new io.presage.core.p1
            r0.<init>()
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = IIIIIIll
            r3.<init>(r4)
            java.lang.String r4 = IIIIIlII
            r3.setPackage(r4)
            android.content.Context r4 = r6.IIIIIIIl
            android.content.Context r4 = r4.getApplicationContext()
            boolean r3 = r4.bindService(r3, r0, r1)
            if (r3 == 0) goto L_0x00af
            io.presage.core.m1 r3 = new io.presage.core.m1     // Catch:{ RemoteException | InterruptedException -> 0x0097 }
            android.os.IBinder r4 = r0.IIIIIIII()     // Catch:{ RemoteException | InterruptedException -> 0x0097 }
            r3.<init>(r4)     // Catch:{ RemoteException | InterruptedException -> 0x0097 }
            io.presage.core.n1 r4 = new io.presage.core.n1     // Catch:{ RemoteException | InterruptedException -> 0x0097 }
            java.lang.String r5 = r3.IIIIIIII()     // Catch:{ RemoteException | InterruptedException -> 0x0097 }
            boolean r1 = r3.IIIIIIII(r1)     // Catch:{ RemoteException | InterruptedException -> 0x0097 }
            r4.<init>(r5, r1, r2)     // Catch:{ RemoteException | InterruptedException -> 0x0097 }
            android.content.Context r1 = r6.IIIIIIIl
            android.content.Context r1 = r1.getApplicationContext()
            r1.unbindService(r0)
            return r4
        L_0x0095:
            r1 = move-exception
            goto L_0x00a5
        L_0x0097:
            io.presage.core.n1 r1 = r6.IIIIIIII()     // Catch:{ all -> 0x0095 }
            android.content.Context r2 = r6.IIIIIIIl
            android.content.Context r2 = r2.getApplicationContext()
            r2.unbindService(r0)
            return r1
        L_0x00a5:
            android.content.Context r2 = r6.IIIIIIIl
            android.content.Context r2 = r2.getApplicationContext()
            r2.unbindService(r0)
            throw r1
        L_0x00af:
            io.presage.core.n1 r0 = r6.IIIIIIII()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.core.C6337o1.IIIIIIIl():io.presage.core.n1");
    }

    public final ApplicationInfo IIIIIIlI() {
        PackageManager packageManager = this.IIIIIIIl.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
        if (installedApplications.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ApplicationInfo next : installedApplications) {
            if (!((next.flags & 1) == 0 || next.packageName == null)) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Collections.sort(arrayList, new IIIIIIll(this));
        return (ApplicationInfo) arrayList.get(0);
    }

    public void IIIIIIII(IIllllII iIllllII, boolean z, IIIIIIlI iIIIIIlI) {
        if (iIIIIIlI != null) {
            this.IIIIIIII = iIIIIIlI;
            try {
                new IIIIIIIl((IIIIIIII) null).IIIIIIII(iIllllII, z, new Void[0]);
            } catch (IIlllIII e) {
                IIIIIIlI iIIIIIlI2 = this.IIIIIIII;
                if (iIIIIIlI2 != null) {
                    iIIIIIlI2.IIIIIIII(this, e, 0);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
