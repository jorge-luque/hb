package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzdad implements zzdah {
    private final Bundle zzgoh;

    zzdad(Bundle bundle) {
        this.zzgoh = bundle;
    }

    public final void zzs(Object obj) {
        ((Bundle) obj).putBundle("shared_pref", this.zzgoh);
    }
}
