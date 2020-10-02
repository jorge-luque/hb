package com.tapjoy.internal;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import com.facebook.share.internal.MessengerShareContentUtility;

/* renamed from: com.tapjoy.internal.hb */
public final class C3147hb extends C3172p {

    /* renamed from: c */
    private static C3147hb f8779c;

    private C3147hb(Context context) {
        super(context, new C5266r() {
            /* renamed from: a */
            public final String mo18568a(Context context) {
                return C5159hj.m17376a(context).f14114b.getString("gcm.senderIds", "");
            }

            /* renamed from: b */
            public final String mo18573b(Context context) {
                return C5159hj.m17376a(context).f14114b.getString("gcm.regId", "");
            }

            /* renamed from: c */
            public final boolean mo18577c(Context context) {
                return C5159hj.m17376a(context).f14114b.getBoolean("gcm.stale", true);
            }

            /* renamed from: d */
            public final int mo18578d(Context context) {
                return C5159hj.m17376a(context).f14114b.getInt("gcm.appVersion", Integer.MIN_VALUE);
            }

            /* renamed from: e */
            public final boolean mo18579e(Context context) {
                return C5159hj.m17376a(context).f14114b.getBoolean("gcm.onServer", false);
            }

            /* renamed from: f */
            public final long mo18580f(Context context) {
                return C5159hj.m17376a(context).f14114b.getLong("gcm.onServerExpirationTime", 0);
            }

            /* renamed from: g */
            public final int mo18581g(Context context) {
                return C5159hj.m17376a(context).f14114b.getInt("gcm.backoff", 0);
            }

            /* renamed from: a */
            public final void mo18571a(Context context, String str) {
                C5264n.m17648a(C5159hj.m17376a(context).f14114b, "gcm.senderIds", str);
            }

            /* renamed from: b */
            public final void mo18575b(Context context, String str) {
                C5264n.m17648a(C5159hj.m17376a(context).f14114b, "gcm.regId", str);
            }

            /* renamed from: a */
            public final void mo18572a(Context context, boolean z) {
                C5264n.m17649a(C5159hj.m17376a(context).f14114b, "gcm.stale", z);
            }

            /* renamed from: b */
            public final void mo18576b(Context context, boolean z) {
                C5159hj.m17376a(context).mo31335a(z);
            }

            /* renamed from: b */
            public final void mo18574b(Context context, int i) {
                C5264n.m17647a(C5159hj.m17376a(context).f14114b, "gcm.backoff", i);
            }

            /* renamed from: a */
            public final void mo18569a(Context context, int i) {
                C5264n.m17647a(C5159hj.m17376a(context).f14114b, "gcm.appVersion", i);
            }

            /* renamed from: a */
            public final void mo18570a(Context context, long j) {
                SharedPreferences.Editor edit = C5159hj.m17376a(context).f14114b.edit();
                edit.putLong("gcm.onServerExpirationTime", j);
                edit.apply();
            }
        });
    }

