package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzaou implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaos zzdiz;

    zzaou(zzaos zzaos) {
        this.zzdiz = zzaos;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdiz.zzdv("User canceled the download.");
    }
}
