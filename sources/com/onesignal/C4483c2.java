package com.onesignal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.onesignal.C4497e1;
import com.onesignal.C4564n1;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.onesignal.c2 */
/* compiled from: OutcomeEventsCache */
class C4483c2 {
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r8 = com.onesignal.C4564n1.C4566a0.ERROR;
        r1 = "Error closing transaction! ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0049, code lost:
        if (r8 != null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r8.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004f, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        com.onesignal.C4564n1.m15790a(com.onesignal.C4564n1.C4566a0.ERROR, "Error closing transaction! ", (java.lang.Throwable) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0057, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        r7 = e;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:7:0x0024, B:15:0x0034] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void m15446a(com.onesignal.C4478b2 r7, com.onesignal.C4655t1 r8) {
        /*
            java.lang.Class<com.onesignal.c2> r0 = com.onesignal.C4483c2.class
            monitor-enter(r0)
            android.database.sqlite.SQLiteDatabase r8 = r8.mo29967t()     // Catch:{ all -> 0x0058 }
            r8.beginTransaction()     // Catch:{ SQLiteException -> 0x0033 }
            java.lang.String r1 = "outcome"
            java.lang.String r2 = "timestamp = ?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0033 }
            r4 = 0
            long r5 = r7.mo29726d()     // Catch:{ SQLiteException -> 0x0033 }
            java.lang.String r7 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0033 }
            r3[r4] = r7     // Catch:{ SQLiteException -> 0x0033 }
            r8.delete(r1, r2, r3)     // Catch:{ SQLiteException -> 0x0033 }
            r8.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x0033 }
            if (r8 == 0) goto L_0x0047
            r8.endTransaction()     // Catch:{ SQLiteException -> 0x0028 }
            goto L_0x0047
        L_0x0028:
            r7 = move-exception
            com.onesignal.n1$a0 r8 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ all -> 0x0058 }
            java.lang.String r1 = "Error closing transaction! "
        L_0x002d:
            com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r8, (java.lang.String) r1, (java.lang.Throwable) r7)     // Catch:{ all -> 0x0058 }
            goto L_0x0047
        L_0x0031:
            r7 = move-exception
            goto L_0x0049
        L_0x0033:
            r7 = move-exception
            com.onesignal.n1$a0 r1 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = "Error deleting old outcome event records! "
            com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r1, (java.lang.String) r2, (java.lang.Throwable) r7)     // Catch:{ all -> 0x0031 }
            if (r8 == 0) goto L_0x0047
            r8.endTransaction()     // Catch:{ SQLiteException -> 0x0041 }
            goto L_0x0047
        L_0x0041:
            r7 = move-exception
            com.onesignal.n1$a0 r8 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ all -> 0x0058 }
            java.lang.String r1 = "Error closing transaction! "
            goto L_0x002d
        L_0x0047:
            monitor-exit(r0)
            return
        L_0x0049:
            if (r8 == 0) goto L_0x0057
            r8.endTransaction()     // Catch:{ SQLiteException -> 0x004f }
            goto L_0x0057
        L_0x004f:
            r8 = move-exception
            com.onesignal.n1$a0 r1 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ all -> 0x0058 }
            java.lang.String r2 = "Error closing transaction! "
            com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r1, (java.lang.String) r2, (java.lang.Throwable) r8)     // Catch:{ all -> 0x0058 }
        L_0x0057:
            throw r7     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r7 = move-exception
            monitor-exit(r0)
            goto L_0x005c
        L_0x005b:
            throw r7
        L_0x005c:
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4483c2.m15446a(com.onesignal.b2, com.onesignal.t1):void");
    }

    /* renamed from: b */
    static synchronized void m15448b(C4478b2 b2Var, C4655t1 t1Var) {
        synchronized (C4483c2.class) {
            SQLiteDatabase t = t1Var.mo29967t();
            String jSONArray = b2Var.mo29724b() != null ? b2Var.mo29724b().toString() : "[]";
            ContentValues contentValues = new ContentValues();
            contentValues.put("notification_ids", jSONArray);
            contentValues.put("session", b2Var.mo29725c().toString().toLowerCase());
            contentValues.put("name", b2Var.mo29723a());
            contentValues.put("timestamp", Long.valueOf(b2Var.mo29726d()));
            contentValues.put("weight", Float.valueOf(b2Var.mo29727e()));
            t.insert("outcome", (String) null, contentValues);
        }
    }

    /* renamed from: a */
    static synchronized List<C4478b2> m15444a(C4655t1 t1Var) {
        ArrayList arrayList;
        synchronized (C4483c2.class) {
            arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                cursor = t1Var.mo29963d().query("outcome", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
                if (cursor.moveToFirst()) {
                    do {
                        C4497e1.C4498a a = C4497e1.C4498a.m15498a(cursor.getString(cursor.getColumnIndex("session")));
                        String string = cursor.getString(cursor.getColumnIndex("notification_ids"));
                        arrayList.add(new C4478b2(a, new JSONArray(string), cursor.getString(cursor.getColumnIndex("name")), cursor.getLong(cursor.getColumnIndex("timestamp")), cursor.getFloat(cursor.getColumnIndex("weight"))));
                    } while (cursor.moveToNext());
                }
            } catch (JSONException e) {
                C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Generating JSONArray from notifications ids outcome:JSON Failed.", (Throwable) e);
            } catch (Throwable th) {
                if (cursor != null) {
                    if (!cursor.isClosed()) {
                        cursor.close();
                    }
                }
                throw th;
            }
            if (cursor != null) {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static synchronized void m15447a(JSONArray jSONArray, String str, C4655t1 t1Var) {
        synchronized (C4483c2.class) {
            if (jSONArray != null) {
                SQLiteDatabase t = t1Var.mo29967t();
                int i = 0;
                while (i < jSONArray.length()) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(TapjoyConstants.TJC_NOTIFICATION_ID, jSONArray.getString(i));
                        contentValues.put("name", str);
                        t.insert("cached_unique_outcome_notification", (String) null, contentValues);
                        i++;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                return;
            }
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        if (r13.isClosed() == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005e, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006e, code lost:
        if (r13.isClosed() == false) goto L_0x005e;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized org.json.JSONArray m15445a(java.lang.String r18, org.json.JSONArray r19, com.onesignal.C4655t1 r20) {
        /*
            java.lang.Class<com.onesignal.c2> r1 = com.onesignal.C4483c2.class
            monitor-enter(r1)
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ all -> 0x007f }
            r2.<init>()     // Catch:{ all -> 0x007f }
            android.database.sqlite.SQLiteDatabase r0 = r20.mo29963d()     // Catch:{ all -> 0x007f }
            r3 = 0
            r12 = 0
            r13 = r3
            r14 = 0
        L_0x0010:
            int r3 = r19.length()     // Catch:{ JSONException -> 0x0064 }
            if (r14 >= r3) goto L_0x0056
            r15 = r19
            java.lang.String r11 = r15.getString(r14)     // Catch:{ JSONException -> 0x0064 }
            com.onesignal.n r3 = new com.onesignal.n     // Catch:{ JSONException -> 0x0064 }
            r10 = r18
            r3.<init>(r11, r10)     // Catch:{ JSONException -> 0x0064 }
            java.lang.String[] r5 = new java.lang.String[r12]     // Catch:{ JSONException -> 0x0064 }
            java.lang.String r6 = "notification_id = ? AND name = ?"
            r4 = 2
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0064 }
            java.lang.String r4 = r3.mo29848b()     // Catch:{ JSONException -> 0x0064 }
            r7[r12] = r4     // Catch:{ JSONException -> 0x0064 }
            java.lang.String r3 = r3.mo29847a()     // Catch:{ JSONException -> 0x0064 }
            r4 = 1
            r7[r4] = r3     // Catch:{ JSONException -> 0x0064 }
            java.lang.String r4 = "cached_unique_outcome_notification"
            r8 = 0
            r9 = 0
            r16 = 0
            java.lang.String r17 = "1"
            r3 = r0
            r10 = r16
            r12 = r11
            r11 = r17
            android.database.Cursor r13 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ JSONException -> 0x0064 }
            int r3 = r13.getCount()     // Catch:{ JSONException -> 0x0064 }
            if (r3 != 0) goto L_0x0052
            r2.put(r12)     // Catch:{ JSONException -> 0x0064 }
        L_0x0052:
            int r14 = r14 + 1
            r12 = 0
            goto L_0x0010
        L_0x0056:
            if (r13 == 0) goto L_0x0071
            boolean r0 = r13.isClosed()     // Catch:{ all -> 0x007f }
            if (r0 != 0) goto L_0x0071
        L_0x005e:
            r13.close()     // Catch:{ all -> 0x007f }
            goto L_0x0071
        L_0x0062:
            r0 = move-exception
            goto L_0x0073
        L_0x0064:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0062 }
            if (r13 == 0) goto L_0x0071
            boolean r0 = r13.isClosed()     // Catch:{ all -> 0x007f }
            if (r0 != 0) goto L_0x0071
            goto L_0x005e
        L_0x0071:
            monitor-exit(r1)
            return r2
        L_0x0073:
            if (r13 == 0) goto L_0x007e
            boolean r2 = r13.isClosed()     // Catch:{ all -> 0x007f }
            if (r2 != 0) goto L_0x007e
            r13.close()     // Catch:{ all -> 0x007f }
        L_0x007e:
            throw r0     // Catch:{ all -> 0x007f }
        L_0x007f:
            r0 = move-exception
            monitor-exit(r1)
            goto L_0x0083
        L_0x0082:
            throw r0
        L_0x0083:
            goto L_0x0082
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4483c2.m15445a(java.lang.String, org.json.JSONArray, com.onesignal.t1):org.json.JSONArray");
    }
}
