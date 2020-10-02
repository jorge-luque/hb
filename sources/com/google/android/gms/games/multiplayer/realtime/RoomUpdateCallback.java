package com.google.android.gms.games.multiplayer.realtime;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public abstract class RoomUpdateCallback implements RoomUpdateListener {
    public abstract void onJoinedRoom(int i, Room room);

    public abstract void onLeftRoom(int i, String str);

    public abstract void onRoomConnected(int i, Room room);

    public abstract void onRoomCreated(int i, Room room);
}
