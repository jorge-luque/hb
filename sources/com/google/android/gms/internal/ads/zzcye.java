package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.tapjoy.TapjoyConstants;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcye implements zzdah<Bundle> {
    private final Bundle zzdmw;

    public zzcye(Bundle bundle) {
        this.zzdmw = bundle;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza = zzdhj.zza(bundle, TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX);
        zza.putBundle("android_mem_info", this.zzdmw);
        bundle.putBundle(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, zza);
    }
}
