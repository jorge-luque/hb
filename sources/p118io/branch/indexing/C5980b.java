package p118io.branch.indexing;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.branch.indexing.b */
/* compiled from: ContentDiscoveryManifest */
public class C5980b {

    /* renamed from: i */
    private static C5980b f15293i;

    /* renamed from: a */
    private JSONObject f15294a;

    /* renamed from: b */
    private String f15295b;

    /* renamed from: c */
    private int f15296c = 0;

    /* renamed from: d */
    private int f15297d = 1;

    /* renamed from: e */
    private int f15298e = 0;

    /* renamed from: f */
    private boolean f15299f = false;

    /* renamed from: g */
    private JSONArray f15300g;

    /* renamed from: h */
    private SharedPreferences f15301h;

    /* renamed from: io.branch.indexing.b$a */
    /* compiled from: ContentDiscoveryManifest */
    class C5981a {

        /* renamed from: a */
        final JSONObject f15302a;

        /* renamed from: b */
        private boolean f15303b;

        /* renamed from: c */
        private int f15304c;

        /* renamed from: d */
        private int f15305d = 15;

        C5981a(C5980b bVar, JSONObject jSONObject) {
            this.f15302a = jSONObject;
            if (jSONObject.has("h")) {
                try {
                    this.f15303b = !jSONObject.getBoolean("h");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (jSONObject.has("dri")) {
                    this.f15304c = jSONObject.getInt("dri");
                }
                if (jSONObject.has("mdr")) {
                    this.f15305d = jSONObject.getInt("mdr");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo33807a() {
            return this.f15304c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public JSONArray mo33808b() {
            if (this.f15302a.has("ck")) {
                try {
                    return this.f15302a.getJSONArray("ck");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public int mo33809c() {
            return this.f15305d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public boolean mo33810d() {
            return this.f15303b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public boolean mo33811e() {
            JSONArray b = mo33808b();
            return b != null && b.length() == 0;
        }
    }

    private C5980b(Context context) {
        this.f15301h = context.getSharedPreferences("bnc_content_discovery_manifest_storage", 0);
        m19179b(context);
    }

    /* renamed from: a */
    public static C5980b m19178a(Context context) {
        if (f15293i == null) {
            f15293i = new C5980b(context);
        }
        return f15293i;
    }

    /* renamed from: b */
    private void m19179b(Context context) {
        String string = this.f15301h.getString("BNC_CD_MANIFEST", (String) null);
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                this.f15294a = jSONObject;
                if (jSONObject.has("mv")) {
                    this.f15295b = this.f15294a.getString("mv");
                }
                if (this.f15294a.has("m")) {
                    this.f15300g = this.f15294a.getJSONArray("m");
                }
            } catch (JSONException unused) {
                this.f15294a = new JSONObject();
            }
        } else {
            this.f15294a = new JSONObject();
        }
    }

    /* renamed from: f */
    private void m19180f() {
        this.f15301h.edit().putString("BNC_CD_MANIFEST", this.f15294a.toString()).apply();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo33804c() {
        return this.f15296c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo33805d() {
        return this.f15297d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo33806e() {
        return this.f15299f;
    }

    /* renamed from: a */
    public void mo33802a(JSONObject jSONObject) {
        int i;
        if (jSONObject.has("cd")) {
            this.f15299f = true;
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("cd");
                if (jSONObject2.has("mv")) {
                    this.f15295b = jSONObject2.getString("mv");
                }
                if (jSONObject2.has("mhl")) {
                    this.f15297d = jSONObject2.getInt("mhl");
                }
                if (jSONObject2.has("m")) {
                    this.f15300g = jSONObject2.getJSONArray("m");
                }
                if (jSONObject2.has("mtl") && (i = jSONObject2.getInt("mtl")) > 0) {
                    this.f15296c = i;
                }
                if (jSONObject2.has("mps")) {
                    this.f15298e = jSONObject2.getInt("mps");
                }
                this.f15294a.put("mv", this.f15295b);
                this.f15294a.put("m", this.f15300g);
                m19180f();
            } catch (JSONException unused) {
            }
        } else {
            this.f15299f = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo33803b() {
        return this.f15298e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C5981a mo33800a(Activity activity) {
        if (this.f15300g == null) {
            return null;
        }
        String str = "/" + activity.getClass().getSimpleName();
        int i = 0;
        while (i < this.f15300g.length()) {
            try {
                JSONObject jSONObject = this.f15300g.getJSONObject(i);
                if (jSONObject.has("p") && jSONObject.getString("p").equals(str)) {
                    return new C5981a(this, jSONObject);
                }
                i++;
            } catch (JSONException unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String mo33801a() {
        if (TextUtils.isEmpty(this.f15295b)) {
            return "-1";
        }
        return this.f15295b;
    }
}
