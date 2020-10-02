package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public abstract class zzdso<PrimitiveT, KeyT> {
    private final Class<PrimitiveT> zzhiy;

    public zzdso(Class<PrimitiveT> cls) {
        this.zzhiy = cls;
    }

    public abstract PrimitiveT zzah(KeyT keyt) throws GeneralSecurityException;

    /* access modifiers changed from: package-private */
    public final Class<PrimitiveT> zzawu() {
        return this.zzhiy;
    }
}
