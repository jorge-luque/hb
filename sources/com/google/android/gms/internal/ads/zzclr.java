package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzclr implements Callable {
    private final zzdri zzfmu;
    private final zzdri zzfvm;

    zzclr(zzdri zzdri, zzdri zzdri2) {
        this.zzfvm = zzdri;
        this.zzfmu = zzdri2;
    }

    public final Object call() {
        return new zzcmg((JSONObject) this.zzfvm.get(), (zzarp) this.zzfmu.get());
    }
}
