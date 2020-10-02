package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.stats.WakeLockTracker;
import p075d.p088f.p089a.C3217a;

@ShowFirstParty
@KeepForSdk
public abstract class GCoreWakefulBroadcastReceiver extends C3217a {
    private static String TAG = "GCoreWakefulBroadcastReceiver";

    @SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
    @KeepForSdk
    public static boolean completeWakefulIntent(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context != null) {
            WakeLockTracker.getInstance().registerReleaseEvent(context, intent);
        } else {
            String str = TAG;
            String valueOf = String.valueOf(intent.toUri(0));
            Log.w(str, valueOf.length() != 0 ? "context shouldn't be null. intent: ".concat(valueOf) : new String("context shouldn't be null. intent: "));
        }
        return C3217a.completeWakefulIntent(intent);
    }
}
