package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public class zzbwx {
    private final zzbek zzdce;
    private final zzbxz zzfoz;

    public zzbwx(zzbxz zzbxz) {
        this(zzbxz, (zzbek) null);
    }

    public Set<zzbvt<zzbqx>> zza(zzbyd zzbyd) {
        return Collections.singleton(zzbvt.zzb(zzbyd, zzbab.zzdzw));
    }

    public final zzbek zzags() {
        return this.zzdce;
    }

    public final zzbxz zzajv() {
        return this.zzfoz;
    }

    public final View zzajw() {
        zzbek zzbek = this.zzdce;
        if (zzbek != null) {
            return zzbek.getWebView();
        }
        return null;
    }

    public final View zzajx() {
        zzbek zzbek = this.zzdce;
        if (zzbek == null) {
            return null;
        }
        return zzbek.getWebView();
    }

    public final zzbvt<zzbtq> zzb(Executor executor) {
        return new zzbvt<>(new zzbwz(this.zzdce), executor);
    }

    public zzbwx(zzbxz zzbxz, zzbek zzbek) {
        this.zzfoz = zzbxz;
        this.zzdce = zzbek;
    }
}
