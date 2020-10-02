package com.onesignal;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import androidx.core.app.C0725i;
import androidx.core.app.C0736l;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.onesignal.v1 */
/* compiled from: OneSignalNotificationManager */
public class C4676v1 {
    /* renamed from: a */
    static int m16250a() {
        return -718463522;
    }

    /* renamed from: a */
    static ArrayList<StatusBarNotification> m16252a(Context context) {
        ArrayList<StatusBarNotification> arrayList = new ArrayList<>();
        for (StatusBarNotification statusBarNotification : m16255b(context)) {
            Notification notification = statusBarNotification.getNotification();
            boolean a = C4476b0.m15425a(statusBarNotification);
            boolean z = notification.getGroup() == null || notification.getGroup().equals(m16254b());
            if (!a && z) {
                arrayList.add(statusBarNotification);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    static String m16254b() {
        return "os_group_undefined";
    }

    /* renamed from: b */
    static StatusBarNotification[] m16255b(Context context) {
        try {
            return m16257d(context).getActiveNotifications();
        } catch (Throwable unused) {
            return new StatusBarNotification[0];
        }
    }

    /* renamed from: c */
    static Integer m16256c(Context context) {
        int i = 0;
        for (StatusBarNotification statusBarNotification : m16255b(context)) {
            if (!C0725i.m2242b(statusBarNotification.getNotification()) && "os_group_undefined".equals(statusBarNotification.getNotification().getGroup())) {
                i++;
            }
        }
        return Integer.valueOf(i);
    }

    /* renamed from: d */
    static NotificationManager m16257d(Context context) {
        return (NotificationManager) context.getSystemService("notification");
    }

    /* renamed from: a */
    static void m16253a(Context context, ArrayList<StatusBarNotification> arrayList) {
        Notification.Builder builder;
        Iterator<StatusBarNotification> it = arrayList.iterator();
        while (it.hasNext()) {
            StatusBarNotification next = it.next();
            if (Build.VERSION.SDK_INT >= 24) {
                builder = Notification.Builder.recoverBuilder(context, next.getNotification());
            } else {
                builder = new Notification.Builder(context);
            }
            C0736l.m2316a(context).mo3959a(next.getId(), builder.setGroup("os_group_undefined").build());
        }
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r0v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.Integer m16251a(android.database.sqlite.SQLiteDatabase r12, java.lang.String r13, boolean r14) {
        /*
            if (r14 == 0) goto L_0x0005
            java.lang.String r0 = "group_id IS NULL"
            goto L_0x0007
        L_0x0005:
            java.lang.String r0 = "group_id = ?"
        L_0x0007:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " AND dismissed = 0 AND opened = 0 AND is_summary = 0"
            r1.append(r0)
            java.lang.String r5 = r1.toString()
            r0 = 0
            if (r14 == 0) goto L_0x001d
            r6 = r0
            goto L_0x0024
        L_0x001d:
            r14 = 1
            java.lang.String[] r14 = new java.lang.String[r14]
            r1 = 0
            r14[r1] = r13
            r6 = r14
        L_0x0024:
            java.lang.String r3 = "notification"
            r4 = 0
            r7 = 0
            r8 = 0
            java.lang.String r9 = "created_time DESC"
            java.lang.String r10 = "1"
            r2 = r12
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0069 }
            boolean r14 = r12.moveToFirst()     // Catch:{ all -> 0x0064 }
            if (r14 != 0) goto L_0x0047
            r12.close()     // Catch:{ all -> 0x0064 }
            if (r12 == 0) goto L_0x0046
            boolean r13 = r12.isClosed()
            if (r13 != 0) goto L_0x0046
            r12.close()
        L_0x0046:
            return r0
        L_0x0047:
            java.lang.String r14 = "android_notification_id"
            int r14 = r12.getColumnIndex(r14)     // Catch:{ all -> 0x0064 }
            int r14 = r12.getInt(r14)     // Catch:{ all -> 0x0064 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x0064 }
            r12.close()     // Catch:{ all -> 0x0064 }
            if (r12 == 0) goto L_0x008d
            boolean r13 = r12.isClosed()
            if (r13 != 0) goto L_0x008d
            r12.close()
            goto L_0x008d
        L_0x0064:
            r14 = move-exception
            r11 = r0
            r0 = r12
            r12 = r11
            goto L_0x006b
        L_0x0069:
            r14 = move-exception
            r12 = r0
        L_0x006b:
            com.onesignal.n1$a0 r1 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ all -> 0x008e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r2.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r3 = "Error getting android notification id for summary notification group: "
            r2.append(r3)     // Catch:{ all -> 0x008e }
            r2.append(r13)     // Catch:{ all -> 0x008e }
            java.lang.String r13 = r2.toString()     // Catch:{ all -> 0x008e }
            com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r1, (java.lang.String) r13, (java.lang.Throwable) r14)     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x008c
            boolean r13 = r0.isClosed()
            if (r13 != 0) goto L_0x008c
            r0.close()
        L_0x008c:
            r0 = r12
        L_0x008d:
            return r0
        L_0x008e:
            r12 = move-exception
            if (r0 == 0) goto L_0x009a
            boolean r13 = r0.isClosed()
            if (r13 != 0) goto L_0x009a
            r0.close()
        L_0x009a:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4676v1.m16251a(android.database.sqlite.SQLiteDatabase, java.lang.String, boolean):java.lang.Integer");
    }
}
