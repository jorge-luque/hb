package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzxc extends zzgi implements zzxa {
    zzxc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
    }

    public final void onAdMetadataChanged() throws RemoteException {
        zza(1, obtainAndWriteInterfaceToken());
    }
}
