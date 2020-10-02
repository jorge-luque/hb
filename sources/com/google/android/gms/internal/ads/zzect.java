package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public class zzect {
    private static final zzebq zzhsw = zzebq.zzbec();
    private zzeaq zzhzh;
    private volatile zzedo zzhzi;
    private volatile zzeaq zzhzj;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzedo zzm(com.google.android.gms.internal.ads.zzedo r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzedo r0 = r1.zzhzi
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzedo r0 = r1.zzhzi     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzhzi = r2     // Catch:{ zzeco -> 0x0012 }
            com.google.android.gms.internal.ads.zzeaq r0 = com.google.android.gms.internal.ads.zzeaq.zzhtf     // Catch:{ zzeco -> 0x0012 }
            r1.zzhzj = r0     // Catch:{ zzeco -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzhzi = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.ads.zzeaq r2 = com.google.android.gms.internal.ads.zzeaq.zzhtf     // Catch:{ all -> 0x001a }
            r1.zzhzj = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.ads.zzedo r2 = r1.zzhzi
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzect.zzm(com.google.android.gms.internal.ads.zzedo):com.google.android.gms.internal.ads.zzedo");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzect)) {
            return false;
        }
        zzect zzect = (zzect) obj;
        zzedo zzedo = this.zzhzi;
        zzedo zzedo2 = zzect.zzhzi;
        if (zzedo == null && zzedo2 == null) {
            return zzbce().equals(zzect.zzbce());
        }
        if (zzedo != null && zzedo2 != null) {
            return zzedo.equals(zzedo2);
        }
        if (zzedo != null) {
            return zzedo.equals(zzect.zzm(zzedo.zzbeu()));
        }
        return zzm(zzedo2.zzbeu()).equals(zzedo2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzeaq zzbce() {
        if (this.zzhzj != null) {
            return this.zzhzj;
        }
        synchronized (this) {
            if (this.zzhzj != null) {
                zzeaq zzeaq = this.zzhzj;
                return zzeaq;
            }
            if (this.zzhzi == null) {
                this.zzhzj = zzeaq.zzhtf;
            } else {
                this.zzhzj = this.zzhzi.zzbce();
            }
            zzeaq zzeaq2 = this.zzhzj;
            return zzeaq2;
        }
    }

    public final int zzbex() {
        if (this.zzhzj != null) {
            return this.zzhzj.size();
        }
        if (this.zzhzi != null) {
            return this.zzhzi.zzbex();
        }
        return 0;
    }

    public final zzedo zzn(zzedo zzedo) {
        zzedo zzedo2 = this.zzhzi;
        this.zzhzh = null;
        this.zzhzj = null;
        this.zzhzi = zzedo;
        return zzedo2;
    }
}
