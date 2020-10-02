package com.onesignal.shortcutbadger.impl;

import android.content.AsyncQueryHandler;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import com.onesignal.shortcutbadger.C4644a;
import com.onesignal.shortcutbadger.ShortcutBadgeException;
import java.util.Arrays;
import java.util.List;

public class SonyHomeBadger implements C4644a {

    /* renamed from: a */
    private final Uri f12654a = Uri.parse("content://com.sonymobile.home.resourceprovider/badge");

    /* renamed from: b */
    private AsyncQueryHandler f12655b;

    /* renamed from: com.onesignal.shortcutbadger.impl.SonyHomeBadger$a */
    class C4648a extends AsyncQueryHandler {
        C4648a(SonyHomeBadger sonyHomeBadger, ContentResolver contentResolver) {
            super(contentResolver);
        }
    }

    /* renamed from: b */
    private static void m16137b(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", componentName.getPackageName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", componentName.getClassName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(i));
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", i > 0);
        context.sendBroadcast(intent);
    }

    /* renamed from: c */
    private void m16138c(Context context, ComponentName componentName, int i) {
        if (i >= 0) {
            ContentValues a = m16133a(i, componentName);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.f12655b == null) {
                    this.f12655b = new C4648a(this, context.getApplicationContext().getContentResolver());
                }
                m16134a(a);
                return;
            }
            m16135a(context, a);
        }
    }

    /* renamed from: a */
    public void mo29955a(Context context, ComponentName componentName, int i) throws ShortcutBadgeException {
        if (m16136a(context)) {
            m16138c(context, componentName, i);
        } else {
            m16137b(context, componentName, i);
        }
    }

    /* renamed from: a */
    public List<String> mo29954a() {
        return Arrays.asList(new String[]{"com.sonyericsson.home", "com.sonymobile.home"});
    }

    /* renamed from: a */
    private void m16134a(ContentValues contentValues) {
        this.f12655b.startInsert(0, (Object) null, this.f12654a, contentValues);
    }

    /* renamed from: a */
    private void m16135a(Context context, ContentValues contentValues) {
        context.getApplicationContext().getContentResolver().insert(this.f12654a, contentValues);
    }

    /* renamed from: a */
    private ContentValues m16133a(int i, ComponentName componentName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("badge_count", Integer.valueOf(i));
        contentValues.put("package_name", componentName.getPackageName());
        contentValues.put("activity_name", componentName.getClassName());
        return contentValues;
    }

    /* renamed from: a */
    private static boolean m16136a(Context context) {
        return context.getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0) != null;
    }
}
