package com.iab.omid.library.adcolony.p144b;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.iab.omid.library.adcolony.adsession.C4148a;

/* renamed from: com.iab.omid.library.adcolony.b.b */
public class C4151b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f */
    private static C4151b f11169f = new C4151b();

    /* renamed from: a */
    private Context f11170a;

    /* renamed from: b */
    private BroadcastReceiver f11171b;

    /* renamed from: c */
    private boolean f11172c;

    /* renamed from: d */
    private boolean f11173d;

    /* renamed from: e */
    private C4152a f11174e;

    /* renamed from: com.iab.omid.library.adcolony.b.b$a */
    public interface C4152a {
        /* renamed from: a */
        void mo28515a(boolean z);
    }

    /* renamed from: com.iab.omid.library.adcolony.b.b$b */
    class C4153b extends BroadcastReceiver {
        C4153b() {
        }

        public void onReceive(Context context, Intent intent) {
            C4151b bVar;
            boolean z;
            KeyguardManager keyguardManager;
            if (intent != null) {
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    bVar = C4151b.this;
                    z = true;
                } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction()) || ("android.intent.action.SCREEN_ON".equals(intent.getAction()) && (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) != null && !keyguardManager.inKeyguardRestrictedInputMode())) {
                    bVar = C4151b.this;
                    z = false;
                } else {
                    return;
                }
                bVar.m13915a(z);
            }
        }
    }

    private C4151b() {
    }

    /* renamed from: a */
    public static C4151b m13913a() {
        return f11169f;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13915a(boolean z) {
        if (this.f11173d != z) {
            this.f11173d = z;
            if (this.f11172c) {
                m13918g();
                C4152a aVar = this.f11174e;
                if (aVar != null) {
                    aVar.mo28515a(mo28514d());
                }
            }
        }
    }

    /* renamed from: e */
    private void m13916e() {
        this.f11171b = new C4153b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f11170a.registerReceiver(this.f11171b, intentFilter);
    }

    /* renamed from: f */
    private void m13917f() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.f11170a;
        if (context != null && (broadcastReceiver = this.f11171b) != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.f11171b = null;
        }
    }

    /* renamed from: g */
    private void m13918g() {
        boolean z = !this.f11173d;
        for (C4148a adSessionStatePublisher : C4150a.m13906a().mo28505b()) {
            adSessionStatePublisher.getAdSessionStatePublisher().mo28563a(z);
        }
    }

    /* renamed from: a */
    public void mo28510a(Context context) {
        this.f11170a = context.getApplicationContext();
    }

    /* renamed from: a */
    public void mo28511a(C4152a aVar) {
        this.f11174e = aVar;
    }

    /* renamed from: b */
    public void mo28512b() {
        m13916e();
        this.f11172c = true;
        m13918g();
    }

    /* renamed from: c */
    public void mo28513c() {
        m13917f();
        this.f11172c = false;
        this.f11173d = false;
        this.f11174e = null;
    }

    /* renamed from: d */
    public boolean mo28514d() {
        return !this.f11173d;
    }
}
