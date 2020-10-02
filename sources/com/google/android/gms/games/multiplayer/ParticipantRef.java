package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class ParticipantRef extends DataBufferRef implements Participant {
    private final PlayerRef zzpm;

    public ParticipantRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zzpm = new PlayerRef(dataHolder, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return ParticipantEntity.zza(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return new ParticipantEntity(this);
    }

    public final int getCapabilities() {
        return getInteger("capabilities");
    }

    public final String getDisplayName() {
        if (hasNull("external_player_id")) {
            return getString("default_display_name");
        }
        return this.zzpm.getDisplayName();
    }

    public final Uri getHiResImageUri() {
        if (hasNull("external_player_id")) {
            return parseUri("default_display_hi_res_image_uri");
        }
        return this.zzpm.getHiResImageUri();
    }

    public final String getHiResImageUrl() {
        if (hasNull("external_player_id")) {
            return getString("default_display_hi_res_image_url");
        }
        return this.zzpm.getHiResImageUrl();
    }

    public final Uri getIconImageUri() {
        if (hasNull("external_player_id")) {
            return parseUri("default_display_image_uri");
        }
        return this.zzpm.getIconImageUri();
    }

    public final String getIconImageUrl() {
        if (hasNull("external_player_id")) {
            return getString("default_display_image_url");
        }
        return this.zzpm.getIconImageUrl();
    }

    public final String getParticipantId() {
        return getString("external_participant_id");
    }

    public final Player getPlayer() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return this.zzpm;
    }

    public final ParticipantResult getResult() {
        if (hasNull("result_type")) {
            return null;
        }
        return new ParticipantResult(getParticipantId(), getInteger("result_type"), getInteger("placing"));
    }

    public final int getStatus() {
        return getInteger("player_status");
    }

    public final int hashCode() {
        return ParticipantEntity.zza((Participant) this);
    }

    public final boolean isConnectedToRoom() {
        return getInteger("connected") > 0;
    }

    public final String toString() {
        return ParticipantEntity.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((ParticipantEntity) ((Participant) freeze())).writeToParcel(parcel, i);
    }

    public final String zzdo() {
        return getString("client_address");
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        if (hasNull("external_player_id")) {
            copyToBuffer("default_display_name", charArrayBuffer);
        } else {
            this.zzpm.getDisplayName(charArrayBuffer);
        }
    }
}
