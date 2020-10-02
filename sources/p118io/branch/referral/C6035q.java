package p118io.branch.referral;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.text.TextUtils;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.branch.referral.q */
/* compiled from: PrefHelper */
public class C6035q {

    /* renamed from: f */
    private static boolean f15641f = false;

    /* renamed from: g */
    private static String f15642g;

    /* renamed from: h */
    private static C6035q f15643h;

    /* renamed from: i */
    private static JSONObject f15644i;

    /* renamed from: a */
    private SharedPreferences f15645a;

    /* renamed from: b */
    private SharedPreferences.Editor f15646b;

    /* renamed from: c */
    private final JSONObject f15647c = new JSONObject();

    /* renamed from: d */
    private final JSONObject f15648d = new JSONObject();

    /* renamed from: e */
    private Context f15649e;

    private C6035q(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("branch_referral_shared_pref", 0);
        this.f15645a = sharedPreferences;
        this.f15646b = sharedPreferences.edit();
        this.f15649e = context;
    }

    /* renamed from: J */
    private void m19392J() {
        String v = mo34001v();
        String w = mo34003w();
        String e = mo33967e();
        String x = mo34005x();
        this.f15646b.clear();
        mo33995s(v);
        mo33998t(w);
        mo33972g(e);
        mo34000u(x);
        f15643h.f15646b.apply();
    }

    /* renamed from: K */
    private ArrayList<String> m19393K() {
        String f = mo33970f("bnc_actions");
        if (f.equals("bnc_no_value")) {
            return new ArrayList<>();
        }
        return m19400z(f);
    }

    /* renamed from: L */
    private ArrayList<String> m19394L() {
        String f = mo33970f("bnc_buckets");
        if (f.equals("bnc_no_value")) {
            return new ArrayList<>();
        }
        return m19400z(f);
    }

    /* renamed from: a */
    public static C6035q m19395a(Context context) {
        if (f15643h == null) {
            f15643h = new C6035q(context);
        }
        return f15643h;
    }

    /* renamed from: A */
    public int mo33937A() {
        return mo33946a("bnc_retry_interval", 1000);
    }

    /* renamed from: B */
    public String mo33938B() {
        return mo33970f("bnc_session_id");
    }

    /* renamed from: C */
    public String mo33939C() {
        return mo33970f("bnc_session_params");
    }

    /* renamed from: D */
    public int mo33940D() {
        return mo33946a("bnc_timeout", 5500);
    }

    /* renamed from: E */
    public String mo33941E() {
        return mo33970f("bnc_user_url");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: F */
    public boolean mo33942F() {
        return mo33955a("bnc_limit_facebook_tracking");
    }

    /* renamed from: G */
    public boolean mo33943G() {
        return mo33955a("bnc_is_full_app_conversion");
    }

    /* renamed from: H */
    public void mo33944H() {
        f15641f = true;
    }

    /* renamed from: I */
    public void mo33945I() {
        mo33968e("bnc_is_referrable", 1);
    }

    /* renamed from: b */
    public void mo33959b(boolean z) {
        mo33952a("bnc_is_full_app_conversion", Boolean.valueOf(z));
    }

    /* renamed from: c */
    public void mo33961c() {
        Iterator<String> it = m19394L().iterator();
        while (it.hasNext()) {
            mo33965d(it.next(), 0);
        }
        m19399c((ArrayList<String>) new ArrayList());
        Iterator<String> it2 = m19393K().iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            mo33958b(next, 0);
            mo33962c(next, 0);
        }
        m19398b((ArrayList<String>) new ArrayList());
    }

    /* renamed from: d */
    public String mo33964d() {
        return "https://api.branch.io/";
    }

    /* renamed from: d */
    public void mo33965d(String str, int i) {
        ArrayList<String> L = m19394L();
        if (!L.contains(str)) {
            L.add(str);
            m19399c(L);
        }
        mo33968e("bnc_credit_base_" + str, i);
    }

    /* renamed from: e */
    public String mo33967e() {
        return mo33970f("bnc_app_link");
    }

    /* renamed from: f */
    public String mo33969f() {
        return mo33970f("bnc_app_version");
    }

    /* renamed from: g */
    public void mo33972g(String str) {
        mo33953a("bnc_app_link", str);
    }

    /* renamed from: h */
    public void mo33974h(String str) {
        mo33953a("bnc_app_version", str);
    }

    /* renamed from: i */
    public boolean mo33976i(String str) {
        f15642g = str;
        String f = mo33970f("bnc_branch_key");
        if (str != null && f != null && f.equals(str)) {
            return false;
        }
        m19392J();
        mo33953a("bnc_branch_key", str);
        return true;
    }

    /* renamed from: j */
    public void mo33977j(String str) {
        mo33953a("bnc_device_fingerprint_id", str);
    }

