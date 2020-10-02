package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.onesignal.shortcutbadger.C4644a;
import com.onesignal.shortcutbadger.ShortcutBadgeException;
import com.onesignal.shortcutbadger.p161c.C4646a;
import java.util.ArrayList;
import java.util.List;

public class DefaultBadger implements C4644a {
    /* renamed from: a */
    public void mo29955a(Context context, ComponentName componentName, int i) throws ShortcutBadgeException {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", i);
        intent.putExtra("badge_count_package_name", componentName.getPackageName());
        intent.putExtra("badge_count_class_name", componentName.getClassName());
        if (C4646a.m16102a(context, intent)) {
            context.sendBroadcast(intent);
            return;
        }
        throw new ShortcutBadgeException("unable to resolve intent: " + intent.toString());
    }

    /* renamed from: a */
    public List<String> mo29954a() {
        return new ArrayList(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo29956a(Context context) {
        return C4646a.m16102a(context, new Intent("android.intent.action.BADGE_COUNT_UPDATE"));
    }
}
