package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdhn {
    public static void zzc(Throwable th, String str) {
        int zzd = zzcjk.zzd(th);
        StringBuilder sb = new StringBuilder(31);
        sb.append("Ad failed to load : ");
        sb.append(zzd);
        zzazw.zzfb(sb.toString());
        zzawr.zza(str, th);
        if (zzcjk.zzd(th) != 3) {
            zzq.zzla().zzb(th, str);
        }
    }

    public static void zze(Context context, boolean z) {
        if (z) {
            zzazw.zzfb("This request is sent from a test device.");
            return;
        }
        zzvj.zzpr();
        String zzbk = zzazm.zzbk(context);
        StringBuilder sb = new StringBuilder(String.valueOf(zzbk).length() + 101);
        sb.append("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"");
        sb.append(zzbk);
        sb.append("\") to get test ads on this device.");
        zzazw.zzfb(sb.toString());
    }
}
