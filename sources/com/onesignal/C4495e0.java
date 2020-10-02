package com.onesignal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.onesignal.C4564n1;
import java.util.ArrayList;

/* renamed from: com.onesignal.e0 */
/* compiled from: NotificationRestorer */
class C4495e0 {

    /* renamed from: a */
    static final String[] f12320a = {"android_notification_id", "full_data", "created_time"};

    /* renamed from: b */
    public static boolean f12321b;

    /* renamed from: com.onesignal.e0$a */
    /* compiled from: NotificationRestorer */
    static class C4496a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f12322a;

        C4496a(Context context) {
            this.f12322a = context;
        }

        public void run() {
            Thread.currentThread().setPriority(10);
            C4495e0.m15485b(this.f12322a);
        }
    }

    /* renamed from: a */
    static void m15481a(Context context) {
        new Thread(new C4496a(context), "OS_RESTORE_NOTIFS").start();
    }

    /* renamed from: b */
    public static void m15485b(Context context) {
        if (C4536k1.m15626a(context) && !f12321b) {
            f12321b = true;
            C4564n1.m15789a(C4564n1.C4566a0.INFO, "Restoring notifications");
            C4655t1 a = C4655t1.m16157a(context);
            StringBuilder v = C4655t1.m16168v();
            m15484a(context, v);
            m15483a(context, a, v);
        }
    }

    /* renamed from: c */
    static void m15486c(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            C4564n1.m15789a(C4564n1.C4566a0.INFO, "scheduleRestoreKickoffJob");
            ((JobScheduler) context.getSystemService("jobscheduler")).schedule(new JobInfo.Builder(2071862120, new ComponentName(context, RestoreKickoffJobService.class)).setOverrideDeadline(15000).setMinimumLatency(15000).build());
            return;
        }
        C4564n1.m15789a(C4564n1.C4566a0.INFO, "scheduleRestoreKickoffAlarmTask");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getPackageName(), NotificationRestoreService.class.getName()));
        PendingIntent service = PendingIntent.getService(context, 2071862120, intent, 134217728);
        ((AlarmManager) context.getSystemService("alarm")).set(1, System.currentTimeMillis() + 15000, service);
    }

    /* renamed from: a */
    private static void m15483a(Context context, C4655t1 t1Var, StringBuilder sb) {
        C4564n1.C4566a0 a0Var = C4564n1.C4566a0.INFO;
        C4564n1.m15789a(a0Var, "Querying DB for notifs to restore: " + sb.toString());
        Cursor cursor = null;
        try {
            SQLiteDatabase d = t1Var.mo29963d();
            cursor = d.query("notification", f12320a, sb.toString(), (String[]) null, (String) null, (String) null, "_id DESC", C4476b0.f12290a);
            m15482a(context, cursor, 200);
            C4521i.m15558a(d, context);
            if (cursor == null || cursor.isClosed()) {
                return;
            }
        } catch (Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
    }

    /* renamed from: a */
    private static void m15484a(Context context, StringBuilder sb) {
        if (Build.VERSION.SDK_INT >= 23) {
            StatusBarNotification[] b = C4676v1.m16255b(context);
            if (b.length != 0) {
                ArrayList arrayList = new ArrayList();
                for (StatusBarNotification id : b) {
                    arrayList.add(Integer.valueOf(id.getId()));
                }
                sb.append(" AND android_notification_id NOT IN (");
                sb.append(TextUtils.join(",", arrayList));
                sb.append(")");
            }
        }
    }

    /* renamed from: a */
    static void m15482a(Context context, Cursor cursor, int i) {
        if (cursor.moveToFirst()) {
            boolean z = C4739z.m16456a(context) != null;
            do {
                if (z) {
                    Intent a = C4739z.m16456a(context);
                    m15480a(a, cursor);
                    JobIntentService.m15345a(context, a.getComponent(), 2071862121, a, false);
                } else {
                    Intent intent = new Intent();
                    m15480a(intent, cursor);
                    JobIntentService.m15345a(context, new ComponentName(context, RestoreJobService.class), 2071862122, intent, false);
                }
                if (i > 0) {
                    C4536k1.m15631b(i);
                }
            } while (cursor.moveToNext());
        }
    }

    /* renamed from: a */
    private static Intent m15480a(Intent intent, Cursor cursor) {
        int i = cursor.getInt(cursor.getColumnIndex("android_notification_id"));
        String string = cursor.getString(cursor.getColumnIndex("full_data"));
        intent.putExtra("json_payload", string).putExtra("android_notif_id", i).putExtra("restoring", true).putExtra("timestamp", Long.valueOf(cursor.getLong(cursor.getColumnIndex("created_time"))));
        return intent;
    }
}
