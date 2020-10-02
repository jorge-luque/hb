package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzqx implements Comparator<zzrd> {
    zzqx(zzqy zzqy) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzrd zzrd = (zzrd) obj;
        zzrd zzrd2 = (zzrd) obj2;
        int i = zzrd.zzbrj - zzrd2.zzbrj;
        if (i != 0) {
            return i;
        }
        return (int) (zzrd.value - zzrd2.value);
    }
}
