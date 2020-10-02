package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzri implements Comparator<zzqw> {
    public zzri(zzrf zzrf) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzqw zzqw = (zzqw) obj;
        zzqw zzqw2 = (zzqw) obj2;
        if (zzqw.zzmo() < zzqw2.zzmo()) {
            return -1;
        }
        if (zzqw.zzmo() > zzqw2.zzmo()) {
            return 1;
        }
        if (zzqw.zzmn() < zzqw2.zzmn()) {
            return -1;
        }
        if (zzqw.zzmn() > zzqw2.zzmn()) {
            return 1;
        }
        float zzmq = (zzqw.zzmq() - zzqw.zzmo()) * (zzqw.zzmp() - zzqw.zzmn());
        float zzmq2 = (zzqw2.zzmq() - zzqw2.zzmo()) * (zzqw2.zzmp() - zzqw2.zzmn());
        if (zzmq > zzmq2) {
            return -1;
        }
        if (zzmq < zzmq2) {
            return 1;
        }
        return 0;
    }
}
