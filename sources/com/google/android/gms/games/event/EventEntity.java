package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzc;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "EventEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class EventEntity extends zzc implements Event {
    public static final Parcelable.Creator<EventEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getDescription", mo15196id = 3)
    private final String description;
    @SafeParcelable.Field(getter = "getName", mo15196id = 2)
    private final String name;
    @SafeParcelable.Field(getter = "getValue", mo15196id = 7)
    private final long value;
    @SafeParcelable.Field(getter = "getPlayer", mo15196id = 6)
    private final PlayerEntity zzfl;
    @SafeParcelable.Field(getter = "getEventId", mo15196id = 1)
    private final String zzgn;
    @SafeParcelable.Field(getter = "getFormattedValue", mo15196id = 8)
    private final String zzgo;
    @SafeParcelable.Field(getter = "isVisible", mo15196id = 9)
    private final boolean zzgp;
    @SafeParcelable.Field(getter = "getIconImageUri", mo15196id = 4)
    private final Uri zzn;
    @SafeParcelable.Field(getter = "getIconImageUrl", mo15196id = 5)
    private final String zzy;

    public EventEntity(Event event) {
        this.zzgn = event.getEventId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.zzn = event.getIconImageUri();
        this.zzy = event.getIconImageUrl();
        this.zzfl = (PlayerEntity) event.getPlayer().freeze();
        this.value = event.getValue();
        this.zzgo = event.getFormattedValue();
        this.zzgp = event.isVisible();
    }

    static int zza(Event event) {
        return Objects.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    static String zzb(Event event) {
        return Objects.toStringHelper(event).add("Id", event.getEventId()).add("Name", event.getName()).add("Description", event.getDescription()).add("IconImageUri", event.getIconImageUri()).add("IconImageUrl", event.getIconImageUrl()).add("Player", event.getPlayer()).add("Value", Long.valueOf(event.getValue())).add("FormattedValue", event.getFormattedValue()).add("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    public final Event freeze() {
        return this;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getEventId() {
        return this.zzgn;
    }

    public final String getFormattedValue() {
        return this.zzgo;
    }

    public final Uri getIconImageUri() {
        return this.zzn;
    }

    public final String getIconImageUrl() {
        return this.zzy;
    }

    public final String getName() {
        return this.name;
    }

    public final Player getPlayer() {
        return this.zzfl;
    }

    public final long getValue() {
        return this.value;
    }

    public final int hashCode() {
        return zza(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final boolean isVisible() {
        return this.zzgp;
    }

    public final String toString() {
        return zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getEventId(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeString(parcel, 3, getDescription(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, getIconImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 5, getIconImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPlayer(), i, false);
        SafeParcelWriter.writeLong(parcel, 7, getValue());
        SafeParcelWriter.writeString(parcel, 8, getFormattedValue(), false);
        SafeParcelWriter.writeBoolean(parcel, 9, isVisible());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.description, charArrayBuffer);
    }

    public final void getFormattedValue(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzgo, charArrayBuffer);
    }

    public final void getName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.name, charArrayBuffer);
    }

    @SafeParcelable.Constructor
    EventEntity(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) String str2, @SafeParcelable.Param(mo15199id = 3) String str3, @SafeParcelable.Param(mo15199id = 4) Uri uri, @SafeParcelable.Param(mo15199id = 5) String str4, @SafeParcelable.Param(mo15199id = 6) Player player, @SafeParcelable.Param(mo15199id = 7) long j, @SafeParcelable.Param(mo15199id = 8) String str5, @SafeParcelable.Param(mo15199id = 9) boolean z) {
        this.zzgn = str;
        this.name = str2;
        this.description = str3;
        this.zzn = uri;
        this.zzy = str4;
        this.zzfl = new PlayerEntity(player);
        this.value = j;
        this.zzgo = str5;
        this.zzgp = z;
    }

    static boolean zza(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return Objects.equal(event2.getEventId(), event.getEventId()) && Objects.equal(event2.getName(), event.getName()) && Objects.equal(event2.getDescription(), event.getDescription()) && Objects.equal(event2.getIconImageUri(), event.getIconImageUri()) && Objects.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && Objects.equal(event2.getPlayer(), event.getPlayer()) && Objects.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && Objects.equal(event2.getFormattedValue(), event.getFormattedValue()) && Objects.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }
}
