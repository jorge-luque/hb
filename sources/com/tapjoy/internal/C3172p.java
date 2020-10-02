package com.tapjoy.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tapjoy.TapjoyConstants;
import java.sql.Timestamp;

/* renamed from: com.tapjoy.internal.p */
public abstract class C3172p extends C3173q {

    /* renamed from: a */
    public final Context f8849a;

    /* renamed from: b */
    public final C5266r f8850b;

    /* renamed from: c */
    private boolean f8851c = false;

    public C3172p(Context context, C5266r rVar) {
        this.f8849a = context.getApplicationContext();
        this.f8850b = rVar;
    }

    /* renamed from: b */
    private boolean m10447b() {
        boolean e = this.f8850b.mo18579e(this.f8849a);
        if (!e) {
            return e;
        }
        long f = this.f8850b.mo18580f(this.f8849a);
        if (f == 0 || System.currentTimeMillis() <= f) {
            return e;
        }
        new Timestamp(f);
        return false;
    }

    /* renamed from: c */
    private static boolean m10449c(Context context, String str) {
        try {
            C3176z.m10469b(context.getPackageManager(), "com.google.android.gsf");
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gsf");
            m10446b(context, intent);
            intent.putExtra("sender", str);
            if (context.startService(intent) != null) {
                return true;
            }
            return false;
        } catch (RuntimeException unused) {
        }
    }

    /* renamed from: e */
    private void mo18567e(String str) {
        this.f8850b.mo18571a(this.f8849a, str);
        this.f8850b.mo18572a(this.f8849a, true);
        if ((this.f8851c || !m10448b(this.f8849a, str)) && m10449c(this.f8849a, str)) {
        }
    }

    /* renamed from: f */
    private synchronized void m10451f(String str) {
        mo18633a(this.f8849a);
        this.f8850b.mo18572a(this.f8849a, false);
        this.f8850b.mo18569a(this.f8849a, C3176z.m10467a(this.f8849a));
        if (!str.equals(this.f8850b.mo18573b(this.f8849a))) {
            this.f8850b.mo18576b(this.f8849a, false);
            this.f8850b.mo18575b(this.f8849a, str);
            mo18562a(this.f8849a, str);
        } else if (!m10447b()) {
            mo18562a(this.f8849a, str);
        }
    }

    /* renamed from: a */
    public final boolean mo18635a() {
        String a = this.f8850b.mo18568a(this.f8849a);
        if (C3166jq.m10436c(a)) {
            return false;
        }
        mo18634a(a);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18634a(String str) {
        String b = this.f8850b.mo18573b(this.f8849a);
        if (b.length() == 0) {
            mo18567e(str);
        } else if (!str.equals(this.f8850b.mo18568a(this.f8849a))) {
            mo18567e(str);
        } else {
            int d = this.f8850b.mo18578d(this.f8849a);
            int a = C3176z.m10467a(this.f8849a);
            if (d != Integer.MIN_VALUE && d != a) {
                mo18567e(str);
            } else if (this.f8850b.mo18577c(this.f8849a)) {
                mo18567e(str);
            } else if (!m10447b()) {
                mo18562a(this.f8849a, b);
            }
        }
    }

    /* renamed from: b */
    private static boolean m10448b(Context context, String str) {
        try {
            if (C3176z.m10469b(context.getPackageManager(), "com.google.android.gms") >= 3159130) {
                Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                intent.setPackage("com.google.android.gms");
                m10446b(context, intent);
                intent.putExtra("sender", str);
                if (context.startService(intent) != null) {
                    return true;
                }
            }
        } catch (RuntimeException unused) {
        }
        return false;
    }

    /* renamed from: b */
    private static void m10446b(Context context, Intent intent) {
        intent.putExtra(TapjoyConstants.TJC_APP_PLACEMENT, PendingIntent.getBroadcast(context, 0, new Intent(), 0));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18633a(Context context) {
        this.f8850b.mo18574b(context, 3000);
    }

    /* renamed from: a */
    public final boolean mo18636a(Intent intent) {
        String str;
        String stringExtra;
        boolean z;
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            String stringExtra2 = intent.getStringExtra("registration_id");
            String stringExtra3 = intent.getStringExtra("unregistered");
            String stringExtra4 = intent.getStringExtra("error");
            if (stringExtra2 != null) {
                if (stringExtra2.length() > 0) {
                    if (stringExtra2.startsWith("|")) {
                        return false;
                    }
                    m10451f(stringExtra2);
                    return false;
                } else if (stringExtra3 == null && stringExtra4 == null && !this.f8851c) {
                    this.f8851c = true;
                    mo18635a();
                    return true;
                }
            }
            if (stringExtra3 != null) {
                String b = this.f8850b.mo18573b(this.f8849a);
                mo18633a(this.f8849a);
                this.f8850b.mo18576b(this.f8849a, false);
                this.f8850b.mo18575b(this.f8849a, "");
                this.f8850b.mo18572a(this.f8849a, true);
                mo18564b(b);
                return false;
            } else if (stringExtra4 == null) {
                return false;
            } else {
                if ("SERVICE_NOT_AVAILABLE".equals(stringExtra4)) {
                    z = mo18565c(stringExtra4);
                } else if (!this.f8851c) {
                    mo18565c(stringExtra4);
                    this.f8851c = true;
                    mo18635a();
                    return true;
                } else {
                    z = mo18566d(stringExtra4);
                }
                if (z) {
                    int g = this.f8850b.mo18581g(this.f8849a);
                    Intent intent2 = new Intent("com.google.android.gcm.intent.RETRY");
                    intent2.setPackage(this.f8849a.getPackageName());
                    ((AlarmManager) this.f8849a.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + ((long) g), PendingIntent.getBroadcast(this.f8849a, 0, intent2, 0));
                    if (g < 3600000) {
                        this.f8850b.mo18574b(this.f8849a, g * 2);
                    }
                }
                return true;
            }
        } else if ("com.google.android.c2dm.intent.RECEIVE".equals(action)) {
            String stringExtra5 = intent.getStringExtra("message_type");
            if (stringExtra5 == null) {
                return mo18563a(this.f8849a, intent);
            }
            if ("deleted_messages".equals(stringExtra5) && (stringExtra = intent.getStringExtra("total_deleted")) != null) {
                try {
                    mo18561a(Integer.parseInt(stringExtra));
                } catch (NumberFormatException unused) {
                }
            }
            return false;
        } else if (!"com.google.android.gcm.intent.RETRY".equals(action) || (str = intent.getPackage()) == null || !str.equals(this.f8849a.getPackageName())) {
            return false;
        } else {
            mo18635a();
            return true;
        }
    }
}
