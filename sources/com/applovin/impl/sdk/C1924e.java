package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.e */
public class C1924e extends BroadcastReceiver implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    public static int f6359a = -1;

    /* renamed from: b */
    private final AudioManager f6360b;

    /* renamed from: c */
    private final Context f6361c;

    /* renamed from: d */
    private final C1941j f6362d;

    /* renamed from: e */
    private final Set<C1926a> f6363e = new HashSet();

    /* renamed from: f */
    private final Object f6364f = new Object();

    /* renamed from: g */
    private boolean f6365g;

    /* renamed from: h */
    private int f6366h;

    /* renamed from: com.applovin.impl.sdk.e$a */
    public interface C1926a {
        void onRingerModeChanged(int i);
    }

    C1924e(C1941j jVar) {
        this.f6362d = jVar;
        Context E = jVar.mo8527E();
        this.f6361c = E;
        this.f6360b = (AudioManager) E.getSystemService("audio");
    }

    /* renamed from: a */
    public static boolean m7397a(int i) {
        return i == 0 || i == 1;
    }

    /* renamed from: b */
    private void m7398b() {
        this.f6362d.mo8602v().mo8742b("AudioSessionManager", "Observing ringer mode...");
        this.f6366h = f6359a;
        this.f6361c.registerReceiver(this, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        this.f6362d.mo8570af().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        this.f6362d.mo8570af().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: b */
    private void m7399b(final int i) {
        if (!this.f6365g) {
            C1977q v = this.f6362d.mo8602v();
            v.mo8742b("AudioSessionManager", "Ringer mode is " + i);
            synchronized (this.f6364f) {
                for (final C1926a next : this.f6363e) {
                    AppLovinSdkUtils.runOnUiThread(new Runnable() {
                        public void run() {
                            next.onRingerModeChanged(i);
                        }
                    });
                }
            }
        }
    }

    /* renamed from: c */
    private void m7400c() {
        this.f6362d.mo8602v().mo8742b("AudioSessionManager", "Stopping observation of mute switch state...");
        this.f6361c.unregisterReceiver(this);
        this.f6362d.mo8570af().unregisterReceiver(this);
    }

    /* renamed from: a */
    public int mo8500a() {
        return this.f6360b.getRingerMode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8501a(com.applovin.impl.sdk.C1924e.C1926a r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f6364f
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.e$a> r1 = r2.f6363e     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x000d:
            java.util.Set<com.applovin.impl.sdk.e$a> r1 = r2.f6363e     // Catch:{ all -> 0x0020 }
            r1.add(r3)     // Catch:{ all -> 0x0020 }
            java.util.Set<com.applovin.impl.sdk.e$a> r3 = r2.f6363e     // Catch:{ all -> 0x0020 }
            int r3 = r3.size()     // Catch:{ all -> 0x0020 }
            r1 = 1
            if (r3 != r1) goto L_0x001e
            r2.m7398b()     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x0020:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1924e.mo8501a(com.applovin.impl.sdk.e$a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8502b(com.applovin.impl.sdk.C1924e.C1926a r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f6364f
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.e$a> r1 = r2.f6363e     // Catch:{ all -> 0x001f }
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x000d:
            java.util.Set<com.applovin.impl.sdk.e$a> r1 = r2.f6363e     // Catch:{ all -> 0x001f }
            r1.remove(r3)     // Catch:{ all -> 0x001f }
            java.util.Set<com.applovin.impl.sdk.e$a> r3 = r2.f6363e     // Catch:{ all -> 0x001f }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x001f }
            if (r3 == 0) goto L_0x001d
            r2.m7400c()     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1924e.mo8502b(com.applovin.impl.sdk.e$a):void");
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
            m7399b(this.f6360b.getRingerMode());
        }
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f6365g = true;
            this.f6366h = this.f6360b.getRingerMode();
        } else if ("com.applovin.application_resumed".equals(action)) {
            this.f6365g = false;
            if (this.f6366h != this.f6360b.getRingerMode()) {
                this.f6366h = f6359a;
                m7399b(this.f6360b.getRingerMode());
            }
        }
    }
}
