package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.firebase.iid.g1 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
public final class C3709g1 implements C3712h1 {

    /* renamed from: a */
    private final IBinder f10330a;

    C3709g1(IBinder iBinder) {
        this.f10330a = iBinder;
    }

    /* renamed from: a */
    public final void mo27337a(Message message) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
        obtain.writeInt(1);
        message.writeToParcel(obtain, 0);
        try {
            this.f10330a.transact(1, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f10330a;
    }
}
