package p118io.presage;

import org.json.JSONObject;

/* renamed from: io.presage.ab */
public final class C6211ab {
    /* renamed from: a */
    public static final int m20766a(JSONObject jSONObject, String str, int i) {
        return jSONObject != null ? jSONObject.optInt(str, i) : i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r0.optString(r1, r2);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String m20768a(org.json.JSONObject r0, java.lang.String r1, java.lang.String r2) {
        /*
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.optString(r1, r2)
            if (r0 != 0) goto L_0x0009
            goto L_0x000a
        L_0x0009:
            r2 = r0
        L_0x000a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.presage.C6211ab.m20768a(org.json.JSONObject, java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static final boolean m20770a(JSONObject jSONObject, String str, boolean z) {
        return jSONObject != null ? jSONObject.optBoolean(str, z) : z;
    }

    /* renamed from: a */
    public static final long m20767a(JSONObject jSONObject, String str, long j) {
        return jSONObject != null ? jSONObject.optLong(str, j) : j;
    }

    /* renamed from: a */
    public static final boolean m20769a(JSONObject jSONObject) {
        return jSONObject.length() == 0;
    }
}
