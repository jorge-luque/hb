package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdhy implements zzawj, zzbrc {
    private final zzawo zzdtl;
    @GuardedBy("this")
    private final HashSet<zzawc> zzgvp = new HashSet<>();
    private final Context zzvf;

    public zzdhy(Context context, zzawo zzawo) {
        this.zzvf = context;
        this.zzdtl = zzawo;
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (i != 3) {
            this.zzdtl.zzb(this.zzgvp);
        }
    }

    public final synchronized void zza(HashSet<zzawc> hashSet) {
        this.zzgvp.clear();
        this.zzgvp.addAll(hashSet);
    }

    public final Bundle zzash() {
        return this.zzdtl.zza(this.zzvf, (zzawj) this);
    }
}
