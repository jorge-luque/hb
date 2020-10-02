package com.google.android.gms.measurement.internal;

import com.ogury.p159cm.OguryChoiceManager;
import com.tapjoy.TapjoyAuctionFlags;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
final class zzew implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzet zzf;

    zzew(zzet zzet, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzet;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    public final void run() {
        zzff zzc2 = this.zzf.zzz.zzc();
        if (zzc2.zzz()) {
            if (this.zzf.zza == 0) {
                if (this.zzf.zzt().zzg()) {
                    zzet zzet = this.zzf;
                    zzet.zzu();
                    char unused = zzet.zza = 'C';
                } else {
                    zzet zzet2 = this.zzf;
                    zzet2.zzu();
                    char unused2 = zzet2.zza = 'c';
                }
            }
            if (this.zzf.zzb < 0) {
                zzet zzet3 = this.zzf;
                long unused3 = zzet3.zzb = zzet3.zzt().zzf();
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            char zza2 = this.zzf.zza;
            long zzb2 = this.zzf.zzb;
            String zza3 = zzet.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
            StringBuilder sb = new StringBuilder(String.valueOf(zza3).length() + 24);
            sb.append(TapjoyAuctionFlags.AUCTION_TYPE_SECOND_PRICE);
            sb.append(charAt);
            sb.append(zza2);
            sb.append(zzb2);
            sb.append(":");
            sb.append(zza3);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = this.zzb.substring(0, OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS);
            }
            zzc2.zzb.zza(sb2, 1);
            return;
        }
        this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
    }
}
