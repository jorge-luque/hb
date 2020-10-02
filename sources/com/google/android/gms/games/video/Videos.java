package com.google.android.gms.games.video;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

@Deprecated
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public interface Videos {
    public static final int CAPTURE_OVERLAY_STATE_CAPTURE_STARTED = 2;
    public static final int CAPTURE_OVERLAY_STATE_CAPTURE_STOPPED = 3;
    public static final int CAPTURE_OVERLAY_STATE_DISMISSED = 4;
    public static final int CAPTURE_OVERLAY_STATE_SHOWN = 1;

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public interface CaptureAvailableResult extends Result {
        boolean isAvailable();
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public interface CaptureCapabilitiesResult extends Result {
        VideoCapabilities getCapabilities();
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public interface CaptureOverlayStateListener {
        void onCaptureOverlayStateChanged(int i);
    }

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public interface CaptureStateResult extends Result {
        CaptureState getCaptureState();
    }

    PendingResult<CaptureCapabilitiesResult> getCaptureCapabilities(GoogleApiClient googleApiClient);

    Intent getCaptureOverlayIntent(GoogleApiClient googleApiClient);

    PendingResult<CaptureStateResult> getCaptureState(GoogleApiClient googleApiClient);

    PendingResult<CaptureAvailableResult> isCaptureAvailable(GoogleApiClient googleApiClient, int i);

    boolean isCaptureSupported(GoogleApiClient googleApiClient);

    void registerCaptureOverlayStateChangedListener(GoogleApiClient googleApiClient, CaptureOverlayStateListener captureOverlayStateListener);

    void unregisterCaptureOverlayStateChangedListener(GoogleApiClient googleApiClient);
}
