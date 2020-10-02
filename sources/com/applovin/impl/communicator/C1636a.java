package com.applovin.impl.communicator;

import android.content.Context;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.C2025o;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.communicator.a */
public class C1636a {

    /* renamed from: a */
    private final Context f5092a;

    /* renamed from: b */
    private final Set<C1637b> f5093b = new HashSet(32);

    /* renamed from: c */
    private final Object f5094c = new Object();

    public C1636a(Context context) {
        this.f5092a = context;
    }

    /* renamed from: a */
    private C1637b m6234a(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        for (C1637b next : this.f5093b) {
            if (str.equals(next.mo7582a()) && appLovinCommunicatorSubscriber.equals(next.mo7584b())) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004e, code lost:
        return true;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo7580a(com.applovin.communicator.AppLovinCommunicatorSubscriber r7, java.lang.String r8) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x006c
            boolean r0 = com.applovin.impl.sdk.utils.C2025o.m7963b(r8)
            if (r0 != 0) goto L_0x0009
            goto L_0x006c
        L_0x0009:
            java.lang.Object r0 = r6.f5094c
            monitor-enter(r0)
            com.applovin.impl.communicator.b r1 = r6.m6234a((java.lang.String) r8, (com.applovin.communicator.AppLovinCommunicatorSubscriber) r7)     // Catch:{ all -> 0x0069 }
            r2 = 1
            if (r1 == 0) goto L_0x004f
            java.lang.String r3 = "AppLovinCommunicator"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r4.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r5 = "Attempting to re-subscribe subscriber ("
            r4.append(r5)     // Catch:{ all -> 0x0069 }
            r4.append(r7)     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = ") to topic ("
            r4.append(r7)     // Catch:{ all -> 0x0069 }
            r4.append(r8)     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = ")"
            r4.append(r7)     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0069 }
            com.applovin.impl.sdk.C1977q.m7751i(r3, r7)     // Catch:{ all -> 0x0069 }
            boolean r7 = r1.mo7585c()     // Catch:{ all -> 0x0069 }
            if (r7 != 0) goto L_0x004d
            r1.mo7583a(r2)     // Catch:{ all -> 0x0069 }
            android.content.Context r7 = r6.f5092a     // Catch:{ all -> 0x0069 }
            com.applovin.impl.sdk.AppLovinBroadcastManager r7 = com.applovin.impl.sdk.AppLovinBroadcastManager.getInstance(r7)     // Catch:{ all -> 0x0069 }
            android.content.IntentFilter r3 = new android.content.IntentFilter     // Catch:{ all -> 0x0069 }
            r3.<init>(r8)     // Catch:{ all -> 0x0069 }
            r7.registerReceiver(r1, r3)     // Catch:{ all -> 0x0069 }
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            return r2
        L_0x004f:
            com.applovin.impl.communicator.b r1 = new com.applovin.impl.communicator.b     // Catch:{ all -> 0x0069 }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x0069 }
            java.util.Set<com.applovin.impl.communicator.b> r7 = r6.f5093b     // Catch:{ all -> 0x0069 }
            r7.add(r1)     // Catch:{ all -> 0x0069 }
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            android.content.Context r7 = r6.f5092a
            com.applovin.impl.sdk.AppLovinBroadcastManager r7 = com.applovin.impl.sdk.AppLovinBroadcastManager.getInstance(r7)
            android.content.IntentFilter r0 = new android.content.IntentFilter
            r0.<init>(r8)
            r7.registerReceiver(r1, r0)
            return r2
        L_0x0069:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            throw r7
        L_0x006c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unable to subscribe - invalid subscriber ("
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = ") or topic ("
            r0.append(r7)
            r0.append(r8)
            java.lang.String r7 = ")"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.String r8 = "AppLovinCommunicator"
            com.applovin.impl.sdk.C1977q.m7751i(r8, r7)
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.communicator.C1636a.mo7580a(com.applovin.communicator.AppLovinCommunicatorSubscriber, java.lang.String):boolean");
    }

    /* renamed from: b */
    public void mo7581b(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        C1637b a;
        if (C2025o.m7963b(str)) {
            synchronized (this.f5094c) {
                a = m6234a(str, appLovinCommunicatorSubscriber);
            }
            if (a != null) {
                a.mo7583a(false);
                AppLovinBroadcastManager.getInstance(this.f5092a).unregisterReceiver(a);
            }
        }
    }
}
