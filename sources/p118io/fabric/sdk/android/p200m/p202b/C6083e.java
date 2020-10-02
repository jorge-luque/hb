package p118io.fabric.sdk.android.p200m.p202b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import p118io.fabric.sdk.android.C6059c;

/* renamed from: io.fabric.sdk.android.m.b.e */
/* compiled from: AdvertisingInfoServiceStrategy */
class C6083e implements C6087f {

    /* renamed from: a */
    private final Context f16013a;

    /* renamed from: io.fabric.sdk.android.m.b.e$b */
    /* compiled from: AdvertisingInfoServiceStrategy */
    private static final class C6085b implements ServiceConnection {

        /* renamed from: a */
        private boolean f16014a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f16015b;

        private C6085b() {
            this.f16014a = false;
            this.f16015b = new LinkedBlockingQueue<>(1);
        }

        /* renamed from: a */
        public IBinder mo34158a() {
            if (this.f16014a) {
                C6059c.m19630f().mo34089b("Fabric", "getBinder already called");
            }
            this.f16014a = true;
            try {
                return this.f16015b.poll(200, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return null;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f16015b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f16015b.clear();
        }
    }

    /* renamed from: io.fabric.sdk.android.m.b.e$c */
    /* compiled from: AdvertisingInfoServiceStrategy */
    private static final class C6086c implements IInterface {

        /* renamed from: a */
        private final IBinder f16016a;

        public C6086c(IBinder iBinder) {
            this.f16016a = iBinder;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
            r1.recycle();
            r0.recycle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003d, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            p118io.fabric.sdk.android.C6059c.m19630f().mo34093d("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0025 */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo34161a() throws android.os.RemoteException {
            /*
                r6 = this;
                android.os.Parcel r0 = android.os.Parcel.obtain()
                android.os.Parcel r1 = android.os.Parcel.obtain()
                r2 = 0
                java.lang.String r3 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService"
                r0.writeInterfaceToken(r3)     // Catch:{ Exception -> 0x0025 }
                r3 = 1
                r0.writeInt(r3)     // Catch:{ Exception -> 0x0025 }
                android.os.IBinder r4 = r6.f16016a     // Catch:{ Exception -> 0x0025 }
                r5 = 2
                r4.transact(r5, r0, r1, r2)     // Catch:{ Exception -> 0x0025 }
                r1.readException()     // Catch:{ Exception -> 0x0025 }
                int r4 = r1.readInt()     // Catch:{ Exception -> 0x0025 }
                if (r4 == 0) goto L_0x0030
                r2 = 1
                goto L_0x0030
            L_0x0023:
                r2 = move-exception
                goto L_0x0037
            L_0x0025:
                io.fabric.sdk.android.k r3 = p118io.fabric.sdk.android.C6059c.m19630f()     // Catch:{ all -> 0x0023 }
                java.lang.String r4 = "Fabric"
                java.lang.String r5 = "Could not get parcel from Google Play Service to capture Advertising limitAdTracking"
                r3.mo34093d(r4, r5)     // Catch:{ all -> 0x0023 }
            L_0x0030:
                r1.recycle()
                r0.recycle()
                return r2
            L_0x0037:
                r1.recycle()
                r0.recycle()
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p118io.fabric.sdk.android.p200m.p202b.C6083e.C6086c.mo34161a():boolean");
        }

        public IBinder asBinder() {
            return this.f16016a;
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:5|6|7|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0022, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
            p118io.fabric.sdk.android.C6059c.m19630f().mo34093d("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
            r1.recycle();
            r0.recycle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0037, code lost:
            r1.recycle();
            r0.recycle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
            throw r2;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0024 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String getId() throws android.os.RemoteException {
            /*
                r5 = this;
                android.os.Parcel r0 = android.os.Parcel.obtain()
                android.os.Parcel r1 = android.os.Parcel.obtain()
                java.lang.String r2 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService"
                r0.writeInterfaceToken(r2)     // Catch:{ Exception -> 0x0024 }
                android.os.IBinder r2 = r5.f16016a     // Catch:{ Exception -> 0x0024 }
                r3 = 1
                r4 = 0
                r2.transact(r3, r0, r1, r4)     // Catch:{ Exception -> 0x0024 }
                r1.readException()     // Catch:{ Exception -> 0x0024 }
                java.lang.String r2 = r1.readString()     // Catch:{ Exception -> 0x0024 }
                r1.recycle()
                r0.recycle()
                goto L_0x0036
            L_0x0022:
                r2 = move-exception
                goto L_0x0037
            L_0x0024:
                io.fabric.sdk.android.k r2 = p118io.fabric.sdk.android.C6059c.m19630f()     // Catch:{ all -> 0x0022 }
                java.lang.String r3 = "Fabric"
                java.lang.String r4 = "Could not get parcel from Google Play Service to capture AdvertisingId"
                r2.mo34093d(r3, r4)     // Catch:{ all -> 0x0022 }
                r1.recycle()
                r0.recycle()
                r2 = 0
            L_0x0036:
                return r2
            L_0x0037:
                r1.recycle()
                r0.recycle()
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p118io.fabric.sdk.android.p200m.p202b.C6083e.C6086c.getId():java.lang.String");
        }
    }

    public C6083e(Context context) {
        this.f16013a = context.getApplicationContext();
    }

    /* renamed from: a */
    public C6079b mo34156a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            C6059c.m19630f().mo34093d("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.f16013a.getPackageManager().getPackageInfo("com.android.vending", 0);
            C6085b bVar = new C6085b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (this.f16013a.bindService(intent, bVar, 1)) {
                    try {
                        C6086c cVar = new C6086c(bVar.mo34158a());
                        C6079b bVar2 = new C6079b(cVar.getId(), cVar.mo34161a());
                        this.f16013a.unbindService(bVar);
                        return bVar2;
                    } catch (Exception e) {
                        C6059c.m19630f().mo34087a("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", (Throwable) e);
                        this.f16013a.unbindService(bVar);
                    }
                } else {
                    C6059c.m19630f().mo34093d("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                    return null;
                }
            } catch (Throwable th) {
                C6059c.m19630f().mo34092c("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", th);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            C6059c.m19630f().mo34093d("Fabric", "Unable to find Google Play Services package name");
            return null;
        } catch (Exception e2) {
            C6059c.m19630f().mo34092c("Fabric", "Unable to determine if Google Play Services is available", e2);
            return null;
        }
    }
}
