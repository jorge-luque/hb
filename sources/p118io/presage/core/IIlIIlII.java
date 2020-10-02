package p118io.presage.core;

import android.content.pm.PackageInfo;
import android.os.Build;

/* renamed from: io.presage.core.IIlIIlII */
public class IIlIIlII {
    public String IIIIIIII;
    public int IIIIIIIl;
    public long IIIIIIlI;
    public long IIIIIIll;
    public boolean IIIIIlII;
    public boolean IIIIIlIl;
    public String IIIIIllI;
    public long IIIIIlll;

    public IIlIIlII(PackageInfo packageInfo, boolean z, boolean z2) {
        this.IIIIIIII = packageInfo.packageName;
        this.IIIIIIIl = packageInfo.applicationInfo.uid;
        this.IIIIIIlI = packageInfo.firstInstallTime;
        this.IIIIIIll = packageInfo.lastUpdateTime;
        this.IIIIIlII = z;
        this.IIIIIlIl = z2;
        String str = packageInfo.versionName;
        this.IIIIIllI = str == null ? "" : str;
        this.IIIIIlll = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : Integer.valueOf(packageInfo.versionCode).longValue();
    }

    public IIlIIlII(String str, int i, long j, long j2, boolean z, boolean z2, String str2, long j3) {
        this.IIIIIIII = str;
        this.IIIIIIIl = i;
        this.IIIIIIlI = j;
        this.IIIIIIll = j2;
        this.IIIIIlII = z;
        this.IIIIIlIl = z2;
        this.IIIIIllI = str2;
        this.IIIIIlll = j3;
    }
}
