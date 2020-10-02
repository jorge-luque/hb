package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.google.firebase.messaging.w */
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
public final class C3823w {

    /* renamed from: a */
    private final Bundle f10565a;

    public C3823w(Bundle bundle) {
        if (bundle != null) {
            this.f10565a = new Bundle(bundle);
            return;
        }
        throw new NullPointerException("data");
    }

    /* renamed from: g */
    private final JSONArray m12915g(String str) {
        String a = mo27516a(str);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        try {
            return new JSONArray(a);
        } catch (JSONException unused) {
            String h = m12916h(str);
            StringBuilder sb = new StringBuilder(String.valueOf(h).length() + 50 + String.valueOf(a).length());
            sb.append("Malformed JSON for key ");
            sb.append(h);
            sb.append(": ");
            sb.append(a);
            sb.append(", falling back to default");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    /* renamed from: h */
    private static String m12916h(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    /* renamed from: i */
    private static String m12917i(String str) {
        if (!str.startsWith("gcm.n.")) {
            return str;
        }
        return str.replace("gcm.n.", "gcm.notification.");
    }

    /* renamed from: a */
    public final String mo27516a(String str) {
        Bundle bundle = this.f10565a;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            String i = m12917i(str);
            if (this.f10565a.containsKey(i)) {
                str = i;
            }
        }
        return bundle.getString(str);
    }

    /* renamed from: b */
    public final boolean mo27518b(String str) {
        String a = mo27516a(str);
        return "1".equals(a) || Boolean.parseBoolean(a);
    }

    /* renamed from: c */
    public final Integer mo27519c(String str) {
        String a = mo27516a(str);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(a));
        } catch (NumberFormatException unused) {
            String h = m12916h(str);
            StringBuilder sb = new StringBuilder(String.valueOf(h).length() + 38 + String.valueOf(a).length());
            sb.append("Couldn't parse value of ");
            sb.append(h);
            sb.append("(");
            sb.append(a);
            sb.append(") into an int");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    /* renamed from: d */
    public final Long mo27521d(String str) {
        String a = mo27516a(str);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(a));
        } catch (NumberFormatException unused) {
            String h = m12916h(str);
            StringBuilder sb = new StringBuilder(String.valueOf(h).length() + 38 + String.valueOf(a).length());
            sb.append("Couldn't parse value of ");
            sb.append(h);
            sb.append("(");
            sb.append(a);
            sb.append(") into a long");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    /* renamed from: e */
    public final String mo27524e(String str) {
        String valueOf = String.valueOf(str);
        return mo27516a("_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
    }

    /* renamed from: f */
    public final Object[] mo27526f(String str) {
        String valueOf = String.valueOf(str);
        JSONArray g = m12915g("_loc_args".length() != 0 ? valueOf.concat("_loc_args") : new String(valueOf));
        if (g == null) {
            return null;
        }
        int length = g.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = g.optString(i);
        }
        return strArr;
    }

    /* renamed from: e */
    public final Bundle mo27523e() {
        Bundle bundle = new Bundle(this.f10565a);
        for (String str : this.f10565a.keySet()) {
            if (str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    /* renamed from: b */
    public final String mo27517b() {
        String a = mo27516a("gcm.n.sound2");
        return TextUtils.isEmpty(a) ? mo27516a("gcm.n.sound") : a;
    }

    /* renamed from: f */
    public final Bundle mo27525f() {
        Bundle bundle = new Bundle(this.f10565a);
        for (String str : this.f10565a.keySet()) {
            if (!(str.startsWith("google.c.a.") || str.equals("from"))) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    /* renamed from: b */
    private final String m12914b(Resources resources, String str, String str2) {
        String e = mo27524e(str2);
        if (TextUtils.isEmpty(e)) {
            return null;
        }
        int identifier = resources.getIdentifier(e, "string", str);
        if (identifier == 0) {
            String valueOf = String.valueOf(str2);
            String h = m12916h("_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
            StringBuilder sb = new StringBuilder(String.valueOf(h).length() + 49 + String.valueOf(str2).length());
            sb.append(h);
            sb.append(" resource not found: ");
            sb.append(str2);
            sb.append(" Default value will be used.");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
        Object[] f = mo27526f(str2);
        if (f == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, f);
        } catch (MissingFormatArgumentException e2) {
            String h2 = m12916h(str2);
            String arrays = Arrays.toString(f);
            StringBuilder sb2 = new StringBuilder(String.valueOf(h2).length() + 58 + String.valueOf(arrays).length());
            sb2.append("Missing format argument for ");
            sb2.append(h2);
            sb2.append(": ");
            sb2.append(arrays);
            sb2.append(" Default value will be used.");
            Log.w("NotificationParams", sb2.toString(), e2);
            return null;
        }
    }

    /* renamed from: a */
    public final Uri mo27514a() {
        String a = mo27516a("gcm.n.link_android");
        if (TextUtils.isEmpty(a)) {
            a = mo27516a("gcm.n.link");
        }
        if (!TextUtils.isEmpty(a)) {
            return Uri.parse(a);
        }
        return null;
    }

    /* renamed from: c */
    public final long[] mo27520c() {
        JSONArray g = m12915g("gcm.n.vibrate_timings");
        if (g == null) {
            return null;
        }
        try {
            if (g.length() > 1) {
                int length = g.length();
                long[] jArr = new long[length];
                for (int i = 0; i < length; i++) {
                    jArr[i] = g.optLong(i);
                }
                return jArr;
            }
            throw new JSONException("vibrateTimings have invalid length");
        } catch (NumberFormatException | JSONException unused) {
            String valueOf = String.valueOf(g);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 74);
            sb.append("User defined vibrateTimings is invalid: ");
            sb.append(valueOf);
            sb.append(". Skipping setting vibrateTimings.");
            Log.w("NotificationParams", sb.toString());
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final int[] mo27522d() {
        JSONArray g = m12915g("gcm.n.light_settings");
        if (g == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (g.length() == 3) {
                int parseColor = Color.parseColor(g.optString(0));
                if (parseColor != -16777216) {
                    iArr[0] = parseColor;
                    iArr[1] = g.optInt(1);
                    iArr[2] = g.optInt(2);
                    return iArr;
                }
                throw new IllegalArgumentException("Transparent color is invalid");
            }
            throw new JSONException("lightSettings don't have all three fields");
        } catch (JSONException unused) {
            String valueOf = String.valueOf(g);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 58);
            sb.append("LightSettings is invalid: ");
            sb.append(valueOf);
            sb.append(". Skipping setting LightSettings");
            Log.w("NotificationParams", sb.toString());
            return null;
        } catch (IllegalArgumentException e) {
            String valueOf2 = String.valueOf(g);
            String message = e.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 60 + String.valueOf(message).length());
            sb2.append("LightSettings is invalid: ");
            sb2.append(valueOf2);
            sb2.append(". ");
            sb2.append(message);
            sb2.append(". Skipping setting LightSettings");
            Log.w("NotificationParams", sb2.toString());
            return null;
        }
    }

    /* renamed from: a */
    public final String mo27515a(Resources resources, String str, String str2) {
        String a = mo27516a(str2);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        return m12914b(resources, str, str2);
    }

    /* renamed from: a */
    public static boolean m12913a(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString(m12917i("gcm.n.e")));
    }
}
