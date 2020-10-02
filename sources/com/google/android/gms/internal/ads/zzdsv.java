package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzedo;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdsv<PrimitiveT, KeyProtoT extends zzedo, PublicKeyProtoT extends zzedo> extends zzdsk<PrimitiveT, KeyProtoT> implements zzdsh<PrimitiveT> {
    private final zzdsy<KeyProtoT, PublicKeyProtoT> zzhjk;
    private final zzdsm<PublicKeyProtoT> zzhjl;

    public zzdsv(zzdsy<KeyProtoT, PublicKeyProtoT> zzdsy, zzdsm<PublicKeyProtoT> zzdsm, Class<PrimitiveT> cls) {
        super(zzdsy, cls);
        this.zzhjk = zzdsy;
        this.zzhjl = zzdsm;
    }
}
