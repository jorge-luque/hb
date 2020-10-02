package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbe extends zzbm {
    private final /* synthetic */ String zzbo;
    private final /* synthetic */ boolean zzkb;
    private final /* synthetic */ int zzkh;
    private final /* synthetic */ int zzki;
    private final /* synthetic */ int zzkj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbe(zzba zzba, GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z) {
        super(googleApiClient, (zzaz) null);
        this.zzbo = str;
        this.zzkh = i;
        this.zzki = i2;
        this.zzkj = i3;
        this.zzkb = z;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zza(this, this.zzbo, this.zzkh, this.zzki, this.zzkj, this.zzkb);
    }
}
