package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcvv implements zzdah {
    private final ArrayList zzglx;

    zzcvv(ArrayList arrayList) {
        this.zzglx = arrayList;
    }

    public final void zzs(Object obj) {
        ((Bundle) obj).putStringArrayList("ad_types", this.zzglx);
    }
}
