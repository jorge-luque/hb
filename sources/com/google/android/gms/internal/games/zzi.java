package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzi implements RemoteCall {
    private final String zzhy;

    zzi(String str) {
        this.zzhy = str;
    }

    public final void accept(Object obj, Object obj2) {
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        ((zzg) obj).zza((TaskCompletionSource<Void>) null, this.zzhy);
    }
}
