package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.games.internal.zzbr;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzaz extends zzar<Void> {
    private final /* synthetic */ byte[] zzdh;
    private final /* synthetic */ String zzdi;
    private final /* synthetic */ String zzdj;

    zzaz(RealTimeMultiplayerClient realTimeMultiplayerClient, byte[] bArr, String str, String str2) {
        this.zzdh = bArr;
        this.zzdi = str;
        this.zzdj = str2;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        if (((zzbr) zzg.getService()).zzb(this.zzdh, this.zzdi, new String[]{this.zzdj}) == 0) {
            taskCompletionSource.setResult(null);
        } else {
            taskCompletionSource.trySetException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza((int) GamesClientStatusCodes.REAL_TIME_MESSAGE_SEND_FAILED)));
        }
    }
}
