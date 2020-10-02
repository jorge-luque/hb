package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzbe implements PendingResult.StatusListener {
    private final TaskCompletionSource zzjh;
    private final PendingResultUtil.ResultConverter zzji;
    private final zzbi zzjp;
    private final PendingResult zzjq;

    zzbe(zzbi zzbi, PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter) {
        this.zzjp = zzbi;
        this.zzjq = pendingResult;
        this.zzjh = taskCompletionSource;
        this.zzji = resultConverter;
    }

    public final void onComplete(Status status) {
        zzbb.zza(this.zzjp, this.zzjq, this.zzjh, this.zzji, status);
    }
}
