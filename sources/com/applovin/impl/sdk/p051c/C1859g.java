package com.applovin.impl.sdk.p051c;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.applovin.impl.sdk.c.g */
public class C1859g {

    /* renamed from: a */
    public static final C1859g f6186a = m7154a("ad_req");

    /* renamed from: b */
    public static final C1859g f6187b = m7154a("ad_imp");

    /* renamed from: c */
    public static final C1859g f6188c = m7154a("ad_session_start");

    /* renamed from: d */
    public static final C1859g f6189d = m7154a("ad_imp_session");

    /* renamed from: e */
    public static final C1859g f6190e = m7154a("cached_files_expired");

    /* renamed from: f */
    public static final C1859g f6191f = m7154a("cache_drop_count");

    /* renamed from: g */
    public static final C1859g f6192g = m7155a("sdk_reset_state_count", true);

    /* renamed from: h */
    public static final C1859g f6193h = m7155a("ad_response_process_failures", true);

    /* renamed from: i */
    public static final C1859g f6194i = m7155a("response_process_failures", true);

    /* renamed from: j */
    public static final C1859g f6195j = m7155a("incent_failed_to_display_count", true);

    /* renamed from: k */
    public static final C1859g f6196k = m7154a("app_paused_and_resumed");

    /* renamed from: l */
    public static final C1859g f6197l = m7155a("ad_rendered_with_mismatched_sdk_key", true);

    /* renamed from: m */
    public static final C1859g f6198m = m7154a("ad_shown_outside_app_count");

    /* renamed from: n */
    public static final C1859g f6199n = m7154a("med_ad_req");

    /* renamed from: o */
    public static final C1859g f6200o = m7155a("med_ad_response_process_failures", true);

    /* renamed from: p */
    public static final C1859g f6201p = m7155a("med_adapters_failed_init_missing_activity", true);

    /* renamed from: q */
    public static final C1859g f6202q = m7155a("med_waterfall_ad_no_fill", true);

    /* renamed from: r */
    public static final C1859g f6203r = m7155a("med_waterfall_ad_adapter_load_failed", true);

    /* renamed from: s */
    public static final C1859g f6204s = m7155a("med_waterfall_ad_invalid_response", true);

    /* renamed from: t */
    private static final Set<String> f6205t = new HashSet(32);

    /* renamed from: v */
    private static final Set<C1859g> f6206v = new HashSet(16);

    /* renamed from: u */
    private final String f6207u;

    static {
        m7154a("fullscreen_ad_nil_vc_count");
        m7154a("applovin_bundle_missing");
    }

    private C1859g(String str) {
        this.f6207u = str;
    }

    /* renamed from: a */
    private static C1859g m7154a(String str) {
        return m7155a(str, false);
    }

    /* renamed from: a */
    private static C1859g m7155a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No key name specified");
        } else if (!f6205t.contains(str)) {
            f6205t.add(str);
            C1859g gVar = new C1859g(str);
            if (z) {
                f6206v.add(gVar);
            }
            return gVar;
        } else {
            throw new IllegalArgumentException("Key has already been used: " + str);
        }
    }

    /* renamed from: b */
    public static Set<C1859g> m7156b() {
        return f6206v;
    }

    /* renamed from: a */
    public String mo8386a() {
        return this.f6207u;
    }
}
