package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p118io.fabric.sdk.android.p200m.p203c.C6120b;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcqi {
    /* access modifiers changed from: private */
    public final Clock zzbnt;
    /* access modifiers changed from: private */
    public final zzcqk zzggl;
    private final List<String> zzggm = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public final boolean zzggn;

    public zzcqi(Clock clock, zzcqk zzcqk) {
        this.zzbnt = clock;
        this.zzggl = zzcqk;
        this.zzggn = ((Boolean) zzvj.zzpv().zzd(zzzz.zzcuc)).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final <T> zzdri<T> zza(zzdgq zzdgq, zzdgo zzdgo, zzdri<T> zzdri) {
        long elapsedRealtime = this.zzbnt.elapsedRealtime();
        String str = zzdgo.zzdfq;
        if (str != null) {
            zzdqw.zza(zzdri, new zzcql(this, str, elapsedRealtime, zzdgo, zzdgq), zzbab.zzdzw);
        }
        return zzdri;
    }

    public final String zzape() {
        return TextUtils.join(C6120b.ROLL_OVER_FILE_NAME_SEPARATOR, this.zzggm);
    }

    /* access modifiers changed from: private */
    public final void zza(String str, int i, long j, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append(str);
        sb.append(".");
        sb.append(i);
        sb.append(".");
        sb.append(j);
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 1 + String.valueOf(str2).length());
            sb3.append(sb2);
            sb3.append(".");
            sb3.append(str2);
            sb2 = sb3.toString();
        }
        this.zzggm.add(sb2);
    }
}
