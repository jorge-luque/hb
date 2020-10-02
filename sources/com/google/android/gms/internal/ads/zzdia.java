package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdia {
    private final zzazz zzbml;
    private final zzawd zzbnp;
    private final Map<String, zzdic> zzgvq = new HashMap();
    private final Context zzzo;

    public zzdia(Context context, zzazz zzazz, zzawd zzawd) {
        this.zzzo = context;
        this.zzbml = zzazz;
        this.zzbnp = zzawd;
    }

    private final zzdic zzasi() {
        return new zzdic(this.zzzo, this.zzbnp.zzwb(), this.zzbnp.zzwd());
    }

    private final zzdic zzgu(String str) {
        zzase zzz = zzase.zzz(this.zzzo);
        try {
            zzz.setAppPackageName(str);
            zzaww zzaww = new zzaww();
            zzaww.zza(this.zzzo, str, false);
            zzawx zzawx = new zzawx(this.zzbnp.zzwb(), zzaww);
            return new zzdic(zzz, zzawx, new zzawo(zzazm.zzyf(), zzawx));
        } catch (PackageManager.NameNotFoundException unused) {
            return zzasi();
        }
    }

    public final zzdic zzgt(String str) {
        if (str == null) {
            return zzasi();
        }
        if (this.zzgvq.containsKey(str)) {
            return this.zzgvq.get(str);
        }
        zzdic zzgu = zzgu(str);
        this.zzgvq.put(str, zzgu);
        return zzgu;
    }
}
