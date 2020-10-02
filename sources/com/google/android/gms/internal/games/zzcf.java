package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcf extends zzcp {
    private final /* synthetic */ String zzko;
    private final /* synthetic */ boolean zzkp;
    private final /* synthetic */ int zzkq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcf(zzcd zzcd, GoogleApiClient googleApiClient, String str, boolean z, int i) {
        super(googleApiClient, (zzcg) null);
        this.zzko = str;
        this.zzkp = z;
        this.zzkq = i;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zza((BaseImplementation.ResultHolder<Snapshots.OpenSnapshotResult>) this, this.zzko, this.zzkp, this.zzkq);
    }
}
