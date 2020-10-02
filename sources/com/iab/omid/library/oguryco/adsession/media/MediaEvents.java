package com.iab.omid.library.oguryco.adsession.media;

import com.iab.omid.library.oguryco.adsession.AdSession;
import com.iab.omid.library.oguryco.adsession.C4199a;
import com.iab.omid.library.oguryco.p150b.C4209f;
import com.iab.omid.library.oguryco.p152d.C4217b;
import com.iab.omid.library.oguryco.p152d.C4221e;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONObject;

public final class MediaEvents {
    private final C4199a adSession;

    private MediaEvents(C4199a aVar) {
        this.adSession = aVar;
    }

    private void confirmValidDuration(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    private void confirmValidVolume(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public static MediaEvents createMediaEvents(AdSession adSession2) {
        C4199a aVar = (C4199a) adSession2;
        C4221e.m14230a((Object) adSession2, "AdSession is null");
        C4221e.m14238g(aVar);
        C4221e.m14229a(aVar);
        C4221e.m14233b(aVar);
        C4221e.m14236e(aVar);
        MediaEvents mediaEvents = new MediaEvents(aVar);
        aVar.getAdSessionStatePublisher().mo28772a(mediaEvents);
        return mediaEvents;
    }

    public final void adUserInteraction(InteractionType interactionType) {
        C4221e.m14230a((Object) interactionType, "InteractionType is null");
        C4221e.m14234c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C4217b.m14214a(jSONObject, "interactionType", interactionType);
        this.adSession.getAdSessionStatePublisher().mo28775a("adUserInteraction", jSONObject);
    }

    public final void bufferFinish() {
        C4221e.m14234c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo28773a("bufferFinish");
    }

    public final void bufferStart() {
        C4221e.m14234c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo28773a(TJAdUnitConstants.String.VIDEO_BUFFER_START);
    }

    public final void complete() {
        C4221e.m14234c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo28773a(TJAdUnitConstants.String.VIDEO_COMPLETE);
    }

    public final void firstQuartile() {
        C4221e.m14234c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo28773a(TJAdUnitConstants.String.VIDEO_FIRST_QUARTILE);
    }

    public final void loaded(VastProperties vastProperties) {
        C4221e.m14230a((Object) vastProperties, "VastProperties is null");
        C4221e.m14233b(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo28775a("loaded", vastProperties.mo28686a());
    }

    public final void midpoint() {
        C4221e.m14234c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo28773a(TJAdUnitConstants.String.VIDEO_MIDPOINT);
    }

    public final void pause() {
        C4221e.m14234c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo28773a("pause");
    }

    public final void playerStateChange(PlayerState playerState) {
        C4221e.m14230a((Object) playerState, "PlayerState is null");
        C4221e.m14234c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C4217b.m14214a(jSONObject, "state", playerState);
        this.adSession.getAdSessionStatePublisher().mo28775a("playerStateChange", jSONObject);
    }

    public final void resume() {
        C4221e.m14234c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo28773a("resume");
    }

    public final void skipped() {
        C4221e.m14234c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo28773a(TJAdUnitConstants.String.VIDEO_SKIPPED);
    }

    public final void start(float f, float f2) {
        confirmValidDuration(f);
        confirmValidVolume(f2);
        C4221e.m14234c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C4217b.m14214a(jSONObject, "duration", Float.valueOf(f));
        C4217b.m14214a(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
        C4217b.m14214a(jSONObject, "deviceVolume", Float.valueOf(C4209f.m14178a().mo28757d()));
        this.adSession.getAdSessionStatePublisher().mo28775a(TJAdUnitConstants.String.VIDEO_START, jSONObject);
    }

    public final void thirdQuartile() {
        C4221e.m14234c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo28773a(TJAdUnitConstants.String.VIDEO_THIRD_QUARTILE);
    }

    public final void volumeChange(float f) {
        confirmValidVolume(f);
        C4221e.m14234c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C4217b.m14214a(jSONObject, "mediaPlayerVolume", Float.valueOf(f));
        C4217b.m14214a(jSONObject, "deviceVolume", Float.valueOf(C4209f.m14178a().mo28757d()));
        this.adSession.getAdSessionStatePublisher().mo28775a("volumeChange", jSONObject);
    }
}