    /* renamed from: k */
    public void mo33980k(String str) {
        mo33953a("bnc_external_intent_extra", str);
    }

    /* renamed from: l */
    public void mo33982l(String str) {
        mo33953a("bnc_external_intent_uri", str);
    }

    /* renamed from: m */
    public void mo33984m(String str) {
        mo33953a("bnc_google_play_install_referrer_extras", str);
    }

    /* renamed from: n */
    public void mo33986n(String str) {
        mo33953a("bnc_google_search_install_identifier", str);
    }

    /* renamed from: o */
    public void mo33988o(String str) {
        mo33953a("bnc_identity", str);
    }

    /* renamed from: p */
    public void mo33990p(String str) {
        mo33953a("bnc_identity_id", str);
    }

    /* renamed from: q */
    public void mo33992q(String str) {
        mo33953a("bnc_install_params", str);
    }

    /* renamed from: r */
    public String mo33993r() {
        return mo33970f("bnc_install_params");
    }

    /* renamed from: s */
    public void mo33995s(String str) {
        mo33953a("bnc_link_click_id", str);
    }

    /* renamed from: t */
    public void mo33998t(String str) {
        mo33953a("bnc_link_click_identifier", str);
    }

    /* renamed from: u */
    public void mo34000u(String str) {
        mo33953a("bnc_push_identifier", str);
    }

    /* renamed from: v */
    public void mo34002v(String str) {
        mo33953a("bnc_session_id", str);
    }

    /* renamed from: w */
    public String mo34003w() {
        return mo33970f("bnc_link_click_identifier");
    }

    /* renamed from: x */
    public String mo34005x() {
        return mo33970f("bnc_push_identifier");
    }

    /* renamed from: y */
    public void mo34008y(String str) {
        mo33968e("bnc_branch_view_use_" + str, mo33956b(str) + 1);
    }

    /* renamed from: z */
    public int mo34009z() {
        return mo33946a("bnc_retry_count", 3);
    }

