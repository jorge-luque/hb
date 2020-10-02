package com.applovin.communicator;

import android.content.Context;
import com.applovin.impl.communicator.C1636a;
import com.applovin.impl.communicator.MessagingServiceImpl;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import java.util.Collections;
import java.util.List;

public final class AppLovinCommunicator {

    /* renamed from: a */
    private static AppLovinCommunicator f4577a;

    /* renamed from: b */
    private static final Object f4578b = new Object();

    /* renamed from: c */
    private C1941j f4579c;

    /* renamed from: d */
    private C1977q f4580d;

    /* renamed from: e */
    private final C1636a f4581e;

    /* renamed from: f */
    private final MessagingServiceImpl f4582f;

    private AppLovinCommunicator(Context context) {
        this.f4581e = new C1636a(context);
        this.f4582f = new MessagingServiceImpl(context);
    }

    /* renamed from: a */
    private void m5692a(String str) {
        C1977q qVar = this.f4580d;
        if (qVar != null) {
            qVar.mo8742b("AppLovinCommunicator", str);
        }
    }

    public static AppLovinCommunicator getInstance(Context context) {
        synchronized (f4578b) {
            if (f4577a == null) {
                f4577a = new AppLovinCommunicator(context.getApplicationContext());
            }
        }
        return f4577a;
    }

    /* renamed from: a */
    public void mo7129a(C1941j jVar) {
        this.f4579c = jVar;
        this.f4580d = jVar.mo8602v();
        m5692a("Attached SDK instance: " + jVar + "...");
    }

    public AppLovinCommunicatorMessagingService getMessagingService() {
        return this.f4582f;
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        subscribe(appLovinCommunicatorSubscriber, (List<String>) Collections.singletonList(str));
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String next : list) {
            if (this.f4581e.mo7580a(appLovinCommunicatorSubscriber, next)) {
                this.f4582f.maybeFlushStickyMessages(next);
            } else {
                m5692a("Unable to subscribe " + appLovinCommunicatorSubscriber + " to topic: " + next);
            }
        }
    }

    public String toString() {
        return "AppLovinCommunicator{sdk=" + this.f4579c + '}';
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        unsubscribe(appLovinCommunicatorSubscriber, (List<String>) Collections.singletonList(str));
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String next : list) {
            m5692a("Unsubscribing " + appLovinCommunicatorSubscriber + " from topic: " + next);
            this.f4581e.mo7581b(appLovinCommunicatorSubscriber, next);
        }
    }
}
