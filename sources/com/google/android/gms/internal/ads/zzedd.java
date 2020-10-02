package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzedd implements zzedl {
    private zzedl[] zzhzv;

    zzedd(zzedl... zzedlArr) {
        this.zzhzv = zzedlArr;
    }

    public final boolean zzc(Class<?> cls) {
        for (zzedl zzc : this.zzhzv) {
            if (zzc.zzc(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzedm zzd(Class<?> cls) {
        for (zzedl zzedl : this.zzhzv) {
            if (zzedl.zzc(cls)) {
                return zzedl.zzd(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
