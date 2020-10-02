package com.onesignal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.onesignal.C4564n1;
import java.util.ArrayList;

/* renamed from: com.onesignal.t1 */
/* compiled from: OneSignalDbHelper */
public class C4655t1 extends SQLiteOpenHelper {

    /* renamed from: a */
    protected static final String[] f12661a = {"CREATE INDEX notification_notification_id_idx ON notification(notification_id); ", "CREATE INDEX notification_android_notification_id_idx ON notification(android_notification_id); ", "CREATE INDEX notification_group_id_idx ON notification(group_id); ", "CREATE INDEX notification_collapse_id_idx ON notification(collapse_id); ", "CREATE INDEX notification_created_time_idx ON notification(created_time); ", "CREATE INDEX notification_expire_time_idx ON notification(expire_time); "};

    /* renamed from: b */
    private static C4655t1 f12662b;

    C4655t1(Context context) {
        super(context, "OneSignal.db", (SQLiteDatabase.CursorFactory) null, m16167u());
    }

    /* renamed from: a */
    public static synchronized C4655t1 m16157a(Context context) {
        C4655t1 t1Var;
        synchronized (C4655t1.class) {
            if (f12662b == null) {
                f12662b = new C4655t1(context.getApplicationContext());
            }
            t1Var = f12662b;
        }
        return t1Var;
    }

    /* renamed from: b */
    private static void m16161b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("BEGIN TRANSACTION;");
            sQLiteDatabase.execSQL("CREATE TEMPORARY TABLE outcome_backup(" + "_id,name,session,timestamp,notification_ids" + ");");
            sQLiteDatabase.execSQL("INSERT INTO outcome_backup SELECT " + "_id,name,session,timestamp,notification_ids" + " FROM outcome;");
            sQLiteDatabase.execSQL("DROP TABLE outcome;");
            sQLiteDatabase.execSQL("CREATE TABLE outcome (_id INTEGER PRIMARY KEY,session TEXT,notification_ids TEXT,name TEXT,timestamp TIMESTAMP,weight FLOAT);");
            sQLiteDatabase.execSQL("INSERT INTO outcome (" + "_id,name,session,timestamp,notification_ids" + ", weight) SELECT " + "_id,name,session,timestamp,notification_ids" + ", 0 FROM outcome_backup;");
            sQLiteDatabase.execSQL("DROP TABLE outcome_backup;");
            sQLiteDatabase.execSQL("COMMIT;");
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private static void m16162c(SQLiteDatabase sQLiteDatabase) {
        m16160a(sQLiteDatabase, "ALTER TABLE notification ADD COLUMN collapse_id TEXT;");
        m16160a(sQLiteDatabase, "CREATE INDEX notification_group_id_idx ON notification(group_id); ");
    }

    /* renamed from: e */
    private static void m16164e(SQLiteDatabase sQLiteDatabase) {
        m16160a(sQLiteDatabase, "CREATE TABLE outcome (_id INTEGER PRIMARY KEY,session TEXT,notification_ids TEXT,name TEXT,timestamp TIMESTAMP,weight FLOAT);");
    }

    /* renamed from: f */
    private static void m16165f(SQLiteDatabase sQLiteDatabase) {
        m16160a(sQLiteDatabase, "CREATE TABLE cached_unique_outcome_notification (_id INTEGER PRIMARY KEY,notification_id TEXT,name TEXT);");
        m16161b(sQLiteDatabase);
    }

    /* renamed from: g */
    private static void m16166g(SQLiteDatabase sQLiteDatabase) {
        m16160a(sQLiteDatabase, "CREATE TABLE in_app_message (_id INTEGER PRIMARY KEY,display_quantity INTEGER,last_display INTEGER,message_id TEXT,displayed_in_session INTEGER,click_ids TEXT);");
    }

    /* renamed from: u */
    private static int m16167u() {
        return 7;
    }

