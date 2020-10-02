package com.google.android.gms.games;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.multiplayer.realtime.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzbn implements ListenerHolder.Notifier<zzg> {
    private final /* synthetic */ zzbo zzdv;

    zzbn(zzbo zzbo) {
        this.zzdv = zzbo;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((zzg) obj).onLeftRoom(0, this.zzdv.zzdw.zzdi);
    }

    public final void onNotifyListenerFailed() {
        this.zzdv.zzdw.zzdp.getRoomUpdateCallback().onLeftRoom(0, this.zzdv.zzdw.zzdi);
    }
}
