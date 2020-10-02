package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.plus.PlusShare;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.p122a.C3619a;
import com.google.firebase.encoders.C3669a;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.p125f.C3676c;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.C3796a;
import p093e.p101c.p102a.p103a.C3379c;
import p093e.p101c.p102a.p103a.C3382f;

/* renamed from: com.google.firebase.messaging.u */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
public final class C3821u {

    /* renamed from: a */
    private static final C3669a f10563a;

    static {
        C3676c cVar = new C3676c();
        cVar.mo27278a(C3796a.C3797a.class, new C3796a.C3799c());
        cVar.mo27278a(C3796a.class, new C3796a.C3798b());
        f10563a = cVar.mo27277a();
    }

    /* renamed from: a */
    public static void m12894a(Intent intent, C3382f<String> fVar) {
        m12895a("_nr", intent);
        if (fVar != null) {
            try {
                fVar.mo19150a(C3379c.m11262a(f10563a.mo27269a(new C3796a.C3797a(new C3796a("MESSAGE_DELIVERED", intent)))));
            } catch (EncodingException unused) {
            }
        }
    }

    /* renamed from: b */
    public static void m12898b(Intent intent) {
        m12895a("_nd", intent);
    }

    /* renamed from: c */
    public static void m12900c(Intent intent) {
        m12895a("_nf", intent);
    }

    /* renamed from: d */
    public static boolean m12902d(Intent intent) {
        if (intent == null || m12912n(intent)) {
            return false;
        }
        return "1".equals(intent.getStringExtra("google.c.a.e"));
    }

    /* renamed from: e */
    public static boolean m12903e(Intent intent) {
        if (intent == null || m12912n(intent)) {
            return false;
        }
        return m12896a();
    }

    /* renamed from: f */
    static int m12904f(Intent intent) {
        Object obj = intent.getExtras().get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
            sb.append("Invalid TTL: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
            return 0;
        }
    }

    /* renamed from: g */
    static String m12905g(Intent intent) {
        return intent.getStringExtra("collapse_key");
    }

    /* renamed from: h */
    static String m12906h(Intent intent) {
        return intent.getStringExtra("google.c.a.c_l");
    }

    /* renamed from: i */
    static String m12907i(Intent intent) {
        return intent.getStringExtra("google.c.a.m_l");
    }

