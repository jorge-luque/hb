package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzeey {
    static String zzam(zzeaq zzeaq) {
        zzeex zzeex = new zzeex(zzeaq);
        StringBuilder sb = new StringBuilder(zzeex.size());
        for (int i = 0; i < zzeex.size(); i++) {
            byte zzfo = zzeex.zzfo(i);
            if (zzfo == 34) {
                sb.append("\\\"");
            } else if (zzfo == 39) {
                sb.append("\\'");
            } else if (zzfo != 92) {
                switch (zzfo) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (zzfo >= 32 && zzfo <= 126) {
                            sb.append((char) zzfo);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((zzfo >>> 6) & 3) + 48));
                            sb.append((char) (((zzfo >>> 3) & 7) + 48));
                            sb.append((char) ((zzfo & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
