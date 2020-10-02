package com.applovin.impl.mediation.p037a.p038a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.mediation.p047d.C1729c;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.a.d */
public class C1651d implements AppLovinCommunicatorSubscriber, Comparable<C1651d> {

    /* renamed from: a */
    private final C1652a f5156a;

    /* renamed from: b */
    private int f5157b;

    /* renamed from: c */
    private final boolean f5158c;

    /* renamed from: d */
    private final boolean f5159d;

    /* renamed from: e */
    private final boolean f5160e;

    /* renamed from: f */
    private final boolean f5161f;

    /* renamed from: g */
    private final String f5162g;

    /* renamed from: h */
    private final String f5163h;

    /* renamed from: i */
    private final String f5164i;

    /* renamed from: j */
    private final String f5165j;

    /* renamed from: k */
    private final String f5166k;

    /* renamed from: l */
    private final String f5167l;

    /* renamed from: m */
    private final int f5168m;

    /* renamed from: n */
    private final List<MaxAdFormat> f5169n;

    /* renamed from: o */
    private final List<C1654f> f5170o;

    /* renamed from: p */
    private final List<C1647a> f5171p;

    /* renamed from: q */
    private final C1653e f5172q;

    /* renamed from: com.applovin.impl.mediation.a.a.d$a */
    public enum C1652a {
        MISSING("MISSING"),
        INCOMPLETE_INTEGRATION("INCOMPLETE INTEGRATION"),
        INVALID_INTEGRATION("INVALID INTEGRATION"),
        COMPLETE("COMPLETE");
        

        /* renamed from: e */
        private final String f5178e;

        private C1652a(String str) {
            this.f5178e = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public String m6319a() {
            return this.f5178e;
        }
    }

