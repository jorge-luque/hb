package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import androidx.core.app.C0725i;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.List;

/* renamed from: com.onesignal.z */
/* compiled from: NotificationExtenderService */
public abstract class C4739z extends JobIntentService {

    /* renamed from: com.onesignal.z$a */
    /* compiled from: NotificationExtenderService */
    public static class C4740a {

        /* renamed from: a */
        public C0725i.C0731f f12865a;

        /* renamed from: b */
        public Integer f12866b;
    }

    /* renamed from: a */
    static Intent m16456a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent().setAction("com.onesignal.NotificationExtender").setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
        if (queryIntentServices.size() < 1) {
            return null;
        }
        intent.setComponent(new ComponentName(context, queryIntentServices.get(0).serviceInfo.name));
        return intent;
    }
}
