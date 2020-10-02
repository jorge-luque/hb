package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzaal extends zzaag {
    zzaal() {
    }

    private static String zzcu(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        int length = str.length();
        while (i < str.length() && str.charAt(i) == ',') {
            i++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        if (length < i) {
            return null;
        }
        if (i == 0 && length == str.length()) {
            return str;
        }
        return str.substring(i, length);
    }

    public final String zzg(String str, String str2) {
        String zzcu = zzcu(str);
        String zzcu2 = zzcu(str2);
        if (TextUtils.isEmpty(zzcu)) {
            return zzcu2;
        }
        if (TextUtils.isEmpty(zzcu2)) {
            return zzcu;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(zzcu).length() + 1 + String.valueOf(zzcu2).length());
        sb.append(zzcu);
        sb.append(",");
        sb.append(zzcu2);
        return sb.toString();
    }
}
