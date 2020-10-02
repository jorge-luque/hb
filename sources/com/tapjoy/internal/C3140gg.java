package com.tapjoy.internal;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tapjoy.internal.gg */
class C3140gg extends C3137gf {

    /* renamed from: b */
    private final File f8738b;

    /* renamed from: c */
    private final C3144gy f8739c;

    /* renamed from: d */
    private volatile SQLiteDatabase f8740d;

    /* renamed from: e */
    private long f8741e;

    /* renamed from: f */
    private long f8742f;

    /* renamed from: g */
    private long f8743g;

    public C3140gg(File file, C3144gy gyVar) {
        this.f8738b = file;
        this.f8739c = gyVar;
    }

    /* renamed from: b */
    private void m10304b() {
        HashMap hashMap;
        Set set = C3137gf.f8730a;
        String str = null;
        Cursor rawQuery = this.f8740d.rawQuery("SELECT ROWID, * FROM UsageStats ORDER BY ROWID ASC", (String[]) null);
        try {
            rawQuery = this.f8740d.rawQuery("SELECT * FROM UsageStatValues ORDER BY stat_id ASC", (String[]) null);
            rawQuery.moveToNext();
            while (rawQuery.moveToNext()) {
                int i = 0;
                long j = rawQuery.getLong(0);
                int i2 = 1;
                String string = rawQuery.getString(1);
                String string2 = rawQuery.getString(2);
                String str2 = string2.isEmpty() ? str : string2;
                int i3 = rawQuery.getInt(3);
                long j2 = rawQuery.getLong(4);
                long j3 = rawQuery.getLong(5);
                if (!rawQuery.isAfterLast()) {
                    hashMap = null;
                    while (true) {
                        if (rawQuery.getLong(i) != j) {
                            break;
                        }
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        String string3 = rawQuery.getString(i2);
                        long j4 = rawQuery.getLong(3);
                        long j5 = rawQuery.getLong(4);
                        hashMap.put(string3, Long.valueOf(j4));
                        hashMap.put(string3 + "_max", Long.valueOf(j5));
                        if (!rawQuery.moveToNext()) {
                            break;
                        }
                        i = 0;
                        i2 = 1;
                    }
                } else {
                    hashMap = null;
                }
                if (set != null) {
                    if (set.contains(string)) {
                        str = null;
                    }
                }
                this.f8739c.mo18541a(string, str2, i3, j2, j3, (Map) hashMap);
                str = null;
            }
            rawQuery.close();
            this.f8740d.execSQL("DELETE FROM UsageStats");
            this.f8740d.execSQL("DELETE FROM UsageStatValues");
            this.f8743g = 0;
            this.f8742f = 0;
        } catch (Throwable th) {
            throw th;
        } finally {
            rawQuery.close();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo18518a(long j) {
        if (this.f8740d == null) {
            this.f8740d = SQLiteDatabase.openOrCreateDatabase(this.f8738b, (SQLiteDatabase.CursorFactory) null);
            int version = this.f8740d.getVersion();
            if (version == 0) {
                this.f8740d.beginTransaction();
                try {
                    this.f8740d.execSQL("CREATE TABLE IF NOT EXISTS UsageStats(name TEXT,dimensions TEXT,count INTEGER,first_time INTEGER,last_time INTEGER,PRIMARY KEY(name, dimensions))");
                    this.f8740d.execSQL("CREATE TABLE IF NOT EXISTS UsageStatValues(stat_id LONG,name TEXT,count INTEGER,avg REAL,max INTEGER,PRIMARY KEY(stat_id, name))");
                    this.f8740d.setVersion(1);
                    this.f8740d.setTransactionSuccessful();
                } finally {
                    this.f8740d.endTransaction();
                }
            } else if (version != 1) {
                throw new SQLException("Unknown database version: " + version);
            }
            Cursor rawQuery = this.f8740d.rawQuery("SELECT MIN(first_time), MAX(last_time) FROM UsageStats", (String[]) null);
            try {
                if (rawQuery.moveToNext()) {
                    this.f8742f = rawQuery.getLong(0);
                    this.f8743g = rawQuery.getLong(1);
                }
                rawQuery.close();
                long j2 = this.f8742f;
                if (j2 > 0 && j2 + 86400000 <= j) {
                    m10304b();
                }
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (this.f8740d != null) {
            C3168jz.m10439a(this.f8740d);
            this.f8740d = null;
        }
        super.finalize();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo18517a() {
        if (this.f8740d != null) {
            C3168jz.m10439a(this.f8740d);
            this.f8740d = null;
        }
        this.f8738b.delete();
        this.f8743g = 0;
        this.f8742f = 0;
    }

    /* access modifiers changed from: protected */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v19, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v22, resolved type: android.database.Cursor} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo18519a(long r28, java.lang.String r30, @javax.annotation.Nullable java.lang.String r31, @javax.annotation.Nullable java.util.Map r32) {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            r0 = r30
            android.database.sqlite.SQLiteDatabase r4 = r1.f8740d
            if (r4 != 0) goto L_0x000b
            return
        L_0x000b:
            long r4 = r1.f8741e
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0018
            r1.f8743g = r2
            r1.f8741e = r2
            goto L_0x0044
        L_0x0018:
            r6 = 86400000(0x5265c00, double:4.2687272E-316)
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x002d
            long r4 = r4 + r6
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x002d
            long r4 = r1.f8743g
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0044
            r1.f8743g = r2
            goto L_0x0044
        L_0x002d:
            long r4 = r1.f8741e
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x003d
            long r4 = r1.f8743g
            long r4 = r4 - r2
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x003d
            r1.f8741e = r2
            goto L_0x0044
        L_0x003d:
            r27.m10304b()
            r1.f8743g = r2
            r1.f8741e = r2
        L_0x0044:
            if (r31 != 0) goto L_0x0049
            java.lang.String r4 = ""
            goto L_0x004b
        L_0x0049:
            r4 = r31
        L_0x004b:
            android.database.sqlite.SQLiteDatabase r5 = r1.f8740d
            r6 = 2
            java.lang.String[] r7 = new java.lang.String[r6]
            r8 = 0
            r7[r8] = r0
            r9 = 1
            r7[r9] = r4
            java.lang.String r10 = "SELECT ROWID,count,first_time,last_time FROM UsageStats WHERE name = ? AND dimensions = ?"
            android.database.Cursor r5 = r5.rawQuery(r10, r7)
            android.content.ContentValues r7 = new android.content.ContentValues     // Catch:{ all -> 0x01f6 }
            r7.<init>()     // Catch:{ all -> 0x01f6 }
            boolean r10 = r5.moveToNext()     // Catch:{ all -> 0x01f6 }
            java.lang.String r11 = "ROWID = "
            java.lang.String r12 = "UsageStats"
            java.lang.String r13 = "last_time"
            java.lang.String r14 = "first_time"
            java.lang.String r15 = "name"
            java.lang.String r6 = "count"
            if (r10 == 0) goto L_0x00bf
            r17 = r11
            long r10 = r5.getLong(r8)     // Catch:{ all -> 0x01f6 }
            int r0 = r5.getInt(r9)     // Catch:{ all -> 0x01f6 }
            r4 = 2
            long r18 = r5.getLong(r4)     // Catch:{ all -> 0x01f6 }
            r4 = 3
            long r20 = r5.getLong(r4)     // Catch:{ all -> 0x01f6 }
            int r0 = r0 + r9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x01f6 }
            r7.put(r6, r0)     // Catch:{ all -> 0x01f6 }
            int r0 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r0 >= 0) goto L_0x009a
            java.lang.Long r0 = java.lang.Long.valueOf(r28)     // Catch:{ all -> 0x01f6 }
            r7.put(r14, r0)     // Catch:{ all -> 0x01f6 }
        L_0x009a:
            int r0 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a5
            java.lang.Long r0 = java.lang.Long.valueOf(r28)     // Catch:{ all -> 0x01f6 }
            r7.put(r13, r0)     // Catch:{ all -> 0x01f6 }
        L_0x00a5:
            android.database.sqlite.SQLiteDatabase r0 = r1.f8740d     // Catch:{ all -> 0x01f6 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f6 }
            r3 = r17
            r2.<init>(r3)     // Catch:{ all -> 0x01f6 }
            r2.append(r10)     // Catch:{ all -> 0x01f6 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01f6 }
            r4 = 0
            r0.update(r12, r7, r2, r4)     // Catch:{ all -> 0x01f6 }
            r25 = r10
            r10 = r3
            r3 = r25
            goto L_0x00e4
        L_0x00bf:
            r10 = r11
            r7.put(r15, r0)     // Catch:{ all -> 0x01f6 }
            java.lang.String r0 = "dimensions"
            r7.put(r0, r4)     // Catch:{ all -> 0x01f6 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x01f6 }
            r7.put(r6, r0)     // Catch:{ all -> 0x01f6 }
            java.lang.Long r0 = java.lang.Long.valueOf(r28)     // Catch:{ all -> 0x01f6 }
            r7.put(r14, r0)     // Catch:{ all -> 0x01f6 }
            java.lang.Long r0 = java.lang.Long.valueOf(r28)     // Catch:{ all -> 0x01f6 }
            r7.put(r13, r0)     // Catch:{ all -> 0x01f6 }
            android.database.sqlite.SQLiteDatabase r0 = r1.f8740d     // Catch:{ all -> 0x01f6 }
            r2 = 0
            long r3 = r0.insert(r12, r2, r7)     // Catch:{ all -> 0x01f6 }
        L_0x00e4:
            if (r32 == 0) goto L_0x01f1
            boolean r0 = r32.isEmpty()     // Catch:{ all -> 0x01f6 }
            if (r0 != 0) goto L_0x01f1
            java.util.Set r0 = r32.entrySet()     // Catch:{ all -> 0x01f6 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x01f6 }
        L_0x00f4:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x01f6 }
            if (r2 == 0) goto L_0x01f1
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x01f6 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x01f6 }
            java.lang.Object r11 = r2.getValue()     // Catch:{ all -> 0x01f6 }
            if (r11 == 0) goto L_0x01ea
            java.lang.Object r11 = r2.getKey()     // Catch:{ all -> 0x01f6 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x01f6 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x01f6 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x01f6 }
            long r12 = r2.longValue()     // Catch:{ all -> 0x01f6 }
            r2 = 2
            java.lang.String[] r14 = new java.lang.String[r2]     // Catch:{ all -> 0x01f6 }
            java.lang.String r16 = java.lang.Long.toString(r3)     // Catch:{ all -> 0x01f6 }
            r14[r8] = r16     // Catch:{ all -> 0x01f6 }
            r14[r9] = r11     // Catch:{ all -> 0x01f6 }
            android.database.sqlite.SQLiteDatabase r2 = r1.f8740d     // Catch:{ all -> 0x01f6 }
            java.lang.String r9 = "SELECT ROWID, * FROM UsageStatValues WHERE stat_id = ? AND name = ?"
            android.database.Cursor r2 = r2.rawQuery(r9, r14)     // Catch:{ all -> 0x01f6 }
            boolean r9 = r2.moveToNext()     // Catch:{ all -> 0x01e2 }
            java.lang.String r14 = "UsageStatValues"
            java.lang.String r8 = "max"
            r28 = r0
            java.lang.String r0 = "avg"
            if (r9 == 0) goto L_0x019c
            r29 = r3
            r9 = 0
            long r3 = r2.getLong(r9)     // Catch:{ all -> 0x01e2 }
            r11 = 3
            int r18 = r2.getInt(r11)     // Catch:{ all -> 0x01e2 }
            r9 = 4
            double r20 = r2.getDouble(r9)     // Catch:{ all -> 0x01e2 }
            r9 = 5
            long r22 = r2.getLong(r9)     // Catch:{ all -> 0x01e2 }
            r7.clear()     // Catch:{ all -> 0x01e2 }
            r9 = 1
            int r11 = r18 + 1
            java.lang.Integer r9 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x01e2 }
            r7.put(r6, r9)     // Catch:{ all -> 0x01e2 }
            r9 = r5
            r18 = r6
            double r5 = (double) r12
            java.lang.Double.isNaN(r5)
            double r5 = r5 - r20
            r32 = r14
            r24 = r15
            double r14 = (double) r11
            java.lang.Double.isNaN(r14)
            double r5 = r5 / r14
            double r20 = r20 + r5
            java.lang.Double r5 = java.lang.Double.valueOf(r20)     // Catch:{ all -> 0x01e0 }
            r7.put(r0, r5)     // Catch:{ all -> 0x01e0 }
            int r0 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r0 <= 0) goto L_0x0180
            java.lang.Long r0 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x01e0 }
            r7.put(r8, r0)     // Catch:{ all -> 0x01e0 }
        L_0x0180:
            android.database.sqlite.SQLiteDatabase r0 = r1.f8740d     // Catch:{ all -> 0x01e0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e0 }
            r5.<init>(r10)     // Catch:{ all -> 0x01e0 }
            r5.append(r3)     // Catch:{ all -> 0x01e0 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x01e0 }
            r4 = r32
            r5 = 0
            r0.update(r4, r7, r3, r5)     // Catch:{ all -> 0x01e0 }
            r14 = r18
            r5 = r24
            r3 = 3
            r6 = 1
            r8 = 0
            goto L_0x01d4
        L_0x019c:
            r29 = r3
            r9 = r5
            r18 = r6
            r4 = r14
            r24 = r15
            r3 = 3
            r7.clear()     // Catch:{ all -> 0x01e0 }
            java.lang.String r5 = "stat_id"
            java.lang.Long r6 = java.lang.Long.valueOf(r29)     // Catch:{ all -> 0x01e0 }
            r7.put(r5, r6)     // Catch:{ all -> 0x01e0 }
            r5 = r24
            r7.put(r5, r11)     // Catch:{ all -> 0x01e0 }
            r6 = 1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01e0 }
            r14 = r18
            r7.put(r14, r11)     // Catch:{ all -> 0x01e0 }
            java.lang.Long r11 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x01e0 }
            r7.put(r0, r11)     // Catch:{ all -> 0x01e0 }
            java.lang.Long r0 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x01e0 }
            r7.put(r8, r0)     // Catch:{ all -> 0x01e0 }
            android.database.sqlite.SQLiteDatabase r0 = r1.f8740d     // Catch:{ all -> 0x01e0 }
            r8 = 0
            r0.insert(r4, r8, r7)     // Catch:{ all -> 0x01e0 }
        L_0x01d4:
            r2.close()     // Catch:{ all -> 0x01e8 }
            r0 = r28
            r3 = r29
            r15 = r5
            r5 = r9
            r6 = r14
            r8 = 0
            goto L_0x01ee
        L_0x01e0:
            r0 = move-exception
            goto L_0x01e4
        L_0x01e2:
            r0 = move-exception
            r9 = r5
        L_0x01e4:
            r2.close()     // Catch:{ all -> 0x01e8 }
            throw r0     // Catch:{ all -> 0x01e8 }
        L_0x01e8:
            r0 = move-exception
            goto L_0x01f8
        L_0x01ea:
            r9 = r5
            r14 = r6
            r6 = 1
            r6 = r14
        L_0x01ee:
            r9 = 1
            goto L_0x00f4
        L_0x01f1:
            r9 = r5
            r9.close()
            return
        L_0x01f6:
            r0 = move-exception
            r9 = r5
        L_0x01f8:
            r9.close()
            goto L_0x01fd
        L_0x01fc:
            throw r0
        L_0x01fd:
            goto L_0x01fc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3140gg.mo18519a(long, java.lang.String, java.lang.String, java.util.Map):void");
    }
}
