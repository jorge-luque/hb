package com.applovin.impl.sdk.p049ad;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.net.Uri;
import com.applovin.impl.adview.C1548c;
import com.applovin.impl.adview.C1563h;
import com.applovin.impl.adview.C1628s;
import com.applovin.impl.adview.C1632v;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p048a.C1814c;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p051c.C1846a;
import com.applovin.impl.sdk.utils.C1989e;
import com.applovin.impl.sdk.utils.C1991g;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.sdk.AppLovinSdkUtils;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
import p118io.fabric.sdk.android.p200m.p202b.C6078a;

/* renamed from: com.applovin.impl.sdk.ad.g */
public abstract class C1827g extends AppLovinAdBase {

    /* renamed from: a */
    private final List<Uri> f5707a = C1989e.m7829a();

    /* renamed from: b */
    private final AtomicBoolean f5708b = new AtomicBoolean();

    /* renamed from: c */
    private final AtomicBoolean f5709c = new AtomicBoolean();

    /* renamed from: d */
    private final AtomicReference<C1814c> f5710d = new AtomicReference<>();

    /* renamed from: e */
    private boolean f5711e;

    /* renamed from: f */
    private List<C1846a> f5712f;

    /* renamed from: g */
    private List<C1846a> f5713g;

    /* renamed from: h */
    private List<C1846a> f5714h;

    /* renamed from: i */
    private List<C1846a> f5715i;

    /* renamed from: j */
    private C1831c f5716j;

    /* renamed from: com.applovin.impl.sdk.ad.g$a */
    public enum C1829a {
        UNSPECIFIED,
        DISMISS,
        DO_NOT_DISMISS
    }

    /* renamed from: com.applovin.impl.sdk.ad.g$b */
    public enum C1830b {
        DEFAULT,
        ACTIVITY_PORTRAIT,
        ACTIVITY_LANDSCAPE
    }

    /* renamed from: com.applovin.impl.sdk.ad.g$c */
    public class C1831c {

        /* renamed from: a */
        public final int f5725a;

        /* renamed from: b */
        public final int f5726b;

        /* renamed from: c */
        public final int f5727c;

        /* renamed from: d */
        public final int f5728d;

        /* renamed from: e */
        public final int f5729e;

        private C1831c() {
            this.f5725a = AppLovinSdkUtils.dpToPx(C1827g.this.sdk.mo8527E(), C1827g.this.mo8253ag());
            this.f5726b = AppLovinSdkUtils.dpToPx(C1827g.this.sdk.mo8527E(), C1827g.this.mo8254ah());
            this.f5727c = AppLovinSdkUtils.dpToPx(C1827g.this.sdk.mo8527E(), C1827g.this.mo8255ai());
            this.f5728d = AppLovinSdkUtils.dpToPx(C1827g.this.sdk.mo8527E(), ((Integer) C1827g.this.sdk.mo8549a(C1841c.f5877bX)).intValue());
            this.f5729e = AppLovinSdkUtils.dpToPx(C1827g.this.sdk.mo8527E(), ((Integer) C1827g.this.sdk.mo8549a(C1841c.f5876bW)).intValue());
        }
    }

    /* renamed from: com.applovin.impl.sdk.ad.g$d */
    public enum C1832d {
        RESIZE_ASPECT,
        RESIZE_ASPECT_FILL,
        RESIZE
    }

    public C1827g(JSONObject jSONObject, JSONObject jSONObject2, C1818b bVar, C1941j jVar) {
        super(jSONObject, jSONObject2, bVar, jVar);
    }

    /* renamed from: a */
    private List<C1846a> m6914a(PointF pointF, boolean z) {
        List<C1846a> a;
        synchronized (this.adObjectLock) {
            a = C2029r.m8004a("click_tracking_urls", this.adObject, m6920c(pointF, z), m6917b(pointF, z), mo8231aA(), this.sdk);
        }
        return a;
    }

