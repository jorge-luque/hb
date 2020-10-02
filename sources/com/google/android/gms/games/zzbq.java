package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbq implements Continuation<String, Task<Boolean>> {
    private final /* synthetic */ ListenerHolder zzdt;
    private final /* synthetic */ RealTimeMultiplayerClient zzdu;

    zzbq(RealTimeMultiplayerClient realTimeMultiplayerClient, ListenerHolder listenerHolder) {
        this.zzdu = realTimeMultiplayerClient;
        this.zzdt = listenerHolder;
    }

    public final /* synthetic */ Object then(Task task) throws Exception {
        return this.zzdu.doUnregisterEventListener(this.zzdt.getListenerKey());
    }
}
