package com.onesignal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.onesignal.i1 */
/* compiled from: OSTrigger */
class C4523i1 {

    /* renamed from: a */
    String f12352a;

    /* renamed from: b */
    public C4524a f12353b;

    /* renamed from: c */
    public String f12354c;

    /* renamed from: d */
    public C4525b f12355d;

    /* renamed from: e */
    public Object f12356e;

    /* renamed from: com.onesignal.i1$a */
    /* compiled from: OSTrigger */
    public enum C4524a {
        TIME_SINCE_LAST_IN_APP("min_time_since"),
        SESSION_TIME("session_time"),
        CUSTOM("custom"),
        UNKNOWN("unknown");
        

        /* renamed from: a */
        private String f12362a;

        private C4524a(String str) {
            this.f12362a = str;
        }

        /* renamed from: a */
        public static C4524a[] m15564a() {
            return (C4524a[]) f12361f.clone();
        }

        public String toString() {
            return this.f12362a;
        }

        /* renamed from: a */
        public static C4524a m15563a(String str) {
            for (C4524a aVar : m15564a()) {
                if (aVar.f12362a.equalsIgnoreCase(str)) {
                    return aVar;
                }
            }
            return UNKNOWN;
        }
    }

    C4523i1(JSONObject jSONObject) throws JSONException {
        this.f12352a = jSONObject.getString("id");
        this.f12353b = C4524a.m15563a(jSONObject.getString("kind"));
        this.f12354c = jSONObject.optString("property", (String) null);
        this.f12355d = C4525b.m15565a(jSONObject.getString("operator"));
        this.f12356e = jSONObject.opt(AppMeasurementSdk.ConditionalUserProperty.VALUE);
    }

    public String toString() {
        return "OSTrigger{triggerId='" + this.f12352a + '\'' + ", kind=" + this.f12353b + ", property='" + this.f12354c + '\'' + ", operatorType=" + this.f12355d + ", value=" + this.f12356e + '}';
    }

    /* renamed from: com.onesignal.i1$b */
    /* compiled from: OSTrigger */
    public enum C4525b {
        GREATER_THAN("greater"),
        LESS_THAN("less"),
        EQUAL_TO("equal"),
        NOT_EQUAL_TO("not_equal"),
        LESS_THAN_OR_EQUAL_TO("less_or_equal"),
        GREATER_THAN_OR_EQUAL_TO("greater_or_equal"),
        EXISTS("exists"),
        NOT_EXISTS("not_exists"),
        CONTAINS("in");
        

        /* renamed from: a */
        private String f12373a;

        private C4525b(String str) {
            this.f12373a = str;
        }

        /* renamed from: a */
        public static C4525b m15565a(String str) {
            for (C4525b bVar : m15566b()) {
                if (bVar.f12373a.equalsIgnoreCase(str)) {
                    return bVar;
                }
            }
            return EQUAL_TO;
        }

        /* renamed from: b */
        public static C4525b[] m15566b() {
            return (C4525b[]) f12372k.clone();
        }

        public String toString() {
            return this.f12373a;
        }

        /* renamed from: a */
        public boolean mo29787a() {
            return this == EQUAL_TO || this == NOT_EQUAL_TO;
        }
    }
}