    /* renamed from: z */
    private ArrayList<String> m19400z(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, str.split(","));
        return arrayList;
    }

    /* renamed from: b */
    public void mo33957b() {
        mo33968e("bnc_is_referrable", 0);
    }

    /* renamed from: e */
    public long mo33966e(String str) {
        return f15643h.f15645a.getLong(str, 0);
    }

    /* renamed from: f */
    public String mo33970f(String str) {
        return f15643h.f15645a.getString(str, "bnc_no_value");
    }

    /* renamed from: g */
    public JSONObject mo33971g() {
        JSONObject jSONObject = f15644i;
        if (jSONObject != null) {
            return jSONObject;
        }
        String f = mo33970f("bnc_branch_analytical_data");
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(f) && !f.equals("bnc_no_value")) {
            try {
                return new JSONObject(f);
            } catch (JSONException unused) {
            }
        }
        return jSONObject2;
    }

    /* renamed from: h */
    public String mo33973h() {
        if (f15642g == null) {
            f15642g = mo33970f("bnc_branch_key");
        }
        return f15642g;
    }

    /* renamed from: j */
    public boolean mo33978j() {
        return f15641f;
    }

    /* renamed from: k */
    public String mo33979k() {
        return mo33970f("bnc_external_intent_extra");
    }

    /* renamed from: l */
    public String mo33981l() {
        return mo33970f("bnc_external_intent_uri");
    }

    /* renamed from: m */
    public String mo33983m() {
        return mo33970f("bnc_google_play_install_referrer_extras");
    }

    /* renamed from: n */
    public String mo33985n() {
        return mo33970f("bnc_google_search_install_identifier");
    }

    /* renamed from: o */
    public String mo33987o() {
        return mo33970f("bnc_identity");
    }

    /* renamed from: p */
    public String mo33989p() {
        return mo33970f("bnc_identity_id");
    }

    /* renamed from: q */
    public JSONObject mo33991q() {
        return this.f15648d;
    }

    /* renamed from: r */
    public void mo33994r(String str) {
        mo33953a("bnc_install_referrer", str);
    }

    /* renamed from: s */
    public boolean mo33996s() {
        return mo33955a("bnc_triggered_by_fb_app_link");
    }

    /* renamed from: t */
    public int mo33997t() {
        return mo33963d("bnc_is_referrable");
    }

    /* renamed from: u */
    public long mo33999u() {
        return mo33966e("bnc_branch_strong_match_time");
    }

    /* renamed from: v */
    public String mo34001v() {
        return mo33970f("bnc_link_click_id");
    }

    /* renamed from: w */
    public void mo34004w(String str) {
        mo33953a("bnc_session_params", str);
    }

    /* renamed from: x */
    public void mo34006x(String str) {
        mo33953a("bnc_user_url", str);
    }

    /* renamed from: b */
    private void m19398b(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            mo33953a("bnc_actions", "bnc_no_value");
        } else {
            mo33953a("bnc_actions", m19396a(arrayList));
        }
    }

    /* renamed from: e */
    public void mo33968e(String str, int i) {
        f15643h.f15646b.putInt(str, i);
        f15643h.f15646b.apply();
    }

    /* renamed from: a */
    public String mo33947a(boolean z) {
        String str = z ? "io.branch.sdk.BranchKey" : "io.branch.sdk.BranchKey.test";
        if (!z) {
            mo33944H();
        }
        String str2 = null;
        try {
            ApplicationInfo applicationInfo = this.f15649e.getPackageManager().getApplicationInfo(this.f15649e.getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
            if (applicationInfo.metaData != null && (str2 = applicationInfo.metaData.getString(str)) == null && !z) {
                str2 = applicationInfo.metaData.getString("io.branch.sdk.BranchKey");
            }
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            try {
                Resources resources = this.f15649e.getResources();
                str2 = resources.getString(resources.getIdentifier(str, "string", this.f15649e.getPackageName()));
            } catch (Exception unused2) {
            }
        }
        return str2 == null ? "bnc_no_value" : str2;
    }

    /* renamed from: y */
    public JSONObject mo34007y() {
        return this.f15647c;
    }

    /* renamed from: b */
    public void mo33958b(String str, int i) {
        ArrayList<String> K = m19393K();
        if (!K.contains(str)) {
            K.add(str);
            m19398b(K);
        }
        mo33968e("bnc_total_base_" + str, i);
    }

    /* renamed from: d */
    public int mo33963d(String str) {
        return mo33946a(str, 0);
    }

    /* renamed from: i */
    public String mo33975i() {
        return mo33970f("bnc_device_fingerprint_id");
    }

    /* renamed from: c */
    private void m19399c(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            mo33953a("bnc_buckets", "bnc_no_value");
        } else {
            mo33953a("bnc_buckets", m19396a(arrayList));
        }
    }

    /* renamed from: b */
    public int mo33956b(String str) {
        return mo33946a("bnc_branch_view_use_" + str, 0);
    }

    /* renamed from: a */
    public void mo33950a(Boolean bool) {
        mo33952a("bnc_triggered_by_fb_app_link", bool);
    }

    /* renamed from: a */
    private String m19396a(ArrayList<String> arrayList) {
        Iterator<String> it = arrayList.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next() + ",";
        }
        return str.substring(0, str.length() - 1);
    }

    /* renamed from: b */
    public static void m19397b(String str, String str2) {
        Boolean bool;
        if ((C3555b.f9968C != null || !f15641f) && (bool = C3555b.f9968C) != null) {
            boolean booleanValue = bool.booleanValue();
        }
    }

    /* renamed from: c */
    public int mo33960c(String str) {
        return mo33963d("bnc_credit_base_" + str);
    }

    /* renamed from: c */
    public void mo33962c(String str, int i) {
        mo33968e("bnc_balance_base_" + str, i);
    }

    /* renamed from: a */
    public int mo33946a(String str, int i) {
        return f15643h.f15645a.getInt(str, i);
    }

    /* renamed from: a */
    public boolean mo33955a(String str) {
        return f15643h.f15645a.getBoolean(str, false);
    }

    /* renamed from: a */
    public void mo33951a(String str, long j) {
        f15643h.f15646b.putLong(str, j);
        f15643h.f15646b.apply();
    }

    /* renamed from: a */
    public void mo33953a(String str, String str2) {
        f15643h.f15646b.putString(str, str2);
        f15643h.f15646b.apply();
    }

    /* renamed from: a */
    public void mo33952a(String str, Boolean bool) {
        f15643h.f15646b.putBoolean(str, bool.booleanValue());
        f15643h.f15646b.apply();
    }

    /* renamed from: a */
    public void mo33948a() {
        f15644i = null;
        mo33953a("bnc_branch_analytical_data", "");
    }

    /* renamed from: a */
    public void mo33954a(JSONObject jSONObject) {
        JSONArray jSONArray;
        String B = mo33938B();
        if (!B.equals("bnc_no_value")) {
            if (f15644i == null) {
                f15644i = mo33971g();
            }
            try {
                if (f15644i.has(B)) {
                    jSONArray = f15644i.getJSONArray(B);
                } else {
                    JSONArray jSONArray2 = new JSONArray();
                    f15644i.put(B, jSONArray2);
                    jSONArray = jSONArray2;
                }
                jSONArray.put(jSONObject);
                mo33953a("bnc_branch_analytical_data", f15644i.toString());
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: a */
    public void mo33949a(long j) {
        mo33951a("bnc_branch_strong_match_time", j);
    }
}
