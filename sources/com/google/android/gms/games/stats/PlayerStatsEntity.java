package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzc;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "PlayerStatsEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class PlayerStatsEntity extends zzc implements PlayerStats {
    public static final Parcelable.Creator<PlayerStatsEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getAverageSessionLength", mo15196id = 1)
    private final float zzrq;
    @SafeParcelable.Field(getter = "getChurnProbability", mo15196id = 2)
    private final float zzrr;
    @SafeParcelable.Field(getter = "getDaysSinceLastPlayed", mo15196id = 3)
    private final int zzrs;
    @SafeParcelable.Field(getter = "getNumberOfPurchases", mo15196id = 4)
    private final int zzrt;
    @SafeParcelable.Field(getter = "getNumberOfSessions", mo15196id = 5)
    private final int zzru;
    @SafeParcelable.Field(getter = "getSessionPercentile", mo15196id = 6)
    private final float zzrv;
    @SafeParcelable.Field(getter = "getSpendPercentile", mo15196id = 7)
    private final float zzrw;
    @SafeParcelable.Field(getter = "getRawValues", mo15196id = 8)
    private final Bundle zzrx;
    @SafeParcelable.Field(getter = "getSpendProbability", mo15196id = 9)
    private final float zzry;
    @SafeParcelable.Field(getter = "getHighSpenderProbability", mo15196id = 10)
    private final float zzrz;
    @SafeParcelable.Field(getter = "getTotalSpendNext28Days", mo15196id = 11)
    private final float zzsa;

    public PlayerStatsEntity(PlayerStats playerStats) {
        this.zzrq = playerStats.getAverageSessionLength();
        this.zzrr = playerStats.getChurnProbability();
        this.zzrs = playerStats.getDaysSinceLastPlayed();
        this.zzrt = playerStats.getNumberOfPurchases();
        this.zzru = playerStats.getNumberOfSessions();
        this.zzrv = playerStats.getSessionPercentile();
        this.zzrw = playerStats.getSpendPercentile();
        this.zzry = playerStats.getSpendProbability();
        this.zzrz = playerStats.getHighSpenderProbability();
        this.zzsa = playerStats.getTotalSpendNext28Days();
        this.zzrx = playerStats.zzdt();
    }

    static int zza(PlayerStats playerStats) {
        return Objects.hashCode(Float.valueOf(playerStats.getAverageSessionLength()), Float.valueOf(playerStats.getChurnProbability()), Integer.valueOf(playerStats.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfSessions()), Float.valueOf(playerStats.getSessionPercentile()), Float.valueOf(playerStats.getSpendPercentile()), Float.valueOf(playerStats.getSpendProbability()), Float.valueOf(playerStats.getHighSpenderProbability()), Float.valueOf(playerStats.getTotalSpendNext28Days()));
    }

    static String zzb(PlayerStats playerStats) {
        return Objects.toStringHelper(playerStats).add("AverageSessionLength", Float.valueOf(playerStats.getAverageSessionLength())).add("ChurnProbability", Float.valueOf(playerStats.getChurnProbability())).add("DaysSinceLastPlayed", Integer.valueOf(playerStats.getDaysSinceLastPlayed())).add("NumberOfPurchases", Integer.valueOf(playerStats.getNumberOfPurchases())).add("NumberOfSessions", Integer.valueOf(playerStats.getNumberOfSessions())).add("SessionPercentile", Float.valueOf(playerStats.getSessionPercentile())).add("SpendPercentile", Float.valueOf(playerStats.getSpendPercentile())).add("SpendProbability", Float.valueOf(playerStats.getSpendProbability())).add("HighSpenderProbability", Float.valueOf(playerStats.getHighSpenderProbability())).add("TotalSpendNext28Days", Float.valueOf(playerStats.getTotalSpendNext28Days())).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public float getAverageSessionLength() {
        return this.zzrq;
    }

    public float getChurnProbability() {
        return this.zzrr;
    }

    public int getDaysSinceLastPlayed() {
        return this.zzrs;
    }

    public float getHighSpenderProbability() {
        return this.zzrz;
    }

    public int getNumberOfPurchases() {
        return this.zzrt;
    }

    public int getNumberOfSessions() {
        return this.zzru;
    }

    public float getSessionPercentile() {
        return this.zzrv;
    }

    public float getSpendPercentile() {
        return this.zzrw;
    }

    public float getSpendProbability() {
        return this.zzry;
    }

    public float getTotalSpendNext28Days() {
        return this.zzsa;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 1, getAverageSessionLength());
        SafeParcelWriter.writeFloat(parcel, 2, getChurnProbability());
        SafeParcelWriter.writeInt(parcel, 3, getDaysSinceLastPlayed());
        SafeParcelWriter.writeInt(parcel, 4, getNumberOfPurchases());
        SafeParcelWriter.writeInt(parcel, 5, getNumberOfSessions());
        SafeParcelWriter.writeFloat(parcel, 6, getSessionPercentile());
        SafeParcelWriter.writeFloat(parcel, 7, getSpendPercentile());
        SafeParcelWriter.writeBundle(parcel, 8, this.zzrx, false);
        SafeParcelWriter.writeFloat(parcel, 9, getSpendProbability());
        SafeParcelWriter.writeFloat(parcel, 10, getHighSpenderProbability());
        SafeParcelWriter.writeFloat(parcel, 11, getTotalSpendNext28Days());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final Bundle zzdt() {
        return this.zzrx;
    }

    static boolean zza(PlayerStats playerStats, Object obj) {
        if (!(obj instanceof PlayerStats)) {
            return false;
        }
        if (playerStats == obj) {
            return true;
        }
        PlayerStats playerStats2 = (PlayerStats) obj;
        return Objects.equal(Float.valueOf(playerStats2.getAverageSessionLength()), Float.valueOf(playerStats.getAverageSessionLength())) && Objects.equal(Float.valueOf(playerStats2.getChurnProbability()), Float.valueOf(playerStats.getChurnProbability())) && Objects.equal(Integer.valueOf(playerStats2.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getDaysSinceLastPlayed())) && Objects.equal(Integer.valueOf(playerStats2.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfPurchases())) && Objects.equal(Integer.valueOf(playerStats2.getNumberOfSessions()), Integer.valueOf(playerStats.getNumberOfSessions())) && Objects.equal(Float.valueOf(playerStats2.getSessionPercentile()), Float.valueOf(playerStats.getSessionPercentile())) && Objects.equal(Float.valueOf(playerStats2.getSpendPercentile()), Float.valueOf(playerStats.getSpendPercentile())) && Objects.equal(Float.valueOf(playerStats2.getSpendProbability()), Float.valueOf(playerStats.getSpendProbability())) && Objects.equal(Float.valueOf(playerStats2.getHighSpenderProbability()), Float.valueOf(playerStats.getHighSpenderProbability())) && Objects.equal(Float.valueOf(playerStats2.getTotalSpendNext28Days()), Float.valueOf(playerStats.getTotalSpendNext28Days()));
    }

    @SafeParcelable.Constructor
    PlayerStatsEntity(@SafeParcelable.Param(mo15199id = 1) float f, @SafeParcelable.Param(mo15199id = 2) float f2, @SafeParcelable.Param(mo15199id = 3) int i, @SafeParcelable.Param(mo15199id = 4) int i2, @SafeParcelable.Param(mo15199id = 5) int i3, @SafeParcelable.Param(mo15199id = 6) float f3, @SafeParcelable.Param(mo15199id = 7) float f4, @SafeParcelable.Param(mo15199id = 8) Bundle bundle, @SafeParcelable.Param(mo15199id = 9) float f5, @SafeParcelable.Param(mo15199id = 10) float f6, @SafeParcelable.Param(mo15199id = 11) float f7) {
        this.zzrq = f;
        this.zzrr = f2;
        this.zzrs = i;
        this.zzrt = i2;
        this.zzru = i3;
        this.zzrv = f3;
        this.zzrw = f4;
        this.zzrx = bundle;
        this.zzry = f5;
        this.zzrz = f6;
        this.zzsa = f7;
    }
}
