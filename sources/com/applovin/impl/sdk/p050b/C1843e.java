package com.applovin.impl.sdk.p050b;

import java.util.HashSet;

/* renamed from: com.applovin.impl.sdk.b.e */
public class C1843e<T> {

    /* renamed from: A */
    public static final C1843e<String> f6086A;

    /* renamed from: a */
    public static final C1843e<String> f6087a;

    /* renamed from: b */
    public static final C1843e<Boolean> f6088b;

    /* renamed from: c */
    public static final C1843e<String> f6089c;

    /* renamed from: d */
    public static final C1843e<String> f6090d;

    /* renamed from: e */
    public static final C1843e<String> f6091e;

    /* renamed from: f */
    public static final C1843e<String> f6092f;

    /* renamed from: g */
    public static final C1843e<String> f6093g;

    /* renamed from: h */
    public static final C1843e<String> f6094h;

    /* renamed from: i */
    public static final C1843e<String> f6095i;

    /* renamed from: j */
    public static final C1843e<Boolean> f6096j;

    /* renamed from: k */
    public static final C1843e<Boolean> f6097k;

    /* renamed from: l */
    public static final C1843e<Boolean> f6098l;

    /* renamed from: m */
    public static final C1843e<HashSet> f6099m = new C1843e<>("com.applovin.sdk.impl.postbackQueue.key", HashSet.class);

    /* renamed from: n */
    public static final C1843e<String> f6100n;

    /* renamed from: o */
    public static final C1843e<String> f6101o;

    /* renamed from: p */
    public static final C1843e<HashSet> f6102p = new C1843e<>("com.applovin.sdk.task.stats", HashSet.class);

    /* renamed from: q */
    public static final C1843e<String> f6103q;

    /* renamed from: r */
    public static final C1843e<String> f6104r;

    /* renamed from: s */
    public static final C1843e<String> f6105s;

    /* renamed from: t */
    public static final C1843e<HashSet> f6106t = new C1843e<>("com.applovin.sdk.ad.stats", HashSet.class);

    /* renamed from: u */
    public static final C1843e<Integer> f6107u = new C1843e<>("com.applovin.sdk.last_video_position", Integer.class);

    /* renamed from: v */
    public static final C1843e<Boolean> f6108v;

    /* renamed from: w */
    public static final C1843e<String> f6109w;

    /* renamed from: x */
    public static final C1843e<String> f6110x;

    /* renamed from: y */
    public static final C1843e<String> f6111y;

    /* renamed from: z */
    public static final C1843e<String> f6112z;

    /* renamed from: B */
    private final String f6113B;

    /* renamed from: C */
    private final Class<T> f6114C;

    static {
        Class<Boolean> cls = Boolean.class;
        Class<String> cls2 = String.class;
        f6087a = new C1843e<>("com.applovin.sdk.impl.isFirstRun", cls2);
        f6088b = new C1843e<>("com.applovin.sdk.launched_before", cls);
        f6089c = new C1843e<>("com.applovin.sdk.user_id", cls2);
        f6090d = new C1843e<>("com.applovin.sdk.compass_id", cls2);
        f6091e = new C1843e<>("com.applovin.sdk.compass_random_token", cls2);
        f6092f = new C1843e<>("com.applovin.sdk.applovin_random_token", cls2);
        f6093g = new C1843e<>("com.applovin.sdk.device_test_group", cls2);
        f6094h = new C1843e<>("com.applovin.sdk.local_test_group", cls2);
        f6095i = new C1843e<>("com.applovin.sdk.variables", cls2);
        f6096j = new C1843e<>("com.applovin.sdk.compliance.has_user_consent", cls);
        f6097k = new C1843e<>("com.applovin.sdk.compliance.is_age_restricted_user", cls);
        f6098l = new C1843e<>("com.applovin.sdk.compliance.is_do_not_sell", cls);
        f6100n = new C1843e<>("com.applovin.sdk.stats", cls2);
        f6101o = new C1843e<>("com.applovin.sdk.errors", cls2);
        f6103q = new C1843e<>("com.applovin.sdk.network_response_code_mapping", cls2);
        f6104r = new C1843e<>("com.applovin.sdk.event_tracking.super_properties", cls2);
        f6105s = new C1843e<>("com.applovin.sdk.request_tracker.counter", cls2);
        f6108v = new C1843e<>("com.applovin.sdk.should_resume_video", cls);
        f6109w = new C1843e<>("com.applovin.sdk.mediation.signal_providers", cls2);
        f6110x = new C1843e<>("com.applovin.sdk.mediation.auto_init_adapters", cls2);
        f6111y = new C1843e<>("com.applovin.sdk.persisted_data", cls2);
        f6112z = new C1843e<>("com.applovin.sdk.mediation_provider", cls2);
        f6086A = new C1843e<>("com.applovin.sdk.mediation.test_mode_network", cls2);
    }

    public C1843e(String str, Class<T> cls) {
        this.f6113B = str;
        this.f6114C = cls;
    }

    /* renamed from: a */
    public String mo8312a() {
        return this.f6113B;
    }

    /* renamed from: b */
    public Class<T> mo8313b() {
        return this.f6114C;
    }

    public String toString() {
        return "Key{name='" + this.f6113B + '\'' + ", type=" + this.f6114C + '}';
    }
}
