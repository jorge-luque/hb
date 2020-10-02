package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzac;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
final class zzaf extends zzac.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Context zze;
    private final /* synthetic */ Bundle zzf;
    private final /* synthetic */ zzac zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaf(zzac zzac, String str, String str2, Context context, Bundle bundle) {
        super(zzac);
        this.zzg = zzac;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054 A[Catch:{ Exception -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0060 A[Catch:{ Exception -> 0x00a0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza() {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            com.google.android.gms.internal.measurement.zzac r2 = r14.zzg     // Catch:{ Exception -> 0x00a0 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x00a0 }
            r3.<init>()     // Catch:{ Exception -> 0x00a0 }
            java.util.List unused = r2.zzf = r3     // Catch:{ Exception -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzac r2 = r14.zzg     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r3 = r14.zzc     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r4 = r14.zzd     // Catch:{ Exception -> 0x00a0 }
            boolean r2 = com.google.android.gms.internal.measurement.zzac.zzc(r3, r4)     // Catch:{ Exception -> 0x00a0 }
            r3 = 0
            if (r2 == 0) goto L_0x0027
            java.lang.String r3 = r14.zzd     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r2 = r14.zzc     // Catch:{ Exception -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzac r4 = r14.zzg     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r4 = r4.zzc     // Catch:{ Exception -> 0x00a0 }
            r10 = r2
            r11 = r3
            r9 = r4
            goto L_0x002a
        L_0x0027:
            r9 = r3
            r10 = r9
            r11 = r10
        L_0x002a:
            android.content.Context r2 = r14.zze     // Catch:{ Exception -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzac.zzi(r2)     // Catch:{ Exception -> 0x00a0 }
            java.lang.Boolean r2 = com.google.android.gms.internal.measurement.zzac.zzi     // Catch:{ Exception -> 0x00a0 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x00a0 }
            if (r2 != 0) goto L_0x003e
            if (r10 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r2 = 0
            goto L_0x003f
        L_0x003e:
            r2 = 1
        L_0x003f:
            com.google.android.gms.internal.measurement.zzac r3 = r14.zzg     // Catch:{ Exception -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzac r4 = r14.zzg     // Catch:{ Exception -> 0x00a0 }
            android.content.Context r5 = r14.zze     // Catch:{ Exception -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzr r4 = r4.zza((android.content.Context) r5, (boolean) r2)     // Catch:{ Exception -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzr unused = r3.zzr = r4     // Catch:{ Exception -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzac r3 = r14.zzg     // Catch:{ Exception -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzr r3 = r3.zzr     // Catch:{ Exception -> 0x00a0 }
            if (r3 != 0) goto L_0x0060
            com.google.android.gms.internal.measurement.zzac r2 = r14.zzg     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r2 = r2.zzc     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r3 = "Failed to connect to measurement client."
            android.util.Log.w(r2, r3)     // Catch:{ Exception -> 0x00a0 }
            return
        L_0x0060:
            android.content.Context r3 = r14.zze     // Catch:{ Exception -> 0x00a0 }
            int r3 = com.google.android.gms.internal.measurement.zzac.zzh(r3)     // Catch:{ Exception -> 0x00a0 }
            android.content.Context r4 = r14.zze     // Catch:{ Exception -> 0x00a0 }
            int r4 = com.google.android.gms.internal.measurement.zzac.zzg(r4)     // Catch:{ Exception -> 0x00a0 }
            if (r2 == 0) goto L_0x0079
            int r2 = java.lang.Math.max(r3, r4)     // Catch:{ Exception -> 0x00a0 }
            if (r4 >= r3) goto L_0x0076
            r3 = 1
            goto L_0x0077
        L_0x0076:
            r3 = 0
        L_0x0077:
            r8 = r3
            goto L_0x0083
        L_0x0079:
            if (r3 <= 0) goto L_0x007c
            r4 = r3
        L_0x007c:
            if (r3 <= 0) goto L_0x0080
            r2 = 1
            goto L_0x0081
        L_0x0080:
            r2 = 0
        L_0x0081:
            r8 = r2
            r2 = r4
        L_0x0083:
            com.google.android.gms.internal.measurement.zzaa r13 = new com.google.android.gms.internal.measurement.zzaa     // Catch:{ Exception -> 0x00a0 }
            r4 = 27000(0x6978, double:1.334E-319)
            long r6 = (long) r2     // Catch:{ Exception -> 0x00a0 }
            android.os.Bundle r12 = r14.zzf     // Catch:{ Exception -> 0x00a0 }
            r3 = r13
            r3.<init>(r4, r6, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzac r2 = r14.zzg     // Catch:{ Exception -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzr r2 = r2.zzr     // Catch:{ Exception -> 0x00a0 }
            android.content.Context r3 = r14.zze     // Catch:{ Exception -> 0x00a0 }
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r3)     // Catch:{ Exception -> 0x00a0 }
            long r4 = r14.zza     // Catch:{ Exception -> 0x00a0 }
            r2.initialize(r3, r13, r4)     // Catch:{ Exception -> 0x00a0 }
            return
        L_0x00a0:
            r2 = move-exception
            com.google.android.gms.internal.measurement.zzac r3 = r14.zzg
            r3.zza((java.lang.Exception) r2, (boolean) r1, (boolean) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaf.zza():void");
    }
}
