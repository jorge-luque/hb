package p118io.fabric.sdk.android.p200m.p205e;

import com.crashlytics.android.beta.BuildConfig;
import com.tapjoy.TapjoyConstants;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p202b.C6096k;

/* renamed from: io.fabric.sdk.android.m.e.k */
/* compiled from: DefaultSettingsJsonTransform */
class C6144k implements C6157v {
    C6144k() {
    }

    /* renamed from: b */
    private C6138e m19887b(JSONObject jSONObject) throws JSONException {
        return new C6138e(jSONObject.getString("identifier"), jSONObject.getString("status"), jSONObject.getString("url"), jSONObject.getString("reports_url"), jSONObject.getString("ndk_reports_url"), jSONObject.optBoolean("update_required", false), (!jSONObject.has("icon") || !jSONObject.getJSONObject("icon").has("hash")) ? null : m19890e(jSONObject.getJSONObject("icon")));
    }

    /* renamed from: c */
    private C6139f m19888c(JSONObject jSONObject) throws JSONException {
        return new C6139f(jSONObject.optString("update_endpoint", C6156u.f16180a), jSONObject.optInt("update_suspend_duration", 3600));
    }

    /* renamed from: d */
    private C6146m m19889d(JSONObject jSONObject) {
        return new C6146m(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false), jSONObject.optBoolean("firebase_crashlytics_enabled", false));
    }

    /* renamed from: e */
    private C6136c m19890e(JSONObject jSONObject) throws JSONException {
        return new C6136c(jSONObject.getString("hash"), jSONObject.getInt("width"), jSONObject.getInt("height"));
    }

    /* renamed from: f */
    private C6148o m19891f(JSONObject jSONObject) throws JSONException {
        return new C6148o(jSONObject.optString("title", "Send Crash Report?"), jSONObject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
    }

    /* renamed from: g */
    private C6149p m19892g(JSONObject jSONObject) throws JSONException {
        return new C6149p(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", 255), jSONObject.optBoolean("send_session_without_crash", false), jSONObject.optInt("max_complete_sessions_count", 4));
    }

    /* renamed from: a */
    public C6155t mo34255a(C6096k kVar, JSONObject jSONObject) throws JSONException {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new C6155t(m19885a(kVar, (long) optInt2, jSONObject), m19887b(jSONObject.getJSONObject(TapjoyConstants.TJC_APP_PLACEMENT)), m19892g(jSONObject.getJSONObject("session")), m19891f(jSONObject.getJSONObject("prompt")), m19889d(jSONObject.getJSONObject("features")), m19886a(jSONObject.getJSONObject("analytics")), m19888c(jSONObject.getJSONObject(BuildConfig.ARTIFACT_ID)), optInt, optInt2);
    }

    /* renamed from: a */
    private C6135b m19886a(JSONObject jSONObject) {
        return new C6135b(jSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", 8000), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("forward_to_google_analytics", false), jSONObject.optBoolean("include_purchase_events_in_forwarded_events", false), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1), jSONObject.optBoolean("flush_on_background", true));
    }

    /* renamed from: a */
    private long m19885a(C6096k kVar, long j, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return (j * 1000) + kVar.mo34175a();
    }
}
