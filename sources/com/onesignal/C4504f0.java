package com.onesignal;

import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.onesignal.C4564n1;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.f0 */
/* compiled from: NotificationSummaryManager */
class C4504f0 {
    /* renamed from: a */
    static void m15523a(Context context, SQLiteDatabase sQLiteDatabase, int i) {
        Cursor query = sQLiteDatabase.query("notification", new String[]{"group_id"}, "android_notification_id = " + i, (String[]) null, (String) null, (String) null, (String) null);
        if (query.moveToFirst()) {
            String string = query.getString(query.getColumnIndex("group_id"));
            query.close();
            if (string != null) {
                m15526b(context, sQLiteDatabase, string, true);
                return;
            }
            return;
        }
        query.close();
    }

    /* renamed from: b */
    static void m15526b(Context context, SQLiteDatabase sQLiteDatabase, String str, boolean z) {
        try {
            Cursor a = m15521a(context, sQLiteDatabase, str, z);
            if (a != null && !a.isClosed()) {
                a.close();
            }
        } catch (Throwable th) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Error running updateSummaryNotificationAfterChildRemoved!", th);
        }
    }

    /* renamed from: a */
    private static Cursor m15521a(Context context, SQLiteDatabase sQLiteDatabase, String str, boolean z) {
        Cursor query = sQLiteDatabase.query("notification", new String[]{"android_notification_id", "created_time"}, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", new String[]{str}, (String) null, (String) null, "_id DESC");
        int count = query.getCount();
        if (count == 0) {
            query.close();
            Integer a = m15522a(sQLiteDatabase, str);
            if (a == null) {
                return query;
            }
            C4676v1.m16257d(context).cancel(a.intValue());
            ContentValues contentValues = new ContentValues();
            contentValues.put(z ? "dismissed" : "opened", 1);
            sQLiteDatabase.update("notification", contentValues, "android_notification_id = " + a, (String[]) null);
            return query;
        } else if (count == 1) {
            query.close();
            if (m15522a(sQLiteDatabase, str) == null) {
                return query;
            }
            m15525a(context, str);
            return query;
        } else {
            try {
                query.moveToFirst();
                Long valueOf = Long.valueOf(query.getLong(query.getColumnIndex("created_time")));
                query.close();
                if (m15522a(sQLiteDatabase, str) == null) {
                    return query;
                }
                C4467a0 a0Var = new C4467a0(context);
                a0Var.f12269c = true;
                a0Var.f12272f = valueOf;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("grp", str);
                a0Var.f12268b = jSONObject;
                C4631r.m16069d(a0Var);
                return query;
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: a */
    private static void m15525a(Context context, String str) {
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            cursor = C4655t1.m16157a(context).mo29963d().query("notification", C4495e0.f12320a, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", strArr, (String) null, (String) null, (String) null);
            C4495e0.m15482a(context, cursor, 0);
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

    /* JADX WARNING: type inference failed for: r9v0, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.Integer m15522a(android.database.sqlite.SQLiteDatabase r12, java.lang.String r13) {
        /*
            java.lang.String r0 = "android_notification_id"
            java.lang.String r4 = "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 1"
            r1 = 1
            java.lang.String[] r5 = new java.lang.String[r1]
            r2 = 0
            r5[r2] = r13
            r9 = 0
            java.lang.String r3 = "notification"
            java.lang.String[] r6 = new java.lang.String[r1]     // Catch:{ all -> 0x0053 }
            r6[r2] = r0     // Catch:{ all -> 0x0053 }
            r7 = 0
            r8 = 0
            r10 = 0
            r1 = r12
            r2 = r3
            r3 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0053 }
            boolean r1 = r12.moveToFirst()     // Catch:{ all -> 0x004e }
            if (r1 != 0) goto L_0x0033
            r12.close()     // Catch:{ all -> 0x004e }
            if (r12 == 0) goto L_0x0032
            boolean r13 = r12.isClosed()
            if (r13 != 0) goto L_0x0032
            r12.close()
        L_0x0032:
            return r9
        L_0x0033:
            int r0 = r12.getColumnIndex(r0)     // Catch:{ all -> 0x004e }
            int r0 = r12.getInt(r0)     // Catch:{ all -> 0x004e }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x004e }
            r12.close()     // Catch:{ all -> 0x004e }
            if (r12 == 0) goto L_0x0077
            boolean r13 = r12.isClosed()
            if (r13 != 0) goto L_0x0077
            r12.close()
            goto L_0x0077
        L_0x004e:
            r0 = move-exception
            r11 = r9
            r9 = r12
            r12 = r11
            goto L_0x0055
        L_0x0053:
            r0 = move-exception
            r12 = r9
        L_0x0055:
            com.onesignal.n1$a0 r1 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ all -> 0x0078 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0078 }
            r2.<init>()     // Catch:{ all -> 0x0078 }
            java.lang.String r3 = "Error getting android notification id for summary notification group: "
            r2.append(r3)     // Catch:{ all -> 0x0078 }
            r2.append(r13)     // Catch:{ all -> 0x0078 }
            java.lang.String r13 = r2.toString()     // Catch:{ all -> 0x0078 }
            com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r1, (java.lang.String) r13, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0078 }
            if (r9 == 0) goto L_0x0076
            boolean r13 = r9.isClosed()
            if (r13 != 0) goto L_0x0076
            r9.close()
        L_0x0076:
            r9 = r12
        L_0x0077:
            return r9
        L_0x0078:
            r12 = move-exception
            if (r9 == 0) goto L_0x0084
            boolean r13 = r9.isClosed()
            if (r13 != 0) goto L_0x0084
            r9.close()
        L_0x0084:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4504f0.m15522a(android.database.sqlite.SQLiteDatabase, java.lang.String):java.lang.Integer");
    }

    /* renamed from: a */
    static void m15524a(Context context, SQLiteDatabase sQLiteDatabase, String str) {
        Integer a = m15522a(sQLiteDatabase, str);
        boolean equals = str.equals(C4676v1.m16254b());
        NotificationManager d = C4676v1.m16257d(context);
        Integer a2 = C4676v1.m16251a(sQLiteDatabase, str, equals);
        if (a2 == null) {
            return;
        }
        if (C4564n1.m15876r()) {
            if (equals) {
                a = Integer.valueOf(C4676v1.m16250a());
            }
            if (a != null) {
                d.cancel(a.intValue());
                return;
            }
            return;
        }
        C4564n1.m15824c(a2.intValue());
    }
}
