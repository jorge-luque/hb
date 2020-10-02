package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public class zzbma {
    private final View view;
    private final zzbek zzdce;
    private final zzdgn zzfik;
    private final zzbnt zzfja;

    public zzbma(View view2, zzbek zzbek, zzbnt zzbnt, zzdgn zzdgn) {
        this.view = view2;
        this.zzdce = zzbek;
        this.zzfja = zzbnt;
        this.zzfik = zzdgn;
    }

    public zzbsh zza(Set<zzbvt<zzbsm>> set) {
        return new zzbsh(set);
    }

    public final zzbek zzags() {
        return this.zzdce;
    }

    public final View zzahe() {
        return this.view;
    }

    public final zzbnt zzahm() {
        return this.zzfja;
    }

    public final zzdgn zzahn() {
        return this.zzfik;
    }
}
