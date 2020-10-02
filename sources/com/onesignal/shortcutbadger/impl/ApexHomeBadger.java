package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.onesignal.shortcutbadger.C4644a;
import com.onesignal.shortcutbadger.ShortcutBadgeException;
import com.onesignal.shortcutbadger.p161c.C4646a;
import java.util.Arrays;
import java.util.List;

public class ApexHomeBadger implements C4644a {
    /* renamed from: a */
    public void mo29955a(Context context, ComponentName componentName, int i) throws ShortcutBadgeException {
        Intent intent = new Intent("com.anddoes.launcher.COUNTER_CHANGED");
        intent.putExtra("package", componentName.getPackageName());
        intent.putExtra("count", i);
        intent.putExtra("class", componentName.getClassName());
        if (C4646a.m16102a(context, intent)) {
            context.sendBroadcast(intent);
            return;
        }
        throw new ShortcutBadgeException("unable to resolve intent: " + intent.toString());
    }

    /* renamed from: a */
    public List<String> mo29954a() {
        return Arrays.asList(new String[]{"com.anddoes.launcher"});
    }
}
