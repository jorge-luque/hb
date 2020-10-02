package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzcmo implements Callable {
    private final zzcmn zzgdb;

    private zzcmo(zzcmn zzcmn) {
        this.zzgdb = zzcmn;
    }

    static Callable zza(zzcmn zzcmn) {
        return new zzcmo(zzcmn);
    }

    public final Object call() {
        return this.zzgdb.getWritableDatabase();
    }
}
