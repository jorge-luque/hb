package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcyi implements zzdah<Bundle> {
    private final zzdgm zzfgh;

    public zzcyi(zzdgm zzdgm) {
        this.zzfgh = zzdgm;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzdgm zzdgm = this.zzfgh;
        if (zzdgm != null) {
            bundle.putBoolean("render_in_browser", zzdgm.zzars());
            bundle.putBoolean("disable_ml", this.zzfgh.zzart());
        }
    }
}
