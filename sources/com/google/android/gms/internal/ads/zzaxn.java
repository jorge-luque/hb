package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzq;

@TargetApi(26)
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public class zzaxn extends zzaxo {
    public final zztp zza(Context context, TelephonyManager telephonyManager) {
        zzq.zzkw();
        if (zzaxa.zzq(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return telephonyManager.isDataEnabled() ? zztp.ENUM_TRUE : zztp.ENUM_FALSE;
        }
        return zztp.ENUM_FALSE;
    }
}
