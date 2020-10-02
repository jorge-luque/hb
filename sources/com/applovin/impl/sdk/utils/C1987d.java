package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1941j;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.utils.d */
public class C1987d implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private static final Set<C1987d> f6645a = new HashSet();

    /* renamed from: b */
    private final C2026p f6646b;

    private C1987d(long j, final C1941j jVar, final Runnable runnable) {
        this.f6646b = C2026p.m7968a(j, jVar, new Runnable() {
            public void run() {
                jVar.mo8570af().unregisterReceiver(C1987d.this);
                C1987d.this.mo8773a();
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        f6645a.add(this);
        jVar.mo8570af().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        jVar.mo8570af().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: a */
    public static C1987d m7825a(long j, C1941j jVar, Runnable runnable) {
        return new C1987d(j, jVar, runnable);
    }

    /* renamed from: a */
    public void mo8773a() {
        this.f6646b.mo8814d();
        f6645a.remove(this);
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f6646b.mo8812b();
        } else if ("com.applovin.application_resumed".equals(action)) {
            this.f6646b.mo8813c();
        }
    }
}
