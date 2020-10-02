package com.onesignal;

import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.onesignal.h0 */
/* compiled from: OSDynamicTriggerTimer */
class C4515h0 {
    /* renamed from: a */
    static void m15550a(TimerTask timerTask, String str, long j) {
        new Timer("trigger_timer:" + str).schedule(timerTask, j);
    }
}
