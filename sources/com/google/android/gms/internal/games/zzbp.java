package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzbp implements Notifications {
    public final void clear(GoogleApiClient googleApiClient, int i) {
        zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzo(i);
        }
    }

    public final void clearAll(GoogleApiClient googleApiClient) {
        clear(googleApiClient, Notifications.NOTIFICATION_TYPES_ALL);
    }
}
