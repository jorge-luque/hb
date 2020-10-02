package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzv extends zzg.zzx<T> {
    private final /* synthetic */ DataHolder zzhj;
    private final /* synthetic */ zzg.zzav zzhl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzv(zzg.zzav zzav, DataHolder dataHolder) {
        super((zzf) null);
        this.zzhl = zzav;
        this.zzhj = dataHolder;
    }

    public final void notifyListener(T t) {
        this.zzhl.zza(t, this.zzhj.getStatusCode(), zzg.zzay(this.zzhj));
    }
}
