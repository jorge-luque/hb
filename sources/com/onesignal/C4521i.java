package com.onesignal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import com.ogury.p159cm.OguryChoiceManager;
import com.onesignal.C4564n1;
import com.onesignal.shortcutbadger.C4645b;
import com.onesignal.shortcutbadger.ShortcutBadgeException;

/* renamed from: com.onesignal.i */
/* compiled from: BadgeCountUpdater */
class C4521i {

    /* renamed from: a */
    private static int f12351a = -1;

    /* renamed from: a */
    private static boolean m15559a(Context context) {
        int i = f12351a;
        if (i != -1) {
            return i == 1;
        }
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE).metaData;
            if (bundle != null) {
                f12351a = "DISABLE".equals(bundle.getString("com.onesignal.BadgeCount")) ? 0 : 1;
            } else {
                f12351a = 1;
            }
        } catch (PackageManager.NameNotFoundException e) {
            f12351a = 0;
            C4564n1.m15790a(C4564n1.C4566a0.ERROR, "Error reading meta-data tag 'com.onesignal.BadgeCount'. Disabling badge setting.", (Throwable) e);
        }
        if (f12351a == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m15561b(Context context) {
        return m15559a(context) && C4536k1.m15626a(context);
    }

    /* renamed from: c */
    private static void m15562c(Context context) {
        int i = 0;
        for (StatusBarNotification a : C4676v1.m16255b(context)) {
            if (!C4476b0.m15425a(a)) {
                i++;
            }
        }
        m15557a(i, context);
    }

    /* renamed from: b */
    private static void m15560b(SQLiteDatabase sQLiteDatabase, Context context) {
        Cursor query = sQLiteDatabase.query("notification", (String[]) null, C4655t1.m16168v().toString(), (String[]) null, (String) null, (String) null, (String) null, C4476b0.f12290a);
        int count = query.getCount();
        query.close();
        m15557a(count, context);
    }

    /* renamed from: a */
    static void m15558a(SQLiteDatabase sQLiteDatabase, Context context) {
        if (m15561b(context)) {
            if (Build.VERSION.SDK_INT >= 23) {
                m15562c(context);
            } else {
                m15560b(sQLiteDatabase, context);
            }
        }
    }

    /* renamed from: a */
    static void m15557a(int i, Context context) {
        if (m15559a(context)) {
            try {
                C4645b.m16100a(context, i);
            } catch (ShortcutBadgeException unused) {
            }
        }
    }
}
