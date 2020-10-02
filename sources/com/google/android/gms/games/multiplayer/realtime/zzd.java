package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzd extends RoomConfig {
    private final String zzoz;
    private final int zzpe;
    @Deprecated
    private final RoomUpdateListener zzps;
    @Deprecated
    private final RoomStatusUpdateListener zzpt;
    @Deprecated
    private final RealTimeMessageReceivedListener zzpu;
    private final RoomUpdateCallback zzpv;
    private final RoomStatusUpdateCallback zzpw;
    private final zzh zzpx;
    private final OnRealTimeMessageReceivedListener zzpy;
    private final String[] zzpz;
    private final Bundle zzqa;

    zzd(RoomConfig.Builder builder) {
        this.zzps = builder.zzps;
        this.zzpt = builder.zzpt;
        this.zzpu = builder.zzpu;
        RoomUpdateCallback roomUpdateCallback = builder.zzpv;
        this.zzpv = roomUpdateCallback;
        RoomStatusUpdateCallback roomStatusUpdateCallback = builder.zzpw;
        this.zzpw = roomStatusUpdateCallback;
        OnRealTimeMessageReceivedListener onRealTimeMessageReceivedListener = builder.zzpy;
        this.zzpy = onRealTimeMessageReceivedListener;
        if (roomStatusUpdateCallback != null) {
            this.zzpx = new zzh(roomUpdateCallback, roomStatusUpdateCallback, onRealTimeMessageReceivedListener);
        } else {
            this.zzpx = null;
        }
        this.zzoz = builder.zzqb;
        this.zzpe = builder.zzpe;
        this.zzqa = builder.zzqa;
        this.zzpz = (String[]) builder.zzqc.toArray(new String[builder.zzqc.size()]);
        if (this.zzpy == null && this.zzpu == null) {
            throw new NullPointerException("Must specify a message listener");
        }
    }

    public final Bundle getAutoMatchCriteria() {
        return this.zzqa;
    }

    public final String getInvitationId() {
        return this.zzoz;
    }

    public final String[] getInvitedPlayerIds() {
        return this.zzpz;
    }

    @Deprecated
    public final RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.zzpu;
    }

    public final OnRealTimeMessageReceivedListener getOnMessageReceivedListener() {
        return this.zzpy;
    }

    public final RoomStatusUpdateCallback getRoomStatusUpdateCallback() {
        return this.zzpw;
    }

    @Deprecated
    public final RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.zzpt;
    }

    public final RoomUpdateCallback getRoomUpdateCallback() {
        return this.zzpv;
    }

    @Deprecated
    public final RoomUpdateListener getRoomUpdateListener() {
        return this.zzps;
    }

    public final int getVariant() {
        return this.zzpe;
    }

    public final zzg zzdp() {
        return this.zzpx;
    }
}
