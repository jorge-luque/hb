package com.iab.omid.library.adcolony.adsession.media;

import com.iab.omid.library.adcolony.adsession.AdSession;
import com.iab.omid.library.adcolony.adsession.C4148a;
import com.iab.omid.library.adcolony.p144b.C4158f;
import com.iab.omid.library.adcolony.p146d.C4166b;
import com.iab.omid.library.adcolony.p146d.C4170e;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONObject;

public final class MediaEvents {

    /* renamed from: a */
    private final C4148a f11156a;

    private MediaEvents(C4148a aVar) {
        this.f11156a = aVar;
    }

    /* renamed from: a */
    private void m13898a(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    /* renamed from: b */
    private void m13899b(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public static MediaEvents createMediaEvents(AdSession adSession) {
        C4148a aVar = (C4148a) adSession;
        C4170e.m14001a((Object) adSession, "AdSession is null");
        C4170e.m14009g(aVar);
        C4170e.m14000a(aVar);
        C4170e.m14004b(aVar);
        C4170e.m14007e(aVar);
        MediaEvents mediaEvents = new MediaEvents(aVar);
        aVar.getAdSessionStatePublisher().mo28558a(mediaEvents);
        return mediaEvents;
    }

    public void adUserInteraction(InteractionType interactionType) {
        C4170e.m14001a((Object) interactionType, "InteractionType is null");
        C4170e.m14005c(this.f11156a);
        JSONObject jSONObject = new JSONObject();
        C4166b.m13985a(jSONObject, "interactionType", interactionType);
        this.f11156a.getAdSessionStatePublisher().mo28561a("adUserInteraction", jSONObject);
    }

    public void bufferFinish() {
        C4170e.m14005c(this.f11156a);
        this.f11156a.getAdSessionStatePublisher().mo28559a("bufferFinish");
    }

    public void bufferStart() {
        C4170e.m14005c(this.f11156a);
        this.f11156a.getAdSessionStatePublisher().mo28559a(TJAdUnitConstants.String.VIDEO_BUFFER_START);
    }

    public void complete() {
        C4170e.m14005c(this.f11156a);
        this.f11156a.getAdSessionStatePublisher().mo28559a(TJAdUnitConstants.String.VIDEO_COMPLETE);
    }

    public void firstQuartile() {
        C4170e.m14005c(this.f11156a);
        this.f11156a.getAdSessionStatePublisher().mo28559a(TJAdUnitConstants.String.VIDEO_FIRST_QUARTILE);
    }

    public void midpoint() {
        C4170e.m14005c(this.f11156a);
        this.f11156a.getAdSessionStatePublisher().mo28559a(TJAdUnitConstants.String.VIDEO_MIDPOINT);
    }

    public void pause() {
        C4170e.m14005c(this.f11156a);
        this.f11156a.getAdSessionStatePublisher().mo28559a("pause");
    }

    public void playerStateChange(PlayerState playerState) {
        C4170e.m14001a((Object) playerState, "PlayerState is null");
        C4170e.m14005c(this.f11156a);
        JSONObject jSONObject = new JSONObject();
        C4166b.m13985a(jSONObject, "state", playerState);
        this.f11156a.getAdSessionStatePublisher().mo28561a("playerStateChange", jSONObject);
    }

    public void resume() {
        C4170e.m14005c(this.f11156a);
        this.f11156a.getAdSessionStatePublisher().mo28559a("resume");
    }

    public void skipped() {
        C4170e.m14005c(this.f11156a);
        this.f11156a.getAdSessionStatePublisher().mo28559a(TJAdUnitConstants.String.VIDEO_SKIPPED);
    }

    public void start(float f, float f2) {
        m13898a(f);
        m13899b(f2);
        C4170e.m14005c(this.f11156a);
        JSONObject jSONObject = new JSONObject();
        C4166b.m13985a(jSONObject, "duration", Float.valueOf(f));
        C4166b.m13985a(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
        C4166b.m13985a(jSONObject, "deviceVolume", Float.valueOf(C4158f.m13949a().mo28543d()));
        this.f11156a.getAdSessionStatePublisher().mo28561a(TJAdUnitConstants.String.VIDEO_START, jSONObject);
    }

    public void thirdQuartile() {
        C4170e.m14005c(this.f11156a);
        this.f11156a.getAdSessionStatePublisher().mo28559a(TJAdUnitConstants.String.VIDEO_THIRD_QUARTILE);
    }

    public void volumeChange(float f) {
        m13899b(f);
        C4170e.m14005c(this.f11156a);
        JSONObject jSONObject = new JSONObject();
        C4166b.m13985a(jSONObject, "mediaPlayerVolume", Float.valueOf(f));
        C4166b.m13985a(jSONObject, "deviceVolume", Float.valueOf(C4158f.m13949a().mo28543d()));
        this.f11156a.getAdSessionStatePublisher().mo28561a("volumeChange", jSONObject);
    }
}
