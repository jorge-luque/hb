package com.moat.analytics.mobile.ogury;

import java.util.HashMap;
import java.util.Map;

public class MoatAdEvent {
    public static final Double VOLUME_MUTED = Double.valueOf(0.0d);
    public static final Double VOLUME_UNMUTED = Double.valueOf(1.0d);

    /* renamed from: ˋ */
    private static final Double f11470 = Double.valueOf(Double.NaN);

    /* renamed from: ˏ */
    static final Integer f11471 = Integer.MIN_VALUE;

    /* renamed from: ʻ */
    private final Double f11472;

    /* renamed from: ˊ */
    Double f11473;

    /* renamed from: ˎ */
    MoatAdEventType f11474;

    /* renamed from: ॱ */
    Integer f11475;

    /* renamed from: ᐝ */
    private final Long f11476;

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer num, Double d) {
        this.f11476 = Long.valueOf(System.currentTimeMillis());
        this.f11474 = moatAdEventType;
        this.f11473 = d;
        this.f11475 = num;
        this.f11472 = Double.valueOf(C4356s.m14572());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ */
    public final Map<String, Object> mo29041() {
        HashMap hashMap = new HashMap();
        hashMap.put("adVolume", this.f11473);
        hashMap.put("playhead", this.f11475);
        hashMap.put("aTimeStamp", this.f11476);
        hashMap.put("type", this.f11474.toString());
        hashMap.put("deviceVolume", this.f11472);
        return hashMap;
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer num) {
        this(moatAdEventType, num, f11470);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType) {
        this(moatAdEventType, f11471, f11470);
    }
}
