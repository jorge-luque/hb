package com.moat.analytics.mobile.vng;

import android.graphics.Rect;
import android.view.View;
import com.moat.analytics.mobile.vng.NativeDisplayTracker;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.vng.t */
class C4416t extends C4377b implements NativeDisplayTracker {

    /* renamed from: g */
    private final Map<String, String> f11851g;

    /* renamed from: h */
    private final Set<NativeDisplayTracker.MoatUserInteractionType> f11852h = new HashSet();

    C4416t(View view, Map<String, String> map) {
        super(view, true, false);
        C4403n e;
        C4403n nVar;
        C4409p.m14772a(3, "NativeDisplayTracker", (Object) this, "Initializing.");
        this.f11851g = map;
        if (view == null) {
            C4409p.m14773a("[ERROR] ", 3, "NativeDisplayTracker", this, "NativeDisplayTracker initialization not successful, " + "Target view is null");
            nVar = new C4403n("Target view is null");
        } else {
            if (map == null || map.isEmpty()) {
                C4409p.m14773a("[ERROR] ", 3, "NativeDisplayTracker", this, "NativeDisplayTracker initialization not successful, " + "AdIds is null or empty");
                e = new C4403n("AdIds is null or empty");
            } else {
                C4383g gVar = ((C4400k) MoatAnalytics.getInstance()).f11809c;
                if (gVar == null) {
                    C4409p.m14773a("[ERROR] ", 3, "NativeDisplayTracker", this, "NativeDisplayTracker initialization not successful, " + "prepareNativeDisplayTracking was not called successfully");
                    nVar = new C4403n("prepareNativeDisplayTracking was not called successfully");
                } else {
                    super.mo29259a(gVar.f11746b);
                    try {
                        super.mo29258a(gVar.f11745a);
                        m14795i();
                        C4409p.m14775a("[SUCCESS] ", mo29257a() + " created for " + mo29268g() + ", with adIds:" + map.toString());
                        return;
                    } catch (C4403n e2) {
                        e = e2;
                    }
                }
            }
            this.f11720a = e;
            return;
        }
        this.f11720a = nVar;
    }

    /* renamed from: a */
    private static String m14794a(Map<String, String> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < 8; i++) {
            String str = "moatClientLevel" + i;
            if (map.containsKey(str)) {
                linkedHashMap.put(str, map.get(str));
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            String str2 = "moatClientSlicer" + i2;
            if (map.containsKey(str2)) {
                linkedHashMap.put(str2, map.get(str2));
            }
        }
        for (String next : map.keySet()) {
            if (!linkedHashMap.containsKey(next)) {
                linkedHashMap.put(next, map.get(next));
            }
        }
        return new JSONObject(linkedHashMap).toString();
    }

    /* renamed from: i */
    private void m14795i() {
        C4395j jVar = this.f11722c;
        if (jVar != null) {
            jVar.mo29314a(m14796j());
        }
    }

    /* renamed from: j */
    private String m14796j() {
        try {
            String a = m14794a(this.f11851g);
            C4409p.m14772a(3, "NativeDisplayTracker", (Object) this, "Parsed ad ids = " + a);
            return "{\"adIds\":" + a + ", \"adKey\":\"" + this.f11724e + "\", \"adSize\":" + m14797k() + "}";
        } catch (Exception e) {
            C4403n.m14758a(e);
            return "";
        }
    }

    /* renamed from: k */
    private String m14797k() {
        try {
            Rect a = C4439z.m14848a(super.mo29267f());
            int width = a.width();
            int height = a.height();
            HashMap hashMap = new HashMap();
            hashMap.put("width", Integer.toString(width));
            hashMap.put("height", Integer.toString(height));
            return new JSONObject(hashMap).toString();
        } catch (Exception e) {
            C4403n.m14758a(e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo29257a() {
        return "NativeDisplayTracker";
    }

    public void reportUserInteractionEvent(NativeDisplayTracker.MoatUserInteractionType moatUserInteractionType) {
        try {
            C4409p.m14772a(3, "NativeDisplayTracker", (Object) this, "reportUserInteractionEvent:" + moatUserInteractionType.name());
            if (!this.f11852h.contains(moatUserInteractionType)) {
                this.f11852h.add(moatUserInteractionType);
                JSONObject jSONObject = new JSONObject();
                jSONObject.accumulate("adKey", this.f11724e);
                jSONObject.accumulate(TapjoyConstants.TJC_SDK_TYPE_DEFAULT, moatUserInteractionType.name().toLowerCase());
                if (this.f11722c != null) {
                    this.f11722c.mo29318b(jSONObject.toString());
                }
            }
        } catch (JSONException e) {
            e = e;
            C4409p.m14776b(2, "NativeDisplayTracker", this, "Got JSON exception");
            C4403n.m14758a(e);
        } catch (Exception e2) {
            e = e2;
            C4403n.m14758a(e);
        }
    }
}
