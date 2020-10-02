package com.onesignal.shortcutbadger.impl;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.onesignal.shortcutbadger.C4644a;
import com.onesignal.shortcutbadger.ShortcutBadgeException;
import java.util.Collections;
import java.util.List;

public class ZukHomeBadger implements C4644a {

    /* renamed from: a */
    private final Uri f12657a = Uri.parse("content://com.android.badge/badge");

    @TargetApi(11)
    /* renamed from: a */
    public void mo29955a(Context context, ComponentName componentName, int i) throws ShortcutBadgeException {
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", i);
        context.getContentResolver().call(this.f12657a, "setAppBadgeCount", (String) null, bundle);
    }

    /* renamed from: a */
    public List<String> mo29954a() {
        return Collections.singletonList("com.zui.launcher");
    }
}
