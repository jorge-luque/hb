package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
final /* synthetic */ class zzdmc implements OnFailureListener {
    private final zzdma zzhbq;

    zzdmc(zzdma zzdma) {
        this.zzhbq = zzdma;
    }

    public final void onFailure(Exception exc) {
        this.zzhbq.zze(exc);
    }
}
