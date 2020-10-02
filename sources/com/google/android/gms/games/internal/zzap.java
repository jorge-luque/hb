package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzap implements zzg.zzao {
    private final RealTimeMessage zziz;

    zzap(RealTimeMessage realTimeMessage) {
        this.zziz = realTimeMessage;
    }

    public final void accept(Object obj) {
        ((RealTimeMessageReceivedListener) obj).onRealTimeMessageReceived(this.zziz);
    }
}