    /* renamed from: v */
    static StringBuilder m16168v() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder("created_time > " + (currentTimeMillis - 604800) + " AND " + "dismissed" + " = 0 AND " + "opened" + " = 0 AND " + "is_summary" + " = 0");
        if (C4698w1.m16348a(C4698w1.f12761a, "OS_RESTORE_TTL_FILTER", true)) {
            sb.append(" AND expire_time > " + currentTimeMillis);
        }
        return sb;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized SQLiteDatabase mo29963d() {
        int i = 0;
        while (true) {
            try {
            } catch (SQLiteCantOpenDatabaseException e) {
                i++;
                if (i < 5) {
                    SystemClock.sleep((long) (i * 400));
                } else {
                    throw e;
                }
            }
        }
        return getReadableDatabase();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE notification (_id INTEGER PRIMARY KEY,notification_id TEXT,android_notification_id INTEGER,group_id TEXT,collapse_id TEXT,is_summary INTEGER DEFAULT 0,opened INTEGER DEFAULT 0,dismissed INTEGER DEFAULT 0,title TEXT,message TEXT,full_data TEXT,created_time TIMESTAMP DEFAULT (strftime('%s', 'now')),expire_time TIMESTAMP);");
        sQLiteDatabase.execSQL("CREATE TABLE outcome (_id INTEGER PRIMARY KEY,session TEXT,notification_ids TEXT,name TEXT,timestamp TIMESTAMP,weight FLOAT);");
        sQLiteDatabase.execSQL("CREATE TABLE cached_unique_outcome_notification (_id INTEGER PRIMARY KEY,notification_id TEXT,name TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE in_app_message (_id INTEGER PRIMARY KEY,display_quantity INTEGER,last_display INTEGER,message_id TEXT,displayed_in_session INTEGER,click_ids TEXT);");
        for (String execSQL : f12661a) {
            sQLiteDatabase.execSQL(execSQL);
        }
    }

    /* JADX INFO: finally extract failed */
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C4564n1.m15789a(C4564n1.C4566a0.WARN, "SDK version rolled back! Clearing OneSignal.db as it could be in an unexpected state.");
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", (String[]) null);
        try {
            ArrayList<String> arrayList = new ArrayList<>(rawQuery.getCount());
            while (rawQuery.moveToNext()) {
                arrayList.add(rawQuery.getString(0));
            }
            for (String str : arrayList) {
                if (!str.startsWith("sqlite_")) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                }
            }
            rawQuery.close();
            onCreate(sQLiteDatabase);
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            m16159a(sQLiteDatabase, i);
        } catch (SQLiteException e) {
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Error in upgrade, migration may have already run! Skipping!", (Throwable) e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public synchronized SQLiteDatabase mo29967t() {
        int i = 0;
        while (true) {
            try {
            } catch (SQLiteCantOpenDatabaseException e) {
                i++;
                if (i < 5) {
                    SystemClock.sleep((long) (i * 400));
                } else {
                    throw e;
                }
            }
        }
        return getWritableDatabase();
    }

    /* renamed from: a */
    private static void m16159a(SQLiteDatabase sQLiteDatabase, int i) {
        if (i < 2) {
            m16162c(sQLiteDatabase);
        }
        if (i < 3) {
            m16163d(sQLiteDatabase);
        }
        if (i < 4) {
            m16164e(sQLiteDatabase);
        }
        if (i < 5) {
            m16165f(sQLiteDatabase);
        }
        if (i == 5) {
            m16158a(sQLiteDatabase);
        }
        if (i < 7) {
            m16166g(sQLiteDatabase);
        }
    }

    /* renamed from: d */
    private static void m16163d(SQLiteDatabase sQLiteDatabase) {
        m16160a(sQLiteDatabase, "ALTER TABLE notification ADD COLUMN expire_time TIMESTAMP;");
        m16160a(sQLiteDatabase, "UPDATE notification SET expire_time = created_time + 259200;");
        m16160a(sQLiteDatabase, "CREATE INDEX notification_expire_time_idx ON notification(expire_time); ");
    }

    /* renamed from: a */
    private static void m16158a(SQLiteDatabase sQLiteDatabase) {
        m16161b(sQLiteDatabase);
    }

    /* renamed from: a */
    private static void m16160a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }
}
