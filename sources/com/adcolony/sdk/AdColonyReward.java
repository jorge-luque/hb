package com.adcolony.sdk;

import com.facebook.GraphResponse;
import org.json.JSONObject;

public class AdColonyReward {

    /* renamed from: a */
    private int f3313a;

    /* renamed from: b */
    private String f3314b;

    /* renamed from: c */
    private String f3315c;

    /* renamed from: d */
    private boolean f3316d;

    AdColonyReward(C1454x xVar) {
        JSONObject b = xVar.mo6830b();
        this.f3313a = C1437s.m5611f(b, "reward_amount");
        this.f3314b = C1437s.m5613h(b, "reward_name");
        this.f3316d = C1437s.m5608d(b, GraphResponse.SUCCESS_KEY);
        this.f3315c = C1437s.m5613h(b, "zone_id");
    }

    public int getRewardAmount() {
        return this.f3313a;
    }

    public String getRewardName() {
        return this.f3314b;
    }

    public String getZoneID() {
        return this.f3315c;
    }

    public boolean success() {
        return this.f3316d;
    }
}
