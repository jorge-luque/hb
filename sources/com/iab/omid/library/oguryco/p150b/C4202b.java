package com.iab.omid.library.oguryco.p150b;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.iab.omid.library.oguryco.adsession.C4199a;

/* renamed from: com.iab.omid.library.oguryco.b.b */
public class C4202b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a */
    private static C4202b f11290a = new C4202b();

    /* renamed from: b */
    private Context f11291b;

    /* renamed from: c */
    private BroadcastReceiver f11292c;

    /* renamed from: d */
    private boolean f11293d;

    /* renamed from: e */
    private boolean f11294e;

    /* renamed from: f */
    private C4204a f11295f;

    /* renamed from: com.iab.omid.library.oguryco.b.b$a */
    public interface C4204a {
        /* renamed from: a */
        void mo28730a(boolean z);
    }

    private C4202b() {
    }

    /* renamed from: a */
    public static C4202b m14142a() {
        return f11290a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14144a(boolean z) {
        if (this.f11294e != z) {
            this.f11294e = z;
            if (this.f11293d) {
                m14147g();
                C4204a aVar = this.f11295f;
                if (aVar != null) {
                    aVar.mo28730a(mo28728d());
                }
            }
        }
    }

    /* renamed from: e */
    private void m14145e() {
        this.f11292c = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                KeyguardManager keyguardManager;
                if (intent != null) {
                    if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                        C4202b.this.m14144a(true);
                    } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                        C4202b.this.m14144a(false);
                    } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) && (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) != null && !keyguardManager.inKeyguardRestrictedInputMode()) {
                        C4202b.this.m14144a(false);
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f11291b.registerReceiver(this.f11292c, intentFilter);
    }

    /* renamed from: f */
    private void m14146f() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.f11291b;
        if (context != null && (broadcastReceiver = this.f11292c) != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.f11292c = null;
        }
    }

    /* renamed from: g */
    private void m14147g() {
        boolean z = !this.f11294e;
        for (C4199a adSessionStatePublisher : C4201a.m14135a().mo28719b()) {
            adSessionStatePublisher.getAdSessionStatePublisher().mo28777a(z);
        }
    }

    /* renamed from: a */
    public void mo28724a(Context context) {
        this.f11291b = context.getApplicationContext();
    }

    /* renamed from: a */
    public void mo28725a(C4204a aVar) {
        this.f11295f = aVar;
    }

    /* renamed from: b */
    public void mo28726b() {
        m14145e();
        this.f11293d = true;
        m14147g();
    }

    /* renamed from: c */
    public void mo28727c() {
        m14146f();
        this.f11293d = false;
        this.f11294e = false;
        this.f11295f = null;
    }

    /* renamed from: d */
    public boolean mo28728d() {
        return !this.f11294e;
    }
}
