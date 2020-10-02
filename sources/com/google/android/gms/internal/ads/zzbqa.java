package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbqa implements zzbrs, zzbsm {
    private final zzapn zzblt;
    private final zzdgo zzfkd;
    private final Context zzvf;

    public zzbqa(Context context, zzdgo zzdgo, zzapn zzapn) {
        this.zzvf = context;
        this.zzfkd = zzdgo;
        this.zzblt = zzapn;
    }

    public final void onAdLoaded() {
        zzapl zzapl = this.zzfkd.zzgud;
        if (zzapl != null && zzapl.zzdlf) {
            ArrayList arrayList = new ArrayList();
            if (!this.zzfkd.zzgud.zzdlg.isEmpty()) {
                arrayList.add(this.zzfkd.zzgud.zzdlg);
            }
            this.zzblt.zza(this.zzvf, arrayList);
        }
    }

    public final void zzbx(Context context) {
    }

    public final void zzby(Context context) {
    }

    public final void zzbz(Context context) {
        this.zzblt.detach();
    }
}
