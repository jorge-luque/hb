package com.google.android.gms.games.multiplayer.realtime;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzh implements zzg {
    private final RoomUpdateCallback zzpv;
    private final RoomStatusUpdateCallback zzpw;
    private final OnRealTimeMessageReceivedListener zzqh;

    public zzh(RoomUpdateCallback roomUpdateCallback, RoomStatusUpdateCallback roomStatusUpdateCallback, OnRealTimeMessageReceivedListener onRealTimeMessageReceivedListener) {
        this.zzpv = roomUpdateCallback;
        this.zzpw = roomStatusUpdateCallback;
        this.zzqh = onRealTimeMessageReceivedListener;
    }

    public final void onConnectedToRoom(Room room) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpw;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onConnectedToRoom(room);
        }
    }

    public final void onDisconnectedFromRoom(Room room) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpw;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onDisconnectedFromRoom(room);
        }
    }

    public final void onJoinedRoom(int i, Room room) {
        RoomUpdateCallback roomUpdateCallback = this.zzpv;
        if (roomUpdateCallback != null) {
            roomUpdateCallback.onJoinedRoom(i, room);
        }
    }

    public final void onLeftRoom(int i, String str) {
        RoomUpdateCallback roomUpdateCallback = this.zzpv;
        if (roomUpdateCallback != null) {
            roomUpdateCallback.onLeftRoom(i, str);
        }
    }

    public final void onP2PConnected(String str) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpw;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onP2PConnected(str);
        }
    }

    public final void onP2PDisconnected(String str) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpw;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onP2PDisconnected(str);
        }
    }

    public final void onPeerDeclined(Room room, List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpw;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeerDeclined(room, list);
        }
    }

    public final void onPeerInvitedToRoom(Room room, List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpw;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeerInvitedToRoom(room, list);
        }
    }

    public final void onPeerJoined(Room room, List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpw;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeerJoined(room, list);
        }
    }

    public final void onPeerLeft(Room room, List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpw;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeerLeft(room, list);
        }
    }

    public final void onPeersConnected(Room room, List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpw;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeersConnected(room, list);
        }
    }

    public final void onPeersDisconnected(Room room, List<String> list) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpw;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onPeersDisconnected(room, list);
        }
    }

    public final void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {
        OnRealTimeMessageReceivedListener onRealTimeMessageReceivedListener = this.zzqh;
        if (onRealTimeMessageReceivedListener != null) {
            onRealTimeMessageReceivedListener.onRealTimeMessageReceived(realTimeMessage);
        }
    }

    public final void onRoomAutoMatching(Room room) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpw;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onRoomAutoMatching(room);
        }
    }

    public final void onRoomConnected(int i, Room room) {
        RoomUpdateCallback roomUpdateCallback = this.zzpv;
        if (roomUpdateCallback != null) {
            roomUpdateCallback.onRoomConnected(i, room);
        }
    }

    public final void onRoomConnecting(Room room) {
        RoomStatusUpdateCallback roomStatusUpdateCallback = this.zzpw;
        if (roomStatusUpdateCallback != null) {
            roomStatusUpdateCallback.onRoomConnecting(room);
        }
    }

    public final void onRoomCreated(int i, Room room) {
        RoomUpdateCallback roomUpdateCallback = this.zzpv;
        if (roomUpdateCallback != null) {
            roomUpdateCallback.onRoomCreated(i, room);
        }
    }
}
