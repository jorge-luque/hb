package p093e.p101c.p102a.p111b.p112a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: e.c.a.b.a.a */
/* compiled from: IGetInstallReferrerService */
public interface C3476a extends IInterface {

    /* renamed from: e.c.a.b.a.a$a */
    /* compiled from: IGetInstallReferrerService */
    public static abstract class C3477a extends Binder implements C3476a {

        /* renamed from: e.c.a.b.a.a$a$a */
        /* compiled from: IGetInstallReferrerService */
        private static class C3478a implements C3476a {

            /* renamed from: a */
            private IBinder f9596a;

            C3478a(IBinder iBinder) {
                this.f9596a = iBinder;
            }

            /* renamed from: a */
            public Bundle mo19257a(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f9596a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f9596a;
            }
        }

        /* renamed from: a */
        public static C3476a m11526a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C3476a)) {
                return new C3478a(iBinder);
            }
            return (C3476a) queryLocalInterface;
        }
    }

    /* renamed from: a */
    Bundle mo19257a(Bundle bundle) throws RemoteException;
}
