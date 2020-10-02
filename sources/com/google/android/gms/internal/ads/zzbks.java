package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbks implements zzegz<Set<zzbvt<zzbrp>>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzbkp> zzfhv;
    private final zzehm<JSONObject> zzfhw;

    private zzbks(zzehm<zzbkp> zzehm, zzehm<Executor> zzehm2, zzehm<JSONObject> zzehm3) {
        this.zzfhv = zzehm;
        this.zzenm = zzehm2;
        this.zzfhw = zzehm3;
    }

    public static zzbks zza(zzehm<zzbkp> zzehm, zzehm<Executor> zzehm2, zzehm<JSONObject> zzehm3) {
        return new zzbks(zzehm, zzehm2, zzehm3);
    }

    public final /* synthetic */ Object get() {
        Set set;
        zzbkp zzbkp = this.zzfhv.get();
        Executor executor = this.zzenm.get();
        if (this.zzfhw.get() == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzbvt(zzbkp, executor));
        }
        return (Set) zzehf.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
