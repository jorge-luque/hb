package p093e.p094a.p095a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: e.a.a.v */
/* compiled from: GooglePlayServicesClient */
public class C3354v {

    /* renamed from: e.a.a.v$b */
    /* compiled from: GooglePlayServicesClient */
    private static final class C3356b implements ServiceConnection {

        /* renamed from: a */
        boolean f9416a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f9417b;

        private C3356b() {
            this.f9416a = false;
            this.f9417b = new LinkedBlockingQueue<>(1);
        }

        /* renamed from: a */
        public IBinder mo19101a() throws InterruptedException {
            if (!this.f9416a) {
                this.f9416a = true;
                return this.f9417b.take();
            }
            throw new IllegalStateException();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f9417b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: e.a.a.v$c */
    /* compiled from: GooglePlayServicesClient */
    public static final class C3357c {

        /* renamed from: a */
        private final String f9418a;

        /* renamed from: b */
        private final Boolean f9419b;

        C3357c(String str, Boolean bool) {
            this.f9418a = str;
            this.f9419b = bool;
        }

        /* renamed from: a */
        public String mo19104a() {
            return this.f9418a;
        }

        /* renamed from: b */
        public Boolean mo19105b() {
            return this.f9419b;
        }
    }

    /* renamed from: a */
    public static C3357c m11169a(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                C3356b bVar = new C3356b();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, bVar, 1)) {
                    try {
                        C3358d dVar = new C3358d(bVar.mo19101a());
                        C3357c cVar = new C3357c(dVar.mo19107a(), dVar.mo19106a(true));
                        context.unbindService(bVar);
                        return cVar;
                    } catch (Exception e) {
                        throw e;
                    } catch (Throwable th) {
                        context.unbindService(bVar);
                        throw th;
                    }
                } else {
                    throw new IOException("Google Play connection failed");
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            throw new IllegalStateException("Google Play Services info can't be accessed from the main thread");
        }
    }

    /* renamed from: e.a.a.v$d */
    /* compiled from: GooglePlayServicesClient */
    private static final class C3358d implements IInterface {

        /* renamed from: a */
        private IBinder f9420a;

        public C3358d(IBinder iBinder) {
            this.f9420a = iBinder;
        }

        /* renamed from: a */
        public String mo19107a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f9420a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.f9420a;
        }

        /* renamed from: a */
        public Boolean mo19106a(boolean z) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z2 = false;
                obtain.writeInt(z ? 1 : 0);
                this.f9420a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z2 = true;
                }
                Boolean valueOf = Boolean.valueOf(z2);
                if (valueOf != null) {
                    return Boolean.valueOf(!valueOf.booleanValue());
                }
                return null;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
