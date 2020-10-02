package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.internal.games.zzar;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbp extends zzar<Integer> {
    private final /* synthetic */ byte[] zzdh;
    private final /* synthetic */ String zzdi;
    private final /* synthetic */ String zzdj;
    private final /* synthetic */ ListenerHolder zzdx;

    zzbp(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerHolder listenerHolder, byte[] bArr, String str, String str2) {
        this.zzdx = listenerHolder;
        this.zzdh = bArr;
        this.zzdi = str;
        this.zzdj = str2;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzg zzg, TaskCompletionSource<Integer> taskCompletionSource) throws RemoteException {
        Integer valueOf = Integer.valueOf(zzg.zza((ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback>) this.zzdx, this.zzdh, this.zzdi, this.zzdj));
        if (valueOf.intValue() == -1) {
            taskCompletionSource.trySetException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza((int) GamesClientStatusCodes.REAL_TIME_MESSAGE_SEND_FAILED)));
        } else {
            taskCompletionSource.setResult(valueOf);
        }
    }
}
