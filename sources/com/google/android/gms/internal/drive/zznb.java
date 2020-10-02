package com.google.android.gms.internal.drive;

import java.util.ListIterator;

final class zznb implements ListIterator<String> {
    private ListIterator<String> zzvu = this.zzvw.zzvt.listIterator(this.zzvv);
    private final /* synthetic */ int zzvv;
    private final /* synthetic */ zzna zzvw;

    zznb(zzna zzna, int i) {
        this.zzvw = zzna;
        this.zzvv = i;
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.zzvu.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzvu.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return this.zzvu.next();
    }

    public final int nextIndex() {
        return this.zzvu.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return this.zzvu.previous();
    }

    public final int previousIndex() {
        return this.zzvu.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
