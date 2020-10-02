package com.onesignal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.onesignal.q1 */
/* compiled from: OneSignalCacheCleaner */
class C4627q1 {

    /* renamed from: a */
    private static String f12618a = "OS_DELETE_OLD_CACHED_DATA";

    /* renamed from: com.onesignal.q1$a */
    /* compiled from: OneSignalCacheCleaner */
    static class C4628a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f12619a;

        C4628a(Context context) {
            this.f12619a = context;
        }

        public void run() {
            Thread.currentThread().setPriority(10);
            SQLiteDatabase t = C4655t1.m16157a(this.f12619a).mo29967t();
            C4627q1.m16013a();
            C4627q1.m16015a(t);
        }
    }

    /* renamed from: a */
    static void m16013a() {
    }

    /* renamed from: a */
    static synchronized void m16014a(Context context) {
        synchronized (C4627q1.class) {
            new Thread(new C4628a(context), f12618a).start();
        }
    }

    /* renamed from: b */
    private static void m16016b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete("notification", "created_time < " + ((System.currentTimeMillis() / 1000) - 604800), (String[]) null);
    }

    /* renamed from: c */
    static void m16017c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete("cached_unique_outcome_notification", "NOT EXISTS(SELECT NULL FROM notification n WHERE n.notification_id = notification_id)", (String[]) null);
    }

    /* renamed from: a */
    static void m16015a(SQLiteDatabase sQLiteDatabase) {
        m16016b(sQLiteDatabase);
        m16017c(sQLiteDatabase);
    }
}
