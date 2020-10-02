package com.iab.omid.library.oguryco.adsession.video;

import com.iab.omid.library.oguryco.adsession.AdSession;
import com.iab.omid.library.oguryco.adsession.media.InteractionType;
import com.iab.omid.library.oguryco.adsession.media.MediaEvents;
import com.iab.omid.library.oguryco.adsession.media.PlayerState;
import com.iab.omid.library.oguryco.p152d.C4221e;

public final class VideoEvents {
    private final MediaEvents mediaEvents;

    private VideoEvents(MediaEvents mediaEvents2) {
        this.mediaEvents = mediaEvents2;
    }

    public static VideoEvents createVideoEvents(AdSession adSession) {
        try {
            return new VideoEvents(MediaEvents.createMediaEvents(adSession));
        } catch (IllegalStateException e) {
            if ("Cannot create MediaEvents for JavaScript AdSession".equalsIgnoreCase(e.getMessage())) {
                throw new IllegalStateException("Cannot create VideoEvents for JavaScript AdSession");
            } else if ("MediaEvents already exists for AdSession".equalsIgnoreCase(e.getMessage())) {
                throw new IllegalStateException("VideoEvents already exists for AdSession");
            } else {
                throw e;
            }
        }
    }

    public final void adUserInteraction(InteractionType interactionType) {
        C4221e.m14230a((Object) interactionType, "InteractionType is null");
        this.mediaEvents.adUserInteraction(InteractionType.valueOf(interactionType.toString().toUpperCase()));
    }

    public final void bufferFinish() {
        this.mediaEvents.bufferFinish();
    }

    public final void bufferStart() {
        this.mediaEvents.bufferStart();
    }

    public final void complete() {
        this.mediaEvents.complete();
    }

    public final void firstQuartile() {
        this.mediaEvents.firstQuartile();
    }

    public final void loaded(VastProperties vastProperties) {
        C4221e.m14230a((Object) vastProperties, "VastProperties is null");
        this.mediaEvents.loaded(vastProperties.mo28694a());
    }

    public final void midpoint() {
        this.mediaEvents.midpoint();
    }

    public final void pause() {
        this.mediaEvents.pause();
    }

    public final void playerStateChange(PlayerState playerState) {
        C4221e.m14230a((Object) playerState, "PlayerState is null");
        this.mediaEvents.playerStateChange(PlayerState.valueOf(playerState.toString().toUpperCase()));
    }

    public final void resume() {
        this.mediaEvents.resume();
    }

    public final void skipped() {
        this.mediaEvents.skipped();
    }

    public final void start(float f, float f2) {
        this.mediaEvents.start(f, f2);
    }

    public final void thirdQuartile() {
        this.mediaEvents.thirdQuartile();
    }

    public final void volumeChange(float f) {
        this.mediaEvents.volumeChange(f);
    }
}
