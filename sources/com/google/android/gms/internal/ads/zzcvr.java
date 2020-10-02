package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcvr implements zzdak<zzcvs> {
    private final zzawd zzbnp;
    private final zzdhe zzfll;
    private final zzdak<zzdan> zzglr;
    private final Context zzvf;

    public zzcvr(zzcxg<zzdan> zzcxg, zzdhe zzdhe, Context context, zzawd zzawd) {
        this.zzglr = zzcxg;
        this.zzfll = zzdhe;
        this.zzvf = context;
        this.zzbnp = zzawd;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcvs zza(zzdan zzdan) {
        boolean z;
        String str;
        int i;
        int i2;
        float f;
        String str2;
        int i3;
        int i4;
        int i5;
        DisplayMetrics displayMetrics;
        zzum zzum = this.zzfll.zzbmp;
        zzum[] zzumArr = zzum.zzcex;
        if (zzumArr != null) {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzum zzum2 : zzumArr) {
                if (!zzum2.zzcey && !z2) {
                    str = zzum2.zzacf;
                    z2 = true;
                }
                if (zzum2.zzcey && !z3) {
                    z3 = true;
                    z = true;
                }
                if (z2 && z3) {
                    break;
                }
            }
        } else {
            str = zzum.zzacf;
            z = zzum.zzcey;
        }
        Resources resources = this.zzvf.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f = 0.0f;
            i2 = 0;
            i = 0;
        } else {
            float f2 = displayMetrics.density;
            int i6 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
            str2 = this.zzbnp.zzwb().zzxc();
            i2 = i6;
            f = f2;
        }
        StringBuilder sb = new StringBuilder();
        zzum[] zzumArr2 = zzum.zzcex;
        if (zzumArr2 != null) {
            boolean z4 = false;
            for (zzum zzum3 : zzumArr2) {
                if (zzum3.zzcey) {
                    z4 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    if (zzum3.width != -1 || f == 0.0f) {
                        i4 = zzum3.width;
                    } else {
                        i4 = (int) (((float) zzum3.widthPixels) / f);
                    }
                    sb.append(i4);
                    sb.append("x");
                    if (zzum3.height == -2) {
                        if (f != 0.0f) {
                            i5 = (int) (((float) zzum3.heightPixels) / f);
                            sb.append(i5);
                        }
                    }
                    i5 = zzum3.height;
                    sb.append(i5);
                }
            }
            if (z4) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, "|");
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzcvs(zzum, str, z, sb.toString(), f, i2, i, str2, this.zzfll.zzglu);
    }

    public final zzdri<zzcvs> zzaqa() {
        return zzdqw.zzb(this.zzglr.zzaqa(), new zzcvu(this), (Executor) zzbab.zzdzw);
    }
}
