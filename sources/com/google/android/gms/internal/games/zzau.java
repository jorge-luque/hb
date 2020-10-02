package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzau {
    static <ResultT> TaskApiCall<zzg, ResultT> zza(RemoteCall<zzg, TaskCompletionSource<ResultT>> remoteCall) {
        return TaskApiCall.builder().run(new zzat(remoteCall)).build();
    }
}
