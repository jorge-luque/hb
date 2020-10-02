package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
public class zzj implements Parcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new C3738t0();

    /* renamed from: a */
    private Messenger f10406a;

    /* renamed from: b */
    private C3712h1 f10407b;

    /* renamed from: com.google.firebase.iid.zzj$a */
    /* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
    public static final class C3751a extends ClassLoader {
        /* access modifiers changed from: protected */
        public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z);
            }
            boolean l = FirebaseInstanceId.m12532l();
            return zzj.class;
        }
    }

    public zzj(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f10406a = new Messenger(iBinder);
        } else {
            this.f10407b = new C3709g1(iBinder);
        }
    }

    /* renamed from: a */
    public final void mo27381a(Message message) throws RemoteException {
        Messenger messenger = this.f10406a;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f10407b.mo27337a(message);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return m12655a().equals(((zzj) obj).m12655a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return m12655a().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.f10406a;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.f10407b.asBinder());
        }
    }

    /* renamed from: a */
    private final IBinder m12655a() {
        Messenger messenger = this.f10406a;
        return messenger != null ? messenger.getBinder() : this.f10407b.asBinder();
    }
}
