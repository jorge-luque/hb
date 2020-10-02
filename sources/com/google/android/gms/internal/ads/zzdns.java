package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public class zzdns extends Handler {
    private static zzdnr zzhdp;

    public zzdns() {
    }

    public final void dispatchMessage(Message message) {
        zzb(message);
    }

    /* access modifiers changed from: protected */
    public void zzb(Message message) {
        super.dispatchMessage(message);
    }

    public zzdns(Looper looper) {
        super(looper);
    }

    public zzdns(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }
}
