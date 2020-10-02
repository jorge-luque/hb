package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.onesignal.shortcutbadger.C4644a;
import com.onesignal.shortcutbadger.ShortcutBadgeException;
import java.util.Arrays;
import java.util.List;

public class EverythingMeHomeBadger implements C4644a {
    /* renamed from: a */
    public void mo29955a(Context context, ComponentName componentName, int i) throws ShortcutBadgeException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("package_name", componentName.getPackageName());
        contentValues.put("activity_name", componentName.getClassName());
        contentValues.put("count", Integer.valueOf(i));
        context.getContentResolver().insert(Uri.parse("content://me.everything.badger/apps"), contentValues);
    }

    /* renamed from: a */
    public List<String> mo29954a() {
        return Arrays.asList(new String[]{"me.everything.launcher"});
    }
}
