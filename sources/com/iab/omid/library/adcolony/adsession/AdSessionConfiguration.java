package com.iab.omid.library.adcolony.adsession;

import com.iab.omid.library.adcolony.p146d.C4166b;
import com.iab.omid.library.adcolony.p146d.C4170e;
import org.json.JSONObject;

public class AdSessionConfiguration {

    /* renamed from: a */
    private final Owner f11114a;

    /* renamed from: b */
    private final Owner f11115b;

    /* renamed from: c */
    private final boolean f11116c;

    /* renamed from: d */
    private final CreativeType f11117d;

    /* renamed from: e */
    private final ImpressionType f11118e;

    private AdSessionConfiguration(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z) {
        this.f11117d = creativeType;
        this.f11118e = impressionType;
        this.f11114a = owner;
        if (owner2 == null) {
            this.f11115b = Owner.NONE;
        } else {
            this.f11115b = owner2;
        }
        this.f11116c = z;
    }

    public static AdSessionConfiguration createAdSessionConfiguration(CreativeType creativeType, ImpressionType impressionType, Owner owner, Owner owner2, boolean z) {
        C4170e.m14001a((Object) creativeType, "CreativeType is null");
        C4170e.m14001a((Object) impressionType, "ImpressionType is null");
        C4170e.m14001a((Object) owner, "Impression owner is null");
        C4170e.m13999a(owner, creativeType, impressionType);
        return new AdSessionConfiguration(creativeType, impressionType, owner, owner2, z);
    }

    public boolean isNativeImpressionOwner() {
        return Owner.NATIVE == this.f11114a;
    }

    public boolean isNativeMediaEventsOwner() {
        return Owner.NATIVE == this.f11115b;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        C4166b.m13985a(jSONObject, "impressionOwner", this.f11114a);
        C4166b.m13985a(jSONObject, "mediaEventsOwner", this.f11115b);
        C4166b.m13985a(jSONObject, "creativeType", this.f11117d);
        C4166b.m13985a(jSONObject, "impressionType", this.f11118e);
        C4166b.m13985a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.f11116c));
        return jSONObject;
    }
}
