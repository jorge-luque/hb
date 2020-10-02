package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzsb implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzrx zzbsk;

    zzsb(zzrx zzrx) {
        this.zzbsk = zzrx;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzbsk.lock) {
            zzsk unused = this.zzbsk.zzbsh = null;
            if (this.zzbsk.zzbsg != null) {
                zzsg unused2 = this.zzbsk.zzbsg = null;
            }
            this.zzbsk.lock.notifyAll();
        }
    }
}
