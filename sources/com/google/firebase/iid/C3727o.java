package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/* renamed from: com.google.firebase.iid.o */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final class C3727o {

    /* renamed from: a */
    private final Messenger f10354a;

    /* renamed from: b */
    private final zzj f10355b;

    C3727o(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f10354a = new Messenger(iBinder);
            this.f10355b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f10355b = new zzj(iBinder);
            this.f10354a = null;
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            Log.w("MessengerIpcClient", valueOf.length() != 0 ? "Invalid interface descriptor: ".concat(valueOf) : new String("Invalid interface descriptor: "));
            throw new RemoteException();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo27356a(Message message) throws RemoteException {
        Messenger messenger = this.f10354a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        zzj zzj = this.f10355b;
        if (zzj != null) {
            zzj.mo27381a(message);
            return;
        }
        throw new IllegalStateException("Both messengers are null");
    }
}
