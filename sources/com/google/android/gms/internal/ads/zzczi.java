package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzczi implements zzdak<zzdah<Bundle>> {
    private final String zzfmw;
    private final Context zzvf;

    zzczi(Context context, String str) {
        this.zzvf = context;
        this.zzfmw = str;
    }

    public final zzdri<zzdah<Bundle>> zzaqa() {
        zzczh zzczh;
        if (this.zzfmw == null) {
            zzczh = null;
        } else {
            zzczh = new zzczh(this);
        }
        return zzdqw.zzag(zzczh);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(Bundle bundle) {
        bundle.putString("rewarded_sku_package", this.zzvf.getPackageName());
    }
}
