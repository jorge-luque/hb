package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedo;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdsj<KeyFormatProtoT extends zzedo, KeyProtoT extends zzedo> {
    private final zzdsl<KeyFormatProtoT, KeyProtoT> zzhiv;

    zzdsj(zzdsl<KeyFormatProtoT, KeyProtoT> zzdsl) {
        this.zzhiv = zzdsl;
    }

    /* access modifiers changed from: package-private */
    public final KeyProtoT zzp(zzeaq zzeaq) throws GeneralSecurityException, zzeco {
        KeyFormatProtoT zzq = this.zzhiv.zzq(zzeaq);
        this.zzhiv.zzc(zzq);
        return (zzedo) this.zzhiv.zzd(zzq);
    }
}
