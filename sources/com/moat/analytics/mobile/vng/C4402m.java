package com.moat.analytics.mobile.vng;

import android.os.Build;
import com.moat.analytics.mobile.vng.C4424w;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.vng.m */
class C4402m {

    /* renamed from: a */
    private boolean f11819a = false;

    /* renamed from: b */
    private boolean f11820b = false;

    /* renamed from: c */
    private boolean f11821c = false;

    /* renamed from: d */
    private int f11822d = 200;

    /* renamed from: e */
    private int f11823e = 10;

    C4402m(String str) {
        m14748a(str);
    }

    /* renamed from: a */
    private void m14748a(String str) {
        int i;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("sa");
                boolean equals = string.equals("fe5b19d82fecca4c1d668e2e40e2636224135a71");
                boolean equals2 = string.equals("8f1d08a2d6496191a5ebae8f0590f513e2619489");
                if ((string.equals(TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON) || equals || equals2) && !m14749a(jSONObject) && !m14750b(jSONObject)) {
                    this.f11819a = true;
                    this.f11820b = equals;
                    this.f11821c = equals2;
                    if (equals2) {
                        this.f11820b = true;
                    }
                }
                if (jSONObject.has("in") && (i = jSONObject.getInt("in")) >= 100 && i <= 1000) {
                    this.f11822d = i;
                }
                if (jSONObject.has("es")) {
                    this.f11823e = jSONObject.getInt("es");
                }
            } catch (Exception e) {
                this.f11819a = false;
                this.f11820b = false;
                this.f11822d = 200;
                C4403n.m14758a(e);
            }
        }
    }

    /* renamed from: a */
    private boolean m14749a(JSONObject jSONObject) {
        try {
            if (16 > Build.VERSION.SDK_INT) {
                return true;
            }
            if (jSONObject.has("ob")) {
                JSONArray jSONArray = jSONObject.getJSONArray("ob");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (jSONArray.getInt(i) == Build.VERSION.SDK_INT) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    /* renamed from: b */
    private boolean m14750b(JSONObject jSONObject) {
        try {
            if (jSONObject.has("ap")) {
                String b = C4412s.m14785c().mo29338b();
                JSONArray jSONArray = jSONObject.getJSONArray("ap");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (jSONArray.getString(i).contentEquals(b)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            C4403n.m14758a(e);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo29330a() {
        return this.f11820b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo29331b() {
        return this.f11821c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo29332c() {
        return this.f11822d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo29333d() {
        return this.f11823e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C4424w.C4432d mo29334e() {
        return this.f11819a ? C4424w.C4432d.ON : C4424w.C4432d.OFF;
    }
}
