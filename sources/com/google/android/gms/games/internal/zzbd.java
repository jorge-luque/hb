package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzbd implements PendingResult.StatusListener {
    private final PendingResult zzjf;
    private final TaskCompletionSource zzjm;
    private final PendingResultUtil.ResultConverter zzjn;

    zzbd(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter) {
        this.zzjf = pendingResult;
        this.zzjm = taskCompletionSource;
        this.zzjn = resultConverter;
    }

    public final void onComplete(Status status) {
        zzbb.zza(this.zzjf, this.zzjm, this.zzjn, status);
    }
}
