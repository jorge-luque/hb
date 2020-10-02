package com.onesignal.shortcutbadger;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;
import com.onesignal.shortcutbadger.impl.AdwHomeBadger;
import com.onesignal.shortcutbadger.impl.ApexHomeBadger;
import com.onesignal.shortcutbadger.impl.C4649a;
import com.onesignal.shortcutbadger.impl.DefaultBadger;
import com.onesignal.shortcutbadger.impl.EverythingMeHomeBadger;
import com.onesignal.shortcutbadger.impl.HuaweiHomeBadger;
import com.onesignal.shortcutbadger.impl.NewHtcHomeBadger;
import com.onesignal.shortcutbadger.impl.NovaHomeBadger;
import com.onesignal.shortcutbadger.impl.OPPOHomeBader;
import com.onesignal.shortcutbadger.impl.SamsungHomeBadger;
import com.onesignal.shortcutbadger.impl.SonyHomeBadger;
import com.onesignal.shortcutbadger.impl.VivoHomeBadger;
import com.onesignal.shortcutbadger.impl.ZukHomeBadger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.onesignal.shortcutbadger.b */
/* compiled from: ShortcutBadger */
public final class C4645b {

    /* renamed from: a */
    private static final List<Class<? extends C4644a>> f12648a = new LinkedList();

    /* renamed from: b */
    private static C4644a f12649b;

    /* renamed from: c */
    private static ComponentName f12650c;

    static {
        f12648a.add(AdwHomeBadger.class);
        f12648a.add(ApexHomeBadger.class);
        f12648a.add(NewHtcHomeBadger.class);
        f12648a.add(NovaHomeBadger.class);
        f12648a.add(SonyHomeBadger.class);
        f12648a.add(C4649a.class);
        f12648a.add(HuaweiHomeBadger.class);
        f12648a.add(OPPOHomeBader.class);
        f12648a.add(SamsungHomeBadger.class);
        f12648a.add(ZukHomeBadger.class);
        f12648a.add(VivoHomeBadger.class);
        f12648a.add(EverythingMeHomeBadger.class);
    }

    /* renamed from: a */
    public static void m16100a(Context context, int i) throws ShortcutBadgeException {
        if (f12649b != null || m16101a(context)) {
            try {
                f12649b.mo29955a(context, f12650c, i);
            } catch (Exception e) {
                throw new ShortcutBadgeException("Unable to execute badge", e);
            }
        } else {
            throw new ShortcutBadgeException("No default launcher available");
        }
    }

    /* renamed from: a */
    private static boolean m16101a(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            Log.e("ShortcutBadger", "Unable to find launch intent for package " + context.getPackageName());
            return false;
        }
        f12650c = launchIntentForPackage.getComponent();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo.name.toLowerCase().contains("resolver")) {
            return false;
        }
        String str = resolveActivity.activityInfo.packageName;
        Iterator<Class<? extends C4644a>> it = f12648a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C4644a aVar = null;
            try {
                aVar = (C4644a) it.next().newInstance();
            } catch (Exception unused) {
            }
            if (aVar != null && aVar.mo29954a().contains(str)) {
                f12649b = aVar;
                break;
            }
        }
        if (f12649b != null) {
            return true;
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("ZUK")) {
            f12649b = new ZukHomeBadger();
            return true;
        } else if (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            f12649b = new OPPOHomeBader();
            return true;
        } else if (Build.MANUFACTURER.equalsIgnoreCase("VIVO")) {
            f12649b = new VivoHomeBadger();
            return true;
        } else {
            f12649b = new DefaultBadger();
            return true;
        }
    }
}