    /* renamed from: b */
    public static synchronized C3147hb m10351b(Context context) {
        C3147hb hbVar;
        synchronized (C3147hb.class) {
            if (f8779c == null) {
                f8779c = new C3147hb(context);
            }
            hbVar = f8779c;
        }
        return hbVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18561a(int i) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18562a(Context context, String str) {
        C3145gz.m10322a(context).mo18545a(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final boolean mo18565c(String str) {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final boolean mo18566d(String str) {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo18567e(String str) {
        if (str != null && str.length() > 0) {
            super.mo18633a(this.f8849a);
            super.mo18634a(new String[]{str}[0]);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo18563a(Context context, Intent intent) {
        Context context2 = context;
        Intent intent2 = intent;
        intent.getExtras();
        String stringExtra = intent2.getStringExtra("fiverocks");
        if (stringExtra == null) {
            return false;
        }
        if (C3149hc.m10374a(context).mo18595f()) {
            C3145gz.m10322a(context).mo18553b(stringExtra);
            return true;
        }
        String stringExtra2 = intent2.getStringExtra("title");
        String stringExtra3 = intent2.getStringExtra("message");
        if (stringExtra3 != null) {
            Bundle extras = intent.getExtras();
            Object obj = extras.get("rich");
            Object obj2 = extras.get("sound");
            String string = extras.getString(MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
            Object obj3 = extras.get("always");
            boolean z = "true".equals(obj3) || Boolean.TRUE.equals(obj3);
            Object obj4 = extras.get("repeatable");
            boolean z2 = "true".equals(obj4) || Boolean.TRUE.equals(obj4);
            String string2 = extras.getString("placement");
            int b = m10350b(extras.get("nid"));
            String string3 = extras.getString("channel_id");
            if (z || !C3145gz.m10322a(context).mo18556d()) {
                Notification a = m10347a(context, stringExtra, C3166jq.m10434a(stringExtra2), stringExtra3, m10349a(obj), m10349a(obj2), string, string2, b, string3);
                if (C3145gz.m10322a(context).mo18550a(context2, stringExtra, z2)) {
                    m10348a(context2, b, a);
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo18564b(String str) {
        mo18635a();
    }

    /* renamed from: b */
    public static int m10350b(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* renamed from: a */
    public static boolean m10349a(Object obj) {
        return Boolean.TRUE.equals(obj) || "true".equals(obj);
    }

    /* renamed from: a */
    public static void m10348a(Context context, int i, Notification notification) {
        ((NotificationManager) context.getSystemService("notification")).notify(i, notification);
    }

    /* renamed from: a */
    private static int m10346a(Bundle bundle, String str, Context context) {
        if (bundle != null) {
            Object obj = bundle.get(str);
            if (obj instanceof Integer) {
                int intValue = ((Integer) obj).intValue();
                try {
                    if ("drawable".equals(context.getResources().getResourceTypeName(intValue))) {
                        return intValue;
                    }
                } catch (Resources.NotFoundException unused) {
                }
            }
            if (obj != null) {
                Object[] objArr = {str};
                if (C5139gw.f14055a) {
                    C3175x.m10465a(4, "Tapjoy", "meta-data of {} invalid", objArr);
                }
            }
        }
        return 0;
    }

    /* JADX WARNING: type inference failed for: r6v2, types: [android.text.Spanned] */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        if (r7 == false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        r5 = android.text.Html.fromHtml(r5);
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    @javax.annotation.Nullable
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.app.Notification m10347a(android.content.Context r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, boolean r7, boolean r8, java.lang.String r9, java.lang.String r10, int r11, java.lang.String r12) {
        /*
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r1 = r3.getApplicationContext()
            java.lang.Class<com.tapjoy.TapjoyReceiver> r2 = com.tapjoy.TapjoyReceiver.class
            r0.<init>(r1, r2)
            java.lang.String r1 = "com.tapjoy.PUSH_CLICK"
            r0.setAction(r1)
            java.lang.String r1 = "com.tapjoy.PUSH_ID"
            r0.putExtra(r1, r4)
            if (r9 == 0) goto L_0x001c
            java.lang.String r4 = "com.tapjoy.PUSH_PAYLOAD"
            r0.putExtra(r4, r9)
        L_0x001c:
            if (r10 == 0) goto L_0x0023
            java.lang.String r4 = "com.tapjoy.PUSH_PLACEMENT"
            r0.putExtra(r4, r10)
        L_0x0023:
            r4 = 134217728(0x8000000, float:3.85186E-34)
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 19
            if (r9 != r10) goto L_0x002d
            r4 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x002d:
            android.content.Context r9 = r3.getApplicationContext()
            android.app.PendingIntent r4 = android.app.PendingIntent.getBroadcast(r9, r11, r0, r4)
            r9 = 0
            if (r4 != 0) goto L_0x0039
            return r9
        L_0x0039:
            android.content.pm.PackageManager r10 = r3.getPackageManager()
            java.lang.String r11 = r3.getPackageName()
            r0 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r11 = r10.getApplicationInfo(r11, r0)     // Catch:{ NameNotFoundException -> 0x00f8 }
            int r0 = r5.length()
            if (r0 != 0) goto L_0x0052
            java.lang.CharSequence r5 = r10.getApplicationLabel(r11)
            goto L_0x0058
        L_0x0052:
            if (r7 == 0) goto L_0x0058
            android.text.Spanned r5 = android.text.Html.fromHtml(r5)
        L_0x0058:
            if (r7 == 0) goto L_0x005e
            android.text.Spanned r6 = android.text.Html.fromHtml(r6)
        L_0x005e:
            android.os.Bundle r7 = r11.metaData
            java.lang.String r10 = "com.tapjoy.notification.icon"
            int r7 = m10346a((android.os.Bundle) r7, (java.lang.String) r10, (android.content.Context) r3)
            if (r7 != 0) goto L_0x0070
            int r7 = r11.icon
            if (r7 == 0) goto L_0x006d
            goto L_0x0070
        L_0x006d:
            r7 = 17301651(0x1080093, float:2.4979667E-38)
        L_0x0070:
            android.os.Bundle r10 = r11.metaData
            java.lang.String r0 = "com.tapjoy.notification.icon.large"
            int r10 = m10346a((android.os.Bundle) r10, (java.lang.String) r0, (android.content.Context) r3)
            if (r10 == 0) goto L_0x0083
            android.content.res.Resources r0 = r3.getResources()
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeResource(r0, r10)
            goto L_0x0084
        L_0x0083:
            r10 = r9
        L_0x0084:
            java.lang.String r0 = "tapjoy"
            if (r12 != 0) goto L_0x0092
            android.os.Bundle r11 = r11.metaData
            if (r11 == 0) goto L_0x0092
            java.lang.String r12 = "com.tapjoy.notification.default_channel_id"
            java.lang.String r12 = r11.getString(r12, r0)
        L_0x0092:
            int r11 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r11 < r1) goto L_0x00b7
            java.lang.String r9 = "notification"
            java.lang.Object r9 = r3.getSystemService(r9)
            android.app.NotificationManager r9 = (android.app.NotificationManager) r9
            if (r12 == 0) goto L_0x00ab
            android.app.NotificationChannel r11 = r9.getNotificationChannel(r12)
            if (r11 != 0) goto L_0x00a9
            goto L_0x00ab
        L_0x00a9:
            r9 = r12
            goto L_0x00b7
        L_0x00ab:
            android.app.NotificationChannel r11 = new android.app.NotificationChannel
            r12 = 3
            java.lang.String r1 = "Tapjoy"
            r11.<init>(r0, r1, r12)
            r9.createNotificationChannel(r11)
            r9 = r0
        L_0x00b7:
            com.tapjoy.internal.ji$c r11 = new com.tapjoy.internal.ji$c
            r11.<init>(r3, r9)
            com.tapjoy.internal.ji$c r3 = r11.mo31445a((int) r7)
            com.tapjoy.internal.ji$c r3 = r3.mo31453c(r5)
            com.tapjoy.internal.ji$c r3 = r3.mo31449a((java.lang.CharSequence) r5)
            com.tapjoy.internal.ji$c r3 = r3.mo31451b(r6)
            com.tapjoy.internal.ji$c r3 = r3.mo31446a((android.app.PendingIntent) r4)
            com.tapjoy.internal.ji$c r3 = r3.mo31444a()
            com.tapjoy.internal.ji$c r3 = r3.mo31452c()
            com.tapjoy.internal.ji$b r4 = new com.tapjoy.internal.ji$b
            r4.<init>()
            com.tapjoy.internal.ji$b r4 = r4.mo31441a((java.lang.CharSequence) r5)
            com.tapjoy.internal.ji$b r4 = r4.mo31443b(r6)
            com.tapjoy.internal.ji$c r3 = r3.mo31448a((com.tapjoy.internal.C5230ji.C5234d) r4)
            if (r8 == 0) goto L_0x00ee
            r3.mo31450b()
        L_0x00ee:
            if (r10 == 0) goto L_0x00f3
            r3.mo31447a((android.graphics.Bitmap) r10)
        L_0x00f3:
            android.app.Notification r3 = r3.mo31454d()
            return r3
        L_0x00f8:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C3147hb.m10347a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, java.lang.String, java.lang.String, int, java.lang.String):android.app.Notification");
    }
}
