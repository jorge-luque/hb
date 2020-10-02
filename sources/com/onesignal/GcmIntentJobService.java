package com.onesignal;

import android.content.Context;
import android.content.Intent;
import com.onesignal.C4739z;

public class GcmIntentJobService extends JobIntentService {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29635a(Intent intent) {
        C4528j a = C4540l.m15657a();
        a.mo29792a(intent.getExtras().getParcelable("Bundle:Parcelable:Extras"));
        C4714x.m16405a((Context) this, a, (C4739z.C4740a) null);
    }

    /* renamed from: a */
    public static void m15342a(Context context, Intent intent) {
        JobIntentService.m15346a(context, GcmIntentJobService.class, 123890, intent, false);
    }
}
