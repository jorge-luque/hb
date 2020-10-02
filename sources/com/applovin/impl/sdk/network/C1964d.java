package com.applovin.impl.sdk.network;

import android.content.Context;
import com.applovin.impl.sdk.p050b.C1843e;
import com.applovin.impl.sdk.p050b.C1844f;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.d */
public class C1964d {

    /* renamed from: a */
    private static final Object f6573a = new Object();

    /* renamed from: a */
    private static JSONObject m7632a(String str, Context context) {
        JSONObject b = m7636b(context);
        if (b == null) {
            b = new JSONObject();
        }
        if (!b.has(str)) {
            try {
                b.put(str, new JSONObject());
            } catch (JSONException unused) {
            }
        }
        return b;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:5|6|7|8|9|10|11|12|13|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0023 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0026 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m7633a(int r4, java.lang.String r5, android.content.Context r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.Object r0 = f6573a
            monitor-enter(r0)
            java.lang.String r5 = com.applovin.impl.sdk.utils.C2029r.m8035d((java.lang.String) r5)     // Catch:{ all -> 0x002b }
            org.json.JSONObject r1 = m7632a((java.lang.String) r5, (android.content.Context) r6)     // Catch:{ all -> 0x002b }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x002b }
            org.json.JSONObject r2 = r1.optJSONObject(r5)     // Catch:{ all -> 0x002b }
            int r3 = r2.optInt(r4)     // Catch:{ all -> 0x002b }
            int r3 = r3 + 1
            r2.put(r4, r3)     // Catch:{ JSONException -> 0x0023 }
        L_0x0023:
            r1.put(r5, r2)     // Catch:{ JSONException -> 0x0026 }
        L_0x0026:
            m7635a((org.json.JSONObject) r1, (android.content.Context) r6)     // Catch:{ all -> 0x002b }
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.C1964d.m7633a(int, java.lang.String, android.content.Context):void");
    }

    /* renamed from: a */
    public static void m7634a(Context context) {
        synchronized (f6573a) {
            C1844f.m7057a(C1843e.f6103q, context);
        }
    }

    /* renamed from: a */
    private static void m7635a(JSONObject jSONObject, Context context) {
        C1844f.m7058a(C1843e.f6103q, jSONObject.toString(), context);
    }

    /* renamed from: b */
    public static JSONObject m7636b(Context context) {
        JSONObject jSONObject;
        synchronized (f6573a) {
            try {
                jSONObject = new JSONObject((String) C1844f.m7060b(C1843e.f6103q, "{}", context));
            } catch (JSONException unused) {
                return new JSONObject();
            } catch (Throwable th) {
                throw th;
            }
        }
        return jSONObject;
    }
}
