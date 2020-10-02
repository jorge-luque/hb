package com.iab.omid.library.adcolony.adsession.media;

import com.iab.omid.library.adcolony.p146d.C4168c;
import com.iab.omid.library.adcolony.p146d.C4170e;
import org.json.JSONException;
import org.json.JSONObject;

public final class VastProperties {

    /* renamed from: a */
    private final boolean f11161a;

    /* renamed from: b */
    private final Float f11162b;

    /* renamed from: c */
    private final boolean f11163c;

    /* renamed from: d */
    private final Position f11164d;

    private VastProperties(boolean z, Float f, boolean z2, Position position) {
        this.f11161a = z;
        this.f11162b = f;
        this.f11163c = z2;
        this.f11164d = position;
    }

    public static VastProperties createVastPropertiesForNonSkippableMedia(boolean z, Position position) {
        C4170e.m14001a((Object) position, "Position is null");
        return new VastProperties(false, (Float) null, z, position);
    }

    public static VastProperties createVastPropertiesForSkippableMedia(float f, boolean z, Position position) {
        C4170e.m14001a((Object) position, "Position is null");
        return new VastProperties(true, Float.valueOf(f), z, position);
    }

    /* renamed from: a */
    public JSONObject mo28495a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f11161a);
            if (this.f11161a) {
                jSONObject.put("skipOffset", this.f11162b);
            }
            jSONObject.put("autoPlay", this.f11163c);
            jSONObject.put("position", this.f11164d);
        } catch (JSONException e) {
            C4168c.m13996a("VastProperties: JSON error", e);
        }
        return jSONObject;
    }

    public Position getPosition() {
        return this.f11164d;
    }

    public Float getSkipOffset() {
        return this.f11162b;
    }

    public boolean isAutoPlay() {
        return this.f11163c;
    }

    public boolean isSkippable() {
        return this.f11161a;
    }
}
