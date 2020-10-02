package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcvk implements zzdah<Bundle> {
    private final zzdhe zzfll;

    public zzcvk(zzdhe zzdhe) {
        Preconditions.checkNotNull(zzdhe, "the targeting must not be null");
        this.zzfll = zzdhe;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzdhe zzdhe = this.zzfll;
        zzuj zzuj = zzdhe.zzguw;
        bundle.putString("slotname", zzdhe.zzgux);
        boolean z = true;
        int i = zzcvj.zzfwx[this.zzfll.zzgvd.zzguh - 1];
        if (i == 1) {
            bundle.putBoolean("is_new_rewarded", true);
        } else if (i == 2) {
            bundle.putBoolean("is_rewarded_interstitial", true);
        }
        zzdhj.zza(bundle, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzuj.zzceg)), zzuj.zzceg != -1);
        zzdhj.zza(bundle, "extras", zzuj.extras);
        zzdhj.zza(bundle, "cust_gender", Integer.valueOf(zzuj.zzceh), zzuj.zzceh != -1);
        zzdhj.zza(bundle, "kw", zzuj.zzcei);
        zzdhj.zza(bundle, "tag_for_child_directed_treatment", Integer.valueOf(zzuj.zzacq), zzuj.zzacq != -1);
        boolean z2 = zzuj.zzcej;
        if (z2) {
            bundle.putBoolean("test_request", z2);
        }
        zzdhj.zza(bundle, "d_imp_hdr", (Integer) 1, zzuj.versionCode >= 2 && zzuj.zzbli);
        String str = zzuj.zzcek;
        zzdhj.zza(bundle, "ppid", str, zzuj.versionCode >= 2 && !TextUtils.isEmpty(str));
        Location location = zzuj.zzmp;
        if (location != null) {
            Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
            Long valueOf2 = Long.valueOf(location.getTime() * 1000);
            Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
            Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("radius", valueOf.floatValue());
            bundle2.putLong("lat", valueOf3.longValue());
            bundle2.putLong("long", valueOf4.longValue());
            bundle2.putLong("time", valueOf2.longValue());
            bundle.putBundle("uule", bundle2);
        }
        zzdhj.zza(bundle, "url", zzuj.zzcem);
        zzdhj.zza(bundle, "neighboring_content_urls", zzuj.zzcet);
        zzdhj.zza(bundle, "custom_targeting", zzuj.zzceo);
        zzdhj.zza(bundle, "category_exclusions", zzuj.zzcep);
        zzdhj.zza(bundle, "request_agent", zzuj.zzceq);
        zzdhj.zza(bundle, "request_pkg", zzuj.zzcer);
        zzdhj.zza(bundle, "is_designed_for_families", Boolean.valueOf(zzuj.zzces), zzuj.versionCode >= 7);
        if (zzuj.versionCode >= 8) {
            Integer valueOf5 = Integer.valueOf(zzuj.zzacr);
            if (zzuj.zzacr == -1) {
                z = false;
            }
            zzdhj.zza(bundle, "tag_for_under_age_of_consent", valueOf5, z);
            zzdhj.zza(bundle, "max_ad_content_rating", zzuj.zzacs);
        }
    }
}
