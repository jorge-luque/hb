package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzg implements RemoteCall {
    static final RemoteCall zzka = new zzg();

    private zzg() {
    }

    public final void accept(Object obj, Object obj2) {
        ((TaskCompletionSource) obj2).setResult(((com.google.android.gms.games.internal.zzg) obj).zzbk());
    }
}
