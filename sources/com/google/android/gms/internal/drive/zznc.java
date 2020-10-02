package com.google.android.gms.internal.drive;

import java.util.Iterator;

final class zznc implements Iterator<String> {
    private final /* synthetic */ zzna zzvw;
    private Iterator<String> zzvx = this.zzvw.zzvt.iterator();

    zznc(zzna zzna) {
        this.zzvw = zzna;
    }

    public final boolean hasNext() {
        return this.zzvx.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.zzvx.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
