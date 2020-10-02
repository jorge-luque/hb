package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzq;

@TargetApi(24)
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public class zzaxo extends zzaxl {
    private static boolean zze(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    public final boolean zza(Activity activity, Configuration configuration) {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcqm)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqo)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzvj.zzpr();
        int zzc = zzazm.zzc(activity, configuration.screenHeightDp);
        int zzc2 = zzazm.zzc(activity, configuration.screenWidthDp);
        zzq.zzkw();
        DisplayMetrics zza = zzaxa.zza((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = zza.heightPixels;
        int i2 = zza.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        double d = (double) activity.getResources().getDisplayMetrics().density;
        Double.isNaN(d);
        int round = ((int) Math.round(d + 0.5d)) * ((Integer) zzvj.zzpv().zzd(zzzz.zzcql)).intValue();
        if (!(zze(i, zzc + dimensionPixelSize, round) && zze(i2, zzc2, round))) {
            return true;
        }
        return false;
    }
}
