package com.onesignal.shortcutbadger.p161c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import java.util.List;

/* renamed from: com.onesignal.shortcutbadger.c.a */
/* compiled from: BroadcastHelper */
public class C4646a {
    /* renamed from: a */
    public static boolean m16102a(Context context, Intent intent) {
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            return false;
        }
        return true;
    }
}
