package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.zzq;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcie {
    private final Executor executor;
    private final String packageName;
    private final String zzbnd;
    private final String zzcul = zzabg.zzcvz.get();
    private final zzbaa zzdyh;
    private final Map<String, String> zzfzb = new HashMap();
    private final boolean zzfzi;
    private final Context zzvf;

    public zzcie(Executor executor2, zzbaa zzbaa, Context context, zzazz zzazz) {
        this.executor = executor2;
        this.zzdyh = zzbaa;
        this.zzvf = context;
        this.packageName = context.getPackageName();
        this.zzfzi = ((double) zzvj.zzpy().nextFloat()) <= zzabg.zzcvy.get().doubleValue();
        this.zzbnd = zzazz.zzbnd;
        this.zzfzb.put("s", "gmob_sdk");
        this.zzfzb.put("v", "3");
        this.zzfzb.put("os", Build.VERSION.RELEASE);
        this.zzfzb.put("api_v", Build.VERSION.SDK);
        Map<String, String> map = this.zzfzb;
        zzq.zzkw();
        map.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, zzaxa.zzxh());
        this.zzfzb.put(TapjoyConstants.TJC_APP_PLACEMENT, this.packageName);
        Map<String, String> map2 = this.zzfzb;
        zzq.zzkw();
        map2.put("is_lite_sdk", zzaxa.zzay(this.zzvf) ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.zzfzb.put("e", TextUtils.join(",", zzzz.zzrb()));
        this.zzfzb.put("sdkVersion", this.zzbnd);
    }

    public final Map<String, String> zzaob() {
        return new HashMap(this.zzfzb);
    }

    public final ConcurrentHashMap<String, String> zzaoc() {
        return new ConcurrentHashMap<>(this.zzfzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzgg(String str) {
        this.zzdyh.zzeq(str);
    }

    /* access modifiers changed from: package-private */
    public final void zzn(Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(this.zzcul).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        String uri = buildUpon.build().toString();
        if (this.zzfzi) {
            this.executor.execute(new zzcih(this, uri));
        }
        zzawr.zzeg(uri);
    }
}
