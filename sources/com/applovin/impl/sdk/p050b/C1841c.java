package com.applovin.impl.sdk.p050b;

import admost.sdk.AdMostManager;
import android.net.Uri;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.p033a.C1490j;
import com.applovin.sdk.AppLovinAdSize;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: com.applovin.impl.sdk.b.c */
public class C1841c<T> implements Comparable {

    /* renamed from: P */
    public static final C1841c<Boolean> f5789P = m7035a("empty", true);

    /* renamed from: Q */
    public static final C1841c<String> f5790Q = m7035a("dls", "");

    /* renamed from: R */
    public static final C1841c<Boolean> f5791R = m7035a("is_disabled", false);

    /* renamed from: S */
    public static final C1841c<String> f5792S = m7035a("device_id", "");

    /* renamed from: T */
    public static final C1841c<String> f5793T = m7035a("device_token", "");

    /* renamed from: U */
    public static final C1841c<Long> f5794U = m7035a("publisher_id", 0L);

    /* renamed from: V */
    public static final C1841c<Boolean> f5795V = m7035a("is_verbose_logging", false);

    /* renamed from: W */
    public static final C1841c<String> f5796W = m7035a("sc", "");

    /* renamed from: X */
    public static final C1841c<String> f5797X = m7035a("sc2", "");

    /* renamed from: Y */
    public static final C1841c<String> f5798Y = m7035a("sc3", "");

    /* renamed from: Z */
    public static final C1841c<String> f5799Z = m7035a("server_installed_at", "");

    /* renamed from: a */
    private static final List<?> f5800a;

    /* renamed from: aA */
    public static final C1841c<String> f5801aA = m7035a("text_alert_consent_no_option", "Cancel");

