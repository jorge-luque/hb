package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzyp implements Runnable {
    private final /* synthetic */ zzym zzchw;

    zzyp(zzym zzym) {
        this.zzchw = zzym;
    }

    public final void run() {
        if (this.zzchw.zzbmt != null) {
            try {
                this.zzchw.zzbmt.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzazw.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
