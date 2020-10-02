package p118io.presage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: io.presage.b */
public final class C6236b implements IInterface {

    /* renamed from: a */
    public static final CamembertauCalvados f16778a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final IBinder f16779b;

    /* renamed from: io.presage.b$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public C6236b(IBinder iBinder) {
        this.f16779b = iBinder;
    }

    /* renamed from: a */
    public final String mo34771a() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.f16779b.transact(1, obtain, obtain2, 0);
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

    public final IBinder asBinder() {
        return this.f16779b;
    }

    /* renamed from: b */
    public final boolean mo34773b() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            boolean z = true;
            obtain.writeInt(1);
            this.f16779b.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z = false;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
