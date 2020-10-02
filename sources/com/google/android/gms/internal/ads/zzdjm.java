package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdjm {
    private int zzgym = 0;
    private final long zzgyn;
    private final zzdjl zzgyo = new zzdjl();
    private long zzgyp;
    private int zzgyq = 0;
    private int zzgyr = 0;

    public zzdjm() {
        long currentTimeMillis = zzq.zzld().currentTimeMillis();
        this.zzgyn = currentTimeMillis;
        this.zzgyp = currentTimeMillis;
    }

    public final long getCreationTimeMillis() {
        return this.zzgyn;
    }

    public final long zzasl() {
        return this.zzgyp;
    }

    public final int zzasm() {
        return this.zzgyq;
    }

    public final String zzasy() {
        return "Created: " + this.zzgyn + " Last accessed: " + this.zzgyp + " Accesses: " + this.zzgyq + "\nEntries retrieved: Valid: " + this.zzgyr + " Stale: " + this.zzgym;
    }

    public final void zzati() {
        this.zzgyp = zzq.zzld().currentTimeMillis();
        this.zzgyq++;
    }

    public final void zzatj() {
        this.zzgyr++;
        this.zzgyo.zzgyl = true;
    }

    public final void zzatk() {
        this.zzgym++;
        this.zzgyo.zzgym++;
    }

    public final zzdjl zzatl() {
        zzdjl zzdjl = (zzdjl) this.zzgyo.clone();
        zzdjl zzdjl2 = this.zzgyo;
        zzdjl2.zzgyl = false;
        zzdjl2.zzgym = 0;
        return zzdjl;
    }
}
