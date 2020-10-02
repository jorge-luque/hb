package com.onesignal;

import admost.sdk.base.AdMost;
import java.util.List;

/* renamed from: com.onesignal.u0 */
/* compiled from: OSNotification */
public class C4667u0 {

    /* renamed from: a */
    public C4717x0 f12698a;

    /* renamed from: b */
    public C4668a f12699b;

    /* renamed from: c */
    public List<C4717x0> f12700c;

    /* renamed from: com.onesignal.u0$a */
    /* compiled from: OSNotification */
    public enum C4668a {
        Notification,
        InAppAlert,
        f12703c;

        static {
            Notification = new C4668a("Notification", 0);
            InAppAlert = new C4668a("InAppAlert", 1);
            f12703c = new C4668a(AdMost.CONSENT_ZONE_NONE, 2);
        }
    }
}
