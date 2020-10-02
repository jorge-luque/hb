package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcya implements zzdah<Bundle> {
    private final String zzdmx;
    private final boolean zzdmz;

    public zzcya(String str, boolean z) {
        this.zzdmx = str;
        this.zzdmz = z;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("gct", this.zzdmx);
        if (this.zzdmz) {
            bundle.putString("de", "1");
        }
    }
}
