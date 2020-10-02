package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzahb implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzbaj zzbsv;

    zzahb(zzagu zzagu, zzbaj zzbaj) {
        this.zzbsv = zzbaj;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzbsv.setException(new RuntimeException("Connection failed."));
    }
}
