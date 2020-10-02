package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzamz implements Runnable {
    private final /* synthetic */ zzams zzdhi;
    private final /* synthetic */ AdRequest.ErrorCode zzdhj;

    zzamz(zzams zzams, AdRequest.ErrorCode errorCode) {
        this.zzdhi = zzams;
        this.zzdhj = errorCode;
    }

    public final void run() {
        try {
            this.zzdhi.zzdgu.onAdFailedToLoad(zzane.zza(this.zzdhj));
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }
}
