package com.applovin.impl.adview;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.utils.C1993i;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.adview.s */
public class C1628s {

    /* renamed from: a */
    private final int f5066a;

    /* renamed from: b */
    private final int f5067b;

    /* renamed from: c */
    private final int f5068c;

    /* renamed from: d */
    private final int f5069d;

    /* renamed from: e */
    private final boolean f5070e;

    /* renamed from: f */
    private final int f5071f;

    /* renamed from: g */
    private final int f5072g;

    /* renamed from: h */
    private final int f5073h;

    /* renamed from: i */
    private final float f5074i;

    /* renamed from: j */
    private final float f5075j;

    public C1628s(JSONObject jSONObject, C1941j jVar) {
        C1977q v = jVar.mo8602v();
        v.mo8744c("VideoButtonProperties", "Updating video button properties with JSON = " + C1993i.m7906e(jSONObject));
        this.f5066a = C1993i.m7894b(jSONObject, "width", 64, jVar);
        this.f5067b = C1993i.m7894b(jSONObject, "height", 7, jVar);
        this.f5068c = C1993i.m7894b(jSONObject, "margin", 20, jVar);
        this.f5069d = C1993i.m7894b(jSONObject, "gravity", 85, jVar);
        this.f5070e = C1993i.m7871a(jSONObject, "tap_to_fade", (Boolean) false, jVar).booleanValue();
        this.f5071f = C1993i.m7894b(jSONObject, "tap_to_fade_duration_milliseconds", 500, jVar);
        this.f5072g = C1993i.m7894b(jSONObject, "fade_in_duration_milliseconds", 500, jVar);
        this.f5073h = C1993i.m7894b(jSONObject, "fade_out_duration_milliseconds", 500, jVar);
        this.f5074i = C1993i.m7868a(jSONObject, "fade_in_delay_seconds", 1.0f, jVar);
        this.f5075j = C1993i.m7868a(jSONObject, "fade_out_delay_seconds", 6.0f, jVar);
    }

    /* renamed from: a */
    public int mo7538a() {
        return this.f5066a;
    }

    /* renamed from: b */
    public int mo7539b() {
        return this.f5067b;
    }

    /* renamed from: c */
    public int mo7540c() {
        return this.f5068c;
    }

    /* renamed from: d */
    public int mo7541d() {
        return this.f5069d;
    }

    /* renamed from: e */
    public boolean mo7542e() {
        return this.f5070e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1628s.class != obj.getClass()) {
            return false;
        }
        C1628s sVar = (C1628s) obj;
        return this.f5066a == sVar.f5066a && this.f5067b == sVar.f5067b && this.f5068c == sVar.f5068c && this.f5069d == sVar.f5069d && this.f5070e == sVar.f5070e && this.f5071f == sVar.f5071f && this.f5072g == sVar.f5072g && this.f5073h == sVar.f5073h && Float.compare(sVar.f5074i, this.f5074i) == 0 && Float.compare(sVar.f5075j, this.f5075j) == 0;
    }

    /* renamed from: f */
    public long mo7544f() {
        return (long) this.f5071f;
    }

    /* renamed from: g */
    public long mo7545g() {
        return (long) this.f5072g;
    }

    /* renamed from: h */
    public long mo7546h() {
        return (long) this.f5073h;
    }

    public int hashCode() {
        int i = ((((((((((((((this.f5066a * 31) + this.f5067b) * 31) + this.f5068c) * 31) + this.f5069d) * 31) + (this.f5070e ? 1 : 0)) * 31) + this.f5071f) * 31) + this.f5072g) * 31) + this.f5073h) * 31;
        float f = this.f5074i;
        int i2 = 0;
        int floatToIntBits = (i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.f5075j;
        if (f2 != 0.0f) {
            i2 = Float.floatToIntBits(f2);
        }
        return floatToIntBits + i2;
    }

    /* renamed from: i */
    public float mo7548i() {
        return this.f5074i;
    }

    /* renamed from: j */
    public float mo7549j() {
        return this.f5075j;
    }

    public String toString() {
        return "VideoButtonProperties{widthPercentOfScreen=" + this.f5066a + ", heightPercentOfScreen=" + this.f5067b + ", margin=" + this.f5068c + ", gravity=" + this.f5069d + ", tapToFade=" + this.f5070e + ", tapToFadeDurationMillis=" + this.f5071f + ", fadeInDurationMillis=" + this.f5072g + ", fadeOutDurationMillis=" + this.f5073h + ", fadeInDelay=" + this.f5074i + ", fadeOutDelay=" + this.f5075j + '}';
    }
}
