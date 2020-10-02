package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzdu implements Videos {
    public final PendingResult<Videos.CaptureCapabilitiesResult> getCaptureCapabilities(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzdt(this, googleApiClient));
    }

    public final Intent getCaptureOverlayIntent(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzcg();
    }

    public final PendingResult<Videos.CaptureStateResult> getCaptureState(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzdw(this, googleApiClient));
    }

    public final PendingResult<Videos.CaptureAvailableResult> isCaptureAvailable(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.enqueue(new zzdv(this, googleApiClient, i));
    }

    public final boolean isCaptureSupported(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzci();
    }

    public final void registerCaptureOverlayStateChangedListener(GoogleApiClient googleApiClient, Videos.CaptureOverlayStateListener captureOverlayStateListener) {
        zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzf(googleApiClient.registerListener(captureOverlayStateListener));
        }
    }

    public final void unregisterCaptureOverlayStateChangedListener(GoogleApiClient googleApiClient) {
        zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzck();
        }
    }
}
