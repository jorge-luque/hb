package com.google.android.gms.internal.drive;

import java.util.Comparator;

final class zzje implements Comparator<zzjc> {
    zzje() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzjc zzjc = (zzjc) obj;
        zzjc zzjc2 = (zzjc) obj2;
        zzjj zzjj = (zzjj) zzjc.iterator();
        zzjj zzjj2 = (zzjj) zzjc2.iterator();
        while (zzjj.hasNext() && zzjj2.hasNext()) {
            int a = C0000a.m0a(zzjc.zza(zzjj.nextByte()), zzjc.zza(zzjj2.nextByte()));
            if (a != 0) {
                return a;
            }
        }
        return C0000a.m0a(zzjc.size(), zzjc2.size());
    }
}
