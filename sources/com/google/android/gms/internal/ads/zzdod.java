package com.google.android.gms.internal.ads;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public abstract class zzdod<T> implements Serializable {
    zzdod() {
    }

    public static <T> zzdod<T> zzz(@NullableDecl T t) {
        if (t == null) {
            return zzdnw.zzhdq;
        }
        return new zzdoi(t);
    }

    @NullableDecl
    public abstract T zzavo();
}
