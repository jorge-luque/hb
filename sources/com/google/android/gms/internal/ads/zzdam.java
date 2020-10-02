package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzdam implements Runnable {
    private final zzdak zzgop;
    private final long zzgoq;

    zzdam(zzdak zzdak, long j) {
        this.zzgop = zzdak;
        this.zzgoq = j;
    }

    public final void run() {
        zzdak zzdak = this.zzgop;
        long j = this.zzgoq;
        String canonicalName = zzdak.getClass().getCanonicalName();
        long elapsedRealtime = zzq.zzld().elapsedRealtime() - j;
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
        sb.append("Signal runtime : ");
        sb.append(canonicalName);
        sb.append(" = ");
        sb.append(elapsedRealtime);
        zzawr.zzeg(sb.toString());
    }
}