    /* renamed from: j */
    static String m12908j(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    /* renamed from: k */
    static String m12909k(Intent intent) {
        return (intent.getExtras() == null || !C3823w.m12913a(intent.getExtras())) ? "DATA_MESSAGE" : "DISPLAY_NOTIFICATION";
    }

    /* renamed from: l */
    static String m12910l(Intent intent) {
        String stringExtra = intent.getStringExtra("from");
        if (stringExtra == null || !stringExtra.startsWith("/topics/")) {
            return null;
        }
        return stringExtra;
    }

    /* renamed from: m */
    static int m12911m(Intent intent) {
        String stringExtra = intent.getStringExtra("google.delivered_priority");
        if (stringExtra == null) {
            if ("1".equals(intent.getStringExtra("google.priority_reduced"))) {
                return 2;
            }
            stringExtra = intent.getStringExtra("google.priority");
        }
        if ("high".equals(stringExtra)) {
            return 1;
        }
        if ("normal".equals(stringExtra)) {
            return 2;
        }
        return 0;
    }

    /* renamed from: n */
    private static boolean m12912n(Intent intent) {
        return "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction());
    }

    /* renamed from: b */
    static String m12897b() {
        return FirebaseApp.getInstance().mo27170a().getPackageName();
    }

    /* renamed from: c */
    static String m12899c() {
        return FirebaseInstanceId.getInstance(FirebaseApp.getInstance()).mo27292a();
    }

    /* renamed from: d */
    static String m12901d() {
        FirebaseApp instance = FirebaseApp.getInstance();
        String c = instance.mo27173c().mo27209c();
        if (c != null) {
            return c;
        }
        String b = instance.mo27173c().mo27208b();
        if (!b.startsWith("1:")) {
            return b;
        }
        String[] split = b.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    /* renamed from: a */
    public static void m12893a(Intent intent) {
        if (intent != null) {
            if ("1".equals(intent.getStringExtra("google.c.a.tc"))) {
                C3619a aVar = (C3619a) FirebaseApp.getInstance().mo27171a(C3619a.class);
                boolean isLoggable = Log.isLoggable("FirebaseMessaging", 3);
                if (aVar != null) {
                    String stringExtra = intent.getStringExtra("google.c.a.c_id");
                    aVar.mo27199a("fcm", AppMeasurement.UserProperty.FIREBASE_LAST_NOTIFICATION, stringExtra);
                    Bundle bundle = new Bundle();
                    bundle.putString(ShareConstants.FEED_SOURCE_PARAM, "Firebase");
                    bundle.putString("medium", "notification");
                    bundle.putString("campaign", stringExtra);
                    aVar.logEvent("fcm", "_cmp", bundle);
                } else {
                    Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                }
            } else {
                boolean isLoggable2 = Log.isLoggable("FirebaseMessaging", 3);
            }
        }
        m12895a("_no", intent);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean m12896a() {
        /*
            java.lang.String r0 = "delivery_metrics_exported_to_big_query_enabled"
            r1 = 0
            com.google.firebase.FirebaseApp.getInstance()     // Catch:{ IllegalStateException -> 0x0046 }
            com.google.firebase.FirebaseApp r2 = com.google.firebase.FirebaseApp.getInstance()
            android.content.Context r2 = r2.mo27170a()
            java.lang.String r3 = "com.google.firebase.messaging"
            android.content.SharedPreferences r3 = r2.getSharedPreferences(r3, r1)
            java.lang.String r4 = "export_to_big_query"
            boolean r5 = r3.contains(r4)
            if (r5 == 0) goto L_0x0021
            boolean r0 = r3.getBoolean(r4, r1)
            return r0
        L_0x0021:
            android.content.pm.PackageManager r3 = r2.getPackageManager()     // Catch:{  }
            if (r3 == 0) goto L_0x0046
            java.lang.String r2 = r2.getPackageName()     // Catch:{  }
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r2 = r3.getApplicationInfo(r2, r4)     // Catch:{  }
            if (r2 == 0) goto L_0x0046
            android.os.Bundle r3 = r2.metaData     // Catch:{  }
            if (r3 == 0) goto L_0x0046
            android.os.Bundle r3 = r2.metaData     // Catch:{  }
            boolean r3 = r3.containsKey(r0)     // Catch:{  }
            if (r3 == 0) goto L_0x0046
            android.os.Bundle r2 = r2.metaData     // Catch:{  }
            boolean r0 = r2.getBoolean(r0, r1)     // Catch:{  }
            return r0
        L_0x0046:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.C3821u.m12896a():boolean");
    }

    /* renamed from: a */
    private static void m12895a(String str, Intent intent) {
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra2 != null) {
            bundle.putString("_nmn", stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("google.c.a.m_l");
        if (!TextUtils.isEmpty(stringExtra3)) {
            bundle.putString(PlusShare.KEY_CALL_TO_ACTION_LABEL, stringExtra3);
        }
        String stringExtra4 = intent.getStringExtra("google.c.a.m_c");
        if (!TextUtils.isEmpty(stringExtra4)) {
            bundle.putString("message_channel", stringExtra4);
        }
        String l = m12910l(intent);
        if (l != null) {
            bundle.putString("_nt", l);
        }
        String stringExtra5 = intent.getStringExtra("google.c.a.ts");
        if (stringExtra5 != null) {
            try {
                bundle.putInt("_nmt", Integer.parseInt(stringExtra5));
            } catch (NumberFormatException e) {
                Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e);
            }
        }
        String stringExtra6 = intent.hasExtra("google.c.a.udt") ? intent.getStringExtra("google.c.a.udt") : null;
        if (stringExtra6 != null) {
            try {
                bundle.putInt("_ndt", Integer.parseInt(stringExtra6));
            } catch (NumberFormatException e2) {
                Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e2);
            }
        }
        String str2 = (intent.getExtras() == null || !C3823w.m12913a(intent.getExtras())) ? "data" : "display";
        if ("_nr".equals(str) || "_nf".equals(str)) {
            bundle.putString("_nmc", str2);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(valueOf).length());
            sb.append("Logging to scion event=");
            sb.append(str);
            sb.append(" scionPayload=");
            sb.append(valueOf);
            sb.toString();
        }
        C3619a aVar = (C3619a) FirebaseApp.getInstance().mo27171a(C3619a.class);
        if (aVar != null) {
            aVar.logEvent("fcm", str, bundle);
        } else {
            Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
        }
    }
}
