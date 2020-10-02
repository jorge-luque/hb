package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p051c.C1859g;
import com.applovin.impl.sdk.utils.C1984a;
import com.applovin.impl.sdk.utils.C2029r;
import com.tapjoy.TJAdUnitConstants;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.w */
public class C2037w {

    /* renamed from: a */
    final C1941j f6757a;

    /* renamed from: b */
    private final AtomicBoolean f6758b = new AtomicBoolean();

    /* renamed from: c */
    private final AtomicBoolean f6759c = new AtomicBoolean();

    /* renamed from: d */
    private Date f6760d;

    /* renamed from: e */
    private Date f6761e;

    C2037w(C1941j jVar) {
        this.f6757a = jVar;
        Application application = (Application) jVar.mo8527E();
        application.registerActivityLifecycleCallbacks(new C1984a() {
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                C2037w.this.m8068d();
            }
        });
        application.registerComponentCallbacks(new ComponentCallbacks2() {
            public void onConfigurationChanged(Configuration configuration) {
            }

            public void onLowMemory() {
            }

            public void onTrimMemory(int i) {
                if (i == 20) {
                    C2037w.this.m8069e();
                }
            }
        });
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        application.registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (C2029r.m8033c()) {
                        C2037w.this.m8068d();
                    }
                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    C2037w.this.m8069e();
                }
            }
        }, intentFilter);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m8068d() {
        if (this.f6759c.compareAndSet(true, false)) {
            m8071g();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m8069e() {
        if (this.f6759c.compareAndSet(false, true)) {
            m8070f();
        }
    }

    /* renamed from: f */
    private void m8070f() {
        this.f6757a.mo8602v().mo8742b("SessionTracker", "Application Paused");
        this.f6757a.mo8570af().sendBroadcastSync(new Intent("com.applovin.application_paused"), (Map<String, Object>) null);
        if (!this.f6758b.get() && ((Boolean) this.f6757a.mo8549a(C1841c.f5965dH)).booleanValue()) {
            boolean booleanValue = ((Boolean) this.f6757a.mo8549a(C1841c.f5962dE)).booleanValue();
            long millis = TimeUnit.MINUTES.toMillis(((Long) this.f6757a.mo8549a(C1841c.f5964dG)).longValue());
            if (this.f6760d == null || System.currentTimeMillis() - this.f6760d.getTime() >= millis) {
                ((EventServiceImpl) this.f6757a.mo8596q()).mo8036a(TJAdUnitConstants.String.VIDEO_PAUSED, false);
                if (booleanValue) {
                    this.f6760d = new Date();
                }
            }
            if (!booleanValue) {
                this.f6760d = new Date();
            }
        }
    }

    /* renamed from: g */
    private void m8071g() {
        this.f6757a.mo8602v().mo8742b("SessionTracker", "Application Resumed");
        boolean booleanValue = ((Boolean) this.f6757a.mo8549a(C1841c.f5962dE)).booleanValue();
        long longValue = ((Long) this.f6757a.mo8549a(C1841c.f5963dF)).longValue();
        this.f6757a.mo8570af().sendBroadcastSync(new Intent("com.applovin.application_resumed"), (Map<String, Object>) null);
        if (!this.f6758b.getAndSet(false)) {
            long millis = TimeUnit.MINUTES.toMillis(longValue);
            if (this.f6761e == null || System.currentTimeMillis() - this.f6761e.getTime() >= millis) {
                ((EventServiceImpl) this.f6757a.mo8596q()).mo8036a("resumed", false);
                if (booleanValue) {
                    this.f6761e = new Date();
                }
            }
            if (!booleanValue) {
                this.f6761e = new Date();
            }
            this.f6757a.mo8534M().mo8387a(C1859g.f6196k);
        }
    }

    /* renamed from: a */
    public boolean mo8846a() {
        return this.f6759c.get();
    }

    /* renamed from: b */
    public void mo8847b() {
        this.f6758b.set(true);
    }

    /* renamed from: c */
    public void mo8848c() {
        this.f6758b.set(false);
    }
}
