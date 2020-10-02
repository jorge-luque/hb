package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzboq<T> {
    private final Executor executor;
    private final zzckg zzflj;
    private final zzckn zzflk;
    private final zzdhe zzfll;
    private final zzdku zzflm;
    private final zzbju zzfln;
    private final zzcqp<T> zzflo;
    /* access modifiers changed from: private */
    public final zzbtx zzflp;
    private final zzdha zzflq;
    private final zzclf zzflr;
    private final zzbqc zzfls;

    zzboq(zzckg zzckg, zzckn zzckn, zzdhe zzdhe, zzdku zzdku, zzbju zzbju, zzcqp<T> zzcqp, zzbtx zzbtx, zzdha zzdha, zzclf zzclf, zzbqc zzbqc, Executor executor2) {
        this.zzflj = zzckg;
        this.zzflk = zzckn;
        this.zzfll = zzdhe;
        this.zzflm = zzdku;
        this.zzfln = zzbju;
        this.zzflo = zzcqp;
        this.zzflp = zzbtx;
        this.zzflq = zzdha;
        this.zzflr = zzclf;
        this.zzfls = zzbqc;
        this.executor = executor2;
    }

    private final zzdri<zzdha> zza(zzdri<zzarj> zzdri) {
        if (this.zzflq != null) {
            return this.zzflm.zzu(zzdkr.SERVER_TRANSACTION).zze(zzdqw.zzag(this.zzflq)).zzaud();
        }
        zzq.zzlc().zzmu();
        if (this.zzfll.zzguw.zzceu != null) {
            return this.zzflm.zzu(zzdkr.SERVER_TRANSACTION).zze(this.zzflk.zzaos()).zzaud();
        }
        return this.zzflm.zza(zzdkr.SERVER_TRANSACTION, zzdri).zza(this.zzflj).zzaud();
    }

    public final zzdri<zzdha> zzaih() {
        return zza(this.zzfls.zzail());
    }

    public final zzdri<T> zzaii() {
        return zzb(zzaih());
    }

    public final zzbtx zzaij() {
        return this.zzflp;
    }

    public final zzdri<T> zzb(zzdri<zzdha> zzdri) {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcrq)).booleanValue()) {
            return this.zzflm.zza(zzdkr.RENDERER, zzdri).zza(this.zzfln).zza(this.zzflo).zzaud();
        }
        return this.zzflm.zza(zzdkr.RENDERER, zzdri).zza(this.zzfln).zza(this.zzflo).zza((long) ((Integer) zzvj.zzpv().zzd(zzzz.zzcrr)).intValue(), TimeUnit.SECONDS).zzaud();
    }

    public final zzdri<Void> zzc(zzarj zzarj) {
        zzdkd<E, I> zzaud = this.zzflm.zza(zzdkr.NOTIFY_CACHE_HIT, this.zzflr.zzk(zzarj)).zzaud();
        zzdqw.zza(zzaud, new zzbov(this), this.executor);
        return zzaud;
    }

    public final zzdri<zzdha> zza(zzarj zzarj) {
        return zza((zzdri<zzarj>) zzdqw.zzag(zzarj));
    }

    public final zzdri<zzarj> zza(zzdir zzdir) {
        zzdkd<E, O2> zzaud = this.zzflm.zza(zzdkr.GET_CACHE_KEY, this.zzfls.zzail()).zza(new zzbot(this, zzdir)).zzaud();
        zzdqw.zza(zzaud, new zzbos(this), this.executor);
        return zzaud;
    }

    public final zzdri<T> zzb(zzarj zzarj) {
        return zzb(zza(zzarj));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(zzdir zzdir, zzarj zzarj) throws Exception {
        zzarj.zzdph = zzdir;
        return this.zzflr.zzj(zzarj);
    }
}
