package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzccp {
    public final int type = 2;
    public final String zzcc;
    public final String zzfvq;
    public final zzace zzfvr;

    @VisibleForTesting
    public zzccp(String str, String str2) {
        this.zzcc = str;
        this.zzfvq = str2;
        this.zzfvr = null;
    }

    @VisibleForTesting
    public zzccp(String str, zzace zzace) {
        this.zzcc = str;
        this.zzfvq = null;
        this.zzfvr = zzace;
    }
}
