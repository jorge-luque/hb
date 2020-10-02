package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzsr implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzbaj zzbsv;
    private final /* synthetic */ zzsl zzbsw;

    zzsr(zzsl zzsl, zzbaj zzbaj) {
        this.zzbsw = zzsl;
        this.zzbsv = zzbaj;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzbsw.lock) {
            this.zzbsv.setException(new RuntimeException("Connection failed."));
        }
    }
}
