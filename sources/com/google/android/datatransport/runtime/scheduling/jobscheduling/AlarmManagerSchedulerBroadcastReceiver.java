package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import p093e.p101c.p102a.p103a.p104i.C3406l;
import p093e.p101c.p102a.p103a.p104i.C3412q;
import p093e.p101c.p102a.p103a.p104i.p110x.C3475a;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    /* renamed from: a */
    static /* synthetic */ void m9886a() {
    }

    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        C3412q.m11367a(context);
        C3406l.C3407a d = C3406l.m11350d();
        d.mo19190a(queryParameter);
        d.mo19189a(C3475a.m11524a(intValue));
        if (queryParameter2 != null) {
            d.mo19191a(Base64.decode(queryParameter2, 0));
        }
        C3412q.m11368b().mo19215a().mo13002a(d.mo19192a(), i, C3007b.m9890a());
    }
}
