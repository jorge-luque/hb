package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.onesignal.shortcutbadger.C4644a;
import com.onesignal.shortcutbadger.ShortcutBadgeException;
import com.onesignal.shortcutbadger.p161c.C4647b;
import java.util.Arrays;
import java.util.List;

public class SamsungHomeBadger implements C4644a {

    /* renamed from: b */
    private static final String[] f12652b = {"_id", "class"};

    /* renamed from: a */
    private DefaultBadger f12653a;

    public SamsungHomeBadger() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f12653a = new DefaultBadger();
        }
    }

    /* renamed from: a */
    public void mo29955a(Context context, ComponentName componentName, int i) throws ShortcutBadgeException {
        DefaultBadger defaultBadger = this.f12653a;
        if (defaultBadger == null || !defaultBadger.mo29956a(context)) {
            Uri parse = Uri.parse("content://com.sec.badge/apps?notify=true");
            ContentResolver contentResolver = context.getContentResolver();
            Cursor cursor = null;
            try {
                cursor = contentResolver.query(parse, f12652b, "package=?", new String[]{componentName.getPackageName()}, (String) null);
                if (cursor != null) {
                    String className = componentName.getClassName();
                    boolean z = false;
                    while (cursor.moveToNext()) {
                        int i2 = cursor.getInt(0);
                        contentResolver.update(parse, m16130a(componentName, i, false), "_id=?", new String[]{String.valueOf(i2)});
                        if (className.equals(cursor.getString(cursor.getColumnIndex("class")))) {
                            z = true;
                        }
                    }
                    if (!z) {
                        contentResolver.insert(parse, m16130a(componentName, i, true));
                    }
                }
            } finally {
                C4647b.m16103a(cursor);
            }
        } else {
            this.f12653a.mo29955a(context, componentName, i);
        }
    }

    /* renamed from: a */
    private ContentValues m16130a(ComponentName componentName, int i, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("package", componentName.getPackageName());
            contentValues.put("class", componentName.getClassName());
        }
        contentValues.put("badgecount", Integer.valueOf(i));
        return contentValues;
    }

    /* renamed from: a */
    public List<String> mo29954a() {
        return Arrays.asList(new String[]{"com.sec.android.app.launcher", "com.sec.android.app.twlauncher"});
    }
}
