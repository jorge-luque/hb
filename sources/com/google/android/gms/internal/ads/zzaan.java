package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzaan {
    private final Map<String, zzaak> zzcuz = new HashMap();
    private final zzaam zzcva;

    public zzaan(zzaam zzaam) {
        this.zzcva = zzaam;
    }

    public final void zza(String str, zzaak zzaak) {
        this.zzcuz.put(str, zzaak);
    }

    public final zzaam zzrn() {
        return this.zzcva;
    }

    public final void zza(String str, String str2, long j) {
        zzaak zzaak;
        zzaam zzaam = this.zzcva;
        zzaak zzaak2 = this.zzcuz.get(str2);
        String[] strArr = {str};
        if (!(zzaam == null || zzaak2 == null)) {
            zzaam.zza(zzaak2, j, strArr);
        }
        Map<String, zzaak> map = this.zzcuz;
        zzaam zzaam2 = this.zzcva;
        if (zzaam2 == null) {
            zzaak = null;
        } else {
            zzaak = zzaam2.zzex(j);
        }
        map.put(str, zzaak);
    }
}
