package com.google.android.gms.internal.ads;

import p075d.p080b.C3191a;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcbi implements zzbrp {
    private final zzbzx zzfqb;
    private final zzcab zzfrc;

    public zzcbi(zzbzx zzbzx, zzcab zzcab) {
        this.zzfqb = zzbzx;
        this.zzfrc = zzcab;
    }

    public final void onAdImpression() {
        if (this.zzfqb.zzald() != null) {
            zzbek zzalc = this.zzfqb.zzalc();
            zzbek zzalb = this.zzfqb.zzalb();
            if (zzalc == null) {
                zzalc = zzalb != null ? zzalb : null;
            }
            if (this.zzfrc.zzaks() && zzalc != null) {
                zzalc.zza("onSdkImpression", new C3191a());
            }
        }
    }
}
