package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.tapjoy.TapjoyConstants;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcwx implements zzdah<Bundle> {
    private final double zzdqd;
    private final boolean zzdqe;

    public zzcwx(double d, boolean z) {
        this.zzdqd = d;
        this.zzdqe = z;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza = zzdhj.zza(bundle, TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX);
        bundle.putBundle(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, zza);
        Bundle zza2 = zzdhj.zza(zza, "battery");
        zza.putBundle("battery", zza2);
        zza2.putBoolean("is_charging", this.zzdqe);
        zza2.putDouble("battery_level", this.zzdqd);
    }
}
