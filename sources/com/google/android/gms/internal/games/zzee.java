package com.google.android.gms.internal.games;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzee {
    public static String zzp(int i) {
        if (i == 0) {
            return "DAILY";
        }
        if (i == 1) {
            return "WEEKLY";
        }
        if (i == 2) {
            return "ALL_TIME";
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Unknown time span ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
