package p118io.presage.core;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: io.presage.core.m1 */
public final class C6329m1 implements IInterface {
    public static final String IIIIIIIl = llllIlll.IIIIIIII;
    public IBinder IIIIIIII;

    public C6329m1(IBinder iBinder) {
        this.IIIIIIII = iBinder;
    }

    public String IIIIIIII() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IIIIIIIl);
            this.IIIIIIII.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean IIIIIIII(boolean z) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IIIIIIIl);
            obtain.writeInt(z ? 1 : 0);
            boolean z2 = false;
            this.IIIIIIII.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z2 = true;
            }
            return z2;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.IIIIIIII;
    }
}
