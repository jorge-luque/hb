package p118io.branch.referral;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.branch.referral.i0 */
/* compiled from: UniversalResourceAnalyser */
class C6011i0 {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static JSONObject f15389c;

    /* renamed from: d */
    private static C6011i0 f15390d;

    /* renamed from: a */
    private final ArrayList<String> f15391a;

    /* renamed from: b */
    private final JSONObject f15392b;

    /* renamed from: io.branch.referral.i0$b */
    /* compiled from: UniversalResourceAnalyser */
    private static class C6013b extends C5991c<Void, Void, JSONObject> {

        /* renamed from: a */
        private final C6035q f15393a;

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.json.JSONObject doInBackground(java.lang.Void... r7) {
            /*
                r6 = this;
                org.json.JSONObject r7 = new org.json.JSONObject
                r7.<init>()
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x005f }
                java.lang.String r2 = "https://cdn.branch.io/sdk/uriskiplist_v#.json"
                java.lang.String r3 = "#"
                org.json.JSONObject r4 = p118io.branch.referral.C6011i0.f15389c     // Catch:{ all -> 0x005f }
                java.lang.String r5 = "version"
                int r4 = r4.optInt(r5)     // Catch:{ all -> 0x005f }
                int r4 = r4 + 1
                java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x005f }
                java.lang.String r2 = r2.replace(r3, r4)     // Catch:{ all -> 0x005f }
                r1.<init>(r2)     // Catch:{ all -> 0x005f }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ all -> 0x005f }
                javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ all -> 0x005f }
                r0 = 1500(0x5dc, float:2.102E-42)
                r1.setConnectTimeout(r0)     // Catch:{ all -> 0x005d }
                r1.setReadTimeout(r0)     // Catch:{ all -> 0x005d }
                int r0 = r1.getResponseCode()     // Catch:{ all -> 0x005d }
                r2 = 200(0xc8, float:2.8E-43)
                if (r0 != r2) goto L_0x0057
                java.io.InputStream r0 = r1.getInputStream()     // Catch:{ all -> 0x005d }
                if (r0 == 0) goto L_0x0057
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x005d }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x005d }
                java.io.InputStream r3 = r1.getInputStream()     // Catch:{ all -> 0x005d }
                r2.<init>(r3)     // Catch:{ all -> 0x005d }
                r0.<init>(r2)     // Catch:{ all -> 0x005d }
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x005d }
                java.lang.String r0 = r0.readLine()     // Catch:{ all -> 0x005d }
                r2.<init>(r0)     // Catch:{ all -> 0x005d }
                r7 = r2
            L_0x0057:
                if (r1 == 0) goto L_0x0065
                r1.disconnect()
                goto L_0x0065
            L_0x005d:
                r0 = r1
                goto L_0x0060
            L_0x005f:
            L_0x0060:
                if (r0 == 0) goto L_0x0065
                r0.disconnect()
            L_0x0065:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: p118io.branch.referral.C6011i0.C6013b.doInBackground(java.lang.Void[]):org.json.JSONObject");
        }

        private C6013b(Context context) {
            this.f15393a = C6035q.m19395a(context);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(JSONObject jSONObject) {
            super.onPostExecute(jSONObject);
            if (jSONObject.optInt("version") > C6011i0.f15389c.optInt("version")) {
                JSONObject unused = C6011i0.f15389c = jSONObject;
                this.f15393a.mo33953a("skip_url_format_key", C6011i0.f15389c.toString());
            }
        }
    }

    private C6011i0(Context context) {
        JSONObject jSONObject = new JSONObject();
        this.f15392b = jSONObject;
        try {
            jSONObject.putOpt("version", 0);
            JSONArray jSONArray = new JSONArray();
            this.f15392b.putOpt("uri_skip_list", jSONArray);
            jSONArray.put("^fb\\d+:");
            jSONArray.put("^li\\d+:");
            jSONArray.put("^pdk\\d+:");
            jSONArray.put("^twitterkit-.*:");
            jSONArray.put("^com\\.googleusercontent\\.apps\\.\\d+-.*:\\/oauth");
            jSONArray.put("^(?i)(?!(http|https):).*(:|:.*\\b)(password|o?auth|o?auth.?token|access|access.?token)\\b");
            jSONArray.put("^(?i)((http|https):\\/\\/).*[\\/|?|#].*\\b(password|o?auth|o?auth.?token|access|access.?token)\\b");
        } catch (JSONException unused) {
        }
        f15389c = m19315c(context);
        this.f15391a = new ArrayList<>();
    }

    /* renamed from: b */
    public static C6011i0 m19314b(Context context) {
        if (f15390d == null) {
            f15390d = new C6011i0(context);
        }
        return f15390d;
    }

    /* renamed from: c */
    private JSONObject m19315c(Context context) {
        C6035q a = C6035q.m19395a(context);
        JSONObject jSONObject = new JSONObject();
        String f = a.mo33970f("skip_url_format_key");
        if (TextUtils.isEmpty(f) || "bnc_no_value".equals(f)) {
            return this.f15392b;
        }
        try {
            return new JSONObject(f);
        } catch (JSONException unused) {
            return jSONObject;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo33894a(Context context) {
        try {
            new C6013b(context).mo33821a(new Void[0]);
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo33893a(String str) {
        String str2;
        try {
            JSONArray optJSONArray = f15389c.optJSONArray("uri_skip_list");
            if (optJSONArray != null) {
                int i = 0;
                while (true) {
                    if (i >= optJSONArray.length()) {
                        break;
                    }
                    try {
                        str2 = optJSONArray.getString(i);
                        if (Pattern.compile(str2).matcher(str).find()) {
                            break;
                        }
                        i++;
                    } catch (JSONException unused) {
                    }
                }
            }
            str2 = null;
            if (str2 == null) {
                if (this.f15391a.size() <= 0) {
                    return str;
                }
                Iterator<String> it = this.f15391a.iterator();
                while (it.hasNext()) {
                    if (str.matches(it.next())) {
                        return str;
                    }
                }
            }
            return str2;
        } catch (Exception unused2) {
            return str;
        }
    }
}
