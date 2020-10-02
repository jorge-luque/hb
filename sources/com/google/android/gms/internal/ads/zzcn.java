package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import com.loopj.android.http.C4250c;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzcn {
    private static boolean zznf = false;
    /* access modifiers changed from: private */
    public static MessageDigest zzng;
    private static final Object zznh = new Object();
    private static final Object zzni = new Object();
    static CountDownLatch zznj = new CountDownLatch(1);

    private static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    public static byte[] zzb(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zznh) {
            MessageDigest zzbq = zzbq();
            if (zzbq != null) {
                zzbq.reset();
                zzbq.update(bArr);
                digest = zzng.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return digest;
    }

    static void zzbp() {
        synchronized (zzni) {
            if (!zznf) {
                zznf = true;
                new Thread(new zzcp()).start();
            }
        }
    }

    private static MessageDigest zzbq() {
        boolean z;
        MessageDigest messageDigest;
        zzbp();
        try {
            z = zznj.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            z = false;
        }
        if (z && (messageDigest = zzng) != null) {
            return messageDigest;
        }
        return null;
    }

    static String zzj(zzbv.zza zza, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] bArr;
        byte[] byteArray = zza.toByteArray();
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcoa)).booleanValue()) {
            Vector<byte[]> zza2 = zza(byteArray, 255);
            if (zza2 == null || zza2.size() == 0) {
                bArr = zza(zza(zzbv.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray(), str, true);
            } else {
                zzbv.zzf.zza zzbm = zzbv.zzf.zzbm();
                Iterator<byte[]> it = zza2.iterator();
                while (it.hasNext()) {
                    zzbm.zzj(zzeaq.zzu(zza(it.next(), str, false)));
                }
                zzbm.zzk(zzeaq.zzu(zzb(byteArray)));
                bArr = ((zzbv.zzf) ((zzecd) zzbm.zzbet())).toByteArray();
            }
        } else if (zzer.zzza != null) {
            bArr = ((zzbv.zzf) ((zzecd) zzbv.zzf.zzbm().zzj(zzeaq.zzu(zzer.zzza.zzc(byteArray, str != null ? str.getBytes() : new byte[0]))).zzb(zzcc.TINK_HYBRID).zzbet())).toByteArray();
        } else {
            throw new GeneralSecurityException();
        }
        return zzcl.zza(bArr, true);
    }

    private static zzbv.zza zza(zzbv.zza.zzd zzd) {
        zzbv.zza.C6825zza zzar = zzbv.zza.zzar();
        zzar.zzn((long) zzd.zzw());
        return (zzbv.zza) ((zzecd) zzar.zzbet());
    }

    private static byte[] zza(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bArr2;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = zza(zzbv.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray();
        }
        if (bArr.length < i) {
            byte[] bArr3 = new byte[(i - bArr.length)];
            new SecureRandom().nextBytes(bArr3);
            bArr2 = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr3).array();
        } else {
            bArr2 = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            bArr2 = ByteBuffer.allocate(256).put(zzb(bArr2)).put(bArr2).array();
        }
        byte[] bArr4 = new byte[256];
        for (zzcu zza : new zzcs().zzvc) {
            zza.zza(bArr2, bArr4);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzeah(str.getBytes(C4250c.DEFAULT_CHARSET)).zzt(bArr4);
        }
        return bArr4;
    }
}
