package com.google.android.gms.internal.ads;

import android.support.p004v4.media.session.PlaybackStateCompat;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzkg {
    private final zzos zzaow = new zzos(8);
    private int zzarw;

    private final long zzc(zzjl zzjl) throws IOException, InterruptedException {
        int i = 0;
        zzjl.zza(this.zzaow.data, 0, 1);
        byte b = this.zzaow.data[0] & 255;
        if (b == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i3 = 0;
        while ((b & i2) == 0) {
            i2 >>= 1;
            i3++;
        }
        int i4 = b & (i2 ^ -1);
        zzjl.zza(this.zzaow.data, 1, i3);
        while (i < i3) {
            i++;
            i4 = (this.zzaow.data[i] & 255) + (i4 << 8);
        }
        this.zzarw += i3 + 1;
        return (long) i4;
    }

    public final boolean zza(zzjl zzjl) throws IOException, InterruptedException {
        zzjl zzjl2 = zzjl;
        long length = zzjl.getLength();
        long j = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        if (length != -1 && length <= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            j = length;
        }
        int i = (int) j;
        zzjl2.zza(this.zzaow.data, 0, 4);
        this.zzarw = 4;
        for (long zzjb = this.zzaow.zzjb(); zzjb != 440786851; zzjb = ((zzjb << 8) & -256) | ((long) (this.zzaow.data[0] & 255))) {
            int i2 = this.zzarw + 1;
            this.zzarw = i2;
            if (i2 == i) {
                return false;
            }
            zzjl2.zza(this.zzaow.data, 0, 1);
        }
        long zzc = zzc(zzjl);
        long j2 = (long) this.zzarw;
        if (zzc != Long.MIN_VALUE && (length == -1 || j2 + zzc < length)) {
            while (true) {
                int i3 = this.zzarw;
                long j3 = j2 + zzc;
                if (((long) i3) < j3) {
                    if (zzc(zzjl) == Long.MIN_VALUE) {
                        return false;
                    }
                    long zzc2 = zzc(zzjl);
                    if (zzc2 < 0 || zzc2 > 2147483647L) {
                        return false;
                    }
                    if (zzc2 != 0) {
                        zzjl2.zzaf((int) zzc2);
                        this.zzarw = (int) (((long) this.zzarw) + zzc2);
                    }
                } else if (((long) i3) == j3) {
                    return true;
                }
            }
        }
        return false;
    }
}
