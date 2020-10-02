package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzt extends zzg.zzx<T> {
    private final /* synthetic */ zzg.zzaq zzhi;
    private final /* synthetic */ DataHolder zzhj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzt(zzg.zzaq zzaq, DataHolder dataHolder) {
        super((zzf) null);
        this.zzhi = zzaq;
        this.zzhj = dataHolder;
    }

    public final void notifyListener(T t) {
        this.zzhi.zza(t, zzg.zzay(this.zzhj));
    }
}
