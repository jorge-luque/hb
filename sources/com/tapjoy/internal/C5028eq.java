package com.tapjoy.internal;

import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TJAdUnitJSBridge;
import com.tapjoy.Tapjoy;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyCachedAssetData;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.eq */
public final class C5028eq {

    /* renamed from: b */
    public static String f13615b = "";

    /* renamed from: a */
    public TJAdUnitJSBridge f13616a;

    /* renamed from: c */
    public boolean f13617c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C4947cr f13618d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C4948cs f13619e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C4953cx f13620f = C4953cx.m16792a("Tapjoy", Tapjoy.getVersion());
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C4958dc f13621g;

    public C5028eq(TJAdUnitJSBridge tJAdUnitJSBridge) {
        this.f13616a = tJAdUnitJSBridge;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static List m16996b(JSONArray jSONArray) {
        C4954cy cyVar;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString(TJAdUnitConstants.String.VENDOR_JS_URL, (String) null);
                if (optString == null) {
                    TapjoyLog.m16649d("TJOMViewabilityAgent", "Vendor JS URL not found. Skipping.");
                } else {
                    try {
                        URL url = new URL(optString);
                        String optString2 = jSONObject.optString(TJAdUnitConstants.String.VENDOR_NAME, (String) null);
                        String optString3 = jSONObject.optString(TJAdUnitConstants.String.VENDOR_PARAMETERS, (String) null);
                        if (optString3 == null || optString2 == null) {
                            cyVar = C4954cy.m16794a(url);
                        } else {
                            cyVar = C4954cy.m16793a(optString2, url, optString3);
                        }
                        arrayList.add(cyVar);
                    } catch (Exception unused) {
                        TapjoyLog.m16649d("TJOMViewabilityAgent", "Malformed vendor JS URL. Skipping " + optString);
                    }
                }
            } catch (JSONException unused2) {
                TapjoyLog.m16649d("TJOMViewabilityAgent", "Malformed vendor object. Skipping.");
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final boolean mo31132a(JSONObject jSONObject) {
        TJAdUnitJSBridge tJAdUnitJSBridge = this.f13616a;
        if (tJAdUnitJSBridge.f12928b == null) {
            TapjoyLog.m16649d("TJOMViewabilityAgent", "Can not init -- WebView is null");
            return false;
        }
        TJAdUnit tJAdUnit = tJAdUnitJSBridge.f12927a;
        if (tJAdUnit == null) {
            TapjoyLog.m16649d("TJOMViewabilityAgent", "Can not init -- TJAdUnit is null");
            return false;
        } else if (tJAdUnit.getVideoView() == null) {
            TapjoyLog.m16649d("TJOMViewabilityAgent", "Can not init -- VideoView is null");
            return false;
        } else if (jSONObject == null) {
            TapjoyLog.m16649d("TJOMViewabilityAgent", "Can not init -- json parameter is null");
            return false;
        } else if (!jSONObject.has(TJAdUnitConstants.String.OM_JAVASCRIPT_URL)) {
            TapjoyLog.m16649d("TJOMViewabilityAgent", "Can not init -- unable to parse om javascript url from json");
            return false;
        } else {
            try {
                jSONObject.getJSONArray(TJAdUnitConstants.String.VENDORS);
                return true;
            } catch (JSONException unused) {
                TapjoyLog.m16649d("TJOMViewabilityAgent", "Can not init -- unable to parse vendors from json");
                return false;
            }
        }
    }

    /* renamed from: b */
    public static void m16997b(JSONObject jSONObject) {
        if (C4889al.m16672a(f13615b)) {
            String optString = jSONObject.optString(TJAdUnitConstants.String.OM_JAVASCRIPT_URL, (String) null);
            if (optString == null) {
                TapjoyLog.m16649d("TJOMViewabilityAgent", "Open Mediation JavaScript name not found in json.");
                return;
            }
            try {
                TapjoyCachedAssetData cachedDataForURL = TapjoyCache.getInstance().getCachedDataForURL(optString);
                String str = "";
                if (cachedDataForURL == null) {
                    TapjoyCache.getInstance().cacheAssetFromURL(optString, str, 30).get();
                    cachedDataForURL = TapjoyCache.getInstance().getCachedDataForURL(optString);
                }
                if (cachedDataForURL != null) {
                    str = TapjoyUtil.getFileContents(new File(cachedDataForURL.getLocalFilePath()));
                }
                f13615b = str;
            } catch (Exception unused) {
                TapjoyLog.m16649d("TJOMViewabilityAgent", "Failed downloading Open Mediation JavaScript");
            }
        }
    }
}
