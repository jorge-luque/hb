package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzot implements zzol {
    private boolean started;
    private zzhl zzaek = zzhl.zzahe;
    private long zzbht;
    private long zzbhu;

    public final void start() {
        if (!this.started) {
            this.zzbhu = SystemClock.elapsedRealtime();
            this.started = true;
        }
    }

    public final void stop() {
        if (this.started) {
            zzel(zzgb());
            this.started = false;
        }
    }

    public final void zza(zzol zzol) {
        zzel(zzol.zzgb());
        this.zzaek = zzol.zzfr();
    }

    public final zzhl zzb(zzhl zzhl) {
        if (this.started) {
            zzel(zzgb());
        }
        this.zzaek = zzhl;
        return zzhl;
    }

    public final void zzel(long j) {
        this.zzbht = j;
        if (this.started) {
            this.zzbhu = SystemClock.elapsedRealtime();
        }
    }

    public final zzhl zzfr() {
        return this.zzaek;
    }

    public final long zzgb() {
        long j;
        long j2 = this.zzbht;
        if (!this.started) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzbhu;
        zzhl zzhl = this.zzaek;
        if (zzhl.zzahf == 1.0f) {
            j = zzgr.zzdp(elapsedRealtime);
        } else {
            j = zzhl.zzdu(elapsedRealtime);
        }
        return j2 + j;
    }
}
