package com.onesignal;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.onesignal.b0 */
/* compiled from: NotificationLimitManager */
class C4476b0 {

    /* renamed from: a */
    static final String f12290a = Integer.toString(49);

    /* renamed from: a */
    private static int m15423a() {
        return 49;
    }

    /* renamed from: a */
    static void m15424a(Context context, int i) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                m15428c(context, i);
            } else {
                m15427b(context, i);
            }
        } catch (Throwable unused) {
            m15427b(context, i);
        }
    }

    /* renamed from: b */
    private static String m15426b() {
        return f12290a;
    }

    /* renamed from: c */
    static void m15428c(Context context, int i) throws Throwable {
        StatusBarNotification[] b = C4676v1.m16255b(context);
        int length = (b.length - m15423a()) + i;
        if (length >= 1) {
            TreeMap treeMap = new TreeMap();
            for (StatusBarNotification statusBarNotification : b) {
                if (!m15425a(statusBarNotification)) {
                    treeMap.put(Long.valueOf(statusBarNotification.getNotification().when), Integer.valueOf(statusBarNotification.getId()));
                }
            }
            for (Map.Entry value : treeMap.entrySet()) {
                C4564n1.m15824c(((Integer) value.getValue()).intValue());
                length--;
                if (length <= 0) {
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    static void m15427b(Context context, int i) {
        Cursor cursor = null;
        try {
            cursor = C4655t1.m16157a(context).mo29963d().query("notification", new String[]{"android_notification_id"}, C4655t1.m16168v().toString(), (String[]) null, (String) null, (String) null, "_id", m15426b() + i);
            int count = (cursor.getCount() - m15423a()) + i;
            if (count >= 1) {
                do {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    C4564n1.m15824c(cursor.getInt(cursor.getColumnIndex("android_notification_id")));
                    count--;
                } while (count > 0);
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } else if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    static boolean m15425a(StatusBarNotification statusBarNotification) {
        return (statusBarNotification.getNotification().flags & 512) != 0;
    }
}
