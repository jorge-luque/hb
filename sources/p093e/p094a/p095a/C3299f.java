package p093e.p094a.p095a;

import admost.sdk.base.AdMostExperimentManager;
import com.tapjoy.TapjoyConstants;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import org.json.JSONObject;

/* renamed from: e.a.a.f */
/* compiled from: AdjustAttribution */
public class C3299f implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public String f9175a;

    /* renamed from: b */
    public String f9176b;

    /* renamed from: c */
    public String f9177c;

    /* renamed from: d */
    public String f9178d;

    /* renamed from: e */
    public String f9179e;

    /* renamed from: f */
    public String f9180f;

    /* renamed from: g */
    public String f9181g;

    /* renamed from: h */
    public String f9182h;

    static {
        Class<String> cls = String.class;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("trackerToken", cls), new ObjectStreamField("trackerName", cls), new ObjectStreamField(AdMostExperimentManager.TYPE_NETWORK, cls), new ObjectStreamField("campaign", cls), new ObjectStreamField("adgroup", cls), new ObjectStreamField(VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE, cls), new ObjectStreamField("clickLabel", cls), new ObjectStreamField("adid", cls)};
    }

    /* renamed from: a */
    public static C3299f m10964a(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return null;
        }
        C3299f fVar = new C3299f();
        if (TapjoyConstants.TJC_PLUGIN_UNITY.equals(str2)) {
            fVar.f9175a = jSONObject.optString("tracker_token", "");
            fVar.f9176b = jSONObject.optString("tracker_name", "");
            fVar.f9177c = jSONObject.optString(AdMostExperimentManager.TYPE_NETWORK, "");
            fVar.f9178d = jSONObject.optString("campaign", "");
            fVar.f9179e = jSONObject.optString("adgroup", "");
            fVar.f9180f = jSONObject.optString(VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE, "");
            fVar.f9181g = jSONObject.optString("click_label", "");
            if (str == null) {
                str = "";
            }
            fVar.f9182h = str;
        } else {
            fVar.f9175a = jSONObject.optString("tracker_token", (String) null);
            fVar.f9176b = jSONObject.optString("tracker_name", (String) null);
            fVar.f9177c = jSONObject.optString(AdMostExperimentManager.TYPE_NETWORK, (String) null);
            fVar.f9178d = jSONObject.optString("campaign", (String) null);
            fVar.f9179e = jSONObject.optString("adgroup", (String) null);
            fVar.f9180f = jSONObject.optString(VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE, (String) null);
            fVar.f9181g = jSONObject.optString("click_label", (String) null);
            fVar.f9182h = str;
        }
        return fVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || C3299f.class != obj.getClass()) {
            return false;
        }
        C3299f fVar = (C3299f) obj;
        return C3268a1.m10848a(this.f9175a, fVar.f9175a) && C3268a1.m10848a(this.f9176b, fVar.f9176b) && C3268a1.m10848a(this.f9177c, fVar.f9177c) && C3268a1.m10848a(this.f9178d, fVar.f9178d) && C3268a1.m10848a(this.f9179e, fVar.f9179e) && C3268a1.m10848a(this.f9180f, fVar.f9180f) && C3268a1.m10848a(this.f9181g, fVar.f9181g) && C3268a1.m10848a(this.f9182h, fVar.f9182h);
    }

    public int hashCode() {
        return ((((((((((((((629 + C3268a1.m10856c(this.f9175a)) * 37) + C3268a1.m10856c(this.f9176b)) * 37) + C3268a1.m10856c(this.f9177c)) * 37) + C3268a1.m10856c(this.f9178d)) * 37) + C3268a1.m10856c(this.f9179e)) * 37) + C3268a1.m10856c(this.f9180f)) * 37) + C3268a1.m10856c(this.f9181g)) * 37) + C3268a1.m10856c(this.f9182h);
    }

    public String toString() {
        return C3268a1.m10834a("tt:%s tn:%s net:%s cam:%s adg:%s cre:%s cl:%s adid:%s", this.f9175a, this.f9176b, this.f9177c, this.f9178d, this.f9179e, this.f9180f, this.f9181g, this.f9182h);
    }
}
