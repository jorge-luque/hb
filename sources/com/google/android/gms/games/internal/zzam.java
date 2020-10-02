package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzam implements zzg.zzar {
    static final zzg.zzar zziy = new zzam();

    private zzam() {
    }

    public final void zza(Object obj, Room room, ArrayList arrayList) {
        ((RoomStatusUpdateListener) obj).onPeerJoined(room, arrayList);
    }
}
