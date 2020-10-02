package com.applovin.impl.mediation.p037a.p039b;

import android.os.Build;
import com.applovin.impl.mediation.p047d.C1728b;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1945k;
import com.applovin.impl.sdk.network.C1956a;
import com.applovin.impl.sdk.network.C1960b;
import com.applovin.impl.sdk.p050b.C1840b;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1921y;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.b.a */
public class C1656a extends C1864a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1956a.C1959c<JSONObject> f5186a;

    public C1656a(C1956a.C1959c<JSONObject> cVar, C1941j jVar) {
        super("TaskFetchMediationDebuggerInfo", jVar, true);
        this.f5186a = cVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Map<String, String> mo7675a() {
        HashMap hashMap = new HashMap();
        hashMap.put("sdk_version", AppLovinSdk.VERSION);
        hashMap.put("build", String.valueOf(131));
        if (!((Boolean) this.f6217b.mo8549a(C1841c.f6020eK)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f6217b.mo8599t());
        }
        C1945k.C1948b c = this.f6217b.mo8536O().mo8614c();
        hashMap.put("package_name", C2025o.m7966e(c.f6471c));
        hashMap.put(TapjoyConstants.TJC_APP_VERSION_NAME, C2025o.m7966e(c.f6470b));
        hashMap.put(TapjoyConstants.TJC_PLATFORM, "android");
        hashMap.put("os", C2025o.m7966e(Build.VERSION.RELEASE));
        return hashMap;
    }

    public void run() {
        C16571 r1 = new C1921y<JSONObject>(C1960b.m7596a(this.f6217b).mo8663a(C1728b.m6618c(this.f6217b)).mo8673c(C1728b.m6619d(this.f6217b)).mo8664a(mo7675a()).mo8669b("GET").mo8662a(new JSONObject()).mo8668b(((Long) this.f6217b.mo8549a(C1840b.f5769g)).intValue()).mo8667a(), this.f6217b, mo8413g()) {
            /* renamed from: a */
            public void mo7627a(int i) {
                C1656a.this.f5186a.mo7627a(i);
            }

            /* renamed from: a */
            public void mo7628a(JSONObject jSONObject, int i) {
                C1656a.this.f5186a.mo7628a(jSONObject, i);
            }
        };
        r1.mo8496a(C1840b.f5765c);
        r1.mo8498b(C1840b.f5766d);
        this.f6217b.mo8533L().mo8474a((C1864a) r1);
    }
}
