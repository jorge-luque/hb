package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzah implements zzg.zzao {
    private final int zzhh;
    private final int zziq;
    private final String zzir;

    zzah(int i, int i2, String str) {
        this.zzhh = i;
        this.zziq = i2;
        this.zzir = str;
    }

    public final void accept(Object obj) {
        ((RealTimeMultiplayer.ReliableMessageSentCallback) obj).onRealTimeMessageSent(this.zzhh, this.zziq, this.zzir);
    }
}
