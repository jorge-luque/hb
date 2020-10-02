package com.google.android.gms.internal.ads;

import com.tapjoy.TapjoyConstants;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzabe {
    private static zzaaz<Boolean> zzcvs = zzaba.zzf("gads:consent:gmscore:dsid:enabled", true);
    private static zzaaz<Boolean> zzcvt = zzaba.zzf("gads:consent:gmscore:lat:enabled", true);
    private static zzaaz<String> zzcvu = new zzaba("gads:consent:gmscore:backend_url", "https://adservice.google.com/getconfig/pubvendors", zzabb.zzcvk);
    private static zzaaz<Long> zzcvv = new zzaba("gads:consent:gmscore:time_out", Long.valueOf(TapjoyConstants.TIMER_INCREMENT), zzabb.zzcvi);
    private static zzaaz<Boolean> zzcvw = zzaba.zzf("gads:consent:gmscore:enabled", true);

    public static final void zza(zzaca zzaca) {
    }
}
