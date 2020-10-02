package com.onesignal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.onesignal.s0 */
/* compiled from: OSInAppMessageRepository */
class C4641s0 {

    /* renamed from: a */
    private final C4655t1 f12646a;

    C4641s0(C4655t1 t1Var) {
        this.f12646a = t1Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo29943a() {
        this.f12646a.mo29967t().delete("in_app_message", "last_display< ?", new String[]{String.valueOf((System.currentTimeMillis() / 1000) - 15552000)});
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008a, code lost:
        if (r1.isClosed() == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a0, code lost:
        if (r1.isClosed() == false) goto L_0x008c;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.onesignal.C4535k0> mo29945b() {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00b1 }
            r0.<init>()     // Catch:{ all -> 0x00b1 }
            r1 = 0
            com.onesignal.t1 r2 = r11.f12646a     // Catch:{ JSONException -> 0x0092 }
            android.database.sqlite.SQLiteDatabase r3 = r2.mo29963d()     // Catch:{ JSONException -> 0x0092 }
            java.lang.String r4 = "in_app_message"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ JSONException -> 0x0092 }
            boolean r2 = r1.moveToFirst()     // Catch:{ JSONException -> 0x0092 }
            if (r2 == 0) goto L_0x0084
        L_0x001f:
            java.lang.String r2 = "message_id"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ JSONException -> 0x0092 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ JSONException -> 0x0092 }
            java.lang.String r3 = "click_ids"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ JSONException -> 0x0092 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x0092 }
            java.lang.String r4 = "display_quantity"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ JSONException -> 0x0092 }
            int r4 = r1.getInt(r4)     // Catch:{ JSONException -> 0x0092 }
            java.lang.String r5 = "last_display"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ JSONException -> 0x0092 }
            long r5 = r1.getLong(r5)     // Catch:{ JSONException -> 0x0092 }
            java.lang.String r7 = "displayed_in_session"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ JSONException -> 0x0092 }
            int r7 = r1.getInt(r7)     // Catch:{ JSONException -> 0x0092 }
            r8 = 0
            r9 = 1
            if (r7 != r9) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r9 = 0
        L_0x0057:
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0092 }
            r7.<init>(r3)     // Catch:{ JSONException -> 0x0092 }
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ JSONException -> 0x0092 }
            r3.<init>()     // Catch:{ JSONException -> 0x0092 }
        L_0x0061:
            int r10 = r7.length()     // Catch:{ JSONException -> 0x0092 }
            if (r8 >= r10) goto L_0x0071
            java.lang.String r10 = r7.getString(r8)     // Catch:{ JSONException -> 0x0092 }
            r3.add(r10)     // Catch:{ JSONException -> 0x0092 }
            int r8 = r8 + 1
            goto L_0x0061
        L_0x0071:
            com.onesignal.k0 r7 = new com.onesignal.k0     // Catch:{ JSONException -> 0x0092 }
            com.onesignal.n0 r8 = new com.onesignal.n0     // Catch:{ JSONException -> 0x0092 }
            r8.<init>(r4, r5)     // Catch:{ JSONException -> 0x0092 }
            r7.<init>(r2, r3, r9, r8)     // Catch:{ JSONException -> 0x0092 }
            r0.add(r7)     // Catch:{ JSONException -> 0x0092 }
            boolean r2 = r1.moveToNext()     // Catch:{ JSONException -> 0x0092 }
            if (r2 != 0) goto L_0x001f
        L_0x0084:
            if (r1 == 0) goto L_0x00a3
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x00b1 }
            if (r2 != 0) goto L_0x00a3
        L_0x008c:
            r1.close()     // Catch:{ all -> 0x00b1 }
            goto L_0x00a3
        L_0x0090:
            r0 = move-exception
            goto L_0x00a5
        L_0x0092:
            r2 = move-exception
            com.onesignal.n1$a0 r3 = com.onesignal.C4564n1.C4566a0.ERROR     // Catch:{ all -> 0x0090 }
            java.lang.String r4 = "Generating JSONArray from iam click ids:JSON Failed."
            com.onesignal.C4564n1.m15790a((com.onesignal.C4564n1.C4566a0) r3, (java.lang.String) r4, (java.lang.Throwable) r2)     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x00a3
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x00b1 }
            if (r2 != 0) goto L_0x00a3
            goto L_0x008c
        L_0x00a3:
            monitor-exit(r11)
            return r0
        L_0x00a5:
            if (r1 == 0) goto L_0x00b0
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x00b1 }
            if (r2 != 0) goto L_0x00b0
            r1.close()     // Catch:{ all -> 0x00b1 }
        L_0x00b0:
            throw r0     // Catch:{ all -> 0x00b1 }
        L_0x00b1:
            r0 = move-exception
            monitor-exit(r11)
            goto L_0x00b5
        L_0x00b4:
            throw r0
        L_0x00b5:
            goto L_0x00b4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.C4641s0.mo29945b():java.util.List");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo29944a(C4535k0 k0Var) {
        SQLiteDatabase t = this.f12646a.mo29967t();
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_id", k0Var.f12392a);
        contentValues.put("display_quantity", Integer.valueOf(k0Var.mo29817d().mo29849a()));
        contentValues.put("last_display", Long.valueOf(k0Var.mo29817d().mo29853b()));
        contentValues.put("click_ids", k0Var.mo29813b().toString());
        contentValues.put("displayed_in_session", Boolean.valueOf(k0Var.mo29818e()));
        if (t.update("in_app_message", contentValues, "message_id = ?", new String[]{k0Var.f12392a}) == 0) {
            t.insert("in_app_message", (String) null, contentValues);
        }
    }
}
