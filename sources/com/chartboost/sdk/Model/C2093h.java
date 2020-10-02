package com.chartboost.sdk.Model;

import com.chartboost.sdk.Libraries.C2072b;
import com.chartboost.sdk.impl.C2224x;
import com.qumpara.offerwall.sdk.core.QumparaOfferwallUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Model.h */
public class C2093h {

    /* renamed from: A */
    public final int f6996A;

    /* renamed from: B */
    public final boolean f6997B;

    /* renamed from: C */
    public final String f6998C;

    /* renamed from: D */
    public final String f6999D;

    /* renamed from: E */
    public final C2094a f7000E;

    /* renamed from: a */
    public final String f7001a;

    /* renamed from: b */
    public final boolean f7002b;

    /* renamed from: c */
    public final boolean f7003c;

    /* renamed from: d */
    public final List<String> f7004d;

    /* renamed from: e */
    public final boolean f7005e;

    /* renamed from: f */
    public final boolean f7006f;

    /* renamed from: g */
    public final boolean f7007g;

    /* renamed from: h */
    public final boolean f7008h;

    /* renamed from: i */
    public final int f7009i;

    /* renamed from: j */
    public final boolean f7010j;

    /* renamed from: k */
    public final boolean f7011k;

    /* renamed from: l */
    public final boolean f7012l;

    /* renamed from: m */
    public final boolean f7013m;

    /* renamed from: n */
    public final boolean f7014n;

    /* renamed from: o */
    public final boolean f7015o;

    /* renamed from: p */
    public final boolean f7016p;

    /* renamed from: q */
    public final long f7017q;

    /* renamed from: r */
    public final int f7018r;

    /* renamed from: s */
    public final int f7019s;

    /* renamed from: t */
    public final int f7020t;

    /* renamed from: u */
    public final int f7021u;

    /* renamed from: v */
    public final List<String> f7022v;

    /* renamed from: w */
    public final boolean f7023w;

    /* renamed from: x */
    public final boolean f7024x;

    /* renamed from: y */
    public final boolean f7025y;

    /* renamed from: z */
    public final boolean f7026z;

