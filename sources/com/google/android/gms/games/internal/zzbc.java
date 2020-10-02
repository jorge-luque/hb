package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzbc implements PendingResult.StatusListener {
    private final PendingResult zzjf;
    private final TaskCompletionSource zzjm;
    private final PendingResultUtil.ResultConverter zzjn;
    private final zzbj zzjo;

    zzbc(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, zzbj zzbj) {
        this.zzjf = pendingResult;
        this.zzjm = taskCompletionSource;
        this.zzjn = resultConverter;
        this.zzjo = zzbj;
    }

    public final void onComplete(Status status) {
        zzbb.zza(this.zzjf, this.zzjm, this.zzjn, this.zzjo, status);
    }
}
