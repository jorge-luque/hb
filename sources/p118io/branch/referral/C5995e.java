package p118io.branch.referral;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.branch.referral.e */
/* compiled from: BranchLinkData */
class C5995e extends JSONObject {

    /* renamed from: a */
    private Collection<String> f15334a;

    /* renamed from: b */
    private String f15335b;

    /* renamed from: c */
    private int f15336c;

    /* renamed from: d */
    private String f15337d;

    /* renamed from: e */
    private String f15338e;

    /* renamed from: f */
    private String f15339f;

    /* renamed from: g */
    private String f15340g;

    /* renamed from: h */
    private JSONObject f15341h;

    /* renamed from: i */
    private int f15342i;

    /* renamed from: a */
    public void mo33832a(Collection<String> collection) throws JSONException {
        if (collection != null) {
            this.f15334a = collection;
            JSONArray jSONArray = new JSONArray();
            for (String put : collection) {
                jSONArray.put(put);
            }
            put(C6029m.Tags.mo33922a(), jSONArray);
        }
    }

    /* renamed from: b */
    public void mo33835b(int i) throws JSONException {
        if (i != 0) {
            this.f15336c = i;
            put(C6029m.Type.mo33922a(), i);
        }
    }

    /* renamed from: c */
    public void mo33838c(String str) throws JSONException {
        if (str != null) {
            this.f15337d = str;
            put(C6029m.Channel.mo33922a(), str);
        }
    }

    /* renamed from: d */
    public int mo33839d() {
        return this.f15342i;
    }

