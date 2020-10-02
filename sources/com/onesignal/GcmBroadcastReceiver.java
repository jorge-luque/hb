package com.onesignal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.appevents.AppEventsConstants;
import com.onesignal.C4714x;
import com.onesignal.C4739z;
import p075d.p088f.p089a.C3217a;

public class GcmBroadcastReceiver extends C3217a {
    /* renamed from: a */
    private static boolean m15338a(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return false;
        }
        String stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null || "gcm".equals(stringExtra)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private void m15339b() {
        if (isOrderedBroadcast()) {
            setResultCode(-1);
        }
    }

    /* renamed from: c */
    private static void m15341c(Context context, Bundle bundle) {
        ComponentName componentName = new ComponentName(context.getPackageName(), GcmIntentService.class.getName());
        C4534k kVar = new C4534k();
        m15334a(bundle, (C4528j) kVar);
        C3217a.startWakefulService(context, new Intent().replaceExtras((Bundle) kVar.mo29791a()).setComponent(componentName));
    }

    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null && !"google.com/iid".equals(extras.getString("from"))) {
            C4564n1.m15865k(context);
            C4714x.C4716b a = m15335a(context, intent, extras);
            if (a == null) {
                m15339b();
            } else if (a.f12804c || a.f12803b) {
                m15336a();
            } else if (!a.f12802a || !C4564n1.m15840e(context)) {
                m15339b();
            } else {
                m15336a();
            }
        }
    }

    @TargetApi(21)
    /* renamed from: b */
    private static void m15340b(Context context, Bundle bundle) {
        C4528j a = C4540l.m15657a();
        m15334a(bundle, a);
        Intent intent = new Intent(context, GcmIntentJobService.class);
        intent.putExtra("Bundle:Parcelable:Extras", (Parcelable) a.mo29791a());
        GcmIntentJobService.m15342a(context, intent);
    }

    /* renamed from: a */
    private void m15336a() {
        if (isOrderedBroadcast()) {
            abortBroadcast();
            setResultCode(-1);
        }
    }

    /* renamed from: a */
    private static C4714x.C4716b m15335a(Context context, Intent intent, Bundle bundle) {
        if (!m15338a(intent)) {
            return null;
        }
        C4714x.C4716b a = C4714x.m16401a(context, bundle);
        if (a.mo30027a()) {
            return a;
        }
        m15337a(context, bundle);
        return a;
    }

    /* renamed from: a */
    private static void m15337a(Context context, Bundle bundle) {
        if (!C4714x.m16420d(bundle)) {
            C4528j a = C4540l.m15657a();
            m15334a(bundle, a);
            C4714x.m16405a(context, a, (C4739z.C4740a) null);
            return;
        }
        if ((Integer.parseInt(bundle.getString("pri", AppEventsConstants.EVENT_PARAM_VALUE_NO)) > 9) || Build.VERSION.SDK_INT < 26) {
            try {
                m15341c(context, bundle);
            } catch (IllegalStateException e) {
                if (Build.VERSION.SDK_INT >= 21) {
                    m15340b(context, bundle);
                    return;
                }
                throw e;
            }
        } else {
            m15340b(context, bundle);
        }
    }

    /* renamed from: a */
    private static C4528j m15334a(Bundle bundle, C4528j jVar) {
        jVar.mo29794a("json_payload", C4714x.m16412b(bundle).toString());
        jVar.mo29793a("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        return jVar;
    }
}
