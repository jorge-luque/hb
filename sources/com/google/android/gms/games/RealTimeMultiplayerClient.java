package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.zzg;
import com.google.android.gms.internal.games.zzad;
import com.google.android.gms.tasks.Task;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class RealTimeMultiplayerClient extends zzad {

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public interface ReliableMessageSentCallback extends RealTimeMultiplayer.ReliableMessageSentCallback {
        void onRealTimeMessageSent(int i, int i2, String str);
    }

    RealTimeMultiplayerClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public Task<Void> create(RoomConfig roomConfig) {
        ListenerHolder registerListener = registerListener(roomConfig.zzdp(), zzg.class.getSimpleName());
        return doRegisterEventListener(new zzbh(this, registerListener, registerListener, roomConfig), new zzbk(this, registerListener.getListenerKey()));
    }

    public Task<Void> declineInvitation(String str) {
        return doWrite(new zzbe(this, str));
    }

    public Task<Void> dismissInvitation(String str) {
        return doWrite(new zzbd(this, str));
    }

    public Task<Intent> getSelectOpponentsIntent(int i, int i2) {
        return getSelectOpponentsIntent(i, i2, true);
    }

    public Task<Intent> getWaitingRoomIntent(Room room, int i) {
        return doRead(new zzba(this, room, i));
    }

    public Task<Void> join(RoomConfig roomConfig) {
        ListenerHolder registerListener = registerListener(roomConfig.zzdp(), zzg.class.getSimpleName());
        return doRegisterEventListener(new zzbj(this, registerListener, registerListener, roomConfig), new zzbm(this, registerListener.getListenerKey()));
    }

    public Task<Void> leave(RoomConfig roomConfig, String str) {
        ListenerHolder registerListener = registerListener(roomConfig.zzdp(), zzg.class.getSimpleName());
        return doRead(new zzbg(this, str)).continueWithTask(new zzbq(this, registerListener)).continueWithTask(new zzbl(this, registerListener, str, roomConfig));
    }

    public Task<Integer> sendReliableMessage(byte[] bArr, String str, String str2, ReliableMessageSentCallback reliableMessageSentCallback) {
        return doWrite(new zzbp(this, reliableMessageSentCallback != null ? ListenerHolders.createListenerHolder(reliableMessageSentCallback, Looper.getMainLooper(), ReliableMessageSentCallback.class.getSimpleName()) : null, bArr, str, str2));
    }

    public Task<Void> sendUnreliableMessage(byte[] bArr, String str, String str2) {
        return doWrite(new zzaz(this, bArr, str, str2));
    }

    public Task<Void> sendUnreliableMessageToOthers(byte[] bArr, String str) {
        return doWrite(new zzbb(this, bArr, str));
    }

    RealTimeMultiplayerClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<Intent> getSelectOpponentsIntent(int i, int i2, boolean z) {
        return doRead(new zzbi(this, i, i2, z));
    }

    public Task<Void> sendUnreliableMessage(byte[] bArr, String str, List<String> list) {
        return doWrite(new zzbc(this, list, bArr, str));
    }
}
