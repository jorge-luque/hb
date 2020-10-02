package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p050b.C1840b;
import com.applovin.impl.sdk.utils.C2026p;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.b */
public class C1836b implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private final C1941j f5737a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1838a f5738b;

    /* renamed from: c */
    private C2026p f5739c;

    /* renamed from: d */
    private final Object f5740d = new Object();

    /* renamed from: e */
    private long f5741e;

    /* renamed from: com.applovin.impl.sdk.b$a */
    public interface C1838a {
        void onAdExpired();
    }

    public C1836b(C1941j jVar, C1838a aVar) {
        this.f5737a = jVar;
        this.f5738b = aVar;
    }

    /* renamed from: b */
    private void m7027b() {
        C2026p pVar = this.f5739c;
        if (pVar != null) {
            pVar.mo8814d();
            this.f5739c = null;
        }
    }

    /* renamed from: c */
    private void m7028c() {
        synchronized (this.f5740d) {
            m7027b();
        }
    }

    /* renamed from: d */
    private void m7029d() {
        boolean z;
        synchronized (this.f5740d) {
            long currentTimeMillis = this.f5741e - System.currentTimeMillis();
            if (currentTimeMillis <= 0) {
                mo8292a();
                z = true;
            } else {
                mo8293a(currentTimeMillis);
                z = false;
            }
        }
        if (z) {
            this.f5738b.onAdExpired();
        }
    }

    /* renamed from: a */
    public void mo8292a() {
        synchronized (this.f5740d) {
            m7027b();
            this.f5737a.mo8570af().unregisterReceiver(this);
        }
    }

    /* renamed from: a */
    public void mo8293a(long j) {
        synchronized (this.f5740d) {
            mo8292a();
            this.f5741e = System.currentTimeMillis() + j;
            this.f5737a.mo8570af().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
            this.f5737a.mo8570af().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
            if (((Boolean) this.f5737a.mo8549a(C1840b.f5753F)).booleanValue() || !this.f5737a.mo8546Y().mo8846a()) {
                this.f5739c = C2026p.m7968a(j, this.f5737a, new Runnable() {
                    public void run() {
                        C1836b.this.mo8292a();
                        C1836b.this.f5738b.onAdExpired();
                    }
                });
            }
        }
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            m7028c();
        } else if ("com.applovin.application_resumed".equals(action)) {
            m7029d();
        }
    }
}
