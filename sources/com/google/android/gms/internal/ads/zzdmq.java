package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
public final class zzdmq {
    private final Context zzvf;
    private final zzdlk zzvj;

    public zzdmq(Context context, zzdlk zzdlk) {
        this.zzvf = context;
        this.zzvj = zzdlk;
    }

    private final String zzauu() {
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"i686", "armv71"}));
        String value = zzdol.OS_ARCH.value();
        if (!TextUtils.isEmpty(value) && hashSet.contains(value)) {
            return value;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (NoSuchFieldException e) {
            zzdlk zzdlk = this.zzvj;
            if (zzdlk != null) {
                zzdlk.zza(2024, 0, (Exception) e);
            }
        } catch (IllegalAccessException e2) {
            zzdlk zzdlk2 = this.zzvj;
            if (zzdlk2 != null) {
                zzdlk2.zza(2024, 0, (Exception) e2);
            }
        }
        String str = Build.CPU_ABI;
        if (str != null) {
            return str;
        }
        return Build.CPU_ABI2;
    }

    private final zzgb zzauv() {
        FileInputStream fileInputStream;
        File file = new File(new File(this.zzvf.getApplicationInfo().dataDir), "lib");
        if (!file.exists()) {
            return zzgb.UNSUPPORTED;
        }
        File[] listFiles = file.listFiles(new zzdpt(Pattern.compile(".*\\.so$", 2)));
        if (listFiles == null || listFiles.length == 0) {
            return zzgb.UNSUPPORTED;
        }
        try {
            fileInputStream = new FileInputStream(listFiles[0]);
            byte[] bArr = new byte[20];
            if (fileInputStream.read(bArr) == 20) {
                byte[] bArr2 = {0, 0};
                if (bArr[5] == 2) {
                    zzj(bArr);
                    zzgb zzgb = zzgb.UNSUPPORTED;
                    fileInputStream.close();
                    return zzgb;
                }
                bArr2[0] = bArr[19];
                bArr2[1] = bArr[18];
                short s = ByteBuffer.wrap(bArr2).getShort();
                if (s == 3) {
                    zzgb zzgb2 = zzgb.X86;
                    fileInputStream.close();
                    return zzgb2;
                } else if (s == 40) {
                    zzgb zzgb3 = zzgb.ARM7;
                    fileInputStream.close();
                    return zzgb3;
                } else if (s == 62) {
                    zzgb zzgb4 = zzgb.X86_64;
                    fileInputStream.close();
                    return zzgb4;
                } else if (s != 183) {
                    zzgb zzgb5 = zzgb.UNSUPPORTED;
                    fileInputStream.close();
                    return zzgb5;
                } else {
                    zzgb zzgb6 = zzgb.ARM64;
                    fileInputStream.close();
                    return zzgb6;
                }
            } else {
                fileInputStream.close();
                return zzgb.UNSUPPORTED;
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            zzdzz.zza(th, th);
        }
        throw th;
    }

    private final void zzj(byte[] bArr) {
        if (this.zzvj != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("os.arch:");
            sb.append(zzdol.OS_ARCH.value());
            sb.append(";");
            try {
                String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
                if (strArr != null) {
                    sb.append("supported_abis:");
                    sb.append(Arrays.toString(strArr));
                    sb.append(";");
                }
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
            sb.append("CPU_ABI:");
            sb.append(Build.CPU_ABI);
            sb.append(";");
            sb.append("CPU_ABI2:");
            sb.append(Build.CPU_ABI2);
            sb.append(";");
            if (bArr != null) {
                sb.append("ELF:");
                sb.append(Arrays.toString(bArr));
                sb.append(";");
            }
            this.zzvj.zzi(4007, sb.toString());
        }
    }

    public final zzgb zzauw() {
        zzgb zzauv = zzauv();
        if (zzauv != zzgb.UNSUPPORTED) {
            return zzauv;
        }
        String zzauu = zzauu();
        if (!TextUtils.isEmpty(zzauu)) {
            if (zzauu.equalsIgnoreCase("i686") || zzauu.equalsIgnoreCase("x86")) {
                return zzgb.X86;
            }
            if (zzauu.equalsIgnoreCase("x86_64")) {
                return zzgb.X86_64;
            }
            if (zzauu.equalsIgnoreCase("arm64-v8a")) {
                return zzgb.ARM64;
            }
            if (zzauu.equalsIgnoreCase("armeabi-v7a") || zzauu.equalsIgnoreCase("armv71")) {
                return zzgb.ARM7;
            }
        }
        zzj((byte[]) null);
        return zzgb.UNSUPPORTED;
    }
}
