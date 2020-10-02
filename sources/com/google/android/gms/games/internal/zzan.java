package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzan implements zzg.zzao {
    private final String zzhy;

    zzan(String str) {
        this.zzhy = str;
    }

    public final void accept(Object obj) {
        ((RoomStatusUpdateListener) obj).onP2PConnected(this.zzhy);
    }
}
