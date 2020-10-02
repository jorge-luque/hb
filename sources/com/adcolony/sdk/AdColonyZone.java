package com.adcolony.sdk;

import admost.sdk.AdMostInterstitial;
import com.adcolony.sdk.C1439u;
import org.json.JSONObject;

public class AdColonyZone {
    public static final int BANNER = 1;
    public static final int INTERSTITIAL = 0;
    @Deprecated
    public static final int NATIVE = 2;

    /* renamed from: l */
    static final int f3321l = 0;

    /* renamed from: m */
    static final int f3322m = 1;

    /* renamed from: n */
    static final int f3323n = 5;

    /* renamed from: o */
    static final int f3324o = 6;

    /* renamed from: a */
    private String f3325a;

    /* renamed from: b */
    private String f3326b;

    /* renamed from: c */
    private int f3327c = 5;

    /* renamed from: d */
    private int f3328d;

    /* renamed from: e */
    private int f3329e;

    /* renamed from: f */
    private int f3330f;

    /* renamed from: g */
    private int f3331g;

    /* renamed from: h */
    private int f3332h;

    /* renamed from: i */
    private int f3333i;

    /* renamed from: j */
    private boolean f3334j;

    /* renamed from: k */
    private boolean f3335k;

    AdColonyZone(String str) {
        this.f3325a = str;
    }

    /* renamed from: a */
    private int m4862a(int i) {
        if (C1199a.m4882e() && !C1199a.m4880c().mo6516A() && !C1199a.m4880c().mo6517B()) {
            return i;
        }
        m4866c();
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo6374b() {
        return this.f3327c == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo6375c(int i) {
        this.f3327c = i;
    }

    public int getPlayFrequency() {
        return m4862a(this.f3331g);
    }

    public int getRemainingViewsUntilReward() {
        return m4862a(this.f3329e);
    }

    public int getRewardAmount() {
        return m4862a(this.f3332h);
    }

    public String getRewardName() {
        return m4863a(this.f3326b);
    }

    public int getViewsPerReward() {
        return m4862a(this.f3330f);
    }

    public String getZoneID() {
        return m4863a(this.f3325a);
    }

    public int getZoneType() {
        return this.f3328d;
    }

    public boolean isRewarded() {
        return this.f3335k;
    }

    public boolean isValid() {
        return m4865a(this.f3334j);
    }

    /* renamed from: c */
    private void m4866c() {
        new C1439u.C1440a().mo6801a("The AdColonyZone API is not available while AdColony is disabled.").mo6803a(C1439u.f4516i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6373b(int i) {
        this.f3333i = i;
    }

    /* renamed from: a */
    private boolean m4865a(boolean z) {
        if (C1199a.m4882e() && !C1199a.m4880c().mo6516A() && !C1199a.m4880c().mo6517B()) {
            return z;
        }
        m4866c();
        return false;
    }

    /* renamed from: a */
    private String m4863a(String str) {
        return m4864a(str, "");
    }

    /* renamed from: a */
    private String m4864a(String str, String str2) {
        if (C1199a.m4882e() && !C1199a.m4880c().mo6516A() && !C1199a.m4880c().mo6517B()) {
            return str;
        }
        m4866c();
        return str2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6372a(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        JSONObject g = C1437s.m5612g(b, "reward");
        this.f3326b = C1437s.m5613h(g, "reward_name");
        this.f3332h = C1437s.m5611f(g, "reward_amount");
        this.f3330f = C1437s.m5611f(g, "views_per_reward");
        this.f3329e = C1437s.m5611f(g, "views_until_reward");
        this.f3335k = C1437s.m5608d(b, AdMostInterstitial.ZONE_TYPE_REWARDED);
        this.f3327c = C1437s.m5611f(b, "status");
        this.f3328d = C1437s.m5611f(b, "type");
        this.f3331g = C1437s.m5611f(b, "play_interval");
        this.f3325a = C1437s.m5613h(b, "zone_id");
        boolean z = true;
        if (this.f3327c == 1) {
            z = false;
        }
        this.f3334j = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6371a() {
        return this.f3333i;
    }
}
