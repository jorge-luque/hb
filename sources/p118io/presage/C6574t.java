package p118io.presage;

import android.app.ActivityManager;
import android.content.Context;
import java.util.List;

/* renamed from: io.presage.t */
public final class C6574t {
    /* renamed from: a */
    public static boolean m21570a(Context context) {
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.importance == 100 && C6514hl.m21416a((Object) next.processName, (Object) packageName)) {
                    return false;
                }
            }
            return true;
        }
        throw new C6434em("null cannot be cast to non-null type android.app.ActivityManager");
    }
}
