package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzmn implements Iterator<Object> {
    zzmn() {
    }

    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
