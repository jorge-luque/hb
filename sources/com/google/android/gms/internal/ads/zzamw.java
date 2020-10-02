package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzamw implements Runnable {
    private final /* synthetic */ zzams zzdhi;

    zzamw(zzams zzams) {
        this.zzdhi = zzams;
    }

    public final void run() {
        try {
            this.zzdhi.zzdgu.onAdClosed();
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }
}
