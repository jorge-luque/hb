package com.tapjoy.internal;

import com.tapjoy.TapjoyConstants;
import com.tapjoy.internal.C3141gj;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;

/* renamed from: com.tapjoy.internal.fy */
public final class C3136fy extends C3141gj {

    /* renamed from: a */
    static final Map f8724a = Collections.unmodifiableMap(new HashMap());

    /* renamed from: c */
    private final C3141gj.C3142a f8725c = mo18531a("BuildConfig");

    /* renamed from: d */
    private final C3141gj.C3142a f8726d = mo18531a("ServerFinal");

    /* renamed from: e */
    private final C3141gj.C3142a f8727e;

    /* renamed from: f */
    private final C3141gj.C3142a f8728f;

    /* renamed from: g */
    private final C3141gj.C3142a f8729g;

    C3136fy() {
        C3141gj.C3142a a = mo18531a("AppRuntime");
        this.f8727e = a;
        a.f8746b = new ConcurrentHashMap();
        this.f8728f = mo18531a("ConnectFlags");
        this.f8729g = mo18531a("ServerDefault");
        C3141gj.C3142a a2 = mo18531a("SDKDefault");
        HashMap hashMap = new HashMap();
        hashMap.put("placement_request_content_retry_timeout", -1);
        hashMap.put("placement_request_content_retry_backoff", Arrays.asList(new Number[]{0L, 500L, Long.valueOf(TapjoyConstants.TIMER_INCREMENT), Double.valueOf(2.0d)}));
        a2.f8746b = hashMap;
    }

    /* renamed from: a */
    public final void mo18516a(@Nullable Map map) {
        Map map2;
        Map map3 = null;
        if (map != null) {
            map3 = (Map) map.get("final");
            map2 = (Map) map.get("default");
        } else {
            map2 = null;
        }
        this.f8726d.f8746b = map3;
        this.f8729g.f8746b = map2;
        setChanged();
    }

    /* renamed from: a */
    public final void mo18515a(Hashtable hashtable) {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : hashtable.entrySet()) {
            String str = (String) f8724a.get(entry.getKey());
            if (str == null) {
                str = (String) entry.getKey();
            }
            this.f8727e.f8746b.remove(str);
            hashMap.put(str, entry.getValue());
        }
        this.f8728f.f8746b = hashMap;
        setChanged();
    }
}
