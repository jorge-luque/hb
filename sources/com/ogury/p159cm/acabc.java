package com.ogury.p159cm;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.ogury.cm.acabc */
public final class acabc implements ServiceConnection {

    /* renamed from: a */
    private final LinkedBlockingQueue<IBinder> f12132a = new LinkedBlockingQueue<>(1);

    /* renamed from: b */
    private boolean f12133b;

    /* renamed from: a */
    public final IBinder mo29518a() throws InterruptedException {
        if (!this.f12133b) {
            this.f12133b = true;
            IBinder take = this.f12132a.take();
            if (take != null) {
                return take;
            }
            throw new acbab("null cannot be cast to non-null type android.os.IBinder");
        }
        throw new IllegalStateException();
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        accbb.m15218b(componentName, "name");
        accbb.m15218b(iBinder, "service");
        try {
            this.f12132a.put(iBinder);
        } catch (InterruptedException unused) {
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        accbb.m15218b(componentName, "name");
    }
}
