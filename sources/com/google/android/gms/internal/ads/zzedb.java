package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzedb implements zzeej {
    private static final zzedl zzhzs = new zzede();
    private final zzedl zzhzr;

    public zzedb() {
        this(new zzedd(zzecb.zzben(), zzbfw()));
    }

    private static boolean zza(zzedm zzedm) {
        return zzedm.zzbge() == zzecd.zzf.zzhyj;
    }

    private static zzedl zzbfw() {
        try {
            return (zzedl) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzhzs;
        }
    }

    public final <T> zzeek<T> zzg(Class<T> cls) {
        Class<zzecd> cls2 = zzecd.class;
        zzeem.zzi(cls);
        zzedm zzd = this.zzhzr.zzd(cls);
        if (zzd.zzbgf()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzedu.zza(zzeem.zzbgx(), zzebu.zzbeh(), zzd.zzbgg());
            }
            return zzedu.zza(zzeem.zzbgv(), zzebu.zzbei(), zzd.zzbgg());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zza(zzd)) {
                return zzeds.zza(cls, zzd, zzedy.zzbgi(), zzecy.zzbfv(), zzeem.zzbgx(), zzebu.zzbeh(), zzedj.zzbgc());
            }
            return zzeds.zza(cls, zzd, zzedy.zzbgi(), zzecy.zzbfv(), zzeem.zzbgx(), (zzebs<?>) null, zzedj.zzbgc());
        } else if (zza(zzd)) {
            return zzeds.zza(cls, zzd, zzedy.zzbgh(), zzecy.zzbfu(), zzeem.zzbgv(), zzebu.zzbei(), zzedj.zzbgb());
        } else {
            return zzeds.zza(cls, zzd, zzedy.zzbgh(), zzecy.zzbfu(), zzeem.zzbgw(), (zzebs<?>) null, zzedj.zzbgb());
        }
    }

    private zzedb(zzedl zzedl) {
        this.zzhzr = (zzedl) zzecg.zza(zzedl, "messageInfoFactory");
    }
}
