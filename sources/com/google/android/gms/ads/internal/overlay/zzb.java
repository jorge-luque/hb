package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.ads.zzawr;
import com.google.android.gms.internal.ads.zzaxa;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzvj;
import com.google.android.gms.internal.ads.zzzz;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzb {
    public static boolean zza(Context context, zzd zzd, zzt zzt) {
        int i = 0;
        if (zzd == null) {
            zzazw.zzfc("No intent data for launcher overlay.");
            return false;
        }
        zzzz.initialize(context);
        Intent intent = zzd.intent;
        if (intent != null) {
            return zza(context, intent, zzt);
        }
        Intent intent2 = new Intent();
        if (TextUtils.isEmpty(zzd.url)) {
            zzazw.zzfc("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzd.mimeType)) {
            intent2.setDataAndType(Uri.parse(zzd.url), zzd.mimeType);
        } else {
            intent2.setData(Uri.parse(zzd.url));
        }
        intent2.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzd.packageName)) {
            intent2.setPackage(zzd.packageName);
        }
        if (!TextUtils.isEmpty(zzd.zzdki)) {
            String[] split = zzd.zzdki.split("/", 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(zzd.zzdki);
                zzazw.zzfc(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent2.setClassName(split[0], split[1]);
        }
        String str = zzd.zzdkj;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                zzazw.zzfc("Could not parse intent flags.");
            }
            intent2.addFlags(i);
        }
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqe)).booleanValue()) {
            intent2.addFlags(DriveFile.MODE_READ_ONLY);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqd)).booleanValue()) {
                zzq.zzkw();
                zzaxa.zzb(context, intent2);
            }
        }
        return zza(context, intent2, zzt);
    }

    private static boolean zza(Context context, Intent intent, zzt zzt) {
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzawr.zzeg(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            zzq.zzkw();
            zzaxa.zza(context, intent);
            if (zzt == null) {
                return true;
            }
            zzt.zzuq();
            return true;
        } catch (ActivityNotFoundException e) {
            zzazw.zzfc(e.getMessage());
            return false;
        }
    }
}
