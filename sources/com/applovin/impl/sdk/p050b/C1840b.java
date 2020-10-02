package com.applovin.impl.sdk.p050b;

import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.b.b */
public class C1840b<T> extends C1841c<T> {

    /* renamed from: A */
    public static final C1841c<Long> f5748A = C1841c.m7035a("ad_view_refresh_precache_request_delay_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(2)));

    /* renamed from: B */
    public static final C1841c<Boolean> f5749B = C1841c.m7035a("ad_view_block_publisher_load_if_refresh_scheduled", true);

    /* renamed from: C */
    public static final C1841c<Boolean> f5750C = C1841c.m7035a("fullscreen_ads_block_publisher_load_if_another_showing", true);

    /* renamed from: D */
    public static final C1841c<Boolean> f5751D = C1841c.m7035a("fabsina", false);

    /* renamed from: E */
    public static final C1841c<Long> f5752E = C1841c.m7035a("ad_expiration_ms", Long.valueOf(TimeUnit.HOURS.toMillis(4)));

    /* renamed from: F */
    public static final C1841c<Boolean> f5753F = C1841c.m7035a("saewib", false);

    /* renamed from: G */
    public static final C1841c<Long> f5754G = C1841c.m7035a("ad_hidden_timeout_ms", -1L);

    /* renamed from: H */
    public static final C1841c<Boolean> f5755H = C1841c.m7035a("schedule_ad_hidden_on_ad_dismiss", false);

    /* renamed from: I */
    public static final C1841c<Long> f5756I = C1841c.m7035a("ad_hidden_on_ad_dismiss_callback_delay_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));

    /* renamed from: J */
    public static final C1841c<Boolean> f5757J = C1841c.m7035a("proe", false);

    /* renamed from: K */
    public static final C1841c<Integer> f5758K = C1841c.m7035a("mute_state", 2);

    /* renamed from: L */
    public static final C1841c<Boolean> f5759L = C1841c.m7035a("adapters_to_re_fetch_sdk_version_if_empty", true);

    /* renamed from: M */
    public static final C1841c<String> f5760M = C1841c.m7035a("saf", "");

    /* renamed from: N */
    public static final C1841c<Integer> f5761N = C1841c.m7035a("mra", -1);

    /* renamed from: O */
    public static final C1841c<Boolean> f5762O = C1841c.m7035a("pmp", false);

    /* renamed from: a */
    public static final C1841c<String> f5763a = C1841c.m7035a("afi", "");

    /* renamed from: b */
    public static final C1841c<Long> f5764b = C1841c.m7035a("afi_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(5)));

    /* renamed from: c */
    public static final C1841c<String> f5765c = C1841c.m7035a("mediation_endpoint", "https://ms.applovin.com/");

    /* renamed from: d */
    public static final C1841c<String> f5766d = C1841c.m7035a("mediation_backup_endpoint", "https://ms.applvn.com/");

    /* renamed from: e */
    public static final C1841c<Long> f5767e = C1841c.m7035a("fetch_next_ad_retry_delay_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(2)));

    /* renamed from: f */
    public static final C1841c<Long> f5768f = C1841c.m7035a("fetch_next_ad_timeout_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(5)));

    /* renamed from: g */
    public static final C1841c<Long> f5769g = C1841c.m7035a("fetch_mediation_debugger_info_timeout_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(7)));

    /* renamed from: h */
    public static final C1841c<String> f5770h = C1841c.m7035a("postback_macros", "{\"{MCODE}\":\"mcode\",\"{BCODE}\":\"bcode\",\"{ICODE}\":\"icode\",\"{SCODE}\":\"scode\"}");

    /* renamed from: i */
    public static final C1841c<Boolean> f5771i = C1841c.m7035a("persistent_mediated_postbacks", false);

    /* renamed from: j */
    public static final C1841c<Long> f5772j = C1841c.m7035a("max_signal_provider_latency_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: k */
    public static final C1841c<Integer> f5773k = C1841c.m7035a("max_adapter_version_length", 20);

    /* renamed from: l */
    public static final C1841c<Integer> f5774l = C1841c.m7035a("max_adapter_sdk_version_length", 20);

    /* renamed from: m */
    public static final C1841c<Integer> f5775m = C1841c.m7035a("max_adapter_signal_length", 5120);

    /* renamed from: n */
    public static final C1841c<Long> f5776n = C1841c.m7035a("default_adapter_timeout_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: o */
    public static final C1841c<Long> f5777o = C1841c.m7035a("ad_refresh_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: p */
    public static final C1841c<Long> f5778p = C1841c.m7035a("ad_load_failure_refresh_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: q */
    public static final C1841c<String> f5779q = C1841c.m7035a("ad_load_failure_refresh_ignore_error_codes", "204");

    /* renamed from: r */
    public static final C1841c<Long> f5780r = C1841c.m7035a("refresh_ad_on_app_resume_elapsed_threshold_ms", 0L);

    /* renamed from: s */
    public static final C1841c<Boolean> f5781s = C1841c.m7035a("refresh_ad_view_timer_responds_to_background", true);

    /* renamed from: t */
    public static final C1841c<Boolean> f5782t = C1841c.m7035a("refresh_ad_view_timer_responds_to_store_kit", true);

    /* renamed from: u */
    public static final C1841c<Boolean> f5783u = C1841c.m7035a("refresh_ad_view_timer_responds_to_window_visibility_changed", false);

    /* renamed from: v */
    public static final C1841c<Long> f5784v = C1841c.m7035a("ad_view_fade_in_animation_ms", 150L);

    /* renamed from: w */
    public static final C1841c<Long> f5785w = C1841c.m7035a("ad_view_fade_out_animation_ms", 150L);

    /* renamed from: x */
    public static final C1841c<Long> f5786x = C1841c.m7035a("fullscreen_display_delay_ms", 600L);

    /* renamed from: y */
    public static final C1841c<Long> f5787y = C1841c.m7035a("ahdm", 500L);

    /* renamed from: z */
    public static final C1841c<Long> f5788z = C1841c.m7035a("ad_view_refresh_precache_request_viewability_undesired_flags", 502L);
}