    public C1651d(JSONObject jSONObject, C1941j jVar) {
        String str;
        String str2;
        this.f5162g = C1993i.m7896b(jSONObject, "name", "", jVar);
        this.f5163h = C1993i.m7896b(jSONObject, "display_name", "", jVar);
        this.f5164i = C1993i.m7896b(jSONObject, "adapter_class", "", jVar);
        this.f5167l = C1993i.m7896b(jSONObject, "latest_adapter_version", "", jVar);
        JSONObject b = C1993i.m7901b(jSONObject, "configuration", new JSONObject(), jVar);
        this.f5170o = m6301a(b, jVar);
        this.f5171p = m6302b(b, jVar);
        this.f5172q = new C1653e(b, jVar);
        this.f5158c = C2029r.m8038e(C1993i.m7896b(jSONObject, "existence_class", "", jVar));
        List<MaxAdFormat> emptyList = Collections.emptyList();
        MaxAdapter a = C1729c.m6622a(this.f5164i, jVar);
        if (a != null) {
            this.f5159d = true;
            try {
                str2 = a.getAdapterVersion();
                try {
                    str = a.getSdkVersion();
                } catch (Throwable th) {
                    th = th;
                    str = "";
                    C1977q.m7751i("MediatedNetwork", "Failed to load adapter for network " + this.f5162g + ". Please check that you have a compatible network SDK integrated. Error: " + th);
                    this.f5166k = str2;
                    this.f5165j = str;
                    this.f5169n = emptyList;
                    this.f5161f = C2029r.m8038e(C1993i.m7896b(C1993i.m7901b(jSONObject, "alternative_network", (JSONObject) null, jVar), "adapter_class", "", jVar));
                    this.f5156a = m6303o();
                    this.f5160e = !str2.equals(this.f5167l);
                    Context E = jVar.mo8527E();
                    Resources resources = E.getResources();
                    this.f5168m = resources.getIdentifier("applovin_ic_mediation_" + this.f5162g.toLowerCase(), "drawable", E.getPackageName());
                    this.f5157b = MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.getCode();
                    AppLovinCommunicator.getInstance(jVar.mo8527E()).subscribe((AppLovinCommunicatorSubscriber) this, "adapter_initialization_status");
                }
                try {
                    emptyList = m6300a(a);
                } catch (Throwable th2) {
                    th = th2;
                    C1977q.m7751i("MediatedNetwork", "Failed to load adapter for network " + this.f5162g + ". Please check that you have a compatible network SDK integrated. Error: " + th);
                    this.f5166k = str2;
                    this.f5165j = str;
                    this.f5169n = emptyList;
                    this.f5161f = C2029r.m8038e(C1993i.m7896b(C1993i.m7901b(jSONObject, "alternative_network", (JSONObject) null, jVar), "adapter_class", "", jVar));
                    this.f5156a = m6303o();
                    this.f5160e = !str2.equals(this.f5167l);
                    Context E2 = jVar.mo8527E();
                    Resources resources2 = E2.getResources();
                    this.f5168m = resources2.getIdentifier("applovin_ic_mediation_" + this.f5162g.toLowerCase(), "drawable", E2.getPackageName());
                    this.f5157b = MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.getCode();
                    AppLovinCommunicator.getInstance(jVar.mo8527E()).subscribe((AppLovinCommunicatorSubscriber) this, "adapter_initialization_status");
                }
            } catch (Throwable th3) {
                th = th3;
                str2 = "";
                str = str2;
                C1977q.m7751i("MediatedNetwork", "Failed to load adapter for network " + this.f5162g + ". Please check that you have a compatible network SDK integrated. Error: " + th);
                this.f5166k = str2;
                this.f5165j = str;
                this.f5169n = emptyList;
                this.f5161f = C2029r.m8038e(C1993i.m7896b(C1993i.m7901b(jSONObject, "alternative_network", (JSONObject) null, jVar), "adapter_class", "", jVar));
                this.f5156a = m6303o();
                this.f5160e = !str2.equals(this.f5167l);
                Context E22 = jVar.mo8527E();
                Resources resources22 = E22.getResources();
                this.f5168m = resources22.getIdentifier("applovin_ic_mediation_" + this.f5162g.toLowerCase(), "drawable", E22.getPackageName());
                this.f5157b = MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.getCode();
                AppLovinCommunicator.getInstance(jVar.mo8527E()).subscribe((AppLovinCommunicatorSubscriber) this, "adapter_initialization_status");
            }
        } else {
            this.f5159d = false;
            str2 = "";
            str = str2;
        }
        this.f5166k = str2;
        this.f5165j = str;
        this.f5169n = emptyList;
        this.f5161f = C2029r.m8038e(C1993i.m7896b(C1993i.m7901b(jSONObject, "alternative_network", (JSONObject) null, jVar), "adapter_class", "", jVar));
        this.f5156a = m6303o();
        this.f5160e = !str2.equals(this.f5167l);
        Context E222 = jVar.mo8527E();
        Resources resources222 = E222.getResources();
        this.f5168m = resources222.getIdentifier("applovin_ic_mediation_" + this.f5162g.toLowerCase(), "drawable", E222.getPackageName());
        this.f5157b = MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.getCode();
        AppLovinCommunicator.getInstance(jVar.mo8527E()).subscribe((AppLovinCommunicatorSubscriber) this, "adapter_initialization_status");
    }

