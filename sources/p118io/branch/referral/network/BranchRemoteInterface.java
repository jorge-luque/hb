package p118io.branch.referral.network;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.branch.referral.C3555b;
import p118io.branch.referral.C5996e0;
import p118io.branch.referral.C6028l;
import p118io.branch.referral.C6035q;

/* renamed from: io.branch.referral.network.BranchRemoteInterface */
public abstract class BranchRemoteInterface {

    /* renamed from: io.branch.referral.network.BranchRemoteInterface$BranchRemoteException */
    public static class BranchRemoteException extends Exception {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f15621a = -113;

        public BranchRemoteException(int i) {
            this.f15621a = i;
        }
    }

    /* renamed from: io.branch.referral.network.BranchRemoteInterface$a */
    public static class C6031a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String f15622a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final int f15623b;

        public C6031a(String str, int i) {
            this.f15622a = str;
            this.f15623b = i;
        }
    }

    /* renamed from: a */
    public final C5996e0 mo33926a(String str, JSONObject jSONObject, String str2, String str3) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (!m19366a(jSONObject, str3)) {
            return new C5996e0(str2, -114);
        }
        String str4 = str + m19365a(jSONObject);
        long currentTimeMillis = System.currentTimeMillis();
        C6035q.m19397b("BranchSDK", "getting " + str4);
        try {
            C6031a a = mo33928a(str4);
            C5996e0 a2 = m19363a(a.f15622a, a.f15623b, str2);
            if (C3555b.m12034k() != null) {
                C3555b.m12034k().mo19636d(str2 + "-" + C6028l.Branch_Round_Trip_Time.mo33920a(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
            }
            return a2;
        } catch (BranchRemoteException e) {
            if (e.f15621a == -111) {
                C5996e0 e0Var = new C5996e0(str2, -111);
                if (C3555b.m12034k() != null) {
                    C3555b.m12034k().mo19636d(str2 + "-" + C6028l.Branch_Round_Trip_Time.mo33920a(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                }
                return e0Var;
            }
            C5996e0 e0Var2 = new C5996e0(str2, -113);
            if (C3555b.m12034k() != null) {
                C3555b.m12034k().mo19636d(str2 + "-" + C6028l.Branch_Round_Trip_Time.mo33920a(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
            }
            return e0Var2;
        } catch (Throwable th) {
            if (C3555b.m12034k() != null) {
                C3555b.m12034k().mo19636d(str2 + "-" + C6028l.Branch_Round_Trip_Time.mo33920a(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
            }
            throw th;
        }
    }

    /* renamed from: a */
    public abstract C6031a mo33928a(String str) throws BranchRemoteException;

    /* renamed from: a */
    public abstract C6031a mo33929a(String str, JSONObject jSONObject) throws BranchRemoteException;

    /* renamed from: a */
    public final C5996e0 mo33927a(JSONObject jSONObject, String str, String str2, String str3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (!m19366a(jSONObject, str3)) {
            return new C5996e0(str2, -114);
        }
        C6035q.m19397b("BranchSDK", "posting to " + str);
        C6035q.m19397b("BranchSDK", "Post value = " + jSONObject.toString());
        try {
            C6031a a = mo33929a(str, jSONObject);
            C5996e0 a2 = m19363a(a.f15622a, a.f15623b, str2);
            if (C3555b.m12034k() != null) {
                C3555b k = C3555b.m12034k();
                k.mo19636d(str2 + "-" + C6028l.Branch_Round_Trip_Time.mo33920a(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
            }
            return a2;
        } catch (BranchRemoteException e) {
            if (e.f15621a == -111) {
                C5996e0 e0Var = new C5996e0(str2, -111);
                if (C3555b.m12034k() != null) {
                    C3555b k2 = C3555b.m12034k();
                    k2.mo19636d(str2 + "-" + C6028l.Branch_Round_Trip_Time.mo33920a(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                }
                return e0Var;
            }
            C5996e0 e0Var2 = new C5996e0(str2, -113);
            if (C3555b.m12034k() != null) {
                C3555b k3 = C3555b.m12034k();
                k3.mo19636d(str2 + "-" + C6028l.Branch_Round_Trip_Time.mo33920a(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
            }
            return e0Var2;
        } catch (Throwable th) {
            if (C3555b.m12034k() != null) {
                C3555b k4 = C3555b.m12034k();
                k4.mo19636d(str2 + "-" + C6028l.Branch_Round_Trip_Time.mo33920a(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static final BranchRemoteInterface m19364a(Context context) {
        return new C6032a(context);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0026 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p118io.branch.referral.C5996e0 m19363a(java.lang.String r3, int r4, java.lang.String r5) {
        /*
            r2 = this;
            io.branch.referral.e0 r0 = new io.branch.referral.e0
            r0.<init>(r5, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "returned "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "BranchSDK"
            p118io.branch.referral.C6035q.m19397b((java.lang.String) r5, (java.lang.String) r4)
            if (r3 == 0) goto L_0x0050
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0026 }
            r4.<init>(r3)     // Catch:{ JSONException -> 0x0026 }
            r0.mo33851a(r4)     // Catch:{ JSONException -> 0x0026 }
            goto L_0x0050
        L_0x0026:
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x002f }
            r4.<init>(r3)     // Catch:{ JSONException -> 0x002f }
            r0.mo33851a(r4)     // Catch:{ JSONException -> 0x002f }
            goto L_0x0050
        L_0x002f:
            r3 = move-exception
            java.lang.Class r4 = r2.getClass()
            java.lang.String r4 = r4.getSimpleName()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = "JSON exception: "
            r5.append(r1)
            java.lang.String r3 = r3.getMessage()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            p118io.branch.referral.C6035q.m19397b((java.lang.String) r4, (java.lang.String) r3)
        L_0x0050:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.branch.referral.network.BranchRemoteInterface.m19363a(java.lang.String, int, java.lang.String):io.branch.referral.e0");
    }

    /* renamed from: a */
    private boolean m19366a(JSONObject jSONObject, String str) {
        try {
            if (!jSONObject.has(C6028l.UserData.mo33920a())) {
                jSONObject.put(C6028l.SDK.mo33920a(), "android2.19.5");
            }
            if (str.equals("bnc_no_value")) {
                return false;
            }
            jSONObject.put(C6028l.BranchKey.mo33920a(), str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private String m19365a(JSONObject jSONObject) {
        JSONArray names;
        StringBuilder sb = new StringBuilder();
        if (!(jSONObject == null || (names = jSONObject.names()) == null)) {
            int length = names.length();
            boolean z = true;
            int i = 0;
            while (i < length) {
                try {
                    String string = names.getString(i);
                    if (z) {
                        sb.append("?");
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    String string2 = jSONObject.getString(string);
                    sb.append(string);
                    sb.append("=");
                    sb.append(string2);
                    i++;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return sb.toString();
    }
}
