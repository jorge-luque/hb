package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzaiw implements Predicate {
    private final zzaga zzdcf;

    zzaiw(zzaga zzaga) {
        this.zzdcf = zzaga;
    }

    public final boolean apply(Object obj) {
        zzaga zzaga = (zzaga) obj;
        return (zzaga instanceof zzajd) && ((zzajd) zzaga).zzdcl.equals(this.zzdcf);
    }
}
