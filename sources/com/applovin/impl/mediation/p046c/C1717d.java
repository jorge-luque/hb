package com.applovin.impl.mediation.p046c;

import android.net.Uri;
import com.applovin.impl.mediation.C1732e;
import com.applovin.impl.mediation.p045b.C1697a;
import com.applovin.impl.mediation.p045b.C1701e;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.network.C1968f;
import com.applovin.impl.sdk.network.C1971g;
import com.applovin.impl.sdk.p050b.C1840b;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.d */
public class C1717d extends C1864a {

    /* renamed from: a */
    private final String f5341a;

    /* renamed from: c */
    private final String f5342c;

    /* renamed from: d */
    private final C1701e f5343d;

    /* renamed from: e */
    private final Map<String, String> f5344e;

    /* renamed from: f */
    private final Map<String, String> f5345f;

    /* renamed from: g */
    private final C1732e f5346g;

    public C1717d(String str, Map<String, String> map, C1732e eVar, C1701e eVar2, C1941j jVar) {
        super("TaskFireMediationPostbacks", jVar);
        this.f5341a = str;
        this.f5342c = str + "_urls";
        this.f5344e = C2029r.m8026b(map);
        this.f5346g = eVar != null ? eVar : C1732e.EMPTY;
        this.f5343d = eVar2;
        HashMap hashMap = new HashMap(6);
        hashMap.put("AppLovin-Event-Type", str);
        hashMap.put("AppLovin-Ad-Network-Name", eVar2.mo7813E());
        if (eVar2 instanceof C1697a) {
            C1697a aVar = (C1697a) eVar2;
            hashMap.put("AppLovin-Ad-Unit-Id", aVar.getAdUnitId());
            hashMap.put("AppLovin-Ad-Format", aVar.getFormat().getLabel());
        }
        if (eVar != null) {
            hashMap.put("AppLovin-Error-Code", String.valueOf(eVar.getErrorCode()));
            hashMap.put("AppLovin-Error-Message", eVar.getErrorMessage());
        }
        this.f5345f = hashMap;
    }

    /* renamed from: a */
    private String m6571a(String str, C1732e eVar) {
        int i;
        String str2;
        if (eVar instanceof MaxAdapterError) {
            MaxAdapterError maxAdapterError = (MaxAdapterError) eVar;
            i = maxAdapterError.getThirdPartySdkErrorCode();
            str2 = maxAdapterError.getThirdPartySdkErrorMessage();
        } else {
            i = 0;
            str2 = "";
        }
        return str.replace("{ERROR_CODE}", String.valueOf(eVar.getErrorCode())).replace("{ERROR_MESSAGE}", C2025o.m7966e(eVar.getErrorMessage())).replace("{THIRD_PARTY_SDK_ERROR_CODE}", String.valueOf(i)).replace("{THIRD_PARTY_SDK_ERROR_MESSAGE}", C2025o.m7966e(str2));
    }

    /* renamed from: a */
    private List<String> m6572a(List<String> list, Map<String, String> map, Map<String, String> map2, C1732e eVar) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            for (String next2 : map.keySet()) {
                next = next.replace(next2, this.f5343d.mo7841e(map.get(next2)));
            }
            arrayList.add(m6571a(m6577b(next, map2), eVar));
        }
        return arrayList;
    }

    /* renamed from: a */
    private Map<String, String> m6573a() {
        try {
            return C1993i.m7879a(new JSONObject((String) this.f6217b.mo8549a(C1840b.f5770h)));
        } catch (JSONException unused) {
            return Collections.EMPTY_MAP;
        }
    }

    /* renamed from: a */
    private void m6575a(String str, Map<String, Object> map) {
        mo8409d().mo8535N().mo8678a(C1968f.m7656m().mo8703c(str).mo8701b("POST").mo8702b(this.f5345f).mo8699a(false).mo8704c(map).mo8700a());
    }

    /* renamed from: a */
    private void m6576a(List<String> list) {
        if (!list.isEmpty()) {
            for (String c : list) {
                mo8409d().mo8535N().mo8678a(C1968f.m7656m().mo8703c(c).mo8699a(false).mo8702b(this.f5345f).mo8700a());
            }
        }
    }

    /* renamed from: b */
    private String m6577b(String str, Map<String, String> map) {
        for (String next : map.keySet()) {
            str = str.replace(next, map.get(next));
        }
        return str;
    }

    /* renamed from: b */
    private void m6578b(List<String> list) {
        if (!list.isEmpty()) {
            for (String d : list) {
                mo8409d().mo8539R().dispatchPostbackRequest(C1971g.m7686b(mo8409d()).mo8663a(d).mo8666a(false).mo8670b(this.f5345f).mo8667a(), C1907s.C1909a.MEDIATION_POSTBACKS, new AppLovinPostbackListener() {
                    public void onPostbackFailure(String str, int i) {
                        C1717d dVar = C1717d.this;
                        dVar.mo8410d("Failed to fire postback with code: " + i + " and url: " + str);
                    }

                    public void onPostbackSuccess(String str) {
                    }
                });
            }
        }
    }

    public void run() {
        List<String> d = this.f5343d.mo7840d(this.f5342c);
        Map<String, String> a = m6573a();
        if (((Boolean) mo8409d().mo8549a(C1840b.f5762O)).booleanValue()) {
            for (String b : d) {
                Uri parse = Uri.parse(m6571a(m6577b(b, this.f5344e), this.f5346g));
                Uri.Builder clearQuery = parse.buildUpon().clearQuery();
                HashMap hashMap = new HashMap(a.size());
                for (String next : parse.getQueryParameterNames()) {
                    String queryParameter = parse.getQueryParameter(next);
                    if (a.containsKey(queryParameter)) {
                        hashMap.put(next, this.f5343d.mo7841e(a.get(queryParameter)));
                    } else {
                        clearQuery.appendQueryParameter(next, queryParameter);
                    }
                }
                m6575a(clearQuery.build().toString(), (Map<String, Object>) hashMap);
            }
            return;
        }
        List<String> a2 = m6572a(d, a, this.f5344e, this.f5346g);
        if (((Boolean) mo8409d().mo8549a(C1840b.f5771i)).booleanValue()) {
            m6576a(a2);
        } else {
            m6578b(a2);
        }
    }
}
