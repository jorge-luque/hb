package com.applovin.impl.sdk.p052d;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.network.C1971g;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C1992h;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.j */
public class C1890j extends C1864a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1971g f6254a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AppLovinPostbackListener f6255c;

    /* renamed from: d */
    private final C1907s.C1909a f6256d;

    public C1890j(C1971g gVar, C1907s.C1909a aVar, C1941j jVar, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", jVar);
        if (gVar != null) {
            this.f6254a = gVar;
            this.f6255c = appLovinPostbackListener;
            this.f6256d = aVar;
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    public void run() {
        final String a = this.f6254a.mo8641a();
        if (!C2025o.m7963b(a)) {
            mo8407b("Requested URL is not valid; nothing to do...");
            AppLovinPostbackListener appLovinPostbackListener = this.f6255c;
            if (appLovinPostbackListener != null) {
                appLovinPostbackListener.onPostbackFailure(a, AppLovinErrorCodes.INVALID_URL);
                return;
            }
            return;
        }
        C18911 r1 = new C1921y<Object>(this.f6254a, mo8409d()) {
            /* renamed from: a */
            public void mo7627a(int i) {
                mo8410d("Failed to dispatch postback. Error code: " + i + " URL: " + a);
                if (C1890j.this.f6255c != null) {
                    C1890j.this.f6255c.onPostbackFailure(a, i);
                }
                if (C1890j.this.f6254a.mo8706o()) {
                    this.f6217b.mo8567ac().mo8507a(C1890j.this.f6254a.mo8707p(), C1890j.this.f6254a.mo8641a(), i, (Object) null);
                }
            }

            /* renamed from: a */
            public void mo7628a(Object obj, int i) {
                if (((Boolean) this.f6217b.mo8549a(C1841c.f6028eS)).booleanValue()) {
                    if (obj instanceof JSONObject) {
                        JSONObject jSONObject = (JSONObject) obj;
                        Iterator<String> it = this.f6217b.mo8576b(C1841c.f5806aF).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (C1890j.this.f6254a.mo8641a().startsWith(it.next())) {
                                C1992h.m7858d(jSONObject, this.f6217b);
                                C1992h.m7857c(jSONObject, this.f6217b);
                                break;
                            }
                        }
                    }
                } else if (obj instanceof String) {
                    for (String startsWith : this.f6217b.mo8576b(C1841c.f5806aF)) {
                        if (C1890j.this.f6254a.mo8641a().startsWith(startsWith)) {
                            String str = (String) obj;
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(str);
                                    C1992h.m7858d(jSONObject2, this.f6217b);
                                    C1992h.m7857c(jSONObject2, this.f6217b);
                                    break;
                                } catch (JSONException unused) {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                if (C1890j.this.f6255c != null) {
                    C1890j.this.f6255c.onPostbackSuccess(a);
                }
                if (C1890j.this.f6254a.mo8706o()) {
                    this.f6217b.mo8567ac().mo8507a(C1890j.this.f6254a.mo8707p(), C1890j.this.f6254a.mo8641a(), i, obj);
                }
            }
        };
        r1.mo8497a(this.f6256d);
        mo8409d().mo8533L().mo8474a((C1864a) r1);
    }
}
