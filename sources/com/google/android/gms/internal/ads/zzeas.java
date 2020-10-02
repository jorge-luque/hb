package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzeas implements Comparator<zzeaq> {
    zzeas() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzeaq zzeaq = (zzeaq) obj;
        zzeaq zzeaq2 = (zzeaq) obj2;
        zzeaz zzeaz = (zzeaz) zzeaq.iterator();
        zzeaz zzeaz2 = (zzeaz) zzeaq2.iterator();
        while (zzeaz.hasNext() && zzeaz2.hasNext()) {
            int a = C0000a.m0a(zzeaq.zzb(zzeaz.nextByte()), zzeaq.zzb(zzeaz2.nextByte()));
            if (a != 0) {
                return a;
            }
        }
        return C0000a.m0a(zzeaq.size(), zzeaq2.size());
    }
}
