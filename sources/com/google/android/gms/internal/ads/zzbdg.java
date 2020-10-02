package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbdg implements zzbdt {
    public final zzbdl zza(zzbbx zzbbx, int i, String str, zzbby zzbby) {
        if (i <= 0) {
            return new zzbdw(zzbbx);
        }
        int zzaaj = zzbcu.zzaaj();
        if (zzaaj < zzbby.zzedy) {
            return new zzbea(zzbbx, zzbby);
        }
        if (zzaaj < zzbby.zzeds) {
            return new zzbdx(zzbbx, zzbby);
        }
        return new zzbdv(zzbbx);
    }
}
