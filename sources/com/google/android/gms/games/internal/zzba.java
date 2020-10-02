package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzba implements PendingResult.StatusListener {
    private final PendingResult zzjf;
    private final zzbi zzjg;
    private final TaskCompletionSource zzjh;
    private final PendingResultUtil.ResultConverter zzji;
    private final PendingResultUtil.ResultConverter zzjj;
    private final zzbg zzjk;

    zzba(PendingResult pendingResult, zzbi zzbi, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, PendingResultUtil.ResultConverter resultConverter2, zzbg zzbg) {
        this.zzjf = pendingResult;
        this.zzjg = zzbi;
        this.zzjh = taskCompletionSource;
        this.zzji = resultConverter;
        this.zzjj = resultConverter2;
        this.zzjk = zzbg;
    }

    public final void onComplete(Status status) {
        zzbb.zza(this.zzjf, this.zzjg, this.zzjh, this.zzji, this.zzjj, this.zzjk, status);
    }
}
