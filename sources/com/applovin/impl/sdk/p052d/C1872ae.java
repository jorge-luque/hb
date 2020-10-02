package com.applovin.impl.sdk.p052d;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p048a.C1814c;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.ae */
public class C1872ae extends C1873af {

    /* renamed from: a */
    private final C1827g f6228a;

    /* renamed from: c */
    private final AppLovinAdRewardListener f6229c;

    public C1872ae(C1827g gVar, AppLovinAdRewardListener appLovinAdRewardListener, C1941j jVar) {
        super("TaskValidateAppLovinReward", jVar);
        this.f6228a = gVar;
        this.f6229c = appLovinAdRewardListener;
    }

    /* renamed from: a */
    public String mo7866a() {
        return "2.0/vr";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7867a(int i) {
        String str;
        super.mo7867a(i);
        if (i < 400 || i >= 500) {
            this.f6229c.validationRequestFailed(this.f6228a, i);
            str = "network_timeout";
        } else {
            this.f6229c.userRewardRejected(this.f6228a, Collections.emptyMap());
            str = "rejected";
        }
        this.f6228a.mo8229a(C1814c.m6808a(str));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7872a(C1814c cVar) {
        this.f6228a.mo8229a(cVar);
        String b = cVar.mo8102b();
        Map<String, String> a = cVar.mo8101a();
        if (b.equals("accepted")) {
            this.f6229c.userRewardVerified(this.f6228a, a);
        } else if (b.equals("quota_exceeded")) {
            this.f6229c.userOverQuota(this.f6228a, a);
        } else if (b.equals("rejected")) {
            this.f6229c.userRewardRejected(this.f6228a, a);
        } else {
            this.f6229c.validationRequestFailed(this.f6228a, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7868a(JSONObject jSONObject) {
        C1993i.m7886a(jSONObject, "zone_id", this.f6228a.getAdZone().mo8174a(), this.f6217b);
        String clCode = this.f6228a.getClCode();
        if (!C2025o.m7963b(clCode)) {
            clCode = "NO_CLCODE";
        }
        C1993i.m7886a(jSONObject, "clcode", clCode, this.f6217b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo7873b() {
        return this.f6228a.mo8243aM();
    }
}
