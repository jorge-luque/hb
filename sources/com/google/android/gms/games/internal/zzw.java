package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zzg;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzw extends zzg.zzx<T> {
    private final /* synthetic */ DataHolder zzhj;
    private final /* synthetic */ zzg.zzar zzhm;
    private final /* synthetic */ ArrayList zzhn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzw(zzg.zzar zzar, DataHolder dataHolder, ArrayList arrayList) {
        super((zzf) null);
        this.zzhm = zzar;
        this.zzhj = dataHolder;
        this.zzhn = arrayList;
    }

    public final void notifyListener(T t) {
        this.zzhm.zza(t, zzg.zzay(this.zzhj), this.zzhn);
    }
}
