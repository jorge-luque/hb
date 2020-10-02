package com.chartboost.sdk.Model;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tapjoy.TJAdUnitConstants;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Model.a */
public class C2086a {

    /* renamed from: a */
    public final JSONObject f6895a;

    /* renamed from: b */
    public int f6896b;

    /* renamed from: c */
    public final Map<String, C2087b> f6897c;

    /* renamed from: d */
    public final Map<String, String> f6898d;

    /* renamed from: e */
    public final String f6899e;

    /* renamed from: f */
    public String f6900f;

    /* renamed from: g */
    public String f6901g;

    /* renamed from: h */
    public String f6902h;

    /* renamed from: i */
    public final String f6903i;

    /* renamed from: j */
    public final String f6904j;

    /* renamed from: k */
    public final int f6905k;

    /* renamed from: l */
    public final String f6906l;

    /* renamed from: m */
    public final String f6907m;

    /* renamed from: n */
    public final Map<String, List<String>> f6908n;

    /* renamed from: o */
    public final int f6909o;

    /* renamed from: p */
    public String f6910p;

    /* renamed from: q */
    public final String f6911q;

    /* renamed from: r */
    public C2087b f6912r;

    /* renamed from: s */
    public final HashSet<String> f6913s;

    public C2086a() {
        this.f6895a = null;
        this.f6896b = 1;
        this.f6897c = new HashMap();
        this.f6898d = new HashMap();
        this.f6899e = "dummy_template";
        this.f6900f = "";
        this.f6901g = "";
        this.f6902h = "";
        this.f6903i = "";
        this.f6904j = "";
        this.f6905k = 0;
        this.f6906l = "";
        this.f6907m = "";
        this.f6908n = new HashMap();
        this.f6909o = 0;
        this.f6910p = "";
        this.f6911q = "";
        this.f6912r = new C2087b("", "", "");
        this.f6913s = new HashSet<>();
    }

    public C2086a(int i, JSONObject jSONObject, boolean z) throws JSONException {
        String str;
        this.f6896b = i;
        this.f6895a = jSONObject;
        this.f6900f = jSONObject.getString("ad_id");
        this.f6901g = jSONObject.getString("cgn");
        this.f6902h = jSONObject.getString(VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE);
        this.f6903i = jSONObject.optString("deep-link");
        this.f6904j = jSONObject.getString("link");
        this.f6907m = jSONObject.getString("to");
        this.f6909o = jSONObject.optInt(TJAdUnitConstants.String.SPLIT_VIEW_ANIMATION);
        this.f6910p = jSONObject.optString("media-type");
        this.f6911q = jSONObject.optString("name");
        this.f6897c = new HashMap();
        this.f6898d = new HashMap();
        this.f6908n = new HashMap();
        this.f6913s = new HashSet<>();
        String str2 = "";
        if (i == 1) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("webview");
            JSONArray jSONArray = jSONObject2.getJSONArray(MessengerShareContentUtility.ELEMENTS);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                str = "body";
                if (i2 >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                String string = jSONObject3.getString("name");
                String optString = jSONObject3.optString("param");
                String string2 = jSONObject3.getString("type");
                String string3 = jSONObject3.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                if (string2.equals("param")) {
                    this.f6898d.put(optString, string3);
                    if (string.equals("reward_amount")) {
                        i3 = Integer.valueOf(string3).intValue();
                    } else if (string.equals("reward_currency")) {
                        str2 = string3;
                    }
                } else {
                    this.f6897c.put((!string2.equals(TJAdUnitConstants.String.HTML) || !optString.isEmpty()) ? optString.isEmpty() ? string : optString : str, new C2087b(string2, string, string3));
                }
                i2++;
            }
            this.f6905k = i3;
            this.f6906l = str2;
            C2087b bVar = this.f6897c.get(str);
            this.f6912r = bVar;
            if (bVar != null) {
                this.f6899e = jSONObject2.getString("template");
                JSONObject optJSONObject = jSONObject.optJSONObject("events");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray jSONArray2 = optJSONObject.getJSONArray(next);
                        ArrayList arrayList = new ArrayList();
                        for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                            arrayList.add(jSONArray2.getString(i4));
                        }
                        this.f6908n.put(next, arrayList);
                    }
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("certification_providers");
                if (optJSONArray != null) {
                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                        this.f6913s.add(optJSONArray.getString(i5));
                    }
                    return;
                }
                return;
            }
            throw new RuntimeException("WebView AdUnit does not have a template html body asset");
        }
        if (z) {
            String string4 = jSONObject.getJSONObject("icons").getString("lg");
            this.f6897c.put("lg", new C2087b("inPlayIcons", string4.substring(string4.lastIndexOf("/") + 1), string4));
            this.f6905k = 0;
            this.f6906l = str2;
        } else {
            JSONObject jSONObject4 = jSONObject.getJSONObject("assets");
            Iterator<String> keys2 = jSONObject4.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                JSONObject jSONObject5 = jSONObject4.getJSONObject(next2);
                String str3 = (next2.equals("video-portrait") || next2.equals("video-landscape")) ? "videos" : "images";
                String optString2 = jSONObject5.optString("id", (String) null);
                if (optString2 == null) {
                    optString2 = jSONObject5.getString("checksum") + ".png";
                }
                this.f6897c.put(next2, new C2087b(str3, optString2, jSONObject5.getString("url")));
            }
            this.f6905k = jSONObject.optInt("reward");
            this.f6906l = jSONObject.optString("currency-name");
        }
        this.f6912r = null;
        this.f6899e = str2;
    }
}
