package com.applovin.impl.mediation.p046c;

import android.app.Activity;
import com.applovin.impl.mediation.p045b.C1701e;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.p051c.C1859g;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.sdk.AppLovinMediationProvider;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.a */
public class C1708a extends C1864a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Activity f5318a;

    public C1708a(Activity activity, C1941j jVar) {
        super("TaskAutoInitAdapters", jVar, true);
        this.f5318a = activity;
    }

    /* renamed from: a */
    private List<C1701e> m6536a(JSONArray jSONArray, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new C1701e(C1993i.m7883a(jSONArray, i, (JSONObject) null, this.f6217b), jSONObject, this.f6217b));
        }
        return arrayList;
    }

    public void run() {
        String str;
        String str2 = (String) this.f6217b.mo8550a(C1843e.f6110x);
        if (C2025o.m7963b(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                List<C1701e> a = m6536a(C1993i.m7900b(jSONObject, this.f6217b.mo8573ai() ? "test_mode_auto_init_adapters" : "auto_init_adapters", new JSONArray(), this.f6217b), jSONObject);
                if (a.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Auto-initing ");
                    sb.append(a.size());
                    sb.append(" adapters");
                    sb.append(this.f6217b.mo8573ai() ? " in test mode" : "");
                    sb.append("...");
                    mo8405a(sb.toString());
                    this.f6217b.mo8581c(AppLovinMediationProvider.MAX);
                    if (this.f5318a == null) {
                        C1977q.m7751i("AppLovinSdk", "\n**********\nFailed to initialize 3rd-party SDKs. Please make sure to initialize the AppLovin SDK with an Activity context.\n**********\n");
                        this.f6217b.mo8534M().mo8392b(C1859g.f6201p, 1);
                        return;
                    }
                    for (final C1701e next : a) {
                        this.f6217b.mo8533L().mo8479b().execute(new Runnable() {
                            public void run() {
                                C1708a aVar = C1708a.this;
                                aVar.mo8405a("Auto-initing adapter: " + next);
                                C1708a.this.f6217b.mo8604x().mo7888a(next, C1708a.this.f5318a);
                            }
                        });
                    }
                }
            } catch (JSONException e) {
                th = e;
                str = "Failed to parse auto-init adapters JSON";
                mo8406a(str, th);
            } catch (Throwable th) {
                th = th;
                str = "Failed to auto-init adapters";
                mo8406a(str, th);
            }
        }
    }
}
