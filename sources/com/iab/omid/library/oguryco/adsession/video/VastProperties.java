package com.iab.omid.library.oguryco.adsession.video;

import com.iab.omid.library.oguryco.adsession.media.Position;
import com.iab.omid.library.oguryco.p152d.C4221e;

public final class VastProperties {

    /* renamed from: a */
    private final boolean f11281a;

    /* renamed from: b */
    private final Float f11282b;

    /* renamed from: c */
    private final boolean f11283c;

    /* renamed from: d */
    private final Position f11284d;

    /* renamed from: e */
    private com.iab.omid.library.oguryco.adsession.media.VastProperties f11285e;

    private VastProperties(boolean z, Float f, boolean z2, Position position, com.iab.omid.library.oguryco.adsession.media.VastProperties vastProperties) {
        this.f11281a = z;
        this.f11282b = f;
        this.f11283c = z2;
        this.f11284d = position;
        this.f11285e = vastProperties;
    }

    public static VastProperties createVastPropertiesForNonSkippableVideo(boolean z, Position position) {
        C4221e.m14230a((Object) position, "Position is null");
        return new VastProperties(false, (Float) null, z, position, com.iab.omid.library.oguryco.adsession.media.VastProperties.createVastPropertiesForNonSkippableMedia(z, Position.valueOf(position.toString().toUpperCase())));
    }

    public static VastProperties createVastPropertiesForSkippableVideo(float f, boolean z, Position position) {
        C4221e.m14230a((Object) position, "Position is null");
        return new VastProperties(true, Float.valueOf(f), z, position, com.iab.omid.library.oguryco.adsession.media.VastProperties.createVastPropertiesForSkippableMedia(f, z, Position.valueOf(position.toString().toUpperCase())));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final com.iab.omid.library.oguryco.adsession.media.VastProperties mo28694a() {
        return this.f11285e;
    }

    public final Position getPosition() {
        return this.f11284d;
    }

    public final Float getSkipOffset() {
        return this.f11282b;
    }

    public final boolean isAutoPlay() {
        return this.f11283c;
    }

    public final boolean isSkippable() {
        return this.f11281a;
    }
}