    /* renamed from: a */
    private List<MaxAdFormat> m6300a(MaxAdapter maxAdapter) {
        ArrayList arrayList = new ArrayList(5);
        if (maxAdapter instanceof MaxInterstitialAdapter) {
            arrayList.add(MaxAdFormat.INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxRewardedAdapter) {
            arrayList.add(MaxAdFormat.REWARDED);
        }
        if (maxAdapter instanceof MaxAdViewAdapter) {
            arrayList.add(MaxAdFormat.BANNER);
            arrayList.add(MaxAdFormat.LEADER);
            arrayList.add(MaxAdFormat.MREC);
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<C1654f> m6301a(JSONObject jSONObject, C1941j jVar) {
        ArrayList arrayList = new ArrayList();
        JSONObject b = C1993i.m7901b(jSONObject, NativeProtocol.RESULT_ARGS_PERMISSIONS, new JSONObject(), jVar);
        Iterator<String> keys = b.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                arrayList.add(new C1654f(next, b.getString(next), jVar.mo8527E()));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private List<C1647a> m6302b(JSONObject jSONObject, C1941j jVar) {
        ArrayList arrayList = new ArrayList();
        JSONArray b = C1993i.m7900b(jSONObject, "dependencies", new JSONArray(), jVar);
        for (int i = 0; i < b.length(); i++) {
            JSONObject a = C1993i.m7883a(b, i, (JSONObject) null, jVar);
            if (a != null) {
                arrayList.add(new C1647a(a, jVar));
            }
        }
        return arrayList;
    }

    /* renamed from: o */
    private C1652a m6303o() {
        if (!this.f5158c && !this.f5159d) {
            return C1652a.MISSING;
        }
        for (C1654f c : this.f5170o) {
            if (!c.mo7673c()) {
                return C1652a.INVALID_INTEGRATION;
            }
        }
        for (C1647a c2 : this.f5171p) {
            if (!c2.mo7637c()) {
                return C1652a.INVALID_INTEGRATION;
            }
        }
        if (this.f5172q.mo7668a() && !this.f5172q.mo7669b()) {
            return C1652a.INVALID_INTEGRATION;
        }
        if (this.f5158c) {
            if (this.f5159d) {
                return C1652a.COMPLETE;
            }
            if (this.f5161f) {
                return C1652a.MISSING;
            }
        }
        return C1652a.INCOMPLETE_INTEGRATION;
    }

    /* renamed from: a */
    public int compareTo(C1651d dVar) {
        return this.f5163h.compareToIgnoreCase(dVar.f5163h);
    }

    /* renamed from: a */
    public C1652a mo7652a() {
        return this.f5156a;
    }

    /* renamed from: b */
    public int mo7653b() {
        return this.f5157b;
    }

    /* renamed from: c */
    public boolean mo7654c() {
        return this.f5158c;
    }

    /* renamed from: d */
    public boolean mo7656d() {
        return this.f5159d;
    }

    /* renamed from: e */
    public boolean mo7657e() {
        return this.f5160e;
    }

    /* renamed from: f */
    public String mo7658f() {
        return this.f5163h;
    }

    /* renamed from: g */
    public String mo7659g() {
        return this.f5165j;
    }

    public String getCommunicatorId() {
        return "MediatedNetwork";
    }

    /* renamed from: h */
    public String mo7660h() {
        return this.f5166k;
    }

    /* renamed from: i */
    public String mo7661i() {
        return this.f5167l;
    }

    /* renamed from: j */
    public int mo7662j() {
        return this.f5168m;
    }

    /* renamed from: k */
    public List<C1654f> mo7663k() {
        return this.f5170o;
    }

    /* renamed from: l */
    public List<C1647a> mo7664l() {
        return this.f5171p;
    }

    /* renamed from: m */
    public final C1653e mo7665m() {
        return this.f5172q;
    }

    /* renamed from: n */
    public final String mo7666n() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n------------------ ");
        sb.append(this.f5162g);
        sb.append(" ------------------");
        sb.append("\nStatus  - ");
        sb.append(this.f5156a.m6319a());
        sb.append("\nSDK     - ");
        String str = "UNAVAILABLE";
        sb.append((!this.f5158c || TextUtils.isEmpty(this.f5165j)) ? str : this.f5165j);
        sb.append("\nAdapter - ");
        if (this.f5159d && !TextUtils.isEmpty(this.f5166k)) {
            str = this.f5166k;
        }
        sb.append(str);
        if (this.f5172q.mo7668a() && !this.f5172q.mo7669b()) {
            sb.append("\n* ");
            sb.append(this.f5172q.mo7670c());
        }
        for (C1654f next : mo7663k()) {
            if (!next.mo7673c()) {
                sb.append("\n* MISSING ");
                sb.append(next.mo7671a());
                sb.append(": ");
                sb.append(next.mo7672b());
            }
        }
        for (C1647a next2 : mo7664l()) {
            if (!next2.mo7637c()) {
                sb.append("\n* MISSING ");
                sb.append(next2.mo7635a());
                sb.append(": ");
                sb.append(next2.mo7636b());
            }
        }
        return sb.toString();
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (this.f5164i.equals(appLovinCommunicatorMessage.getMessageData().getString("adapter_class", ""))) {
            this.f5157b = appLovinCommunicatorMessage.getMessageData().getInt("init_status", 0);
        }
    }

    public String toString() {
        return "MediatedNetwork{name=" + this.f5162g + ", displayName=" + this.f5163h + ", sdkAvailable=" + this.f5158c + ", sdkVersion=" + this.f5165j + ", adapterAvailable=" + this.f5159d + ", adapterVersion=" + this.f5166k + "}";
    }
}
