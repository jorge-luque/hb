package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzane {
    public static int zza(AdRequest.ErrorCode errorCode) {
        int i = zzanh.zzdhm[errorCode.ordinal()];
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? 0 : 3;
        }
        return 2;
    }

    public static MediationAdRequest zza(zzuj zzuj, boolean z) {
        AdRequest.Gender gender;
        HashSet hashSet = zzuj.zzcei != null ? new HashSet(zzuj.zzcei) : null;
        Date date = new Date(zzuj.zzceg);
        int i = zzuj.zzceh;
        if (i == 1) {
            gender = AdRequest.Gender.MALE;
        } else if (i != 2) {
            gender = AdRequest.Gender.UNKNOWN;
        } else {
            gender = AdRequest.Gender.FEMALE;
        }
        return new MediationAdRequest(date, gender, hashSet, z, zzuj.zzmp);
    }
}
