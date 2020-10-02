package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.zzq;
import com.tapjoy.TapjoyConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzaad {
    private String zzbnd = null;
    private String zzcul;
    private Map<String, String> zzcuo;
    private Context zzvf = null;

    public zzaad(Context context, String str) {
        String str2;
        this.zzvf = context;
        this.zzbnd = str;
        this.zzcul = zzabg.zzcvz.get();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzcuo = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        this.zzcuo.put("v", "3");
        this.zzcuo.put("os", Build.VERSION.RELEASE);
        this.zzcuo.put("api_v", Build.VERSION.SDK);
        Map<String, String> map = this.zzcuo;
        zzq.zzkw();
        map.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, zzaxa.zzxh());
        Map<String, String> map2 = this.zzcuo;
        if (context.getApplicationContext() != null) {
            str2 = context.getApplicationContext().getPackageName();
        } else {
            str2 = context.getPackageName();
        }
        map2.put(TapjoyConstants.TJC_APP_PLACEMENT, str2);
        Map<String, String> map3 = this.zzcuo;
        zzq.zzkw();
        map3.put("is_lite_sdk", zzaxa.zzay(context) ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Future<zzars> zzx = zzq.zzlh().zzx(this.zzvf);
        try {
            this.zzcuo.put("network_coarse", Integer.toString(zzx.get().zzdpy));
            this.zzcuo.put("network_fine", Integer.toString(zzx.get().zzdpz));
        } catch (Exception e) {
            zzq.zzla().zza(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* access modifiers changed from: package-private */
    public final Context getContext() {
        return this.zzvf;
    }

    /* access modifiers changed from: package-private */
    public final String zzkr() {
        return this.zzbnd;
    }

    /* access modifiers changed from: package-private */
    public final String zzrh() {
        return this.zzcul;
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zzri() {
        return this.zzcuo;
    }
}
