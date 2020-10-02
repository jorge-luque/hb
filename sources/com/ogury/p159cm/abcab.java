package com.ogury.p159cm;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;

/* renamed from: com.ogury.cm.abcab */
public final class abcab {

    /* renamed from: a */
    public static final abcab f12094a = new abcab();

    /* renamed from: b */
    private static abcba f12095b;

    /* renamed from: c */
    private static BillingClient f12096c;

    /* renamed from: d */
    private static boolean f12097d;

    private abcab() {
    }

    /* renamed from: a */
    public static abccb m15160a(Context context) {
        accbb.m15218b(context, "context");
        abccb abccb = abccb.f12123a;
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("cacheBilling", 0);
        accbb.m15215a((Object) sharedPreferences, "context.applicationConte…ME, Context.MODE_PRIVATE)");
        abccb.m15180a(sharedPreferences);
        return abccb;
    }

    /* renamed from: b */
    public static void m15161b() {
        f12095b = new abccc();
    }

    /* renamed from: a */
    public final synchronized BillingClient mo29492a(Context context, PurchasesUpdatedListener purchasesUpdatedListener) {
        BillingClient billingClient;
        accbb.m15218b(context, "context");
        accbb.m15218b(purchasesUpdatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!f12097d) {
            BillingClient build = BillingClient.newBuilder(context).enablePendingPurchases().setListener(purchasesUpdatedListener).build();
            accbb.m15215a((Object) build, "BillingClient.newBuilder…istener(listener).build()");
            f12096c = build;
        }
        billingClient = f12096c;
        if (billingClient == null) {
            accbb.m15216a("billingClient");
        }
        return billingClient;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e A[Catch:{ Exception -> 0x001d, all -> 0x000d }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.ogury.p159cm.abcba mo29493a() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.ogury.cm.abcba r0 = f12095b     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x002a
            com.ogury.cm.abcca r0 = new com.ogury.cm.abcca     // Catch:{ Exception -> 0x001d, all -> 0x000d }
            r0.<init>()     // Catch:{ Exception -> 0x001d, all -> 0x000d }
            f12095b = r0     // Catch:{ Exception -> 0x001d, all -> 0x000d }
            goto L_0x002a
        L_0x000d:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x0035 }
            if (r1 != 0) goto L_0x0017
            r0.toString()     // Catch:{ all -> 0x0035 }
        L_0x0017:
            com.ogury.cm.abcbc r0 = com.ogury.p159cm.abcbc.f12099a     // Catch:{ all -> 0x0035 }
        L_0x0019:
            com.ogury.p159cm.abcbc.m15166a()     // Catch:{ all -> 0x0035 }
            goto L_0x002a
        L_0x001d:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x0035 }
            if (r1 != 0) goto L_0x0027
            r0.toString()     // Catch:{ all -> 0x0035 }
        L_0x0027:
            com.ogury.cm.abcbc r0 = com.ogury.p159cm.abcbc.f12099a     // Catch:{ all -> 0x0035 }
            goto L_0x0019
        L_0x002a:
            com.ogury.cm.abcba r0 = f12095b     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0033
            java.lang.String r1 = "billingLibrary"
            com.ogury.p159cm.accbb.m15216a((java.lang.String) r1)     // Catch:{ all -> 0x0035 }
        L_0x0033:
            monitor-exit(r2)
            return r0
        L_0x0035:
            r0 = move-exception
            monitor-exit(r2)
            goto L_0x0039
        L_0x0038:
            throw r0
        L_0x0039:
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ogury.p159cm.abcab.mo29493a():com.ogury.cm.abcba");
    }
}
