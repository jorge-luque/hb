package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.webkit.WebSettings;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.adview.v */
public final class C1632v {

    /* renamed from: a */
    private C1941j f5079a;

    /* renamed from: b */
    private JSONObject f5080b;

    public C1632v(JSONObject jSONObject, C1941j jVar) {
        this.f5079a = jVar;
        this.f5080b = jSONObject;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(21)
    /* renamed from: a */
    public Integer mo7554a() {
        int i;
        String b = C1993i.m7896b(this.f5080b, "mixed_content_mode", (String) null, this.f5079a);
        if (C2025o.m7963b(b)) {
            if ("always_allow".equalsIgnoreCase(b)) {
                i = 0;
            } else if ("never_allow".equalsIgnoreCase(b)) {
                i = 1;
            } else if ("compatibility_mode".equalsIgnoreCase(b)) {
                i = 2;
            }
            return Integer.valueOf(i);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public WebSettings.PluginState mo7555b() {
        String b = C1993i.m7896b(this.f5080b, "plugin_state", (String) null, this.f5079a);
        if (C2025o.m7963b(b)) {
            if (TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON.equalsIgnoreCase(b)) {
                return WebSettings.PluginState.ON;
            }
            if ("on_demand".equalsIgnoreCase(b)) {
                return WebSettings.PluginState.ON_DEMAND;
            }
            if ("off".equalsIgnoreCase(b)) {
                return WebSettings.PluginState.OFF;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Boolean mo7556c() {
        return C1993i.m7871a(this.f5080b, "allow_file_access", (Boolean) null, this.f5079a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Boolean mo7557d() {
        return C1993i.m7871a(this.f5080b, "load_with_overview_mode", (Boolean) null, this.f5079a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Boolean mo7558e() {
        return C1993i.m7871a(this.f5080b, "use_wide_view_port", (Boolean) null, this.f5079a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public Boolean mo7559f() {
        return C1993i.m7871a(this.f5080b, "allow_content_access", (Boolean) null, this.f5079a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public Boolean mo7560g() {
        return C1993i.m7871a(this.f5080b, "use_built_in_zoom_controls", (Boolean) null, this.f5079a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public Boolean mo7561h() {
        return C1993i.m7871a(this.f5080b, "display_zoom_controls", (Boolean) null, this.f5079a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public Boolean mo7562i() {
        return C1993i.m7871a(this.f5080b, "save_form_data", (Boolean) null, this.f5079a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public Boolean mo7563j() {
        return C1993i.m7871a(this.f5080b, "geolocation_enabled", (Boolean) null, this.f5079a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public Boolean mo7564k() {
        return C1993i.m7871a(this.f5080b, "need_initial_focus", (Boolean) null, this.f5079a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public Boolean mo7565l() {
        return C1993i.m7871a(this.f5080b, "allow_file_access_from_file_urls", (Boolean) null, this.f5079a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public Boolean mo7566m() {
        return C1993i.m7871a(this.f5080b, "allow_universal_access_from_file_urls", (Boolean) null, this.f5079a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public Boolean mo7567n() {
        return C1993i.m7871a(this.f5080b, "offscreen_pre_raster", (Boolean) null, this.f5079a);
    }
}