    /* renamed from: aB */
    public static final C1841c<Long> f5802aB = m7035a("ttc_max_click_duration_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));

    /* renamed from: aC */
    public static final C1841c<Integer> f5803aC = m7035a("ttc_max_click_distance_dp", 10);

    /* renamed from: aD */
    public static final C1841c<Integer> f5804aD = m7035a("ttc_acrs", Integer.valueOf(AppLovinTouchToClickListener.ClickRecognitionState.DISABLED.ordinal()));

    /* renamed from: aE */
    public static final C1841c<Integer> f5805aE = m7035a("ttc_acrsv2a", Integer.valueOf(AppLovinTouchToClickListener.ClickRecognitionState.ACTION_DOWN.ordinal()));

    /* renamed from: aF */
    public static final C1841c<String> f5806aF = m7035a("whitelisted_postback_endpoints", "https://prod-a.applovin.com,https://rt.applovin.com/4.0/pix, https://rt.applvn.com/4.0/pix,https://ms.applovin.com/,https://ms.applvn.com/");

    /* renamed from: aG */
    public static final C1841c<String> f5807aG = m7035a("fetch_settings_endpoint", "https://ms.applovin.com/");

    /* renamed from: aH */
    public static final C1841c<String> f5808aH = m7035a("fetch_settings_backup_endpoint", "https://ms.applvn.com/");

    /* renamed from: aI */
    public static final C1841c<String> f5809aI = m7035a("adserver_endpoint", "https://a.applovin.com/");

    /* renamed from: aJ */
    public static final C1841c<String> f5810aJ = m7035a("adserver_backup_endpoint", "https://a.applvn.com/");

    /* renamed from: aK */
    public static final C1841c<String> f5811aK = m7035a("api_endpoint", "https://d.applovin.com/");

    /* renamed from: aL */
    public static final C1841c<String> f5812aL = m7035a("api_backup_endpoint", "https://d.applvn.com/");

    /* renamed from: aM */
    public static final C1841c<String> f5813aM = m7035a("event_tracking_endpoint_v2", "https://rt.applovin.com/");

    /* renamed from: aN */
    public static final C1841c<String> f5814aN = m7035a("event_tracking_backup_endpoint_v2", "https://rt.applvn.com/");

    /* renamed from: aO */
    public static final C1841c<String> f5815aO = m7035a("fetch_variables_endpoint", "https://ms.applovin.com/");

    /* renamed from: aP */
    public static final C1841c<String> f5816aP = m7035a("fetch_variables_backup_endpoint", "https://ms.applvn.com/");

    /* renamed from: aQ */
    public static final C1841c<String> f5817aQ = m7035a("token_type_prefixes_r", "4!");

    /* renamed from: aR */
    public static final C1841c<String> f5818aR = m7035a("token_type_prefixes_arj", "json_v3!");

    /* renamed from: aS */
    public static final C1841c<String> f5819aS = m7035a("top_level_events", "landing,paused,resumed,checkout,iap");

    /* renamed from: aT */
    public static final C1841c<Boolean> f5820aT = m7035a("events_enabled", true);

    /* renamed from: aU */
    public static final C1841c<String> f5821aU;

    /* renamed from: aV */
    public static final C1841c<Boolean> f5822aV = m7035a("persist_super_properties", true);

    /* renamed from: aW */
    public static final C1841c<Integer> f5823aW = m7035a("super_property_string_max_length", Integer.valueOf(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS));

    /* renamed from: aX */
    public static final C1841c<Integer> f5824aX = m7035a("super_property_url_max_length", Integer.valueOf(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS));

    /* renamed from: aY */
    public static final C1841c<Integer> f5825aY = m7035a("preload_callback_timeout_seconds", -1);

    /* renamed from: aZ */
    public static final C1841c<Boolean> f5826aZ = m7035a("ad_preload_enabled", true);

    /* renamed from: aa */
    public static final C1841c<Boolean> f5827aa = m7035a("trn", false);

    /* renamed from: ab */
    public static final C1841c<Boolean> f5828ab = m7035a("track_network_response_codes", false);

    /* renamed from: ac */
    public static final C1841c<Boolean> f5829ac = m7035a("submit_network_response_codes", false);

    /* renamed from: ad */
    public static final C1841c<Boolean> f5830ad = m7035a("clear_network_response_codes_on_request", true);

    /* renamed from: ae */
    public static final C1841c<Boolean> f5831ae = m7035a("clear_completion_callback_on_failure", false);

    /* renamed from: af */
    public static final C1841c<Long> f5832af = m7035a("sicd_ms", 0L);

    /* renamed from: ag */
    public static final C1841c<Integer> f5833ag = m7035a("logcat_max_line_size", 1000);

    /* renamed from: ah */
    public static final C1841c<Integer> f5834ah = m7035a("stps", 32);

    /* renamed from: ai */
    public static final C1841c<Boolean> f5835ai = m7035a("ustp", false);

    /* renamed from: aj */
    public static final C1841c<Boolean> f5836aj = m7035a("publisher_can_show_consent_dialog", true);

    /* renamed from: ak */
    public static final C1841c<String> f5837ak = m7035a("consent_dialog_url", "https://assets.applovin.com/gdpr/flow_v1/gdpr-flow-1.html");

    /* renamed from: al */
    public static final C1841c<Boolean> f5838al = m7035a("consent_dialog_immersive_mode_on", false);

    /* renamed from: am */
    public static final C1841c<Long> f5839am = m7035a("consent_dialog_show_from_alert_delay_ms", 450L);

    /* renamed from: an */
    public static final C1841c<Boolean> f5840an = m7035a("alert_consent_for_dialog_rejected", false);

    /* renamed from: ao */
    public static final C1841c<Boolean> f5841ao = m7035a("alert_consent_for_dialog_closed", false);

    /* renamed from: ap */
    public static final C1841c<Boolean> f5842ap = m7035a("alert_consent_for_dialog_closed_with_back_button", false);

    /* renamed from: aq */
    public static final C1841c<Boolean> f5843aq = m7035a("alert_consent_after_init", false);

    /* renamed from: ar */
    public static final C1841c<Long> f5844ar = m7035a("alert_consent_after_init_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(5)));

    /* renamed from: as */
    public static final C1841c<Long> f5845as = m7035a("alert_consent_after_dialog_rejection_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(30)));

    /* renamed from: at */
    public static final C1841c<Long> f5846at = m7035a("alert_consent_after_dialog_close_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(5)));

    /* renamed from: au */
    public static final C1841c<Long> f5847au = m7035a("alert_consent_after_dialog_close_with_back_button_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(5)));

    /* renamed from: av */
    public static final C1841c<Long> f5848av = m7035a("alert_consent_after_cancel_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(10)));

    /* renamed from: aw */
    public static final C1841c<Long> f5849aw = m7035a("alert_consent_reschedule_interval_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(5)));

    /* renamed from: ax */
    public static final C1841c<String> f5850ax = m7035a("text_alert_consent_title", "Make this App Better and Stay Free!");

    /* renamed from: ay */
    public static final C1841c<String> f5851ay = m7035a("text_alert_consent_body", "If you don't give us consent to use your data, you will be making our ability to support this app harder, which may negatively affect the user experience.");

    /* renamed from: az */
    public static final C1841c<String> f5852az = m7035a("text_alert_consent_yes_option", "I Agree");

    /* renamed from: b */
    private static final Map<String, C1841c<?>> f5853b = new HashMap(512);

    /* renamed from: bA */
    public static final C1841c<Long> f5854bA = m7035a("cache_file_ttl_seconds", Long.valueOf(TimeUnit.DAYS.toSeconds(1)));

    /* renamed from: bB */
    public static final C1841c<Integer> f5855bB = m7035a("cache_max_size_mb", -1);

    /* renamed from: bC */
    public static final C1841c<String> f5856bC = m7035a("precache_delimiters", ")]',");

    /* renamed from: bD */
    public static final C1841c<Boolean> f5857bD = m7035a("native_auto_cache_preload_resources", true);

    /* renamed from: bE */
    public static final C1841c<Boolean> f5858bE = m7035a("ad_resource_caching_enabled", true);

    /* renamed from: bF */
    public static final C1841c<Boolean> f5859bF = m7035a("fail_ad_load_on_failed_video_cache", true);

    /* renamed from: bG */
    public static final C1841c<String> f5860bG = m7035a("resource_cache_prefix", "https://vid.applovin.com/,https://pdn.applovin.com/,https://img.applovin.com/,https://d.applovin.com/,https://assets.applovin.com/,https://cdnjs.cloudflare.com/,http://vid.applovin.com/,http://pdn.applovin.com/,http://img.applovin.com/,http://d.applovin.com/,http://assets.applovin.com/,http://cdnjs.cloudflare.com/");

    /* renamed from: bH */
    public static final C1841c<String> f5861bH = m7035a("preserved_cached_assets", "sound_off.png,sound_on.png,closeOptOut.png,1381250003_28x28.png,zepto-1.1.3.min.js,jquery-2.1.1.min.js,jquery-1.9.1.min.js,jquery.knob.js");

    /* renamed from: bI */
    public static final C1841c<Integer> f5862bI = m7035a("vr_retry_count_v1", 1);

    /* renamed from: bJ */
    public static final C1841c<Integer> f5863bJ = m7035a("cr_retry_count_v1", 1);

    /* renamed from: bK */
    public static final C1841c<Boolean> f5864bK = m7035a("incent_warning_enabled", false);

    /* renamed from: bL */
    public static final C1841c<String> f5865bL = m7035a("text_incent_warning_title", "Attention!");

    /* renamed from: bM */
    public static final C1841c<String> f5866bM = m7035a("text_incent_warning_body", "You won’t get your reward if the video hasn’t finished.");

    /* renamed from: bN */
    public static final C1841c<String> f5867bN = m7035a("text_incent_warning_close_option", "Close");

    /* renamed from: bO */
    public static final C1841c<String> f5868bO = m7035a("text_incent_warning_continue_option", "Keep Watching");

    /* renamed from: bP */
    public static final C1841c<Boolean> f5869bP = m7035a("incent_nonvideo_warning_enabled", false);

    /* renamed from: bQ */
    public static final C1841c<String> f5870bQ = m7035a("text_incent_nonvideo_warning_title", "Attention!");

    /* renamed from: bR */
    public static final C1841c<String> f5871bR = m7035a("text_incent_nonvideo_warning_body", "You won’t get your reward if the game hasn’t finished.");

    /* renamed from: bS */
    public static final C1841c<String> f5872bS = m7035a("text_incent_nonvideo_warning_close_option", "Close");

    /* renamed from: bT */
    public static final C1841c<String> f5873bT = m7035a("text_incent_nonvideo_warning_continue_option", "Keep Playing");

    /* renamed from: bU */
    public static final C1841c<Boolean> f5874bU = m7035a("video_callbacks_for_incent_nonvideo_ads_enabled", true);

    /* renamed from: bV */
    public static final C1841c<Boolean> f5875bV = m7035a("check_webview_has_gesture", false);

    /* renamed from: bW */
    public static final C1841c<Integer> f5876bW = m7035a("close_button_touch_area", 0);

    /* renamed from: bX */
    public static final C1841c<Integer> f5877bX = m7035a("close_button_outside_touch_area", 0);

    /* renamed from: bY */
    public static final C1841c<Long> f5878bY = m7035a("viewability_adview_imp_delay_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));

    /* renamed from: bZ */
    public static final C1841c<Integer> f5879bZ = m7035a("viewability_adview_banner_min_width", 320);

    /* renamed from: ba */
    public static final C1841c<String> f5880ba;

    /* renamed from: bb */
    public static final C1841c<Boolean> f5881bb = m7035a("ad_auto_preload_incent", true);

    /* renamed from: bc */
    public static final C1841c<Boolean> f5882bc = m7035a("ad_auto_preload_native", false);

    /* renamed from: bd */
    public static final C1841c<Boolean> f5883bd = m7035a("preload_native_ad_on_dequeue", false);

    /* renamed from: be */
    public static final C1841c<Integer> f5884be = m7035a("preload_capacity_banner_regular", 0);

    /* renamed from: bf */
    public static final C1841c<Integer> f5885bf = m7035a("preload_capacity_mrec_regular", 0);

    /* renamed from: bg */
    public static final C1841c<Integer> f5886bg = m7035a("preload_capacity_leader_regular", 0);

    /* renamed from: bh */
    public static final C1841c<Integer> f5887bh = m7035a("preload_capacity_inter_regular", 0);

    /* renamed from: bi */
    public static final C1841c<Integer> f5888bi = m7035a("preload_capacity_inter_videoa", 0);

    /* renamed from: bj */
    public static final C1841c<Boolean> f5889bj = m7035a("use_per_format_cache_queues", true);

    /* renamed from: bk */
    public static final C1841c<Integer> f5890bk = m7035a("extended_preload_capacity_banner_regular", 15);

    /* renamed from: bl */
    public static final C1841c<Integer> f5891bl = m7035a("extended_preload_capacity_mrec_regular", 15);

    /* renamed from: bm */
    public static final C1841c<Integer> f5892bm = m7035a("extended_preload_capacity_leader_regular", 15);

    /* renamed from: bn */
    public static final C1841c<Integer> f5893bn = m7035a("extended_preload_capacity_inter_regular", 15);

    /* renamed from: bo */
    public static final C1841c<Integer> f5894bo = m7035a("extended_preload_capacity_inter_videoa", 15);

    /* renamed from: bp */
    public static final C1841c<Integer> f5895bp = m7035a("preload_capacity_zone", 1);

    /* renamed from: bq */
    public static final C1841c<Integer> f5896bq = m7035a("preload_capacity_zone_native", 1);

    /* renamed from: br */
    public static final C1841c<Integer> f5897br = m7035a("extended_preload_capacity_zone", 15);

    /* renamed from: bs */
    public static final C1841c<Integer> f5898bs = m7035a("preload_capacity_native_native", 0);

    /* renamed from: bt */
    public static final C1841c<Boolean> f5899bt = m7035a("preload_merge_init_tasks_inter_regular", false);

    /* renamed from: bu */
    public static final C1841c<Boolean> f5900bu = m7035a("preload_merge_init_tasks_inter_videoa", false);

    /* renamed from: bv */
    public static final C1841c<Boolean> f5901bv = m7035a("preload_merge_init_tasks_banner_regular", false);

    /* renamed from: bw */
    public static final C1841c<Boolean> f5902bw = m7035a("preload_merge_init_tasks_mrec_regular", false);

    /* renamed from: bx */
    public static final C1841c<Boolean> f5903bx = m7035a("preload_merge_init_tasks_leader_regular", false);

    /* renamed from: by */
    public static final C1841c<Boolean> f5904by = m7035a("preload_merge_init_tasks_zones", false);

    /* renamed from: bz */
    public static final C1841c<Boolean> f5905bz = m7035a("cache_cleanup_enabled", false);

    /* renamed from: cA */
    public static final C1841c<Integer> f5906cA = m7035a("close_button_top_margin_video", 8);

    /* renamed from: cB */
    public static final C1841c<Boolean> f5907cB = m7035a("show_close_on_exit", true);

    /* renamed from: cC */
    public static final C1841c<Integer> f5908cC = m7035a("video_countdown_clock_margin", 10);

    /* renamed from: cD */
    public static final C1841c<Integer> f5909cD = m7035a("video_countdown_clock_gravity", 83);

    /* renamed from: cE */
    public static final C1841c<Integer> f5910cE = m7035a("countdown_clock_size", 32);

    /* renamed from: cF */
    public static final C1841c<Integer> f5911cF = m7035a("countdown_clock_stroke_size", 4);

    /* renamed from: cG */
    public static final C1841c<Integer> f5912cG = m7035a("countdown_clock_text_size", 28);

    /* renamed from: cH */
    public static final C1841c<Boolean> f5913cH = m7035a("draw_countdown_clock", true);

    /* renamed from: cI */
    public static final C1841c<Boolean> f5914cI = m7035a("force_back_button_enabled_always", false);

    /* renamed from: cJ */
    public static final C1841c<Boolean> f5915cJ = m7035a("force_back_button_enabled_close_button", false);

    /* renamed from: cK */
    public static final C1841c<Boolean> f5916cK = m7035a("force_back_button_enabled_poststitial", false);

    /* renamed from: cL */
    public static final C1841c<Long> f5917cL = m7035a("force_hide_status_bar_delay_ms", (Long) null);

    /* renamed from: cM */
    public static final C1841c<Boolean> f5918cM = m7035a("handle_window_actions", false);

    /* renamed from: cN */
    public static final C1841c<Long> f5919cN = m7035a("inter_display_delay", 200L);

    /* renamed from: cO */
    public static final C1841c<Boolean> f5920cO = m7035a("lock_specific_orientation", false);

    /* renamed from: cP */
    public static final C1841c<Boolean> f5921cP = m7035a("lhs_skip_button", true);

    /* renamed from: cQ */
    public static final C1841c<String> f5922cQ = m7035a("soft_buttons_resource_id", "config_showNavigationBar");

    /* renamed from: cR */
    public static final C1841c<Boolean> f5923cR = m7035a("countdown_toggleable", false);

    /* renamed from: cS */
    public static final C1841c<Boolean> f5924cS = m7035a("track_app_killed", false);

    /* renamed from: cT */
    public static final C1841c<Boolean> f5925cT = m7035a("should_use_animated_mute_icon", false);

    /* renamed from: cU */
    public static final C1841c<Boolean> f5926cU = m7035a("mute_controls_enabled", false);

    /* renamed from: cV */
    public static final C1841c<Boolean> f5927cV = m7035a("allow_user_muting", true);

    /* renamed from: cW */
    public static final C1841c<Boolean> f5928cW = m7035a("mute_videos", false);

    /* renamed from: cX */
    public static final C1841c<Boolean> f5929cX = m7035a("show_mute_by_default", false);

    /* renamed from: cY */
    public static final C1841c<Boolean> f5930cY = m7035a("mute_with_user_settings", true);

    /* renamed from: cZ */
    public static final C1841c<Integer> f5931cZ = m7035a("mute_button_size", 32);

    /* renamed from: ca */
    public static final C1841c<Integer> f5932ca = m7035a("viewability_adview_banner_min_height", Integer.valueOf(AppLovinAdSize.BANNER.getHeight()));

    /* renamed from: cb */
    public static final C1841c<Integer> f5933cb = m7035a("viewability_adview_mrec_min_width", Integer.valueOf(AppLovinAdSize.MREC.getWidth()));

    /* renamed from: cc */
    public static final C1841c<Integer> f5934cc = m7035a("viewability_adview_mrec_min_height", Integer.valueOf(AppLovinAdSize.MREC.getHeight()));

    /* renamed from: cd */
    public static final C1841c<Integer> f5935cd = m7035a("viewability_adview_leader_min_width", 728);

    /* renamed from: ce */
    public static final C1841c<Integer> f5936ce = m7035a("viewability_adview_leader_min_height", Integer.valueOf(AppLovinAdSize.LEADER.getHeight()));

    /* renamed from: cf */
    public static final C1841c<Float> f5937cf = m7035a("viewability_adview_min_alpha", Float.valueOf(10.0f));

    /* renamed from: cg */
    public static final C1841c<Long> f5938cg = m7035a("viewability_timer_min_visible_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));

    /* renamed from: ch */
    public static final C1841c<Long> f5939ch = m7035a("viewability_timer_interval_ms", 100L);

    /* renamed from: ci */
    public static final C1841c<Boolean> f5940ci = m7035a("dismiss_expanded_adview_on_refresh", false);

    /* renamed from: cj */
    public static final C1841c<Boolean> f5941cj = m7035a("dismiss_expanded_adview_on_detach", false);

    /* renamed from: ck */
    public static final C1841c<Boolean> f5942ck = m7035a("contract_expanded_ad_on_close", true);

    /* renamed from: cl */
    public static final C1841c<Long> f5943cl = m7035a("expandable_close_button_animation_duration_ms", 300L);

    /* renamed from: cm */
    public static final C1841c<Integer> f5944cm = m7035a("expandable_close_button_size", 27);

    /* renamed from: cn */
    public static final C1841c<Integer> f5945cn = m7035a("expandable_h_close_button_margin", 10);

    /* renamed from: co */
    public static final C1841c<Integer> f5946co = m7035a("expandable_t_close_button_margin", 10);

    /* renamed from: cp */
    public static final C1841c<Boolean> f5947cp = m7035a("expandable_lhs_close_button", false);

    /* renamed from: cq */
    public static final C1841c<Integer> f5948cq = m7035a("expandable_close_button_touch_area", 0);

    /* renamed from: cr */
    public static final C1841c<Boolean> f5949cr = m7035a("click_failed_expand", false);

    /* renamed from: cs */
    public static final C1841c<Boolean> f5950cs = m7035a("iaad", false);

    /* renamed from: ct */
    public static final C1841c<Integer> f5951ct = m7035a("auxiliary_operations_threads", 3);

    /* renamed from: cu */
    public static final C1841c<Integer> f5952cu = m7035a("caching_operations_threads", 8);

    /* renamed from: cv */
    public static final C1841c<Long> f5953cv = m7035a("fullscreen_ad_pending_display_state_timeout_ms", Long.valueOf(TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: cw */
    public static final C1841c<Long> f5954cw = m7035a("fullscreen_ad_showing_state_timeout_ms", Long.valueOf(TimeUnit.MINUTES.toMillis(2)));

    /* renamed from: cx */
    public static final C1841c<Boolean> f5955cx = m7035a("lhs_close_button_video", false);

    /* renamed from: cy */
    public static final C1841c<Integer> f5956cy = m7035a("close_button_right_margin_video", 4);

    /* renamed from: cz */
    public static final C1841c<Integer> f5957cz = m7035a("close_button_size_video", 30);

    /* renamed from: dA */
    public static final C1841c<Boolean> f5958dA = m7035a("skip_fetch_basic_settings_if_not_connected", false);

    /* renamed from: dB */
    public static final C1841c<Integer> f5959dB = m7035a("fetch_basic_settings_retry_delay_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(2)));

    /* renamed from: dC */
    public static final C1841c<Integer> f5960dC = m7035a("fetch_variables_connection_timeout_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(5)));

    /* renamed from: dD */
    public static final C1841c<Integer> f5961dD = m7035a("ad_session_minutes", 60);

    /* renamed from: dE */
    public static final C1841c<Boolean> f5962dE = m7035a("session_tracking_cooldown_on_event_fire", true);

    /* renamed from: dF */
    public static final C1841c<Long> f5963dF = m7035a("session_tracking_resumed_cooldown_minutes", 90L);

    /* renamed from: dG */
    public static final C1841c<Long> f5964dG = m7035a("session_tracking_paused_cooldown_minutes", 90L);

    /* renamed from: dH */
    public static final C1841c<Boolean> f5965dH = m7035a("track_app_paused", false);

    /* renamed from: dI */
    public static final C1841c<Boolean> f5966dI = m7035a("qq", false);

    /* renamed from: dJ */
    public static final C1841c<Boolean> f5967dJ = m7035a("qq1", true);

    /* renamed from: dK */
    public static final C1841c<Boolean> f5968dK = m7035a("qq3", true);

    /* renamed from: dL */
    public static final C1841c<Boolean> f5969dL = m7035a("qq4", true);

    /* renamed from: dM */
    public static final C1841c<Boolean> f5970dM = m7035a("qq5", true);

    /* renamed from: dN */
    public static final C1841c<Boolean> f5971dN = m7035a("qq6", true);

    /* renamed from: dO */
    public static final C1841c<Boolean> f5972dO = m7035a("qq7", true);

    /* renamed from: dP */
    public static final C1841c<Boolean> f5973dP = m7035a("qq8", true);

    /* renamed from: dQ */
    public static final C1841c<Boolean> f5974dQ = m7035a("pui", true);

    /* renamed from: dR */
    public static final C1841c<String> f5975dR;

    /* renamed from: dS */
    public static final C1841c<Boolean> f5976dS = m7035a("hgn", false);

    /* renamed from: dT */
    public static final C1841c<Boolean> f5977dT = m7035a("citab", false);

    /* renamed from: dU */
    public static final C1841c<Boolean> f5978dU = m7035a("cit", false);

    /* renamed from: dV */
    public static final C1841c<Boolean> f5979dV = m7035a("cso", false);

    /* renamed from: dW */
    public static final C1841c<Boolean> f5980dW = m7035a("cfs", false);

    /* renamed from: dX */
    public static final C1841c<Boolean> f5981dX = m7035a("cmi", false);

    /* renamed from: dY */
    public static final C1841c<Boolean> f5982dY = m7035a("cvs", false);

    /* renamed from: dZ */
    public static final C1841c<Boolean> f5983dZ = m7035a("caf", false);

    /* renamed from: da */
    public static final C1841c<Integer> f5984da = m7035a("mute_button_margin", 10);

    /* renamed from: db */
    public static final C1841c<Integer> f5985db = m7035a("mute_button_gravity", 85);

    /* renamed from: dc */
    public static final C1841c<Boolean> f5986dc = m7035a("video_immersive_mode_enabled", false);

    /* renamed from: dd */
    public static final C1841c<Long> f5987dd = m7035a("progress_bar_step", 25L);

    /* renamed from: de */
    public static final C1841c<Integer> f5988de = m7035a("progress_bar_scale", Integer.valueOf(C6078a.DEFAULT_TIMEOUT));

    /* renamed from: df */
    public static final C1841c<Integer> f5989df = m7035a("progress_bar_vertical_padding", -8);

    /* renamed from: dg */
    public static final C1841c<Long> f5990dg = m7035a("video_resume_delay", 250L);

    /* renamed from: dh */
    public static final C1841c<Boolean> f5991dh = m7035a("is_video_skippable", false);

    /* renamed from: di */
    public static final C1841c<Integer> f5992di = m7035a("vs_buffer_indicator_size", 50);

    /* renamed from: dj */
    public static final C1841c<Boolean> f5993dj = m7035a("video_zero_length_as_computed", false);

    /* renamed from: dk */
    public static final C1841c<Long> f5994dk = m7035a("set_poststitial_muted_initial_delay_ms", 500L);

    /* renamed from: dl */
    public static final C1841c<Integer> f5995dl = m7035a("native_batch_precache_count", 1);

    /* renamed from: dm */
    public static final C1841c<Integer> f5996dm = m7035a("submit_postback_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: dn */
    public static final C1841c<Integer> f5997dn = m7035a("submit_postback_retries", 4);

    /* renamed from: do */
    public static final C1841c<Integer> f5998do = m7035a("max_postback_attempts", 3);

    /* renamed from: dp */
    public static final C1841c<Integer> f5999dp = m7035a("get_retry_delay_v1", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: dq */
    public static final C1841c<Integer> f6000dq = m7035a("http_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: dr */
    public static final C1841c<Integer> f6001dr = m7035a("http_socket_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(20)));

    /* renamed from: ds */
    public static final C1841c<Boolean> f6002ds = m7035a("force_ssl", false);

    /* renamed from: dt */
    public static final C1841c<Integer> f6003dt = m7035a("fetch_ad_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: du */
    public static final C1841c<Integer> f6004du = m7035a("fetch_ad_retry_count_v1", 1);

    /* renamed from: dv */
    public static final C1841c<Integer> f6005dv = m7035a("submit_data_retry_count_v1", 1);

    /* renamed from: dw */
    public static final C1841c<Integer> f6006dw = m7035a("response_buffer_size", 16000);

    /* renamed from: dx */
    public static final C1841c<Integer> f6007dx = m7035a("fetch_basic_settings_connection_timeout_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: dy */
    public static final C1841c<Integer> f6008dy = m7035a("fetch_basic_settings_retry_count", 3);

    /* renamed from: dz */
    public static final C1841c<Boolean> f6009dz = m7035a("fetch_basic_settings_on_reconnect", false);

    /* renamed from: eA */
    public static final C1841c<String> f6010eA = m7035a("vast_link_html", "<html><head><style>html,body,iframe{height:100%;width:100%;}body{margin:0}iframe{border:0;overflow:hidden;position:absolute}</style></head><body><iframe src={SOURCE} frameborder=0></iframe></body></html>");

    /* renamed from: eB */
    public static final C1841c<Integer> f6011eB = m7035a("vast_max_response_length", 640000);

    /* renamed from: eC */
    public static final C1841c<Integer> f6012eC = m7035a("vast_max_wrapper_depth", 5);

    /* renamed from: eD */
    public static final C1841c<Long> f6013eD = m7035a("vast_progress_tracking_countdown_step", Long.valueOf(TimeUnit.SECONDS.toMillis(1)));

    /* renamed from: eE */
    public static final C1841c<String> f6014eE = m7035a("vast_unsupported_video_extensions", "ogv,flv");

    /* renamed from: eF */
    public static final C1841c<String> f6015eF = m7035a("vast_unsupported_video_types", "video/ogg,video/x-flv");

    /* renamed from: eG */
    public static final C1841c<Boolean> f6016eG = m7035a("vast_validate_with_extension_if_no_video_type", true);

    /* renamed from: eH */
    public static final C1841c<Integer> f6017eH = m7035a("vast_video_selection_policy", Integer.valueOf(C1490j.C1492a.MEDIUM.ordinal()));

    /* renamed from: eI */
    public static final C1841c<Integer> f6018eI = m7035a("vast_wrapper_resolution_retry_count_v1", 1);

    /* renamed from: eJ */
    public static final C1841c<Integer> f6019eJ = m7035a("vast_wrapper_resolution_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: eK */
    public static final C1841c<Boolean> f6020eK = m7035a("ree", true);

    /* renamed from: eL */
    public static final C1841c<Boolean> f6021eL = m7035a("btee", true);

    /* renamed from: eM */
    public static final C1841c<Long> f6022eM = m7035a("server_timestamp_ms", (Long) null);

    /* renamed from: eN */
    public static final C1841c<Long> f6023eN = m7035a("device_timestamp_ms", (Long) null);

    /* renamed from: eO */
    public static final C1841c<Boolean> f6024eO = m7035a("cleanup_webview", false);

    /* renamed from: eP */
    public static final C1841c<Boolean> f6025eP = m7035a("sanitize_webview", false);

    /* renamed from: eQ */
    public static final C1841c<Boolean> f6026eQ = m7035a("force_rerender", false);

    /* renamed from: eR */
    public static final C1841c<Boolean> f6027eR = m7035a("daostr", false);

    /* renamed from: eS */
    public static final C1841c<Boolean> f6028eS = m7035a("urrr", false);

    /* renamed from: eT */
    public static final C1841c<Boolean> f6029eT = m7035a("tctpmw", false);

    /* renamed from: eU */
    public static final C1841c<Boolean> f6030eU = m7035a("tctlaa", false);

    /* renamed from: eV */
    public static final C1841c<Boolean> f6031eV = m7035a("swvb", false);

    /* renamed from: eW */
    public static final C1841c<Boolean> f6032eW = m7035a("rwvdv", false);

    /* renamed from: eX */
    public static final C1841c<Boolean> f6033eX = m7035a("handle_render_process_gone", true);

    /* renamed from: eY */
    public static final C1841c<Boolean> f6034eY = m7035a("sfawv", false);

    /* renamed from: eZ */
    public static final C1841c<Boolean> f6035eZ = m7035a("sipntps", false);

    /* renamed from: ea */
    public static final C1841c<Boolean> f6036ea = m7035a("cf", false);

    /* renamed from: eb */
    public static final C1841c<String> f6037eb = m7035a("emulator_hardware_list", "ranchu,goldfish,vbox");

    /* renamed from: ec */
    public static final C1841c<String> f6038ec = m7035a("emulator_device_list", "generic,vbox");

    /* renamed from: ed */
    public static final C1841c<String> f6039ed = m7035a("emulator_manufacturer_list", "Genymotion");

    /* renamed from: ee */
    public static final C1841c<String> f6040ee = m7035a("emulator_model_list", "Android SDK built for x86");

    /* renamed from: ef */
    public static final C1841c<Boolean> f6041ef = m7035a("adr", false);

    /* renamed from: eg */
    public static final C1841c<Float> f6042eg = m7035a("volume_normalization_factor", Float.valueOf(6.6666665f));

    /* renamed from: eh */
    public static final C1841c<Boolean> f6043eh = m7035a("user_agent_collection_enabled", false);

    /* renamed from: ei */
    public static final C1841c<Long> f6044ei = m7035a("user_agent_collection_timeout_ms", 600L);

    /* renamed from: ej */
    public static final C1841c<Boolean> f6045ej = m7035a("http_headers_collection_enabled", false);

    /* renamed from: ek */
    public static final C1841c<Long> f6046ek = m7035a("http_headers_collection_timeout_ms", 600L);

    /* renamed from: el */
    public static final C1841c<String> f6047el = m7035a("webview_package_name", "com.google.android.webview");

    /* renamed from: em */
    public static final C1841c<Boolean> f6048em = m7035a("collect_device_angle", false);

    /* renamed from: en */
    public static final C1841c<Boolean> f6049en = m7035a("collect_device_movement", false);

    /* renamed from: eo */
    public static final C1841c<Float> f6050eo = m7035a("movement_degradation", Float.valueOf(0.75f));

    /* renamed from: ep */
    public static final C1841c<Integer> f6051ep = m7035a("device_sensor_period_ms", Integer.valueOf(AdMostManager.AD_MEDIUM_RECTANGLE));

    /* renamed from: eq */
    public static final C1841c<Boolean> f6052eq = m7035a("dte", true);

    /* renamed from: er */
    public static final C1841c<Boolean> f6053er = m7035a("is_track_ad_info", true);

    /* renamed from: es */
    public static final C1841c<Boolean> f6054es = m7035a("submit_ad_stats_enabled", false);

    /* renamed from: et */
    public static final C1841c<Integer> f6055et = m7035a("submit_ad_stats_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: eu */
    public static final C1841c<Integer> f6056eu = m7035a("submit_ad_stats_retry_count", 1);

    /* renamed from: ev */
    public static final C1841c<Integer> f6057ev = m7035a("submit_ad_stats_max_count", 500);

    /* renamed from: ew */
    public static final C1841c<Boolean> f6058ew = m7035a("asdm", false);

    /* renamed from: ex */
    public static final C1841c<Boolean> f6059ex = m7035a("error_reporting_enabled", false);

    /* renamed from: ey */
    public static final C1841c<Integer> f6060ey = m7035a("error_reporting_log_limit", 100);

    /* renamed from: ez */
    public static final C1841c<String> f6061ez = m7035a("vast_image_html", "<html><head><style>html,body{height:100%;width:100%}body{background-image:url({SOURCE});background-repeat:no-repeat;background-size:contain;background-position:center;}a{position:absolute;top:0;bottom:0;left:0;right:0}</style></head><body><a href=\"applovin://com.applovin.sdk/adservice/track_click_now\"></a></body></html>");

    /* renamed from: fa */
    public static final C1841c<Boolean> f6062fa = m7035a("comcr", true);

    /* renamed from: fb */
    public static final C1841c<Boolean> f6063fb = m7035a("gcoas", false);

    /* renamed from: fc */
    public static final C1841c<Boolean> f6064fc = m7035a("cofaonw", true);

    /* renamed from: fd */
    public static final C1841c<String> f6065fd = m7035a("config_consent_dialog_state", "unknown");

    /* renamed from: fe */
    public static final C1841c<String> f6066fe = m7035a("c_sticky_topics", "safedk_init,max_ad_events,test_mode_enabled,test_mode_networks,send_http_request,adapter_initialization_status");

    /* renamed from: ff */
    public static final C1841c<Boolean> f6067ff = m7035a("zt_enabled", true);

    /* renamed from: fg */
    public static final C1841c<String> f6068fg = m7035a("zt_endpoint", "https://a.applovin.com/");

    /* renamed from: fh */
    public static final C1841c<String> f6069fh = m7035a("zt_backup_endpoint", "https://a.applvn.com/");

    /* renamed from: fi */
    public static final C1841c<Integer> f6070fi = m7035a("zt_timeout_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: fj */
    public static final C1841c<Long> f6071fj = m7035a("zt_flush_interval_s", -1L);

    /* renamed from: fk */
    public static final C1841c<Boolean> f6072fk = m7035a("zt_bg_aware_timer", true);

    /* renamed from: fl */
    public static final C1841c<Boolean> f6073fl = m7035a("zt_flush_on_impression", true);

    /* renamed from: fm */
    public static final C1841c<Boolean> f6074fm = m7035a("zt_flush_on_app_bg", false);

    /* renamed from: fn */
    public static final C1841c<Boolean> f6075fn = m7035a("zt_continue_through_error", true);

    /* renamed from: c */
    private final String f6076c;

    /* renamed from: d */
    private final T f6077d;

    static {
        Class<String> cls = String.class;
        Class<Long> cls2 = Long.class;
        Class<Integer> cls3 = Integer.class;
        Class<Float> cls4 = Float.class;
        f5800a = Arrays.asList(new Class[]{Boolean.class, cls4, cls3, cls2, cls});
        f5821aU = m7035a("valid_super_property_types", cls.getName() + "," + cls3.getName() + "," + cls2.getName() + "," + Double.class.getName() + "," + cls4.getName() + "," + Date.class.getName() + "," + Uri.class.getName() + "," + List.class.getName() + "," + Map.class.getName());
        Object obj = "";
        f5880ba = m7035a("ad_auto_preload_sizes", obj);
        f5975dR = m7035a("plugin_version", obj);
    }

    public C1841c(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        } else if (t != null) {
            this.f6076c = str;
            this.f6077d = t;
        } else {
            throw new IllegalArgumentException("No default value specified");
        }
    }

    /* renamed from: a */
    protected static <T> C1841c<T> m7035a(String str, T t) {
        if (t == null) {
            throw new IllegalArgumentException("No default value specified");
        } else if (f5800a.contains(t.getClass())) {
            C1841c<T> cVar = new C1841c<>(str, t);
            if (!f5853b.containsKey(str)) {
                f5853b.put(str, cVar);
                return cVar;
            }
            throw new IllegalArgumentException("Setting has already been used: " + str);
        } else {
            throw new IllegalArgumentException("Unsupported value type: " + t.getClass());
        }
    }

    /* renamed from: c */
    public static Collection<C1841c<?>> m7036c() {
        return Collections.synchronizedCollection(f5853b.values());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public T mo8297a(Object obj) {
        return this.f6077d.getClass().cast(obj);
    }

    /* renamed from: a */
    public String mo8298a() {
        return this.f6076c;
    }

    /* renamed from: b */
    public T mo8299b() {
        return this.f6077d;
    }

    public int compareTo(Object obj) {
        if (!(obj instanceof C1841c)) {
            return 0;
        }
        return this.f6076c.compareTo(((C1841c) obj).mo8298a());
    }
}
