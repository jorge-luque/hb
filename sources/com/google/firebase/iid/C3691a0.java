package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.firebase.iid.a0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final class C3691a0 {

    /* renamed from: d */
    private static final long f10282d = TimeUnit.DAYS.toMillis(7);

    /* renamed from: a */
    final String f10283a;

    /* renamed from: b */
    private final String f10284b;

    /* renamed from: c */
    private final long f10285c;

    private C3691a0(String str, String str2, long j) {
        this.f10283a = str;
        this.f10284b = str2;
        this.f10285c = j;
    }

    /* renamed from: a */
    static String m12559a(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j);
            return jSONObject.toString();
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
            sb.append("Failed to encode token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    /* renamed from: b */
    static C3691a0 m12560b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new C3691a0(str, (String) null, 0);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new C3691a0(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to parse token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo27310a(String str) {
        return System.currentTimeMillis() > this.f10285c + f10282d || !str.equals(this.f10284b);
    }
}
