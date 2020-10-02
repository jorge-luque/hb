package com.google.protobuf;

import com.google.protobuf.C4038p;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.c */
/* compiled from: AbstractProtobufList */
abstract class C3984c<E> extends AbstractList<E> implements C4038p.C4046h<E> {

    /* renamed from: a */
    private boolean f10744a = true;

    C3984c() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo28069a() {
        if (!this.f10744a) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean add(E e) {
        mo28069a();
        return super.add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        mo28069a();
        return super.addAll(collection);
    }

    public void clear() {
        mo28069a();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public boolean remove(Object obj) {
        mo28069a();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        mo28069a();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        mo28069a();
        return super.retainAll(collection);
    }

    /* renamed from: t */
    public final void mo28079t() {
        this.f10744a = false;
    }

    /* renamed from: v */
    public boolean mo28080v() {
        return this.f10744a;
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        mo28069a();
        return super.addAll(i, collection);
    }
}
