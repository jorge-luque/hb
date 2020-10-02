package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.ads.zzdmf;
import com.google.android.gms.internal.ads.zzdmm;

@ShowFirstParty
/* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
public final class zzdly {
    private final Looper zzhbp;
    private final Context zzvf;

    public zzdly(Context context, Looper looper) {
        this.zzvf = context;
        this.zzhbp = looper;
    }

    public final void zzgz(String str) {
        new zzdlx(this.zzvf, this.zzhbp, (zzdmm) ((zzecd) zzdmm.zzaus().zzhc(this.zzvf.getPackageName()).zzb(zzdmm.zza.BLOCKED_IMPRESSION).zza(zzdmf.zzauq().zzhb(str).zzb(zzdmf.zza.BLOCKED_REASON_BACKGROUND)).zzbet())).zzaul();
    }
}
