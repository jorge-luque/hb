package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbns;
import com.google.android.gms.internal.ads.zzbqh;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdec<R extends zzbqh<AdT>, AdT extends zzbns> implements zzdjk<AdT> {
    private final zzdeu<R, zzdiv<AdT>> zzgrw;

    public zzdec(zzdeu<R, zzdiv<AdT>> zzdeu) {
        this.zzgrw = zzdeu;
    }

    public final zzdri<zzdiv<AdT>> zza(zzdjj zzdjj) {
        zzdeb zzdeb = (zzdeb) zzdjj;
        return this.zzgrw.zza(zzdeb.zzgru, zzdeb.zzgrt);
    }

    public final void zzb(Throwable th) {
    }

    public final void zza(zzdiv<AdT> zzdiv) {
        zzdiv.zzgxt = ((zzbqh) this.zzgrw.zzarj()).zzaed();
    }
}
