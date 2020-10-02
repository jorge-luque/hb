package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxp;
import com.loopj.android.http.C4250c;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdsu<P> {
    private static final Charset UTF_8 = Charset.forName(C4250c.DEFAULT_CHARSET);
    private final Class<P> zzhix;
    private ConcurrentMap<String, List<zzdst<P>>> zzhji = new ConcurrentHashMap();
    private zzdst<P> zzhjj;

    private zzdsu(Class<P> cls) {
        this.zzhix = cls;
    }

    public static <P> zzdsu<P> zza(Class<P> cls) {
        return new zzdsu<>(cls);
    }

    public final Class<P> zzawu() {
        return this.zzhix;
    }

    public final zzdst<P> zzaxh() {
        return this.zzhjj;
    }

    public final void zza(zzdst<P> zzdst) {
        if (zzdst == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        } else if (zzdst.zzaxe() == zzdxj.ENABLED) {
            List list = (List) this.zzhji.get(new String(zzdst.zzaxg(), UTF_8));
            if (list == null) {
                list = Collections.emptyList();
            }
            if (!list.isEmpty()) {
                this.zzhjj = zzdst;
                return;
            }
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        } else {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
    }

    public final zzdst<P> zza(P p, zzdxp.zza zza) throws GeneralSecurityException {
        byte[] bArr;
        if (zza.zzaxe() == zzdxj.ENABLED) {
            int i = zzdsg.zzhiu[zza.zzaxf().ordinal()];
            if (i == 1 || i == 2) {
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zza.zzbaw()).array();
            } else if (i == 3) {
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zza.zzbaw()).array();
            } else if (i == 4) {
                bArr = zzdsd.zzhit;
            } else {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            zzdst zzdst = new zzdst(p, bArr, zza.zzaxe(), zza.zzaxf(), zza.zzbaw());
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzdst);
            String str = new String(zzdst.zzaxg(), UTF_8);
            List list = (List) this.zzhji.put(str, Collections.unmodifiableList(arrayList));
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list);
                arrayList2.add(zzdst);
                this.zzhji.put(str, Collections.unmodifiableList(arrayList2));
            }
            return zzdst;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }
}
