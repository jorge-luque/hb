package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
final class zzdpm<E> extends zzdpb<E> {
    private final transient E zzhgb;
    private transient int zzhgc;

    zzdpm(E e) {
        this.zzhgb = zzdoj.checkNotNull(e);
    }

    public final boolean contains(Object obj) {
        return this.zzhgb.equals(obj);
    }

    public final int hashCode() {
        int i = this.zzhgc;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zzhgb.hashCode();
        this.zzhgc = hashCode;
        return hashCode;
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.zzhgb.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zzhgb;
        return i + 1;
    }

    /* renamed from: zzavs */
    public final zzdpp<E> iterator() {
        return new zzdpd(this.zzhgb);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzavx() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzawd() {
        return this.zzhgc != 0;
    }

    /* access modifiers changed from: package-private */
    public final zzdou<E> zzawe() {
        return zzdou.zzad(this.zzhgb);
    }

    zzdpm(E e, int i) {
        this.zzhgb = e;
        this.zzhgc = i;
    }
}
