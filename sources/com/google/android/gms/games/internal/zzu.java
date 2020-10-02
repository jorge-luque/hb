package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzu extends zzg.zzx<T> {
    private final /* synthetic */ zzg.zzao zzhk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzu(zzg.zzao zzao) {
        super((zzf) null);
        this.zzhk = zzao;
    }

    public final void notifyListener(T t) {
        this.zzhk.accept(t);
    }
}
