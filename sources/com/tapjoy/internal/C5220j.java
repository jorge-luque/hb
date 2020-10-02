package com.tapjoy.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.tapjoy.internal.j */
public class C5220j extends BroadcastReceiver {
    /* access modifiers changed from: protected */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo31438a(android.content.Context r8, android.content.Intent r9) {
        /*
            r7 = this;
            android.content.ComponentName r0 = new android.content.ComponentName
            java.lang.Class r1 = r7.getClass()
            r0.<init>(r8, r1)
            r1 = 0
            android.content.pm.PackageManager r2 = r8.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0053 }
            r3 = 128(0x80, float:1.794E-43)
            android.content.pm.ActivityInfo r0 = r2.getReceiverInfo(r0, r3)     // Catch:{ NameNotFoundException -> 0x0053 }
            android.os.Bundle r0 = r0.metaData     // Catch:{ NameNotFoundException -> 0x0053 }
            if (r0 == 0) goto L_0x0053
            java.util.Set r2 = r0.keySet()     // Catch:{ NameNotFoundException -> 0x0053 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ NameNotFoundException -> 0x0053 }
        L_0x0020:
            boolean r3 = r2.hasNext()     // Catch:{ NameNotFoundException -> 0x0053 }
            if (r3 == 0) goto L_0x0053
            java.lang.Object r3 = r2.next()     // Catch:{ NameNotFoundException -> 0x0053 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ NameNotFoundException -> 0x0053 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ NameNotFoundException -> 0x0053 }
            if (r3 == 0) goto L_0x0020
            java.lang.Class r4 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException -> 0x0020 }
            java.lang.Object r4 = r4.newInstance()     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException -> 0x0020 }
            boolean r5 = r4 instanceof android.content.BroadcastReceiver     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException -> 0x0020 }
            if (r5 == 0) goto L_0x0020
            android.content.BroadcastReceiver r4 = (android.content.BroadcastReceiver) r4     // Catch:{ ClassNotFoundException | IllegalAccessException | InstantiationException -> 0x0020 }
            android.content.Intent r5 = new android.content.Intent     // Catch:{  }
            r5.<init>(r9)     // Catch:{  }
            android.content.ComponentName r6 = new android.content.ComponentName     // Catch:{  }
            r6.<init>(r8, r3)     // Catch:{  }
            r5.setComponent(r6)     // Catch:{  }
            r4.onReceive(r8, r5)     // Catch:{  }
            int r1 = r1 + 1
            goto L_0x0020
        L_0x0053:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5220j.mo31438a(android.content.Context, android.content.Intent):int");
    }

    public void onReceive(Context context, Intent intent) {
        mo31438a(context, intent);
    }
}
