package com.applovin.impl.communicator;

import android.content.Context;
import android.content.Intent;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1977q;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.communicator.b */
public class C1637b implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    private boolean f5095a = true;

    /* renamed from: b */
    private final String f5096b;

    /* renamed from: c */
    private final WeakReference<AppLovinCommunicatorSubscriber> f5097c;

    /* renamed from: d */
    private final Set<CommunicatorMessageImpl> f5098d = new LinkedHashSet();

    /* renamed from: e */
    private final Object f5099e = new Object();

    C1637b(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        this.f5096b = str;
        this.f5097c = new WeakReference<>(appLovinCommunicatorSubscriber);
    }

    /* renamed from: a */
    public String mo7582a() {
        return this.f5096b;
    }

    /* renamed from: a */
    public void mo7583a(boolean z) {
        this.f5095a = z;
    }

    /* renamed from: b */
    public AppLovinCommunicatorSubscriber mo7584b() {
        return (AppLovinCommunicatorSubscriber) this.f5097c.get();
    }

    /* renamed from: c */
    public boolean mo7585c() {
        return this.f5095a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1637b)) {
            return false;
        }
        C1637b bVar = (C1637b) obj;
        if (mo7582a().equals(bVar.mo7582a())) {
            if (this.f5097c.get() != null) {
                if (((AppLovinCommunicatorSubscriber) this.f5097c.get()).equals(bVar.f5097c.get())) {
                    return true;
                }
            } else if (this.f5097c.get() == bVar.f5097c.get()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f5096b.hashCode() * 31) + (this.f5097c.get() != null ? ((AppLovinCommunicatorSubscriber) this.f5097c.get()).hashCode() : 0);
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        if (mo7584b() == null) {
            C1977q.m7751i("AppLovinCommunicator", "Message received for GC'd subscriber");
            return;
        }
        CommunicatorMessageImpl communicatorMessageImpl = (CommunicatorMessageImpl) intent;
        boolean z = false;
        synchronized (this.f5099e) {
            if (!this.f5098d.contains(communicatorMessageImpl)) {
                this.f5098d.add(communicatorMessageImpl);
                z = true;
            }
        }
        if (z) {
            mo7584b().onMessageReceived((AppLovinCommunicatorMessage) communicatorMessageImpl);
        }
    }
}
