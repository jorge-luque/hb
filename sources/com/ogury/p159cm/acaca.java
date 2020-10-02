package com.ogury.p159cm;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.ogury.cm.acaca */
public final class acaca implements IInterface {

    /* renamed from: a */
    private final IBinder f12134a;

    public acaca(IBinder iBinder) {
        accbb.m15218b(iBinder, "binder");
        this.f12134a = iBinder;
    }

    /* renamed from: a */
    public final String mo29521a() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.f12134a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            if (readString == null) {
                readString = "";
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    /* renamed from: a */
    public final boolean mo29522a(boolean z) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            boolean z2 = true;
            obtain.writeInt(1);
            this.f12134a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z2 = false;
            }
            return z2;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f12134a;
    }
}
