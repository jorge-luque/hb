package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzbf implements PendingResult.StatusListener {
    private final TaskCompletionSource zzjh;
    private final PendingResult zzjq;
    private final PendingResultUtil.ResultConverter zzjr;

    zzbf(PendingResultUtil.ResultConverter resultConverter, PendingResult pendingResult, TaskCompletionSource taskCompletionSource) {
        this.zzjr = resultConverter;
        this.zzjq = pendingResult;
        this.zzjh = taskCompletionSource;
    }

    public final void onComplete(Status status) {
        zzbb.zza(this.zzjr, this.zzjq, this.zzjh, status);
    }
}
