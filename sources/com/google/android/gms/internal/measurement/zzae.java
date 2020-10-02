package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzae extends zzac.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Bundle zze;
    private final /* synthetic */ zzac zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzae(zzac zzac, String str, String str2, Bundle bundle) {
        super(zzac);
        this.zzf = zzac;
        this.zzc = str;
        this.zzd = str2;
        this.zze = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzf.zzr.clearConditionalUserProperty(this.zzc, this.zzd, this.zze);
    }
}
