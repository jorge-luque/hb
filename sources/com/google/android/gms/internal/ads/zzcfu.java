package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcfu {
    @GuardedBy("this")
    private final Map<String, zzcfv> zzfxo = new HashMap();

    zzcfu() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(String str, zzdhq zzdhq) {
        if (!this.zzfxo.containsKey(str)) {
            try {
                this.zzfxo.put(str, new zzcfv(str, zzdhq.zztn(), zzdhq.zzto()));
            } catch (zzdhk unused) {
            }
        }
    }

    @Nullable
    public final synchronized zzcfv zzge(String str) {
        return this.zzfxo.get(str);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(String str, zzanv zzanv) {
        if (!this.zzfxo.containsKey(str)) {
            try {
                this.zzfxo.put(str, new zzcfv(str, zzanv.zztn(), zzanv.zzto()));
            } catch (Throwable unused) {
            }
        }
    }
}
