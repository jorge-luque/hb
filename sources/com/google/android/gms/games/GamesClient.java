package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.games.Games;
import com.google.android.gms.internal.games.zzad;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class GamesClient extends zzad {
    GamesClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    public Task<Bundle> getActivationHint() {
        return doRead(new zzm(this));
    }

    public Task<String> getAppId() {
        return doRead(new zzk(this));
    }

    public Task<String> getCurrentAccountName() {
        return doRead(new zzl(this));
    }

    @KeepForSdk
    public Task<Integer> getSdkVariant() {
        return doRead(new zzo(this));
    }

    public Task<Intent> getSettingsIntent() {
        return doRead(new zzn(this));
    }

    public Task<Void> setGravityForPopups(int i) {
        return doWrite(new zzj(this, i));
    }

    public Task<Void> setViewForPopups(View view) {
        return doWrite(new zzi(this, view));
    }

    GamesClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }
}
