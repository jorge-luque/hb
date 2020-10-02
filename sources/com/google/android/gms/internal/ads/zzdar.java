package com.google.android.gms.internal.ads;

import admost.sdk.base.AdMostExperimentManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tapjoy.TapjoyConstants;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdar implements zzdah<Bundle> {
    private final String zzdpx;
    private final int zzdpy;
    private final int zzdpz;
    private final int zzdqa;
    private final boolean zzdqb;
    private final int zzdqc;

    public zzdar(String str, int i, int i2, int i3, boolean z, int i4) {
        this.zzdpx = str;
        this.zzdpy = i;
        this.zzdpz = i2;
        this.zzdqa = i3;
        this.zzdqb = z;
        this.zzdqc = i4;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.zzdpx;
        boolean z = true;
        zzdhj.zza(bundle, "carrier", str, !TextUtils.isEmpty(str));
        Integer valueOf = Integer.valueOf(this.zzdpy);
        if (this.zzdpy == -2) {
            z = false;
        }
        zzdhj.zza(bundle, "cnt", valueOf, z);
        bundle.putInt("gnt", this.zzdpz);
        bundle.putInt("pt", this.zzdqa);
        Bundle zza = zzdhj.zza(bundle, TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX);
        bundle.putBundle(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, zza);
        Bundle zza2 = zzdhj.zza(zza, AdMostExperimentManager.TYPE_NETWORK);
        zza.putBundle(AdMostExperimentManager.TYPE_NETWORK, zza2);
        zza2.putInt("active_network_state", this.zzdqc);
        zza2.putBoolean("active_network_metered", this.zzdqb);
    }
}
