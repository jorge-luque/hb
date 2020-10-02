package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzyk extends zzvq {
    final /* synthetic */ zzyi zzcht;

    private zzyk(zzyi zzyi) {
        this.zzcht = zzyi;
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    public final boolean isLoading() throws RemoteException {
        return false;
    }

    public final void zza(zzuj zzuj, int i) throws RemoteException {
        zzazw.zzfa("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzazm.zzzn.post(new zzyn(this));
    }

    public final void zzb(zzuj zzuj) throws RemoteException {
        zza(zzuj, 1);
    }

    public final String zzkh() throws RemoteException {
        return null;
    }
}
