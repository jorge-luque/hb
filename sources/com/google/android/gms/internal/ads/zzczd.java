package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzczd implements zzdah<Bundle> {
    private String zzdmh;

    public zzczd(String str) {
        this.zzdmh = str;
    }

    public final /* synthetic */ void zzs(Object obj) {
        ((Bundle) obj).putString("request_id", this.zzdmh);
    }
}
