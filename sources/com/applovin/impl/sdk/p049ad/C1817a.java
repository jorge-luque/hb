package com.applovin.impl.sdk.p049ad;

import android.net.Uri;
import com.applovin.impl.adview.C1563h;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2025o;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.a */
public final class C1817a extends C1827g {

    /* renamed from: a */
    private final String f5649a = mo7152b();

    /* renamed from: b */
    private final String f5650b = mo8161g();

    /* renamed from: c */
    private final String f5651c = m6836aQ();

    public C1817a(JSONObject jSONObject, JSONObject jSONObject2, C1818b bVar, C1941j jVar) {
        super(jSONObject, jSONObject2, bVar, jVar);
    }

    /* renamed from: aQ */
    private String m6836aQ() {
        return getStringFromAdObject("stream_url", "");
    }

    /* renamed from: a */
    public void mo7144a() {
        synchronized (this.adObjectLock) {
            C1993i.m7886a(this.adObject, TJAdUnitConstants.String.HTML, this.f5649a, this.sdk);
            C1993i.m7886a(this.adObject, "stream_url", this.f5651c, this.sdk);
        }
    }

    /* renamed from: a */
    public void mo8158a(Uri uri) {
        synchronized (this.adObjectLock) {
            C1993i.m7886a(this.adObject, "video", uri.toString(), this.sdk);
        }
    }

    /* renamed from: a */
    public void mo8159a(String str) {
        synchronized (this.adObjectLock) {
            C1993i.m7886a(this.adObject, TJAdUnitConstants.String.HTML, str, this.sdk);
        }
    }

    /* renamed from: b */
    public String mo7152b() {
        String b;
        synchronized (this.adObjectLock) {
            b = C1993i.m7896b(this.adObject, TJAdUnitConstants.String.HTML, (String) null, this.sdk);
        }
        return b;
    }

    /* renamed from: c */
    public String mo7153c() {
        return this.f5650b;
    }

    /* renamed from: d */
    public boolean mo7154d() {
        return this.adObject.has("stream_url");
    }

    /* renamed from: e */
    public void mo8160e() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("stream_url");
        }
    }

    /* renamed from: f */
    public Uri mo7157f() {
        String aQ = m6836aQ();
        if (C2025o.m7963b(aQ)) {
            return Uri.parse(aQ);
        }
        String g = mo8161g();
        if (C2025o.m7963b(g)) {
            return Uri.parse(g);
        }
        return null;
    }

    /* renamed from: g */
    public String mo8161g() {
        return getStringFromAdObject("video", "");
    }

    /* renamed from: h */
    public Uri mo7160h() {
        String stringFromAdObject = getStringFromAdObject("click_url", "");
        if (C2025o.m7963b(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public boolean hasVideoUrl() {
        return mo7157f() != null;
    }

    /* renamed from: i */
    public Uri mo7163i() {
        String stringFromAdObject = getStringFromAdObject("video_click_url", "");
        return C2025o.m7963b(stringFromAdObject) ? Uri.parse(stringFromAdObject) : mo7160h();
    }

    /* renamed from: j */
    public float mo8162j() {
        return getFloatFromAdObject("mraid_close_delay_graphic", 0.0f);
    }

    /* renamed from: k */
    public boolean mo8163k() {
        return getBooleanFromAdObject("close_button_graphic_hidden", false);
    }

    /* renamed from: l */
    public boolean mo8164l() {
        if (this.adObject.has("close_button_expandable_hidden")) {
            return getBooleanFromAdObject("close_button_expandable_hidden", false);
        }
        return true;
    }

    /* renamed from: m */
    public C1563h.C1564a mo8165m() {
        return mo8227a(getIntFromAdObject("expandable_style", C1563h.C1564a.INVISIBLE.mo7440a()));
    }
}
