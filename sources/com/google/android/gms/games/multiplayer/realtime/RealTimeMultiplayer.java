package com.google.android.gms.games.multiplayer.realtime;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;

@Deprecated
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public interface RealTimeMultiplayer {
    public static final int REAL_TIME_MESSAGE_FAILED = -1;

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public interface ReliableMessageSentCallback {
        void onRealTimeMessageSent(int i, int i2, String str);
    }

    void create(GoogleApiClient googleApiClient, RoomConfig roomConfig);

    void declineInvitation(GoogleApiClient googleApiClient, String str);

    void dismissInvitation(GoogleApiClient googleApiClient, String str);

    Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2);

    Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2, boolean z);

    Intent getWaitingRoomIntent(GoogleApiClient googleApiClient, Room room, int i);

    void join(GoogleApiClient googleApiClient, RoomConfig roomConfig);

    void leave(GoogleApiClient googleApiClient, RoomUpdateListener roomUpdateListener, String str);

    int sendReliableMessage(GoogleApiClient googleApiClient, ReliableMessageSentCallback reliableMessageSentCallback, byte[] bArr, String str, String str2);

    int sendUnreliableMessage(GoogleApiClient googleApiClient, byte[] bArr, String str, String str2);

    int sendUnreliableMessage(GoogleApiClient googleApiClient, byte[] bArr, String str, List<String> list);

    int sendUnreliableMessageToOthers(GoogleApiClient googleApiClient, byte[] bArr, String str);
}
