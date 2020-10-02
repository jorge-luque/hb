package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
final class zzdpd extends zzdpp<T> {
    private boolean zzhfo;
    private final /* synthetic */ Object zzhfp;

    zzdpd(Object obj) {
        this.zzhfp = obj;
    }

    public final boolean hasNext() {
        return !this.zzhfo;
    }

    public final T next() {
        if (!this.zzhfo) {
            this.zzhfo = true;
            return this.zzhfp;
        }
        throw new NoSuchElementException();
    }
}