    /* renamed from: e */
    public String mo33841e() {
        return this.f15338e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C5995e.class != obj.getClass()) {
            return false;
        }
        C5995e eVar = (C5995e) obj;
        String str = this.f15335b;
        if (str == null) {
            if (eVar.f15335b != null) {
                return false;
            }
        } else if (!str.equals(eVar.f15335b)) {
            return false;
        }
        String str2 = this.f15337d;
        if (str2 == null) {
            if (eVar.f15337d != null) {
                return false;
            }
        } else if (!str2.equals(eVar.f15337d)) {
            return false;
        }
        String str3 = this.f15338e;
        if (str3 == null) {
            if (eVar.f15338e != null) {
                return false;
            }
        } else if (!str3.equals(eVar.f15338e)) {
            return false;
        }
        JSONObject jSONObject = this.f15341h;
        if (jSONObject == null) {
            if (eVar.f15341h != null) {
                return false;
            }
        } else if (!jSONObject.equals(eVar.f15341h)) {
            return false;
        }
        String str4 = this.f15339f;
        if (str4 == null) {
            if (eVar.f15339f != null) {
                return false;
            }
        } else if (!str4.equals(eVar.f15339f)) {
            return false;
        }
        String str5 = this.f15340g;
        if (str5 == null) {
            if (eVar.f15340g != null) {
                return false;
            }
        } else if (!str5.equals(eVar.f15340g)) {
            return false;
        }
        if (this.f15336c != eVar.f15336c || this.f15342i != eVar.f15342i) {
            return false;
        }
        Collection<String> collection = this.f15334a;
        if (collection == null) {
            if (eVar.f15334a != null) {
                return false;
            }
        } else if (!collection.toString().equals(eVar.f15334a.toString())) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public JSONObject mo33844f() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f15337d)) {
                jSONObject.put("~" + C6029m.Channel.mo33922a(), this.f15337d);
            }
            if (!TextUtils.isEmpty(this.f15335b)) {
                jSONObject.put("~" + C6029m.Alias.mo33922a(), this.f15335b);
            }
            if (!TextUtils.isEmpty(this.f15338e)) {
                jSONObject.put("~" + C6029m.Feature.mo33922a(), this.f15338e);
            }
            if (!TextUtils.isEmpty(this.f15339f)) {
                jSONObject.put("~" + C6029m.Stage.mo33922a(), this.f15339f);
            }
            if (!TextUtils.isEmpty(this.f15340g)) {
                jSONObject.put("~" + C6029m.Campaign.mo33922a(), this.f15340g);
            }
            if (has(C6029m.Tags.mo33922a())) {
                jSONObject.put(C6029m.Tags.mo33922a(), getJSONArray(C6029m.Tags.mo33922a()));
            }
            jSONObject.put("~" + C6029m.Type.mo33922a(), this.f15336c);
            jSONObject.put("~" + C6029m.Duration.mo33922a(), this.f15342i);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* renamed from: g */
    public JSONObject mo33845g() {
        return this.f15341h;
    }

    /* renamed from: h */
    public String mo33846h() {
        return this.f15339f;
    }

    @SuppressLint({"DefaultLocale"})
    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = (this.f15336c + 19) * 19;
        String str = this.f15335b;
        int i7 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.toLowerCase().hashCode();
        }
        int i8 = (i6 + i) * 19;
        String str2 = this.f15337d;
        if (str2 == null) {
            i2 = 0;
        } else {
            i2 = str2.toLowerCase().hashCode();
        }
        int i9 = (i8 + i2) * 19;
        String str3 = this.f15338e;
        if (str3 == null) {
            i3 = 0;
        } else {
            i3 = str3.toLowerCase().hashCode();
        }
        int i10 = (i9 + i3) * 19;
        String str4 = this.f15339f;
        if (str4 == null) {
            i4 = 0;
        } else {
            i4 = str4.toLowerCase().hashCode();
        }
        int i11 = (i10 + i4) * 19;
        String str5 = this.f15340g;
        if (str5 == null) {
            i5 = 0;
        } else {
            i5 = str5.toLowerCase().hashCode();
        }
        int i12 = (i11 + i5) * 19;
        JSONObject jSONObject = this.f15341h;
        if (jSONObject != null) {
            i7 = jSONObject.toString().toLowerCase().hashCode();
        }
        int i13 = ((i12 + i7) * 19) + this.f15342i;
        Collection<String> collection = this.f15334a;
        if (collection != null) {
            for (String lowerCase : collection) {
                i13 = (i13 * 19) + lowerCase.toLowerCase().hashCode();
            }
        }
        return i13;
    }

    /* renamed from: i */
    public Collection<String> mo33848i() {
        return this.f15334a;
    }

    /* renamed from: j */
    public int mo33849j() {
        return this.f15336c;
    }

    /* renamed from: d */
    public void mo33840d(String str) throws JSONException {
        if (str != null) {
            this.f15338e = str;
            put(C6029m.Feature.mo33922a(), str);
        }
    }

    /* renamed from: e */
    public void mo33842e(String str) throws JSONException {
        if (str != null) {
            this.f15339f = str;
            put(C6029m.Stage.mo33922a(), str);
        }
    }

    /* renamed from: b */
    public void mo33836b(String str) throws JSONException {
        if (str != null) {
            this.f15340g = str;
            put(C6029m.Campaign.mo33922a(), str);
        }
    }

    /* renamed from: c */
    public String mo33837c() {
        return this.f15337d;
    }

    /* renamed from: b */
    public String mo33834b() {
        return this.f15340g;
    }

    /* renamed from: a */
    public void mo33831a(String str) throws JSONException {
        if (str != null) {
            this.f15335b = str;
            put(C6029m.Alias.mo33922a(), str);
        }
    }

    /* renamed from: a */
    public String mo33829a() {
        return this.f15335b;
    }

    /* renamed from: a */
    public void mo33830a(int i) throws JSONException {
        if (i > 0) {
            this.f15342i = i;
            put(C6029m.Duration.mo33922a(), i);
        }
    }

    /* renamed from: a */
    public void mo33833a(JSONObject jSONObject) throws JSONException {
        this.f15341h = jSONObject;
        put(C6029m.Data.mo33922a(), jSONObject);
    }
}
