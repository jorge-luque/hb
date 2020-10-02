package p118io.presage;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;

/* renamed from: io.presage.Maroilles */
public final class Maroilles {

    /* renamed from: a */
    public static final Maroilles f16566a = new Maroilles();

    private Maroilles() {
    }

    /* renamed from: a */
    public static void m20471a(Context context) {
        if (!m20477b(context)) {
            if (!C6214ae.m20773a(context, "android.permission.INTERNET")) {
                C6578x xVar = C6578x.f17137a;
                C6578x.m21579a("No internet permission");
            }
            m20478c(context);
        }
    }

    /* renamed from: b */
    private static boolean m20477b(Context context) {
        return (context.getApplicationInfo().flags & 2) == 0;
    }

    /* renamed from: c */
    private static void m20478c(Context context) {
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
        PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
        PackageInfo packageInfo3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 2);
        C6514hl.m21414a((Object) packageInfo, "activitiesInfo");
        m20479c(packageInfo);
        C6514hl.m21414a((Object) packageInfo2, "servicesInfo");
        m20475b(packageInfo2);
        C6514hl.m21414a((Object) packageInfo3, "receiversInfo");
        m20472a(packageInfo3);
    }

    /* renamed from: b */
    private static void m20475b(PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            m20474a(serviceInfoArr, "io.presage.common.profig.schedule.ProfigSyncIntentService");
            m20474a(serviceInfoArr, "io.presage.common.profig.schedule.ProfigJobService");
        }
    }

    /* renamed from: a */
    private static void m20472a(PackageInfo packageInfo) {
        ActivityInfo[] activityInfoArr = packageInfo.receivers;
        if (activityInfoArr != null) {
            m20473a(activityInfoArr, "io.presage.common.profig.schedule.ProfigAlarmReceiver");
        }
    }

    /* renamed from: b */
    private static void m20476b(ActivityInfo[] activityInfoArr, String str) {
        int length = activityInfoArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (C6514hl.m21416a((Object) activityInfoArr[i].name, (Object) str)) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            C6578x xVar = C6578x.f17137a;
            C6578x.m21579a("Missing activity: ".concat(String.valueOf(str)));
        }
    }

    /* renamed from: a */
    private static void m20473a(ActivityInfo[] activityInfoArr, String str) {
        int length = activityInfoArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (C6514hl.m21416a((Object) activityInfoArr[i].name, (Object) str)) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            C6578x xVar = C6578x.f17137a;
            C6578x.m21579a("Missing receiver: ".concat(String.valueOf(str)));
        }
    }

    /* renamed from: c */
    private static void m20479c(PackageInfo packageInfo) {
        ActivityInfo[] activityInfoArr = packageInfo.activities;
        if (activityInfoArr != null) {
            m20476b(activityInfoArr, "io.presage.interstitial.ui.InterstitialActivity");
            m20476b(activityInfoArr, "io.presage.interstitial.ui.InterstitialAndroid8TransparentActivity");
            m20476b(activityInfoArr, "io.presage.interstitial.ui.InterstitialAndroid8RotableActivity");
        }
    }

    /* renamed from: a */
    private static void m20474a(ServiceInfo[] serviceInfoArr, String str) {
        int length = serviceInfoArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (C6514hl.m21416a((Object) serviceInfoArr[i].name, (Object) str)) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            C6578x xVar = C6578x.f17137a;
            C6578x.m21579a("Missing service: ".concat(String.valueOf(str)));
        }
    }
}
