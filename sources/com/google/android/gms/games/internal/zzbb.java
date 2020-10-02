package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesClientStatusCodes;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzbb {
    private static final zzbi zzjl = zzbh.zzjs;

    public static <R, PendingR extends Result> Task<R> toTask(PendingResult<PendingR> pendingResult, PendingResultUtil.ResultConverter<PendingR, R> resultConverter) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new zzbd(pendingResult, taskCompletionSource, resultConverter));
        return taskCompletionSource.getTask();
    }

    public static <R, PendingR extends Result, ExceptionData> Task<R> zza(PendingResult<PendingR> pendingResult, zzbi zzbi, PendingResultUtil.ResultConverter<PendingR, R> resultConverter, PendingResultUtil.ResultConverter<PendingR, ExceptionData> resultConverter2, zzbg<ExceptionData> zzbg) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new zzba(pendingResult, zzbi, taskCompletionSource, resultConverter, resultConverter2, zzbg));
        return taskCompletionSource.getTask();
    }

    public static <R extends Releasable, PendingR extends Result> Task<AnnotatedData<R>> zzb(PendingResult<PendingR> pendingResult, PendingResultUtil.ResultConverter<PendingR, R> resultConverter) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new zzbf(resultConverter, pendingResult, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public static <R, PendingR extends Result> Task<AnnotatedData<R>> zza(PendingResult<PendingR> pendingResult, PendingResultUtil.ResultConverter<PendingR, R> resultConverter, zzbj<PendingR> zzbj) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new zzbc(pendingResult, taskCompletionSource, resultConverter, zzbj));
        return taskCompletionSource.getTask();
    }

    public static <R, PendingR extends Result> Task<AnnotatedData<R>> zza(PendingResult<PendingR> pendingResult, PendingResultUtil.ResultConverter<PendingR, R> resultConverter) {
        return zza(pendingResult, resultConverter, (zzbj) null);
    }

    public static <R, PendingR extends Result> Task<R> zza(PendingResult<PendingR> pendingResult, zzbi zzbi, PendingResultUtil.ResultConverter<PendingR, R> resultConverter) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new zzbe(zzbi, pendingResult, taskCompletionSource, resultConverter));
        return taskCompletionSource.getTask();
    }

    static final /* synthetic */ void zza(zzbi zzbi, PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, Status status) {
        if (zzbi.zzb(status)) {
            taskCompletionSource.setResult(resultConverter.convert(pendingResult.await(0, TimeUnit.MILLISECONDS)));
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(status)));
        }
    }

    static final /* synthetic */ void zza(PendingResultUtil.ResultConverter resultConverter, PendingResult pendingResult, TaskCompletionSource taskCompletionSource, Status status) {
        boolean z = status.getStatusCode() == 3;
        Releasable releasable = (Releasable) resultConverter.convert(pendingResult.await(0, TimeUnit.MILLISECONDS));
        if (status.isSuccess() || z) {
            taskCompletionSource.setResult(new AnnotatedData(releasable, z));
            return;
        }
        if (releasable != null) {
            releasable.release();
        }
        taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(status)));
    }

    static final /* synthetic */ void zza(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, zzbj zzbj, Status status) {
        boolean z = status.getStatusCode() == 3;
        Result await = pendingResult.await(0, TimeUnit.MILLISECONDS);
        if (status.isSuccess() || z) {
            taskCompletionSource.setResult(new AnnotatedData(resultConverter.convert(await), z));
            return;
        }
        if (!(await == null || zzbj == null)) {
            zzbj.zza(await);
        }
        taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(status)));
    }

    static final /* synthetic */ void zza(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, Status status) {
        Result await = pendingResult.await(0, TimeUnit.MILLISECONDS);
        if (status.isSuccess()) {
            taskCompletionSource.setResult(resultConverter.convert(await));
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(status)));
        }
    }

    static final /* synthetic */ void zza(PendingResult pendingResult, zzbi zzbi, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, PendingResultUtil.ResultConverter resultConverter2, zzbg zzbg, Status status) {
        Result await = pendingResult.await(0, TimeUnit.MILLISECONDS);
        if (zzbi.zzb(status)) {
            taskCompletionSource.setResult(resultConverter.convert(await));
            return;
        }
        Object convert = resultConverter2.convert(await);
        if (convert != null) {
            taskCompletionSource.setException(zzbg.zza(GamesClientStatusCodes.zza(status), convert));
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(status)));
        }
    }
}
