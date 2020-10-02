package p118io.presage;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Process;

/* renamed from: io.presage.ag */
public final class C6216ag {
    /* renamed from: a */
    public static final boolean m20778a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
            String b = m20779b(context);
            String str = packageInfo.applicationInfo.processName;
            if (b == null) {
                return true;
            }
            return C6514hl.m21416a((Object) b, (Object) str);
        } catch (Exception unused) {
            return true;
        }
    }

    /* renamed from: b */
    private static final String m20779b(Context context) {
        int myPid = Process.myPid();
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) systemService).getRunningAppProcesses()) {
                if (next.pid == myPid) {
                    return next.processName;
                }
            }
            return null;
        }
        throw new C6434em("null cannot be cast to non-null type android.app.ActivityManager");
    }
}