    /* renamed from: b */
    private String mo7152b() {
        String stringFromAdObject = getStringFromAdObject("video_end_url", (String) null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    /* renamed from: b */
    private String m6917b(PointF pointF, boolean z) {
        String stringFromAdObject = getStringFromAdObject("click_tracking_url", (String) null);
        Map<String, String> c = m6920c(pointF, z);
        if (stringFromAdObject != null) {
            return C2025o.m7958a(stringFromAdObject, c);
        }
        return null;
    }

    /* renamed from: c */
    private C1563h.C1564a m6918c(boolean z) {
        return z ? C1563h.C1564a.WHITE_ON_TRANSPARENT : C1563h.C1564a.WHITE_ON_BLACK;
    }

    /* renamed from: c */
    private Map<String, String> m6920c(PointF pointF, boolean z) {
        Point a = C1991g.m7836a(this.sdk.mo8527E());
        HashMap hashMap = new HashMap(5);
        hashMap.put("{CLCODE}", getClCode());
        hashMap.put("{CLICK_X}", String.valueOf(pointF.x));
        hashMap.put("{CLICK_Y}", String.valueOf(pointF.y));
        hashMap.put("{SCREEN_WIDTH}", String.valueOf(a.x));
        hashMap.put("{SCREEN_HEIGHT}", String.valueOf(a.y));
        hashMap.put("{IS_VIDEO_CLICK}", String.valueOf(z));
        return hashMap;
    }

    /* renamed from: A */
    public boolean mo8201A() {
        return getBooleanFromAdObject("accelerate_hardware", false);
    }

    /* renamed from: B */
    public boolean mo8202B() {
        return getBooleanFromAdObject("keep_screen_on", false);
    }

    /* renamed from: C */
    public boolean mo8203C() {
        return getBooleanFromAdObject("hide_close_on_exit_graphic", false);
    }

    /* renamed from: D */
    public boolean mo8204D() {
        return getBooleanFromAdObject("hide_close_on_exit", false);
    }

    /* renamed from: E */
    public boolean mo8205E() {
        return getBooleanFromAdObject("lock_current_orientation", false);
    }

    /* renamed from: F */
    public int mo8206F() {
        return getIntFromAdObject("countdown_length", 0);
    }

    /* renamed from: G */
    public int mo8207G() {
        int parseColor = Color.parseColor("#C8FFFFFF");
        String stringFromAdObject = getStringFromAdObject("countdown_color", (String) null);
        return C2025o.m7963b(stringFromAdObject) ? Color.parseColor(stringFromAdObject) : parseColor;
    }

    /* renamed from: H */
    public int mo8208H() {
        String stringFromAdObject = getStringFromAdObject("video_background_color", (String) null);
        if (C2025o.m7963b(stringFromAdObject)) {
            return Color.parseColor(stringFromAdObject);
        }
        return -16777216;
    }

    /* renamed from: I */
    public int mo8209I() {
        int i = hasVideoUrl() ? -16777216 : -1157627904;
        String stringFromAdObject = getStringFromAdObject("graphic_background_color", (String) null);
        return C2025o.m7963b(stringFromAdObject) ? Color.parseColor(stringFromAdObject) : i;
    }

    /* renamed from: J */
    public C1829a mo8210J() {
        String stringFromAdObject = getStringFromAdObject("poststitial_dismiss_type", (String) null);
        if (C2025o.m7963b(stringFromAdObject)) {
            if (TapjoyConstants.TJC_FULLSCREEN_AD_DISMISS_URL.equalsIgnoreCase(stringFromAdObject)) {
                return C1829a.DISMISS;
            }
            if ("no_dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return C1829a.DO_NOT_DISMISS;
            }
        }
        return C1829a.UNSPECIFIED;
    }

    /* renamed from: K */
    public List<String> mo8211K() {
        String stringFromAdObject = getStringFromAdObject("resource_cache_prefix", (String) null);
        return stringFromAdObject != null ? C1989e.m7831a(stringFromAdObject) : this.sdk.mo8576b(C1841c.f5860bG);
    }

    /* renamed from: L */
    public String mo8212L() {
        return getStringFromAdObject("cache_prefix", (String) null);
    }

    /* renamed from: M */
    public boolean mo8213M() {
        return getBooleanFromAdObject("daome", true);
    }

    /* renamed from: N */
    public boolean mo8214N() {
        return getBooleanFromAdObject("utpfc", false);
    }

    /* renamed from: O */
    public boolean mo8215O() {
        return getBooleanFromAdObject("sscomt", false);
    }

    /* renamed from: P */
    public String mo8216P() {
        return getStringFromFullResponse("event_id", (String) null);
    }

    /* renamed from: Q */
    public boolean mo8217Q() {
        return getBooleanFromAdObject("progress_bar_enabled", false);
    }

    /* renamed from: R */
    public int mo8218R() {
        String stringFromAdObject = getStringFromAdObject("progress_bar_color", "#C8FFFFFF");
        if (C2025o.m7963b(stringFromAdObject)) {
            return Color.parseColor(stringFromAdObject);
        }
        return 0;
    }

    /* renamed from: S */
    public boolean mo8219S() {
        return getBooleanFromAdObject("vs_buffer_indicator_enabled", false);
    }

    /* renamed from: T */
    public boolean mo8220T() {
        return getBooleanFromAdObject("vs_buffer_indicator_initial_load_enabled", false);
    }

    /* renamed from: U */
    public int mo8221U() {
        return getIntFromAdObject("vs_buffer_indicator_style", 16842874);
    }

    /* renamed from: V */
    public int mo8222V() {
        String stringFromAdObject = getStringFromAdObject("vs_buffer_indicator_color", (String) null);
        if (C2025o.m7963b(stringFromAdObject)) {
            return Color.parseColor(stringFromAdObject);
        }
        return -1;
    }

    /* renamed from: W */
    public int mo8223W() {
        int parseColor = Color.parseColor("#66000000");
        String stringFromAdObject = getStringFromAdObject("vs_buffer_indicator_bg_color", (String) null);
        return C2025o.m7963b(stringFromAdObject) ? Color.parseColor(stringFromAdObject) : parseColor;
    }

    /* renamed from: X */
    public boolean mo8224X() {
        return getBooleanFromAdObject("clear_dismissible", false);
    }

    /* renamed from: Y */
    public int mo8225Y() {
        int a;
        synchronized (this.adObjectLock) {
            a = C2029r.m7986a(this.adObject);
        }
        return a;
    }

    /* renamed from: Z */
    public int mo8226Z() {
        return getIntFromAdObject("poststitial_shown_forward_delay_millis", -1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1563h.C1564a mo8227a(int i) {
        return i == 1 ? C1563h.C1564a.WHITE_ON_TRANSPARENT : i == 2 ? C1563h.C1564a.INVISIBLE : C1563h.C1564a.WHITE_ON_BLACK;
    }

    /* renamed from: a */
    public List<C1846a> mo8228a(PointF pointF) {
        return m6914a(pointF, false);
    }

    /* renamed from: a */
    public abstract void mo7144a();

    /* renamed from: a */
    public void mo8229a(C1814c cVar) {
        this.f5710d.set(cVar);
    }

    /* renamed from: a */
    public void mo8230a(boolean z) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("html_resources_cached", z);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: aA */
    public Map<String, String> mo8231aA() {
        HashMap hashMap = new HashMap();
        if (getBooleanFromAdObject("send_webview_http_headers", false)) {
            hashMap.putAll(C1548c.getHttpHeaders());
        }
        if (getBooleanFromAdObject("use_webview_ua_for_postbacks", false)) {
            hashMap.put(C6078a.HEADER_USER_AGENT, C1548c.m5986a(0));
        }
        return hashMap;
    }

    /* renamed from: aB */
    public boolean mo8232aB() {
        return getBooleanFromAdObject("playback_requires_user_action", true);
    }

    /* renamed from: aC */
    public boolean mo8233aC() {
        return getBooleanFromAdObject("sanitize_webview", false);
    }

    /* renamed from: aD */
    public String mo8234aD() {
        String stringFromAdObject = getStringFromAdObject("base_url", "/");
        if ("null".equalsIgnoreCase(stringFromAdObject)) {
            return null;
        }
        return stringFromAdObject;
    }

    /* renamed from: aE */
    public boolean mo8235aE() {
        return getBooleanFromAdObject("web_contents_debugging_enabled", false);
    }

    /* renamed from: aF */
    public C1632v mo8236aF() {
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("web_view_settings", (JSONObject) null);
        if (jsonObjectFromAdObject != null) {
            return new C1632v(jsonObjectFromAdObject, this.sdk);
        }
        return null;
    }

    /* renamed from: aG */
    public List<String> mo8237aG() {
        return C1989e.m7831a(getStringFromAdObject("wls", ""));
    }

    /* renamed from: aH */
    public List<String> mo8238aH() {
        return C1989e.m7831a(getStringFromAdObject("wlh", (String) null));
    }

    /* renamed from: aI */
    public boolean mo8239aI() {
        return getBooleanFromAdObject("ibbdfs", false);
    }

    /* renamed from: aJ */
    public boolean mo8240aJ() {
        return getBooleanFromAdObject("ibbdfc", false);
    }

    /* renamed from: aK */
    public Uri mo8241aK() {
        String stringFromAdObject = getStringFromAdObject("mute_image", (String) null);
        if (C2025o.m7963b(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    /* renamed from: aL */
    public Uri mo8242aL() {
        String stringFromAdObject = getStringFromAdObject("unmute_image", "");
        if (C2025o.m7963b(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    /* renamed from: aM */
    public boolean mo8243aM() {
        return this.f5709c.get();
    }

    /* renamed from: aN */
    public void mo8244aN() {
        this.f5709c.set(true);
    }

    /* renamed from: aO */
    public C1814c mo8245aO() {
        return this.f5710d.getAndSet((Object) null);
    }

    /* renamed from: aP */
    public C1832d mo8246aP() {
        String stringFromAdObject = getStringFromAdObject("video_gravity", (String) null);
        return "resize".equals(stringFromAdObject) ? C1832d.RESIZE : "resize_aspect_fill".equals(stringFromAdObject) ? C1832d.RESIZE_ASPECT_FILL : C1832d.RESIZE_ASPECT;
    }

    /* renamed from: aa */
    public int mo8247aa() {
        return getIntFromAdObject("poststitial_dismiss_forward_delay_millis", -1);
    }

    /* renamed from: ab */
    public boolean mo8248ab() {
        return getBooleanFromAdObject("should_apply_mute_setting_to_poststitial", false);
    }

    /* renamed from: ac */
    public boolean mo8249ac() {
        return getBooleanFromAdObject("should_forward_close_button_tapped_to_poststitial", false);
    }

    /* renamed from: ad */
    public boolean mo8250ad() {
        return getBooleanFromAdObject("vkuv", false);
    }

    /* renamed from: ae */
    public boolean mo8251ae() {
        return getBooleanFromAdObject("forward_lifecycle_events_to_webview", false);
    }

    /* renamed from: af */
    public C1831c mo8252af() {
        if (this.f5716j == null) {
            this.f5716j = new C1831c();
        }
        return this.f5716j;
    }

    /* renamed from: ag */
    public int mo8253ag() {
        return getIntFromAdObject("close_button_size", ((Integer) this.sdk.mo8549a(C1841c.f5957cz)).intValue());
    }

    /* renamed from: ah */
    public int mo8254ah() {
        return getIntFromAdObject("close_button_top_margin", ((Integer) this.sdk.mo8549a(C1841c.f5906cA)).intValue());
    }

    /* renamed from: ai */
    public int mo8255ai() {
        return getIntFromAdObject("close_button_horizontal_margin", ((Integer) this.sdk.mo8549a(C1841c.f5956cy)).intValue());
    }

    /* renamed from: aj */
    public boolean mo8256aj() {
        return getBooleanFromAdObject("lhs_close_button", (Boolean) this.sdk.mo8549a(C1841c.f5955cx));
    }

    /* renamed from: ak */
    public boolean mo8257ak() {
        return getBooleanFromAdObject("lhs_skip_button", (Boolean) this.sdk.mo8549a(C1841c.f5921cP));
    }

    /* renamed from: al */
    public boolean mo8258al() {
        return getBooleanFromAdObject("unhide_adview_on_render", false);
    }

    /* renamed from: am */
    public long mo8259am() {
        long longFromAdObject = getLongFromAdObject("report_reward_duration", -1);
        if (longFromAdObject >= 0) {
            return TimeUnit.SECONDS.toMillis(longFromAdObject);
        }
        return -1;
    }

    /* renamed from: an */
    public int mo8260an() {
        return getIntFromAdObject("report_reward_percent", -1);
    }

    /* renamed from: ao */
    public boolean mo8261ao() {
        return getBooleanFromAdObject("report_reward_percent_include_close_delay", true);
    }

    /* renamed from: ap */
    public AtomicBoolean mo8262ap() {
        return this.f5708b;
    }

    /* renamed from: aq */
    public boolean mo8263aq() {
        return getBooleanFromAdObject("show_nia", false);
    }

    /* renamed from: ar */
    public String mo8264ar() {
        return getStringFromAdObject("nia_title", "");
    }

    /* renamed from: as */
    public String mo8265as() {
        return getStringFromAdObject("nia_message", "");
    }

    /* renamed from: at */
    public String mo8266at() {
        return getStringFromAdObject("nia_button_title", "");
    }

    /* renamed from: au */
    public boolean mo8267au() {
        return getBooleanFromAdObject("avoms", false);
    }

    /* renamed from: av */
    public boolean mo8268av() {
        return this.f5711e;
    }

    /* renamed from: aw */
    public List<C1846a> mo8269aw() {
        List<C1846a> a;
        List<C1846a> list = this.f5712f;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            a = C2029r.m8001a("video_end_urls", this.adObject, getClCode(), mo7152b(), this.sdk);
            this.f5712f = a;
        }
        return a;
    }

    /* renamed from: ax */
    public List<C1846a> mo8270ax() {
        List<C1846a> a;
        List<C1846a> list = this.f5713g;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            a = C2029r.m8001a("ad_closed_urls", this.adObject, getClCode(), (String) null, this.sdk);
            this.f5713g = a;
        }
        return a;
    }

    /* renamed from: ay */
    public List<C1846a> mo8271ay() {
        List<C1846a> a;
        List<C1846a> list = this.f5714h;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            a = C2029r.m8001a("app_killed_urls", this.adObject, getClCode(), (String) null, this.sdk);
            this.f5714h = a;
        }
        return a;
    }

    /* renamed from: az */
    public List<C1846a> mo7151az() {
        List<C1846a> a;
        List<C1846a> list = this.f5715i;
        if (list != null) {
            return list;
        }
        synchronized (this.adObjectLock) {
            a = C2029r.m8003a("imp_urls", this.adObject, getClCode(), C1989e.m7834a("{SOC}", String.valueOf(mo8268av())), (String) null, mo8231aA(), this.sdk);
            this.f5715i = a;
        }
        return a;
    }

    /* renamed from: b */
    public List<C1846a> mo8272b(PointF pointF) {
        List<C1846a> a;
        synchronized (this.adObjectLock) {
            a = C2029r.m8004a("video_click_tracking_urls", this.adObject, m6920c(pointF, true), (String) null, mo8231aA(), this.sdk);
        }
        return a.isEmpty() ? m6914a(pointF, true) : a;
    }

    /* renamed from: b */
    public void mo8273b(Uri uri) {
        this.f5707a.add(uri);
    }

    /* renamed from: b */
    public void mo8274b(boolean z) {
        this.f5711e = z;
    }

    /* renamed from: c */
    public abstract String mo7153c();

    /* renamed from: c */
    public void mo8275c(Uri uri) {
        synchronized (this.adObjectLock) {
            C1993i.m7885a(this.adObject, "mute_image", (Object) uri, this.sdk);
        }
    }

    /* renamed from: d */
    public void mo8276d(Uri uri) {
        synchronized (this.adObjectLock) {
            C1993i.m7885a(this.adObject, "unmute_image", (Object) uri, this.sdk);
        }
    }

    /* renamed from: d */
    public boolean mo7154d() {
        this.sdk.mo8602v().mo8746e("DirectAd", "Attempting to invoke isVideoStream() from base ad class");
        return false;
    }

    /* renamed from: f */
    public Uri mo7157f() {
        this.sdk.mo8602v().mo8746e("DirectAd", "Attempting to invoke getVideoUri() from base ad class");
        return null;
    }

    /* renamed from: h */
    public Uri mo7160h() {
        this.sdk.mo8602v().mo8746e("DirectAd", "Attempting to invoke getClickDestinationUri() from base ad class");
        return null;
    }

    /* renamed from: i */
    public Uri mo7163i() {
        this.sdk.mo8602v().mo8746e("DirectAd", "Attempting to invoke getVideoClickDestinationUri() from base ad class");
        return null;
    }

    /* renamed from: n */
    public boolean mo8277n() {
        return getBooleanFromAdObject("fs_2", false);
    }

    /* renamed from: o */
    public C1830b mo8278o() {
        String upperCase = getStringFromAdObject("ad_target", C1830b.DEFAULT.toString()).toUpperCase(Locale.ENGLISH);
        return "ACTIVITY_PORTRAIT".equalsIgnoreCase(upperCase) ? C1830b.ACTIVITY_PORTRAIT : "ACTIVITY_LANDSCAPE".equalsIgnoreCase(upperCase) ? C1830b.ACTIVITY_LANDSCAPE : C1830b.DEFAULT;
    }

    /* renamed from: p */
    public long mo8279p() {
        return getLongFromAdObject("close_delay", 0);
    }

    /* renamed from: q */
    public long mo8280q() {
        return TimeUnit.SECONDS.toMillis(getLongFromAdObject("close_delay_max_buffering_time_seconds", 5));
    }

    /* renamed from: r */
    public long mo8281r() {
        long longFromAdObject = getLongFromAdObject("close_delay_graphic", 0);
        if (!mo8277n()) {
            return longFromAdObject;
        }
        if (longFromAdObject == -1 || longFromAdObject == -2) {
            return 0;
        }
        return longFromAdObject;
    }

    /* renamed from: s */
    public C1563h.C1564a mo8282s() {
        int intFromAdObject = getIntFromAdObject("close_style", -1);
        return intFromAdObject == -1 ? m6918c(hasVideoUrl()) : mo8227a(intFromAdObject);
    }

    /* renamed from: t */
    public C1563h.C1564a mo8283t() {
        int intFromAdObject = getIntFromAdObject("skip_style", -1);
        return intFromAdObject == -1 ? mo8282s() : mo8227a(intFromAdObject);
    }

    /* renamed from: u */
    public boolean mo8284u() {
        return getBooleanFromAdObject("dismiss_on_skip", false);
    }

    /* renamed from: v */
    public boolean mo8285v() {
        return getBooleanFromAdObject("html_resources_cached", false);
    }

    /* renamed from: w */
    public List<Uri> mo8286w() {
        return this.f5707a;
    }

    /* renamed from: x */
    public String mo8287x() {
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("video_button_properties", (JSONObject) null);
        return jsonObjectFromAdObject != null ? C1993i.m7896b(jsonObjectFromAdObject, "video_button_html", "", this.sdk) : "";
    }

    /* renamed from: y */
    public C1628s mo8288y() {
        return new C1628s(getJsonObjectFromAdObject("video_button_properties", (JSONObject) null), this.sdk);
    }

    /* renamed from: z */
    public boolean mo7169z() {
        return getBooleanFromAdObject("video_clickable", false);
    }
}
