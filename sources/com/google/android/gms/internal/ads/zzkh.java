package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzkh extends zzki {
    public final long zzarx;
    public final List<zzkk> zzary = new ArrayList();
    public final List<zzkh> zzarz = new ArrayList();

    public zzkh(int i, long j) {
        super(i);
        this.zzarx = j;
    }

    public final String toString() {
        String zzar = zzki.zzar(this.type);
        String arrays = Arrays.toString(this.zzary.toArray());
        String arrays2 = Arrays.toString(this.zzarz.toArray());
        StringBuilder sb = new StringBuilder(String.valueOf(zzar).length() + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
        sb.append(zzar);
        sb.append(" leaves: ");
        sb.append(arrays);
        sb.append(" containers: ");
        sb.append(arrays2);
        return sb.toString();
    }

    public final zzkk zzan(int i) {
        int size = this.zzary.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzkk zzkk = this.zzary.get(i2);
            if (zzkk.type == i) {
                return zzkk;
            }
        }
        return null;
    }

    public final zzkh zzao(int i) {
        int size = this.zzarz.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzkh zzkh = this.zzarz.get(i2);
            if (zzkh.type == i) {
                return zzkh;
            }
        }
        return null;
    }
}
