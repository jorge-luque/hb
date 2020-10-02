package com.google.android.gms.internal.ads;

import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.ads.zzecd;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzeds<T> implements zzeek<T> {
    private static final Unsafe zzhgt = zzefi.zzbhj();
    private static final int[] zziac = new int[0];
    private final int[] zziad;
    private final Object[] zziae;
    private final int zziaf;
    private final int zziag;
    private final zzedo zziah;
    private final boolean zziai;
    private final boolean zziaj;
    private final boolean zziak;
    private final boolean zzial;
    private final int[] zziam;
    private final int zzian;
    private final int zziao;
    private final zzedw zziap;
    private final zzecy zziaq;
    private final zzefc<?, ?> zziar;
    private final zzebs<?> zzias;
    private final zzedh zziat;

    private zzeds(int[] iArr, Object[] objArr, int i, int i2, zzedo zzedo, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzedw zzedw, zzecy zzecy, zzefc<?, ?> zzefc, zzebs<?> zzebs, zzedh zzedh) {
        this.zziad = iArr;
        this.zziae = objArr;
        this.zziaf = i;
        this.zziag = i2;
        this.zziaj = zzedo instanceof zzecd;
        this.zziak = z;
        this.zziai = zzebs != null && zzebs.zzj(zzedo);
        this.zzial = false;
        this.zziam = iArr2;
        this.zzian = i3;
        this.zziao = i4;
        this.zziap = zzedw;
        this.zziaq = zzecy;
        this.zziar = zzefc;
        this.zzias = zzebs;
        this.zziah = zzedo;
        this.zziat = zzedh;
    }

    static <T> zzeds<T> zza(Class<T> cls, zzedm zzedm, zzedw zzedw, zzecy zzecy, zzefc<?, ?> zzefc, zzebs<?> zzebs, zzedh zzedh) {
        int i;
        char c;
        int[] iArr;
        char c2;
        int i2;
        char c3;
        char c4;
        char c5;
        char c6;
        int i3;
        boolean z;
        int i4;
        zzeeb zzeeb;
        int i5;
        Class<?> cls2;
        int i6;
        String str;
        int i7;
        int i8;
        char c7;
        char c8;
        Field field;
        int i9;
        char charAt;
        int i10;
        Field field2;
        Field field3;
        int i11;
        char charAt2;
        int i12;
        char charAt3;
        int i13;
        char charAt4;
        int i14;
        int i15;
        char charAt5;
        int i16;
        char charAt6;
        int i17;
        char charAt7;
        int i18;
        char charAt8;
        int i19;
        char charAt9;
        int i20;
        char charAt10;
        int i21;
        char charAt11;
        int i22;
        char charAt12;
        int i23;
        char charAt13;
        char charAt14;
        zzedm zzedm2 = zzedm;
        if (zzedm2 instanceof zzeeb) {
            zzeeb zzeeb2 = (zzeeb) zzedm2;
            char c9 = 0;
            boolean z2 = zzeeb2.zzbge() == zzecd.zzf.zzhyk;
            String zzbgl = zzeeb2.zzbgl();
            int length = zzbgl.length();
            char charAt15 = zzbgl.charAt(0);
            if (charAt15 >= 55296) {
                char c10 = charAt15 & 8191;
                int i24 = 1;
                int i25 = 13;
                while (true) {
                    i = i24 + 1;
                    charAt14 = zzbgl.charAt(i24);
                    if (charAt14 < 55296) {
                        break;
                    }
                    c10 |= (charAt14 & 8191) << i25;
                    i25 += 13;
                    i24 = i;
                }
                charAt15 = c10 | (charAt14 << i25);
            } else {
                i = 1;
            }
            int i26 = i + 1;
            char charAt16 = zzbgl.charAt(i);
            if (charAt16 >= 55296) {
                char c11 = charAt16 & 8191;
                int i27 = 13;
                while (true) {
                    i23 = i26 + 1;
                    charAt13 = zzbgl.charAt(i26);
                    if (charAt13 < 55296) {
                        break;
                    }
                    c11 |= (charAt13 & 8191) << i27;
                    i27 += 13;
                    i26 = i23;
                }
                charAt16 = c11 | (charAt13 << i27);
                i26 = i23;
            }
            if (charAt16 == 0) {
                iArr = zziac;
                c5 = 0;
                c4 = 0;
                c3 = 0;
                i2 = 0;
                c2 = 0;
                c = 0;
            } else {
                int i28 = i26 + 1;
                char charAt17 = zzbgl.charAt(i26);
                if (charAt17 >= 55296) {
                    char c12 = charAt17 & 8191;
                    int i29 = 13;
                    while (true) {
                        i22 = i28 + 1;
                        charAt12 = zzbgl.charAt(i28);
                        if (charAt12 < 55296) {
                            break;
                        }
                        c12 |= (charAt12 & 8191) << i29;
                        i29 += 13;
                        i28 = i22;
                    }
                    charAt17 = c12 | (charAt12 << i29);
                    i28 = i22;
                }
                int i30 = i28 + 1;
                char charAt18 = zzbgl.charAt(i28);
                if (charAt18 >= 55296) {
                    char c13 = charAt18 & 8191;
                    int i31 = 13;
                    while (true) {
                        i21 = i30 + 1;
                        charAt11 = zzbgl.charAt(i30);
                        if (charAt11 < 55296) {
                            break;
                        }
                        c13 |= (charAt11 & 8191) << i31;
                        i31 += 13;
                        i30 = i21;
                    }
                    charAt18 = c13 | (charAt11 << i31);
                    i30 = i21;
                }
                int i32 = i30 + 1;
                c3 = zzbgl.charAt(i30);
                if (c3 >= 55296) {
                    char c14 = c3 & 8191;
                    int i33 = 13;
                    while (true) {
                        i20 = i32 + 1;
                        charAt10 = zzbgl.charAt(i32);
                        if (charAt10 < 55296) {
                            break;
                        }
                        c14 |= (charAt10 & 8191) << i33;
                        i33 += 13;
                        i32 = i20;
                    }
                    c3 = c14 | (charAt10 << i33);
                    i32 = i20;
                }
                int i34 = i32 + 1;
                char charAt19 = zzbgl.charAt(i32);
                if (charAt19 >= 55296) {
                    char c15 = charAt19 & 8191;
                    int i35 = 13;
                    while (true) {
                        i19 = i34 + 1;
                        charAt9 = zzbgl.charAt(i34);
                        if (charAt9 < 55296) {
                            break;
                        }
                        c15 |= (charAt9 & 8191) << i35;
                        i35 += 13;
                        i34 = i19;
                    }
                    charAt19 = c15 | (charAt9 << i35);
                    i34 = i19;
                }
                int i36 = i34 + 1;
                c2 = zzbgl.charAt(i34);
                if (c2 >= 55296) {
                    char c16 = c2 & 8191;
                    int i37 = 13;
                    while (true) {
                        i18 = i36 + 1;
                        charAt8 = zzbgl.charAt(i36);
                        if (charAt8 < 55296) {
                            break;
                        }
                        c16 |= (charAt8 & 8191) << i37;
                        i37 += 13;
                        i36 = i18;
                    }
                    c2 = c16 | (charAt8 << i37);
                    i36 = i18;
                }
                int i38 = i36 + 1;
                char charAt20 = zzbgl.charAt(i36);
                if (charAt20 >= 55296) {
                    char c17 = charAt20 & 8191;
                    int i39 = 13;
                    while (true) {
                        i17 = i38 + 1;
                        charAt7 = zzbgl.charAt(i38);
                        if (charAt7 < 55296) {
                            break;
                        }
                        c17 |= (charAt7 & 8191) << i39;
                        i39 += 13;
                        i38 = i17;
                    }
                    charAt20 = c17 | (charAt7 << i39);
                    i38 = i17;
                }
                int i40 = i38 + 1;
                char charAt21 = zzbgl.charAt(i38);
                if (charAt21 >= 55296) {
                    char c18 = charAt21 & 8191;
                    int i41 = i40;
                    int i42 = 13;
                    while (true) {
                        i16 = i41 + 1;
                        charAt6 = zzbgl.charAt(i41);
                        if (charAt6 < 55296) {
                            break;
                        }
                        c18 |= (charAt6 & 8191) << i42;
                        i42 += 13;
                        i41 = i16;
                    }
                    charAt21 = c18 | (charAt6 << i42);
                    i14 = i16;
                } else {
                    i14 = i40;
                }
                int i43 = i14 + 1;
                char charAt22 = zzbgl.charAt(i14);
                if (charAt22 >= 55296) {
                    char c19 = charAt22 & 8191;
                    int i44 = i43;
                    int i45 = 13;
                    while (true) {
                        i15 = i44 + 1;
                        charAt5 = zzbgl.charAt(i44);
                        if (charAt5 < 55296) {
                            break;
                        }
                        c19 |= (charAt5 & 8191) << i45;
                        i45 += 13;
                        i44 = i15;
                    }
                    charAt22 = c19 | (charAt5 << i45);
                    i43 = i15;
                }
                int i46 = (charAt17 << 1) + charAt18;
                c4 = charAt19;
                i2 = i46;
                c = charAt22;
                c9 = charAt17;
                i26 = i43;
                char c20 = charAt20;
                iArr = new int[(charAt22 + charAt20 + charAt21)];
                c5 = c20;
            }
            Unsafe unsafe = zzhgt;
            Object[] zzbgm = zzeeb2.zzbgm();
            Class<?> cls3 = zzeeb2.zzbgg().getClass();
            int i47 = i26;
            int[] iArr2 = new int[(c2 * 3)];
            Object[] objArr = new Object[(c2 << 1)];
            int i48 = c + c5;
            char c21 = c;
            int i49 = i47;
            int i50 = i48;
            int i51 = 0;
            int i52 = 0;
            while (i49 < length) {
                int i53 = i49 + 1;
                int charAt23 = zzbgl.charAt(i49);
                int i54 = length;
                if (charAt23 >= 55296) {
                    int i55 = charAt23 & 8191;
                    int i56 = i53;
                    int i57 = 13;
                    while (true) {
                        i13 = i56 + 1;
                        charAt4 = zzbgl.charAt(i56);
                        c6 = c;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i55 |= (charAt4 & 8191) << i57;
                        i57 += 13;
                        i56 = i13;
                        c = c6;
                    }
                    charAt23 = i55 | (charAt4 << i57);
                    i3 = i13;
                } else {
                    c6 = c;
                    i3 = i53;
                }
                int i58 = i3 + 1;
                char charAt24 = zzbgl.charAt(i3);
                int i59 = i58;
                if (charAt24 >= 55296) {
                    char c22 = charAt24 & 8191;
                    int i60 = i59;
                    int i61 = 13;
                    while (true) {
                        i12 = i60 + 1;
                        charAt3 = zzbgl.charAt(i60);
                        z = z2;
                        if (charAt3 < 55296) {
                            break;
                        }
                        c22 |= (charAt3 & 8191) << i61;
                        i61 += 13;
                        i60 = i12;
                        z2 = z;
                    }
                    charAt24 = c22 | (charAt3 << i61);
                    i4 = i12;
                } else {
                    z = z2;
                    i4 = i59;
                }
                char c23 = charAt24 & 255;
                char c24 = c4;
                if ((charAt24 & 1024) != 0) {
                    iArr[i51] = i52;
                    i51++;
                }
                char c25 = c3;
                if (c23 >= '3') {
                    int i62 = i4 + 1;
                    char charAt25 = zzbgl.charAt(i4);
                    char c26 = 55296;
                    if (charAt25 >= 55296) {
                        char c27 = charAt25 & 8191;
                        int i63 = 13;
                        while (true) {
                            i11 = i62 + 1;
                            charAt2 = zzbgl.charAt(i62);
                            if (charAt2 < c26) {
                                break;
                            }
                            c27 |= (charAt2 & 8191) << i63;
                            i63 += 13;
                            i62 = i11;
                            c26 = 55296;
                        }
                        charAt25 = c27 | (charAt2 << i63);
                        i62 = i11;
                    }
                    int i64 = c23 - '3';
                    int i65 = i62;
                    if (i64 == 9 || i64 == 17) {
                        objArr[((i52 / 3) << 1) + 1] = zzbgm[i2];
                        i2++;
                    } else if (i64 == 12 && (charAt15 & 1) == 1) {
                        objArr[((i52 / 3) << 1) + 1] = zzbgm[i2];
                        i2++;
                    }
                    int i66 = charAt25 << 1;
                    Object obj = zzbgm[i66];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zzbgm[i66] = field2;
                    }
                    zzeeb = zzeeb2;
                    String str2 = zzbgl;
                    i8 = (int) unsafe.objectFieldOffset(field2);
                    int i67 = i66 + 1;
                    Object obj2 = zzbgm[i67];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zzbgm[i67] = field3;
                    }
                    cls2 = cls3;
                    i5 = i2;
                    i4 = i65;
                    str = str2;
                    i6 = 0;
                    i7 = (int) unsafe.objectFieldOffset(field3);
                    c7 = c9;
                } else {
                    zzeeb = zzeeb2;
                    String str3 = zzbgl;
                    int i68 = i2 + 1;
                    Field zza = zza(cls3, (String) zzbgm[i2]);
                    if (c23 == 9 || c23 == 17) {
                        c8 = 1;
                        objArr[((i52 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (c23 == 27 || c23 == '1') {
                            c8 = 1;
                            i10 = i68 + 1;
                            objArr[((i52 / 3) << 1) + 1] = zzbgm[i68];
                        } else if (c23 == 12 || c23 == 30 || c23 == ',') {
                            c8 = 1;
                            if ((charAt15 & 1) == 1) {
                                i10 = i68 + 1;
                                objArr[((i52 / 3) << 1) + 1] = zzbgm[i68];
                            }
                        } else {
                            if (c23 == '2') {
                                int i69 = c21 + 1;
                                iArr[c21] = i52;
                                int i70 = (i52 / 3) << 1;
                                int i71 = i68 + 1;
                                objArr[i70] = zzbgm[i68];
                                if ((charAt24 & 2048) != 0) {
                                    i68 = i71 + 1;
                                    objArr[i70 + 1] = zzbgm[i71];
                                    c21 = i69;
                                } else {
                                    i68 = i71;
                                    c8 = 1;
                                    c21 = i69;
                                }
                            }
                            c8 = 1;
                        }
                        i68 = i10;
                    }
                    i8 = (int) unsafe.objectFieldOffset(zza);
                    if ((charAt15 & 1) != c8 || c23 > 17) {
                        i5 = i68;
                        c7 = c9;
                        cls2 = cls3;
                        str = str3;
                        i7 = 0;
                        i6 = 0;
                    } else {
                        int i72 = i4 + 1;
                        str = str3;
                        char charAt26 = str.charAt(i4);
                        if (charAt26 >= 55296) {
                            char c28 = charAt26 & 8191;
                            int i73 = 13;
                            while (true) {
                                i9 = i72 + 1;
                                charAt = str.charAt(i72);
                                if (charAt < 55296) {
                                    break;
                                }
                                c28 |= (charAt & 8191) << i73;
                                i73 += 13;
                                i72 = i9;
                            }
                            charAt26 = c28 | (charAt << i73);
                            i72 = i9;
                        }
                        int i74 = (c9 << 1) + (charAt26 / ' ');
                        Object obj3 = zzbgm[i74];
                        i5 = i68;
                        if (obj3 instanceof Field) {
                            field = (Field) obj3;
                        } else {
                            field = zza(cls3, (String) obj3);
                            zzbgm[i74] = field;
                        }
                        c7 = c9;
                        cls2 = cls3;
                        i7 = (int) unsafe.objectFieldOffset(field);
                        i6 = charAt26 % ' ';
                        i4 = i72;
                    }
                    if (c23 >= 18 && c23 <= '1') {
                        iArr[i50] = i8;
                        i50++;
                    }
                }
                int i75 = i52 + 1;
                iArr2[i52] = charAt23;
                int i76 = i75 + 1;
                iArr2[i75] = i8 | ((charAt24 & 256) != 0 ? DriveFile.MODE_READ_ONLY : 0) | ((charAt24 & 512) != 0 ? DriveFile.MODE_WRITE_ONLY : 0) | (c23 << 20);
                i52 = i76 + 1;
                iArr2[i76] = (i6 << 20) | i7;
                c9 = c7;
                zzbgl = str;
                i49 = i4;
                cls3 = cls2;
                c4 = c24;
                length = i54;
                c = c6;
                z2 = z;
                c3 = c25;
                i2 = i5;
                zzeeb2 = zzeeb;
            }
            char c29 = c4;
            boolean z3 = z2;
            return new zzeds(iArr2, objArr, c3, c4, zzeeb2.zzbgg(), z2, false, iArr, c, i48, zzedw, zzecy, zzefc, zzebs, zzedh);
        }
        int zzbge = ((zzeev) zzedm2).zzbge();
        int i77 = zzecd.zzf.zzhyk;
        throw new NoSuchMethodError();
    }

    private final int zzan(int i, int i2) {
        if (i < this.zziaf || i > this.zziag) {
            return -1;
        }
        return zzao(i, i2);
    }

    private final int zzao(int i, int i2) {
        int length = (this.zziad.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zziad[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static zzefb zzav(Object obj) {
        zzecd zzecd = (zzecd) obj;
        zzefb zzefb = zzecd.zzhxv;
        if (zzefb != zzefb.zzbhd()) {
            return zzefb;
        }
        zzefb zzbhe = zzefb.zzbhe();
        zzecd.zzhxv = zzbhe;
        return zzbhe;
    }

    private final void zzb(T t, T t2, int i) {
        int zzhc = zzhc(i);
        int i2 = this.zziad[i];
        long j = (long) (zzhc & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zzefi.zzp(t, j);
            Object zzp2 = zzefi.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zzefi.zza((Object) t, j, zzecg.zzd(zzp, zzp2));
                zzb(t, i2, i);
            } else if (zzp2 != null) {
                zzefi.zza((Object) t, j, zzp2);
                zzb(t, i2, i);
            }
        }
    }

    private final boolean zzc(T t, T t2, int i) {
        return zze(t, i) == zze(t2, i);
    }

    private static List<?> zze(Object obj, long j) {
        return (List) zzefi.zzp(obj, j);
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzefi.zzp(t, j)).floatValue();
    }

    private final zzeek zzgz(int i) {
        int i2 = (i / 3) << 1;
        zzeek zzeek = (zzeek) this.zziae[i2];
        if (zzeek != null) {
            return zzeek;
        }
        zzeek zzh = zzedz.zzbgk().zzh((Class) this.zziae[i2 + 1]);
        this.zziae[i2] = zzh;
        return zzh;
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzefi.zzp(t, j)).intValue();
    }

    private final Object zzha(int i) {
        return this.zziae[(i / 3) << 1];
    }

    private final zzech zzhb(int i) {
        return (zzech) this.zziae[((i / 3) << 1) + 1];
    }

    private final int zzhc(int i) {
        return this.zziad[i + 1];
    }

    private final int zzhd(int i) {
        return this.zziad[i + 2];
    }

    private static boolean zzhe(int i) {
        return (i & DriveFile.MODE_WRITE_ONLY) != 0;
    }

    private final int zzhf(int i) {
        if (i < this.zziaf || i > this.zziag) {
            return -1;
        }
        return zzao(i, 0);
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzefi.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzefi.zzp(t, j)).booleanValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.ads.zzeem.zzg(com.google.android.gms.internal.ads.zzefi.zzp(r10, r6), com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzl(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzk(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzl(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzk(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzk(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzk(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.ads.zzeem.zzg(com.google.android.gms.internal.ads.zzefi.zzp(r10, r6), com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.ads.zzeem.zzg(com.google.android.gms.internal.ads.zzefi.zzp(r10, r6), com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.ads.zzeem.zzg(com.google.android.gms.internal.ads.zzefi.zzp(r10, r6), com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzm(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzm(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzk(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzl(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzk(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzl(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.ads.zzefi.zzl(r10, r6) == com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.zzefi.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.zzefi.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.zzefi.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.zzefi.zzo(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.ads.zzeem.zzg(com.google.android.gms.internal.ads.zzefi.zzp(r10, r6), com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zziad
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzhc(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.zzhd(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.ads.zzefi.zzk(r10, r4)
            int r4 = com.google.android.gms.internal.ads.zzefi.zzk(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzefi.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.ads.zzeem.zzg(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.ads.zzeem.zzg(r3, r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.ads.zzeem.zzg(r3, r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzefi.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.ads.zzeem.zzg(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.ads.zzefi.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.ads.zzefi.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.ads.zzefi.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.ads.zzefi.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.ads.zzefi.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.ads.zzefi.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzefi.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.ads.zzeem.zzg(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzefi.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.ads.zzeem.zzg(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzefi.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.ads.zzeem.zzg(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.ads.zzefi.zzm(r10, r6)
            boolean r5 = com.google.android.gms.internal.ads.zzefi.zzm(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.ads.zzefi.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.ads.zzefi.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.ads.zzefi.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzefi.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.ads.zzefi.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.ads.zzefi.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.ads.zzefi.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.ads.zzefi.zzn(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.ads.zzefi.zzn(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.ads.zzefi.zzo(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.ads.zzefi.zzo(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = 0
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.ads.zzefc<?, ?> r0 = r9.zziar
            java.lang.Object r0 = r0.zzay(r10)
            com.google.android.gms.internal.ads.zzefc<?, ?> r2 = r9.zziar
            java.lang.Object r2 = r2.zzay(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zziai
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.ads.zzebs<?> r0 = r9.zzias
            com.google.android.gms.internal.ads.zzebt r10 = r0.zzai(r10)
            com.google.android.gms.internal.ads.zzebs<?> r0 = r9.zzias
            com.google.android.gms.internal.ads.zzebt r11 = r0.zzai(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.equals(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c3, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0227, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0228, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zziad
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.zzhc(r1)
            int[] r4 = r8.zziad
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0219;
                case 1: goto L_0x020e;
                case 2: goto L_0x0203;
                case 3: goto L_0x01f8;
                case 4: goto L_0x01f1;
                case 5: goto L_0x01e6;
                case 6: goto L_0x01df;
                case 7: goto L_0x01d4;
                case 8: goto L_0x01c7;
                case 9: goto L_0x01b9;
                case 10: goto L_0x01ad;
                case 11: goto L_0x01a5;
                case 12: goto L_0x019d;
                case 13: goto L_0x0195;
                case 14: goto L_0x0189;
                case 15: goto L_0x0181;
                case 16: goto L_0x0175;
                case 17: goto L_0x016a;
                case 18: goto L_0x015e;
                case 19: goto L_0x015e;
                case 20: goto L_0x015e;
                case 21: goto L_0x015e;
                case 22: goto L_0x015e;
                case 23: goto L_0x015e;
                case 24: goto L_0x015e;
                case 25: goto L_0x015e;
                case 26: goto L_0x015e;
                case 27: goto L_0x015e;
                case 28: goto L_0x015e;
                case 29: goto L_0x015e;
                case 30: goto L_0x015e;
                case 31: goto L_0x015e;
                case 32: goto L_0x015e;
                case 33: goto L_0x015e;
                case 34: goto L_0x015e;
                case 35: goto L_0x015e;
                case 36: goto L_0x015e;
                case 37: goto L_0x015e;
                case 38: goto L_0x015e;
                case 39: goto L_0x015e;
                case 40: goto L_0x015e;
                case 41: goto L_0x015e;
                case 42: goto L_0x015e;
                case 43: goto L_0x015e;
                case 44: goto L_0x015e;
                case 45: goto L_0x015e;
                case 46: goto L_0x015e;
                case 47: goto L_0x015e;
                case 48: goto L_0x015e;
                case 49: goto L_0x015e;
                case 50: goto L_0x0152;
                case 51: goto L_0x013c;
                case 52: goto L_0x012a;
                case 53: goto L_0x0118;
                case 54: goto L_0x0106;
                case 55: goto L_0x00f8;
                case 56: goto L_0x00e6;
                case 57: goto L_0x00d8;
                case 58: goto L_0x00c6;
                case 59: goto L_0x00b2;
                case 60: goto L_0x00a0;
                case 61: goto L_0x008e;
                case 62: goto L_0x0080;
                case 63: goto L_0x0072;
                case 64: goto L_0x0064;
                case 65: goto L_0x0052;
                case 66: goto L_0x0044;
                case 67: goto L_0x0032;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0228
        L_0x0020:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzecg.zzfr(r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzecg.zzfr(r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = zzj(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzecg.zzbu(r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzecg.zzfr(r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzecg.zzfr(r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzecg.zzfr(r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = zzg(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = zzf(r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.ads.zzecg.zzfr(r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzefi.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzecg.zzfr(r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzefi.zzk(r9, r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzefi.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzecg.zzfr(r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzefi.zzk(r9, r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzefi.zzk(r9, r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzefi.zzk(r9, r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzefi.zzp(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.ads.zzefi.zzm(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzecg.zzbu(r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzefi.zzk(r9, r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzefi.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzecg.zzfr(r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzefi.zzk(r9, r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzefi.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzecg.zzfr(r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzefi.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzecg.zzfr(r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.ads.zzefi.zzn(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.ads.zzefi.zzo(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.ads.zzecg.zzfr(r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.ads.zzefc<?, ?> r0 = r8.zziar
            java.lang.Object r0 = r0.zzay(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zziai
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.ads.zzebs<?> r0 = r8.zzias
            com.google.android.gms.internal.ads.zzebt r9 = r0.zzai(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.hashCode(java.lang.Object):int");
    }

    public final T newInstance() {
        return this.zziap.newInstance(this.zziah);
    }

    public final void zzak(T t) {
        int i;
        int i2 = this.zzian;
        while (true) {
            i = this.zziao;
            if (i2 >= i) {
                break;
            }
            long zzhc = (long) (zzhc(this.zziam[i2]) & 1048575);
            Object zzp = zzefi.zzp(t, zzhc);
            if (zzp != null) {
                zzefi.zza((Object) t, zzhc, this.zziat.zzaq(zzp));
            }
            i2++;
        }
        int length = this.zziam.length;
        while (i < length) {
            this.zziaq.zzb(t, (long) this.zziam[i]);
            i++;
        }
        this.zziar.zzak(t);
        if (this.zziai) {
            this.zzias.zzak(t);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:397:0x0831, code lost:
        r8 = (r8 + r9) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x08fc, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:419:0x090d, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:435:0x0955, code lost:
        r6 = r6 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:472:0x0a06, code lost:
        r6 = r6 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:481:0x0a2a, code lost:
        r5 = r5 + 3;
        r9 = r13;
        r8 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzau(T r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r0.zziak
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x04f2
            sun.misc.Unsafe r2 = zzhgt
            r12 = 0
            r13 = 0
        L_0x0016:
            int[] r14 = r0.zziad
            int r14 = r14.length
            if (r12 >= r14) goto L_0x04ea
            int r14 = r0.zzhc(r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zziad
            r3 = r3[r12]
            r14 = r14 & r7
            long r5 = (long) r14
            com.google.android.gms.internal.ads.zzeby r14 = com.google.android.gms.internal.ads.zzeby.DOUBLE_LIST_PACKED
            int r14 = r14.mo22687id()
            if (r15 < r14) goto L_0x0041
            com.google.android.gms.internal.ads.zzeby r14 = com.google.android.gms.internal.ads.zzeby.SINT64_LIST_PACKED
            int r14 = r14.mo22687id()
            if (r15 > r14) goto L_0x0041
            int[] r14 = r0.zziad
            int r17 = r12 + 2
            r14 = r14[r17]
            r14 = r14 & r7
            goto L_0x0042
        L_0x0041:
            r14 = 0
        L_0x0042:
            switch(r15) {
                case 0: goto L_0x04d6;
                case 1: goto L_0x04ca;
                case 2: goto L_0x04ba;
                case 3: goto L_0x04aa;
                case 4: goto L_0x049a;
                case 5: goto L_0x048e;
                case 6: goto L_0x0482;
                case 7: goto L_0x0476;
                case 8: goto L_0x0458;
                case 9: goto L_0x0444;
                case 10: goto L_0x0433;
                case 11: goto L_0x0424;
                case 12: goto L_0x0415;
                case 13: goto L_0x040a;
                case 14: goto L_0x03ff;
                case 15: goto L_0x03f0;
                case 16: goto L_0x03e1;
                case 17: goto L_0x03cc;
                case 18: goto L_0x03c1;
                case 19: goto L_0x03b8;
                case 20: goto L_0x03af;
                case 21: goto L_0x03a6;
                case 22: goto L_0x039d;
                case 23: goto L_0x0394;
                case 24: goto L_0x038b;
                case 25: goto L_0x0382;
                case 26: goto L_0x0379;
                case 27: goto L_0x036c;
                case 28: goto L_0x0363;
                case 29: goto L_0x035a;
                case 30: goto L_0x0350;
                case 31: goto L_0x0346;
                case 32: goto L_0x033c;
                case 33: goto L_0x0332;
                case 34: goto L_0x0328;
                case 35: goto L_0x0308;
                case 36: goto L_0x02eb;
                case 37: goto L_0x02ce;
                case 38: goto L_0x02b1;
                case 39: goto L_0x0293;
                case 40: goto L_0x0275;
                case 41: goto L_0x0257;
                case 42: goto L_0x0239;
                case 43: goto L_0x021b;
                case 44: goto L_0x01fd;
                case 45: goto L_0x01df;
                case 46: goto L_0x01c1;
                case 47: goto L_0x01a3;
                case 48: goto L_0x0185;
                case 49: goto L_0x0177;
                case 50: goto L_0x0167;
                case 51: goto L_0x0159;
                case 52: goto L_0x014d;
                case 53: goto L_0x013d;
                case 54: goto L_0x012d;
                case 55: goto L_0x011d;
                case 56: goto L_0x0111;
                case 57: goto L_0x0105;
                case 58: goto L_0x00f9;
                case 59: goto L_0x00db;
                case 60: goto L_0x00c7;
                case 61: goto L_0x00b5;
                case 62: goto L_0x00a5;
                case 63: goto L_0x0095;
                case 64: goto L_0x0089;
                case 65: goto L_0x007d;
                case 66: goto L_0x006d;
                case 67: goto L_0x005d;
                case 68: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x04e4
        L_0x0047:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r1, r5)
            com.google.android.gms.internal.ads.zzedo r5 = (com.google.android.gms.internal.ads.zzedo) r5
            com.google.android.gms.internal.ads.zzeek r6 = r0.zzgz(r12)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x005d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzm(r3, r5)
            goto L_0x03c9
        L_0x006d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzah(r3, r5)
            goto L_0x03c9
        L_0x007d:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.ads.zzebk.zzo(r3, r9)
            goto L_0x03c9
        L_0x0089:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.ads.zzebk.zzaj(r3, r11)
            goto L_0x03c9
        L_0x0095:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzak(r3, r5)
            goto L_0x03c9
        L_0x00a5:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzag(r3, r5)
            goto L_0x03c9
        L_0x00b5:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r1, r5)
            com.google.android.gms.internal.ads.zzeaq r5 = (com.google.android.gms.internal.ads.zzeaq) r5
            int r3 = com.google.android.gms.internal.ads.zzebk.zzc((int) r3, (com.google.android.gms.internal.ads.zzeaq) r5)
            goto L_0x03c9
        L_0x00c7:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r1, r5)
            com.google.android.gms.internal.ads.zzeek r6 = r0.zzgz(r12)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzc((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.ads.zzeek) r6)
            goto L_0x03c9
        L_0x00db:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.ads.zzeaq
            if (r6 == 0) goto L_0x00f1
            com.google.android.gms.internal.ads.zzeaq r5 = (com.google.android.gms.internal.ads.zzeaq) r5
            int r3 = com.google.android.gms.internal.ads.zzebk.zzc((int) r3, (com.google.android.gms.internal.ads.zzeaq) r5)
            goto L_0x03c9
        L_0x00f1:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.ads.zzebk.zzl((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x00f9:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.ads.zzebk.zzi((int) r3, (boolean) r8)
            goto L_0x03c9
        L_0x0105:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.ads.zzebk.zzai(r3, r11)
            goto L_0x03c9
        L_0x0111:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.ads.zzebk.zzn(r3, r9)
            goto L_0x03c9
        L_0x011d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzaf(r3, r5)
            goto L_0x03c9
        L_0x012d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzl((int) r3, (long) r5)
            goto L_0x03c9
        L_0x013d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzk((int) r3, (long) r5)
            goto L_0x03c9
        L_0x014d:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.ads.zzebk.zzb((int) r3, (float) r4)
            goto L_0x03c9
        L_0x0159:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.ads.zzebk.zzc((int) r3, (double) r5)
            goto L_0x03c9
        L_0x0167:
            com.google.android.gms.internal.ads.zzedh r14 = r0.zziat
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r1, r5)
            java.lang.Object r6 = r0.zzha(r12)
            int r3 = r14.zzb(r3, r5, r6)
            goto L_0x03c9
        L_0x0177:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            com.google.android.gms.internal.ads.zzeek r6 = r0.zzgz(r12)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzd(r3, r5, r6)
            goto L_0x03c9
        L_0x0185:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzeem.zzab(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzial
            if (r6 == 0) goto L_0x0199
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0199:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzgk(r3)
            int r6 = com.google.android.gms.internal.ads.zzebk.zzgm(r5)
            goto L_0x0324
        L_0x01a3:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzeem.zzaf(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzial
            if (r6 == 0) goto L_0x01b7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01b7:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzgk(r3)
            int r6 = com.google.android.gms.internal.ads.zzebk.zzgm(r5)
            goto L_0x0324
        L_0x01c1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzeem.zzah(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzial
            if (r6 == 0) goto L_0x01d5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01d5:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzgk(r3)
            int r6 = com.google.android.gms.internal.ads.zzebk.zzgm(r5)
            goto L_0x0324
        L_0x01df:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzeem.zzag(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzial
            if (r6 == 0) goto L_0x01f3
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01f3:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzgk(r3)
            int r6 = com.google.android.gms.internal.ads.zzebk.zzgm(r5)
            goto L_0x0324
        L_0x01fd:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzeem.zzac(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzial
            if (r6 == 0) goto L_0x0211
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0211:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzgk(r3)
            int r6 = com.google.android.gms.internal.ads.zzebk.zzgm(r5)
            goto L_0x0324
        L_0x021b:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzeem.zzae(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzial
            if (r6 == 0) goto L_0x022f
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x022f:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzgk(r3)
            int r6 = com.google.android.gms.internal.ads.zzebk.zzgm(r5)
            goto L_0x0324
        L_0x0239:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzeem.zzai(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzial
            if (r6 == 0) goto L_0x024d
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x024d:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzgk(r3)
            int r6 = com.google.android.gms.internal.ads.zzebk.zzgm(r5)
            goto L_0x0324
        L_0x0257:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzeem.zzag(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzial
            if (r6 == 0) goto L_0x026b
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x026b:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzgk(r3)
            int r6 = com.google.android.gms.internal.ads.zzebk.zzgm(r5)
            goto L_0x0324
        L_0x0275:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzeem.zzah(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzial
            if (r6 == 0) goto L_0x0289
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0289:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzgk(r3)
            int r6 = com.google.android.gms.internal.ads.zzebk.zzgm(r5)
            goto L_0x0324
        L_0x0293:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzeem.zzad(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzial
            if (r6 == 0) goto L_0x02a7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02a7:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzgk(r3)
            int r6 = com.google.android.gms.internal.ads.zzebk.zzgm(r5)
            goto L_0x0324
        L_0x02b1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzeem.zzaa(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzial
            if (r6 == 0) goto L_0x02c5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02c5:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzgk(r3)
            int r6 = com.google.android.gms.internal.ads.zzebk.zzgm(r5)
            goto L_0x0324
        L_0x02ce:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzeem.zzz(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzial
            if (r6 == 0) goto L_0x02e2
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02e2:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzgk(r3)
            int r6 = com.google.android.gms.internal.ads.zzebk.zzgm(r5)
            goto L_0x0324
        L_0x02eb:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzeem.zzag(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzial
            if (r6 == 0) goto L_0x02ff
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02ff:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzgk(r3)
            int r6 = com.google.android.gms.internal.ads.zzebk.zzgm(r5)
            goto L_0x0324
        L_0x0308:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.ads.zzeem.zzah(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzial
            if (r6 == 0) goto L_0x031c
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x031c:
            int r3 = com.google.android.gms.internal.ads.zzebk.zzgk(r3)
            int r6 = com.google.android.gms.internal.ads.zzebk.zzgm(r5)
        L_0x0324:
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x03c9
        L_0x0328:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzq(r3, r5, r11)
            goto L_0x03c9
        L_0x0332:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzu(r3, r5, r11)
            goto L_0x03c9
        L_0x033c:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x0346:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x0350:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzr(r3, r5, r11)
            goto L_0x03c9
        L_0x035a:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzt(r3, r5, r11)
            goto L_0x03c9
        L_0x0363:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzd(r3, r5)
            goto L_0x03c9
        L_0x036c:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            com.google.android.gms.internal.ads.zzeek r6 = r0.zzgz(r12)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzc((int) r3, (java.util.List<?>) r5, (com.google.android.gms.internal.ads.zzeek) r6)
            goto L_0x03c9
        L_0x0379:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzc(r3, r5)
            goto L_0x03c9
        L_0x0382:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzx(r3, r5, r11)
            goto L_0x03c9
        L_0x038b:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x0394:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x039d:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzs(r3, r5, r11)
            goto L_0x03c9
        L_0x03a6:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzp(r3, r5, r11)
            goto L_0x03c9
        L_0x03af:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzo(r3, r5, r11)
            goto L_0x03c9
        L_0x03b8:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x03c1:
            java.util.List r5 = zze((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzw(r3, r5, r11)
        L_0x03c9:
            int r13 = r13 + r3
            goto L_0x04e4
        L_0x03cc:
            boolean r14 = r0.zze(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r1, r5)
            com.google.android.gms.internal.ads.zzedo r5 = (com.google.android.gms.internal.ads.zzedo) r5
            com.google.android.gms.internal.ads.zzeek r6 = r0.zzgz(r12)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x03e1:
            boolean r14 = r0.zze(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.ads.zzefi.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzm(r3, r5)
            goto L_0x03c9
        L_0x03f0:
            boolean r14 = r0.zze(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.ads.zzefi.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzah(r3, r5)
            goto L_0x03c9
        L_0x03ff:
            boolean r5 = r0.zze(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.ads.zzebk.zzo(r3, r9)
            goto L_0x03c9
        L_0x040a:
            boolean r5 = r0.zze(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.ads.zzebk.zzaj(r3, r11)
            goto L_0x03c9
        L_0x0415:
            boolean r14 = r0.zze(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.ads.zzefi.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzak(r3, r5)
            goto L_0x03c9
        L_0x0424:
            boolean r14 = r0.zze(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.ads.zzefi.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzag(r3, r5)
            goto L_0x03c9
        L_0x0433:
            boolean r14 = r0.zze(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r1, r5)
            com.google.android.gms.internal.ads.zzeaq r5 = (com.google.android.gms.internal.ads.zzeaq) r5
            int r3 = com.google.android.gms.internal.ads.zzebk.zzc((int) r3, (com.google.android.gms.internal.ads.zzeaq) r5)
            goto L_0x03c9
        L_0x0444:
            boolean r14 = r0.zze(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r1, r5)
            com.google.android.gms.internal.ads.zzeek r6 = r0.zzgz(r12)
            int r3 = com.google.android.gms.internal.ads.zzeem.zzc((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.ads.zzeek) r6)
            goto L_0x03c9
        L_0x0458:
            boolean r14 = r0.zze(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.ads.zzeaq
            if (r6 == 0) goto L_0x046e
            com.google.android.gms.internal.ads.zzeaq r5 = (com.google.android.gms.internal.ads.zzeaq) r5
            int r3 = com.google.android.gms.internal.ads.zzebk.zzc((int) r3, (com.google.android.gms.internal.ads.zzeaq) r5)
            goto L_0x03c9
        L_0x046e:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.ads.zzebk.zzl((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x0476:
            boolean r5 = r0.zze(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.ads.zzebk.zzi((int) r3, (boolean) r8)
            goto L_0x03c9
        L_0x0482:
            boolean r5 = r0.zze(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.ads.zzebk.zzai(r3, r11)
            goto L_0x03c9
        L_0x048e:
            boolean r5 = r0.zze(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.ads.zzebk.zzn(r3, r9)
            goto L_0x03c9
        L_0x049a:
            boolean r14 = r0.zze(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.ads.zzefi.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzaf(r3, r5)
            goto L_0x03c9
        L_0x04aa:
            boolean r14 = r0.zze(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.ads.zzefi.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzl((int) r3, (long) r5)
            goto L_0x03c9
        L_0x04ba:
            boolean r14 = r0.zze(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.ads.zzefi.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.ads.zzebk.zzk((int) r3, (long) r5)
            goto L_0x03c9
        L_0x04ca:
            boolean r5 = r0.zze(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.ads.zzebk.zzb((int) r3, (float) r4)
            goto L_0x03c9
        L_0x04d6:
            boolean r5 = r0.zze(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.ads.zzebk.zzc((int) r3, (double) r5)
            goto L_0x03c9
        L_0x04e4:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x04ea:
            com.google.android.gms.internal.ads.zzefc<?, ?> r2 = r0.zziar
            int r1 = zza(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x04f2:
            sun.misc.Unsafe r2 = zzhgt
            r3 = -1
            r5 = 0
            r6 = 0
            r12 = 0
        L_0x04f8:
            int[] r13 = r0.zziad
            int r13 = r13.length
            if (r5 >= r13) goto L_0x0a32
            int r13 = r0.zzhc(r5)
            int[] r14 = r0.zziad
            r15 = r14[r5]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r17 = r13 & r16
            int r4 = r17 >>> 20
            r11 = 17
            if (r4 > r11) goto L_0x0523
            int r11 = r5 + 2
            r11 = r14[r11]
            r14 = r11 & r7
            int r18 = r11 >>> 20
            int r18 = r8 << r18
            if (r14 == r3) goto L_0x0521
            long r8 = (long) r14
            int r12 = r2.getInt(r1, r8)
            r3 = r14
        L_0x0521:
            r8 = r11
            goto L_0x0542
        L_0x0523:
            boolean r8 = r0.zzial
            if (r8 == 0) goto L_0x053f
            com.google.android.gms.internal.ads.zzeby r8 = com.google.android.gms.internal.ads.zzeby.DOUBLE_LIST_PACKED
            int r8 = r8.mo22687id()
            if (r4 < r8) goto L_0x053f
            com.google.android.gms.internal.ads.zzeby r8 = com.google.android.gms.internal.ads.zzeby.SINT64_LIST_PACKED
            int r8 = r8.mo22687id()
            if (r4 > r8) goto L_0x053f
            int[] r8 = r0.zziad
            int r9 = r5 + 2
            r8 = r8[r9]
            r8 = r8 & r7
            goto L_0x0540
        L_0x053f:
            r8 = 0
        L_0x0540:
            r18 = 0
        L_0x0542:
            r9 = r13 & r7
            long r9 = (long) r9
            switch(r4) {
                case 0: goto L_0x0a1a;
                case 1: goto L_0x0a09;
                case 2: goto L_0x09f6;
                case 3: goto L_0x09e5;
                case 4: goto L_0x09d4;
                case 5: goto L_0x09c7;
                case 6: goto L_0x09ba;
                case 7: goto L_0x09ae;
                case 8: goto L_0x0992;
                case 9: goto L_0x0980;
                case 10: goto L_0x0971;
                case 11: goto L_0x0964;
                case 12: goto L_0x0957;
                case 13: goto L_0x094c;
                case 14: goto L_0x0941;
                case 15: goto L_0x0934;
                case 16: goto L_0x0927;
                case 17: goto L_0x0914;
                case 18: goto L_0x08ff;
                case 19: goto L_0x08f1;
                case 20: goto L_0x08e5;
                case 21: goto L_0x08d9;
                case 22: goto L_0x08cd;
                case 23: goto L_0x08c1;
                case 24: goto L_0x08b5;
                case 25: goto L_0x08a9;
                case 26: goto L_0x089e;
                case 27: goto L_0x088f;
                case 28: goto L_0x0883;
                case 29: goto L_0x0876;
                case 30: goto L_0x0869;
                case 31: goto L_0x085c;
                case 32: goto L_0x084f;
                case 33: goto L_0x0842;
                case 34: goto L_0x0835;
                case 35: goto L_0x0815;
                case 36: goto L_0x07f8;
                case 37: goto L_0x07db;
                case 38: goto L_0x07be;
                case 39: goto L_0x07a0;
                case 40: goto L_0x0782;
                case 41: goto L_0x0764;
                case 42: goto L_0x0746;
                case 43: goto L_0x0728;
                case 44: goto L_0x070a;
                case 45: goto L_0x06ec;
                case 46: goto L_0x06ce;
                case 47: goto L_0x06b0;
                case 48: goto L_0x0692;
                case 49: goto L_0x0682;
                case 50: goto L_0x0672;
                case 51: goto L_0x0664;
                case 52: goto L_0x0657;
                case 53: goto L_0x0647;
                case 54: goto L_0x0637;
                case 55: goto L_0x0627;
                case 56: goto L_0x0619;
                case 57: goto L_0x060c;
                case 58: goto L_0x05ff;
                case 59: goto L_0x05e1;
                case 60: goto L_0x05cd;
                case 61: goto L_0x05bb;
                case 62: goto L_0x05ab;
                case 63: goto L_0x059b;
                case 64: goto L_0x058e;
                case 65: goto L_0x0580;
                case 66: goto L_0x0570;
                case 67: goto L_0x0560;
                case 68: goto L_0x054a;
                default: goto L_0x0548;
            }
        L_0x0548:
            goto L_0x090b
        L_0x054a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzedo r4 = (com.google.android.gms.internal.ads.zzedo) r4
            com.google.android.gms.internal.ads.zzeek r8 = r0.zzgz(r5)
            int r4 = com.google.android.gms.internal.ads.zzebk.zzc(r15, r4, r8)
            goto L_0x090a
        L_0x0560:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            long r8 = zzi(r1, r9)
            int r4 = com.google.android.gms.internal.ads.zzebk.zzm(r15, r8)
            goto L_0x090a
        L_0x0570:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.ads.zzebk.zzah(r15, r4)
            goto L_0x090a
        L_0x0580:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r8 = 0
            int r4 = com.google.android.gms.internal.ads.zzebk.zzo(r15, r8)
            goto L_0x090a
        L_0x058e:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r4 = 0
            int r8 = com.google.android.gms.internal.ads.zzebk.zzaj(r15, r4)
            goto L_0x0955
        L_0x059b:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.ads.zzebk.zzak(r15, r4)
            goto L_0x090a
        L_0x05ab:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.ads.zzebk.zzag(r15, r4)
            goto L_0x090a
        L_0x05bb:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzeaq r4 = (com.google.android.gms.internal.ads.zzeaq) r4
            int r4 = com.google.android.gms.internal.ads.zzebk.zzc((int) r15, (com.google.android.gms.internal.ads.zzeaq) r4)
            goto L_0x090a
        L_0x05cd:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzeek r8 = r0.zzgz(r5)
            int r4 = com.google.android.gms.internal.ads.zzeem.zzc((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.ads.zzeek) r8)
            goto L_0x090a
        L_0x05e1:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            boolean r8 = r4 instanceof com.google.android.gms.internal.ads.zzeaq
            if (r8 == 0) goto L_0x05f7
            com.google.android.gms.internal.ads.zzeaq r4 = (com.google.android.gms.internal.ads.zzeaq) r4
            int r4 = com.google.android.gms.internal.ads.zzebk.zzc((int) r15, (com.google.android.gms.internal.ads.zzeaq) r4)
            goto L_0x090a
        L_0x05f7:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.ads.zzebk.zzl((int) r15, (java.lang.String) r4)
            goto L_0x090a
        L_0x05ff:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r4 = 1
            int r8 = com.google.android.gms.internal.ads.zzebk.zzi((int) r15, (boolean) r4)
            goto L_0x0955
        L_0x060c:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r4 = 0
            int r8 = com.google.android.gms.internal.ads.zzebk.zzai(r15, r4)
            goto L_0x0955
        L_0x0619:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r8 = 0
            int r4 = com.google.android.gms.internal.ads.zzebk.zzn(r15, r8)
            goto L_0x090a
        L_0x0627:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.ads.zzebk.zzaf(r15, r4)
            goto L_0x090a
        L_0x0637:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            long r8 = zzi(r1, r9)
            int r4 = com.google.android.gms.internal.ads.zzebk.zzl((int) r15, (long) r8)
            goto L_0x090a
        L_0x0647:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            long r8 = zzi(r1, r9)
            int r4 = com.google.android.gms.internal.ads.zzebk.zzk((int) r15, (long) r8)
            goto L_0x090a
        L_0x0657:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r4 = 0
            int r8 = com.google.android.gms.internal.ads.zzebk.zzb((int) r15, (float) r4)
            goto L_0x0955
        L_0x0664:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r8 = 0
            int r4 = com.google.android.gms.internal.ads.zzebk.zzc((int) r15, (double) r8)
            goto L_0x090a
        L_0x0672:
            com.google.android.gms.internal.ads.zzedh r4 = r0.zziat
            java.lang.Object r8 = r2.getObject(r1, r9)
            java.lang.Object r9 = r0.zzha(r5)
            int r4 = r4.zzb(r15, r8, r9)
            goto L_0x090a
        L_0x0682:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.ads.zzeek r8 = r0.zzgz(r5)
            int r4 = com.google.android.gms.internal.ads.zzeem.zzd(r15, r4, r8)
            goto L_0x090a
        L_0x0692:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzab(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x06a6
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x06a6:
            int r8 = com.google.android.gms.internal.ads.zzebk.zzgk(r15)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzgm(r4)
            goto L_0x0831
        L_0x06b0:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzaf(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x06c4
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x06c4:
            int r8 = com.google.android.gms.internal.ads.zzebk.zzgk(r15)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzgm(r4)
            goto L_0x0831
        L_0x06ce:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzah(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x06e2
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x06e2:
            int r8 = com.google.android.gms.internal.ads.zzebk.zzgk(r15)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzgm(r4)
            goto L_0x0831
        L_0x06ec:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzag(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x0700
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x0700:
            int r8 = com.google.android.gms.internal.ads.zzebk.zzgk(r15)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzgm(r4)
            goto L_0x0831
        L_0x070a:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzac(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x071e
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x071e:
            int r8 = com.google.android.gms.internal.ads.zzebk.zzgk(r15)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzgm(r4)
            goto L_0x0831
        L_0x0728:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzae(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x073c
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x073c:
            int r8 = com.google.android.gms.internal.ads.zzebk.zzgk(r15)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzgm(r4)
            goto L_0x0831
        L_0x0746:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzai(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x075a
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x075a:
            int r8 = com.google.android.gms.internal.ads.zzebk.zzgk(r15)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzgm(r4)
            goto L_0x0831
        L_0x0764:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzag(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x0778
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x0778:
            int r8 = com.google.android.gms.internal.ads.zzebk.zzgk(r15)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzgm(r4)
            goto L_0x0831
        L_0x0782:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzah(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x0796
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x0796:
            int r8 = com.google.android.gms.internal.ads.zzebk.zzgk(r15)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzgm(r4)
            goto L_0x0831
        L_0x07a0:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzad(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x07b4
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x07b4:
            int r8 = com.google.android.gms.internal.ads.zzebk.zzgk(r15)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzgm(r4)
            goto L_0x0831
        L_0x07be:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzaa(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x07d2
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x07d2:
            int r8 = com.google.android.gms.internal.ads.zzebk.zzgk(r15)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzgm(r4)
            goto L_0x0831
        L_0x07db:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzz(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x07ef
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x07ef:
            int r8 = com.google.android.gms.internal.ads.zzebk.zzgk(r15)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzgm(r4)
            goto L_0x0831
        L_0x07f8:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzag(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x080c
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x080c:
            int r8 = com.google.android.gms.internal.ads.zzebk.zzgk(r15)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzgm(r4)
            goto L_0x0831
        L_0x0815:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzah(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzial
            if (r9 == 0) goto L_0x0829
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x0829:
            int r8 = com.google.android.gms.internal.ads.zzebk.zzgk(r15)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzgm(r4)
        L_0x0831:
            int r8 = r8 + r9
            int r8 = r8 + r4
            goto L_0x0955
        L_0x0835:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            r8 = 0
            int r4 = com.google.android.gms.internal.ads.zzeem.zzq(r15, r4, r8)
            goto L_0x08fc
        L_0x0842:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzu(r15, r4, r8)
            goto L_0x08fc
        L_0x084f:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzw(r15, r4, r8)
            goto L_0x08fc
        L_0x085c:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzv(r15, r4, r8)
            goto L_0x08fc
        L_0x0869:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzr(r15, r4, r8)
            goto L_0x08fc
        L_0x0876:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzt(r15, r4, r8)
            goto L_0x090a
        L_0x0883:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzd(r15, r4)
            goto L_0x090a
        L_0x088f:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.ads.zzeek r8 = r0.zzgz(r5)
            int r4 = com.google.android.gms.internal.ads.zzeem.zzc((int) r15, (java.util.List<?>) r4, (com.google.android.gms.internal.ads.zzeek) r8)
            goto L_0x090a
        L_0x089e:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzc(r15, r4)
            goto L_0x090a
        L_0x08a9:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            r8 = 0
            int r4 = com.google.android.gms.internal.ads.zzeem.zzx(r15, r4, r8)
            goto L_0x08fc
        L_0x08b5:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzv(r15, r4, r8)
            goto L_0x08fc
        L_0x08c1:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzw(r15, r4, r8)
            goto L_0x08fc
        L_0x08cd:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzs(r15, r4, r8)
            goto L_0x08fc
        L_0x08d9:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzp(r15, r4, r8)
            goto L_0x08fc
        L_0x08e5:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzo(r15, r4, r8)
            goto L_0x08fc
        L_0x08f1:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzv(r15, r4, r8)
        L_0x08fc:
            int r6 = r6 + r4
            r4 = 1
            goto L_0x090d
        L_0x08ff:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzeem.zzw(r15, r4, r8)
        L_0x090a:
            int r6 = r6 + r4
        L_0x090b:
            r4 = 1
        L_0x090c:
            r8 = 0
        L_0x090d:
            r9 = 0
            r10 = 0
            r13 = 0
            goto L_0x0a2a
        L_0x0914:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzedo r4 = (com.google.android.gms.internal.ads.zzedo) r4
            com.google.android.gms.internal.ads.zzeek r8 = r0.zzgz(r5)
            int r4 = com.google.android.gms.internal.ads.zzebk.zzc(r15, r4, r8)
            goto L_0x090a
        L_0x0927:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            long r8 = r2.getLong(r1, r9)
            int r4 = com.google.android.gms.internal.ads.zzebk.zzm(r15, r8)
            goto L_0x090a
        L_0x0934:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.ads.zzebk.zzah(r15, r4)
            goto L_0x090a
        L_0x0941:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            r8 = 0
            int r4 = com.google.android.gms.internal.ads.zzebk.zzo(r15, r8)
            goto L_0x090a
        L_0x094c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            r4 = 0
            int r8 = com.google.android.gms.internal.ads.zzebk.zzaj(r15, r4)
        L_0x0955:
            int r6 = r6 + r8
            goto L_0x090b
        L_0x0957:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.ads.zzebk.zzak(r15, r4)
            goto L_0x090a
        L_0x0964:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.ads.zzebk.zzag(r15, r4)
            goto L_0x090a
        L_0x0971:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzeaq r4 = (com.google.android.gms.internal.ads.zzeaq) r4
            int r4 = com.google.android.gms.internal.ads.zzebk.zzc((int) r15, (com.google.android.gms.internal.ads.zzeaq) r4)
            goto L_0x090a
        L_0x0980:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzeek r8 = r0.zzgz(r5)
            int r4 = com.google.android.gms.internal.ads.zzeem.zzc((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.ads.zzeek) r8)
            goto L_0x090a
        L_0x0992:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            boolean r8 = r4 instanceof com.google.android.gms.internal.ads.zzeaq
            if (r8 == 0) goto L_0x09a6
            com.google.android.gms.internal.ads.zzeaq r4 = (com.google.android.gms.internal.ads.zzeaq) r4
            int r4 = com.google.android.gms.internal.ads.zzebk.zzc((int) r15, (com.google.android.gms.internal.ads.zzeaq) r4)
            goto L_0x090a
        L_0x09a6:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.ads.zzebk.zzl((int) r15, (java.lang.String) r4)
            goto L_0x090a
        L_0x09ae:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            r4 = 1
            int r8 = com.google.android.gms.internal.ads.zzebk.zzi((int) r15, (boolean) r4)
            int r6 = r6 + r8
            goto L_0x090c
        L_0x09ba:
            r4 = 1
            r8 = r12 & r18
            if (r8 == 0) goto L_0x090c
            r8 = 0
            int r9 = com.google.android.gms.internal.ads.zzebk.zzai(r15, r8)
            int r6 = r6 + r9
            goto L_0x090d
        L_0x09c7:
            r4 = 1
            r8 = 0
            r9 = r12 & r18
            r13 = 0
            if (r9 == 0) goto L_0x0a07
            int r9 = com.google.android.gms.internal.ads.zzebk.zzn(r15, r13)
            goto L_0x0a06
        L_0x09d4:
            r4 = 1
            r8 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a07
            int r9 = r2.getInt(r1, r9)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzaf(r15, r9)
            goto L_0x0a06
        L_0x09e5:
            r4 = 1
            r8 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a07
            long r9 = r2.getLong(r1, r9)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzl((int) r15, (long) r9)
            goto L_0x0a06
        L_0x09f6:
            r4 = 1
            r8 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a07
            long r9 = r2.getLong(r1, r9)
            int r9 = com.google.android.gms.internal.ads.zzebk.zzk((int) r15, (long) r9)
        L_0x0a06:
            int r6 = r6 + r9
        L_0x0a07:
            r9 = 0
            goto L_0x0a17
        L_0x0a09:
            r4 = 1
            r8 = 0
            r13 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x0a07
            r9 = 0
            int r10 = com.google.android.gms.internal.ads.zzebk.zzb((int) r15, (float) r9)
            int r6 = r6 + r10
        L_0x0a17:
            r10 = 0
            goto L_0x0a2a
        L_0x0a1a:
            r4 = 1
            r8 = 0
            r9 = 0
            r13 = 0
            r10 = r12 & r18
            if (r10 == 0) goto L_0x0a17
            r10 = 0
            int r15 = com.google.android.gms.internal.ads.zzebk.zzc((int) r15, (double) r10)
            int r6 = r6 + r15
        L_0x0a2a:
            int r5 = r5 + 3
            r9 = r13
            r4 = 0
            r8 = 1
            r11 = 0
            goto L_0x04f8
        L_0x0a32:
            r8 = 0
            com.google.android.gms.internal.ads.zzefc<?, ?> r2 = r0.zziar
            int r2 = zza(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.zziai
            if (r2 == 0) goto L_0x0a8c
            com.google.android.gms.internal.ads.zzebs<?> r2 = r0.zzias
            com.google.android.gms.internal.ads.zzebt r1 = r2.zzai(r1)
            r11 = 0
        L_0x0a45:
            com.google.android.gms.internal.ads.zzeel<T, java.lang.Object> r2 = r1.zzhut
            int r2 = r2.zzbgq()
            if (r11 >= r2) goto L_0x0a65
            com.google.android.gms.internal.ads.zzeel<T, java.lang.Object> r2 = r1.zzhut
            java.util.Map$Entry r2 = r2.zzhj(r11)
            java.lang.Object r3 = r2.getKey()
            com.google.android.gms.internal.ads.zzebv r3 = (com.google.android.gms.internal.ads.zzebv) r3
            java.lang.Object r2 = r2.getValue()
            int r2 = com.google.android.gms.internal.ads.zzebt.zzb((com.google.android.gms.internal.ads.zzebv<?>) r3, (java.lang.Object) r2)
            int r8 = r8 + r2
            int r11 = r11 + 1
            goto L_0x0a45
        L_0x0a65:
            com.google.android.gms.internal.ads.zzeel<T, java.lang.Object> r1 = r1.zzhut
            java.lang.Iterable r1 = r1.zzbgr()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a6f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0a8b
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            com.google.android.gms.internal.ads.zzebv r3 = (com.google.android.gms.internal.ads.zzebv) r3
            java.lang.Object r2 = r2.getValue()
            int r2 = com.google.android.gms.internal.ads.zzebt.zzb((com.google.android.gms.internal.ads.zzebv<?>) r3, (java.lang.Object) r2)
            int r8 = r8 + r2
            goto L_0x0a6f
        L_0x0a8b:
            int r6 = r6 + r8
        L_0x0a8c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zzau(java.lang.Object):int");
    }

    public final boolean zzaw(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.zzian) {
                return !this.zziai || this.zzias.zzai(t).isInitialized();
            }
            int i5 = this.zziam[i3];
            int i6 = this.zziad[i5];
            int zzhc = zzhc(i5);
            if (!this.zziak) {
                int i7 = this.zziad[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i4 = zzhgt.getInt(t, (long) i8);
                    i2 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzhc) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzhc) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza((Object) t, zzhc, zzgz(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzao = this.zziat.zzao(zzefi.zzp(t, (long) (zzhc & 1048575)));
                            if (!zzao.isEmpty()) {
                                if (this.zziat.zzas(zzha(i5)).zzhzy.zzbhn() == zzefw.MESSAGE) {
                                    zzeek<?> zzeek = null;
                                    Iterator<?> it = zzao.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzeek == null) {
                                            zzeek = zzedz.zzbgk().zzh(next.getClass());
                                        }
                                        if (!zzeek.zzaw(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzefi.zzp(t, (long) (zzhc & 1048575));
                if (!list.isEmpty()) {
                    zzeek zzgz = zzgz(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zzgz.zzaw(list.get(i10))) {
                            z = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i5, i4, i) && !zza((Object) t, zzhc, zzgz(i5))) {
                return false;
            }
            i3++;
        }
    }

    public final void zzf(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zziad.length; i += 3) {
                int zzhc = zzhc(i);
                long j = (long) (1048575 & zzhc);
                int i2 = this.zziad[i];
                switch ((zzhc & 267386880) >>> 20) {
                    case 0:
                        if (!zze(t2, i)) {
                            break;
                        } else {
                            zzefi.zza((Object) t, j, zzefi.zzo(t2, j));
                            zzf(t, i);
                            break;
                        }
                    case 1:
                        if (!zze(t2, i)) {
                            break;
                        } else {
                            zzefi.zza((Object) t, j, zzefi.zzn(t2, j));
                            zzf(t, i);
                            break;
                        }
                    case 2:
                        if (!zze(t2, i)) {
                            break;
                        } else {
                            zzefi.zza((Object) t, j, zzefi.zzl(t2, j));
                            zzf(t, i);
                            break;
                        }
                    case 3:
                        if (!zze(t2, i)) {
                            break;
                        } else {
                            zzefi.zza((Object) t, j, zzefi.zzl(t2, j));
                            zzf(t, i);
                            break;
                        }
                    case 4:
                        if (!zze(t2, i)) {
                            break;
                        } else {
                            zzefi.zzb((Object) t, j, zzefi.zzk(t2, j));
                            zzf(t, i);
                            break;
                        }
                    case 5:
                        if (!zze(t2, i)) {
                            break;
                        } else {
                            zzefi.zza((Object) t, j, zzefi.zzl(t2, j));
                            zzf(t, i);
                            break;
                        }
                    case 6:
                        if (!zze(t2, i)) {
                            break;
                        } else {
                            zzefi.zzb((Object) t, j, zzefi.zzk(t2, j));
                            zzf(t, i);
                            break;
                        }
                    case 7:
                        if (!zze(t2, i)) {
                            break;
                        } else {
                            zzefi.zza((Object) t, j, zzefi.zzm(t2, j));
                            zzf(t, i);
                            break;
                        }
                    case 8:
                        if (!zze(t2, i)) {
                            break;
                        } else {
                            zzefi.zza((Object) t, j, zzefi.zzp(t2, j));
                            zzf(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zze(t2, i)) {
                            break;
                        } else {
                            zzefi.zza((Object) t, j, zzefi.zzp(t2, j));
                            zzf(t, i);
                            break;
                        }
                    case 11:
                        if (!zze(t2, i)) {
                            break;
                        } else {
                            zzefi.zzb((Object) t, j, zzefi.zzk(t2, j));
                            zzf(t, i);
                            break;
                        }
                    case 12:
                        if (!zze(t2, i)) {
                            break;
                        } else {
                            zzefi.zzb((Object) t, j, zzefi.zzk(t2, j));
                            zzf(t, i);
                            break;
                        }
                    case 13:
                        if (!zze(t2, i)) {
                            break;
                        } else {
                            zzefi.zzb((Object) t, j, zzefi.zzk(t2, j));
                            zzf(t, i);
                            break;
                        }
                    case 14:
                        if (!zze(t2, i)) {
                            break;
                        } else {
                            zzefi.zza((Object) t, j, zzefi.zzl(t2, j));
                            zzf(t, i);
                            break;
                        }
                    case 15:
                        if (!zze(t2, i)) {
                            break;
                        } else {
                            zzefi.zzb((Object) t, j, zzefi.zzk(t2, j));
                            zzf(t, i);
                            break;
                        }
                    case 16:
                        if (!zze(t2, i)) {
                            break;
                        } else {
                            zzefi.zza((Object) t, j, zzefi.zzl(t2, j));
                            zzf(t, i);
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zziaq.zza(t, t2, j);
                        break;
                    case 50:
                        zzeem.zza(this.zziat, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzefi.zza((Object) t, j, zzefi.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzefi.zza((Object) t, j, zzefi.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            zzeem.zza(this.zziar, t, t2);
            if (this.zziai) {
                zzeem.zza(this.zzias, t, t2);
                return;
            }
            return;
        }
        throw null;
    }

    private final boolean zze(T t, int i) {
        if (this.zziak) {
            int zzhc = zzhc(i);
            long j = (long) (zzhc & 1048575);
            switch ((zzhc & 267386880) >>> 20) {
                case 0:
                    return zzefi.zzo(t, j) != 0.0d;
                case 1:
                    return zzefi.zzn(t, j) != 0.0f;
                case 2:
                    return zzefi.zzl(t, j) != 0;
                case 3:
                    return zzefi.zzl(t, j) != 0;
                case 4:
                    return zzefi.zzk(t, j) != 0;
                case 5:
                    return zzefi.zzl(t, j) != 0;
                case 6:
                    return zzefi.zzk(t, j) != 0;
                case 7:
                    return zzefi.zzm(t, j);
                case 8:
                    Object zzp = zzefi.zzp(t, j);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzeaq) {
                        return !zzeaq.zzhtf.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzefi.zzp(t, j) != null;
                case 10:
                    return !zzeaq.zzhtf.equals(zzefi.zzp(t, j));
                case 11:
                    return zzefi.zzk(t, j) != 0;
                case 12:
                    return zzefi.zzk(t, j) != 0;
                case 13:
                    return zzefi.zzk(t, j) != 0;
                case 14:
                    return zzefi.zzl(t, j) != 0;
                case 15:
                    return zzefi.zzk(t, j) != 0;
                case 16:
                    return zzefi.zzl(t, j) != 0;
                case 17:
                    return zzefi.zzp(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzhd = zzhd(i);
            return (zzefi.zzk(t, (long) (zzhd & 1048575)) & (1 << (zzhd >>> 20))) != 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.ads.zzefv r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zziai
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.ads.zzebs<?> r3 = r0.zzias
            com.google.android.gms.internal.ads.zzebt r3 = r3.zzai(r1)
            com.google.android.gms.internal.ads.zzeel<T, java.lang.Object> r5 = r3.zzhut
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            r6 = -1
            int[] r7 = r0.zziad
            int r7 = r7.length
            sun.misc.Unsafe r8 = zzhgt
            r10 = 0
            r11 = 0
        L_0x002d:
            if (r10 >= r7) goto L_0x0494
            int r12 = r0.zzhc(r10)
            int[] r13 = r0.zziad
            r14 = r13[r10]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zziak
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r4 != 0) goto L_0x005d
            r4 = 17
            if (r15 > r4) goto L_0x005d
            int r4 = r10 + 2
            r4 = r13[r4]
            r13 = r4 & r16
            r17 = r10
            if (r13 == r6) goto L_0x0057
            long r9 = (long) r13
            int r11 = r8.getInt(r1, r9)
            r6 = r13
        L_0x0057:
            int r4 = r4 >>> 20
            r9 = 1
            int r4 = r9 << r4
            goto L_0x0060
        L_0x005d:
            r17 = r10
            r4 = 0
        L_0x0060:
            if (r5 == 0) goto L_0x007e
            com.google.android.gms.internal.ads.zzebs<?> r9 = r0.zzias
            int r9 = r9.zza(r5)
            if (r9 > r14) goto L_0x007e
            com.google.android.gms.internal.ads.zzebs<?> r9 = r0.zzias
            r9.zza(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x007c
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0060
        L_0x007c:
            r5 = 0
            goto L_0x0060
        L_0x007e:
            r9 = r12 & r16
            long r9 = (long) r9
            r12 = r17
            switch(r15) {
                case 0: goto L_0x0485;
                case 1: goto L_0x0479;
                case 2: goto L_0x046d;
                case 3: goto L_0x0461;
                case 4: goto L_0x0455;
                case 5: goto L_0x0449;
                case 6: goto L_0x043d;
                case 7: goto L_0x0431;
                case 8: goto L_0x0425;
                case 9: goto L_0x0414;
                case 10: goto L_0x0405;
                case 11: goto L_0x03f8;
                case 12: goto L_0x03eb;
                case 13: goto L_0x03de;
                case 14: goto L_0x03d1;
                case 15: goto L_0x03c4;
                case 16: goto L_0x03b7;
                case 17: goto L_0x03a6;
                case 18: goto L_0x0396;
                case 19: goto L_0x0386;
                case 20: goto L_0x0376;
                case 21: goto L_0x0366;
                case 22: goto L_0x0356;
                case 23: goto L_0x0346;
                case 24: goto L_0x0336;
                case 25: goto L_0x0326;
                case 26: goto L_0x0317;
                case 27: goto L_0x0304;
                case 28: goto L_0x02f5;
                case 29: goto L_0x02e5;
                case 30: goto L_0x02d5;
                case 31: goto L_0x02c5;
                case 32: goto L_0x02b5;
                case 33: goto L_0x02a5;
                case 34: goto L_0x0295;
                case 35: goto L_0x0285;
                case 36: goto L_0x0275;
                case 37: goto L_0x0265;
                case 38: goto L_0x0255;
                case 39: goto L_0x0245;
                case 40: goto L_0x0235;
                case 41: goto L_0x0225;
                case 42: goto L_0x0215;
                case 43: goto L_0x0205;
                case 44: goto L_0x01f5;
                case 45: goto L_0x01e5;
                case 46: goto L_0x01d5;
                case 47: goto L_0x01c5;
                case 48: goto L_0x01b5;
                case 49: goto L_0x01a2;
                case 50: goto L_0x0199;
                case 51: goto L_0x018a;
                case 52: goto L_0x017b;
                case 53: goto L_0x016c;
                case 54: goto L_0x015d;
                case 55: goto L_0x014e;
                case 56: goto L_0x013f;
                case 57: goto L_0x0130;
                case 58: goto L_0x0121;
                case 59: goto L_0x0112;
                case 60: goto L_0x00ff;
                case 61: goto L_0x00ef;
                case 62: goto L_0x00e1;
                case 63: goto L_0x00d3;
                case 64: goto L_0x00c5;
                case 65: goto L_0x00b7;
                case 66: goto L_0x00a9;
                case 67: goto L_0x009b;
                case 68: goto L_0x0089;
                default: goto L_0x0086;
            }
        L_0x0086:
            r13 = 0
            goto L_0x0490
        L_0x0089:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzeek r9 = r0.zzgz(r12)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.ads.zzeek) r9)
            goto L_0x0086
        L_0x009b:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzi(r1, r9)
            r2.zzi(r14, r9)
            goto L_0x0086
        L_0x00a9:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzad(r14, r4)
            goto L_0x0086
        L_0x00b7:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzi(r1, r9)
            r2.zzq(r14, r9)
            goto L_0x0086
        L_0x00c5:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzal(r14, r4)
            goto L_0x0086
        L_0x00d3:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzam(r14, r4)
            goto L_0x0086
        L_0x00e1:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzac(r14, r4)
            goto L_0x0086
        L_0x00ef:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzeaq r4 = (com.google.android.gms.internal.ads.zzeaq) r4
            r2.zza((int) r14, (com.google.android.gms.internal.ads.zzeaq) r4)
            goto L_0x0086
        L_0x00ff:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzeek r9 = r0.zzgz(r12)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.ads.zzeek) r9)
            goto L_0x0086
        L_0x0112:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.ads.zzefv) r2)
            goto L_0x0086
        L_0x0121:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            boolean r4 = zzj(r1, r9)
            r2.zzh((int) r14, (boolean) r4)
            goto L_0x0086
        L_0x0130:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzae(r14, r4)
            goto L_0x0086
        L_0x013f:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzi(r1, r9)
            r2.zzj(r14, r9)
            goto L_0x0086
        L_0x014e:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            int r4 = zzh(r1, r9)
            r2.zzab(r14, r4)
            goto L_0x0086
        L_0x015d:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzi(r1, r9)
            r2.zzh((int) r14, (long) r9)
            goto L_0x0086
        L_0x016c:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            long r9 = zzi(r1, r9)
            r2.zzp(r14, r9)
            goto L_0x0086
        L_0x017b:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            float r4 = zzg(r1, r9)
            r2.zza((int) r14, (float) r4)
            goto L_0x0086
        L_0x018a:
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0086
            double r9 = zzf(r1, (long) r9)
            r2.zzb((int) r14, (double) r9)
            goto L_0x0086
        L_0x0199:
            java.lang.Object r4 = r8.getObject(r1, r9)
            r0.zza((com.google.android.gms.internal.ads.zzefv) r2, (int) r14, (java.lang.Object) r4, (int) r12)
            goto L_0x0086
        L_0x01a2:
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeek r10 = r0.zzgz(r12)
            com.google.android.gms.internal.ads.zzeem.zzb((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.ads.zzefv) r2, (com.google.android.gms.internal.ads.zzeek) r10)
            goto L_0x0086
        L_0x01b5:
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.ads.zzeem.zze(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01c5:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzj(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01d5:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzg(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01e5:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzl(r4, r9, r2, r13)
            goto L_0x0086
        L_0x01f5:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzm(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0205:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzi(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0215:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzn(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0225:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzk(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0235:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzf(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0245:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzh(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0255:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzd(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0265:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzc(r4, r9, r2, r13)
            goto L_0x0086
        L_0x0275:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.ads.zzefv) r2, (boolean) r13)
            goto L_0x0086
        L_0x0285:
            r13 = 1
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.ads.zzefv) r2, (boolean) r13)
            goto L_0x0086
        L_0x0295:
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.ads.zzeem.zze(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02a5:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzj(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02b5:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzg(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02c5:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzl(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02d5:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzm(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02e5:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzi(r4, r9, r2, r13)
            goto L_0x0490
        L_0x02f5:
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzb(r4, r9, r2)
            goto L_0x0086
        L_0x0304:
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeek r10 = r0.zzgz(r12)
            com.google.android.gms.internal.ads.zzeem.zza((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.ads.zzefv) r2, (com.google.android.gms.internal.ads.zzeek) r10)
            goto L_0x0086
        L_0x0317:
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zza((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.ads.zzefv) r2)
            goto L_0x0086
        L_0x0326:
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.ads.zzeem.zzn(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0336:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzk(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0346:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzf(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0356:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzh(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0366:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzd(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0376:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzc(r4, r9, r2, r13)
            goto L_0x0490
        L_0x0386:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.ads.zzefv) r2, (boolean) r13)
            goto L_0x0490
        L_0x0396:
            r13 = 0
            int[] r4 = r0.zziad
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.ads.zzefv) r2, (boolean) r13)
            goto L_0x0490
        L_0x03a6:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzeek r9 = r0.zzgz(r12)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.ads.zzeek) r9)
            goto L_0x0490
        L_0x03b7:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzi(r14, r9)
            goto L_0x0490
        L_0x03c4:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzad(r14, r4)
            goto L_0x0490
        L_0x03d1:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzq(r14, r9)
            goto L_0x0490
        L_0x03de:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzal(r14, r4)
            goto L_0x0490
        L_0x03eb:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzam(r14, r4)
            goto L_0x0490
        L_0x03f8:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzac(r14, r4)
            goto L_0x0490
        L_0x0405:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzeaq r4 = (com.google.android.gms.internal.ads.zzeaq) r4
            r2.zza((int) r14, (com.google.android.gms.internal.ads.zzeaq) r4)
            goto L_0x0490
        L_0x0414:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzeek r9 = r0.zzgz(r12)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.ads.zzeek) r9)
            goto L_0x0490
        L_0x0425:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.ads.zzefv) r2)
            goto L_0x0490
        L_0x0431:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            boolean r4 = com.google.android.gms.internal.ads.zzefi.zzm(r1, r9)
            r2.zzh((int) r14, (boolean) r4)
            goto L_0x0490
        L_0x043d:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzae(r14, r4)
            goto L_0x0490
        L_0x0449:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzj(r14, r9)
            goto L_0x0490
        L_0x0455:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            int r4 = r8.getInt(r1, r9)
            r2.zzab(r14, r4)
            goto L_0x0490
        L_0x0461:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzh((int) r14, (long) r9)
            goto L_0x0490
        L_0x046d:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            long r9 = r8.getLong(r1, r9)
            r2.zzp(r14, r9)
            goto L_0x0490
        L_0x0479:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            float r4 = com.google.android.gms.internal.ads.zzefi.zzn(r1, r9)
            r2.zza((int) r14, (float) r4)
            goto L_0x0490
        L_0x0485:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0490
            double r9 = com.google.android.gms.internal.ads.zzefi.zzo(r1, r9)
            r2.zzb((int) r14, (double) r9)
        L_0x0490:
            int r10 = r12 + 3
            goto L_0x002d
        L_0x0494:
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.ads.zzebs<?> r4 = r0.zzias
            r4.zza(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04a9
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x0494
        L_0x04a9:
            r5 = 0
            goto L_0x0494
        L_0x04ab:
            com.google.android.gms.internal.ads.zzefc<?, ?> r3 = r0.zziar
            zza(r3, r1, (com.google.android.gms.internal.ads.zzefv) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zzb(java.lang.Object, com.google.android.gms.internal.ads.zzefv):void");
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzefi.zzp(t, j)).doubleValue();
    }

    private final void zzf(T t, int i) {
        if (!this.zziak) {
            int zzhd = zzhd(i);
            long j = (long) (zzhd & 1048575);
            zzefi.zzb((Object) t, j, zzefi.zzk(t, j) | (1 << (zzhd >>> 20)));
        }
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzhc = (long) (zzhc(i) & 1048575);
        if (zze(t2, i)) {
            Object zzp = zzefi.zzp(t, zzhc);
            Object zzp2 = zzefi.zzp(t2, zzhc);
            if (zzp != null && zzp2 != null) {
                zzefi.zza((Object) t, zzhc, zzecg.zzd(zzp, zzp2));
                zzf(t, i);
            } else if (zzp2 != null) {
                zzefi.zza((Object) t, zzhc, zzp2);
                zzf(t, i);
            }
        }
    }

    private static <UT, UB> int zza(zzefc<UT, UB> zzefc, T t) {
        return zzefc.zzau(zzefc.zzay(t));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.ads.zzefv r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzbeb()
            int r1 = com.google.android.gms.internal.ads.zzecd.zzf.zzhyn
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.ads.zzefc<?, ?> r0 = r13.zziar
            zza(r0, r14, (com.google.android.gms.internal.ads.zzefv) r15)
            boolean r0 = r13.zziai
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzebs<?> r0 = r13.zzias
            com.google.android.gms.internal.ads.zzebt r0 = r0.zzai(r14)
            com.google.android.gms.internal.ads.zzeel<T, java.lang.Object> r1 = r0.zzhut
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zziad
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzhc(r7)
            int[] r9 = r13.zziad
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.ads.zzebs<?> r10 = r13.zzias
            int r10 = r10.zza(r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.ads.zzebs<?> r10 = r13.zzias
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0043
        L_0x005f:
            r1 = r3
            goto L_0x0043
        L_0x0061:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04fe;
                case 1: goto L_0x04ee;
                case 2: goto L_0x04de;
                case 3: goto L_0x04ce;
                case 4: goto L_0x04be;
                case 5: goto L_0x04ae;
                case 6: goto L_0x049e;
                case 7: goto L_0x048d;
                case 8: goto L_0x047c;
                case 9: goto L_0x0467;
                case 10: goto L_0x0454;
                case 11: goto L_0x0443;
                case 12: goto L_0x0432;
                case 13: goto L_0x0421;
                case 14: goto L_0x0410;
                case 15: goto L_0x03ff;
                case 16: goto L_0x03ee;
                case 17: goto L_0x03d9;
                case 18: goto L_0x03c8;
                case 19: goto L_0x03b7;
                case 20: goto L_0x03a6;
                case 21: goto L_0x0395;
                case 22: goto L_0x0384;
                case 23: goto L_0x0373;
                case 24: goto L_0x0362;
                case 25: goto L_0x0351;
                case 26: goto L_0x0340;
                case 27: goto L_0x032b;
                case 28: goto L_0x031a;
                case 29: goto L_0x0309;
                case 30: goto L_0x02f8;
                case 31: goto L_0x02e7;
                case 32: goto L_0x02d6;
                case 33: goto L_0x02c5;
                case 34: goto L_0x02b4;
                case 35: goto L_0x02a3;
                case 36: goto L_0x0292;
                case 37: goto L_0x0281;
                case 38: goto L_0x0270;
                case 39: goto L_0x025f;
                case 40: goto L_0x024e;
                case 41: goto L_0x023d;
                case 42: goto L_0x022c;
                case 43: goto L_0x021b;
                case 44: goto L_0x020a;
                case 45: goto L_0x01f9;
                case 46: goto L_0x01e8;
                case 47: goto L_0x01d7;
                case 48: goto L_0x01c6;
                case 49: goto L_0x01b1;
                case 50: goto L_0x01a6;
                case 51: goto L_0x0195;
                case 52: goto L_0x0184;
                case 53: goto L_0x0173;
                case 54: goto L_0x0162;
                case 55: goto L_0x0151;
                case 56: goto L_0x0140;
                case 57: goto L_0x012f;
                case 58: goto L_0x011e;
                case 59: goto L_0x010d;
                case 60: goto L_0x00f8;
                case 61: goto L_0x00e5;
                case 62: goto L_0x00d4;
                case 63: goto L_0x00c3;
                case 64: goto L_0x00b2;
                case 65: goto L_0x00a1;
                case 66: goto L_0x0090;
                case 67: goto L_0x007f;
                case 68: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x050d
        L_0x006a:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            com.google.android.gms.internal.ads.zzeek r10 = r13.zzgz(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.ads.zzeek) r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzad(r9, r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzq(r9, r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzal(r9, r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzam(r9, r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzac(r9, r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            com.google.android.gms.internal.ads.zzeaq r8 = (com.google.android.gms.internal.ads.zzeaq) r8
            r15.zza((int) r9, (com.google.android.gms.internal.ads.zzeaq) r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            com.google.android.gms.internal.ads.zzeek r10 = r13.zzgz(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.ads.zzeek) r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.ads.zzefv) r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzj(r14, r10)
            r15.zzh((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzae(r9, r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzab(r9, r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzh((int) r9, (long) r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzp(r9, r10)
            goto L_0x050d
        L_0x0184:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzg(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x0195:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzf(r14, (long) r10)
            r15.zzb((int) r9, (double) r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            r13.zza((com.google.android.gms.internal.ads.zzefv) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeek r10 = r13.zzgz(r7)
            com.google.android.gms.internal.ads.zzeem.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.ads.zzefv) r15, (com.google.android.gms.internal.ads.zzeek) r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.ads.zzefv) r15, (boolean) r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.ads.zzefv) r15, (boolean) r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzb(r9, r8, r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeek r10 = r13.zzgz(r7)
            com.google.android.gms.internal.ads.zzeem.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.ads.zzefv) r15, (com.google.android.gms.internal.ads.zzeek) r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.ads.zzefv) r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.ads.zzefv) r15, (boolean) r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zziad
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeem.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.ads.zzefv) r15, (boolean) r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            com.google.android.gms.internal.ads.zzeek r10 = r13.zzgz(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.ads.zzeek) r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r10)
            r15.zzad(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r10)
            r15.zzq(r9, r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r10)
            r15.zzal(r9, r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r10)
            r15.zzam(r9, r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r10)
            r15.zzac(r9, r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            com.google.android.gms.internal.ads.zzeaq r8 = (com.google.android.gms.internal.ads.zzeaq) r8
            r15.zza((int) r9, (com.google.android.gms.internal.ads.zzeaq) r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            com.google.android.gms.internal.ads.zzeek r10 = r13.zzgz(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.ads.zzeek) r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.ads.zzefv) r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.ads.zzefi.zzm(r14, r10)
            r15.zzh((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r10)
            r15.zzae(r9, r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r10)
            r15.zzab(r9, r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r10)
            r15.zzh((int) r9, (long) r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r10)
            r15.zzp(r9, r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.ads.zzefi.zzn(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zze(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.ads.zzefi.zzo(r14, r10)
            r15.zzb((int) r9, (double) r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.ads.zzebs<?> r14 = r13.zzias
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0526
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x0511
        L_0x0526:
            r1 = r3
            goto L_0x0511
        L_0x0528:
            return
        L_0x0529:
            boolean r0 = r13.zziak
            if (r0 == 0) goto L_0x0a44
            boolean r0 = r13.zziai
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.ads.zzebs<?> r0 = r13.zzias
            com.google.android.gms.internal.ads.zzebt r0 = r0.zzai(r14)
            com.google.android.gms.internal.ads.zzeel<T, java.lang.Object> r1 = r0.zzhut
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x054a
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x054c
        L_0x054a:
            r0 = r3
            r1 = r0
        L_0x054c:
            int[] r7 = r13.zziad
            int r7 = r7.length
            r8 = 0
        L_0x0550:
            if (r8 >= r7) goto L_0x0a28
            int r9 = r13.zzhc(r8)
            int[] r10 = r13.zziad
            r10 = r10[r8]
        L_0x055a:
            if (r1 == 0) goto L_0x0578
            com.google.android.gms.internal.ads.zzebs<?> r11 = r13.zzias
            int r11 = r11.zza(r1)
            if (r11 > r10) goto L_0x0578
            com.google.android.gms.internal.ads.zzebs<?> r11 = r13.zzias
            r11.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0576
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x055a
        L_0x0576:
            r1 = r3
            goto L_0x055a
        L_0x0578:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0a15;
                case 1: goto L_0x0a05;
                case 2: goto L_0x09f5;
                case 3: goto L_0x09e5;
                case 4: goto L_0x09d5;
                case 5: goto L_0x09c5;
                case 6: goto L_0x09b5;
                case 7: goto L_0x09a4;
                case 8: goto L_0x0993;
                case 9: goto L_0x097e;
                case 10: goto L_0x096b;
                case 11: goto L_0x095a;
                case 12: goto L_0x0949;
                case 13: goto L_0x0938;
                case 14: goto L_0x0927;
                case 15: goto L_0x0916;
                case 16: goto L_0x0905;
                case 17: goto L_0x08f0;
                case 18: goto L_0x08df;
                case 19: goto L_0x08ce;
                case 20: goto L_0x08bd;
                case 21: goto L_0x08ac;
                case 22: goto L_0x089b;
                case 23: goto L_0x088a;
                case 24: goto L_0x0879;
                case 25: goto L_0x0868;
                case 26: goto L_0x0857;
                case 27: goto L_0x0842;
                case 28: goto L_0x0831;
                case 29: goto L_0x0820;
                case 30: goto L_0x080f;
                case 31: goto L_0x07fe;
                case 32: goto L_0x07ed;
                case 33: goto L_0x07dc;
                case 34: goto L_0x07cb;
                case 35: goto L_0x07ba;
                case 36: goto L_0x07a9;
                case 37: goto L_0x0798;
                case 38: goto L_0x0787;
                case 39: goto L_0x0776;
                case 40: goto L_0x0765;
                case 41: goto L_0x0754;
                case 42: goto L_0x0743;
                case 43: goto L_0x0732;
                case 44: goto L_0x0721;
                case 45: goto L_0x0710;
                case 46: goto L_0x06ff;
                case 47: goto L_0x06ee;
                case 48: goto L_0x06dd;
                case 49: goto L_0x06c8;
                case 50: goto L_0x06bd;
                case 51: goto L_0x06ac;
                case 52: goto L_0x069b;
                case 53: goto L_0x068a;
                case 54: goto L_0x0679;
                case 55: goto L_0x0668;
                case 56: goto L_0x0657;
                case 57: goto L_0x0646;
                case 58: goto L_0x0635;
                case 59: goto L_0x0624;
                case 60: goto L_0x060f;
                case 61: goto L_0x05fc;
                case 62: goto L_0x05eb;
                case 63: goto L_0x05da;
                case 64: goto L_0x05c9;
                case 65: goto L_0x05b8;
                case 66: goto L_0x05a7;
                case 67: goto L_0x0596;
                case 68: goto L_0x0581;
                default: goto L_0x057f;
            }
        L_0x057f:
            goto L_0x0a24
        L_0x0581:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            com.google.android.gms.internal.ads.zzeek r11 = r13.zzgz(r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.ads.zzeek) r11)
            goto L_0x0a24
        L_0x0596:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a24
        L_0x05a7:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzad(r10, r9)
            goto L_0x0a24
        L_0x05b8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzq(r10, r11)
            goto L_0x0a24
        L_0x05c9:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzal(r10, r9)
            goto L_0x0a24
        L_0x05da:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzam(r10, r9)
            goto L_0x0a24
        L_0x05eb:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzac(r10, r9)
            goto L_0x0a24
        L_0x05fc:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            com.google.android.gms.internal.ads.zzeaq r9 = (com.google.android.gms.internal.ads.zzeaq) r9
            r15.zza((int) r10, (com.google.android.gms.internal.ads.zzeaq) r9)
            goto L_0x0a24
        L_0x060f:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            com.google.android.gms.internal.ads.zzeek r11 = r13.zzgz(r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.ads.zzeek) r11)
            goto L_0x0a24
        L_0x0624:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.ads.zzefv) r15)
            goto L_0x0a24
        L_0x0635:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzj(r14, r11)
            r15.zzh((int) r10, (boolean) r9)
            goto L_0x0a24
        L_0x0646:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzae(r10, r9)
            goto L_0x0a24
        L_0x0657:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x0668:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzab(r10, r9)
            goto L_0x0a24
        L_0x0679:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzh((int) r10, (long) r11)
            goto L_0x0a24
        L_0x068a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzp(r10, r11)
            goto L_0x0a24
        L_0x069b:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzg(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a24
        L_0x06ac:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzf(r14, (long) r11)
            r15.zzb((int) r10, (double) r11)
            goto L_0x0a24
        L_0x06bd:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            r13.zza((com.google.android.gms.internal.ads.zzefv) r15, (int) r10, (java.lang.Object) r9, (int) r8)
            goto L_0x0a24
        L_0x06c8:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeek r11 = r13.zzgz(r8)
            com.google.android.gms.internal.ads.zzeem.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.ads.zzefv) r15, (com.google.android.gms.internal.ads.zzeek) r11)
            goto L_0x0a24
        L_0x06dd:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zze(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ee:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzj(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ff:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzg(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0710:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzl(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0721:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzm(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0732:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzi(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0743:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzn(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0754:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzk(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0765:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzf(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0776:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzh(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0787:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzd(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0798:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzc(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07a9:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.ads.zzefv) r15, (boolean) r4)
            goto L_0x0a24
        L_0x07ba:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.ads.zzefv) r15, (boolean) r4)
            goto L_0x0a24
        L_0x07cb:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zze(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07dc:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzj(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07ed:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzg(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07fe:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzl(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x080f:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzm(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0820:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzi(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0831:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzb(r10, r9, r15)
            goto L_0x0a24
        L_0x0842:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeek r11 = r13.zzgz(r8)
            com.google.android.gms.internal.ads.zzeem.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.ads.zzefv) r15, (com.google.android.gms.internal.ads.zzeek) r11)
            goto L_0x0a24
        L_0x0857:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.ads.zzefv) r15)
            goto L_0x0a24
        L_0x0868:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzn(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0879:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzk(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x088a:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzf(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x089b:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzh(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ac:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzd(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08bd:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzc(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ce:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.ads.zzefv) r15, (boolean) r5)
            goto L_0x0a24
        L_0x08df:
            int[] r10 = r13.zziad
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeem.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.ads.zzefv) r15, (boolean) r5)
            goto L_0x0a24
        L_0x08f0:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            com.google.android.gms.internal.ads.zzeek r11 = r13.zzgz(r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.ads.zzeek) r11)
            goto L_0x0a24
        L_0x0905:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a24
        L_0x0916:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r11)
            r15.zzad(r10, r9)
            goto L_0x0a24
        L_0x0927:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r11)
            r15.zzq(r10, r11)
            goto L_0x0a24
        L_0x0938:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r11)
            r15.zzal(r10, r9)
            goto L_0x0a24
        L_0x0949:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r11)
            r15.zzam(r10, r9)
            goto L_0x0a24
        L_0x095a:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r11)
            r15.zzac(r10, r9)
            goto L_0x0a24
        L_0x096b:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            com.google.android.gms.internal.ads.zzeaq r9 = (com.google.android.gms.internal.ads.zzeaq) r9
            r15.zza((int) r10, (com.google.android.gms.internal.ads.zzeaq) r9)
            goto L_0x0a24
        L_0x097e:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            com.google.android.gms.internal.ads.zzeek r11 = r13.zzgz(r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.ads.zzeek) r11)
            goto L_0x0a24
        L_0x0993:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzefi.zzp(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.ads.zzefv) r15)
            goto L_0x0a24
        L_0x09a4:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.ads.zzefi.zzm(r14, r11)
            r15.zzh((int) r10, (boolean) r9)
            goto L_0x0a24
        L_0x09b5:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r11)
            r15.zzae(r10, r9)
            goto L_0x0a24
        L_0x09c5:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x09d5:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzefi.zzk(r14, r11)
            r15.zzab(r10, r9)
            goto L_0x0a24
        L_0x09e5:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r11)
            r15.zzh((int) r10, (long) r11)
            goto L_0x0a24
        L_0x09f5:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.ads.zzefi.zzl(r14, r11)
            r15.zzp(r10, r11)
            goto L_0x0a24
        L_0x0a05:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.ads.zzefi.zzn(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a24
        L_0x0a15:
            boolean r11 = r13.zze(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.ads.zzefi.zzo(r14, r11)
            r15.zzb((int) r10, (double) r11)
        L_0x0a24:
            int r8 = r8 + 3
            goto L_0x0550
        L_0x0a28:
            if (r1 == 0) goto L_0x0a3e
            com.google.android.gms.internal.ads.zzebs<?> r2 = r13.zzias
            r2.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a3c
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0a28
        L_0x0a3c:
            r1 = r3
            goto L_0x0a28
        L_0x0a3e:
            com.google.android.gms.internal.ads.zzefc<?, ?> r0 = r13.zziar
            zza(r0, r14, (com.google.android.gms.internal.ads.zzefv) r15)
            return
        L_0x0a44:
            r13.zzb(r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zza(java.lang.Object, com.google.android.gms.internal.ads.zzefv):void");
    }

    private final void zzb(T t, int i, int i2) {
        zzefi.zzb((Object) t, (long) (zzhd(i2) & 1048575), i);
    }

    private final <K, V> void zza(zzefv zzefv, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzefv.zza(i, this.zziat.zzas(zzha(i2)), this.zziat.zzao(obj));
        }
    }

    private static <UT, UB> void zza(zzefc<UT, UB> zzefc, T t, zzefv zzefv) throws IOException {
        zzefc.zza(zzefc.zzay(t), zzefv);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:149|150|(1:152)|153|(5:174|155|(2:158|156)|256|(2:160|264)(1:265))(1:252)) */
    /* JADX WARNING: Code restructure failed: missing block: B:150:?, code lost:
        r8.zza(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x05a0, code lost:
        if (r10 == null) goto L_0x05a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x05a2, code lost:
        r10 = r8.zzaz(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x05ab, code lost:
        if (r8.zza(r10, r14) == false) goto L_0x05ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x05ad, code lost:
        r14 = r12.zzian;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x05b1, code lost:
        if (r14 < r12.zziao) goto L_0x05b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x05b3, code lost:
        r10 = zza((java.lang.Object) r13, r12.zziam[r14], r10, r8);
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x05be, code lost:
        if (r10 != null) goto L_0x05c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x05c0, code lost:
        r8.zzi(r13, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:149:0x059d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r13, com.google.android.gms.internal.ads.zzeee r14, com.google.android.gms.internal.ads.zzebq r15) throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            if (r15 == 0) goto L_0x05dc
            com.google.android.gms.internal.ads.zzefc<?, ?> r8 = r12.zziar
            com.google.android.gms.internal.ads.zzebs<?> r9 = r12.zzias
            r1 = r0
            r10 = r1
        L_0x0009:
            int r2 = r14.zzbdw()     // Catch:{ all -> 0x05c4 }
            int r3 = r12.zzhf(r2)     // Catch:{ all -> 0x05c4 }
            if (r3 >= 0) goto L_0x0077
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x002f
            int r14 = r12.zzian
        L_0x001a:
            int r15 = r12.zziao
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zziam
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x001a
        L_0x0029:
            if (r10 == 0) goto L_0x002e
            r8.zzi(r13, r10)
        L_0x002e:
            return
        L_0x002f:
            boolean r3 = r12.zziai     // Catch:{ all -> 0x05c4 }
            if (r3 != 0) goto L_0x0035
            r3 = r0
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.ads.zzedo r3 = r12.zziah     // Catch:{ all -> 0x05c4 }
            java.lang.Object r2 = r9.zza(r15, r3, r2)     // Catch:{ all -> 0x05c4 }
            r3 = r2
        L_0x003c:
            if (r3 == 0) goto L_0x0051
            if (r1 != 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzebt r1 = r9.zzaj(r13)     // Catch:{ all -> 0x05c4 }
        L_0x0044:
            r11 = r1
            r1 = r9
            r2 = r14
            r4 = r15
            r5 = r11
            r6 = r10
            r7 = r8
            java.lang.Object r10 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x05c4 }
            r1 = r11
            goto L_0x0009
        L_0x0051:
            r8.zza(r14)     // Catch:{ all -> 0x05c4 }
            if (r10 != 0) goto L_0x005a
            java.lang.Object r10 = r8.zzaz(r13)     // Catch:{ all -> 0x05c4 }
        L_0x005a:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.ads.zzeee) r14)     // Catch:{ all -> 0x05c4 }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzian
        L_0x0062:
            int r15 = r12.zziao
            if (r14 >= r15) goto L_0x0071
            int[] r15 = r12.zziam
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0062
        L_0x0071:
            if (r10 == 0) goto L_0x0076
            r8.zzi(r13, r10)
        L_0x0076:
            return
        L_0x0077:
            int r4 = r12.zzhc(r3)     // Catch:{ all -> 0x05c4 }
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r5 = r5 & r4
            int r5 = r5 >>> 20
            r6 = 1048575(0xfffff, float:1.469367E-39)
            switch(r5) {
                case 0: goto L_0x0571;
                case 1: goto L_0x0562;
                case 2: goto L_0x0553;
                case 3: goto L_0x0544;
                case 4: goto L_0x0535;
                case 5: goto L_0x0526;
                case 6: goto L_0x0517;
                case 7: goto L_0x0508;
                case 8: goto L_0x0500;
                case 9: goto L_0x04cf;
                case 10: goto L_0x04c0;
                case 11: goto L_0x04b1;
                case 12: goto L_0x048f;
                case 13: goto L_0x0480;
                case 14: goto L_0x0471;
                case 15: goto L_0x0462;
                case 16: goto L_0x0453;
                case 17: goto L_0x0422;
                case 18: goto L_0x0414;
                case 19: goto L_0x0406;
                case 20: goto L_0x03f8;
                case 21: goto L_0x03ea;
                case 22: goto L_0x03dc;
                case 23: goto L_0x03ce;
                case 24: goto L_0x03c0;
                case 25: goto L_0x03b2;
                case 26: goto L_0x0390;
                case 27: goto L_0x037e;
                case 28: goto L_0x0370;
                case 29: goto L_0x0362;
                case 30: goto L_0x034d;
                case 31: goto L_0x033f;
                case 32: goto L_0x0331;
                case 33: goto L_0x0323;
                case 34: goto L_0x0315;
                case 35: goto L_0x0307;
                case 36: goto L_0x02f9;
                case 37: goto L_0x02eb;
                case 38: goto L_0x02dd;
                case 39: goto L_0x02cf;
                case 40: goto L_0x02c1;
                case 41: goto L_0x02b3;
                case 42: goto L_0x02a5;
                case 43: goto L_0x0297;
                case 44: goto L_0x0282;
                case 45: goto L_0x0274;
                case 46: goto L_0x0266;
                case 47: goto L_0x0258;
                case 48: goto L_0x024a;
                case 49: goto L_0x0238;
                case 50: goto L_0x01f6;
                case 51: goto L_0x01e4;
                case 52: goto L_0x01d2;
                case 53: goto L_0x01c0;
                case 54: goto L_0x01ae;
                case 55: goto L_0x019c;
                case 56: goto L_0x018a;
                case 57: goto L_0x0178;
                case 58: goto L_0x0166;
                case 59: goto L_0x015e;
                case 60: goto L_0x012d;
                case 61: goto L_0x011f;
                case 62: goto L_0x010d;
                case 63: goto L_0x00e8;
                case 64: goto L_0x00d6;
                case 65: goto L_0x00c4;
                case 66: goto L_0x00b2;
                case 67: goto L_0x00a0;
                case 68: goto L_0x008e;
                default: goto L_0x0086;
            }
        L_0x0086:
            if (r10 != 0) goto L_0x0580
            java.lang.Object r10 = r8.zzbhg()     // Catch:{ zzecn -> 0x059d }
            goto L_0x0580
        L_0x008e:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzeek r6 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r6 = r14.zzb(r6, r15)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x00a0:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            long r6 = r14.zzbdm()     // Catch:{ zzecn -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x00b2:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            int r6 = r14.zzbdl()     // Catch:{ zzecn -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x00c4:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            long r6 = r14.zzbdk()     // Catch:{ zzecn -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x00d6:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            int r6 = r14.zzbdj()     // Catch:{ zzecn -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x00e8:
            int r5 = r14.zzbdi()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzech r7 = r12.zzhb(r3)     // Catch:{ zzecn -> 0x059d }
            if (r7 == 0) goto L_0x00ff
            boolean r7 = r7.zzf(r5)     // Catch:{ zzecn -> 0x059d }
            if (r7 == 0) goto L_0x00f9
            goto L_0x00ff
        L_0x00f9:
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzeem.zza((int) r2, (int) r5, r10, r8)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x00ff:
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzecn -> 0x059d }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r6, (java.lang.Object) r4)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x010d:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            int r6 = r14.zzbdh()     // Catch:{ zzecn -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x011f:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzeaq r6 = r14.zzbdg()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x012d:
            boolean r5 = r12.zza(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            if (r5 == 0) goto L_0x0149
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r6 = com.google.android.gms.internal.ads.zzefi.zzp(r13, r4)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzeek r7 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r7 = r14.zza(r7, r15)     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r6 = com.google.android.gms.internal.ads.zzecg.zzd(r6, r7)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0159
        L_0x0149:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzeek r6 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r6 = r14.zza(r6, r15)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
        L_0x0159:
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x015e:
            r12.zza((java.lang.Object) r13, (int) r4, (com.google.android.gms.internal.ads.zzeee) r14)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0166:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            boolean r6 = r14.zzbde()     // Catch:{ zzecn -> 0x059d }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0178:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            int r6 = r14.zzbdd()     // Catch:{ zzecn -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x018a:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            long r6 = r14.zzbdc()     // Catch:{ zzecn -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x019c:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            int r6 = r14.zzbdb()     // Catch:{ zzecn -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x01ae:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            long r6 = r14.zzbcz()     // Catch:{ zzecn -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x01c0:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            long r6 = r14.zzbda()     // Catch:{ zzecn -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x01d2:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            float r6 = r14.readFloat()     // Catch:{ zzecn -> 0x059d }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x01e4:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzecn -> 0x059d }
            double r6 = r14.readDouble()     // Catch:{ zzecn -> 0x059d }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzb(r13, (int) r2, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x01f6:
            java.lang.Object r2 = r12.zzha(r3)     // Catch:{ zzecn -> 0x059d }
            int r3 = r12.zzhc(r3)     // Catch:{ zzecn -> 0x059d }
            r3 = r3 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzefi.zzp(r13, r3)     // Catch:{ zzecn -> 0x059d }
            if (r5 != 0) goto L_0x0210
            com.google.android.gms.internal.ads.zzedh r5 = r12.zziat     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r5 = r5.zzar(r2)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0227
        L_0x0210:
            com.google.android.gms.internal.ads.zzedh r6 = r12.zziat     // Catch:{ zzecn -> 0x059d }
            boolean r6 = r6.zzap(r5)     // Catch:{ zzecn -> 0x059d }
            if (r6 == 0) goto L_0x0227
            com.google.android.gms.internal.ads.zzedh r6 = r12.zziat     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r6 = r6.zzar(r2)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzedh r7 = r12.zziat     // Catch:{ zzecn -> 0x059d }
            r7.zze(r6, r5)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r6)     // Catch:{ zzecn -> 0x059d }
            r5 = r6
        L_0x0227:
            com.google.android.gms.internal.ads.zzedh r3 = r12.zziat     // Catch:{ zzecn -> 0x059d }
            java.util.Map r3 = r3.zzan(r5)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzedh r4 = r12.zziat     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzedf r2 = r4.zzas(r2)     // Catch:{ zzecn -> 0x059d }
            r14.zza(r3, r2, (com.google.android.gms.internal.ads.zzebq) r15)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0238:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzeek r2 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzecy r3 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            java.util.List r3 = r3.zza(r13, r4)     // Catch:{ zzecn -> 0x059d }
            r14.zzb(r3, r2, r15)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x024a:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzy(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0258:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzx(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0266:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzw(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0274:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzv(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0282:
            com.google.android.gms.internal.ads.zzecy r5 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzecn -> 0x059d }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzecn -> 0x059d }
            r14.zzu(r4)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzech r3 = r12.zzhb(r3)     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzeem.zza(r2, r4, r3, r10, r8)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0297:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzt(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x02a5:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzq(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x02b3:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzp(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x02c1:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzo(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x02cf:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzn(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x02dd:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzl(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x02eb:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzm(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x02f9:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzk(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0307:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzj(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0315:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzy(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0323:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzx(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0331:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzw(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x033f:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzv(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x034d:
            com.google.android.gms.internal.ads.zzecy r5 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzecn -> 0x059d }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzecn -> 0x059d }
            r14.zzu(r4)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzech r3 = r12.zzhb(r3)     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzeem.zza(r2, r4, r3, r10, r8)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0362:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzt(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0370:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzs(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x037e:
            com.google.android.gms.internal.ads.zzeek r2 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzecy r5 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            java.util.List r3 = r5.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zza(r3, r2, (com.google.android.gms.internal.ads.zzebq) r15)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0390:
            boolean r2 = zzhe(r4)     // Catch:{ zzecn -> 0x059d }
            if (r2 == 0) goto L_0x03a4
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzr(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x03a4:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.readStringList(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x03b2:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzq(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x03c0:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzp(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x03ce:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzo(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x03dc:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzn(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x03ea:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzl(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x03f8:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzm(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0406:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzk(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0414:
            com.google.android.gms.internal.ads.zzecy r2 = r12.zziaq     // Catch:{ zzecn -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzecn -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzecn -> 0x059d }
            r14.zzj(r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0422:
            boolean r2 = r12.zze(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            if (r2 == 0) goto L_0x0440
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzefi.zzp(r13, r4)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzeek r3 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r3 = r14.zzb(r3, r15)     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzecg.zzd(r2, r3)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0440:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzeek r2 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r2 = r14.zzb(r2, r15)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0453:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            long r6 = r14.zzbdm()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0462:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            int r2 = r14.zzbdl()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zzb((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0471:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            long r6 = r14.zzbdk()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0480:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            int r2 = r14.zzbdj()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zzb((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x048f:
            int r5 = r14.zzbdi()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzech r7 = r12.zzhb(r3)     // Catch:{ zzecn -> 0x059d }
            if (r7 == 0) goto L_0x04a6
            boolean r7 = r7.zzf(r5)     // Catch:{ zzecn -> 0x059d }
            if (r7 == 0) goto L_0x04a0
            goto L_0x04a6
        L_0x04a0:
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzeem.zza((int) r2, (int) r5, r10, r8)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x04a6:
            r2 = r4 & r6
            long r6 = (long) r2     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zzb((java.lang.Object) r13, (long) r6, (int) r5)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x04b1:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            int r2 = r14.zzbdh()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zzb((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x04c0:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzeaq r2 = r14.zzbdg()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x04cf:
            boolean r2 = r12.zze(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            if (r2 == 0) goto L_0x04ed
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzefi.zzp(r13, r4)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzeek r3 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r3 = r14.zza(r3, r15)     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzecg.zzd(r2, r3)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x04ed:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzeek r2 = r12.zzgz(r3)     // Catch:{ zzecn -> 0x059d }
            java.lang.Object r2 = r14.zza(r2, r15)     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (java.lang.Object) r2)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0500:
            r12.zza((java.lang.Object) r13, (int) r4, (com.google.android.gms.internal.ads.zzeee) r14)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0508:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            boolean r2 = r14.zzbde()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (boolean) r2)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0517:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            int r2 = r14.zzbdd()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zzb((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0526:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            long r6 = r14.zzbdc()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0535:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            int r2 = r14.zzbdb()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zzb((java.lang.Object) r13, (long) r4, (int) r2)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0544:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            long r6 = r14.zzbcz()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0553:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            long r6 = r14.zzbda()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (long) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0562:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            float r2 = r14.readFloat()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (float) r2)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0571:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzecn -> 0x059d }
            double r6 = r14.readDouble()     // Catch:{ zzecn -> 0x059d }
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r13, (long) r4, (double) r6)     // Catch:{ zzecn -> 0x059d }
            r12.zzf(r13, (int) r3)     // Catch:{ zzecn -> 0x059d }
            goto L_0x0009
        L_0x0580:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.ads.zzeee) r14)     // Catch:{ zzecn -> 0x059d }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzian
        L_0x0588:
            int r15 = r12.zziao
            if (r14 >= r15) goto L_0x0597
            int[] r15 = r12.zziam
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0588
        L_0x0597:
            if (r10 == 0) goto L_0x059c
            r8.zzi(r13, r10)
        L_0x059c:
            return
        L_0x059d:
            r8.zza(r14)     // Catch:{ all -> 0x05c4 }
            if (r10 != 0) goto L_0x05a7
            java.lang.Object r2 = r8.zzaz(r13)     // Catch:{ all -> 0x05c4 }
            r10 = r2
        L_0x05a7:
            boolean r2 = r8.zza(r10, (com.google.android.gms.internal.ads.zzeee) r14)     // Catch:{ all -> 0x05c4 }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzian
        L_0x05af:
            int r15 = r12.zziao
            if (r14 >= r15) goto L_0x05be
            int[] r15 = r12.zziam
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x05af
        L_0x05be:
            if (r10 == 0) goto L_0x05c3
            r8.zzi(r13, r10)
        L_0x05c3:
            return
        L_0x05c4:
            r14 = move-exception
            int r15 = r12.zzian
        L_0x05c7:
            int r0 = r12.zziao
            if (r15 >= r0) goto L_0x05d6
            int[] r0 = r12.zziam
            r0 = r0[r15]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r0, r10, r8)
            int r15 = r15 + 1
            goto L_0x05c7
        L_0x05d6:
            if (r10 == 0) goto L_0x05db
            r8.zzi(r13, r10)
        L_0x05db:
            throw r14
        L_0x05dc:
            goto L_0x05de
        L_0x05dd:
            throw r0
        L_0x05de:
            goto L_0x05dd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zza(java.lang.Object, com.google.android.gms.internal.ads.zzeee, com.google.android.gms.internal.ads.zzebq):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r2 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(byte[] r1, int r2, int r3, com.google.android.gms.internal.ads.zzefp r4, java.lang.Class<?> r5, com.google.android.gms.internal.ads.zzeap r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.ads.zzedr.zzhuk
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0094;
                case 3: goto L_0x0087;
                case 4: goto L_0x007a;
                case 5: goto L_0x007a;
                case 6: goto L_0x006f;
                case 7: goto L_0x006f;
                case 8: goto L_0x0064;
                case 9: goto L_0x0057;
                case 10: goto L_0x0057;
                case 11: goto L_0x0057;
                case 12: goto L_0x004a;
                case 13: goto L_0x004a;
                case 14: goto L_0x003d;
                case 15: goto L_0x002b;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unsupported field type."
            r1.<init>(r2)
            throw r1
        L_0x0013:
            int r1 = com.google.android.gms.internal.ads.zzeam.zzd(r1, r2, r6)
            goto L_0x00ae
        L_0x0019:
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r1, r2, r6)
            long r2 = r6.zzhtc
            long r2 = com.google.android.gms.internal.ads.zzebf.zzfh(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzhtd = r2
            goto L_0x00ae
        L_0x002b:
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r1, r2, r6)
            int r2 = r6.zzhtb
            int r2 = com.google.android.gms.internal.ads.zzebf.zzfw(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzhtd = r2
            goto L_0x00ae
        L_0x003d:
            com.google.android.gms.internal.ads.zzedz r4 = com.google.android.gms.internal.ads.zzedz.zzbgk()
            com.google.android.gms.internal.ads.zzeek r4 = r4.zzh(r5)
            int r1 = com.google.android.gms.internal.ads.zzeam.zza((com.google.android.gms.internal.ads.zzeek) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.ads.zzeap) r6)
            goto L_0x00ae
        L_0x004a:
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r1, r2, r6)
            long r2 = r6.zzhtc
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzhtd = r2
            goto L_0x00ae
        L_0x0057:
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r1, r2, r6)
            int r2 = r6.zzhtb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzhtd = r2
            goto L_0x00ae
        L_0x0064:
            float r1 = com.google.android.gms.internal.ads.zzeam.zzi(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r6.zzhtd = r1
            goto L_0x0084
        L_0x006f:
            long r3 = com.google.android.gms.internal.ads.zzeam.zzg(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r6.zzhtd = r1
            goto L_0x0091
        L_0x007a:
            int r1 = com.google.android.gms.internal.ads.zzeam.zzf(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.zzhtd = r1
        L_0x0084:
            int r1 = r2 + 4
            goto L_0x00ae
        L_0x0087:
            double r3 = com.google.android.gms.internal.ads.zzeam.zzh(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r6.zzhtd = r1
        L_0x0091:
            int r1 = r2 + 8
            goto L_0x00ae
        L_0x0094:
            int r1 = com.google.android.gms.internal.ads.zzeam.zze(r1, r2, r6)
            goto L_0x00ae
        L_0x0099:
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r1, r2, r6)
            long r2 = r6.zzhtc
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6.zzhtd = r2
        L_0x00ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zza(byte[], int, int, com.google.android.gms.internal.ads.zzefp, java.lang.Class, com.google.android.gms.internal.ads.zzeap):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0422 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01eb  */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.ads.zzeap r30) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r6 = r23
            r8 = r24
            r9 = r28
            r7 = r30
            sun.misc.Unsafe r11 = zzhgt
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzecl r11 = (com.google.android.gms.internal.ads.zzecl) r11
            boolean r12 = r11.zzbci()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.ads.zzecl r11 = r11.zzfn(r12)
            sun.misc.Unsafe r12 = zzhgt
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x03e4;
                case 19: goto L_0x03a6;
                case 20: goto L_0x0365;
                case 21: goto L_0x0365;
                case 22: goto L_0x034b;
                case 23: goto L_0x030c;
                case 24: goto L_0x02cd;
                case 25: goto L_0x0276;
                case 26: goto L_0x01c3;
                case 27: goto L_0x01a9;
                case 28: goto L_0x0151;
                case 29: goto L_0x034b;
                case 30: goto L_0x0119;
                case 31: goto L_0x02cd;
                case 32: goto L_0x030c;
                case 33: goto L_0x00cc;
                case 34: goto L_0x007f;
                case 35: goto L_0x03e4;
                case 36: goto L_0x03a6;
                case 37: goto L_0x0365;
                case 38: goto L_0x0365;
                case 39: goto L_0x034b;
                case 40: goto L_0x030c;
                case 41: goto L_0x02cd;
                case 42: goto L_0x0276;
                case 43: goto L_0x034b;
                case 44: goto L_0x0119;
                case 45: goto L_0x02cd;
                case 46: goto L_0x030c;
                case 47: goto L_0x00cc;
                case 48: goto L_0x007f;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0422
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x0422
            com.google.android.gms.internal.ads.zzeek r1 = r0.zzgz(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.ads.zzeam.zza((com.google.android.gms.internal.ads.zzeek) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.ads.zzeap) r27)
            java.lang.Object r8 = r7.zzhtd
            r11.add(r8)
        L_0x005f:
            if (r4 >= r5) goto L_0x0422
            int r8 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r9 = r7.zzhtb
            if (r2 != r9) goto L_0x0422
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.ads.zzeam.zza((com.google.android.gms.internal.ads.zzeek) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.ads.zzeap) r27)
            java.lang.Object r8 = r7.zzhtd
            r11.add(r8)
            goto L_0x005f
        L_0x007f:
            if (r6 != r10) goto L_0x00a3
            com.google.android.gms.internal.ads.zzedc r11 = (com.google.android.gms.internal.ads.zzedc) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r2 = r7.zzhtb
            int r2 = r2 + r1
        L_0x008a:
            if (r1 >= r2) goto L_0x009a
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r1, r7)
            long r4 = r7.zzhtc
            long r4 = com.google.android.gms.internal.ads.zzebf.zzfh(r4)
            r11.zzfs(r4)
            goto L_0x008a
        L_0x009a:
            if (r1 != r2) goto L_0x009e
            goto L_0x0423
        L_0x009e:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x00a3:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.ads.zzedc r11 = (com.google.android.gms.internal.ads.zzedc) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r4, r7)
            long r8 = r7.zzhtc
            long r8 = com.google.android.gms.internal.ads.zzebf.zzfh(r8)
            r11.zzfs(r8)
        L_0x00b4:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r6 = r7.zzhtb
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r4, r7)
            long r8 = r7.zzhtc
            long r8 = com.google.android.gms.internal.ads.zzebf.zzfh(r8)
            r11.zzfs(r8)
            goto L_0x00b4
        L_0x00cc:
            if (r6 != r10) goto L_0x00f0
            com.google.android.gms.internal.ads.zzece r11 = (com.google.android.gms.internal.ads.zzece) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r2 = r7.zzhtb
            int r2 = r2 + r1
        L_0x00d7:
            if (r1 >= r2) goto L_0x00e7
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r4 = r7.zzhtb
            int r4 = com.google.android.gms.internal.ads.zzebf.zzfw(r4)
            r11.zzgw(r4)
            goto L_0x00d7
        L_0x00e7:
            if (r1 != r2) goto L_0x00eb
            goto L_0x0423
        L_0x00eb:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x00f0:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.ads.zzece r11 = (com.google.android.gms.internal.ads.zzece) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r4 = r7.zzhtb
            int r4 = com.google.android.gms.internal.ads.zzebf.zzfw(r4)
            r11.zzgw(r4)
        L_0x0101:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r6 = r7.zzhtb
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r4 = r7.zzhtb
            int r4 = com.google.android.gms.internal.ads.zzebf.zzfw(r4)
            r11.zzgw(r4)
            goto L_0x0101
        L_0x0119:
            if (r6 != r10) goto L_0x0120
            int r2 = com.google.android.gms.internal.ads.zzeam.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.ads.zzecl<?>) r11, (com.google.android.gms.internal.ads.zzeap) r7)
            goto L_0x0131
        L_0x0120:
            if (r6 != 0) goto L_0x0422
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.ads.zzeam.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.ads.zzecl<?>) r6, (com.google.android.gms.internal.ads.zzeap) r7)
        L_0x0131:
            com.google.android.gms.internal.ads.zzecd r1 = (com.google.android.gms.internal.ads.zzecd) r1
            com.google.android.gms.internal.ads.zzefb r3 = r1.zzhxv
            com.google.android.gms.internal.ads.zzefb r4 = com.google.android.gms.internal.ads.zzefb.zzbhd()
            if (r3 != r4) goto L_0x013c
            r3 = 0
        L_0x013c:
            com.google.android.gms.internal.ads.zzech r4 = r0.zzhb(r8)
            com.google.android.gms.internal.ads.zzefc<?, ?> r5 = r0.zziar
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzeem.zza(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.ads.zzefb r3 = (com.google.android.gms.internal.ads.zzefb) r3
            if (r3 == 0) goto L_0x014e
            r1.zzhxv = r3
        L_0x014e:
            r1 = r2
            goto L_0x0423
        L_0x0151:
            if (r6 != r10) goto L_0x0422
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r4 = r7.zzhtb
            if (r4 < 0) goto L_0x01a4
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x019f
            if (r4 != 0) goto L_0x0167
            com.google.android.gms.internal.ads.zzeaq r4 = com.google.android.gms.internal.ads.zzeaq.zzhtf
            r11.add(r4)
            goto L_0x016f
        L_0x0167:
            com.google.android.gms.internal.ads.zzeaq r6 = com.google.android.gms.internal.ads.zzeaq.zzh((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
        L_0x016e:
            int r1 = r1 + r4
        L_0x016f:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r6 = r7.zzhtb
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r4 = r7.zzhtb
            if (r4 < 0) goto L_0x019a
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0195
            if (r4 != 0) goto L_0x018d
            com.google.android.gms.internal.ads.zzeaq r4 = com.google.android.gms.internal.ads.zzeaq.zzhtf
            r11.add(r4)
            goto L_0x016f
        L_0x018d:
            com.google.android.gms.internal.ads.zzeaq r6 = com.google.android.gms.internal.ads.zzeaq.zzh((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
            goto L_0x016e
        L_0x0195:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x019a:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfh()
            throw r1
        L_0x019f:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x01a4:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfh()
            throw r1
        L_0x01a9:
            if (r6 != r10) goto L_0x0422
            com.google.android.gms.internal.ads.zzeek r1 = r0.zzgz(r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x0423
        L_0x01c3:
            if (r6 != r10) goto L_0x0422
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 != 0) goto L_0x0216
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r6 = r7.zzhtb
            if (r6 < 0) goto L_0x0211
            if (r6 != 0) goto L_0x01de
            r11.add(r1)
            goto L_0x01e9
        L_0x01de:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzecg.UTF_8
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
        L_0x01e8:
            int r4 = r4 + r6
        L_0x01e9:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r8 = r7.zzhtb
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r6, r7)
            int r6 = r7.zzhtb
            if (r6 < 0) goto L_0x020c
            if (r6 != 0) goto L_0x0201
            r11.add(r1)
            goto L_0x01e9
        L_0x0201:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzecg.UTF_8
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
            goto L_0x01e8
        L_0x020c:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfh()
            throw r1
        L_0x0211:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfh()
            throw r1
        L_0x0216:
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r6 = r7.zzhtb
            if (r6 < 0) goto L_0x0271
            if (r6 != 0) goto L_0x0224
            r11.add(r1)
            goto L_0x0237
        L_0x0224:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.ads.zzefk.zzm(r3, r4, r8)
            if (r9 == 0) goto L_0x026c
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzecg.UTF_8
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
        L_0x0236:
            r4 = r8
        L_0x0237:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r8 = r7.zzhtb
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r6, r7)
            int r6 = r7.zzhtb
            if (r6 < 0) goto L_0x0267
            if (r6 != 0) goto L_0x024f
            r11.add(r1)
            goto L_0x0237
        L_0x024f:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.ads.zzefk.zzm(r3, r4, r8)
            if (r9 == 0) goto L_0x0262
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzecg.UTF_8
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
            goto L_0x0236
        L_0x0262:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfo()
            throw r1
        L_0x0267:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfh()
            throw r1
        L_0x026c:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfo()
            throw r1
        L_0x0271:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfh()
            throw r1
        L_0x0276:
            r1 = 0
            if (r6 != r10) goto L_0x029e
            com.google.android.gms.internal.ads.zzeao r11 = (com.google.android.gms.internal.ads.zzeao) r11
            int r2 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r4 = r7.zzhtb
            int r4 = r4 + r2
        L_0x0282:
            if (r2 >= r4) goto L_0x0295
            int r2 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r2, r7)
            long r5 = r7.zzhtc
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x0290
            r5 = 1
            goto L_0x0291
        L_0x0290:
            r5 = 0
        L_0x0291:
            r11.addBoolean(r5)
            goto L_0x0282
        L_0x0295:
            if (r2 != r4) goto L_0x0299
            goto L_0x014e
        L_0x0299:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x029e:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.ads.zzeao r11 = (com.google.android.gms.internal.ads.zzeao) r11
            int r4 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r4, r7)
            long r8 = r7.zzhtc
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = 1
            goto L_0x02af
        L_0x02ae:
            r6 = 0
        L_0x02af:
            r11.addBoolean(r6)
        L_0x02b2:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r8 = r7.zzhtb
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r6, r7)
            long r8 = r7.zzhtc
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02c8
            r6 = 1
            goto L_0x02c9
        L_0x02c8:
            r6 = 0
        L_0x02c9:
            r11.addBoolean(r6)
            goto L_0x02b2
        L_0x02cd:
            if (r6 != r10) goto L_0x02ed
            com.google.android.gms.internal.ads.zzece r11 = (com.google.android.gms.internal.ads.zzece) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r2 = r7.zzhtb
            int r2 = r2 + r1
        L_0x02d8:
            if (r1 >= r2) goto L_0x02e4
            int r4 = com.google.android.gms.internal.ads.zzeam.zzf(r3, r1)
            r11.zzgw(r4)
            int r1 = r1 + 4
            goto L_0x02d8
        L_0x02e4:
            if (r1 != r2) goto L_0x02e8
            goto L_0x0423
        L_0x02e8:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x02ed:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.ads.zzece r11 = (com.google.android.gms.internal.ads.zzece) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zzf(r18, r19)
            r11.zzgw(r1)
        L_0x02f8:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r6 = r7.zzhtb
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.ads.zzeam.zzf(r3, r4)
            r11.zzgw(r1)
            goto L_0x02f8
        L_0x030c:
            if (r6 != r10) goto L_0x032c
            com.google.android.gms.internal.ads.zzedc r11 = (com.google.android.gms.internal.ads.zzedc) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r2 = r7.zzhtb
            int r2 = r2 + r1
        L_0x0317:
            if (r1 >= r2) goto L_0x0323
            long r4 = com.google.android.gms.internal.ads.zzeam.zzg(r3, r1)
            r11.zzfs(r4)
            int r1 = r1 + 8
            goto L_0x0317
        L_0x0323:
            if (r1 != r2) goto L_0x0327
            goto L_0x0423
        L_0x0327:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x032c:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.ads.zzedc r11 = (com.google.android.gms.internal.ads.zzedc) r11
            long r8 = com.google.android.gms.internal.ads.zzeam.zzg(r18, r19)
            r11.zzfs(r8)
        L_0x0337:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r6 = r7.zzhtb
            if (r2 != r6) goto L_0x0423
            long r8 = com.google.android.gms.internal.ads.zzeam.zzg(r3, r4)
            r11.zzfs(r8)
            goto L_0x0337
        L_0x034b:
            if (r6 != r10) goto L_0x0353
            int r1 = com.google.android.gms.internal.ads.zzeam.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.ads.zzecl<?>) r11, (com.google.android.gms.internal.ads.zzeap) r7)
            goto L_0x0423
        L_0x0353:
            if (r6 != 0) goto L_0x0422
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.ads.zzeam.zza((int) r21, (byte[]) r22, (int) r23, (int) r24, (com.google.android.gms.internal.ads.zzecl<?>) r25, (com.google.android.gms.internal.ads.zzeap) r26)
            goto L_0x0423
        L_0x0365:
            if (r6 != r10) goto L_0x0385
            com.google.android.gms.internal.ads.zzedc r11 = (com.google.android.gms.internal.ads.zzedc) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r2 = r7.zzhtb
            int r2 = r2 + r1
        L_0x0370:
            if (r1 >= r2) goto L_0x037c
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r1, r7)
            long r4 = r7.zzhtc
            r11.zzfs(r4)
            goto L_0x0370
        L_0x037c:
            if (r1 != r2) goto L_0x0380
            goto L_0x0423
        L_0x0380:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x0385:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.ads.zzedc r11 = (com.google.android.gms.internal.ads.zzedc) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r4, r7)
            long r8 = r7.zzhtc
            r11.zzfs(r8)
        L_0x0392:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r6 = r7.zzhtb
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r4, r7)
            long r8 = r7.zzhtc
            r11.zzfs(r8)
            goto L_0x0392
        L_0x03a6:
            if (r6 != r10) goto L_0x03c5
            com.google.android.gms.internal.ads.zzebz r11 = (com.google.android.gms.internal.ads.zzebz) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r2 = r7.zzhtb
            int r2 = r2 + r1
        L_0x03b1:
            if (r1 >= r2) goto L_0x03bd
            float r4 = com.google.android.gms.internal.ads.zzeam.zzi(r3, r1)
            r11.zzh(r4)
            int r1 = r1 + 4
            goto L_0x03b1
        L_0x03bd:
            if (r1 != r2) goto L_0x03c0
            goto L_0x0423
        L_0x03c0:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x03c5:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.ads.zzebz r11 = (com.google.android.gms.internal.ads.zzebz) r11
            float r1 = com.google.android.gms.internal.ads.zzeam.zzi(r18, r19)
            r11.zzh(r1)
        L_0x03d0:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r6 = r7.zzhtb
            if (r2 != r6) goto L_0x0423
            float r1 = com.google.android.gms.internal.ads.zzeam.zzi(r3, r4)
            r11.zzh(r1)
            goto L_0x03d0
        L_0x03e4:
            if (r6 != r10) goto L_0x0403
            com.google.android.gms.internal.ads.zzebp r11 = (com.google.android.gms.internal.ads.zzebp) r11
            int r1 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r7)
            int r2 = r7.zzhtb
            int r2 = r2 + r1
        L_0x03ef:
            if (r1 >= r2) goto L_0x03fb
            double r4 = com.google.android.gms.internal.ads.zzeam.zzh(r3, r1)
            r11.zzd(r4)
            int r1 = r1 + 8
            goto L_0x03ef
        L_0x03fb:
            if (r1 != r2) goto L_0x03fe
            goto L_0x0423
        L_0x03fe:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            throw r1
        L_0x0403:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.ads.zzebp r11 = (com.google.android.gms.internal.ads.zzebp) r11
            double r8 = com.google.android.gms.internal.ads.zzeam.zzh(r18, r19)
            r11.zzd(r8)
        L_0x040e:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.ads.zzeam.zza(r3, r1, r7)
            int r6 = r7.zzhtb
            if (r2 != r6) goto L_0x0423
            double r8 = com.google.android.gms.internal.ads.zzeam.zzh(r3, r4)
            r11.zzd(r8)
            goto L_0x040e
        L_0x0422:
            r1 = r4
        L_0x0423:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.ads.zzeap):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.ads.zzeap r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = zzhgt
            java.lang.Object r12 = r7.zzha(r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.ads.zzedh r2 = r7.zziat
            boolean r2 = r2.zzap(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.ads.zzedh r2 = r7.zziat
            java.lang.Object r2 = r2.zzar(r12)
            com.google.android.gms.internal.ads.zzedh r3 = r7.zziat
            r3.zze(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.ads.zzedh r8 = r7.zziat
            com.google.android.gms.internal.ads.zzedf r8 = r8.zzas(r12)
            com.google.android.gms.internal.ads.zzedh r12 = r7.zziat
            java.util.Map r12 = r12.zzan(r1)
            int r10 = com.google.android.gms.internal.ads.zzeam.zza(r9, r10, r15)
            int r13 = r15.zzhtb
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.zzhzx
            V r0 = r8.zzcif
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.ads.zzeam.zza((int) r10, (byte[]) r9, (int) r1, (com.google.android.gms.internal.ads.zzeap) r15)
            int r10 = r15.zzhtb
        L_0x004c:
            r2 = r1
            int r1 = r10 >>> 3
            r3 = r10 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0072
            r4 = 2
            if (r1 == r4) goto L_0x0058
            goto L_0x0087
        L_0x0058:
            com.google.android.gms.internal.ads.zzefp r1 = r8.zzhzy
            int r1 = r1.zzbho()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.ads.zzefp r4 = r8.zzhzy
            V r10 = r8.zzcif
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.ads.zzefp) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.ads.zzeap) r6)
            java.lang.Object r0 = r15.zzhtd
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.ads.zzefp r1 = r8.zzhzw
            int r1 = r1.zzbho()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.ads.zzefp r4 = r8.zzhzw
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.ads.zzefp) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.ads.zzeap) r6)
            java.lang.Object r14 = r15.zzhtd
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.android.gms.internal.ads.zzeam.zza((int) r10, (byte[]) r9, (int) r2, (int) r11, (com.google.android.gms.internal.ads.zzeap) r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.android.gms.internal.ads.zzeco r8 = com.google.android.gms.internal.ads.zzeco.zzbfn()
            throw r8
        L_0x0097:
            com.google.android.gms.internal.ads.zzeco r8 = com.google.android.gms.internal.ads.zzeco.zzbfg()
            goto L_0x009d
        L_0x009c:
            throw r8
        L_0x009d:
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.ads.zzeap):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x018a, code lost:
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x019b, code lost:
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x019d, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.ads.zzeap r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = zzhgt
            int[] r7 = r0.zziad
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x018d;
                case 52: goto L_0x017d;
                case 53: goto L_0x016d;
                case 54: goto L_0x016d;
                case 55: goto L_0x015d;
                case 56: goto L_0x014e;
                case 57: goto L_0x0140;
                case 58: goto L_0x0127;
                case 59: goto L_0x00f3;
                case 60: goto L_0x00c5;
                case 61: goto L_0x00b8;
                case 62: goto L_0x015d;
                case 63: goto L_0x008a;
                case 64: goto L_0x0140;
                case 65: goto L_0x014e;
                case 66: goto L_0x0075;
                case 67: goto L_0x0060;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x01a1
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x01a1
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.ads.zzeek r2 = r0.zzgz(r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.ads.zzeam.zza((com.google.android.gms.internal.ads.zzeek) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.ads.zzeap) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 != 0) goto L_0x0055
            java.lang.Object r3 = r11.zzhtd
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0055:
            java.lang.Object r3 = r11.zzhtd
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzecg.zzd(r15, r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0060:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r4, r11)
            long r3 = r11.zzhtc
            long r3 = com.google.android.gms.internal.ads.zzebf.zzfh(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0075:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r11)
            int r3 = r11.zzhtb
            int r3 = com.google.android.gms.internal.ads.zzebf.zzfw(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x008a:
            if (r5 != 0) goto L_0x01a1
            int r3 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r11)
            int r4 = r11.zzhtb
            com.google.android.gms.internal.ads.zzech r5 = r0.zzhb(r6)
            if (r5 == 0) goto L_0x00ae
            boolean r5 = r5.zzf(r4)
            if (r5 == 0) goto L_0x009f
            goto L_0x00ae
        L_0x009f:
            com.google.android.gms.internal.ads.zzefb r1 = zzav(r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zzd(r2, r4)
            r2 = r3
            goto L_0x01a2
        L_0x00ae:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x019d
        L_0x00b8:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.ads.zzeam.zze(r3, r4, r11)
            java.lang.Object r3 = r11.zzhtd
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x00c5:
            if (r5 != r15) goto L_0x01a1
            com.google.android.gms.internal.ads.zzeek r2 = r0.zzgz(r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.ads.zzeam.zza((com.google.android.gms.internal.ads.zzeek) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.ads.zzeap) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00dc
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00dd
        L_0x00dc:
            r15 = 0
        L_0x00dd:
            if (r15 != 0) goto L_0x00e5
            java.lang.Object r3 = r11.zzhtd
            r12.putObject(r1, r9, r3)
            goto L_0x00ee
        L_0x00e5:
            java.lang.Object r3 = r11.zzhtd
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzecg.zzd(r15, r3)
            r12.putObject(r1, r9, r3)
        L_0x00ee:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x00f3:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r11)
            int r4 = r11.zzhtb
            if (r4 != 0) goto L_0x0103
            java.lang.String r3 = ""
            r12.putObject(r1, r9, r3)
            goto L_0x0122
        L_0x0103:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0117
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.ads.zzefk.zzm(r3, r2, r5)
            if (r5 == 0) goto L_0x0112
            goto L_0x0117
        L_0x0112:
            com.google.android.gms.internal.ads.zzeco r1 = com.google.android.gms.internal.ads.zzeco.zzbfo()
            throw r1
        L_0x0117:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.ads.zzecg.UTF_8
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x0122:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x0127:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r4, r11)
            long r3 = r11.zzhtc
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0137
            r15 = 1
            goto L_0x0138
        L_0x0137:
            r15 = 0
        L_0x0138:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0140:
            if (r5 != r7) goto L_0x01a1
            int r2 = com.google.android.gms.internal.ads.zzeam.zzf(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x018a
        L_0x014e:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            long r2 = com.google.android.gms.internal.ads.zzeam.zzg(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x019b
        L_0x015d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.ads.zzeam.zza(r3, r4, r11)
            int r3 = r11.zzhtb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x016d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.ads.zzeam.zzb(r3, r4, r11)
            long r3 = r11.zzhtc
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x017d:
            if (r5 != r7) goto L_0x01a1
            float r2 = com.google.android.gms.internal.ads.zzeam.zzi(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x018a:
            int r2 = r4 + 4
            goto L_0x019d
        L_0x018d:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            double r2 = com.google.android.gms.internal.ads.zzeam.zzh(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x019b:
            int r2 = r4 + 8
        L_0x019d:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x01a1:
            r2 = r4
        L_0x01a2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zza(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.ads.zzeap):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v46, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x036a, code lost:
        if (r0 == r15) goto L_0x03dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03b3, code lost:
        if (r0 == r15) goto L_0x03dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        r7 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0174, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0213, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0215, code lost:
        r3 = r8;
        r2 = r9;
        r1 = r11;
        r9 = r13;
        r11 = r34;
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x023f, code lost:
        r32 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02b6, code lost:
        r0 = r7 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02b8, code lost:
        r6 = r6 | r22;
        r7 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02bc, code lost:
        r3 = r8;
        r2 = r9;
        r1 = r11;
        r9 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02c0, code lost:
        r13 = r33;
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02c6, code lost:
        r2 = r7;
        r18 = r9;
        r26 = r10;
        r24 = r11;
        r7 = r32;
        r9 = r8;
        r8 = r34;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.ads.zzeap r35) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            sun.misc.Unsafe r10 = zzhgt
            r16 = 0
            r0 = r32
            r1 = -1
            r2 = 0
            r3 = 0
            r6 = 0
            r7 = -1
        L_0x0017:
            if (r0 >= r13) goto L_0x047d
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0028
            int r0 = com.google.android.gms.internal.ads.zzeam.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.ads.zzeap) r9)
            int r3 = r9.zzhtb
            r4 = r0
            r5 = r3
            goto L_0x002a
        L_0x0028:
            r5 = r0
            r4 = r3
        L_0x002a:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x0037
            int r2 = r2 / r8
            int r1 = r15.zzan(r3, r2)
            goto L_0x003b
        L_0x0037:
            int r1 = r15.zzhf(r3)
        L_0x003b:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x004a
            r24 = r3
            r2 = r4
            r9 = r5
            r26 = r10
            r8 = r11
            r18 = 0
            goto L_0x03e1
        L_0x004a:
            int[] r1 = r15.zziad
            int r18 = r2 + 1
            r8 = r1[r18]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r8 & r18
            int r11 = r18 >>> 20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r5
            r5 = r8 & r18
            long r12 = (long) r5
            r5 = 17
            r20 = r8
            if (r11 > r5) goto L_0x02d4
            int r5 = r2 + 2
            r1 = r1[r5]
            int r5 = r1 >>> 20
            r8 = 1
            int r22 = r8 << r5
            r1 = r1 & r18
            r5 = -1
            if (r1 == r7) goto L_0x007e
            if (r7 == r5) goto L_0x0078
            long r8 = (long) r7
            r10.putInt(r14, r8, r6)
        L_0x0078:
            long r6 = (long) r1
            int r6 = r10.getInt(r14, r6)
            r7 = r1
        L_0x007e:
            r1 = 5
            switch(r11) {
                case 0: goto L_0x029e;
                case 1: goto L_0x0284;
                case 2: goto L_0x025e;
                case 3: goto L_0x025e;
                case 4: goto L_0x0243;
                case 5: goto L_0x021e;
                case 6: goto L_0x01fb;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01ae;
                case 9: goto L_0x0178;
                case 10: goto L_0x015d;
                case 11: goto L_0x0243;
                case 12: goto L_0x012b;
                case 13: goto L_0x01fb;
                case 14: goto L_0x021e;
                case 15: goto L_0x0110;
                case 16: goto L_0x00e3;
                case 17: goto L_0x0091;
                default: goto L_0x0082;
            }
        L_0x0082:
            r12 = r31
            r13 = r35
            r9 = r2
            r11 = r3
            r32 = r7
            r8 = r19
            r18 = -1
        L_0x008e:
            r7 = r4
            goto L_0x02c6
        L_0x0091:
            r8 = 3
            if (r0 != r8) goto L_0x00d7
            int r0 = r3 << 3
            r8 = r0 | 4
            com.google.android.gms.internal.ads.zzeek r0 = r15.zzgz(r2)
            r1 = r31
            r9 = r2
            r2 = r4
            r11 = r3
            r3 = r33
            r4 = r8
            r8 = r19
            r18 = -1
            r5 = r35
            int r0 = com.google.android.gms.internal.ads.zzeam.zza((com.google.android.gms.internal.ads.zzeek) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.ads.zzeap) r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00ba
            r5 = r35
            java.lang.Object r1 = r5.zzhtd
            r10.putObject(r14, r12, r1)
            goto L_0x00c9
        L_0x00ba:
            r5 = r35
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r5.zzhtd
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzecg.zzd(r1, r2)
            r10.putObject(r14, r12, r1)
        L_0x00c9:
            r6 = r6 | r22
            r12 = r31
            r13 = r33
            r3 = r8
            r2 = r9
            r1 = r11
            r11 = r34
            r9 = r5
            goto L_0x0017
        L_0x00d7:
            r9 = r2
            r11 = r3
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            goto L_0x023f
        L_0x00e3:
            r5 = r35
            r9 = r2
            r11 = r3
            r8 = r19
            r18 = -1
            if (r0 != 0) goto L_0x010b
            r2 = r12
            r12 = r31
            int r13 = com.google.android.gms.internal.ads.zzeam.zzb(r12, r4, r5)
            long r0 = r5.zzhtc
            long r19 = com.google.android.gms.internal.ads.zzebf.zzfh(r0)
            r0 = r10
            r1 = r30
            r32 = r13
            r13 = r5
            r4 = r19
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r32
            goto L_0x02bc
        L_0x010b:
            r12 = r31
            r13 = r5
            goto L_0x023f
        L_0x0110:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x023f
            int r0 = com.google.android.gms.internal.ads.zzeam.zza(r12, r4, r13)
            int r1 = r13.zzhtb
            int r1 = com.google.android.gms.internal.ads.zzebf.zzfw(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x0174
        L_0x012b:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x023f
            int r0 = com.google.android.gms.internal.ads.zzeam.zza(r12, r4, r13)
            int r1 = r13.zzhtb
            com.google.android.gms.internal.ads.zzech r4 = r15.zzhb(r9)
            if (r4 == 0) goto L_0x0159
            boolean r4 = r4.zzf(r1)
            if (r4 == 0) goto L_0x014b
            goto L_0x0159
        L_0x014b:
            com.google.android.gms.internal.ads.zzefb r2 = zzav(r30)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzd(r8, r1)
            goto L_0x02bc
        L_0x0159:
            r10.putInt(r14, r2, r1)
            goto L_0x0174
        L_0x015d:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x023f
            int r0 = com.google.android.gms.internal.ads.zzeam.zze(r12, r4, r13)
            java.lang.Object r1 = r13.zzhtd
            r10.putObject(r14, r2, r1)
        L_0x0174:
            r6 = r6 | r22
            goto L_0x02bc
        L_0x0178:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x01aa
            com.google.android.gms.internal.ads.zzeek r0 = r15.zzgz(r9)
            r5 = r33
            int r0 = com.google.android.gms.internal.ads.zzeam.zza((com.google.android.gms.internal.ads.zzeek) r0, (byte[]) r12, (int) r4, (int) r5, (com.google.android.gms.internal.ads.zzeap) r13)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x019b
            java.lang.Object r1 = r13.zzhtd
            r10.putObject(r14, r2, r1)
            goto L_0x0213
        L_0x019b:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r13.zzhtd
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzecg.zzd(r1, r4)
            r10.putObject(r14, r2, r1)
            goto L_0x0213
        L_0x01aa:
            r5 = r33
            goto L_0x023f
        L_0x01ae:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x023f
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x01c9
            int r0 = com.google.android.gms.internal.ads.zzeam.zzc(r12, r4, r13)
            goto L_0x01cd
        L_0x01c9:
            int r0 = com.google.android.gms.internal.ads.zzeam.zzd(r12, r4, r13)
        L_0x01cd:
            java.lang.Object r1 = r13.zzhtd
            r10.putObject(r14, r2, r1)
            goto L_0x0213
        L_0x01d3:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x023f
            int r0 = com.google.android.gms.internal.ads.zzeam.zzb(r12, r4, r13)
            r32 = r0
            long r0 = r13.zzhtc
            r19 = 0
            int r4 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r4 == 0) goto L_0x01f2
            r0 = 1
            goto L_0x01f3
        L_0x01f2:
            r0 = 0
        L_0x01f3:
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r14, (long) r2, (boolean) r0)
            r6 = r6 | r22
            r0 = r32
            goto L_0x0215
        L_0x01fb:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x023f
            int r0 = com.google.android.gms.internal.ads.zzeam.zzf(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
        L_0x0213:
            r6 = r6 | r22
        L_0x0215:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r34
            r13 = r5
            goto L_0x0017
        L_0x021e:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 1
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x023f
            long r19 = com.google.android.gms.internal.ads.zzeam.zzg(r12, r4)
            r0 = r10
            r1 = r30
            r32 = r7
            r7 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
            goto L_0x02b6
        L_0x023f:
            r32 = r7
            goto L_0x008e
        L_0x0243:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != 0) goto L_0x02c6
            int r0 = com.google.android.gms.internal.ads.zzeam.zza(r12, r7, r13)
            int r1 = r13.zzhtb
            r10.putInt(r14, r2, r1)
            goto L_0x02b8
        L_0x025e:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != 0) goto L_0x02c6
            int r7 = com.google.android.gms.internal.ads.zzeam.zzb(r12, r7, r13)
            long r4 = r13.zzhtc
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r7
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r7 = r32
            goto L_0x02c0
        L_0x0284:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != r1) goto L_0x02c6
            float r0 = com.google.android.gms.internal.ads.zzeam.zzi(r12, r7)
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r7 + 4
            goto L_0x02b8
        L_0x029e:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r1 = 1
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != r1) goto L_0x02c6
            double r0 = com.google.android.gms.internal.ads.zzeam.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x02b6:
            int r0 = r7 + 8
        L_0x02b8:
            r6 = r6 | r22
            r7 = r32
        L_0x02bc:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
        L_0x02c0:
            r13 = r33
            r11 = r34
            goto L_0x0017
        L_0x02c6:
            r2 = r7
            r18 = r9
            r26 = r10
            r24 = r11
            r7 = r32
            r9 = r8
            r8 = r34
            goto L_0x03e1
        L_0x02d4:
            r5 = r3
            r17 = r7
            r8 = r19
            r18 = -1
            r7 = r4
            r27 = r12
            r12 = r31
            r13 = r9
            r9 = r2
            r2 = r27
            r1 = 27
            if (r11 != r1) goto L_0x0339
            r1 = 2
            if (r0 != r1) goto L_0x032c
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.ads.zzecl r0 = (com.google.android.gms.internal.ads.zzecl) r0
            boolean r1 = r0.zzbci()
            if (r1 != 0) goto L_0x0309
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0300
            r1 = 10
            goto L_0x0302
        L_0x0300:
            int r1 = r1 << 1
        L_0x0302:
            com.google.android.gms.internal.ads.zzecl r0 = r0.zzfn(r1)
            r10.putObject(r14, r2, r0)
        L_0x0309:
            r11 = r0
            com.google.android.gms.internal.ads.zzeek r0 = r15.zzgz(r9)
            r1 = r8
            r2 = r31
            r3 = r7
            r4 = r33
            r7 = r5
            r5 = r11
            r19 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.ads.zzeam.zza(r0, r1, r2, r3, r4, r5, r6)
            r11 = r34
            r1 = r7
            r3 = r8
            r2 = r9
            r9 = r13
            r7 = r17
            r6 = r19
            r13 = r33
            goto L_0x0017
        L_0x032c:
            r19 = r6
            r24 = r5
            r15 = r7
            r25 = r8
            r18 = r9
            r26 = r10
            goto L_0x03b6
        L_0x0339:
            r19 = r6
            r6 = r5
            r1 = 49
            if (r11 > r1) goto L_0x0388
            r5 = r20
            long r4 = (long) r5
            r1 = r0
            r0 = r29
            r32 = r1
            r1 = r30
            r22 = r2
            r2 = r31
            r3 = r7
            r20 = r4
            r4 = r33
            r5 = r8
            r24 = r6
            r15 = r7
            r7 = r32
            r25 = r8
            r8 = r9
            r18 = r9
            r26 = r10
            r9 = r20
            r12 = r22
            r14 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.ads.zzeap) r14)
            if (r0 != r15) goto L_0x036e
            goto L_0x03dd
        L_0x036e:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r7 = r17
            r2 = r18
            r6 = r19
            r1 = r24
            r3 = r25
            r10 = r26
            goto L_0x0017
        L_0x0388:
            r32 = r0
            r22 = r2
            r24 = r6
            r15 = r7
            r25 = r8
            r18 = r9
            r26 = r10
            r5 = r20
            r0 = 50
            if (r11 != r0) goto L_0x03c0
            r7 = r32
            r0 = 2
            if (r7 != r0) goto L_0x03b6
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r18
            r6 = r22
            r8 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.ads.zzeap) r8)
            if (r0 != r15) goto L_0x036e
            goto L_0x03dd
        L_0x03b6:
            r8 = r34
            r2 = r15
        L_0x03b9:
            r7 = r17
            r6 = r19
            r9 = r25
            goto L_0x03e1
        L_0x03c0:
            r7 = r32
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r8 = r5
            r5 = r25
            r6 = r24
            r9 = r11
            r10 = r22
            r12 = r18
            r13 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.ads.zzeap) r13)
            if (r0 != r15) goto L_0x0461
        L_0x03dd:
            r8 = r34
            r2 = r0
            goto L_0x03b9
        L_0x03e1:
            if (r9 != r8) goto L_0x03ef
            if (r8 != 0) goto L_0x03e6
            goto L_0x03ef
        L_0x03e6:
            r1 = -1
            r10 = r29
            r13 = r30
            r0 = r2
            r3 = r9
            goto L_0x0487
        L_0x03ef:
            r10 = r29
            boolean r0 = r10.zziai
            if (r0 == 0) goto L_0x043c
            r11 = r35
            com.google.android.gms.internal.ads.zzebq r0 = r11.zzhte
            com.google.android.gms.internal.ads.zzebq r1 = com.google.android.gms.internal.ads.zzebq.zzbec()
            if (r0 == r1) goto L_0x0439
            com.google.android.gms.internal.ads.zzedo r0 = r10.zziah
            com.google.android.gms.internal.ads.zzebq r1 = r11.zzhte
            r12 = r24
            com.google.android.gms.internal.ads.zzecd$zzd r0 = r1.zza(r0, r12)
            if (r0 != 0) goto L_0x0429
            com.google.android.gms.internal.ads.zzefb r4 = zzav(r30)
            r0 = r9
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.ads.zzeam.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.ads.zzefb) r4, (com.google.android.gms.internal.ads.zzeap) r5)
            r14 = r30
            r13 = r33
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r2 = r18
            r10 = r26
            r12 = r31
            goto L_0x045e
        L_0x0429:
            r13 = r30
            r0 = r13
            com.google.android.gms.internal.ads.zzecd$zzb r0 = (com.google.android.gms.internal.ads.zzecd.zzb) r0
            r0.zzbfd()
            com.google.android.gms.internal.ads.zzebt<com.google.android.gms.internal.ads.zzecd$zze> r0 = r0.zzhxy
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x0439:
            r13 = r30
            goto L_0x0440
        L_0x043c:
            r13 = r30
            r11 = r35
        L_0x0440:
            r12 = r24
            com.google.android.gms.internal.ads.zzefb r4 = zzav(r30)
            r0 = r9
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.ads.zzeam.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.ads.zzefb) r4, (com.google.android.gms.internal.ads.zzeap) r5)
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r14 = r13
            r2 = r18
            r10 = r26
            r12 = r31
            r13 = r33
        L_0x045e:
            r11 = r8
            goto L_0x0017
        L_0x0461:
            r12 = r24
            r9 = r25
            r15 = r29
            r14 = r30
            r13 = r33
            r11 = r34
            r3 = r9
            r1 = r12
            r7 = r17
            r2 = r18
            r6 = r19
            r10 = r26
            r12 = r31
            r9 = r35
            goto L_0x0017
        L_0x047d:
            r19 = r6
            r17 = r7
            r26 = r10
            r8 = r11
            r13 = r14
            r10 = r15
            r1 = -1
        L_0x0487:
            if (r7 == r1) goto L_0x048f
            long r1 = (long) r7
            r4 = r26
            r4.putInt(r13, r1, r6)
        L_0x048f:
            r1 = 0
            int r2 = r10.zzian
        L_0x0492:
            int r4 = r10.zziao
            if (r2 >= r4) goto L_0x04a5
            int[] r4 = r10.zziam
            r4 = r4[r2]
            com.google.android.gms.internal.ads.zzefc<?, ?> r5 = r10.zziar
            java.lang.Object r1 = r10.zza((java.lang.Object) r13, (int) r4, r1, r5)
            com.google.android.gms.internal.ads.zzefb r1 = (com.google.android.gms.internal.ads.zzefb) r1
            int r2 = r2 + 1
            goto L_0x0492
        L_0x04a5:
            if (r1 == 0) goto L_0x04ac
            com.google.android.gms.internal.ads.zzefc<?, ?> r2 = r10.zziar
            r2.zzi(r13, r1)
        L_0x04ac:
            if (r8 != 0) goto L_0x04b8
            r1 = r33
            if (r0 != r1) goto L_0x04b3
            goto L_0x04be
        L_0x04b3:
            com.google.android.gms.internal.ads.zzeco r0 = com.google.android.gms.internal.ads.zzeco.zzbfn()
            throw r0
        L_0x04b8:
            r1 = r33
            if (r0 > r1) goto L_0x04bf
            if (r3 != r8) goto L_0x04bf
        L_0x04be:
            return r0
        L_0x04bf:
            com.google.android.gms.internal.ads.zzeco r0 = com.google.android.gms.internal.ads.zzeco.zzbfn()
            goto L_0x04c5
        L_0x04c4:
            throw r0
        L_0x04c5:
            goto L_0x04c4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzeap):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010b, code lost:
        r2 = r4;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013d, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0159, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015b, code lost:
        r1 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015f, code lost:
        r24 = r7;
        r15 = r8;
        r18 = r9;
        r19 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e2, code lost:
        if (r0 == r15) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x020f, code lost:
        if (r0 == r15) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x022e, code lost:
        if (r0 == r15) goto L_0x0230;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.ads.zzeap r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            boolean r0 = r15.zziak
            if (r0 == 0) goto L_0x025d
            sun.misc.Unsafe r9 = zzhgt
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
        L_0x0017:
            if (r0 >= r13) goto L_0x0254
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0029
            int r0 = com.google.android.gms.internal.ads.zzeam.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.ads.zzeap) r11)
            int r3 = r11.zzhtb
            r8 = r0
            r17 = r3
            goto L_0x002c
        L_0x0029:
            r17 = r0
            r8 = r3
        L_0x002c:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x0039
            int r2 = r2 / 3
            int r0 = r15.zzan(r7, r2)
            goto L_0x003d
        L_0x0039:
            int r0 = r15.zzhf(r7)
        L_0x003d:
            r4 = r0
            if (r4 != r10) goto L_0x004b
            r24 = r7
            r2 = r8
            r18 = r9
            r19 = 0
            r26 = -1
            goto L_0x0231
        L_0x004b:
            int[] r0 = r15.zziad
            int r1 = r4 + 1
            r5 = r0[r1]
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r5
            int r3 = r0 >>> 20
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r1 = (long) r0
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x0167
            r0 = 1
            switch(r3) {
                case 0: goto L_0x014e;
                case 1: goto L_0x013f;
                case 2: goto L_0x012d;
                case 3: goto L_0x012d;
                case 4: goto L_0x011f;
                case 5: goto L_0x010f;
                case 6: goto L_0x00fe;
                case 7: goto L_0x00e8;
                case 8: goto L_0x00d1;
                case 9: goto L_0x00b0;
                case 10: goto L_0x00a3;
                case 11: goto L_0x011f;
                case 12: goto L_0x0094;
                case 13: goto L_0x00fe;
                case 14: goto L_0x010f;
                case 15: goto L_0x0081;
                case 16: goto L_0x0066;
                default: goto L_0x0064;
            }
        L_0x0064:
            goto L_0x01a4
        L_0x0066:
            if (r6 != 0) goto L_0x01a4
            int r6 = com.google.android.gms.internal.ads.zzeam.zzb(r12, r8, r11)
            r19 = r1
            long r0 = r11.zzhtc
            long r21 = com.google.android.gms.internal.ads.zzebf.zzfh(r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            goto L_0x013d
        L_0x0081:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r0 = com.google.android.gms.internal.ads.zzeam.zza(r12, r8, r11)
            int r1 = r11.zzhtb
            int r1 = com.google.android.gms.internal.ads.zzebf.zzfw(r1)
            r9.putInt(r14, r2, r1)
            goto L_0x015b
        L_0x0094:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r0 = com.google.android.gms.internal.ads.zzeam.zza(r12, r8, r11)
            int r1 = r11.zzhtb
            r9.putInt(r14, r2, r1)
            goto L_0x015b
        L_0x00a3:
            r2 = r1
            if (r6 != r10) goto L_0x01a4
            int r0 = com.google.android.gms.internal.ads.zzeam.zze(r12, r8, r11)
            java.lang.Object r1 = r11.zzhtd
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00b0:
            r2 = r1
            if (r6 != r10) goto L_0x01a4
            com.google.android.gms.internal.ads.zzeek r0 = r15.zzgz(r4)
            int r0 = com.google.android.gms.internal.ads.zzeam.zza((com.google.android.gms.internal.ads.zzeek) r0, (byte[]) r12, (int) r8, (int) r13, (com.google.android.gms.internal.ads.zzeap) r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00c7
            java.lang.Object r1 = r11.zzhtd
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00c7:
            java.lang.Object r5 = r11.zzhtd
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzecg.zzd(r1, r5)
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00d1:
            r2 = r1
            if (r6 != r10) goto L_0x01a4
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00de
            int r0 = com.google.android.gms.internal.ads.zzeam.zzc(r12, r8, r11)
            goto L_0x00e2
        L_0x00de:
            int r0 = com.google.android.gms.internal.ads.zzeam.zzd(r12, r8, r11)
        L_0x00e2:
            java.lang.Object r1 = r11.zzhtd
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00e8:
            r2 = r1
            if (r6 != 0) goto L_0x01a4
            int r1 = com.google.android.gms.internal.ads.zzeam.zzb(r12, r8, r11)
            long r5 = r11.zzhtc
            r19 = 0
            int r8 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x00f8
            goto L_0x00f9
        L_0x00f8:
            r0 = 0
        L_0x00f9:
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r14, (long) r2, (boolean) r0)
            r0 = r1
            goto L_0x010b
        L_0x00fe:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x01a4
            int r0 = com.google.android.gms.internal.ads.zzeam.zzf(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x010b:
            r2 = r4
            r1 = r7
            goto L_0x0251
        L_0x010f:
            r2 = r1
            if (r6 != r0) goto L_0x01a4
            long r5 = com.google.android.gms.internal.ads.zzeam.zzg(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
            goto L_0x0159
        L_0x011f:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r0 = com.google.android.gms.internal.ads.zzeam.zza(r12, r8, r11)
            int r1 = r11.zzhtb
            r9.putInt(r14, r2, r1)
            goto L_0x015b
        L_0x012d:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r6 = com.google.android.gms.internal.ads.zzeam.zzb(r12, r8, r11)
            long r4 = r11.zzhtc
            r0 = r9
            r1 = r28
            r0.putLong(r1, r2, r4)
        L_0x013d:
            r0 = r6
            goto L_0x015b
        L_0x013f:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x015f
            float r0 = com.google.android.gms.internal.ads.zzeam.zzi(r12, r8)
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r8 + 4
            goto L_0x015b
        L_0x014e:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x015f
            double r0 = com.google.android.gms.internal.ads.zzeam.zzh(r12, r8)
            com.google.android.gms.internal.ads.zzefi.zza((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x0159:
            int r0 = r8 + 8
        L_0x015b:
            r1 = r7
            r2 = r10
            goto L_0x0251
        L_0x015f:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            goto L_0x01ab
        L_0x0167:
            r0 = 27
            if (r3 != r0) goto L_0x01af
            if (r6 != r10) goto L_0x01a4
            java.lang.Object r0 = r9.getObject(r14, r1)
            com.google.android.gms.internal.ads.zzecl r0 = (com.google.android.gms.internal.ads.zzecl) r0
            boolean r3 = r0.zzbci()
            if (r3 != 0) goto L_0x018b
            int r3 = r0.size()
            if (r3 != 0) goto L_0x0182
            r3 = 10
            goto L_0x0184
        L_0x0182:
            int r3 = r3 << 1
        L_0x0184:
            com.google.android.gms.internal.ads.zzecl r0 = r0.zzfn(r3)
            r9.putObject(r14, r1, r0)
        L_0x018b:
            r5 = r0
            com.google.android.gms.internal.ads.zzeek r0 = r15.zzgz(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = com.google.android.gms.internal.ads.zzeam.zza(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            goto L_0x0251
        L_0x01a4:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
        L_0x01ab:
            r26 = -1
            goto L_0x0212
        L_0x01af:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x01e5
            long r4 = (long) r5
            r0 = r27
            r20 = r1
            r1 = r28
            r2 = r29
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r31
            r5 = r17
            r30 = r6
            r6 = r7
            r24 = r7
            r7 = r30
            r15 = r8
            r8 = r19
            r18 = r9
            r25 = r10
            r26 = -1
            r9 = r22
            r11 = r25
            r12 = r20
            r14 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.ads.zzeap) r14)
            if (r0 != r15) goto L_0x0241
            goto L_0x0230
        L_0x01e5:
            r20 = r1
            r25 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x0214
            r7 = r30
            if (r7 != r10) goto L_0x0212
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.ads.zzeap) r8)
            if (r0 != r15) goto L_0x0241
            goto L_0x0230
        L_0x0212:
            r2 = r15
            goto L_0x0231
        L_0x0214:
            r7 = r30
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r8 = r5
            r5 = r17
            r6 = r24
            r10 = r20
            r12 = r19
            r13 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.ads.zzeap) r13)
            if (r0 != r15) goto L_0x0241
        L_0x0230:
            r2 = r0
        L_0x0231:
            com.google.android.gms.internal.ads.zzefb r4 = zzav(r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = com.google.android.gms.internal.ads.zzeam.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.ads.zzefb) r4, (com.google.android.gms.internal.ads.zzeap) r5)
        L_0x0241:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
        L_0x0251:
            r10 = -1
            goto L_0x0017
        L_0x0254:
            r4 = r13
            if (r0 != r4) goto L_0x0258
            return
        L_0x0258:
            com.google.android.gms.internal.ads.zzeco r0 = com.google.android.gms.internal.ads.zzeco.zzbfn()
            throw r0
        L_0x025d:
            r4 = r13
            r5 = 0
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r6 = r32
            r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.ads.zzeap) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeds.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzeap):void");
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzefc<UT, UB> zzefc) {
        zzech zzhb;
        int i2 = this.zziad[i];
        Object zzp = zzefi.zzp(obj, (long) (zzhc(i) & 1048575));
        if (zzp == null || (zzhb = zzhb(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zziat.zzan(zzp), zzhb, ub, zzefc);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzech zzech, UB ub, zzefc<UT, UB> zzefc) {
        zzedf<?, ?> zzas = this.zziat.zzas(zzha(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzech.zzf(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzefc.zzbhg();
                }
                zzeay zzfq = zzeaq.zzfq(zzedg.zza(zzas, next.getKey(), next.getValue()));
                try {
                    zzedg.zza(zzfq.zzbcx(), zzas, next.getKey(), next.getValue());
                    zzefc.zza(ub, i2, zzfq.zzbcw());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private static boolean zza(Object obj, int i, zzeek zzeek) {
        return zzeek.zzaw(zzefi.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzefv zzefv) throws IOException {
        if (obj instanceof String) {
            zzefv.zzk(i, (String) obj);
        } else {
            zzefv.zza(i, (zzeaq) obj);
        }
    }

    private final void zza(Object obj, int i, zzeee zzeee) throws IOException {
        if (zzhe(i)) {
            zzefi.zza(obj, (long) (i & 1048575), (Object) zzeee.zzbdf());
        } else if (this.zziaj) {
            zzefi.zza(obj, (long) (i & 1048575), (Object) zzeee.readString());
        } else {
            zzefi.zza(obj, (long) (i & 1048575), (Object) zzeee.zzbdg());
        }
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zziak) {
            return zze(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i, int i2) {
        return zzefi.zzk(t, (long) (zzhd(i2) & 1048575)) == i;
    }
}
