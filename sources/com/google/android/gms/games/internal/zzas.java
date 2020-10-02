package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzas implements zzg.zzao {
    private final int zzhh;
    private final String zzja;

    zzas(int i, String str) {
        this.zzhh = i;
        this.zzja = str;
    }

    public final void accept(Object obj) {
        ((RoomUpdateListener) obj).onLeftRoom(this.zzhh, this.zzja);
    }
}
