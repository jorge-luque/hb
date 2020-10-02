package com.onesignal;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import androidx.core.app.C0736l;
import com.onesignal.C4564n1;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.onesignal.d0 */
/* compiled from: NotificationOpenedProcessor */
class C4485d0 {
    /* renamed from: a */
    private static boolean m15455a(Intent intent) {
        return intent.hasExtra("onesignal_data") || intent.hasExtra("summary") || intent.hasExtra("notificationId");
    }

    /* renamed from: b */
    static void m15457b(Context context, Intent intent) {
        if (m15455a(intent)) {
            C4564n1.m15865k(context);
            m15450a(context, intent);
            m15458c(context, intent);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: org.json.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: org.json.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: org.json.JSONObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: org.json.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: org.json.JSONArray} */
    /* JADX WARNING: type inference failed for: r7v0, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074 A[SYNTHETIC, Splitter:B:27:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m15458c(android.content.Context r9, android.content.Intent r10) {
        /*
            java.lang.String r0 = "notificationId"
            java.lang.String r1 = "Error closing transaction! "
            java.lang.String r2 = "onesignal_data"
            java.lang.String r3 = "summary"
            java.lang.String r3 = r10.getStringExtra(r3)
            r4 = 0
            java.lang.String r5 = "dismissed"
            boolean r5 = r10.getBooleanExtra(r5, r4)
            r6 = 0
            if (r5 != 0) goto L_0x004b
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x0044 }
            java.lang.String r8 = r10.getStringExtra(r2)     // Catch:{ all -> 0x0044 }
            r7.<init>(r8)     // Catch:{ all -> 0x0044 }
            boolean r8 = m15454a((android.content.Context) r9, (org.json.JSONObject) r7)     // Catch:{ all -> 0x0042 }
            if (r8 == 0) goto L_0x0026
            return
        L_0x0026:
            int r8 = r10.getIntExtra(r0, r4)     // Catch:{ all -> 0x0042 }
            r7.put(r0, r8)     // Catch:{ all -> 0x0042 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0042 }
            r10.putExtra(r2, r0)     // Catch:{ all -> 0x0042 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = r10.getStringExtra(r2)     // Catch:{ all -> 0x0042 }
            r0.<init>(r2)     // Catch:{ all -> 0x0042 }
            org.json.JSONArray r0 = com.onesignal.C4714x.m16419d((org.json.JSONObject) r0)     // Catch:{ all -> 0x0042 }
            goto L_0x004d
        L_0x0042:
            r0 = move-exception
            goto L_0x0046
        L_0x0044:
            r0 = move-exception
            r7 = r6
        L_0x0046:
            r0.printStackTrace()
            r0 = r6
            goto L_0x004d
        L_0x004b:
            r0 = r6
            r7 = r0
        L_0x004d:
            com.onesignal.t1 r2 = com.onesignal.C4655t1.m16157a((android.content.Context) r9)
            android.database.sqlite.SQLiteDatabase r6 = r2.mo29967t()     // Catch:{ Exception -> 0x007a }
            r6.beginTransaction()     // Catch:{ Exception -> 0x007a }
            if (r5 != 0) goto L_0x005f
            if (r3 == 0) goto L_0x005f
            m15453a((org.json.JSONArray) r0, (java.lang.String) r3, (android.database.sqlite.SQLiteDatabase) r6)     // Catch:{ Exception -> 0x007a }
        L_0x005f:
            m15451a(r9, r10, r6, r5)     // Catch:{ Exception -> 0x007a }
            if (r3 != 0) goto L_0x006f
            java.lang.String r2 = "grp"
            java.lang.String r2 = r10.getStringExtra(r2)     // Catch:{ Exception -> 0x007a }
            if (r2 == 0) goto L_0x006f
            com.onesignal.C4504f0.m15526b(r9, r6, r2, r5)     // Catch:{ Exception -> 0x007a }
        L_0x006f:
            r6.setTransactionSuccessful()     // Catch:{ Exception -> 0x007a }
            if (r6 == 0) goto L_0x008e
            r6.endTransaction()     // Catch:{ all -> 0x0088 }
            goto L_0x008e
        L_0x0078:
            r9 = move-exception
            goto L_0x009e
        L_0x007a:
            r2 = move-exception
            com.onesignal.n1$a0 r3 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ all -> 0x0078 }
            java.lang.String r8 = "Error processing notification open or dismiss record! "
            com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r3, (java.lang.String) r8, (java.lang.Throwable) r2)     // Catch:{ all -> 0x0078 }
            if (r6 == 0) goto L_0x008e
            r6.endTransaction()     // Catch:{ all -> 0x0088 }
            goto L_0x008e
        L_0x0088:
            r2 = move-exception
            com.onesignal.n1$a0 r3 = com.onesignal.C4564n1.C4566a0.ERROR
            com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r3, (java.lang.String) r1, (java.lang.Throwable) r2)
        L_0x008e:
            if (r5 != 0) goto L_0x009d
            java.lang.String r1 = "from_alert"
            boolean r10 = r10.getBooleanExtra(r1, r4)
            java.lang.String r1 = com.onesignal.C4564n1.m15812b((org.json.JSONObject) r7)
            com.onesignal.C4564n1.m15787a((android.content.Context) r9, (org.json.JSONArray) r0, (boolean) r10, (java.lang.String) r1)
        L_0x009d:
            return
        L_0x009e:
            if (r6 == 0) goto L_0x00aa
            r6.endTransaction()     // Catch:{ all -> 0x00a4 }
            goto L_0x00aa
        L_0x00a4:
            r10 = move-exception
            com.onesignal.n1$a0 r0 = com.onesignal.C4564n1.C4566a0.ERROR
            com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r0, (java.lang.String) r1, (java.lang.Throwable) r10)
        L_0x00aa:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4485d0.m15458c(android.content.Context, android.content.Intent):void");
    }

    /* renamed from: a */
    private static void m15450a(Context context, Intent intent) {
        if (intent.getBooleanExtra("action_button", false)) {
            C0736l.m2316a(context).mo3958a(intent.getIntExtra("notificationId", 0));
            context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
    }

    /* renamed from: a */
    private static boolean m15454a(Context context, JSONObject jSONObject) {
        String c = C4714x.m16416c(jSONObject);
        if (c == null) {
            return false;
        }
        C4564n1.m15872n(context);
        C4548m0.m15715h().mo29834a(c);
        return true;
    }

    /* renamed from: b */
    private static ContentValues m15456b(Intent intent) {
        ContentValues contentValues = new ContentValues();
        if (intent.getBooleanExtra("dismissed", false)) {
            contentValues.put("dismissed", 1);
        } else {
            contentValues.put("opened", 1);
        }
        return contentValues;
    }

    /* renamed from: a */
    private static void m15453a(JSONArray jSONArray, String str, SQLiteDatabase sQLiteDatabase) {
        Cursor query = sQLiteDatabase.query("notification", new String[]{"full_data"}, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", new String[]{str}, (String) null, (String) null, (String) null);
        if (query.getCount() > 1) {
            query.moveToFirst();
            do {
                try {
                    jSONArray.put(new JSONObject(query.getString(query.getColumnIndex("full_data"))));
                } catch (Throwable unused) {
                    C4564n1.C4566a0 a0Var = C4564n1.C4566a0.ERROR;
                    C4564n1.m15789a(a0Var, "Could not parse JSON of sub notification in group: " + str);
                }
            } while (query.moveToNext());
        }
        query.close();
    }

    /* renamed from: a */
    private static void m15451a(Context context, Intent intent, SQLiteDatabase sQLiteDatabase, boolean z) {
        String str;
        String stringExtra = intent.getStringExtra("summary");
        String[] strArr = null;
        if (stringExtra != null) {
            boolean equals = stringExtra.equals(C4676v1.m16254b());
            if (equals) {
                str = "group_id IS NULL";
            } else {
                strArr = new String[]{stringExtra};
                str = "group_id = ?";
            }
            if (!z && !C4564n1.m15876r()) {
                String valueOf = String.valueOf(C4676v1.m16251a(sQLiteDatabase, stringExtra, equals));
                str = str + " AND android_notification_id = ?";
                strArr = equals ? new String[]{valueOf} : new String[]{stringExtra, valueOf};
            }
        } else {
            str = "android_notification_id = " + intent.getIntExtra("notificationId", 0);
        }
        m15452a(context, sQLiteDatabase, stringExtra);
        sQLiteDatabase.update("notification", m15456b(intent), str, strArr);
        C4521i.m15558a(sQLiteDatabase, context);
    }

    /* renamed from: a */
    private static void m15452a(Context context, SQLiteDatabase sQLiteDatabase, String str) {
        if (str != null) {
            C4504f0.m15524a(context, sQLiteDatabase, str);
        } else if (Build.VERSION.SDK_INT >= 23 && C4676v1.m16256c(context).intValue() < 1) {
            C4676v1.m16257d(context).cancel(C4676v1.m16250a());
        }
    }
}
