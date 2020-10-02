package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzczr implements zzdak<zzczs> {
    private final zzauu zzboj;
    private final zzdrh zzfur;
    private final Context zzvf;

    public zzczr(zzauu zzauu, zzdrh zzdrh, Context context) {
        this.zzboj = zzauu;
        this.zzfur = zzdrh;
        this.zzvf = context;
    }

    public final zzdri<zzczs> zzaqa() {
        return this.zzfur.zzd(new zzczu(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzczs zzaqn() throws Exception {
        String str;
        String str2;
        String str3;
        if (!this.zzboj.zzab(this.zzvf)) {
            return new zzczs((String) null, (String) null, (String) null, (String) null, (Long) null);
        }
        String zzae = this.zzboj.zzae(this.zzvf);
        String str4 = zzae == null ? "" : zzae;
        String zzaf = this.zzboj.zzaf(this.zzvf);
        if (zzaf == null) {
            str = "";
        } else {
            str = zzaf;
        }
        String zzag = this.zzboj.zzag(this.zzvf);
        if (zzag == null) {
            str2 = "";
        } else {
            str2 = zzag;
        }
        String zzah = this.zzboj.zzah(this.zzvf);
        if (zzah == null) {
            str3 = "";
        } else {
            str3 = zzah;
        }
        return new zzczs(str4, str, str2, str3, "TIME_OUT".equals(str) ? (Long) zzvj.zzpv().zzd(zzzz.zzckr) : null);
    }
}
