package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcxj implements zzdah<Bundle> {
    @Nullable
    private final Location zzmp;

    public zzcxj(@Nullable Location location) {
        this.zzmp = location;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zzmp != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("radius", this.zzmp.getAccuracy() * 1000.0f);
            bundle2.putLong("lat", (long) (this.zzmp.getLatitude() * 1.0E7d));
            bundle2.putLong("long", (long) (this.zzmp.getLongitude() * 1.0E7d));
            bundle2.putLong("time", this.zzmp.getTime() * 1000);
            bundle.putBundle("uule", bundle2);
        }
    }
}
