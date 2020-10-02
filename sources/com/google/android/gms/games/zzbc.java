package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.internal.zzbr;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbc extends zzar<Void> {
    private final /* synthetic */ byte[] zzdh;
    private final /* synthetic */ String zzdi;
    private final /* synthetic */ List zzdm;

    zzbc(RealTimeMultiplayerClient realTimeMultiplayerClient, List list, byte[] bArr, String str) {
        this.zzdm = list;
        this.zzdh = bArr;
        this.zzdi = str;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        Preconditions.checkNotNull(this.zzdm, "Participant IDs must not be null");
        List list = this.zzdm;
        if (((zzbr) zzg.getService()).zzb(this.zzdh, this.zzdi, (String[]) list.toArray(new String[list.size()])) == 0) {
            taskCompletionSource.setResult(null);
        } else {
            taskCompletionSource.trySetException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza((int) GamesClientStatusCodes.REAL_TIME_MESSAGE_SEND_FAILED)));
        }
    }
}
