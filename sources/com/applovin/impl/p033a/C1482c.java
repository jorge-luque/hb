package com.applovin.impl.p033a;

import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p049ad.C1818b;
import com.applovin.impl.sdk.p049ad.C1821d;
import com.applovin.impl.sdk.utils.C1989e;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.impl.sdk.utils.C2032t;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.a.c */
public class C1482c {

    /* renamed from: c */
    private static final List<String> f4620c = Arrays.asList(new String[]{"video/mp4", "video/webm", "video/3gpp", "video/x-matroska"});

    /* renamed from: a */
    protected List<C2032t> f4621a = new ArrayList();

    /* renamed from: b */
    private final C1941j f4622b;

    /* renamed from: d */
    private final JSONObject f4623d;

    /* renamed from: e */
    private final JSONObject f4624e;

    /* renamed from: f */
    private final C1818b f4625f;

    /* renamed from: g */
    private final long f4626g = System.currentTimeMillis();

    public C1482c(JSONObject jSONObject, JSONObject jSONObject2, C1818b bVar, C1941j jVar) {
        this.f4622b = jVar;
        this.f4623d = jSONObject;
        this.f4624e = jSONObject2;
        this.f4625f = bVar;
    }

    /* renamed from: a */
    public int mo7190a() {
        return this.f4621a.size();
    }

    /* renamed from: b */
    public List<C2032t> mo7191b() {
        return this.f4621a;
    }

    /* renamed from: c */
    public JSONObject mo7192c() {
        return this.f4623d;
    }

    /* renamed from: d */
    public JSONObject mo7193d() {
        return this.f4624e;
    }

    /* renamed from: e */
    public C1818b mo7194e() {
        return this.f4625f;
    }

    /* renamed from: f */
    public long mo7195f() {
        return this.f4626g;
    }

    /* renamed from: g */
    public C1821d mo7196g() {
        String b = C1993i.m7896b(this.f4624e, "zone_id", (String) null, this.f4622b);
        return C1821d.m6858a(AppLovinAdSize.fromString(C1993i.m7896b(this.f4624e, "ad_size", (String) null, this.f4622b)), AppLovinAdType.fromString(C1993i.m7896b(this.f4624e, "ad_type", (String) null, this.f4622b)), b, this.f4622b);
    }

    /* renamed from: h */
    public List<String> mo7197h() {
        List<String> a = C1989e.m7831a(C1993i.m7896b(this.f4623d, "vast_preferred_video_types", (String) null, (C1941j) null));
        return !a.isEmpty() ? a : f4620c;
    }

    /* renamed from: i */
    public int mo7198i() {
        return C2029r.m7986a(this.f4623d);
    }
}