    public C2093h(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        this.f7001a = jSONObject2.optString("configVariant");
        this.f7002b = jSONObject2.optBoolean("prefetchDisable");
        this.f7003c = jSONObject2.optBoolean("publisherDisable");
        this.f7000E = C2094a.m8281a(jSONObject);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject2.optJSONArray("invalidateFolderList");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString = optJSONArray.optString(i);
                if (!optString.isEmpty()) {
                    arrayList.add(optString);
                }
            }
        }
        this.f7004d = Collections.unmodifiableList(arrayList);
        JSONObject optJSONObject = jSONObject2.optJSONObject("native");
        optJSONObject = optJSONObject == null ? new JSONObject() : optJSONObject;
        this.f7005e = optJSONObject.optBoolean("enabled", true);
        this.f7006f = optJSONObject.optBoolean("inplayEnabled", true);
        this.f7007g = optJSONObject.optBoolean("interstitialEnabled", true);
        this.f7008h = optJSONObject.optBoolean("lockOrientation");
        this.f7009i = optJSONObject.optInt("prefetchSession", 3);
        this.f7010j = optJSONObject.optBoolean("rewardVideoEnabled", true);
        JSONObject optJSONObject2 = jSONObject2.optJSONObject("trackingLevels");
        optJSONObject2 = optJSONObject2 == null ? new JSONObject() : optJSONObject2;
        this.f7011k = optJSONObject2.optBoolean("critical", true);
        this.f7016p = optJSONObject2.optBoolean("includeStackTrace", true);
        this.f7012l = optJSONObject2.optBoolean("error");
        optJSONObject2.optBoolean("debug");
        this.f7013m = optJSONObject2.optBoolean("session");
        this.f7014n = optJSONObject2.optBoolean("system");
        this.f7015o = optJSONObject2.optBoolean("timing");
        optJSONObject2.optBoolean(QumparaOfferwallUtil.TABLE_NAME);
        this.f7017q = jSONObject2.optLong("getAdRetryBaseMs", 200);
        this.f7018r = jSONObject2.optInt("getAdRetryMaxBackoffExponent", 3);
        JSONObject optJSONObject3 = jSONObject2.optJSONObject("webview");
        optJSONObject3 = optJSONObject3 == null ? new JSONObject() : optJSONObject3;
        this.f7019s = optJSONObject3.optInt("cacheMaxBytes", 104857600);
        int i2 = 10;
        int optInt = optJSONObject3.optInt("cacheMaxUnits", 10);
        this.f7020t = optInt > 0 ? optInt : i2;
        this.f7021u = (int) TimeUnit.SECONDS.toDays((long) optJSONObject3.optInt("cacheTTLs", C2072b.f6853a));
        ArrayList arrayList2 = new ArrayList();
        JSONArray optJSONArray2 = optJSONObject3.optJSONArray("directories");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                String optString2 = optJSONArray2.optString(i3);
                if (!optString2.isEmpty()) {
                    arrayList2.add(optString2);
                }
            }
        }
        this.f7022v = Collections.unmodifiableList(arrayList2);
        this.f7023w = optJSONObject3.optBoolean("enabled", m8279b());
        this.f7024x = optJSONObject3.optBoolean("inplayEnabled", true);
        this.f7025y = optJSONObject3.optBoolean("interstitialEnabled", true);
        optJSONObject3.optInt("invalidatePendingImpression", 3);
        this.f7026z = optJSONObject3.optBoolean("lockOrientation", true);
        this.f6996A = optJSONObject3.optInt("prefetchSession", 3);
        this.f6997B = optJSONObject3.optBoolean("rewardVideoEnabled", true);
        String optString3 = optJSONObject3.optString("version", "v2");
        this.f6998C = optString3;
        String.format("%s/%s%s", new Object[]{"webview", optString3, "/interstitial/get"});
        this.f6999D = String.format("%s/%s/%s", new Object[]{"webview", this.f6998C, "prefetch"});
        String.format("%s/%s%s", new Object[]{"webview", this.f6998C, "/reward/get"});
    }

    /* renamed from: b */
    private static boolean m8279b() {
        int[] iArr = {4, 4, 2};
        String c = C2224x.m8805e().mo9551c();
        if (c != null && c.length() > 0) {
            String[] split = c.replaceAll("[^\\d.]", "").split("\\.");
            int i = 0;
            while (i < split.length && i < 3) {
                try {
                    if (Integer.valueOf(split[i]).intValue() > iArr[i]) {
                        return true;
                    }
                    if (Integer.valueOf(split[i]).intValue() < iArr[i]) {
                        return false;
                    }
                    i++;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo9152a() {
        return this.f7003c;
    }

    /* renamed from: com.chartboost.sdk.Model.h$a */
    public static class C2094a {

        /* renamed from: a */
        private double f7027a;

        /* renamed from: b */
        private double f7028b;

        /* renamed from: c */
        private boolean f7029c;

        /* renamed from: a */
        public static C2094a m8281a(JSONObject jSONObject) {
            C2094a aVar = new C2094a();
            aVar.f7029c = jSONObject.optBoolean("bannerEnable", true);
            aVar.f7027a = jSONObject.optDouble("bannerRefreshInterval", 30.0d);
            aVar.f7028b = jSONObject.optDouble("bannerShowTimeout", 30.0d);
            return aVar;
        }

        /* renamed from: b */
        public double mo9154b() {
            return this.f7028b;
        }

        /* renamed from: c */
        public boolean mo9155c() {
            return this.f7029c;
        }

        /* renamed from: a */
        public double mo9153a() {
            return this.f7027a;
        }
    }
}
