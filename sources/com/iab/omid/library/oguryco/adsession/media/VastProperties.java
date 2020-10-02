package com.iab.omid.library.oguryco.adsession.media;

import com.iab.omid.library.oguryco.p152d.C4219c;
import com.iab.omid.library.oguryco.p152d.C4221e;
import org.json.JSONException;
import org.json.JSONObject;

public final class VastProperties {

    /* renamed from: a */
    private final boolean f11277a;

    /* renamed from: b */
    private final Float f11278b;

    /* renamed from: c */
    private final boolean f11279c;

    /* renamed from: d */
    private final Position f11280d;

    private VastProperties(boolean z, Float f, boolean z2, Position position) {
        this.f11277a = z;
        this.f11278b = f;
        this.f11279c = z2;
        this.f11280d = position;
    }

    public static VastProperties createVastPropertiesForNonSkippableMedia(boolean z, Position position) {
        C4221e.m14230a((Object) position, "Position is null");
        return new VastProperties(false, (Float) null, z, position);
    }

    public static VastProperties createVastPropertiesForSkippableMedia(float f, boolean z, Position position) {
        C4221e.m14230a((Object) position, "Position is null");
        return new VastProperties(true, Float.valueOf(f), z, position);
    }

    /* renamed from: a */
    public final JSONObject mo28686a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f11277a);
            if (this.f11277a) {
                jSONObject.put("skipOffset", this.f11278b);
            }
            jSONObject.put("autoPlay", this.f11279c);
            jSONObject.put("position", this.f11280d);
        } catch (JSONException e) {
            C4219c.m14225a("VastProperties: JSON error", e);
        }
        return jSONObject;
    }

    public final Position getPosition() {
        return this.f11280d;
    }

    public final Float getSkipOffset() {
        return this.f11278b;
    }

    public final boolean isAutoPlay() {
        return this.f11279c;
    }

    public final boolean isSkippable() {
        return this.f11277a;
    }
}
