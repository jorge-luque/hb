package com.tapjoy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.google.android.gms.drive.DriveFile;
import com.tapjoy.internal.C3144gy;
import com.tapjoy.internal.C3145gz;
import com.tapjoy.internal.C3147hb;
import com.tapjoy.internal.C5041ev;
import com.tapjoy.internal.C5050ey;
import com.tapjoy.internal.C5062fc;
import com.tapjoy.internal.C5139gw;
import com.tapjoy.internal.C5160hk;
import java.util.List;

public class TapjoyReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Intent intent2;
        C3147hb.m10351b(context);
        if ("com.tapjoy.PUSH_CLICK".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("com.tapjoy.PUSH_ID");
            String stringExtra2 = intent.getStringExtra(Tapjoy.INTENT_EXTRA_PUSH_PAYLOAD);
            String stringExtra3 = intent.getStringExtra("com.tapjoy.PUSH_PLACEMENT");
            if (!(stringExtra == null || stringExtra.length() == 0)) {
                PackageManager packageManager = context.getPackageManager();
                String packageName = context.getPackageName();
                Intent intent3 = new Intent("android.intent.action.MAIN");
                intent3.setPackage(packageName);
                intent3.addCategory("android.intent.category.LAUNCHER");
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent3, 0);
                if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                    intent2 = null;
                } else {
                    intent2 = new Intent(intent3);
                    intent2.setFlags(DriveFile.MODE_READ_ONLY);
                    intent2.setClassName(queryIntentActivities.get(0).activityInfo.packageName, queryIntentActivities.get(0).activityInfo.name);
                }
                if (intent2 != null) {
                    if (stringExtra2 != null) {
                        intent2.putExtra(Tapjoy.INTENT_EXTRA_PUSH_PAYLOAD, stringExtra2);
                    }
                    C3145gz a = C3145gz.m10322a(context);
                    if (a.f8762f.mo18592c(stringExtra)) {
                        C3144gy gyVar = a.f8763g;
                        C5041ev.C5042a a2 = gyVar.mo18538a(C5050ey.APP, "push_click");
                        a2.f13710s = new C5062fc((String) null, (String) null, stringExtra);
                        gyVar.mo18539a(a2);
                    }
                    if (stringExtra3 != null) {
                        C5160hk.m17381a(stringExtra, stringExtra3);
                    }
                    context.startActivity(intent2);
                } else {
                    C5139gw.m17328b("No intent that can be used to launch the main activity.");
                }
            }
        }
        if (isOrderedBroadcast()) {
            setResult(-1, (String) null, (Bundle) null);
        }
    }
}
