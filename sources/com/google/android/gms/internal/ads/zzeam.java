package com.google.android.gms.internal.ads;

import com.google.android.gms.games.Notifications;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzeam {
    static int zza(byte[] bArr, int i, zzeap zzeap) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza((int) b, bArr, i2, zzeap);
        }
        zzeap.zzhtb = b;
        return i2;
    }

    static int zzb(byte[] bArr, int i, zzeap zzeap) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzeap.zzhtc = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzeap.zzhtc = j2;
        return i3;
    }

    static int zzc(byte[] bArr, int i, zzeap zzeap) throws zzeco {
        int zza = zza(bArr, i, zzeap);
        int i2 = zzeap.zzhtb;
        if (i2 < 0) {
            throw zzeco.zzbfh();
        } else if (i2 == 0) {
            zzeap.zzhtd = "";
            return zza;
        } else {
            zzeap.zzhtd = new String(bArr, zza, i2, zzecg.UTF_8);
            return zza + i2;
        }
    }

    static int zzd(byte[] bArr, int i, zzeap zzeap) throws zzeco {
        int zza = zza(bArr, i, zzeap);
        int i2 = zzeap.zzhtb;
        if (i2 < 0) {
            throw zzeco.zzbfh();
        } else if (i2 == 0) {
            zzeap.zzhtd = "";
            return zza;
        } else {
            zzeap.zzhtd = zzefk.zzo(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zzeap zzeap) throws zzeco {
        int zza = zza(bArr, i, zzeap);
        int i2 = zzeap.zzhtb;
        if (i2 < 0) {
            throw zzeco.zzbfh();
        } else if (i2 > bArr.length - zza) {
            throw zzeco.zzbfg();
        } else if (i2 == 0) {
            zzeap.zzhtd = zzeaq.zzhtf;
            return zza;
        } else {
            zzeap.zzhtd = zzeaq.zzh(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zzf(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static long zzg(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzh(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzg(bArr, i));
    }

    static float zzi(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzf(bArr, i));
    }

    static int zza(int i, byte[] bArr, int i2, zzeap zzeap) {
        int i3 = i & Notifications.NOTIFICATION_TYPES_ALL;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzeap.zzhtb = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzeap.zzhtb = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzeap.zzhtb = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzeap.zzhtb = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzeap.zzhtb = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zza(com.google.android.gms.internal.ads.zzeek r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.ads.zzeap r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zza((int) r8, (byte[]) r7, (int) r0, (com.google.android.gms.internal.ads.zzeap) r10)
            int r8 = r10.zzhtb
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.newInstance()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zza(r1, r2, r3, r4, r5)
            r6.zzak(r9)
            r10.zzhtd = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.ads.zzeco r6 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeam.zza(com.google.android.gms.internal.ads.zzeek, byte[], int, int, com.google.android.gms.internal.ads.zzeap):int");
    }

    static int zza(zzeek zzeek, byte[] bArr, int i, int i2, int i3, zzeap zzeap) throws IOException {
        zzeds zzeds = (zzeds) zzeek;
        Object newInstance = zzeds.newInstance();
        int zza = zzeds.zza(newInstance, bArr, i, i2, i3, zzeap);
        zzeds.zzak(newInstance);
        zzeap.zzhtd = newInstance;
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzecl<?> zzecl, zzeap zzeap) {
        zzece zzece = (zzece) zzecl;
        int zza = zza(bArr, i2, zzeap);
        zzece.zzgw(zzeap.zzhtb);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzeap);
            if (i != zzeap.zzhtb) {
                break;
            }
            zza = zza(bArr, zza2, zzeap);
            zzece.zzgw(zzeap.zzhtb);
        }
        return zza;
    }

    static int zza(byte[] bArr, int i, zzecl<?> zzecl, zzeap zzeap) throws IOException {
        zzece zzece = (zzece) zzecl;
        int zza = zza(bArr, i, zzeap);
        int i2 = zzeap.zzhtb + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzeap);
            zzece.zzgw(zzeap.zzhtb);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzeco.zzbfg();
    }

    static int zza(zzeek<?> zzeek, int i, byte[] bArr, int i2, int i3, zzecl<?> zzecl, zzeap zzeap) throws IOException {
        int zza = zza((zzeek) zzeek, bArr, i2, i3, zzeap);
        zzecl.add(zzeap.zzhtd);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzeap);
            if (i != zzeap.zzhtb) {
                break;
            }
            zza = zza((zzeek) zzeek, bArr, zza2, i3, zzeap);
            zzecl.add(zzeap.zzhtd);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzefb zzefb, zzeap zzeap) throws zzeco {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzeap);
                zzefb.zzd(i, Long.valueOf(zzeap.zzhtc));
                return zzb;
            } else if (i4 == 1) {
                zzefb.zzd(i, Long.valueOf(zzg(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzeap);
                int i5 = zzeap.zzhtb;
                if (i5 < 0) {
                    throw zzeco.zzbfh();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzefb.zzd(i, zzeaq.zzhtf);
                    } else {
                        zzefb.zzd(i, zzeaq.zzh(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzeco.zzbfg();
                }
            } else if (i4 == 3) {
                zzefb zzbhe = zzefb.zzbhe();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzeap);
                    int i8 = zzeap.zzhtb;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zza2;
                        break;
                    }
                    int zza3 = zza(i7, bArr, zza2, i3, zzbhe, zzeap);
                    i7 = i8;
                    i2 = zza3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzeco.zzbfn();
                }
                zzefb.zzd(i, zzbhe);
                return i2;
            } else if (i4 == 5) {
                zzefb.zzd(i, Integer.valueOf(zzf(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzeco.zzbfj();
            }
        } else {
            throw zzeco.zzbfj();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzeap zzeap) throws zzeco {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzeap);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzeap) + zzeap.zzhtb;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzeap);
                    i6 = zzeap.zzhtb;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzeap);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzeco.zzbfn();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzeco.zzbfj();
            }
        } else {
            throw zzeco.zzbfj();
        }
    }
}
