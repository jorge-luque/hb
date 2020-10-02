package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzsv;
import com.google.android.gms.internal.ads.zztf;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcgs implements zzbrc, zzbrp, zzbsm, zzbtm, zzbuf, zzub {
    private final zzst zzfyd;
    @GuardedBy("this")
    private boolean zzfye = false;
    @GuardedBy("this")
    private boolean zzfyf = false;

    public zzcgs(zzst zzst, @Nullable zzdfa zzdfa) {
        this.zzfyd = zzst;
        zzst.zza(zzsv.zza.C6839zza.AD_REQUEST);
        if (zzdfa != null) {
            zzst.zza(zzsv.zza.C6839zza.REQUEST_IS_PREFETCH);
        }
    }

    public final synchronized void onAdClicked() {
        if (!this.zzfyf) {
            this.zzfyd.zza(zzsv.zza.C6839zza.AD_FIRST_CLICK);
            this.zzfyf = true;
            return;
        }
        this.zzfyd.zza(zzsv.zza.C6839zza.AD_SUBSEQUENT_CLICK);
    }

    public final void onAdFailedToLoad(int i) {
        switch (i) {
            case 1:
                this.zzfyd.zza(zzsv.zza.C6839zza.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                return;
            case 2:
                this.zzfyd.zza(zzsv.zza.C6839zza.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                return;
            case 3:
                this.zzfyd.zza(zzsv.zza.C6839zza.AD_FAILED_TO_LOAD_NO_FILL);
                return;
            case 4:
                this.zzfyd.zza(zzsv.zza.C6839zza.AD_FAILED_TO_LOAD_TIMEOUT);
                return;
            case 5:
                this.zzfyd.zza(zzsv.zza.C6839zza.AD_FAILED_TO_LOAD_CANCELLED);
                return;
            case 6:
                this.zzfyd.zza(zzsv.zza.C6839zza.AD_FAILED_TO_LOAD_NO_ERROR);
                return;
            case 7:
                this.zzfyd.zza(zzsv.zza.C6839zza.AD_FAILED_TO_LOAD_NOT_FOUND);
                return;
            default:
                this.zzfyd.zza(zzsv.zza.C6839zza.AD_FAILED_TO_LOAD);
                return;
        }
    }

    public final synchronized void onAdImpression() {
        this.zzfyd.zza(zzsv.zza.C6839zza.AD_IMPRESSION);
    }

    public final void onAdLoaded() {
        this.zzfyd.zza(zzsv.zza.C6839zza.AD_LOADED);
    }

    public final void zzaja() {
        this.zzfyd.zza(zzsv.zza.C6839zza.REQUEST_FAILED_TO_LOAD_FROM_CACHE);
    }

    public final void zzb(zzdha zzdha) {
        this.zzfyd.zza((zzsw) new zzcgv(zzdha));
    }

    public final void zzbg(boolean z) {
        zzsv.zza.C6839zza zza;
        zzst zzst = this.zzfyd;
        if (z) {
            zza = zzsv.zza.C6839zza.REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED;
        } else {
            zza = zzsv.zza.C6839zza.REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED;
        }
        zzst.zza(zza);
    }

    public final void zzbh(boolean z) {
        zzsv.zza.C6839zza zza;
        zzst zzst = this.zzfyd;
        if (z) {
            zza = zzsv.zza.C6839zza.NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED;
        } else {
            zza = zzsv.zza.C6839zza.NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED;
        }
        zzst.zza(zza);
    }

    public final void zzc(zztf.zzb zzb) {
        this.zzfyd.zza((zzsw) new zzcgu(zzb));
        this.zzfyd.zza(zzsv.zza.C6839zza.REQUEST_LOADED_FROM_CACHE);
    }

    public final void zzd(zzarj zzarj) {
    }

    public final void zzd(zztf.zzb zzb) {
        this.zzfyd.zza((zzsw) new zzcgx(zzb));
        this.zzfyd.zza(zzsv.zza.C6839zza.REQUEST_SAVED_TO_CACHE);
    }

    public final void zze(zztf.zzb zzb) {
        this.zzfyd.zza((zzsw) new zzcgw(zzb));
        this.zzfyd.zza(zzsv.zza.C6839zza.REQUEST_PREFETCH_INTERCEPTED);
    }
}
