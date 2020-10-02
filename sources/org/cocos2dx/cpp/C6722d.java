package org.cocos2dx.cpp;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.core.app.C0725i;
import com.masomo.headball2.C6871R$drawable;
import com.masomo.headball2.C6876R$mipmap;

/* renamed from: org.cocos2dx.cpp.d */
/* compiled from: NotificationHandler */
public class C6722d {

    /* renamed from: a */
    private static String f17566a = "pushjson";

    /* renamed from: b */
    private static String f17567b = "notification_key";

    /* renamed from: c */
    private static String f17568c = "notification_silent_key";

    /* renamed from: d */
    private static String f17569d = "notification_body_key";

    /* renamed from: e */
    private static String f17570e = "notification_local_navigation";

    /* renamed from: f */
    private static String f17571f = "notification_local_value";

    /* renamed from: a */
    private static void m21980a(Bundle bundle) {
        if (bundle.containsKey(f17570e)) {
            AppActivity.setNotificationTarget(bundle.getString(f17570e), bundle.containsKey(f17571f) ? bundle.getString(f17571f) : "");
        }
    }

    /* renamed from: b */
    private static void m21984b(Bundle bundle) {
        if (bundle.containsKey(f17566a)) {
            AppActivity.pushNotificationReceived(bundle.getString(f17566a), true);
        }
    }

    /* renamed from: c */
    public static void m21985c(Bundle bundle) {
        if (bundle != null) {
            m21984b(bundle);
            m21980a(bundle);
        }
    }

    /* renamed from: b */
    public static void m21983b(Context context, Intent intent) {
        Intent a = m21978a(context, intent);
        ((NotificationManager) context.getSystemService("notification")).notify(intent.getStringExtra(f17567b).hashCode(), m21979a(context, a, intent.getStringExtra(f17569d), intent.getBooleanExtra(f17568c, false)).mo3918a());
    }

    /* renamed from: a */
    private static Intent m21978a(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(f17567b);
        String stringExtra2 = intent.getStringExtra(f17570e);
        String stringExtra3 = intent.getStringExtra(f17571f);
        Intent intent2 = new Intent(context, AppActivity.class);
        intent2.putExtra("pushkey", stringExtra);
        intent2.putExtra(f17570e, stringExtra2);
        intent2.putExtra(f17571f, stringExtra3);
        return intent2;
    }

    /* renamed from: a */
    private static C0725i.C0730e m21979a(Context context, Intent intent, String str, boolean z) {
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        C0725i.C0730e eVar = new C0725i.C0730e(context, z ? "HB2_notification_default_nosound" : "HB2_notification_default");
        eVar.mo3936b((CharSequence) context.getResources().getString(2131558470));
        C0725i.C0728c cVar = new C0725i.C0728c();
        cVar.mo3916a((CharSequence) str);
        eVar.mo3928a((C0725i.C0733h) cVar);
        eVar.mo3929a((CharSequence) str);
        eVar.mo3923a(activity);
        eVar.mo3931a(true);
        eVar.mo3944e(0);
        if (Build.VERSION.SDK_INT < 26) {
            if (z) {
                eVar.mo3934b(4);
            } else {
                eVar.mo3934b(7);
            }
        }
        if (Build.VERSION.SDK_INT < 21) {
            eVar.mo3946f(C6876R$mipmap.ic_launcher);
        } else {
            eVar.mo3946f(C6871R$drawable.icon_notification);
        }
        return eVar;
    }

    /* renamed from: a */
    public static void m21982a(AppActivity appActivity, String str, String str2, String str3, String str4, int i, int i2) {
        Intent putExtra = new Intent(appActivity, NotificationReceiver.class).putExtra(f17569d, str2);
        String str5 = f17568c;
        boolean z = true;
        if (i2 != 1) {
            z = false;
        }
        Intent putExtra2 = putExtra.putExtra(str5, z).putExtra(f17567b, str).putExtra(f17570e, str3).putExtra(f17571f, str4);
        long elapsedRealtime = SystemClock.elapsedRealtime() + ((long) (i * 1000));
        PendingIntent broadcast = PendingIntent.getBroadcast(appActivity, str.hashCode(), putExtra2, 134217728);
        AlarmManager alarmManager = (AlarmManager) appActivity.getSystemService("alarm");
        if (alarmManager != null) {
            alarmManager.set(2, elapsedRealtime, broadcast);
        }
    }

    /* renamed from: a */
    public static void m21981a(AppActivity appActivity, String str) {
        PendingIntent broadcast = PendingIntent.getBroadcast(appActivity, str.hashCode(), new Intent(appActivity, NotificationReceiver.class), 0);
        AlarmManager alarmManager = (AlarmManager) appActivity.getSystemService("alarm");
        if (alarmManager != null && broadcast != null) {
            alarmManager.cancel(broadcast);
        }
    }
}
