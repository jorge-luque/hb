package com.onesignal;

import android.content.Intent;
import android.os.Bundle;
import com.onesignal.C4739z;

public class RestoreJobService extends JobIntentService {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo29635a(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null) {
            C4714x.m16405a(getApplicationContext(), (C4528j) new C4534k(extras), (C4739z.C4740a) null);
        }
    }
}
