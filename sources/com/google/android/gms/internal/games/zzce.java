package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzce implements RealTimeMultiplayer {
    private static <L> ListenerHolder<L> zza(GoogleApiClient googleApiClient, L l) {
        if (l == null) {
            return null;
        }
        return googleApiClient.registerListener(l);
    }

    private static ListenerHolder<RoomStatusUpdateListener> zzb(GoogleApiClient googleApiClient, RoomConfig roomConfig) {
        if (roomConfig.getRoomStatusUpdateCallback() != null) {
            return zza(googleApiClient, roomConfig.getRoomStatusUpdateCallback());
        }
        return zza(googleApiClient, roomConfig.getRoomStatusUpdateListener());
    }

    private static ListenerHolder<RealTimeMessageReceivedListener> zzc(GoogleApiClient googleApiClient, RoomConfig roomConfig) {
        if (roomConfig.getOnMessageReceivedListener() != null) {
            return googleApiClient.registerListener(roomConfig.getOnMessageReceivedListener());
        }
        return googleApiClient.registerListener(roomConfig.getMessageReceivedListener());
    }

    public final void create(GoogleApiClient googleApiClient, RoomConfig roomConfig) {
        zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzb((ListenerHolder<? extends RoomUpdateListener>) zza(googleApiClient, roomConfig), (ListenerHolder<? extends RoomStatusUpdateListener>) zzb(googleApiClient, roomConfig), (ListenerHolder<? extends RealTimeMessageReceivedListener>) zzc(googleApiClient, roomConfig), roomConfig);
        }
    }

    public final void declineInvitation(GoogleApiClient googleApiClient, String str) {
        zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zze(str, 0);
        }
    }

    public final void dismissInvitation(GoogleApiClient googleApiClient, String str) {
        zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzc(str, 0);
        }
    }

    public final Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2) {
        return Games.zza(googleApiClient).zzd(i, i2, true);
    }

    public final Intent getWaitingRoomIntent(GoogleApiClient googleApiClient, Room room, int i) {
        return Games.zza(googleApiClient).zzb(room, i);
    }

    public final void join(GoogleApiClient googleApiClient, RoomConfig roomConfig) {
        zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzd(zza(googleApiClient, roomConfig), zzb(googleApiClient, roomConfig), zzc(googleApiClient, roomConfig), roomConfig);
        }
    }

    public final void leave(GoogleApiClient googleApiClient, RoomUpdateListener roomUpdateListener, String str) {
        zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zza((ListenerHolder<? extends RoomUpdateListener>) googleApiClient.registerListener(roomUpdateListener), str);
        }
    }

    public final int sendReliableMessage(GoogleApiClient googleApiClient, RealTimeMultiplayer.ReliableMessageSentCallback reliableMessageSentCallback, byte[] bArr, String str, String str2) {
        return Games.zza(googleApiClient).zzb((ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback>) zza(googleApiClient, reliableMessageSentCallback), bArr, str, str2);
    }

    public final int sendUnreliableMessage(GoogleApiClient googleApiClient, byte[] bArr, String str, String str2) {
        return Games.zza(googleApiClient).zza(bArr, str, new String[]{str2});
    }

    public final int sendUnreliableMessageToOthers(GoogleApiClient googleApiClient, byte[] bArr, String str) {
        return Games.zza(googleApiClient).zzb(bArr, str);
    }

    private static ListenerHolder<RoomUpdateListener> zza(GoogleApiClient googleApiClient, RoomConfig roomConfig) {
        if (roomConfig.getRoomUpdateCallback() != null) {
            return googleApiClient.registerListener(roomConfig.getRoomUpdateCallback());
        }
        return googleApiClient.registerListener(roomConfig.getRoomUpdateListener());
    }

    public final Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2, boolean z) {
        return Games.zza(googleApiClient).zzd(i, i2, z);
    }

    public final int sendUnreliableMessage(GoogleApiClient googleApiClient, byte[] bArr, String str, List<String> list) {
        return Games.zza(googleApiClient).zza(bArr, str, (String[]) list.toArray(new String[list.size()]));
    }
}
