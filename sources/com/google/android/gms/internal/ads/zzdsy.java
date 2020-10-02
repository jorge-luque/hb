package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedo;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public abstract class zzdsy<KeyProtoT extends zzedo, PublicKeyProtoT extends zzedo> extends zzdsm<KeyProtoT> {
    private final Class<PublicKeyProtoT> zzhjr;

    @SafeVarargs
    protected zzdsy(Class<KeyProtoT> cls, Class<PublicKeyProtoT> cls2, zzdso<?, KeyProtoT>... zzdsoArr) {
        super(cls, zzdsoArr);
        this.zzhjr = cls2;
    }
}
