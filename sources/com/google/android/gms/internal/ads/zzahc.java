package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public interface zzahc extends IInterface {
    void onInitializationFailed(String str) throws RemoteException;

    void onInitializationSucceeded() throws RemoteException;
}
