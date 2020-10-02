package com.applovin.impl.mediation.p047d;

import android.text.TextUtils;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p050b.C1840b;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.d.c */
public class C1729c {

    /* renamed from: a */
    private static final List<String> f5370a;

    /* renamed from: b */
    private static C1731a f5371b;

    /* renamed from: com.applovin.impl.mediation.d.c$a */
    public static class C1731a {

        /* renamed from: a */
        private final JSONArray f5372a;

        /* renamed from: b */
        private final JSONArray f5373b;

        private C1731a(JSONArray jSONArray, JSONArray jSONArray2) {
            this.f5372a = jSONArray;
            this.f5373b = jSONArray2;
        }

        /* renamed from: a */
        public JSONArray mo7874a() {
            return this.f5372a;
        }

        /* renamed from: b */
        public JSONArray mo7875b() {
            return this.f5373b;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f5370a = arrayList;
        arrayList.add("com.applovin.mediation.adapters.AdColonyMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.AmazonMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.AmazonBiddingMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.AppLovinMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.ByteDanceMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.ChartboostMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.FacebookMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.GoogleMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.HyperMXMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.IMobileMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.InMobiMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.InneractiveMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.IronSourceMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.LeadboltMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.MadvertiseMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.MaioMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.MintegralMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.MoPubMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.MyTargetMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.NendMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.OguryMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.OguryPresageMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.SmaatoMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.TapjoyMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.TencentMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.UnityAdsMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.VerizonAdsMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.VungleMediationAdapter");
        f5370a.add("com.applovin.mediation.adapters.YandexMediationAdapter");
    }

    /* renamed from: a */
    public static C1731a m6620a(C1941j jVar) {
        C1731a aVar;
        if (!((Boolean) jVar.mo8549a(C1840b.f5759L)).booleanValue() && (aVar = f5371b) != null) {
            return aVar;
        }
        if (f5371b != null) {
            m6625b(jVar);
            return f5371b;
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (String next : f5370a) {
            MaxAdapter a = m6622a(next, jVar);
            if (a != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("class", next);
                    jSONObject.put("sdk_version", a.getSdkVersion());
                    jSONObject.put("version", a.getAdapterVersion());
                } catch (Throwable unused) {
                }
                jSONArray.put(jSONObject);
            } else {
                jSONArray2.put(next);
            }
        }
        C1731a aVar2 = new C1731a(jSONArray, jSONArray2);
        f5371b = aVar2;
        return aVar2;
    }

    /* renamed from: a */
    public static C1907s.C1909a m6621a(MaxAdFormat maxAdFormat) {
        return maxAdFormat == MaxAdFormat.INTERSTITIAL ? C1907s.C1909a.MEDIATION_INTERSTITIAL : maxAdFormat == MaxAdFormat.REWARDED ? C1907s.C1909a.MEDIATION_INCENTIVIZED : C1907s.C1909a.MEDIATION_BANNER;
    }

    /* renamed from: a */
    public static MaxAdapter m6622a(String str, C1941j jVar) {
        Class<MaxAdapter> cls = MaxAdapter.class;
        if (TextUtils.isEmpty(str)) {
            jVar.mo8602v().mo8746e("AppLovinSdk", "Failed to create adapter instance. No class name provided");
            return null;
        }
        try {
            Class<?> cls2 = Class.forName(str);
            if (cls.isAssignableFrom(cls2)) {
                return (MaxAdapter) cls2.getConstructor(new Class[]{AppLovinSdk.class}).newInstance(new Object[]{jVar.mo8540S()});
            }
            C1977q v = jVar.mo8602v();
            v.mo8746e("AppLovinSdk", str + " error: not an instance of '" + cls.getName() + "'.");
            return null;
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            C1977q v2 = jVar.mo8602v();
            v2.mo8743b("AppLovinSdk", "Failed to load: " + str, th);
        }
    }

    /* renamed from: a */
    public static boolean m6623a(Object obj) {
        return (obj instanceof C1827g) && C2025o.m7963b(((C1827g) obj).mo8216P());
    }

    /* renamed from: b */
    public static String m6624b(MaxAdFormat maxAdFormat) {
        return maxAdFormat.getLabel();
    }

    /* renamed from: b */
    private static void m6625b(C1941j jVar) {
        MaxAdapter a;
        JSONArray a2 = f5371b.mo7874a();
        for (int i = 0; i < a2.length(); i++) {
            JSONObject a3 = C1993i.m7883a(a2, i, (JSONObject) null, jVar);
            String b = C1993i.m7896b(a3, "class", "", jVar);
            if (!C2025o.m7963b(C1993i.m7896b(a3, "sdk_version", "", jVar)) && (a = m6622a(b, jVar)) != null) {
                C1993i.m7886a(a3, "sdk_version", a.getSdkVersion(), jVar);
            }
        }
    }
}
