package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzaxw implements DialogInterface.OnClickListener {
    private final String zzdbv;
    private final zzaxr zzdws;

    zzaxw(zzaxr zzaxr, String str) {
        this.zzdws = zzaxr;
        this.zzdbv = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdws.zza(this.zzdbv, dialogInterface, i);
    }
}
