package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
final class zzdlp extends zzdlo {
    private final String zzhbe;
    private final boolean zzwb;
    private final boolean zzyu;

    private zzdlp(String str, boolean z, boolean z2) {
        this.zzhbe = str;
        this.zzwb = z;
        this.zzyu = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdlo) {
            zzdlo zzdlo = (zzdlo) obj;
            return this.zzhbe.equals(zzdlo.zzauf()) && this.zzwb == zzdlo.zzaug() && this.zzyu == zzdlo.zzcn();
        }
    }

    public final int hashCode() {
        int i = 1231;
        int hashCode = (((this.zzhbe.hashCode() ^ 1000003) * 1000003) ^ (this.zzwb ? 1231 : 1237)) * 1000003;
        if (!this.zzyu) {
            i = 1237;
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String str = this.zzhbe;
        boolean z = this.zzwb;
        boolean z2 = this.zzyu;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 99);
        sb.append("AdShield2Options{clientVersion=");
        sb.append(str);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(z);
        sb.append(", isGooglePlayServicesAvailable=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }

    public final String zzauf() {
        return this.zzhbe;
    }

    public final boolean zzaug() {
        return this.zzwb;
    }

    public final boolean zzcn() {
        return this.zzyu;
    }
}
