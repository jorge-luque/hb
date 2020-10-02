package com.moat.analytics.mobile.ogury;

import android.graphics.Rect;
import android.view.View;
import com.moat.analytics.mobile.ogury.C4315e;
import com.moat.analytics.mobile.ogury.NativeDisplayTracker;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.ogury.t */
final class C4360t extends C4310c implements NativeDisplayTracker {

    /* renamed from: ʼ */
    private final Map<String, String> f11677;

    /* renamed from: ॱॱ */
    private final Set<NativeDisplayTracker.MoatUserInteractionType> f11678 = new HashSet();

    C4360t(View view, Map<String, String> map) {
        super(view, true, false);
        C4315e.C43161.m14442(3, "NativeDisplayTracker", this, "Initializing.");
        this.f11677 = map;
        if (view == null) {
            String concat = "NativeDisplayTracker initialization not successful, ".concat("Target view is null");
            C4315e.C43161.m14442(3, "NativeDisplayTracker", this, concat);
            C4315e.C43161.m14446("[ERROR] ", concat);
            this.f11498 = new C4332l("Target view is null");
        } else if (map == null || map.isEmpty()) {
            String concat2 = "NativeDisplayTracker initialization not successful, ".concat("AdIds is null or empty");
            C4315e.C43161.m14442(3, "NativeDisplayTracker", this, concat2);
            C4315e.C43161.m14446("[ERROR] ", concat2);
            this.f11498 = new C4332l("AdIds is null or empty");
        } else {
            C4311d dVar = ((C4328i) MoatAnalytics.getInstance()).f11579;
            if (dVar == null) {
                String concat3 = "NativeDisplayTracker initialization not successful, ".concat("prepareNativeDisplayTracking was not called successfully");
                C4315e.C43161.m14442(3, "NativeDisplayTracker", this, concat3);
                C4315e.C43161.m14446("[ERROR] ", concat3);
                this.f11498 = new C4332l("prepareNativeDisplayTracking was not called successfully");
                return;
            }
            this.f11496 = dVar.f11506;
            try {
                super.mo29113(dVar.f11507);
                if (this.f11496 != null) {
                    this.f11496.mo29145(m14585());
                }
                StringBuilder sb = new StringBuilder("NativeDisplayTracker created for ");
                sb.append(mo29108());
                sb.append(", with adIds:");
                sb.append(map.toString());
                C4315e.C43161.m14446("[SUCCESS] ", sb.toString());
            } catch (C4332l e) {
                this.f11498 = e;
            }
        }
    }

    /* renamed from: ʼ */
    private String m14584() {
        try {
            Rect r0 = C4362v.m14596(super.mo29118());
            int width = r0.width();
            int height = r0.height();
            HashMap hashMap = new HashMap();
            hashMap.put("width", Integer.toString(width));
            hashMap.put("height", Integer.toString(height));
            return new JSONObject(hashMap).toString();
        } catch (Exception e) {
            C4332l.m14509(e);
            return null;
        }
    }

    /* renamed from: ᐝ */
    private String m14585() {
        try {
            Map<String, String> map = this.f11677;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int i = 0; i < 8; i++) {
                String concat = "moatClientLevel".concat(String.valueOf(i));
                if (map.containsKey(concat)) {
                    linkedHashMap.put(concat, map.get(concat));
                }
            }
            for (int i2 = 0; i2 < 8; i2++) {
                String concat2 = "moatClientSlicer".concat(String.valueOf(i2));
                if (map.containsKey(concat2)) {
                    linkedHashMap.put(concat2, map.get(concat2));
                }
            }
            for (String next : map.keySet()) {
                if (!linkedHashMap.containsKey(next)) {
                    linkedHashMap.put(next, map.get(next));
                }
            }
            String obj = new JSONObject(linkedHashMap).toString();
            C4315e.C43161.m14442(3, "NativeDisplayTracker", this, "Parsed ad ids = ".concat(String.valueOf(obj)));
            StringBuilder sb = new StringBuilder("{\"adIds\":");
            sb.append(obj);
            sb.append(", \"adKey\":\"");
            sb.append(this.f11500);
            sb.append("\", \"adSize\":");
            sb.append(m14584());
            sb.append("}");
            return sb.toString();
        } catch (Exception e) {
            C4332l.m14509(e);
            return "";
        }
    }

    public final void reportUserInteractionEvent(NativeDisplayTracker.MoatUserInteractionType moatUserInteractionType) {
        try {
            StringBuilder sb = new StringBuilder("reportUserInteractionEvent:");
            sb.append(moatUserInteractionType.name());
            C4315e.C43161.m14442(3, "NativeDisplayTracker", this, sb.toString());
            if (!this.f11678.contains(moatUserInteractionType)) {
                this.f11678.add(moatUserInteractionType);
                JSONObject jSONObject = new JSONObject();
                jSONObject.accumulate("adKey", this.f11500);
                jSONObject.accumulate(TapjoyConstants.TJC_SDK_TYPE_DEFAULT, moatUserInteractionType.name().toLowerCase());
                if (this.f11496 != null) {
                    this.f11496.mo29142(jSONObject.toString());
                }
            }
        } catch (JSONException e) {
            C4315e.C43161.m14443("NativeDisplayTracker", this, "Got JSON exception");
            C4332l.m14509(e);
        } catch (Exception e2) {
            C4332l.m14509(e2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ */
    public final String mo29116() {
        return "NativeDisplayTracker";
    }
}
