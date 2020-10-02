package com.tapjoy.internal;

import android.os.Build;
import android.webkit.WebView;
import com.tapjoy.TapjoyConstants;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.ds */
public abstract class C4979ds {

    /* renamed from: a */
    public C4978dr f13514a = new C4978dr((WebView) null);

    /* renamed from: b */
    public C4947cr f13515b;

    /* renamed from: c */
    public C4958dc f13516c;

    /* renamed from: d */
    public int f13517d;

    /* renamed from: e */
    public long f13518e;

    /* renamed from: com.tapjoy.internal.ds$a */
    public enum C4980a {
        ;
        

        /* renamed from: a */
        public static final int f13519a = 1;

        /* renamed from: b */
        public static final int f13520b = 2;

        /* renamed from: c */
        public static final int f13521c = 3;

        static {
            f13522d = new int[]{1, 2, 3};
        }
    }

    public C4979ds() {
        mo31076d();
    }

    /* renamed from: a */
    public void mo31068a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo31070a(WebView webView) {
        this.f13514a = new C4978dr(webView);
    }

    /* renamed from: a */
    public final void mo31071a(C4955cz czVar, C4950cu cuVar) {
        String str = czVar.f13468f;
        JSONObject jSONObject = new JSONObject();
        C4972dm.m16845a(jSONObject, "environment", TapjoyConstants.TJC_APP_PLACEMENT);
        C4972dm.m16845a(jSONObject, "adSessionType", cuVar.f13448f);
        JSONObject jSONObject2 = new JSONObject();
        C4972dm.m16845a(jSONObject2, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        C4972dm.m16845a(jSONObject2, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        C4972dm.m16845a(jSONObject2, "os", "Android");
        C4972dm.m16845a(jSONObject, "deviceInfo", jSONObject2);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        C4972dm.m16845a(jSONObject, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        C4972dm.m16845a(jSONObject3, "partnerName", cuVar.f13443a.f13458a);
        C4972dm.m16845a(jSONObject3, "partnerVersion", cuVar.f13443a.f13459b);
        C4972dm.m16845a(jSONObject, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        C4972dm.m16845a(jSONObject4, "libraryVersion", "1.2.19-Tapjoy");
        C4972dm.m16845a(jSONObject4, "appId", C4963df.m16824a().f13494a.getApplicationContext().getPackageName());
        C4972dm.m16845a(jSONObject, TapjoyConstants.TJC_APP_PLACEMENT, jSONObject4);
        String str2 = cuVar.f13447e;
        if (str2 != null) {
            C4972dm.m16845a(jSONObject, "customReferenceData", str2);
        }
        JSONObject jSONObject5 = new JSONObject();
        for (C4954cy cyVar : Collections.unmodifiableList(cuVar.f13445c)) {
            C4972dm.m16845a(jSONObject5, cyVar.f13460a, cyVar.f13462c);
        }
        C4964dg.m16825a().mo31062a(mo31075c(), "startSession", str, jSONObject, jSONObject5);
    }

    /* renamed from: a */
    public final void mo31072a(String str) {
        C4964dg.m16825a().mo31061a(mo31075c(), str, (JSONObject) null);
    }

    /* renamed from: a */
    public final void mo31073a(String str, JSONObject jSONObject) {
        C4964dg.m16825a().mo31061a(mo31075c(), str, jSONObject);
    }

    /* renamed from: b */
    public void mo31074b() {
        this.f13514a.clear();
    }

    /* renamed from: c */
    public final WebView mo31075c() {
        return (WebView) this.f13514a.get();
    }

    /* renamed from: d */
    public final void mo31076d() {
        this.f13518e = System.nanoTime();
        this.f13517d = C4980a.f13519a;
    }

    /* renamed from: a */
    public final void mo31069a(float f) {
        C4964dg.m16825a().mo31062a(mo31075c(), "setDeviceVolume", Float.valueOf(f));
    }
}
