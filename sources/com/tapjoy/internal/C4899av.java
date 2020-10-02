package com.tapjoy.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: com.tapjoy.internal.av */
public final class C4899av implements C4901ax {

    /* renamed from: a */
    private final List f13371a;

    public C4899av(List list) {
        this.f13371a = list;
    }

    /* renamed from: a */
    public final Object mo30931a(int i) {
        return this.f13371a.get(i);
    }

    public final boolean add(Object obj) {
        return this.f13371a.add(obj);
    }

    public final boolean addAll(Collection collection) {
        return this.f13371a.addAll(collection);
    }

    /* renamed from: b */
    public final void mo30932b(int i) {
        C4900aw.m16687a(this.f13371a, i);
    }

    public final void clear() {
        this.f13371a.clear();
    }

    public final boolean contains(Object obj) {
        return this.f13371a.contains(obj);
    }

    public final boolean containsAll(Collection collection) {
        return this.f13371a.containsAll(collection);
    }

    public final Object element() {
        Object peek = peek();
        if (peek != null) {
            return peek;
        }
        throw new NoSuchElementException();
    }

    public final boolean equals(Object obj) {
        return this.f13371a.equals(obj);
    }

    public final int hashCode() {
        return this.f13371a.hashCode();
    }

    public final boolean isEmpty() {
        return this.f13371a.isEmpty();
    }

    public final Iterator iterator() {
        return this.f13371a.iterator();
    }

    public final boolean offer(Object obj) {
        return this.f13371a.add(obj);
    }

    public final Object peek() {
        if (this.f13371a.isEmpty()) {
            return null;
        }
        return this.f13371a.get(0);
    }

    public final Object poll() {
        if (this.f13371a.isEmpty()) {
            return null;
        }
        return this.f13371a.remove(0);
    }

    public final boolean remove(Object obj) {
        return this.f13371a.remove(obj);
    }

    public final boolean removeAll(Collection collection) {
        return this.f13371a.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        return this.f13371a.retainAll(collection);
    }

    public final int size() {
        return this.f13371a.size();
    }

    public final Object[] toArray() {
        return this.f13371a.toArray();
    }

    public final Object remove() {
        Object poll = poll();
        if (poll != null) {
            return poll;
        }
        throw new NoSuchElementException();
    }

    public final Object[] toArray(Object[] objArr) {
        return this.f13371a.toArray(objArr);
    }
}
