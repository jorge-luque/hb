package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzru extends zzgi implements zzrs {
    zzru(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
    }

    public final void onAppOpenAdClosed() throws RemoteException {
        zza(1, obtainAndWriteInterfaceToken());
    }
}
