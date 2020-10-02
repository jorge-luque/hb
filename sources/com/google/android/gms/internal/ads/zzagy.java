package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzagy implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzbaj zzbsv;
    private final /* synthetic */ zzagu zzdbf;

    zzagy(zzagu zzagu, zzbaj zzbaj) {
        this.zzdbf = zzagu;
        this.zzbsv = zzbaj;
    }

    public final void onConnected(Bundle bundle) {
        try {
            this.zzbsv.set(this.zzdbf.zzdbd.zzso());
        } catch (DeadObjectException e) {
            this.zzbsv.setException(e);
        }
    }

    public final void onConnectionSuspended(int i) {
        zzbaj zzbaj = this.zzbsv;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        zzbaj.setException(new RuntimeException(sb.toString()));
    }
}
