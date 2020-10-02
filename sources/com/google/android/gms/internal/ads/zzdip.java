package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdip {
    private final zzdis zzgwj = new zzdis();
    private int zzgwk;
    private int zzgwl;
    private int zzgwm;
    private int zzgwn;
    private int zzgwo;

    zzdip() {
    }

    public final void zzass() {
        this.zzgwm++;
    }

    public final void zzast() {
        this.zzgwn++;
    }

    public final void zzasu() {
        this.zzgwk++;
        this.zzgwj.zzgxd = true;
    }

    public final void zzasv() {
        this.zzgwl++;
        this.zzgwj.zzgxe = true;
    }

    public final void zzasw() {
        this.zzgwo++;
    }

    public final zzdis zzasx() {
        zzdis zzdis = (zzdis) this.zzgwj.clone();
        zzdis zzdis2 = this.zzgwj;
        zzdis2.zzgxd = false;
        zzdis2.zzgxe = false;
        return zzdis;
    }

    public final String zzasy() {
        return "\n\tPool does not exist: " + this.zzgwm + "\n\tNew pools created: " + this.zzgwk + "\n\tPools removed: " + this.zzgwl + "\n\tEntries added: " + this.zzgwo + "\n\tNo entries retrieved: " + this.zzgwn + "\n";
    }
}
