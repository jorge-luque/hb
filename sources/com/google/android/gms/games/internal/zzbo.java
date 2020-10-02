package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.games.zza;
import com.google.android.gms.internal.games.zzd;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public abstract class zzbo extends zza implements zzbp {
    public zzbo() {
        super("com.google.android.gms.games.internal.IGamesClient");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1001) {
            return false;
        }
        zzbt zzaz = zzaz();
        parcel2.writeNoException();
        zzd.zzb(parcel2, zzaz);
        return true;
    }
}
