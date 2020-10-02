package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzdoi<T> extends zzdod<T> {
    private final T zzdcc;

    zzdoi(T t) {
        this.zzdcc = t;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzdoi) {
            return this.zzdcc.equals(((zzdoi) obj).zzdcc);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzdcc.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzdcc);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }

    public final T zzavo() {
        return this.zzdcc;
    }
}
