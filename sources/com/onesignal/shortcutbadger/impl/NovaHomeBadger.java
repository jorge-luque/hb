package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.onesignal.shortcutbadger.C4644a;
import com.onesignal.shortcutbadger.ShortcutBadgeException;
import java.util.Arrays;
import java.util.List;

public class NovaHomeBadger implements C4644a {
    /* renamed from: a */
    public void mo29955a(Context context, ComponentName componentName, int i) throws ShortcutBadgeException {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ViewHierarchyConstants.TAG_KEY, componentName.getPackageName() + "/" + componentName.getClassName());
        contentValues.put("count", Integer.valueOf(i));
        context.getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"), contentValues);
    }

    /* renamed from: a */
    public List<String> mo29954a() {
        return Arrays.asList(new String[]{"com.teslacoilsw.launcher"});
    }
}
