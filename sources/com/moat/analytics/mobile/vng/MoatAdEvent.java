package com.moat.analytics.mobile.vng;

import java.util.HashMap;
import java.util.Map;

public class MoatAdEvent {
    public static final Double VOLUME_MUTED = Double.valueOf(0.0d);
    public static final Double VOLUME_UNMUTED = Double.valueOf(1.0d);

    /* renamed from: a */
    static final Integer f11700a = Integer.MIN_VALUE;

    /* renamed from: e */
    private static final Double f11701e = Double.valueOf(Double.NaN);

    /* renamed from: b */
    Integer f11702b;

    /* renamed from: c */
    Double f11703c;

    /* renamed from: d */
    MoatAdEventType f11704d;

    /* renamed from: f */
    private final Double f11705f;

    /* renamed from: g */
    private final Long f11706g;

    public MoatAdEvent(MoatAdEventType moatAdEventType) {
        this(moatAdEventType, f11700a, f11701e);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer num) {
        this(moatAdEventType, num, f11701e);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer num, Double d) {
        this.f11706g = Long.valueOf(System.currentTimeMillis());
        this.f11704d = moatAdEventType;
        this.f11703c = d;
        this.f11702b = num;
        this.f11705f = Double.valueOf(C4401l.m14743a().mo29329b());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<String, Object> mo29194a() {
        HashMap hashMap = new HashMap();
        hashMap.put("adVolume", this.f11703c);
        hashMap.put("playhead", this.f11702b);
        hashMap.put("aTimeStamp", this.f11706g);
        hashMap.put("type", this.f11704d.toString());
        hashMap.put("deviceVolume", this.f11705f);
        return hashMap;
    }
}
