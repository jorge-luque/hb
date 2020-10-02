package p093e.p094a.p095a;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: e.a.a.h */
/* compiled from: AdjustEvent */
public class C3303h {

    /* renamed from: h */
    private static C3364y f9222h = C3309k.m11002d();

    /* renamed from: a */
    String f9223a;

    /* renamed from: b */
    Double f9224b;

    /* renamed from: c */
    String f9225c;

    /* renamed from: d */
    Map<String, String> f9226d;

    /* renamed from: e */
    Map<String, String> f9227e;

    /* renamed from: f */
    String f9228f;

    /* renamed from: g */
    String f9229g;

    public C3303h(String str) {
        if (m10982a(str, f9222h)) {
            this.f9223a = str;
        }
    }

    /* renamed from: a */
    public void mo19026a(double d, String str) {
        if (m10981a(Double.valueOf(d), str)) {
            this.f9224b = Double.valueOf(d);
            this.f9225c = str;
        }
    }

    /* renamed from: a */
    public void mo19028a(String str, String str2) {
        if (C3268a1.m10849a(str, "key", "Partner") && C3268a1.m10849a(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE, "Partner")) {
            if (this.f9227e == null) {
                this.f9227e = new LinkedHashMap();
            }
            if (this.f9227e.put(str, str2) != null) {
                f9222h.mo19021b("Key %s was overwritten", str);
            }
        }
    }

    /* renamed from: a */
    public void mo19027a(String str) {
        this.f9228f = str;
    }

    /* renamed from: a */
    public boolean mo19029a() {
        return this.f9223a != null;
    }

    /* renamed from: a */
    private static boolean m10982a(String str, C3364y yVar) {
        if (str == null) {
            yVar.mo19022c("Missing Event Token", new Object[0]);
            return false;
        } else if (str.length() == 6) {
            return true;
        } else {
            yVar.mo19022c("Malformed Event Token '%s'", str);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m10981a(Double d, String str) {
        if (d != null) {
            if (d.doubleValue() < 0.0d) {
                f9222h.mo19022c("Invalid amount %.5f", d);
                return false;
            } else if (str == null) {
                f9222h.mo19022c("Currency must be set with revenue", new Object[0]);
                return false;
            } else if (str.equals("")) {
                f9222h.mo19022c("Currency is empty", new Object[0]);
                return false;
            }
        } else if (str != null) {
            f9222h.mo19022c("Revenue must be set with currency", new Object[0]);
            return false;
        }
        return true;
    }
}
