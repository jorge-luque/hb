package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.games.AchievementsClient;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zze extends AchievementsClient {
    public zze(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public final Task<Intent> getAchievementsIntent() {
        return doRead(zzau.zza(zzg.zzka));
    }

    public final void increment(String str, int i) {
        doWrite(zzau.zza(new zzm(str, i)));
    }

    public final Task<Boolean> incrementImmediate(String str, int i) {
        return doWrite(zzau.zza(new zzl(str, i)));
    }

    public final Task<AnnotatedData<AchievementBuffer>> load(boolean z) {
        return doRead(zzau.zza(new zzf(z)));
    }

    public final void reveal(String str) {
        doWrite(zzau.zza(new zzi(str)));
    }

    public final Task<Void> revealImmediate(String str) {
        return doWrite(zzau.zza(new zzh(str)));
    }

    public final void setSteps(String str, int i) {
        doWrite(zzau.zza(new zzo(str, i)));
    }

    public final Task<Boolean> setStepsImmediate(String str, int i) {
        return doWrite(zzau.zza(new zzn(str, i)));
    }

    public final void unlock(String str) {
        doWrite(zzau.zza(new zzk(str)));
    }

    public final Task<Void> unlockImmediate(String str) {
        return doWrite(zzau.zza(new zzj(str)));
    }

    public zze(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }
}
