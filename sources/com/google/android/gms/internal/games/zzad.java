package com.google.android.gms.internal.games;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.games.Games;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class zzad extends GoogleApi<Games.GamesOptions> {
    protected zzad(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, Games.API, gamesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    /* access modifiers changed from: protected */
    public ClientSettings.Builder createClientSettingsBuilder() {
        ClientSettings.Builder createClientSettingsBuilder = super.createClientSettingsBuilder();
        return (getApiOptions() == null || ((Games.GamesOptions) getApiOptions()).zzax == null) ? createClientSettingsBuilder : createClientSettingsBuilder.setRealClientPackageName(((Games.GamesOptions) getApiOptions()).zzax);
    }

    protected zzad(Context context, Games.GamesOptions gamesOptions) {
        super(context, Games.API, gamesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
