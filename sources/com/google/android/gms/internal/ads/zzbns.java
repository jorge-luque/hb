package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public class zzbns {
    protected final zzdha zzfgj;
    protected final zzdgo zzfkd;
    private final zzbrr zzfkq;
    private final zzbsh zzfkr;
    private final zzder zzfks;
    private final zzbqs zzfkt;

    protected zzbns(zzbnv zzbnv) {
        this.zzfgj = zzbnv.zzfgj;
        this.zzfkd = zzbnv.zzfkd;
        this.zzfkq = zzbnv.zzfkq;
        this.zzfkr = zzbnv.zzfkr;
        this.zzfks = zzbnv.zzfks;
        this.zzfkt = zzbnv.zzfkt;
    }

    public void destroy() {
        this.zzfkq.zzbz((Context) null);
    }

    public void zzahk() {
        this.zzfkr.onAdLoaded();
    }

    public final zzbrr zzahz() {
        return this.zzfkq;
    }

    public final zzbqs zzaia() {
        return this.zzfkt;
    }

    public final zzder zzaib() {
        return this.zzfks;
    }
}
