package com.applovin.impl.mediation.p045b;

import android.content.Context;
import android.os.Bundle;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p050b.C1840b;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.sdk.AppLovinPrivacySettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

/* renamed from: com.applovin.impl.mediation.b.e */
public class C1701e {

    /* renamed from: a */
    private final JSONObject f5301a;

    /* renamed from: b */
    protected final C1941j f5302b;

    /* renamed from: c */
    private final JSONObject f5303c;

    /* renamed from: d */
    private final Object f5304d = new Object();

    /* renamed from: e */
    private final Object f5305e = new Object();

    /* renamed from: f */
    private volatile String f5306f;

    public C1701e(JSONObject jSONObject, JSONObject jSONObject2, C1941j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (jSONObject2 == null) {
            throw new IllegalArgumentException("No full response specified");
        } else if (jSONObject != null) {
            this.f5302b = jVar;
            this.f5301a = jSONObject2;
            this.f5303c = jSONObject;
        } else {
            throw new IllegalArgumentException("No spec object specified");
        }
    }

    /* renamed from: a */
    private int mo7765a() {
        return mo7830b("mute_state", mo7822a("mute_state", ((Integer) this.f5302b.mo8549a(C1840b.f5758K)).intValue()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public JSONObject mo7810B() {
        JSONObject jSONObject;
        synchronized (this.f5305e) {
            jSONObject = this.f5301a;
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public JSONObject mo7811C() {
        JSONObject jSONObject;
        synchronized (this.f5304d) {
            jSONObject = this.f5303c;
        }
        return jSONObject;
    }

    /* renamed from: D */
    public String mo7812D() {
        return mo7833b("class", (String) null);
    }

    /* renamed from: E */
    public String mo7813E() {
        return mo7833b("name", (String) null);
    }

    /* renamed from: F */
    public String mo7814F() {
        return mo7813E().split(C6120b.ROLL_OVER_FILE_NAME_SEPARATOR)[0];
    }

    /* renamed from: G */
    public boolean mo7815G() {
        return mo7836b("is_testing", (Boolean) false);
    }

    /* renamed from: H */
    public boolean mo7816H() {
        return mo7836b("run_on_ui_thread", (Boolean) true);
    }

    /* renamed from: I */
    public Bundle mo7817I() {
        Bundle c = mo7832b("server_parameters") instanceof JSONObject ? C1993i.m7903c(mo7826a("server_parameters", (JSONObject) null)) : new Bundle();
        int a = mo7765a();
        if (a != -1) {
            c.putBoolean("is_muted", a == 2 ? this.f5302b.mo8591l().isMuted() : a == 0);
        }
        return c;
    }

    /* renamed from: J */
    public long mo7818J() {
        return mo7831b("adapter_timeout_ms", ((Long) this.f5302b.mo8549a(C1840b.f5776n)).longValue());
    }

    /* renamed from: K */
    public long mo7819K() {
        return mo7831b("init_completion_delay_ms", -1);
    }

    /* renamed from: L */
    public String mo7820L() {
        return this.f5306f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo7821a(String str, float f) {
        float a;
        synchronized (this.f5304d) {
            a = C1993i.m7868a(this.f5303c, str, f, this.f5302b);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo7822a(String str, int i) {
        int b;
        synchronized (this.f5305e) {
            b = C1993i.m7894b(this.f5301a, str, i, this.f5302b);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public long mo7823a(String str, long j) {
        long a;
        synchronized (this.f5305e) {
            a = C1993i.m7869a(this.f5301a, str, j, this.f5302b);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo7824a(String str, String str2) {
        String b;
        synchronized (this.f5305e) {
            b = C1993i.m7896b(this.f5301a, str, str2, this.f5302b);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONArray mo7825a(String str, JSONArray jSONArray) {
        JSONArray b;
        synchronized (this.f5305e) {
            b = C1993i.m7900b(this.f5301a, str, jSONArray, this.f5302b);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject mo7826a(String str, JSONObject jSONObject) {
        JSONObject b;
        synchronized (this.f5304d) {
            b = C1993i.m7901b(this.f5303c, str, jSONObject, this.f5302b);
        }
        return b;
    }

    /* renamed from: a */
    public boolean mo7827a(Context context) {
        return mo7828a("huc") ? mo7836b("huc", (Boolean) false) : mo7829a("huc", Boolean.valueOf(AppLovinPrivacySettings.hasUserConsent(context)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7828a(String str) {
        boolean has;
        synchronized (this.f5304d) {
            has = this.f5303c.has(str);
        }
        return has;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7829a(String str, Boolean bool) {
        boolean booleanValue;
        synchronized (this.f5305e) {
            booleanValue = C1993i.m7871a(this.f5301a, str, bool, this.f5302b).booleanValue();
        }
        return booleanValue;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo7830b(String str, int i) {
        int b;
        synchronized (this.f5304d) {
            b = C1993i.m7894b(this.f5303c, str, i, this.f5302b);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public long mo7831b(String str, long j) {
        long a;
        synchronized (this.f5304d) {
            a = C1993i.m7869a(this.f5303c, str, j, this.f5302b);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo7832b(String str) {
        Object opt;
        synchronized (this.f5304d) {
            opt = this.f5303c.opt(str);
        }
        return opt;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo7833b(String str, String str2) {
        String b;
        synchronized (this.f5304d) {
            b = C1993i.m7896b(this.f5303c, str, str2, this.f5302b);
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public JSONArray mo7834b(String str, JSONArray jSONArray) {
        JSONArray b;
        synchronized (this.f5304d) {
            b = C1993i.m7900b(this.f5303c, str, jSONArray, this.f5302b);
        }
        return b;
    }

    /* renamed from: b */
    public boolean mo7835b(Context context) {
        return mo7828a("aru") ? mo7836b("aru", (Boolean) false) : mo7829a("aru", Boolean.valueOf(AppLovinPrivacySettings.isAgeRestrictedUser(context)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo7836b(String str, Boolean bool) {
        boolean booleanValue;
        synchronized (this.f5304d) {
            booleanValue = C1993i.m7871a(this.f5303c, str, bool, this.f5302b).booleanValue();
        }
        return booleanValue;
    }

    /* renamed from: c */
    public void mo7837c(String str) {
        this.f5306f = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo7838c(String str, long j) {
        synchronized (this.f5304d) {
            C1993i.m7902b(this.f5303c, str, j, this.f5302b);
        }
    }

    /* renamed from: c */
    public boolean mo7839c(Context context) {
        return mo7828a("dns") ? mo7836b("dns", (Boolean) false) : mo7829a("dns", Boolean.valueOf(AppLovinPrivacySettings.isDoNotSell(context)));
    }

    /* renamed from: d */
    public List<String> mo7840d(String str) {
        if (str != null) {
            List a = C1993i.m7875a(mo7825a(str, new JSONArray()), Collections.EMPTY_LIST);
            List a2 = C1993i.m7875a(mo7834b(str, new JSONArray()), Collections.EMPTY_LIST);
            ArrayList arrayList = new ArrayList(a.size() + a2.size());
            arrayList.addAll(a);
            arrayList.addAll(a2);
            return arrayList;
        }
        throw new IllegalArgumentException("No key specified");
    }

    /* renamed from: e */
    public String mo7841e(String str) {
        String b = mo7833b(str, "");
        return C2025o.m7963b(b) ? b : mo7824a(str, "");
    }

    public String toString() {
        return "MediationAdapterSpec{adapterClass='" + mo7812D() + "', adapterName='" + mo7813E() + "', isTesting=" + mo7815G() + '}';
    }
}
