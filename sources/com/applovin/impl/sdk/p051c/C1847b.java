package com.applovin.impl.sdk.p051c;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.c.b */
public class C1847b {

    /* renamed from: A */
    public static final C1847b f6120A = m7089a("wvhec", "WEB_VIEW_HTTP_ERROR_COUNT");

    /* renamed from: B */
    public static final C1847b f6121B = m7089a("wvrec", "WEB_VIEW_RENDER_ERROR_COUNT");

    /* renamed from: C */
    public static final C1847b f6122C = m7089a("wvsem", "WEB_VIEW_SSL_ERROR_MESSAGES");

    /* renamed from: D */
    public static final C1847b f6123D = m7089a("wvruc", "WEB_VIEW_RENDERER_UNRESPONSIVE_COUNT");

    /* renamed from: G */
    private static final Set<String> f6124G = new HashSet(32);

    /* renamed from: a */
    static final C1847b f6125a = m7089a("sas", "AD_SOURCE");

    /* renamed from: b */
    static final C1847b f6126b = m7089a("srt", "AD_RENDER_TIME");

    /* renamed from: c */
    static final C1847b f6127c = m7089a("sft", "AD_FETCH_TIME");

    /* renamed from: d */
    static final C1847b f6128d = m7089a("sfs", "AD_FETCH_SIZE");

    /* renamed from: e */
    static final C1847b f6129e = m7089a("sadb", "AD_DOWNLOADED_BYTES");

    /* renamed from: f */
    static final C1847b f6130f = m7089a("sacb", "AD_CACHED_BYTES");

    /* renamed from: g */
    static final C1847b f6131g = m7089a("stdl", "TIME_TO_DISPLAY_FROM_LOAD");

    /* renamed from: h */
    static final C1847b f6132h = m7089a("stdi", "TIME_TO_DISPLAY_FROM_INIT");

    /* renamed from: i */
    static final C1847b f6133i = m7089a("snas", "AD_NUMBER_IN_SESSION");

    /* renamed from: j */
    static final C1847b f6134j = m7089a("snat", "AD_NUMBER_TOTAL");

    /* renamed from: k */
    static final C1847b f6135k = m7089a("stah", "TIME_AD_HIDDEN_FROM_SHOW");

    /* renamed from: l */
    static final C1847b f6136l = m7089a("stas", "TIME_TO_SKIP_FROM_SHOW");

    /* renamed from: m */
    static final C1847b f6137m = m7089a("stac", "TIME_TO_CLICK_FROM_SHOW");

    /* renamed from: n */
    static final C1847b f6138n = m7089a("stbe", "TIME_TO_EXPAND_FROM_SHOW");

    /* renamed from: o */
    static final C1847b f6139o = m7089a("stbc", "TIME_TO_CONTRACT_FROM_SHOW");

    /* renamed from: p */
    static final C1847b f6140p = m7089a("saan", "AD_SHOWN_WITH_ACTIVE_NETWORK");

    /* renamed from: q */
    static final C1847b f6141q = m7089a("suvs", "INTERSTITIAL_USED_VIDEO_STREAM");

    /* renamed from: r */
    static final C1847b f6142r = m7089a("sugs", "AD_USED_GRAPHIC_STREAM");

    /* renamed from: s */
    static final C1847b f6143s = m7089a("svpv", "INTERSTITIAL_VIDEO_PERCENT_VIEWED");

    /* renamed from: t */
    static final C1847b f6144t = m7089a("stpd", "INTERSTITIAL_PAUSED_DURATION");

    /* renamed from: u */
    static final C1847b f6145u = m7089a("shsc", "HTML_RESOURCE_CACHE_SUCCESS_COUNT");

    /* renamed from: v */
    static final C1847b f6146v = m7089a("shfc", "HTML_RESOURCE_CACHE_FAILURE_COUNT");

    /* renamed from: w */
    static final C1847b f6147w = m7089a("schc", "AD_CANCELLED_HTML_CACHING");

    /* renamed from: x */
    static final C1847b f6148x = m7089a("smwm", "AD_SHOWN_IN_MULTIWINDOW_MODE");

    /* renamed from: y */
    static final C1847b f6149y = m7089a("vssc", "VIDEO_STREAM_STALLED_COUNT");

    /* renamed from: z */
    public static final C1847b f6150z = m7089a("wvem", "WEB_VIEW_ERROR_MESSAGES");

    /* renamed from: E */
    private final String f6151E;

    /* renamed from: F */
    private final String f6152F;

    static {
        m7089a("sisw", "IS_STREAMING_WEBKIT");
        m7089a("surw", "UNABLE_TO_RETRIEVE_WEBKIT_HTML_STRING");
        m7089a("surp", "UNABLE_TO_PERSIST_WEBKIT_HTML_PLACEMENT_REPLACED_STRING");
        m7089a("swhp", "SUCCESSFULLY_PERSISTED_WEBKIT_HTML_STRING");
        m7089a("skr", "STOREKIT_REDIRECTED");
        m7089a("sklf", "STOREKIT_LOAD_FAILURE");
        m7089a("skps", "STOREKIT_PRELOAD_SKIPPED");
    }

    private C1847b(String str, String str2) {
        this.f6151E = str;
        this.f6152F = str2;
    }

    /* renamed from: a */
    private static C1847b m7089a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No key name specified");
        } else if (f6124G.contains(str)) {
            throw new IllegalArgumentException("Key has already been used: " + str);
        } else if (!TextUtils.isEmpty(str2)) {
            f6124G.add(str);
            return new C1847b(str, str2);
        } else {
            throw new IllegalArgumentException("No debug name specified");
        }
    }

    /* renamed from: a */
    public String mo8344a() {
        return this.f6151E;
    }

    /* renamed from: b */
    public String mo8345b() {
        return this.f6152F;
    }
}
